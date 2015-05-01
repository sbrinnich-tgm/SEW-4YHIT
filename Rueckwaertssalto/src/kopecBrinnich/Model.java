package kopecBrinnich;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Klasse zur Verwaltung der Meta-Daten einer DB
 * 
 * @author Selina Brinnich
 * @author Jakub Kopec
 * @version 2015-02-10
 *
 */
public class Model {

	private DatabaseMetaData dmd;
	
	/**
	 * Erzeugt ein neues Model mithilfe dessen verschiedene Eigenschaften einer DB ausgelesen werden können
	 * @param dbcon eine DBConnection, mit der bereits eine Verbindung zu einer Datenbank aufgebaut wurde
	 */
	public Model(DBConnection dbcon){
		try {
			dmd = dbcon.getCon().getMetaData();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Gibt die Namen aller Tabellen einer DB in einem String-Array zurueck
	 * @return die Namen aller Tabellen einer DB
	 */
	public String[] getTables(){
		String[] re = new String[1];
		ArrayList<String> tables = new ArrayList<String>();
		
		try {
			ResultSet t = dmd.getTables(null, null, null, null);
			while(t.next()){
				tables.add(t.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return tables.toArray(re);
	}
	
	/**
	 * Gibt die Namen aller Spalten einer Tabelle zurueck
	 * @param table ein Tabellenname, aus dem die Spalten ausgelesen werden sollen
	 * @return die Namen aller Spalten dieser Tabelle
	 */
	public String[] getAttributes(String table){
		String[] re = new String[1];
		ArrayList<String> columns = new ArrayList<String>();
		
		try {
			ResultSet t = dmd.getColumns(null, null, table, null);
			while(t.next()){
				columns.add(t.getString("COLUMN_NAME"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return columns.toArray(re);
	}
	
	/**
	 * Gibt die Namen aller Spalten einer Tabelle zurueck, die als Primary Key definiert sind
	 * @param table ein Tabellenname, aus dem die Primary Keys ausgelesen werden sollen
	 * @return die Namen aller Spalten dieser Tabelle, die als Primary Key definiert sind
	 */
	private String[] getPrimaryKeys(String table){
		String[] re = new String[1];
		ArrayList<String> columns = new ArrayList<String>();
		
		try {
			ResultSet t = dmd.getPrimaryKeys(null, null, table);
			while(t.next()){
				columns.add(t.getString("COLUMN_NAME"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return columns.toArray(re);
	}
	
	/**
	 * Gibt die Namen aller Spalten einer Tabelle zurueck, die als Foreign Key definiert sind
	 * @param table ein Tabellenname, aus dem die Foreign Keys ausgelesen werden sollen
	 * @return die Namen aller Spalten dieser Tabelle, die als Foreign Key definiert sind
	 */
	private String[] getForeignKeys(String table){
		String[] re = new String[1];
		ArrayList<String> columns = new ArrayList<String>();
		
		try {
			ResultSet t = dmd.getImportedKeys(null, null, table);
			while(t.next()){
				columns.add(t.getString("FKCOLUMN_NAME"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(columns.size() > 0){
			return columns.toArray(re);
		}else{
			return null;
		}
	}
	
	/**
	 * Dient zur Abfrage, ob eine bestimmte Spalte als Primary Key definiert ist
	 * @param table ein Tabellenname, aus dem die abzufragende Spalte stammt
	 * @param column der Name der Spalte, die abgefragt werden soll
	 * @return true, falls die abgefragte Spalte ein Primary Key ist<br>
	 * 			false, falls die abgefragte Spalte kein Primary Key ist
	 */
	public boolean isPrimaryKey(String table, String column){
		String[] p = getPrimaryKeys(table);
		for(int i = 0; i < p.length; i++){
			if(p[i].equals(column))
				return true;
		}
		return false;
	}
	
	/**
	 * Dient zur Abfrage, ob eine bestimmte Spalte als Foreign Key definiert ist
	 * @param table ein Tabellenname, aus dem die abzufragende Spalte stammt
	 * @param column der Name der Spalte, die abgefragt werden soll
	 * @return true, falls die abgefragte Spalte ein Foreign Key ist<br>
	 * 			false, falls die abgefragte Spalte kein Foreign Key ist
	 */
	public boolean isForeignKey(String table, String column){
		String[] p = getForeignKeys(table);
		if (p != null) {
			for (int i = 0; i < p.length; i++) {
				if (p[i].equals(column))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Gibt ein String-Array zurueck, das eine Foreign Key Definition enthaelt
	 * @param table der Tabellenname des Foreign Keys
	 * @param column der Spaltenname des Foreign Keys
	 * @return ein String-Array im folgenden Format:<br> 
	 * 			[0] -> [PKTable-Name]<br>
	 * 			[1] -> [PKColumn-Name]
	 */
	public String[] getForeignDescr(String table, String column){
		if(isForeignKey(table,column)){
			String[] s = new String[2];
			
			try {
				ResultSet t = dmd.getImportedKeys(null, null, table);
				while(t.next()){
					if(t.getString("FKCOLUMN_NAME").equals(column)){
						s[0] = t.getString("PKTABLE_NAME");
						s[1] = t.getString("PKCOLUMN_NAME");
						return s;
					}
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
	
	/**
	 * Gibt alle in der Datenbank vorhandenen Beziehungen zwischen Tabellen zurueck
	 * @return ein Relation-Array, das alle Beziehungen enthaelt
	 */
	public Relation[] getRelations(){
		ArrayList<Relation> rel = new ArrayList<Relation>();
		
		String[] t = getTables();
		String[] f;
		String[] d;
		boolean b = false;
		for(int i = 0; i < t.length; i++){
			f = getForeignKeys(t[i]);
			if (f != null) {
				for (int j = 0; j < f.length; j++) {
					d = getForeignDescr(t[i], f[j]);
					for (int k = 0; k < rel.size(); k++) {
						if (rel.get(k).isEqual(t[i], d[0]))
							b = true;
					}
					if (!b)
						rel.add(new Relation(t[i], d[0]));
					b = false;
				}
			}
		}
		
		Relation[] r = new Relation[rel.size()];
		return rel.toArray(r);
	}
	
}

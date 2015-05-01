package kopecBrinnich;

/**
 * Stellt eine Beziehung zwischen zwei Tabellen dar.
 * 
 * @author Selina Brinnich
 * @author Jakub Kopec
 * @version 2015-02-10
 *
 */
public class Relation {
	
	private String table1, table2;

	/**
	 * Erstellt eine neue Relation
	 * @param table1 der Tabellenname der ersten Tabelle in der Relation
	 * @param table2 der Tabellenname der zweiten Tabelle in der Relation
	 */
	public Relation(String table1, String table2){
		this.table1 = table1;
		this.table2 = table2;
	}
	
	/**
	 * Ueberprueft, ob die uebergebene Beziehung der hier gespeicherten entspricht
	 * @param table1 der Tabellenname der ersten Tabelle in der Relation
	 * @param table2der Tabellenname der zweiten Tabelle in der Relation
	 * @return true, falls die Beziehung dieselbe ist<br>
	 * 			false, falls die Beziehung unterschiedlich ist
	 */
	public boolean isEqual(String table1, String table2){
		if((table1.equals(this.table1) && table2.equals(this.table2)) || (table1.equals(table2) && table2.equals(table1)))
			return true;
		return false;
	}
	
	/**
	 * Gibt die Tabellennamen der in dieser Beziehung vorhandenen beiden Tabellen zurueck
	 * @return ein Array, welches die Namen der beiden Tabellen enthaelt
	 */
	public String[] getTables(){
		return new String[]{table1,table2};
	}
	
}

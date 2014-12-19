package brinnich;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * ConfFactory kann sich mit einer MySQL-Datenbank verbinden und Daten aus einer Tabelle 'element' mit den Spalten 'type'
 * und 'value' lesen. Diese Daten koennen in eine beliebige propel-Konfiguration umgesetzt werden.
 * 
 * @author Selina Brinnich
 * @version 2014-12-19
 *
 */
public abstract class ConfFactory {
	
	private DBConnection dbcon;
	
	private String[] configTypes = new String[] {
			"adapter", "classname", "dsn", "user", "password", "attributes", "defaultConnection", "connections"
	};
	
	/**
	 * Stellt die Verbindung zur Datenbank her
	 * @param server der Hostname des Servers, auf dem die Datenbank liegt
	 * @param user der Username, mit dem auf MySQL verbunden werden soll
	 * @param password das Passwort, mit dem auf MySQL verbunden werden soll
	 * @param dbname der Name der Datenbank, aus der die Daten ausgelesen werden sollen
	 */
	public void connect(String server, String user, String password, String dbname){
		// Build DB-Connection
		this.dbcon = new DBConnection();
		dbcon.connect(server, user, password, dbname);
	}
	
	/**
	 * Holt die Daten aus einer Datenbank und gibt sie in einem ResultSet zurueck
	 * @return ein ResultSet, das die Daten aus der Datenbank beinhaltet
	 */
	public ResultSet getDBData(){		
		// Build Query
		String query = "SELECT type, value FROM element;";
		
		// Execute Query
		ResultSet rs = dbcon.executeStatement(query);
		
		return rs;
	}
	
	/**
	 * Wandelt die Daten aus einem ResultSet in eine HashMap um
	 * @param rs das ResultSet, von dem die Daten umgewandelt werden sollen
	 * @return eine HashMap<String,String>, die alle Daten des ResultSets enthaelt (key = 'type' & value = 'value')
	 */
	public HashMap<String, String> toHashMap(ResultSet rs){
		HashMap<String, String> list = new HashMap<String, String>();
		try {
			while (rs.next()) {
				list.put(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * Schreibt eine Konfiguration fuer propel in ein Konfigurationsfile
	 * @param filename der Name des neuen Konfigurationsfiles
	 */
	public void writeConfig(String filename){
		HashMap<String, String> elements = toHashMap(getDBData());
		
		BufferedWriter file = null;

		try {
			file = new BufferedWriter(new PrintWriter(filename, "UTF-8"));
		} catch (Exception e) {
			System.err.println("Could not create output-file '" + filename + "'.");
		}
		try {
			for(int i = 0; i < 8; i++){
				if(!elements.containsKey(configTypes[i]) || elements.get(configTypes[i]).equals("null")){
					file.write(createElement(configTypes[i],"").getString());
				}else{
					file.write(createElement(configTypes[i],elements.get(configTypes[i])).getString());
				}
				file.newLine();
			}
		} catch (Exception e) {
			System.err.println("Could not write to file.");
		}
		
		try {
			file.close();
		} catch (IOException e) {
			System.err.println("Could not close output-file.");
		}
	}
	
	/**
	 * Schliesst alle Verbindungen
	 */
	public void closeConnections(){
		// Close Connection
		dbcon.closeConnections();
	}

	/**
	 * Factory method. Uebernimmt einen Konfigurationselement-Typ und einen Value und liefert ein neues Konfigurationselement
	 * zurueck.
	 * @param type ein Konfigurationselement-Typ
	 * @param value der value fuer dieses Konfigurationslement
	 * @return ein Konfigurationselement vom angegebenen Typ und mit angegebenem value
	 */
	public abstract Element createElement(String type, String value);
	
}

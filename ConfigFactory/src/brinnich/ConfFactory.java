package brinnich;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ConfFactory {
	
	private DBConnection dbcon;
	
	public void connect(String server, String user, String password, String dbname){
		// Build DB-Connection
		this.dbcon = new DBConnection();
		dbcon.connect(server, user, password, dbname);
	}
	
	public ResultSet getDBData(){		
		// Build Query
		String query = "SELECT type, value FROM element;";
		
		// Execute Query
		ResultSet rs = dbcon.executeStatement(query);
		
		// Close Connection
		dbcon.closeConnections();
		
		return rs;
		
	}
	
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
	
	public void writeConfig(String filename){
		HashMap<String, String> elements = toHashMap(getDBData());
		
		BufferedWriter file = null;

		try {
			file = new BufferedWriter(new PrintWriter(filename, "UTF-8"));
		} catch (Exception e) {
			System.err.println("Could not create output-file '" + filename + "'.");
		}
		try {
			file.write(createElement("adapter",elements.get("adapter")).getString());
			file.newLine();
			file.write(createElement("user",elements.get("user")).getString());
			file.newLine();
			file.write(createElement("password",elements.get("password")).getString());
		} catch (Exception e) {
			System.err.println("Could not write to file.");
		}
		
		try {
			file.close();
		} catch (IOException e) {
			System.err.println("Could not close output-file.");
		}
	}

	public abstract Element createElement(String type, String value);
	
}

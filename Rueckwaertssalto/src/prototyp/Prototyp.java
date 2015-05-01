package prototyp;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import kopecBrinnich.DBConnection;

public class Prototyp {

	public static void main(String[] args) {
		DBConnection dbcon = new DBConnection();
		dbcon.connect("localhost", "root", "asd", "schokoladenfabrik");
		ResultSet rs = dbcon.executeStatement("Select * from mitarbeiter");
		ResultSetMetaData md;
		DatabaseMetaData dmd;
		try {
			md = rs.getMetaData();
			dmd = dbcon.getCon().getMetaData();
			System.out.println(md.getTableName(1)+" -> "+md.getColumnName(1)+", "+md.getColumnName(2));
			ResultSet prim = dmd.getPrimaryKeys(null, null, "mitarbeiter");
			ResultSet fore = dmd.getExportedKeys(null, null, "mitarbeiter");
			prim.next();
			fore.next();
			System.out.println("Primary Key: " + prim.getString("COLUMN_NAME"));
			System.out.println("Foreign Key: " + fore.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

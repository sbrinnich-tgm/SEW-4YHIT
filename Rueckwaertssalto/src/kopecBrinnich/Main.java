package kopecBrinnich;

import java.sql.SQLException;

import org.apache.commons.cli.ParseException;

/**
 * Main-Klasse
 * 
 * @author Selina Brinnich
 * @author Jakub Kopec
 * @version 2015-01-19
 *
 */
public class Main {

	public static void main(String[] args) throws SQLException, ParseException {
		//Eingabe des Benutzers
		Connector c = new Connector(args);
	
		//DB-Connection aufbauen
		DBConnection dbcon = new DBConnection();
		dbcon.connect(c.getHost(), c.getUsername(), c.getPasswort(), c.getDatabaseName());
		
		//Model erstellen
		Model m = new Model(dbcon);
		
		//RM erstellen
		if (!c.getRMFilename().isEmpty()) {
			System.out.println("Drawing RM...");
			RM rm = new RM(c.getRMFilename());
			rm.createOutputFile(m);
			rm.createOutputHTML(m);
			System.out.println("Finished RM!");
		}
		
		//EER erstellen
		if(!c.getEERFilename().isEmpty()){
			System.out.println("Drawing EER...");
			EER eer = new EER(c.getEERFilename());
			eer.createOutputFile(m);
			System.out.println("Finished EER!");
		}
	}
}

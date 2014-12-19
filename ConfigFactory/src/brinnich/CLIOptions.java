package brinnich;

import org.apache.commons.cli.*;

/**
 * Verwaltet CLI-Argumente. Eingegebene CLI-Argumente des Users sind validierbar und koennen abgefragt werden. Bei
 * nicht vorhandenen Argumenten werden Standardwerte vergeben.
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class CLIOptions {
	
	private CommandLine cmd = null;
	
	public static final int SERVERNAME = 0;
	public static final int USERNAME = 1;
	public static final int PASSWORD = 2;
	public static final int DBNAME = 3;
	public static final int CONFIGTYPE = 4;

	/**
	 * Initialisiert die CLI-Argumente
	 * @param args die eingegebenen CLI-Argumente des Users
	 */
	public CLIOptions(String[] args) {		
		initOptions(args);
	}
	
	/**
	 * Initialisiert alle moeglichen CLI-Argumente und parsed die eingegebenen Argumente des Users
	 * @param args die eingegebenen CLI-Argumente des Users
	 */
	public void initOptions(String[] args){
		Options options = new Options();

		options.addOption("h", true, "Hostname des DBMS");
		options.addOption("u", true, "Benutzername");
		options.addOption("p", true, "Passwort");
		options.addOption("d", true, "Name der Datenbank");
		options.addOption("t", true, "Typ der Konfigurationsdatei");
		
		CommandLineParser parser = new BasicParser();
		try {
			cmd = parser.parse( options, args);
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Prueft die eingegebenen CLI-Argumente. (Alle notwendigen Parameter muessen angegeben sein)
	 * @return true, wenn alle Argumente valide sind<br>
	 * 			false, wenn ein oder mehrere Argumente fehlen/falsch sind
	 */
	public boolean verifyOptions(){
		boolean err = false;
		if(!cmd.hasOption("d")){
			System.err.println("Name der Datenbank wird zur Abfrage benötigt! (Parameter: -d)");
			err = true;
		}
		if(!cmd.hasOption("t")){
			System.err.println("Typ der Konfigurationsdatei wird benötigt! (Parameter: -t)");
			err = true;
		}
		
		return !err;
	}
	
	/**
	 * Gibt ein CLI-Argument zurueck
	 * @param opt die Option, die zurueckgegeben werden soll
	 * @return einen String, der entweder das eingegebene Argument des Users enthaelt, oder einen Default-Wert fuer diese
	 * 			Option
	 */
	public String getOption(int opt){
		if (opt == SERVERNAME) {
			if (cmd.hasOption("h")) {
				return cmd.getOptionValue("h");
			} else {
				return "localhost";
			}
		}
		if (opt == USERNAME) {
			if (cmd.hasOption("u")) {
				return cmd.getOptionValue("u");
			} else {
				return System.getProperty("user.name");
			}
		}
		if (opt == PASSWORD) {
			if (cmd.hasOption("p")) {
				return cmd.getOptionValue("p");
			} else {
				return "";
			}
		}
		if (opt == DBNAME) {
			if (cmd.hasOption("d")) {
				return cmd.getOptionValue("d");
			} else {
				return "";
			}
		}
		if (opt == CONFIGTYPE) {
			if (cmd.hasOption("t")) {
				return cmd.getOptionValue("t");
			} else {
				return "";
			}
		}
		return null;
	}

}

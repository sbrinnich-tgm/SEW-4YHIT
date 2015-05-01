package kopecBrinnich;

import java.io.Console;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Klasse zur Verwaltung der User-Eingaben
 *
 * @author Selina Brinnich
 * @author Jakub Kopec
 * @version 2015-01-19
 */
public class Connector {
	//Default-Werte
	private static String
	USERNAME = "root",//System.getProperty("user.name"),
	PASSWORD = "",
	IP = "localhost",
	DATABASE = "",
	RMFILENAME = "",
	EERFILENAME = "";

	//Optionen der Argumente
	private static final String[][] opt = new String[][]{
		{"h", "true",  "Hostname des DBMS. Standard: localhost"},
		{"u", "true",  "Benutzername. Standard: Benutzername des im Betriebssystem angemeldeten Benutzers"},
		{"p", "false", "Passwort. Alternativ kann ein Passwortprompt angezeigt werden. Standard: keins"},
		{"d", "true",  "Name der Datenbank"},
		{"r", "true", "Der Filename des Outputfiles des Relationenmodells. Falls nicht angegeben, wird kein RM erstellt."},
		{"e", "true", "Der Filename des Outputfiles des EER-Diagramms. Falls nicht angegeben, wird kein EER erstellt."}
	};

	/**
	 * Sobald das Objekt dieser Klasse erzeugt wird und die Argumente einer main-Methode
	 * uebergeben worden sind, werden sie verarbeitet. Wenn der Benutzer vergessen hat
	 * Werte einzugeben fuer die es keine definierten Default-Werte gibt muss er diese
	 * noch eingeben. Ansonsten muss der Benutzer nur das Passwort eingeben.
	 */
	public Connector(String[] args) throws SQLException, ParseException {

		CommandLine cmd = null;
		CommandLineParser parser = null;

		Scanner s = new Scanner(System.in);
		Console console = null;

		Options options = new Options();

		for(int i = 0;i < opt.length;++i) {
			options.addOption(opt[i][0], Boolean.parseBoolean(opt[i][1]), opt[i][2]);
		}

		try {
			parser = new BasicParser();
			cmd = parser.parse(options, args);
		} catch (Exception e) {
			System.out.println("Couldn't parse options, because " + e.getMessage());
			System.exit(0);
		}

		//Einlesen der vorhandenen Optionen
		if(cmd.hasOption('h'))
			IP = cmd.getOptionValue('h');
		if(cmd.hasOption('u'))
			USERNAME = cmd.getOptionValue('u');
		if(cmd.hasOption("p"))
			password(console,s);
		if(cmd.hasOption('d'))
			DATABASE = cmd.getOptionValue('d');
		if(cmd.hasOption("r"))
			RMFILENAME = cmd.getOptionValue('r');
		if(cmd.hasOption('e'))
			EERFILENAME = cmd.getOptionValue('e');

		//Falls der Benutzer vergessen hat die Pflichtinformationen anzugeben
		if(DATABASE.equals("")){
			System.out.println("Datenbankname:");
			DATABASE = s.nextLine();
		}
		if(PASSWORD.equals("")){
			password(console,s);
		}

		//Ausgabe der Connection-Daten
		System.out.println("\nHost: "+IP+"\nUsername: "+USERNAME+"\nDatabasename: "+DATABASE+"\n");

		s.close();
	}

	/**
	 * Diese Methode ist fuer die Passworteingabe zustaendig. In Eclipse gibt es
	 * einen Bug. Und zwar : System.console = null; dadurch kann man der Eclipse
	 * Konsole nicht sagen, dass sie ein Passwort einlesen soll (die eingegebenen
	 * Zeichen nicht anzeigen soll). Fuehrt man das Programm jedoch in der Konsole
	 * des Betriebssystems aus kann man diese Funktion serwohl nutzen. Diese Methode
	 * ist auf beide Moeglichkeiten ausgelegt.
	 *
	 * @param console Console
	 * @param s Scanner
	 */
	public static void password(Console console, Scanner s){
		try {
			console = System.console();
			if (console==null) { //IN ECLIPSE IDE
				System.out.print("Password: ");
				PASSWORD = s.nextLine();
			} else { //Outside Eclipse IDE
				PASSWORD = new String(console.readPassword("Password: "));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Getter-Methode
	 * @return host-ip
	 */
	public String getHost(){
		return IP;
	}

	/**
	 * Getter-Methode
	 * @return username
	 */
	public String getUsername(){
		return USERNAME;
	}

	/**
	 * Getter-Methode
	 * @return password
	 */
	public String getPasswort(){
		return PASSWORD;
	}

	/**
	 * Getter-Methode
	 * @return databasename
	 */
	public String getDatabaseName(){
		return DATABASE;
	}
	
	/**
	 * Getter-Methode
	 * @return RM-Outputfilename
	 */
	public String getRMFilename(){
		return RMFILENAME;
	}
	
	/**
	 * Getter-Methode
	 * @return EER-Outputfilename
	 */
	public String getEERFilename(){
		return EERFILENAME;
	}
}

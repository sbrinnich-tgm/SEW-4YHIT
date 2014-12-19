package brinnich;

/**
 * Main-Klasse fuer die ConfigFactory
 * 
 * @author Selina Brinnich
 * @version 2014-12-19
 *
 */
public class Main {

	public static void main(String[] args) {
		//CLI-Argumente parsen und pruefen
		CLIOptions opt = new CLIOptions(args);
		if(!opt.verifyOptions()){
			System.exit(1);
		}
		
		//Factory je nach Userwahl erstellen
		ConfFactory conf = null;
		
		if(opt.getOption(CLIOptions.CONFIGTYPE).equals("yaml")){
			conf = new YamlConfFactory();
		}else if(opt.getOption(CLIOptions.CONFIGTYPE).equals("xml")){
			conf = new XMLConfFactory();
		}else{
			System.err.println("Configurationfile type '" + opt.getOption(CLIOptions.CONFIGTYPE) + "' not supported!");
			System.exit(1);
		}
		
		//DB-Verbindung aufbauen
		conf.connect(opt.getOption(CLIOptions.SERVERNAME), opt.getOption(CLIOptions.USERNAME), 
				opt.getOption(CLIOptions.PASSWORD), opt.getOption(CLIOptions.DBNAME));
		
		//Konfigurationsfile schreiben
		conf.writeConfig("propel." + opt.getOption(CLIOptions.CONFIGTYPE));
		
		//Verbindungen schliessen
		conf.closeConnections();
	}

}

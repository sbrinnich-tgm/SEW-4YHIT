package brinnich;

public class Main {

	public static void main(String[] args) {
		CLIOptions opt = new CLIOptions(args);
		if(!opt.verifyOptions()){
			System.exit(1);
		}
		
		ConfFactory conf = null;
		
		if(opt.getOption(CLIOptions.CONFIGTYPE).equals("yaml")){
			conf = new YamlConfFactory();
		}else if(opt.getOption(CLIOptions.CONFIGTYPE).equals("xml")){
			conf = new XMLConfFactory();
		}else{
			System.err.println("Configurationfile type '" + opt.getOption(CLIOptions.CONFIGTYPE) + "' not supported!");
			System.exit(1);
		}
		
		conf.connect(opt.getOption(CLIOptions.SERVERNAME), opt.getOption(CLIOptions.USERNAME), 
				opt.getOption(CLIOptions.PASSWORD), opt.getOption(CLIOptions.DBNAME));
		
		conf.writeConfig("propel.yaml");
		conf.closeConnections();
	}

}

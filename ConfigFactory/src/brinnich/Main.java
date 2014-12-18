package brinnich;

public class Main {

	public static void main(String[] args) {
		CLIOptions opt = new CLIOptions(args);
		if(!opt.verifyOptions()){
			System.exit(1);
		}
		
		YamlConfFactory yaml = new YamlConfFactory();
		yaml.connect(opt.getOption(CLIOptions.SERVERNAME), opt.getOption(CLIOptions.USERNAME), 
				opt.getOption(CLIOptions.PASSWORD), opt.getOption(CLIOptions.DBNAME));
		
		yaml.writeConfig("propel.yaml");
	}

}

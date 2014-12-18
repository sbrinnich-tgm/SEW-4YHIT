package brinnich;

public class YamlPassword {

	private String value;
	
	public YamlPassword(String value){
		value = "password: " + value;
	}
	
	public String getString(){
		return value;
	}
	
}

package brinnich;

public class YamlUser {

	private String value;
	
	public YamlUser(String value){
		value = "user: " + value;
	}
	
	public String getString(){
		return value;
	}
	
}

package brinnich;

public class YamlClassname {

	private String value;
	
	public YamlClassname(String value){
		value = "classname: " + value;
	}
	
	public String getString(){
		return value;
	}
	
}

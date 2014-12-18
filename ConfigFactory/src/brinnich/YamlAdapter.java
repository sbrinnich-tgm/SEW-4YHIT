package brinnich;

public class YamlAdapter {
	
	private String value;
	
	public YamlAdapter(String value){
		value = "adapter: " + value;
	}
	
	public String getString(){
		return value;
	}
}

package brinnich.yamlElements;

import brinnich.Element;

public class YamlPassword extends Element{
	
	public YamlPassword(String value){
		this.value = "password: " + value;
	}
	
}

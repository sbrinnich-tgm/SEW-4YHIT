package brinnich.yamlElements;

import brinnich.Element;

/**
 * Produkt fuer Yaml-Password-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class YamlPassword extends Element{
	
	public YamlPassword(String value){
		this.value = "password: " + value;
	}
	
}

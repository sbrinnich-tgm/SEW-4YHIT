package brinnich.yamlElements;

import brinnich.Element;

/**
 * Produkt fuer Yaml-User-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class YamlUser extends Element{

	public YamlUser(String value){
		this.value = "user: " + value;
	}
	
}

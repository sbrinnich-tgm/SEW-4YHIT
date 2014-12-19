package brinnich.yamlElements;

import brinnich.Element;

/**
 * Produkt fuer Yaml-Classname-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class YamlClassname extends Element{

	public YamlClassname(String value){
		this.value = "classname: " + value;
	}
	
}

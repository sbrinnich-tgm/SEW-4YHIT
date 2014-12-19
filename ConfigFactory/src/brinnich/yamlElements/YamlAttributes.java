package brinnich.yamlElements;

import brinnich.Element;

/**
 * Produkt fuer Yaml-Attributes-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class YamlAttributes extends Element{

	public YamlAttributes(String value){
		this.value = "attributes: " + value;
	}
	
}

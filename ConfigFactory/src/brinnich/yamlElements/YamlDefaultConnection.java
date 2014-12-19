package brinnich.yamlElements;

import brinnich.Element;

/**
 * Produkt fuer Yaml-DefaultConnection-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class YamlDefaultConnection extends Element {

	public YamlDefaultConnection(String value){
		this.value = "defaultConnection: " + value;
	}
	
}

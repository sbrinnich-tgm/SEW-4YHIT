package brinnich.yamlElements;

import brinnich.Element;

/**
 * Produkt fuer Yaml-Connections-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class YamlConnections extends Element {

	public YamlConnections(String value){
		this.value = "connections: " + value;
	}
	
}

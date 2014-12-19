package brinnich.yamlElements;

import brinnich.Element;

/**
 * Produkt fuer Yaml-DSN-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class YamlDSN extends Element{

	public YamlDSN(String value){
		this.value = "dsn: " + value;
	}
	
}

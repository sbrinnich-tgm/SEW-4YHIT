package brinnich.yamlElements;

import brinnich.Element;

/**
 * Produkt fuer Yaml-Adapter-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class YamlAdapter extends Element{
	
	public YamlAdapter(String value){
		this.value = "adapter: " + value;
	}
}

package brinnich.xmlElements;

import brinnich.Element;

/**
 * Produkt fuer XML-Connections-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class XMLConnections extends Element {

	public XMLConnections(String value){
		this.value = "<connection>" + value + "</connection>";
	}
	
}

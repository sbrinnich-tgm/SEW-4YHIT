package brinnich.xmlElements;

import brinnich.Element;

/**
 * Produkt fuer XML-DefaultConnection-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class XMLDefaultConnection extends Element {

	public XMLDefaultConnection(String value){
		this.value = "<defaultConnection>" + value + "</defaultConnection>";
	}
	
}

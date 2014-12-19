package brinnich.xmlElements;

import brinnich.Element;

/**
 * Produkt fuer XML-User-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class XMLUser extends Element{

	public XMLUser(String value){
		this.value = "<user>" + value + "</user>";
	}
	
}

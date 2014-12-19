package brinnich.xmlElements;

import brinnich.Element;

/**
 * Produkt fuer XML-Attributes-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class XMLAttributes extends Element{

	public XMLAttributes(String value){
		this.value = "<attributes>" + value + "</attributes>";
	}
	
}

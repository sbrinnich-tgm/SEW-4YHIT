package brinnich.xmlElements;

import brinnich.Element;

/**
 * Produkt fuer XML-Password-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class XMLPassword extends Element{
	
	public XMLPassword(String value){
		this.value = "<password>" + value + "</password>";
	}
	
}

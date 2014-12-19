package brinnich.xmlElements;

import brinnich.Element;

/**
 * Produkt fuer XML-DSN-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class XMLDSN extends Element{

	public XMLDSN(String value){
		this.value = "<dsn>" + value + "</dsn>";
	}
	
}

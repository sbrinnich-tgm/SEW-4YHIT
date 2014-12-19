package brinnich.xmlElements;

import brinnich.Element;

/**
 * Produkt fuer XML-Classname-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class XMLClassname extends Element{

	public XMLClassname(String value){
		this.value = "<classname>" + value + "</classname>";
	}
	
}

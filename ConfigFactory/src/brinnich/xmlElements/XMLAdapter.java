package brinnich.xmlElements;

import brinnich.Element;

/**
 * Produkt fuer XML-Adapter-Konfiguration
 * 
 * @author Selina Brinnich
 * @version 2014-12-18
 *
 */
public class XMLAdapter extends Element{
	
	public XMLAdapter(String value){
		this.value = "<adapter>" + value + "</adapter>";
	}
}

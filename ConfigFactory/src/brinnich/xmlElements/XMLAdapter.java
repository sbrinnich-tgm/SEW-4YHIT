package brinnich.xmlElements;

import brinnich.Element;

public class XMLAdapter extends Element{
	
	public XMLAdapter(String value){
		this.value = "<adapter>" + value + "</adapter>";
	}
}

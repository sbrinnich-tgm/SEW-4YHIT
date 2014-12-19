package brinnich;

import brinnich.xmlElements.*;

/**
 * Stellt eine Factory fuer XML-Propel-Konfigurationen dar
 * 
 * @author Selina Brinnich
 * @version 2014-12-19
 *
 */
public class XMLConfFactory extends ConfFactory{

	@Override
	public Element createElement(String type, String value) {
		if(type.equals("adapter")){
			return new XMLAdapter(value);
		}else if(type.equals("classname")){
			return new XMLClassname(value);
		}else if(type.equals("dsn")){
			return new XMLDSN(value);
		}else if(type.equals("user")){
			return new XMLUser(value);
		}else if(type.equals("password")){
			return new XMLPassword(value);
		}else if(type.equals("attributes")){
			return new XMLAttributes(value);
		}else if(type.equals("defaultConnection")){
			return new XMLDefaultConnection(value);
		}else if(type.equals("connections")){
			return new XMLConnections(value);
		}else{
			return null;
		}
	}
	
}

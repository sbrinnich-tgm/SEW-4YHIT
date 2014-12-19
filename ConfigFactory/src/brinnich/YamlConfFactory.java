package brinnich;

import brinnich.yamlElements.*;

/**
 * Stellt eine Factory fuer Yaml-Propel-Konfigurationen dar
 * 
 * @author Selina Brinnich
 * @version 2014-12-19
 *
 */
public class YamlConfFactory extends ConfFactory{

	@Override
	public Element createElement(String type, String value) {
		if(type.equals("adapter")){
			return new YamlAdapter(value);
		}else if(type.equals("classname")){
			return new YamlClassname(value);
		}else if(type.equals("dsn")){
			return new YamlDSN(value);
		}else if(type.equals("user")){
			return new YamlUser(value);
		}else if(type.equals("password")){
			return new YamlPassword(value);
		}else if(type.equals("attributes")){
			return new YamlAttributes(value);
		}else if(type.equals("defaultConnection")){
			return new YamlDefaultConnection(value);
		}else if(type.equals("connections")){
			return new YamlConnections(value);
		}else{
			return null;
		}
	}
	
}

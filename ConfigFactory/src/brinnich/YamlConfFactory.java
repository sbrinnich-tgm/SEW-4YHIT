package brinnich;

import brinnich.yamlElements.*;

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

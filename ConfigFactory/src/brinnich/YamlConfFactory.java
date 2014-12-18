package brinnich;

public class YamlConfFactory extends ConfFactory{

	@Override
	public Element createElement(String type, String value) {
		if(type.equals("adapter")){
			return new YamlAdapter(value);
		}else if(type.equals("classname")){
			return new YamlClassname(value);
		}else if(type.equals("user")){
			return new YamlUser(value);
		}else if(type.equals("password")){
			return new YamlPassword(value);
		}else{
			return null;
		}
	}
	
}

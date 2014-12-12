package galaBrinnich;

/**
 * Decorator-Klasse zum Entfernen aller Leerzeichen in einem Text
 * 
 * @author Selina Brinnich
 * @author Mateusz Gala
 * @version 2014-11-29
 *
 */
public class TextNospace extends TextType{

	/**
	 * Speichert das Objekt, das von dieser Klasse erweitert wird
	 * @param wrappee die Oberklasse, die durch diese Klasse erweitert werden soll
	 */
	public TextNospace(Text wrappee){
		this.wrappee = wrappee;
	}

	/**
	 * Gibt den gespeicherten Text mit entfernten Leerzeichen zurueck
	 * @return den gespeicherten Text, wobei alle Leerzeichen darin entfernt wurden
	 */
	@Override
	public String getText() {
		return wrappee.getText().replace(" ", "");
	}
	
}

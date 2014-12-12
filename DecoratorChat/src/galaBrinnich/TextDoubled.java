package galaBrinnich;

/**
 * Decorator-Klasse zum verdoppeln der einzelnen Buchstaben eines Textes
 * 
 * @author Selina Brinnich
 * @author Mateusz Gala
 * @version 2014-11-29
 *
 */
public class TextDoubled extends TextType {
	
	/**
	 * Speichert das Objekt, das von dieser Klasse erweitert wird
	 * @param wrappee die Oberklasse, die durch diese Klasse erweitert werden soll
	 */
	public TextDoubled(Text wrappee){
		this.wrappee = wrappee;
	}

	/**
	 * Gibt den gespeicherten Text mit doppelten Buchstaben zurück
	 * @return den gespeicherten Text, wobei jeder Buchstabe darin doppelt ist
	 */
	@Override
	public String getText() {
		String t = wrappee.getText();
		String n = "";
		for(int i = 0; i < t.length(); i++){
			n += t.substring(i,i+1)+t.substring(i,i+1);
		}
		return n;
	}

}

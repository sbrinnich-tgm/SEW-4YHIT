package galaBrinnich;


/**
 * Decorator-Klasse um alle Buchstaben eines Textes als Grossbuchstaben zu schreiben
 * 
 * @author Selina Brinnich
 * @author Mateusz Gala
 * @version 2014-11-29
 *
 */
public class TextUppercase extends TextType {
	
	/**
	 * Speichert das Objekt, das von dieser Klasse erweitert wird
	 * @param wrappee die Oberklasse, die durch diese Klasse erweitert werden soll
	 */
	public TextUppercase(Text wrappee){
		this.wrappee = wrappee;
	}

	/**
	 * Gibt den gespeicherten Text nur in Grossbuchstaben zurueck
	 * @return den gespeicherten Text, wobei jeder Buchstabe zu einem Grossbuchstaben geaendert wurde
	 */
	@Override
	public String getText() {
		return wrappee.getText().toUpperCase();
	}

}

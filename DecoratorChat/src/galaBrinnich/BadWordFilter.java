package galaBrinnich;

/**
 * Eine Core-Klasse von Text, die einen unformatierten Text enthaelt, wobei alle in einer externen Datei definierten
 * "boesen" Woerter durch '$%&*' ersetzt werden
 * 
 * @author Selina Brinnich
 * @author Mateusz Gala
 * @version 2014-12-04
 *
 */
public class BadWordFilter extends Text {

	private String[] badWords;
	private String text;
	
	/**
	 * Speichert ein Array mit allen "boesen" Woertern und einen Text, der anschliessend nach den definierten
	 * Woertern gefiltert wird
	 * @param text der Text, der gespeichert werden soll
	 * @param badWords ein String-Array mit allen Badwords
	 */
	public BadWordFilter(String text, String[] badWords){
		this.badWords = badWords;
		this.text = text;
		filter();
	}
	
	/**
	 * Filtert alle definiert Badwords aus dem Text und ersetzt sie mit '$%&'
	 */
	public void filter(){
		for(int i = 0; i < badWords.length; i++){
			text = text.replace(badWords[i], "$%&*");
		}
	}
	
	/**
	 * Gibt den gespeicherten und gefilterten Text zurueck
	 * @return der gespeicherte und nach definierten Woertern gefilterte Text
	 */
	@Override
	public String getText() {
		return text;
	}

}

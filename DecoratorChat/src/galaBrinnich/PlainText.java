package galaBrinnich;

/**
 * Eine Core-Klasse von Text, die einen unformatierten Text enthaelt
 * 
 * @author Selina Brinnich
 * @author Mateusz Gala
 * @version 2014-11-29
 *
 */
public class PlainText extends Text{

	private String text;
	
	/**
	 * Setzt den Text
	 * @param text der Text, der verwendet werden soll.
	 */
	public PlainText(String text){
		this.text = text;
	}
	
	/**
	 * Gibt den Text zurueck
	 * @return der Text, der hier gespeichert wird.
	 */
	@Override
	public String getText(){
		return text;
	}
	
}
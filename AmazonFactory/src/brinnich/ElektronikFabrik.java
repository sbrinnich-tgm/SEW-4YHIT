package brinnich;

/**
 * Stellt eine Elektronik-Fabrik dar, mit der Elektronikprodukte erstellt werden koennen
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public class ElektronikFabrik extends Fabrik {

	@Override
	public Artikel erstelle(String produkt, double menge) {
		switch(produkt){
		case "USB_Stick":
			return new USB_Stick(menge);
		case "USB_Tastatur":
			return new USB_Tastatur(menge);
		case "USB_Maus":
			return new USB_Maus(menge);
		default:
			return null;
		}
	}
	
}

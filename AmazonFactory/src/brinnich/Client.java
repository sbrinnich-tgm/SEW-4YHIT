package brinnich;

/**
 * Client des Versandhauses. Dient zum Testen des Programmes.
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public class Client {

	public static void main(String[] args) {
		//Neue Elektronikfabrik erstellen
		Fabrik fabrik = new ElektronikFabrik();
		fabrik.add(fabrik.erstelle("USB_Stick", 2));
		fabrik.add(fabrik.erstelle("USB_Tastatur", 1));
		fabrik.bezahlen();
		fabrik.verpacken();
		fabrik.verschicken();
		System.out.println(fabrik.toString());
		
		//Neue Tiefkuehlfabrik erstellen
		fabrik = new TiefkuehlFabrik();
//		fabrik.add(fabrik.erstelle("TK_Spinat", 800));
		fabrik.add(fabrik.erstelle("TK_Maronireis", 250));
		fabrik.bezahlen();
		fabrik.verpacken();
		fabrik.verschicken();
		System.out.println(fabrik.toString());
	}

}

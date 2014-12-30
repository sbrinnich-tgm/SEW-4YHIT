package brinnich;

/**
 * Stellt eine USB-Tastatur dar
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public class USB_Tastatur extends ElektronikArtikel {

	public USB_Tastatur(double menge) {
		super("USB-Computertastatur 102 Tasten", menge, Einheit.STK, calculatePreis(20.00,menge));
	}

}

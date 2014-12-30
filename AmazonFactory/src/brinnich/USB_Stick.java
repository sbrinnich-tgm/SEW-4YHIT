package brinnich;

/**
 * Stellt einen USB-Stick dar
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public class USB_Stick extends ElektronikArtikel {

	public USB_Stick(double menge) {
		super("USB-Stick 16GB", menge, Einheit.STK, calculatePreis(9.99,menge));
	}

}

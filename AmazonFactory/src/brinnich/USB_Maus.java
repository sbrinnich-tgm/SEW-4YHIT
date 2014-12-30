package brinnich;

/**
 * Stellt eine USB-Maus dar
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public class USB_Maus extends ElektronikArtikel {
	
	public USB_Maus(double menge) {
		super("USB-Computermaus laserabgetastet", menge, Einheit.STK, calculatePreis(24.99,menge));
	}

}

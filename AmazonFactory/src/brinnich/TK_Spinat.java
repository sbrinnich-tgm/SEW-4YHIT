package brinnich;

/**
 * Stellt Tiefkuehl-Spinat dar
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public class TK_Spinat extends TiefkuehlArtikel {

	public TK_Spinat(double menge) {
		super("TK-Spinat", menge, Einheit.GRAMM, calculatePreis(0.00265,menge));
	}

}

package brinnich;

/**
 * Stellt Tiefkuehl-Maronireis dar
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public class TK_Maronireis extends TiefkuehlArtikel {

	public TK_Maronireis(double menge) {
		super("TK-Maronireis", menge, Einheit.GRAMM, calculatePreis(0.02792,menge));
	}

}

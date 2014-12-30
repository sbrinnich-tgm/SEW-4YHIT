package brinnich;

/**
 * Super-Klasse von Tiefkuehl-Produkten
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public class TiefkuehlArtikel extends Artikel {

	public TiefkuehlArtikel(String bezeichnung, double menge,
			String einheit, double preis) {
		super("Tiefkuehlware", bezeichnung, menge, einheit, preis);
	}

}

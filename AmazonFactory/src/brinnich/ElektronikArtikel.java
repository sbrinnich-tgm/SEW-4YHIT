package brinnich;

/**
 * Super-Klasse von Elektronik-Produkten
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public class ElektronikArtikel extends Artikel{

	public ElektronikArtikel(String bezeichnung, double menge, String einheit, double preis) {
		super("Elektronikware", bezeichnung, menge, einheit, preis);
	}

}

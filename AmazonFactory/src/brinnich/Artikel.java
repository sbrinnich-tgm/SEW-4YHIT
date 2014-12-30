package brinnich;

/**
 * Super-Klasse von allen Produkten. Speichert die Kategorie, die Bezeichnung, die Menge, die Einheit und den Preis eines
 * Produktes.
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public abstract class Artikel {

	private String kategorie;
	private String bezeichnung;
	private double menge;
	private String einheit;
	private double preis;
	
	/**
	 * Erstellt einen neuen Artikel
	 * @param kategorie die Kategorie des Produktes
	 * @param bezeichnung die Bezeichnung des Produktes
	 * @param menge die Menge an Produkten
	 * @param einheit die Einheit, in der das Produkt gemessen wird
	 * @param preis der Preis des Artikels
	 */
	public Artikel(String kategorie, String bezeichnung, double menge, String einheit, double preis){
		this.kategorie = kategorie;
		this.bezeichnung = bezeichnung;
		this.menge = menge;
		this.einheit = einheit;
		this.preis = preis;
	}
	
	/**
	 * Berechnet den Preis anhand eines Preises fuer die Menge 1
	 * @param einzelPreis der Preis des Produktes bei der Menge 1
	 * @param menge die Menge an Produkten
	 * @return einen berechneten Preis fuer die uebergebene Menge an Produkten
	 */
	public static double calculatePreis(double einzelPreis, double menge){
		return einzelPreis*menge;
	}
	
	/**
	 * Gibt die Kategorie des Artikels zurueck
	 * @return die Kategorie des Artikels
	 */
	public String getKategorie() {
		return kategorie;
	}

	/**
	 * Gibt die Bezeichnung des Artikels zurueck
	 * @return die Bezeichnung des Artikels
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	/**
	 * Gibt die Menge an Produkten zurueck
	 * @return die Menge an Produkten
	 */
	public double getMenge() {
		return menge;
	}

	/**
	 * Gibt die Einheit des Artikels zurueck
	 * @return die Einheit des Artikels
	 */
	public String getEinheit() {
		return einheit;
	}

	/**
	 * Gibt den Preis des Artikels zurueck
	 * @return den Preis des Artikels
	 */
	public double getPreis() {
		return preis;
	}
	
}

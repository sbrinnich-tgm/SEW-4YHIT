package brinnich;

/**
 * Stellt eine Tiefkuehl-Fabrik dar, mit der Tiefkuehlprodukte erstellt werden koennen
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public class TiefkuehlFabrik extends Fabrik {

	@Override
	public Artikel erstelle(String produkt, double menge) {
		switch(produkt){
		case "TK_Spinat":
			return new TK_Spinat(menge);
		case "TK_Maronireis":
			return new TK_Maronireis(menge);
		default:
			return null;
		}
	}

}

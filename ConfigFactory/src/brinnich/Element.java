package brinnich;

/**
 * Stellt ein 'Grundgeruest' fuer Konfigurationslemente (-> Products) dar
 * 
 * @author Selina Brinnich
 * @version 2014-12-19
 *
 */
public abstract class Element {
	
	protected String value;

	/**
	 * Gibt das Attribut value zurueck
	 * @return das Attribut value
	 */
	public String getString(){
		return this.value;
	}
	
}

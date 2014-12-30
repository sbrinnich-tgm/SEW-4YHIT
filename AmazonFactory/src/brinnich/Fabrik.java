package brinnich;

import java.util.LinkedList;

/**
 * Super-Klasse von allen Fabriken. Verwaltet einen Einkaufswagen, stellt die Status "bezahlt", "verpackt" und "verschickt" zur
 * Verfuegung und kann einen String mit allen Informationen ueber die aktuelle Einkaufssession zurueckgeben.
 * @author Selina Brinnich
 * @version 2014-12-30
 *
 */
public abstract class Fabrik {
	
	private LinkedList<Artikel> einkaufswagen;
	
	private boolean bezahlt;
	private boolean verpackt;
	private boolean verschickt;

	/**
	 * Erstellt einen neuen leeren Einkaufswagen und setzt alle Status zurueck
	 */
	public Fabrik(){
		this.einkaufswagen=new LinkedList<Artikel>();
		
		this.bezahlt = false;
		this.verpackt = false;
		this.verschickt = false;
	}
	
	/**
	 * Erzeugt ein neues Produkt
	 * @param produkt die Bezeichnung des Produktes, das erzeugt werden soll
	 * @param menge wie viele Produkte dieser Art erstellt werden sollen
	 * @return einen neuen Artikel, der die Menge und die Bezeichnung speichert
	 */
	public abstract Artikel erstelle(String produkt, double menge);
	
	/**
	 * Fuegt dem Einkaufswagen ein neues Produkt hinzu
	 * @param produkt der Artikel, der in den Einkaufswagen soll
	 */
	public void add(Artikel produkt){
		einkaufswagen.add(produkt);
	}

	/**
	 * Bezahlt die Artikel im Einkaufswagen
	 */
	public void bezahlen(){
		this.bezahlt = true;
	}
	
	/**
	 * Verpackt die Artikel im Einkaufswagen
	 */
	public void verpacken(){
		this.verpackt = true;
	}
	
	/**
	 * Verschickt die Artikel im Einkaufswagen
	 */
	public void verschicken(){
		this.verschickt = true;
	}
	
	/**
	 * Gibt Informationen ueber die aktuelle Einkaufssession zurueck
	 */
	@Override
	public String toString(){
		String s = "";
		//Anzahl der Artikel im Einkaufswagen
		s += "Der Einkaufswagen enthaelt " + einkaufswagen.size();
		if(einkaufswagen.size() == 1){
			s += " Produkt:\n";
		}else{
			s += " Produkte:\n";
		}
		
		//Artikel im Einkaufswagen
		for(int i = 0; i < einkaufswagen.size(); i++){
			Artikel a = einkaufswagen.get(i);
			
			s += a.getKategorie() + ": ";
			if(a.getEinheit().equals(Einheit.STK)){
				s += (int)a.getMenge() + " " + a.getEinheit();
			}else{
				s += a.getMenge() + a.getEinheit();
			}
			s += " " + a.getBezeichnung() + " zu €" + a.getPreis();
			
			s += "\n";
		}
		
		s += "\n";
		
		//Bezahlt? Verpackt? Verschickt?
		if(einkaufswagen.size() == 1){
			if(bezahlt){
				s += "Der Artikel wurde bereits bezahlt.\n";
			}
			if(verpackt){
				s += "Der Artikel wurde bereits verpackt.\n";
			}
			if(verschickt){
				s += "Der Artikel wurde bereits verschickt.\n";
			}
		}else{
			if(bezahlt){
				s += "Die Artikel wurden bereits bezahlt.\n";
			}
			if(verpackt){
				s += "Die Artikel wurden bereits verpackt.\n";
			}
			if(verschickt){
				s += "Die Artikel wurden bereits verschickt.\n";
			}
		}
		
		return s;
	}
	
}

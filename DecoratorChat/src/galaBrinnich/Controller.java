package galaBrinnich;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Ein Controller zum Verwalten des Chats
 * 
 * @author Selina Brinnich
 * @author Mateusz Gala
 * @version 2014-12-04
 *
 */
public class Controller {
	
	private NetworkClient nw;
	private GUI gui;
	private String username;
	
	private String[] badWords;
	
	private boolean[] options;
	
	public static final int BADWORDFILTER = 0;
	public static final int DOUBLED = 1;
	public static final int UPPERCASE = 2;
	public static final int NOSPACE = 3;
	
	/**
	 * Erzeugt eine GUI und initialisiert alle Decorator-Optionen, sowie die Badwords
	 */
	public Controller(){
		gui = new GUI(this);
		this.options = new boolean[]{true,false,false,false};
		initBadwords();
	}
	
	/**
	 * Initialisiert alle Badwords, indem sie von einer externen Textdatei eingelesen werden
	 */
	public void initBadwords(){
		badWords = read("src/galaBrinnich/badwords.txt");
	}
	
	/**
	 * Stellt die Verbindung zum Chat-Netzwerk her
	 * @param host die IP des Multicast-Netzwerks
	 * @param port der Port des Multicast-Sockets
	 * @param username der Username, der im Chat verwendet werden soll
	 */
	public void connect(String host, int port, String username){
		this.username = username;
		nw = new NetworkClient(host, port);
		new Receiver(nw, this);
		nw.send("**"+username+" is online.**");
	}
	
	/**
	 * Gibt eine empfangene Nachricht zur Darstellung an die GUI weiter
	 * @param msg die empfangene Nachricht
	 */
	public void receiveMsg(String msg){
		gui.output(msg);
	}
	
	/**
	 * Sendet eine Nachricht des Users an das Chat-Netzwerk
	 * @param msg die zu sendende Nachricht
	 */
	public void sendMsg(String msg){
		msg = modifyText(msg);
		nw.send(username + ": " + msg);
	}
	
	/**
	 * Setzt eine Option zum Aendern der Darstelung von gesendeten Chat-Nachrichten
	 * @param option die Option, die veraendert werden soll (siehe final-Variablen dieser Klasse)
	 * @param value true, falls diese Option verwendet werden soll <br>false, falls diese Option ausgeschaltet werden soll
	 */
	public void setOption(int option, boolean value){
		this.options[option] = value;
	}
	
	/**
	 * Formatiert eine Nachricht nach den gesetzten Optionen
	 * @param msg die Nachricht, die formatiert werden soll
	 * @return die formatierte Nachricht
	 */
	public String modifyText(String msg){
		Text text;
		if(options[BADWORDFILTER]){
			text = new BadWordFilter(msg, badWords);
		}else{
			text = new PlainText(msg);
		}
		if(options[DOUBLED]){
			text = new TextDoubled(text);
		}
		if(options[UPPERCASE]){
			text = new TextUppercase(text);
		}
		if(options[NOSPACE]){
			text = new TextNospace(text);
		}
		return text.getText();
	}
	
	/**
	 * Liest Badwords Zeile fuer Zeile aus einer externen Textdatei ein
	 * @param filename der Pfad zu der Textdatei + Name der Textdatei
	 * @return ein String-Array mit allen eingelesenen Badwords
	 */
	public static String[] read(String filename){
		ArrayList<String> s = new ArrayList<String>();
		boolean l = true;
		try {
			FileReader filereader = new FileReader(filename);
			BufferedReader br = new BufferedReader(filereader);
			while(l){
				String z = br.readLine();
				if(z == null){
					l = false;
					br.close();
				}else{
					s.add(z);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s.toArray(new String[1]);
	}
	
}

package galaBrinnich;

/**
 * Thread-Klasse, die zum Nachrichten empfangen dient
 * 
 * @author Selina Brinnich
 * @author Mateusz Gala
 * @version 2014-11-27
 *
 */
public class Receiver extends Thread{
	
	private NetworkClient nw;
	private Controller c;

	/**
	 * Initialisiert den Receiver
	 * @param nw der Netzwerk-Client, der zum Nachrichten empfangen verwendet werden soll
	 * @param c der Controller des Chats
	 */
	public Receiver(NetworkClient nw, Controller c){
		this.c = c;
		this.nw = nw;
		start();
	}
	
	/**
	 * Bei jedem Durchlauf wartet der Receiver darauf, dass eine Nachricht empfangen wird. Sobald eine Nachricht empfangen wird,
	 * wird sie dem Controller des Chats mitgeteilt und anschliessend ein neuer Durchlauf begonnen
	 */
	@Override
	public void run(){
		String msg = "";
		while(true){
			msg = nw.receive();
			c.receiveMsg(msg);
		}
	}
	
}

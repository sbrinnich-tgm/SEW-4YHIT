package galaBrinnich;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Stellt einen Netzwerk-Client dar, der das Senden und Empfangen von Nachrichten in ein Chat-Netzwerk ueber
 * Multicast-Sockets ermoeglicht
 * 
 * @author Brinnich Selina
 * @author Gala Mateusz
 * @version 2014-11-27
 * 
 */
public class NetworkClient {
	
	MulticastSocket socket = null;
	InetAddress address = null;
	int port;
	
	/**
	 * Initialisiert das Chat-Netzwerk
	 * @param host die IP des Multicast-Netzwerks
	 * @param port der Port des Multicast-Sockets
	 */
	public NetworkClient(String host, int port){
		try {
			this.port = port;
			//Multicast-Socket erstellen
			socket = new MulticastSocket(port);
			address = InetAddress.getByName(host);
			//Dem Netzwerk beitreten
			socket.joinGroup(address);
		} catch (IOException e) {
			System.out.println("Konnte dem Chat-Netzwerk nicht beitreten! \n"
					+ "Ungueltige Multicast-IP! (Muss zwischen 224.0.0.1 und 239.255.255.255 liegen)");
			System.exit(1);
		}
	}

	/**
	 * Schliesst alle bestehenden Verbindungen
	 */
	public void close() {
		try {
			socket.leaveGroup(address);
		} catch (IOException e) {
			e.printStackTrace();
		}
		socket.close();
	}
	
	/**
	 * Sendet eine Nachricht an das Chat-Netzwerk
	 * @param msg die zu sendende Nachricht
	 */
	public void send(String msg){
		//Packet zum Senden erstellen (Nachricht in Bytes umgewandelt, Laenge der Nachricht, IP des Netzwerks, Port)
		DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, port);
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Wartet auf eine hereinkommende Nachricht aus dem Chat-Netzwerk
	 * @return die empfangene Nachricht als String
	 */
	public String receive(){
		//Packet erstellen, in das die empfangene Nachricht gespeichert werden soll
		byte[] buf = new byte[256];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		try {
			socket.receive(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Nachrichten-Packet in String umwandeln
		String received = new String(packet.getData(), 0, packet.getLength());
		return received;
	}
}
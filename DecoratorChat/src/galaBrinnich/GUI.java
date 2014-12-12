package galaBrinnich;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Eine GUI zur Darstellung von Chatnachrichten bzw. Optionen des Chats
 * @author Selina Brinnich
 * @author Mateusz Gala
 * @version 2014-12-04
 *
 */
public class GUI implements ActionListener{
	
	private Controller contr;
	
	private JFrame chatFrame;
	private JTextField chatInput;
	private JTextArea chatMsg;
	private JScrollPane chatScroll;
	private JButton chatSend;
	
	private JButton chatOptions;
	
	private JFrame optionsFrame;
	private JCheckBox optionsBwFilter;
	private JCheckBox[] decorators;
	private JButton optionsApply;

	private JFrame connectFrame;
	private JTextField connectIP;
	private JTextField connectUsername;
	private JTextField connectPort;
	private JButton connectCon;

	/**
	 * Initialisiert die GUI und zeigt ein Verbindungs-Frame an
	 */
	public GUI(Controller c){
		this.contr = c;
		init();
		connectFrame.setVisible(true);
	}
	
	/**
	 * Initialisiert alle Attribute und erzeugt alle Frames
	 */
	private void init(){
		//Frames
		connectFrame = new JFrame("Connect");
		chatFrame = new JFrame("Chat");
		optionsFrame = new JFrame("Options");
		
		//Chat-Elemente
		this.chatInput = new JTextField();
		this.chatMsg = new JTextArea();
		chatScroll = new JScrollPane (chatMsg, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.chatSend = new JButton("Senden");
		
		this.chatOptions = new JButton("Optionen");
		
		//Optionen-Elemente
		this.optionsApply = new JButton("Anwenden");
		this.optionsBwFilter = new JCheckBox("Bad-Word Filter verwenden", true);
		this.decorators = new JCheckBox[]{ 
				new JCheckBox("Buchstaben verdoppeln", false),
				new JCheckBox("Nur Grossbuchstaben verwenden", false),
				new JCheckBox("Keine Leerzeichen", false)
			};

		//Verbindungs-Elemente
		this.connectIP = new JTextField();
		this.connectUsername = new JTextField();
		this.connectPort = new JTextField();
		this.connectCon = new JButton("Connect");

		//Alle Frame erzeugen
		createConnectFrame();
		createChatFrame();
		createOptionsFrame();
	}
	
	/**
	 * Erzeugt ein Frame, in dem man eine Verbindung zu einem Chat-Netzwerk erstellen kann
	 */
	private void createConnectFrame(){
		//Frame-Optionen
		connectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connectFrame.setSize(400,180);
		connectFrame.setResizable(false);
		connectFrame.setLocationRelativeTo(null);
		
		//Hauptpanel mit Rahmen von 10 erstellen
		JPanel rootPanel = new JPanel();
		rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.PAGE_AXIS));
		rootPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//Alle Panel erstellen und Layouts bzw. Alignments setzen
		JPanel ipPanel = new JPanel();
		JPanel portPanel = new JPanel();
		JPanel userPanel = new JPanel();
		JPanel connectPanel = new JPanel();
		ipPanel.setLayout(new BoxLayout(ipPanel,BoxLayout.LINE_AXIS));
		ipPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		portPanel.setLayout(new BoxLayout(portPanel,BoxLayout.LINE_AXIS));
		portPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		userPanel.setLayout(new BoxLayout(userPanel,BoxLayout.LINE_AXIS));
		userPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		connectPanel.setLayout(new BoxLayout(connectPanel,BoxLayout.LINE_AXIS));
		connectPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Panel mit Label 'Multicast-IP:' und JTextField erstellen
		ipPanel.add(new JLabel("Multicast-IP:"));
		ipPanel.add(Box.createRigidArea(new Dimension(23,0)));
		connectIP.setMinimumSize(new Dimension(300,28));
		connectIP.setMaximumSize(new Dimension(300,28));
		connectIP.setToolTipText("z.B. 225.0.0.1");
		ipPanel.add(connectIP);
		
		//Panel mit Label 'Multicast-Port:' und JTextField erstellen
		portPanel.add(new JLabel("Multicast-Port:"));
		portPanel.add(Box.createRigidArea(new Dimension(10,0)));
		connectPort.setMinimumSize(new Dimension(300,28));
		connectPort.setMaximumSize(new Dimension(300,28));
		connectPort.setToolTipText("z.B. 4446");
		portPanel.add(connectPort);
		
		//Panel mit Label 'Username:' und JTextField erstellen
		userPanel.add(new JLabel("Username:"));
		userPanel.add(Box.createRigidArea(new Dimension(31,0)));
		connectUsername.setMinimumSize(new Dimension(300,28));
		connectUsername.setMaximumSize(new Dimension(300,28));
		connectUsername.setToolTipText("z.B. Max");
		userPanel.add(connectUsername);
		
		//Panel mit Button zum verbinden erstellen
		connectPanel.add(Box.createRigidArea(new Dimension(150,0)));
		connectPanel.add(connectCon);
		connectCon.setMinimumSize(new Dimension(100,28));
		connectCon.setMaximumSize(new Dimension(100,28));
		connectCon.addActionListener(this);
		connectCon.setActionCommand("connect");
		
		//Alle Panel zum Hauptpanel hinzufuegen
		rootPanel.add(ipPanel);
		rootPanel.add(portPanel);
		rootPanel.add(userPanel);
		rootPanel.add(Box.createRigidArea(new Dimension(0,10)));
		rootPanel.add(connectPanel);

		//Hauptpanel zum Frame hinzufuegen
		connectFrame.add(rootPanel);
	}
	
	/**
	 * Erzeugt ein Frame, in dem Chatnachrichten angezeigt und gesendet werden koennen
	 */
	private void createChatFrame(){
		//Textfeldergroessen setzen
		this.chatInput.setMinimumSize(new Dimension(400,28));
		this.chatInput.setMaximumSize(new Dimension(400,28));
		this.chatMsg.setMinimumSize(new Dimension(400,380));
		this.chatMsg.setMaximumSize(new Dimension(400,380));

		//Action-Listener zum Senden von Nachrichten hinzufuegen
		this.chatInput.addActionListener(this);
		this.chatInput.setActionCommand("chatInput");
		this.chatSend.addActionListener(this);
		this.chatSend.setActionCommand("chatSend");
		
		//Feld zum Anzeigen von Nachrichten auf 'nicht editierbar' setzen
		this.chatMsg.setEditable(false);

		//Frame-Optionen
		chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chatFrame.setSize(400, 400);
		chatFrame.setResizable(false);
		chatFrame.setLocationRelativeTo(null);
		
		//Panel mit JTextField zum Nachrichten eingeben und Button zum Senden erstellen
		JPanel pSend = new JPanel();
		pSend.setLayout(new BoxLayout(pSend,BoxLayout.LINE_AXIS));
		pSend.add(this.chatInput);
		pSend.add(Box.createRigidArea(new Dimension(30,0)));
		pSend.add(this.chatSend);
		
		//Panel mit Button fuer Chat-Optionen erstellen
		JPanel pOpt = new JPanel();
		pOpt.setLayout(new BoxLayout(pOpt,BoxLayout.LINE_AXIS));
		pOpt.add(Box.createRigidArea(new Dimension(270,0)));
		pOpt.add(this.chatOptions);
		chatOptions.addActionListener(this);
		chatOptions.setActionCommand("options");
		
		//Hauptpanel mit Sende-Panel, Optionen-Panel und Textfeld fuer Chat-Nachrichten erstellen
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		mainPanel.add(pOpt);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(chatScroll);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(pSend);
		
		//Hauptpanel zum Frame hinzufuegen
		chatFrame.add(mainPanel);
	}
	
	private void createOptionsFrame(){
		//Frame-Optionen
		optionsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		optionsFrame.setSize(300,200);
		optionsFrame.setResizable(false);
		optionsFrame.setLocationRelativeTo(null);
		
		//Panel mit Checkboxen zum Setzen von Filter- bzw. Darstellungsoptionen erstellen
		JPanel pFilter = new JPanel();
		JPanel pTemp;
		pFilter.setLayout(new BoxLayout(pFilter,BoxLayout.PAGE_AXIS));
		pFilter.setAlignmentX(Container.CENTER_ALIGNMENT);
		pTemp = new JPanel();
		pTemp.setLayout(new BoxLayout(pTemp,BoxLayout.LINE_AXIS));
		pTemp.setAlignmentX(Container.LEFT_ALIGNMENT);
		pTemp.add(Box.createRigidArea(new Dimension(20,0)));
		optionsBwFilter.setFocusable(false);
		pTemp.add(optionsBwFilter);
		pFilter.add(pTemp);
		for(int i = 0; i < decorators.length; i++){
			pTemp = new JPanel();
			pTemp.setLayout(new BoxLayout(pTemp,BoxLayout.LINE_AXIS));
			pTemp.setAlignmentX(Container.LEFT_ALIGNMENT);
			pTemp.add(Box.createRigidArea(new Dimension(20,0)));
			decorators[i].setFocusable(false);
			pTemp.add(decorators[i]);
			pFilter.add(pTemp);
		}
		
		//Panel mit Button zum Optionen akzeptieren erstellen
		JPanel pApply = new JPanel();
		pApply.setLayout(new BoxLayout(pApply, BoxLayout.LINE_AXIS));
		pApply.add(Box.createRigidArea(new Dimension(80,0)));
		pApply.add(this.optionsApply);
		pApply.add(Box.createRigidArea(new Dimension(80,0)));
		optionsApply.addActionListener(this);
		optionsApply.setActionCommand("optionsApply");
		
		//Hauptpanel mit Optionen und Button erstellen
		JPanel rootPanel = new JPanel();
		rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.PAGE_AXIS));
		rootPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		rootPanel.add(pFilter);
		rootPanel.add(Box.createRigidArea(new Dimension(0,20)));
		rootPanel.add(pApply);

		//Hauptpanel zum Frame hinzufuegen
		optionsFrame.add(rootPanel);
	}
	
	/**
	 * Stellt eine Verbindung zu einem Chat-Netzwerk her
	 * @param adresse die IP des Chat-Netzwerks
	 * @param port der Port des Multicast-Sockets
	 * @param username der Username, der im Chat-Netzwerk verwendet werden soll
	 */
	public void connect(String adresse, int port, String username){
		contr.connect(adresse, port, username);
	}

	/**
	 * Gibt neue Chatnachrichten im Chatframe aus
	 */
	public void output(String msg) {
		chatMsg.setText(chatMsg.getText()+"\n"+msg);
	}
	
	/**
	 * Setzt alle eingestellten Optionen
	 */
	private void setOptions(){
		contr.setOption(Controller.BADWORDFILTER,optionsBwFilter.isSelected());
		for(int i = 0; i < decorators.length; i++){
			contr.setOption((i+1), decorators[i].isSelected());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();
		if(c.equals("connect")){
			//Verbindung zum Chat-Netzwerk herstellen
			try{
				int port = 0;
				if(connectIP.getText().equals("")){
					connectIP.setBackground(Color.red);
				}else{
					connectIP.setBackground(Color.white);
				}
				if(connectPort.getText().equals("")){
					connectPort.setBackground(Color.red);
				}else{
					connectPort.setBackground(Color.white);
					port = Integer.parseInt(connectPort.getText());
				}
				if(connectUsername.getText().equals("")){
					connectUsername.setBackground(Color.red);
				}else{
					connectUsername.setBackground(Color.white);
				}
				if(connectIP.getBackground() != Color.red && 
						connectPort.getBackground() != Color.red &&
						connectUsername.getBackground() != Color.red){
					connect(connectIP.getText(),port,connectUsername.getText());
					
					//Connect-Frame nicht mehr anzeigen und stattdessen Chat-Frame zeigen
					connectFrame.setVisible(false);
					chatFrame.setVisible(true);
				}
			}catch(Exception ex){
				System.out.println("Ungueltiger Port!");
				System.exit(1);
			}
		}else if(c.equals("chatInput") || c.equals("chatSend")){
			//Eingegebene Nachricht senden
			contr.sendMsg(chatInput.getText());
			chatInput.setText("");
			//Im Textfeld runterscrollen
			chatScroll.getViewport().setViewPosition(new Point(0,chatScroll.getHeight()));
		}else if(c.equals("options")){
			//Optionen-Frame anzeigen
			optionsFrame.setVisible(true);
		}else if(c.equals("optionsApply")){
			//Eingestellte Optionen setzen und Optionen-Frame nicht mehr anzeigen
			setOptions();
			optionsFrame.setVisible(false);
		}
	}
	
}

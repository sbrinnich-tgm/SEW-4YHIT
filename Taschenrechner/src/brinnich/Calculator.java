package brinnich;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textInput;
	private JTextField textAnzeige;
	
	private double zahl = 0;
	private Integer operator = -1;
	
	//Moegliche Rechenoperationen
	public static final int PLUS = 0;
	public static final int MINUS = 1;
	public static final int MULTI = 2;
	public static final int DIVI = 3;
	
	public boolean shiftDown = false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		//Frame
		setName("frameSimpleCalc");
		setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		setTitle("Simple Calc");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Calculator.class.getResource("/brinnich/logoCalc.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(215, 237);
		setLocationRelativeTo(null);
		
		//ContentPane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 153));
		contentPane.setFocusable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addKeyListener(this);
		
		//BUTTONS
		JPanel panel_buttons = new JPanel();
		panel_buttons.setFocusable(false);
		panel_buttons.setBounds(0, 60, 212, 149);
		contentPane.add(panel_buttons);
		panel_buttons.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 204, 153));
		panel_1.setFocusable(false);
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 212, 42);
		panel_buttons.add(panel_1);
		
		//Button "7"
		JButton button_7 = new JButton("7");
		button_7.setFocusable(false);
		button_7.addActionListener(this);
		button_7.setMargin(new Insets(0, 0, 0, 0));
		button_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_7.setBounds(10, 10, 35, 30);
		panel_1.add(button_7);

		//Button "8"
		JButton button_8 = new JButton("8");
		button_8.setFocusable(false);
		button_8.addActionListener(this);
		button_8.setMargin(new Insets(0, 0, 0, 0));
		button_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_8.setBounds(49, 10, 35, 30);
		panel_1.add(button_8);

		//Button "9"
		JButton button_9 = new JButton("9");
		button_9.setFocusable(false);
		button_9.addActionListener(this);
		button_9.setMargin(new Insets(0, 0, 0, 0));
		button_9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_9.setBounds(88, 10, 35, 30);
		panel_1.add(button_9);

		//Button "<-"
		JButton button_back = new JButton("\u2190");
		button_back.addActionListener(this);
		button_back.setActionCommand("back");
		button_back.setFocusable(false);
		button_back.setMargin(new Insets(0, 0, 0, 0));
		button_back.setFont(new Font("SansSerif", Font.PLAIN, 20));
		button_back.setBounds(167, 10, 35, 30);
		panel_1.add(button_back);

		//Button "C"
		JButton button_clear = new JButton("C");
		button_clear.addActionListener(this);
		button_clear.setActionCommand("c");
		button_clear.setMargin(new Insets(0, 0, 0, 0));
		button_clear.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_clear.setFocusable(false);
		button_clear.setBounds(127, 10, 35, 30);
		panel_1.add(button_clear);

		//Button "2"
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 204, 153));
		panel_2.setFocusable(false);
		panel_2.setLayout(null);
		panel_2.setBounds(0, 42, 212, 34);
		panel_buttons.add(panel_2);

		//Button "4"
		JButton button_4 = new JButton("4");
		button_4.setFocusable(false);
		button_4.addActionListener(this);
		button_4.setMargin(new Insets(0, 0, 0, 0));
		button_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_4.setBounds(10, 2, 35, 30);
		panel_2.add(button_4);

		//Button "5"
		JButton button_5 = new JButton("5");
		button_5.setFocusable(false);
		button_5.addActionListener(this);
		button_5.setMargin(new Insets(0, 0, 0, 0));
		button_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_5.setBounds(49, 2, 35, 30);
		panel_2.add(button_5);

		//Button "6"
		JButton button_6 = new JButton("6");
		button_6.setFocusable(false);
		button_6.addActionListener(this);
		button_6.setMargin(new Insets(0, 0, 0, 0));
		button_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_6.setBounds(88, 2, 35, 30);
		panel_2.add(button_6);

		//Button "="
		JButton button_equals = new JButton("=");
		button_equals.addActionListener(this);
		button_equals.setFocusable(false);
		button_equals.setMargin(new Insets(0, 0, 0, 0));
		button_equals.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		button_equals.setBounds(127, 2, 75, 30);
		panel_2.add(button_equals);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 204, 153));
		panel_3.setFocusable(false);
		panel_3.setLayout(null);
		panel_3.setBounds(0, 76, 212, 34);
		panel_buttons.add(panel_3);

		//Button "1"
		JButton button_1 = new JButton("1");
		button_1.setFocusable(false);
		button_1.addActionListener(this);
		button_1.setMargin(new Insets(0, 0, 0, 0));
		button_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_1.setBounds(10, 2, 35, 30);
		panel_3.add(button_1);

		//Button "2"
		JButton button_2 = new JButton("2");
		button_2.setFocusable(false);
		button_2.addActionListener(this);
		button_2.setMargin(new Insets(0, 0, 0, 0));
		button_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_2.setBounds(49, 2, 35, 30);
		panel_3.add(button_2);

		//Button "3"
		JButton button_3 = new JButton("3");
		button_3.setFocusable(false);
		button_3.addActionListener(this);
		button_3.setMargin(new Insets(0, 0, 0, 0));
		button_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_3.setBounds(88, 2, 35, 30);
		panel_3.add(button_3);

		//Button "+"
		JButton button_plus = new JButton("+");
		button_plus.setFocusable(false);
		button_plus.addActionListener(this);
		button_plus.setMargin(new Insets(0, 0, 0, 0));
		button_plus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_plus.setBounds(127, 2, 35, 30);
		panel_3.add(button_plus);

		//Button "-"
		JButton button_minus = new JButton("-");
		button_minus.setFocusable(false);
		button_minus.addActionListener(this);
		button_minus.setMargin(new Insets(0, 0, 2, 0));
		button_minus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_minus.setBounds(167, 2, 35, 30);
		panel_3.add(button_minus);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 204, 153));
		panel_4.setFocusable(false);
		panel_4.setLayout(null);
		panel_4.setBounds(0, 110, 212, 42);
		panel_buttons.add(panel_4);

		//Button "0"
		JButton button_0 = new JButton("0");
		button_0.setFocusable(false);
		button_0.addActionListener(this);
		button_0.setMargin(new Insets(2, 0, 0, 0));
		button_0.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_0.setBounds(10, 2, 75, 30);
		panel_4.add(button_0);

		//Button ","
		JButton button_comma = new JButton(",");
		button_comma.setFocusable(false);
		button_comma.addActionListener(this);
		button_comma.setActionCommand(".");
		button_comma.setVerticalAlignment(SwingConstants.TOP);
		button_comma.setMargin(new Insets(0, 0, 0, 0));
		button_comma.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		button_comma.setBounds(88, 2, 35, 30);
		panel_4.add(button_comma);

		//Button "*"
		JButton button_multi = new JButton("*");
		button_multi.setFocusable(false);
		button_multi.addActionListener(this);
		button_multi.setVerticalAlignment(SwingConstants.BOTTOM);
		button_multi.setMargin(new Insets(0, 0, 0, 0));
		button_multi.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_multi.setBounds(127, 2, 35, 30);
		panel_4.add(button_multi);

		//Button "/"
		JButton button_divi = new JButton("/");
		button_divi.setFocusable(false);
		button_divi.addActionListener(this);
		button_divi.setMargin(new Insets(0, 0, 0, 0));
		button_divi.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		button_divi.setBounds(167, 2, 35, 30);
		panel_4.add(button_divi);
		
		//DISPLAY
		JPanel panel_display = new JPanel();
		panel_display.setBackground(new Color(0, 204, 153));
		panel_display.setFocusable(false);
		panel_display.setBounds(0, 10, 212, 50);
		contentPane.add(panel_display);
		panel_display.setLayout(null);
		
		//TextField with Input
		textInput = new JTextField();
		textInput.setBorder(new EmptyBorder(0, 0, 0, 0));
		textInput.setText("0");
		textInput.setFocusable(false);
		textInput.setRequestFocusEnabled(false);
		textInput.setMargin(new Insets(6, 2, 1, 6));
		textInput.setHorizontalAlignment(SwingConstants.TRAILING);
		textInput.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 19));
		textInput.setBounds(10, 19, 192, 30);
		panel_display.add(textInput);
		textInput.setColumns(10);
		
		//TextField with "Cache-Display"
		textAnzeige = new JTextField();
		textAnzeige.setForeground(Color.GRAY);
		textAnzeige.setBorder(new EmptyBorder(0, 0, 0, 0));
		textAnzeige.setHorizontalAlignment(SwingConstants.TRAILING);
		textAnzeige.setFocusable(false);
		textAnzeige.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 10));
		textAnzeige.setBounds(10, 0, 192, 19);
		panel_display.add(textAnzeige);
		textAnzeige.setColumns(10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String a = e.getActionCommand();

		//Falls "Undefined" im Text, wird 0 reingeschrieben zum Weiterrechnen
		if(textInput.getText().equals("Undefined"))
			textInput.setText("0");
		
		switch(a){
		case "=":
			//Rechnen
			executeCalculation();
			break;
		case "c":
			//Zwischenspeicher und aktuelle Rechnung zurücksetzen auf 0
			textInput.setText("0");
			textAnzeige.setText("");
			operator = -1;
			zahl = 0;
			break;
		case "back":
			//Letzte eingegebene Zahl löschen
			if(!textInput.getText().equals(""))
				textInput.setText(textInput.getText().substring(0, textInput.getText().length()-1));
			if(textInput.getText().equals(""))
				textInput.setText("0");
			break;
		case "+":
			//Addieren
			if(operator != -1)
				executeCalculation();
			zahl = Double.parseDouble(textInput.getText());
			operator = PLUS;
			textAnzeige.setText(zahl+" +");
			textInput.setText("0");
			break;
		case "-":
			//Subtrahieren
			if(operator != -1)
				executeCalculation();
			zahl = Double.parseDouble(textInput.getText());
			operator = MINUS;
			textAnzeige.setText(zahl+" -");
			textInput.setText("0");
			break;
		case "*":
			//Multiplizieren
			if(operator != -1)
				executeCalculation();
			zahl = Double.parseDouble(textInput.getText());
			operator = MULTI;
			textAnzeige.setText(zahl+" *");
			textInput.setText("0");
			break;
		case "/":
			//Dividieren
			if(operator != -1)
				executeCalculation();
			zahl = Double.parseDouble(textInput.getText());
			operator = DIVI;
			textAnzeige.setText(zahl+" /");
			textInput.setText("0");
			break;
		case ".":
			//Komma
			if(!textInput.getText().contains("."))
				textInput.setText(textInput.getText()+a);
			break;
		default:
			//Zahlen
			if(textInput.getText().equals("0")){
				textInput.setText(a);
			}else{
				textInput.setText(textInput.getText()+a);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		//Letzte eingegebene Zahl löschen
		case KeyEvent.VK_BACK_SPACE:
			if(!textInput.getText().equals("") && !textInput.getText().equals("Undefined"))
				textInput.setText(textInput.getText().substring(0, textInput.getText().length()-1));
			if(textInput.getText().equals("") || textInput.getText().equals("Undefined"))
				textInput.setText("0");
			break;
		//Zwischenspeicher und aktuelle Rechnung zurücksetzen auf 0
		case KeyEvent.VK_DELETE:
			textInput.setText("0");
			textAnzeige.setText("");
			operator = -1;
			zahl = 0;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		//Falls "Undefined" im Text, wird 0 reingeschrieben zum Weiterrechnen
		if(textInput.getText().equals("Undefined"))
			textInput.setText("0");
		
		switch(e.getKeyChar()){
		case '\n':
			//Bei Enter Rechnen
			executeCalculation();
			break;
		case '+':
			//Addieren
			if(operator != -1)
				executeCalculation();
			zahl = Double.parseDouble(textInput.getText());
			operator = PLUS;
			textAnzeige.setText(zahl+" +");
			textInput.setText("0");
			break;
		case '-':
			//Subtrahieren
			if(operator != -1)
				executeCalculation();
			zahl = Double.parseDouble(textInput.getText());
			operator = MINUS;
			textAnzeige.setText(zahl+" -");
			textInput.setText("0");
			break;
		case '*':
			//Multiplizieren
			if(operator != -1)
				executeCalculation();
			zahl = Double.parseDouble(textInput.getText());
			operator = MULTI;
			textAnzeige.setText(zahl+" *");
			textInput.setText("0");
			break;
		case '/':
			//Dividieren
			if(operator != -1)
				executeCalculation();
			zahl = Double.parseDouble(textInput.getText());
			operator = DIVI;
			textAnzeige.setText(zahl+" /");
			textInput.setText("0");
			break;
		default:
			//Nur eingegebene Zahlen zulassen
			if("0123456789".contains(e.getKeyChar()+"")){
				if(textInput.getText().equals("0")){
					textInput.setText(""+e.getKeyChar());
				}else{
					textInput.setText(textInput.getText()+e.getKeyChar());
				}
			//Oder , bzw. .
			}else if(".,".contains(e.getKeyChar()+"") && !textInput.getText().contains(".")){
				textInput.setText(textInput.getText()+".");
			}
		}
	}
	
	/**
	 * Führt eine Rechnung aus
	 */
	public void executeCalculation(){
		if(operator != -1){
			//Division durch 0 vermeiden (Text "Undefined" anzeigen)
			if(operator==DIVI && Double.parseDouble(textInput.getText()) == 0){
				textInput.setText("Undefined");
				operator = -1;
				textAnzeige.setText("");
			}else{
				//Rechnung durchführen
				zahl = calculate(zahl,operator,Double.parseDouble(textInput.getText()));
				operator = -1;
				textAnzeige.setText("");
				if(zahl*10%10==0){
					textInput.setText((int)zahl+"");
				}else{
					textInput.setText(zahl+"");
				}
			}
		}
	}
	
	/**
	 * Addiert, Subtrahiert, Dividiert oder Multipliziert zwei Zahlen
	 * @param zahl1 die erste Zahl
	 * @param operator ein Operator (siehe vorhandene Konstanten in Calculator)
	 * @param zahl2 die zweite Zahl
	 * @return das Ergebnis der Rechenoperation
	 */
	public double calculate(double zahl1, int operator, double zahl2){
		if(operator == DIVI && zahl2 == 0)
			return 0;
		
		switch(operator){
		case PLUS:
			return zahl1 + zahl2;
		case MINUS:
			return zahl1 - zahl2;
		case MULTI:
			return zahl1 * zahl2;
		case DIVI:
			return zahl1 / zahl2;
		default:
			return 0;
		}
	}
}

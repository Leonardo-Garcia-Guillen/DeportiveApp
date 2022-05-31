package modelo;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import controlador.DecodifySport;
import vista.InterfazPrincipal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JPasswordField;

import controlador.ChangeWindow;

public class BANCOPRUEBAS_GRAFICAS implements ActionListener{
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel[] panelReservas = new JPanel[10];
	private JButton[] btnArray = new JButton[100];
	private JScrollPane scroll;
	private static JList reservas;
	private String[] array= {};
	DefaultListModel listModel;
	private JButton btnNewButton;
	private int cont = 0;
	JPasswordField passwordField = new JPasswordField(10);
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JList<String> list = new JList<String>(array);
	
	///public static ChangeWindow change = new ChangeWindow("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BANCOPRUEBAS_GRAFICAS window = new BANCOPRUEBAS_GRAFICAS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BANCOPRUEBAS_GRAFICAS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		frame = new JFrame();
		frame.setBounds(0, 0, (int) width, (int) height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(10, 0, 1526, 800);
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension((int)width,(int)height));
		System.out.println(width + " " + height);
		frame.getContentPane().add(mainPanel);
	
		btnNewButton = new JButton("este");
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(491, 126, 183, 160);
		mainPanel.add(btnNewButton);
		
		panelReservas[cont] = new JPanel();
		// panelReservas.setBorder(null);
		panelReservas[cont].setBackground(new Color(255, 255, 255));
		panelReservas[cont].setBounds(300, 121, 950, 1000);
		mainPanel.add(panelReservas[0]);
		panelReservas[cont].setLayout(new FlowLayout());
		
		
		//creaLista(1);
		//creaPswd();
		
	}

	private void creaPswd() {
		JPanel panelAdmin = new JPanel();
		JLabel label = new JLabel("Contraseña:");
		JPasswordField pass = new JPasswordField(20);
		panelAdmin.add(label);
		panelAdmin.add(pass);
		String[] options = new String[]{"OK", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, panelAdmin, "Administrador",
		                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
		                         null, options, options[0]);
		System.out.println(option);
		if(option == 0) // pressing OK button
		{
		    char[] password = pass.getPassword();
		    String pswd = new String(password);
		    if (pswd.equals("ejercito1")) {
		    	JOptionPane.showMessageDialog(null, "Contraseña correcta", "Administrador", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Administrador", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	private void creaLista(int j) {
		//change.newWindowApp("gg", frame);
		list = new JList<String>(array);
				
		list.setVisibleRowCount(20); // Muestra hasta 15 reservas
		list.setFont(new Font("Calibri", Font.BOLD, 22));

		listModel = new DefaultListModel<String>();

		// Busca reservas una a una
		for(int i =0;i<100;i++)
			if (j==0) {
				System.out.println("0");
				listModel.addElement("0");
			}
			else {
				System.out.println("1");
				listModel.addElement("1");
			}

		// Modificamos el modelo de la lista para poder ir añadiendo más y más elementos
		list.setModel(listModel);
		
		panelReservas[cont].add(list);

		// Crea un JScroll para buscar aquellas reservas que no caben en el panel
		JScrollPane scroll = new JScrollPane(list);
		panelReservas[cont].add(scroll);
		cont++;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		creaPswd();

	}
	

}

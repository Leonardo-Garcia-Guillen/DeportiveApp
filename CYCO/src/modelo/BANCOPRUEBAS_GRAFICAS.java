package modelo;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JFrame;
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
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JPasswordField;

public class BANCOPRUEBAS_GRAFICAS {
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel panelReservas;
	private JButton[] btnArray = new JButton[100];
	private JScrollPane scroll;
	private static JList reservas;
	private String[] array= {};
	DefaultListModel listModel;
	private JButton btnNewButton;
	
	JPasswordField passwordField = new JPasswordField(10);
	
	
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

		passwordField.setActionCommand(OK);
		passwordField.addActionListener(this);
		
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
		
		panelReservas = new JPanel();
		panelReservas.setBorder(null);
		panelReservas.setBackground(new Color(255, 0, 0));
		panelReservas.setBounds(159, 121, 500, 500);
		mainPanel.add(panelReservas);
		panelReservas.setLayout(null);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnNewButton.setBounds(118, 10, 183, 40);
		panelReservas.add(btnNewButton);
		
	}

	public void actionPerformed(ActionEvent e) {
	    String cmd = e.getActionCommand();

	    if (OK.equals(cmd)) { //Process the password.
	        char[] input = passwordField.getPassword();
	        if (isPasswordCorrect(input)) {
	            JOptionPane.showMessageDialog(controllingFrame,
	                "Success! You typed the right password.");
	        } else {
	            JOptionPane.showMessageDialog(controllingFrame,
	                "Invalid password. Try again.",
	                "Error Message",
	                JOptionPane.ERROR_MESSAGE);
	        }

	        //Zero out the possible password, for security.
	        Arrays.fill(input, '0');

	        passwordField.selectAll();
	        resetFocus();
	    } else ...//handle the Help button...
	}
}

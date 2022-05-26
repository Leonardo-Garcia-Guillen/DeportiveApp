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
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	
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
		
		panelReservas = new JPanel();
		panelReservas.setBorder(null);
		panelReservas.setBackground(new Color(255, 255, 255));
		panelReservas.setBounds(159, 121, 500, 500);
		mainPanel.add(panelReservas);
		panelReservas.setLayout(null);
		
		btnNewButton = new JButton("este");
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnNewButton.setBounds(118, 10, 183, 40);
		panelReservas.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBackground(new Color(153, 204, 255));
		btnNewButton_1.setBounds(118, 73, 207, 54);
		panelReservas.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBackground(new Color(248, 248, 255));
		btnNewButton_2.setBounds(334, 41, 166, 40);
		panelReservas.add(btnNewButton_2);
		
	}

}

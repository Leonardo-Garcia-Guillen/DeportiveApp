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

public class BANCOPRUEBAS_GRAFICAS {
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel panelReservas;
	private JButton[] btnArray = new JButton[100];
	private JScrollPane scroll;
	private static JList reservas;
	private String[] array= {};
	DefaultListModel listModel;
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
		//panelReservas.setBorder(null);
		//panelReservas.setBackground(new Color(255, 0, 0));
		panelReservas.setBounds(159, 121, 500, 500);
		mainPanel.add(panelReservas);
		panelReservas.setLayout(new BorderLayout());
		
		JList<String> list = new JList<String>(array);
		//list.setBounds(378, 35, 500, 250);
		list.setVisibleRowCount(10);
		
		listModel = new DefaultListModel<String>();
		creaBotones();
		list.setModel(listModel);
		panelReservas.add(list,BorderLayout.CENTER);
		
		list.setFont(new Font("Calibri", Font.BOLD, 25));
		
		JScrollPane scroll = new JScrollPane(list);
		panelReservas.add(scroll);
		
		JButton btn = new JButton();
		btn.setText("Cancelar reserva");
		btn.addActionListener(null);
		panelReservas.add(btn,BorderLayout.NORTH);
		//	list.add(scroll);
	}

	private void creaBotones() {
		for (int i = 0; i<100; i++) {	
			listModel.addElement(""+i);
			/*btnArray[i] = new JButton();
			btnArray[i].setText(""+i);
			btnArray[i].setBackground(new Color(248, 248, 255));
			btnArray[i].setForeground(new Color(71, 0, 100));
			btnArray[i].setFont(new Font("Calibri", Font.BOLD, 16));
			btnArray[i].setBounds(482, 28 + i* 36, 570, 32);
			panelReservas.add(btnArray[i]);
			*/
		}
		
				
	}
}

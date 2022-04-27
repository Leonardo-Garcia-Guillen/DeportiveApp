// PROBLEMA: HAY ALGUNAS HORAS DE CIERTOS DÍAS QUE NO ESTAN INCLUIDAS

package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ChangePanelHours;
import controlador.ChangeWindow;

public class ReservaPadel implements ActionListener{
	
	private JPanel[] panelDaysArray = new JPanel[7];
	private JButton[] btnDaysArray = new JButton[7];
	
	public static ChangeWindow change = new ChangeWindow("");

	public static ChangePanelHours panelHours = new ChangePanelHours();

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ReservaPadel window = new
	 * ReservaPadel();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public ReservaPadel() {
		initialize();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void newPadelInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaPadel window = new ReservaPadel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

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

		// ---------- MAIN PANEL ----------
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(10, 0, 1526, 800);
		frame.getContentPane().add(mainPanel);

		JLabel cycoLabel = new JLabel("");
		cycoLabel.setBounds(72, 10, 272, 135);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/padel.jpg"))
				.getImage().getScaledInstance(186, 101, Image.SCALE_DEFAULT));
		mainPanel.setLayout(null);
		cycoLabel.setIcon(imageIcon);
		cycoLabel.setBackground(new Color(218, 112, 214));
		mainPanel.add(cycoLabel);

		// --------- PANELES HORARIOS SEMANALES ---------
		panelDaysArray[0] = new JPanel();
		panelDaysArray[0].setBounds(72, 452, 1350, 309);
		mainPanel.add(panelDaysArray[0]);
		panelDaysArray[0].setLayout(null);
		panelDaysArray[0].setVisible(false);

		panelDaysArray[1] = new JPanel();
		panelDaysArray[1].setBounds(72, 452, 1350, 309);
		mainPanel.add(panelDaysArray[1]);
		panelDaysArray[1].setLayout(null);
		panelDaysArray[1].setVisible(false);

		panelDaysArray[2] = new JPanel();
		panelDaysArray[2].setBounds(72, 452, 1350, 309);
		mainPanel.add(panelDaysArray[2]);
		panelDaysArray[2].setLayout(null);
		panelDaysArray[2].setVisible(false);

		panelDaysArray[3] = new JPanel();
		panelDaysArray[3].setBounds(72, 452, 1350, 309);
		mainPanel.add(panelDaysArray[3]);
		panelDaysArray[3].setLayout(null);
		panelDaysArray[3].setVisible(false);

		panelDaysArray[4] = new JPanel();
		panelDaysArray[4].setBounds(72, 452, 1350, 309);
		mainPanel.add(panelDaysArray[4]);
		panelDaysArray[4].setLayout(null);
		panelDaysArray[4].setVisible(false);

		panelDaysArray[5] = new JPanel();
		panelDaysArray[5].setBounds(72, 452, 1350, 309);
		mainPanel.add(panelDaysArray[5]);
		panelDaysArray[5].setLayout(null);
		panelDaysArray[5].setVisible(false);

		panelDaysArray[6] = new JPanel();
		panelDaysArray[6].setBounds(72, 452, 1350, 309);
		mainPanel.add(panelDaysArray[6]);
		panelDaysArray[6].setLayout(null);
		panelDaysArray[6].setVisible(false);
		// ---------- PANEL SUPERIOR ----------
		JPanel panelSup = new JPanel();
		panelSup.setBackground(new Color(255, 255, 255));
		panelSup.setBounds(206, 10, 1293, 44);
		mainPanel.add(panelSup);
		panelSup.setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});

		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(71, 0, 100));
		btnSalir.setBounds(1217, 0, 66, 44);
		panelSup.add(btnSalir);

		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAyuda.setForeground(new Color(255, 255, 255));
		btnAyuda.setBackground(new Color(100, 0, 140));
		btnAyuda.setBounds(826, 0, 95, 44);
		panelSup.add(btnAyuda);

		JButton btnCalendario = new JButton("Calendario");
		btnCalendario.setFont(new Font("Calibri", Font.BOLD, 16));
		btnCalendario.setForeground(new Color(255, 255, 255));
		btnCalendario.setBackground(new Color(100, 0, 140));
		btnCalendario.setBounds(946, 0, 121, 44);
		panelSup.add(btnCalendario);

		JButton btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMiPerfil.setForeground(new Color(255, 255, 255));
		btnMiPerfil.setBackground(new Color(100, 0, 140));
		btnMiPerfil.setBounds(1095, 0, 95, 44);
		panelSup.add(btnMiPerfil);

		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change.newWindowApp("principal", frame);
			}
		});
		btnInicio.setFont(new Font("Calibri", Font.BOLD, 16));
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setBackground(new Color(71, 0, 100));
		btnInicio.setBounds(705, 0, 95, 44);
		panelSup.add(btnInicio);

		// ---------- FECHA Y HORA ----------
		String fecha = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		JLabel lblFecha = new JLabel(fecha);
		lblFecha.setFont(new Font("Calibri", Font.BOLD, 33));
		lblFecha.setForeground(new Color(100, 0, 140));
		lblFecha.setBackground(new Color(255, 255, 255));
		lblFecha.setBounds(686, 99, 139, 46);
		mainPanel.add(lblFecha);

		String hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		JLabel lblHora = new JLabel(hora);
		lblHora.setFont(new Font("Calibri", Font.BOLD, 30));
		lblHora.setForeground(new Color(100, 0, 140));
		lblHora.setBackground(new Color(255, 255, 255));
		lblHora.setBounds(717, 155, 108, 32);
		mainPanel.add(lblHora);

		// --------- DIAS SEMANA ----------
		for (int i=0;i<7;i++) {
			if (i==0)
				btnDaysArray[i]= new JButton("LUNES");
			else if (i==1) 
				btnDaysArray[i]= new JButton("MARTES");
			else if (i==2) 
				btnDaysArray[i]= new JButton("MIERCOLES");
			else if (i==3) 
				btnDaysArray[i]= new JButton("JUEVES");
			else if (i==4) 
				btnDaysArray[i]= new JButton("VIERNES");
			else if (i==5) 
				btnDaysArray[i]= new JButton("SABADO");
			else if (i==6) 
				btnDaysArray[i]= new JButton("DOMINGO");
			
			btnDaysArray[i].addActionListener(this);
			btnDaysArray[i].setBackground(new Color(248, 248, 255));
			btnDaysArray[i].setForeground(new Color(71, 0, 100));
			btnDaysArray[i].setFont(new Font("Calibri", Font.BOLD, 16));
			btnDaysArray[i].setBounds(72+i*201, 222, 139, 133);
			mainPanel.add(btnDaysArray[i]);
		}
		/*btnDaysArray[0]= new JButton("LUNES");
		btnDaysArray[0].addActionListener(this);
		btnDaysArray[0].setBackground(new Color(248, 248, 255));
		btnDaysArray[0].setForeground(new Color(71, 0, 100));
		btnDaysArray[0].setFont(new Font("Calibri", Font.BOLD, 16));
		btnDaysArray[0].setBounds(72, 222, 139, 133);
		mainPanel.add(btnDaysArray[0]);

		btnDaysArray[1] = new JButton("MARTES");
		btnDaysArray[1].addActionListener(this);
		btnDaysArray[1].setBackground(new Color(248, 248, 255));
		btnDaysArray[1].setForeground(new Color(71, 0, 100));
		btnDaysArray[1].setFont(new Font("Calibri", Font.BOLD, 16));
		btnDaysArray[1].setBounds(273, 222, 139, 133);
		mainPanel.add(btnDaysArray[1]);

		btnDaysArray[2] = new JButton("MIERCOLES");
		btnDaysArray[2].addActionListener(this);
		btnDaysArray[2].setBackground(new Color(248, 248, 255));
		btnDaysArray[2].setForeground(new Color(71, 0, 100));
		btnDaysArray[2].setFont(new Font("Calibri", Font.BOLD, 16));
		btnDaysArray[2].setBounds(474, 222, 139, 133);
		mainPanel.add(btnDaysArray[2]);

		btnDaysArray[3] = new JButton("JUEVES");
		btnDaysArray[3].addActionListener(this);
		btnDaysArray[3].setBackground(new Color(248, 248, 255));
		btnDaysArray[3].setForeground(new Color(71, 0, 100));
		btnDaysArray[3].setFont(new Font("Calibri", Font.BOLD, 16));
		btnDaysArray[3].setBounds(676, 222, 139, 133);
		mainPanel.add(btnDaysArray[3]);

		btnDaysArray[4] = new JButton("VIERNES");
		btnDaysArray[4].addActionListener(this);
		btnDaysArray[4].setBackground(new Color(248, 248, 255));
		btnDaysArray[4].setForeground(new Color(71, 0, 100));
		btnDaysArray[4].setFont(new Font("Calibri", Font.BOLD, 16));
		btnDaysArray[4].setBounds(880, 222, 139, 133);
		mainPanel.add(btnDaysArray[4]);

		btnDaysArray[5] = new JButton("S\u00C1BADO");
		btnDaysArray[5].addActionListener(this);
		btnDaysArray[5].setBackground(new Color(248, 248, 255));
		btnDaysArray[5].setForeground(new Color(71, 0, 100));
		btnDaysArray[5].setFont(new Font("Calibri", Font.BOLD, 16));
		btnDaysArray[5].setBounds(1083, 222, 139, 133);
		mainPanel.add(btnDaysArray[5]);

		btnDaysArray[6]= new JButton("DOMINGO");
		btnDaysArray[6].addActionListener(this);
		btnDaysArray[6].setBackground(new Color(248, 248, 255));
		btnDaysArray[6].setForeground(new Color(71, 0, 100));
		btnDaysArray[6].setFont(new Font("Calibri", Font.BOLD, 16));
		btnDaysArray[6].setBounds(1283, 222, 139, 133);
		mainPanel.add(btnDaysArray[6]);
*/
		// ---------- PISTAS DISPONIBLES ---------
		JLabel lblPistasDisponibles = new JLabel("Pistas disponibles:  ");
		lblPistasDisponibles.setForeground(new Color(100, 0, 140));
		lblPistasDisponibles.setFont(new Font("Calibri", Font.BOLD, 30));
		lblPistasDisponibles.setBounds(1102, 149, 319, 44);
		mainPanel.add(lblPistasDisponibles);

		JLabel lblPista = new JLabel("Pista 1");
		lblPista.setForeground(new Color(100, 0, 140));
		lblPista.setFont(new Font("Calibri", Font.BOLD, 23));
		lblPista.setBounds(316, 386, 70, 56);
		mainPanel.add(lblPista);

		JLabel lblPista_2 = new JLabel("Pista 2");
		lblPista_2.setForeground(new Color(100, 0, 140));
		lblPista_2.setFont(new Font("Calibri", Font.BOLD, 23));
		lblPista_2.setBounds(1122, 386, 70, 56);
		mainPanel.add(lblPista_2);

		JLabel lblTitulo = new JLabel("PADEL");
		lblTitulo.setBounds(290, 93, 139, 56);
		mainPanel.add(lblTitulo);
		lblTitulo.setForeground(new Color(71, 0, 100));
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 45));

		// ---------- HORARIOS LUNES PANEL 1 ----------
		JButton btnLu1_0730 = new JButton("7:30 - 9:00");
		btnLu1_0730.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLu1_0730.setBounds(55, 10, 139, 32);
		panelDaysArray[0].add(btnLu1_0730);
		btnLu1_0730.setForeground(new Color(71, 0, 100));
		btnLu1_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu1_0730.setBackground(new Color(248, 248, 255));

		JButton btnLu1_0900 = new JButton("9:00 - 10:30");
		btnLu1_0900.setBounds(55, 70, 139, 32);
		panelDaysArray[0].add(btnLu1_0900);
		btnLu1_0900.setForeground(new Color(71, 0, 100));
		btnLu1_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu1_0900.setBackground(new Color(248, 248, 255));

		JButton btnLu1_1030 = new JButton("10:30 - 12:00");
		btnLu1_1030.setBounds(55, 135, 139, 32);
		panelDaysArray[0].add(btnLu1_1030);
		btnLu1_1030.setForeground(new Color(71, 0, 100));
		btnLu1_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu1_1030.setBackground(new Color(248, 248, 255));

		JButton btnLu1_1200 = new JButton("12:00 - 13:30");
		btnLu1_1200.setBounds(55, 199, 139, 32);
		panelDaysArray[0].add(btnLu1_1200);
		btnLu1_1200.setForeground(new Color(71, 0, 100));
		btnLu1_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu1_1200.setBackground(new Color(248, 248, 255));

		JButton btnLu1_1330 = new JButton("13:30 - 15:00");
		btnLu1_1330.setBounds(55, 266, 139, 32);
		panelDaysArray[0].add(btnLu1_1330);
		btnLu1_1330.setForeground(new Color(71, 0, 100));
		btnLu1_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu1_1330.setBackground(new Color(248, 248, 255));

		JButton btnLu1_2100 = new JButton("21:00 - 22:00");
		btnLu1_2100.setBounds(256, 266, 139, 32);
		panelDaysArray[0].add(btnLu1_2100);
		btnLu1_2100.setForeground(new Color(71, 0, 100));
		btnLu1_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu1_2100.setBackground(new Color(248, 248, 255));

		JButton btnLu1_1930 = new JButton("19:30 - 21:00");
		btnLu1_1930.setBounds(256, 199, 139, 32);
		panelDaysArray[0].add(btnLu1_1930);
		btnLu1_1930.setForeground(new Color(71, 0, 100));
		btnLu1_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu1_1930.setBackground(new Color(248, 248, 255));

		JButton btnLu1_1800 = new JButton("18:00 - 19:30");
		btnLu1_1800.setBounds(256, 135, 139, 32);
		panelDaysArray[0].add(btnLu1_1800);
		btnLu1_1800.setForeground(new Color(71, 0, 100));
		btnLu1_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu1_1800.setBackground(new Color(248, 248, 255));

		JButton btnLu1_1630 = new JButton("16:30 - 18:00");
		btnLu1_1630.setBounds(256, 70, 139, 32);
		panelDaysArray[0].add(btnLu1_1630);
		btnLu1_1630.setForeground(new Color(71, 0, 100));
		btnLu1_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu1_1630.setBackground(new Color(248, 248, 255));

		JButton btnLu1_1500 = new JButton("15:00 - 16:30");
		btnLu1_1500.setBounds(256, 10, 139, 32);
		panelDaysArray[0].add(btnLu1_1500);
		btnLu1_1500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLu1_1500.setForeground(new Color(71, 0, 100));
		btnLu1_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu1_1500.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS LUNES PANEL 2 ----------
		JButton btnLu2_1800;
		btnLu2_1800 = new JButton("18:00 - 19:30");
		btnLu2_1800.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLu2_1800.setBounds(1064, 135, 139, 32);
		panelDaysArray[0].add(btnLu2_1800);
		btnLu2_1800.setForeground(new Color(71, 0, 100));
		btnLu2_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu2_1800.setBackground(new Color(248, 248, 255));

		JButton btnLu2_0730 = new JButton("7:30 - 9:00");
		btnLu2_0730.setBounds(863, 10, 139, 32);
		panelDaysArray[0].add(btnLu2_0730);
		btnLu2_0730.setForeground(new Color(71, 0, 100));
		btnLu2_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu2_0730.setBackground(new Color(248, 248, 255));

		JButton btnLu2_1500 = new JButton("15:00 - 16:30");
		btnLu2_1500.setBounds(1064, 10, 139, 32);
		panelDaysArray[0].add(btnLu2_1500);
		btnLu2_1500.setForeground(new Color(71, 0, 100));
		btnLu2_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu2_1500.setBackground(new Color(248, 248, 255));

		JButton btnLu2_1630 = new JButton("16:30 - 18:00");
		btnLu2_1630.setBounds(1064, 70, 139, 32);
		panelDaysArray[0].add(btnLu2_1630);
		btnLu2_1630.setForeground(new Color(71, 0, 100));
		btnLu2_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu2_1630.setBackground(new Color(248, 248, 255));

		JButton btnLu2_0900 = new JButton("9:00 - 10:30");
		btnLu2_0900.setBounds(863, 70, 139, 32);
		panelDaysArray[0].add(btnLu2_0900);
		btnLu2_0900.setForeground(new Color(71, 0, 100));
		btnLu2_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu2_0900.setBackground(new Color(248, 248, 255));

		JButton btnLu2_1030 = new JButton("10:30 - 12:00");
		btnLu2_1030.setBounds(863, 135, 139, 32);
		panelDaysArray[0].add(btnLu2_1030);
		btnLu2_1030.setForeground(new Color(71, 0, 100));
		btnLu2_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu2_1030.setBackground(new Color(248, 248, 255));

		JButton btnLu2_1200 = new JButton("12:00 - 13:30");
		btnLu2_1200.setBounds(863, 199, 139, 32);
		panelDaysArray[0].add(btnLu2_1200);
		btnLu2_1200.setForeground(new Color(71, 0, 100));
		btnLu2_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu2_1200.setBackground(new Color(248, 248, 255));

		JButton btnLu2_1930 = new JButton("19:30 - 21:00");
		btnLu2_1930.setBounds(1064, 199, 139, 32);
		panelDaysArray[0].add(btnLu2_1930);
		btnLu2_1930.setForeground(new Color(71, 0, 100));
		btnLu2_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu2_1930.setBackground(new Color(248, 248, 255));

		JButton btnLu2_2100 = new JButton("21:00 - 22:00");
		btnLu2_2100.setBounds(1064, 266, 139, 32);
		panelDaysArray[0].add(btnLu2_2100);
		btnLu2_2100.setForeground(new Color(71, 0, 100));
		btnLu2_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu2_2100.setBackground(new Color(248, 248, 255));

		JButton btnLu2_1330 = new JButton("13:30 - 15:00");
		btnLu2_1330.setBounds(863, 266, 139, 32);
		panelDaysArray[0].add(btnLu2_1330);
		btnLu2_1330.setForeground(new Color(71, 0, 100));
		btnLu2_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLu2_1330.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS MARTES PANEL 1 ----------
		JButton btnMa1_0730 = new JButton("7:30 - 9:00");
		btnMa1_0730.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMa1_0730.setBounds(55, 10, 139, 32);
		panelDaysArray[1].add(btnMa1_0730);
		btnMa1_0730.setForeground(new Color(71, 0, 100));
		btnMa1_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa1_0730.setBackground(new Color(248, 248, 255));

		JButton btnMa1_0900 = new JButton("9:00 - 10:30");
		btnMa1_0900.setBounds(55, 70, 139, 32);
		panelDaysArray[1].add(btnMa1_0900);
		btnMa1_0900.setForeground(new Color(71, 0, 100));
		btnMa1_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa1_0900.setBackground(new Color(248, 248, 255));

		JButton btnMa1_1030 = new JButton("10:30 - 12:00");
		btnMa1_1030.setBounds(55, 135, 139, 32);
		panelDaysArray[1].add(btnMa1_1030);
		btnMa1_1030.setForeground(new Color(71, 0, 100));
		btnMa1_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa1_1030.setBackground(new Color(248, 248, 255));

		JButton btnMa1_1200 = new JButton("12:00 - 13:30");
		btnMa1_1200.setBounds(55, 199, 139, 32);
		panelDaysArray[1].add(btnMa1_1200);
		btnMa1_1200.setForeground(new Color(71, 0, 100));
		btnMa1_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa1_1200.setBackground(new Color(248, 248, 255));

		JButton btnMa1_1330 = new JButton("13:30 - 15:00");
		btnMa1_1330.setBounds(55, 266, 139, 32);
		panelDaysArray[1].add(btnMa1_1330);
		btnMa1_1330.setForeground(new Color(71, 0, 100));
		btnMa1_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa1_1330.setBackground(new Color(248, 248, 255));

		JButton btnMa1_2100 = new JButton("21:00 - 22:00");
		btnMa1_2100.setBounds(256, 266, 139, 32);
		panelDaysArray[1].add(btnMa1_2100);
		btnMa1_2100.setForeground(new Color(71, 0, 100));
		btnMa1_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa1_2100.setBackground(new Color(248, 248, 255));

		JButton btnMa1_1930 = new JButton("19:30 - 21:00");
		btnMa1_1930.setBounds(256, 199, 139, 32);
		panelDaysArray[1].add(btnMa1_1930);
		btnMa1_1930.setForeground(new Color(71, 0, 100));
		btnMa1_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa1_1930.setBackground(new Color(248, 248, 255));

		JButton btnMa1_1800 = new JButton("18:00 - 19:30");
		btnMa1_1800.setBounds(256, 135, 139, 32);
		panelDaysArray[1].add(btnMa1_1800);
		btnMa1_1800.setForeground(new Color(71, 0, 100));
		btnMa1_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa1_1800.setBackground(new Color(248, 248, 255));

		JButton btnMa1_1630 = new JButton("16:30 - 18:00");
		btnMa1_1630.setBounds(256, 70, 139, 32);
		panelDaysArray[1].add(btnMa1_1630);
		btnMa1_1630.setForeground(new Color(71, 0, 100));
		btnMa1_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa1_1630.setBackground(new Color(248, 248, 255));

		JButton btnMa1_1500 = new JButton("15:00 - 16:30");
		btnMa1_1500.setBounds(256, 10, 139, 32);
		panelDaysArray[1].add(btnMa1_1500);
		btnMa1_1500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMa1_1500.setForeground(new Color(71, 0, 100));
		btnMa1_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa1_1500.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS MARTES PANEL 2 ----------
		JButton btnMa2_1800;
		btnMa2_1800 = new JButton("18:00 - 19:30");
		btnMa2_1800.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMa2_1800.setBounds(1064, 135, 139, 32);
		panelDaysArray[1].add(btnMa2_1800);
		btnMa2_1800.setForeground(new Color(71, 0, 100));
		btnMa2_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa2_1800.setBackground(new Color(248, 248, 255));

		JButton btnMa2_0730 = new JButton("7:30 - 9:00");
		btnMa2_0730.setBounds(863, 10, 139, 32);
		panelDaysArray[1].add(btnMa2_0730);
		btnMa2_0730.setForeground(new Color(71, 0, 100));
		btnMa2_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa2_0730.setBackground(new Color(248, 248, 255));

		JButton btnMa2_1500 = new JButton("15:00 - 16:30");
		btnMa2_1500.setBounds(1064, 10, 139, 32);
		panelDaysArray[1].add(btnMa2_1500);
		btnMa2_1500.setForeground(new Color(71, 0, 100));
		btnMa2_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa2_1500.setBackground(new Color(248, 248, 255));

		JButton btnMa2_1630 = new JButton("16:30 - 18:00");
		btnMa2_1630.setBounds(1064, 70, 139, 32);
		panelDaysArray[1].add(btnMa2_1630);
		btnMa2_1630.setForeground(new Color(71, 0, 100));
		btnMa2_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa2_1630.setBackground(new Color(248, 248, 255));

		JButton btnMa2_0900 = new JButton("9:00 - 10:30");
		btnMa2_0900.setBounds(863, 70, 139, 32);
		panelDaysArray[1].add(btnMa2_0900);
		btnMa2_0900.setForeground(new Color(71, 0, 100));
		btnMa2_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa2_0900.setBackground(new Color(248, 248, 255));

		JButton btnMa2_1030 = new JButton("10:30 - 12:00");
		btnMa2_1030.setBounds(863, 135, 139, 32);
		panelDaysArray[1].add(btnMa2_1030);
		btnMa2_1030.setForeground(new Color(71, 0, 100));
		btnMa2_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa2_1030.setBackground(new Color(248, 248, 255));

		JButton btnMa2_1200 = new JButton("12:00 - 13:30");
		btnMa2_1200.setBounds(863, 199, 139, 32);
		panelDaysArray[1].add(btnMa2_1200);
		btnMa2_1200.setForeground(new Color(71, 0, 100));
		btnMa2_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa2_1200.setBackground(new Color(248, 248, 255));

		JButton btnMa2_1930 = new JButton("19:30 - 21:00");
		btnMa2_1930.setBounds(1064, 199, 139, 32);
		panelDaysArray[1].add(btnMa2_1930);
		btnMa2_1930.setForeground(new Color(71, 0, 100));
		btnMa2_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa2_1930.setBackground(new Color(248, 248, 255));

		JButton btnMa2_2100 = new JButton("21:00 - 22:00");
		btnMa2_2100.setBounds(1064, 266, 139, 32);
		panelDaysArray[1].add(btnMa2_2100);
		btnMa2_2100.setForeground(new Color(71, 0, 100));
		btnMa2_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa2_2100.setBackground(new Color(248, 248, 255));

		JButton btnMa2_1330 = new JButton("13:30 - 15:00");
		btnMa2_1330.setBounds(863, 266, 139, 32);
		panelDaysArray[1].add(btnMa2_1330);
		btnMa2_1330.setForeground(new Color(71, 0, 100));
		btnMa2_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMa2_1330.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS MIERCOLES PANEL 1 ----------
		JButton btnXi1_0730 = new JButton("7:30 - 9:00");
		btnXi1_0730.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXi1_0730.setBounds(55, 10, 139, 32);
		panelDaysArray[2].add(btnXi1_0730);
		btnXi1_0730.setForeground(new Color(71, 0, 100));
		btnXi1_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi1_0730.setBackground(new Color(248, 248, 255));

		JButton btnXi1_0900 = new JButton("9:00 - 10:30");
		btnXi1_0900.setBounds(55, 70, 139, 32);
		panelDaysArray[2].add(btnXi1_0900);
		btnXi1_0900.setForeground(new Color(71, 0, 100));
		btnXi1_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi1_0900.setBackground(new Color(248, 248, 255));

		JButton btnXi1_1030 = new JButton("10:30 - 12:00");
		btnXi1_1030.setBounds(55, 135, 139, 32);
		panelDaysArray[2].add(btnXi1_1030);
		btnXi1_1030.setForeground(new Color(71, 0, 100));
		btnXi1_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi1_1030.setBackground(new Color(248, 248, 255));

		JButton btnXi1_1200 = new JButton("12:00 - 13:30");
		btnXi1_1200.setBounds(55, 199, 139, 32);
		panelDaysArray[2].add(btnXi1_1200);
		btnXi1_1200.setForeground(new Color(71, 0, 100));
		btnXi1_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi1_1200.setBackground(new Color(248, 248, 255));

		JButton btnXi1_1330 = new JButton("13:30 - 15:00");
		btnXi1_1330.setBounds(55, 266, 139, 32);
		panelDaysArray[2].add(btnXi1_1330);
		btnXi1_1330.setForeground(new Color(71, 0, 100));
		btnXi1_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi1_1330.setBackground(new Color(248, 248, 255));

		JButton btnXi1_2100 = new JButton("21:00 - 22:00");
		btnXi1_2100.setBounds(256, 266, 139, 32);
		panelDaysArray[2].add(btnXi1_2100);
		btnXi1_2100.setForeground(new Color(71, 0, 100));
		btnXi1_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi1_2100.setBackground(new Color(248, 248, 255));

		JButton btnXi1_1930 = new JButton("19:30 - 21:00");
		btnXi1_1930.setBounds(256, 199, 139, 32);
		panelDaysArray[2].add(btnXi1_1930);
		btnXi1_1930.setForeground(new Color(71, 0, 100));
		btnXi1_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi1_1930.setBackground(new Color(248, 248, 255));

		JButton btnXi1_1800 = new JButton("18:00 - 19:30");
		btnXi1_1800.setBounds(256, 135, 139, 32);
		panelDaysArray[2].add(btnXi1_1800);
		btnXi1_1800.setForeground(new Color(71, 0, 100));
		btnXi1_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi1_1800.setBackground(new Color(248, 248, 255));

		JButton btnXi1_1630 = new JButton("16:30 - 18:00");
		btnXi1_1630.setBounds(256, 70, 139, 32);
		panelDaysArray[2].add(btnXi1_1630);
		btnXi1_1630.setForeground(new Color(71, 0, 100));
		btnXi1_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi1_1630.setBackground(new Color(248, 248, 255));

		JButton btnXi1_1500 = new JButton("15:00 - 16:30");
		btnXi1_1500.setBounds(256, 10, 139, 32);
		panelDaysArray[2].add(btnXi1_1500);
		btnXi1_1500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXi1_1500.setForeground(new Color(71, 0, 100));
		btnXi1_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi1_1500.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS Miercoles PANEL 2 ----------
		JButton btnXi2_1800;
		btnXi2_1800 = new JButton("18:00 - 19:30");
		btnXi2_1800.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXi2_1800.setBounds(1064, 135, 139, 32);
		panelDaysArray[2].add(btnXi2_1800);
		btnXi2_1800.setForeground(new Color(71, 0, 100));
		btnXi2_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi2_1800.setBackground(new Color(248, 248, 255));

		JButton btnXi2_0730 = new JButton("7:30 - 9:00");
		btnXi2_0730.setBounds(863, 10, 139, 32);
		panelDaysArray[2].add(btnXi2_0730);
		btnXi2_0730.setForeground(new Color(71, 0, 100));
		btnXi2_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi2_0730.setBackground(new Color(248, 248, 255));

		JButton btnXi2_1500 = new JButton("15:00 - 16:30");
		btnXi2_1500.setBounds(1064, 10, 139, 32);
		panelDaysArray[2].add(btnXi2_1500);
		btnXi2_1500.setForeground(new Color(71, 0, 100));
		btnXi2_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi2_1500.setBackground(new Color(248, 248, 255));

		JButton btnXi2_1630 = new JButton("16:30 - 18:00");
		btnXi2_1630.setBounds(1064, 70, 139, 32);
		panelDaysArray[2].add(btnXi2_1630);
		btnXi2_1630.setForeground(new Color(71, 0, 100));
		btnXi2_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi2_1630.setBackground(new Color(248, 248, 255));

		JButton btnXi2_0900 = new JButton("9:00 - 10:30");
		btnXi2_0900.setBounds(863, 70, 139, 32);
		panelDaysArray[2].add(btnXi2_0900);
		btnXi2_0900.setForeground(new Color(71, 0, 100));
		btnXi2_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi2_0900.setBackground(new Color(248, 248, 255));

		JButton btnXi2_1030 = new JButton("10:30 - 12:00");
		btnXi2_1030.setBounds(863, 135, 139, 32);
		panelDaysArray[2].add(btnXi2_1030);
		btnXi2_1030.setForeground(new Color(71, 0, 100));
		btnXi2_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi2_1030.setBackground(new Color(248, 248, 255));

		JButton btnXi2_1200 = new JButton("12:00 - 13:30");
		btnXi2_1200.setBounds(863, 199, 139, 32);
		panelDaysArray[2].add(btnXi2_1200);
		btnXi2_1200.setForeground(new Color(71, 0, 100));
		btnXi2_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi2_1200.setBackground(new Color(248, 248, 255));

		JButton btnXi2_1930 = new JButton("19:30 - 21:00");
		btnXi2_1930.setBounds(1064, 199, 139, 32);
		panelDaysArray[2].add(btnXi2_1930);
		btnXi2_1930.setForeground(new Color(71, 0, 100));
		btnXi2_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi2_1930.setBackground(new Color(248, 248, 255));

		JButton btnXi2_2100 = new JButton("21:00 - 22:00");
		btnXi2_2100.setBounds(1064, 266, 139, 32);
		panelDaysArray[2].add(btnXi2_2100);
		btnXi2_2100.setForeground(new Color(71, 0, 100));
		btnXi2_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi2_2100.setBackground(new Color(248, 248, 255));

		JButton btnXi2_1330 = new JButton("13:30 - 15:00");
		btnXi2_1330.setBounds(863, 266, 139, 32);
		panelDaysArray[2].add(btnXi2_1330);
		btnXi2_1330.setForeground(new Color(71, 0, 100));
		btnXi2_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXi2_1330.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS JUEVES PANEL 1 ----------
		JButton btnJu1_0730 = new JButton("7:30 - 9:00");
		btnJu1_0730.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJu1_0730.setBounds(55, 10, 139, 32);
		panelDaysArray[3].add(btnJu1_0730);
		btnJu1_0730.setForeground(new Color(71, 0, 100));
		btnJu1_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu1_0730.setBackground(new Color(248, 248, 255));

		JButton btnJu1_0900 = new JButton("9:00 - 10:30");
		btnJu1_0900.setBounds(55, 70, 139, 32);
		panelDaysArray[3].add(btnJu1_0900);
		btnJu1_0900.setForeground(new Color(71, 0, 100));
		btnJu1_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu1_0900.setBackground(new Color(248, 248, 255));

		JButton btnJu1_1030 = new JButton("10:30 - 12:00");
		btnJu1_1030.setBounds(55, 135, 139, 32);
		panelDaysArray[3].add(btnJu1_1030);
		btnJu1_1030.setForeground(new Color(71, 0, 100));
		btnJu1_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu1_1030.setBackground(new Color(248, 248, 255));

		JButton btnJu1_1200 = new JButton("12:00 - 13:30");
		btnJu1_1200.setBounds(55, 199, 139, 32);
		panelDaysArray[3].add(btnJu1_1200);
		btnJu1_1200.setForeground(new Color(71, 0, 100));
		btnJu1_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu1_1200.setBackground(new Color(248, 248, 255));

		JButton btnJu1_1330 = new JButton("13:30 - 15:00");
		btnJu1_1330.setBounds(55, 266, 139, 32);
		panelDaysArray[3].add(btnJu1_1330);
		btnJu1_1330.setForeground(new Color(71, 0, 100));
		btnJu1_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu1_1330.setBackground(new Color(248, 248, 255));

		JButton btnJu1_2100 = new JButton("21:00 - 22:00");
		btnJu1_2100.setBounds(256, 266, 139, 32);
		panelDaysArray[3].add(btnJu1_2100);
		btnJu1_2100.setForeground(new Color(71, 0, 100));
		btnJu1_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu1_2100.setBackground(new Color(248, 248, 255));

		JButton btnJu1_1930 = new JButton("19:30 - 21:00");
		btnJu1_1930.setBounds(256, 199, 139, 32);
		panelDaysArray[3].add(btnJu1_1930);
		btnJu1_1930.setForeground(new Color(71, 0, 100));
		btnJu1_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu1_1930.setBackground(new Color(248, 248, 255));

		JButton btnJu1_1800 = new JButton("18:00 - 19:30");
		btnJu1_1800.setBounds(256, 135, 139, 32);
		panelDaysArray[3].add(btnJu1_1800);
		btnJu1_1800.setForeground(new Color(71, 0, 100));
		btnJu1_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu1_1800.setBackground(new Color(248, 248, 255));

		JButton btnJu1_1630 = new JButton("16:30 - 18:00");
		btnJu1_1630.setBounds(256, 70, 139, 32);
		panelDaysArray[3].add(btnJu1_1630);
		btnJu1_1630.setForeground(new Color(71, 0, 100));
		btnJu1_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu1_1630.setBackground(new Color(248, 248, 255));

		JButton btnJu1_1500 = new JButton("15:00 - 16:30");
		btnJu1_1500.setBounds(256, 10, 139, 32);
		panelDaysArray[3].add(btnJu1_1500);
		btnJu1_1500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJu1_1500.setForeground(new Color(71, 0, 100));
		btnJu1_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu1_1500.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS JUEVES PANEL 2 ----------
		JButton btnJu2_1800;
		btnJu2_1800 = new JButton("18:00 - 19:30");
		btnJu2_1800.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJu2_1800.setBounds(1064, 135, 139, 32);
		panelDaysArray[3].add(btnJu2_1800);
		btnJu2_1800.setForeground(new Color(71, 0, 100));
		btnJu2_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu2_1800.setBackground(new Color(248, 248, 255));

		JButton btnJu2_0730 = new JButton("7:30 - 9:00");
		btnJu2_0730.setBounds(863, 10, 139, 32);
		panelDaysArray[3].add(btnJu2_0730);
		btnJu2_0730.setForeground(new Color(71, 0, 100));
		btnJu2_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu2_0730.setBackground(new Color(248, 248, 255));

		JButton btnJu2_1500 = new JButton("15:00 - 16:30");
		btnJu2_1500.setBounds(1064, 10, 139, 32);
		panelDaysArray[3].add(btnJu2_1500);
		btnJu2_1500.setForeground(new Color(71, 0, 100));
		btnJu2_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu2_1500.setBackground(new Color(248, 248, 255));

		JButton btnJu2_1630 = new JButton("16:30 - 18:00");
		btnJu2_1630.setBounds(1064, 70, 139, 32);
		panelDaysArray[3].add(btnJu2_1630);
		btnJu2_1630.setForeground(new Color(71, 0, 100));
		btnJu2_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu2_1630.setBackground(new Color(248, 248, 255));

		JButton btnJu2_0900 = new JButton("9:00 - 10:30");
		btnJu2_0900.setBounds(863, 70, 139, 32);
		panelDaysArray[3].add(btnJu2_0900);
		btnJu2_0900.setForeground(new Color(71, 0, 100));
		btnJu2_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu2_0900.setBackground(new Color(248, 248, 255));

		JButton btnJu2_1030 = new JButton("10:30 - 12:00");
		btnJu2_1030.setBounds(863, 135, 139, 32);
		panelDaysArray[3].add(btnJu2_1030);
		btnJu2_1030.setForeground(new Color(71, 0, 100));
		btnJu2_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu2_1030.setBackground(new Color(248, 248, 255));

		JButton btnJu2_1200 = new JButton("12:00 - 13:30");
		btnJu2_1200.setBounds(863, 199, 139, 32);
		panelDaysArray[3].add(btnJu2_1200);
		btnJu2_1200.setForeground(new Color(71, 0, 100));
		btnJu2_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu2_1200.setBackground(new Color(248, 248, 255));

		JButton btnJu2_1930 = new JButton("19:30 - 21:00");
		btnJu2_1930.setBounds(1064, 199, 139, 32);
		panelDaysArray[3].add(btnJu2_1930);
		btnJu2_1930.setForeground(new Color(71, 0, 100));
		btnJu2_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu2_1930.setBackground(new Color(248, 248, 255));

		JButton btnJu2_2100 = new JButton("21:00 - 22:00");
		btnJu2_2100.setBounds(1064, 266, 139, 32);
		panelDaysArray[3].add(btnJu2_2100);
		btnJu2_2100.setForeground(new Color(71, 0, 100));
		btnJu2_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu2_2100.setBackground(new Color(248, 248, 255));

		JButton btnJu2_1330 = new JButton("13:30 - 15:00");
		btnJu2_1330.setBounds(863, 266, 139, 32);
		panelDaysArray[3].add(btnJu2_1330);
		btnJu2_1330.setForeground(new Color(71, 0, 100));
		btnJu2_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJu2_1330.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS VIERNES PANEL 1 ----------
		JButton btnVi1_0730 = new JButton("7:30 - 9:00");
		btnVi1_0730.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVi1_0730.setBounds(55, 10, 139, 32);
		panelDaysArray[4].add(btnVi1_0730);
		btnVi1_0730.setForeground(new Color(71, 0, 100));
		btnVi1_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi1_0730.setBackground(new Color(248, 248, 255));

		JButton btnVi1_0900 = new JButton("9:00 - 10:30");
		btnVi1_0900.setBounds(55, 70, 139, 32);
		panelDaysArray[4].add(btnVi1_0900);
		btnVi1_0900.setForeground(new Color(71, 0, 100));
		btnVi1_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi1_0900.setBackground(new Color(248, 248, 255));

		JButton btnVi1_1030 = new JButton("10:30 - 12:00");
		btnVi1_1030.setBounds(55, 135, 139, 32);
		panelDaysArray[4].add(btnVi1_1030);
		btnVi1_1030.setForeground(new Color(71, 0, 100));
		btnVi1_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi1_1030.setBackground(new Color(248, 248, 255));

		JButton btnVi1_1200 = new JButton("12:00 - 13:30");
		btnVi1_1200.setBounds(55, 199, 139, 32);
		panelDaysArray[4].add(btnVi1_1200);
		btnVi1_1200.setForeground(new Color(71, 0, 100));
		btnVi1_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi1_1200.setBackground(new Color(248, 248, 255));

		JButton btnVi1_1330 = new JButton("13:30 - 15:00");
		btnVi1_1330.setBounds(55, 266, 139, 32);
		panelDaysArray[4].add(btnVi1_1330);
		btnVi1_1330.setForeground(new Color(71, 0, 100));
		btnVi1_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi1_1330.setBackground(new Color(248, 248, 255));

		JButton btnVi1_2100 = new JButton("21:00 - 22:00");
		btnVi1_2100.setBounds(256, 266, 139, 32);
		panelDaysArray[4].add(btnVi1_2100);
		btnVi1_2100.setForeground(new Color(71, 0, 100));
		btnVi1_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi1_2100.setBackground(new Color(248, 248, 255));

		JButton btnVi1_1930 = new JButton("19:30 - 21:00");
		btnVi1_1930.setBounds(256, 199, 139, 32);
		panelDaysArray[4].add(btnVi1_1930);
		btnVi1_1930.setForeground(new Color(71, 0, 100));
		btnVi1_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi1_1930.setBackground(new Color(248, 248, 255));

		JButton btnVi1_1800 = new JButton("18:00 - 19:30");
		btnVi1_1800.setBounds(256, 135, 139, 32);
		panelDaysArray[4].add(btnVi1_1800);
		btnVi1_1800.setForeground(new Color(71, 0, 100));
		btnVi1_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi1_1800.setBackground(new Color(248, 248, 255));

		JButton btnVi1_1630 = new JButton("16:30 - 18:00");
		btnVi1_1630.setBounds(256, 70, 139, 32);
		panelDaysArray[4].add(btnVi1_1630);
		btnVi1_1630.setForeground(new Color(71, 0, 100));
		btnVi1_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi1_1630.setBackground(new Color(248, 248, 255));

		JButton btnVi1_1500 = new JButton("15:00 - 16:30");
		btnVi1_1500.setBounds(256, 10, 139, 32);
		panelDaysArray[4].add(btnVi1_1500);
		btnVi1_1500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVi1_1500.setForeground(new Color(71, 0, 100));
		btnVi1_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi1_1500.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS VIERNES PANEL 2 ----------
		JButton btnVi2_1800;
		btnVi2_1800 = new JButton("18:00 - 19:30");
		btnVi2_1800.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVi2_1800.setBounds(1064, 135, 139, 32);
		panelDaysArray[4].add(btnVi2_1800);
		btnVi2_1800.setForeground(new Color(71, 0, 100));
		btnVi2_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi2_1800.setBackground(new Color(248, 248, 255));

		JButton btnVi2_0730 = new JButton("7:30 - 9:00");
		btnVi2_0730.setBounds(863, 10, 139, 32);
		panelDaysArray[4].add(btnVi2_0730);
		btnVi2_0730.setForeground(new Color(71, 0, 100));
		btnVi2_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi2_0730.setBackground(new Color(248, 248, 255));

		JButton btnVi2_1500 = new JButton("15:00 - 16:30");
		btnVi2_1500.setBounds(1064, 10, 139, 32);
		panelDaysArray[4].add(btnVi2_1500);
		btnVi2_1500.setForeground(new Color(71, 0, 100));
		btnVi2_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi2_1500.setBackground(new Color(248, 248, 255));

		JButton btnVi2_1630 = new JButton("16:30 - 18:00");
		btnVi2_1630.setBounds(1064, 70, 139, 32);
		panelDaysArray[4].add(btnVi2_1630);
		btnVi2_1630.setForeground(new Color(71, 0, 100));
		btnVi2_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi2_1630.setBackground(new Color(248, 248, 255));

		JButton btnVi2_0900 = new JButton("9:00 - 10:30");
		btnVi2_0900.setBounds(863, 70, 139, 32);
		panelDaysArray[4].add(btnVi2_0900);
		btnVi2_0900.setForeground(new Color(71, 0, 100));
		btnVi2_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi2_0900.setBackground(new Color(248, 248, 255));

		JButton btnVi2_1030 = new JButton("10:30 - 12:00");
		btnVi2_1030.setBounds(863, 135, 139, 32);
		panelDaysArray[4].add(btnVi2_1030);
		btnVi2_1030.setForeground(new Color(71, 0, 100));
		btnVi2_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi2_1030.setBackground(new Color(248, 248, 255));

		JButton btnVi2_1200 = new JButton("12:00 - 13:30");
		btnVi2_1200.setBounds(863, 199, 139, 32);
		panelDaysArray[4].add(btnVi2_1200);
		btnVi2_1200.setForeground(new Color(71, 0, 100));
		btnVi2_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi2_1200.setBackground(new Color(248, 248, 255));

		JButton btnVi2_1930 = new JButton("19:30 - 21:00");
		btnVi2_1930.setBounds(1064, 199, 139, 32);
		panelDaysArray[4].add(btnVi2_1930);
		btnVi2_1930.setForeground(new Color(71, 0, 100));
		btnVi2_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi2_1930.setBackground(new Color(248, 248, 255));

		JButton btnVi2_2100 = new JButton("21:00 - 22:00");
		btnVi2_2100.setBounds(1064, 266, 139, 32);
		panelDaysArray[4].add(btnVi2_2100);
		btnVi2_2100.setForeground(new Color(71, 0, 100));
		btnVi2_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi2_2100.setBackground(new Color(248, 248, 255));

		JButton btnVi2_1330 = new JButton("13:30 - 15:00");
		btnVi2_1330.setBounds(863, 266, 139, 32);
		panelDaysArray[4].add(btnVi2_1330);
		btnVi2_1330.setForeground(new Color(71, 0, 100));
		btnVi2_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnVi2_1330.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS SABADO PANEL 1 ----------
		JButton btnSa1_0730 = new JButton("7:30 - 9:00");
		btnSa1_0730.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSa1_0730.setBounds(55, 10, 139, 32);
		panelDaysArray[5].add(btnSa1_0730);
		btnSa1_0730.setForeground(new Color(71, 0, 100));
		btnSa1_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa1_0730.setBackground(new Color(248, 248, 255));

		JButton btnSa1_0900 = new JButton("9:00 - 10:30");
		btnSa1_0900.setBounds(55, 70, 139, 32);
		panelDaysArray[5].add(btnSa1_0900);
		btnSa1_0900.setForeground(new Color(71, 0, 100));
		btnSa1_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa1_0900.setBackground(new Color(248, 248, 255));

		JButton btnSa1_1030 = new JButton("10:30 - 12:00");
		btnSa1_1030.setBounds(55, 135, 139, 32);
		panelDaysArray[5].add(btnSa1_1030);
		btnSa1_1030.setForeground(new Color(71, 0, 100));
		btnSa1_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa1_1030.setBackground(new Color(248, 248, 255));

		JButton btnSa1_1200 = new JButton("12:00 - 13:30");
		btnSa1_1200.setBounds(55, 199, 139, 32);
		panelDaysArray[5].add(btnSa1_1200);
		btnSa1_1200.setForeground(new Color(71, 0, 100));
		btnSa1_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa1_1200.setBackground(new Color(248, 248, 255));

		JButton btnSa1_1330 = new JButton("13:30 - 15:00");
		btnSa1_1330.setBounds(55, 266, 139, 32);
		panelDaysArray[5].add(btnSa1_1330);
		btnSa1_1330.setForeground(new Color(71, 0, 100));
		btnSa1_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa1_1330.setBackground(new Color(248, 248, 255));

		JButton btnSa1_2100 = new JButton("21:00 - 22:00");
		btnSa1_2100.setBounds(256, 266, 139, 32);
		panelDaysArray[5].add(btnSa1_2100);
		btnSa1_2100.setForeground(new Color(71, 0, 100));
		btnSa1_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa1_2100.setBackground(new Color(248, 248, 255));

		JButton btnSa1_1930 = new JButton("19:30 - 21:00");
		btnSa1_1930.setBounds(256, 199, 139, 32);
		panelDaysArray[5].add(btnSa1_1930);
		btnSa1_1930.setForeground(new Color(71, 0, 100));
		btnSa1_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa1_1930.setBackground(new Color(248, 248, 255));

		JButton btnSa1_1800 = new JButton("18:00 - 19:30");
		btnSa1_1800.setBounds(256, 135, 139, 32);
		panelDaysArray[5].add(btnSa1_1800);
		btnSa1_1800.setForeground(new Color(71, 0, 100));
		btnSa1_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa1_1800.setBackground(new Color(248, 248, 255));

		JButton btnSa1_1630 = new JButton("16:30 - 18:00");
		btnSa1_1630.setBounds(256, 70, 139, 32);
		panelDaysArray[5].add(btnSa1_1630);
		btnSa1_1630.setForeground(new Color(71, 0, 100));
		btnSa1_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa1_1630.setBackground(new Color(248, 248, 255));

		JButton btnSa1_1500 = new JButton("15:00 - 16:30");
		btnSa1_1500.setBounds(256, 10, 139, 32);
		panelDaysArray[5].add(btnSa1_1500);
		btnSa1_1500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSa1_1500.setForeground(new Color(71, 0, 100));
		btnSa1_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa1_1500.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS SABADO PANEL 2 ----------
		JButton btnSa2_1800;
		btnSa2_1800 = new JButton("18:00 - 19:30");
		btnSa2_1800.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSa2_1800.setBounds(1064, 135, 139, 32);
		panelDaysArray[5].add(btnSa2_1800);
		btnSa2_1800.setForeground(new Color(71, 0, 100));
		btnSa2_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa2_1800.setBackground(new Color(248, 248, 255));

		JButton btnSa2_0730 = new JButton("7:30 - 9:00");
		btnSa2_0730.setBounds(863, 10, 139, 32);
		panelDaysArray[5].add(btnSa2_0730);
		btnSa2_0730.setForeground(new Color(71, 0, 100));
		btnSa2_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa2_0730.setBackground(new Color(248, 248, 255));

		JButton btnSa2_1500 = new JButton("15:00 - 16:30");
		btnSa2_1500.setBounds(1064, 10, 139, 32);
		panelDaysArray[5].add(btnSa2_1500);
		btnSa2_1500.setForeground(new Color(71, 0, 100));
		btnSa2_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa2_1500.setBackground(new Color(248, 248, 255));

		JButton btnSa2_1630 = new JButton("16:30 - 18:00");
		btnSa2_1630.setBounds(1064, 70, 139, 32);
		panelDaysArray[5].add(btnSa2_1630);
		btnSa2_1630.setForeground(new Color(71, 0, 100));
		btnSa2_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa2_1630.setBackground(new Color(248, 248, 255));

		JButton btnSa2_0900 = new JButton("9:00 - 10:30");
		btnSa2_0900.setBounds(863, 70, 139, 32);
		panelDaysArray[5].add(btnSa2_0900);
		btnSa2_0900.setForeground(new Color(71, 0, 100));
		btnSa2_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa2_0900.setBackground(new Color(248, 248, 255));

		JButton btnSa2_1030 = new JButton("10:30 - 12:00");
		btnSa2_1030.setBounds(863, 135, 139, 32);
		panelDaysArray[5].add(btnSa2_1030);
		btnSa2_1030.setForeground(new Color(71, 0, 100));
		btnSa2_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa2_1030.setBackground(new Color(248, 248, 255));

		JButton btnSa2_1200 = new JButton("12:00 - 13:30");
		btnSa2_1200.setBounds(863, 199, 139, 32);
		panelDaysArray[5].add(btnSa2_1200);
		btnSa2_1200.setForeground(new Color(71, 0, 100));
		btnSa2_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa2_1200.setBackground(new Color(248, 248, 255));

		JButton btnSa2_1930 = new JButton("19:30 - 21:00");
		btnSa2_1930.setBounds(1064, 199, 139, 32);
		panelDaysArray[5].add(btnSa2_1930);
		btnSa2_1930.setForeground(new Color(71, 0, 100));
		btnSa2_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa2_1930.setBackground(new Color(248, 248, 255));

		JButton btnSa2_2100 = new JButton("21:00 - 22:00");
		btnSa2_2100.setBounds(1064, 266, 139, 32);
		panelDaysArray[5].add(btnSa2_2100);
		btnSa2_2100.setForeground(new Color(71, 0, 100));
		btnSa2_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa2_2100.setBackground(new Color(248, 248, 255));

		JButton btnSa2_1330 = new JButton("13:30 - 15:00");
		btnSa2_1330.setBounds(863, 266, 139, 32);
		panelDaysArray[5].add(btnSa2_1330);
		btnSa2_1330.setForeground(new Color(71, 0, 100));
		btnSa2_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSa2_1330.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS DOMINGO PANEL 1 ----------
		JButton btnDo1_0730 = new JButton("7:30 - 9:00");
		btnDo1_0730.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDo1_0730.setBounds(55, 10, 139, 32);
		panelDaysArray[6].add(btnDo1_0730);
		btnDo1_0730.setForeground(new Color(71, 0, 100));
		btnDo1_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo1_0730.setBackground(new Color(248, 248, 255));

		JButton btnDo1_0900 = new JButton("9:00 - 10:30");
		btnDo1_0900.setBounds(55, 70, 139, 32);
		panelDaysArray[6].add(btnDo1_0900);
		btnDo1_0900.setForeground(new Color(71, 0, 100));
		btnDo1_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo1_0900.setBackground(new Color(248, 248, 255));

		JButton btnDo1_1030 = new JButton("10:30 - 12:00");
		btnDo1_1030.setBounds(55, 135, 139, 32);
		panelDaysArray[6].add(btnDo1_1030);
		btnDo1_1030.setForeground(new Color(71, 0, 100));
		btnDo1_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo1_1030.setBackground(new Color(248, 248, 255));

		JButton btnDo1_1200 = new JButton("12:00 - 13:30");
		btnDo1_1200.setBounds(55, 199, 139, 32);
		panelDaysArray[6].add(btnDo1_1200);
		btnDo1_1200.setForeground(new Color(71, 0, 100));
		btnDo1_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo1_1200.setBackground(new Color(248, 248, 255));

		JButton btnDo1_1330 = new JButton("13:30 - 15:00");
		btnDo1_1330.setBounds(55, 266, 139, 32);
		panelDaysArray[6].add(btnDo1_1330);
		btnDo1_1330.setForeground(new Color(71, 0, 100));
		btnDo1_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo1_1330.setBackground(new Color(248, 248, 255));

		JButton btnDo1_2100 = new JButton("21:00 - 22:00");
		btnDo1_2100.setBounds(256, 266, 139, 32);
		panelDaysArray[6].add(btnDo1_2100);
		btnDo1_2100.setForeground(new Color(71, 0, 100));
		btnDo1_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo1_2100.setBackground(new Color(248, 248, 255));

		JButton btnDo1_1930 = new JButton("19:30 - 21:00");
		btnDo1_1930.setBounds(256, 199, 139, 32);
		panelDaysArray[6].add(btnDo1_1930);
		btnDo1_1930.setForeground(new Color(71, 0, 100));
		btnDo1_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo1_1930.setBackground(new Color(248, 248, 255));

		JButton btnDo1_1800 = new JButton("18:00 - 19:30");
		btnDo1_1800.setBounds(256, 135, 139, 32);
		panelDaysArray[6].add(btnDo1_1800);
		btnDo1_1800.setForeground(new Color(71, 0, 100));
		btnDo1_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo1_1800.setBackground(new Color(248, 248, 255));

		JButton btnDo1_1630 = new JButton("16:30 - 18:00");
		btnDo1_1630.setBounds(256, 70, 139, 32);
		panelDaysArray[6].add(btnDo1_1630);
		btnDo1_1630.setForeground(new Color(71, 0, 100));
		btnDo1_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo1_1630.setBackground(new Color(248, 248, 255));

		JButton btnDo1_1500 = new JButton("15:00 - 16:30");
		btnDo1_1500.setBounds(256, 10, 139, 32);
		panelDaysArray[6].add(btnDo1_1500);
		btnDo1_1500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDo1_1500.setForeground(new Color(71, 0, 100));
		btnDo1_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo1_1500.setBackground(new Color(248, 248, 255));

		// ---------- HORARIOS DOMINGO PANEL 2 ----------
		JButton btnDo2_1800;
		btnDo2_1800 = new JButton("18:00 - 19:30");
		btnDo2_1800.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDo2_1800.setBounds(1064, 135, 139, 32);
		panelDaysArray[6].add(btnDo2_1800);
		btnDo2_1800.setForeground(new Color(71, 0, 100));
		btnDo2_1800.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo2_1800.setBackground(new Color(248, 248, 255));

		JButton btnDo2_0730 = new JButton("7:30 - 9:00");
		btnDo2_0730.setBounds(863, 10, 139, 32);
		panelDaysArray[6].add(btnDo2_0730);
		btnDo2_0730.setForeground(new Color(71, 0, 100));
		btnDo2_0730.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo2_0730.setBackground(new Color(248, 248, 255));

		JButton btnDo2_1500 = new JButton("15:00 - 16:30");
		btnDo2_1500.setBounds(1064, 10, 139, 32);
		panelDaysArray[6].add(btnDo2_1500);
		btnDo2_1500.setForeground(new Color(71, 0, 100));
		btnDo2_1500.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo2_1500.setBackground(new Color(248, 248, 255));

		JButton btnDo2_1630 = new JButton("16:30 - 18:00");
		btnDo2_1630.setBounds(1064, 70, 139, 32);
		panelDaysArray[6].add(btnDo2_1630);
		btnDo2_1630.setForeground(new Color(71, 0, 100));
		btnDo2_1630.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo2_1630.setBackground(new Color(248, 248, 255));

		JButton btnDo2_0900 = new JButton("9:00 - 10:30");
		btnDo2_0900.setBounds(863, 70, 139, 32);
		panelDaysArray[6].add(btnDo2_0900);
		btnDo2_0900.setForeground(new Color(71, 0, 100));
		btnDo2_0900.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo2_0900.setBackground(new Color(248, 248, 255));

		JButton btnDo2_1030 = new JButton("10:30 - 12:00");
		btnDo2_1030.setBounds(863, 135, 139, 32);
		panelDaysArray[6].add(btnDo2_1030);
		btnDo2_1030.setForeground(new Color(71, 0, 100));
		btnDo2_1030.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo2_1030.setBackground(new Color(248, 248, 255));

		JButton btnDo2_1200 = new JButton("12:00 - 13:30");
		btnDo2_1200.setBounds(863, 199, 139, 32);
		panelDaysArray[6].add(btnDo2_1200);
		btnDo2_1200.setForeground(new Color(71, 0, 100));
		btnDo2_1200.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo2_1200.setBackground(new Color(248, 248, 255));

		JButton btnDo2_1930 = new JButton("19:30 - 21:00");
		btnDo2_1930.setBounds(1064, 199, 139, 32);
		panelDaysArray[6].add(btnDo2_1930);
		btnDo2_1930.setForeground(new Color(71, 0, 100));
		btnDo2_1930.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo2_1930.setBackground(new Color(248, 248, 255));

		JButton btnDo2_2100 = new JButton("21:00 - 22:00");
		btnDo2_2100.setBounds(1064, 266, 139, 32);
		panelDaysArray[6].add(btnDo2_2100);
		btnDo2_2100.setForeground(new Color(71, 0, 100));
		btnDo2_2100.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo2_2100.setBackground(new Color(248, 248, 255));

		JButton btnDo2_1330 = new JButton("13:30 - 15:00");
		btnDo2_1330.setBounds(863, 266, 139, 32);
		panelDaysArray[6].add(btnDo2_1330);
		btnDo2_1330.setForeground(new Color(71, 0, 100));
		btnDo2_1330.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDo2_1330.setBackground(new Color(248, 248, 255));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String button = ((AbstractButton) e.getSource()).getText();
		System.out.println(button);
		if (button == "LUNES" || button == "MARTES" || button == "MIERCOLES"|| button == "JUEVES"|| 
				button == "VIERNES"|| button == "SABADO"|| button == "DOMINGO")
			panelHours.newPanelHours(button, panelDaysArray);
		
	
				
		
	}
}

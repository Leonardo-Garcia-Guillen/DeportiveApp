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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ReservaPadel {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaPadel window = new ReservaPadel();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

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
		frame.setBounds(0, 0, (int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(10, 0, 1526, 800);
		frame.getContentPane().add(mainPanel);
		
		
		
		JLabel cycoLabel = new JLabel("");
		cycoLabel.setBounds(72, 28, 272, 117);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/padel.jpg")).getImage().getScaledInstance(186, 101, Image.SCALE_DEFAULT));
		mainPanel.setLayout(null);
		cycoLabel.setIcon(imageIcon);
		cycoLabel.setBackground(new Color(218, 112, 214));
		mainPanel.add(cycoLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(206, 10, 1293, 44);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(71, 0, 100));
		btnNewButton.setBounds(1217, 0, 66, 44);
		panel_1.add(btnNewButton);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAyuda.setForeground(new Color(255, 255, 255));
		btnAyuda.setBackground(new Color(100, 0, 140));
		btnAyuda.setBounds(826, 0, 95, 44);
		panel_1.add(btnAyuda);
		
		JButton btnCalendario = new JButton("Calendario");
		btnCalendario.setFont(new Font("Calibri", Font.BOLD, 16));
		btnCalendario.setForeground(new Color(255, 255, 255));
		btnCalendario.setBackground(new Color(100, 0, 140));
		btnCalendario.setBounds(946, 0, 121, 44);
		panel_1.add(btnCalendario);
		
		JButton btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMiPerfil.setForeground(new Color(255, 255, 255));
		btnMiPerfil.setBackground(new Color(100, 0, 140));
		btnMiPerfil.setBounds(1095, 0, 95, 44);
		panel_1.add(btnMiPerfil);
		
		JButton btnAtrs = new JButton("Inicio");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtrs.setForeground(Color.WHITE);
		btnAtrs.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAtrs.setBackground(new Color(100, 0, 140));
		btnAtrs.setBounds(705, 0, 95, 44);
		panel_1.add(btnAtrs);
		
		String fecha = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		JLabel lblFecha = new JLabel("07/04/22");
		lblFecha.setFont(new Font("Calibri", Font.BOLD, 33));
		lblFecha.setForeground(new Color(100, 0, 140));
		lblFecha.setBackground(new Color(255, 255, 255));
		lblFecha.setBounds(686, 99, 139, 46);
		mainPanel.add(lblFecha);
		
		String hora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		JLabel lblHora = new JLabel(hora);
		lblHora.setFont(new Font("Calibri", Font.BOLD, 30));
		lblHora.setForeground(new Color(100, 0, 140));
		lblHora.setBackground(new Color(255, 255, 255));
		lblHora.setBounds(696, 155, 108, 32);
		mainPanel.add(lblHora);
		
		JButton btnLunes = new JButton("LUNES");
		btnLunes.setBackground(new Color(248, 248, 255));
		btnLunes.setForeground(new Color(71, 0, 100));
		btnLunes.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes.setBounds(72, 222, 139, 133);
		mainPanel.add(btnLunes);
		
		JButton btnMartes = new JButton("MARTES");
		btnMartes.setBackground(new Color(248, 248, 255));
		btnMartes.setForeground(new Color(71, 0, 100));
		btnMartes.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMartes.setBounds(273, 222, 139, 133);
		mainPanel.add(btnMartes);
		
		JButton btnMiercoles = new JButton("MI\u00C9RCOLES");
		btnMiercoles.setBackground(new Color(248, 248, 255));
		btnMiercoles.setForeground(new Color(71, 0, 100));
		btnMiercoles.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMiercoles.setBounds(474, 222, 139, 133);
		mainPanel.add(btnMiercoles);
		
		JButton btnJueves = new JButton("JUEVES");
		btnJueves.setBackground(new Color(248, 248, 255));
		btnJueves.setForeground(new Color(71, 0, 100));
		btnJueves.setFont(new Font("Calibri", Font.BOLD, 16));
		btnJueves.setBounds(676, 222, 139, 133);
		mainPanel.add(btnJueves);
		
		JButton btnViernes = new JButton("VIERNES");
		btnViernes.setBackground(new Color(248, 248, 255));
		btnViernes.setForeground(new Color(71, 0, 100));
		btnViernes.setFont(new Font("Calibri", Font.BOLD, 16));
		btnViernes.setBounds(880, 222, 139, 133);
		mainPanel.add(btnViernes);
		
		JButton btnSabado = new JButton("S\u00C1BADO");
		btnSabado.setBackground(new Color(248, 248, 255));
		btnSabado.setForeground(new Color(71, 0, 100));
		btnSabado.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSabado.setBounds(1083, 222, 139, 133);
		mainPanel.add(btnSabado);
		
		JButton btnDomingo = new JButton("DOMINGO");
		btnDomingo.setBackground(new Color(248, 248, 255));
		btnDomingo.setForeground(new Color(71, 0, 100));
		btnDomingo.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDomingo.setBounds(1283, 222, 139, 133);
		mainPanel.add(btnDomingo);
		
		JLabel lblNewLabel = new JLabel("Pistas disponibles:  ");
		lblNewLabel.setForeground(new Color(100, 0, 140));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(1102, 149, 319, 44);
		mainPanel.add(lblNewLabel);
		
		JButton btnLunes_1 = new JButton("7:30 - 9:00");
		btnLunes_1.setForeground(new Color(71, 0, 100));
		btnLunes_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1.setBackground(new Color(248, 248, 255));
		btnLunes_1.setBounds(175, 452, 139, 32);
		mainPanel.add(btnLunes_1);
		
		JButton btnLunes_1_1 = new JButton("9:00 - 10:30");
		btnLunes_1_1.setForeground(new Color(71, 0, 100));
		btnLunes_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_1.setBackground(new Color(248, 248, 255));
		btnLunes_1_1.setBounds(175, 512, 139, 32);
		mainPanel.add(btnLunes_1_1);
		
		JButton btnLunes_1_2 = new JButton("10:30 - 12:00");
		btnLunes_1_2.setForeground(new Color(71, 0, 100));
		btnLunes_1_2.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_2.setBackground(new Color(248, 248, 255));
		btnLunes_1_2.setBounds(175, 577, 139, 32);
		mainPanel.add(btnLunes_1_2);
		
		JButton btnLunes_1_3 = new JButton("12:00 - 13:30");
		btnLunes_1_3.setForeground(new Color(71, 0, 100));
		btnLunes_1_3.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3.setBackground(new Color(248, 248, 255));
		btnLunes_1_3.setBounds(175, 641, 139, 32);
		mainPanel.add(btnLunes_1_3);
		
		JButton btnLunes_1_3_1 = new JButton("13:30 - 15:00");
		btnLunes_1_3_1.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1.setBounds(175, 708, 139, 32);
		mainPanel.add(btnLunes_1_3_1);
		
		JButton btnLunes_1_3_1_1 = new JButton("15:00 - 16:30");
		btnLunes_1_3_1_1.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_1.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_1.setBounds(376, 452, 139, 32);
		mainPanel.add(btnLunes_1_3_1_1);
		
		JButton btnLunes_1_3_1_2 = new JButton("16:30 - 18:00");
		btnLunes_1_3_1_2.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_2.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_2.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_2.setBounds(376, 512, 139, 32);
		mainPanel.add(btnLunes_1_3_1_2);
		
		JButton btnLunes_1_3_1_3 = new JButton("18:00 - 19:30");
		btnLunes_1_3_1_3.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_3.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_3.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_3.setBounds(376, 577, 139, 32);
		mainPanel.add(btnLunes_1_3_1_3);
		
		JButton btnLunes_1_3_1_4 = new JButton("19:30 - 21:00");
		btnLunes_1_3_1_4.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_4.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_4.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_4.setBounds(376, 641, 139, 32);
		mainPanel.add(btnLunes_1_3_1_4);
		
		JButton btnLunes_1_3_1_5 = new JButton("21:00 - 22:00");
		btnLunes_1_3_1_5.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_5.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_5.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_5.setBounds(376, 708, 139, 32);
		mainPanel.add(btnLunes_1_3_1_5);
		
		JButton btnLunes_1_4 = new JButton("7:30 - 9:00");
		btnLunes_1_4.setForeground(new Color(71, 0, 100));
		btnLunes_1_4.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_4.setBackground(new Color(248, 248, 255));
		btnLunes_1_4.setBounds(983, 452, 139, 32);
		mainPanel.add(btnLunes_1_4);
		
		JButton btnLunes_1_3_1_1_1 = new JButton("15:00 - 16:30");
		btnLunes_1_3_1_1_1.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_1_1.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_1_1.setBounds(1184, 452, 139, 32);
		mainPanel.add(btnLunes_1_3_1_1_1);
		
		JButton btnLunes_1_1_1 = new JButton("9:00 - 10:30");
		btnLunes_1_1_1.setForeground(new Color(71, 0, 100));
		btnLunes_1_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_1_1.setBackground(new Color(248, 248, 255));
		btnLunes_1_1_1.setBounds(983, 512, 139, 32);
		mainPanel.add(btnLunes_1_1_1);
		
		JButton btnLunes_1_3_1_2_1 = new JButton("16:30 - 18:00");
		btnLunes_1_3_1_2_1.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_2_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_2_1.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_2_1.setBounds(1184, 512, 139, 32);
		mainPanel.add(btnLunes_1_3_1_2_1);
		
		JButton btnLunes_1_2_1 = new JButton("10:30 - 12:00");
		btnLunes_1_2_1.setForeground(new Color(71, 0, 100));
		btnLunes_1_2_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_2_1.setBackground(new Color(248, 248, 255));
		btnLunes_1_2_1.setBounds(983, 577, 139, 32);
		mainPanel.add(btnLunes_1_2_1);
		
		JButton btnLunes_1_3_1_3_1 = new JButton("18:00 - 19:30");
		btnLunes_1_3_1_3_1.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_3_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_3_1.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_3_1.setBounds(1184, 577, 139, 32);
		mainPanel.add(btnLunes_1_3_1_3_1);
		
		JButton btnLunes_1_3_2 = new JButton("12:00 - 13:30");
		btnLunes_1_3_2.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_2.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_2.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_2.setBounds(983, 641, 139, 32);
		mainPanel.add(btnLunes_1_3_2);
		
		JButton btnLunes_1_3_1_4_1 = new JButton("19:30 - 21:00");
		btnLunes_1_3_1_4_1.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_4_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_4_1.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_4_1.setBounds(1184, 641, 139, 32);
		mainPanel.add(btnLunes_1_3_1_4_1);
		
		JButton btnLunes_1_3_1_6 = new JButton("13:30 - 15:00");
		btnLunes_1_3_1_6.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_6.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_6.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_6.setBounds(983, 708, 139, 32);
		mainPanel.add(btnLunes_1_3_1_6);
		
		JButton btnLunes_1_3_1_5_1 = new JButton("21:00 - 22:00");
		btnLunes_1_3_1_5_1.setForeground(new Color(71, 0, 100));
		btnLunes_1_3_1_5_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnLunes_1_3_1_5_1.setBackground(new Color(248, 248, 255));
		btnLunes_1_3_1_5_1.setBounds(1184, 708, 139, 32);
		mainPanel.add(btnLunes_1_3_1_5_1);
		
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
		
		JLabel lblTitulo = new JLabel("P\u00C1DEL");
		lblTitulo.setBounds(290, 93, 139, 56);
		mainPanel.add(lblTitulo);
		lblTitulo.setForeground(new Color(71, 0, 100));
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 45));
	}

	
}

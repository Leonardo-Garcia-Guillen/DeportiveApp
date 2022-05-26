package vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

import controlador.ChangeWindow;

public class InterfazPrincipal {
	
	
	private JFrame frame;
	public static ChangeWindow change = new ChangeWindow("");
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public InterfazPrincipal() {
		initialize();
	}
	
	/**
	 * @param statment 
	 * @param connect 
	 * @wbp.parser.entryPoint
	 */
	public void newPrincipalInterface() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPrincipal window = new InterfazPrincipal();
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
		cycoLabel.setBounds(10, 10, 186, 101);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/CYCO_LOGO.jpeg")).getImage().getScaledInstance(186, 101, Image.SCALE_DEFAULT));
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
		
		String help = "-¿Cómo puedo reservar un deporte?\r\n"
				+ "Para reservar un doporte, seleccione el deporte que desee y, a continuación, se le mostrarán los horarios disponibles\n\n"
				+ "-¿Puedo ver quién ha reservado a una determinada hora?\r\n"
				+ ""
				+ "-¿Cuántas reservas puedo hacer al día?\r\n"
				+ ""
				+ "Puede reservar un máximo de 2 periodos por día\n\n"
				+ "-¿Cómo se si una hora está completa?\r\n"
				+ "-¿Cómo veo mis reservas?\r\n"
				+ ""
				+ "-¿Cómo cancelo mis reservas?"
				+ "";
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAyuda.setForeground(new Color(255, 255, 255));
		btnAyuda.setBackground(new Color(100, 0, 140));
		btnAyuda.setBounds(902, 0, 95, 44);
		panel_1.add(btnAyuda);
		
		String contact = "Correo electrónico: cyco.sigesdep@gmail.com \n\nTeléfono de contacto: 662 62 62 62";
		
		JButton btnContacto = new JButton("Contacto");
		btnContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, contact, "Contacto", JOptionPane.WARNING_MESSAGE);
				
				
				
			}
		});
		btnContacto.setFont(new Font("Calibri", Font.BOLD, 16));
		btnContacto.setForeground(new Color(255, 255, 255));
		btnContacto.setBackground(new Color(100, 0, 140));
		btnContacto.setBounds(1007, 0, 95, 44);
		panel_1.add(btnContacto);
		
		JButton btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change.newWindowApp("miPerfil",frame);
			}
		});
		btnMiPerfil.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMiPerfil.setForeground(new Color(255, 255, 255));
		btnMiPerfil.setBackground(new Color(100, 0, 140));
		btnMiPerfil.setBounds(1112, 0, 95, 44);
		panel_1.add(btnMiPerfil);
		
		JLabel lblAGA = new JLabel("ACADEMIA GENERAL DEL AIRE");
		lblAGA.setBounds(10, 0, 658, 56);
		panel_1.add(lblAGA);
		lblAGA.setForeground(new Color(153, 0, 204));
		lblAGA.setFont(new Font("Calibri", Font.BOLD, 45));
		
		JButton btnAdmin = new JButton("Administrador");
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAdmin.setBackground(new Color(153, 51, 204));
		btnAdmin.setBounds(749, 0, 143, 44);
		panel_1.add(btnAdmin);
		
		String fecha = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		JLabel lblFecha = new JLabel("Fecha:   " + fecha);
		lblFecha.setFont(new Font("Calibri", Font.BOLD, 16));
		lblFecha.setForeground(new Color(102, 0, 153));
		lblFecha.setBackground(new Color(255, 255, 255));
		lblFecha.setBounds(1330, 63, 139, 25);
		mainPanel.add(lblFecha);
		
		String hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		JLabel lblHora = new JLabel(hora);
		lblHora.setFont(new Font("Calibri", Font.BOLD, 16));
		lblHora.setForeground(new Color(102, 0, 153));
		lblHora.setBackground(new Color(255, 255, 255));
		lblHora.setBounds(1384, 86, 85, 25);
		mainPanel.add(lblHora);
		
		JPanel panelDeportes = new JPanel();
		panelDeportes.setBorder(null);
		panelDeportes.setBackground(new Color(255, 255, 255));
		panelDeportes.setBounds(10, 121, 1489, 627);
		mainPanel.add(panelDeportes);
		
		JButton btnBaloncesto = new JButton("");
		btnBaloncesto.setBounds(1116, 46, 213, 137);
		ImageIcon imageBaloncesto = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/baloncesto.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		panelDeportes.setLayout(null);
		btnBaloncesto.setIcon(imageBaloncesto);
		panelDeportes.add(btnBaloncesto);
		
		JButton btnEsgrima = new JButton("");
		btnEsgrima.setBounds(1116, 246, 213, 137);
		ImageIcon imageEsgrima = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/esgrima.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnEsgrima.setIcon(imageEsgrima);
		panelDeportes.add(btnEsgrima);
		
		JButton btnAtletismo = new JButton("");
		btnAtletismo.setBounds(1116, 446, 213, 137);
		ImageIcon imageAtletismo = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/atletismo.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnAtletismo.setIcon(imageAtletismo);
		panelDeportes.add(btnAtletismo);
		
		JButton btnPiscina = new JButton("");
		btnPiscina.setBounds(794, 46, 213, 137);
		ImageIcon imagePiscina = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/natacion.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnPiscina.setIcon(imagePiscina);
		panelDeportes.add(btnPiscina);
		
		JButton btnTiro = new JButton("");
		btnTiro.setBounds(794, 246, 213, 137);
		ImageIcon imageTiro = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/tiro.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnTiro.setIcon(imageTiro);
		panelDeportes.add(btnTiro);
		
		JButton btnTenis = new JButton("");
		btnTenis.setBounds(472, 46, 213, 137);
		ImageIcon imageTenis = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/tenis.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnTenis.setIcon(imageTenis);
		panelDeportes.add(btnTenis);
		
		JButton btnPadel = new JButton("");
		btnPadel.setBounds(153, 46, 213, 137);
		btnPadel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change.newWindowApp("padel",frame);
			}
		});
		ImageIcon imagePadel = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/padel.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnPadel.setIcon(imagePadel);
		panelDeportes.add(btnPadel);
		
		JButton btnF7 = new JButton("");
		btnF7.setBounds(794, 446, 213, 137);
		ImageIcon imageFutbol7 = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/futbol7.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnF7.setIcon(imageFutbol7);
		panelDeportes.add(btnF7);
		
		JButton btnCrossfit = new JButton("");
		btnCrossfit.setBounds(472, 246, 213, 137);
		ImageIcon imageCrossfit = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/crossfit.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnCrossfit.setIcon(imageCrossfit);
		panelDeportes.add(btnCrossfit);
		
		JButton btnFSala = new JButton("");
		btnFSala.setBounds(472, 446, 213, 137);
		ImageIcon imageSala = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/futbol_sala.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnFSala.setIcon(imageSala);
		panelDeportes.add(btnFSala);
		
		JButton btnGimnasio = new JButton("");
		btnGimnasio.setBounds(153, 246, 213, 137);
		ImageIcon imageGimnasio = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/gimnasio.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnGimnasio.setIcon(imageGimnasio);
		panelDeportes.add(btnGimnasio);
		
		JButton btnVoley = new JButton("");
		btnVoley.setBounds(153, 446, 213, 137);
		ImageIcon imageVoley = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/voley.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnVoley.setIcon(imageVoley);
		panelDeportes.add(btnVoley);
		
		JLabel lblNewLabel = new JLabel("P\u00E1del");
		lblNewLabel.setForeground(new Color(102, 0, 153));
		lblNewLabel.setBounds(243, 193, 43, 20);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblNewLabel);
		
		JLabel lblTenis = new JLabel("Tenis");
		lblTenis.setForeground(new Color(102, 0, 153));
		lblTenis.setBounds(561, 195, 43, 20);
		lblTenis.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblTenis);
		
		JLabel lblNatacin = new JLabel("Nataci\u00F3n");
		lblNatacin.setForeground(new Color(102, 0, 153));
		lblNatacin.setBounds(877, 195, 74, 20);
		lblNatacin.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblNatacin);
		
		JLabel lblGimnasio = new JLabel("Gimnasio");
		lblGimnasio.setForeground(new Color(102, 0, 153));
		lblGimnasio.setBounds(231, 393, 74, 20);
		lblGimnasio.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblGimnasio);
		
		JLabel lblCrossfit = new JLabel("Crossfit");
		lblCrossfit.setForeground(new Color(102, 0, 153));
		lblCrossfit.setBounds(545, 395, 74, 20);
		lblCrossfit.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblCrossfit);
		
		JLabel lblTiroNeumtico = new JLabel("Tiro Neum\u00E1tico");
		lblTiroNeumtico.setForeground(new Color(102, 0, 153));
		lblTiroNeumtico.setBounds(849, 395, 116, 20);
		lblTiroNeumtico.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblTiroNeumtico);
		
		JLabel lblVolleyball = new JLabel("Voleybol");
		lblVolleyball.setForeground(new Color(102, 0, 153));
		lblVolleyball.setBounds(237, 593, 81, 20);
		lblVolleyball.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblVolleyball);
		
		JLabel lblFtbolSala = new JLabel("F\u00FAtbol sala");
		lblFtbolSala.setForeground(new Color(102, 0, 153));
		lblFtbolSala.setBounds(545, 593, 81, 20);
		lblFtbolSala.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblFtbolSala);
		
		JLabel lblFtbol = new JLabel("F\u00FAtbol");
		lblFtbol.setForeground(new Color(102, 0, 153));
		lblFtbol.setBounds(886, 593, 65, 20);
		lblFtbol.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblFtbol);
		
		JLabel lblAtletismo = new JLabel("Atletismo");
		lblAtletismo.setForeground(new Color(102, 0, 153));
		lblAtletismo.setBounds(1203, 595, 74, 20);
		lblAtletismo.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblAtletismo);
		
		JLabel lblEsgrima = new JLabel("Esgrima");
		lblEsgrima.setForeground(new Color(102, 0, 153));
		lblEsgrima.setBounds(1212, 395, 65, 20);
		lblEsgrima.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblEsgrima);
		
		JLabel lblBaloncesto = new JLabel("Baloncesto");
		lblBaloncesto.setForeground(new Color(102, 0, 153));
		lblBaloncesto.setBounds(1189, 193, 93, 20);
		lblBaloncesto.setFont(new Font("Calibri", Font.BOLD, 16));
		panelDeportes.add(lblBaloncesto);
		
		JLabel lblSistemaDeGestin = new JLabel("Sistema de Gesti\u00F3n de Deportes");
		lblSistemaDeGestin.setForeground(new Color(153, 0, 204));
		lblSistemaDeGestin.setFont(new Font("Calibri", Font.BOLD, 35));
		lblSistemaDeGestin.setBounds(216, 67, 658, 56);
		mainPanel.add(lblSistemaDeGestin);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}



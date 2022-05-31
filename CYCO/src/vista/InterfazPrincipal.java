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
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
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
import controlador.SportIsBlock;

public class InterfazPrincipal implements ActionListener{
	
	
	private JFrame frame;
	private JButton btnPadel;
	private JButton btnTenis;
	private JButton btnGimnasio;
	private JButton btnVoley;
	private JButton btnBaloncesto;
	private JButton btnCrossfit;
	private JButton btnTiro;
	private JButton btnEsgrima;
	private JButton btnF7;
	private JButton btnFSala;
	private JButton btnNatacion;
	private JButton btnAtletismo;
	
	
	public static ChangeWindow change = new ChangeWindow("");
	
	

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
		
		
		JButton btnCYCO = new JButton();
		btnCYCO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change.newWindowApp("principal", frame);
			}
		});
		btnCYCO.setBounds(10, 12, 186, 99);
		ImageIcon imageCyco = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/CYCO_LOGO.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		mainPanel.setLayout(null);
		btnCYCO.setIcon(imageCyco);
		mainPanel.add(btnCYCO);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(206, 10, 1293, 44);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", "Salir",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

				if (res == 0) {
					System.exit(0);
				}
			}
		});
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(71, 0, 100));
		btnNewButton.setBounds(1217, 0, 66, 44);
		panel_1.add(btnNewButton);
		
		String help = "-¿Cómo puedo reservar un deporte?\r\n"
				+ "  Para reservar un deporte, seleccione en la imagen del deporte que desee y, a continuación, se le mostrarán los horarios disponibles para \n\n"
				+ "-¿Puedo ver quién ha reservado a una determinada hora?\r\n"
				+ "  Al realizar una reserva, aparecen los nombres de los usuarios que ya hayan reservado en ese mismo horario\n\n"
				+ "-¿Cuántas reservas puedo hacer al día?\r\n"
				+ "  Puede reservar un máximo de 2 periodos por día\n\n"
				+ "-¿Cómo sé si una hora está completa?\r\n"
				+ "  Cada horario de reserva tiene un código de colores que nos indica el nivel de ocupación: \n  Verde: Totalmente desocupado\n  Naranja: Parcialmente ocupado\n  Rojo: Totalmente ocupado\n\n"
				+ "-¿Cómo veo mis reservas?\r\n"
				+ "  En la opción \"Mi Perfil\"\n\n"
				+ "-¿Cómo cancelo mis reservas?\n"
				+ "  En \"Mi perfil\" salen todas las reservas realizadas por el usuario y la opción de cancelar cada una de ellas";
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, help, "Preguntas frecuentes", JOptionPane.QUESTION_MESSAGE);
				
			}
		});
		btnAyuda.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAyuda.setForeground(new Color(255, 255, 255));
		btnAyuda.setBackground(new Color(100, 0, 140));
		btnAyuda.setBounds(902, 0, 95, 44);
		panel_1.add(btnAyuda);
		
		String contact = "Correo electrónico: cyco.sigesdep@gmail.com \n\nTeléfono de contacto: 662 62 62 62";
		
		JButton btnContacto = new JButton("Contacto");
		btnContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, contact, "Contacto", JOptionPane.WARNING_MESSAGE);
				ImageIcon icon = new ImageIcon(
						new ImageIcon(InterfazPrincipal.class.getResource("/images/tlf.png")).getImage()
								.getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JOptionPane.showMessageDialog(null, contact, "Contacto",
						JOptionPane.INFORMATION_MESSAGE, icon);
				
				
			}
		});
		btnContacto.setFont(new Font("Calibri", Font.BOLD, 16));
		btnContacto.setForeground(new Color(255, 255, 255));
		btnContacto.setBackground(new Color(100, 0, 140));
		btnContacto.setBounds(1007, 0, 95, 44);
		panel_1.add(btnContacto);
		
		JButton btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.addActionListener(this);
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
		btnAdmin.addActionListener(this);
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAdmin.setBackground(new Color(153, 51, 204));
		btnAdmin.setBounds(749, 0, 143, 44);
		panel_1.add(btnAdmin);
		
		String fecha = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		JLabel lblFecha = new JLabel("Fecha:   " + fecha);
		lblFecha.setFont(new Font("Calibri", Font.BOLD, 17));
		lblFecha.setForeground(new Color(102, 0, 153));
		lblFecha.setBackground(new Color(255, 255, 255));
		lblFecha.setBounds(1330, 75, 139, 25);
		mainPanel.add(lblFecha);
		
		String hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		JLabel lblHora = new JLabel(hora);
		lblHora.setFont(new Font("Calibri", Font.BOLD, 17));
		lblHora.setForeground(new Color(102, 0, 153));
		lblHora.setBackground(new Color(255, 255, 255));
		lblHora.setBounds(1384, 98, 85, 25);
		mainPanel.add(lblHora);
		
		JPanel panelDeportes = new JPanel();
		panelDeportes.setBorder(null);
		panelDeportes.setBackground(new Color(255, 255, 255));
		panelDeportes.setBounds(10, 121, 1489, 627);
		mainPanel.add(panelDeportes);
		
		btnBaloncesto = new JButton("");
		btnBaloncesto.setBounds(1116, 46, 213, 137);
		btnBaloncesto.addActionListener(this);
		ImageIcon imageBaloncesto = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/baloncesto.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		panelDeportes.setLayout(null);
		btnBaloncesto.setIcon(imageBaloncesto);
		panelDeportes.add(btnBaloncesto);
		
		btnEsgrima = new JButton("");
		btnEsgrima.setBounds(1116, 246, 213, 137);
		btnEsgrima.addActionListener(this);
		ImageIcon imageEsgrima = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/esgrima.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnEsgrima.setIcon(imageEsgrima);
		panelDeportes.add(btnEsgrima);
		
		btnAtletismo = new JButton("");
		btnAtletismo.setBounds(1116, 446, 213, 137);
		btnAtletismo.addActionListener(this);
		ImageIcon imageAtletismo = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/atletismo.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnAtletismo.setIcon(imageAtletismo);
		panelDeportes.add(btnAtletismo);
		
		btnNatacion = new JButton("");
		btnNatacion.setBounds(794, 46, 213, 137);
		btnNatacion.addActionListener(this);
		ImageIcon imagePiscina = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/natacion.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnNatacion.setIcon(imagePiscina);
		panelDeportes.add(btnNatacion);
		
		btnTiro = new JButton("");
		btnTiro.setBounds(794, 246, 213, 137);
		btnTiro.addActionListener(this);
		ImageIcon imageTiro = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/tiro.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnTiro.setIcon(imageTiro);
		panelDeportes.add(btnTiro);
		
		btnTenis = new JButton("");
		btnTenis.setBounds(472, 46, 213, 137);
		btnTenis.addActionListener(this);
		ImageIcon imageTenis = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/tenis.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnTenis.setIcon(imageTenis);
		panelDeportes.add(btnTenis);
		
		btnPadel = new JButton("");
		btnPadel.setBounds(153, 46, 213, 137);
		btnPadel.addActionListener(this);
		ImageIcon imagePadel = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/padel.jpg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnPadel.setIcon(imagePadel);
		panelDeportes.add(btnPadel);
		
		btnF7 = new JButton("");
		btnF7.setBounds(794, 446, 213, 137);
		btnF7.addActionListener(this);
		ImageIcon imageFutbol7 = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/futbol7.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnF7.setIcon(imageFutbol7);
		panelDeportes.add(btnF7);
		
		btnCrossfit = new JButton("");
		btnCrossfit.setBounds(472, 246, 213, 137);
		btnCrossfit.addActionListener(this);
		ImageIcon imageCrossfit = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/crossfit.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnCrossfit.setIcon(imageCrossfit);
		panelDeportes.add(btnCrossfit);
		
		btnFSala = new JButton("");
		btnFSala.setBounds(472, 446, 213, 137);
		btnFSala.addActionListener(this);
		ImageIcon imageSala = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/futbol_sala.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnFSala.setIcon(imageSala);
		panelDeportes.add(btnFSala);
		
		btnGimnasio = new JButton("");
		btnGimnasio.setBounds(153, 246, 213, 137);
		btnGimnasio.addActionListener(this);
		ImageIcon imageGimnasio = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/gimnasio.jpeg")).getImage().getScaledInstance(213,137,Image.SCALE_DEFAULT));
		btnGimnasio.setIcon(imageGimnasio);
		panelDeportes.add(btnGimnasio);
		
		btnVoley = new JButton("");
		btnVoley.setBounds(153, 446, 213, 137);
		btnVoley.addActionListener(this);
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

	private void askPassword() {
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
		    	change.newWindowApp("miPerfilAdministrador",frame);
		    } else {
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Administrador", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonText = ((AbstractButton) e.getSource()).getText();
		JButton btn = (JButton) e.getSource();
		
		int sport = 0;
		String nameBtn = "padel";
		
		
		System.out.println(buttonText);
		if (buttonText.equals("Mi perfil")) {
			change.newWindowApp("miPerfil", frame);
		}
		else if (buttonText.equals("Administrador")) {
			askPassword();
		}
		else { // La de algún deporte
			int disponible;
			
			if (btn == btnPadel) {
				sport = 0;
				nameBtn = "padel";
			}
			else if (btn == btnTenis) {
				sport = 1;
				nameBtn = "tenis";
			}
			else if (btn == btnNatacion) {
				sport = 2;
				nameBtn = "natacion";
			}
			else if (btn == btnBaloncesto) {
				sport = 3;
				nameBtn = "baloncesto";
			}
			else if (btn == btnGimnasio) {
				sport = 4;
				nameBtn = "gimnasio";
			}
			else if (btn == btnCrossfit) {
				sport = 5;
				nameBtn = "crossfit";
			}
			else if (btn == btnTiro) {
				sport = 6;
				nameBtn = "tiro";
			}
			else if (btn == btnEsgrima) {
				sport = 7;
				nameBtn = "esgrima";
			}
			else if (btn == btnVoley) {
				sport = 8;
				nameBtn = "voley";
			}
			else if (btn == btnFSala) {
				sport = 9;
				nameBtn = "fSala";
			}
			else if (btn == btnF7) {
				sport = 10;
				nameBtn = "f7";
			}
			else if (btn == btnAtletismo) {
				sport = 11;		
				nameBtn = "atletismo";
			}
			
			SportIsBlock lock = new SportIsBlock();
			disponible = lock.getDisponibility(sport);
			System.out.println(disponible);
			lockSport(btn,disponible,nameBtn);
			}		
	}
	
	public void lockSport(JButton btn, int disponible, String nameBtn) {
		if (disponible == 0) {
			btn.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Deporte inhabilitado, por favor, inténtelo más tarde\n o póngase en contacto con el Administrador", "¡ATENCIÓN!", JOptionPane.WARNING_MESSAGE);
		}
		else {
			btn.setEnabled(true);		
			change.newWindowApp(nameBtn, frame);
		}
		
			
	}
}



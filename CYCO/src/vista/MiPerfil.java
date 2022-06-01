package vista;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.SystemColor;
import javax.swing.UIManager;

import controlador.ChangeWindow;
import controlador.DecodifySport;
import controlador.DecodifySportCancelation;
import modelo.ConnectionBBDDJava;

import javax.swing.SwingConstants;

public class MiPerfil implements ActionListener {
	Connection conn;
	Statement stmt;
	private JFrame frame;
	private JPanel panelReservas;
	private String acronym = "lgargui"; // System.getProperty("user.name");
	private JButton[] btnBookingArray = new JButton[100];
	private JButton btnCancel;
	private JButton btnConfig;
	private String[] array = {};
	private String bookingToCancel;
	private String name, surname1, surname2, job;
	private JLabel lblNewUser;

	DefaultListModel<String> listModel;

	public static ChangeWindow change = new ChangeWindow("");

	// BBDD
	private static String conectionBBDD = "jdbc:mysql://192.168.50.27:3306/cy&co";
	private static String userBBDD = "Leo";
	private static String pswdBBDD = "CYCO";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MiPerfil() {
		initialize();
	}

	/**
	 * @param statment
	 * @param connect
	 * @wbp.parser.entryPoint
	 */
	public void newMiPerfil() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiPerfil window = new MiPerfil();
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

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(10, 0, 1526, 800);
		frame.getContentPane().add(mainPanel);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/CYCO_LOGO.jpeg"))
				.getImage().getScaledInstance(186, 101, Image.SCALE_DEFAULT));
		mainPanel.setLayout(null);

		JPanel panelSup = new JPanel();
		panelSup.setBackground(new Color(255, 255, 255));
		panelSup.setBounds(206, 10, 1293, 44);
		mainPanel.add(panelSup);
		panelSup.setLayout(null);

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
		panelSup.add(btnNewButton);

		String help = "-¿Cómo puedo reservar un deporte?\r\n"
				+ "  Para reservar un deporte, seleccione en la imagen del deporte que desee y, a continuación, se le mostrarán los horarios disponibles para cada día de la semana\n\n"
				+ "-¿Puedo ver quién ha reservado a una determinada hora?\r\n"
				+ "  Al realizar una reserva, aparecen los nombres de los usuarios que ya hayan reservado en ese mismo horario\n\n"
				+ "-¿Cuántas reservas puedo hacer al día?\r\n" + "  Puede reservar un máximo de 2 periodos por día\n\n"
				+ "-¿Cómo sé si una hora está completa?\r\n"
				+ "  Cada horario de reserva tiene un código de colores que nos indica el nivel de ocupación: \n  Verde: Totalmente desocupado\n  Naranja: Parcialmente ocupado\n  Rojo: Totalmente ocupado\n\n"
				+ "-¿Cómo veo mis reservas?\r\n" + "  En la opción \"Mi Perfil\"\n\n" + "-¿Cómo cancelo mis reservas?\n"
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
		panelSup.add(btnAyuda);

		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change.newWindowApp("principal", frame);
			}
		});
		btnInicio.setFont(new Font("Calibri", Font.BOLD, 16));
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setBackground(new Color(100, 0, 140));
		btnInicio.setBounds(797, 0, 95, 44);
		panelSup.add(btnInicio);

		String contact = "Correo electrónico: cyco.sigesdep@gmail.com \n\nTeléfono de contacto: 662 62 62 62";

		JButton btnContacto = new JButton("Contacto");
		btnContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, contact, "Contacto",
				// JOptionPane.WARNING_MESSAGE);
				ImageIcon icon = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/tlf.png"))
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JOptionPane.showMessageDialog(null, contact, "Contacto", JOptionPane.INFORMATION_MESSAGE, icon);

			}
		});
		btnContacto.setFont(new Font("Calibri", Font.BOLD, 16));
		btnContacto.setForeground(new Color(255, 255, 255));
		btnContacto.setBackground(new Color(100, 0, 140));
		btnContacto.setBounds(1007, 0, 95, 44);
		panelSup.add(btnContacto);

		JButton btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change.newWindowApp("miPerfil", frame);
			}
		});
		btnMiPerfil.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMiPerfil.setForeground(new Color(255, 255, 255));
		btnMiPerfil.setBackground(new Color(100, 0, 140));
		btnMiPerfil.setBounds(1112, 0, 95, 44);
		panelSup.add(btnMiPerfil);

		JLabel lblAGA = new JLabel("ACADEMIA GENERAL DEL AIRE");
		lblAGA.setBounds(10, 0, 658, 56);
		panelSup.add(lblAGA);
		lblAGA.setForeground(new Color(153, 0, 204));
		lblAGA.setFont(new Font("Calibri", Font.BOLD, 45));

		String fecha = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());

		String hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());

		panelReservas = new JPanel();
		// panelReservas.setBorder(null);
		panelReservas.setBackground(new Color(255, 255, 255));
		panelReservas.setBounds(300, 121, 950, 1000);
		mainPanel.add(panelReservas);
		panelReservas.setLayout(new FlowLayout());

		// Creo una lista de reservas
		JList<String> list = new JList<String>(array);
		list.setVisibleRowCount(20); // Muestra hasta 15 reservas
		list.setFont(new Font("Calibri", Font.BOLD, 22));

		listModel = new DefaultListModel<String>();

		// Busca reservas una a una 
		getBooking();

		// Modificamos el modelo de la lista para poder ir añadiendo más y más elementos
		list.setModel(listModel);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg) {
				bookingToCancel = list.getSelectedValue();
			}

		});
		panelReservas.add(list);

		// Crea un JScroll para buscar aquellas reservas que no caben en el panel
		JScrollPane scroll = new JScrollPane(list);
		panelReservas.add(scroll);

		JLabel lblSistemaDeGestin = new JLabel("Mi Perfil - Historial de reservas");
		lblSistemaDeGestin.setForeground(new Color(153, 0, 204));
		lblSistemaDeGestin.setFont(new Font("Calibri", Font.BOLD, 35));
		lblSistemaDeGestin.setBounds(216, 67, 658, 56);
		mainPanel.add(lblSistemaDeGestin);

		JButton btnCYCO = new JButton();
		btnCYCO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change.newWindowApp("principal", frame);
			}
		});
		btnCYCO.setBounds(10, 12, 186, 99);
		ImageIcon imageCyco = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/CYCO_LOGO.jpeg"))
				.getImage().getScaledInstance(213, 137, Image.SCALE_DEFAULT));
		mainPanel.setLayout(null);
		btnCYCO.setIcon(imageCyco);
		mainPanel.add(btnCYCO);

		// Botón para cancelar reserva
		btnCancel = new JButton();
		btnCancel.setBounds(1254, 357, 117, 71);
		btnCancel.addActionListener(this);
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCancel.setBorder(new LineBorder(Color.BLACK, 2));
		mainPanel.add(btnCancel);
		btnCancel.setText("<html>Cancelar <br/>reserva");

		JLabel lblFecha = new JLabel("Fecha: "+ fecha);
		lblFecha.setForeground(new Color(102, 0, 153));
		lblFecha.setFont(new Font("Calibri", Font.BOLD, 17));
		lblFecha.setBackground(Color.WHITE);
		lblFecha.setBounds(1328, 75, 139, 25);
		mainPanel.add(lblFecha);

		JLabel lblHora = new JLabel(hora);
		lblHora.setForeground(new Color(102, 0, 153));
		lblHora.setFont(new Font("Calibri", Font.BOLD, 17));
		lblHora.setBackground(Color.WHITE);
		lblHora.setBounds(1382, 98, 85, 25);
		mainPanel.add(lblHora);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(20, 121, 255, 152);
		mainPanel.add(panel);
		panel.setLayout(null);

		openConnectionBBDD();
		getUserData();
		String totalLockSports = "<html>Usuario: " + acronym + "<br/>Empleo: " + job + "<br/>Nombre: " + name
				+ "<br/>Primer Apellido: " + surname1 + "<br/>Segundo Apellido: " + surname2;

		lblNewUser = new JLabel();
		lblNewUser.setText(totalLockSports);
		lblNewUser.setVerticalAlignment(SwingConstants.TOP);
		lblNewUser.setBounds(10, 10, 235, 138);
		panel.add(lblNewUser);
		lblNewUser.setBackground(new Color(128, 0, 128));
		lblNewUser.setFont(new Font("Calibri", Font.BOLD, 18));

		btnConfig = new JButton();
		btnConfig.setText("<html>Configurar datos usuario");
		btnConfig.setFont(new Font("Calibri", Font.BOLD, 18));
		btnConfig.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnConfig.setBounds(20, 312, 255, 37);
		mainPanel.add(btnConfig);
		btnConfig.addActionListener(this);
	}

	private void getBooking() {
		int thisWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
		int thisWeekMinus30Days = thisWeek - 5;

		String booking = "";
		int i = 0;
		int j = 0;

		openConnectionBBDD();
		try {

			// Select statement
			String query = "SELECT * FROM reservas r JOIN deportes d ON d.id_deporte = r.id_deporte JOIN semana s ON s.dia=r.dia WHERE semana <="
					+ thisWeek + " AND semana >=" + thisWeekMinus30Days + " AND r.acrónimo='" + acronym
					+ "' ORDER BY r.semana,d.id_deporte,s.int_dia DESC";
			java.sql.Statement stmt = conn.createStatement();

			// Gets the result
			ResultSet rs = stmt.executeQuery(query);

			// Take the value
			while (rs.next()) {

				String nDeporte = rs.getString("nombre_deporte");
				String dia = rs.getString("dia");
				int pista = rs.getInt("pista");
				int plazas = rs.getInt("plazas");
				String hora = rs.getString("hora");
				int weekYear = rs.getInt("semana");

				booking = "Deporte: " + nDeporte + ". Nº semana: " + weekYear + ". Día: " + dia + ". Hora: " + hora
						+ ". Pista: " + pista + ". Nº plazas: " + plazas;
				listModel.addElement(booking);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void openConnectionBBDD() {
		/*// Abrir conexion con BD
		try {
			conn = (Connection) DriverManager.getConnection(conectionBBDD, userBBDD, pswdBBDD);
			System.out.println("¡¡ Conectado con la base Cy&Co !!");
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ConnectionBBDDJava connect = new ConnectionBBDDJava();
		conn = connect.getConn();
		stmt = connect.getStmt();

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// String button = ((AbstractButton) e.getSource()).getText();
		JButton btn = (JButton) e.getSource();

		if (btn == btnCancel) {
			if (bookingToCancel == null) {
				JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna reserva", "ERROR_MESSAGE",
						JOptionPane.ERROR_MESSAGE);

			} else {
				int res = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la reserva?", "Eliminar reserva",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

				if (res == 0) {
					// Abrir conexion con BD
					try {
						conn = (Connection) DriverManager.getConnection(conectionBBDD, userBBDD, pswdBBDD);
						System.out.println("¡¡ Conectado con la base Cy&Co !!");
						stmt = conn.createStatement();

					} catch (SQLException error) {
						// TODO Auto-generated catch block
						error.printStackTrace();
					}

					DecodifySportCancelation cancel = new DecodifySportCancelation(bookingToCancel);
					System.out.println(bookingToCancel);
					System.out.println(cancel.toString());
					String sport = cancel.getSport();
					int weekYear = cancel.getWeekYear();
					String day = cancel.getDay();
					String hour = cancel.getHour();
					int schedule = cancel.getSchedule();
					int users = cancel.getUsers();

					// Borrar fila seleccionada
					try {
						// Select statement
						String query = "DELETE r FROM reservas r JOIN deportes d ON d.id_deporte = r.id_deporte WHERE d.nombre_deporte='"
								+ sport + "' AND r.dia='" + day + "' AND r.pista=" + schedule + " AND r.hora='" + hour
								+ "'" + " AND r.semana='" + weekYear + "'" + " AND r.plazas='" + users
								+ "' AND r.acrónimo='" + acronym + "'";
						java.sql.Statement stmt = conn.createStatement();
						// Gets the result
						stmt.executeUpdate(query);

						change.newWindowApp("miPerfil", frame);
						System.out.println("eliminada la fila");

					} catch (Exception error) {
						error.printStackTrace();
					}

				} else
					System.out.println("Reserva cancelada");
			}

		} else if (btn == btnConfig) {
			getConfigPanel();
		}

	}

	// Muestra al usuario un panel para que introduzca sus datos personales
	private void getConfigPanel() {

		JPanel panelConfig = new JPanel();
		panelConfig.setLayout(new BoxLayout(panelConfig, BoxLayout.Y_AXIS));

		JLabel lblJob = new JLabel("Empleo:");
		JLabel lblName = new JLabel("Nombre:");
		JLabel lbl1Surname = new JLabel("Primer apellido:");
		JLabel lbl2Surname = new JLabel("Segundo apellido:");

		JTextField textJob = new JTextField();
		JTextField textName = new JTextField();
		JTextField text1Surname = new JTextField();
		JTextField text2Surname = new JTextField();

		panelConfig.add(lblJob);
		panelConfig.add(textJob);
		panelConfig.add(lblName);
		panelConfig.add(textName);
		panelConfig.add(lbl1Surname);
		panelConfig.add(text1Surname);
		panelConfig.add(lbl2Surname);
		panelConfig.add(text2Surname);

		String[] options = new String[] { "Guardar", "Cancel" };
		int option = JOptionPane.showOptionDialog(null, panelConfig, "Configuración de usuario", JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		System.out.println(option);

		if (option == 0) // pressing OK button
		{
			job = textJob.getText();
			name = textName.getText();
			surname1 = text1Surname.getText();
			surname2 = text2Surname.getText();

			openConnectionBBDD();
			updateUserConfig(job, name, surname1, surname2);
			resetLblNewUser();

		}

	}

	private void resetLblNewUser() {
		lblNewUser.removeAll();
		String totalLockSports = "<html>Usuario: " + acronym + "<br/>Empleo: " + job + "<br/>Nombre: " + name
				+ "<br/>Primer Apellido: " + surname1 + "<br/>Segundo Apellido: " + surname2;
		lblNewUser.setText(totalLockSports);
	}

	private void updateUserConfig(String job, String name, String surname1, String surname2) {
		try {
			String query = "UPDATE usuarios SET empleo='" + job + "', nombre='" + name + "', apellido_1='" + surname1
					+ "', apellido_2='" + surname2 + "' WHERE acrónimo='" + acronym + "'";

			stmt.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getUserData() {
		String query;
		try {
			// Inserts
			query = "SELECT * FROM usuarios WHERE acrónimo='" + acronym + "'";
			java.sql.Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				name = rs.getString("nombre");
				surname1 = rs.getString("apellido_1");
				surname2 = rs.getString("apellido_2");
				job = rs.getString("empleo");
			}
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import controlador.SportIsBlock;
import modelo.ConnectionBBDDJava;

import javax.swing.SwingConstants;

public class MiPerfilAdministrador implements ActionListener, ItemListener {
	Connection conn;
	Statement stmt;
	private JFrame frame;
	private JPanel panelReservas;
	private JPanel mainPanel;
	private JPanel panelUserData;
	private String acronym = System.getProperty("user.name");
	private String userSelected = "TODOS";
	private String sportSelected = "TODOS";
	private JButton[] btnBookingArray = new JButton[100];
	private String[] array = {};
	private String bookingToCancel;
	DefaultListModel<String> listModel;
	private JComboBox<String> listUsers;
	private JComboBox<String> listSports;
	private JLabel lblDeportesBloqueados;
	private String name, surname1, surname2, job;
	private JLabel lblNewUser;
	private JLabel lblUserData;

	public static ChangeWindow change = new ChangeWindow("");
	private JList<String> list;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MiPerfilAdministrador() {
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
					MiPerfilAdministrador window = new MiPerfilAdministrador();
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

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(10, 0, 1526, 800);
		frame.getContentPane().add(mainPanel);
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
		panelReservas.setBounds(272, 122, 928, 1499);
		mainPanel.add(panelReservas);
		panelReservas.setLayout(new FlowLayout());

		JLabel lblSistemaDeGestin = new JLabel("Administrador - Historial de reservas");
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
		JButton btn = new JButton();
		btn.addActionListener(this);
		btn.setBounds(1213, 436, 116, 99);
		btn.setFont(new Font("Calibri", Font.BOLD, 18));
		btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mainPanel.add(btn);
		btn.setText("<html>Cancelar <br/>reserva");

		JLabel lblFecha = new JLabel("Fecha: " + fecha);
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

		// PANELES LADO IZQ
		JPanel panelUsers = new JPanel();
		panelUsers.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panelUsers.setBackground(UIManager.getColor("Button.background"));
		panelUsers.setBounds(48, 121, 203, 293);
		mainPanel.add(panelUsers);
		panelUsers.setLayout(null);

		String totalUsers = "<html> Usuarios registrados <br/>" + getUsers();

		lblNewUser = new JLabel(totalUsers);
		lblNewUser.setVerticalAlignment(SwingConstants.TOP);
		lblNewUser.setBounds(8, 10, 174, 273);
		panelUsers.add(lblNewUser);
		lblNewUser.setBackground(new Color(128, 0, 128));
		lblNewUser.setFont(new Font("Calibri", Font.BOLD, 18));

		JPanel panelSportsLock = new JPanel();
		panelSportsLock.setLayout(null);
		panelSportsLock.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panelSportsLock.setBackground(SystemColor.menu);
		panelSportsLock.setBounds(48, 436, 203, 293);
		mainPanel.add(panelSportsLock);

		String totalLockSports = "<html> Deportes bloqueados <br/>" + getLockSports();

		lblDeportesBloqueados = new JLabel(totalLockSports);
		lblDeportesBloqueados.setVerticalAlignment(SwingConstants.TOP);
		lblDeportesBloqueados.setFont(new Font("Calibri", Font.BOLD, 18));
		lblDeportesBloqueados.setBackground(new Color(128, 0, 128));
		lblDeportesBloqueados.setBounds(8, 10, 174, 271);
		panelSportsLock.add(lblDeportesBloqueados);

		panelUserData = new JPanel();
		panelUserData.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panelUserData.setLayout(null);
		panelUserData.setBackground(SystemColor.control);
		panelUserData.setBounds(1213, 243, 274, 140);
		mainPanel.add(panelUserData);

		lblUserData = new JLabel();
		lblUserData.setVerticalAlignment(SwingConstants.TOP);
		lblUserData.setFont(new Font("Calibri", Font.BOLD, 18));
		lblUserData.setBackground(UIManager.getColor("Button.background"));
		lblUserData.setBounds(10, 10, 254, 120);
		panelUserData.add(lblUserData);

		// Crear lista de usuarios para seleccionar sus reservas
		getUserList();
		getSportsList();

		insertBookingList();

	}

	// --------------- ACCIÓN BOTÓN O LISTA -----------------
	@Override
	public void actionPerformed(ActionEvent e) {

		String button = ((AbstractButton) e.getSource()).getText();

		if (button.equals("Ver datos y reservas")) {
			getBooking(userSelected); // Muestra reservas del usuario seleccionado

			if (userSelected.equals("TODOS")) {
				lblUserData.removeAll();
				lblUserData.setText("");
			}
			else {
				getUserData(); // Muestra los datos personales del usuario seleccionado
				resetLblUserData();
			}

			// createBookingList(userSelected);
		} else if (button.equals("<html>Cancelar <br/>reserva")) {
			cancelBooking();
		} else if (button.equals("<html>Resetear <br/>reservas")) {
			resetBooking();
		} else if (button.equals("Bloquear")) {
			lockSport();
		} else if (button.equals("Desbloquear")) {
			unlockSport();
		}

	}

	// Lista de usuarios y deportes (usuario pincha en un nombre)
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == listUsers) {
			userSelected = (String) listUsers.getSelectedItem();
		} else if (e.getSource() == listSports) {
			sportSelected = (String) listSports.getSelectedItem();
			System.out.println(sportSelected);
		}

	}

	// --------------- FRAME -----------------
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	// --------------- LISTAS -----------------
	// Reservas
	private void insertBookingList() {
		// Creo una lista de reservas
		JList<String> list = new JList<String>(array);
		list.setVisibleRowCount(20);
		// Muestra hasta 15 reservas
		list.setFont(new Font("Calibri", Font.BOLD, 22));

		listModel = new DefaultListModel<String>();

		// Busca reservas una a una
		getBooking("TODOS");

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
	}

	// Usuarios
	private void getUserList() {
		listUsers = new JComboBox<String>();
		listUsers.setFont(new Font("Calibri", Font.BOLD, 18));
		listUsers.setBounds(1213, 163, 227, 30);
		mainPanel.add(listUsers);

		JLabel lblSelect = new JLabel("Seleccione usuario:");
		lblSelect.setFont(new Font("Calibri", Font.BOLD, 18));
		lblSelect.setBounds(1213, 133, 169, 20);
		mainPanel.add(lblSelect);

		JButton btnUserSelect = new JButton("Ver datos y reservas");
		btnUserSelect.setVerticalAlignment(SwingConstants.TOP);
		btnUserSelect.addActionListener(this);
		btnUserSelect.setFont(new Font("Calibri", Font.BOLD, 18));
		btnUserSelect.setBounds(1213, 203, 227, 30);
		mainPanel.add(btnUserSelect);

		JButton btnReset = new JButton();
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(230, 25, 30));
		btnReset.addActionListener(this);
		btnReset.setText("<html>Resetear <br/>reservas");
		btnReset.setFont(new Font("Calibri", Font.BOLD, 18));
		btnReset.setBorder(new LineBorder(Color.BLACK, 2));
		btnReset.setBounds(1371, 436, 116, 99);
		mainPanel.add(btnReset);

		// Lista usuarios
		listUsers.addItem("TODOS");

		openConnectionBBDD();

		// Hace la lista de usuarios (Select from BBDD)
		getListUsers();

	}

	// Deportes
	private void getSportsList() {
		listSports = new JComboBox<String>();
		listSports.setFont(new Font("Calibri", Font.BOLD, 18));
		listSports.setBounds(1213, 617, 227, 31);
		mainPanel.add(listSports);

		JLabel lblSelectionSport = new JLabel("Seleccione deporte: ");
		lblSelectionSport.setFont(new Font("Calibri", Font.BOLD, 18));
		lblSelectionSport.setBounds(1213, 587, 169, 20);
		mainPanel.add(lblSelectionSport);

		JButton btnLock = new JButton("Bloquear");
		btnLock.addActionListener(this);
		btnLock.setFont(new Font("Calibri", Font.BOLD, 18));
		btnLock.setBounds(1213, 657, 227, 31);
		mainPanel.add(btnLock);

		JButton btnUnlock = new JButton("Desbloquear");
		btnUnlock.addActionListener(this);
		btnUnlock.setFont(new Font("Calibri", Font.BOLD, 18));
		btnUnlock.setBounds(1213, 698, 227, 31);
		mainPanel.add(btnUnlock);

		openConnectionBBDD();

		listSports.addItem("TODOS");

		//openConnectionBBDD();

		// Hace la lista de deportes (Select from BBDD)
		getListSports();
	}

	// ---------------- SELECCIONAR DE BBDD -------------------
	// Abre conexión con la Base de Datos
	private void openConnectionBBDD() {
		/*try {
			conn = (Connection) DriverManager.getConnection(conectionBBDD, userBBDD, pswdBBDD);
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ConnectionBBDDJava connect = new ConnectionBBDDJava();
		conn = connect.getConn();
		stmt = connect.getStmt();

	}

	// Toma los datos personales del usuario especificado
	private void getUserData() {
		String query;

		try {
			// Inserts
			query = "SELECT * FROM usuarios WHERE acrónimo='" + userSelected + "'";
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

	private void getListUsers() {
		// Sentencia que se hace para conocer los nombres de los usuarios
		try {
			// Select statement
			String query = "SELECT acrónimo FROM usuarios";
			java.sql.Statement stmt = conn.createStatement();

			// Toma el resultado
			ResultSet rs = stmt.executeQuery(query);

			// Cogemos nombre por nombre con saltos de línea
			while (rs.next()) {
				listUsers.addItem(rs.getString(1));
			}

			// Cerramos el statement?
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		listUsers.addItemListener(this);

	}

	private void getListSports() {
		// Sentencia que se hace para conocer los nombres de los usuarios
		try {
			// Select statement
			String query = "SELECT nombre_deporte FROM deportes";
			java.sql.Statement stmt = conn.createStatement();

			// Toma el resultado
			ResultSet rs = stmt.executeQuery(query);

			// Cogemos nombre por nombre con saltos de línea
			while (rs.next()) {
				listSports.addItem(rs.getString(1));
			}

			// Cerramos el statement?
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		listSports.addItemListener(this);

	}

	// Busca todos los usuarios registrados y los muestra en fila
	private String getUsers() {
		// Permite hacer .setText() en un JLabel con salto de línea
		String user = "<html>";
		openConnectionBBDD();

		// Sentencia que se hace para conocer los nombres de los usuarios
		try {
			// Select statement
			String query = "SELECT acrónimo FROM usuarios";
			java.sql.Statement stmt = conn.createStatement();

			// Toma el resultado
			ResultSet rs = stmt.executeQuery(query);

			// Cogemos nombre por nombre con saltos de línea
			while (rs.next()) {
				user = user + "<br/>- " + rs.getString(1);
			}

			// Cerramos el statement?
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	private void resetLblDeportesBloqueados() {
		lblDeportesBloqueados.removeAll();
		String totalLockSports = "<html> Deportes bloqueados <br/>" + getLockSports();
		lblDeportesBloqueados.setText(totalLockSports);
	}

	private void resetLblUserData() {
		lblUserData.removeAll();
		String userData = "<html>Usuario: " + userSelected + "<br/>Empleo: " + job + "<br/>Nombre: " + name
				+ "<br/>Primer Apellido: " + surname1 + "<br/>Segundo Apellido: " + surname2;
		lblUserData.setText(userData);
	}

	private String getLockSports() {
		// Permite hacer .setText() en un JLabel con salto de línea
		String sport = "<html>";
		openConnectionBBDD();

		// Sentencia que se hace para conocer los nombres de los usuarios
		try {
			// statement
			String query = "SELECT nombre_deporte FROM deportes WHERE disponibilidad=0";
			java.sql.Statement stmt = conn.createStatement();

			// Toma el resultado
			ResultSet rs = stmt.executeQuery(query);

			// Cogemos nombre por nombre con saltos de línea
			while (rs.next()) {
				sport = sport + "<br/>- " + rs.getString(1);
			}

			// Cerramos el statement?
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sport;
	}

	// Coge las reservas y las muestra en el centro de la pantalla para un usuario
	// específico o para todos
	private void getBooking(String name) {
		int thisWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
		int thisWeekMinus30Days = thisWeek - 5;

		listModel.removeAllElements();

		String booking = "";
		String query = "";

		
		openConnectionBBDD();
		try {
			// Select statement
			if (name.equals("TODOS")) {
				query = "SELECT * FROM reservas r JOIN deportes d ON d.id_deporte = r.id_deporte JOIN semana s ON s.dia=r.dia ORDER BY r.semana DESC,s.int_dia DESC,d.id_deporte";
			} else {
				query = "SELECT * FROM reservas r JOIN deportes d ON d.id_deporte = r.id_deporte JOIN semana s ON s.dia=r.dia WHERE r.acrónimo='"
						+ name + "' ORDER BY r.semana DESC,s.int_dia DESC,d.id_deporte";
			}

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

	// --------------- BOTONES CANCELAR Y RESETEAR RESERVAS ---------------------
	// Cancelar
	public void cancelBooking() {
		System.out.println("Cancelar reserva");
		if (bookingToCancel == null) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna reserva", "ERROR_MESSAGE",
					JOptionPane.ERROR_MESSAGE);

		} else {
			int res = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la reserva?", "Eliminar reserva",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

			if (res == 0) {
				openConnectionBBDD();

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
							+ sport + "' AND r.dia='" + day + "' AND r.pista=" + schedule + " AND r.hora='" + hour + "'"
							+ " AND r.semana='" + weekYear + "'" + " AND r.plazas='" + users + "'";
					java.sql.Statement stmt = conn.createStatement();
					// Gets the result
					stmt.executeUpdate(query);

					change.newWindowApp("miPerfilAdministrador", frame);
					System.out.println("eliminada la fila");

				} catch (Exception error) {
					error.printStackTrace();
				}
			} else
				System.out.println("Reserva cancelada");
		}
	}

	// Resetear
	public void resetBooking() {
		System.out.println("Resetear reservas");

		int res = JOptionPane.showConfirmDialog(null,
				"Se van a eliminar TODAS las reservas para TODOS los usuarios.\n¿Está seguro que desea continuar?",
				"Resetear reservas", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

		if (res == 0) {
			// Borrar fila seleccionada
			try {
				// Select statement
				String query = "DELETE r FROM reservas r";
				java.sql.Statement stmt = conn.createStatement();
				// Gets the result
				stmt.executeUpdate(query);

				change.newWindowApp("miPerfilAdministrador", frame);
				System.out.println("eliminada la fila");

			} catch (Exception error) {
				error.printStackTrace();
			}
		}
	}

	// --------------- BLOQUEAR Y DESBLOQUEAR DEPORTES ----------------
	public void lockSport() {
		SportIsBlock disponible = new SportIsBlock();
		disponible.updateLock(sportSelected, 0);
		resetLblDeportesBloqueados();

		ImageIcon icon = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/candado cerrado.png"))
				.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		JLabel text = new JLabel("<html><center>Se ha BLOQUEADO cualquier entrada para el siguiente deporte:<br>"
				+ sportSelected.toUpperCase() + "<br>");
		text.setHorizontalAlignment(SwingConstants.CENTER);

		JOptionPane.showMessageDialog(null, text, "Deporte bloqueado", JOptionPane.INFORMATION_MESSAGE, icon);
	}

	public void unlockSport() {
		SportIsBlock disponible = new SportIsBlock();
		disponible.updateLock(sportSelected, 1);
		resetLblDeportesBloqueados();

		ImageIcon icon = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/candado abierto.png"))
				.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));

		JLabel text = new JLabel("<html><center>Se ha DESBLOQUEADO cualquier entrada para el siguiente deporte:<br>"
				+ sportSelected.toUpperCase() + "<br>");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		JOptionPane.showMessageDialog(null, text, "Deporte desbloqueado", JOptionPane.INFORMATION_MESSAGE, icon);
	}
}

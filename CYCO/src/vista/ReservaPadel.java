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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.ChangePanelHours;
import controlador.ChangeWindow;
import modelo.DayHourList;
import modelo.PadelBooking;
import modelo.WeekBtn;
import controlador.DecodifySport;
import controlador.JavaToBBDD;

import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ReservaPadel implements ActionListener {
	// STATIC
	PadelBooking padel = new PadelBooking();

	public static ChangeWindow change = new ChangeWindow("");
	public static ChangePanelHours panelHours = new ChangePanelHours();

	private final int sportNumber = 0;
	private final int totalDays = 7;
	private final int totalHours = padel.getTotalHours();
	private final int totalUsers = padel.getTotalUsers();
	private final int totalSchedules = padel.getTotalSchedules();

	private JPanel[] panelDaysArray = new JPanel[totalDays];
	private JButton[] btnDaysArray = new JButton[totalDays];
	private JButton[][][] btnHoursArray = new JButton[totalDays][totalSchedules][totalHours];
	private JRadioButton[] bookingRadioButtonArray = new JRadioButton[totalUsers];

	private JLabel lblUsersList;

	private DecodifySport decode;
	private ButtonGroup bookingGroup;
	private String text = "";

	private JFrame frame;
	private JPanel bookingPanel;
	private JPanel mainPanel;

	private int availableUsers = totalUsers;
	private int scheduleSelected = 0;
	private String lastHour = "";
	private String booking = "";
	private String lastHourSelected = "";

	// BBDD
	private static final String conectionBBDD = "jdbc:mysql://192.168.43.228:3306/cy&co";
	private static final String userBBDD = "Leo";
	private static final String pswdBBDD = "CYCO";
	Connection conn;
	Statement stmt;

	public ReservaPadel() {
		initialize();
	}

	/**
	 * @param statement
	 * @param connect
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
		mainPanel = new JPanel();
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

		// RESERVAS HORARIAS
		bookingGroup = new ButtonGroup(); // Donde guardaremos los bookingRadio
		bookingPanel = new JPanel();
		// bookingPanel.setBackground(new Color(255, 255, 255));
		bookingPanel.setBounds(627, 386, 290, 380);
		mainPanel.add(bookingPanel);
		bookingPanel.setLayout(null);
		bookingPanel.setVisible(false);
		getBookingRadioBtn();

		JLabel lblBooking = new JLabel("Indique cuántas plazas desea reservar");
		lblBooking.setBounds(17, 24, 300, 18);
		lblBooking.setForeground(new Color(0, 0, 0));
		lblBooking.setFont(new Font("Calibri", Font.BOLD, 16));
		bookingPanel.add(lblBooking);

		JButton btnBooking = new JButton();
		btnBooking.setText("Confirmar");
		btnBooking.addActionListener(this);
		// btnBooking.setBackground(new Color(255, 255, 255));
		btnBooking.setFont(new Font("Calibri", Font.BOLD, 18));
		btnBooking.setBorder(new LineBorder(Color.BLACK, 2));
		btnBooking.setBounds(138, 128, 117, 71);
		bookingPanel.add(btnBooking);

		lblUsersList = new JLabel();
		lblUsersList.setFont(new Font("Calibri", Font.BOLD, 16));
		lblUsersList.setText("");
		lblUsersList.setBounds(86, 250, 113, 100);
		bookingPanel.add(lblUsersList);

		// --------- PANELES HORARIOS SEMANALES ---------
		getWeekPanels(mainPanel);

		// --------- DIAS SEMANA ----------
		getDayBtns(mainPanel);

		// ---------- HORARIOS ----------
		getHourBtns();

		// ---------- COLORES ASIGNACION PLAZAS -----------
		getColorHourBtns();

		// ---------- PANEL SUPERIOR ----------
		JPanel panelSup = new JPanel();
		panelSup.setBackground(new Color(255, 255, 255));
		panelSup.setBounds(206, 10, 1275, 44);
		mainPanel.add(panelSup);
		panelSup.setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", "Salir",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

				if (res == 0) {
					System.exit(0);
				}
			}
		});

		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(71, 0, 100));
		btnSalir.setBounds(1199, 0, 66, 44);
		panelSup.add(btnSalir);

		JButton btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change.newWindowApp("miPerfil", frame);
			}
		});
		btnMiPerfil.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMiPerfil.setForeground(new Color(255, 255, 255));
		btnMiPerfil.setBackground(new Color(100, 0, 140));
		btnMiPerfil.setBounds(1094, 0, 95, 44);
		panelSup.add(btnMiPerfil);

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
		btnAyuda.setBounds(884, 0, 95, 44);
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
		btnInicio.setBounds(779, 0, 95, 44);
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
		btnContacto.setBounds(989, 0, 95, 44);
		panelSup.add(btnContacto);

		// ---------- FECHA Y HORA ----------
		String fecha = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		JLabel lblFecha = new JLabel(fecha);
		lblFecha.setFont(new Font("Calibri", Font.BOLD, 33));
		lblFecha.setForeground(new Color(100, 0, 140));
		lblFecha.setBackground(new Color(255, 255, 255));
		lblFecha.setBounds(693, 99, 139, 46);
		mainPanel.add(lblFecha);

		String hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		JLabel lblHora = new JLabel(hora);
		lblHora.setFont(new Font("Calibri", Font.BOLD, 30));
		lblHora.setForeground(new Color(100, 0, 140));
		lblHora.setBackground(new Color(255, 255, 255));
		lblHora.setBounds(724, 155, 77, 32);
		mainPanel.add(lblHora);

		// ---------- PISTAS DISPONIBLES ---------

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

		// Ayudas de colores
		JLabel lblHelpGreen = new JLabel("Borde verde: pista libre");
		lblHelpGreen.setBounds(1132, 81, 313, 32);
		lblHelpGreen.setForeground(new Color(71, 0, 100));
		lblHelpGreen.setFont(new Font("Calibri", Font.BOLD, 17));
		mainPanel.add(lblHelpGreen);

		JLabel lblHelpRed = new JLabel("Borde rojo: pista totalmente ocupada");
		lblHelpRed.setBounds(1132, 165, 313, 30);
		lblHelpRed.setForeground(new Color(71, 0, 100));
		lblHelpRed.setFont(new Font("Calibri", Font.BOLD, 17));
		mainPanel.add(lblHelpRed);

		JLabel lblHelpOrange = new JLabel("Borde naranja: pista parcialmente ocupada");
		lblHelpOrange.setBounds(1132, 123, 313, 32);
		lblHelpOrange.setForeground(new Color(71, 0, 100));
		lblHelpOrange.setFont(new Font("Calibri", Font.BOLD, 17));
		mainPanel.add(lblHelpOrange);

		JLabel lblGreen = new JLabel("");
		lblGreen.setForeground(new Color(71, 0, 100));
		lblGreen.setFont(new Font("Calibri", Font.BOLD, 17));
		lblGreen.setBorder(new LineBorder(new Color(50, 205, 50), 3));
		lblGreen.setBounds(1090, 81, 32, 32);
		mainPanel.add(lblGreen);

		JLabel lblOrange = new JLabel("");
		lblOrange.setForeground(new Color(71, 0, 100));
		lblOrange.setFont(new Font("Calibri", Font.BOLD, 17));
		lblOrange.setBorder(new LineBorder(Color.ORANGE, 3));
		lblOrange.setBounds(1090, 123, 32, 32);
		mainPanel.add(lblOrange);

		JLabel lblRed = new JLabel("");
		lblRed.setForeground(new Color(71, 0, 100));
		lblRed.setFont(new Font("Calibri", Font.BOLD, 17));
		lblRed.setBorder(new LineBorder(Color.RED, 3));
		lblRed.setBounds(1090, 163, 32, 32);
		mainPanel.add(lblRed);

	}

	// ------------- CREATE BUTTONS & PANELS -------------
	private void getHourBtns() {
		int cont = 0;
		int x = 0;
		int y = 0;
		int weekYear;

		for (int day = 0; day < 7; day++) {
			weekYear = padel.getPadelWeek().getDayBtn(day).getWeekYear();
			for (int schedule = 0; schedule < totalSchedules; schedule++) {
				for (int hour = 0; hour < totalHours; hour++) {
					btnHoursArray[day][schedule][hour] = new JButton(padel.getPadelWeek().getDayBtn(day).getSchedules()
							.get(schedule).getSchedule().get(hour).getHourStr());
					// Nombre: 0 (padel) + nº de la semana respecto del año + dia + pista + hora
					btnHoursArray[day][schedule][hour].setName(sportNumber + "-" + weekYear + "-" + day + "-" + schedule
							+ "-" + btnHoursArray[day][schedule][hour].getText());
					btnHoursArray[day][schedule][hour].addActionListener(this);
					panelDaysArray[day].add(btnHoursArray[day][schedule][hour]);
					btnHoursArray[day][schedule][hour].setForeground(new Color(71, 0, 100));
					btnHoursArray[day][schedule][hour].setFont(new Font("Calibri", Font.BOLD, 16));
					btnHoursArray[day][schedule][hour].setBackground(new Color(248, 248, 255));
					// btnHoursArray[day][schedule][hour].setBorder(new LineBorder(Color.RED));
					// btnHoursArray[hour].setVisible(false);

					if (y >= 5) {
						y = 0;
						x = 1;
					}

					btnHoursArray[day][schedule][hour].setBounds((106 + x * 201) + (schedule * 808), 10 + y * 64, 139,
							32);
					y++;

					cont++;
				}

				x = 0;
				y = 0;
			}
		}
	}

	// Crea los JRadioButton: botones circulares para selección del número de plazas
	private void getBookingRadioBtn() {

		for (int i = 0; i < totalUsers; i++) {
			int j = i + 1;
			bookingRadioButtonArray[i] = new JRadioButton();
			bookingRadioButtonArray[i].setText("" + j);
			bookingRadioButtonArray[i].setBounds(45, 75 + i * 50, 50, 21);
			// bookingRadioButtonArray[i].setColor(new Color(255,255,255));
			bookingRadioButtonArray[i].setFont(new Font("Calibri", Font.BOLD, 16));
			bookingPanel.add(bookingRadioButtonArray[i]);
			bookingGroup.add(bookingRadioButtonArray[i]);
			bookingRadioButtonArray[i].setLayout(null);
			bookingRadioButtonArray[i].setVisible(true);

		}
	}

	private void getWeekPanels(JPanel panel) {
		for (int i = 0; i < totalDays; i++) {
			panelDaysArray[i] = new JPanel();
			panelDaysArray[i].setBackground(new Color(255, 255, 255));
			panelDaysArray[i].setBounds(72, 452, 1350, 309);
			panel.add(panelDaysArray[i]);
			panelDaysArray[i].setLayout(null);
			panelDaysArray[i].setVisible(false);
		}
	}

	private void getDayBtns(JPanel panel) {
		for (int i = 0; i < totalDays; i++) {

			btnDaysArray[i] = new JButton();
			btnDaysArray[i].setText(padel.getPadelWeek().getDayBtn(i).getDayName().toUpperCase());
			btnDaysArray[i].addActionListener(this);
			btnDaysArray[i].setBackground(new Color(248, 248, 255));
			btnDaysArray[i].setForeground(new Color(71, 0, 100));
			btnDaysArray[i].setFont(new Font("Calibri", Font.BOLD, 16));
			btnDaysArray[i].setBounds(72 + i * 203, 222, 139, 133);
			panel.add(btnDaysArray[i]);
		}

	}

	// ---------- CHANGE COLORS -----------

	private void changeBtnColor(ActionEvent e) {
		((JComponent) e.getSource()).setBackground(new Color(220, 220, 220));

	}

	private void changeHourColor(JButton btn, int availableUsers) {

		if (availableUsers == totalUsers) {
			btn.setBorder(new LineBorder(new Color(50, 205, 50), 3));
		} else if (availableUsers == 0) {
			btn.setBorder(new LineBorder(Color.RED, 3));
		} else {
			btn.setBorder(new LineBorder(Color.ORANGE, 3));
		}
	}

	private void getColorHourBtns() {
		String decodification;
		int weekYear;

		for (int day = 0; day < 7; day++) {
			weekYear = padel.getPadelWeek().getDayBtn(day).getWeekYear();
			// System.out.println(weekYear);
			for (int schedule = 0; schedule < totalSchedules; schedule++) {
				for (int hour = 0; hour < totalHours; hour++) {
					decodification = sportNumber + "-" + weekYear + "-" + day + "-" + schedule + "-"
							+ btnHoursArray[day][schedule][hour].getText();
					DecodifySport decodeColor = new DecodifySport(decodification, 0);
					// System.out.println(decodeColor.toString());
					changeHourColor(btnHoursArray[day][schedule][hour], getAvailableUsers(sportNumber,
							decodeColor.getDay(), schedule + 1, decodeColor.getHour(), weekYear));
				}
			}
		}
	}

	// ------------ RESET BTNS ------------

	private void resetHourBtns() {
		for (int day = 0; day < 7; day++)
			for (int schedule = 0; schedule < totalSchedules; schedule++)
				for (int hour = 0; hour < totalHours; hour++)
					btnHoursArray[day][schedule][hour].setBackground(new Color(248, 248, 255));

	}

	private void resetDayBtns() {
		for (int i = 0; i < totalDays; i++) {
			btnDaysArray[i].setBackground(new Color(248, 248, 255));
		}

	}

	// ------------ BOOKING --------------
	// Estudiamos el caso en que se pulsa un botón horario
	private void evaluateHourBtn(AbstractButton source) {
		// Visibilizamos el panel con los botones respectivos
		bookingPanel.setVisible(true);
		booking = source.getName(); // Tomamos el nombre del botón codificado

		// Decodificamos el nombre y tomamos cada valor por separado
		decode = new DecodifySport(booking, 0);
		int sport = decode.getSport();
		int weekYear = decode.getWeekYear();
		String day = decode.getDay();
		int schedule = decode.getSchedule();
		String hour = decode.getHour();

		// Muestra los usuarios que han reservado a esa hora
		lblUsersList.setText("<html>Reservada por:" + getUsers(sport, day, schedule, hour, weekYear));

		// Estudia si hay alguna plaza para reservar a esa hora
		availableUsers = getAvailableUsers(sport, day, schedule, hour, weekYear);
		
		// Si hay alguna reserva, muestra las personas que la han reservado y su(s) comentario(s)
		
		if (availableUsers == totalUsers)
			lblUsersList.setVisible(false);
		else {
			lblUsersList.setVisible(true);
			
			// Muestra comentarios del usuario si los hay
			showUserComments(sport, day, schedule, hour, weekYear);
		}
			
		
		

		// Guardamos la última hora y la pista seleccionadas
		scheduleSelected = decode.getSchedule();
		lastHour = decode.getHour();

	}

	// ------------- LLAMADAS A LA BASE DE DATOS -------------
	// Abre conexión con la Base de Datos
	private void openConnectionBBDD() {
		try {
			conn = (Connection) DriverManager.getConnection(conectionBBDD, userBBDD, pswdBBDD);
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Muestra los usuarios que han reservado en un deporte, un día a una hora
	// específicas
	private String getUsers(int sport, String day, int schedule, String hour, int weekYear) {
		// Permite hacer .setText() en un JLabel con salto de línea
		String user = "<html>";

		openConnectionBBDD();

		// Sentencia que se hace para conocer los nombres de los usuarios
		try {
			// Select statement
			String query = "SELECT acrónimo FROM reservas WHERE id_deporte=" + sport + " AND dia='" + day
					+ "' AND pista=" + schedule + " AND hora='" + hour + "'" + " AND semana=" + weekYear;
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

	// Estudia si queda alguna plaza disponible a una hora específica
	private int getAvailableUsers(int sport, String day, int schedule, String hour, int weekYear) {

		// Abrimos conexión con la BBDD
		openConnectionBBDD();

		// Contar cuantas reservas hay en un deporte a una hora específica
		int hoursCounter = 0;
		int aux = 0;
		try {
			// Select statement
			String query = "SELECT plazas FROM reservas WHERE id_deporte=" + sport + " AND dia='" + day + "' AND pista="
					+ schedule + " AND hora='" + hour + "'" + " AND semana=" + weekYear;
			java.sql.Statement stmt = conn.createStatement();

			// Gets the result
			ResultSet rs = stmt.executeQuery(query);

			// Take the value
			while (rs.next()) {
				aux = aux + rs.getInt(1);

			}
			hoursCounter = aux;

			// stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		hoursCounter = totalUsers - hoursCounter;

		return hoursCounter;
	}

	private String getUserComment(int sport, String day, int schedule, String hour, int weekYear) {
		String com = "";
		String acronym = "";
		String aux;
		// Abrimos conexión con la BBDD
		openConnectionBBDD();

		// Busca el comentario que haya en una hora específica

		try {
			// Select statement
			String query = "SELECT acrónimo FROM reservas WHERE id_deporte=" + sport + " AND dia='" + day
					+ "' AND pista=" + schedule + " AND hora='" + hour + "'" + " AND semana=" + weekYear;
			java.sql.Statement stmt = conn.createStatement();

			// Gets the result
			ResultSet rs = stmt.executeQuery(query);

			// Take the value
			while (rs.next()) {
				// Para cada usuario, mostrar su comentario
				acronym = rs.getString(1);
				System.out.println(acronym);
				String query2 = "SELECT comentario FROM reservas WHERE acrónimo='" + acronym + "' AND id_deporte="
						+ sport + " AND dia='" + day + "' AND pista=" + schedule + " AND hora='" + hour + "'"
						+ " AND semana=" + weekYear;
				java.sql.Statement stmt2 = conn.createStatement();

				// Gets the result
				ResultSet rs2 = stmt2.executeQuery(query2);

				// Take the value
				aux = "";
				while (rs2.next()) {
					aux = aux + rs2.getString(1);
				}

				if (aux == null || aux.equals("") || aux.equals(" ") || aux.equals("  ") || aux.equals("   ")
						|| aux.equals(null) || aux.equals("null") || aux.equals("nullnull")) {
					//System.out.println("comentario vacío");
				} else {
					com = com + "\n" + acronym + ": " + aux;
				}
				acronym = "";
				

			}

			// stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return com;
	}

	// ------------ ACTION PERFORMANCE ------------
	// Se pulsa un botón: Acción
	@Override
	public void actionPerformed(ActionEvent e) {
		String textDialog = "";
		int users = 0;

		// Tomamos el valor de ese botón
		String button = ((AbstractButton) e.getSource()).getText();

		// Evaluamos el texto del botón si es un día de la semana, un botón horario o
		// confirmamos reserva
		if (button.equals("LUNES") || button.equals("MARTES") || button.equals("MIERCOLES") || button.equals("JUEVES")
				|| button.equals("VIERNES") || button.equals("SABADO") || button.equals("DOMINGO")) {
			// Pongo el resto del color estandar, y el botón pulsado en otro color
			resetDayBtns();
			changeBtnColor(e);

			// Muestro las horas del dia pulsado
			text = button;
			panelHours.newPanelHours(button, panelDaysArray);

		} else if (button.equals("Confirmar")) {
			// Muestra la reserva que el usuario ha realizado

			for (int i = 0; i < totalUsers; i++) {

				if (bookingRadioButtonArray[i].isSelected()) {
					users = i + 1;
					textDialog = "" + users;
				}
			}

			// Si hay confirmación sin asignación de plazas
			if (users == 0) {
				if (availableUsers == totalUsers)
					JOptionPane.showMessageDialog(null, "Ninguna plaza ha sido seleccionada", "Ups!",
							JOptionPane.WARNING_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "No hay más plazas disponibles", "Ups!",
							JOptionPane.WARNING_MESSAGE);
			} else {
				// Muestra al usuario los datos de la reserva
				textDialog = "¿Desea hacer la siguiente reserva?\n\nPlazas: " + textDialog + "\nPista: "
						+ scheduleSelected + "\nDía: " + text + "\nHora: " + lastHour
						+ "\n\nAñada un comentario si lo desea: ";

				ImageIcon icon = new ImageIcon(
						new ImageIcon(InterfazPrincipal.class.getResource("/images/nueva reserva.png")).getImage()
								.getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				String userComment = (String) JOptionPane.showInputDialog(null, textDialog, "Datos de la reserva",
						JOptionPane.INFORMATION_MESSAGE, icon, null, null);

				if (userComment.equals(null))
					System.out.println("Reserva cancelada");
				else {
					// Se envía la inforación de la reserva
					decode = new DecodifySport(booking, users);
					decode.sendBBDD(decode.toString(), totalUsers, userComment);

					change.newWindowApp("miPerfil", frame);
				}

			}

		} else {
			// Cualquier botón horario ha sido pulsado: se resalta el color de ese botón
			resetHourBtns();
			changeBtnColor(e);

			// Se toma el nombre de dicho botón
			lastHourSelected = ((AbstractButton) e.getSource()).getName();

			// Evaluamos las opciones del botón pulsado
			evaluateHourBtn(((AbstractButton) e.getSource()));

			// Mostramos tantas opciones de reservas como plazas queden disponibles
			bookingGroup.clearSelection();
			for (int i = 0; i < totalUsers; i++) {
				if (i >= availableUsers)
					bookingRadioButtonArray[i].setEnabled(false);
				else
					bookingRadioButtonArray[i].setEnabled(true);
			}
		}

	}

	private void showUserComments(int sport, String day, int schedule, String hour, int weekYear) {
		// Si hay alguna reserva realizada, muestra si hay algún comentario de algún
		// usuario
		String userHourComment = "";

		if (availableUsers != totalUsers) {
			// Vemos si hay algún comentario en esa hora
			userHourComment = getUserComment(sport, day, schedule, hour, weekYear);
			//System.out.println("Veamos: " + userHourComment);
			if (userHourComment.equals("") || userHourComment.equals(" ") || userHourComment.equals("  ")
					|| userHourComment.equals("   ") || userHourComment == null) { // Comentario vacío no mostrarlo
				System.out.println("No comentarios");
			} else { // Muestro el comentario
				ImageIcon icon = new ImageIcon(
						new ImageIcon(InterfazPrincipal.class.getResource("/images/comentario.png")).getImage()
								.getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JOptionPane.showMessageDialog(null, userHourComment, "Nuevo comentario",
						JOptionPane.INFORMATION_MESSAGE, icon);
			}
		}

	}
}

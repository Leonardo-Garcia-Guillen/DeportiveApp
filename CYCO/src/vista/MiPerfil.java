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

public class MiPerfil implements ActionListener {
	Connection conn;
	Statement stmt;
	private JFrame frame;
	private JPanel panelReservas;
	private String acronym = System.getProperty("user.name");
	private JButton[] btnBookingArray = new JButton[100];
	private String[] array = {};
	private String bookingToCancel;
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

		JLabel cycoLabel = new JLabel("");
		cycoLabel.setBounds(10, 10, 186, 101);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(InterfazPrincipal.class.getResource("/images/CYCO_LOGO.jpeg"))
				.getImage().getScaledInstance(186, 101, Image.SCALE_DEFAULT));
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
		btnNewButton.setBackground(new Color(153, 51, 204));
		btnNewButton.setBounds(1217, 0, 66, 44);
		panel_1.add(btnNewButton);

		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAyuda.setForeground(new Color(255, 255, 255));
		btnAyuda.setBackground(new Color(153, 51, 204));
		btnAyuda.setBounds(981, 0, 95, 44);
		panel_1.add(btnAyuda);

		JButton btnContacto = new JButton("Contacto");
		btnContacto.setFont(new Font("Calibri", Font.BOLD, 16));
		btnContacto.setForeground(new Color(255, 255, 255));
		btnContacto.setBackground(new Color(153, 51, 204));
		btnContacto.setBounds(1099, 0, 95, 44);
		panel_1.add(btnContacto);

		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change.newWindowApp("principal", frame);
			}
		});
		btnInicio.setFont(new Font("Calibri", Font.BOLD, 16));
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setBackground(new Color(71, 0, 100));
		btnInicio.setBounds(865, 0, 95, 44);
		panel_1.add(btnInicio);

		JLabel lblAGA = new JLabel("ACADEMIA GENERAL DEL AIRE");
		lblAGA.setBounds(10, 0, 658, 56);
		panel_1.add(lblAGA);
		lblAGA.setForeground(new Color(153, 0, 204));
		lblAGA.setFont(new Font("Calibri", Font.BOLD, 45));

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

		panelReservas = new JPanel();
		// panelReservas.setBorder(null);
		// panelReservas.setBackground(new Color(255, 255, 255));
		panelReservas.setBounds(159, 121, 1500, 1000);
		mainPanel.add(panelReservas);
		panelReservas.setLayout(new FlowLayout()); // Una debajo de otra
		JLabel lblReservasRealizadas = new JLabel("Reservas realizadas:");
		lblReservasRealizadas.setFont(new Font("Calibri", Font.BOLD, 16));
		lblReservasRealizadas.setBounds(10, 10, 864, 26);
		panelReservas.add(lblReservasRealizadas);

		// Creo una lista de reservas
		JList<String> list = new JList<String>(array);
		list.setVisibleRowCount(6); // Muestra hasta 15 reservas
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

		// Botón para cancelar reserva
		JButton btn = new JButton();
		btn.setText("Cancelar reserva");
		btn.addActionListener(this);
		panelReservas.add(btn);

		JLabel lblSistemaDeGestin = new JLabel("Mi Perfil");
		lblSistemaDeGestin.setForeground(new Color(153, 0, 204));
		lblSistemaDeGestin.setFont(new Font("Calibri", Font.BOLD, 35));
		lblSistemaDeGestin.setBounds(216, 67, 658, 56);
		mainPanel.add(lblSistemaDeGestin);

		JLabel lblNewUser = new JLabel("<html>Nombre usuario: <br/>" + acronym);
		lblNewUser.setBounds(10, 133, 118, 40);
		mainPanel.add(lblNewUser);
		lblNewUser.setFont(new Font("Calibri", Font.BOLD, 16));
	}

	private void getBooking() {
		int thisWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
		int thisWeekMinus30Days = thisWeek - 5;
		
		String booking = "";
		int i = 0;
		int j = 0;

		// Abrir conexion con BD
		try {
			conn = (Connection) DriverManager.getConnection(conectionBBDD, userBBDD, pswdBBDD);
			System.out.println("¡¡ Conectado con la base Cy&Co !!");
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// Select statement
			String query = "SELECT * FROM reservas r JOIN deportes d ON d.id_deporte = r.id_deporte WHERE r.acrónimo='"
					+ acronym + "' AND semana <="+thisWeek+" AND semana >="+thisWeekMinus30Days+" ORDER BY r.semana,d.id_deporte,r.dia";
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
				/*
				 * 
				 * if (i > 16) { i = 0; j = 1; }
				 * 
				 * // Crea el botón con la reserva, con la idea de cancelarla btnBookingArray[i]
				 * = new JButton(); btnBookingArray[i].setText(booking);
				 * btnBookingArray[i].addActionListener(this);
				 * btnBookingArray[i].setBackground(new Color(248, 248, 255));
				 * btnBookingArray[i].setForeground(new Color(71, 0, 100));
				 * btnBookingArray[i].setFont(new Font("Calibri", Font.BOLD, 16));
				 * btnBookingArray[i].setBounds(10 + j*662, 36 + i * 36, 630, 26);
				 * panelReservas.add(btnBookingArray[i]);
				 * 
				 * i++;
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
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
		// String button = ((AbstractButton) e.getSource()).getText();

		if (bookingToCancel == null) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna reserva",
	                "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
	 
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
							+ sport + "' AND r.dia='" + day + "' AND r.pista=" + schedule + " AND r.hora='" + hour + "'"
							+ " AND r.semana='" + weekYear + "'" + " AND r.plazas='" + users + "' AND r.acrónimo='"
							+ acronym + "'";
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

	}
}

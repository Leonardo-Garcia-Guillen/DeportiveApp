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
import javax.swing.SwingConstants;

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
	private static String conectionBBDD = "jdbc:mysql://192.168.43.228:3306/cy&co";
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
				int res = JOptionPane.showConfirmDialog(null, "�Desea salir de la aplicaci�n?", "Salir",
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

		String help = "-�C�mo puedo reservar un deporte?\r\n"
				+ "  Para reservar un deporte, seleccione en la imagen del deporte que desee y, a continuaci�n, se le mostrar�n los horarios disponibles para cada d�a de la semana\n\n"
				+ "-�Puedo ver qui�n ha reservado a una determinada hora?\r\n"
				+ "  Al realizar una reserva, aparecen los nombres de los usuarios que ya hayan reservado en ese mismo horario\n\n"
				+ "-�Cu�ntas reservas puedo hacer al d�a?\r\n" + "  Puede reservar un m�ximo de 2 periodos por d�a\n\n"
				+ "-�C�mo s� si una hora est� completa?\r\n"
				+ "  Cada horario de reserva tiene un c�digo de colores que nos indica el nivel de ocupaci�n: \n  Verde: Totalmente desocupado\n  Naranja: Parcialmente ocupado\n  Rojo: Totalmente ocupado\n\n"
				+ "-�C�mo veo mis reservas?\r\n" + "  En la opci�n \"Mi Perfil\"\n\n" + "-�C�mo cancelo mis reservas?\n"
				+ "  En \"Mi perfil\" salen todas las reservas realizadas por el usuario y la opci�n de cancelar cada una de ellas";
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

		String contact = "Correo electr�nico: cyco.sigesdep@gmail.com \n\nTel�fono de contacto: 662 62 62 62";

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

				// Modificamos el modelo de la lista para poder ir a�adiendo m�s y m�s elementos
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

		// Bot�n para cancelar reserva
		JButton btn = new JButton();
		btn.setBounds(1254, 357, 117, 71);
		btn.setFont(new Font("Calibri", Font.BOLD, 18));
		btn.setBorder(new LineBorder(Color.BLACK, 2));
		mainPanel.add(btn);
		btn.setText("<html>Cancelar <br/>reserva");

		JLabel lblFecha = new JLabel("Fecha:   26/05/22");
		lblFecha.setForeground(new Color(102, 0, 153));
		lblFecha.setFont(new Font("Calibri", Font.BOLD, 17));
		lblFecha.setBackground(Color.WHITE);
		lblFecha.setBounds(1328, 75, 139, 25);
		mainPanel.add(lblFecha);

		JLabel lblHora = new JLabel("19:50");
		lblHora.setForeground(new Color(102, 0, 153));
		lblHora.setFont(new Font("Calibri", Font.BOLD, 17));
		lblHora.setBackground(Color.WHITE);
		lblHora.setBounds(1382, 98, 85, 25);
		mainPanel.add(lblHora);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(48, 121, 203, 108);
		mainPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewUser = new JLabel("Nombre usuario: leona");
		lblNewUser.setBounds(8, 42, 174, 23);
		panel.add(lblNewUser);
		lblNewUser.setBackground(new Color(128, 0, 128));
		lblNewUser.setFont(new Font("Calibri", Font.BOLD, 18));
		btn.addActionListener(this);
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
			System.out.println("�� Conectado con la base Cy&Co !!");
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			// Select statement
			String query = "SELECT * FROM reservas r JOIN deportes d ON d.id_deporte = r.id_deporte JOIN semana s ON s.dia=r.dia WHERE semana <="
					+ thisWeek + " AND semana >=" + thisWeekMinus30Days + " AND r.acr�nimo='" + acronym
					+ "' ORDER BY r.semana,d.id_deporte,s.int_dia";
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

				booking = "Deporte: " + nDeporte + ". N� semana: " + weekYear + ". D�a: " + dia + ". Hora: " + hora
						+ ". Pista: " + pista + ". N� plazas: " + plazas;
				listModel.addElement(booking);
				/*
				 * 
				 * if (i > 16) { i = 0; j = 1; }
				 * 
				 * // Crea el bot�n con la reserva, con la idea de cancelarla btnBookingArray[i]
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
			JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna reserva", "ERROR_MESSAGE",
					JOptionPane.ERROR_MESSAGE);

		} else {
			int res = JOptionPane.showConfirmDialog(null, "�Desea cancelar la reserva?", "Eliminar reserva",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

			if (res == 0) {
				// Abrir conexion con BD
				try {
					conn = (Connection) DriverManager.getConnection(conectionBBDD, userBBDD, pswdBBDD);
					System.out.println("�� Conectado con la base Cy&Co !!");
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
							+ " AND r.semana='" + weekYear + "'" + " AND r.plazas='" + users + "' AND r.acr�nimo='"
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

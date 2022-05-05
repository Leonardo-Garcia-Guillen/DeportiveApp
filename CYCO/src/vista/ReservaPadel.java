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
import controlador.DocodifySport;
import controlador.JavaToBBDD;

import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ReservaPadel implements ActionListener {
	// STATIC
	PadelBooking padel = new PadelBooking();

	public static ChangeWindow change = new ChangeWindow("");
	public static ChangePanelHours panelHours = new ChangePanelHours();
	
	private final int totalDays = 7;
	private final int totalHours = padel.getTotalHours();
	private final int totalUsers = padel.getTotalUsers();
	private final int totalSchedules = padel.getTotalSchedules();
	
	private JPanel[] panelDaysArray = new JPanel[totalDays];
	private JButton[] btnDaysArray = new JButton[totalDays];
	private JButton[][][] btnHoursArray = new JButton[totalDays][totalSchedules][totalHours];
	private JRadioButton[] bookingRadioButtonArray = new JRadioButton[totalUsers];
	

	//private DayHourList weekList;
	
	//private HashMap<Integer,HashMap<Integer,JButton[]>> list = new HashMap<Integer,HashMap<Integer,JButton[]>>();
	//private HourList btnList = new HourList();
	//btnList = new LinkedList <LinkedList<JButton[]>>();
	private DocodifySport decode;
	private ButtonGroup bookingGroup;
	private String text = "";

	private JFrame frame;
	private JPanel bookingPanel;
	private JPanel mainPanel;
	
	private int availableUsers = totalUsers;
	private int scheduleSelected = 0;
	private String lastHour = "";
	private String booking = "";
	
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
		// getBookingPanels(mainPanel);
		bookingGroup = new ButtonGroup();
		bookingPanel = new JPanel();
		bookingPanel.setBounds(627, 386, 272, 312);
		mainPanel.add(bookingPanel);
		bookingPanel.setLayout(null);
		bookingPanel.setVisible(false);
		getBookingRadioBtn(bookingPanel);

		JLabel lblBooking = new JLabel("Indique cuántas plazas desea reservar");
		lblBooking.setBounds(17, 46, 237, 18);
		lblBooking.setForeground(new Color(100, 0, 140));
		lblBooking.setFont(new Font("Calibri", Font.BOLD, 14));
		bookingPanel.add(lblBooking);

		JButton btnBooking = new JButton();
		btnBooking.setText("Confirmar");
		btnBooking.addActionListener(this);
		btnBooking.setBounds(148, 120, 108, 71);
		bookingPanel.add(btnBooking);

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

				System.exit(0);
			}
		});

		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(71, 0, 100));
		btnSalir.setBounds(1183, 0, 66, 44);
		panelSup.add(btnSalir);

		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAyuda.setForeground(new Color(255, 255, 255));
		btnAyuda.setBackground(new Color(100, 0, 140));
		btnAyuda.setBounds(949, 0, 95, 44);
		panelSup.add(btnAyuda);

		JButton btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.setFont(new Font("Calibri", Font.BOLD, 16));
		btnMiPerfil.setForeground(new Color(255, 255, 255));
		btnMiPerfil.setBackground(new Color(100, 0, 140));
		btnMiPerfil.setBounds(1067, 0, 95, 44);
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
		btnInicio.setBounds(838, 0, 95, 44);
		panelSup.add(btnInicio);

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
					btnHoursArray[day][schedule][hour] = new JButton(padel.getPadelWeek().getDayBtn(day).getSchedules().get(schedule)
							.getSchedule().get(hour).getHourStr());
					// Nombre: 0 (padel) + nº de la semana respecto del año + dia + pista + hora
					btnHoursArray[day][schedule][hour].setName(
							"0-" + weekYear + "-" + day + "-" + schedule + "-" + btnHoursArray[day][schedule][hour].getText());
					btnHoursArray[day][schedule][hour].addActionListener(this);
					panelDaysArray[day].add(btnHoursArray[day][schedule][hour]);
					btnHoursArray[day][schedule][hour].setForeground(new Color(71, 0, 100));
					btnHoursArray[day][schedule][hour].setFont(new Font("Calibri", Font.BOLD, 16));
					btnHoursArray[day][schedule][hour].setBackground(new Color(248, 248, 255));
					//btnHoursArray[day][schedule][hour].setBorder(new LineBorder(Color.RED));
					//btnHoursArray[hour].setVisible(false);
					
					if (y >= 5) {
						y = 0;
						x = 1;
					}

					btnHoursArray[day][schedule][hour].setBounds((106 + x * 201) + (schedule * 808), 10 + y * 64, 139, 32);
					y++;
					
					cont++;
				}
				
				x = 0;
				y = 0;
			}
		}
	}

	private void getBookingRadioBtn(JPanel panel) {
		for (int i = 0; i < availableUsers; i++) {
			int j = i + 1;
			bookingRadioButtonArray[i] = new JRadioButton();
			bookingRadioButtonArray[i].setText("" + j);
			// bookingPanelArray[i].setBackground(new Color(250));
			bookingRadioButtonArray[i].setBounds(45, 85 + i * 50, 103, 21);
			panel.add(bookingRadioButtonArray[i]);
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
			((JComponent) e.getSource()).setBackground(new Color(229, 165, 255));
		
	}
	
	private void changeHourColor(JButton btn, int availableUsers) {
		
			if (availableUsers == totalUsers) {
				btn.setBorder(new LineBorder(new Color (50,205,50),5));
			}
			else if(availableUsers == 0) {
				btn.setBorder(new LineBorder(Color.RED,5));
			}
			else {
				btn.setBorder(new LineBorder(Color.ORANGE,5));
			}		
	}
	
	private void getColorHourBtns() {
		
		
		for (int day = 0; day < 7; day++) 
			for (int schedule = 0; schedule < totalSchedules; schedule++) 
				for (int hour = 0; hour < totalHours; hour++) {
					changeHourColor(btnHoursArray[day][schedule][hour], availableUsers);
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
	private void evaluateHourBtn(AbstractButton source) {
		//availableUsers = 4; // - padel.getavailableUsers();	
		
		bookingPanel.setVisible(true);
		booking = source.getName();
		
		decode = new DocodifySport(booking,0);
		availableUsers = 4 - decode.getAvailableUsers();
		scheduleSelected = decode.getSchedule();
		lastHour = decode.getHour();
		
	}
	
	// ------------ ACTION PERFORMANCE ------------
	@Override
	public void actionPerformed(ActionEvent e) {
		String textDialog = "";
		String button = ((AbstractButton) e.getSource()).getText();
		int users = 0;
		
		if (button.equals("LUNES") || button.equals("MARTES") || button.equals("MIERCOLES") || button.equals("JUEVES")
				|| button.equals("VIERNES") || button.equals("SABADO") || button.equals("DOMINGO")) {
			// Pongo el resto del color estandar, y el pulsado en otro color
			resetDayBtns();
			changeBtnColor(e);
			// Muestro las horas del dia pulsado
			text = button;
			panelHours.newPanelHours(button, panelDaysArray);
			//panelHours.newPanelHours(button, btnHoursArray, totalHours*totalSchedules*totalUsers);
		} else if (button.equals("Confirmar")) {
			// Muestra la reserva que el usuario ha realizado
			for (int i = 1; i < availableUsers + 1; i++)
				if (bookingRadioButtonArray[i - 1].isSelected()) {
					users = i;
					textDialog = "" + i;
				}
					
			// Si hay confirmación sin asignación de plazas
			if (users == 0)
				JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna plaza");
			else {
				// Muestra al usuario los datos de la reserva
				textDialog = "Plazas: " + textDialog + "\nPista: " +scheduleSelected + "\nDía: " + text + "\nHora: " + lastHour;

				int res = JOptionPane.showConfirmDialog(null, textDialog, "Resumen de reserva", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE);

				if (res == 0) {
					decode = new DocodifySport(booking,users);
					decode.sendBBDD(decode.toString(),totalUsers);
				}
				else 
					System.out.println("Reserva cancelada");
				
			}
			
			
		} else {
			resetHourBtns();
			changeBtnColor(e);
			evaluateHourBtn(((AbstractButton) e.getSource()));
			
		}
		
	}
}

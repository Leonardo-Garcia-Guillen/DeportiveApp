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
import java.util.LinkedList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ChangePanelHours;
import controlador.ChangeWindow;
import modelo.PadelBooking;
import modelo.WeekBtn;

public class ReservaPadel implements ActionListener {
	// STATIC
	PadelBooking padel = new PadelBooking();
	public static ChangeWindow change = new ChangeWindow("");
	public static ChangePanelHours panelHours = new ChangePanelHours();

	private JPanel[] panelDaysArray = new JPanel[7];
	private JButton[] btnDaysArray = new JButton[7];
	private JButton[] btnHoursArray = new JButton[10];

	private JFrame frame;

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
		getWeekPanels(mainPanel);

		// --------- DIAS SEMANA ----------
		getDayBtns(mainPanel);

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
		getHourBtns();
		
	}

	private void getHourBtns() {
		int x = 0;
		int y = 0;
		int schedulesTotal = padel.getTotalSchedules();
		int hoursTotal = padel.getTotalHours();

		for (int day = 0; day < 7; day++) {
			for (int schedule = 0; schedule < schedulesTotal; schedule++) {
				for (int hour = 0; hour < hoursTotal; hour++) {
					btnHoursArray[hour] = new JButton(padel.getPadelWeek().getDayBtn(day).getSchedules().get(schedule)
							.getSchedule().get(hour).getHourStr());
					btnHoursArray[hour].setName(""+day+schedule+hour);
					btnHoursArray[hour].addActionListener(this);
					panelDaysArray[day].add(btnHoursArray[hour]);
					btnHoursArray[hour].setForeground(new Color(71, 0, 100));
					btnHoursArray[hour].setFont(new Font("Calibri", Font.BOLD, 16));
					btnHoursArray[hour].setBackground(new Color(248, 248, 255));

					if (y >= 5) {
						y = 0;
						x = 1;
					}

					btnHoursArray[hour].setBounds((106 + x * 201) + (schedule * 808), 10 + y * 64, 139, 32);
					y++;

				}
				x = 0;
				y = 0;
			}
		}
	}

	private void getWeekPanels(JPanel panel) {
		for (int i = 0; i < 7; i++) {
			panelDaysArray[i] = new JPanel();
			panelDaysArray[i].setBounds(72, 452, 1350, 309);
			panel.add(panelDaysArray[i]);
			panelDaysArray[i].setLayout(null);
			panelDaysArray[i].setVisible(false);
		}
	}

	private void getDayBtns(JPanel panel) {
		for (int i = 0; i < 7; i++) {

			/*if (i == 0)
				btnDaysArray[i] = new JButton("LUNES");
			else if (i == 1)
				btnDaysArray[i] = new JButton("MARTES");
			else if (i == 2)
				btnDaysArray[i] = new JButton("MIERCOLES");
			else if (i == 3)
				btnDaysArray[i] = new JButton("JUEVES");
			else if (i == 4)
				btnDaysArray[i] = new JButton("VIERNES");
			else if (i == 5)
				btnDaysArray[i] = new JButton("SABADO");
			else if (i == 6)
				btnDaysArray[i] = new JButton("DOMINGO");*/
			btnDaysArray[i] = new JButton();
			btnDaysArray[i].setText(padel.getPadelWeek().getWeek().get(i).getDayName().toUpperCase());
			btnDaysArray[i].addActionListener(this);
			btnDaysArray[i].setBackground(new Color(248, 248, 255));
			btnDaysArray[i].setForeground(new Color(71, 0, 100));
			btnDaysArray[i].setFont(new Font("Calibri", Font.BOLD, 16));
			btnDaysArray[i].setBounds(72 + i * 203, 222, 139, 133);
			panel.add(btnDaysArray[i]);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String button = ((AbstractButton) e.getSource()).getText();
		System.out.println(button);
		if (button == "LUNES" || button == "MARTES" || button == "MIERCOLES" || button == "JUEVES"
				|| button == "VIERNES" || button == "SABADO" || button == "DOMINGO")
			panelHours.newPanelHours(button, panelDaysArray);
		else {
			evaluateHourBtn(((AbstractButton) e.getSource()));
		}

	}

	private void evaluateHourBtn(AbstractButton source) {
		System.out.println(source.getName());
	}

}

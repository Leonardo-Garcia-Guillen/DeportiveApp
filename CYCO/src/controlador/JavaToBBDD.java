package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class JavaToBBDD {
	private String acronym;
	private int sport;
	private int weekYear;
	private String day;
	private int schedule;
	private String hour;
	private int users;
	private String comment;
	
	private static int pointer = 0;

	private static String staticAcronym = "";
	private static int staticSport = 0;
	private static int staticWeekYear = 0;
	private static String staticDay = "";
	private static int staticSchedule = 0;
	private static String staticHour = "";
	private static int staticUsers = 0;

	// BBDD
	private static String conectionBBDD = "jdbc:mysql://192.168.50.27:3306/cy&co";
	private static String userBBDD = "Leo";
	private static String pswdBBDD = "CYCO";
	private Connection conn;
	private Statement stmt;

	public JavaToBBDD(int sportOK, int weekYearOK, String dayOK, int scheduleOK, String hourOK, int usersOK,
			int totalUsers, String userComment) {

		// Nombre + nº de la semana respecto del año + dia + schedule + hora
		acronym = System.getProperty("user.name");
		sport = sportOK;
		weekYear = weekYearOK;
		day = dayOK;
		schedule = scheduleOK;
		hour = hourOK;
		users = usersOK;
		comment = userComment;
				
		// Abrir conexion con BD
		try {
			conn = (Connection) DriverManager.getConnection(conectionBBDD, userBBDD, pswdBBDD);
			System.out.println("¡¡ Conectado con la base Cy&Co !!");
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Cuenta las reservas a esa hora
		int counter = countHourBooking();

		// Comprueba si el usuario ya esta registrado en la BD
		if (checkUser() == false) {
			// En caso de que no, lo inserta
			insertIntoUsuarios();
			System.out.println("Usuario nuevo");
		} else
			System.out.println("Que hay de nuevo viejo...?");

		// Si hay plazas disponibles, hacer la reserva
		// System.out.println("Totales: " + totalUsers + "Counter: " + counter + "users: " + users);
		if (counter == totalUsers)
			JOptionPane.showMessageDialog(null, "Pista completa");
		else if (users > totalUsers - counter)
			JOptionPane.showMessageDialog(null, "Número de plazas sugeridas excede las que quedan disponibles");
		else {
			// Introducir datos de reserva
			insertIntoReserva();
			JOptionPane.showMessageDialog(null, "Reserva realizada con éxito");
		}
	}

	// Contar cuantas reservas hay en total
	public int countTotalBooking() {
		Integer id = 0;
		try {
			// Select statement
			String query = "SELECT id_reserva FROM reservas";
			java.sql.Statement stmt = conn.createStatement();

			// Gets the result
			ResultSet rs = stmt.executeQuery(query);

			// Take the value
			while (rs.next()) {
				id = rs.getInt(1);
				
			}
			if (id==null) 
				id = 0;
			
			System.out.println(id);
			// stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	// Contar cuantas reservas hay de un usuario en un deporte a una hora específica
	public int countHourBooking() {

		int hoursCounter = 0;
		int aux = 0;
		try {
			// Select statement
			String query = "SELECT plazas FROM reservas WHERE id_deporte=" + sport + " AND dia='" + day + "' AND pista="
					+ schedule + " AND hora='" + hour + "'" + " AND semana='" + weekYear + "'";
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

		return hoursCounter;
	}

	// Comprueba si el usuario esta registrado en la BD "usuarios"
	public Boolean checkUser() {
		Boolean check = false;
		try {
			// Inserts
			String query = "SELECT acrónimo FROM usuarios";
			java.sql.Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				String user = rs.getString(1);

				if (user.equals(acronym))
					return true;

				// print the results
				System.out.format("%s\n", user);
			}
			// stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	// Insertar valores en tabla "reserva"
	public void insertIntoReserva() {
		// Contamos el numero de reservas que hay para poner el id correspondiente
		int hoursBooked = countTotalBooking() + 1;

		try { // Inserts
			String query1 = "INSERT INTO reservas " + "VALUES ('" + hoursBooked + "', '" + acronym + "', '" + sport
					+ "', '" + weekYear + "', '" + day + "', '" + schedule + "', '" + users + "', '" + hour + "', '" + comment + "')";
			stmt.executeUpdate(query1);
			System.out
					.println("Los datos han sido añadido a la base de datos..... \nAhora una cerveza para celebrarlo");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Insertar valores en tabla "usuarios"
	public void insertIntoUsuarios() {
		try {
			// Inserts
			String query1 = "INSERT INTO usuarios " + "VALUES ('" + acronym + "', 'garcia', 'guillen','AA','leonardo')";
			stmt.executeUpdate(query1);
			System.out
					.println("Los datos han sido añadido a la base de datos..... \nAhora una cerveza para celebrarlo");
			// conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

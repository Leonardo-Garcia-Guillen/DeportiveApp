package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.ConnectionBBDDJava;

public class SportIsBlock {
	private int disponible;
	private int staticDisponible = 1;

	// BBDD
	private static String conectionBBDD = "jdbc:mysql://192.168.50.27:3306/cy&co";
	private static String userBBDD = "Leo";
	private static String pswdBBDD = "CYCO";
	private Connection conn;
	private Statement stmt;

	public SportIsBlock() {
		openConnectionBBDD();
		//disponible = getDisponibility(sport);
	}

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

	public int getDisponibility(int sport) {
		try {
			// Select statement

			String query = "SELECT disponibilidad FROM deportes WHERE id_deporte='" + sport + "'";

			java.sql.Statement stmt = conn.createStatement();

			// Gets the result
			ResultSet rs = stmt.executeQuery(query);

			// Take the value
			while (rs.next()) {
				staticDisponible = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staticDisponible;
	}

	public void updateLock(String sport, int i) {
		String query;
		try {
			// Inserts
			if (sport == "TODOS")
				query = "UPDATE deportes SET disponibilidad=" + i;
			else
				query = "UPDATE deportes SET disponibilidad=" + i + " WHERE nombre_deporte='" + sport + "'";

			stmt.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

}

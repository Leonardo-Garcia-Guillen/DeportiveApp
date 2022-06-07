package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBBDDJava {

	private Connection conn;
	private Statement stmt;

	// BBDD
	private static String conectionBBDD = "jdbc:mysql://192.168.50.27:3306/cy&co";
	private static String userBBDD = "Leo";
	private static String pswdBBDD = "CYCO";

	public ConnectionBBDDJava() {
		// Abrir conexion con BD
		try {
			conn = (Connection) DriverManager.getConnection(conectionBBDD, userBBDD, pswdBBDD);
			//System.out.println("¡¡ Conectado con la base Cy&Co !!");
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

}

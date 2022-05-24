package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectServerBBDD {
	Connection conn;
	Statement stmt;

	public ConnectServerBBDD() {
		// Abrir conexion con BD
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.43.228:3306/cy&co", "Leo", "CYCO");
			System.out.println("¡¡ Conectado con la base Cy&Co !!");
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

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class BANCO_PRUEBAS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.50.27:3306/cy&co", "Leo", "CYCO");
			System.out.println("�� Conectado con la base Cy&Co !!");
			java.sql.Statement stmt = conn.createStatement();
			String query1 = "INSERT INTO usuarios " + "VALUES ('lgargui', 'garcia', 'guillen','AA','leonardo')";
			stmt.executeUpdate(query1);
			System.out
					.println("Los datos han sido a�adido a la base de datos..... \nAhora una cerveza para celebrarlo");
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

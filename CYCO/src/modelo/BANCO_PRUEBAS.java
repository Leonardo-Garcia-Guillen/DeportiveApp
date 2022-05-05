package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BANCO_PRUEBAS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.88.247:3306/cy&co", "Leo", "CYCO");
			System.out.println("¡¡ Conectado con la base Cy&Co !!");
			
			//String query1 = "INSERT INTO usuarios " + "VALUES ('lgargui', 'garcia', 'guillen','AA','leonardo')";
			String query1 = "SELECT COUNT(*)  FROM usuarios";
			java.sql.Statement stmt = conn.createStatement();
			
			//stmt.executeUpdate(query1);
			
			ResultSet rs = stmt.executeQuery(query1);
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        String a = rs.getString(1);
		        
		        // print the results
		        System.out.format("%s\n", a);
		      }
		      stmt.close();
		      
			System.out
					.println("Los datos han sido añadido a la base de datos..... \nAhora una cerveza para celebrarlo");
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

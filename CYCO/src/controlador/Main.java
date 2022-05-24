package controlador;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import controlador.ConnectServerBBDD;
import vista.InterfazPrincipal;
import java.sql.Connection;
import java.sql.Statement;


public class Main {
	public static InterfazPrincipal principal = new InterfazPrincipal();
	
	public static void main(String[] args) {
		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	// Para poner la interfaz más "moderna"
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*ConnectServerBBDD conectionJavaBBDD = new ConnectServerBBDD();
		Connection conn = conectionJavaBBDD.getConn();
		Statement stmt = conectionJavaBBDD.getStmt();*/
		principal.newPrincipalInterface();

	}

}

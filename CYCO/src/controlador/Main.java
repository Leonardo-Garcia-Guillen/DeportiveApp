package controlador;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import vista.InterfazPrincipal;

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
		principal.newPrincipalInterface();

	}

}

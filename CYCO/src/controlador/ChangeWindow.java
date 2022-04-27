package controlador;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import vista.InterfazPrincipal;
import vista.ReservaPadel;

public class ChangeWindow {
	public static InterfazPrincipal principal = new InterfazPrincipal();
	public static ReservaPadel padel = new ReservaPadel();
	
	public ChangeWindow(String sport) {
		
	}

	public void newWindowApp(String windowName, JFrame frame) {
		frame.dispose();
		switch (windowName) {
		case "padel": {
			padel.newPadelInterface();
			break;
		}
		case "principal": {
			principal.newPrincipalInterface();
			break;
		}
		case "tenis": {
			System.out.println("alegría");
			break;
		}
		case "piscina": {
			break;
		}
		case "baloncesto": {
			break;
		}
		case "gimnasio": {
			break;
		}
		case "crossfit": {
			break;
		}
		case "TO": {
			break;
		}
		case "esgrima": {
			break;
		}
		case "voley": {
			break;
		}
		case "Fsala": {
			break;
		}
		case "F7": {
			break;
		}
		case "atletismo": {
			break;
		}
		default : {
			break;
		}
		
		
		
	}
		
	}

}

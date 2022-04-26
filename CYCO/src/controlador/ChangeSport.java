package controlador;

import javax.swing.WindowConstants;

import vista.ReservaPadel;

public class ChangeSport {
	public static ReservaPadel padel = new ReservaPadel();
	
	public ChangeSport(String sport) {
		
	}

	public void alegria(String sport) {
		
		switch (sport) {
		case "padel": padel.newPadelInterface();
		case "tenis": ;
		case "piscina": ;
		case "baloncesto": ;
		case "gimnasio": ;
		case "crossfit": ;
		case "TO": ;
		case "esgrima": ;
		case "voley": ;
		case "Fsala": ;
		case "F7": ;
		case "atletismo": ;
		default: ;
		
		
	}
		
	}

}

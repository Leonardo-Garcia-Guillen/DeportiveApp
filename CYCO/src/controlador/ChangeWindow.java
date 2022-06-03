package controlador;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import modelo.BANCOPRUEBAS_GRAFICAS;
import vista.InterfazPrincipal;
import vista.MiPerfil;
import vista.MiPerfilAdministrador;
import vista.ReservaPadel;
import vista.ReservaPiscina;
import vista.ReservaTenis;

public class ChangeWindow {
	public static InterfazPrincipal principal = new InterfazPrincipal();
	
	public static MiPerfil miPerfil = new MiPerfil();
	public static MiPerfilAdministrador miPerfilAdministrador = new MiPerfilAdministrador();
	
	public static BANCOPRUEBAS_GRAFICAS gg = new BANCOPRUEBAS_GRAFICAS();
	
	public static ReservaPadel padel = new ReservaPadel();
	public static ReservaTenis tenis = new ReservaTenis();
	public static ReservaPiscina piscina = new ReservaPiscina();
	
	
	public ChangeWindow(String sport) {
		
	}

	public void newWindowApp(String windowName, JFrame frame) {
		frame.dispose();
		switch (windowName) {
		case "miPerfil" : {
			miPerfil.newMiPerfil();
			break;
		}
		case "miPerfilAdministrador" : {
			miPerfilAdministrador.newMiPerfil();
			break;
		}
		case "principal": {
			principal.newPrincipalInterface();
			break;
		}
		case "padel": {
			padel.newPadelInterface();
			break;
		}
		case "tenis": {
			tenis.newTenisInterface();
			break;
		}
		case "natacion": {
			piscina.newPiscinaInterface();
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
			gg.main(null);
			break;
		}
		
		
		
	}
		
	}



}

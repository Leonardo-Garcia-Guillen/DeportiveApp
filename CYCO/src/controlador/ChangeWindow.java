package controlador;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import modelo.BANCOPRUEBAS_GRAFICAS;
import vista.InterfazPrincipal;
import vista.MiPerfil;
import vista.MiPerfilAdministrador;
import vista.ReservaAtletismo;
import vista.ReservaBaloncesto;
import vista.ReservaCrossfit;
import vista.ReservaEsgrima;
import vista.ReservaFutbol7;
import vista.ReservaFutbolSala;
import vista.ReservaGimnasio;
import vista.ReservaPadel;
import vista.ReservaPiscina;
import vista.ReservaTenis;
import vista.ReservaTiro;
import vista.ReservaVoley;

public class ChangeWindow {
	public static InterfazPrincipal principal = new InterfazPrincipal();
	
	public static MiPerfil miPerfil = new MiPerfil();
	public static MiPerfilAdministrador miPerfilAdministrador = new MiPerfilAdministrador();
	
	public static BANCOPRUEBAS_GRAFICAS gg = new BANCOPRUEBAS_GRAFICAS();
	
	public static ReservaPadel padel = new ReservaPadel();
	public static ReservaTenis tenis = new ReservaTenis();
	public static ReservaPiscina piscina = new ReservaPiscina();
	public static ReservaBaloncesto baloncesto = new ReservaBaloncesto();
	public static ReservaGimnasio gimnasio = new ReservaGimnasio();
	public static ReservaCrossfit crossfit = new ReservaCrossfit();
	public static ReservaTiro tiro = new ReservaTiro();
	public static ReservaEsgrima esgrima= new ReservaEsgrima();
	public static ReservaVoley voley = new ReservaVoley();
	public static ReservaFutbolSala futbolSala = new ReservaFutbolSala();
	public static ReservaFutbol7 futbol7 = new ReservaFutbol7();
	public static ReservaAtletismo atletismo = new ReservaAtletismo();
	
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
			baloncesto.newBaloncestoInterface();
			break;
		}
		case "gimnasio": {
			gimnasio.newGimnasioInterface();
			break;
		}
		case "crossfit": {
			crossfit.newCrossfitInterface();
			break;
		}
		case "tiro": {
			tiro.newTiroInterface();
			break;
		}
		case "esgrima": {
			esgrima.newEsgrimaInterface();
			break;
		}
		case "voley": {
			voley.newVoleyInterface();
			break;
		}
		case "futbolSala": {
			futbolSala.newFutbolSalaInterface();
			break;
		}
		case "futbol7": {
			futbol7.newFutbol7Interface();
			break;
		}
		case "atletismo": {
			atletismo.newAtletismoInterface();
			break;
		}
		default : {
			gg.main(null);
			break;
		}
		
		
		
	}
		
	}



}

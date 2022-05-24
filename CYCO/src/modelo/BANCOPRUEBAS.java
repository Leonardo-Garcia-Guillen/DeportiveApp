package modelo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

public class BANCOPRUEBAS {
	static int pointer = 0;
	public static void main(String[] args) {
		String booking = "Deporte: padel. Nº semana: 21. Día: miercoles. Hora: 19:30 - 21:00. Pista: 1. Nº plazas: 3";
		System.out.println(booking);
		String sport = decodeSport(booking);
		int weekYear = decodeWeekYear(booking);
		System.out.println(sport + weekYear);
	}
	
	public static String decodeSport(String sportCodify) {
		int index, finalIndex;
		
		index = sportCodify.indexOf(" ", 0)+1;
	
		
		finalIndex = sportCodify.indexOf(".", index);
		String staticSport = sportCodify.substring(index, finalIndex);
		pointer = finalIndex;
		
		return staticSport;
	}
	
	private static int decodeWeekYear(String sportCodify) {
		int index, finalIndex;
		index = sportCodify.indexOf(": ", pointer)+2;
		finalIndex = sportCodify.indexOf(".", index);	
		
		int staticWeekYear = Integer.parseInt(sportCodify.substring(index, finalIndex));
		
		
		return staticWeekYear;
	}
	
	private String decodeDay(String sportCodify) {
		int index, finalIndex;
		index = sportCodify.indexOf("Día", pointer);
		
		int day = Integer.parseInt(sportCodify.substring(pointer, index));
		pointer = index + 1;
		
		return "";
	}
}

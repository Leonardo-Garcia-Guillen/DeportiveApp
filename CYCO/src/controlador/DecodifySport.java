package controlador;

import java.sql.Connection;
import java.sql.Statement;

public class DecodifySport {
	private int sport;
	private int weekYear;
	private String day;
	private int schedule;
	private String hour;
	private int users;
	
	
	private static int pointer = 0;
	
	private static int staticSport = 0;
	private static int staticWeekYear = 0;
	private static String staticDay = "";
	private static int staticSchedule = 0;
	private static String staticHour = "";
	private static int staticUsers = 0;
	
	
	
	public DecodifySport(String sportCodify,int people) {
	
		// Nombre + nº de la semana respecto del año + dia + schedule + hora 
		sport = decodeSport(sportCodify);
		weekYear = decodeWeekYear(sportCodify);
		day = decodeDay(sportCodify);
		schedule = decodeSchedule(sportCodify);
		hour = decodeHour(sportCodify);
		users = decodeUsers(people);
	}
	
	private int decodeUsers(int people) {
		staticUsers = people;
		
		return staticUsers;
	}

	private int decodeSchedule(String sportCodify) {
		int index;
		index = sportCodify.indexOf("-", pointer);
		
		staticSchedule = Integer.parseInt(sportCodify.substring(pointer, index)) + 1;
		pointer = index + 1;
		
		return staticSchedule;
	}

	private String decodeHour(String sportCodify) {
		
		staticHour = sportCodify.substring(pointer, sportCodify.length());
		
		return staticHour;
	}

	private String decodeDay(String sportCodify) {
		int index;
		index = sportCodify.indexOf("-", pointer);
		
		int day = Integer.parseInt(sportCodify.substring(pointer, index));
		pointer = index + 1;
		
		if (day == 0)
			staticDay = "lunes";
		else if (day == 1) 
			staticDay = "martes";
		else if (day == 2) {
			staticDay = "miercoles";
		} else if (day == 3) {
			staticDay = "jueves";
		} else if (day == 4) {
			staticDay = "viernes";
		} else if (day == 5) {
			staticDay = "sabado";
		} else {
			staticDay = "domingo";
		}
		
		return staticDay;
	}

	private int decodeWeekYear(String sportCodify) {
		int index;
		index = sportCodify.indexOf("-", pointer);
				
		staticWeekYear = Integer.parseInt(sportCodify.substring(pointer, index));
		pointer = index + 1;
		
		return staticWeekYear;
	}

	public int decodeSport(String sportCodify) {
		int index, sportNumber;
		
		index = sportCodify.indexOf("-", 0);
		pointer = index+1;

		sportNumber = Integer.parseInt(sportCodify.substring(0, index));
		staticSport = sportNumber;
		
		return staticSport;
	}
	
	public String toString() {
		
		return sport + "; "+weekYear+"; " + day+"; " + schedule+"; " +users + "; "+ hour;
	}

	public void sendBBDD(String booking, int totalUsers, String userComment) {
		System.out.println("Enviar a BBDD");
		System.out.println("Reserva: "+booking+".\nComentario a la reserva: " + userComment);
		JavaToBBDD sending = new JavaToBBDD(sport, weekYear, day, schedule, hour, users, totalUsers, userComment);
	}
	

	public int getSport() {
		return sport;
	}

	public void setSport(int sport) {
		this.sport = sport;
	}

	public int getWeekYear() {
		return weekYear;
	}

	public void setWeekYear(int weekYear) {
		this.weekYear = weekYear;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getSchedule() {
		return schedule;
	}

	public void setSchedule(int schedule) {
		this.schedule = schedule;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}
	
}

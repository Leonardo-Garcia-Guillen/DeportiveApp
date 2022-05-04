package controlador;

public class DocodifySport {
	private String sport;
	private int weekYear;
	private String day;
	private int schedule;
	private String hour;
	private int users;
	
	private static int pointer = 0;
	
	private static String staticSport = "";
	private static int staticWeekYear = 0;
	private static String staticDay = "";
	private static int staticSchedule = 0;
	private static String staticHour = "";
	private static int staticUsers = 0;
	
	public DocodifySport(String sportCodify,int people) {
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

	public String decodeSport(String sportCodify) {
		int index, sportNumber;
		
		index = sportCodify.indexOf("-", 0);
		pointer = index+1;

		sportNumber = Integer.parseInt(sportCodify.substring(0, index));
		
		if (sportNumber == 0)
			staticSport = "padel";
		else  if (sportNumber == 1)
			staticSport = "tenis";
		else  if (sportNumber == 2)
			staticSport = "piscina";
		else  if (sportNumber == 3)
			staticSport = "baloncesto";
		else  if (sportNumber == 4)
			staticSport = "gimnasio";
		else  if (sportNumber == 5)
			staticSport = "crossfit";
		else  if (sportNumber == 6)
			staticSport = "tiro";
		else  if (sportNumber == 7)
			staticSport = "esgrima";
		else  if (sportNumber == 8)
			staticSport = "voley";
		else  if (sportNumber == 9)
			staticSport = "futbol sala";
		else  if (sportNumber == 10)
			staticSport = "futbol 7";
		else 
			staticSport = "atletismo";
		
		return staticSport;
	}
	
	public String toString() {
		
		return sport + "; "+weekYear+"; " + day+"; " + schedule+"; " +users + "; "+ hour;
	}

	public void sendBBDD(String booking) {
		System.out.println("Enviar a BBDD");
		System.out.println(booking);
		JavaToBBDD sending = new JavaToBBDD(sport, weekYear, day, schedule, hour, users);
	}
	
	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
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
	
}

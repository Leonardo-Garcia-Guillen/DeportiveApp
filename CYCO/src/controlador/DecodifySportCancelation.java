package controlador;

public class DecodifySportCancelation {
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

	public DecodifySportCancelation(String sportCodify) {

		// Nombre + nº de la semana respecto del año + dia + schedule + hora
		sport = decodeSport(sportCodify);
		weekYear = decodeWeekYear(sportCodify);
		day = decodeDay(sportCodify);
		hour = decodeHour(sportCodify);
		schedule = decodeSchedule(sportCodify);
		users = decodeUsers(sportCodify);
	}

	public String decodeSport(String sportCodify) {
		int index, finalIndex;

		// Comienza buscando el primer espacio (+1 para evitar este mismo espacio)
		index = sportCodify.indexOf(" ", 0) + 1;

		// Final: donde haya un punto
		finalIndex = sportCodify.indexOf(".", index);
		staticSport = sportCodify.substring(index, finalIndex);

		// Actualizamos el puntero para comenzar en la próxima búsqueda
		pointer = finalIndex;

		return staticSport;
	}

	private int decodeWeekYear(String sportCodify) {
		int index, finalIndex;

		index = sportCodify.indexOf(": ", pointer) + 2;
		finalIndex = sportCodify.indexOf(".", index);

		staticWeekYear = Integer.parseInt(sportCodify.substring(index, finalIndex));
		pointer = finalIndex;

		return staticWeekYear;
	}

	private String decodeDay(String sportCodify) {
		int index, finalIndex;

		index = sportCodify.indexOf(": ", pointer) + 2;
		finalIndex = sportCodify.indexOf(".", index);

		staticDay = sportCodify.substring(index, finalIndex);
		pointer = index;

		return staticDay;
	}

	private String decodeHour(String sportCodify) {
		int index, finalIndex;

		index = sportCodify.indexOf(": ", pointer) + 2;
		finalIndex = sportCodify.indexOf(".", index);

		staticHour = sportCodify.substring(index, finalIndex);
		pointer = index;

		return staticHour;
	}

	private int decodeSchedule(String sportCodify) {
		int index, finalIndex;

		index = sportCodify.indexOf(": ", pointer) + 2;
		finalIndex = sportCodify.indexOf(".", index);

		staticSchedule = Integer.parseInt(sportCodify.substring(index, finalIndex));
		pointer = index;

		return staticSchedule;
	}

	private int decodeUsers(String sportCodify) {
		int index;

		index = sportCodify.indexOf(": ", pointer) + 2;

		staticUsers = Integer.parseInt(sportCodify.substring(index, sportCodify.length()));

		return staticUsers;
	}

	public String toString() {

		return sport + " " + weekYear + " " + day + " " + hour + " " + schedule + " " + users;
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

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

}

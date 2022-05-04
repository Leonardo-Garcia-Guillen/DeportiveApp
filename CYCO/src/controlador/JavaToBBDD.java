package controlador;

public class JavaToBBDD {
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
	
	public JavaToBBDD(String sportOK,int weekYearOK, String dayOK, int scheduleOK,String hourOK,int usersOK) {
		// Nombre + nº de la semana respecto del año + dia + schedule + hora 
		sport = sportOK;
		weekYear = weekYearOK;
		day = dayOK;
		schedule = scheduleOK;
		hour = hourOK;
		users = usersOK;
		
		
	}
}

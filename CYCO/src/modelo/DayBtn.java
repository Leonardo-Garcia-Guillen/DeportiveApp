// Aqui el Schedule.java
package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class DayBtn {
	
	private LinkedList<Schedule> schedules;
	

	// Instances
	private int dayNumber;
	private String dayName;
	private int weekYear;

	private static String staticDayName = "";
	private static int staticDayNumber = -1;

	// Constructor
	public DayBtn(int totalSchedules, int totalHours, double firstHour, double bookingTime) {
		
		schedules = new LinkedList<Schedule>();
		
		dayNumber = newDayNumber();
		dayName = newDayName();
		weekYear = newWeekYear();
		
		for (int s=0;s<totalSchedules;s++) {
			Schedule schedule = new Schedule(totalHours,firstHour,bookingTime);
			
			schedules.add(schedule);
		}
	}

	private int newDayNumber() {
		staticDayNumber++;

		return staticDayNumber;
	}

	private String newDayName() {
		if (dayNumber == 0) {
			staticDayName = "lunes";
		} else if (dayNumber == 1) {
			staticDayName = "martes";
		} else if (dayNumber == 2) {
			staticDayName = "miercoles";
		} else if (dayNumber == 3) {
			staticDayName = "jueves";
		} else if (dayNumber == 4) {
			staticDayName = "viernes";
		} else if (dayNumber == 5) {
			staticDayName = "sabado";
		} else {
			staticDayName = "domingo";
		}

		return staticDayName;
	}

	private int newWeekYear() {
		// Desde el primer lunes del año
		return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public int getWeekYear() {
		return weekYear;
	}

	public void setWeekYear(int weekYear) {
		this.weekYear = weekYear;
	}


	public LinkedList<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(LinkedList<Schedule> schedules) {
		this.schedules = schedules;
	}

}

package modelo;

import java.util.LinkedList;

public class WeekBtn {
	private LinkedList<DayBtn> week;
	private final int WEEK_LENGTH = 7;
	
	// Constructor
	public WeekBtn(int totalSchedules, int totalHours, double firstHour, double bookingTime) {
		week = new LinkedList<DayBtn>();
		
		for (int i=0;i<WEEK_LENGTH;i++) {
			DayBtn day = new DayBtn(totalSchedules,totalHours,firstHour,bookingTime);

			week.add(day);
		}
		
	}
	
	public DayBtn getDayBtn(int dayNumber) {
		DayBtn day = week.get(dayNumber);
		
		return day;
	}


	public LinkedList<DayBtn> getWeek() {
		return week;
	}

	public void setWeek(LinkedList<DayBtn> week) {
		this.week = week;
	}
	
}

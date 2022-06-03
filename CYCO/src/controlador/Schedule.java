package controlador;

import java.util.LinkedList;

public class Schedule {
	private LinkedList<HourBtn> schedule;


	public Schedule(int totalHours, double firstHour, double bookingTime) {
		schedule = new LinkedList<HourBtn>();
		double actualHour = firstHour;
		
		for (int i = 0; i < totalHours; i++) {
			HourBtn hour = new HourBtn(actualHour,bookingTime);
			
			schedule.add(hour);
			actualHour = actualHour + bookingTime;
		}
	}

	public LinkedList<HourBtn> getSchedule() {
		return schedule;
	}

	public void setSchedule(LinkedList<HourBtn> schedule) {
		this.schedule = schedule;
	}



	

}

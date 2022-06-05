package controlador;

public class GimnasioBooking {
	private WeekBtn gimnasioWeek;
	private final int sportNumber = 4;
	private final int totalHours = 10;
	private final double firstHour = 7.30; 
	private final double bookingTime = 1.5;
	private final int totalSchedules = 1;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 24;
	
	// Constructor
	public GimnasioBooking() {
		gimnasioWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
	}

	public WeekBtn getGimnasioWeek() {
		return gimnasioWeek;
	}

	public void setGimnasioWeek(WeekBtn gimnasioWeek) {
		this.gimnasioWeek = gimnasioWeek;
	}

	public int getSportNumber() {
		return sportNumber;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public double getFirstHour() {
		return firstHour;
	}

	public double getBookingTime() {
		return bookingTime;
	}

	public int getTotalSchedules() {
		return totalSchedules;
	}

	public int getTotalUsers() {
		return totalUsers;
	}


	
}

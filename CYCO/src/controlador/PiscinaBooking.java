package controlador;

public class PiscinaBooking {
	private WeekBtn piscinaWeek;
	private final int sportNumber = 2;
	private final int totalHours = 12;
	private final double firstHour = 10; 
	private final double bookingTime = 1;
	private final int totalSchedules = 1;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 12;
	
	// Constructor
	public PiscinaBooking() {
		piscinaWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
	}

	public WeekBtn getPiscinaWeek() {
		return piscinaWeek;
	}

	public void setPiscinaWeek(WeekBtn piscinaWeek) {
		this.piscinaWeek = piscinaWeek;
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

package controlador;

public class VoleyBooking {
	private WeekBtn voleyWeek;
	private final int sportNumber = 8;
	private final int totalHours = 10;
	private final double firstHour = 7.5;
	private final double bookingTime = 1.5;
	private final int totalSchedules = 2;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 16;
	
	// Constructor
	public VoleyBooking() {
		voleyWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
	}

	public WeekBtn getVoleyWeek() {
		return voleyWeek;
	}

	public void setVoleyWeek(WeekBtn voleyWeek) {
		this.voleyWeek = voleyWeek;
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

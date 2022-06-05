package controlador;

public class Futbol7Booking {
	private WeekBtn futbol7Week;
	private final int sportNumber = 10;
	private final int totalHours = 10;
	private final double firstHour = 7.5;
	private final double bookingTime = 1.5;
	private final int totalSchedules = 2;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 37;
	
	// Constructor
	public Futbol7Booking() {
		futbol7Week = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
	}

	public WeekBtn getFutbol7Week() {
		return futbol7Week;
	}

	public void setFutbol7Week(WeekBtn futbol7Week) {
		this.futbol7Week = futbol7Week;
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

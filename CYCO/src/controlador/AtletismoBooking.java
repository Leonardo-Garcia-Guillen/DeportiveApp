package controlador;

public class AtletismoBooking {
	private WeekBtn atletismoWeek;
	private final int sportNumber = 11;
	private final int totalHours = 10;
	private final double firstHour = 7.5;
	private final double bookingTime = 1.5;
	private final int totalSchedules = 1;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 20;
	
	// Constructor
	public AtletismoBooking() {
		atletismoWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
	}

	public WeekBtn getAtletismoWeek() {
		return atletismoWeek;
	}

	public void setAtletismoWeek(WeekBtn atletismoWeek) {
		this.atletismoWeek = atletismoWeek;
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

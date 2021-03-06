package controlador;

public class BaloncestoBooking {
	private WeekBtn baloncestoWeek;
	private final int sportNumber = 3;
	private final int totalHours = 10;
	private final double firstHour = 7.5;
	private final double bookingTime = 1.5;
	private final int totalSchedules = 2;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 14;
	
	// Constructor
	public BaloncestoBooking() {
		baloncestoWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
	}

	public WeekBtn getBaloncestoWeek() {
		return baloncestoWeek;
	}

	public void setBaloncestoWeek(WeekBtn baloncestoWeek) {
		this.baloncestoWeek = baloncestoWeek;
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

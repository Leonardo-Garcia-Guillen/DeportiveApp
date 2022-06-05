package controlador;

public class TiroBooking {
	private WeekBtn tiroWeek;
	private final int sportNumber = 6;
	private final int totalHours = 10;
	private final double firstHour = 7.5;
	private final double bookingTime = 1.5;
	private final int totalSchedules = 1;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 10;
	
	// Constructor
	public TiroBooking() {
		tiroWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
	}

	public WeekBtn getTiroWeek() {
		return tiroWeek;
	}

	public void setTiroWeek(WeekBtn tiroWeek) {
		this.tiroWeek = tiroWeek;
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

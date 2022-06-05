package controlador;

public class FutbolSalaBooking {
	private WeekBtn futbolSalaWeek;
	private final int sportNumber = 9;
	private final int totalHours = 10;
	private final double firstHour = 7.5;
	private final double bookingTime = 1.5;
	private final int totalSchedules = 2;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 14;
	
	// Constructor
	public FutbolSalaBooking() {
		futbolSalaWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
	}

	public WeekBtn getFutbolSalaWeek() {
		return futbolSalaWeek;
	}

	public void setFutbolSalaWeek(WeekBtn futbolSalaWeek) {
		this.futbolSalaWeek = futbolSalaWeek;
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

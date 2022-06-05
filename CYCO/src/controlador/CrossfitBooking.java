package controlador;

public class CrossfitBooking {
	private WeekBtn crossfitWeek;
	private final int sportNumber = 5;
	private final int totalHours = 10;
	private final double firstHour = 7.30; 
	private final double bookingTime = 1.5;
	private final int totalSchedules = 1;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 35;
	
	// Constructor
	public CrossfitBooking() {
		crossfitWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
	}

	public WeekBtn getCrossfitWeek() {
		return crossfitWeek;
	}

	public void setCrossfitWeek(WeekBtn crossfitWeek) {
		this.crossfitWeek = crossfitWeek;
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

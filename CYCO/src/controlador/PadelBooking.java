package controlador;

public class PadelBooking {
	private WeekBtn padelWeek;
	private final int totalHours = 10;
	private final double firstHour = 7.5;
	private final double bookingTime = 1.5;
	private final int totalSchedules = 2;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 4;
	
	// Constructor
	public PadelBooking() {
		padelWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
	}

	public int getAvailableHour() {
		return 0;
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

	public WeekBtn getPadelWeek() {
		return padelWeek;
	}

	public void setPadelWeek(WeekBtn padelWeek) {
		this.padelWeek = padelWeek;
	}

	public int getTotalUsers() {
		return totalUsers;
	}

	

	

	
}

package controlador;

public class TenisBooking {
	private WeekBtn tenisWeek;
	private final int sportNumber = 1;
	private final int totalHours = 10;
	private final double firstHour = 7.5;
	private final double bookingTime = 1.5;
	private final int totalSchedules = 2;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 4;
	
	// Constructor
	public TenisBooking() {
		tenisWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
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

	public WeekBtn getTenisWeek() {
		return tenisWeek;
	}

	public void setTenisWeek(WeekBtn tenisWeek) {
		this.tenisWeek = tenisWeek;
	}

	public int getTotalUsers() {
		return totalUsers;
	}

	public int getSportNumber() {
		return sportNumber;
	}

	

	

	
}

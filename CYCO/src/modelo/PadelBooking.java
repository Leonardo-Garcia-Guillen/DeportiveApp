package modelo;

public class PadelBooking {
	private WeekBtn padelWeek;
	private final int totalHours = 10;
	private final double firstHour = 7.5;
	private final double bookingTime = 1.5;
	private final int totalSchedules = 2;

	// Constructor
	public PadelBooking() {
		padelWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
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

	

	
}
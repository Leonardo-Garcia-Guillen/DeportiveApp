package controlador;

public class BaloncestoBooking {
	private WeekBtn baloncestoWeek;
	private final int sportNumber = 3;
	private final int totalHours = 10;
	private final double firstHour = 7.5;
	private final double bookingTime = 1.5;
	private final int totalSchedules = 1;
	
	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 4;
	
	// Constructor
	public BaloncestoBooking() {
		baloncestoWeek = new WeekBtn(totalSchedules,totalHours,firstHour,bookingTime);
		
	}


	

	
}

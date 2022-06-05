package controlador;

public class EsgrimaBooking {
	private WeekBtn esgrimaWeek;
	private final int sportNumber = 7;
	private final int totalHours = 12;
	private final double firstHour = 10;
	private final double bookingTime = 1;
	private final int totalSchedules = 2;

	// Cuantos usuarios pueden llegar a usar una hora en padel
	private final int totalUsers = 8;

	// Constructor
	public EsgrimaBooking() {
		esgrimaWeek = new WeekBtn(totalSchedules, totalHours, firstHour, bookingTime);
	}

	public WeekBtn getEsgrimaWeek() {
		return esgrimaWeek;
	}

	public void setEsgrimaWeek(WeekBtn esgrimaWeek) {
		this.esgrimaWeek = esgrimaWeek;
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
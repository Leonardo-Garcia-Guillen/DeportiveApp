package modelo;

public class BANCO_PRUEBAS {
	
	public static void main(String[] args) {
		PadelBooking padel = new PadelBooking();
		for (int s=0;s<2;s++) {
			for (int i = 0;i<10;i++) {
			System.out.println(padel.getPadelWeek().getDayBtn(0).getSchedules().get(s).getSchedule().get(i).getHourStr());
		}
		}
		
	}

}

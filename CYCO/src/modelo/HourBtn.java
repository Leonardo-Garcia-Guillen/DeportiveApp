package modelo;

public class HourBtn {
	private String hourStr;
	
	private static String staticHourStr = "";
	public HourBtn(double firstHour, double bookingTime) {
		hourStr = newHourStr(firstHour,bookingTime);
	}
	
	public String newHourStr(double firstHour, double bookingTime) {
		int unidad, unidadBookingTime;
		int decimal, decimalAux, decimalBookingTime, decimalBookingTimeAux;
	
		double hourFinal;
		
		// Hora inicial, tomo unidad y decimales
		unidad = (int) Math.floor(firstHour);
		decimal = (int)((firstHour - unidad)*100);
		// Si decimal es "media", pongo 30 por ser horario
		if (decimal != 0)
			decimalAux = 3;
		else
			decimalAux = 0;
		
		// Hora finalizacion actividad = hora inicial + duracion actividad
		hourFinal = firstHour + bookingTime;
		
		// Hora tope para cualquier actividad: 22:00
		if (hourFinal >= 22)
			hourFinal = 22;
		
		// Tomo unidad y decimales, y lo mismo que antes
		unidadBookingTime = (int) Math.floor(hourFinal);
		decimalBookingTime = (int)((hourFinal - unidadBookingTime)*100);
		if (decimalBookingTime != 0)
			decimalBookingTimeAux = 3;
		else
			decimalBookingTimeAux = 0;
		
		// Muestro los "Aux" ya que son en formato horario: "30"
		staticHourStr = unidad+":"+decimalAux+"0"+" - "+unidadBookingTime+":"+decimalBookingTimeAux+"0";
		
		return staticHourStr;
	}


	public String getHourStr() {
		return hourStr;
	}

	public void setHourStr(String hourStr) {
		this.hourStr = hourStr;
	}

	
	
	
}

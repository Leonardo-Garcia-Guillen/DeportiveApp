package controlador;

import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DayHourList {
	private LinkedList<LinkedList<LinkedList<JButton>>> weekList;
	private LinkedList<LinkedList<JButton>> dayList;
	private LinkedList<JButton> hourList;
	
	
	
	public DayHourList(PadelBooking sport,JPanel[] panel) {
		
		initHourBtns(sport,panel);
		
		/*for (int d=0;d<7;d++) {
			for (int i = 0; i < schedules; i++) {
				for (int j = 0; j < hours; j++) {
					hourList.add(null);
				}
				dayList.add(hourList);
			}
			weekList.add(dayList);
		}
		*/
	}
	
	public void initHourBtns(PadelBooking sport, JPanel[] panel) {
		int x = 0;
		int y = 0;
		int weekYear;
		int totalSchedules = sport.getTotalSchedules();
		int totalHours = sport.getTotalHours();
		for (int day = 0; day < 7; day++) {
			weekYear = sport.getPadelWeek().getDayBtn(day).getWeekYear();
			for (int schedule = 0; schedule < totalSchedules; schedule++) {
				
				for (int hour = 0; hour < totalHours; hour++) {
					JButton btnHoursArray = new JButton(sport.getPadelWeek().getDayBtn(day).getSchedules().get(schedule)
							.getSchedule().get(hour).getHourStr());
					// Nombre: 0 (padel) + nº de la semana respecto del año + dia + pista + hora
					btnHoursArray.setName(
							"0-" + weekYear + "-" + day + "-" + schedule + "-" + btnHoursArray.getText());
					panel[day].add(btnHoursArray);
					btnHoursArray.setForeground(new Color(71, 0, 100));
					btnHoursArray.setFont(new Font("Calibri", Font.BOLD, 16));
					btnHoursArray.setBackground(new Color(248, 248, 255));
					
					if (y >= 5) {
						y = 0;
						x = 1;
					}

					btnHoursArray.setBounds((106 + x * 201) + (schedule * 808), 10 + y * 64, 139, 32);
					y++;
					//weekList.getWeekList().get(day).get(schedule).get(hour).add(btnHoursArray[hour]);
					//btnList.get(day).get(schedule).add(hour, btnHoursArray[hour]);
					hourList.add(btnHoursArray);
				}
				
				
				x = 0;
				y = 0;
				dayList.add(hourList);
			}
			weekList.add(dayList);
		}
		
	}
	
	
	public LinkedList<LinkedList<LinkedList<JButton>>> getWeekList() {
		return weekList;
	}
	public void setWeekList(LinkedList<LinkedList<LinkedList<JButton>>> weekList) {
		this.weekList = weekList;
	}
	
	
	
}

package controlador;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChangePanelHours {
	public ChangePanelHours() {

	}
public void newPanelHours(String day, JPanel[] panel) {
		
		for (int i=0;i<panel.length;i++) {
			panel[i].setVisible(false);
		}
		
		if (day.equals("LUNES"))
			panel[0].setVisible(true);
		else if (day.equals("MARTES"))
			panel[1].setVisible(true);
		else if (day.equals("MIERCOLES"))
			panel[2].setVisible(true);
		else if (day.equals("JUEVES"))
			panel[3].setVisible(true);
		else if (day.equals("VIERNES"))
			panel[4].setVisible(true);
		else if (day.equals("SABADO"))
			panel[5].setVisible(true);
		else if (day.equals("DOMINGO"))
			panel[6].setVisible(true);

	}

	
/*
	public void newPanelHours(String day, JButton[] btns,int totalBtns) {
		int dayN=0;
		int init = dayN*totalBtns-1;
		if (day.equals("LUNES")) {
			dayN = 0;
			init = dayN*totalBtns;
		}			
		else if (day.equals("MARTES"))
			dayN = 1;
		else if (day.equals("MIERCOLES"))
			dayN = 2;
		else if (day.equals("JUEVES"))
			dayN = 3;
		else if (day.equals("VIERNES"))
			dayN = 4;
		else if (day.equals("SABADO"))
			dayN = 5;
		else if (day.equals("DOMINGO"))
			dayN = 6;
		
		for (int i=0;i<btns.length;i++) {
			btns[i].setVisible(false);
		}
		
		for (int i=init;i<dayN*totalBtns;i++) {
			btns[i].setVisible(true);
		}

	}*/
	

}

package controlador;

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

}

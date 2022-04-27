package controlador;

import javax.swing.JPanel;

public class ChangePanelHours {
	public ChangePanelHours() {

	}

	public void newPanelHours(String day, JPanel[] panel) {
		for (int i=0;i<panel.length;i++) {
			panel[i].setVisible(false);
		}
		if (day == "LUNES")
			panel[0].setVisible(true);
		else if (day == "MARTES")
			panel[1].setVisible(true);
		else if (day == "MIERCOLES")
			panel[2].setVisible(true);
		else if (day == "JUEVES")
			panel[3].setVisible(true);
		else if (day == "VIERNES")
			panel[4].setVisible(true);
		else if (day == "SABADO")
			panel[5].setVisible(true);
		else if (day == "DOMINGO")
			panel[6].setVisible(true);

	}

}

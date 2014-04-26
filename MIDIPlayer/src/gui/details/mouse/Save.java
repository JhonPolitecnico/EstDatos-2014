package gui.details.mouse;

import gui.details.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import midi.Cancion;

public class Save implements ActionListener {

	private Controller controller;

	public Save(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent aE) {
		Cancion song = this.controller.getSong();

		song.setArtista(this.controller.getTxtArtista().getText());
		int year = 0;
		try {
			year = (Integer.parseInt(this.controller.getTxtAño().getText()));
		} catch (Exception e) {
		}
		song.setAño(year);
		song.setCasaDiscografica(this.controller.getTxtDisco().getText());
		song.setTitulo(this.controller.getTxtTitulo().getText());

		this.controller.dispose();
	}

}

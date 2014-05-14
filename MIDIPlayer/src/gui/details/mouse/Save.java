package gui.details.mouse;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.details.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import midi.Song;

public class Save implements ActionListener {

	private Controller controller;

	public Save(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent aE) {
		Song song = this.controller.getSong();

		song.setArtist(this.controller.getTxtArtist().getText());
		int year = 0;
		try {
			year = (Integer.parseInt(this.controller.getTxtYear().getText()));
		} catch (Exception e) {
		}
		song.setYear(year);
		song.setAlbum(this.controller.getTxtAlbum().getText());
		song.setTitle(this.controller.getTxtTitle().getText());

		this.controller.dispose();
	}

}

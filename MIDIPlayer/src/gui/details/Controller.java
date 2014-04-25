package gui.details;

import javax.swing.JFrame;

import midi.Cancion;

public class Controller extends Details {

	private static final long serialVersionUID = -4549619257548714350L;

	private Cancion song;

	public Controller(JFrame owner, Cancion song) {
		super();
		this.song = song;

		long minutes = 0;
		long seconds = 0;
		long milliseconds = this.song.getDuracion() / 1000;

		if (milliseconds >= 1000) {
			seconds = milliseconds / 1000;
			milliseconds = milliseconds - (seconds * 1000);
		}

		if (seconds >= 60) {
			minutes = seconds / 60;
			seconds = seconds - (minutes * 60);
		}

		this.txtDuracion.setText(String.valueOf(minutes) + ":" + String.valueOf(seconds) + ":" + String.valueOf(milliseconds));
		this.txtArchivo.setText(this.song.getArchivo().getFileName());

		this.setLocationRelativeTo(owner);
		this.setVisible(true);
	}

	/*
	 * Getters & Setters
	 */

}

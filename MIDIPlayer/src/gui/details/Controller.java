package gui.details;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.details.mouse.Cancel;
import gui.details.mouse.Save;

import javax.swing.JFrame;

import midi.Song;

public class Controller extends Details {

	private static final long serialVersionUID = -4549619257548714350L;

	private Song song;

	public Controller(JFrame owner, Song song) {
		super();
		this.song = song;

		this.txtArchivo.setText(this.song.getMIDIFile().getFileName());
		this.txtArtista.setText(this.song.getArtist());
		this.txtAño.setText(String.valueOf(this.song.getYear()));
		this.txtDisco.setText(this.song.getAlbum());
		this.txtDuracion.setText(this.song.getLength());
		this.txtTitulo.setText(this.song.getTitle());

		/*
		 * Eventos
		 */
		this.btnCancelar.addActionListener(new Cancel(this));
		this.btnGuardar.addActionListener(new Save(this));

		this.setLocationRelativeTo(owner);
		this.setVisible(true);
	}

	/*
	 * Getters & Setters
	 */

	public Song getSong() {
		return song;
	}

}

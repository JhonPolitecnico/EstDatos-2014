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

import midi.Cancion;

public class Controller extends Details {

	private static final long serialVersionUID = -4549619257548714350L;

	private Cancion song;

	public Controller(JFrame owner, Cancion song) {
		super();
		this.song = song;

		this.txtArchivo.setText(this.song.getArchivo().getFileName());
		this.txtArtista.setText(this.song.getArtista());
		this.txtA�o.setText(String.valueOf(this.song.getA�o()));
		this.txtDisco.setText(this.song.getCasaDiscografica());
		this.txtDuracion.setText(this.song.getDuracion());
		this.txtTitulo.setText(this.song.getTitulo());

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

	public Cancion getSong() {
		return song;
	}

}

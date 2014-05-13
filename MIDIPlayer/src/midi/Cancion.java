package midi;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.Serializable;

import midi.player.MIDIPlayer;

public class Cancion implements Serializable {

	private static final long serialVersionUID = 4614709442745098197L;

	private String titulo;
	private String artista;
	private int año;
	private String casaDiscografica;
	private String duracion;
	private MIDIFile mIDIFile;

	public Cancion(MIDIFile mIDIFile) {
		super();
		this.mIDIFile = mIDIFile;

		/**
		 * Set time of song
		 */
		MIDIPlayer tempPlayer = new MIDIPlayer(this.mIDIFile);

		if (!tempPlayer.prepare()) {
			this.duracion = "00:00:00";
			return;
		}

		long microseconds = tempPlayer.getMicrosecondTime();
		long minutes = 0;
		long seconds = 0;
		long milliseconds = microseconds / 1000;

		if (milliseconds >= 1000) {
			seconds = milliseconds / 1000;
			milliseconds = milliseconds - (seconds * 1000);
		}

		if (seconds >= 60) {
			minutes = seconds / 60;
			seconds = seconds - (minutes * 60);
		}

		this.duracion = String.format("%02d:%02d:%04d", minutes, seconds, milliseconds);

	}

	public String toString() {

		if (this.titulo != null)
			return this.titulo;

		if (this.mIDIFile != null)
			return mIDIFile.getFileName();

		return "No disponible";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getCasaDiscografica() {
		return casaDiscografica;
	}

	public void setCasaDiscografica(String casaDiscografica) {
		this.casaDiscografica = casaDiscografica;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public MIDIFile getArchivo() {
		return mIDIFile;
	}

}

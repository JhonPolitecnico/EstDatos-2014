package midi;

import midi.player.MIDIPlayer;

public class Cancion {

	private String titulo;
	private String artista;
	private int año;
	private String casaDiscografica;
	private long duracion;
	private MIDIFile archivo;

	public Cancion(MIDIFile archivo) {
		super();
		this.archivo = archivo;
		this.duracion = (new MIDIPlayer(this.archivo)).getMicrosecondTime();

	}

	public String toString() {

		if (this.titulo != null)
			return this.titulo;

		if (this.archivo != null)
			return archivo.getFileName();

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

	public long getDuracion() {
		return duracion;
	}

	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}

	public MIDIFile getArchivo() {
		return archivo;
	}

}

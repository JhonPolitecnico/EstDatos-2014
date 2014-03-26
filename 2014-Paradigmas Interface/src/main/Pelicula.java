package main;

public class Pelicula {
	private String nombre;
	private Hora horaInicio;
	private Hora horaFin;
	private int sillas[][];

	public Pelicula(String nombre, Hora horaInicio, Hora horaFin) {
		super();
		this.nombre = nombre;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Hora getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Hora horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Hora getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Hora horaFin) {
		this.horaFin = horaFin;
	}

	public int[][] getSillas() {
		return sillas;
	}

	public void setSillas(int[][] sillas) {
		this.sillas = sillas;
	}

	public boolean ocuparSilla(int x, int y) {
		if (this.sillas[x][y] == 0)
			return false;

		this.sillas[x][y] = 1;
		return true;
	}

}

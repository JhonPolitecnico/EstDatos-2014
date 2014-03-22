package main;

public class Pelicula {
	String nombre;
	Hora horaInicio;
	Hora horaFin;

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

}

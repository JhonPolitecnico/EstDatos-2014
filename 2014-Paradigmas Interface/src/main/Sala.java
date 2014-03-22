package main;

import java.util.ArrayList;

public class Sala {
	Hora horaInicio;
	Hora horaFin;
	ArrayList<Pelicula> peliculas;

	public Sala(Hora horaInicio, Hora horaFin) {
		super();
		peliculas = new ArrayList<Pelicula>();
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
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

	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}

}

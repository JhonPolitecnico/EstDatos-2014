package main;

import java.util.ArrayList;

public class Sala {
	private Hora horaInicio;
	private Hora horaFin;
	private ArrayList<Pelicula> peliculas;
	private int sillas[][];

	public Sala(Hora horaInicio, Hora horaFin, int noFilas, int NoColumnas) {
		super();
		peliculas = new ArrayList<Pelicula>();
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.sillas = new int[noFilas][NoColumnas];
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

	public int[][] getSillas() {
		return sillas.clone();
	}

	public boolean AgregarPelicula(Pelicula peli) {

		// Si la película esta en el horario de la this de cine
		if ((peli.getHoraInicio().mayorQue(this.getHoraInicio()) || peli.getHoraInicio().igualQue(this.getHoraInicio()))
				&& (peli.getHoraFin().menorQue(this.getHoraFin()) || peli.getHoraFin().igualQue(this.getHoraFin()))) {

			if (this.getPeliculas().size() == 0) {
				peli.setSillas(this.getSillas()); // Crear una copia de las sillas de la sala
				this.getPeliculas().add(peli);
				return true;
			}

			for (Pelicula sPeli : this.getPeliculas()) {

				// Caso 1, Nueva peli luego de la peli antigua || Caso 2, Nueva
				// peli antes de la peli antigua
				if (!peli.getHoraInicio().mayorQue(sPeli.getHoraFin()) || !peli.getHoraFin().menorQue(sPeli.getHoraInicio()))
					return false;

			}

			return true;
		}

		return false;
	}

}

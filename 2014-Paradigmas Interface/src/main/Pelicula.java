package main;

public class Pelicula {
	private String nombre;
	private Hora horaInicio;
	private Hora horaFin;

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
		System.out.println("Peli:" + horaInicio.getHora() + ":" + horaInicio.getMinuto() + ":" + horaInicio.getSegundo());
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

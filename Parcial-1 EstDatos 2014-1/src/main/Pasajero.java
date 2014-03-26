package main;

public class Pasajero {
	private String nombre;
	private int ID;
	private int edad;
	private int noReserva;

	public Pasajero(String nombre, int iD, int edad, int noReserva) {
		super();
		this.nombre = nombre;
		ID = iD;
		this.edad = edad;
		this.noReserva = noReserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNoReserva() {
		return noReserva;
	}

	public void setNoReserva(int noReserva) {
		this.noReserva = noReserva;
	}

}

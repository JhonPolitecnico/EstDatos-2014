package main;

import java.util.Date;

import lista.Lista;

public class Pista {
	private String nombre;
	private int no;
	private boolean vuelosNacionales;
	private boolean vuelosinternacionales;
	private Date horarioInicio;
	private Date horarioFin;

	private Lista vuelos = new Lista();

	public Pista(String nombre, int no, boolean vuelosNacionales, boolean vuelosinternacionales, Date horarioInicio, Date horarioFin) {
		super();
		this.nombre = nombre;
		this.no = no;
		this.vuelosNacionales = vuelosNacionales;
		this.vuelosinternacionales = vuelosinternacionales;
		this.horarioInicio = horarioInicio;
		this.horarioFin = horarioFin;
	}

	public Lista getVuelos() {
		return this.vuelos;
	}

	public boolean hasVuelo(String ID) {
		Vuelo v = null;
		for (int i = 0; i < this.vuelos.getLength(); i++) {
			v = (Vuelo) this.vuelos.getItem(i);
			if (v.getID() == ID)
				return true;
		}
		return false;
	}

	public Vuelo getVuelo(String ID) {
		Vuelo v = null;
		for (int i = 0; i < this.vuelos.getLength(); i++) {
			v = (Vuelo) this.vuelos.getItem(i);
			if (v.getID() == ID)
				return v;
		}
		return null;
	}

	public void agregarVuelo(Vuelo vuelo) {
		this.vuelos.addItem(vuelo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public boolean isVuelosNacionales() {
		return vuelosNacionales;
	}

	public void setVuelosNacionales(boolean vuelosNacionales) {
		this.vuelosNacionales = vuelosNacionales;
	}

	public boolean isVuelosinternacionales() {
		return vuelosinternacionales;
	}

	public void setVuelosinternacionales(boolean vuelosinternacionales) {
		this.vuelosinternacionales = vuelosinternacionales;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(Date horarioFin) {
		this.horarioFin = horarioFin;
	}

}

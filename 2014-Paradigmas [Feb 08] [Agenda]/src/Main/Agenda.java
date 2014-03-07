package Main;

import java.util.ArrayList;

public class Agenda {
	private ArrayList<Persona> personas;

	public Agenda() {
		super();
		this.personas = new ArrayList<Persona>();
	}

	public boolean hasPersonas() {
		return (this.personas.size() > 0);
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(String nombre, int dni) {
		int id;
		this.personas.add(new Persona(nombre, dni));
		id = this.personas.size() - 1;
		this.getPersona(id).setId(id);
		return this.getPersona(id);
	}

	public Persona getPersona(int id) {
		return this.personas.get(id);
	}

	public Persona setPersona(int id, Persona persona) {
		return this.personas.set(id, persona);
	}

}

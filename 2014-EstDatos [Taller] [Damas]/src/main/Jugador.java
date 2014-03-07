package main;

public class Jugador {
	private String nombre;
	private Color color;

	public Jugador(String nombre, Color color) {
		super();
		this.nombre = nombre;
		this.color = color;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
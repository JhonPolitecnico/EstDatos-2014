package main;

public class Ficha {
	private boolean reina;

	private Color color;

	public Ficha(Color color) {
		this.color = color;
		this.reina = false;
	}

	public boolean isReina() {
		return reina;
	}

	public void setReina() {
		this.reina = true;
	}

	public Color getColor() {
		return color;
	}

}
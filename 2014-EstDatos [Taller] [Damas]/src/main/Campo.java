package main;

public class Campo {
	private Ficha ficha;
	private Color color;

	public Campo(Color color) {
		super();
		this.color = color;
	}

	public boolean hasFicha() {
		return (this.ficha != null);
	}

	public Ficha getFicha() {
		return this.ficha;
	}

	public void setFicha(Ficha newFicha) {
		this.ficha = newFicha;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void vaciar() {
		this.ficha = null;
	}
}
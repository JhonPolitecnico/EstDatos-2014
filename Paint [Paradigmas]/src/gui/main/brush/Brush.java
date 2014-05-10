package gui.main.brush;

public enum Brush {
	LINE(0), TRIANGLE(1), SQUARE(2), POLYGON(3);

	private int value;

	private Brush(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

package graphic;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Brush {

	protected Color color;

	public Brush(Color color) {
		super();
		this.color = color;
	}

	public void paint(Graphics g) {
		g.setColor(this.color);
	}
}

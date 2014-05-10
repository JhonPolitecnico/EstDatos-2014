package graphic;

import java.awt.Color;
import java.awt.Graphics;

import position.Position;

public class Line extends BasicFigure {

	public Line(Color color, Position posStart, Position posEnd) {
		super(color, posStart, posEnd);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(super.posStart.getX(), super.posStart.getY(), super.posEnd.getX(), super.posEnd.getY());
	}
}

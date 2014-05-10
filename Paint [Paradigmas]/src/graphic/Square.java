package graphic;

import java.awt.Color;
import java.awt.Graphics;

import position.Position;

public class Square extends BasicFigure {

	public Square(Color color, Position posStart, Position posEnd) {
		super(color, posStart, posEnd);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawRect(this.posStart.getX(), this.posStart.getY(), this.posEnd.getX() - this.posStart.getX(), this.posEnd.getY() - this.posStart.getY());
	}
}

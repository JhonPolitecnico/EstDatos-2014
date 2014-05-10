package graphic;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
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

		int x;

		if (this.posEnd.getX() >= this.posStart.getX()) {

			x = this.posEnd.getX() - this.posStart.getX();

			if (this.posEnd.getY() >= this.posStart.getY()) {
				g.drawRect(this.posStart.getX(), this.posStart.getY(), x, this.posEnd.getY() - this.posStart.getY());
			} else {
				g.drawRect(this.posStart.getX(), this.posEnd.getY(), x, this.posStart.getY() - this.posEnd.getY());
			}

		} else {
			x = this.posStart.getX() - this.posEnd.getX();

			if (this.posEnd.getY() >= this.posStart.getY()) {
				g.drawRect(this.posEnd.getX(), this.posStart.getY(), x, this.posEnd.getY() - this.posStart.getY());
			} else {
				g.drawRect(this.posEnd.getX(), this.posEnd.getY(), x, this.posStart.getY() - this.posEnd.getY());
			}
		}
	}
}

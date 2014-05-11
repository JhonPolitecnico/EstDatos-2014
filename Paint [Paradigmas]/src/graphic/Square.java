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
import java.io.Serializable;

import position.Position;

public class Square extends BasicFigure implements Serializable {

	private static final long serialVersionUID = -206355307460459959L;

	public Square(Color color, Position posStart, Position posEnd) {
		super(color, posStart, posEnd);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		int x;

		if (super.posEnd.getX() >= super.posStart.getX()) {

			x = super.posEnd.getX() - super.posStart.getX();

			if (super.posEnd.getY() >= super.posStart.getY()) {
				g.drawRect(super.posStart.getX(), super.posStart.getY(), x, super.posEnd.getY() - super.posStart.getY());
			} else {
				g.drawRect(super.posStart.getX(), super.posEnd.getY(), x, super.posStart.getY() - super.posEnd.getY());
			}

		} else {
			x = super.posStart.getX() - super.posEnd.getX();

			if (super.posEnd.getY() >= super.posStart.getY()) {
				g.drawRect(super.posEnd.getX(), super.posStart.getY(), x, super.posEnd.getY() - super.posStart.getY());
			} else {
				g.drawRect(super.posEnd.getX(), super.posEnd.getY(), x, super.posStart.getY() - super.posEnd.getY());
			}
		}
	}
}

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

public class Line extends BasicFigure implements Serializable {

	private static final long serialVersionUID = -2770346558065374781L;

	public Line(Color color, Position posStart, Position posEnd) {
		super(color, posStart, posEnd);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(super.posStart.getX(), super.posStart.getY(), super.posEnd.getX(), super.posEnd.getY());
	}
}

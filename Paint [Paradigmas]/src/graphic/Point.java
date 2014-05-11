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

public class Point extends Brush {

	private Position position;
	private Line line;

	public Point(Color color, Position position) {
		super(color);
		this.position = position;
		this.line = new Line(super.color, this.position, this.position);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.line.paint(g);
	}
}

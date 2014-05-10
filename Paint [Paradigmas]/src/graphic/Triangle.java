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

public class Triangle extends Brush {

	private Position posA;
	private Position posB;
	private Position posC;
	private Line lineA;
	private Line lineB;
	private Line lineC;

	public Triangle(Color color, Position posA, Position posB, Position posC) {
		super(color);
		this.posA = posA;
		this.posB = posB;
		this.posC = posC;
		this.lineA = new Line(color, this.posA, this.posB);
		this.lineB = new Line(color, this.posB, this.posC);
		this.lineC = new Line(color, this.posC, this.posA);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		this.lineA.paint(g);
		this.lineB.paint(g);
		this.lineC.paint(g);
	}

}

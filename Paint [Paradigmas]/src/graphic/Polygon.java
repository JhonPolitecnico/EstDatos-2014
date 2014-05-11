package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import position.Position;

public class Polygon extends Brush implements Serializable {

	private static final long serialVersionUID = -6529200935156761803L;

	private ArrayList<Position> positions = new ArrayList<Position>();

	public Polygon(Color color, ArrayList<Position> positions) {
		super(color);
		this.positions = positions;
	}

	public Polygon(Color color, Position... positions) {
		super(color);
		for (Position position : positions)
			this.positions.add(position);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (int i = 0; i < positions.size(); i++)
			if (i != positions.size() - 1)
				new Line(super.color, positions.get(i), positions.get(i + 1)).paint(g);
			else
				new Line(super.color, positions.get(i), positions.get(0)).paint(g);
	}

}

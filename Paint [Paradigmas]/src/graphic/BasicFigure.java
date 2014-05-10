package graphic;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.Color;

import position.Position;

public class BasicFigure extends Brush {

	protected Position posStart;
	protected Position posEnd;

	public BasicFigure(Color color, Position posStart, Position posEnd) {
		super(color);
		this.posStart = posStart;
		this.posEnd = posEnd;
	}

}

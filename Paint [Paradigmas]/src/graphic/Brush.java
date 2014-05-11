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

public abstract class Brush implements Serializable {

	private static final long serialVersionUID = -2923554404551483905L;
	
	protected Color color;

	public Brush(Color color) {
		super();
		this.color = color;
	}

	public void paint(Graphics g) {
		g.setColor(this.color);
	}
}

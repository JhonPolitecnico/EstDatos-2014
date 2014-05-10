package gui.main.workspace;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import graphic.Brush;
import gui.main.Controller;
import gui.main.workspace.mouse.Line;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Workspace extends JPanel {

	private static final long serialVersionUID = 308183912358545561L;

	private Controller main;
	private ArrayList<Brush> brushes;
	private Brush tempBrush;
	private Line lineListener;

	public Workspace() {
		super();
		this.brushes = new ArrayList<Brush>();
	}

	public void setMain(Controller main) {
		this.main = main;

		this.lineListener = new Line(this.main, this);

		this.addMouseListener(this.lineListener);
		this.addMouseMotionListener(this.lineListener);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (Brush brush : brushes)
			brush.paint(g);

		if (tempBrush != null)
			tempBrush.paint(g);
	}

	public void setTempBrush(Brush tempBrush) {
		this.tempBrush = tempBrush;
		this.repaint();
	}

	public void addBrush(Brush brush) {
		this.brushes.add(brush);
		this.repaint();
	}

}

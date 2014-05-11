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
import gui.main.workspace.mouse.Polygon;
import gui.main.workspace.mouse.Square;
import gui.main.workspace.mouse.Triangle;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Workspace extends JPanel {

	private static final long serialVersionUID = 308183912358545561L;

	private Controller main;
	private ArrayList<Brush> brushes;
	private ArrayList<Brush> tempBrushes;
	private Line lineListener;
	private Square squareListener;
	private Triangle triangleListener;
	private Polygon polygonListener;
	private gui.main.workspace.mouse.Brush brushListener;

	public Workspace() {
		super();
		this.brushes = new ArrayList<Brush>();
		this.tempBrushes = new ArrayList<Brush>();
	}

	public void setMain(Controller main) {
		this.main = main;

		this.lineListener = new Line(this.main, this);
		this.squareListener = new Square(this.main, this);
		this.triangleListener = new Triangle(this.main, this);
		this.polygonListener = new Polygon(this.main, this);
		this.brushListener = new gui.main.workspace.mouse.Brush(this.main, this);

		this.addMouseListener(this.lineListener);
		this.addMouseMotionListener(this.lineListener);

		this.addMouseListener(this.squareListener);
		this.addMouseMotionListener(this.squareListener);

		this.addMouseListener(this.triangleListener);
		this.addMouseMotionListener(this.triangleListener);

		this.addMouseListener(this.polygonListener);
		this.addMouseMotionListener(this.polygonListener);

		this.addMouseListener(this.brushListener);
		this.addMouseMotionListener(this.brushListener);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (Brush brush : brushes)
			brush.paint(g);

		if (tempBrushes != null)
			for (Brush tempBrush : tempBrushes)
				tempBrush.paint(g);
	}

	public void clearBrushes() {
		this.brushes.clear();
		this.repaint();
	}

	public void clearTempBrushes() {
		this.tempBrushes.clear();
		this.repaint();
	}

	public void addTempBrush(Brush tempBrush) {
		this.tempBrushes.add(tempBrush);
		this.repaint();
	}

	public void addBrush(Brush brush) {
		this.brushes.add(brush);
		this.repaint();
	}

	public ArrayList<Brush> getBrushes() {
		return this.brushes;
	}

	public void setBrushes(ArrayList<Brush> brushes) {
		this.brushes = brushes;
		this.repaint();
	}

}

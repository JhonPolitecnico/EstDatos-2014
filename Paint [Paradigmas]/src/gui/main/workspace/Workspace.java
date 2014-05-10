package gui.main.workspace;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import graphic.Brush;
import gui.main.Main;
import gui.main.workspace.mouse.Line;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Workspace extends JPanel {

	private static final long serialVersionUID = 308183912358545561L;

	private Main main;
	private ArrayList<Brush> brushes;

	public Workspace(Main main) {
		super();
		this.main = main;
		this.brushes = new ArrayList<Brush>();

		/*
		 * Events
		 */
		this.addMouseListener(new Line(this.main, this));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (Brush brush : brushes)
			brush.paint(g);
	}

	public void addBrush(Brush brush) {
		this.brushes.add(brush);
	}

}

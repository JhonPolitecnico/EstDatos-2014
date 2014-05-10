package gui.main.workspace.mouse;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.Controller;
import gui.main.brush.Brush;
import gui.main.workspace.Workspace;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import position.Position;

public class Line implements MouseListener {

	private Controller main;
	private Workspace workspace;
	private boolean state;
	private Position posStart;
	private Position posEnd;

	public Line(Controller main, Workspace workspace) {
		super();
		this.main = main;
		this.workspace = workspace;
		this.state = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (main.getBrush().getState() != Brush.LINE)
			return;

		if (!state) {
			this.posStart = new Position(e.getX(), e.getY());
		} else {
			this.posEnd = new Position(e.getX(), e.getY());
			this.workspace.addBrush(new graphic.Line(Color.BLACK, this.posStart, this.posEnd));

		}
		state = !state;

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

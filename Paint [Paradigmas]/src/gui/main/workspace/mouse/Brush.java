package gui.main.workspace.mouse;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import graphic.Point;
import gui.main.Controller;
import gui.main.workspace.Workspace;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import position.Position;

public class Brush implements MouseListener, MouseMotionListener {

	private Controller main;
	private Workspace workspace;

	public Brush(Controller main, Workspace workspace) {
		super();
		this.main = main;
		this.workspace = workspace;
	}

	private void printBrush(MouseEvent e) {
		if (main.getBrush().getState() != gui.main.brush.Brush.BRUSH)
			return;

		this.workspace.addBrush(new Point(main.getColor().getState(), new Position(e.getX(), e.getY())));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

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
		this.printBrush(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.printBrush(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.printBrush(e);
	}

}

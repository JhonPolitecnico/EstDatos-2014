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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import position.Position;

public class Square implements MouseListener, MouseMotionListener {

	private Controller main;
	private Workspace workspace;
	private boolean state;
	private Position posStart;
	private Position posEnd;

	public Square(Controller main, Workspace workspace) {
		super();
		this.main = main;
		this.workspace = workspace;
		this.state = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (main.getBrush().getState() != Brush.SQUARE)
			return;

		if (!state) {
			this.posStart = new Position(e.getX(), e.getY());
		} else {
			this.posEnd = new Position(e.getX(), e.getY());

			this.workspace.setTempBrush(null);
			this.workspace.addBrush(new graphic.Square(this.main.getColor().getState(), this.posStart, this.posEnd));

			this.posStart = null;
			this.posEnd = null;
		}

		// Cambiar el estado
		state = !state;

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// si aun no indica el primer click
		if (!this.state || this.posStart == null)
			return;

		// Si cambio de pincel
		if (main.getBrush().getState() != Brush.SQUARE) {
			this.state = false;
			return;
		}

		// Dibujar una forma temporal
		this.workspace.setTempBrush(new graphic.Square(this.main.getColor().getState(), this.posStart, new Position(e.getX(), e.getY())));
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

package gui.main.workspace.mouse;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import graphic.Line;
import gui.main.Controller;
import gui.main.brush.Brush;
import gui.main.workspace.Workspace;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import position.Position;

public class Triangle implements MouseListener, MouseMotionListener {

	private Controller main;
	private Workspace workspace;
	private int state;
	private Position posA;
	private Position posB;
	private Position posC;

	public Triangle(Controller main, Workspace workspace) {
		super();
		this.main = main;
		this.workspace = workspace;
		this.state = 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (main.getBrush().getState() != Brush.TRIANGLE)
			return;

		if (this.state == 0) {
			this.posA = new Position(e.getX(), e.getY());
		} else if (this.state == 1) {
			this.posB = new Position(e.getX(), e.getY());
		} else {
			this.posC = new Position(e.getX(), e.getY());

			this.workspace.addBrush(new graphic.Triangle(this.main.getColor().getState(), this.posA, this.posB, this.posC));

			this.workspace.clearTempBrushes();
			this.posA = this.posB = this.posC = null;
			this.state = -1; // Restaurar a 0
		}

		// Cambiar el estado
		this.state++;

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// si aun no indica el primer click
		if (this.state == 0 || this.posA == null)
			return;

		// Si cambio de pincel
		if (main.getBrush().getState() != Brush.TRIANGLE) {
			this.state = 0;
			this.workspace.clearTempBrushes();
			return;
		}

		// Dibujar una forma temporal

		Position actual = new Position(e.getX(), e.getY());

		this.workspace.clearTempBrushes();
		// 0 to 1
		if (this.state == 1)
			this.workspace.addTempBrush(new Line(this.main.getColor().getState(), this.posA, actual));
		else { // 1 to 2
			this.workspace.addTempBrush(new graphic.Triangle(this.main.getColor().getState(), this.posA, this.posB, actual));
		}

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

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
import java.util.ArrayList;

import position.Position;

public class Polygon implements MouseListener, MouseMotionListener {

	private Controller main;
	private Workspace workspace;
	private int state;
	private ArrayList<Position> positions;

	public Polygon(Controller main, Workspace workspace) {
		super();
		this.main = main;
		this.workspace = workspace;
		this.state = 0;
		this.positions = new ArrayList<Position>();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (main.getBrush().getState() != Brush.POLYGON)
			return;

		if (this.state == 0) {
			this.positions.add(new Position(e.getX(), e.getY()));
		} else if (e.getButton() == MouseEvent.BUTTON1) { // N lines
			this.positions.add(new Position(e.getX(), e.getY()));
		} else {
			this.positions.add(new Position(e.getX(), e.getY()));
			this.workspace.addBrush(new graphic.Polygon(this.main.getColor().getState(), (ArrayList<Position>) this.positions.clone()));

			this.workspace.clearTempBrushes();
			this.positions.clear();
			this.state = -1; // Restaurar a 0
		}

		// Cambiar el estado
		this.state++;

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// si aun no indica el primer click
		if (this.state == 0 || this.positions.size() <= 0)
			return;

		// Si cambio de pincel
		if (main.getBrush().getState() != Brush.POLYGON) {
			this.state = 0;
			this.workspace.clearTempBrushes();
			this.positions.clear();
			return;
		}

		// Dibujar una forma temporal

		Position actual = new Position(e.getX(), e.getY());
		ArrayList<Position> tempPositions = (ArrayList<Position>) this.positions.clone();
		tempPositions.add(actual);

		this.workspace.clearTempBrushes();
		this.workspace.addTempBrush(new graphic.Polygon(this.main.getColor().getState(), tempPositions));

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

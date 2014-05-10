package gui.main.workspace.mouse;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.Main;
import gui.main.workspace.Workspace;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Line implements MouseListener {

	private Main main;
	private Workspace workspace;

	public Line(Main main, Workspace workspace) {
		super();
		this.main = main;
		this.workspace = workspace;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("ok");
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

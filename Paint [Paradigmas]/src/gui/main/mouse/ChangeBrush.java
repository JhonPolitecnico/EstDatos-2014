package gui.main.mouse;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.brush.Brush;
import gui.main.brush.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import swing.jDataButton.JDataButton;

public class ChangeBrush implements MouseListener {

	private Controller brush;

	public ChangeBrush(Controller brush) {
		super();
		this.brush = brush;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!(e.getSource() instanceof JDataButton))
			return;

		JDataButton btn = (JDataButton) e.getSource();

		brush.setState((Brush) btn.getData());

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

package gui.main.mouse;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.color.Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import swing.jDataButton.JDataButton;

public class ChangeColor implements MouseListener {

	private Controller color;

	public ChangeColor(Controller color) {
		super();
		this.color = color;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!(e.getSource() instanceof JDataButton))
			return;

		JDataButton btn = (JDataButton) e.getSource();

		this.color.setState((Color) btn.getData());

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

package gui.main.workspace;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.Graphics;

import javax.swing.JPanel;

public class Workspace extends JPanel {

	private static final long serialVersionUID = 308183912358545561L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		g.drawLine(0, 0, 100, 100);
	}

}

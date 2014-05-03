package gui.main.workspace;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Workspace extends JPanel {

	private static final long serialVersionUID = 308183912358545561L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, 100, 100);

		g.setColor(Color.BLUE);
		g.drawLine(0, 50, 100, 150);

		g.setColor(Color.RED);
		g.drawLine(0, 100, 100, 200);
	}

}

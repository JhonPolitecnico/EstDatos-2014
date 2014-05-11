package gui.main.mouse;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.workspace.Workspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class New implements ActionListener {

	private Workspace workspace;

	public New(Workspace workspace) {
		this.workspace = workspace;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.workspace.clearBrushes();
	}

}

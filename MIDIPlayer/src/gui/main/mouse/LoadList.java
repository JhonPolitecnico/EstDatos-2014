package gui.main.mouse;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Load the "Load" frame
 *
 */
public class LoadList implements ActionListener {

	private Controller controller;

	public LoadList(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		new gui.load.Controller(this.controller);
	}

}

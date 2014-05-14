package gui.details.mouse;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.details.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Abort editing the music file
 *
 */
public class Cancel implements ActionListener {

	private Controller controller;

	public Cancel(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		this.controller.dispose();
	}

}

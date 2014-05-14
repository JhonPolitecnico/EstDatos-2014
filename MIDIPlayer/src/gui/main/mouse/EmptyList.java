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
 * Clear playlist
 * 
 */
public class EmptyList implements ActionListener {

	private Controller controller;

	public EmptyList(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		controller.getMIDIList().clear();
	}

}

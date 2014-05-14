package gui.main.check;

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
 * Set repeat playlist
 *
 */
public class Repeat implements ActionListener {

	private Controller controller;

	public Repeat(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		controller.getPlayerController().setRepeat(!controller.getPlayerController().isRepeat());
	}

}

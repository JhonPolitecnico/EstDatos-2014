package gui.main.mouse;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayAndPause extends MouseAdapter {

	private Controller controller;

	public PlayAndPause(Controller controller) {
		super();
		this.controller = controller;
	}

	public void mouseClicked(MouseEvent e) {
		if (controller.getMIDIList().size() <= 0)
			return;

		if (!controller.getPlayerController().isPlaying())
			controller.getPlayerController().playCurrent();
		else
			controller.getPlayerController().playAndPause();
	}

}

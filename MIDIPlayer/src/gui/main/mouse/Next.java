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

/**
 * Play next song
 * 
 */
public class Next extends MouseAdapter {

	private Controller controller;

	public Next(Controller controller) {
		super();
		this.controller = controller;
	}

	public void mouseClicked(MouseEvent e) {
		if (controller.getMIDITable().getRowCount() <= 0)
			return;

		controller.getPlayerController().nextSong();
	}

}

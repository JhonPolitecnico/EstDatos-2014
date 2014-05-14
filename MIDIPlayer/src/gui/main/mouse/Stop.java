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
 * Stop actual song
 *
 */
public class Stop extends MouseAdapter {

	private Controller controller;

	public Stop(Controller controller) {
		super();
		this.controller = controller;
	}

	public void mouseClicked(MouseEvent e) {
		if (!controller.getPlayerController().isPlaying())
			return;

		controller.getPlayerController().stop();
	}

}

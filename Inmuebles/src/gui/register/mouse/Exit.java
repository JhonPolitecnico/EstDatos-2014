package gui.register.mouse;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.register.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Exit application
 * 
 */
public class Exit extends MouseAdapter {

	private Controller registerController;

	public Exit(Controller registerController) {
		this.registerController = registerController;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.registerController.dispose();
	}
}

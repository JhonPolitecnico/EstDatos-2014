package gui.property.list.window;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.login.Controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import library.Library;
import serializer.engine.Serializer;
import utils.Utils;

/**
 * Window Controller
 * 
 * Save the work of the session
 * 
 */
public class WindowController implements WindowListener {

	Controller loginController;

	public WindowController(Controller loginController) {
		super();
		this.loginController = loginController;
	}

	/**
	 * Save roles and properties
	 */
	private void saveRole() {
		Serializer s = new Serializer(Utils.getLibrary());
		Library library = new Library(this.loginController.getRoles());
		s.serialize(library);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		this.saveRole();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.saveRole();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}

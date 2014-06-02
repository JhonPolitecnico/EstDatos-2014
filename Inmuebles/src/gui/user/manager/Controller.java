package gui.user.manager;

import gui.user.manager.mouse.Delete;

import javax.swing.JList;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import user.manager.ManagerModel;

/**
 * Load the saved list
 * 
 */
public class Controller extends Manager {

	private static final long serialVersionUID = -2056308172932341438L;

	private gui.login.Controller loginController;
	private ManagerModel model;

	/**
	 * 
	 * @param main
	 *            Main frame
	 */
	public Controller(gui.login.Controller loginController) {
		super();
		this.loginController = loginController;

		this.model = new ManagerModel();

		for (int i = 0; i < this.loginController.getRoles().size(); i++)
			this.model.addElement(this.loginController.getRoles().get(i).toString());

		this.list.setModel(this.model);
		/**
		 * Events
		 */
		super.btnDelete.addMouseListener(new Delete(this, this.loginController));

		setVisible(true);
	}

	/*
	 * Getters & Setters
	 */

	public JList getList() {
		return super.list;
	}

}

package gui.property.list.mouse;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.login.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import property.Property;
import user.Admin;
import user.Owner;
import user.Rol;

/**
 * Remove multiple properties selected
 * 
 */
public class Delete implements ActionListener {

	private gui.property.list.Controller listController;
	private Controller loginController;

	public Delete(gui.property.list.Controller listController, Controller loginController) {
		super();
		this.listController = listController;
		this.loginController = loginController;
	}

	public void actionPerformed(ActionEvent e) {

		int rows[] = this.listController.getTable().getSelectedRows();

		for (int i = 0; i < rows.length; i++) {

			if (this.loginController.getSession() instanceof Admin) {
				Property property = this.listController.getPropertyTable().getRow(rows[i] - i);

				for (Rol rol : this.loginController.getRoles())
					if (rol instanceof Owner) {
						Owner owner = (Owner) rol;

						if (owner.containsProperty(property)) {
							owner.removeProperty(property);
							break;
						}
					}
			}

			this.listController.getPropertyTable().removeRow(rows[i] - i);
		}
	}
}

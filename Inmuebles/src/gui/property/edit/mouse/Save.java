package gui.property.edit.mouse;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.property.edit.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import property.Property;
import property.list.PropertyTableGUI;
import user.Admin;
import user.Owner;

/**
 * Exit application
 * 
 */
public class Save implements ActionListener {

	private PropertyTableGUI owner;
	private Controller editController;
	private gui.login.Controller loginController;

	public Save(PropertyTableGUI owner, Controller editController, gui.login.Controller loginController) {
		super();
		this.owner = owner;
		this.editController = editController;
		this.loginController = loginController;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		/**
		 * Save property
		 */
		Property property = this.editController.getProperty();

		property.setArea(Double.valueOf(this.editController.getTextArea().getText()));
		property.setAddress(this.editController.getTextAddress().getText());
		property.setCity(this.editController.getTextCity().getText());
		property.setDescription(this.editController.getTxtrDescription().getText());
		property.setStratum(Integer.parseInt(this.editController.getTextStratum().getText()));
		property.setSalePrice(Integer.parseInt(this.editController.getTextSalePrice().getText()));
		property.setLeasePrice(Integer.parseInt(this.editController.getTextLeasePrice().getText()));
		property.setTimeBuilt(this.editController.getTextTimeBuild().getText());
		property.setCostOfAdministration(Integer.parseInt(this.editController.getTextCostOfAdministration().getText()));
		property.setPrivateSecurity(this.editController.getChckbxPrivateSecurity().isSelected());

		if (this.editController.getPhoto() != null)
			property.setPhoto(this.editController.getPhoto().getDescription());
		else
			property.setPhoto("");

		/**
		 * Permissions
		 */
		editController.checkPermissions();

		/**
		 * Add in current user if new
		 */
		if (!(this.loginController.getSession() instanceof Admin)) {
			Owner owner = (Owner) loginController.getSession();

			if (!owner.containsProperty(property))
				owner.addProperty(property);
		}

		this.owner.refreshProperies();
	}
}

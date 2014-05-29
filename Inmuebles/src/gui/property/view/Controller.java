package gui.property.view;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import utils.Utils;
import property.Property;
import user.mask.Flag;

public class Controller extends View {

	private static final long serialVersionUID = 1322530645747508580L;

	private gui.login.Controller loginController;
	private Property property;

	public Controller(gui.login.Controller loginController, Property property) {
		super();
		this.loginController = loginController;
		this.property = property;
		this.prepare();
	}

	private void prepare() {

		/**
		 * Permisions
		 * 
		 */
		if (!Flag.isFlag(this.loginController.getSession().getFlags(), Flag.VIEW))
			Utils.fatalExit();

		/**
		 * GUI
		 */
		super.setTitle("Inmueble" + Utils.getTitle());

		super.textArea.setText(String.valueOf(this.property.getArea()));
		super.textAddress.setText(this.property.getAddress());
		super.textCity.setText(this.property.getCity());
		super.txtrDescription.setText(this.property.getDescription());
		super.textStratum.setText(String.valueOf(this.property.getStratum()));
		super.textSalePrice.setText(String.valueOf(this.property.getSalePrice()));
		super.textLeasePrice.setText(String.valueOf(this.property.getLeasePrice()));
		super.textTimeBuild.setText(this.property.getTimeBuilt());
		super.textCostOfAdministration.setText(String.valueOf(this.property.getCostOfAdministration()));
		super.chckbxPrivateSecurity.setSelected(this.property.isPrivateSecurity());

		try {
			super.lblPhoto.setIcon(Utils.getPhoto(this.property.getPhoto(), 517, 327));
		} catch (Exception e) {
			try {
				super.lblPhoto.setIcon(Utils.getPhoto("not found.png", 517, 327));
			} catch (Exception e1) {
				super.lblPhoto.setIcon(null);
			}
		}

		Utils.centerFrame(this);
		this.setVisible(true);
	}
}

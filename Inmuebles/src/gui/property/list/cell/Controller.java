package gui.property.list.cell;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import property.Property;
import utils.Utils;

public class Controller extends Cell {

	private static final long serialVersionUID = 5723373734859781163L;

	public Controller() {
		super();
	}

	public Controller(Property property) {
		super();

		super.lblArea.setText(super.lblArea.getText() + String.valueOf(property.getArea()));
		super.lblAddress.setText(super.lblAddress.getText() + property.getAddress());
		super.lblCity.setText(super.lblCity.getText() + property.getCity());
		super.lblStratum.setText(super.lblStratum.getText() + String.valueOf(property.getStratum()));
		super.lblSalePrice.setText(super.lblSalePrice.getText() + String.valueOf(property.getSalePrice()));
		super.lblLeasePrice.setText(super.lblLeasePrice.getText() + String.valueOf(property.getLeasePrice()));
		super.lblTimeBuild.setText(super.lblTimeBuild.getText() + property.getTimeBuilt());
		super.lblCostOfAdministration.setText(super.lblCostOfAdministration.getText() + String.valueOf(property.getCostOfAdministration()));
		super.chckbxPrivateSecurity.setSelected(property.isPrivateSecurity());

		try {
			super.lblImage.setIcon(Utils.getPhoto(property.getPhoto(), 150, 100));
		} catch (Exception e) {
			try {
				super.lblImage.setIcon(Utils.getPhoto("not found.png", 150, 100));
			} catch (Exception e1) {
				super.lblImage.setIcon(null);
			}
		}
	}
}

package gui.property.list.cell;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JCheckBox;

public class Cell extends JPanel {

	private static final long serialVersionUID = 2778033245248768762L;
	protected JLabel lblImage;
	protected JLabel lblArea;
	protected JLabel lblAddress;
	protected JLabel lblCity;
	protected JLabel lblStratum;
	protected JLabel lblSalePrice;
	protected JLabel lblLeasePrice;
	protected JLabel lblTimeBuild;
	protected JLabel lblCostOfAdministration;
	protected JLabel lblPrivateSecurity;
	protected JCheckBox chckbxPrivateSecurity;

	/**
	 * Create the panel.
	 */
	public Cell() {
		setSize(new Dimension(850, 121));

		lblImage = new JLabel("");
		lblImage.setBounds(10, 11, 150, 100);
		lblImage.setVerticalAlignment(SwingConstants.TOP);
		lblImage.setAlignmentY(Component.TOP_ALIGNMENT);
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImage.setHorizontalAlignment(SwingConstants.LEFT);

		lblArea = new JLabel("Area: ");
		lblArea.setBounds(166, 11, 245, 14);

		lblAddress = new JLabel("Direcci\u00F3n: ");
		lblAddress.setBounds(166, 36, 245, 14);

		lblCity = new JLabel("Ciudad: ");
		lblCity.setBounds(166, 63, 245, 14);

		lblStratum = new JLabel("Estrato: ");
		lblStratum.setBounds(166, 88, 245, 14);

		lblSalePrice = new JLabel("Precio de venta: ");
		lblSalePrice.setBounds(423, 11, 280, 14);

		lblLeasePrice = new JLabel("Precio de arriendo: ");
		lblLeasePrice.setBounds(423, 36, 280, 14);

		lblTimeBuild = new JLabel("Tiempo de construido: ");
		lblTimeBuild.setBounds(423, 63, 280, 14);

		lblCostOfAdministration = new JLabel("Costro de administraci\u00F3n: ");
		lblCostOfAdministration.setBounds(423, 88, 280, 14);

		lblPrivateSecurity = new JLabel("Seguridad Privada");
		lblPrivateSecurity.setBounds(714, 36, 101, 14);

		chckbxPrivateSecurity = new JCheckBox("");
		chckbxPrivateSecurity.setBounds(754, 57, 21, 21);
		chckbxPrivateSecurity.setVerticalAlignment(SwingConstants.TOP);
		setLayout(null);
		add(lblImage);
		add(lblArea);
		add(lblAddress);
		add(lblCity);
		add(lblStratum);
		add(lblLeasePrice);
		add(lblSalePrice);
		add(lblTimeBuild);
		add(chckbxPrivateSecurity);
		add(lblPrivateSecurity);
		add(lblCostOfAdministration);

	}
}

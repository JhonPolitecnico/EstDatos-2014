package gui.property.edit;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Edit extends JFrame {

	private static final long serialVersionUID = -2284107981984764312L;

	protected JPanel contentPane;
	protected JTextField textArea;
	protected JTextField textAddress;
	protected JTextField textCity;
	protected JTextField textStratum;
	protected JTextField textSalePrice;
	protected JTextField textLeasePrice;
	protected JTextField textTimeBuild;
	protected JTextField textCostOfAdministration;
	protected JMenuBar menuBar;
	protected JMenu mnAcciones;
	protected JMenuItem mntmUpdatePhoto;
	protected JMenuItem mntmSave;
	protected JMenuItem mntmExit;
	protected JLabel lblPhoto;
	protected JCheckBox chckbxPrivateSecurity;
	protected JTextArea txtrDescription;

	/**
	 * Create the frame.
	 */
	public Edit() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 690, 539);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAcciones = new JMenu("Acciones");
		menuBar.add(mnAcciones);

		mntmUpdatePhoto = new JMenuItem("Cambiar imagen");
		mnAcciones.add(mntmUpdatePhoto);

		JSeparator separator = new JSeparator();
		mnAcciones.add(separator);

		mntmSave = new JMenuItem("Guardar");
		mnAcciones.add(mntmSave);

		mntmExit = new JMenuItem("Salir");
		mnAcciones.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblPhoto = new JLabel();
		lblPhoto.setVerticalAlignment(SwingConstants.TOP);
		lblPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPhoto.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel panel = new JPanel();

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblPhoto, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE).addContainerGap(12, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(lblPhoto, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)).addContainerGap()));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panelArea = new JPanel();
		panel.add(panelArea);

		JLabel lblArea = new JLabel("Area:");
		panelArea.add(lblArea);

		textArea = new JTextField();
		textArea.setText("...");
		panelArea.add(textArea);
		textArea.setColumns(10);

		JPanel panelAddress = new JPanel();
		panel.add(panelAddress);

		JLabel lblAddress = new JLabel("Direcci\u00F3n:");
		panelAddress.add(lblAddress);

		textAddress = new JTextField();
		textAddress.setText("...");
		textAddress.setColumns(10);
		panelAddress.add(textAddress);

		JPanel panelCity = new JPanel();
		panel.add(panelCity);

		JLabel lblCity = new JLabel("Ciudad:");
		panelCity.add(lblCity);

		textCity = new JTextField();
		textCity.setText("...");
		textCity.setColumns(10);
		panelCity.add(textCity);

		JPanel panelStratum = new JPanel();
		panel.add(panelStratum);

		JLabel lblStratum = new JLabel("Estrato:");
		panelStratum.add(lblStratum);

		textStratum = new JTextField();
		textStratum.setText("...");
		textStratum.setColumns(10);
		panelStratum.add(textStratum);

		JPanel panelSalePrice = new JPanel();
		panel.add(panelSalePrice);

		JLabel lblSalePrice = new JLabel("Precio de venta:");
		panelSalePrice.add(lblSalePrice);

		textSalePrice = new JTextField();
		textSalePrice.setText("...");
		textSalePrice.setColumns(10);
		panelSalePrice.add(textSalePrice);

		JPanel panelLeasePrice = new JPanel();
		panel.add(panelLeasePrice);

		JLabel lblLeasePrice = new JLabel("Precio de arriendo:");
		panelLeasePrice.add(lblLeasePrice);

		textLeasePrice = new JTextField();
		textLeasePrice.setText("...");
		textLeasePrice.setColumns(10);
		panelLeasePrice.add(textLeasePrice);

		JPanel panelTimeBuild = new JPanel();
		panel.add(panelTimeBuild);

		JLabel lblTimeBuild = new JLabel("Tiempo de construido:");
		panelTimeBuild.add(lblTimeBuild);

		textTimeBuild = new JTextField();
		textTimeBuild.setText("...");
		textTimeBuild.setColumns(10);
		panelTimeBuild.add(textTimeBuild);

		JPanel panelCostOfAdministration = new JPanel();
		panel.add(panelCostOfAdministration);

		JLabel lblCostOfAdministration = new JLabel("Costo de administraci\u00F3n:");
		panelCostOfAdministration.add(lblCostOfAdministration);

		textCostOfAdministration = new JTextField();
		textCostOfAdministration.setText("...");
		textCostOfAdministration.setColumns(10);
		panelCostOfAdministration.add(textCostOfAdministration);

		JPanel panelPrivateSecurity = new JPanel();
		panel.add(panelPrivateSecurity);

		JLabel lblPrivateSecurity = new JLabel("Seguridad privada:");
		panelPrivateSecurity.add(lblPrivateSecurity);

		chckbxPrivateSecurity = new JCheckBox("Si");
		panelPrivateSecurity.add(chckbxPrivateSecurity);

		txtrDescription = new JTextArea();
		txtrDescription
				.setText("Nine Inch Nails aren't on the bill, and they \r\nwon't play the fest anytime soon. Soundwave promoter\r\nAJ Maddah started a Twitter war-of-words with a few \r\nchoice comments about NIN's Trent Reznor.\r\n\r\n---------------------\r\n\r\nlorein");
		scrollPane.setViewportView(txtrDescription);
		contentPane.setLayout(gl_contentPane);
	}
}

package gui.property.user.list;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.Component;

public class List extends JFrame {

	private static final long serialVersionUID = 5759811461465050437L;

	protected JPanel contentPane;
	protected JTable table;
	protected JMenu mnUser;
	protected JMenuBar menuBar;
	protected JMenuItem mntmViewProfile;
	protected JMenuItem mntmEditProfile;
	protected JMenuItem mntmViewEstate;
	protected JMenuItem mntmAddEstate;
	protected JMenuItem mntmLogout;
	protected JMenuItem mntmExit;

	/**
	 * Create the frame.
	 */
	public List() {
		setTitle("Inmuebles");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 480);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnUser = new JMenu("Usuario");
		menuBar.add(mnUser);

		mntmViewProfile = new JMenuItem("Ver perfil");
		mnUser.add(mntmViewProfile);

		mntmEditProfile = new JMenuItem("Editar perfil");
		mnUser.add(mntmEditProfile);

		JSeparator separator = new JSeparator();
		mnUser.add(separator);

		mntmViewEstate = new JMenuItem("Ver inmuebles");
		mnUser.add(mntmViewEstate);

		mntmAddEstate = new JMenuItem("Agregar inmueble");
		mnUser.add(mntmAddEstate);

		JSeparator separator_1 = new JSeparator();
		mnUser.add(separator_1);

		mntmLogout = new JMenuItem("Cerrar sesi\u00F3n");
		mnUser.add(mntmLogout);

		mntmExit = new JMenuItem("Salir");
		mnUser.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);

		table = new JTable();
		table.setAlignmentY(Component.TOP_ALIGNMENT);
		table.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
	}
}

package gui.user.manager;

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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

public abstract class Manager extends JFrame {

	private static final long serialVersionUID = 7374801605100165298L;

	protected JPanel contentPane;
	protected JList list;
	protected JButton btnDelete;

	/**
	 * Create the frame.
	 */
	public Manager() {
		setTitle("Eliminar Usuarios");
		setName("frmSave");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 273, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		btnDelete = new JButton("Eliminar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE).addContainerGap())
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addComponent(btnDelete).addGap(82)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addContainerGap().addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnDelete).addGap(2)));

		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		contentPane.setLayout(gl_contentPane);
	}
}

package gui.register;

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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private static final long serialVersionUID = 8100692450321594610L;

	protected JPanel contentPane;
	protected JTextField txtUsername;
	protected JPasswordField txtPassword;
	protected JComboBox<String> cmbUserType;
	protected JLabel lblUserType;
	protected JLabel lblUsername;
	protected JButton btnCancel;
	protected JLabel lblPassword;
	protected JButton btnRegister;

	/**
	 * Create the frame.
	 */
	public Register() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btnRegister = new JButton("Registrar");

		cmbUserType = new JComboBox<String>();
		cmbUserType.setModel(new DefaultComboBoxModel<String>(new String[] { "Administrador", "Due\u00F1o", "Cliente" }));

		lblUserType = new JLabel("Tipo: ");

		lblUsername = new JLabel("Usuario:");

		txtUsername = new JTextField();
		txtUsername.setColumns(10);

		lblPassword = new JLabel("Contrase\u00F1a:");

		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);

		btnCancel = new JButton("Cancelar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_contentPane
														.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(
																gl_contentPane.createSequentialGroup().addComponent(btnCancel)
																		.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnRegister))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
																						.addComponent(lblUserType, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
																						.addComponent(lblPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)).addGap(8)
																		.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)))
										.addGroup(
												gl_contentPane
														.createSequentialGroup()
														.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
														.addGap(22)
														.addGroup(
																gl_contentPane.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(cmbUserType, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(txtUsername, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblUserType)
										.addComponent(cmbUserType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(6).addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGap(9)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnRegister).addComponent(btnCancel)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}

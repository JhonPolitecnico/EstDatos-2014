package gui.login;

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
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 6764621988629202798L;

	protected JPanel contentPane;
	protected JTextField textUsername;
	protected JTextField textPwd;
	protected JButton btnExit;
	protected JButton btnLogin;
	protected JButton btnGuest;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Imagen");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblUsername = new JLabel("Usuario:");

		textUsername = new JTextField();
		textUsername.setColumns(10);

		textPwd = new JTextField();
		textPwd.setColumns(10);

		JLabel lblPwd = new JLabel("Contrase\u00F1a:");

		btnExit = new JButton("Salir");

		btnLogin = new JButton("Ingresar");

		btnGuest = new JButton("Invitado");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(textUsername, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(lblPwd, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(textPwd, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(btnExit).addGap(60).addComponent(btnGuest)
														.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE).addComponent(btnLogin)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblUsername)
										.addComponent(textUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(textPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(14).addComponent(lblPwd))).addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnExit).addComponent(btnLogin).addComponent(btnGuest))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}

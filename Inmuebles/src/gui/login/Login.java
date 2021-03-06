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
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 6764621988629202798L;

	protected JPanel contentPane;
	protected JTextField textUsername;
	protected JPasswordField textPwd;
	protected JButton btnExit;
	protected JButton btnLogin;
	protected JButton btnGuest;
	protected JLabel lblLogo;
	protected JButton btnNew;

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblLogo = new JLabel("");
		lblLogo.setVerticalAlignment(SwingConstants.TOP);
		lblLogo.setBounds(10, 11, 327, 82);
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblUsername = new JLabel("Usuario:");
		lblUsername.setBounds(10, 112, 58, 14);

		textUsername = new JTextField();
		textUsername.setBounds(90, 106, 247, 23);
		textUsername.setColumns(10);

		textPwd = new JPasswordField();
		textPwd.setBounds(90, 138, 247, 23);
		textPwd.setColumns(10);

		JLabel lblPwd = new JLabel("Contrase\u00F1a:");
		lblPwd.setBounds(10, 141, 72, 14);

		btnExit = new JButton("Salir");
		btnExit.setBounds(10, 169, 82, 23);

		btnLogin = new JButton("Ingresar");
		btnLogin.setBounds(255, 169, 82, 23);

		btnGuest = new JButton("Invitado");
		btnGuest.setBounds(172, 169, 82, 23);
		contentPane.setLayout(null);
		contentPane.add(btnExit);
		contentPane.add(btnGuest);
		contentPane.add(btnLogin);
		contentPane.add(lblLogo);
		contentPane.add(lblUsername);
		contentPane.add(lblPwd);
		contentPane.add(textPwd);
		contentPane.add(textUsername);
		
		btnNew = new JButton("Nuevo");
		btnNew.setBounds(90, 169, 82, 23);
		contentPane.add(btnNew);
	}
}

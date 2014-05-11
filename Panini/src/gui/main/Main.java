package gui.main;

/**
 * Panini
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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;

public class Main extends JFrame {

	private static final long serialVersionUID = -1721385220436993011L;

	protected JPanel contentPane;
	protected JTable table;

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(0)));

		JLabel lblNingunaFicha = new JLabel("Ninguna ficha");
		lblNingunaFicha.setOpaque(true);
		lblNingunaFicha.setBorder(new EmptyBorder(3, 3, 3, 3));
		lblNingunaFicha.setBackground(Color.RED);
		panel.add(lblNingunaFicha);

		JLabel lblSoloUnaFicha = new JLabel("Solo una ficha");
		lblSoloUnaFicha.setBorder(new EmptyBorder(3, 3, 3, 3));
		lblSoloUnaFicha.setOpaque(true);
		lblSoloUnaFicha.setBackground(Color.WHITE);
		panel.add(lblSoloUnaFicha);

		JLabel lblDosFichas = new JLabel("Dos fichas");
		lblDosFichas.setOpaque(true);
		lblDosFichas.setBorder(new EmptyBorder(3, 3, 3, 3));
		lblDosFichas.setBackground(Color.ORANGE);
		panel.add(lblDosFichas);

		JLabel lblMasDeDos = new JLabel("Mas de dos fichas");
		lblMasDeDos.setOpaque(true);
		lblMasDeDos.setBorder(new EmptyBorder(3, 3, 3, 3));
		lblMasDeDos.setBackground(Color.GREEN);
		panel.add(lblMasDeDos);

		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}

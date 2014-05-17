package gui.property.view;

import java.awt.EventQueue;

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

public class View extends JFrame {

	private static final long serialVersionUID = -1017403274124794549L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Inmueble: Nombre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 576);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAcciones = new JMenu("Acciones");
		menuBar.add(mnAcciones);

		JMenuItem mntmSeguir = new JMenuItem("Seguir");
		mnAcciones.add(mntmSeguir);

		JMenuItem mntmPedirCita = new JMenuItem("Pedir cita");
		mnAcciones.add(mntmPedirCita);

		JSeparator separator = new JSeparator();
		mnAcciones.add(separator);

		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnAcciones.add(mntmModificar);

		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnAcciones.add(mntmEliminar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel = new JPanel();

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING, false).addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
										.addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE).addContainerGap(14, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
						.addGap(15)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel lblTag = new JLabel("Tag: ...");
		panel.add(lblTag);

		JLabel label = new JLabel("Tag: ...");
		panel.add(label);

		JLabel label_1 = new JLabel("Tag: ...");
		panel.add(label_1);

		JLabel label_2 = new JLabel("Tag: ...");
		panel.add(label_2);

		JLabel label_3 = new JLabel("Tag: ...");
		panel.add(label_3);

		JLabel label_4 = new JLabel("Tag: ...");
		panel.add(label_4);

		JLabel label_5 = new JLabel("Tag: ...");
		panel.add(label_5);

		JLabel label_6 = new JLabel("Tag: ...");
		panel.add(label_6);

		JLabel label_7 = new JLabel("Tag: ...");
		panel.add(label_7);

		JTextArea txtrNineInchNails = new JTextArea();
		txtrNineInchNails
				.setText("Nine Inch Nails aren't on the bill, and they \r\nwon't play the fest anytime soon. Soundwave promoter\r\nAJ Maddah started a Twitter war-of-words with a few \r\nchoice comments about NIN's Trent Reznor.\r\n\r\n---------------------\r\n\r\nlorein");
		scrollPane.setViewportView(txtrNineInchNails);
		contentPane.setLayout(gl_contentPane);
	}
}

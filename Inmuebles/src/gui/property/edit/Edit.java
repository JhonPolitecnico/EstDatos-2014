package gui.property.edit;

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
import javax.swing.JTextField;

public class Edit extends JFrame {

	private static final long serialVersionUID = -2284107981984764312L;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit frame = new Edit();
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
	public Edit() {
		setTitle("Editar Inmueble: Nombre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 576);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAcciones = new JMenu("Acciones");
		menuBar.add(mnAcciones);
		
		JMenuItem mntmCambiarNombre = new JMenuItem("Cambiar nombre");
		mnAcciones.add(mntmCambiarNombre);
		
		JMenuItem mntmCambiarImagen = new JMenuItem("Cambiar imagen");
		mnAcciones.add(mntmCambiarImagen);
		
		JSeparator separator = new JSeparator();
		mnAcciones.add(separator);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnAcciones.add(mntmGuardar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnAcciones.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel = new JPanel();

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
						.addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
					.addGap(15))
		);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblTag = new JLabel("Tag:");
		panel_1.add(lblTag);
		
		textField = new JTextField();
		textField.setText("...");
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel label = new JLabel("Tag:");
		panel_2.add(label);
		
		textField_1 = new JTextField();
		textField_1.setText("...");
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel label_1 = new JLabel("Tag:");
		panel_3.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setText("...");
		textField_2.setColumns(10);
		panel_3.add(textField_2);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel label_2 = new JLabel("Tag:");
		panel_4.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setText("...");
		textField_3.setColumns(10);
		panel_4.add(textField_3);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel label_3 = new JLabel("Tag:");
		panel_5.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setText("...");
		textField_4.setColumns(10);
		panel_5.add(textField_4);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JLabel label_4 = new JLabel("Tag:");
		panel_6.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setText("...");
		textField_5.setColumns(10);
		panel_6.add(textField_5);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JLabel label_5 = new JLabel("Tag:");
		panel_7.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setText("...");
		textField_6.setColumns(10);
		panel_7.add(textField_6);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JLabel label_6 = new JLabel("Tag:");
		panel_8.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setText("...");
		textField_7.setColumns(10);
		panel_8.add(textField_7);

		JTextArea txtrNineInchNails = new JTextArea();
		txtrNineInchNails
				.setText("Nine Inch Nails aren't on the bill, and they \r\nwon't play the fest anytime soon. Soundwave promoter\r\nAJ Maddah started a Twitter war-of-words with a few \r\nchoice comments about NIN's Trent Reznor.\r\n\r\n---------------------\r\n\r\nlorein");
		scrollPane.setViewportView(txtrNineInchNails);
		contentPane.setLayout(gl_contentPane);
	}
}

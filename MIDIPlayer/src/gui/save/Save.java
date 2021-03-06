package gui.save;

/**
 * MIDIPlayer
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
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import playlist.PlayList;

public abstract class Save extends JFrame {

	private static final long serialVersionUID = 2717518904562274867L;

	protected JPanel contentPane;
	protected JList<PlayList> list;
	protected JTextField textField;
	protected JButton btnSave;
	protected JCheckBox chckbxNew;

	/**
	 * Create the frame.
	 */
	public Save() {
		setTitle("Guardar Lista");
		setName("frmSave");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 237, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		chckbxNew = new JCheckBox("Nuevo");

		textField = new JTextField();
		textField.setColumns(10);

		btnSave = new JButton("Guardar");
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
														.createSequentialGroup()
														.addGroup(
																gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(chckbxNew)
																		.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
																		.addComponent(textField, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)).addContainerGap())
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addComponent(btnSave).addGap(65)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addContainerGap().addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(chckbxNew).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addComponent(btnSave).addGap(7)));

		list = new JList<PlayList>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		contentPane.setLayout(gl_contentPane);
	}
}

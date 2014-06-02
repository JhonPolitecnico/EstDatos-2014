package gui.details;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpringLayout;

public abstract class Details extends JFrame {

	private static final long serialVersionUID = 6811103470110601282L;

	protected JPanel contentPane;
	protected JTextField txtTitle;
	protected JTextField txtArtist;
	protected JTextField txtYear;
	protected JTextField txtAlbum;
	protected JLabel lblLength;
	protected JLabel lblFile;
	protected JLabel txtLength;
	protected JLabel txtFile;
	protected JButton btnSave;
	protected JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public Details() {
		setTitle("Propiedades");
		setName("frmDetails");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 284, 287);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		txtTitle = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtTitle, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtTitle, -10, SpringLayout.EAST, contentPane);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);

		txtArtist = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtArtist, 6, SpringLayout.SOUTH, txtTitle);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtArtist, 0, SpringLayout.WEST, txtTitle);
		txtArtist.setColumns(10);
		contentPane.add(txtArtist);

		txtYear = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtYear, 6, SpringLayout.SOUTH, txtArtist);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtYear, 0, SpringLayout.WEST, txtTitle);
		txtYear.setColumns(10);
		contentPane.add(txtYear);

		txtAlbum = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtAlbum, 6, SpringLayout.SOUTH, txtYear);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAlbum, 0, SpringLayout.WEST, txtTitle);
		txtAlbum.setColumns(10);
		contentPane.add(txtAlbum);

		JLabel lblTitle = new JLabel("Titulo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTitle, 0, SpringLayout.NORTH, txtTitle);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTitle, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblTitle);

		JLabel lblArtist = new JLabel("Artista");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblArtist, 0, SpringLayout.NORTH, txtArtist);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblArtist, 0, SpringLayout.WEST, lblTitle);
		contentPane.add(lblArtist);

		JLabel lblYear = new JLabel("A\u00F1o");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblYear, 0, SpringLayout.NORTH, txtYear);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblYear, 0, SpringLayout.WEST, lblTitle);
		contentPane.add(lblYear);

		JLabel lblAlbum = new JLabel("Album");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAlbum, 0, SpringLayout.NORTH, txtAlbum);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAlbum, 0, SpringLayout.WEST, lblTitle);
		contentPane.add(lblAlbum);

		lblLength = new JLabel("Duraci\u00F3n");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLength, 24, SpringLayout.SOUTH, lblAlbum);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblLength, 0, SpringLayout.WEST, lblTitle);
		contentPane.add(lblLength);

		lblFile = new JLabel("Archivo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFile, 17, SpringLayout.SOUTH, lblLength);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFile, 0, SpringLayout.WEST, lblTitle);
		contentPane.add(lblFile);

		txtLength = new JLabel("......");
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtLength, 0, SpringLayout.NORTH, lblLength);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtLength, 0, SpringLayout.EAST, txtTitle);
		contentPane.add(txtLength);

		txtFile = new JLabel("......");
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtFile, 0, SpringLayout.NORTH, lblFile);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtFile, 0, SpringLayout.EAST, txtTitle);
		contentPane.add(txtFile);

		btnSave = new JButton("Guardar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSave, 21, SpringLayout.SOUTH, lblFile);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSave, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnSave);

		btnCancel = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnSave);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCancel, 0, SpringLayout.EAST, txtTitle);
		contentPane.add(btnCancel);
	}

	/*
	 * Getters & Setters
	 */

	public JTextField getTxtTitle() {
		return txtTitle;
	}

	public JTextField getTxtArtist() {
		return txtArtist;
	}

	public JTextField getTxtYear() {
		return txtYear;
	}

	public JTextField getTxtAlbum() {
		return txtAlbum;
	}

	public JLabel getLblLength() {
		return lblLength;
	}

	public JLabel getLblFile() {
		return lblFile;
	}

	public JLabel getTxtLength() {
		return txtLength;
	}

	public JLabel getTxtFile() {
		return txtFile;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

}

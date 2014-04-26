package gui.details;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpringLayout;

public abstract class Details extends JFrame {

	private static final long serialVersionUID = 6811103470110601282L;

	protected JPanel contentPane;
	protected JTextField txtTitulo;
	protected JTextField txtArtista;
	protected JTextField txtAño;
	protected JTextField txtDisco;
	protected JLabel lblDuracion;
	protected JLabel lblArchivo;
	protected JLabel txtDuracion;
	protected JLabel txtArchivo;
	protected JButton btnGuardar;
	protected JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public Details() {
		setTitle("Propiedades");
		setName("frmDetails");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 284, 266);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		txtTitulo = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtTitulo, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtTitulo, -10, SpringLayout.EAST, contentPane);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		txtArtista = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtArtista, 6, SpringLayout.SOUTH, txtTitulo);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtArtista, 0, SpringLayout.WEST, txtTitulo);
		txtArtista.setColumns(10);
		contentPane.add(txtArtista);

		txtAño = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtAño, 6, SpringLayout.SOUTH, txtArtista);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAño, 0, SpringLayout.WEST, txtTitulo);
		txtAño.setColumns(10);
		contentPane.add(txtAño);

		txtDisco = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtDisco, 6, SpringLayout.SOUTH, txtAño);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtDisco, 0, SpringLayout.WEST, txtTitulo);
		txtDisco.setColumns(10);
		contentPane.add(txtDisco);

		JLabel lblTitulo = new JLabel("Titulo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTitulo, 0, SpringLayout.NORTH, txtTitulo);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTitulo, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblTitulo);

		JLabel lblArtista = new JLabel("Artista");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblArtista, 0, SpringLayout.NORTH, txtArtista);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblArtista, 0, SpringLayout.WEST, lblTitulo);
		contentPane.add(lblArtista);

		JLabel lblAo = new JLabel("A\u00F1o");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAo, 0, SpringLayout.NORTH, txtAño);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAo, 0, SpringLayout.WEST, lblTitulo);
		contentPane.add(lblAo);

		JLabel lblDiscografica = new JLabel("Discogr\u00E1fica");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDiscografica, 0, SpringLayout.NORTH, txtDisco);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDiscografica, 0, SpringLayout.WEST, lblTitulo);
		contentPane.add(lblDiscografica);

		lblDuracion = new JLabel("Duraci\u00F3n");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDuracion, 24, SpringLayout.SOUTH, lblDiscografica);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDuracion, 0, SpringLayout.WEST, lblTitulo);
		contentPane.add(lblDuracion);

		lblArchivo = new JLabel("Archivo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblArchivo, 17, SpringLayout.SOUTH, lblDuracion);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblArchivo, 0, SpringLayout.WEST, lblTitulo);
		contentPane.add(lblArchivo);

		txtDuracion = new JLabel("......");
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtDuracion, 0, SpringLayout.NORTH, lblDuracion);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtDuracion, 0, SpringLayout.EAST, txtTitulo);
		contentPane.add(txtDuracion);

		txtArchivo = new JLabel("......");
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtArchivo, 0, SpringLayout.NORTH, lblArchivo);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtArchivo, 0, SpringLayout.EAST, txtTitulo);
		contentPane.add(txtArchivo);

		btnGuardar = new JButton("Guardar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGuardar, 21, SpringLayout.SOUTH, lblArchivo);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnGuardar, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnGuardar);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCancelar, 0, SpringLayout.EAST, txtTitulo);
		contentPane.add(btnCancelar);
	}

	/*
	 * Getters & Setters
	 */

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public JTextField getTxtArtista() {
		return txtArtista;
	}

	public JTextField getTxtAño() {
		return txtAño;
	}

	public JTextField getTxtDisco() {
		return txtDisco;
	}

	public JLabel getLblDuracion() {
		return lblDuracion;
	}

	public JLabel getLblArchivo() {
		return lblArchivo;
	}

	public JLabel getTxtDuracion() {
		return txtDuracion;
	}

	public JLabel getTxtArchivo() {
		return txtArchivo;
	}

}

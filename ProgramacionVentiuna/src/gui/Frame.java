package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poligran.MainVentiuna;

/**
 * Ventiuna
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class Frame extends JFrame {

	private MainVentiuna model;
	private JPanel panelPlayer1;
	private JPanel panelPlayer2;
	private JPanel panelPlayer3;
	private JPanel panelPlayer4;
	private JPanel panelControl;
	private JButton btnCarta;
	private JButton btnPasar;
	private ButtonController buttonController;

	public static void main(String[] args) {
		new Frame();
	}

	private String getPath() {
		return System.getProperty("user.dir");
	}

	public ImageIcon getImage(int numeroCarta, int palo) {
		return new ImageIcon(this.getPath() + "\\img\\card" + (numeroCarta - 1) + "" + palo + ".png");
	}

	public Frame() {
		this.setBounds(50, 50, 850, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Definir el Layout
		this.getContentPane().setLayout(null);

		// Definir los paneles de los jugadores
		this.panelPlayer1 = new JPanel();
		this.panelPlayer2 = new JPanel();
		this.panelPlayer3 = new JPanel();
		this.panelPlayer4 = new JPanel();
		this.panelControl = new JPanel();

		/*
		 * Panel 1
		 */
		// Posicion del panel
		this.panelPlayer1.setBounds(50, 50, 350, 250);
		// Color del panel
		this.panelPlayer1.setBackground(Color.YELLOW);
		// Agregar al entorno
		this.getContentPane().add(this.panelPlayer1);

		/*
		 * Panel 2
		 */
		// Posicion del panel
		this.panelPlayer2.setBounds(420, 50, 350, 250);
		// Color del panel
		this.panelPlayer2.setBackground(Color.BLACK);
		// Agregar al entorno
		this.getContentPane().add(this.panelPlayer2);

		/*
		 * Panel 3
		 */
		// Posicion del panel
		this.panelPlayer3.setBounds(420, 310, 350, 250);
		// Color del panel
		this.panelPlayer3.setBackground(Color.BLUE);
		// Agregar al entorno
		this.getContentPane().add(this.panelPlayer3);

		/*
		 * Panel 4
		 */
		// Posicion del panel
		this.panelPlayer4.setBounds(50, 310, 350, 250);
		// Color del panel
		this.panelPlayer4.setBackground(Color.GREEN);
		// Agregar al entorno
		this.getContentPane().add(this.panelPlayer4);

		/*
		 * Panel De Control
		 */
		// Posicion del panel
		this.panelControl.setBounds(50, 580, 720, 35);
		// Color del panel
		this.panelControl.setBackground(Color.RED);
		// Agregar al entorno
		this.getContentPane().add(this.panelControl);

		/*
		 * Layouts de los paneles
		 */
		this.panelPlayer1.setLayout(new FlowLayout());
		this.panelPlayer2.setLayout(new FlowLayout());
		this.panelPlayer3.setLayout(new FlowLayout());
		this.panelPlayer4.setLayout(new FlowLayout());
		this.panelControl.setLayout(new FlowLayout());

		/*
		 * Botones
		 */
		// Pedir carta
		this.btnCarta = new JButton("Pedir Carta");
		this.btnCarta.setActionCommand("Carta");
		// Pasar turno
		this.btnPasar = new JButton("Pasar");
		this.btnPasar.setActionCommand("Pasar");
		// Agregar al panel de control
		this.panelControl.add(this.btnCarta);
		this.panelControl.add(this.btnPasar);

		/*
		 * Eventos
		 */
		this.buttonController = new ButtonController(this);
		this.btnCarta.addActionListener(buttonController);
		this.btnPasar.addActionListener(buttonController);

		/*
		 * Modelo
		 */
		this.model = new MainVentiuna();
		this.model.reiniciar();
		this.refrescar();

		// Hacer visible
		this.setVisible(true);
	}

	public MainVentiuna getModel() {
		return model;
	}

	public void refrescar() {

		String[] cartas = null;
		JPanel panel = null;
		int palo = 0;
		int numeroCarta = 0;

		for (int i = 1; i <= 4; i++) {
			switch (i) {
			case 1:
				panel = this.panelPlayer1;
				break;
			case 2:
				panel = this.panelPlayer2;
				break;
			case 3:
				panel = this.panelPlayer3;
				break;
			case 4:
				panel = this.panelPlayer4;
				break;
			}

			// Eliminar todo
			panel.removeAll();

			cartas = this.model.darListaCartasJugador(i);

			for (int j = 0; j < cartas.length; j++) {

				for (int j2 = 0; j2 < this.model.palosSegunImagenes.length; j2++) {
					if (cartas[j].indexOf(this.model.palosSegunImagenes[j2]) != -1) {
						palo = j2;
						break;
					}
				}

				for (int j2 = 0; j2 < this.model.valores.length; j2++) {

					// Si es jugador actual, sus cartas de ven
					if (i == this.model.darTurno()) {
						if (cartas[j].indexOf(this.model.valores[j2]) != -1) {
							numeroCarta = j2 + 1;
							break;
						}

					} else {
						numeroCarta = 10;
						palo = 9;
					}

				}

				ImageIcon img = this.getImage(numeroCarta, palo);
				JLabel label = new JLabel(img);

				panel.add(label);

			}
			// Referencia:
			// http://docs.oracle.com/javase/7/docs/api/java/awt/Container.html#removeAll()
			panel.validate();
			panel.repaint();

		}
	}
}

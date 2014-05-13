package gui.main;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.JList;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;

import midi.Cancion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Main extends JFrame {

	private static final long serialVersionUID = 3247169800303769527L;

	protected JList<Cancion> jList;
	protected JMenuItem mntmLimpiar;
	protected JMenuItem mntmAadirArchivo;
	protected JMenuItem mntmEliminar;
	protected JMenuItem mntmPropiedades;
	protected JButton btnPlayPause;
	protected JCheckBox chckbxModoAleatorio;
	protected JCheckBox chckbxRepetir;
	protected JButton btnParar;
	protected JButton btnPararLista;
	protected JMenuItem mntmSalir;
	protected JMenuItem mntmCargar;
	protected JMenuItem mntmGuardar;

	/**
	 * Create the frame.
	 */
	public Main() {
		setSize(new Dimension(780, 525));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Reproductor MIDI - Jhon Jairo Eslava");

		JScrollPane scrollPane = new JScrollPane();

		JPanel panelControl = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				groupLayout
						.createSequentialGroup()
						.addGap(23)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
										.addComponent(panelControl, GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)).addGap(20)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addGap(13).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelControl, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE).addContainerGap()));

		jList = new JList<Cancion>();
		jList.setVisibleRowCount(-1);
		scrollPane.setViewportView(jList);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(jList, popupMenu);

		mntmLimpiar = new JMenuItem("Vaciar lista");
		popupMenu.add(mntmLimpiar);

		JSeparator separator_2 = new JSeparator();
		popupMenu.add(separator_2);

		mntmAadirArchivo = new JMenuItem("A\u00F1adir archivo(s)");
		popupMenu.add(mntmAadirArchivo);

		mntmEliminar = new JMenuItem("Eliminar");
		popupMenu.add(mntmEliminar);

		JSeparator separator = new JSeparator();
		popupMenu.add(separator);

		mntmPropiedades = new JMenuItem("Propiedades");
		popupMenu.add(mntmPropiedades);

		btnPlayPause = new JButton("Reproducir / Pausa");
		btnPlayPause.setAlignmentY(Component.TOP_ALIGNMENT);

		chckbxModoAleatorio = new JCheckBox("Modo Aleatorio");

		chckbxRepetir = new JCheckBox("Repetir");

		btnParar = new JButton("Parar");

		btnPararLista = new JButton("Parar Lista");
		GroupLayout gl_panelControl = new GroupLayout(panelControl);
		gl_panelControl.setHorizontalGroup(gl_panelControl.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panelControl.createSequentialGroup().addComponent(btnPlayPause).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnParar).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnPararLista).addPreferredGap(ComponentPlacement.RELATED, 260, Short.MAX_VALUE).addComponent(chckbxModoAleatorio).addGap(14).addComponent(chckbxRepetir)
						.addContainerGap()));
		gl_panelControl.setVerticalGroup(gl_panelControl.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panelControl
						.createSequentialGroup()
						.addGroup(
								gl_panelControl.createParallelGroup(Alignment.LEADING).addComponent(chckbxRepetir).addComponent(chckbxModoAleatorio)
										.addGroup(gl_panelControl.createParallelGroup(Alignment.BASELINE).addComponent(btnParar).addComponent(btnPararLista)).addComponent(btnPlayPause))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelControl.setLayout(gl_panelControl);
		getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);

		JMenu mnLista = new JMenu("Lista");
		menuBar.add(mnLista);

		JMenuItem mntmVerListas = new JMenuItem("Ver listas");
		mnLista.add(mntmVerListas);

		JSeparator separator_1 = new JSeparator();
		mnLista.add(separator_1);

		mntmCargar = new JMenuItem("Cargar");
		mnLista.add(mntmCargar);

		mntmGuardar = new JMenuItem("Guardar");
		mnLista.add(mntmGuardar);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

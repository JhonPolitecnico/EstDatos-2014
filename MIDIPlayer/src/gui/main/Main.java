package gui.main;

import gui.main.check.Repeat;
import gui.main.mouse.AddFile;
import gui.main.mouse.DeleteElement;
import gui.main.mouse.EmptyList;
import gui.main.mouse.PlayAndPause;
import gui.main.mouse.Stop;
import gui.main.mouse.StopList;
import gui.main.mouse.ViewDetails;

import java.awt.EventQueue;

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

import utils.Utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 3247169800303769527L;
	private Controller controller;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void createController() {
		this.controller = new Controller(this);
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		// Crear el controlador de Main
		createController();
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Reproductor MIDI - Jhon Jairo Eslava");
		setSize(new Dimension(780, 525));

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

		list = new JList();
		list.setModel(this.controller.getMIDIList());
		list.setVisibleRowCount(-1);
		scrollPane.setViewportView(list);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(list, popupMenu);

		JMenuItem mntmLimpiar = new JMenuItem("Vaciar lista");
		mntmLimpiar.addActionListener(new EmptyList(controller));
		popupMenu.add(mntmLimpiar);

		JSeparator separator_2 = new JSeparator();
		popupMenu.add(separator_2);

		JMenuItem mntmAadirArchivo = new JMenuItem("A\u00F1adir archivo(s)");
		mntmAadirArchivo.addActionListener(new AddFile(controller));
		popupMenu.add(mntmAadirArchivo);

		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new DeleteElement(controller));
		popupMenu.add(mntmEliminar);

		JSeparator separator = new JSeparator();
		popupMenu.add(separator);

		JMenuItem mntmPropiedades = new JMenuItem("Propiedades");
		mntmPropiedades.addActionListener(new ViewDetails(controller));
		popupMenu.add(mntmPropiedades);

		JButton btnNewButton = new JButton("Reproducir / Pausa");
		btnNewButton.addMouseListener(new PlayAndPause(controller));
		btnNewButton.setAlignmentY(Component.TOP_ALIGNMENT);

		JCheckBox chckbxModoAleatorio = new JCheckBox("Modo Aleatorio");

		JCheckBox chckbxRepetir = new JCheckBox("Repetir");
		chckbxRepetir.addActionListener(new Repeat(controller));

		JButton btnParar = new JButton("Parar");
		btnParar.addMouseListener(new Stop(controller));

		JButton btnPararLista = new JButton("Parar Lista");
		btnPararLista.addMouseListener(new StopList(controller));
		GroupLayout gl_panelControl = new GroupLayout(panelControl);
		gl_panelControl.setHorizontalGroup(gl_panelControl.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panelControl.createSequentialGroup().addComponent(btnNewButton).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnParar).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnPararLista).addPreferredGap(ComponentPlacement.RELATED, 260, Short.MAX_VALUE).addComponent(chckbxModoAleatorio).addGap(14).addComponent(chckbxRepetir)
						.addContainerGap()));
		gl_panelControl.setVerticalGroup(gl_panelControl.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panelControl
						.createSequentialGroup()
						.addGroup(
								gl_panelControl.createParallelGroup(Alignment.LEADING).addComponent(chckbxRepetir).addComponent(chckbxModoAleatorio)
										.addGroup(gl_panelControl.createParallelGroup(Alignment.BASELINE).addComponent(btnParar).addComponent(btnPararLista)).addComponent(btnNewButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelControl.setLayout(gl_panelControl);
		getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnLista = new JMenu("Lista");
		menuBar.add(mnLista);

		JMenuItem mntmVerListas = new JMenuItem("Ver listas");
		mnLista.add(mntmVerListas);

		JSeparator separator_1 = new JSeparator();
		mnLista.add(separator_1);

		JMenuItem mntmCargar = new JMenuItem("Cargar");
		mnLista.add(mntmCargar);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
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

	public JList getList() {
		return list;
	}
}

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

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public abstract class Main extends JFrame {

	private static final long serialVersionUID = 3247169800303769527L;

	protected JMenuItem mntmClear;
	protected JMenuItem mntmAddFile;
	protected JMenuItem mntmRemove;
	protected JMenuItem mntmPlay;
	protected JMenuItem mntmProperties;
	protected JButton btnPlayPause;
	protected JCheckBox chckbxRepeat;
	protected JButton btnStop;
	protected JButton btnStopList;
	protected JMenuItem mntmExit;
	protected JMenuItem mntmLoad;
	protected JMenuItem mntmSave;
	protected JTable table;
	protected JPopupMenu popupMenu;
	protected JButton btnNext;
	protected JButton btnPrev;
	protected JLabel lblCurrent;

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

		table = new JTable();
		scrollPane.setViewportView(table);

		popupMenu = new JPopupMenu();
		scrollPane.setComponentPopupMenu(this.popupMenu);
		table.setComponentPopupMenu(this.popupMenu);

		mntmClear = new JMenuItem("Vaciar lista");
		popupMenu.add(mntmClear);

		JSeparator separator_2 = new JSeparator();
		popupMenu.add(separator_2);

		mntmAddFile = new JMenuItem("A\u00F1adir archivo(s)");
		popupMenu.add(mntmAddFile);

		mntmRemove = new JMenuItem("Eliminar");
		popupMenu.add(mntmRemove);

		JSeparator separator = new JSeparator();
		popupMenu.add(separator);

		mntmPlay = new JMenuItem("Reproducir");
		popupMenu.add(mntmPlay);

		mntmProperties = new JMenuItem("Propiedades");
		popupMenu.add(mntmProperties);

		btnPlayPause = new JButton("Reproducir / Pausa");
		btnPlayPause.setAlignmentY(Component.TOP_ALIGNMENT);

		chckbxRepeat = new JCheckBox("Repetir");

		btnStop = new JButton("Parar");

		btnStopList = new JButton("Parar Lista");

		btnNext = new JButton("Siguiente");

		btnPrev = new JButton("Anterior");

		lblCurrent = new JLabel("...");
		lblCurrent.setVerticalAlignment(SwingConstants.TOP);
		lblCurrent.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout gl_panelControl = new GroupLayout(panelControl);
		gl_panelControl.setHorizontalGroup(gl_panelControl.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panelControl.createSequentialGroup().addComponent(btnPlayPause).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnStop).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnStopList).addGap(30).addComponent(btnPrev).addGap(3).addComponent(btnNext).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblCurrent, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
						.addComponent(chckbxRepeat).addContainerGap()));
		gl_panelControl.setVerticalGroup(gl_panelControl.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panelControl
						.createSequentialGroup()
						.addGroup(
								gl_panelControl
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_panelControl.createParallelGroup(Alignment.BASELINE).addComponent(btnStop).addComponent(btnStopList).addComponent(chckbxRepeat)
														.addComponent(btnNext).addComponent(btnPrev).addComponent(lblCurrent, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnPlayPause)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelControl.setLayout(gl_panelControl);
		getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("Archivo");
		menuBar.add(mnFile);

		mntmExit = new JMenuItem("Salir");
		mnFile.add(mntmExit);

		JMenu mnLista = new JMenu("Lista");
		menuBar.add(mnLista);

		mntmLoad = new JMenuItem("Cargar");
		mnLista.add(mntmLoad);

		mntmSave = new JMenuItem("Guardar");
		mnLista.add(mntmSave);
	}
}

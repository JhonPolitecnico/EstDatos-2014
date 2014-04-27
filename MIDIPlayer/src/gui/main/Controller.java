package gui.main;

import java.awt.EventQueue;

import javax.swing.JList;

import utils.Utils;
import gui.main.check.Repeat;
import gui.main.mouse.AddFile;
import gui.main.mouse.DeleteElement;
import gui.main.mouse.EmptyList;
import gui.main.mouse.Exit;
import gui.main.mouse.PlayAndPause;
import gui.main.mouse.SaveList;
import gui.main.mouse.Stop;
import gui.main.mouse.StopList;
import gui.main.mouse.ViewDetails;
import gui.main.player.MIDIPlayerController;
import midi.MIDIListModel;
import midi.MIDIPLayList;

public class Controller extends Main {

	private static final long serialVersionUID = 6445097674136753468L;

	private MIDIPLayList playList;
	private MIDIListModel MIDIList;
	private MIDIPlayerController playerController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller frame = new Controller();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Controller() {
		super();

		/*
		 * Modelo
		 */
		this.playList = new MIDIPLayList();
		this.MIDIList = new MIDIListModel();
		this.playList.addList("Default", this.MIDIList);
		jList.setModel(this.MIDIList);
		this.playerController = new MIDIPlayerController(this);

		/*
		 * Eventos
		 */
		mntmAadirArchivo.addActionListener(new AddFile(this));
		mntmEliminar.addActionListener(new DeleteElement(this));
		mntmGuardar.addActionListener(new SaveList(this));
		mntmLimpiar.addActionListener(new EmptyList(this));
		mntmPropiedades.addActionListener(new ViewDetails(this));
		mntmSalir.addActionListener(new Exit());

		btnNewButton.addMouseListener(new PlayAndPause(this));
		btnParar.addMouseListener(new Stop(this));
		btnPararLista.addMouseListener(new StopList(this));

		chckbxRepetir.addActionListener(new Repeat(this));

		// Crear frame
		Utils.centerFrame(this);
	}

	/*
	 * Getters & Setters
	 */

	public JList getList() {
		return this.jList;
	}

	public MIDIPLayList getPlayList() {
		return playList;
	}

	public void setPlayList(MIDIPLayList playList) {
		this.playList = playList;
	}

	public MIDIListModel getMIDIList() {
		return MIDIList;
	}

	public void setMIDIList(MIDIListModel mIDIList) {
		MIDIList = mIDIList;
	}

	public MIDIPlayerController getPlayerController() {
		return playerController;
	}

	public void setPlayerController(MIDIPlayerController playerController) {
		this.playerController = playerController;
	}
}

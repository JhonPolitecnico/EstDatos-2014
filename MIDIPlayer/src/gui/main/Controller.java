package gui.main;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.EventQueue;

import javax.swing.JList;

import serializer.engine.Serializer;
import utils.Utils;
import gui.main.check.Repeat;
import gui.main.mouse.AddFile;
import gui.main.mouse.DeleteElement;
import gui.main.mouse.EmptyList;
import gui.main.mouse.Exit;
import gui.main.mouse.LoadList;
import gui.main.mouse.PlayAndPause;
import gui.main.mouse.SaveList;
import gui.main.mouse.Stop;
import gui.main.mouse.StopList;
import gui.main.mouse.ViewDetails;
import gui.main.player.MIDIPlayerController;
import gui.main.window.WindowController;
import midi.Cancion;
import midi.MIDIListModel;
import midi.MIDIPLayList;

public class Controller extends Main {

	private static final long serialVersionUID = 6445097674136753468L;

	private MIDIPLayList playList;
	private MIDIListModel<Cancion> MIDIList;
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
		 * Serializer
		 */
		Serializer s = new Serializer(Utils.getLibrary());
		Object object = s.unserialize();

		if (object != null && object instanceof MIDIPLayList) {
			this.playList = (MIDIPLayList) object;
		} else
			this.playList = new MIDIPLayList();

		/*
		 * Modelo
		 */
		this.MIDIList = new MIDIListModel<Cancion>();
		jList.setModel(this.MIDIList);
		this.playerController = new MIDIPlayerController(this);

		/*
		 * Eventos
		 */

		this.addWindowListener(new WindowController(this));

		mntmAadirArchivo.addActionListener(new AddFile(this));
		mntmCargar.addActionListener(new LoadList(this));
		mntmEliminar.addActionListener(new DeleteElement(this));
		mntmGuardar.addActionListener(new SaveList(this));
		mntmLimpiar.addActionListener(new EmptyList(this));
		mntmPropiedades.addActionListener(new ViewDetails(this));
		mntmSalir.addActionListener(new Exit());

		btnPlayPause.addMouseListener(new PlayAndPause(this));
		btnParar.addMouseListener(new Stop(this));
		btnPararLista.addMouseListener(new StopList(this));

		chckbxRepetir.addActionListener(new Repeat(this));

		// Crear frame
		Utils.centerFrame(this);
	}

	/*
	 * Getters & Setters
	 */

	public JList<Cancion> getList() {
		return this.jList;
	}

	public MIDIPLayList getPlayList() {
		return playList;
	}

	public void setPlayList(MIDIPLayList playList) {
		this.playList = playList;
	}

	public MIDIListModel<Cancion> getMIDIList() {
		return MIDIList;
	}

	public void setMIDIList(MIDIListModel<Cancion> mIDIList) {
		MIDIListModel<Cancion> clon = new MIDIListModel<Cancion>();

		for (int i = 0; i < mIDIList.getSize(); i++)
			clon.addElement(mIDIList.get(i));

		MIDIList = clon;
		jList.setModel(this.MIDIList);
	}

	public MIDIPlayerController getPlayerController() {
		return playerController;
	}

	public void setPlayerController(MIDIPlayerController playerController) {
		this.playerController = playerController;
	}
}

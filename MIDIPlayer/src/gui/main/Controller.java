package gui.main;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.EventQueue;

import javax.swing.JTable;

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
import library.Library;
import midi.MIDITableModel;
import midi.MIDIPLayList;
import midi.SongList;

public class Controller extends Main {

	private static final long serialVersionUID = 6445097674136753468L;

	private MIDIPLayList playList;
	private MIDITableModel MIDITable;
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

		/**
		 * Serializer
		 */
		Serializer s = new Serializer(Utils.getLibrary());
		Object object = s.unserialize();

		if (object != null && object instanceof Library) {
			Library library = (Library) object;
			SongList.setInstance(library.getSongList());
			this.playList = library.getPlaylists();
		} else
			this.playList = new MIDIPLayList();

		/**
		 * Model
		 */
		this.MIDITable = new MIDITableModel();
		super.table.setModel(this.MIDITable);
		this.playerController = new MIDIPlayerController(this);

		/**
		 * Events
		 */

		this.addWindowListener(new WindowController(this));

		super.mntmAddFile.addActionListener(new AddFile(this));
		super.mntmLoad.addActionListener(new LoadList(this));
		super.mntmRemove.addActionListener(new DeleteElement(this));
		super.mntmSave.addActionListener(new SaveList(this));
		super.mntmClear.addActionListener(new EmptyList(this));
		super.mntmProperties.addActionListener(new ViewDetails(this));
		super.mntmExit.addActionListener(new Exit());

		super.btnPlayPause.addMouseListener(new PlayAndPause(this));
		super.btnStop.addMouseListener(new Stop(this));
		super.btnStopList.addMouseListener(new StopList(this));

		super.chckbxRepeat.addActionListener(new Repeat(this));

		/**
		 * Center frame
		 */
		Utils.centerFrame(this);
	}

	/*
	 * Getters & Setters
	 */

	public JTable getTable() {
		return super.table;
	}

	public MIDITableModel getMIDITable() {
		return MIDITable;
	}

	public MIDIPLayList getPlayList() {
		return playList;
	}

	public void setPlayList(MIDIPLayList playList) {
		this.playList = playList;
	}

	public void setMIDITable(MIDITableModel midiTableModel) {
		this.MIDITable = midiTableModel.clone();
		super.table.setModel(this.MIDITable);
	}

	public MIDIPlayerController getPlayerController() {
		return playerController;
	}

	public void setPlayerController(MIDIPlayerController playerController) {
		this.playerController = playerController;
	}
}

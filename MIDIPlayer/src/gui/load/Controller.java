package gui.load;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.util.Map.Entry;

import javax.swing.JList;

import playlist.PlayList;
import playlist.PlayListModel;
import midi.MIDITableModel;

/**
 * Load the saved list
 * 
 */
public class Controller extends Load {

	private static final long serialVersionUID = -2056308172932341438L;

	private gui.main.Controller main;
	private PlayListModel playlist;

	/**
	 * 
	 * @param main
	 *            Main frame
	 */
	public Controller(gui.main.Controller main) {
		super();
		this.main = main;

		this.playlist = new PlayListModel();

		/**
		 * Add playlist to temporal list
		 */
		for (Entry<String, MIDITableModel> entry : this.main.getPlayList().getLists().entrySet())
			this.playlist.addElement(new PlayList(entry.getKey(), entry.getValue()));

		this.list.setModel(this.playlist);

		/**
		 * Events
		 */
		this.btnLoad.addMouseListener(new gui.load.mouse.Load(this));

		setLocationRelativeTo(main);
		setVisible(true);
	}

	/*
	 * Getters & Setters
	 */

	public JList<PlayList> getList() {
		return this.list;
	}

	public gui.main.Controller getMain() {
		return main;
	}

	public PlayListModel getPlaylist() {
		return playlist;
	}

}

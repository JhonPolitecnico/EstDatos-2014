package gui.save;

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
import gui.save.check.New;
import midi.MIDITableModel;

/**
 * Save the actual playlist
 * 
 */
public class Controller extends Save {

	private static final long serialVersionUID = -2056308172932341438L;

	private gui.main.Controller owner;
	private PlayListModel playlist;
	private MIDITableModel table;
	private boolean bNew;

	/**
	 * 
	 * @param owner
	 *            Main frame
	 * @param list
	 *            list of songs to save
	 */
	public Controller(gui.main.Controller owner, MIDITableModel table) {
		super();
		this.owner = owner;
		this.table = table.clone();

		this.playlist = new PlayListModel();

		for (Entry<String, MIDITableModel> entry : this.owner.getPlayList().getLists().entrySet())
			this.playlist.addElement(new PlayList(entry.getKey(), entry.getValue()));

		this.list.setModel(this.playlist);

		/*
		 * Events
		 */
		this.chckbxNuevo.addActionListener(new New(this));
		this.btnGuardar.addMouseListener(new gui.save.mouse.Save(this));

		setNew(false);
		setLocationRelativeTo(owner);
		setVisible(true);
	}

	/*
	 * Getters & Setters
	 */

	public boolean isNew() {
		return bNew;
	}

	public void setNew(boolean value) {
		this.bNew = value;
		this.list.setEnabled(!value);
		this.textField.setEnabled(value);
	}

	public JList<PlayList> getList() {
		return this.list;
	}

	public gui.main.Controller getOwner() {
		return owner;
	}

	public PlayListModel getPlaylist() {
		return playlist;
	}

	public MIDITableModel getTable() {
		return this.table;
	}

	public String getNewPlayListName() {
		return this.textField.getText();
	}

}

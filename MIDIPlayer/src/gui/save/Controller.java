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
import midi.Song;
import midi.MIDIListModel;

public class Controller extends Save {

	private static final long serialVersionUID = -2056308172932341438L;

	private gui.main.Controller owner;
	private PlayListModel playlist;
	private MIDIListModel<Song> mIDIList;
	private boolean bNew;

	public Controller(gui.main.Controller owner, MIDIListModel<Song> list) {
		super();
		this.owner = owner;
		this.mIDIList = list;

		this.playlist = new PlayListModel();

		for (Entry<String, MIDIListModel<Song>> entry : this.owner.getPlayList().getLists().entrySet())
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

	public MIDIListModel<Song> getMIDIList() {
		MIDIListModel<Song> clon = new MIDIListModel<Song>();

		for (int i = 0; i < this.mIDIList.getSize(); i++)
			clon.addElement(this.mIDIList.get(i));

		return clon;
	}

	public String getNewPlayListName() {
		return this.textField.getText();
	}

}

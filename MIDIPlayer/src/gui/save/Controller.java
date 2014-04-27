package gui.save;

import java.util.Map.Entry;

import javax.swing.JList;

import gui.save.check.New;
import gui.save.playlist.PlayList;
import gui.save.playlist.PlayListModel;
import midi.MIDIListModel;

public class Controller extends Save {

	private static final long serialVersionUID = -2056308172932341438L;

	private gui.main.Controller owner;
	private PlayListModel playlist;
	private MIDIListModel MIDIList;
	private boolean bNew;

	public Controller(gui.main.Controller owner, MIDIListModel list) {
		super();
		this.owner = owner;
		this.MIDIList = list;

		this.playlist = new PlayListModel();

		for (Entry<String, MIDIListModel> entry : this.owner.getPlayList().getLists().entrySet())
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

	public JList getList() {
		return this.list;
	}

	public gui.main.Controller getOwner() {
		return owner;
	}

	public PlayListModel getPlaylist() {
		return playlist;
	}

	public MIDIListModel getMIDIList() {
		return MIDIList;
	}

	public String getNewPlayListName() {
		return this.textField.getText();
	}

}

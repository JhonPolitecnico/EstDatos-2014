package gui.save.playlist;

import midi.MIDIListModel;

public class PlayList {
	private String name;
	private MIDIListModel list;

	public PlayList(String name, MIDIListModel list) {
		super();
		this.name = name;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public MIDIListModel getList() {
		return list;
	}

	@Override
	public String toString() {
		return this.name;
	}

}

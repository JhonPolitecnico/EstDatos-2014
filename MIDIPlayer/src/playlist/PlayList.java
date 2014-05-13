package playlist;

import midi.Cancion;
/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import midi.MIDIListModel;

public class PlayList {
	private String name;
	private MIDIListModel<Cancion> list;

	public PlayList(String name, MIDIListModel<Cancion> list) {
		super();
		this.name = name;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public MIDIListModel<Cancion> getList() {
		return list;
	}

	@Override
	public String toString() {
		return this.name;
	}

}

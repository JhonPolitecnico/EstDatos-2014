package playlist;

import midi.Song;
/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import midi.MIDIListModel;

/**
 * Single playlist
 *
 */
public class PlayList {
	private String name;
	private MIDIListModel<Song> list;

	public PlayList(String name, MIDIListModel<Song> list) {
		super();
		this.name = name;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public MIDIListModel<Song> getList() {
		return list;
	}

	@Override
	public String toString() {
		return this.name;
	}

}

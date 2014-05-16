package playlist;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import midi.MIDITableModel;

/**
 * Single playlist
 * 
 */
public class PlayList {

	private String name;
	private MIDITableModel list;

	public PlayList(String name, MIDITableModel list) {
		super();
		this.name = name;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public MIDITableModel getList() {
		return list;
	}

	@Override
	public String toString() {
		return this.name;
	}

}

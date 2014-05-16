package midi;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.Serializable;
import java.util.Hashtable;

/**
 * The model contains all saved playlists
 * 
 */
public class MIDIPLayList implements Serializable {

	private static final long serialVersionUID = -3060777809404304238L;

	private Hashtable<String, MIDITableModel> lists;

	public MIDIPLayList() {
		this.lists = new Hashtable<String, MIDITableModel>();
	}

	public void addList(String name, MIDITableModel list) {
		this.lists.put(name, list);
	}

	public void replaceList(String name, MIDITableModel list) {
		this.lists.replace(name, list);
	}

	public Hashtable<String, MIDITableModel> getLists() {
		return lists;
	}

	public void setLists(Hashtable<String, MIDITableModel> lists) {
		this.lists = lists;
	}

}

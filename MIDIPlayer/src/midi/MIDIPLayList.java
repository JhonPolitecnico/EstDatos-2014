package midi;

import java.util.HashMap;

public class MIDIPLayList {
	private HashMap<String, MIDIListModel> lists;

	public MIDIPLayList() {
		this.lists = new HashMap<String, MIDIListModel>();
	}

	public void addList(String name, MIDIListModel list) {
		this.lists.put(name, list);
	}

	public void replaceList(String name, MIDIListModel list) {
		this.lists.replace(name, list);
	}

	public HashMap<String, MIDIListModel> getLists() {
		return lists;
	}

	public void setLists(HashMap<String, MIDIListModel> lists) {
		this.lists = lists;
	}

}

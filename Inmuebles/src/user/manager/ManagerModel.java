package user.manager;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class ManagerModel extends AbstractListModel<String> {

	private static final long serialVersionUID = -2504354897327847114L;

	private ArrayList<String> model;

	public ManagerModel() {
		this.model = new ArrayList<String>();
	}

	@Override
	public String getElementAt(int index) {
		return this.model.get(index);
	}

	public void removeElement(int index) {
		this.model.remove(index);
	}

	public void addElement(String element) {
		this.model.add(element);
	}

	@Override
	public int getSize() {
		return this.model.size();
	}

}

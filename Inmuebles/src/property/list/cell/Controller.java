package property.list.cell;

import utils.Utils;

public class Controller extends Cell {

	private static final long serialVersionUID = 5723373734859781163L;

	public Controller() {
		super();
	}

	public Controller(String photo) {
		super();
		super.lblImage.setIcon(Utils.getPhoto(photo, 150, 100));
	}

}

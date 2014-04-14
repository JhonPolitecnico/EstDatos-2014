package gui;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import poligran.MainVentiuna;

public class CheckController implements ChangeListener {

	private MainVentiuna model;

	public CheckController(MainVentiuna model) {
		this.model = model;
	}

	@Override
	public void stateChanged(ChangeEvent e) {

		if (!(e.getSource() instanceof JCheckBox))
			return;

		JCheckBox check = (JCheckBox) e.getSource();

		if (!check.isEnabled())
			return;

		String sCommand = check.getText();

		switch (sCommand) {
		case "Debug":
			this.debugCommand(check.isSelected());
			break;
		default:
			break;
		}

	}

	private void debugCommand(boolean selected) {
		this.model.setDebug(selected);
	}

}

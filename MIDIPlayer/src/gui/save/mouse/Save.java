package gui.save.mouse;

import gui.save.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import playlist.PlayList;

public class Save extends MouseAdapter {

	private Controller controller;

	public Save(Controller controller) {
		super();
		this.controller = controller;
	}

	public void mouseClicked(MouseEvent e) {

		if (this.controller.isNew()) {
			if (this.controller.getNewPlayListName().length() <= 0) {
				JOptionPane.showMessageDialog(this.controller, "Debes escribir un nombre para la nueva lista", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (this.controller.getOwner().getPlayList().getLists().containsKey(this.controller.getNewPlayListName())) {
				JOptionPane.showMessageDialog(this.controller, "No puedes tener dos listas con un mismo nombre", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}

			this.controller.getOwner().getPlayList().addList(this.controller.getNewPlayListName(), this.controller.getMIDIList());
		} else {

			if (this.controller.getList().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(this.controller, "Debes seleccionar una lista donde guardar", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}

			PlayList playlist = (PlayList) this.controller.getList().getSelectedValue();
			this.controller.getOwner().getPlayList().replaceList(playlist.getName(), playlist.getList());
		}

		JOptionPane.showMessageDialog(this.controller, "La lista se guardo correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
		this.controller.dispose();
	}
}

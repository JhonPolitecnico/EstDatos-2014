package gui.load.mouse;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.load.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import playlist.PlayList;

/**
 * Load the selected list
 * 
 */
public class Load extends MouseAdapter {

	private Controller controller;

	public Load(Controller controller) {
		super();
		this.controller = controller;
	}

	public void mouseClicked(MouseEvent e) {

		if (this.controller.getList().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this.controller, "Debes seleccionar una lista donde guardar", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}

		PlayList playlist = (PlayList) this.controller.getList().getSelectedValue();
		this.controller.getMain().setMIDITable(playlist.getList());
		// this.controller.getOwner().setMIDIList(playlist.getList());

		JOptionPane.showMessageDialog(this.controller, "La lista se cargo correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
		this.controller.dispose();
	}
}

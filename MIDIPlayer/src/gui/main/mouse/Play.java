package gui.main.mouse;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

/**
 * Save the playlist
 * 
 */
public class Play implements MouseListener, ActionListener {

	private Controller controller;

	public Play(Controller controller) {
		super();
		this.controller = controller;
	}

	private void playSong(JTable table) {
		int id = table.convertRowIndexToModel(table.getSelectedRow());
		this.controller.getPlayerController().playSong(id);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if (me.getClickCount() == 2)
			this.playSong((JTable) me.getSource());
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		this.playSong(controller.getTable());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}

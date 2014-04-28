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
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import utils.Utils;

public class AddFile implements ActionListener {

	private Controller controller;

	public AddFile(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {

		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Archivos MIDI", new String[] { "mid" }));
		fc.setMultiSelectionEnabled(true);
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setCurrentDirectory(new File(Utils.getPath()));
		fc.setVisible(true);
		int ret = fc.showOpenDialog(controller.getOwner());

		if (ret == JFileChooser.APPROVE_OPTION) {

			File[] selectedFiles = fc.getSelectedFiles();
			for (int i = 0; i < selectedFiles.length; i++) {
				File file = selectedFiles[i];
				controller.getMIDIList().agregar(file);
			}

		}

	}

}

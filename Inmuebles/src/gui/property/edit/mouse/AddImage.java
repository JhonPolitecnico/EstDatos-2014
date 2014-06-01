package gui.property.edit.mouse;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.property.edit.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import utils.Utils;

/**
 * Add image to actual property
 * 
 */
public class AddImage implements ActionListener {

	private Controller editController;

	public AddImage(Controller editController) {
		super();
		this.editController = editController;
	}

	public void actionPerformed(ActionEvent ae) {

		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", new String[] { "jpg", "png" }));
		fc.setMultiSelectionEnabled(false);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setCurrentDirectory(new File(Utils.getPath()));
		fc.setVisible(true);
		int ret = fc.showOpenDialog(this.editController);

		if (ret == JFileChooser.APPROVE_OPTION) {

			File file = fc.getSelectedFile();

			String relativePath = Utils.getNewImagePath(file);

			if (relativePath.equals("")) {
				this.onError();
				return;
			}

			try {
				this.editController.setPhoto(relativePath);
			} catch (Exception e) {
				this.onError();
			}

		}

	}

	private void onError() {
		JOptionPane.showMessageDialog(this.editController, "Ocurrio un error inesperado, intentelo de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

}

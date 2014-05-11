package gui.main.mouse;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.Controller;
import gui.main.workspace.Workspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import jpng.file.JpngFile;
import serializer.engine.Serializer;
import utils.Utils;

public class Load implements ActionListener {

	private Controller main;
	private Workspace workspace;

	public Load(Controller main, Workspace workspace) {
		this.main = main;
		this.workspace = workspace;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Cargar - Jhon's Portable Network Graphics");
		fc.setFileFilter(new FileNameExtensionFilter("Archivos JPNG", new String[] { "jpng" }));
		fc.setCurrentDirectory(new File(Utils.getPath()));
		int ret = fc.showOpenDialog(main);

		if (ret == JFileChooser.APPROVE_OPTION) {
			Serializer serializer = new Serializer(fc.getSelectedFile());

			Object obj = serializer.unserialize();

			if (obj instanceof JpngFile) {
				JpngFile jpng = (JpngFile) obj;
				this.workspace.setBrushes(jpng.getBrushes());
			} else
				JOptionPane.showMessageDialog(this.main, "Oops! El archivo que intentas cargar esta corrupto", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

}

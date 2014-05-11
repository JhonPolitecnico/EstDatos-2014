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

public class Save implements ActionListener {

	private Controller main;
	private Workspace workspace;

	public Save(Controller main, Workspace workspace) {
		this.main = main;
		this.workspace = workspace;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Guardar - Jhon's Portable Network Graphics");
		fc.setFileFilter(new FileNameExtensionFilter("Archivos JPNG", new String[] { "jpng" }));
		fc.setCurrentDirectory(new File(Utils.getPath()));
		int ret = fc.showSaveDialog(this.main);

		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			file = new File(file.getAbsolutePath() + ".jpng");
			Serializer serializer = new Serializer(file);

			if (serializer.serialize(new JpngFile(this.workspace.getBrushes())))
				JOptionPane.showMessageDialog(this.main, "El dibujo se guardo correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(this.main, "Oops! Ocurrio un error inesperado al guardar", "ERROR", JOptionPane.ERROR_MESSAGE);

		}

	}

}

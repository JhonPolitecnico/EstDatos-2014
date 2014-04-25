package gui.main.mouse;

import gui.main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import midi.MIDIFile;
import utils.Utils;

public class EmptyList implements ActionListener {

	private Controller controller;

	public EmptyList(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		controller.getMIDIList().clear();
	}

}

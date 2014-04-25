package gui.main.check;

import gui.main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import midi.MIDIFile;
import utils.Utils;

public class Repeat implements ActionListener {

	private Controller controller;

	public Repeat(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		controller.getPlayerController().setRepeat(!controller.getPlayerController().isRepeat());
	}

}

package gui.main.window;

import gui.main.Controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import midi.MIDIPLayList;
import serializer.engine.Serializer;
import utils.Utils;

public class WindowController implements WindowListener {

	Controller controller;

	public WindowController(Controller controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		/*
		 * Serializer
		 */
		Serializer s = new Serializer(Utils.getLibrary());
		s.serialize(this.controller.getPlayList());
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}

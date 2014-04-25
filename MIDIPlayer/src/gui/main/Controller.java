package gui.main;

import gui.main.player.MIDIPlayerController;
import midi.MIDIListModel;

public class Controller {

	private Main owner;
	private MIDIListModel MIDIList;
	private MIDIPlayerController playerController;

	public Controller(Main owner) {
		super();
		this.owner = owner;
		this.MIDIList = new MIDIListModel();
		this.playerController = new MIDIPlayerController(this);
	}

	/*
	 * Getters & Setters
	 */

	public Main getOwner() {
		return owner;
	}

	public void setOwner(Main owner) {
		this.owner = owner;
	}

	public MIDIListModel getMIDIList() {
		return MIDIList;
	}

	public void setMIDIList(MIDIListModel mIDIList) {
		MIDIList = mIDIList;
	}

	public MIDIPlayerController getPlayerController() {
		return playerController;
	}

	public void setPlayerController(MIDIPlayerController playerController) {
		this.playerController = playerController;
	}
}

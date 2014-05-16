package gui.details;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.details.mouse.Cancel;
import gui.details.mouse.Save;

import midi.Song;

/**
 * Edit the properties of music files
 * 
 */
public class Controller extends Details {

	private static final long serialVersionUID = -4549619257548714350L;

	private gui.main.Controller main;
	private int row;
	private Song song;

	/**
	 * Edit a row
	 * 
	 * @param main
	 *            Main frame
	 * @param row
	 *            Row to edit
	 */
	public Controller(gui.main.Controller main, int row) {
		super();
		this.main = main;
		this.row = row;
		this.song = this.main.getMIDITable().getRow(this.row);
		super.txtFile.setText(this.song.getMIDIFile().getFileName());
		super.txtArtist.setText(this.song.getArtist());
		super.txtYear.setText(String.valueOf(this.song.getYear()));
		super.txtAlbum.setText(this.song.getAlbum());
		super.txtLength.setText(this.song.getLength());
		super.txtTitle.setText(this.song.getTitle());

		/**
		 * Events
		 */
		super.btnCancel.addActionListener(new Cancel(this));
		super.btnSave.addActionListener(new Save(this));

		super.setLocationRelativeTo(this.main);
		super.setVisible(true);
	}

	/*
	 * Getters & Setters
	 */

	public gui.main.Controller getMain() {
		return this.main;
	}

	public int getRow() {
		return this.row;
	}

	public Song getSong() {
		return this.song;
	}

}

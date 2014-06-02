package gui.main.player;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.JOptionPane;

import gui.main.Controller;
import midi.Song;
import midi.player.MIDIPLayerListener;
import midi.player.MIDIPlayer;
import midi.player.MIDIPlayerEvent;

/**
 * Controller of player
 * 
 * Contains the current playlist, performs actions start, pause, stop, repeat.
 * 
 * Handles errors related to playback MIDI files
 * 
 */
public class MIDIPlayerController implements MIDIPLayerListener {

	private Controller controller;
	private MIDIPlayer player;
	private int id;
	private boolean repeat;

	public MIDIPlayerController(Controller controller) {
		super();
		this.controller = controller;
		this.id = 0;
		repeat = false;
	}

	/**
	 * Creates a new music player capable of playing a sound
	 * 
	 * @param id
	 */
	private void newPlayer(int id) {
		Song song = this.controller.getMIDITable().getRow(id);
		this.controller.setCurrentSong(song.getTitle());
		this.player = new MIDIPlayer(song.getMIDIFile());
		this.player.setEventListener(this);
		if (this.player.prepare())
			this.player.playAndPause();
	}

	/**
	 * Play specific song
	 * 
	 * @param id
	 */
	public void playSong(int id) {
		this.stop();
		this.id = id;
		this.newPlayer(this.id);
	}

	/**
	 * Play previous song
	 */
	public void prevSong() {
		this.id--;

		if (this.id >= controller.getMIDITable().getRowCount() || this.id < 0)
			this.reset();
		else
			this.stop();

		this.newPlayer(this.id);
	}

	/**
	 * Play next song
	 */
	public void nextSong() {
		this.id++;
		if (this.id >= controller.getMIDITable().getRowCount())
			this.reset();
		else
			this.stop();

		this.newPlayer(this.id);
	}

	@Override
	public void onTerminate(MIDIPlayerEvent e) {
		this.id++;

		if (this.id >= controller.getMIDITable().getRowCount()) {
			this.reset();

			/**
			 * Repeat at the end of the playlist
			 */
			if (!isRepeat())
				return;
		}

		this.newPlayer(this.id);
	}

	@Override
	public void onMIDIUnavailable(MIDIPlayerEvent e) {
		this.reset();
		JOptionPane.showMessageDialog(this.controller, "Oops, usted no tiene una libreria MIDI compatible", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onInvalidMIDIFile(MIDIPlayerEvent e) {
		this.reset();
		JOptionPane.showMessageDialog(this.controller, "Oops, el archivo que intenta reproducir no es un archivo MIDI compatible o esta corrupto", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onFileNotFound(MIDIPlayerEvent e) {
		this.reset();
		JOptionPane.showMessageDialog(this.controller, "Oops, el archivo que intenta reproducir no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Reset counter and stop cueent song
	 */
	public void reset() {
		this.id = 0;
		this.stop();
	}

	/**
	 * Determines if is active the repeat flag
	 * 
	 * @return
	 */
	public boolean isRepeat() {
		return repeat;
	}

	/**
	 * Set repeat flag
	 * 
	 * @param repeat
	 */
	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	/**
	 * Get current player
	 * 
	 * @return
	 */
	public MIDIPlayer getPlayer() {
		return player;
	}

	/**
	 * Play or pause current song
	 */
	public void playAndPause() {
		this.player.playAndPause();
	}

	/**
	 * Stop current song
	 */
	public void stop() {
		if (!this.isPlaying())
			return;
		this.player.stop();
		this.player = null;
	}

	/**
	 * Determines if a song is playing
	 * 
	 * @return
	 */
	public boolean isPlaying() {
		return (this.player != null);
	}

	/**
	 * Play from the start the current song
	 */
	public void playCurrent() {
		this.newPlayer(this.id);
	}

}

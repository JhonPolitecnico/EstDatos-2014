package midi;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.Serializable;

import midi.player.MIDIPlayer;

/**
 * The skeleton of song
 * 
 */
public class Song implements Serializable {

	private static final long serialVersionUID = 4614709442745098197L;

	private String title;
	private String artist;
	private int year;
	private String album;
	private String length;
	private MIDIFile mIDIFile;

	/**
	 * Create a song from a MIDIFile
	 * 
	 * @param mIDIFile
	 */
	public Song(MIDIFile mIDIFile) {
		super();
		this.mIDIFile = mIDIFile;

		/**
		 * Set time of song
		 */
		MIDIPlayer tempPlayer = new MIDIPlayer(this.mIDIFile);

		if (!tempPlayer.prepare()) {
			this.length = "00:00:00";
			return;
		}

		/**
		 * Additions and subtractions ;D
		 */
		long microseconds = tempPlayer.getMicrosecondTime();
		long minutes = 0;
		long seconds = 0;
		long milliseconds = microseconds / 1000;

		if (milliseconds >= 1000) {
			seconds = milliseconds / 1000;
			milliseconds = milliseconds - (seconds * 1000);
		}

		if (seconds >= 60) {
			minutes = seconds / 60;
			seconds = seconds - (minutes * 60);
		}

		this.length = String.format("%02d:%02d:%04d", minutes, seconds, milliseconds);

	}

	public String toString() {

		if (this.title != null)
			return this.title;

		if (this.mIDIFile != null)
			return mIDIFile.getFileName();

		return "No disponible";
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public int getYear() {
		return year;
	}

	public String getAlbum() {
		return album;
	}

	public String getLength() {
		return length;
	}

	public MIDIFile getMIDIFile() {
		return mIDIFile;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public void setMIDIFile(MIDIFile mIDIFile) {
		this.mIDIFile = mIDIFile;
	}

}

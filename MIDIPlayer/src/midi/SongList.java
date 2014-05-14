package midi;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 * List that contains all the songs from this Seller
 * 
 * Ensures data synchronization in all playlists
 * 
 */
public class SongList implements Serializable {

	private static final long serialVersionUID = -7206256068965025522L;

	private static SongList instance;
	private ArrayList<Song> songs;

	private SongList() {
		this.songs = new ArrayList<Song>();
	}

	public boolean exists(MIDIFile mIDIFile) {

		for (Song single : this.songs)
			if (single.getMIDIFile().getFile().getAbsolutePath().equals(mIDIFile.getFile().getAbsolutePath()))
				return true;

		return false;
	}

	public Song getSong(MIDIFile mIDIFile) {
		for (int i = 0; i < songs.size(); i++)
			if (mIDIFile.getFile().getAbsolutePath().equals(songs.get(i).getMIDIFile().getFile().getAbsolutePath()))
				return songs.get(i);

		return null;
	}

	public Song addSong(Song song) {
		if (!this.exists(song.getMIDIFile()))
			this.songs.add(song);

		return this.getSong(song.getMIDIFile());
	}

	public static SongList getInstance() {
		return (instance != null) ? instance : (instance = new SongList());
	}

}

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

public class SongList implements Serializable {

	private static final long serialVersionUID = -7206256068965025522L;

	private static SongList instance;
	private ArrayList<Cancion> songs;

	private SongList() {
		this.songs = new ArrayList<Cancion>();
	}

	public boolean exists(MIDIFile mIDIFile) {

		for (Cancion single : this.songs)
			if (single.getArchivo().getFile().getAbsolutePath().equals(mIDIFile.getFile().getAbsolutePath()))
				return true;

		return false;
	}

	public Cancion getSong(MIDIFile mIDIFile) {
		for (int i = 0; i < songs.size(); i++)
			if (mIDIFile.getFile().getAbsolutePath().equals(songs.get(i).getArchivo().getFile().getAbsolutePath()))
				return songs.get(i);

		return null;
	}

	public Cancion addSong(Cancion song) {
		if (!this.exists(song.getArchivo()))
			this.songs.add(song);

		return this.getSong(song.getArchivo());
	}

	public static SongList getInstance() {
		return (instance != null) ? instance : (instance = new SongList());
	}

}

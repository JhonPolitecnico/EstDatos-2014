package midi;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class SongList implements Serializable {

	private static final long serialVersionUID = -7206256068965025522L;

	private static SongList instance;
	private ArrayList<Cancion> songs;

	private SongList() {
		this.songs = new ArrayList<Cancion>();
	}

	public boolean exists(File file) {

		for (Cancion single : this.songs)
			if (single.getArchivo().getAbsolutePath().equals(file.getAbsolutePath()))
				return true;

		return false;
	}

	public Cancion getSong(File file) {
		for (int i = 0; i < songs.size(); i++)
			if (file.getAbsolutePath().equals(songs.get(i).getArchivo().getAbsolutePath()))
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

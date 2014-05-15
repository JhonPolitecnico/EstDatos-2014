package library;

import java.io.Serializable;

import midi.MIDIPLayList;
import midi.SongList;

/**
 * Skeleton file library
 * 
 */
public class Library implements Serializable {

	private static final long serialVersionUID = -3340855410454139702L;

	private SongList songList;
	private MIDIPLayList playlists;

	public Library(SongList songList, MIDIPLayList playlists) {
		super();
		this.songList = songList;
		this.playlists = playlists;
	}

	public SongList getSongList() {
		return songList;
	}

	public MIDIPLayList getPlaylists() {
		return playlists;
	}

}

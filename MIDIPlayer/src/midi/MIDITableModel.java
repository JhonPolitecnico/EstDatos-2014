package midi;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * A model that contains a list of songs
 * 
 * @param <T>
 *            song of type "Song"
 */
public class MIDITableModel extends AbstractTableModel implements Serializable {

	private static final long serialVersionUID = 8391183624099206154L;

	private String[] columnNames = { "Titulo", "Artista", "Album", "Año", "Duracion" };
	private ArrayList<Song> songs;

	public MIDITableModel() {
		super();
		songs = new ArrayList<Song>();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return this.songs.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		if (rowIndex > this.songs.size() - 1)
			return null;

		Song song = this.songs.get(rowIndex);

		if (song == null)
			return null;

		switch (columnIndex) {
		case 0:
			return song.getTitle();

		case 1:
			return song.getArtist();

		case 2:
			return song.getAlbum();

		case 3:
			return song.getYear();

		case 4:
			return song.getLength();

		default:
			return null;
		}

	}

	/**
	 * Add files or directories recursively
	 * 
	 * @param fileOrPath
	 */
	public void addRecursiveFileOrPath(File fileOrPath) {

		if (fileOrPath == null)
			return;

		if (fileOrPath.isDirectory()) {

			String files[] = fileOrPath.list();
			for (int i = 0; i < files.length; i++) {
				File leafFile = new File(fileOrPath.getAbsolutePath(), files[i]);
				addRecursiveFileOrPath(leafFile);
			}

		} else if (fileOrPath.exists()) {
			this.addFile(fileOrPath);
		}

	}

	/**
	 * Add single file
	 * 
	 * @param file
	 */
	public void addFile(File file) {

		if (!file.getName().endsWith(".mid"))
			return;

		Song song = new Song(new MIDIFile(file.getAbsolutePath()));
		this.songs.add(SongList.getInstance().addSong(song));
	}
}

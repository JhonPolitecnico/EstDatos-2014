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

import javax.swing.DefaultListModel;

/**
 * A model that contains a list of songs
 * 
 * @param <T>
 *            song of type "Song"
 */
public class MIDIListModel<T extends Song> extends DefaultListModel<T> implements Serializable {

	private static final long serialVersionUID = 5697885976584118660L;

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
	@SuppressWarnings("unchecked")
	public void addFile(File file) {

		if (!file.getName().endsWith(".mid"))
			return;

		Song song = new Song(new MIDIFile(file.getAbsolutePath()));
		super.addElement((T) SongList.getInstance().addSong(song));
	}
}

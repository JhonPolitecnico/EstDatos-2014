package midi;

import java.io.File;
import java.io.Serializable;

import javax.swing.DefaultListModel;

public class MIDIListModel extends DefaultListModel<Cancion> implements Serializable {

	private static final long serialVersionUID = 5697885976584118660L;

	public void agregar(File fileOrPath) {

		if (fileOrPath == null)
			return;

		if (fileOrPath.isDirectory()) {

			String files[] = fileOrPath.list();
			for (int i = 0; i < files.length; i++) {
				File leafFile = new File(fileOrPath.getAbsolutePath(), files[i]);
				agregar(leafFile);
			}

		} else if (fileOrPath.exists()) {
			agregarArchivo(fileOrPath);
		}

	}

	public void agregarArchivo(File archivo) {

		if (!archivo.getName().endsWith(".mid"))
			return;

		Cancion song = new Cancion(new MIDIFile(archivo.getAbsolutePath()));
		super.addElement(SongList.getInstance().addSong(song));
	}
}

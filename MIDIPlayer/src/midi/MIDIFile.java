package midi;

import java.io.File;

public class MIDIFile extends File {

	private static final long serialVersionUID = -691317870702529354L;

	public MIDIFile(String rutaArchivo) {
		super(rutaArchivo);
	}

	public String getFileName() {
		return this.getName().split("\\.", 2)[0];
	}

}

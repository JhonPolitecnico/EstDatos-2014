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

public class MIDIFile extends File implements Serializable {

	private static final long serialVersionUID = -691317870702529354L;

	public MIDIFile(String rutaArchivo) {
		super(rutaArchivo);
	}

	public String getFileName() {
		return this.getName().split("\\.", 2)[0];
	}

}
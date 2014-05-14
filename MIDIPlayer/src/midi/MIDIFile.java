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

import utils.Utils;

/**
 * A skeleton that allows load files with relative address and offers some useful methods
 * 
 */
public class MIDIFile implements Serializable {

	private static final long serialVersionUID = -691317870702529354L;

	/**
	 * Filename or filepath (absolute or relative)
	 */
	private String file;

	public MIDIFile(String file) {
		this.file = file;

		/**
		 * If file is relative to actual path
		 */
		if (this.file.contains(Utils.getPath()))
			this.file = this.file.replace(Utils.getPath(), "");

		/**
		 * Remove the '\' at the beginning if you have
		 */
		if (this.file.charAt(0) == '\\')
			this.file = this.file.split("\\\\", 2)[1];
	}

	/**
	 * Get file with "File" class
	 * 
	 * @return
	 */
	public File getFile() {
		return new File(file);
	}

	/**
	 * Get filename without ext
	 * 
	 * @return
	 */
	public String getFileName() {
		return this.getFile().getName().split("\\.", 2)[0];
	}

}

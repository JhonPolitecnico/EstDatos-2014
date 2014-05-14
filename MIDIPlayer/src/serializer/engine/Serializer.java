package serializer.engine;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.*;

/**
 * Serializer
 * 
 * Serialize and unserialize an object
 * 
 */
public class Serializer {

	private File file;

	/**
	 * 
	 * @param file
	 *            a file to save or load the object
	 */
	public Serializer(File file) {
		super();
		this.file = file;
	}

	public boolean serialize(Object object) {

		boolean ret = true;

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(this.file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
		} catch (IOException e) {
			ret = false;
		} finally {

			// Close ObjectOutputStream
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					ret = false;
				}
			}

			// Close FileOutputStream
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					ret = false;
				}
			}
		}

		return ret;
	}

	public Object unserialize() {

		Object object = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(this.file);
			ois = new ObjectInputStream(fis);
			object = ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			return object;
		} finally {

			// Close ObjectInputStream
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					return object;
				}
			}

			// Close FileInputStream
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					return object;
				}
			}
		}

		return object;
	}
}

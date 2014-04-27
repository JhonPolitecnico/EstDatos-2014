package serializer.engine;

import java.io.*;

public class Serializer {

	File file;

	public Serializer(File file) {
		super();
		this.file = file;
	}

	public boolean serialize(Object object) {

		try {
			FileOutputStream fos = new FileOutputStream(this.file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			oos.close();
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	public Object unserialize() {

		Object object = null;
		try {
			FileInputStream fis = new FileInputStream(this.file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			object = ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			return object;
		}

		return object;
	}
}

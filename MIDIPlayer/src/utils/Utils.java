package utils;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.util.zip.*;

import javax.swing.JFrame;

/**
 * Utils
 * 
 */
public class Utils {

	/**
	 * Get current path
	 * 
	 * @return
	 */
	public static String getPath() {
		return System.getProperty("user.dir");
	}

	/**
	 * Get path to library
	 * 
	 * @return
	 */
	public static File getLibrary() {
		return new File(Utils.getPath() + "\\library.bin");
	}

	/**
	 * Center a frame
	 * 
	 * @param frame
	 */
	public static void centerFrame(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = dim.width / 2 - frame.getSize().width / 2;
		int y = dim.height / 2 - frame.getSize().height / 2;
		frame.setBounds(x, y, frame.getSize().width, frame.getSize().height);
	}

	public static long getCRC32(String file) {
		return getCRC32(new File(file));
	}

	public static long getCRC32(File file) {
		try {
			CheckedInputStream cis = new CheckedInputStream(new FileInputStream(file), new CRC32());
			BufferedInputStream ins = new BufferedInputStream(cis);
			while (ins.read() != -1) {
				// Read file in completely
			}
			ins.close();
			return cis.getChecksum().getValue();
		} catch (Exception e) {
			return 0;
		}
	}
}

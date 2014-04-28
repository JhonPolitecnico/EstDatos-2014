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
import java.io.File;

import javax.swing.JFrame;

public class Utils {

	public static String getPath() {
		return System.getProperty("user.dir");
	}

	public static File getLibrary() {
		return new File(Utils.getPath() + "\\library.bin");
	}

	public static void centerFrame(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = dim.width / 2 - frame.getSize().width / 2;
		int y = dim.height / 2 - frame.getSize().height / 2;
		frame.setBounds(x, y, frame.getSize().width, frame.getSize().height);
	}
}

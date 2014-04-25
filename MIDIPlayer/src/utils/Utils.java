package utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Utils {
	public static String getPath() {
		return System.getProperty("user.dir");
	}

	public static void centerFrame(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}
}

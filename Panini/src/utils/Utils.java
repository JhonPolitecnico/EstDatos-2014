package utils;

/**
 * Panini
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;

public class Utils {

	/**
	 * @reference: http://stackoverflow.com/a/363692/1050719
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static void centerFrame(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = dim.width / 2 - frame.getSize().width / 2;
		int y = dim.height / 2 - frame.getSize().height / 2;
		frame.setBounds(x, y, frame.getSize().width, frame.getSize().height);
	}
}

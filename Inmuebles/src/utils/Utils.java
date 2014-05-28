package utils;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.swing.ImageIcon;
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

	public static ImageIcon getImage(String relativePath) {
		return new ImageIcon(getPath() + "\\img\\" + relativePath);
	}

	public static ImageIcon getPhoto(String relativePath, int width, int height) {
		ImageIcon icon = new ImageIcon(getPath() + "\\img\\" + relativePath);
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(icon.getImage(), 0, 0, width, height, null);
		g2d.dispose();
		return new ImageIcon(bi);
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

	/**
	 * Terminate application
	 * 
	 */
	public static void fatalExit() {
		System.exit(0);
	}
}

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

	/**
	 * Get image from relative path
	 * 
	 * @param relativePath
	 * @return
	 * @throws Exception
	 *             on error
	 */
	public static ImageIcon getImage(String relativePath) throws Exception {
		File file = new File(getPath() + "\\img\\" + relativePath);
		if (!file.exists() || relativePath.equals(""))
			throw new Exception();
		ImageIcon img = new ImageIcon(file.getAbsolutePath());
		img.setDescription(relativePath);
		return img;
	}

	/**
	 * Get resized photo from relative path
	 * 
	 * @param relativePath
	 * @param width
	 * @param height
	 * @return
	 * @throws Exception
	 *             on error
	 */
	public static ImageIcon getPhoto(String relativePath, int width, int height) throws Exception {
		File file = new File(getPath() + "\\img\\" + relativePath);
		if (!file.exists() || relativePath.equals(""))
			throw new Exception();
		ImageIcon icon = new ImageIcon(file.getAbsolutePath());
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(icon.getImage(), 0, 0, width, height, null);
		g2d.dispose();
		ImageIcon img = new ImageIcon(bi);
		img.setDescription(relativePath);
		return img;
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

	/**
	 * Get application title
	 * 
	 * @return
	 */
	public static String getTitle() {
		return " - Jhon's Estate Sales";
	}
}

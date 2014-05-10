package gui.main;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */

import gui.main.workspace.Workspace;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import utils.Utils;

public class Main extends JFrame {

	private static final long serialVersionUID = 6181817596811086435L;

	protected JPanel contentPane;
	protected Workspace workspace;
	protected JPanel pnlLeft;
	protected JPanel pnlRight;
	protected JButton btnWhite;
	protected JButton btnBlack;
	protected JButton btnRed;
	protected JButton btnGreen;
	protected JButton btnBlue;
	protected JButton btnOrange;
	protected JButton btnLine;
	protected JButton btnTriangle;
	protected JButton btnSquare;
	protected JButton btnPolygon;

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		workspace = new Workspace(this);
		workspace.setBackground(Color.ORANGE);

		pnlLeft = new JPanel();

		pnlRight = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				gl_contentPane.createSequentialGroup().addComponent(pnlLeft, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(workspace, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnlRight, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE).addGap(0)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(pnlLeft, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
										.addComponent(pnlRight, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
										.addComponent(workspace, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)).addContainerGap()));

		btnWhite = new JButton("   ");
		btnWhite.setBackground(Color.WHITE);
		pnlRight.add(btnWhite);

		btnBlack = new JButton("   ");
		btnBlack.setBackground(Color.BLACK);
		pnlRight.add(btnBlack);

		btnRed = new JButton("   ");
		btnRed.setBackground(Color.RED);
		pnlRight.add(btnRed);

		btnGreen = new JButton("   ");
		btnGreen.setBackground(Color.GREEN);
		pnlRight.add(btnGreen);

		btnBlue = new JButton("   ");
		btnBlue.setBackground(Color.BLUE);
		pnlRight.add(btnBlue);

		btnOrange = new JButton("   ");
		btnOrange.setBackground(Color.ORANGE);
		pnlRight.add(btnOrange);

		btnLine = new JButton("");
		btnLine.setIcon(new ImageIcon(Utils.getPath() + "\\img\\line.png"));
		pnlLeft.add(btnLine);

		btnTriangle = new JButton("");
		btnTriangle.setIcon(new ImageIcon(Utils.getPath() + "\\img\\triangle.png"));
		pnlLeft.add(btnTriangle);

		btnSquare = new JButton("");
		btnSquare.setIcon(new ImageIcon(Utils.getPath() + "\\img\\square.png"));
		pnlLeft.add(btnSquare);

		btnPolygon = new JButton("");
		btnPolygon.setIcon(new ImageIcon(Utils.getPath() + "\\img\\polygon.png"));
		pnlLeft.add(btnPolygon);
		contentPane.setLayout(gl_contentPane);
	}
}

package property.list.cell;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;

public class Cell extends JPanel {

	private static final long serialVersionUID = 2778033245248768762L;
	protected JLabel lblImage;

	/**
	 * Create the panel.
	 */
	public Cell() {
		setSize(new Dimension(700, 121));

		lblImage = new JLabel("");
		lblImage.setVerticalAlignment(SwingConstants.TOP);
		lblImage.setAlignmentY(Component.TOP_ALIGNMENT);
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImage.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap().addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE).addContainerGap(550, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap().addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(20)));
		setLayout(groupLayout);

	}
}

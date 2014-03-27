package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import swing.jDataButton.JDataButton;
import ui.tic.tac.toe.UI;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 528, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		JButton BTN_Reset = new JButton("Jugar Otraves");

		JButton BTN_Salir = new JButton("Salir");
		BTN_Salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
										.addGroup(
												groupLayout.createSequentialGroup().addComponent(BTN_Reset, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
														.addComponent(BTN_Salir, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addGap(6).addComponent(panel, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(BTN_Reset).addComponent(BTN_Salir)).addContainerGap(68, Short.MAX_VALUE)));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[] { 128, 128, 128, 0, 0 };
		gbl_panel.columnWidths = new int[] { 128, 128, 128 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);

		JDataButton BTN_00 = new JDataButton();
		GridBagConstraints gbc_BTN_00 = new GridBagConstraints();
		gbc_BTN_00.fill = GridBagConstraints.BOTH;
		gbc_BTN_00.insets = new Insets(0, 0, 5, 5);
		gbc_BTN_00.gridx = 0;
		gbc_BTN_00.gridy = 0;
		panel.add(BTN_00, gbc_BTN_00);

		JDataButton BTN_01 = new JDataButton();
		GridBagConstraints gbc_BTN_01 = new GridBagConstraints();
		gbc_BTN_01.fill = GridBagConstraints.BOTH;
		gbc_BTN_01.insets = new Insets(0, 0, 5, 5);
		gbc_BTN_01.gridx = 1;
		gbc_BTN_01.gridy = 0;
		panel.add(BTN_01, gbc_BTN_01);

		JDataButton BTN_02 = new JDataButton();
		GridBagConstraints gbc_BTN_02 = new GridBagConstraints();
		gbc_BTN_02.insets = new Insets(0, 0, 5, 0);
		gbc_BTN_02.fill = GridBagConstraints.BOTH;
		gbc_BTN_02.gridx = 2;
		gbc_BTN_02.gridy = 0;
		panel.add(BTN_02, gbc_BTN_02);

		JDataButton BTN_10 = new JDataButton();
		GridBagConstraints gbc_BTN_10 = new GridBagConstraints();
		gbc_BTN_10.fill = GridBagConstraints.BOTH;
		gbc_BTN_10.insets = new Insets(0, 0, 5, 5);
		gbc_BTN_10.gridx = 0;
		gbc_BTN_10.gridy = 1;
		panel.add(BTN_10, gbc_BTN_10);

		JDataButton BTN_11 = new JDataButton();
		GridBagConstraints gbc_BTN_11 = new GridBagConstraints();
		gbc_BTN_11.fill = GridBagConstraints.BOTH;
		gbc_BTN_11.insets = new Insets(0, 0, 5, 5);
		gbc_BTN_11.gridx = 1;
		gbc_BTN_11.gridy = 1;
		panel.add(BTN_11, gbc_BTN_11);

		JDataButton BTN_12 = new JDataButton();
		GridBagConstraints gbc_BTN_12 = new GridBagConstraints();
		gbc_BTN_12.insets = new Insets(0, 0, 5, 0);
		gbc_BTN_12.fill = GridBagConstraints.BOTH;
		gbc_BTN_12.gridx = 2;
		gbc_BTN_12.gridy = 1;
		panel.add(BTN_12, gbc_BTN_12);

		JDataButton BTN_20 = new JDataButton();
		GridBagConstraints gbc_BTN_20 = new GridBagConstraints();
		gbc_BTN_20.fill = GridBagConstraints.BOTH;
		gbc_BTN_20.insets = new Insets(0, 0, 5, 5);
		gbc_BTN_20.gridx = 0;
		gbc_BTN_20.gridy = 2;
		panel.add(BTN_20, gbc_BTN_20);

		JDataButton BTN_21 = new JDataButton();
		GridBagConstraints gbc_BTN_21 = new GridBagConstraints();
		gbc_BTN_21.fill = GridBagConstraints.BOTH;
		gbc_BTN_21.insets = new Insets(0, 0, 5, 5);
		gbc_BTN_21.gridx = 1;
		gbc_BTN_21.gridy = 2;
		panel.add(BTN_21, gbc_BTN_21);

		JDataButton BTN_22 = new JDataButton();
		GridBagConstraints gbc_BTN_22 = new GridBagConstraints();
		gbc_BTN_22.fill = GridBagConstraints.BOTH;
		gbc_BTN_22.insets = new Insets(0, 0, 5, 0);
		gbc_BTN_22.gridx = 2;
		gbc_BTN_22.gridy = 2;
		panel.add(BTN_22, gbc_BTN_22);
		frame.getContentPane().setLayout(groupLayout);

		final UI UI = new UI(frame, BTN_00, BTN_01, BTN_02, BTN_10, BTN_11, BTN_12, BTN_20, BTN_21, BTN_22);

		BTN_Reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UI.reset();
			}
		});

	}
}

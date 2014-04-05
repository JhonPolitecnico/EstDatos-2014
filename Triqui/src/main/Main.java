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

/**
 * Triqui
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
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
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																panel,
																GroupLayout.DEFAULT_SIZE,
																502,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				BTN_Reset,
																				GroupLayout.PREFERRED_SIZE,
																				186,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				130,
																				Short.MAX_VALUE)
																		.addComponent(
																				BTN_Salir,
																				GroupLayout.PREFERRED_SIZE,
																				186,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addGap(6)
								.addComponent(panel,
										GroupLayout.PREFERRED_SIZE, 453,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										groupLayout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(BTN_Reset)
												.addComponent(BTN_Salir))
								.addContainerGap(68, Short.MAX_VALUE)));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[] { 128, 128, 128, 0, 0 };
		gbl_panel.columnWidths = new int[] { 128, 128, 128 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);

		/*
		 * Runtime buttons
		 */
		JDataButton[] buttons = new JDataButton[9];
		GridBagConstraints[] gbc_buttons = new GridBagConstraints[9];

		int pos = 0;
		for (int i = 0; i < 9; i += 3) {

			for (int j = 0; j < 3; j++) {
				buttons[i + j] = new JDataButton();
				gbc_buttons[i + j] = new GridBagConstraints();

				gbc_buttons[i + j].fill = GridBagConstraints.BOTH;
				if (pos < 2) {
					gbc_buttons[i + j].insets = new Insets(0, 0, 5, 5);
					pos++;
				} else {
					gbc_buttons[i + j].insets = new Insets(0, 0, 5, 0);
					pos = 0;
				}

				gbc_buttons[i + j].gridx = j;
				gbc_buttons[i + j].gridy = i / 3;

				panel.add(buttons[i + j], gbc_buttons[i + j]);
			}

		}

		frame.getContentPane().setLayout(groupLayout);

		final UI UI = new UI(frame, buttons);

		BTN_Reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UI.reset();
			}
		});

	}
}

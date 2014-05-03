package gui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JButton button = new JButton("   ");
		button.setBackground(Color.WHITE);
		panel_2.add(button);
		
		JButton button_1 = new JButton("   ");
		button_1.setBackground(Color.BLACK);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("   ");
		button_2.setBackground(Color.RED);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("   ");
		button_3.setBackground(Color.GREEN);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("   ");
		button_4.setBackground(Color.BLUE);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("   ");
		button_5.setBackground(Color.ORANGE);
		panel_2.add(button_5);
		
		JButton btnLinea = new JButton("");
		btnLinea.setIcon(new ImageIcon("C:\\Users\\jjeslava\\git\\Proyectos-2014\\Paint [Paradigmas]\\img\\line.png"));
		panel_1.add(btnLinea);
		
		JButton btnTriangulo = new JButton("");
		btnTriangulo.setIcon(new ImageIcon("C:\\Users\\jjeslava\\git\\Proyectos-2014\\Paint [Paradigmas]\\img\\triangle.png"));
		panel_1.add(btnTriangulo);
		
		JButton btnCuadrado = new JButton("");
		btnCuadrado.setIcon(new ImageIcon("C:\\Users\\jjeslava\\git\\Proyectos-2014\\Paint [Paradigmas]\\img\\square.png"));
		panel_1.add(btnCuadrado);
		
		JButton btnPoligono = new JButton("");
		btnPoligono.setIcon(new ImageIcon("C:\\Users\\jjeslava\\git\\Proyectos-2014\\Paint [Paradigmas]\\img\\polygon.png"));
		panel_1.add(btnPoligono);
		contentPane.setLayout(gl_contentPane);
	}
}

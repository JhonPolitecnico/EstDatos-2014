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
		setBounds(100, 100, 746, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
					.addGap(116))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton btnLinea = new JButton("Linea");
		panel_1.add(btnLinea);
		
		JButton btnTriangulo = new JButton("Triangulo");
		panel_1.add(btnTriangulo);
		
		JButton btnCuadrado = new JButton("Cuadrado");
		panel_1.add(btnCuadrado);
		
		JButton btnPoligono = new JButton("Poligono");
		panel_1.add(btnPoligono);
		contentPane.setLayout(gl_contentPane);
	}
}

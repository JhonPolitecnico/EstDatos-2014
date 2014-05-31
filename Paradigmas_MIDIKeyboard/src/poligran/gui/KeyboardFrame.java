package poligran.gui;

/**
 * MIDIKeyBoard
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import poligran.model.KeyPlayer;
import poligran.model.exceptions.KeyLoaderException;

public class KeyboardFrame extends JFrame {

	private static final long serialVersionUID = 2370440304861747818L;

	private JPanel contentPane;
	private JLabel btnC;
	private JLabel btnD;
	private JLabel btnE;
	private JLabel btnF;
	private JLabel btnG;
	private JLabel btnA;
	private JLabel btnB;
	private JLabel btnC_;
	private JLabel btnD_;
	private JLabel btnF_;
	private JLabel btnG_;
	private JLabel btnA_;

	private PianoKeyboardListener keyboardListener;
	private MenuListener menuListener;
	private KeyPlayer player;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmResetLog;
	private JMenuItem mntmSaveLog;
	private JMenuItem mntmShowLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyboardFrame frame = new KeyboardFrame();
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
	public KeyboardFrame() {
		setTitle("Piano Keyboard Test");
		keyboardListener = new PianoKeyboardListener(this);
		menuListener = new MenuListener(this);

		try {
			this.player = new KeyPlayer();
		} catch (KeyLoaderException e) {
			JOptionPane.showMessageDialog(this, "Error cargando definicion de flechas");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 296);

		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);

		this.mnFile = new JMenu("File");
		this.menuBar.add(this.mnFile);

		this.mntmResetLog = new JMenuItem("Reset log");
		this.mnFile.add(this.mntmResetLog);
		this.mntmResetLog.setActionCommand(MenuListener.MENU_RESET);
		this.mntmResetLog.addActionListener(this.menuListener);

		this.mntmSaveLog = new JMenuItem("Save log");
		this.mnFile.add(this.mntmSaveLog);
		this.mntmSaveLog.setActionCommand(MenuListener.MENU_SAVE);
		this.mntmSaveLog.addActionListener(this.menuListener);

		this.mntmShowLog = new JMenuItem("Show log");
		this.mnFile.add(this.mntmShowLog);
		this.mntmShowLog.setActionCommand(MenuListener.MENU_SHOW);
		this.mntmShowLog.addActionListener(this.menuListener);

		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		this.btnC_ = new JLabel("");
		this.btnC_.setBackground(Color.BLACK);
		this.btnC_.setBounds(54, 0, 44, 160);
		this.contentPane.add(this.btnC_);
		this.btnC_.setOpaque(true);
		this.btnC_.addMouseListener(this.keyboardListener);

		this.btnD_ = new JLabel("");
		this.btnD_.setBackground(Color.BLACK);
		this.btnD_.setBounds(131, 0, 44, 160);
		this.contentPane.add(this.btnD_);
		this.btnD_.setOpaque(true);
		this.btnD_.addMouseListener(this.keyboardListener);

		this.btnF_ = new JLabel("");
		this.btnF_.setBackground(Color.BLACK);
		this.btnF_.setBounds(278, 0, 44, 160);
		this.contentPane.add(this.btnF_);
		this.btnF_.setOpaque(true);
		this.btnF_.addMouseListener(this.keyboardListener);

		this.btnG_ = new JLabel("");
		this.btnG_.setBackground(Color.BLACK);
		this.btnG_.setBounds(355, 0, 44, 160);
		this.contentPane.add(this.btnG_);
		this.btnG_.setOpaque(true);
		this.btnG_.addMouseListener(this.keyboardListener);

		this.btnA_ = new JLabel("");
		this.btnA_.setBackground(Color.BLACK);
		this.btnA_.setBounds(432, 0, 44, 160);
		this.contentPane.add(this.btnA_);
		this.btnA_.setOpaque(true);
		this.btnA_.addMouseListener(this.keyboardListener);

		this.btnC = new JLabel("");
		this.btnC.setBackground(Color.WHITE);
		this.btnC.setBounds(0, 0, 75, 249);
		this.contentPane.add(this.btnC);
		this.btnC.setOpaque(true);
		this.btnC.setBorder(BorderFactory.createLineBorder(Color.black));
		this.btnC.addMouseListener(this.keyboardListener);

		this.btnD = new JLabel("");
		this.btnD.setBackground(Color.WHITE);
		this.btnD.setBounds(76, 0, 75, 249);
		this.contentPane.add(this.btnD);
		this.btnD.setOpaque(true);
		this.btnD.setBorder(BorderFactory.createLineBorder(Color.black));
		this.btnD.addMouseListener(this.keyboardListener);

		this.btnE = new JLabel("");
		this.btnE.setBackground(Color.WHITE);
		this.btnE.setBounds(151, 0, 75, 249);
		this.contentPane.add(this.btnE);
		this.btnE.setOpaque(true);
		this.btnE.setBorder(BorderFactory.createLineBorder(Color.black));
		this.btnE.addMouseListener(this.keyboardListener);

		this.btnF = new JLabel("");
		this.btnF.setBackground(Color.WHITE);
		this.btnF.setBounds(226, 0, 75, 249);
		this.contentPane.add(this.btnF);
		this.btnF.setOpaque(true);
		this.btnF.setBorder(BorderFactory.createLineBorder(Color.black));
		this.btnF.addMouseListener(this.keyboardListener);

		this.btnG = new JLabel("");
		this.btnG.setBackground(Color.WHITE);
		this.btnG.setBounds(300, 0, 75, 249);
		this.contentPane.add(this.btnG);
		this.btnG.setOpaque(true);
		this.btnG.setBorder(BorderFactory.createLineBorder(Color.black));
		this.btnG.addMouseListener(this.keyboardListener);

		this.btnA = new JLabel("");
		this.btnA.setBackground(Color.WHITE);
		this.btnA.setBounds(375, 0, 75, 249);
		this.contentPane.add(this.btnA);
		this.btnA.setOpaque(true);
		this.btnA.setBorder(BorderFactory.createLineBorder(Color.black));
		this.btnA.addMouseListener(this.keyboardListener);

		this.btnB = new JLabel("");
		this.btnB.setBackground(Color.WHITE);
		this.btnB.setBounds(450, 0, 75, 249);
		this.contentPane.add(this.btnB);
		this.btnB.setOpaque(true);
		this.btnB.setBorder(BorderFactory.createLineBorder(Color.black));
		this.btnB.addMouseListener(this.keyboardListener);
	}

	public JLabel getBtnC() {
		return btnC;
	}

	public void setBtnC(JLabel btnC) {
		this.btnC = btnC;
	}

	public JLabel getBtnD() {
		return btnD;
	}

	public void setBtnD(JLabel btnD) {
		this.btnD = btnD;
	}

	public JLabel getBtnE() {
		return btnE;
	}

	public void setBtnE(JLabel btnE) {
		this.btnE = btnE;
	}

	public JLabel getBtnF() {
		return btnF;
	}

	public void setBtnF(JLabel btnF) {
		this.btnF = btnF;
	}

	public JLabel getBtnG() {
		return btnG;
	}

	public void setBtnG(JLabel btnG) {
		this.btnG = btnG;
	}

	public JLabel getBtnA() {
		return btnA;
	}

	public void setBtnA(JLabel btnA) {
		this.btnA = btnA;
	}

	public JLabel getBtnB() {
		return btnB;
	}

	public void setBtnB(JLabel btnB) {
		this.btnB = btnB;
	}

	public JLabel getBtnC_() {
		return btnC_;
	}

	public void setBtnC_(JLabel btnC_) {
		this.btnC_ = btnC_;
	}

	public JLabel getBtnD_() {
		return btnD_;
	}

	public void setBtnD_(JLabel btnD_) {
		this.btnD_ = btnD_;
	}

	public JLabel getBtnF_() {
		return btnF_;
	}

	public void setBtnF_(JLabel btnF_) {
		this.btnF_ = btnF_;
	}

	public JLabel getBtnG_() {
		return btnG_;
	}

	public void setBtnG_(JLabel btnG_) {
		this.btnG_ = btnG_;
	}

	public JLabel getBtnA_() {
		return btnA_;
	}

	public void setBtnA_(JLabel btnA_) {
		this.btnA_ = btnA_;
	}

	public void playNote(String note) {
		player.playNote(note);
	}

	public void showLog() {
		String log = this.player.getNotesLog().toString();
		JOptionPane.showMessageDialog(this, log);
	}

	public void saveLog() {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			this.player.saveLog(f);
		}

	}

	public void resetLog() {
		// TODO Auto-generated method stub

	}
}

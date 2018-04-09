package Coin;

import java.util.Random;
import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import sound.Sound;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class coin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String frame = null;
	static Random rand = new Random();
	private JPanel contentPane;
	static int counter = 0;
	static int head = 0;
	static int tail = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coin frame = new coin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public coin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 301);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JOptionPane pane = new JOptionPane(
						"This is a little app in case you don't have a coin handy to toss a coin and see what you get. \n Coin sound was downloaded from https://freesound.org/ and it used with a free license.");
				final JDialog d = pane.createDialog((JFrame) null, "About");
				d.setVisible(true);
			}
		});
		mnMenu.add(mntmAbout);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnMenu.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(158, 125, 79, 14);
		contentPane.add(lblNewLabel);

		JLabel lblTimesFlipped = new JLabel();

		lblTimesFlipped.setBounds(0, 196, 139, 14);
		contentPane.add(lblTimesFlipped);

		JLabel lblHeads = new JLabel();
		lblHeads.setBounds(0, 221, 64, 14);
		contentPane.add(lblHeads);

		JLabel lblTail = new JLabel();
		lblTail.setBounds(93, 221, 64, 14);
		contentPane.add(lblTail);

		JButton btnNewButton = new JButton("Flip a coin!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter++;
				lblTimesFlipped.setText("Times flipped: " + counter);
				boolean coin = rand.nextBoolean();				
				
				Sound s = new Sound();
				s.playSound();				
				//Sound.playSound1();
				
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (coin == true) {
					head++;
					lblHeads.setText("Heads: " + head);
					final JOptionPane pane = new JOptionPane("Heads");
					final JDialog d = pane.createDialog((JFrame) null, " You got heads!");
					d.setVisible(true);
				} else {
					tail++;
					lblTail.setText("Tail: " + tail);
					final JOptionPane pane = new JOptionPane("Tails");
					final JDialog d = pane.createDialog((JFrame) null, " You got tails! ");
					d.setVisible(true);
				}
				if (counter == 100) {
					final JOptionPane pane = new JOptionPane(
							"This is not supposed to be addictive! Why are you still clicking?");
					final JDialog d = pane.createDialog((JFrame) null, "We are concerned!");
					d.setVisible(true);

				}

			}
		});
		btnNewButton.setBounds(118, 91, 139, 23);
		contentPane.add(btnNewButton);
	}	

	
}

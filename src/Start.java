import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Start {

  private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmailAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
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
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 832, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setBounds(24, 25, 138, 27);
		frame.getContentPane().add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(24, 49, 138, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setBounds(24, 81, 138, 14);
		frame.getContentPane().add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(24, 96, 138, 20);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailAddress.setBounds(24, 137, 138, 14);
		frame.getContentPane().add(lblEmailAddress);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setBounds(24, 151, 138, 20);
		frame.getContentPane().add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLUE);
		menuBar.setBounds(24, 208, 97, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnCharityOptions = new JMenu("Charity Options");
		menuBar.add(mnCharityOptions);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(Color.BLUE);
		menuBar_1.setBounds(244, 208, 97, 21);
		frame.getContentPane().add(menuBar_1);
		
		JMenu mnAmountDonated = new JMenu("Amount Donated ");
		menuBar_1.add(mnAmountDonated);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnAmountDonated.add(mntmNewMenuItem);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubmit.setBounds(34, 449, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JMenuBar menuBar_2 = new JMenuBar();
		frame.setJMenuBar(menuBar_2);
		
		JMenu mnFile = new JMenu("File ");
		menuBar_2.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnFile.add(mntmExit);
	}
}

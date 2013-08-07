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
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollBar;


public class Start {

  private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmailAddress;
	private JTable table;
	private JTextField textDonationAmount;

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
		frame.setBounds(100, 100, 727, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setBounds(30, 82, 138, 27);
		frame.getContentPane().add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(30, 106, 138, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setBounds(30, 138, 138, 14);
		frame.getContentPane().add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(30, 153, 138, 20);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailAddress.setBounds(30, 186, 138, 20);
		frame.getContentPane().add(lblEmailAddress);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setBounds(30, 208, 138, 20);
		frame.getContentPane().add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
		
		JComboBox cmbCharity = new JComboBox();
		cmbCharity.setBounds(30, 52, 138, 22);
		frame.getContentPane().add(cmbCharity);
		
		JLabel lblCharityName = new JLabel("Charity Name:");
		lblCharityName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCharityName.setBounds(30, 13, 116, 26);
		frame.getContentPane().add(lblCharityName);
		
		table = new JTable();
		table.setBounds(190, 47, 507, 270);
		frame.getContentPane().add(table);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(49, 288, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		textDonationAmount = new JTextField();
		textDonationAmount.setBounds(30, 253, 138, 22);
		frame.getContentPane().add(textDonationAmount);
		textDonationAmount.setColumns(10);
		
		JLabel lblDonationAmount = new JLabel("Donation Amount");
		lblDonationAmount.setBounds(49, 235, 116, 16);
		frame.getContentPane().add(lblDonationAmount);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(676, 141, 21, 48);
		frame.getContentPane().add(scrollBar);
		
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

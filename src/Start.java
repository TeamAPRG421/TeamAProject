import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JTable;
import Logic.*;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class Start {

  private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmailAddress;
	private JTextField textDonationAmount;
	private JTable table;
	
	private DonorRepository donorRepository;
	private JComboBox<Charity> cmbCharity;

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
		donorRepository = new DonorRepository();
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
		
		cmbCharity = new JComboBox<Charity>();
		this.populateCharities();
		cmbCharity.setBounds(30, 52, 138, 22);
		frame.getContentPane().add(cmbCharity);
		
		JLabel lblCharityName = new JLabel("Charity Name:");
		lblCharityName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCharityName.setBounds(30, 13, 116, 26);
		frame.getContentPane().add(lblCharityName);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fName = txtFirstName.getText();
				String lName = txtLastName.getText();
				String email = txtEmailAddress.getText();
				String amount = textDonationAmount.getText();
				Charity charity = (Charity) cmbCharity.getSelectedItem();
				
				String message = "";
				boolean isValid = true;
				if(fName.isEmpty())
				{
					message+="- First Name cannot be blank\n";
					isValid = false;
				}
				if(lName.isEmpty())
				{
					message += "- Last Name cannot be blank\n";
					isValid = false;
				}
				if(email.isEmpty())
				{
					message += "- Email cannot be blank\n";
					isValid = false;
				}
				else if(Util.isValidEmail(email) == false)
				{
					message += "- Email Address is invalid\n";
					isValid = false;
				}
				
				if(amount.isEmpty())
				{
					message += "- Amount cannot be blank\n";
					isValid = false;
				}
				else if(Util.isDecimal(amount)==false)
				{
					message += "- Ammount must be numeric\n";
					isValid = false;
				}
				
				if(isValid == false)
				{
					JOptionPane.showMessageDialog(frame, message, "Validation Errors", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				donorRepository.AddDonor(DonorFactory.CreateDonor(fName, lName, email, charity.getCharityId(), amount));
				
				updateModel();
			}
		});
		btnSubmit.setBounds(49, 288, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		textDonationAmount = new JTextField();
		textDonationAmount.setBounds(30, 253, 138, 22);
		frame.getContentPane().add(textDonationAmount);
		textDonationAmount.setColumns(10);
		
		JLabel lblDonationAmount = new JLabel("Donation Amount");
		lblDonationAmount.setBounds(49, 235, 116, 16);
		frame.getContentPane().add(lblDonationAmount);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 13, 506, 325);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(Util.CreateHeader(new String[]{"First Name","Last Name","Email","Charity","Amount"}));
		scrollPane.setViewportView(table);
		
		JMenuBar menuBar_2 = new JMenuBar();
		frame.setJMenuBar(menuBar_2);
		
		JMenu mnFile = new JMenu("File ");
		menuBar_2.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DonorRepository dr = new DonorRepository();
				
				if(dr != null)
				{
					donorRepository = dr;
					updateModel();
				}
			}
		});
		mnFile.add(mntmOpen);
		mnFile.add(mntmExit);
	}
	
	private void updateModel()
	{
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		for(Donor d : donorRepository.getAll() )
		{
			model.addRow(new Object[]{
				d.getFname(),
				d.getLname(),
				d.getEmail(),
				d.getCharity(),
				formatter.format(d.getAmtDonated())
			});
		}
	}
	
	private void populateCharities()
	{
		for(Charity c : this.donorRepository.getAllCharities())
		{
			this.cmbCharity.addItem(c);
		}
	}
	
	
}

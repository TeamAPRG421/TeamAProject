package Logic;

public class DonorFactory {

	public static Donor CreateDonor(String Fname, String Lname, String email, Charity charity, String amount)
	{
		Donor donor = new Donor();
		float amt = Float.parseFloat(amount);
		
		donor.setFname(Fname);
		donor.setLname(Lname);
		donor.setEmail(email);
		donor.setCharity(charity);
		donor.setAmtDonated(amt);
		
		return donor;
		
		
		
	}
}

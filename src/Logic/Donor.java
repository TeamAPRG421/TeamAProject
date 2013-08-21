package Logic;

public class Donor{
	private String fname;
	private String lname;
	private String email;
	private String charity;
	private int charityId;
	private float amtDonated;
	
	
	public void setCharityId(int id)
	{
		this.charityId = id;
	}
	
	public int getCharityId()
	{
		return this.charityId;
	}
	public String getCharity() {
		return charity;
	}
	public void setCharity(String charity) {
		this.charity = charity;
	}
	public float getAmtDonated() {
		return amtDonated;
	}
	public void setAmtDonated(float amtDonated) {
		this.amtDonated = amtDonated;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

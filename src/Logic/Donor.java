package Logic;

import java.io.Serializable;

public class Donor implements Serializable {
	private String fname;
	private String lname;
	private String email;
	private Charity charity;
	private float amtDonated;
	
	
	
	public Charity getCharity() {
		return charity;
	}
	public void setCharity(Charity charity) {
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

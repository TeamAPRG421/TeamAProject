package Logic;

public class Charity {
	
	private int CharityId;
	private String CharityName;
	public int getCharityId() {
		return CharityId;
	}
	public void setCharityId(int charityId) {
		CharityId = charityId;
	}
	public String getCharityName() {
		return CharityName;
	}
	public void setCharityName(String charityName) {
		CharityName = charityName;
	}
	
	
	public String toString()
	{
		return this.CharityName;
	}

}

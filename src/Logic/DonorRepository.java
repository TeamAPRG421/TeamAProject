package Logic;

import java.io.Serializable;
import java.util.ArrayList;

public class DonorRepository  implements Serializable {
	private ArrayList<Donor> donors;
	
	public DonorRepository()
	{
		donors = new ArrayList<>();
	}
	
	public ArrayList<Donor> getAll()
	{
		return donors;
	}
	
	public Donor getByCharity(Charity charity)
	{
		for(Donor donor:donors)
		{
			if(donor.getCharity() == charity)
				return donor;
		}
		
		return null;
	}
	
	public void AddDonor(Donor donor)
	{
		donors.add(donor);
	}
	
	public void DeleteDonor(int donorId)
	{
		
	}
	
}

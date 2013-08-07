package Logic;

import java.util.ArrayList;

public class DonorRepository {
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
			//if(donor.)
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

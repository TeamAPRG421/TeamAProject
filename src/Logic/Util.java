package Logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;

public class Util {
	
	private static String _fileName = "data.txt";
	public static DefaultTableModel CreateHeader(String[] columnNames)
	{
		DefaultTableModel model = new DefaultTableModel();
		
		for(String str: columnNames)
		{
			model.addColumn((Object)str);
		}
		
		return model;
	}
	
	
	public static  boolean isNumber(String str)
	{
		String exp = "\\d*";		
		return str.matches(exp);
	}
	
	public static boolean isDecimal(String str)
	{
		String exp = "[0-9.]+";
		return str.matches(exp);
	}
	
	public static boolean isValidEmail(String str)
	{
		String exp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		return str.matches(exp);
	}
	
	public static void saveRepository(DonorRepository repo)
	{
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			 
			File file = new File(_fileName);
 
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			
			for(Donor person : repo.getAll())
			{
				bw.write(person.getFname() + ",");
				bw.write(person.getLname() + ",");
				bw.write(person.getEmail() + ",");
				bw.write(person.getCharity().name() + ",");
				bw.write(person.getAmtDonated() + "\n");
				
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try{
				if(fw != null)
					fw.close();
				
				if(bw != null)
					bw.close();
			}
			catch(Exception e)
			{
				
			}
		}
		
	}
	
	
	public static DonorRepository OpenRepository()
	{
		DonorRepository repo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try
		{
			fr = new FileReader(_fileName);
			br = new BufferedReader(fr);
			repo = new DonorRepository();
			String sCurrentLine;
			
			while ((sCurrentLine = br.readLine()) != null) {
				String[] items = sCurrentLine.split(",");
				
				repo.AddDonor(DonorFactory.CreateDonor(items[0], items[1], items[2], items[3], items[4]));
				
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			try{
				if(fr != null)
					fr.close();
				if(br != null)
					br.close();
			}catch(Exception e){}
		}
		
		
		
		return repo;
	}
	
	public static Charity CharityFromString(String charityName)
	{
		if(charityName !=null)
		{
			for(Charity c : Charity.values())
			{
				if(charityName.equalsIgnoreCase(c.name()));
					return c;
			}
		}
		
		return null;
	}
	
}

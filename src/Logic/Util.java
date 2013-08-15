package Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.table.DefaultTableModel;

public class Util {
	
	private static String _fileName = ".\\DonorInformation.dat";
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
	
	public static void SaveRepository(DonorRepository repo) 
	{
		
		File file = new File(_fileName);
		try {
			String tmpFileName = file.getName();
			
			
						
			//Serialize the Repository object and save it to a file
			serialize(file, repo);
			
		} catch (IOException e) {
			//Do nothing for now if there is an error
		}
	}
	
	public static DonorRepository OpenRepository()
	{
		File file = new File(_fileName);
		try{
			return (DonorRepository) deserialize(file);
		}
		catch(Exception e)
		{
			return null;
			
		}
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
	
	
	private static void serialize(File file, Object obj) throws FileNotFoundException, IOException
	{
		FileOutputStream fos;
		ObjectOutputStream oos;
		
		fos = new FileOutputStream(file);
		oos = new ObjectOutputStream(fos);
			
		oos.writeObject(obj);
		fos.close();
		oos.close();		
	}
	
	private static Object deserialize(File file) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		Object obj;
		FileInputStream fis;
		ObjectInputStream ois;

		fis = new FileInputStream(file);
		ois = new ObjectInputStream(fis);
			
		obj =(ois.readObject());
			
		ois.close();
		fis.close();
		
		return obj;
			
	}
	
}

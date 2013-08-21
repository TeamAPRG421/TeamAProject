package Logic;


import javax.swing.table.DefaultTableModel;

public class Util {
	

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
	
	
	
}

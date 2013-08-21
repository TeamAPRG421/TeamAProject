package Logic;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DonorRepository{
	private static java.sql.Connection connection = null;
	private static ResultSet resultSet = null;
	private static Statement statement = null;
	private String _connectionString;
	
	public DonorRepository()
	{
		this._connectionString = "jdbc:sqlite:Charity.sqlite";
	}
	
	public ArrayList<Donor> getAll()
	{
		ArrayList<Donor> donors = new ArrayList<>();
		
		String sql = "";
		sql += "SELECT FirstName, LastName,DonorAmount, Email, CharityName ";
		sql += "FROM Donor INNER JOIN Charity ON Donor.CharityId = Charity.CharityId";
		
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(this._connectionString);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				Donor d = new Donor();
				
				d.setFname(resultSet.getString("FirstName"));
				d.setLname(resultSet.getString("LastName"));
				d.setEmail(resultSet.getString("Email"));
				d.setAmtDonated(resultSet.getFloat("DonorAmount"));
				
				d.setCharity(resultSet.getString("CharityName"));
				
				donors.add(d);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return donors;
	}
	
	public boolean AddDonor(Donor donor)
	{
		
		//donors.add(donor);
		String sql = "";
		sql += "INSERT INTO Donor(FirstName, LastName, Email, DonorAmount, CharityId) VALUES(";
		sql += "'" + donor.getFname() + "',";
		sql += "'" + donor.getLname() + "',";
		sql += "'" + donor.getEmail() + "',";
		sql += donor.getAmtDonated() + ",";
		sql += donor.getCharityId() + ")";
		
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(this._connectionString);
			statement = connection.createStatement();
			int result = statement.executeUpdate(sql);
			
			return result == 1;
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public ArrayList<Charity> getAllCharities()
	{
		ArrayList<Charity> charities = new ArrayList<>();
		String sql = "";
		sql += "SELECT CharityName, CharityId FROM Charity ORDER BY CharityName";
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(this._connectionString);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				Charity c = new Charity();
				c.setCharityId(resultSet.getInt("CharityId"));
				c.setCharityName(resultSet.getString("CharityName"));
				
				charities.add(c);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return charities;
	}
	public void DeleteDonor(int donorId)
	{
		
	}
	
}

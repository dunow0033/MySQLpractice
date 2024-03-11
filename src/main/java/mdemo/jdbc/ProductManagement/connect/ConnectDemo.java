package mdemo.jdbc.ProductManagement.connect;
import java.sql.*;
public class ConnectDemo {
	private static Connection con;
	//it can be used to specify all connection information
	/*
	 * Load the driver in the project
	 */
	private ConnectDemo()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demodatabase","root","bdiver1");
			System.out.println("Data connected");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
	public static Connection getConnect()
	{
		ConnectDemo cdemo=new ConnectDemo();
		return con;
		
	}
	public static void main(String[] args) {
		getConnect();
		
	}

}

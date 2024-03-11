package mdemo.jdbc.ProductManagement.dao;
import java.sql.*;

import mdemo.jdbc.ProductManagement.connect.ConnectDemo;
import mdemo.jdbc.ProductManagement.dto.Product;

public class ProductDAO {
	private Connection con;
	private PreparedStatement stat;
	public ProductDAO()
	{
		con = ConnectDemo.getConnect();
	}
	
	public void insert(Product p) throws SQLException {
		stat = con.prepareStatement("insert into product values(?,?,?,?)");
		stat.setInt(1, p.getProductid());
		stat.setString(2, p.getProductname());
		stat.setInt(3, p.getQuantity());
		stat.setDouble(4, p.getPrice());
		int result=stat.executeUpdate();
		if(result>0)
		{
			System.out.println("Data inserted successfully");
		}
	}

	public void delete(int pid) throws SQLException {
		stat = con.prepareStatement("delete from product where productid = ?");
		stat.setInt(1, pid);
		
		int result = stat.executeUpdate();
		if(result > 0)
		{
			System.out.println("Data deleted successfully");
		}
	}

	public void update(int productid, Product p) throws SQLException {
		stat = con.prepareStatement("update product set productname = ?, quantity = ?, price = ? "
				+ "where productid = ?");
		stat.setString(1, p.getProductname());
		stat.setInt(2, p.getQuantity());
		stat.setDouble(3, p.getPrice());
		stat.setInt(4, productid);
		int result=stat.executeUpdate();
		if(result>0)
		{
			System.out.println("Data updated successfully");
		}
	}
	
	public void view(int pid) throws SQLException
	{
		stat = con.prepareStatement("select * from product where productid = ?");
		stat.setInt(1, pid);
		
		ResultSet result = stat.executeQuery();
		
		if(result.next()) {
			System.out.println("Here is the product: ");
			System.out.println();
			System.out.println("Product id: " + result.getInt("productid"));
			System.out.println("Product name: " + result.getString("productname"));
			System.out.println("Quantity: " + result.getInt("quantity"));
			System.out.println("Price: " + result.getDouble("price"));
		} else {
			System.out.println("No product found with id: " + pid);
		}
	}
}

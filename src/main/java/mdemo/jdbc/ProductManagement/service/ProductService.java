package mdemo.jdbc.ProductManagement.service;
import java.sql.SQLException;
import java.util.*;

import mdemo.jdbc.ProductManagement.dao.ProductDAO;
import mdemo.jdbc.ProductManagement.dto.Product;
public class ProductService {
	private Scanner sc;
	private ProductDAO pdao;
	public ProductService()
	{
		sc=new Scanner(System.in);
		pdao=new ProductDAO();
	}
	public void insertData()throws SQLException
	{
		System.out.println("Enter how many products u want to have");
		int noofproduct=sc.nextInt();
		for(int x=1;x<=noofproduct;x++)
		{
			Product p = new Product();
			System.out.println("Enter Product id");
			p.setProductid(sc.nextInt());
			System.out.println("Enter Product name ");
			p.setProductname(sc.next());
			System.out.println("Enter Price ");
			p.setPrice(sc.nextDouble());
			System.out.println("Enter Quantity ");
			p.setQuantity(sc.nextInt());
			pdao.insert(p);
			
		}
	}
	
	public void deleteData() throws SQLException
	{
		System.out.println("Enter product id which u want to delete");
		int pid=sc.nextInt();
		pdao.delete(pid);
	}
	
	public void updateData() throws SQLException
	{
		System.out.println("Please enter the id of the product you want to update:  ");
		int productid = sc.nextInt();
		
		Product p = new Product();
		System.out.println("Enter Product name ");
		p.setProductname(sc.next());
		System.out.println("Enter Price ");
		p.setPrice(sc.nextDouble());
		System.out.println("Enter Quantity ");
		p.setQuantity(sc.nextInt());
		pdao.update(productid, p);	
	}
	
	public void viewData() throws SQLException
	{
		System.out.println("Ok, great, please enter the id of the product you want to view: ");
		int productid = sc.nextInt();
		System.out.println();
		pdao.view(productid);
	}
}

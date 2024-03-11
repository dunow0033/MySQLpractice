package mdemo.jdbc.ProductManagement;

import mdemo.jdbc.ProductManagement.service.ProductService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try
    	{
    		ProductService pservice = new ProductService();
    		//pservice.deleteData();
    		//pservice.insertData();
    		//pservice.updateData();
    		pservice.viewData();
    	}
    	catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    }
}

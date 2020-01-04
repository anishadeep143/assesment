package product;

import java.sql.*;



public class ProductDao {
	
	Connection con;
	ResultSet rs;
	PreparedStatement pstmt;
	CallableStatement cstmt;
	
	
	public ProductDao()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","seed1234");
			System.out.println("connection successful");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public int insertProduct(Products p)// to insert a product into the database
	{
		int ra=0;
		try{
			pstmt=con.prepareStatement("insert into products values(?,?,?,?)");
			pstmt.setInt(1, p.getId());
			pstmt.setString(2, p.getName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getCategory());
			ra=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ra;
	}
	
	public int updateProduct(Products p){  // to update a product
		int ra=0;
		try{
			pstmt=con.prepareStatement("update products set name=?,price=?,category=? where id=?");
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getPrice());
			pstmt.setString(3, p.getCategory());
			pstmt.setInt(4, p.getId());
			ra=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ra;
	}
	
	public int deleteProduct(String id)	//delete a product
	{
		int ra=0;
		try{
			pstmt=con.prepareStatement("delete from  products  where id=?");
			pstmt.setString(1, id);
			ra=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ra;
	}
	
	public ResultSet retriveProducts()// to retrieve products 
	{
		try
		{
			
			pstmt=con.prepareStatement("select * from products");
			rs=pstmt.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getProduct(String id)
	{
		try
		{
				pstmt=con.prepareStatement("select * from products where id=?");
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
	}
}

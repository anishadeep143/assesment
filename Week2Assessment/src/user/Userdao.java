package user;

import java.sql.*;

public class Userdao {

	Connection con;
	PreparedStatement pstmt;
	CallableStatement cstmt;
	ResultSet rs;

	public Userdao()
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
	
	public int insertUser(User1 u)
	{
		int ra=0;
		try{
			pstmt=con.prepareStatement("insert into user1 values(?,?,?)");
			pstmt.setInt(1, u.getLoginid());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getEmail());
			ra=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ra;
	}
	
	public int updateUser(User1 u){
		int ra=0;
		try{
			pstmt=con.prepareStatement("update user1 set password=?,email=? where loginid=?");
			pstmt.setInt(3, u.getLoginid());
			pstmt.setString(1, u.getPassword());
			pstmt.setString(2, u.getEmail());
			ra=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ra;
	}
	
	public int deleteUser(int loginid)
	{
		int ra=0;
		try{
			pstmt=con.prepareStatement("delete from  user1  where loginid=?");
			pstmt.setInt(1,loginid);
			ra=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ra;
	}
	
	public ResultSet retriveUsers(int loginid)
	{
		try
		{
			
			pstmt=con.prepareStatement("select * from user1 where loginid=?");
			pstmt.setInt(1,loginid);
			rs=pstmt.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean validateUser(User1 u)
	{
		boolean flag=false;
		try
		{
			
			pstmt=con.prepareStatement("select * from user1");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				if(rs.getInt("loginid")==u.getLoginid() && rs.getString("password")==u.getPassword())
					flag=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
}

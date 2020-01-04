package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User1;
import user.Userdao;

@WebServlet("/user")
public class modifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	User1 u;
	Userdao udao;
	
    public modifyUser() {
       udao=new Userdao();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		int uid=Integer.parseInt(request.getParameter("uid"));
		String password=request.getParameter("pass");
		String email="";
		
		u=new User1(uid, password, email);
		boolean ra=udao.validateUser(u);
		if(ra==false)
			out.println("<font color=greenlogin Unsucccessfully.</font>");
		else{
			out.println("<font color=red>login successful</font>");
			out.println("search a product <a href='http://localhost:9080/Week2Assessment/search.html'>Click Here</a>");
			out.println("list all products<a href='http://localhost:9080/Week2Assessment/getproducts.html'>Click Here</a>");
			out.println("add product <a href='http://localhost:9080/Week2Assessment/insert.html'>Click Here</a>");
			out.println("delete a product <a href='http://localhost:9080/Week2Assessment/delete.html'>Click Here</a>");
		}
		out.println("To Go Back To The Form <a href='http://localhost:9080/Week2Assessment/home.html'>Click Here</a>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		int uid=Integer.parseInt(request.getParameter("uid"));
		String password=request.getParameter("pass");
		String email=request.getParameter("email");
		
		u=new User1(uid, password, email);
		
		int ra=udao.insertUser(u);
		if(ra>0)
			out.println("<font color=green>user Details register Succcessfully.</font>");
		else
			out.println("<font color=red>user Details are not inserted.</font>");
		out.println("To Go Back To The Form <a href='http://localhost:9080/Examples/home.html'>Click Here</a>");
		
	}

}

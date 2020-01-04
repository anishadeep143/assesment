package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.ProductDao;
import product.Products;

@WebServlet("/product")
public class ModifyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Products p;
	ProductDao pdao;
	PrintWriter out;
    public ModifyProduct() {
        pdao=new ProductDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		out=response.getWriter();
		String pid=request.getParameter("pid");
		
		ResultSet res=pdao.getProduct(pid);
		out.println("<table border=3><tr><th>product Id</th><th>product Name</th><th>price</th><th>category</th></tr>");
		while(res.next())
		{
			out.println("<tr>");
			out.println("<td>"+res.getString("id")+"</td>");
			out.println("<td>"+res.getString("name")+"</td>");
			out.println("<td>"+res.getString("price")+"</td>");
			out.println("<td>"+res.getString("category")+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("To Go Back To The Form <a href='http://localhost:9080/Week2Assessment/home.html'>Click Here</a>");
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			out=response.getWriter();
			ResultSet res=pdao.retriveProducts();
			out.println("<table border=3><tr><th>product Id</th><th>product Name</th><th>price</th><th>category</th></tr>");
			while(res.next())
			{
				out.println("<tr>");
				out.println("<td>"+res.getString("id")+"</td>");
				out.println("<td>"+res.getString("name")+"</td>");
				out.println("<td>"+res.getString("price")+"</td>");
				out.println("<td>"+res.getString("category")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("To Go Back To The Form <a href='http://localhost:9080/Week2Assessment/home.html'>Click Here</a>");
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}

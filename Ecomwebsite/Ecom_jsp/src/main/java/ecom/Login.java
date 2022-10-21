package ecom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ecom/Login")
public class Login extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter pw=res.getWriter();
		pw.println("<html><body>");
		String mailId=req.getParameter("mailId");
		String password=req.getParameter("password");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
			PreparedStatement ps=con.prepareStatement("select * from registration where mailId=? and password=?");
			ps.setString(1,mailId);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				HttpSession s=req.getSession();
				s.setAttribute("username", mailId);
				pw.println("<script>alert('login successfull')</script>");
				RequestDispatcher rd=req.getRequestDispatcher("HomePage.jsp");  
	               rd.include(req,res); 
				}
				else{
					//response.sendRedirect("Login.html");
					pw.println("<script>alert('Invalid credentials')</script>");
					RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");  
		               rd.include(req,res); 
				}
				
			}catch(Exception e){
				pw.println("exception occured");
			
		}
		pw.println("</body></html>");

	}

}

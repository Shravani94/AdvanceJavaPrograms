package ecom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Registration.java")
public class Registration extends HttpServlet{
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String mailId =req.getParameter("mailId");
		String mobile=req.getParameter("number");
		long mobilenumber=Long.parseLong(mobile);
		String password=req.getParameter("password");
		String confirm=req.getParameter("confirm");
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
		
		String query="insert into registration(firstName,lastName,mailId,mobile,password,confirm)values(?,?,?,?,?,?)";
		if(password.equals(confirm)){
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,firstName);
		st.setString(2,lastName);
		st.setString(3,mailId);
		st.setLong(4,mobilenumber);
		st.setString(5,password);
		st.setString(6,confirm);
		int i= st.executeUpdate();
		if(i>0){
		pw.println("<script>window.alert('regiserd successfully')</script>");
		RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");  
        rd.include(req,res); 
;
		}
		}
		else {
		pw.println("<script>window.alert('password and confirm password musy be same')</script>");
		RequestDispatcher rd=req.getRequestDispatcher("Registration.jsp");  
        rd.include(req,res); 

		}
		}catch(Exception e)
		{
			pw.println("<script>window.alert('this mailId/mobilenumber already register continue with login')</script>");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");  
            rd.include(req,res); 



	}

}
}

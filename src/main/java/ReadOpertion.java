import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ReadOperation")
public class ReadOpertion extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String str=req.getParameter("id");
		System.out.println(str);
		pw.print("<html><body>");
		pw.print("<table>");
		pw.print("<tr><th>Id</th><th>name</th><th>mailId</th><th>Mobile</th></tr>");
		//String str=req.getParameter("id");
		//int id=Integer.parseInt(str);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement psmt=con.createStatement();
		ResultSet rs=psmt.executeQuery("Select * from employee ");
		while(rs.next()) {
		int id1=rs.getInt("id");
		String name=rs.getString("name");
		String mailId=rs.getString("mailId");
		long mobile=rs.getLong("mobile");
		pw.print("<tr><td>"+id1+"</td><td>"+name+"</td><td>"+mailId+"</td><td>"+mobile+"</td></tr>");	
		}
		con.close();
		pw.println("</table>");
		pw.println("</body></html>");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		
		
	}

}

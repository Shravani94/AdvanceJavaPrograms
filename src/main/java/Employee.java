import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Employee")
public class Employee extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException{
		try {
		res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			String str=req.getParameter("id");
			int id=Integer.parseInt(str);
			String str1=req.getParameter("name");
			String str2=req.getParameter("mail");
			String str3=req.getParameter("mobile");
			long num=Long.parseLong(str3);
			  String query
              = "insert into employee(id,name,mailId,mobile) values(?,?,?,?)";
    
          // Load driver class
          Class.forName("com.mysql.cj.jdbc.Driver");
    
          // Obtain a connection
          Connection con = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/employee", "root", "root");
    
          // Obtain a statement
          PreparedStatement st = con.prepareStatement(query);
          st.setInt(1, id);
          st.setString(2,str1) ;
          st.setString(3, str2);
          st.setLong(4, num);
          int count=st.executeUpdate();
          System.out.println(
              "number of rows affected by this query is"+count);
		}
		catch(Exception e) {
			System.out.println(e);
		}
			
			
		}
	}
		
		


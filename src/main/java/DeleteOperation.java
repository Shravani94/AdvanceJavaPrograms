import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteOperation")
public class DeleteOperation extends HttpServlet {
	static boolean sing;
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String str1=req.getParameter("id");
		int id=Integer.parseInt(str1);
		String str2=req.getParameter("name");
		String str3=req.getParameter("mailId");
		String str4=req.getParameter("mobile");
		long mobile=Long.parseLong(str4);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			Statement psmt=con.createStatement();
			psmt.executeQuery("delete * from employee");
			ResultSet rs=psmt.getResultSet();
			while(rs.next()) {
			int id1=rs.getInt("id");
			String name1=rs.getString("name");
			String mailId1=rs.getString("mailId");
			long mobile1=rs.getLong("mobile");
			if(str1.equals(name1)&&str1.equals(id1)&&str3.equals(mailId1)&&str4.equals(mobile1)) {
				this.sing=true;
				psmt.executeQuery("delete from employee where id='"+id+"'");
				break;
				
			}
			if(sing==true)
			{
				System.out.println(id+" is deleted successfully");
			}
			else {
				System .out.println("delete operation is unsuccessfull");
			}
			con.close();
				
			}
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UpdateOperation")
public class UpdateOperation extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String oldName=req.getParameter("oldname");
		String newName=req.getParameter("newname");
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			PreparedStatement psmt=con.prepareStatement("update employee set name=?, where id=?");
			psmt.setString(1, newName);
			psmt.setInt(2,id1);
			psmt.executeUpdate();
			if(true)
			{
				System.out.println("updated successfully");
			}
			else {
				System.out.println("not updated");
				con.close();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}

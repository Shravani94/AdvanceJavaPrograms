package ecom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("addCart.java")
public class addCart extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=(String) req.getAttribute("username");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
			PreparedStatement ps=con.prepareStatement("select * from fashion productId=?");
			ps.setInt(1, id1);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			int productId= rs.getInt("productId");
			String image=rs.getString("productImage" );
			double cost= rs.getDouble("cost");
			String color=rs.getString("color");
			String size=rs.getString("size");

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
		if(name!=null) {
		String query="insert into cart(username,productId,cost)values(?,?,?)";
		PreparedStatement st = con1.prepareStatement(query);
		st.setString(1,name );
		st.setString(2, image);
		st.setDouble(3, cost);
		int i=st.executeUpdate();
		if(i>0) {
			pw.println("<h1>inserted</h1>");
		}
		else {
			pw.println("<h1>not inserted</h1>");
		}

		
		
	}else {
		pw.println("<h1>Please login</h1>");
		RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");  
        rd.include(req,res); 
        }
			}

}catch(Exception e) {
	pw.println("<h1>"+e+"</h1>");
}
	}
}

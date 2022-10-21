package ecom;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fashionplp")
public class fashionplp extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
		PreparedStatement ps=con.prepareStatement("select * from fashion");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
		int productId= rs.getInt("productId");
		String image=rs.getString("productImage" );
		double cost= rs.getDouble("cost");
		String color=rs.getString("color");
		String size=rs.getString("size");
		pw.println("<div style='float:left'>");
		pw.println("<a href='fashoinpdp.java?id='"+productId+"'<p>"+productId+"</p></p><img src='"+image+"'</p><p>"+cost+"</p><p>"+color+"</p></a></div>");
		}
}catch(Exception e) {
	pw.println("<h1>"+e+"</h1>");
;}

}
}


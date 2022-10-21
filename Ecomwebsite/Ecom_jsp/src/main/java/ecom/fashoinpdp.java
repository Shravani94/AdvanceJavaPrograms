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
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
@WebServlet("/fashoinpdp")
public class fashoinpdp extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter pw=res.getWriter();		
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
		PreparedStatement ps=con.prepareStatement("select * from fashion productId=?");
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		ps.setInt(1, id1);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
		int productId= rs.getInt("productId");
		String image=rs.getString("productImage" );
		double cost= rs.getDouble("cost");
		String color=rs.getString("color");
		String size=rs.getString("size");
		pw.println("<div style='background-color:black;color:white'><header><h1>product details</h1></header></div>");
		pw.println("<div style='float:left;padding-right:100px';>");
		pw.println("<div></p><img src='"+image+"'</p></div><div><p>"+cost+"</p><p>"+color+"</p><p>"+size+"</p></div></div>");
		pw.println("<div style='float:left;padding-right:100px';>");
		pw.println("<a href='addCart.java?id="+productId+"'><button>addCart</button></a>");
		pw.println("<a href='#?id="+productId+"'><button>BuyNow</button></a></div>");
		pw.println("<div style='float:left;padding-right:100px';>");
		pw.println("<footer><a href='beautyplp.java'>beautyProducts</a>");
		pw.println("<a href='mobiles.java'>mobiles</a>");
		pw.println("<a href='HomePage.jsp'>homePage</a>");

		pw.println("<a href='homeFurnitureplp.java'>homefurnitures</a></footer></div>");

		}
}catch(Exception e) {
	pw.println(e)
;}

}
}

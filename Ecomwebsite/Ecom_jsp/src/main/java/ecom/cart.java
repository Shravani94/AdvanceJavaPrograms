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
@WebServlet("/cart")
public class cart extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		String name=(String) req.getAttribute("username");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
			PreparedStatement ps=con.prepareStatement("select * from addCart where username=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			while(rs.next()) {
			int productId= rs.getInt("productId");
			String image=rs.getString("productImage" );
			double cost= rs.getDouble("cost");
			String color=rs.getString("color");
			String size=rs.getString("size");
			pw.println("<div><header><h1>cartProduct</h1></header></div>");
			pw.println("<div style='float:left'>");
			pw.println("<a href='fashoinpdp.java?id='"+productId+"'<p>"+productId+"</p></p><img src='"+image+"'</p><p>"+cost+"</p><p>"+color+"</p></a></div>");
			pw.println("<div style='float:left'><a href='#'><button>BuyNow</button></a>");
			pw.println("<a href='#'><button>remove</button></a></div>");
			pw.println("<div><footer><a href='HomePage.jsp'>click here to move homePage</a></footer></div>");
			}
			}else {
				pw.println("<div style='height:80px;width:200px'><header><h1>cartList</h1></header></div>");
				pw.println("<div><h1>cart is empty</h1>");
				pw.println("<p><a href='HomePge.jsp'><button>Click to go homePage</button></a></p></div>");
				pw.println("<div><footer><a href='Login.jsp'>click to move login</a></div></footer>");
			}
		
	}catch (Exception e) {
		// TODO: handle exception
	}

}
}

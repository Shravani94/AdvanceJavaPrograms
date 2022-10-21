package ecom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderPlaced extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		String name=(String)req.getAttribute("username");
		String id1=req.getParameter("id");
		int id=Integer.parseInt(id1);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
			PreparedStatement ps=con.prepareStatement("select * from fashion where username=?,prouctId=? ");
			ResultSet rs=ps.executeQuery();
			ps.setString(1,name);
			ps.setInt(2,id);
			while(rs.next()) {
			int productId= rs.getInt("productId");
			String image=rs.getString("productImage" );
			pw.println("<div><header><h1>Order confirmation page</h1></header></div>");
			pw.println("<div><div style='float:left'><div><image src='image'></div>");
			pw.println("<div><p>color:<select name='color' id='cars'>");
		  pw.println("<option value='red'>red</option> <option value='white'>white</option><option value='black'>black</option> <option value='green'>green</option>");
		pw.println("</select></p><p>Quantity:<input type='range' id='points' name='points' min='1' max='10'>");
		pw.println("<p><a href='order?id="+id+"'><button>proceed</button></a></p></div></div></div>");
			pw.println("<div><footer><a href='HomePage.jsp'>click here to move home page</a><a href='Login.jsp'></a></footer></div>");

	}

}catch(Exception e) {
	pw.println("<h1>"+e+"</h1>");
}
	}
}

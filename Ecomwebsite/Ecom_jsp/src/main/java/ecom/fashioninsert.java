package ecom;

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
@WebServlet("/fashioninsert.java")
public class fashioninsert extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
		String query="insert into homefurniture(productId,productImage,cost,color,name)values(?,?,?,?,?)";
		String productId1 =req.getParameter("productId");
		int productId=Integer.parseInt(productId1);
		String productImage=req.getParameter("productImage");
		String cost =req.getParameter("cost");
		String color=req.getParameter("color");
		double price=Double.parseDouble(cost);
		String size=req.getParameter("size");
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, productId);
		st.setString(2, productImage);
		st.setDouble(3, price);
		st.setString(4, color);
		st.setString(5, size);
		int i=st.executeUpdate();
		if(i>0) {
			pw.println("<h1>inserted</h1>");
		}
}catch(Exception e) {
	pw.println(e)
;}

}
}

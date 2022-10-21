package Cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Cookies1")
public class Cookies1 extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		try {
		res.setContentType("http/text");
		PrintWriter pw=res.getWriter();
		String name=req.getParameter("name");
		pw.print("welcome "+name);
		Cookie ck=new Cookie("uname",name);
		ck.setComment("cookies added to your browser");
		res.addCookie(ck);
		pw.println("<form action='Cookies2' method='post'>");
		pw.print("<input type='submit' name='go'/>");
		pw.print("</form>");
		pw.close();
		
		
	
}catch(Exception e) {
	System.out.println(e);
}
	}

}
 
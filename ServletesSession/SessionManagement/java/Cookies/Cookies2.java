package Cookies;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
@WebServlet("/Cookies2")
public class Cookies2 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response){  
	    try{  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	      
	    Cookie[] ck=request.getCookies();  
	    out.print("Hello "+ck[0].getValue());  
	  
	    out.close();  
	  
	         }catch(Exception e){System.out.println(e);}  
	    }  

}

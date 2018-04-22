

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Songs")
public class Songs extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String str1="";
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String str="Music/";
	str=str+request.getParameter("mname");
	str=str+"/";
	str=str+request.getParameter("fname");
                str=str+"/";
                str+=request.getParameter("sname");

                str1=str1+"<audio controls autoplay='autoplay'";
                str1= str1+ "<source src='"+str+"' type='audio/mpeg' />";
                str1= str1+ "</audio>"  ;
	
	request.setAttribute("result",str1);
	
	
	RequestDispatcher rd = request.getRequestDispatcher("play.jsp");
	rd.forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Movies")
public class Movies extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String str="";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		File ff=new  File("D:\\AdvJava\\Online Music Store\\WebContent\\Music\\"+request.getParameter("mname"));
		File []list=ff.listFiles();
		
		for(File f:list)
		{
			
			   str=str+"<li><a href='Media?mname="+request.getParameter("mname").toString()+"&fname="+f.getName()+"'>"+f.getName()+"</a></li><br> ";
			
		}
		request.setAttribute("result",str);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
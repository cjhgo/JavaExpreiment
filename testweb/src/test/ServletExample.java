package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ServletExample extends HttpServlet
{
	public  void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>A Servlet Example<title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>this is  a servlet example!</h1>");
				out.println("<h2>docGet method is invoked!<h2>");
				out.println("<boyd>");
				out.println("</html>");
				out.flush();
				out.close();
			}
}
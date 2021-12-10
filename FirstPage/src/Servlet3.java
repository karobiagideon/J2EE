

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Calendar calendar=new GregorianCalendar();
		
		int hour=calendar.get(Calendar.HOUR);
		int min=calendar.get(Calendar.MINUTE);
		int sec=calendar.get(Calendar.SECOND);
		
		String am_pm;
		response.setContentType("text/html");
		response.setIntHeader("refresh", 5	);
		
		
		PrintWriter out=response.getWriter();
		
		if(calendar.get(Calendar.AM_PM)==0)
			am_pm="PM";
		else
			am_pm="AM";
		
		String time=hour+":"+min+":"+sec+" "+am_pm;
		
		String html="<html>"
				+ " <head></head>"
				+ "<body>"
				    +"<p>Time is : "+time+"</p>"
				+ "</body>"
				+ "</html>";
		
		out.println(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

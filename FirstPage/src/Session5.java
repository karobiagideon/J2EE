

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session5
 */
@WebServlet("/Session5")
public class Session5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		Date createdTime=new Date(session.getCreationTime());
		Date lastTime=new Date(session.getLastAccessedTime());
		
		String title="Welcome back to my website";
		String Id=new String("id1");
		String IdKey=new String("idKey");
		Integer visitCount=new Integer(0);
		String visitKey=new String("visitKey");
		
		if(session.isNew()) {
			title="Welcome to my website";
			session.setAttribute(IdKey, Id);
		}else {
		 visitCount=(Integer) session.getAttribute("visitKey");
		 visitCount=visitCount+1;
		 Id=(String) session.getAttribute("id1");
		}
		session.setAttribute(visitKey, visitCount);
		
		PrintWriter out = response.getWriter();
		out.println("IDS="+Id+"Counts="+visitCount);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

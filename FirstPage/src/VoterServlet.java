

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VoterServlet")
public class VoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// declare variables
	       PrintWriter pw = null;
	       String name = null;
	       String tage = null;
	       int age = 0;

	       // set content type
	       res.setContentType("text/html");

	       // get PrintWriter object
	       pw = res.getWriter();

	       // get form data (from req parameter)
	       name = req.getParameter("pname");
	       tage = req.getParameter("page");

	       // convert String value to int
	       age = Integer.parseInt(tage);

	       // check age
	       pw.println("<h1 style='text-align: center; color:blue'>"
	                 + "Hello "+ name + "</h1>");
	       if(age < 18) {
	          pw.println("<h2 style='text-align: center; color:red'>"
	                    +"You are not eligible for voting.</h2>"
	                    +"<h3 style='text-align: center; color:green'>"
	                    +"Please wait for more " + (18-age) + " years.<br>"
	                    +" Thank You.<h3>"
	          );
	       } else  {
	          pw.println("<h2 style='text-align: center; color:green'>"
	                    +"You are eligible for voting.</h2>"
	                    +"<h3 style='text-align: center'>"
	                    +"Thank You.<h3>"
	          );
	       }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

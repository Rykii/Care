package chameleon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DatabaseHandler;

/**
 * Servlet implementation class ChameleonManager
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseHandler handler = new DatabaseHandler();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		if ((request.getParameter("mac") != null) && (request.getParameter("psk") != null)) {
			result = handler.insert(request.getParameter("mac").toLowerCase(), request.getParameter("psk").toLowerCase());
			response.setContentType("text/html;charset=UTF-8");
			if (result > 0)
				response.getWriter().write("Registration successful!");
			else
				response.getWriter().write("Your MAC address has been registered!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
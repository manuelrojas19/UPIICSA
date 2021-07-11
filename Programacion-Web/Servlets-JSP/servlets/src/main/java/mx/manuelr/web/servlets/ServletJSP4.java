package mx.manuelr.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.manuelr.web.pr.PersonaPr;

/**
 * Servlet implementation class ServletJSP4
 */
public class ServletJSP4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJSP4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idPersona = Integer.parseInt(request.getParameter("idPersona"));
		PersonaPr.eliminarPersona(idPersona);
		response.sendRedirect("ServletJSP1");
	}

}

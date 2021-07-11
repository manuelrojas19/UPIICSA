package mx.manuelr.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.manuelr.web.entity.Persona;
import mx.manuelr.web.pr.PersonaPr;

/**
 * Servlet implementation class ServletJSP1
 */
public class ServletJSP1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJSP1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Persona> personas = PersonaPr.obtenerPersonas();
		RequestDispatcher rd = request.getRequestDispatcher("jsp/jsp1.jsp");
		request.setAttribute("personas", personas);
		rd.forward(request, response);
	}

}

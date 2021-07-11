package mx.manuelr.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.manuelr.web.entity.Persona;
import mx.manuelr.web.pr.PersonaPr;

/**
 * Servlet implementation class ServletJSP2
 */
public class ServletJSP2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJSP2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("jsp/jsp2.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String primerApellido = request.getParameter("primerApellido");
		String segundoApellido = request.getParameter("segundoApellido");
		String curp = request.getParameter("curp");
		Persona personaGuardada = null;
		Persona p = new Persona(nombre, primerApellido, segundoApellido, curp);
		personaGuardada = PersonaPr.registrarPersona(p);
		if (personaGuardada != null) {
			response.sendRedirect("ServletJSP1");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/jsp2.jsp");
			request.setAttribute("persona", p);
			rd.forward(request, response);
		}
	}

}

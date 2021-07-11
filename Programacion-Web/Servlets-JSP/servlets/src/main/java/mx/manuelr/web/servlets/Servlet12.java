package mx.manuelr.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.manuelr.web.entity.Persona;
import mx.manuelr.web.pr.PersonaPr;

/**
 * Servlet implementation class Database1
 */
public class Servlet12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet12() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Persona> personas = PersonaPr.obtenerPersonas();

		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		out.println("<html lang=\"es-MX\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<meta name=\"content-type\" content=\"text/html;charset=UTF-8\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Ejemplo base de datos 1: Consultas </h1>");
		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th> Nombre </th>");
		out.println("<th> Primer Apellido </th>");
		out.println("<th> Segundo Apellido </th>");
		out.println("<th> CURP </th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");

		for (Persona p : personas) {
			out.println("<tr>");
			out.println("<td>" + p.getNombre() + "</td>");
			out.println("<td>" + p.getPrimerApellido() + "</td>");
			out.println("<td>" + p.getSegundoApellido() + "</td>");
			out.println("<td>" + p.getCurp() + "</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("<table>");
		out.println("</body>");
		out.println("</html>");
	}
}

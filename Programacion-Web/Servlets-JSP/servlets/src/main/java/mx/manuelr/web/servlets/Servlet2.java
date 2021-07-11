package mx.manuelr.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String primerApellido = request.getParameter("primerApellido");
		String segundoApellido = request.getParameter("segundoApellido");
		Integer edad = Integer.parseInt(request.getParameter("edad"));
		String nacimientoString = request.getParameter("nacimiento");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date nacimiento = null;
		try {
			nacimiento = format.parse(nacimientoString);
		} catch (ParseException e) {
			System.out.println("Error en la conversión de la fecha: " + nacimientoString);
		}
		generarRespuesta(response, request.getMethod(), nombre, primerApellido, segundoApellido, edad, nacimiento);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String primerApellido = request.getParameter("primerApellido");
		String segundoApellido = request.getParameter("segundoApellido");
		Integer edad = Integer.parseInt(request.getParameter("edad"));
		String nacimientoString = request.getParameter("nacimiento");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date nacimiento = null;
		try {
			nacimiento = format.parse(nacimientoString);
		} catch (ParseException e) {
			System.out.println("Error en la conversión de la fecha: " + nacimientoString);
		}
		generarRespuesta(response, request.getMethod(), nombre, primerApellido, segundoApellido, edad, nacimiento);
	}

	private void generarRespuesta(HttpServletResponse response, String method, String nombre, String primerApellido,
			String segundoApellido, Integer edad, Date nacimiento) throws ServletException, IOException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html lang=\"es-MX\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<meta name=\"content-type\" content=\"text/html;charset=UTF-8\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet 2: Recepción de parámetros por " + method + "</h1>");
		out.println("<ul>");
		out.println("<li>Nombre:" + nombre + "</li>");
		out.println("<li>Primer Apellido: " + primerApellido + "</li>");
		out.println("<li>Segundo Apellido: " + segundoApellido + "</li>");
		out.println("<li>Edad: " + edad + "</li>");
		out.println("<li>Nacimiento: " + format.format(nacimiento) + "</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

}

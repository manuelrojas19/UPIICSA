package mx.manuelr.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet4
 */
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int y = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		Integer x = (Integer) session.getAttribute("contador");
		String nombre = (String) session.getAttribute("nombre");
		Date fecha = null;
		if (x == null) {
			x = 0;
		}
		if (nombre == null) {
			nombre = "Manuel Rojas Ramos";
			fecha = new Date(12143124141412l);
		}
		PrintWriter out = response.getWriter();
		int z = 1;
		out.println("<html lang=\"es-MX\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<meta name=\"content-type\" content=\"text/html;charset=UTF-8\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet 4: Manejo de sesiones y variables de petición e instancia </h1>");
		out.println("Variable de sesión x = " + x);
		out.println("Variable de instancia y = " + y);
		out.println("Variable de petición z = " + z);
		out.println("<ul>");
		out.println("<li> ID de la sesión: " + session.getId() + "</li>");
		out.println("<li> Creación de la sesión: " + new Date(session.getCreationTime()) + "</li>");
		out.println("<li> Ultimo acceso: " + new Date(session.getLastAccessedTime()) + "</li>");
		out.println("<li> Tiempo máximo de inactividad: " + session.getMaxInactiveInterval() + "</h1>");
		out.println("<li> Objetos en la sesión: </li>");
		Enumeration<String> attributesSession = session.getAttributeNames();
		out.println("<ul>");
		while(attributesSession.hasMoreElements()) {
			String attributeName = attributesSession.nextElement();
			out.println("<li>" + attributeName +" = " + session.getAttribute(attributeName) + " </li>");
		}
		out.println("</ul>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		x++;
		y++;
		z++;
		session.setAttribute("contador", x);
		session.setAttribute("nombre", nombre);
		session.setAttribute("fecha", fecha);
		if (x == 10) {
			session.removeAttribute("nombre");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

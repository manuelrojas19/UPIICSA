package mx.manuelr.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet3
 */
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html lang=\"es-MX\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<meta name=\"content-type\" content=\"text/html;charset=UTF-8\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet 3: Recepción de parámetros dinámicos por " + request.getMethod() + "</h1>");
		Enumeration<String> names = request.getParameterNames();
		out.println("<ul>");
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String[] datos = request.getParameterValues(name);
			out.println("<li>Parametro: " + name + "</li>");
			out.println("<ul>");
			for (String dato : datos) {
				out.println("<li>Dato: " + dato + "</li>");
			}
			out.println("</ul>");
		}
		
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html lang=\"es-MX\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<meta name=\"content-type\" content=\"text/html;charset=UTF-8\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet 3: Recepción de parámetros dinámicos por " + request.getMethod() + "</h1>");
		Enumeration<String> names = request.getParameterNames();
		out.println("<ul>");
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String[] datos = request.getParameterValues(name);
			out.println("<li>Parametro: " + name + "</li>");
			out.println("<ul>");
			for (String dato : datos) {
				out.println("<li>Dato: " + dato + "</li>");
			}
			out.println("</ul>");
		}
		
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

}

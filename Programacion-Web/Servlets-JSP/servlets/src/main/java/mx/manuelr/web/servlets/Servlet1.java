package mx.manuelr.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Servlet1: instanciando");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Servlet1: inicializando");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Servlet1: destruyendo");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html lan=\"es-MX\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta name=\"content-type\" content = \"text/html;charset=UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Hola mundo de los servlets </h1>");
		out.println("<ul>");
		out.println("<li> Context Path: " + request.getContextPath() + "</li>");
		out.println("<li> IP petición: " + request.getLocalAddr() + "</li>");
		out.println("<li> Método: " + request.getMethod() + "</li>");
		out.println("<li> Protocolo del cliente: " + request.getRemoteAddr() + "</li>");
		out.println("<li> Nombre y versión del protocolo: " + request.getProtocol()+ "</li>");
		out.println("<li> Query String: " + request.getQueryString() + "</li>");
		out.println("<li> Navegador: " + request.getHeader("User-Agent") + "</li>");
		out.println("<li> Codificación de llegada: " + request.getCharacterEncoding() + "</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("Servlet1: atendiendo petición GET");
//		response.getWriter().append("Servicio ubicado en el path: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet1: atendiendo petición POST");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		out.println("<html lang=\"es-MX\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<meta name=\"content-type\" content=\"text/html;charset=UTF-8\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet1: petición POST</h1>");
		out.println("<ul>");
		out.println("<li>"+request.getContextPath()+"</li>");
		out.println("<li>"+request.getLocalAddr()+"</li>");
		out.println("<li>"+request.getMethod()+"</li>");
		out.println("<li>"+request.getRemoteAddr()+"</li>");
		out.println("<li>"+request.getProtocol()+"</li>");
		out.println("<li>"+request.getQueryString()+"</li>");
		out.println("<li>"+request.getHeader("User-Agent")+"</li>");
		out.println("<li>"+request.getCharacterEncoding()+"</li>");
		out.println("<li>X="+request.getParameter("x")+"</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

}

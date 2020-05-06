package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.chor.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.chor.dao.JefeDAOImplementation;
import es.upm.dit.isst.chor.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.chor.model.Empleado;
import es.upm.dit.isst.chor.model.Jefe;
import es.upm.dit.isst.chor.model.Proyecto;

/**
 * Servlet implementation class verUsuario
 */
@WebServlet("/verUsuario")
public class verUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
 		Empleado empleado = EmpleadoDAOImplementation.getInstance().read(email);
 		String empleadopass = empleado.getPassword();
 		Jefe jefe = JefeDAOImplementation.getInstance().read(email);
 		String jefepass = jefe.getPassword();
 		
 		if(EmpleadoDAOImplementation.getInstance().buscarEmpleado(email)) {
			EmpleadoDAOImplementation.getInstance().login(email, empleadopass);
 			req.getSession().setAttribute("empleado", empleado);
			getServletContext().getRequestDispatcher("/Empleado.jsp").forward(req,resp);
 		}else if (JefeDAOImplementation.getInstance().buscarJefe(email)) {
			JefeDAOImplementation.getInstance().login(email, jefepass);
 			req.getSession().setAttribute("jefe", jefe);
 			getServletContext().getRequestDispatcher("/jefe.jsp").forward(req,resp);
 		}else {
 			log("Fallo en el usuario");
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

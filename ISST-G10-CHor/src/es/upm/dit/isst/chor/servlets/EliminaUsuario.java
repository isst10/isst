package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.chor.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.chor.dao.JefeDAOImplementation;
import es.upm.dit.isst.chor.model.Empleado;
import es.upm.dit.isst.chor.model.Jefe;

/**
 * Servlet implementation class EliminaUsuario
 */
@WebServlet("/EliminaUsuario")
public class EliminaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
 		String email = req.getParameter("email");	
 		Empleado empleado = EmpleadoDAOImplementation.getInstance().read(email);
 		
 		if (empleado != null) {
 			if(empleado.isEsJefe()) {
 				EmpleadoDAOImplementation.getInstance().delete(empleado);
 	 	 		List<Jefe> jefes = (List<Jefe>) JefeDAOImplementation.getInstance().readAll();
 	 	     	req.getSession().setAttribute("jefes", jefes);
 			}else {
 				EmpleadoDAOImplementation.getInstance().delete(empleado);
 	 	     	List<Empleado> empleados = (List<Empleado>) EmpleadoDAOImplementation.getInstance().readAll();
 	    		req.getSession().setAttribute("empleados", empleados);
 			}
 	     	
 		}
 		getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
 	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

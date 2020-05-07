package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.chor.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.chor.dao.HorasDAOImplementation;
import es.upm.dit.isst.chor.dao.JefeDAOImplementation;
import es.upm.dit.isst.chor.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.chor.model.Empleado;
import es.upm.dit.isst.chor.model.Horas;
import es.upm.dit.isst.chor.model.Jefe;
import es.upm.dit.isst.chor.model.Proyecto;

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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
 		String email = req.getParameter("email");
 		log(email);
 		
 		if (EmpleadoDAOImplementation.getInstance().buscarEmpleado(email)) {
 	 		Empleado empleado = EmpleadoDAOImplementation.getInstance().read(email);
 	 		List<Horas> horas = (List<Horas>) HorasDAOImplementation.getInstance().readAllEmpleado(empleado);
 	 		for (Horas h : horas) {
 	 			HorasDAOImplementation.getInstance().delete(h);
 	 		}
 	     	EmpleadoDAOImplementation.getInstance().delete(empleado);
 	    	List<Empleado> empleados = (List<Empleado>) EmpleadoDAOImplementation.getInstance().readAll();
 			req.getSession().setAttribute("empleados", empleados);

 		} else if (JefeDAOImplementation.getInstance().buscarJefe(email)) {
 	 		Jefe jefe = JefeDAOImplementation.getInstance().read(email);
 	 		List<Proyecto> proyectos = (List<Proyecto>) ProyectoDAOImplementation.getInstance().readAllJefe(jefe);
 	 		for (Proyecto p : proyectos) {
 	 	 			ProyectoDAOImplementation.getInstance().delete(p);
 	 		}
 	     	JefeDAOImplementation.getInstance().delete(jefe);
 	    	List<Jefe> jefes = (List<Jefe>) JefeDAOImplementation.getInstance().readAll();
 			req.getSession().setAttribute("jefes", jefes);
 		} else {
 			log("El usuario no existe");
 		}
 		getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
 	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

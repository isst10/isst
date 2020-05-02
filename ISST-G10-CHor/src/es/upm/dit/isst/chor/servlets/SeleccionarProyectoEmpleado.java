package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class SeleccionarProyectoEmpleado
 */
@WebServlet("/SeleccionarProyectoEmpleado")
public class SeleccionarProyectoEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionarProyectoEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Empleado empleadoA = (Empleado) req.getSession().getAttribute("empleado");
		String name = req.getParameter("name");
		Proyecto proyecto = ProyectoDAOImplementation.getInstance().read(name);
 		List<Empleado> empleados = (List<Empleado>) EmpleadoDAOImplementation.getInstance().readAll();
 		req.getSession().setAttribute("empleados", empleados);
 		

 		Empleado empleado = EmpleadoDAOImplementation.getInstance().read(empleadoA.getEmail());

//		  if (EmpleadoDAOImplementation.getInstance().buscarEmpleado(empleado.getEmail())) {
		  empleado.setProyecto(proyecto);
		  EmpleadoDAOImplementation.getInstance().update(empleado);
		  req.getSession().setAttribute("empleado", empleado);
	 		List<Empleado> le = new ArrayList<Empleado>();
	 		le.addAll((List<Empleado>)req.getSession().getAttribute("empleados"));
	 		le.add(empleado);
	 		req.getSession().setAttribute("empleados", le);
		  
//		 
			getServletContext().getRequestDispatcher("/Empleado.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

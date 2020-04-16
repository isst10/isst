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
import es.upm.dit.isst.chor.model.Empleado;



/**
 * Servlet implementation class CreaEmpleado
 */
@WebServlet("/CreaEmpleado")
public class CreaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
 		String email = req.getParameter("email");
 		String password = req.getParameter("password");
 		String name = req.getParameter("name");
    	List<Empleado> empleados = (List<Empleado>) EmpleadoDAOImplementation.getInstance().readAll();
		req.getSession().setAttribute("empleados", empleados);

 		Empleado empleado = new Empleado();
 		empleado.setEmail(email);
 		empleado.setPassword(password);
 		empleado.setNombre(name);
 		
 		if (EmpleadoDAOImplementation.getInstance().buscarEmpleado(email) || JefeDAOImplementation.getInstance().buscarJefe(email)) {
 			log("Usuario ya existente");
 			getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
 		}else {
 			EmpleadoDAOImplementation.getInstance().create(empleado);
 	    	EmpleadoDAOImplementation.getInstance().login(email, password);
 			req.getSession().setAttribute("empleado", empleado);

 	 		List<Empleado> lp = new ArrayList<Empleado>();
 	 		lp.addAll((List<Empleado>)         
 	           req.getSession().getAttribute("empleados"));
 	 		lp.add(empleado);
 	 		req.getSession().setAttribute("empleados", lp);
 	 		getServletContext().getRequestDispatcher("/Empleado.jsp").forward(req,resp);
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

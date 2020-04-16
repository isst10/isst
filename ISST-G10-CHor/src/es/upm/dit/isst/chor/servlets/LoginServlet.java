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
import es.upm.dit.isst.chor.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.chor.model.Empleado;
import es.upm.dit.isst.chor.model.Jefe;
import es.upm.dit.isst.chor.model.Proyecto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    private final String ADMIN_EMAIL = "root";
    private final String ADMIN_PASSWORD = "root";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String email = req.getParameter("email");
    	String password = req.getParameter("password");
    	List<Jefe> jefes = (List<Jefe>) JefeDAOImplementation.getInstance().readAll();
    	List<Empleado> empleados = (List<Empleado>) EmpleadoDAOImplementation.getInstance().readAll();
    	List<Proyecto> proyectos = (List<Proyecto>) ProyectoDAOImplementation.getInstance().readAll();
    	Empleado empleado = EmpleadoDAOImplementation.getInstance().login(email, password);
    	Jefe jefe = JefeDAOImplementation.getInstance().login(email, password);
    	if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
    		req.getSession().setAttribute("admin", true);
    		req.getSession().setAttribute("jefes", jefes);
    		req.getSession().setAttribute("empleados", empleados);
    		req.getSession().setAttribute("proyectos", proyectos);
    		getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
    	} else if (empleado != null && empleado.getEmail().equals(email) && empleado.getPassword().equals(password) ) {
			req.getSession().setAttribute("empleado", empleado);
    		getServletContext().getRequestDispatcher("/Empleado.jsp").forward(req,resp);
    	} else if (jefe != null && jefe.getEmail().equals(email) && jefe.getPassword().equals(password)){
    		req.getSession().setAttribute("proyectos", proyectos);
    		req.getSession().setAttribute("jefe", jefe);
    		getServletContext().getRequestDispatcher("/Jefe.jsp").forward(req,resp);
    	} else {
    		getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
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

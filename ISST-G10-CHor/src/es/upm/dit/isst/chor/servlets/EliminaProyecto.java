package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.chor.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.chor.dao.JefeDAOImplementation;
import es.upm.dit.isst.chor.model.Proyecto;
import es.upm.dit.isst.chor.model.Jefe;

/**
 * Servlet implementation class EliminaProyecto
 */
@WebServlet("/EliminaProyecto")
public class EliminaProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaProyecto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
 		Proyecto proyecto = ProyectoDAOImplementation.getInstance().read(name);
 		
 		
 		if (ProyectoDAOImplementation.getInstance().buscarProyecto(name)) {
 			ProyectoDAOImplementation.getInstance().delete(proyecto);
 	    	List<Proyecto> proyectos = (List<Proyecto>) ProyectoDAOImplementation.getInstance().readAll();
 			req.getSession().setAttribute("empleados", proyectos);
 		} else {
 			log("El proyecto no existe");
 		}
 		getServletContext().getRequestDispatcher("/Jefe.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

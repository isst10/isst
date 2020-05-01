package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.chor.dao.JefeDAOImplementation;
import es.upm.dit.isst.chor.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.chor.model.Jefe;
import es.upm.dit.isst.chor.model.Proyecto;

/**
 * Servlet implementation class EliminarProyecto
 */
@WebServlet("/EliminarProyecto")
public class EliminarProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProyecto() {
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
 		
 		if (ProyectoDAOImplementation.getInstance().read(name) != null) {
 			Jefe jefe = proyecto.getJefe();
 			ProyectoDAOImplementation.getInstance().delete(proyecto);
 	    	List<Proyecto> proyectos = (List<Proyecto>) ProyectoDAOImplementation.getInstance().readAll();
 			req.getSession().setAttribute("proyectos", proyectos);
 			Jefe jefeActualizado = JefeDAOImplementation.getInstance().read(jefe.getEmail());
 			req.getSession().setAttribute("jefe", jefeActualizado);
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

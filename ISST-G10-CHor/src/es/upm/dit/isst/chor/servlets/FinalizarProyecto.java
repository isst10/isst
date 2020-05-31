package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import java.util.Date;
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
 * Servlet implementation class FinalizarProyecto
 */
@WebServlet("/FinalizarProyecto")
public class FinalizarProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizarProyecto() {
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

		java.util.Date fecha = new Date();

		if (ProyectoDAOImplementation.getInstance().read(name) != null && ProyectoDAOImplementation.getInstance().read(name).getFechaFin() != null) {
			proyecto.setFechaFin(fecha);
			proyecto.setTerminado(true);
			ProyectoDAOImplementation.getInstance().update(proyecto);
 	    	List<Proyecto> proyectos = (List<Proyecto>) ProyectoDAOImplementation.getInstance().readAll();
 			req.getSession().setAttribute("proyectos", proyectos);
 			Jefe jefe = proyecto.getJefe();
 			JefeDAOImplementation.getInstance().update(jefe);
 			req.getSession().setAttribute("jefe", jefe);
 		} else {
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

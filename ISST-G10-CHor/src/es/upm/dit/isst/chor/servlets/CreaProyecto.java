package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class CreaProyecto
 */
@WebServlet("/CreaProyecto")
public class CreaProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaProyecto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	Jefe jefe =(Jefe) req.getSession().getAttribute("jefe");
    	String name = req.getParameter("name");
 		java.util.Date fecha = new Date();
 		String finalizacionstr = req.getParameter("Finalizacion");
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
		Date finalizacion = null;
		try {
			finalizacion = sdff.parse(finalizacionstr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

 		List<Proyecto> proyectos = (List<Proyecto>) ProyectoDAOImplementation.getInstance().readAll();
 		req.getSession().setAttribute("proyectos", proyectos);

 		Proyecto proyecto = new Proyecto();
 		proyecto.setName(name);
 		proyecto.setJefe(jefe);
 		proyecto.setFechaInicio(fecha);
 		proyecto.setFechaFin(finalizacion);
 		if (!ProyectoDAOImplementation.getInstance().buscarProyecto(name)) {
 	 		ProyectoDAOImplementation.getInstance().create(proyecto);
 	 		req.getSession().setAttribute("proyecto", proyecto);
 	 		List<Proyecto> lp = new ArrayList<Proyecto>();
 	 		lp.addAll((List<Proyecto>)req.getSession().getAttribute("proyectos"));
 	 		lp.add(proyecto);
 	 		req.getSession().setAttribute("proyectos", lp);
 	 		getServletContext().getRequestDispatcher("/Proyecto.jsp").forward(req,resp);
 		}else {
 			log("El proyecto ya existe");
 	 		getServletContext().getRequestDispatcher("/Proyecto.jsp").forward(req,resp);

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

package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	Empleado empleado = (Empleado) req.getSession().getAttribute("empleado");
 		String name = req.getParameter("name");
 		Jefe jefe =(Jefe) req.getSession().getAttribute("jefe");
 		
 		java.util.Date fecha = new Date();
 		
 		Proyecto proyecto = new Proyecto();
 		
 		proyecto.setName(name);

 		proyecto.setJefe(jefe);
 		proyecto.setFechaInicio(fecha);
 		
 		ProyectoDAOImplementation.getInstance().create(proyecto);
 		List<Proyecto> lp = new ArrayList<Proyecto>();
 		lp.addAll((List<Proyecto>)         
                           req.getSession().getAttribute("proyectos"));
 		lp.add (proyecto);
 		req.getSession().setAttribute("proyectos", lp);
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

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

import java.text.SimpleDateFormat;
import java.text.ParseException;

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
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	Jefe jefe =(Jefe) req.getSession().getAttribute("jefe");
    	String name = req.getParameter("name");

    	String cliente = req.getParameter("cliente");
 		String fechaFin = req.getParameter("fechaFin");
 		java.util.Date fechaFinal = ParseFecha(fechaFin);
    	//String employees[] = req.getParameterValues("employees[]");
 		java.util.Date fecha = new Date();

 		List<Proyecto> proyectos = (List<Proyecto>) ProyectoDAOImplementation.getInstance().readAll();
 		req.getSession().setAttribute("proyectos", proyectos);


 		if (!ProyectoDAOImplementation.getInstance().buscarProyecto(name)) {
 			Proyecto proyecto = new Proyecto();
 	 		proyecto.setName(name);
 	 		proyecto.setJefe(jefe);
 	 		proyecto.setCliente(cliente);
 	 		proyecto.setFechaInicio(fecha);
 	 		proyecto.setFechaFin(fechaFinal);
 	 		proyecto.setTerminado(false);
 	 		ProyectoDAOImplementation.getInstance().create(proyecto);
 	 		req.getSession().setAttribute("proyecto", proyecto);
 	 		List<Proyecto> lp = new ArrayList<Proyecto>();
 	 		lp.addAll((List<Proyecto>)req.getSession().getAttribute("proyectos"));
 	 		lp.add(proyecto);
 	 		req.getSession().setAttribute("proyectos", lp);
			/*
			 * for(int i=0; i<employees.length; i++) { Empleado
			 * empleado=EmpleadoDAOImplementation.getInstance().read(employees[i]);
			 * empleado.setProyecto(proyecto);
			 * EmpleadoDAOImplementation.getInstance().update(empleado); }
			 */

 		}else {
 			log("El proyecto ya existe");
 		}
 		getServletContext().getRequestDispatcher("/Proyecto.jsp").forward(req,resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

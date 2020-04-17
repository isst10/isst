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

import es.upm.dit.isst.chor.dao.HorasDAOImplementation;
import es.upm.dit.isst.chor.model.Empleado;
import es.upm.dit.isst.chor.model.Horas;
<<<<<<< Updated upstream
=======
import es.upm.dit.isst.chor.model.Jefe;
import es.upm.dit.isst.chor.model.Proyecto;
>>>>>>> Stashed changes

/**
 * Servlet implementation class RegistrarHorasServlet
 */
@WebServlet("/RegistrarHorasServlet")
public class RegistrarHorasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarHorasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Empleado empleado = (Empleado) req.getSession().getAttribute("empleado");
<<<<<<< Updated upstream
 		String proyecto = req.getParameter("proyecto");
 		String h = req.getParameter("horas");
=======
//		Jefe jefe = (Jefe) req.getSession().getAttribute("jefe");
 		
		String proyecto = req.getParameter("proyecto");
 		String h = req.getParameter("h");
>>>>>>> Stashed changes
 		java.util.Date fecha = new Date();
 		List<Horas> horas = (List<Horas>)HorasDAOImplementation.getInstance().readAllEmpleado(empleado);
 		req.getSession().setAttribute("horas", horas);

 		Horas hora = new Horas();
 		hora.sethEmpleado(empleado);
 		hora.setProyecto(proyecto);
 		hora.setEmpresa(empleado.getEmpresa());
 		hora.setHoras(h);
 		hora.setDate(fecha);
 		
 		HorasDAOImplementation.getInstance().create(hora);
		req.getSession().setAttribute("hora", hora);

 		List<Horas> lp = new ArrayList<Horas>();
	 	lp.addAll((List<Horas>)req.getSession().getAttribute("horas"));

// 		lp = (List<Horas>) HorasDAOImplementation.getInstance().readAllEmpleado(empleado.getNombre());
 		lp.add(hora);
<<<<<<< Updated upstream
 		req.getSession().setAttribute("horas", lp);
// 		if(empleado.isEsJefe()) {
// 			getServletContext().getRequestDispatcher("/Jefe.jsp").forward(req,response);
// 		}else {
 			getServletContext().getRequestDispatcher("/Empleado.jsp").forward(req,response);
// 		}
=======
 		req.getSession().setAttribute("h", lp);
>>>>>>> Stashed changes
 		
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

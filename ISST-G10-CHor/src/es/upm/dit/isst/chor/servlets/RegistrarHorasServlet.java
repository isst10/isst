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
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Empleado empleado = (Empleado) req.getSession().getAttribute("empleado");
 		String proyecto = req.getParameter("proyecto");
 		String h = req.getParameter("horas");
 		java.util.Date fecha = new Date();

 		Horas hora = new Horas();
 		hora.setEmpleado(empleado.getNombre());
 		hora.setProyecto(proyecto);
 		hora.setHoras(h);
 		hora.setDate(fecha);
 		
 		HorasDAOImplementation.getInstance().create(hora);
 		List<Horas> lp = new ArrayList<Horas>();
 		lp = (List<Horas>) HorasDAOImplementation.getInstance().readAllEmpleado(empleado.getNombre());
 		lp.add(hora);
 		req.getSession().setAttribute("horas", lp);
// 		if(empleado.isEsJefe()) {
// 			getServletContext().getRequestDispatcher("/Jefe.jsp").forward(req,response);
// 		}else {
 			getServletContext().getRequestDispatcher("/Empleado.jsp").forward(req,response);
// 		}
 		
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import javax.swing.JOptionPane;

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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Empleado empleado = (Empleado) req.getSession().getAttribute("empleado");

		if(empleado.getProyecto() == null) {
			getServletContext().getRequestDispatcher("/Empleado.jsp").forward(req,response);
 		}else {
 		String h = req.getParameter("horas");
 		java.util.Date fecha = new Date();
 		List<Horas> horas = (List<Horas>)HorasDAOImplementation.getInstance().readAllEmpleado(empleado);
 		req.getSession().setAttribute("horas", horas);
 		//Proyecto proyecto = ProyectoDAOImplementation.getInstance().read(empleado.getProyecto());
 		Horas hora = new Horas();
 		hora.setEmpleado(empleado);
 		hora.setProyecto(empleado.getProyecto());
 		hora.setHoras(h);
 		hora.setDate(fecha);

 		HorasDAOImplementation.getInstance().create(hora);
		req.getSession().setAttribute("hora", hora);

 		List<Horas> lp = new ArrayList<Horas>();
	 	lp = (List<Horas>) HorasDAOImplementation.getInstance().readAllEmpleado(empleado);
 		lp.add(hora);
 		req.getSession().setAttribute("horas", lp);
 		boolean flag = true;
 		req.setAttribute("flag", flag);
 		getServletContext().getRequestDispatcher("/Empleado.jsp").forward(req,response);
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

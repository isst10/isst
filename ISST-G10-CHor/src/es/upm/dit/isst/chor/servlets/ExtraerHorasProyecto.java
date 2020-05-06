package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.chor.dao.HorasDAOImplementation;
import es.upm.dit.isst.chor.model.Horas;
import es.upm.dit.isst.chor.model.Proyecto;

/**
 * Servlet implementation class ExtraerHorasProyecto
 */
@WebServlet("/ExtraerHorasProyecto")
public class ExtraerHorasProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtraerHorasProyecto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Proyecto proyecto = (Proyecto) request.getSession().getAttribute("proyecto");
		String name = proyecto.getName();
		List<Horas> horas = (List<Horas>) HorasDAOImplementation.getInstance().readAllProyecto(name);
		request.setAttribute("horasProyecto", horas);
		getServletContext().getRequestDispatcher("/Proyecto.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

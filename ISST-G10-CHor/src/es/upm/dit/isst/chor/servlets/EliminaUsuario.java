package es.upm.dit.isst.chor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.chor.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.chor.model.Empleado;

/**
 * Servlet implementation class EliminaUsuario
 */
@WebServlet("/EliminaUsuario")
public class EliminaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
 		String email = req.getParameter("email");
 		String password = req.getParameter("password");
 		String name = req.getParameter("name");
 		
 		Empleado empleado = new Empleado();
 		empleado.setEmail(email);
 		empleado.setPassword(password);
 		empleado.setNombre(name);
 		
 		EmpleadoDAOImplementation.getInstance().delete(empleado);
 		getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
 	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import es.upm.dit.isst.chor.model.Jefe;



/**
 * Servlet implementation class CreaJefe
 */
@WebServlet("/CreaJefe")
public class CreaJefe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaJefe() {
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
 		String empresa = req.getParameter("empresa");
 		
 		Jefe jefe = new Jefe();
 		jefe.setEmail(email);
 		jefe.setPassword(password);
 		jefe.setNombre(name);
 		jefe.setEmpresa(empresa);
 		
 		
 		JefeDAOImplementation.getInstance().create(jefe);
 		List<Jefe> lp = new ArrayList<Jefe>();
 		lp.addAll((List<Jefe>)         
           req.getSession().getAttribute("jefes"));
 		lp.add (jefe);
 		req.getSession().setAttribute("jefes", lp);
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

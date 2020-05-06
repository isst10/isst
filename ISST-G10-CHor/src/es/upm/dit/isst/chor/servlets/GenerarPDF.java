package es.upm.dit.isst.chor.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Text;

import es.upm.dit.isst.chor.model.Empleado;
import es.upm.dit.isst.chor.model.Proyecto;
import es.upm.dit.isst.chor.model.Horas;
import es.upm.dit.isst.chor.dao.HorasDAOImplementation;



/**
 * Servlet implementation class GenerarPDF
 */
@WebServlet("/GenerarPDF")
public class GenerarPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarPDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Proyecto proyecto = (Proyecto) req.getSession().getAttribute("proyecto");

		String home = System.getProperty("user.home");
		String desc = home + "/Downloads/Horas.pdf";

		PdfWriter writer = new PdfWriter(desc);
		PdfDocument pdf = new PdfDocument(writer);
		Document documento = new Document(pdf);
		java.util.List<Horas> listHoras = (java.util.List<Horas>) HorasDAOImplementation.getInstance().readAllProyecto(proyecto.getName());

		Table tabla = new Table(3);
		tabla.addHeaderCell("Nombre");
		tabla.addHeaderCell("Fecha");
		tabla.addHeaderCell("Horas Registradas");


		for(Horas h : listHoras) {
			tabla.addCell(h.getEmpleado().getNombre());
			tabla.addCell(h.getDate().toString());
			tabla.addCell(h.getHoras());
		}

		documento.add(tabla);
		documento.close();

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

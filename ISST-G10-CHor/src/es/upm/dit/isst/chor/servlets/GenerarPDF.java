package es.upm.dit.isst.chor.servlets;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.element.Table;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
//import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Text;
import com.itextpdf.io.image.ImageType;
import com.itextpdf.io.image.ImageData;

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

	// private static final ImageType JPEG = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GenerarPDF() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Proyecto proyecto = (Proyecto) req.getSession().getAttribute("proyecto");
		try {
			

		String home = System.getProperty("user.home");
		Document documento = new Document();


		PdfWriter.getInstance(documento, new FileOutputStream(home + "/Desktop/InformeProyecto_" + proyecto.getName() + ".pdf"));

		documento.open();
		String relativeWebPath = "/images/consulthour.jpg";
		String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
		Image imagen = Image.getInstance(absoluteDiskPath);
		imagen.scalePercent(20, 10);
		imagen.setAlignment(Element.ALIGN_CENTER);
		documento.add(imagen);

		java.util.List<Horas> listHoras = (java.util.List<Horas>) HorasDAOImplementation.getInstance()
				.readAllProyecto(proyecto.getName());

		PdfPTable tabla = new PdfPTable(3);
		tabla.addCell("Nombre");
		tabla.addCell("Fecha");
		tabla.addCell("Horas Registradas");
		
		for (Horas h : listHoras) {
			tabla.addCell(h.getEmpleado().getNombre());
			tabla.addCell(h.getDate().toString());
			tabla.addCell(h.getHoras());
		}
		tabla.setSpacingBefore(50);
		documento.add(tabla);
		documento.close();
		
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/Proyecto.jsp").forward(req, resp);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

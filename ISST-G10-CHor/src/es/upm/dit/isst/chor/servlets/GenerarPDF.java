package es.upm.dit.isst.chor.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import es.upm.dit.isst.chor.model.Empleado;
import es.upm.dit.isst.chor.model.Proyecto;

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

		Document documento = new Document();
		
		try {
			String ruta = System.getProperty("user.home");
			PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Proyecto.pdf"));
			documento.open();

			PdfPTable tabla = new PdfPTable(3);
			tabla.addCell("Nombre");
			tabla.addCell("Fecha");
			tabla.addCell("Horas Registradas");
			
			Connection cn = null;
			Statement stmt = null;
			
			try {
				Class.forName ("org.h2.Driver");
				cn = DriverManager.getConnection("jdbc:h2:~/isst-g10/AUTO_SERVER=TRUE", "sa", "sa");
				stmt = cn.createStatement();
				String sql = "SELECT EMPLEADO_EMAIL, DATE, HORAS FROM HORAS WHERE PROYECTO='" + proyecto.getName() +"'";
				log(sql);
				
				ResultSet rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
						tabla.addCell(rs.getString(1));
						tabla.addCell(rs.getString(2));
						tabla.addCell(rs.getString(3));
				}
				rs.close();
				
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally { 
		         // finally block used to close resources 
		         try { 
		            if(stmt!=null) stmt.close(); 
		         } catch(SQLException se2) { 
		         } // nothing we can do 
		         try { 
		            if(cn!=null) cn.close(); 
		         } catch(SQLException se) { 
		            se.printStackTrace(); 
		         }
			}
		} catch (Exception e) {
			documento.close();
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

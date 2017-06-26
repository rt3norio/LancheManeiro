/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */
 
package servlet;
 
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import model.PedidosBanco;
import object.Pedido;
@WebServlet("/pdf")
public class PdfServlet extends HttpServlet {
 
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            // Get the text that will be added to the PDF
            String text = request.getParameter("text");
            if (text == null || text.trim().length() == 0) {
                 text = "You didn't enter any text.";
            }
            
            ArrayList<Pedido> pedidos = PedidosBanco.historicoPedidos();
        	
            
            
            
            // step 1
            Document document = new Document();
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            // step 3
            document.open();
            // step 4
            
            for(Pedido p:pedidos){
            	document.add(new Paragraph(p.getCliente()));
            	document.add(new Paragraph(p.getComida()));
            	document.add(new Paragraph(p.getCriacao().getHours()+":"+p.getCriacao().getMinutes()));
            	document.add(new Paragraph(p.getPrioritario().toString()));
            	document.add(new Paragraph(p.getObservacao()));
            	document.add(new Paragraph(" "));
            	LineSeparator separador = new LineSeparator();              
            	document.add(separador);
            	
            }
            
            //add here!
//            document.add(new Paragraph(String.format(
//                "You have submitted the following text using the %s method:",
//                request.getMethod())));
            
            
//            document.add(new Paragraph(text));
            
            
            // step 5
            document.close();
 
            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the contentlength
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        }
        catch(DocumentException e) {
            throw new IOException(e.getMessage());
        }
    }
 
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 6067021675155015602L;
 
}
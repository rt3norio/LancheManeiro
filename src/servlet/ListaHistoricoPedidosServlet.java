package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PedidosBanco;
import object.Pedido;

/**
 * Servlet implementation class ListaPedidosServlet
 */
@WebServlet("/HistoricoPedidos")
public class ListaHistoricoPedidosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaHistoricoPedidosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
    	// Set refresh, autoload time as 5 seconds
    	//response.setIntHeader("Refresh", 5);

    	// Set response content type
    	response.setContentType("text/html");

    	// Get current time
    	Calendar calendar = new GregorianCalendar();
    	String am_pm;
    	int hour = calendar.get(Calendar.HOUR);
    	int minute = calendar.get(Calendar.MINUTE);
    	int second = calendar.get(Calendar.SECOND);
    	if(calendar.get(Calendar.AM_PM) == 0)
    		am_pm = "AM";
    	else
    		am_pm = "PM";

    	String CT = hour+":"+ minute +":"+ second +" "+ am_pm;

    	PrintWriter out = response.getWriter();
    	String title = "Historico de Pedidos";
    	String docType =
    			"<!doctype html public \"-//w3c//dtd html 4.0 " +
    					"transitional//en\">\n";
    	out.println(docType +
    			"<html>\n" +
    			"<head><title>" + title + "</title></head>\n"+
    			"<body bgcolor=\"#f0f0f0\">\n" +
    			"<h1 align=\"center\">" + title + "</h1>\n" +
    			"<p align=\"center\">HORA AGORA: " + CT + "</p>\n");
    	  	
    	String finalizaForm = ("<form align=\"center\" method=\"get\" action=\"paginas/menu.jsp\">"+
    	  "Voltar:<br>"+
    	  "<input type=\"submit\" value=\"Voltar\">"+
    	"</form>");
    	out.println(finalizaForm);
    	String botaoPdf = ("<form align=\"center\" method=\"get\" action=\"pdf\">"+
    	    	  "Exibir PDF:<br>"+
    	    	  "<input type=\"submit\" value=\"Exibir PDF\">"+
    	    	"</form>");
    	    	out.println(botaoPdf);
    	
    	String tabela = ("<table style=\"margin-left: auto; margin-right: auto;\" border=\"1\">"+
	"<tbody>"+
		"<tr>"+
		"	<td>Numero do Pedido</td>"+
		"	<td>Hora</td>"+
		"	<td>&nbsp;&nbsp;Nome&nbsp;&nbsp;</td>"+
		"	<td>&nbsp;&nbsp;&nbsp;Pedido&nbsp;&nbsp;&nbsp;</td>"+
		"	<td>&nbsp;&nbsp;Observacao&nbsp;&nbsp;</td>"+
		"	<td>Prioridade</td>"+
		"</tr>");
		//inserir as paradas aqui!

//    	PdfUtil pdf = new PdfUtil();
//    	pdf.criar();
    	

//    	PdfTest1 t = new PdfTest1();
//    	try {
//			t.main();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	ArrayList<Pedido> pedidos = PedidosBanco.historicoPedidos();
    	for(Pedido p:pedidos){
    		
    		tabela = tabela + p.toTable();
    		
    	}
    	
    	tabela = tabela +(	"</tbody>"+
    						"</table>");

    	out.println(tabela);
    	
    	
    	
}
    // Method to handle POST method request.
    public void doPost(HttpServletRequest request,
    		HttpServletResponse response)
    				throws ServletException, IOException {
    	doGet(request, response);
    }

}

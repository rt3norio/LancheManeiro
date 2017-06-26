package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PedidosBanco;
import model.SendMail;
import object.Pedido;

/**
 * Servlet implementation class PedidoServlet
 */
@WebServlet("/PedidoServlet")
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out.println("pedidoservletemexecucao");
			String compilacaoDosPedidos = "";
			//
			Enumeration<String> parameters = request.getParameterNames();
			System.out.println(parameters);
		    while(parameters.hasMoreElements()){
		        String parameterName = (String)parameters.nextElement();
		        //String parameterValue = request.getParameter(parameterName);
		        String[] listaDeParametros = request.getParameterValues(parameterName);
		        for (String parametros:listaDeParametros){
		        	if (parameterName.equals("nome") || parameterName.equals("obs")){
		        		continue;
		        	}
		        	else{
		        	compilacaoDosPedidos = compilacaoDosPedidos + parameterName+" : "+parametros;
		        	}
		        }
		    }
			
			Pedido p = new Pedido((String)request.getParameter("nome"),compilacaoDosPedidos,(String)request.getParameter("obs"));
			PedidosBanco.adicionarPedido(p);
			SendMail.enviar(p);
		
		response.sendRedirect("index.jsp");
	}

}

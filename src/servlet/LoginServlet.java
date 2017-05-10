package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.websocket.Session;

import model.Validador;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("post");
		String login = (String) request.getParameter("login");
		String senha = (String) request.getParameter("senha");
		System.out.println(login);
		System.out.println(senha);
		
		if (Validador.checarUsuario(login, senha)){ //MODO TESTE!!!!
			HttpSession sessao = request.getSession();
			sessao.setAttribute("login", login);
			System.out.println("ok");
			response.sendRedirect("/LancheManeiro/paginas/menu.jsp");
		}
		else{
			System.out.println("login errado");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("senha", "incorreta");
			response.sendRedirect("/LancheManeiro/index2.jsp");
		}
		
		
	}

}

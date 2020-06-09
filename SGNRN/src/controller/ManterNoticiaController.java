package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/ManterNoticiaController.do")
public class ManterNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().println("Chegou até aqui! " + request.getParameter("action"));
		System.out.println(request.getParameter("acao"));
		// 1º Passo: verificar qual ação o usuário enviou para a servlet:

		if (request.getParameter("acao").equals("cadastrarNoticia")) {
			// Se a ação do usuário é "login":
			this.cadastroNoticia(request, response);
		} else if (request.getParameter("acao").equals("visualizarNoticia")) {
			// Se a ação do usuário é "cadastro":
			this.visualizarNoticia(request, response);
		}else if(request.getParameter("acao").equals("cadastroNoticia")) {
			
		}
	}
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id_noticia"));
		String descricao = request.getParameter("descricao_noticia");
		String titulo = request.getParameter("titulo_noticia");
		String texto = request.getParameter("texto_noticia");
		Noticia noticia = new Noticia(id, descricao, titulo, texto);
		NoticiaService noticiaservice = new NoticiaService();
		noticiaservice.cadastrar(noticia);
		
		try {
			// Redirecionando o usuário: (despachando)
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private void visualizarNoticia(HttpServletRequest request, HttpServletResponse response) {
		NoticiaService noticiaservice = new NoticiaService();
		ArrayList<Noticia> noticias = noticiaservice.noticias();
		
		HttpSession session = request.getSession();
		 session.setAttribute("noticias", noticias);

		try {
			// Redirecionando o usuário: (despachando)
			request.getRequestDispatcher("VisualizarNoticia.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	

	/**
	 * Executa as ações relacionadas ao login do usuário:
	 * 
	 * @param request
	 * @param response
	 */
	private void cadastroNoticia(HttpServletRequest request, HttpServletResponse response) {

		try {
			// Redirecionando o usuário: (despachando)
			request.getRequestDispatcher("CadastrarNoticia.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}

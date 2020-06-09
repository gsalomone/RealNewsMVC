package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticiaDAO;
import model.Noticia;
import service.NoticiaService;


@WebServlet("/CadastraNoticias.do")
public class CadastrarNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarNoticias() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id_noticia"));
		String descricao = request.getParameter("descricao_noticia");
		String titulo = request.getParameter("titulo_noticia");
		String texto = request.getParameter("texto_noticia");
		Noticia noticia = new Noticia(id, descricao, titulo, texto);
		NoticiaService noticiaservice = new NoticiaService();
		noticiaservice.cadastrar(noticia);
		
		response.sendRedirect("VisualizarNoticia.do");
		
	}
}

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticiaDAO;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/VisualizarNoticia.do")
public class VisualizarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizarNoticia() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Executando Servlets");
		response.setContentType("text/html");

		NoticiaService noticiaservice = new NoticiaService();
		ArrayList<Noticia> noticias = noticiaservice.noticias();

		PrintWriter saida = response.getWriter();

		for (Noticia n : noticias) {
			saida.println(" <br>Id: " + n.getId() + " <br>Descricao: " + n.getDescricao() + " <br>Titulo: "
					+ n.getTitulo() + "<br><a href = '/SGNRN/ExcluirNoticia.do?id=" + n.getId() + "'>excluir</a>"
					+ "<br><a href = '/SGNRN/AlterarNoticia.do?id=" + n.getId() + "'>alterar</a>"
					+ "<br><a href = '/SGNRN/DetalheNoticia.do?id=" + n.getId() + "'>detalhes</a>");

		}
	}
}

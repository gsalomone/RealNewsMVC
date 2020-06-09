package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

@WebServlet("/DetalheNoticia.do")
public class DetalheNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetalheNoticia() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int idNoticia = Integer.parseInt(request.getParameter("id"));
		NoticiaService noticiaservice = new NoticiaService();
		Noticia noticia = noticiaservice.consultarnoticia(idNoticia);
		ComentarioService comentarioservice = new ComentarioService();
		ArrayList<Comentario> comentarios = comentarioservice.comentarios(idNoticia);

		PrintWriter saida = response.getWriter();

		saida.println("<br><h1>" + noticia.getTitulo() + "</h1><p> " + noticia.getTexto()+"</p>");
		saida.println("<h2> Comentarios: </h2>");
		
		for (Comentario c : comentarios) {
			saida.println(c.getNome()+"<br>");
			saida.println("  "+c.getTexto());
			saida.println("<hr>");

		}
		saida.println("<h5>Adicionar Comentario: </h5>");
		saida.println("<form action = 'CadastrarComentario.do' method = 'post'>"
		+"<input type='hidden' name='id_noticia' value='" + noticia.getId() + "'>");

		saida.println("Nome: <input type = 'text' name = 'nome_comentario'/><br><br>" );
		saida.println("Texto: <textarea name = 'texto_comentario'></textarea>" );
		saida.println("<input type = 'submit' value = 'Salvar Comentario'/>");
		saida.println("</form>");
		
	}

}

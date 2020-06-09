package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

@WebServlet("/CadastrarComentario.do")
public class CadastrarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CadastrarComentario() {
        super();
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idNoticia = Integer.parseInt(request.getParameter("id_noticia"));
		String nome = request.getParameter("nome_comentario");
		String texto = request.getParameter("texto_comentario");
		ComentarioService cometarioservice = new ComentarioService();
		Comentario comentario = new Comentario();
		comentario.setIdNoticia(idNoticia);
		comentario.setNome(nome);
		comentario.setTexto(texto);
		cometarioservice.cadastrar(comentario);
		
		response.sendRedirect("VisualizarNoticia.do");
		
		
	}

}

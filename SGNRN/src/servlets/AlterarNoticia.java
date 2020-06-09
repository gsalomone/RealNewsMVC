package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/AlterarNoticia.do")
public class AlterarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarNoticia() {
		super();

	}
	   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	int id = Integer.parseInt(request.getParameter("id"));
		    NoticiaService noticiaservice = new NoticiaService();
	    	Noticia noticia = noticiaservice.consultarnoticia(id);
	    	
	    	//criando formulario para alteracao
	    	PrintWriter saida = response.getWriter();
	    	saida.println(" <form action = 'ConcluirAlteracao.do' method = 'post'>" 	 
	    					+"<input type='hidden' name='id_noticia' value='" + noticia.getId() + "'>"
	    					+ "<br>Titulo: <input type = 'text' value = '" + noticia.getTitulo()+ "' name = 'titulo_noticia'/>"
	    					+ "<br>Descricao: <input type = 'text' value = '" + noticia.getDescricao()+ "' name = 'descricao_noticia'/>"
	    					+ "<br>Texto: <textarea value = '" + noticia.getTexto()+ "'' name = 'texto_noticia'></textarea>"
	    					+ "<br><input type = 'submit' value = 'Salvar Alteracoes'/>"
	    					+ "</form>");
	    	
	    	
	   }

	    
		
}

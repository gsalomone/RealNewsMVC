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


@WebServlet("/ExcluirNoticia.do")
public class ExcluirNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ExcluirNoticia() {
        super();
        
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	Noticia noticia = new Noticia();
    	noticia.setId(id);
    	NoticiaService noticiaservice = new NoticiaService();
    	noticiaservice.excluir(noticia);
    	
    	PrintWriter saida = response.getWriter();
    	saida.println("A Noticia " + id + " Foi excluída com sucesso" );
    }

    
	
}

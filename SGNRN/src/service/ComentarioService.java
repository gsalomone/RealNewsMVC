package service;

import java.util.ArrayList;

import dao.ComentarioDAO;
import dao.NoticiaDAO;
import model.Comentario;
import model.Noticia;

public class ComentarioService {
	private ComentarioDAO comentariodao = new ComentarioDAO();
	
	public void cadastrar(Comentario comentario) {
		comentariodao.cadastrar(comentario);
	}
	public void excluir(Comentario comentario) {
		comentariodao.excluir(comentario);
	}
	public void alterar(Comentario comentario) {
		comentariodao.alterar(comentario);
	}
	public Comentario consultarcomentario(int id) { 
		return comentariodao.consultar(id);
	}
	public ArrayList<Comentario> comentarios(int idNoticia) {
		return comentariodao.listarComentariosPorNoticia(idNoticia);
		
	}
}

package service;

import java.util.ArrayList;

import dao.NoticiaDAO;
import model.Noticia;

public class NoticiaService {
	private NoticiaDAO noticiadao = new NoticiaDAO();
	
	public void cadastrar(Noticia noticia) {
		noticiadao.cadastrar(noticia);
	}
	public void excluir(Noticia noticia) {
		noticiadao.excluir(noticia);
	}
	public void alterar(Noticia noticia) {
		noticiadao.alterar(noticia);
	}
	public Noticia consultarnoticia(int id) { 
		return noticiadao.consultar(id);
	}
	public ArrayList<Noticia> noticias() {
		return noticiadao.listarNoticias();
		
	}
}


package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;

import java.sql.ResultSet;

public class ComentarioDAO {
	
	private Connection conexao;
	
	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Comentario comentario) {
			
		String inserir = "INSERT INTO comentario "
				+ " ( nome, texto, fk_noticia_id) "
				+ " VALUES ( ?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3,  comentario.getIdNoticia());
						
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Nao foi possivel manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Comentario comentario) {
		
		String inserir = "UPDATE comentario "
				+ "SET nome = ?, texto = ? "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, comentario.getNome());
			pst.setString(3, comentario.getTexto());
			pst.setInt(4, comentario.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("nao foi possivel manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Comentario comentario) {
		
		String inserir = "DELETE FROM comentario "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, comentario.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Nao foi possivel manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
		}
	}
	
	public Comentario consultar(int id) {
		
		String inserir = "SELECT * FROM comentario "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Comentario c = new Comentario();
			if (resultado.next()) {
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
			}
			return c;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Nao foi possivel manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Comentario> listarComentariosPorNoticia(int idNoticia) {
		
		String inserir = "SELECT * FROM comentario WHERE fk_noticia_id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, idNoticia);
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario c = new Comentario();
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				lista.add(c);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Nao foi possivel manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
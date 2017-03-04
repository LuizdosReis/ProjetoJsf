package br.com.bean;

import javax.faces.bean.ManagedBean;

import br.com.dao.DAO;
import br.com.model.Livro;

@ManagedBean
public class LivroBean{

	private Livro livro = new Livro();
	

	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public void gravar(){
		System.out.println("livro gravado"+livro.getTitulo());
		
		if (livro.getAutores().isEmpty()) {
			throw new RuntimeException("Livro deve ter pelo menos um Autor.");
		}
		
		new DAO<Livro>(Livro.class).adiciona(livro);
		
		livro = new Livro();
		
	}
	
	
	
}

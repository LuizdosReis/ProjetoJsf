package br.com.bean;

import javax.faces.bean.ManagedBean;

import br.com.dao.DAO;
import br.com.model.Autor;

@ManagedBean
public class AutorBean {
	
	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public void gravar(){
		
		new DAO<Autor>(Autor.class).adiciona(autor);
		
		autor = new Autor();
	}

}

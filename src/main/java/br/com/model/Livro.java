package br.com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Livro {

	@Id @GeneratedValue
	private int id;
	
	private String titulo;
	private String isbn;
	private Double preco;
	private String dataLancamento;
	
	@ManyToMany
	private List<Autor> autores;
	
	public Livro() {
		autores = new ArrayList<Autor>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void adicionaAutor(Autor autor) {
		autores.add(autor);
	}

	public List<Autor> getAutores() {
		return Collections.unmodifiableList(autores);
	}
	
	

	
}

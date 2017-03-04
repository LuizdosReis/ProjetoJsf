package br.com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.model.Livro;


public class PopulaBanco {

	public static void main(String[] args) {
		
		
		
		

		EntityManager em = new JPAUtil().getEntityManeger();

		em.getTransaction().begin();

		Livro casmurro = geraLivro("978-8-52-504464-8", "Dom Casmurro",
				"10/01/1899", 24.90);
		Livro memorias = geraLivro("978-8-50-815415-9",
				"Memorias Postumas de Bras Cubas", "01/01/1881", 19.90);
		Livro quincas = geraLivro("978-8-50-804084-1", "Quincas Borba",
				"01/01/1891", 16.90);
		
		//new DAO<Livro>(Livro.class).adiciona(casmurro);

		em.persist(casmurro);
		em.persist(memorias);
		em.persist(quincas);

		Livro alquemista = geraLivro("978-8-57-542758-3", "O Alquimista",
				"01/01/1988", 19.90);
		Livro brida = geraLivro("978-8-50-567258-7", "Brida", "01/01/1990",
				12.90);
		Livro valkirias = geraLivro("978-8-52-812458-8", "As Valkirias",
				"01/01/1992", 29.90);
		Livro maao = geraLivro("978-8-51-892238-9", "O Diario de um Mago",
				"01/01/1987", 9.90);

		em.persist(alquemista);
		em.persist(brida);
		em.persist(valkirias);
		em.persist(maao);

		Livro capitaes = geraLivro("978-8-50-831169-1", "Capitaes da Areia",
				"01/01/1937", 6.90);
		Livro flor = geraLivro("978-8-53-592569-9",
				"Dona Flor e Seus Dois Maridos", "01/01/1966", 18.90);

		em.persist(capitaes);
		em.persist(flor);

		em.getTransaction().commit();
		em.close();

	}


	private static Livro geraLivro(String isbn, String titulo, String data,
			double preco) {
		Livro livro = new Livro();
		livro.setIsbn(isbn);
		livro.setTitulo(titulo);
		livro.setDataLancamento(data);
		livro.setPreco(preco);
		return livro;
	}

	@SuppressWarnings("unused")
	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

}

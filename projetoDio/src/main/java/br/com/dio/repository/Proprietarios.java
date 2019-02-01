package br.com.dio.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dio.model.Proprietario;

public class Proprietarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Proprietarios() {

	}

	public Proprietarios(EntityManager manager) {
		this.manager = manager;
	}
	
	public Proprietario porId(Long id) {
		return manager.find(Proprietario.class, id);
	}

	public List<Proprietario> pesquisar(String nome) {
		String jpql = "from Proprietario where descricao like :nome";
		
		TypedQuery<Proprietario> query = manager
				.createQuery(jpql, Proprietario.class);
		
		query.setParameter("nome", nome + "%");
		
		return query.getResultList();
	}

	public Proprietario guardar(Proprietario proprietario) {
		return manager.merge(proprietario);
	}

	public void remover(Proprietario proprietario) {
		proprietario = porId(proprietario.getId());
		manager.remove(proprietario);
	}

}

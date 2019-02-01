package br.com.dio.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dio.model.Proprietario;
import br.com.dio.model.Veiculo;

public class Veiculos implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Veiculos() {

	}

	public Veiculos(EntityManager manager) {
		this.manager = manager;
	}
	
	public Veiculo porId(Long id) {
		return manager.find(Veiculo.class, id);
	}
	
	public List<Veiculo> pesquisar(String placa) {
		String jpql = "from Veiculo where descricao like :placa";
		
		TypedQuery<Veiculo> query = manager
				.createQuery(jpql, Veiculo.class);
		
		query.setParameter("placa", placa + "%");
		
		return query.getResultList();
	}
	
	public Veiculo guardar(Veiculo veiculo) {
		return manager.merge(veiculo);
	}

	public void remover(Veiculo veiculo) {
		veiculo = porId(veiculo.getId());
		manager.remove(veiculo);
	}

}

package br.com.dio.daohibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.dio.dao.ProprietarioDAO;
import br.com.dio.model.Proprietario;

public class ProprietarioDAOHibernate implements ProprietarioDAO{
	
	//@Inject
	//private EntityManager manager;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void salvarProprietario(Proprietario proprietario) {
		abrirConexao();
		entityManager.merge(proprietario);
		fecharConexao();
	}
	
	public List<Proprietario> listarProprietario() {
		abrirConexao();
		List<Proprietario> proprietarioList;
		proprietarioList = entityManager.createQuery("from Proprietario", Proprietario.class).getResultList();
		fecharConexao();
		
		return proprietarioList;
   }
	
	public List<Proprietario> pesquisarProprietario(String nome) {
		abrirConexao();
		String jpql = "from Proprietario where nome like :nome";
		
		TypedQuery<Proprietario> query = entityManager
				.createQuery(jpql, Proprietario.class);
		query.setParameter("nome", nome + "%");
		
		List<Proprietario> proprietarioList = query.getResultList();
		fecharConexao();
		
		return proprietarioList;
	}
	
	public void excluirProprietario(Proprietario proprietario) {
		abrirConexao();
		proprietario = pesquisarProprietarioId(proprietario.getId(), entityManager);
		entityManager.remove(proprietario);
		fecharConexao();
	}
	
	public Proprietario pesquisarProprietarioId(Long id, EntityManager em) {
		return em.find(Proprietario.class, id);
	}
	
	public void abrirConexao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceDio");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	public void fecharConexao() {
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}

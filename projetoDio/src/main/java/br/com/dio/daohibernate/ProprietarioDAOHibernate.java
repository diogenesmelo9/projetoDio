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

	public void salvarProprietario(Proprietario proprietario) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDio");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(proprietario);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public List<Proprietario> listarProprietario() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDio");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Proprietario> proprietarioList;
		proprietarioList = em.createQuery("from Proprietario", Proprietario.class).getResultList();
        
        em.getTransaction().commit();
		em.close();
		emf.close();
		
		return proprietarioList;
   }
	
	public List<Proprietario> pesquisarProprietario(String nome) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDio");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		String jpql = "from Proprietario where nome like :nome";
		
		TypedQuery<Proprietario> query = em
				.createQuery(jpql, Proprietario.class);
		
		query.setParameter("nome", nome + "%");
		
		List<Proprietario> proprietarioList;
		proprietarioList = query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return proprietarioList;
	}
	
	public void excluirProprietario(Proprietario proprietario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDio");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		proprietario = pesquisarProprietarioId(proprietario.getId(), em);
		em.remove(proprietario);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public Proprietario pesquisarProprietarioId(Long id, EntityManager em) {
		return em.find(Proprietario.class, id);
	}

}

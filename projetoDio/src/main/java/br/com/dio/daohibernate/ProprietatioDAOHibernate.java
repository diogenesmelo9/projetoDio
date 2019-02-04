package br.com.dio.daohibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.dio.dao.ProprietarioDAO;
import br.com.dio.model.Proprietario;

public class ProprietatioDAOHibernate implements ProprietarioDAO{
	
	//@Inject
	//private EntityManager manager;

	public void save(Proprietario proprietario) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDio");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(proprietario);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public List<Proprietario> listarTodosProprietarios() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDio");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Proprietario> proprietarioList;
		proprietarioList = em.createQuery("from Proprietario", Proprietario.class).getResultList();
        
        em.getTransaction().commit();
		em.close();
		emf.close();
		
		return proprietarioList;
		
		/*Proprietario proprietario1 = new Proprietario();
		proprietario1.setId(1l);
		proprietario1.setNome("nome");
		proprietario1.setSobreNome("sobreNome");
		
		List<Proprietario> proprietarioList = new ArrayList<Proprietario>();
		proprietarioList.add(proprietario1);
		
		return proprietarioList;*/
   }
	
	public List<Proprietario> pesquisar(String nome) {
		
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

}

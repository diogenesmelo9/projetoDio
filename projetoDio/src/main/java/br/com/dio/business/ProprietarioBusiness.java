package br.com.dio.business;

import java.util.List;

import br.com.dio.daohibernate.ProprietatioDAOHibernate;
import br.com.dio.model.Proprietario;

public class ProprietarioBusiness {
	
	//@Inject
	private ProprietatioDAOHibernate proprietatioDAOHibernate;
	
	public ProprietarioBusiness(){
		
	}
	
	//@Transacional
	public void save(Proprietario proprietario) {
		proprietatioDAOHibernate = new ProprietatioDAOHibernate();
		proprietatioDAOHibernate.save(proprietario);
	}
	
	public List<Proprietario> listarTodosProprietarios() {
		proprietatioDAOHibernate = new ProprietatioDAOHibernate();
		return proprietatioDAOHibernate.listarTodosProprietarios();
	}
	
	public List<Proprietario> pesquisar(String nome) {
		proprietatioDAOHibernate = new ProprietatioDAOHibernate();
		return proprietatioDAOHibernate.pesquisar(nome);
	}
	
	public void excluir(Proprietario proprietario) {
		proprietatioDAOHibernate = new ProprietatioDAOHibernate();
		proprietatioDAOHibernate.excluir(proprietario);
	}

}

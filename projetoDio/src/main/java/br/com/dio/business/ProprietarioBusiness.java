package br.com.dio.business;

import java.util.List;

import br.com.dio.daohibernate.ProprietarioDAOHibernate;
import br.com.dio.model.Proprietario;

public class ProprietarioBusiness {
	
	//@Inject
	private ProprietarioDAOHibernate proprietatioDAOHibernate = new ProprietarioDAOHibernate();
	
	public ProprietarioBusiness(){
		
	}
	
	//@Transacional
	public void salvar(Proprietario proprietario) {
		proprietatioDAOHibernate.salvarProprietario(proprietario);
	}
	
	public List<Proprietario> listarTodosProprietarios() {
		return proprietatioDAOHibernate.listarProprietario();
	}
	
	public List<Proprietario> pesquisar(String nome) {
		return proprietatioDAOHibernate.pesquisarProprietario(nome);
	}
	
	public void excluir(Proprietario proprietario) {
		proprietatioDAOHibernate.excluirProprietario(proprietario);
	}

}

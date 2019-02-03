package br.com.dio.business;

import java.util.List;

import br.com.dio.daohibernate.ProprietatioDAOHibernate;
import br.com.dio.model.Proprietario;
import br.com.dio.model.Veiculo;

public class ProprietarioBusiness {
	
	//@Inject
	private ProprietatioDAOHibernate proprietatioDAOHibernate;
	
	public ProprietarioBusiness(){
		
	}
	
	//@Transacional
	public void save(Proprietario proprietario) {
		proprietario.setSobreNome("sobreNome");
		Veiculo veiculo = new Veiculo();
		veiculo.setId(1L);
		veiculo.setCor("azul");
		veiculo.setPlaca("saas-121");
		//proprietario.setVeiculo(veiculo);
		proprietatioDAOHibernate = new ProprietatioDAOHibernate();
		proprietatioDAOHibernate.save(proprietario);
	}
	
	public List<Proprietario> listarTodosProprietarios() {
		proprietatioDAOHibernate = new ProprietatioDAOHibernate();
		return proprietatioDAOHibernate.listarTodosProprietarios();
	}

}

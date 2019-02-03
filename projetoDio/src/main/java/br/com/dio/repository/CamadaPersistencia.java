package br.com.dio.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dio.model.Empresa;
import br.com.dio.model.RamoAtividade;
import br.com.dio.model.TipoEmpresa;

public class CamadaPersistencia {
	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDio");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Declarando os repositórios
		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);
		
		//Buscando as informações do banco
		//List<RamoAtividade> listaDeRamoAtividades = ramoAtividades.pesquisar("");
		List<Empresa> listaDeEmpresas = empresas.pesquisar("");
		System.out.println(listaDeEmpresas);
		
		//Criando uma empresa
		Empresa empresa = new Empresa();		
		empresa.setDescricao("aaaaaaa");
		empresa.setCnpj("41.952.519/0001-57");
		empresa.setRazaoSocial("João da Silva 41952519000157");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		
		RamoAtividade ramoAtividade3 = new RamoAtividade();
		ramoAtividade3.setId(1l);
		ramoAtividade3.setdescricao("top");
		empresa.setRamoAtividade(ramoAtividade3);
		
		//Salvando a empresa
		empresas.guardar(empresa);
		
		em.getTransaction().commit();
		
		//Verificando se a inserção funcionou
		List<Empresa> listaDeEmpresas2 = empresas.pesquisar("");
		System.out.println(listaDeEmpresas2);
		
		
		em.close();
		emf.close();
	}

}
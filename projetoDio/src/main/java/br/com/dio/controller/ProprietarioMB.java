package br.com.dio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import br.com.dio.business.ProprietarioBusiness;
import br.com.dio.model.Proprietario;

@Named
@ViewScoped
public class ProprietarioMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ProprietarioMB () {
		proprietario = new Proprietario();
		//proprietarioBusiness = new ProprietarioBusiness();
	}

	//@Inject
	private Proprietario proprietario;

	private List<Proprietario> listaProprietarios;

	//@Inject
	private ProprietarioBusiness proprietarioBusiness = new ProprietarioBusiness();
	
	private String termoPesquisa;
	
	//@Inject
    //private FacesMessages messages;
	
	public void salvar() {
		proprietarioBusiness = new ProprietarioBusiness();
		proprietarioBusiness.save(proprietario);
		listarTodosProprietarios();
	}

	public void listarTodosProprietarios() {
		listaProprietarios = proprietarioBusiness.listarTodosProprietarios();
	}

	public List<Proprietario> getListaProprietarios() {
		return listaProprietarios;
	}
	
	public void pesquisar() {
		listaProprietarios = proprietarioBusiness.pesquisar(termoPesquisa);

		if (listaProprietarios.isEmpty()) {
			//messages.info("Sua consulta não retornou registros.");
		}
	}
	
	public void excluir(){
		System.out.println(proprietario);
	}
	
	public String ajuda() {
		return "ajuda?faces-redirect=true";
	}
	
	public void prepararNovaProprietario() {
		proprietario = new Proprietario();
    }
	
	public boolean isProprietarioSelecionado() {
        return proprietario != null && proprietario.getId() != null;
    }

	/*Gets and Sets*/
	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
}

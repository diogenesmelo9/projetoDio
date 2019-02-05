package br.com.dio.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.dio.business.ProprietarioBusiness;
import br.com.dio.model.Proprietario;
import br.com.dio.util.FacesMessages;

@Named
@ViewScoped
public class ProprietarioMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ProprietarioMB () {
	}

	//@Inject
	private Proprietario proprietario = new Proprietario();
	
	//@Inject
	private ProprietarioBusiness proprietarioBusiness = new ProprietarioBusiness();
	
	private FacesMessages mensagem =  new FacesMessages();

	private List<Proprietario> listaProprietarios;

	private String termoPesquisa;
	
	public void salvar() {
		proprietarioBusiness.salvar(proprietario);
		listarTodosProprietarios();
		mensagem.info("Proprietário salvo com sucesso.");
		RequestContext.getCurrentInstance().update(Arrays.asList(
                "frm:proprietarioDataTable", "frm:messages"));
	}

	public void listarTodosProprietarios() {
		listaProprietarios = proprietarioBusiness.listarTodosProprietarios();
	}
	
	public void pesquisar() {
		listaProprietarios = proprietarioBusiness.pesquisar(termoPesquisa);
		if (listaProprietarios.isEmpty()) {
			mensagem.info("Sua consulta não retornou registros.");
			RequestContext.getCurrentInstance().update(Arrays.asList(
	                "frm:proprietarioDataTable", "frm:messages"));
		}
	}
	
	public void excluir(Proprietario proprietario){
		proprietarioBusiness.excluir(proprietario);
		listarTodosProprietarios();
		mensagem.info("Proprietário excluído com sucesso.");
		RequestContext.getCurrentInstance().update(Arrays.asList(
                "frm:proprietarioDataTable", "frm:messages"));
	}
	
	public String ajuda() {
		return "ajuda?faces-redirect=true";
	}
	
	public void prepararNovaProprietario() {
		proprietario = new Proprietario();
    }

	/*Gets and Sets*/
	public List<Proprietario> getListaProprietarios() {
		return listaProprietarios;
	}
	
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

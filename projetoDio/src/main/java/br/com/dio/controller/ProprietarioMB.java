package br.com.dio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.dio.business.ProprietarioBusiness;
import br.com.dio.model.Proprietario;

@Named
@ViewScoped
public class ProprietarioMB implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //@Inject
    private Proprietario proprietario = new Proprietario();
    
    private List<Proprietario> listaProprietarios;
    
    private ProprietarioBusiness proprietarioBusiness;
    
    
    public void salvar() {
    	proprietarioBusiness = new ProprietarioBusiness();
    	//proprietarioBusiness.save(proprietario);
        System.out.println("Nome: " + proprietario.getNome());
    }
    
    public String ajuda() {
    	return "ajuda?faces-redirect=true";
    }

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	public void listarTodosProprietarios() {
		proprietarioBusiness = new ProprietarioBusiness();
		listaProprietarios = proprietarioBusiness.listarTodosProprietarios();
    }
	
	public List<Proprietario> getListaProprietarios() {
        return listaProprietarios;
    }
	
}

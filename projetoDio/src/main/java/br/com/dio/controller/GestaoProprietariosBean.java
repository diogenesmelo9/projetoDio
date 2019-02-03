package br.com.dio.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.dio.model.Proprietario;

@Named
@ViewScoped
public class GestaoProprietariosBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Proprietario proprietario = new Proprietario();
	
	int g = 1;
	    
	   public void salvar() {
	        System.out.println("Razão social: " + proprietario.getNome());
	    }
	    
	    /*public String ajuda() {
	        return "trur";
	    }
	    
	    
	    /*public Empresa getEmpresa() {
	        return empresa;
	    }
	    
	    public TipoEmpresa[] getTiposEmpresa() {
	        return TipoEmpresa.values();
	    }*/

}

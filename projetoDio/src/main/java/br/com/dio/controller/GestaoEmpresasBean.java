package br.com.dio.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.dio.model.Empresa;

@Named("gestaoEmpresasBean")
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    Empresa empresa = new Empresa();
    
    
    public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
    
    public void salvar() {
        System.out.println("Razão social: " + empresa.getRazaoSocial());
    }
    
    
}
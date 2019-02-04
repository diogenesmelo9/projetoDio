package br.com.dio.dao;

import java.util.List;

import br.com.dio.model.Proprietario;

public interface ProprietarioDAO {
	
	public void salvarProprietario(Proprietario proprietario);
	
	public List<Proprietario> listarProprietario();
	
	public List<Proprietario> pesquisarProprietario(String nome);
	
	public void excluirProprietario(Proprietario proprietario);

}

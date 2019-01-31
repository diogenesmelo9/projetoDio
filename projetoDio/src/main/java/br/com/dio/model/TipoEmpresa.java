package br.com.dio.model;

public enum TipoEmpresa {
	
	MEI("Microempreendedor"),
	LTDA("Sociedade Limitada");
	
	private TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

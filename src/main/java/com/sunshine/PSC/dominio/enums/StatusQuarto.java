package com.sunshine.PSC.dominio.enums;

public enum StatusQuarto {

	disponivel(1,"disponível"),
	indisponivel(2,"indisponível");
	
	private int cod;
	private String descricao;
	
	private StatusQuarto(int cod , String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	public String getDescricao(){
		return descricao;
	}
	
	public static StatusQuarto toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		
		for(StatusQuarto x :StatusQuarto.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id invalido" + cod);
	}
}

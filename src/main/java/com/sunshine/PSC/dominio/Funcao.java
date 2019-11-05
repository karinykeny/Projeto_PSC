package com.sunshine.PSC.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import org.springframework.security.core.GrantedAuthority;

@Entity
public class Funcao implements GrantedAuthority  {


	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Descricao;
	
	@ManyToMany(mappedBy="funcoes")
	private List<Cliente> clientes;

	/*
	@ManyToMany
	private List<Funcionario> funcionarios;
*/
	
	public Funcao(){
	
	
	}
	public Funcao (String descricao) {
		this.Descricao = descricao;
	}
	
	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String getAuthority() {
		
		return this.Descricao;
	}
	
	

}

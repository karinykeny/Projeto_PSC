package com.sunshine.PSC.dominio;

import javax.persistence.Entity;

import com.sunshine.PSC.dominio.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer numeroDeParcelas;
	private Integer numeroCartão;

	public PagamentoComCartao() {

	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Reserva reserva, Integer numeroDeParcelas,
			Integer numeroCartao, String nome) {
		super(id, estado, reserva);
		this.numeroCartão = numeroCartao;
		this.numeroDeParcelas = numeroDeParcelas;
		this.nome = nome;

	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroCartão() {
		return numeroCartão;
	}

	public void setNumeroCartão(Integer numeroCartão) {
		this.numeroCartão = numeroCartão;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

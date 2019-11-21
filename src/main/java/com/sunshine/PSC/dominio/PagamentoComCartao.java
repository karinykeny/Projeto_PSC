package com.sunshine.PSC.dominio;

import com.sunshine.PSC.dominio.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;
	private Integer numeroCartão;

	public PagamentoComCartao() {

	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Reserva reserva, Integer numeroDeParcelas,
			Integer numeroCartao) {
		super(id, estado, reserva);
		this.numeroCartão = numeroCartao;
		this.numeroDeParcelas = numeroDeParcelas;

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

}

package com.sunshine.PSC.dominio;

import java.util.Date;

import com.sunshine.PSC.dominio.enums.EstadoPagamento;

public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	
	private Date dataVencimento;
	private Date dataPagamento;
	private Integer NumeroDoBoleto;

	public PagamentoComBoleto() {

	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Reserva reserva, Date dataVencimento,
			Date dataPagamento, Integer numeroBoleto) {
		super(id, estado, reserva);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		this.NumeroDoBoleto = NumeroDoBoleto;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Integer getNumeroDoBoleto() {
		return NumeroDoBoleto;
	}

	public void setNumeroDoBoleto(Integer numeroDoBoleto) {
		NumeroDoBoleto = numeroDoBoleto;
	}

}

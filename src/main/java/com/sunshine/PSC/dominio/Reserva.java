package com.sunshine.PSC.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer nPessoas;

	// @DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate dataEntrada;

	// @DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate dataSaida;

	private Double precoDiaria;

	private Double total;

	private String dataEntradaTemp;
	private String dataSaidaTemp;

	@ManyToMany
	@JoinTable(name = "RESERVA_QUARTOS", joinColumns = @JoinColumn(name = "reserva_id"), inverseJoinColumns = @JoinColumn(name = "quarto_id"))
	private List<Quarto> quartos = new ArrayList<>();

	@JsonIgnore
	@ManyToOne (cascade= {CascadeType.MERGE, CascadeType.ALL})
	private Cliente cliente;

	@JsonIgnore
	@ManyToOne (cascade= {CascadeType.MERGE, CascadeType.ALL})
	private Funcionario funcionario;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "reserva")
	private Pagamento pagamento;

	public Reserva() {

	}

	public Reserva(Integer id, Integer nPessoas, LocalDate dataEntrada, LocalDate dataSaida, Double precoDiaria,
			Double total) {
		super();
		this.id = id;
		this.nPessoas = nPessoas;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.precoDiaria = precoDiaria;
		this.total = precoDiaria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getnPessoas() {
		return nPessoas;
	}

	public void setnPessoas(Integer nPessoas) {
		this.nPessoas = nPessoas;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getDataEntradaTemp() {
		return dataEntradaTemp;
	}

	public void setDataEntradaTemp(String dataEntradaTemp) {
		this.dataEntradaTemp = dataEntradaTemp;
	}

	public String getDataSaidaTemp() {
		return dataSaidaTemp;
	}

	public void setDataSaidaTemp(String dataSaidaTemp) {
		this.dataSaidaTemp = dataSaidaTemp;
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(Double precoDiaria) {
		this.precoDiaria = precoDiaria;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
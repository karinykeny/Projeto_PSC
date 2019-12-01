package com.sunshine.PSC.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sunshine.PSC.dominio.enums.StatusQuarto;

@Entity
public class Quarto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "O nome do quarto é obrigatório.")
	@Size(min = 3, max = 50, message = "O nome do quarto deve ter entre {min} e {max} caracteres")
	private String nomeQuarto;
	@NumberFormat
	private Integer qtdPessoas;
	@NotBlank(message = "É necessário informar o tipo de cama do quarto")
	private String tipoDeCama;
	private Integer status;
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal diaria;

	public Quarto() {

	}

	public Quarto(String nomeQuarto, Integer qtdPessoas, String tipoDeCama, StatusQuarto status, BigDecimal diaria) {
		super();

		this.nomeQuarto = nomeQuarto;
		this.qtdPessoas = qtdPessoas;
		this.tipoDeCama = tipoDeCama;
		this.status = (status == null) ? null : status.getCod();
		this.diaria = diaria;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeQuarto() {
		return nomeQuarto;
	}

	public void setNomeQuarto(String nomeQuarto) {
		this.nomeQuarto = nomeQuarto;
	}

	public Integer getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public StatusQuarto getStatus() {
		return StatusQuarto.toEnum(status);
	}

	public String getTipoDeCama() {
		return tipoDeCama;
	}

	public void setTipoDeCama(String tipoDeCama) {
		this.tipoDeCama = tipoDeCama;
	}

	public void setStatus(StatusQuarto status) {
		this.status = status.getCod();
	}

	public BigDecimal getDiaria() {
		return diaria;
	}

	public void setDiaria(BigDecimal diaria) {
		this.diaria = diaria;
	}

	public BigDecimal calcularDiaria(Long dias) {
		return this.diaria.multiply(new BigDecimal(dias)).setScale(2, RoundingMode.HALF_EVEN);
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
		Quarto other = (Quarto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quarto [id=" + id + ", nomeQuarto=" + nomeQuarto + ", qtdPessoas=" + qtdPessoas + "]";
	}

}

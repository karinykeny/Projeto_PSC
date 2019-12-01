package com.sunshine.PSC.dominio;

import java.io.Serializable;
import java.time.LocalDate;

public class Reservado implements Serializable {

	private static final long serialVersionUID = 4535591477617028111L;
	private LocalDate entrada;
	private LocalDate saida;

	public Reservado(LocalDate entrada, LocalDate saida) {
		this.entrada = entrada;
		this.saida = saida;
	}

	/**
	 * Verifica disponibilidade para reserva
	 * 
	 * @param entrar ref. a data de entrada da reserva 
	 * @param sair ref. a data de saida da reserva 
	 * @return verdadeiro se disponivel
	 */
	public boolean isDisponivel(LocalDate entrar, LocalDate sair) {
		if (entrar.isBefore(entrada) && (sair.isBefore(entrada) || sair.isEqual(entrada))) {
			return true;
		}
		if (entrar.isEqual(saida) || entrar.isAfter(saida)) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
		result = prime * result + ((saida == null) ? 0 : saida.hashCode());
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
		Reservado other = (Reservado) obj;
		if (entrada == null) {
			if (other.entrada != null)
				return false;
		} else if (!entrada.equals(other.entrada))
			return false;
		if (saida == null) {
			if (other.saida != null)
				return false;
		} else if (!saida.equals(other.saida))
			return false;
		return true;
	}

}

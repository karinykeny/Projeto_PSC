
package com.sunshine.PSC.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.sunshine.PSC.dao.ReservaDao;
import com.sunshine.PSC.dominio.Reserva;
import com.sunshine.PSC.service.exception.DateInvalidException;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;

import ch.qos.logback.core.joran.conditional.ElseAction;

@Service
public class ReservaService {

	@Autowired
	private ReservaDao dao;

	public List<Reserva> findAll() {
		return dao.findAll();
	}

	public Reserva findById(int Id) throws ObjectNotFoundException {

		Optional<Reserva> reserva = dao.findById(Id);

		return reserva.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encontrado! Id: " + Id + ",tipo: " + Reserva.class.getName()));
	}

	public Reserva updateReserva(Reserva reserva) throws ObjectNotFoundException {
		findById(reserva.getId());
		return dao.save(reserva);
	}

	public void deleteReserva(Reserva reserva) throws ObjectNotFoundException {
		findById(reserva.getId());
		dao.delete(reserva);
	}

	public boolean reservaTemCliente(Integer id) {
		if (findById(id).getCliente() == null) {
			return false;
		}
		return true;
	}

	public Reserva calcularTotal(Reserva reserva) {
		/*
		 * Period periodo; Integer totalDias = (Period.between(reserva.getDataEntrada(),
		 * reserva.getDataSaida()).getYears() * 365) +
		 * (Period.between(reserva.getDataEntrada(), reserva.getDataSaida()).getMonths()
		 * * 30) + (Period.between(reserva.getDataEntrada(),
		 * reserva.getDataSaida()).getDays()); reserva.setTotal((Double) (totalDias *
		 * reserva.getPrecoDiaria()));
		 */
		long response = ChronoUnit.DAYS.between(reserva.getDataEntrada(), reserva.getDataSaida());
		reserva.setTotal((Double) (response * reserva.getPrecoDiaria()));
		return reserva;
	}

	public boolean verificaPeriodo(Reserva reserva) {

		if (reserva.getDataEntrada().isBefore(reserva.getDataSaida())
				&& (reserva.getDataSaida().compareTo(reserva.getDataEntrada()) >= 0
						&& reserva.getDataEntrada().compareTo(LocalDate.now()) >= 0
						&& reserva.getDataSaida().compareTo(LocalDate.now()) >= 0)) {

			return true;
		}

		return false;

	}

	public Reserva save(Reserva reserva) {
		reserva.setId(null);

		calcularTotal(reserva);
		return dao.save(reserva);

	}
}

package com.sunshine.PSC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.PSC.dao.ReservaDao;
import com.sunshine.PSC.dominio.Reserva;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;

@Service
public class ReservaService {

	@Autowired
	private ReservaDao dao;

	public Reserva save(Reserva reserva) {
		reserva.setId(null);
		return dao.save(reserva);
	}

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

}

package com.sunshine.PSC.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.PSC.dao.ReservaDao;
import com.sunshine.PSC.dominio.Reserva;
import com.sunshine.PSC.dominio.Reservado;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;

@Service
public class ReservaService {

	@Autowired
	private ReservaDao dao;

	@Transactional
	public Reserva save(Reserva reserva) {
		List<Reserva> reservas = dao.findAll();
		Optional<Reserva> quarto = reservas.stream().filter(r -> {
			Reservado reservado = new Reservado(r.getDataEntrada(), r.getDataSaida());
			return !reservado.isDisponivel(reserva.getDataEntrada(), reserva.getDataSaida());
		}).findFirst();

		if (quarto.isEmpty()) {
			System.out.println("salvamos a reserva :)");
			return dao.save(reserva);
		}
		
		return reserva;
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

	public boolean reservaTemCliente(Integer id) {
		if (findById(id).getCliente() == null) {
			return false;
		}
		return true;
	}

}

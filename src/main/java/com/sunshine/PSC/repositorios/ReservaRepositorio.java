package com.sunshine.PSC.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Reserva;


@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {

}

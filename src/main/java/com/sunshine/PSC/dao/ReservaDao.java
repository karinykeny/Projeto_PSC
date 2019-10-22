package com.sunshine.PSC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Reserva;

@Repository
public interface ReservaDao extends JpaRepository<Reserva, Integer>{

}

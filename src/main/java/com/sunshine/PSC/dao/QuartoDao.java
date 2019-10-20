package com.sunshine.PSC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Quarto;

@Repository
//@Transactional
public interface QuartoDao extends JpaRepository<Quarto, Integer> {

}

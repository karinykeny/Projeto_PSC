package com.sunshine.PSC.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Quarto;


@Repository
public interface QuartoRepositorio extends JpaRepository<Quarto, Integer> {

}

package com.sunshine.PSC.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunshine.PSC.dominio.Quarto;

@Repository
//@Transactional
public interface QuartoDao extends JpaRepository<Quarto, Integer> {

}

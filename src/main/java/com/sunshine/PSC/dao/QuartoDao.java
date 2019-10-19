package com.sunshine.PSC.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunshine.PSC.dominio.Quarto;

@Repository
@Transactional
public class QuartoDao {

	@PersistenceContext
	private EntityManager manager;
	
	

	public void create(Quarto quarto) {
		
		manager.persist(quarto);
	}
}

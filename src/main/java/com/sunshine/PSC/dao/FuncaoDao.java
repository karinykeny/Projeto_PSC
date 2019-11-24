package com.sunshine.PSC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Funcao;

@Repository
public interface FuncaoDao extends JpaRepository<Funcao, String>{

	
}

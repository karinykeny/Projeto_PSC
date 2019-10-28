package com.sunshine.PSC.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunshine.PSC.dominio.Funcionario;


@Repository
//@Transactional
public interface FuncionarioDao extends JpaRepository<Funcionario, Integer> {
    

	@Modifying
    @Transactional
	default
    void deleteById(Integer id) {

		
	}
}



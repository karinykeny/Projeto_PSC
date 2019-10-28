package com.sunshine.PSC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Funcionario;


@Repository
//@Transactional
public interface FuncionarioDao extends JpaRepository<Funcionario, Integer> {
    
}



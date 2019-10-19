package com.sunshine.PSC.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Funcionario;


@Repository
public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Integer> {

	
}

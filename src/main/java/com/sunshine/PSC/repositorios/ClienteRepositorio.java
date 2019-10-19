package com.sunshine.PSC.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
	
}

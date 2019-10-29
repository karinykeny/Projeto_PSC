package com.sunshine.PSC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Integer>{
	
	Cliente findByCpf(String cpf);
}

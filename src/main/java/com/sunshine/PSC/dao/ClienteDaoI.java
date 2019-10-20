package com.sunshine.PSC.dao;

import java.util.List;

import com.sunshine.PSC.dominio.Cliente;

public interface ClienteDaoI {
	
	void save(Cliente cliente );
    void update(Cliente cliente);
    void delete(Integer  id);
    Cliente findById(Integer id);
    List<Cliente> findAll();

}

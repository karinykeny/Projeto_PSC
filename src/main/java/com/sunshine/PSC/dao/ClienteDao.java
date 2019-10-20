package com.sunshine.PSC.dao;

import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Cliente;

@Repository
public class ClienteDao extends Dao<Cliente, Integer> implements ClienteDaoI{

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

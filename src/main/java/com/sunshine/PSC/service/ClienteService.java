package com.sunshine.PSC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.PSC.dao.ClienteDao;
import com.sunshine.PSC.dominio.Cliente;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao dao;

	public Cliente save(Cliente cliente) {
		cliente.setId(null);
		return dao.save(cliente);
	}

	public List<Cliente> findAll() {
		return dao.findAll();
	}

	public Cliente findById(int Id) throws ObjectNotFoundException {

		Optional<Cliente> cliente = dao.findById(Id);

		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encontrado! Id: " + Id + ",tipo: " + Cliente.class.getName()));
	}

	public Cliente updateCliente(Cliente cliente) throws ObjectNotFoundException {
		findById(cliente.getId());
		return dao.save(cliente);
	}

	public void deleteCliente(Cliente cliente) throws ObjectNotFoundException {
		findById(cliente.getId());
		dao.delete(cliente);
	}
	
	public boolean clienteTemReserva(int id) {
		if(findById(id).getReservas().isEmpty()) {
			return false;
		}		
		return true;
	}

}

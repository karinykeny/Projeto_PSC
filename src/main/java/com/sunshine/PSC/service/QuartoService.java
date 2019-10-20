package com.sunshine.PSC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.PSC.dao.QuartoDao;
import com.sunshine.PSC.dominio.Quarto;


import javassist.tools.rmi.ObjectNotFoundException;


@Service
public class QuartoService {

@Autowired
private QuartoDao dao;

	public Quarto save(Quarto quarto) {
		quarto.setId(null);
		return dao.save(quarto);
	}
	
	public List<Quarto> findAll() {
		return dao.findAll();
	}
	
	public Quarto findById(int Id) throws ObjectNotFoundException{
		
		Optional<Quarto> quarto = dao.findById(Id);
		
		return quarto.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encontrado! Id: " + Id + ",tipo: " + Quarto.class.getName()));
	}
	
	public Quarto updateQuarto(Quarto quarto) throws ObjectNotFoundException {
		findById(quarto.getId());
		return dao.save(quarto);
	}
	
}

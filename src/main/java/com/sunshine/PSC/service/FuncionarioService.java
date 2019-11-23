package com.sunshine.PSC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.PSC.dao.FuncionarioDao;
import com.sunshine.PSC.dominio.Funcionario;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioDao dao;
	
	public Funcionario save(Funcionario funcionario) {
		funcionario.setId(null);
		return dao.save(funcionario);
	}
	
	public void deleteFuncionario(Funcionario funcionario) throws ObjectNotFoundException {
		findById(funcionario.getId());
		dao.delete(funcionario);
	}
	
	public List<Funcionario> findAll() {
		return dao.findAll();
	}
		
public Funcionario findById(int Id) throws ObjectNotFoundException{
		
		Optional<Funcionario> funcionario = dao.findById(Id);
		
		return funcionario.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encontrado! Id: " + Id + ",tipo: " + Funcionario.class.getName()));
	}
	
public Funcionario updateFuncionario(Funcionario funcionario) throws ObjectNotFoundException {
	findById(funcionario.getId());
	return dao.save(funcionario);
}


	
}

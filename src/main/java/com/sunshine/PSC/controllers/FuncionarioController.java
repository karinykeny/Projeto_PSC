package com.sunshine.PSC.controllers;

import com.sunshine.PSC.dominio.Funcionario;
import com.sunshine.PSC.service.FuncionarioService;
import com.sunshine.PSC.dao.FuncionarioDao;

import javassist.tools.rmi.ObjectNotFoundException;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
	@RequestMapping(value="funcionario/form")
	public String form() {
		return "funcionario/form";
	}
	
	
	@RequestMapping(value="/Funcionario/create", method=RequestMethod.POST)
	public String create(Funcionario funcionario) {
		service.save(funcionario);
		return "funcionario/confirmacao";
	}
	
	
	@RequestMapping(value="/Funcionario/listar", method=RequestMethod.GET)
	public String findAll(ModelMap model) {
		model.addAttribute("funcionarios", service.findAll());
		return "funcionario/index";	}
	
	
	@RequestMapping(value="/Funcionario/buscarid", method=RequestMethod.GET)
	public Funcionario findById(int Id) throws ObjectNotFoundException {
		
		return service.findById(Id);
	}	
	
	
}

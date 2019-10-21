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

public class FuncionarioController {

	
}

/*package com.sunshine.PSC.controllers;


//====[IMPORTS RESUMIDOS]======



@Controller
public class QuartoController {

	@Autowired
	private QuartoService service;
	
	//@RequestMapping("quarto/form")
	@RequestMapping(value="quarto/form", method=RequestMethod.GET)
	public String form() {
		return "quarto/form";
	}
	//@RequestMapping("quarto/create")
	@RequestMapping(value="/Quarto/create", method=RequestMethod.POST)
	public String create(Quarto quarto) {
	
		service.save(quarto);
		return "quarto/confirmacao";
	}
	@RequestMapping(value="/Quarto/listar", method=RequestMethod.GET)
	public String findAll(ModelMap model) {
				
		model.addAttribute("quartos", service.findAll());
		return "quarto/index";	
	}
	@RequestMapping(value="/Quarto/buscarid", method=RequestMethod.GET)
	public Quarto findById(int Id) throws ObjectNotFoundException {
		
		return service.findById(Id);
	}
}

 */
package com.sunshine.PSC.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.sunshine.PSC.dominio.Funcionario;
import com.sunshine.PSC.service.FuncionarioService;



import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	

// ================= CHAMAR TELAS ==================	
	
	@GetMapping("/createFuncionarios")//cadastro de funcionario na area do adm 
	public String createFuncionarios(Funcionario funcionario) {   
		return "adm/createFuncionario";
	}

	@RequestMapping(value = "funcionario/deletar")
	public String formdeletar() {
		return "funcionario/deletar";
	}

	@RequestMapping(value = "funcionario/atualizar")
	public String formatualizar() {
		return "funcionario/atualizar";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionario", service.findAll());
		return "/adm/listFuncionarios";
	}
	
// ====================== METODOS ======================

	@PostMapping(value = "/seve")
	public String create(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr, ModelMap model) {
		if (result.hasErrors()) {
			return "adm/createFuncionario";
		}
		service.save(funcionario);
		attr.addFlashAttribute("success", "quarto cadastrado com sucesso!");
		model.addAttribute("funcionario", service.findAll());
		return "adm/listFuncionarios";

		
	}

	@GetMapping(value = "/listarFuncionarios")
	public String findAll(ModelMap model) {
		model.addAttribute("funcionarios", service.findAll());
		return "funcionario/listarFuncionarios";
	}

	@GetMapping("/buscarid")
	public Funcionario findById(int Id) throws ObjectNotFoundException {

		return service.findById(Id);
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("funcionario", service.findById(id));
		return "adm/editFuncionario";
		//return "funcionario/cadastrarFuncionarios";
	}
	


	@GetMapping("/deletar/{id}")
	public String deletarFuncionario(Funcionario funcionario, ModelMap model) throws ObjectNotFoundException {
		findById(funcionario.getId());
		service.deleteFuncionario(funcionario);
		model.addAttribute("funcionario", service.findAll());
		return "adm/listFuncionarios";
	}
	
	@PostMapping("/editar")
	public String updateFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr, ModelMap model) throws ObjectNotFoundException {
		if (result.hasErrors()) {
			return "adm/editFuncionario";
		}
		service.findById(funcionario.getId());
		service.updateFuncionario(funcionario);
		model.addAttribute("funcionario", service.findAll());
		return "adm/listFuncionarios";
	}

}

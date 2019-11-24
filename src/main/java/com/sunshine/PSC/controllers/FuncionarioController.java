package com.sunshine.PSC.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunshine.PSC.dominio.Cliente;
import com.sunshine.PSC.dominio.Funcionario;
import com.sunshine.PSC.service.FuncionarioService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

// ================= CHAMAR TELAS ==================	

	@GetMapping("/cadastrarFuncionarios")
	public String form(Funcionario funcionario) { //
	    
		return "funcionario/cadastrarFuncionarios";
	}
	
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
	
	@PostMapping("/seve")//inicio do cadastro de funcionário na area do adm
	public String seve(Funcionario funcionario) {
		service.save(funcionario);
		return "/adm/areaAdm";
	}

// ====================== METODOS ======================

	@PostMapping(value = "/create")
	public String create(Funcionario funcionario) {
		service.save(funcionario);
		return "funcionario/confirmacao";
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

	@GetMapping("/preupdate/{id}")
	public String preUpdate(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("funcionario", service.findById(id));

		return "funcionario/cadastrarFuncionarios";
	}

	@GetMapping("/deletar/{id}")
	public String deletarFuncionario(Funcionario funcionario, ModelMap model) throws ObjectNotFoundException {
		findById(funcionario.getId());
		service.deleteFuncionario(funcionario);
		model.addAttribute("funcionario", service.findAll());
		return "adm/listFuncionarios";
	}

	@PostMapping("/editar")
	public String updateFuncionario(Funcionario funcionario) throws ObjectNotFoundException {
		findById(funcionario.getId());
		service.updateFuncionario(funcionario);
		return "redirect:/funcionario/listarFuncionarios";
	}


}

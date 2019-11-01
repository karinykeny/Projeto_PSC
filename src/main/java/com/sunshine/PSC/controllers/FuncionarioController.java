package com.sunshine.PSC.controllers;

import com.sunshine.PSC.dominio.Funcionario;
import com.sunshine.PSC.dominio.Quarto;
import com.sunshine.PSC.service.FuncionarioService;
import com.sunshine.PSC.dao.FuncionarioDao;

import javassist.tools.rmi.ObjectNotFoundException;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
// ================= CHAMAR TELAS ==================	
	
	
	@GetMapping("/cadastrarFuncionarios")
	public String form(Funcionario funcionario) {

		return "funcionario/cadastrarFuncionarios";
	}
	
	@RequestMapping(value="funcionario/deletar")
	public String formdeletar() {
		return "funcionario/deletar";
	}
	
	@RequestMapping(value="funcionario/atualizar")
	public String formatualizar() {
		return "funcionario/atualizar";
	}
	
// ====================== METODOS ======================
	
	@PostMapping(value="/create")
	public String create(Funcionario funcionario) {
		service.save(funcionario);
		return "funcionario/confirmacao";
	}

	@GetMapping(value="/listarFuncionarios")
	public String findAll(ModelMap model) {
		model.addAttribute("funcionarios", service.findAll());
		return "funcionario/listarFuncionarios";	}
	
	
	
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
	public String deletarFuncionario(Funcionario funcionario) throws ObjectNotFoundException {
		findById(funcionario.getId());
		service.deleteFuncionario(funcionario);
		return "funcionario/confirmacao";
	}
	
	@PostMapping("/editar")
	public String updateFuncionario(Funcionario funcionario) throws ObjectNotFoundException {
		findById(funcionario.getId());
		service.updateFuncionario(funcionario);
		return "redirect:/funcionario/listarFuncionarios";
	}
	
	

	
	
	
}

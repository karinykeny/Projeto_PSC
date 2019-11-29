package com.sunshine.PSC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	// ================= CREATE ==================
	@GetMapping("/createFuncionarios") // cadastro de funcionario na area do adm
	public String createFuncionarios(Funcionario funcionario) {
		return "adm/createFuncionario";
	}
	
	@PostMapping("/seve") // inicio do cadastro de funcionário na area do adm
	public String seve(Funcionario funcionario, RedirectAttributes attr) {
		service.save(funcionario);
		attr.addFlashAttribute("success", "Funcionário cadastrado com sucesso.");
		return "redirect:/funcionario/listar";
	}

	// ================= UPDATE ==================
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("funcionario", service.findById(id));
		return "adm/editFuncionario";
	}

	@PostMapping("/edit")
	public String edit(Funcionario funcionario, RedirectAttributes attr) throws ObjectNotFoundException {
		service.findById(funcionario.getId());
		service.updateFuncionario(funcionario);
		attr.addFlashAttribute("success", "Funcionário alterado com sucesso.");
		return "redirect:/funcionario/listar";
	}

	// ================= DELETE ==================
	@GetMapping("/deletar/{id}")
	public String deletarFuncionario(Funcionario funcionario, ModelMap model) throws ObjectNotFoundException {
		service.findById(funcionario.getId());
		service.deleteFuncionario(funcionario);
		model.addAttribute("success", "Funcionário excluído com sucesso.");
		model.addAttribute("funcionario", service.findAll());
		return "adm/listFuncionarios";
	}

	// ================= LIST ====================
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionario", service.findAll());
		return "/adm/listFuncionarios";
	}

}

package com.sunshine.PSC.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunshine.PSC.dominio.Cliente;
import com.sunshine.PSC.dominio.Funcionario;
import com.sunshine.PSC.service.ClienteService;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;
import com.sunshine.PSC.validator.ClienteValidator;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.addValidators(new ClienteValidator());
	}

	// ================= CHAMAR TELAS ==================
	@GetMapping("/cadastrar")
	public String cadastar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
		return "/cliente/cadastrarCliente";
	}

	@GetMapping("/create")
	public String create(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
		return "/adm/createCliente";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", service.findAll());
		return "/adm/listClientes";
	}

	@GetMapping("/listaDeClientes")
	public String listaDeClientes(ModelMap model) {
		model.addAttribute("clientes", service.findAll());
		return "/adm/preReserva";
	}

	@GetMapping("/area")
	public String area() {
		return "/cliente/areaCliente";
	}

	@GetMapping("/dados/{id}")
	public String dados(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("cliente", service.findById(id));
		return "/cliente/dadosCliente";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("cliente", service.findById(id));
		return "/adm/editCliente";
	}

	// ================= DELETE ==================

	@GetMapping("/deletar/{id}")
	public String deletar(Cliente cliente, ModelMap model) throws ObjectNotFoundException {
		service.findById(cliente.getId());
		if (service.clienteTemReserva(cliente.getId())) {
			model.addAttribute("fail", "Este cliente não pode ser excluido,possui reserva(s) vinculada(s)");
		} else {
			service.deleteCliente(cliente);
			model.addAttribute("success", "Cliente exluido com sucesso");
		}
		model.addAttribute("clientes", service.findAll());
		return "adm/listClientes";
	}

	// ================= CREATE ==================

	@PostMapping("/salvar")
	public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr, ModelMap model) {
		if (result.hasErrors()) {
			return "adm/createCliente";
		}
		service.save(cliente);
		attr.addFlashAttribute("success", "cliente cadastrado com sucesso!");
		model.addAttribute("cliente", service.findAll());
		return "redirect:/clientes/listar";

	}

	@PostMapping("/seve")
	public String seve(Cliente cliente, BindingResult result, RedirectAttributes attr) {
		service.save(cliente);
		attr.addFlashAttribute("sucess", "Cliente inserido com sucesso");
		return "redirect:/clientes/listar";
	}

	// ================= UPDATE ==================

	@PostMapping("/editar")
	public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr, ModelMap model)
			throws ObjectNotFoundException {

		if (result.hasErrors()) {
			return "adm/editCliente";
		}
		service.findById(cliente.getId());
		service.updateCliente(cliente);
		model.addAttribute("cliente", service.findAll());
		return "redirect:/clientes/listar";
	}

}

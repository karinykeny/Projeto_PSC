package com.sunshine.PSC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunshine.PSC.dominio.Cliente;
import com.sunshine.PSC.service.ClienteService;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	// ================= CREATE ==================

	@GetMapping("/create") // Area do administrador
	public String create(Cliente cliente) {
		return "/adm/createCliente";
	}
	
	@PostMapping("/Salvar") // Area do cliente
	public String salvar(Cliente cliente, RedirectAttributes attr) {
		service.save(cliente);
		attr.addFlashAttribute("success", "Cadastrado realizado com sucesso.");
		return "/cliente/areaCliente";
	}

	@PostMapping("/seve") // Area do administrador
	public String seve(Cliente cliente, RedirectAttributes attr) {
		service.save(cliente);
		attr.addFlashAttribute("success", "Cliente cadastrado com sucesso.");
		return "redirect:/clientes/listar";
	}

	// ================= UPDATE ==================
	@GetMapping("/editar/{id}") // Area do cliente
	public String editar(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("cliente", service.findById(id));
		return "/cliente/editarCliente";
	}

	@GetMapping("/edit/{id}") // Area do administrador
	public String edit(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("cliente", service.findById(id));
		return "/adm/editCliente";
	}

	@PostMapping("/editar") // Area do cliente
	public String editar(Cliente cliente, RedirectAttributes attr) throws ObjectNotFoundException {
		service.findById(cliente.getId());
		service.updateCliente(cliente);
		attr.addFlashAttribute("success", "Cliente alterado com sucesso.");
		return "/cliente/areaCliente";
	}

	@PostMapping("/edit") // Area do administrador
	public String edit(Cliente cliente, RedirectAttributes attr) throws ObjectNotFoundException {
		service.findById(cliente.getId());
		service.updateCliente(cliente);
		attr.addFlashAttribute("success", "Cliente alterado com sucesso.");
		return "redirect:/clientes/listar";
	}

	// ================= DELETE ==================

	@GetMapping("/deletar/{id}") // Area do administrador
	public String deletar(Cliente cliente, ModelMap model) throws ObjectNotFoundException {
		service.findById(cliente.getId());
		if (service.clienteTemReserva(cliente.getId())) {
			model.addAttribute("fail", "Cliente não removido. Possui reserva(s) vonculada(s).");
		} else {
			service.deleteCliente(cliente);
			model.addAttribute("success", "Cliente excluído com sucesso.");
		}
		model.addAttribute("clientes", service.findAll());
		return "adm/listClientes";
	}

	// ================= LIST ====================
	@GetMapping("/listar") // Area do administrador
	public String listar(ModelMap model) {
		model.addAttribute("clientes", service.findAll());
		return "/adm/listClientes";
	}

	@GetMapping("/listaDeClientes") // Area do administrador (lista de clientes para reserva)
	public String listaDeClientes(ModelMap model) {
		model.addAttribute("clientes", service.findAll());
		return "/adm/preReserva";
	}

	// ================= Area do cliente =========
	@GetMapping("/area")
	public String area() {
		return "/cliente/areaCliente";
	}

	@GetMapping("/dados/{id}")
	public String dados(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("cliente", service.findById(id));
		return "/cliente/dadosCliente";
	}

}

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
import com.sunshine.PSC.dominio.Funcionario;
import com.sunshine.PSC.service.ClienteService;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	// ================= CHAMAR TELAS ==================
	@GetMapping("/cadastrar")
	public String cadastar(Cliente cliente) {
		return "/cliente/cadastrarCliente";
	}

	@GetMapping("/create")
	public String create(Cliente cliente) {
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

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("cliente", service.findById(id));
		return "/cliente/editarCliente";
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
			model.addAttribute("fail","Cliente não removido. Possui reserva(s) vonculada(s).");
		}else {
			service.deleteCliente(cliente);
			model.addAttribute("success","Cliente excluído com sucesso.");
		}
		model.addAttribute("clientes", service.findAll());
		return "adm/listClientes";
	}

	// ================= CREATE ==================

	@PostMapping("/Salvar")
	public String salvar(Cliente cliente, RedirectAttributes attr) {
		service.save(cliente);
		attr.addFlashAttribute("success","Cliente Cadastrado com sucesso.");
		return "/cliente/areaCliente";
	}

	@PostMapping("/seve")
	public String seve(Cliente cliente, RedirectAttributes attr) {
		service.save(cliente);
		attr.addFlashAttribute("success","Cliente Cadastrado com sucesso.");
		return "/adm/area";
	}

	// ================= UPDATE ==================

	@PostMapping("/editar")
	public String editar(Cliente cliente) throws ObjectNotFoundException {
		service.findById(cliente.getId());
		service.updateCliente(cliente);
		return "/cliente/areaCliente";
	}

	@PostMapping("/edit")
	public String edit(Cliente cliente) throws ObjectNotFoundException {
		service.findById(cliente.getId());
		service.updateCliente(cliente);
		return "/adm/areaAdm";
	}

}

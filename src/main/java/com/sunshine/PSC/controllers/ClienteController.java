package com.sunshine.PSC.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sunshine.PSC.dominio.Cliente;
import com.sunshine.PSC.dominio.Funcionario;
import com.sunshine.PSC.dominio.Reserva;
import com.sunshine.PSC.service.ClienteService;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;

import groovyjarjarpicocli.CommandLine.Model;

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
	public String preEditar(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("cliente", service.findById(id));
		return "/cliente/editarCliente";
	}
	
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("cliente", service.findById(id));
		return "/adm/editCliente";
	}

 // ================= DELETE ==================	
	
	@GetMapping("/deletar/{id}")
	public String deletar(Cliente cliente)throws ObjectNotFoundException{
		service.findById(cliente.getId());
			if(!service.clienteTemReserva(cliente.getId())) {
				service.deleteCliente(cliente);
			}
		return "/adm/areaAdm";
	}
	
 // ================= CREATE ==================	
	
	@PostMapping("/Salvar")
	public String salvar(Cliente cliente) {
		service.save(cliente);
		return "/cliente/areaCliente";
	}
	
	@PostMapping("/seve")
	public String seve(Cliente cliente) {
		service.save(cliente);
		return "/adm/areaAdm";
	}

 // ================= UPDATE ==================	
	
	@PostMapping("/editar")
	public String editar(Cliente cliente) throws ObjectNotFoundException {
		service.updateCliente(cliente);
		return "/cliente/areaCliente";
	}
	
	 @PostMapping("/edit")
	    public String edit(Cliente cliente) throws ObjectNotFoundException{
		 service.updateCliente(cliente);
			return "/adm/areaAdm";
	        }

}

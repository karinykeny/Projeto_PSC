package com.sunshine.PSC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunshine.PSC.dominio.Cliente;
import com.sunshine.PSC.service.ClienteService;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping("/cadastrar")
	public String cadastar() {
		return "/cliente/cadastrarCliente"; 
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", service.findAll());
		
		return "/cliente/listarClientes";
	}

	@GetMapping("/buscarid")
	public Cliente findById(int Id) throws ObjectNotFoundException {
		return service.findById(Id);
	}

	@GetMapping("/login")
	public String logar() {
		return "/cliente/loginCliente";
	}

	@PostMapping("/salvar")
	public String salvar(Cliente cliente) {
		String senha = new BCryptPasswordEncoder().encode(cliente.getSenha());
		cliente.setSenha(senha); 
		service.save(cliente);
		ModelMap model = new ModelMap();
		model.addAttribute("clientes",service.findAll());
		return "/cliente/listarClientes";
	}

	@RequestMapping("/deletarCliente")
	public ResponseEntity<Cliente> deletarCliente(Integer id) throws ObjectNotFoundException {
		service.deleteCliente(id);
		return ResponseEntity.noContent().build();

	}

}

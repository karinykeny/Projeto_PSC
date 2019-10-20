package com.sunshine.PSC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunshine.PSC.dao.ClienteDao;
import com.sunshine.PSC.dominio.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteDao cli;

	@GetMapping("/cadastrar")
	public String cadastar() {
		return "/cliente/cadastrarCliente";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/cliente/listarClientes";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cliente cliente){
		cli.save(cliente);
		return "/quarto/confirmacao";
	}
	

}

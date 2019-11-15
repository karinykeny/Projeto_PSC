package com.sunshine.PSC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/area")
	public String area() {
		return "/cliente/areaCliente";
	}

	@GetMapping("/buscarid/{id}")
	public Cliente findById(Integer Id) throws ObjectNotFoundException {
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
		model.addAttribute("clientes", service.findAll());
		return "/cliente/areaCliente";
	}

	@DeleteMapping("/{id}")
	// public ResponseEntity<Cliente> deletarCliente(@PathVariable("id") Integer id)
	// throws ObjectNotFoundException {
	public String deletarCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente)
			throws ObjectNotFoundException {
		service.deleteCliente(id);
		return "Cliente deletado";
		// return ResponseEntity.noContent().build();

	}

	@PutMapping("/updateCliente/{id}")
	public String updateCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		service.updateCliente(cliente);
		return "Cliente atualizado com sucesso";
	}

}

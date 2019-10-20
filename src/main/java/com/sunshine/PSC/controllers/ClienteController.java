package com.sunshine.PSC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	/*@Autowired
	private ClienteRepositorio er;*/

	@GetMapping("/cadastrar")
	public String cadastar() {
		return "/cliente/cadastrarCliente";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/cliente/listarClientes";
	}
	
/*
	@PostMapping("/cadastarCliente")
	public String form(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarClientes";
		}

		er.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
		return "redirect:/cadastrarClientes";
	}

	@RequestMapping("/clientes")
	public ModelAndView listaClientes() {
		ModelAndView mv = new ModelAndView("listaClientes");
		Iterable<Cliente> clientes = er.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("id") Integer id) {
		Optional<Cliente> cliente = er.findById(id);
		ModelAndView mv = new ModelAndView("cliente/cadastrarClientes");
		mv.addObject("cliente", cliente);
		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cliente obj, @PathVariable Integer id) {
		obj.setId(id);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		return ResponseEntity.noContent().build();
	}*/

}

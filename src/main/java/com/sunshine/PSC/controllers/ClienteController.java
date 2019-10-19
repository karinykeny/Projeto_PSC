package com.sunshine.PSC.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunshine.PSC.dominio.Cliente;
import com.sunshine.PSC.repositorios.ClienteRepositorio;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepositorio er;

	@RequestMapping(value = "/cadastarCliente", method = RequestMethod.GET)
	public String cliente() {
		return "cliente/cadastrarClientes";
	}

	@RequestMapping(method = RequestMethod.POST)
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
	}

}

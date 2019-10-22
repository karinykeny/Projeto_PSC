package com.sunshine.PSC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunshine.PSC.dominio.Quarto;
import com.sunshine.PSC.service.QuartoService;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;


@Controller
@RequestMapping("/quarto")
public class QuartoController {

	@Autowired
	private QuartoService service;

	// @RequestMapping("quarto/form")
	@RequestMapping(value = "quarto/form", method = RequestMethod.GET)

	public String form() {
		return "quarto/form";
	}

	// @RequestMapping("quarto/create")
	@RequestMapping(value = "/Quarto/create", method = RequestMethod.POST)

	// @RequestMapping("quarto/form")
	// @RequestMapping(value="quarto/form", method=RequestMethod.GET)
	@GetMapping("/cadastrarQuartos")
	public String form(Quarto quarto) {
		return "quarto/cadastrarQuartos";
	}

	// @RequestMapping("quarto/create")
	@PostMapping("/create")
	public String create(Quarto quarto) {

		service.save(quarto);
		return "quarto/confirmacao";
	}

	@RequestMapping(value = "/Quarto/listar", method = RequestMethod.GET)

	@GetMapping("/listarQuartos")

	public String findAll(ModelMap model) {

		model.addAttribute("quartos", service.findAll());

		return "quarto/index";
	}

	/*
	 * @RequestMapping(value="/Quarto/buscarid",method=RequestMethod.GET)
	 * 
	 * }
	 */

	@GetMapping("/buscarid")

	public Quarto findById(int Id) throws ObjectNotFoundException {

		return service.findById(Id);
	}

	@GetMapping("/preupdate/{id}")
	public String preUpdate(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("quarto", service.findById(id));

		return "quarto/cadastrarQuartos";
	}

	@PostMapping("/editar")
	public String updateQuarto(Quarto quarto) throws ObjectNotFoundException {
		findById(quarto.getId());
		service.updateQuarto(quarto);
		return "redirect:/quarto/listarQuartos";
	}

	@GetMapping("/deletar")
	public String deletarQuarto(Quarto quarto) throws ObjectNotFoundException {
		findById(quarto.getId());
		service.deleteQuarto(quarto);
		return "quarto/confirmacao";
	}
	/*
	 * @RequestMapping(value = "/{id}", method = RequestMethod.PUT) public
	 * ResponseEntity<Void> update(@RequestBody Cliente obj, @PathVariable Integer
	 * id) { obj.setId(id); obj = service.updateCliente(obj); return
	 * ResponseEntity.noContent().build();
	 */

}

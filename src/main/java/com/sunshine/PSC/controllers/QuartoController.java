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
import com.sunshine.PSC.dominio.Quarto;
import com.sunshine.PSC.service.QuartoService;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;
import com.sunshine.PSC.validator.QuartoValidator;

@Controller
@RequestMapping("/quarto")
public class QuartoController {

	@Autowired
	private QuartoService service;

	@InitBinder // Essa notação faz com que esse seja o primeiro método executado no controller
	public void initBinder(WebDataBinder binder) {
		// binder vai fornecer acesso ao validator

		binder.addValidators(new QuartoValidator());
	}

	@GetMapping("/cadastrarQuartos")
	public String form(Quarto quarto) {

		return "quarto/cadastrarQuartos";

	}
	
	@GetMapping("/create") //cadastro de quarto na area do adm
	public String createQuartos(Quarto quarto) {
		return "adm/createQuarto";

	}

	// @RequestMapping("quarto/create")
	@PostMapping("/create")
	public String create(@Valid Quarto quarto, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "quarto/cadastrarQuartos";
			//return "adm/createQuarto";
		}
		service.save(quarto);
		attr.addFlashAttribute("success", "quarto cadastrado com sucesso!");

		return "redirect:/quarto/listar";
	}

	@GetMapping("/listarQuartos")
	public String findAll(ModelMap model) {
		model.addAttribute("quartos", service.findAll());
		return "quarto/listarQuartos";
	}

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
	public String updateQuarto(@Valid Quarto quarto, BindingResult result, RedirectAttributes attr)
			throws ObjectNotFoundException {

		findById(quarto.getId());
		service.updateQuarto(quarto);

		if (result.hasErrors()) {
			return "quarto/cadastrarQuartos";
		}
		//return "redirect:/quarto/listarQuartos";
		return "redirect:listar";
	}

	@GetMapping("/deletar/{id}")
	public String deletarQuarto(Quarto quarto, ModelMap model ) throws ObjectNotFoundException {
		findById(quarto.getId());
		service.deleteQuarto(quarto);
		model.addAttribute("quartos", service.findAll());
		return "/adm/listQuartos";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("quartos", service.findAll());
		return "/adm/listQuartos";
	}

	/*@PostMapping("/seve") //inicio do cadastro de quarto na area do adm
	public String seve(Quarto quarto) {
		service.save(quarto);
		return "/adm/areaAdm";
	}*/
	
	/*@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("quarto", service.findById(id));
		return "/adm/editQuarto";
	}*/
	
	/*@PostMapping("/edit")
	public String edit(Quarto quarto) throws ObjectNotFoundException {
		findById(quarto.getId());
		service.updateQuarto(quarto);
		return "/adm/areaAdm";
	}*/

}

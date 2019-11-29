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
	
	// ================= CREATE ==================
	@GetMapping("/createrQuartos") //cadastro de quarto na area do adm
	public String createrQuartos(Quarto quarto) {
		return "adm/createQuarto";
	}
	
	@PostMapping("/seve") //inicio do cadastro de quarto na area do adm
	public String seve(Quarto quarto, RedirectAttributes attr) {
		service.save(quarto);
		attr.addFlashAttribute("success", "Quarto cadastrado com sucesso.");
		return "redirect:/quarto/listar";
	}
	
	// ================= UPDATE ==================
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("quarto", service.findById(id));
		return "/adm/editQuarto";
	}
	
	@PostMapping("/edit")
	public String edit(Quarto quarto, RedirectAttributes attr) throws ObjectNotFoundException {
		service.findById(quarto.getId());
		service.updateQuarto(quarto);
		attr.addFlashAttribute("success", "Quarto alterado com sucesso.");
		return "redirect:/quarto/listar";
	}
	
	// ================= DELETE ==================
	@GetMapping("/deletar/{id}")
	public String deletarQuarto(Quarto quarto, ModelMap model ) throws ObjectNotFoundException {
		service.findById(quarto.getId());
		if (service.quartoTemReserva(quarto.getId())){
			model.addAttribute("fail", "Quarto não removido. Possui reserva(s) vonculada(s).");
		} else {
			service.deleteQuarto(quarto);
			model.addAttribute("success", "Quarto excluído com sucesso.");
		}
		model.addAttribute("quartos", service.findAll());
		return "/adm/listQuartos";
	}
	
	// ================= LIST ====================
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("quartos", service.findAll());
		return "/adm/listQuartos";
	}

}

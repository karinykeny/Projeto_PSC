package com.sunshine.PSC.controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunshine.PSC.dominio.Pagamento;
import com.sunshine.PSC.dominio.Reserva;
import com.sunshine.PSC.service.ClienteService;
import com.sunshine.PSC.service.PagamentoService;
import com.sunshine.PSC.service.QuartoService;
import com.sunshine.PSC.service.ReservaService;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;
import com.sunshine.PSC.validator.ReservaValidator;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private ReservaService service;
	@Autowired
	private QuartoService qService;
	@Autowired
	private ClienteService cService;
	@Autowired
	private PagamentoService pService;
	
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(new ReservaValidator());
	}

	// ================= CREATE ==================
	@GetMapping("/cadastrarReservas") // Reserva cliente
	public String form(Reserva reserva, ModelMap model) {
		model.addAttribute("clientes", cService.findAll());
		return "reserva/cadastrarReservas";
	}

	@GetMapping("/createReservas/{id}") // Reserva administrador
	public String createReservas(Reserva reserva, @PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("clientes", cService.findById(id));
		model.addAttribute("quartos", qService.findAll());
		return "adm/createReserva";
	}

	@PostMapping("/create") // Reserva cliente
	public String create(Reserva reserva, RedirectAttributes attr) throws ParseException {
		service.save(reserva);
		attr.addFlashAttribute("success", "Cadastrado realizado com sucesso.");
		return "reserva/confirmacao";
	}

	@PostMapping("/seve") // Reserva administrador
	public String seve(@Valid Reserva reserva, BindingResult result, RedirectAttributes attr) throws ParseException {
		
		if (result.hasErrors()) {
			return "/adm/createReserva";
		}
		service.save(reserva);
		attr.addFlashAttribute("success", "Cadastrado realizado com sucesso.");		
		return "/adm/pagamentoReserva";
	}

	// ================= UPDATE ==================
	@GetMapping("/preupdate/{id}")// Reserva cliente
	public String preUpdate(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("reserva", service.findById(id));

		return "reserva/cadastrarReservas";
	}

	@GetMapping("/edit/{id}") // Area do administrador
	public String edit(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("reserva", service.findById(id));
		// model.addAttribute("quartos", qService.findAll());
		return "/adm/editReserva";
	}

	@PostMapping("/editar") // Reserva cliente
	public String updateReserva(Reserva reserva) throws ObjectNotFoundException {
		service.findById(reserva.getId());
		service.updateReserva(reserva);
		return "redirect:/reserva/listarReservas";
	}

	@PostMapping("/edit") // Area do administrador
	public String edit(Reserva reserva, RedirectAttributes attr) throws ObjectNotFoundException {
		service.findById(reserva.getId());
		attr.addFlashAttribute("success", "Reserva alterado com sucesso.");
		return "redirect:/reserva/listar";
	}

	// ================= DELETE ==================
	@GetMapping("/deletar/{id}") // Area do administrador
	public String deletarReserva(Reserva reserva, ModelMap model) throws ObjectNotFoundException {
		service.findById(reserva.getId());
		service.deleteReserva(reserva);
		model.addAttribute("success", "Reserva excluído com sucesso.");
		model.addAttribute("reserva", service.findAll());
		return "adm/listReservas";
	}

	// ================= LIST ====================
	@GetMapping("/listarReservas") // Reserva cliente
	public String findAll(ModelMap model) {
		model.addAttribute("reservas", service.findAll());
		return "reserva/listarReservas";
	}

	@GetMapping("/listar") // Area do administrador
	public String listar(ModelMap model) {
		model.addAttribute("reserva", service.findAll());
		return "/adm/listReservas";
	}

	// ================= PAGAMENTO ==============

	@GetMapping("/prePg/{id}") // Area do administrador
	public String pagar(Reserva reserva, Pagamento pagamento, @PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("reserva", service.findById(id));
		pService.save(pagamento);
		return "adm/pagamentoReserva";
	}
	
	
	

}

package com.sunshine.PSC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunshine.PSC.dominio.Reserva;
import com.sunshine.PSC.service.QuartoService;
import com.sunshine.PSC.service.ReservaService;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private ReservaService service;
	@Autowired
	private QuartoService qService;

	@GetMapping("/cadastrarReservas")
	public String form(Reserva reserva) {

		return "reserva/cadastrarReservas";
	}

	// @RequestMapping("reserva/create")
	@PostMapping("/create")
	public String create(Reserva reserva) {
		service.save(reserva);
		return "reserva/confirmacao";
	}

	@GetMapping("/listarReservas")
	public String findAll(ModelMap model) {
		model.addAttribute("reservas", service.findAll());
		return "reserva/listarReservas";
	}

	@GetMapping("/buscarid")
	public Reserva findById(int Id) throws ObjectNotFoundException {

		return service.findById(Id);
	}

	@GetMapping("/preupdate/{id}")
	public String preUpdate(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("reserva", service.findById(id));

		return "reserva/cadastrarReservas";
	}

	@PostMapping("/editar")
	public String updateReserva(Reserva reserva) throws ObjectNotFoundException {
		findById(reserva.getId());
		service.updateReserva(reserva);
		return "redirect:/reserva/listarReservas";
	}

	@GetMapping("/deletar/{id}")
	public String deletarReserva(Reserva reserva) throws ObjectNotFoundException {
		findById(reserva.getId());
		service.deleteReserva(reserva);
		return "reserva/confirmacao";
	}

}

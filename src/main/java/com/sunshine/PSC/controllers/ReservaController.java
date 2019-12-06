package com.sunshine.PSC.controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunshine.PSC.dominio.Quarto;
import com.sunshine.PSC.dominio.Reserva;
import com.sunshine.PSC.service.ClienteService;
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
	@Autowired
	private ClienteService cService;

	@GetMapping("/cadastrarReservas")
	public String form(Reserva reserva, ModelMap model) {

		model.addAttribute("clientes", cService.findAll());
		model.addAttribute("quartos", qService.findAll());
		return "reserva/cadastrarReservas";

	}

	@GetMapping("/createReservas") // cadastro de reseerva na area do adm
	public String createReservas(Reserva reserva, Quarto quarto, ModelMap model) {
		model.addAttribute("reservas", service.findAll());
		model.addAttribute("clientes", cService.findAll());
		model.addAttribute("quartos", qService.findAll());

		return "reserva/cadastrarReservas";
	}

	@PostMapping("/create")
	public String create(@Valid Reserva reserva, BindingResult result, RedirectAttributes attr) throws ParseException {
		String DTE = reserva.getDataEntradaTemp();
		String DTS = reserva.getDataSaidaTemp();

		LocalDate date1 = LocalDate.parse(DTE);
		LocalDate date2 = LocalDate.parse(DTS);
		reserva.setDataEntrada(date1);
		reserva.setDataSaida(date2);

		boolean comparacao = date1.isBefore(date2);
		ModelMap model = new ModelMap();
		if (comparacao == true) {
			service.save(reserva);

			model.addAttribute("reserva", service.findAll());
			// return "reserva/listarReservas";
			return "redirect:/reserva/listar";
		} else {
			model.addAttribute("reserva", service.findAll());
			return "redirect:/reserva/listar";
		}

	}

	/*
	 * @GetMapping("/listarReservas") public String findAll(ModelMap model) {
	 * model.addAttribute("reserva", service.findAll()); return "/adm/listReservas";
	 * }
	 */

	@GetMapping("/buscarid")
	public Reserva findById(int Id) throws ObjectNotFoundException {

		return service.findById(Id);
	}

	@GetMapping("/preupdate/{id}")
	public String preUpdate(@PathVariable("id") int id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("reserva", service.findById(id));

		return "redirect:/reserva/createReservas";
	}

	@PostMapping("/editar")
	public String updateReserva(@Valid Reserva reserva, BindingResult result, RedirectAttributes attr)
			throws ObjectNotFoundException {
		findById(reserva.getId());

		String DTE = reserva.getDataEntradaTemp();
		String DTS = reserva.getDataSaidaTemp();

		LocalDate date1 = LocalDate.parse(DTE);
		LocalDate date2 = LocalDate.parse(DTS);
		reserva.setDataEntrada(date1);
		reserva.setDataSaida(date2);

		if (result.hasErrors()) {
			return "adm/createReserva";
		}
		service.updateReserva(reserva);
		return "redirect:/reserva/listarReservas";
	}

	@GetMapping("/deletar/{id}")
	public String deletarReserva(Reserva reserva, ModelMap model) throws ObjectNotFoundException {
		findById(reserva.getId());
		if (service.reservaTemCliente(reserva.getId())) {
			model.addAttribute("fail", "Esta reserva não pode ser excluida,possui cliente(s) vinculado(s)");
		}else {
			service.deleteReserva(reserva);
			model.addAttribute("success", "reserva exluida com sucesso");
		}
		model.addAttribute("reserva", service.findAll());
		return "adm/listReservas";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("reserva", service.findAll());
		return "/adm/listReservas";
	}

	// @PostMapping("/seve") // inicio do cadastro de reserva na area do adm
	// public String seve(Reserva reserva) {
	// service.save(reserva);
	// return "/adm/areaAdm";
	// }

	@PostMapping("/seve")
	public String seve(@Valid Reserva reserva, BindingResult result, RedirectAttributes attr) throws ParseException {
		String DTE = reserva.getDataEntradaTemp();
		String DTS = reserva.getDataSaidaTemp();

		LocalDate date1 = LocalDate.parse(DTE);
		LocalDate date2 = LocalDate.parse(DTS);
		reserva.setDataEntrada(date1);
		reserva.setDataSaida(date2);

		if (result.hasErrors()) {
			return "adm/createReserva";
		}
		service.save(reserva);
		return "/adm/areaAdm";
	}

}

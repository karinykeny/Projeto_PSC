package com.sunshine.PSC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunshine.PSC.dominio.PagamentoComCartao;
import com.sunshine.PSC.dominio.Reserva;
import com.sunshine.PSC.service.PagamentoService;
import com.sunshine.PSC.service.ReservaService;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	@Autowired
	private PagamentoService pagamentoService;
	@Autowired
	private ReservaService reservaService;

	@GetMapping("/pagamentoCartao")
	public String EfetuarPagamento(PagamentoComCartao pagamento) {
		return "Pagamento/pagamentoCartao";
	}

	@PostMapping("/salvar")
	public String salvar(PagamentoComCartao pagamento) {
		pagamentoService.save(pagamento);
		return "redirect:/pagamento/pagamentoCartao";
	}

	@ModelAttribute("reservas")
	public List<Reserva> listaDeReservas() {
		return reservaService.findAll();
	}
}

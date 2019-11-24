package com.sunshine.PSC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunshine.PSC.dominio.PagamentoComCartao;
import com.sunshine.PSC.service.PagamentoService;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	
	private PagamentoService service;

	@GetMapping("/pagamentoCartao")
	public String EfetuarPagamento(PagamentoComCartao pagamento) {
		return "Pagamento/pagamentoCartao";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pagamento", service.findAll());
		return "/adm/listPagamentos";
	}
}

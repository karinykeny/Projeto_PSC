package com.sunshine.PSC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunshine.PSC.dominio.PagamentoComCartao;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

	@GetMapping("/pagamentoCartao")
	public String EfetuarPagamento(PagamentoComCartao pagamento) {
		return "Pagamento/pagamentoCartao";
	}
}

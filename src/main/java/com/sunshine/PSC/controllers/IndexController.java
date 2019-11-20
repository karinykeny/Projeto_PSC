package com.sunshine.PSC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String home() {	
	      return "/home";

		}
	@GetMapping("/contato")
	public String contato() {	
	      return "/contato";

		}
	
	@GetMapping("/promocoes")
	public String promocoes() {	
	      return "/promocoes";

		}
	
	@GetMapping("/acomodacoes")
	public String acomodacoes() {	
	      return "/acomodacoes";

		}
	@GetMapping("/login")
	public String login() {	
	      return "/login";

		}
	@GetMapping("/informacoesHotel")
	public String informacoesHotel() {	
	      return "/informacoesHotel";

		}
	@GetMapping("/adm")
	public String adm() {	
	      return "/adm/areaAdm";

		}
}


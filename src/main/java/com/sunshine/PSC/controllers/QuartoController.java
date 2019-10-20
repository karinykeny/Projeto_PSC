package com.sunshine.PSC.controllers;

import com.sunshine.PSC.dominio.Quarto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunshine.PSC.dao.QuartoDao;



@Controller
public class QuartoController {

	@Autowired
	private QuartoDao dao;
	
	//@RequestMapping("quarto/form")
	@RequestMapping(value="quarto/form", method=RequestMethod.GET)
	public String form() {
		return "quarto/form";
	}
	//@RequestMapping("quarto/create")
	@RequestMapping(value="/Quarto/create", method=RequestMethod.POST)
	public String create(Quarto quarto) {
	
		dao.create(quarto);
		return "quarto/confirmacao";
	}
	
}

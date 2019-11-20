package com.sunshine.PSC.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sunshine.PSC.dominio.Quarto;
import com.sunshine.PSC.dominio.Reserva;

public class ReservaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Reserva.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

	
}

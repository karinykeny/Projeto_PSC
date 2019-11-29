package com.sunshine.PSC.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sunshine.PSC.dominio.Reserva;

public class ReservaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Reserva.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors)  	{
		
		Reserva r = (Reserva) object;
		
		LocalDate entrada = r.getDataEntrada();
		
		if(r.getDataSaida() != null) {
			if(r.getDataSaida().isBefore(entrada)) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.reserva.dataSaida");				
			}
		}
		
		
	}

	
}

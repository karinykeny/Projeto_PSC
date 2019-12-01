package com.sunshine.PSC.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sunshine.PSC.dominio.Cliente;

public class ClienteValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Cliente.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Cliente c = (Cliente)object;
	}

}

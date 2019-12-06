package com.sunshine.PSC.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sunshine.PSC.dominio.Funcionario;

public class FuncionarioValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Funcionario f = (Funcionario)object;
	}

}

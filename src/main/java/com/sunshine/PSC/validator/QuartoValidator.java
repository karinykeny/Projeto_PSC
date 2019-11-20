package com.sunshine.PSC.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sunshine.PSC.dominio.Quarto;

public class QuartoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// tem como princípio validar o objeto que se está enviando a partir do formulário;
		//clazz é o objeto que temos no formulário;
		return Quarto.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		//Se o método suports validar, o processo segue para este método;
		//object = objeto que estamos recebendo do formulário;
		//errors = é o objeto que se irá lidar com a validação;
		Quarto q = (Quarto) object;
		
		boolean containsDigit = false;
		
		if (q.getTipoDeCama() != null && !q.getTipoDeCama().isEmpty()) {
		      for (char c : q.getTipoDeCama().toCharArray()) {
		            if (containsDigit = Character.isDigit(c)) {
		              errors.rejectValue("tipoDeCama", "tipoDeCamaInteger.quarto.tipoDeCama");
		            }
		        }
		    }
	}
}

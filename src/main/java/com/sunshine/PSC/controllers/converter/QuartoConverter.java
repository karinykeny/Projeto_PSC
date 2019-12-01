package com.sunshine.PSC.controllers.converter;

import org.springframework.core.convert.converter.Converter;

import com.sunshine.PSC.dominio.Quarto;
import org.springframework.util.StringUtils;

public class QuartoConverter implements Converter<String, Quarto> {

	@Override
	public Quarto convert(String id) {
		if (!StringUtils.isEmpty(id)) {
			Quarto quarto = new Quarto();
			quarto.setId(Integer.valueOf(id));
			return quarto;
		}
		
		return null;
	}

}

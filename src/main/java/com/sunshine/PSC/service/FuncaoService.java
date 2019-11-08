package com.sunshine.PSC.service;

import org.springframework.stereotype.Service;

import com.sunshine.PSC.dao.FuncaoDao;
import com.sunshine.PSC.dominio.Cliente;
import com.sunshine.PSC.dominio.Funcao;

@Service
public class FuncaoService {
	
	private FuncaoDao dao ;
	
	
	public Funcao save(Funcao funcao) {
		funcao.setDescricao(null);
		return dao.save(funcao);
	}

}

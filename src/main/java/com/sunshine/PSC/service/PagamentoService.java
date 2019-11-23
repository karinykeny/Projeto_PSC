package com.sunshine.PSC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.PSC.dao.PagamentoDao;
import com.sunshine.PSC.dominio.Pagamento;
import com.sunshine.PSC.service.exception.ObjectNotFoundException;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoDao dao;

	public Pagamento save(Pagamento pagamento) {
		pagamento.setId(null);
		return dao.save(pagamento);
	}

	public List<Pagamento> findAll() {
		return dao.findAll();
	}

	public Pagamento findById(int Id) throws ObjectNotFoundException {

		Optional<Pagamento> pagamento = dao.findById(Id);

		return pagamento.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encontrado! Id: " + Id + ",tipo: " + Pagamento.class.getName()));
	}

	public Pagamento updatePagamento(Pagamento pagamento) throws ObjectNotFoundException {
		findById(pagamento.getId());
		return dao.save(pagamento);
	}

	public void deletePagamento(Pagamento pagamento) throws ObjectNotFoundException {
		findById(pagamento.getId());
		dao.delete(pagamento);
	}

}

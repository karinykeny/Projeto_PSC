package com.sunshine.PSC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.PSC.dominio.Pagamento;

@Repository
public interface PagamentoDao extends JpaRepository<Pagamento, Integer> {

}

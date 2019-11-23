package com.sunshine.PSC;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunshine.PSC.dao.ClienteDao;
import com.sunshine.PSC.dao.FuncionarioDao;
import com.sunshine.PSC.dao.PagamentoDao;
import com.sunshine.PSC.dao.QuartoDao;
import com.sunshine.PSC.dao.ReservaDao;
import com.sunshine.PSC.dominio.Cliente;
import com.sunshine.PSC.dominio.Funcionario;
import com.sunshine.PSC.dominio.Pagamento;
import com.sunshine.PSC.dominio.PagamentoComCartao;
import com.sunshine.PSC.dominio.Quarto;
import com.sunshine.PSC.dominio.Reserva;
import com.sunshine.PSC.dominio.enums.EstadoPagamento;
import com.sunshine.PSC.dominio.enums.StatusQuarto;

@SpringBootApplication
public class PscApplication implements CommandLineRunner {

	@Autowired
	private QuartoDao quartoDao;
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private ReservaDao rdao;
	@Autowired
	private FuncionarioDao funcionarioDao;
	@Autowired
	PagamentoDao pgtDao;

	/*
	 * @Autowired private FuncaoDao funcaoDao;
	 */

	public static void main(String[] args) {
		SpringApplication.run(PscApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Quarto q1 = new Quarto("Quarto 101", 1, "Solteiro", StatusQuarto.disponivel);
		Quarto q2 = new Quarto("Quarto 202", 2, "Casal", StatusQuarto.disponivel);
		Quarto q3 = new Quarto("Quarto 303", 4, "Misto", StatusQuarto.disponivel);

		Cliente c1 = new Cliente("Adalberto", "410.211.230-80", "Adalberto@teste.com",
				"$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");
		Cliente c2 = new Cliente("Ricardo", "702.003.314-85", "Ricardo@teste.com",
				"$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");

		Funcionario f1 = new Funcionario(null, "kariy", "330.888.020-20", "karinykeny@gmail.com", "123", "81996912471");
		Funcionario f2 = new Funcionario(null, "Carlos Jose", "802.090.780-73", "carlsjose@gmail.com", "123",
				"81996912471");
		quartoDao.saveAll(Arrays.asList(q1, q2, q3));
		clienteDao.save(c1);
		clienteDao.save(c2);
		funcionarioDao.save(f1);
		funcionarioDao.save(f2);

		Reserva r1 = new Reserva(null, 6, null, null, null, null);

		Pagamento pgt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, r1, 6, 6352895,"jonas");

	



		r1.setPagamento(pgt1);

		rdao.save(r1);
	

		/*
		 * Funcao fun1 = new Funcao(); fun1.setDescricao("ROLE_ADMIN"); Funcao fun2 =
		 * new Funcao(); fun2.setDescricao("ROLE_USER");
		 */

		// Cliente c2 = new Cliente("Heitor", "058.966.204-03", "heitor@teste.com",
		// "$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");
		// clienteDao.save(c2);

		// Cliente cli = clienteDao.findByCpf("058.966.204-03");
		// System.out.println(cli.getNome() + "NOME DO CLIENTE");

	}

}
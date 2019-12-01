package com.sunshine.PSC;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
import com.sunshine.PSC.service.QuartoService;

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
		Quarto q3 = new Quarto("Quarto 303", 4, "Solteiro", StatusQuarto.disponivel);
		Quarto q4 = new Quarto("Quarto 404", 4, "Misto", StatusQuarto.disponivel);
		Quarto q5 = new Quarto("Quarto 505", 4, "Casal", StatusQuarto.disponivel);
		Quarto q6 = new Quarto("Quarto 606", 4, "Casal", StatusQuarto.disponivel);
		Quarto q7 = new Quarto("Quarto 707", 4, "Solteiro", StatusQuarto.disponivel);
		Quarto q8 = new Quarto("Quarto 808", 4, "Misto", StatusQuarto.disponivel);
		Quarto q9 = new Quarto("Quarto 909", 4, "Misto", StatusQuarto.disponivel);
		
		Cliente c1 = new Cliente("Adalberto Tavares de Souza", "410.211.230-80", "Adalberto@teste.com",
				"$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");
		Cliente c2 = new Cliente("Ricardo Joaquim Amaral", "702.003.314-85", "Ricardo@teste.com",
				"$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");
		Cliente c3 = new Cliente("Jailson Pereira Costa", "702.003.314-85", "jailson@teste.com",
				"$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");
		Cliente c4 = new Cliente("Noemi Silva das graças", "702.003.314-85", "noemi@teste.com",
				"$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");
		Cliente c5 = new Cliente("Sandra Lima de Souza", "702.003.314-85", "Sandra@teste.com",
				"$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");
		Cliente c6 = new Cliente("Joaquim Fragoso Cavalcante", "702.003.314-85", "joaquim@teste.com",
				"$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");
		Cliente c7 = new Cliente("Agrivaldo Santos de souza", "702.003.314-85", "agrivaldo@teste.com",
				"$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");
		
		Funcionario f1 = new Funcionario(null, "kariy", "330.888.020-20", "karinykeny@gmail.com", "123", "81996912471");
		Funcionario f2 = new Funcionario(null, "Carlos Jose", "802.090.780-73", "carlsjose@gmail.com", "123",
				"81996912471");
		quartoDao.saveAll(Arrays.asList(q1, q2, q3,q4,q5,q6,q7,q8,q9));
		clienteDao.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
		funcionarioDao.saveAll(Arrays.asList(f1, f2));
		
		
		Reserva r1 = new Reserva(c1, 2, LocalDate.of(2019, 12, 12), LocalDate.of(2019, 12, 14), 35.0, 70.0);
		Reserva r2 = new Reserva(c2, 2, LocalDate.of(2019, 12, 13), LocalDate.of(2019, 12, 15), 35.0, 70.0);
		Reserva r3 = new Reserva(c3, 2, LocalDate.of(2019, 12, 12), LocalDate.of(2019, 12, 16), 35.0, 175.0);
		Reserva r4 = new Reserva(c4, 2, LocalDate.of(2019, 12, 12), LocalDate.of(2019, 12, 17), 35.0, 35.0);
		Reserva r5 = new Reserva(c5, 2, LocalDate.of(2019, 12, 12), LocalDate.of(2019, 12, 13), 35.0, 35.0);
		Reserva r6 = new Reserva(c6, 2, LocalDate.of(2019, 12, 12), LocalDate.of(2019, 12, 14), 35.0, 75.0);
		Reserva r7 = new Reserva(c7, 2, LocalDate.of(2019, 12, 12), LocalDate.of(2019, 12, 14), 35.0, 75.0);

		Pagamento pgt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, r1, 6, 6352895,"jonas");

		r1.setPagamento(pgt1);

		rdao.saveAll(Arrays.asList(r1,r2,r3,r4,r5,r6,r7));
	
			
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
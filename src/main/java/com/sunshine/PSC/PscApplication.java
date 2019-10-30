package com.sunshine.PSC;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sunshine.PSC.dao.ClienteDao;
import com.sunshine.PSC.dao.QuartoDao;
import com.sunshine.PSC.dominio.Cliente;
import com.sunshine.PSC.dominio.Quarto;
import com.sunshine.PSC.dominio.enums.StatusQuarto;

@SpringBootApplication
public class PscApplication implements CommandLineRunner {

	@Autowired
	private QuartoDao quartoDao;
	@Autowired
	private ClienteDao clienteDao;

	public static void main(String[] args) {
		SpringApplication.run(PscApplication.class, args);
		System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		System.out.print(new BCryptPasswordEncoder().encode("123"));

	}

	@Override
	public void run(String... args) throws Exception {

		Quarto q1 = new Quarto("Quarto 101", 1, "Solteiro", StatusQuarto.disponivel);
		Quarto q2 = new Quarto("Quarto 202", 2, "Casal", StatusQuarto.disponivel);
		Quarto q3 = new Quarto("Quarto 303", 4, "Misto", StatusQuarto.disponivel);
		
		Cliente c1 = new Cliente("Adalberto", "70200331485", "Adalberto@teste.com", "123456");
		Cliente c2 = new Cliente("Eduardo", "62857037015", "edu@hotmail.com", "123");
		quartoDao.saveAll(Arrays.asList(q1, q2, q3));
		clienteDao.saveAll(Arrays.asList(c1,c2));

	}

}
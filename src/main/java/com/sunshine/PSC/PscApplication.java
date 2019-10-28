package com.sunshine.PSC;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunshine.PSC.dao.QuartoDao;
import com.sunshine.PSC.dominio.Quarto;
import com.sunshine.PSC.dominio.enums.StatusQuarto;

@SpringBootApplication
public class PscApplication implements CommandLineRunner {

	@Autowired
	private QuartoDao quartoDao;

	public static void main(String[] args) {
		SpringApplication.run(PscApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Quarto q1 = new Quarto("Quarto 101", 1, "Solteiro", StatusQuarto.disponivel);
		Quarto q2 = new Quarto("Quarto 202", 2, "Casal", StatusQuarto.disponivel);
		Quarto q3 = new Quarto("Quarto 303", 4, "Misto", StatusQuarto.disponivel);

		quartoDao.saveAll(Arrays.asList(q1, q2, q3));

	}

}
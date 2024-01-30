package com.Lanchonete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LanchoneteApplication {

	// NECESSÁRIO CRIAR UMA TABELA DE RECEITAS, PARA PODER QUANTIFICAR CADA INGREDIENTE DE UMA RECEITA.

	public static void main(String[] args) {
		SpringApplication.run(LanchoneteApplication.class, args);
	}

}

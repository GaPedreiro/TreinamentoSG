package com.Lanchonete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LanchoneteApplication {

	// NECESSÁRIO CRIAR UMA TABELA DE RECEITAS, PARA PODER QUANTIFICAR CADA INGREDIENTE DE UMA RECEITA.
	// LEMBRAR DE PRODUZIR O PRODUTO NO ATO DA VENDA.
	// PAREI CRIANDO A LISTA DE INGREDIENTES.
	public static void main(String[] args) {
		SpringApplication.run(LanchoneteApplication.class, args);
	}

}

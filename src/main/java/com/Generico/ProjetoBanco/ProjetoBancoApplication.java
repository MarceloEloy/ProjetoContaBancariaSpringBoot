package com.Generico.ProjetoBanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoBancoApplication {
// Lembrar de por um JSON formatado por conta da data_de_vencimento e data_de_pagamento.
	public static void main(String[] args) {
		SpringApplication.run(ProjetoBancoApplication.class, args);
	}

}

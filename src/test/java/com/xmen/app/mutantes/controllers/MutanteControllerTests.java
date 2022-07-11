package com.xmen.app.mutantes.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.xmen.app.mutantes.model.request.RequestMutante;

import com.xmen.app.mutantes.model.service.IMutanteService;

@SpringBootTest
 class MutanteControllerTests {

	@Autowired
	private IMutanteService mutanteService;

	@Test
	@SuppressWarnings("squid:S2699")
	 void isMutant() {
		RequestMutante rqTest = new RequestMutante();
		ResponseEntity<Boolean> rsTesr;

		String[] valorDna = { "ATGCGA" };
		rqTest.setDna(valorDna);

		rsTesr = mutanteService.validaMutante(rqTest);
	}

	@Test
	@SuppressWarnings("squid:S2699")
	 void estadisticas() {
		mutanteService.estadisticas();
	}

	@Test
	@SuppressWarnings("squid:S2699")
	 void bitacoraMutantes() {

		mutanteService.findAll();
	}

}

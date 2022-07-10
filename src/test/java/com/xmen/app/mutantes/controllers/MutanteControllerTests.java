package com.xmen.app.mutantes.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.xmen.app.mutantes.model.request.RequestMutante;

import com.xmen.app.mutantes.model.service.IMutanteService;

@SpringBootTest
public class MutanteControllerTests {

	@Autowired
	private IMutanteService mutanteService;

	@Test
	public void isMutant() {
		RequestMutante rqTest = new RequestMutante();
		ResponseEntity<Boolean> rsTesr;

		String[] valorDna = { "ATGCGA" };
		rqTest.setDna(valorDna);

		rsTesr = mutanteService.validaMutante(rqTest);
	}

	@Test
	public void estadisticas() {
		mutanteService.estadisticas();
	}

	@Test
	public void bitacoraMutantes() {

		mutanteService.findAll();
	}

}

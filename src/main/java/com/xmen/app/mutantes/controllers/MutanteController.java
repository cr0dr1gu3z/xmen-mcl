package com.xmen.app.mutantes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xmen.app.mutantes.model.entity.BitacoraValidacionMutante;
import com.xmen.app.mutantes.model.request.RequestMutante;
import com.xmen.app.mutantes.model.response.ResponseEstadistica;
import com.xmen.app.mutantes.model.service.IMutanteService;

@RestController
public class MutanteController 
{
	@Autowired
	private IMutanteService mutanteService;
	
	@PostMapping("/mutant")	
	public ResponseEntity<Boolean> isMutant(@RequestBody RequestMutante dna)
	{		
		return mutanteService.validaMutante(dna);
	}
	
	
	@GetMapping("/stats")
	public ResponseEstadistica estadisticas() 
	{
		return mutanteService.estadisticas();
	}
	
	@GetMapping("/listar")
	public List<BitacoraValidacionMutante> bitacoraMutantes() 
	{
		return mutanteService.findAll();
	}

}

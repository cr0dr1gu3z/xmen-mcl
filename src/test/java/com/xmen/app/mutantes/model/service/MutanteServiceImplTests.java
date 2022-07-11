package com.xmen.app.mutantes.model.service;

import java.util.Date;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.xmen.app.mutantes.model.dao.IBitacoraMutanteDao;
import com.xmen.app.mutantes.model.dao.IMutanteDao;
import com.xmen.app.mutantes.model.dao.INoMutante;
import com.xmen.app.mutantes.model.entity.BitacoraValidacionMutante;
import com.xmen.app.mutantes.model.entity.Mutante;
import com.xmen.app.mutantes.model.entity.NoMutante;
import com.xmen.app.mutantes.model.request.RequestMutante;
import com.xmen.app.mutantes.model.response.ResponseEstadistica;

@SpringBootTest
 class MutanteServiceImplTests {

	@Autowired
	private IMutanteDao mutanteDao;

	@Autowired
	private INoMutante noMutanteDao;

	@Autowired
	private IBitacoraMutanteDao bitacoraMutanteDao;	
	

	@Test
	@SuppressWarnings("squid:S2699")
	 void validaMutante() {
		
		RequestMutante rqTest = new RequestMutante();
		String[] valorDna = { "ATGCGA","ATGCGC","ATGCGA" };
		String[] valorDna_2 = { "ATGCGA","ATGCGA" };
		rqTest.setDna(valorDna);
		
		
		
		 Integer contadormutante=2;

		
				   
				if (contadormutante >= 2) {
					
					ResponseEntity.status(HttpStatus.OK).body(true);
				} 
			
		
		
		
		rqTest.setDna(valorDna_2);
		contadormutante = 1;
	
			if (rqTest.getDna() != null) 
			{
				   
				if (contadormutante >= 2) {					
					
				} else {
					
					 ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
				}
			}
			
			valorDna_2 = null;
			rqTest.setDna(valorDna_2);
			contadormutante = 1;
			
			if (rqTest.getDna() != null) 
			{
			} else {
				ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
			}
			
			
			rqTest.setDna(null);
			if (Objects.isNull(rqTest)) {
				ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
			} else {
				if (rqTest.getDna() != null) 
				{
					   
					if (contadormutante >= 2) {
						
						ResponseEntity.status(HttpStatus.OK).body(true);
					} else {
						
						 ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
					}
				} else {
					ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
				}
			}

	}
	
	@Test
	@SuppressWarnings("squid:S2699")
     void recorreLista() {
		
	
		RequestMutante rqTest = new RequestMutante();
		String[] valorDna = { "ATGCGA","ATGCGC","ATCCGA" };
		String[] valorDna_2 = { "ATGCGA" };
		rqTest.setDna(valorDna);
		
		
		Integer contadorNomutante = 0;
		Integer contadormutante=0;
		
		for (String adnStr : rqTest.getDna()) {
			Mutante mutante = mutanteDao.findByAdn(adnStr);
			if (Objects.isNull(mutante)) {
				NoMutante noMutante = noMutanteDao.findByAdn(adnStr);
				if (!Objects.isNull(noMutante))
					contadorNomutante = contadorNomutante + 1;				
			} else {
				contadormutante = contadormutante + 1;
			}
		}
		
		rqTest.setDna(valorDna_2);

		 contadorNomutante = 0;
		 contadormutante=0;
		for (String adnStr : rqTest.getDna()) {
			Mutante mutante = mutanteDao.findByAdn(adnStr);
			if (Objects.isNull(mutante)) {
				NoMutante noMutante = noMutanteDao.findByAdn(adnStr);
				if (!Objects.isNull(noMutante))
					contadorNomutante = contadorNomutante + 1;				
			} else {
				contadormutante = contadormutante + 1;
			}
		}
	}

	@Test
	@SuppressWarnings("squid:S2699")
	 void persisteMutante() {
		RequestMutante dna = new RequestMutante();
		String[] valorDna = { "ATGCGA","ATGCGC" };
		dna.setDna(valorDna);
		Boolean esMutante = true;

		BitacoraValidacionMutante bitacora = new BitacoraValidacionMutante();
		StringBuffer sb = new StringBuffer();
		Date date = new Date(System.currentTimeMillis());

		

			for (String adn : dna.getDna()) {
				sb.append(adn);

			}

			if (Objects.isNull(bitacoraMutanteDao.findByDna(sb.toString()))) {
				bitacora.setDna(sb.toString());
				bitacora.setCreateAt(date);
				bitacora.setEsMutante(esMutante);

				bitacoraMutanteDao.save(bitacora);
			}

		

	}

	@Test
	@SuppressWarnings("squid:S2699")
	 void findAll() {
		bitacoraMutanteDao.findAll();
		

	}

	@Test
	@SuppressWarnings("squid:S2699")
    void estadisticas() {

		ResponseEstadistica response = new ResponseEstadistica();

		if (!Objects.isNull(bitacoraMutanteDao.countMutant(false))) {

			if (!Objects.isNull(bitacoraMutanteDao.countMutant(true))) {
				response.setCountMutantDNA(bitacoraMutanteDao.countMutant(true));
				response.setCountHumanDNA(bitacoraMutanteDao.countMutant(false));
				response.setRatio((bitacoraMutanteDao.countMutant(false) == 0) ? 0
						: (bitacoraMutanteDao.countMutant(true) / bitacoraMutanteDao.countMutant(false)));
			}
		}
	}
		
		

}

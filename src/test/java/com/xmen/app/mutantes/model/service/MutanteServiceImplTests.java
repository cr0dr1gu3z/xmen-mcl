package com.xmen.app.mutantes.model.service;

import java.util.Date;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		String[] valorDna = { "ATGCGA" };
		rqTest.setDna(valorDna);

		Integer contadorNomutante = 0;
		Integer contadormutante = 0;

		if (rqTest.getDna() != null) {
			for (String adnStr : rqTest.getDna()) {

				Mutante mutante = new Mutante();
				NoMutante noMutante = new NoMutante();

				mutante = mutanteDao.findByAdn(adnStr);

				if (Objects.isNull(mutante)) {
					noMutante = noMutanteDao.findByAdn(adnStr);

					if (!Objects.isNull(noMutante)) {
						contadorNomutante = contadorNomutante + 1;
					}
				} else {
					contadormutante = contadormutante + 1;
				}

			}
		}

	}

	@Test
	@SuppressWarnings("squid:S2699")
	 void persisteMutante() {
		RequestMutante dna = new RequestMutante();
		String[] valorDna = { "ATGCGA" };
		dna.setDna(valorDna);
		Boolean esMutante = true;

		BitacoraValidacionMutante bitacora = new BitacoraValidacionMutante();
		StringBuffer sb = new StringBuffer();
		Date date = new Date(System.currentTimeMillis());

		try {

			for (String adn : dna.getDna()) {
				sb.append(adn);

			}

			if (Objects.isNull(bitacoraMutanteDao.findByDna(sb.toString()))) {
				bitacora.setDna(sb.toString());
				bitacora.setCreateAt(date);
				bitacora.setEsMutante(esMutante);

				bitacoraMutanteDao.save(bitacora);
			}

		} catch (Exception e) {
			e.getStackTrace();
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

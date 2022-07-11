package com.xmen.app.mutantes.model.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xmen.app.mutantes.model.dao.IBitacoraMutanteDao;
import com.xmen.app.mutantes.model.dao.IMutanteDao;
import com.xmen.app.mutantes.model.dao.INoMutante;
import com.xmen.app.mutantes.model.entity.BitacoraValidacionMutante;
import com.xmen.app.mutantes.model.entity.Mutante;
import com.xmen.app.mutantes.model.entity.NoMutante;
import com.xmen.app.mutantes.model.request.RequestMutante;
import com.xmen.app.mutantes.model.response.ResponseEstadistica;

@Service
public class MutanteServiceImpl implements IMutanteService {
	@Autowired
	private IMutanteDao mutanteDao;

	@Autowired
	private INoMutante noMutanteDao;

	@Autowired
	private IBitacoraMutanteDao bitacoraMutanteDao;

	private Integer contadorNomutante;
	private Integer contadormutante;

	@Override
	@Transactional()
	public ResponseEntity<Boolean> validaMutante(RequestMutante adn) {

		if (Objects.isNull(adn)) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
		} else {
			if (adn.getDna() != null) 
			{
				   recorreLista(adn);
				if (contadormutante >= 2) {
					persisteMutante(adn, true);
					return ResponseEntity.status(HttpStatus.OK).body(true);
				} else {
					persisteMutante(adn, false);
					return ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
				}
			} else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
			}
		}
	}

	public void recorreLista(RequestMutante adn) {
		contadorNomutante = 0;
		contadormutante=0;
		for (String adnStr : adn.getDna()) {
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

	@Transactional
	public void persisteMutante(RequestMutante dna, Boolean esMutante) {
		BitacoraValidacionMutante bitacora = new BitacoraValidacionMutante();
		StringBuilder sb = new StringBuilder();
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

	@Override
	@Transactional(readOnly = true)
	public List<BitacoraValidacionMutante> findAll() {
		return (List<BitacoraValidacionMutante>) bitacoraMutanteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEstadistica estadisticas() {

		ResponseEstadistica response = new ResponseEstadistica();

		if (!Objects.isNull(bitacoraMutanteDao.countMutant(false))
				&& !Objects.isNull(bitacoraMutanteDao.countMutant(true))) {
			response.setCountMutantDNA(bitacoraMutanteDao.countMutant(true));
			response.setCountHumanDNA(bitacoraMutanteDao.countMutant(false));
			response.setRatio((bitacoraMutanteDao.countMutant(false) == 0) ? 0
					: (bitacoraMutanteDao.countMutant(true) / bitacoraMutanteDao.countMutant(false)));
		}
		return response;
	}

}

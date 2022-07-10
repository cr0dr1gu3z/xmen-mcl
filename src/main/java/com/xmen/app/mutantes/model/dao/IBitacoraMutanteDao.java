package com.xmen.app.mutantes.model.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.xmen.app.mutantes.model.entity.BitacoraValidacionMutante;


public interface IBitacoraMutanteDao extends CrudRepository<BitacoraValidacionMutante, Long>
{
	
	BitacoraValidacionMutante findByDna(String dna);
	
    @Query("SELECT COUNT(b) FROM BitacoraValidacionMutante b ")
    long countAll();
    
    @Query("SELECT COUNT(b) FROM BitacoraValidacionMutante b WHERE b.esMutante= :mutante")
    long countMutant(@Param ("mutante") Boolean mutante);
	
}

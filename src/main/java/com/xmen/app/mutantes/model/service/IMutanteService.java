package com.xmen.app.mutantes.model.service;



import java.util.List;

import org.springframework.http.ResponseEntity;

import com.xmen.app.mutantes.model.entity.BitacoraValidacionMutante;
import com.xmen.app.mutantes.model.request.RequestMutante;
import com.xmen.app.mutantes.model.response.ResponseEstadistica;

public interface IMutanteService {
	
	
    public ResponseEntity<Boolean> validaMutante(RequestMutante adn);
    
    public List<BitacoraValidacionMutante> findAll();
    
    
    public ResponseEstadistica estadisticas();
    
}

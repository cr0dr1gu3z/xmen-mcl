package com.xmen.app.mutantes.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.xmen.app.mutantes.model.entity.Mutante;

public interface IMutanteDao extends JpaRepository<Mutante, Long>
{
	Mutante findByAdn(String adn);	

}
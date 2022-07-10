package com.xmen.app.mutantes.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xmen.app.mutantes.model.entity.NoMutante;

public interface INoMutante extends JpaRepository<NoMutante, Long> 
{
	NoMutante findByAdn(String adn);

}

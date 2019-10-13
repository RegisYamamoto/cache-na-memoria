package com.regis.cachenamemoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.regis.cachenamemoria.model.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
	
}
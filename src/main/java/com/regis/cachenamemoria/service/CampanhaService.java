package com.regis.cachenamemoria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regis.cachenamemoria.CrunchifyInMemoryCache;
import com.regis.cachenamemoria.model.Campanha;
import com.regis.cachenamemoria.repository.CampanhaRepository;

@Service
public class CampanhaService {

	@Autowired
	private CampanhaRepository campanhaRepository;
	
	CrunchifyInMemoryCache<Long, String> cache = new CrunchifyInMemoryCache<>(60, 60, 100);
	List<Campanha> campanhas = new ArrayList<>();
	
	public List<Campanha> listaTodasAsCampanha() {
		System.out.println("Tamanho do cache: " + cache.size());
		
		if (cache.size() != 0) {
			System.out.println("Trazendo campanhas do cache...");
			for (int i = 0; i < 10000; i++) {
				if (cache.get(i) != null) {
					campanhas.add(cache.get(i));
				}
			}
		} else {
			System.out.println("Cache estava vazio, trazendo campanhas do banco");
			campanhas = campanhaRepository.findAll();
			for (Campanha campanha : campanhas) {
				cache.put(campanha.getId(), campanha);
			}
		}

		System.out.println("Tamanho do cache: " + cache.size());
		return campanhas;
	}
	
}
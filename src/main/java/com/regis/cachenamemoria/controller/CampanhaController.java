package com.regis.cachenamemoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regis.cachenamemoria.model.Campanha;
import com.regis.cachenamemoria.service.CampanhaService;

@RestController
@RequestMapping(value = "/cache-na-memoria/campanhas")
public class CampanhaController {

	@Autowired
	private CampanhaService campanhaService;
	
	@GetMapping
	public List<Campanha> listarTodasAsCampanhas() {
		return campanhaService.listaTodasAsCampanha();
	}
	
	
}
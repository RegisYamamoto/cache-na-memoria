package com.regis.cachenamemoria.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Campanha {

	@Id
	private long id;
	private String produto;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	@Override
	public String toString() {
		return "Campanha [id=" + id + ", produto=" + produto + "]";
	}

	
}
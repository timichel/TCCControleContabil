package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dao.EntidadeBase;

@Entity
public class Conta implements EntidadeBase{

	@Id
	private String id;
	private String Descricao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pai", insertable = true, updatable = true, nullable = true)
	private Conta Tipo;
	
	public Conta(){}
	public String getId() { 		return id; 	}
	public void setId(String id) {		this.id = id;	}
	public String getDescricao() {		return Descricao;	}
	public void setDescricao(String descricao) { 		Descricao = descricao; 	}
	public Conta getTipo() {	return Tipo;	}
	public void setTipo(Conta tipo) {		Tipo = tipo;	}
	
	
}

package com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dao.EntidadeBase;
@Entity
public class DC implements EntidadeBase{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="lanc_id")
	private Lancamento lancamento;
	@ManyToOne
	@JoinColumn(name="conta_id")
	private Conta conta;
	private String tipo;//Se e Debito ou Credito
	private Date data;
	private Double valor;
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}

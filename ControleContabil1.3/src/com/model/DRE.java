package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dao.EntidadeBase;

@Entity
public class DRE implements EntidadeBase{

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Empresa_Id")
	private Empresa empresa;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Contador_cpf")
	private Contador contador;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Admin_cpf")
	private Admin admin;
	private boolean alterado;
	private Double fatBruto;
	private Double impSobreVendas;
	private Double fatLiq;
	private Double cmv;
	private Double lucroBruto;
	private Double comissoes;
	private Double despVar;
	private Double totDesp;
	private Double lucroOper;
	private Double despFinanceiras;
	private Double ganhoNOperacional;
	private Double lucroLiquido;
	
	public DRE() {	super();	}

	public Integer getId() {	return id;	}
	public void setId(Integer id) {	this.id = id;	}

	public Empresa getEmpresa() {	return empresa;	}
	public void setEmpresa(Empresa empresa) {	this.empresa = empresa;	}

	public Contador getContador() {	return contador;	}
	public void setContador(Contador contador) {	this.contador = contador;	}

	public Admin getAdmin() {	return admin;}
	public void setAdmin(Admin admin) {	this.admin = admin;	}

	public boolean isAlterado() {	return alterado;}
	public void setAlterado(boolean alterado) {	this.alterado = alterado;}

	public Double getFatBruto() {	return fatBruto;}
	public void setFatBruto(Double fatBruto) {	this.fatBruto = fatBruto;}

	public Double getImpSobreVendas() {	return impSobreVendas;}
	public void setImpSobreVendas(Double impSobreVendas) {	this.impSobreVendas = impSobreVendas;}

	public Double getFatLiq() {	return fatLiq;}
	public void setFatLiq(Double fatLiq) {	this.fatLiq = fatLiq;}

	public Double getCmv() {return cmv;	}
	public void setCmv(Double cmv) {	this.cmv = cmv;}

	public Double getLucroBruto() {	return lucroBruto;}
	public void setLucroBruto(Double lucroBruto) {	this.lucroBruto = lucroBruto;}

	public Double getComissoes() {	return comissoes;}
	public void setComissoes(Double comissoes) {	this.comissoes = comissoes;}

	public Double getDespVar() {return despVar;	}
	public void setDespVar(Double despVar) {	this.despVar = despVar;}

	public Double getTotDesp() {return totDesp;}
	public void setTotDesp(Double totDesp) {this.totDesp = totDesp;	}

	public Double getLucroOper() {	return lucroOper;}
	public void setLucroOper(Double lucroOper) {	this.lucroOper = lucroOper;}

	public Double getDespFinanceiras() {	return despFinanceiras;	}
	public void setDespFinanceiras(Double despFinanceiras) {	this.despFinanceiras = despFinanceiras;	}

	public Double getGanhoNOperacional() {	return ganhoNOperacional;}
	public void setGanhoNOperacional(Double ganhoNOperacional) {	this.ganhoNOperacional = ganhoNOperacional;	}

	public Double getLucroLiquido() {	return lucroLiquido;}
	public void setLucroLiquido(Double lucroLiquido) {	this.lucroLiquido = lucroLiquido;}
	

}

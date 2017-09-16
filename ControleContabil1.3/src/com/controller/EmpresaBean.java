package com.controller;

import javax.faces.bean.ManagedBean;

import com.model.Empresa;

@ManagedBean(name="empresa")
public class EmpresaBean {

	private Empresa e;

	public Empresa getE() {
		return e;
	}

	public void setE(Empresa e) {
		this.e = e;
	}
	
	
}

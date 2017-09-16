package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("prop")
public class Proprietario extends User implements Serializable{

	private static final long serialVersionUID = 1L;

	public Proprietario() {	}
	@OneToMany(targetEntity=Empresa.class, mappedBy="proprietario", fetch=FetchType.EAGER)
	private List<Empresa> listEmpresas;

	/*getter e setter omitidos*/
	
	
	public List<Empresa> getListEmpresas() {
		return listEmpresas;
	}

	public void addEmpresa(Empresa e) {
		this.listEmpresas.add(e);
	}
		
	
}

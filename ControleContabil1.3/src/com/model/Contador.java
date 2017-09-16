package com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.dao.EntidadeBase;

@Entity
@DiscriminatorValue("cont")
public class Contador extends User implements EntidadeBase{

	
	private String CRC;//Conselho regional de Conabilidade
	private Date DataAdm;
	@OneToMany(targetEntity=Empresa.class, mappedBy="contador", fetch=FetchType.EAGER)
	private List<Empresa> listEmpresas;
	public Contador() {			}
	
	/*getter e setter omitidos*/
	
	public String getCRC() { return CRC;	}
	public void setCRC(String cRC) {		CRC = cRC;	}
	public Date getDataAdm() {		return DataAdm;	}
	public void setDataAdm(Date dataAdm) {		DataAdm = dataAdm;	}
	public List<Empresa> getListEmpresas() {		return listEmpresas;	}
	public void addEmpresa(Empresa e) {		this.listEmpresas.add(e);	}	
}

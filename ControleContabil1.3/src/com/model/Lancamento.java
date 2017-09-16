package com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.dao.EntidadeBase;

@Entity
public class Lancamento implements EntidadeBase{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cnpj_empresa")
	private Empresa empresa;
	private Admin admin;
	private boolean alterado;
	private String descricao;
	private Date data;
	@OneToMany( targetEntity=DC.class,
			mappedBy="lancamento",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	private List<DC> listDC;
	
	public Lancamento() {	}
	
	public Integer getId() {return Id;	}
	public void setId(Integer id) { 		Id = id;	}
	public Empresa getEmpresa() { 	return empresa;	}
	public void setEmpresa(Empresa empresa) { this.empresa = empresa;}
	public Admin getAdmin() {		return admin;	}
	public void setAdmin(Admin admin) {		this.admin = admin;	}
	public boolean isAlterado() {		return alterado;	}
	public void setAlterado(boolean alterado) {		this.alterado = alterado;	}
	public String getDescricao() {		return descricao;	}
	public void setDescricao(String descricao) {		this.descricao = descricao;	}
	public Date getData() {		return data;	}
	public void setData(Date data) {		this.data = data;	}

	public List<DC> getListDC() {
		return listDC;
	}

	public void setListDC(List<DC> listDC) {
		this.listDC = listDC;
	}
	
	
	
}

package com.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.dao.EntidadeBase;
@Entity
public class Empresa implements EntidadeBase{

	@Id
	private String CNPJ;
	@Column(name="Razao_Social")
	private String RazaoSocial;
	private String Fantasia;
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JoinColumn
	private Contador contador;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JoinColumn
	private Proprietario proprietario;
	@OneToMany(targetEntity=Lancamento.class, 
			mappedBy="empresa",
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY)
	private List<Lancamento> listLancamentos;
	
	public Empresa() {		}
	
	public String getCNPJ() {		return CNPJ;	}
	public void setCNPJ(String CNPJ) {		this.CNPJ = CNPJ;	}
	public String getRazaoSocial() {		return RazaoSocial;	}
	public void setRazaoSocial(String razaoSocial) {		RazaoSocial = razaoSocial;	}
	public String getFantasia() {		return Fantasia;	}
	public void setFantasia(String fantasia) {		Fantasia = fantasia;	}
	public Endereco getEndereco() {		return endereco;	}
	public void setEndereco(Endereco endereco) {		this.endereco = endereco;	}
	public Contador getContador() {		return contador;	}
	public void setContador(Contador contador) {		this.contador = contador;	}
	public Proprietario getProprietario() {		return proprietario;	}
	public void setProprietario(Proprietario proprietario) {		this.proprietario = proprietario;	}

	public List<Lancamento> getListLancamentos() {
		return listLancamentos;
	}
	public void setListLancamentos(List<Lancamento> listLancamentos) {
		this.listLancamentos = listLancamentos;
	}
	
	
}

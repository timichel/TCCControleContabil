package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dao.ContaDao;
import com.dao.ContadorDao;
import com.dao.DCDao;
import com.dao.EmpresaDao;
import com.dao.LancamentoDao;
import com.model.Conta;
import com.model.DC;
import com.model.Empresa;
import com.model.Lancamento;

/**
 * @author michel
 *
 */
@ManagedBean(name="contador")
@SessionScoped
public class ContadorBean extends UserBean{

	private static final long serialVersionUID = 1L;
	String msg = null;
	Conta conta = new Conta();
	DC dc = new DC();
	List<DC> listdc = new ArrayList<DC>();
	Lancamento lancamento = new Lancamento();
	List<Lancamento> listLancamento = new ArrayList<Lancamento>();
	Empresa e = new Empresa();
	ContaDao contadao = null;
	LancamentoDao ldao = null;
	DCDao dcdao = null;
	EmpresaDao empresadao = null;
	ContadorDao contadordao = null;

	
	//RETORNA A CONTA COM BASE NO ID INFORMADO
	public Conta SelecionaConta(String Id){
		contadao = new ContaDao();
		if(lancamento.getDescricao().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Informe a descrição do lancamento!!"));
		}else if(lancamento.getData() == null){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Informe a data do lancamento!!"));
		}else if(Id.length() <= 0){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Informe o código da conta para pesquisar!!"));
		}else{
			try {
				conta = new Conta();
				conta = contadao.BuscaPorId(Id);
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage("Conta não encontrada!!"));
				e.printStackTrace();
			}
		}	
		return conta;
	}
	
	//INSTANCIA UM NOVO OBJETO DE DEBITOCREDITO E SETA UMA CONTA 
	public void setaContaDC(){
		dc = new DC();
		if(conta.getDescricao().length() <= 0){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Informe o código da conta"));
		}else{
			dc.setConta(conta);
		}
		
	}
	//ADICIONA O OBJETO DE DEBITO CREDITO CRIADO A UMA LISTA DEBITOCREDITO
	public void addListDC(){
		if(dc.getConta() == null){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Informe o código da conta"));
		}
		if(dc.getTipo() == null){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Informe se é débito ou crédito"));
		}
		listdc.add(dc);
		conta = new Conta();
		dc = new DC();
	}
	/*
	 * SETA O LISTDC NO LANCAMENTO, INSERE LISTDC NO LANCAMENTO,
	 * REALIZA O SET DO LANCAMENTO EM EMPRESA, 
	 * REALIZA O SET DA EMPRESA EM LANCAMENTO
	 * RALIZA UM FOR ENCADEADO GRAVANDO NO BANCO DE DADOS O LANCAMENTO 
	 *  E APÓS GRAVANDO NO BANCO DE DADOS OS DEBITOS E CREDITOS
	 *  ATE ESGOTAR TODOS OS LANCAMENTOS 
	 */
	public void RealizaLancamento(Empresa empresa) {
		DCDao dcdao = new DCDao();
		LancamentoDao lancamentodao = new LancamentoDao();
		for (DC dc : listdc) {dc.setLancamento(lancamento); }
		lancamento.setListDC(listdc);
		lancamento.setEmpresa(empresa);
		listLancamento.add(lancamento);
		empresa.setListLancamentos(listLancamento);
		for (int i = 0; i < empresa.getListLancamentos().size(); i++) {
			try {
				lancamentodao.salvar(empresa.getListLancamentos().get(i));
			} catch (Exception e1) {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage("Erro ao realizar o Lancamento"));
				e1.printStackTrace();
			}
			for (int j = 0; j < empresa.getListLancamentos().get(i).getListDC().size(); j++) {
				try {
					dcdao.salvar(empresa.getListLancamentos().get(i).getListDC().get(j));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage("Erro ao realizar os itens do lancamento	"));
					e.printStackTrace();
				}
			}

		}
		empresa = new Empresa();
		lancamento = new Lancamento();
		listLancamento.removeAll(getListLancamento());

	}
	
	public String GerarDRE(Empresa e, Date mes){
		return msg;
	}
	
	public Empresa getE() {
		return e;
	}
	public void setE(Empresa e) {
		this.e = e;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Lancamento getLancamento() {
		return lancamento;
	}
	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	public DC getDc() {
		return dc;
	}
	public void setDc(DC dc) {
		this.dc = dc;
	}
	public List<DC> getListdc() {
		return listdc;
	}
	public void setListdc(List<DC> listdc) {
		this.listdc = listdc;
	}
	public List<Lancamento> getListLancamento() {
		return listLancamento;
	}
	public void setListLancamento(List<Lancamento> listLancamento) {
		this.listLancamento = listLancamento;
	}
	

}//FIM DA CLASSE CONTADORBEAN

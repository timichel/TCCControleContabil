package com.test;

import java.util.ArrayList;
import java.util.List;

import com.controller.ContadorBean;
import com.dao.EmpresaDao;
import com.model.Conta;
import com.model.Contador;
import com.model.DC;
import com.model.Empresa;
import com.model.Lancamento;

public class realizaLancamentoTest {

	
	public static void main(String[] args){
		ContadorBean contbean = new ContadorBean();
		Conta conta = new Conta();
		DC dc = new DC();
		Empresa empresa = new Empresa();
		Lancamento lancamento = new Lancamento();
		empresa = contbean.SelecionaEmpresa("12566887000199");
		conta = contbean.SelecionaConta("5");
		dc.setConta(conta);
		dc.setTipo("D");
		dc.setValor((double)30000);
		dc.setLancamento(lancamento);
		List<DC> listdc = new ArrayList<DC>();
		listdc.add(dc);
		conta = contbean.SelecionaConta("11");
		dc.setConta(conta);
		dc.setTipo("C");
		dc.setConta(conta);
		dc.setValor((double)30000);
		listdc.add(dc);
		lancamento.setListDC(listdc);
		lancamento.setDescricao("lancamento de teste");
		lancamento.setEmpresa(empresa);
		List<Lancamento> listLancamentos = new ArrayList<Lancamento>();
		listLancamentos.add(lancamento);
		empresa.setListLancamentos(listLancamentos);
		contbean.RealizaLancamento(empresa);
	}
	
}

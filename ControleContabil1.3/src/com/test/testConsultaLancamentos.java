package com.test;

import java.text.SimpleDateFormat;

import com.controller.ContadorBean;
import com.model.Conta;
import com.model.Contador;
import com.model.DC;
import com.model.Empresa;
import com.model.Lancamento;

public class testConsultaLancamentos {

	public static void main(String args[]){
		Double TotalVendas =  (double) 0;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Conta conta = new Conta();
		DC dc = new DC();
		Lancamento l = new Lancamento();
		Contador contador = new Contador();
		ContadorBean contbean = new ContadorBean();
		Empresa e = new Empresa();
		conta = contbean.SelecionaConta("5");
		e = contbean.SelecionaEmpresa("12566887000199");
		for(int i = 0;i < e.getListLancamentos().size();i++){
			if(e.getListLancamentos().get(i).getListDC().get(0).getConta().getId() == conta.getId()){
				TotalVendas = TotalVendas + e.getListLancamentos().get(i).getListDC().get(0).getValor();
				System.out.println("Valor da venda: "+e.getListLancamentos().get(i).getListDC().get(0).getValor());
			}
				
		}
		System.out.println("Total de vendas realizadas:"+TotalVendas);
		
	}
	
	
}


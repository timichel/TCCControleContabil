package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.controller.ContadorBean;
import com.model.Conta;
import com.model.Contador;
import com.model.DC;
import com.model.Empresa;
import com.model.Lancamento;

public class LancamentoTests {

	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Conta conta = new Conta();
		DC dc = new DC();
		Lancamento l = new Lancamento();
		Contador contador = new Contador();
		ContadorBean contbean = new ContadorBean();
		Empresa e = new Empresa();
		String DataTextodc = "13/10/2016";
		Date datadc = new Date();
		
		//cria uma data
		try {
			datadc = df.parse(DataTextodc);
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		conta = contbean.SelecionaConta("4");
		System.out.println("Descricao da conta"+conta.getDescricao());
		
		//cria o DC
		dc.setConta(conta);
		dc.setData(datadc);
		dc.setTipo("D");
		dc.setValor((double) 30000);
		//cria o lancamento
		l.setDescricao("Venda realizada conforme NF 322011");
		l.setData(datadc);
		//busca um contador
		//insere o contador responsavel pelo lancamento
		e = contbean.SelecionaEmpresa("4171544600180");
		
		List<Lancamento> listLancamentos = new ArrayList<Lancamento>();
		listLancamentos.add(l);
		e.setListLancamentos(listLancamentos);
		//contbean.RealizaLancamento(e);
		
		
		
		//cria uma lista de DC
		List<DC> listDC = new ArrayList<DC>();
		//insere o DC na lista
		listDC.add(dc);
		//seta o DC na lista
		l.setListDC(listDC);
		
		System.out.println("Dados do lancamento"+l.getId());

	}

}

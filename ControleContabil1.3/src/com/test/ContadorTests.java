package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.controller.ContadorBean;
import com.model.Conta;
import com.model.Contador;
import com.model.DC;
import com.model.Empresa;
import com.model.Lancamento;

public class ContadorTests {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Conta conta = new Conta();
		DC dc = new DC();
		Lancamento l = new Lancamento();
		Contador contador = new Contador();
		ContadorBean contbean = new ContadorBean();
		Empresa e = new Empresa();
		
		String DataTextodc = "6/11/2016";
		Date datadc = new Date();
		
		try {
			datadc = df.parse(DataTextodc);
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		/*CADASTRA A CONTA*/
		/*conta.setDescricao("Aluguel Passivo");
		contbean.CadastraConta(conta);
		System.out.println("Descricao da conta:"+conta.getDescricao());*/
		/*FIM DO CADASTRA CONTA*/
		/*SELECIONA CONTA*/
		conta = contbean.SelecionaConta("5");
		System.out.println("Id da conta:"+conta.getId());
		/*SETA CONTA NO DC*/
		dc.setConta(conta);
		dc.setData(datadc);
		dc.setTipo("D");
		dc.setValor((double) 45000);
		/*CADASTRA DC */
		System.out.println("Id do dc"+dc.getId());
		l.setData(datadc);
		l.setDescricao("Aluguel de máquinas conforme contrato 02320321/2016");
		System.out.println("Descricao do lancamento"+l.getId()+" - "+l.getDescricao());
		e = contbean.SelecionaEmpresa("12566887000199");
		dc.setLancamento(l);
		l.setEmpresa(e);
		contbean.RealizaLancamento(e);
	}//FIM DO METODO MAIN

}

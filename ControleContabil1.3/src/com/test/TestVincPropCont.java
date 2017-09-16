package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;

import com.controller.AdminBean;
import com.model.Admin;
import com.model.Contador;
import com.model.Empresa;
import com.model.Proprietario;

public class TestVincPropCont {

	public static void main(String args[]){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAdm = new Date();
		AdminBean adminbean = new AdminBean();
		Empresa e = new Empresa();
		Admin a = new Admin();
		Contador c = new Contador();
		Proprietario p = new Proprietario();
		
		
		e = adminbean.SelecionaEmpresa("4171544600180");
		p = adminbean.BuscaProprietario("24089812544");
		e.setProprietario(p);
		adminbean.AtualizaDadosEmpresa(e);
		e = adminbean.SelecionaEmpresa("4171544600180");
		System.out.println("Empresa"+e.getProprietario().getCpf());
	}
}

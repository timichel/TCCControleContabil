package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.controller.AdminBean;

import com.model.Admin;
import com.model.Contador;
import com.model.Empresa;
import com.model.Proprietario;

public class AdminTest {

	public static void main(String args[]){
		String dataTexto = "21/10/2016";
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAdm = new Date();
		AdminBean adminbean = new AdminBean();
		Empresa e = new Empresa();
		Admin a = new Admin();
		Contador c = new Contador();
		Proprietario p = new Proprietario();
		
		/*a.setCpf("32884454845");
		a.setCRC("48948988");
		a.setNome("Michel Garcia Furtado");
		try { 			dataAdm = df.parse(dataTexto);} 
		catch (ParseException e2) {e2.printStackTrace();}
		a.setDataAdm(dataAdm);
		a.setRg("292019373");
		a.setSenha("123");
		Endereco enda = new Endereco();
		enda.setBairro("Vl.Hortencia");
		enda.setCep("18023230");
		enda.setCompl("casa");
		enda.seteMail("michel_garcia@outlook.com");
		enda.setMunicipio("Sorocaba");
		enda.setN("3000");
		enda.setRua("R. Bayard Nobrega de Almeida");
		enda.setTel1("3326232");
		enda.setTel2("991230964");
		enda.setUf("SP");
		a.setEndereco(enda);
		adminbean.CadastrarAdministrador(a);//cadastra adinistrador
		
		c.setCpf("38900125655");
		c.setCRC("01444401");
		c.setNome("Pedro Araujo de Moraes");
		String dataTexto2 = "21/10/2005";
		try {dataAdm = df.parse(dataTexto2);} 
		catch (ParseException e2) {	e2.printStackTrace();}
		c.setDataAdm(dataAdm);
		c.setRg("551234565");
		c.setSenha("123");
		Endereco endc = new Endereco();
		endc.setBairro("Vl. Fiori");
		endc.setCep("18030718");
		endc.setCompl("Casa");
		endc.seteMail("pearaujo@outlook.com");
		endc.setMunicipio("Sorocaba");
		endc.setN("130");
		endc.setRua("R. Firmino Mineli");
		endc.setTel1("32227250");
		endc.setTel2("981236490");
		endc.setUf("SP");
		c.setEndereco(endc);
		adminbean.CadastrarContador(c);
		
		e.setCNPJ("12566887000199");
		e.setFantasia("Companhia da Terra");
		e.setRazaoSocial("Conservas da Terra Nova Friburgo - ME");
		e.setInscrEst("02829914000195");
		Endereco end = new Endereco();
		end.setBairro("Heliopolis");
		end.setCep("26113420");
		end.setCompl("Bloco 3 Sala 5");
		end.seteMail("conserterrasfriburgo@terra.combr");
		end.setMunicipio("Belo Horizonte");
		end.setN("780");
		end.setRua("R. Geraldo Macedo");
		end.setTel1("56899787");
		end.setTel2("99812356");
		end.setUf("MG");
		e.setEndereco(end);
		adminbean.CadastrarEmpresa(e);
		
		p.setCpf("40289812544");
	    p.setNome("Adriana Aparecida");
	    p.setRg("00231568");
	    p.setSenha("123");
	    Endereco endp = new Endereco();
		endp.setBairro("Jd. Josane");
		endp.setCep("18015211");
		endp.setCompl("casa 05");
		endp.seteMail("adrap@outlook.com");
		endp.setMunicipio("Sorocaba");
		endp.setN("120");
		endp.setRua("Av. Independencia");
		endp.setTel1("33265906");
		endp.setTel2("989889811");
		endp.setUf("SP");
	    p.setEndereco(endp);
	    adminbean.CadastrarProprietario(p);
	    */
	    e = adminbean.SelecionaEmpresa("12566887000199");
	    System.out.println("empresa:"+e.getFantasia());
		e.setFantasia("Assess Consultoria Contabil");
		adminbean.AtualizaDadosEmpresa(e);
		
		
		e = adminbean.SelecionaEmpresa("12566887000199");
		c = adminbean.BuscaContador("38900125655");
		e.setContador(c);
		adminbean.VincCont(e);
		
		e = adminbean.SelecionaEmpresa("12566887000199");
		p = adminbean.BuscaProprietario("40289812544");
		e.setProprietario(p);
		adminbean.VincProp(e);
		
		
		
		
		
		
	}//FIM DO MAIN
	
	
	
}//FIM DA CLASSE ADMINTEST

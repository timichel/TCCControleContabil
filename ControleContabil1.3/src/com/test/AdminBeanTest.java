package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.controller.AdminBean;
import com.model.Admin;
import com.model.Contador;
import com.model.Empresa;
import com.model.Endereco;
import com.model.Proprietario;

public class AdminBeanTest {

	String dataTexto = "21/10/2016";
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Date dataAdm = new Date();
	AdminBean adminbean = new AdminBean();
	Empresa e = new Empresa();
	Admin a = new Admin();
	Contador c = new Contador();
	Proprietario p = new Proprietario();
	/*COM ESTE TESTE CHECAMOS A INSERÇÃO
	 * E A BUSCA POR ID DAS CLASSES 
	 * ATRAVES DA COMPARAÇÃO DO OBJETO RETORNADO
	 * COM O QUE FOI PERSISTIDO
	 */
	@Test
	public void testCadastrarAdministrador() {
		/*SETA ATRIBUTOS DO ADMINISTRADOR*/
		a.setCpf("32884454845");
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
		adminbean.CadastrarAdministrador(a);//cadastra a empresa
		a = adminbean.BuscaAdmin(a.getCpf());
		Assert.assertEquals("32884454845", a.getCpf());
	}

	@Test
	public void testCadastrarContador() {	
		/*SETA ATRIBUTOS DO CONTADOR*/
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
		c = adminbean.BuscaContador(c.getCpf());
		Assert.assertEquals("38900125655", c.getCpf());
	}
	@Test
	public void testCadastrarProprietario() {
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
	    p = adminbean.BuscaProprietario("40289812544");
	    Assert.assertEquals("40289812544", p.getCpf());
		
	}
	@Test
	public void testCadastrarEmpresa() {
		/*SETA ATRIBUTOS DA EMPRESA*/
		e.setCNPJ("10884478000185");
		e.setFantasia("Dados para serem atualizados");
		e.setRazaoSocial("Real Contabilidade e Acessoria Ltda");
		Endereco end = new Endereco();
		end.setBairro("Heliopolis");
		end.setCep("18030030");
		end.setCompl("");
		end.seteMail("realcontabilidade@terra.combr");
		end.setMunicipio("Sorocaba");
		end.setN("410");
		end.setRua("R. Pandiá Calógenas");
		end.setTel1("1533260960");
		end.setTel2("1533279920");
		end.setUf("SP");
		e.setEndereco(end);
		adminbean.CadastrarEmpresa(e);
		e = adminbean.SelecionaEmpresa(e.getCNPJ());
		Assert.assertEquals("10884478000185",e.getCNPJ());
	}

	

	/*COM ESTES TESTES PRETENDE-SE
	 * CHECAR A ATUALIZAÇÃO DE EMPRESA COM
	 * RELAÇÃO A CONSISTENCIA DOS RELACIONAMENTOS COM
	 * AS CLASSES CONTADOR, PROPRIETARIO E ADMIN 
	 */
	@Test
	public void testAtualizaDadosEmpresa() {
		e = adminbean.SelecionaEmpresa("10884478000185");
		e.setFantasia("Real Contabilidade e Acessoria");
		adminbean.AtualizaDadosEmpresa(e);
		e = adminbean.SelecionaEmpresa("10884478000185");
		Assert.assertEquals("Real Contabilidade e Acessoria", e.getFantasia());
	}

	@Test
	public void testVincCont(){
		Empresa empresa = new Empresa();
		Contador contador = new Contador();
		empresa = adminbean.SelecionaEmpresa("10884478000185");
		contador = adminbean.BuscaContador("38900125655");
		empresa.setContador(contador);
		adminbean.VincCont(empresa);//Cria o vinculo da empresa com contador
		e = adminbean.SelecionaEmpresa("10884478000185");//busca empresa no bd
		//checa se o cpf do contador esta
	    //atrelado a empresa
		Assert.assertEquals(contador.getCpf(), empresa.getContador().getCpf());
	}
	
	@Test
	public void testVincProp(){
		Empresa empresa = new Empresa();
		Proprietario proprietario = new Proprietario();
		empresa = adminbean.SelecionaEmpresa("10884478000185");
		proprietario = adminbean.BuscaProprietario("40289812544");
		empresa.setProprietario(proprietario);
		adminbean.VincProp(empresa);//Cria o vinculo da empresa com proprietario
		empresa = adminbean.SelecionaEmpresa("10884478000185");//busca empresa no bd
		//checa se o cpf do proprietario esta
		//atrelado a empresa
		Assert.assertEquals(proprietario.getCpf(), empresa.getProprietario().getCpf());
	}
}

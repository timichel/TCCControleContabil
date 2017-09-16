package com.test;

import com.controller.AdminBean;
import com.model.Contador;
import com.model.Empresa;
import com.model.Proprietario;

public class SelecionaEmpresaTest {

	public static void main(String[] args) {
		AdminBean adm = new AdminBean();
		Empresa e = adm.SelecionaEmpresa("10884478000185");
		Contador c = adm.BuscaContador("38900125655");
		Proprietario p = adm.BuscaProprietario("40289812544");
		System.out.println("Contador: "+c.getNome());
		System.out.println("Empresa nome:"+e.getFantasia());
		
		System.out.println("Proprietario: "+p.getNome());
		e.setProprietario(p);
		adm.VincProp(e);

	}

}

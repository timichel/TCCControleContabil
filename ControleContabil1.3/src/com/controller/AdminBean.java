package com.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.AdminDao;
import com.dao.ContadorDao;
import com.dao.DREDao;
import com.dao.EmpresaDao;
import com.dao.LancamentoDao;
import com.dao.ProprietarioDao;
import com.model.Admin;
import com.model.Contador;
import com.model.Empresa;
import com.model.Proprietario;

@ManagedBean(name="adminbean")
@SessionScoped
public class AdminBean extends UserBean{

	private static final long serialVersionUID = 1L;
	
	Empresa e = new Empresa();
	String msg = null;
	AdminDao admdao = null;
	ProprietarioDao propdao = null;
	ContadorDao contdao = null;
	EmpresaDao empdao = null;
	LancamentoDao landao = null;
	DREDao dredao = null;
	
	public String CadastrarAdministrador(Admin a){
		  admdao = new AdminDao();
		  try {
			admdao.salvar(a);
			msg = "Salvo com sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao salvar";
		}
			return msg;
		}
	
	public String CadastrarContador(Contador c){
		contdao = new ContadorDao();
		try {
			contdao.salvar(c);
			msg = "Salvo com sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao salvar";
		}
		return msg;
	}
	
	public String CadastrarEmpresa(Empresa e){
		empdao = new EmpresaDao();
		try {
			empdao.salvar(e);
			msg = "Salvo com sucesso";
		} catch (Exception e1) {
			e1.printStackTrace();
			msg = "Erro ao salvar";
		}
		return msg;
	}
	
	public String CadastrarProprietario(Proprietario p){
		  propdao = new ProprietarioDao();
		  try {
			propdao.salvar(p);
			msg = "Salvo com sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao salvar";
		}
			return msg;
		}
	
	public void VincProp(Empresa e){
		empdao = new EmpresaDao();
		try {
			AtualizaDadosEmpresa(e);
		} catch (Exception e1) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<ERRO Vincproprietario>>>>>>>>>>>>>>");
			System.out.println("ERRO"+e1.getMessage());
		}
		
	}
	public void VincCont(Empresa e){
		empdao = new EmpresaDao();
		try {
			AtualizaDadosEmpresa(e);
		} catch (Exception e1) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<ERRO VincContador>>>>>>>>>>>>>>");
			System.out.println("ERRO"+e1.getMessage());
		}
	}
	public String AtualizaDadosEmpresa(Empresa e){
		empdao = new EmpresaDao();
		try {
			empdao.alterar(e);
			msg = "Salvo com sucesso";
		} catch (Exception e1) {	
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<ERRO AtualizarDadosEmpresa>>>>>>>>>>>>>>");
			System.out.println("ERRO"+e1.getMessage());
			msg = "Erro ao salvar";
		}
		return msg;
	}
	

	public Contador BuscaContador(String cpf) {
		contdao = new ContadorDao();
		Contador c = null;
		try {
			c = contdao.buscaporcpf(cpf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public Admin BuscaAdmin(String cpf) {
		admdao = new AdminDao();
		Admin a = null;
		try {
			a = admdao.buscaporcpf(cpf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public Proprietario BuscaProprietario(String cpf) {
		propdao = new ProprietarioDao();
		Proprietario p = null;
		try {
			p = propdao.buscaporcpf(cpf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}

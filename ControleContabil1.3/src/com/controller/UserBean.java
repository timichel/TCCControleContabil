
package com.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.UserDao;
import com.model.Admin;
import com.model.Contador;
import com.model.Empresa;
import com.model.Lancamento;
import com.model.Proprietario;
import com.model.User;

@ManagedBean(name="user")
public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private User user;
	private UserDao userdao;
	FacesMessage fm;
    /*CONSTRUTOR*/
	public UserBean() { user = new User(); userdao = new UserDao();	}
	 /*METODOS GETTER E SETTER*/
	public User getUser() {return user;	}
	public void setUser(User user) {this.user = user;}
	/*REALIZA O LOGIN DO USUARIO E
	 * DE ACORDO COM O TIPO DE USUARIO RETORNA UMA PAGINA
	 *  COM DIFERENTES OPERAÇÕES OU  DEVOLVE PARA A 
	 *  PAGINA DE LOGIN COM MENSAGEM DE ERRO APROPRIADA
	 */
	public String login() {
		String pagina = "login.xhtml";// fixa a pagina de login como retorno  padrão
		try {// Faz a busca do usuario no banco
			user = userdao.Login(user.getCpf(), user.getSenha());
		} catch (Exception e) {
			throw new NullPointerException(e.getMessage());
		}
		if (user == null) {			
			user = new User();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de Login",
							"Usuário ou senha incorretos"));
		} else {
			// se usuario for contador encaminha para a pagina dele
			if (user instanceof Contador){
				pagina = "contador.xhtml";}
			// se usuario for proprietario encaminha para a pagina dele
			if (user instanceof Proprietario){
				pagina = "proprietario.xhtml";}
			// se usuario for admin encaminha para a pagina dele
			if (user instanceof Admin){
				pagina = "admin.xhtml";}
		}
		try {FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
		} catch (IOException e) { e.printStackTrace();		}
		System.out.println("Pagina: "+pagina);
		return pagina;
	}
	/*FIM DO METODO LOGIN*/
	
	
	/*REALIZA A SELECÃO DA EMPRESA*/
	public Empresa SelecionaEmpresa(String cnpj){
		Empresa empresa = null;//cria objeto empresa
		try{
			if(cnpj.length() <= 0){
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage("Informe o cnpj da empresa"));
			}else{
				empresa = new Empresa();
				empresa = userdao.SelecionaEmpresa(cnpj);//busca a empresa com base no cnpj
				//se a empresa nao for encontrada retorna mensagem informando o usuario	
				if(!empresa.getContador().getCpf().equals(user.getCpf()) 
						|| !empresa.getProprietario().getCpf().equals(user.getCpf())){
					FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage("Dados nao disponiveis para o usuario"));
				}
			}
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Empresa não localizada"));
		}
		return empresa;//retorna a empresa encontrada
	}
	/*FIM DO METODO SELECIONAEMPRESA*/
	/*RETORNA UMA SEQUENCIA DE LANÇAMENTOS REALIZADOS POR UMA EMPRESA EM UMA DATA ESPECIFICA*/
	public List<Lancamento> ConsultaLancamentos(Empresa empresa, Date Data){
		return null;
	}
	
	
}

package com.dao;

import java.util.Date;
import java.util.List;
import com.model.DRE;
import com.model.Empresa;
import com.model.Lancamento;
import com.model.User;

public class UserDao extends GenericDao<User>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public User Login(String cpf, String senha)throws Exception{
		String consulta = "from User u where u.cpf = :cpf and u.senha = :senha";
		getSession().beginTransaction();
		return (User) getSession().createQuery(consulta)
				.setParameter("cpf", cpf)
				.setParameter("senha", senha)
				.uniqueResult();
	}
	
	public Empresa SelecionaEmpresa(String cnpj)throws Exception{
		String consulta = "from Empresa e where e.CNPJ = :cnpj";
		getSession().beginTransaction();
		return (Empresa) getSession().createQuery(consulta)
				.setParameter("cnpj", cnpj)
				.uniqueResult();
	}
	
	 public DRE ConsultarDRE(Empresa e,Date DataInicio, Date DataTermino){
	    	return null;
	    }
	    @SuppressWarnings("unchecked")
		public List<Lancamento> ConsultarLancamentos(Empresa e, Date Data){
	    	String consulta = "from Empresa e join e.lancamentos.data = :data";
	    	getSession().beginTransaction();
	    	return  getSession().createQuery(consulta).setParameter("data", Data).list();
	    }
	
}

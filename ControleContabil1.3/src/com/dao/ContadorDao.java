package com.dao;

import com.model.Contador;

public class ContadorDao extends UserDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Contador buscaporcpf(String cpf) throws Exception{
		String consulta = "from Contador c where c.cpf = :cpf";
		getSession().beginTransaction();
		return (Contador) getSession().createQuery(consulta)
				.setParameter("cpf", cpf)
				.uniqueResult();
	}
	
	public void GerarDRE(){
		
	}
}

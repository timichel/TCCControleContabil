package com.dao;

import com.model.Proprietario;

public class ProprietarioDao extends GenericDao<Proprietario>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Proprietario buscaporcpf(String cpf) throws Exception{
		String consulta = "from Proprietario p where p.cpf = :cpf";
		getSession().beginTransaction();
		return (Proprietario) getSession().createQuery(consulta)
				.setParameter("cpf", cpf)
				.uniqueResult();
	}
	
}

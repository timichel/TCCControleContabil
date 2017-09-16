package com.dao;

import com.model.Admin;

public class AdminDao extends GenericDao<Admin>{

	private static final long serialVersionUID = 1L;

	public Admin buscaporcpf(String cpf) throws Exception{
				String consulta = "from Admin a where a.cpf=:cpf";
		getSession().beginTransaction();
		return (Admin) getSession().createQuery(consulta)
				.setParameter("cpf", cpf)
				.uniqueResult();
	}
	
}

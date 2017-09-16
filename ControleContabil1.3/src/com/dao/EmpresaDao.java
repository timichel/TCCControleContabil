package com.dao;

import com.model.Empresa;

public class EmpresaDao extends GenericDao<Empresa>{
	
	private static final long serialVersionUID = 1L;

	public Empresa buscaporcnpj(String cnpj) throws Exception{
		String consulta = "from Empresa e where e.CNPJ=:cnpj";
		getSession().beginTransaction();
		Empresa empresa =  (Empresa) getSession().createQuery(consulta)
				.setParameter("cnpj", cnpj)
				.uniqueResult();
		return empresa;
	}

	
}

package com.dao;

import com.model.Conta;

public class ContaDao extends GenericDao<Conta>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Conta BuscaPorId(String Id) throws Exception{
		String consulta = "from Conta c where c.id=:Id";
		getSession().beginTransaction();
		return (Conta) getSession().createQuery(consulta)
				.setParameter("Id", Id)
				.uniqueResult();
	}
}

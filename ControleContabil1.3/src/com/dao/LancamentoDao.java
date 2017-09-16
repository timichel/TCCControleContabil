package com.dao;

import com.model.Lancamento;

public class LancamentoDao extends GenericDao<Lancamento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Lancamento BuscaPorId(int id) throws Exception{
		String consulta = "from Lancamento l where l.id = :id";
		getSession().beginTransaction();
		return (Lancamento) getSession().createQuery(consulta)
		.setParameter("id", id)
		.uniqueResult();
	}

	
}

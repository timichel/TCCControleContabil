package com.dao;

import com.model.DC;


public class DCDao extends GenericDao<DC>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DC BuscaPorId(int Id)throws Exception{
		String consulta = "from DC dc where dc.Id = :Id";
		getSession().beginTransaction();
		return (DC) getSession().createQuery(consulta)
				.setParameter("Id", Id)
				.uniqueResult();
	}
	
}

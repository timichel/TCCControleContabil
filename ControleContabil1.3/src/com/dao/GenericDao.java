package com.dao;

import java.io.Serializable;

import org.hibernate.Session;
import com.util.HibernateUtil;

public class GenericDao<T extends EntidadeBase> implements Serializable{

	private static final long serialVersionUID = 1L;
	private Session session = new HibernateUtil().getSession();

	public Session getSession() {
		return session;
	}

	public void salvar(T t)throws Exception{
		this.session.beginTransaction();
		this.session.save(t);
		this.session.getTransaction().commit();
	}

	public void alterar(T t)throws Exception{
		this.session.beginTransaction();
		this.session.merge(t);
		this.session.getTransaction().commit();
	}
	
	public void remover(T t)throws Exception{
		this.session.beginTransaction();
		this.session.delete(t);
		this.session.getTransaction().commit();
	}
	
}

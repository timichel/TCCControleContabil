package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.model.Admin;
import com.model.Conta;
import com.model.Contador;
import com.model.DC;
import com.model.DRE;
import com.model.Empresa;
import com.model.Endereco;
import com.model.Lancamento;
import com.model.Proprietario;
import com.model.User;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration()
					.configure("2hibernate.cfg.xml")
					.addAnnotatedClass(User.class)
					.addAnnotatedClass(Contador.class)
					.addAnnotatedClass(Proprietario.class)
					.addAnnotatedClass(Admin.class)
					.addAnnotatedClass(Endereco.class)
					.addAnnotatedClass(Empresa.class)
					.addAnnotatedClass(Lancamento.class)
					.addAnnotatedClass(DC.class)
					.addAnnotatedClass(Conta.class)
					.addAnnotatedClass(DRE.class);

			StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			return configuration.buildSessionFactory(builder.build());

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Session getSession() {
        return sessionFactory.openSession();
        
    }
}

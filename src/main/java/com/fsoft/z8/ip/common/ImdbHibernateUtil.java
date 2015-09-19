package com.fsoft.z8.ip.common;

import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public final class ImdbHibernateUtil {

	private static final Logger LOGGER = Logger.getLogger(ImdbHibernateUtil.class.getName());
	
	private static final SessionFactory sessionFactory;
	
	static {
	    try {
		Configuration configuration = new Configuration();
		configuration.configure(ImdbConstants.HIBERNATE_CONFIG);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	    } catch (Throwable ex) {
		LOGGER.info("Initial SessionFactory creation failed." + ex);
		throw new ExceptionInInitializerError(ex);
	    }
	}
	
	private ImdbHibernateUtil() {
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

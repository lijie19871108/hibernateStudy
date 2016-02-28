package com.tyyj.db.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Component
public class HibernateUtil {

	@Autowired
	private final SessionFactory sessionFactory=null;
	
	public  SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}

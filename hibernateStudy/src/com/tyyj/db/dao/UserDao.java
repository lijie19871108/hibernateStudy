package com.tyyj.db.dao;

import java.time.chrono.JapaneseChronology;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.tyyj.db.Entities.User;

@Repository
@Transactional
public class UserDao {

	private static final Log log = LogFactory.getLog(TyyyjManorHome.class);

	SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;//.openSession().getSessionFactory();
	}
	
	public Session getCurrentSession(){
		return sessionFactory.openSession();
	}
	
	public void persist(User user) {
		log.debug("persisting User instance");
		try {
			getCurrentSession().save(user);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	
	public User findById(java.lang.String id) {
		log.debug("getting TyyyjManor instance with id: " + id);
		try {
			User instance = (User) getCurrentSession().get("hibernate.User", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public User findByName(java.lang.String name) {
		log.debug("getting TyyyjManor instance with id: " + name);
		try {
			java.util.List result = getCurrentSession().createQuery("from User as u where u.username = '"+name+"'").list();
			User instance = (User)result.get(0) ;
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
}

package com.tyyj.db.dao;
// Generated 2016-1-26 23:21:06 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.tyyj.db.Entities.TyyjUser;

/**
 * Home object for domain model class TyyjUser.
 * @see com.tyyj.db.Entities.TyyjUser
 * @author Hibernate Tools
 */
public class TyyjUserHome {

	private static final Log log = LogFactory.getLog(TyyjUserHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TyyjUser transientInstance) {
		log.debug("persisting TyyjUser instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TyyjUser instance) {
		log.debug("attaching dirty TyyjUser instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TyyjUser instance) {
		log.debug("attaching clean TyyjUser instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TyyjUser persistentInstance) {
		log.debug("deleting TyyjUser instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TyyjUser merge(TyyjUser detachedInstance) {
		log.debug("merging TyyjUser instance");
		try {
			TyyjUser result = (TyyjUser) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TyyjUser findById(java.lang.String id) {
		log.debug("getting TyyjUser instance with id: " + id);
		try {
			TyyjUser instance = (TyyjUser) sessionFactory.getCurrentSession().get("hibernate.TyyjUser", id);
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

	public List findByExample(TyyjUser instance) {
		log.debug("finding TyyjUser instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("hibernate.TyyjUser")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}

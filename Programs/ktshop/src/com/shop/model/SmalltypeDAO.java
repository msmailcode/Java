package com.shop.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Smalltype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.shop.model.Smalltype
 * @author MyEclipse Persistence Tools
 */

public class SmalltypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SmalltypeDAO.class);
	// property constants
	public static final String BIGTYPEID = "bigtypeid";
	public static final String SMALLTYPENAME = "smalltypename";

	public void save(Smalltype transientInstance) {
		log.debug("saving Smalltype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Smalltype persistentInstance) {
		log.debug("deleting Smalltype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Smalltype findById(java.lang.Integer id) {
		log.debug("getting Smalltype instance with id: " + id);
		try {
			Smalltype instance = (Smalltype) getSession().get(
					"com.shop.model.Smalltype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(Smalltype instance) {
		log.debug("finding Smalltype instance by example");
		try {
			List<?> results = getSession()
					.createCriteria("com.shop.model.Smalltype")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<?> findByProperty(String propertyName, Object value) {
		log.debug("finding Smalltype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Smalltype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByBigtypeid(Object bigtypeid) {
		return findByProperty(BIGTYPEID, bigtypeid);
	}

	public List<?> findBySmalltypename(Object smalltypename) {
		return findByProperty(SMALLTYPENAME, smalltypename);
	}

	public List<?> findAll() {
		log.debug("finding all Smalltype instances");
		try {
			String queryString = "from Smalltype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Smalltype merge(Smalltype detachedInstance) {
		log.debug("merging Smalltype instance");
		try {
			Smalltype result = (Smalltype) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Smalltype instance) {
		log.debug("attaching dirty Smalltype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Smalltype instance) {
		log.debug("attaching clean Smalltype instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
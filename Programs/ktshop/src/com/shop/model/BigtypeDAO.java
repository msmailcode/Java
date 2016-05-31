package com.shop.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Bigtype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.shop.model.Bigtype
 * @author MyEclipse Persistence Tools
 */

public class BigtypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BigtypeDAO.class);
	// property constants
	public static final String BIGTYPENAME = "bigtypename";

	public void save(Bigtype transientInstance) {
		log.debug("saving Bigtype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bigtype persistentInstance) {
		log.debug("deleting Bigtype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bigtype findById(java.lang.Integer id) {
		log.debug("getting Bigtype instance with id: " + id);
		try {
			Bigtype instance = (Bigtype) getSession().get(
					"com.shop.model.Bigtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Bigtype instance) {
		log.debug("finding Bigtype instance by example");
		try {
			List results = getSession()
					.createCriteria("com.shop.model.Bigtype")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Bigtype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bigtype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBigtypename(Object bigtypename) {
		return findByProperty(BIGTYPENAME, bigtypename);
	}

	public List findAll() {
		log.debug("finding all Bigtype instances");
		try {
			String queryString = "from Bigtype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bigtype merge(Bigtype detachedInstance) {
		log.debug("merging Bigtype instance");
		try {
			Bigtype result = (Bigtype) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bigtype instance) {
		log.debug("attaching dirty Bigtype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bigtype instance) {
		log.debug("attaching clean Bigtype instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
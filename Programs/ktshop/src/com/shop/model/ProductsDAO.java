package com.shop.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Products entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.shop.model.Products
 * @author MyEclipse Persistence Tools
 */

public class ProductsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProductsDAO.class);
	// property constants
	public static final String PRODUCTNAME = "productname";
	public static final String BIGCATEGORY = "bigcategory";
	public static final String SMALLCATEGORY = "smallcategory";
	public static final String PIC = "pic";
	public static final String PRICE = "price";
	public static final String INTRODUCE = "introduce";
	public static final String PARAMETER = "parameter";
	public static final String RECOMMEND = "recommend";

	public void save(Products transientInstance) {
		log.debug("saving Products instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Products persistentInstance) {
		log.debug("deleting Products instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Products findById(java.lang.Integer id) {
		log.debug("getting Products instance with id: " + id);
		try {
			Products instance = (Products) getSession().get(
					"com.shop.model.Products", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(Products instance) {
		log.debug("finding Products instance by example");
		try {
			List<?> results = getSession()
					.createCriteria("com.shop.model.Products")
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
		log.debug("finding Products instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Products as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByProductname(Object productname) {
		return findByProperty(PRODUCTNAME, productname);
	}

	public List<?> findByBigcategory(Object bigcategory) {
		return findByProperty(BIGCATEGORY, bigcategory);
	}

	public List<?> findBySmallcategory(Object smallcategory) {
		return findByProperty(SMALLCATEGORY, smallcategory);
	}

	public List<?> findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	public List<?> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<?> findByIntroduce(Object introduce) {
		return findByProperty(INTRODUCE, introduce);
	}

	public List<?> findByParameter(Object parameter) {
		return findByProperty(PARAMETER, parameter);
	}

	public List<?> findByRecommend(Object recommend) {
		return findByProperty(RECOMMEND, recommend);
	}

	public List<?> findAll() {
		log.debug("finding all Products instances");
		try {
			String queryString = "from Products";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Products merge(Products detachedInstance) {
		log.debug("merging Products instance");
		try {
			Products result = (Products) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Products instance) {
		log.debug("attaching dirty Products instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Products instance) {
		log.debug("attaching clean Products instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
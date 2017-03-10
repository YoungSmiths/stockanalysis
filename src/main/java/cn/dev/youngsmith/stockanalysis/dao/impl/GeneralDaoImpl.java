package cn.dev.youngsmith.stockanalysis.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
@Transactional
public class GeneralDaoImpl implements Serializable {
	private static final long serialVersionUID = 985876060660021716L;

	private final Logger LOGGER = LoggerFactory.getLogger(GeneralDaoImpl.class);

	protected EntityManager entityManager;

	@Inject
	public void setEntityManager(EntityManager entityManager) {
		LOGGER.debug("inject EntityManager");
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void save(Object entity) throws Exception {
		try {
			LOGGER.debug(entity.toString());
			entityManager.persist(entity);
			entityManager.flush();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	public List<?> getAll(Class<?> entityClass) throws Exception {
		try {
			Query query = entityManager.createQuery("from " + entityClass.getSimpleName());
			return query.getResultList();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	public void update(Object entity) throws Exception {
		try {
			entityManager.merge(entity);
			entityManager.flush();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

}

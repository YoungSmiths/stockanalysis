package cn.dev.youngsmith.stockanalysis.dao.impl;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockEntityManagerProvider {
	private final static Logger LOGGER = LoggerFactory.getLogger(StockEntityManagerProvider.class);

	private ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory emf = null;
	static {
		emf = createEntityManagerFactory();
	}

	@Produces
	public EntityManager createEntityManager() {
		EntityManager entityManager = emf.createEntityManager();
		threadLocal.set(entityManager);
		LOGGER.debug("set entityManager {}", entityManager);

		return entityManager;
	}

	public void close(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}

	private static EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("stockanalysis");

	}
}

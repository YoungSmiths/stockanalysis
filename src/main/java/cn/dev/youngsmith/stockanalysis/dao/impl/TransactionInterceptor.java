package cn.dev.youngsmith.stockanalysis.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@Interceptor
public class TransactionInterceptor implements Serializable {
	private static final long serialVersionUID = -5911704948168768909L;
	private final Logger LOGGER = LoggerFactory.getLogger(TransactionInterceptor.class);

	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception {
		// EntityManager em=threadLocal.get();
		Object target = ctx.getTarget();
		LOGGER.debug(target.toString());
		Method method = target.getClass().getMethod("getEntityManager");
		if (method == null) {
			LOGGER.info("Not need transaction");
			return ctx.proceed();
		}

		EntityManager em = (EntityManager) method.invoke(target);
		LOGGER.debug("interceptor {} ==> {}", ctx.getMethod(), em);

		Object ret = null;
		// avoid multi-thread issue
		synchronized (target) {
			em.getTransaction().begin();
			try {
				ret = ctx.proceed();
				em.getTransaction().commit();
			} catch (Exception ex) {
				LOGGER.debug("got exception", ex);
				em.getTransaction().rollback();
				throw ex;
			}
		}
		LOGGER.debug("interceptor finished");
		return ret;
	}
}

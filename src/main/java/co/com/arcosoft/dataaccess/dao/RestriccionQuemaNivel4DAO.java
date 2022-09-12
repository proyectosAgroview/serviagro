package co.com.arcosoft.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.arcosoft.dataaccess.api.HibernateDaoImpl;
import co.com.arcosoft.modelo.RestriccionQuemaNivel4;
import co.com.arcosoft.modelo.RestriccionQuemaNivel4Id;

/**
 * A data access object (DAO) providing persistence and search support for
 * RestriccionQuemaNivel4 entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.RestriccionQuemaNivel4
 */
@Scope("singleton")
@Repository("RestriccionQuemaNivel4DAO")
public class RestriccionQuemaNivel4DAO extends HibernateDaoImpl<RestriccionQuemaNivel4, RestriccionQuemaNivel4Id>
		implements IRestriccionQuemaNivel4DAO {
	private static final Logger log = LoggerFactory.getLogger(RestriccionQuemaNivel4DAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static IRestriccionQuemaNivel4DAO getFromApplicationContext(ApplicationContext ctx) {
		return (IRestriccionQuemaNivel4DAO) ctx.getBean("RestriccionQuemaNivel4DAO");
	}
}

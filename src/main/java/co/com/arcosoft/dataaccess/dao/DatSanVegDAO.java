package co.com.arcosoft.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.arcosoft.dataaccess.api.HibernateDaoImpl;
import co.com.arcosoft.modelo.DatSanVeg;

/**
 * A data access object (DAO) providing persistence and search support for
 * DatSanVeg entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 *
 * @see lidis.DatSanVeg
 */
@Scope("singleton")
@Repository("DatSanVegDAO")
public class DatSanVegDAO extends HibernateDaoImpl<DatSanVeg, Long> implements IDatSanVegDAO {
	private static final Logger log = LoggerFactory.getLogger(DatSanVegDAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static IDatSanVegDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IDatSanVegDAO) ctx.getBean("DatSanVegDAO");
	}
}
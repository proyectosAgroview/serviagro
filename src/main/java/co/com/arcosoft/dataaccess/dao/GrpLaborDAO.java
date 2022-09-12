package co.com.arcosoft.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.arcosoft.dataaccess.api.HibernateDaoImpl;
import co.com.arcosoft.modelo.GrpLabor;

/**
 * A data access object (DAO) providing persistence and search support for
 * GrpLabor entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 *
 * @see lidis.GrpLabor
 */
@Scope("singleton")
@Repository("GrpLaborDAO")
public class GrpLaborDAO extends HibernateDaoImpl<GrpLabor, Long> implements IGrpLaborDAO {
	private static final Logger log = LoggerFactory.getLogger(GrpLaborDAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static IGrpLaborDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IGrpLaborDAO) ctx.getBean("GrpLaborDAO");
	}
}

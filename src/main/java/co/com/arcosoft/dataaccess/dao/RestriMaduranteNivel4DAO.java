package co.com.arcosoft.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.arcosoft.dataaccess.api.HibernateDaoImpl;
import co.com.arcosoft.modelo.RestriMaduranteNivel4;
import co.com.arcosoft.modelo.RestriMaduranteNivel4Id;

/**
 * A data access object (DAO) providing persistence and search support for
 * RestriMaduranteNivel4 entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.RestriMaduranteNivel4
 */
@Scope("singleton")
@Repository("RestriMaduranteNivel4DAO")
public class RestriMaduranteNivel4DAO extends HibernateDaoImpl<RestriMaduranteNivel4, RestriMaduranteNivel4Id>
		implements IRestriMaduranteNivel4DAO {
	private static final Logger log = LoggerFactory.getLogger(RestriMaduranteNivel4DAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static IRestriMaduranteNivel4DAO getFromApplicationContext(ApplicationContext ctx) {
		return (IRestriMaduranteNivel4DAO) ctx.getBean("RestriMaduranteNivel4DAO");
	}
}

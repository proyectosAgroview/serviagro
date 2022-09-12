package co.com.arcosoft.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.arcosoft.dataaccess.api.HibernateDaoImpl;
import co.com.arcosoft.modelo.DatProgramaRiegoDet;

/**
 * A data access object (DAO) providing persistence and search support for
 * DatProgramaRiegoDet entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.DatProgramaRiegoDet
 */
@Scope("singleton")
@Repository("DatProgramaRiegoDetDAO")
public class DatProgramaRiegoDetDAO extends HibernateDaoImpl<DatProgramaRiegoDet, Long>
		implements IDatProgramaRiegoDetDAO {
	private static final Logger log = LoggerFactory.getLogger(DatProgramaRiegoDetDAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static IDatProgramaRiegoDetDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IDatProgramaRiegoDetDAO) ctx.getBean("DatProgramaRiegoDetDAO");
	}
}

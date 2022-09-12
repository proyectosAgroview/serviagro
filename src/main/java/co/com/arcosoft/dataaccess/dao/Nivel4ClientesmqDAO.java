package co.com.arcosoft.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.arcosoft.dataaccess.api.HibernateDaoImpl;
import co.com.arcosoft.modelo.Nivel4Clientesmq;


/**
 * A data access object (DAO) providing persistence and search support for
 * Nivel4Clientesmq entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Nivel4Clientesmq
 */
@Scope("singleton")
@Repository("Nivel4ClientesmqDAO")
public class Nivel4ClientesmqDAO extends HibernateDaoImpl<Nivel4Clientesmq, Long>
    implements INivel4ClientesmqDAO {
    private static final Logger log = LoggerFactory.getLogger(Nivel4ClientesmqDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static INivel4ClientesmqDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (INivel4ClientesmqDAO) ctx.getBean("Nivel4ClientesmqDAO");
    }
}

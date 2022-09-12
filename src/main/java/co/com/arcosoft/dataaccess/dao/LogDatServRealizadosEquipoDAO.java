package co.com.arcosoft.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.arcosoft.dataaccess.api.HibernateDaoImpl;
import co.com.arcosoft.modelo.LogDatServRealizadosEquipo;


/**
 * A data access object (DAO) providing persistence and search support for
 * LogDatServRealizadosEquipo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.LogDatServRealizadosEquipo
 */
@Scope("singleton")
@Repository("LogDatServRealizadosEquipoDAO")
public class LogDatServRealizadosEquipoDAO extends HibernateDaoImpl<LogDatServRealizadosEquipo, Long>
    implements ILogDatServRealizadosEquipoDAO {
    private static final Logger log = LoggerFactory.getLogger(LogDatServRealizadosEquipoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static ILogDatServRealizadosEquipoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ILogDatServRealizadosEquipoDAO) ctx.getBean(
            "LogDatServRealizadosEquipoDAO");
    }
}

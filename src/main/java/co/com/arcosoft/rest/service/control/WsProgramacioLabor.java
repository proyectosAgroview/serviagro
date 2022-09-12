package co.com.arcosoft.rest.service.control;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.arcosoft.rest.service.dto.OrdenDeTrabajoDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/transacciones")
public class WsProgramacioLabor {

	private static final Logger logger = LoggerFactory.getLogger(WsProgramacioLabor.class);

	@Resource
	private SessionFactory sessionFactory;

	/*
	 * Programación de labores
	 * 
	 */

	@RequestMapping(value = "/listarProgramacionLabor", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<OrdenDeTrabajoDTO> obtenerOrdenDeTrabajo(
			@RequestParam(value = "codigocompania", required = true) String codigoCompania,
			@RequestParam(value = "codigosupervisor", required = true) String codigoSupervisor

	) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consulta_orden_trabajo_at (:compania,  :supervisor)");

		q.setString("compania", codigoCompania);
		q.setString("supervisor", codigoSupervisor);

		List l = q.list();
		List<OrdenDeTrabajoDTO> ordenesDeTrabajo = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			ordenesDeTrabajo = new ArrayList<OrdenDeTrabajoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				OrdenDeTrabajoDTO ordenDeTrabajo = new OrdenDeTrabajoDTO();

				BigInteger idPlanLabor = (BigInteger) row[0];
				;
				String ordenTrabajo = (String) row[1];
				BigInteger idCompania = (BigInteger) row[2];
				BigInteger idZona = (BigInteger) row[3];
				String nombreZona = (String) row[4];
				BigInteger idFinca = (BigInteger) row[5];
				String nombreFinca = (String) row[6];
				BigInteger idBloque = (BigInteger) row[7];
				String nombreBloque = (String) row[8];
				BigInteger idLote = (BigInteger) row[9];
				String nombreLote = (String) row[10];
				String codigoTrabajador = (String) row[11];
				String nombreTrabajador = (String) row[12];
				String tipoLabor = (String) row[13];

				ordenDeTrabajo.setIdPlanLabor(idPlanLabor);
				ordenDeTrabajo.setOrdenDeTrabajo(ordenTrabajo);
				ordenDeTrabajo.setIdCompania(idCompania);
				ordenDeTrabajo.setIdZona(idZona);
				ordenDeTrabajo.setNombreZona(nombreZona);
				ordenDeTrabajo.setIdFinca(idFinca);
				ordenDeTrabajo.setNombreFinca(nombreFinca);
				ordenDeTrabajo.setIdBloque(idBloque);
				ordenDeTrabajo.setNombreBloque(nombreBloque);
				ordenDeTrabajo.setIdLote(idLote);
				ordenDeTrabajo.setNombreLote(nombreLote);
				ordenDeTrabajo.setCodigoTrabajador(codigoTrabajador);
				ordenDeTrabajo.setNombreTrabajador(nombreTrabajador);
				ordenDeTrabajo.setTipoLabor(tipoLabor);

				ordenesDeTrabajo.add(ordenDeTrabajo);

			}
		}

		return ordenesDeTrabajo;

	}

}

package co.com.arcosoft.rest.service.control;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
public class WsProgramacioLaborBasadoEnOT {

	private static final Logger logger = LoggerFactory.getLogger(WsProgramacioLaborBasadoEnOT.class);

	@Resource
	private SessionFactory sessionFactory;

	/*
	 * Programación de labores
	 * 
	 */

	@RequestMapping(value = "/listarProgramacionLaborBasadoEnOT", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<OrdenDeTrabajoDTO> obtenerOrdenDeTrabajo(
			@RequestParam(value = "codigocompania", required = true) String codigoCompania,
			@RequestParam(value = "codigosupervisor", required = true) String codigoSupervisor

	) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consulta_orden_trabajo_basado_en_os (:compania,  :supervisor)");

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
				
				String ordenTrabajo = (String) row[1];
				BigInteger idCompania = (BigInteger) row[2];
				Date periodoInicial = (Date) row[3];
				String periodoInicial1 = periodoInicial.toString().substring(0, 10);
				Date periodoFinal = (Date) row[4];
				String periodoFinal1 = periodoFinal.toString().substring(0, 10);
				BigInteger idLabor = (BigInteger) row[5];
				String nombreLabor = (String) row[6];
				BigInteger idZona = (BigInteger) row[7];
				String nombreZona = (String) row[8];
				BigInteger idFinca = (BigInteger) row[9];
				String nombreFinca = (String) row[10];
				BigInteger idBloque = (BigInteger) row[11];
				String nombreBloque = (String) row[12];
				BigInteger idLote = (BigInteger) row[13];
				String nombreLote = (String) row[14];
				BigDecimal cantidadPlaneada = (BigDecimal) row[15];
				BigDecimal numeroPases = (BigDecimal) row[16];
				BigInteger codigoUnidadMedida = (BigInteger) row[17];
				String nombreUnidadMedida = (String) row[18];
				String codigoTrabajador = (String) row[19];
				String nombreTrabajador = (String) row[20];
				String tipoLabor = (String) row[21];

				ordenDeTrabajo.setIdPlanLabor(idPlanLabor);
				ordenDeTrabajo.setOrdenDeTrabajo(ordenTrabajo);
				ordenDeTrabajo.setIdCompania(idCompania);
				ordenDeTrabajo.setPeriodoInicial(periodoInicial1);
				ordenDeTrabajo.setPeriodoFinal(periodoFinal1);
				ordenDeTrabajo.setIdLabor(idLabor);
				ordenDeTrabajo.setNombreLabor(nombreLabor);
				ordenDeTrabajo.setIdZona(idZona);
				ordenDeTrabajo.setNombreZona(nombreZona);
				ordenDeTrabajo.setIdFinca(idFinca);
				ordenDeTrabajo.setNombreFinca(nombreFinca);
				ordenDeTrabajo.setIdBloque(idBloque);
				ordenDeTrabajo.setNombreBloque(nombreBloque);
				ordenDeTrabajo.setIdLote(idLote);
				ordenDeTrabajo.setNombreLote(nombreLote);
				ordenDeTrabajo.setCantidadPlaneada(cantidadPlaneada);
				ordenDeTrabajo.setNumeroPases(numeroPases);
				ordenDeTrabajo.setCodigoUnidadMedida(codigoUnidadMedida);
				ordenDeTrabajo.setNombreUnidadMedida(nombreUnidadMedida);
				ordenDeTrabajo.setCodigoTrabajador(codigoTrabajador);
				ordenDeTrabajo.setNombreTrabajador(nombreTrabajador);
				ordenDeTrabajo.setTipoLabor(tipoLabor);
				ordenesDeTrabajo.add(ordenDeTrabajo);

			}
		}
		session.close();
		return ordenesDeTrabajo;

	}

}

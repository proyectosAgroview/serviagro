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

import co.com.arcosoft.rest.service.dto.HistoricoLaboresFincaLoteDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/transacciones")
public class WsHistoricoLaboresFincaLote {

	private static final Logger logger = LoggerFactory.getLogger(WsHistoricoLaboresFincaLote.class);

	@Resource
	private SessionFactory sessionFactory;

	/*
	 * Programación de labores
	 * 
	 */

	@RequestMapping(value = "/listarHistoricoLaboresFincaLote", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<HistoricoLaboresFincaLoteDTO> obtenerHistoricoLaboresFincaLote(
			@RequestParam(value = "codigocompania", required = true) String codigoCompania,
			@RequestParam(value = "codigosupervisor", required = true) String codigoSupervisor

	) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_costos_compania_det_mobile (:compania,  :supervisor)");

		q.setString("compania", codigoCompania);
		q.setString("supervisor", codigoSupervisor);

		List l = q.list();
		List<HistoricoLaboresFincaLoteDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<HistoricoLaboresFincaLoteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				HistoricoLaboresFincaLoteDTO reporteA = new HistoricoLaboresFincaLoteDTO();

				BigInteger idLote = (BigInteger) row[0];
				String nombreLote = (String) row[1];
				BigDecimal area = (BigDecimal) row[2];
				Date fechaRegistro = (Date) row[3];
				String nombreLabor = (String) row[4];
				String nombreProducto = (String) row[5];
				BigDecimal cantidadIns = (BigDecimal) row[6];
				String nombreUdadMedIns = (String) row[7];
				BigDecimal costoTotal = (BigDecimal) row[8];
				BigDecimal cantidadCos = (BigDecimal) row[9];

				reporteA.setIdLote(idLote);
				reporteA.setNombreLote(nombreLote);
				reporteA.setArea(area);
				reporteA.setFechaRegistro(fechaRegistro.toString().substring(0, 10));
				reporteA.setNombreLabor(nombreLabor);
				reporteA.setNombreProducto(nombreProducto);
				reporteA.setCantidadIns(cantidadIns);
				reporteA.setNombreUdadMedIns(nombreUdadMedIns);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setCantidadCos(cantidadCos);

				reporte.add(reporteA);

			}
		}

		return reporte;

	}

}

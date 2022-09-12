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

import co.com.arcosoft.rest.service.dto.ProgLaboresMecMaqDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/transacciones")
public class WsReportePlanificacionServiciosMecanizadosOT {

	private static final Logger logger = LoggerFactory.getLogger(WsReportePlanificacionServiciosMecanizadosOT.class);

	@Resource
	private SessionFactory sessionFactory;

	/*
	 * Programación de labores
	 * 
	 */

	@RequestMapping(value = "/listarReportePlanificacionServiciosMecanizadosOT", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ProgLaboresMecMaqDTO> obtenerOrdenDeTrabajo(
			@RequestParam(value = "compania", required = true) String codigoCompania,
			@RequestParam(value = "idzona", required = true) String idZona

	) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_lista_prog_maquinaria_movil (:compania , :zona)");
		Long companiaid = Long.parseLong(codigoCompania);
		Long zona = Long.parseLong(idZona);
		q.setLong("compania", companiaid);
	    q.setLong("zona", zona);

		List l = q.list();
		List<ProgLaboresMecMaqDTO> ordenesDeTrabajo = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			ordenesDeTrabajo = new ArrayList<ProgLaboresMecMaqDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgLaboresMecMaqDTO ordenDeTrabajo = new ProgLaboresMecMaqDTO();

				//BigInteger idPlanLabor = (BigInteger) row[0];
				
				BigInteger	compania	=	(BigInteger) row[	0	];
				Date	periodo_inicial	=	(Date) row[	1	];
				BigInteger	consecutivo	=	(BigInteger) row[	2	];
				BigInteger	dat_plan_servicios_mq_id	=	(BigInteger) row[	3	];
				BigInteger	id_programa	=	(BigInteger) row[	4	];
				BigInteger	labor_id	=	(BigInteger) row[	5	];
				String	cod_labor	=	(String) row[	6	];
				String	nom_labor	=	(String) row[	7	];
				BigDecimal	num_pases	=	(BigDecimal) row[	8	];
				BigInteger	id_supervisor	=	(BigInteger) row[	9	];
				String	cod_supervisor	=	(String) row[	10	];
				String	nom_supervisor	=	(String) row[	11	];
				BigInteger	id_zona	=	(BigInteger) row[	12	];
				String	cod_zona	=	(String) row[	13	];
				String	nom_zona	=	(String) row[	14	];
				BigInteger	id_cliente	=	(BigInteger) row[	15	];
				String	cod_cliente	=	(String) row[	16	];
				String	nom_cliente	=	(String) row[	17	];
				BigInteger	id_finca	=	(BigInteger) row[	18	];
				String	cod_finca	=	(String) row[	19	];
				String	nom_finca	=	(String) row[	20	];
				BigInteger	id_lote	=	(BigInteger) row[	21	];
				String	nom_lote	=	(String) row[	22	];
				BigDecimal	cantidad_plan	=	(BigDecimal) row[	23	];
				BigDecimal	cantidad_pendiente	=	(BigDecimal) row[	24	];
				BigDecimal	cantidad_programada_movil	=	(BigDecimal) row[	25	];
				BigDecimal	area_programada	=	(BigDecimal) row[	26	];
				String	facturado	=	(String) row[	27	];
				String	concluido	=	(String) row[	28	];
				BigInteger	udad_med_id	=	(BigInteger) row[	29	];
				String	cod_udad_med	=	(String) row[	30	];
				String	nom_udad_med	=	(String) row[	31	];
				BigDecimal	valor_est_unitario	=	(BigDecimal) row[	32	];
				BigDecimal	valor_est_total	=	(BigDecimal) row[	33	];
				String	detalle_nota	=	(String) row[	34	];
				BigDecimal	anio_registro	=	(BigDecimal) row[	35	];
				BigDecimal	mes	=	(BigDecimal) row[	36	];
				String	anio_mes	=	(String) row[	37	];
				String 	descripcionOt	=	(String ) row[	38	];
				BigDecimal	cantidadRealizada	=	(BigDecimal) row[	39	];
				String 	fechaEjcucion	=	(String ) row[	40	];
				String 	maquina	=	(String ) row[	41	];
				String 	operador	=	(String ) row[	42	];
				
				ordenDeTrabajo.setFechaEjcucion(fechaEjcucion);
				ordenDeTrabajo.setMaquina(maquina);
				ordenDeTrabajo.setOperador(operador);
				ordenDeTrabajo.setCompania(compania);
				ordenDeTrabajo.setPeriodo_inicial(periodo_inicial);
				ordenDeTrabajo.setConsecutivo(consecutivo);
				ordenDeTrabajo.setDat_plan_servicios_mq_id(dat_plan_servicios_mq_id);
				ordenDeTrabajo.setId_programa(id_programa);
				ordenDeTrabajo.setLabor_id(labor_id);
				ordenDeTrabajo.setCod_labor(cod_labor);
				ordenDeTrabajo.setNom_labor(nom_labor);
				ordenDeTrabajo.setNum_pases(num_pases);
				ordenDeTrabajo.setId_supervisor(id_supervisor);
				ordenDeTrabajo.setCod_supervisor(cod_supervisor);
				ordenDeTrabajo.setNom_supervisor(nom_supervisor);
				ordenDeTrabajo.setId_zona(id_zona);
				ordenDeTrabajo.setCod_zona(cod_zona);
				ordenDeTrabajo.setNom_zona(nom_zona);
				ordenDeTrabajo.setId_cliente(id_cliente);
				ordenDeTrabajo.setCod_cliente(cod_cliente);
				ordenDeTrabajo.setNom_cliente(nom_cliente);
				ordenDeTrabajo.setId_finca(id_finca);
				ordenDeTrabajo.setCod_finca(cod_finca);
				ordenDeTrabajo.setNom_finca(nom_finca);
				ordenDeTrabajo.setId_lote(id_lote);
				ordenDeTrabajo.setNom_lote(nom_lote);
				ordenDeTrabajo.setCantidad_plan(cantidad_plan);
				ordenDeTrabajo.setCantidad_pendiente(cantidad_pendiente);
				ordenDeTrabajo.setCantidad_programada_movil(cantidad_programada_movil);
				ordenDeTrabajo.setArea_programada(area_programada);
				ordenDeTrabajo.setFacturado(facturado);
				ordenDeTrabajo.setConcluido(concluido);
				ordenDeTrabajo.setUdad_med_id(udad_med_id);
				ordenDeTrabajo.setCod_udad_med(cod_udad_med);
				ordenDeTrabajo.setNom_udad_med(nom_udad_med);
				ordenDeTrabajo.setValor_est_unitario(valor_est_unitario);
				ordenDeTrabajo.setValor_est_total(valor_est_total);
				ordenDeTrabajo.setDetalle_nota(detalle_nota);
				ordenDeTrabajo.setAnio_registro(anio_registro);
				ordenDeTrabajo.setMes(mes);
				ordenDeTrabajo.setAnio_mes(anio_mes);
				ordenDeTrabajo.setDescripcionOt(descripcionOt);
				ordenDeTrabajo.setCantidad_realizada(cantidadRealizada);
				
				if(cantidad_plan.doubleValue()>0) {
					ordenesDeTrabajo.add(ordenDeTrabajo);
				}
			}
		}

		return ordenesDeTrabajo;

	}

}

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

import co.com.arcosoft.rest.service.dto.ProgMttoPreventivosMaqDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/transacciones")
public class WsOrdenesMttoMaqDetalle {

	private static final Logger logger = LoggerFactory.getLogger(WsOrdenesMttoMaqDetalle.class);

	@Resource
	private SessionFactory sessionFactory;

	/*
	 * Programación de labores de mtto detalle productos
	 * 
	 */

	@RequestMapping(value = "/listarOrdenesMttoPreventivoMaqDetalle", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ProgMttoPreventivosMaqDTO> obtenerOrdenDeTrabajo(
			@RequestParam(value = "compania", required = true) String codigoCompania,
			@RequestParam(value = "idUsuario", required = true) String idUsuario

	) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_ordenes_mtto_prod_preventivas_movil (:compania , :idUsuario)");

		q.setString("compania", codigoCompania);
	    q.setString("idUsuario", idUsuario);

		List l = q.list();
		List<ProgMttoPreventivosMaqDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ProgMttoPreventivosMaqDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgMttoPreventivosMaqDTO reporteA = new ProgMttoPreventivosMaqDTO();

				BigInteger	id_mtto	=	(BigInteger)	row[0	];
				BigInteger	id_programa	=	(BigInteger)	row[1	];
				Date	fecha_entrada_taller	=	(Date)	row[2	];
				Date	fecha_salida_taller	=	(Date)	row[3	];
				BigInteger	consecutivo	=	(BigInteger)	row[4	];
				BigInteger	id_equipo	=	(BigInteger)	row[5	];
				String	cod_equipo	=	(String)	row[6	];
				String	nom_equipo	=	(String)	row[7	];
				BigDecimal	horo_odo_entrada	=	(BigDecimal)	row[8	];
				BigInteger	id_plan_revision	=	(BigInteger)	row[9	];
				String	cod_plan_revision	=	(String)	row[10	];
				String	nom_plan_revision	=	(String)	row[11	];
				String	cod_solicitante	=	(String)	row[12	];
				String	solicitante	=	(String)	row[13	];
				BigInteger	responsable_mtto	=	(BigInteger)	row[14	];
				String	cod_responsable_tto	=	(String)	row[15	];
				String	nom_responsable_mtto	=	(String)	row[16	];
				BigInteger	id_usuario_responsable	=	(BigInteger)	row[17	];
				BigInteger	id_producto	=	(BigInteger)	row[18	];
				String	nom_producto	=	(String)	row[19	];
				String	um_producto	=	(String)	row[20	];
				BigDecimal	cantidad	=	(BigDecimal)	row[21	];

				String descripcion_solicitud	 =	(String)	row[22	];
				String descripcion_ot =	(String)	row[23	];

				reporteA.setId_mtto(id_mtto);
				reporteA.setId_programa(id_programa);
				reporteA.setFecha_entrada_taller(fecha_entrada_taller);
				reporteA.setFecha_salida_taller(fecha_salida_taller);
				reporteA.setConsecutivo(consecutivo);
				reporteA.setId_equipo(id_equipo);
				reporteA.setCod_equipo(cod_equipo);
				reporteA.setNom_equipo(nom_equipo);
				reporteA.setHoro_odo_entrada(horo_odo_entrada);
				reporteA.setId_plan_revision(id_plan_revision);
				reporteA.setCod_plan_revision(cod_plan_revision);
				reporteA.setNom_plan_revision(nom_plan_revision);
				reporteA.setCod_solicitante(cod_solicitante);
				reporteA.setSolicitante(solicitante);
				reporteA.setResponsable_mtto(responsable_mtto);
				reporteA.setCod_responsable_tto(cod_responsable_tto);
				reporteA.setNom_responsable_mtto(nom_responsable_mtto);
				reporteA.setId_usuario_responsable(id_usuario_responsable);
				reporteA.setId_producto(id_producto);
				reporteA.setNom_producto(nom_producto);
				reporteA.setUm_producto(um_producto);
				reporteA.setCantidad(cantidad);
				reporteA.setDescripcion_solicitud(descripcion_solicitud);
				reporteA.setDescripcion_ot(descripcion_ot);


				reporte.add(reporteA);

			}
		}
		session.close();
		return reporte;

	}

}

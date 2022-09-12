package co.com.arcosoft.rest.service.control;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

import co.com.arcosoft.rest.service.dto.SaldoBodegaProductoDTO;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/transacciones")
public class WsSaldosPorProducto {

	private static final Logger logger = LoggerFactory.getLogger(WsSaldosPorProducto.class);

	@Resource
	private SessionFactory sessionFactory;

	/*
	 * Programación de labores
	 * 
	 */

	@RequestMapping(value = "/listarSaldosProducto", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<SaldoBodegaProductoDTO> obtenerSaldoProducto(
			@RequestParam(value = "compania", required = true) String codigoCompania
			) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro =null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);
		fechaFinalDateRegistro = sdf.parse(fsalida);
		
		 GregorianCalendar calendar = new GregorianCalendar();
		 Date date = new Date();
		 calendar.setTime(date); // Configuramos la fecha que se
		 calendar.add(GregorianCalendar.DAY_OF_YEAR, 365); 
			
		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_inventario_saldo_producto (:compania, :fechaInicial,  :fechaFinal, "
						+ ":almacen, :flagAlmacen, :producto, :flagProducto )");
		
		q.setString("compania", codigoCompania);
		q.setDate("fechaInicial", fechaFinalDateRegistro);
		q.setDate("fechaFinal", calendar.getTime());
		q.setString("almacen", "0");
		q.setLong("flagAlmacen", 1l);
		q.setString("producto", "0");
		q.setLong("flagProducto", 1l);

		List l = q.list();
		List<SaldoBodegaProductoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<SaldoBodegaProductoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				SaldoBodegaProductoDTO reporteA = new SaldoBodegaProductoDTO();

				String fechaEntrada = (String) row[0];
				reporteA.setFechaEntrada(fechaEntrada);
				String fechaSalida = (String) row[1];
				reporteA.setFechaSalida(fechaSalida);
				String codTipoProducto = (String) row[2];
				reporteA.setCodTipoProducto(codTipoProducto);
				String nomTipoProducto = (String) row[3];
				reporteA.setNomTipoProducto(nomTipoProducto);
				String cod_producto = (String) row[4];
				reporteA.setCodProducto(cod_producto);
				String nom_producto = (String) row[5];
				reporteA.setNomProducto(nom_producto);
				BigDecimal cantidadIngresada = (BigDecimal) row[6];
				reporteA.setCantidadIngresada(cantidadIngresada);
				BigDecimal cantidadSalida = (BigDecimal) row[7];
				reporteA.setCantidadSalida(cantidadSalida);
				BigDecimal cantidadDisponible = (BigDecimal) row[8];
				reporteA.setCantidadDisponible(cantidadDisponible);
				BigDecimal valor_unitario = (BigDecimal) row[10];
				reporteA.setV_unitario(valor_unitario);
				BigDecimal costo_total = (BigDecimal) row[9];
				reporteA.setCosto_total(costo_total);

				String nom_udad_med = (String) row[12];
				reporteA.setNombreUdadMed(nom_udad_med);
				String cod_almacen = (String) row[13];
				reporteA.setCodAlmacen(cod_almacen);
				String nom_almacen = (String) row[14];
				reporteA.setAlmacen(nom_almacen);
				String referencia = (String) row[15];
				reporteA.setReferencia(referencia);

				reporte.add(reporteA);
			}
			session.close();
			
		}
		return reporte;
	}

}

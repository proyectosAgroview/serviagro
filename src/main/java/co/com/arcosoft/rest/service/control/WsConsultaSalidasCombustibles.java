package co.com.arcosoft.rest.service.control;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedProperty;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.rest.service.dto.ConsultaSalidaCombustibleDTO;
import co.com.arcosoft.rest.service.dto.ProgLaboresMecMaqDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/transacciones")
public class WsConsultaSalidasCombustibles {

	private static final Logger logger = LoggerFactory.getLogger(WsConsultaSalidasCombustibles.class);

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@Resource
	private SessionFactory sessionFactory;

	/*
	 * Programación de labores
	 * 
	 */

	@RequestMapping(value = "/consultaSalidaCombustible", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ConsultaSalidaCombustibleDTO> obtenerSalidaCombustible(
			@RequestParam(value = "compania", required = true) Long codigoCompania,
			@RequestParam(value = "fecha", required = true) String fecha,
			@RequestParam(value = "idUsuario", required = true) Long idUsuario

	) throws Exception {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_consulta_combustible_movil (:compania, :fechaInicial,  :fechaFinal, "
				+ ":contratista, :flagContratista, :producto, :flagProducto, :almacen, "
				+ ":flagAlmacen, :conceptokardex, :flagConceptokardex, :conseckardex, :factura , :usuario, :equipo, :flagEquipo, :tipoMovimiento)");

		
		Compania compania = businessDelegatorView.getCompania(codigoCompania);
		String productoCombustibleId = "0";
		Long flagCombustible = 1l;
		
		if(compania.getProductoCombustibleId()!=null) {
			productoCombustibleId = compania.getProductoCombustibleId().toString();
			flagCombustible =0L;
		}
			
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

		Date fechaOriginal = foriginal.parse(fecha);
		
		q.setLong("compania", codigoCompania);
		q.setDate("fechaInicial", fechaOriginal);
		q.setDate("fechaFinal", fechaOriginal);
		q.setString("contratista", "0");
		q.setString("producto", productoCombustibleId);
		q.setString("almacen", "0");
		q.setString("conceptokardex", "0");
		q.setLong("flagContratista", 1l);
		q.setLong("flagProducto", flagCombustible);
		q.setLong("flagAlmacen", 1l);
		q.setLong("flagConceptokardex", 1l);
		q.setLong("conseckardex", 0l);
		q.setLong("factura", 0l);
		q.setLong("usuario", idUsuario);
		q.setString("equipo", "0");
		q.setLong("flagEquipo", 1l);
		q.setString("tipoMovimiento", "0");

		List l = q.list();
		List<ConsultaSalidaCombustibleDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaSalidaCombustibleDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaSalidaCombustibleDTO reporteA = new ConsultaSalidaCombustibleDTO();

				BigInteger precioProdid = (BigInteger) row[0];
				Date fecha_registro = (Date) row[1];
				BigDecimal anio = (BigDecimal) row[2];
				BigDecimal mes = (BigDecimal) row[3];
				String anio_mes = (String) row[4];
				BigInteger num_factura = (BigInteger) row[5];
				String cod_proveedor = (String) row[6];
				String nom_proveedor = (String) row[7];
				String cod_producto = (String) row[8];
				String nom_producto = (String) row[9];
				BigDecimal valor_unitario = (BigDecimal) row[10];
				BigDecimal cantidad_compra = (BigDecimal) row[11];
				String cod_equipo = (String) row[12];
				String nom_equipo = (String) row[13];
				String cod_udad_med = (String) row[14];
				String nom_udad_med = (String) row[15];
				String cod_almacen = (String) row[16];
				String nom_almacen = (String) row[17];
				String cod_concepto_kardex = (String) row[18];
				String nom_concepto_kardex = (String) row[19];
				String tipo_movimiento = (String) row[20];
				String cod_trabajador = (String) row[21];
				String nom_trabajador = (String) row[22];
				BigDecimal costoTotal = (BigDecimal) row[23];
				BigInteger documentoKardex = (BigInteger) row[24];
				BigDecimal cantidadEntrada = (BigDecimal) row[25];
				BigDecimal cantidadSalida = (BigDecimal) row[26];
				BigDecimal costoEntrada = (BigDecimal) row[27];
				BigDecimal costoSalida = (BigDecimal) row[28];
				BigInteger consecutivoPin = (BigInteger) row[29];
				String transportadora = (String) row[30];
				String nguia = (String) row[31];
				BigDecimal flete = (BigDecimal) row[32];
				String codHacienda = (String) row[33];
				String codSuerte = (String) row[34];
				BigInteger consecutivoRdl = (BigInteger) row[35];
				BigDecimal horometroAbastecimiento = (BigDecimal) row[36];
				String usuarioDigitador = (String) row[37];
				
				BigDecimal consumo_gl_hora_estandar = (BigDecimal) row[38];
				BigInteger equipo_id = (BigInteger) row[39];
				BigDecimal hor_odo_abastecimiento_inicial = (BigDecimal) row[40];
				BigDecimal horometro_abastecimiento_anterior = (BigDecimal) row[41];
				
				BigDecimal horas = (BigDecimal) row[42];
				BigDecimal gl_hora = (BigDecimal) row[43];
				
				String infoAdicional = (String) row[44];
				
				
				String nombrePeso1 = "#17b55e";
				reporteA.setColor(nombrePeso1);
				if (consumo_gl_hora_estandar.doubleValue() >0 &&  gl_hora.doubleValue()  > consumo_gl_hora_estandar.doubleValue()  ) {
					nombrePeso1 = "#F85B5B";
					reporteA.setColor(nombrePeso1);
				} else {
					nombrePeso1 = "#17b55e";
					reporteA.setColor(nombrePeso1);
				}
				
				reporteA.setInfoAdicional(infoAdicional);
				reporteA.setGlHorasEstandar(consumo_gl_hora_estandar);
				reporteA.setEquipoId(equipo_id);
				reporteA.setHorOdoAbastecimientoInicial(hor_odo_abastecimiento_inicial);
				reporteA.setHorometroAbastecimientoAnterior(horometro_abastecimiento_anterior);
				reporteA.setHoras(horas);
				reporteA.setGlHoras(gl_hora);
				
				
				reporteA.setUsuarioDigitador(usuarioDigitador);
				reporteA.setHorometroAbastecimiento(horometroAbastecimiento);
				reporteA.setConsecutivoRdl(consecutivoRdl);
				reporteA.setPrecioProdid(precioProdid);
				reporteA.setFecha_registro(fecha_registro);
				reporteA.setAnio(anio);
				reporteA.setMes(mes);
				reporteA.setAnio_mes(anio_mes);
				reporteA.setNum_factura(num_factura);
				reporteA.setCod_proveedor(cod_proveedor);
				reporteA.setNom_proveedor(nom_proveedor);
				reporteA.setCod_producto(cod_producto);
				reporteA.setNom_producto(nom_producto);
				reporteA.setValor_unitario(valor_unitario);
				reporteA.setCantidad_compra(cantidad_compra);
				reporteA.setCod_equipo(cod_equipo);
				reporteA.setNom_equipo(nom_equipo);
				reporteA.setCod_udad_med(cod_udad_med);
				reporteA.setNom_udad_med(nom_udad_med);
				reporteA.setCod_almacen(cod_almacen);
				reporteA.setNom_almacen(nom_almacen);
				reporteA.setCod_concepto_kardex(cod_concepto_kardex);
				reporteA.setNom_concepto_kardex(nom_concepto_kardex);
				reporteA.setTipo_movimiento(tipo_movimiento);
				reporteA.setCod_trabajador(cod_trabajador);
				reporteA.setNom_trabajador(nom_trabajador);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setDocumentoKardex(documentoKardex);
				reporteA.setCantidadEntrada(cantidadEntrada);
				reporteA.setCantidadSalida(cantidadSalida);
				reporteA.setCostoEntrada(costoEntrada);
				reporteA.setCostoSalida(costoSalida);
				reporteA.setConsecutivoPin(consecutivoPin);
				reporteA.setTransportadora(transportadora);
				reporteA.setnGuia(nguia);
				reporteA.setFlete(flete);
				reporteA.setCodHacienda(codHacienda);
				reporteA.setCodSuerte(codSuerte);

				reporte.add(reporteA);
			}
			session.close();
		}

		return reporte;

	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	

}

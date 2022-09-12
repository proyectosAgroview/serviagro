package co.com.arcosoft.dataaccess.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDTO;
import co.com.arcosoft.modelo.dto.DatPlanLaborDTO;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaDTO;
import co.com.arcosoft.modelo.dto.DatTransProdDTO;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogoPlanRevisionDTO;
import co.com.arcosoft.modelo.informes.dto.ConsolidadoNominaDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCajaMenorDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraMateriaPrimaDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaComprobantePagoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCostosDiferidosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaDiferidosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaOtrosMovimientosInventarioDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaProgLaboresMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaProvisioncesMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaRegistrosUsuariosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaStockMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.CosechasLoteDTO;
import co.com.arcosoft.modelo.informes.dto.CostosIndirectosEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.CostosTotalesDTO;
import co.com.arcosoft.modelo.informes.dto.CuadroPrecipitacionDiariaDTO;
import co.com.arcosoft.modelo.informes.dto.DesprendiblePagoDTO;
import co.com.arcosoft.modelo.informes.dto.DistribuccionCostosMaquinaDTO;
import co.com.arcosoft.modelo.informes.dto.FacturaServiciosConsolidadosDTO;
import co.com.arcosoft.modelo.informes.dto.FacturaServiciosConsolidadosTercerosDTO;
import co.com.arcosoft.modelo.informes.dto.ImportarNominaEmpAdmonDTO;
import co.com.arcosoft.modelo.informes.dto.ListaProduccionDTO;
import co.com.arcosoft.modelo.informes.dto.ListaEquiposCategoriaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaLaboresDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel2ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ListaPlanillaNominaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaPlanillaNominaDetalladoDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoPinesMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoProvisionesDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoProximosMttoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.NominaDetalladaDTO;
import co.com.arcosoft.modelo.informes.dto.PagosNotasClientesDTO;
import co.com.arcosoft.modelo.informes.dto.ProduccionAcumFincaDTO;
import co.com.arcosoft.modelo.informes.dto.ProgLaboresMecMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgMttoPreventivosMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgramacionLaboresMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ProntuarioLotesDTO;
import co.com.arcosoft.modelo.informes.dto.SolicitudesMttoEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaDTO;
import co.com.arcosoft.modelo.informes.dto.logServiciosMaqDTO;


@Service("Informes2DAO")
public class Informes2DAO implements IInformes2DAO {

	@Resource
	private SessionFactory sessionFactory;


	public Informes2DAO() {
		super();
	}
	
	public String getAutoridad() {
		
		String rol = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			for (GrantedAuthority auth : userDetails.getAuthorities()) {
				rol = auth.getAuthority();
			}
		} 
		
		return rol;
		
	}
	
	public List<TiquetesBasculaDTO> consultarEstadoVehiculoPr(Long compania1, Date fechaInicial, Date fechaFinal, String tipoMovimiento,
			String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoEquipos, String estadoEquipos, String selectedTiquet, Long flagTiquet, String tiquete_peso_neto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consultar_estado_tiquete_bascula (:compania1, :fechaInicial, :fechaFinal, :tipoTransaccion1, :flagTipoTransaccion, :equipo1, "
						+ ":flagEquipo, :tiquete, :flagTiquete, :estado1, :flagEstado, :tipoMovimiento, :tiquete_peso_neto)");

		q.setLong("compania1", compania1);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tipoTransaccion1", tipoTransaccion);
		q.setLong("flagTipoTransaccion", flagTipoTransaccion);
		q.setString("equipo1", equipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("tiquete", selectedTiquet);
		q.setLong("flagTiquete", flagTiquet);
		q.setString("estado1", estadoEquipos);
		q.setLong("flagEstado", flagEstadoEquipos);
		q.setString("tipoMovimiento", tipoMovimiento);
		q.setString("tiquete_peso_neto", tiquete_peso_neto);
		
		List l = q.list();
		List<TiquetesBasculaDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<TiquetesBasculaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				TiquetesBasculaDTO materiaPrimaLoteA = new TiquetesBasculaDTO();

				BigInteger dat_trans_prod_id = (BigInteger) row[0];
				materiaPrimaLoteA.setDat_trans_prod_id(dat_trans_prod_id);
				BigInteger consecutivo = (BigInteger) row[1];
				materiaPrimaLoteA.setConsecutivo(consecutivo);
				Date fecha_registro = (Date) row[2];
				materiaPrimaLoteA.setFecha_registro(fecha_registro);
				String tipo_transaccion = (String) row[3];
				materiaPrimaLoteA.setTipo_transaccion(tipo_transaccion);
				String equipo1 = (String) row[4];
				materiaPrimaLoteA.setEquipo(equipo1);
				Date fecha_entrada = (Date) row[5];
				materiaPrimaLoteA.setFecha_entrada(fecha_entrada);
				Date fecha_salida = (Date) row[6];
				materiaPrimaLoteA.setFecha_salida(fecha_salida);
				BigDecimal peso_bruto = (BigDecimal) row[7];
				materiaPrimaLoteA.setPeso_bruto(peso_bruto);
				BigDecimal peso_tara = (BigDecimal) row[8];
				materiaPrimaLoteA.setPeso_tara(peso_tara);
				BigDecimal peso_neto = (BigDecimal) row[9];
				materiaPrimaLoteA.setPeso_neto(peso_neto);
				String destino_produccion = (String) row[10];
				materiaPrimaLoteA.setDestino_produccion(destino_produccion);
				BigInteger compania = (BigInteger) row[11];
				materiaPrimaLoteA.setCompania(compania);
				String transportadora = (String) row[12];
				materiaPrimaLoteA.setTransportadora(transportadora);
				String trabajador = (String) row[13];
				materiaPrimaLoteA.setTrabajador(trabajador);
				String observacion = (String) row[14];
				materiaPrimaLoteA.setObservacion(observacion);
				String estado = (String) row[15];
				materiaPrimaLoteA.setEstado(estado);
				String observacion_anular_reg = (String) row[16];
				materiaPrimaLoteA.setObservacion_anular_reg(observacion_anular_reg);
				String vagon1 = (String) row[17];
				materiaPrimaLoteA.setVagon1(vagon1);
				String vagon2 = (String) row[18];
				materiaPrimaLoteA.setVagon2(vagon2);
				String vagon3 = (String) row[19];
				materiaPrimaLoteA.setVagon3(vagon3);
				Date fecha_peso_bruto = (Date) row[20];
				materiaPrimaLoteA.setFecha_peso_bruto(fecha_peso_bruto);
				Date fecha_tara = (Date) row[21];
				materiaPrimaLoteA.setFecha_tara(fecha_tara);
				Date fecha_peso_neto = (Date) row[22];
				materiaPrimaLoteA.setFecha_peso_neto(fecha_peso_neto);
				String numero_sellos = (String) row[23];
				materiaPrimaLoteA.setNumero_sellos(numero_sellos);
				String bascula_tara = (String) row[24];
				materiaPrimaLoteA.setBascula_tara(bascula_tara);
				String bascula_peso_bruto = (String) row[25];
				materiaPrimaLoteA.setBascula_peso_bruto(bascula_peso_bruto);
				String usuario_peso_tara = (String) row[26];
				materiaPrimaLoteA.setUsuario_peso_tara(usuario_peso_tara);
				String usuario_peso_bruto = (String) row[27];
				materiaPrimaLoteA.setUsuario_peso_bruto(usuario_peso_bruto);
				BigDecimal acidez = (BigDecimal) row[28];
				materiaPrimaLoteA.setAcidez(acidez);
				BigDecimal humedad = (BigDecimal) row[29];
				materiaPrimaLoteA.setHumedad(humedad);
				String impurezas = (String) row[30];
				materiaPrimaLoteA.setImpurezas(impurezas);
				BigDecimal variable4 = (BigDecimal) row[31];
				materiaPrimaLoteA.setVariable4(variable4);
				BigDecimal variable5 = (BigDecimal) row[32];
				materiaPrimaLoteA.setVariable5(variable5);
				BigDecimal variable6 = (BigDecimal) row[33];
				materiaPrimaLoteA.setVariable6(variable6);
				BigDecimal variable7 = (BigDecimal) row[34];
				materiaPrimaLoteA.setVariable7(variable7);
				BigDecimal variable8 = (BigDecimal) row[35];
				materiaPrimaLoteA.setVariable8(variable8);
				BigDecimal variable9 = (BigDecimal) row[36];
				materiaPrimaLoteA.setVariable9(variable9);
				BigDecimal variable10 = (BigDecimal) row[37];
				materiaPrimaLoteA.setVariable10(variable10);
				String observacion_analisis = (String) row[38];
				materiaPrimaLoteA.setObservacion_analisis(observacion_analisis);
				Date fecha_anulacion = (Date) row[39];
				materiaPrimaLoteA.setFecha_anulacion(fecha_anulacion);

				String tipoPesajeTara = (String) row[42];
				materiaPrimaLoteA.setTipoPesajeTara(tipoPesajeTara);

				String tipoPesajeBruto = (String) row[43];
				materiaPrimaLoteA.setTipoPesajeBruto(tipoPesajeBruto);
				
				BigInteger consecutivo_peso_neto = (BigInteger) row[45];
				materiaPrimaLoteA.setConsecutivo_peso_neto(consecutivo_peso_neto);

				Date fecha_vehiculo_porteria = (Date) row[46];
				materiaPrimaLoteA.setFecha_vehiculo_porteria(fecha_vehiculo_porteria);
				
				String producto = (String) row[47];
				materiaPrimaLoteA.setProducto(producto);
				
				String estadoEstrue = "false";
				if (estado.equals("I")) {
					estadoEstrue = "true";
					materiaPrimaLoteA.setEstadoTrue(estadoEstrue);
					materiaPrimaLoteA.setEstadoTruePesoNeto(estadoEstrue);
				}
				
				String estadoTrueImprimir = "false";
				if (peso_neto.compareTo(BigDecimal.ZERO) < 1) {
					estadoTrueImprimir = "true";
					materiaPrimaLoteA.setEstadoTrueImprimir(estadoTrueImprimir);
				}
				
				String nombrePeso1 = "#17b55e";
				materiaPrimaLoteA.setColor1(nombrePeso1);
				if (peso_bruto != null && peso_bruto.compareTo(BigDecimal.ZERO) > 0) {
					nombrePeso1 = "#17b55e";
					materiaPrimaLoteA.setColor1(nombrePeso1);
				} else {
					nombrePeso1 = "#FF8000";
					materiaPrimaLoteA.setColor1(nombrePeso1);
				}
				
				String nombrePeso2 = "#17b55e";
				materiaPrimaLoteA.setColor2(nombrePeso2);
				if (peso_tara != null && peso_tara.compareTo(BigDecimal.ZERO) > 0) {
					nombrePeso2 = "#17b55e";
					materiaPrimaLoteA.setColor2(nombrePeso2);
				} else {
					nombrePeso2 = "#FF8000";
					materiaPrimaLoteA.setColor2(nombrePeso2);
				}
				
				String nombrePeso3 = "#17b55e";
				materiaPrimaLoteA.setColor3(nombrePeso3);
				if (peso_tara != null && peso_tara.compareTo(BigDecimal.ZERO) > 0 
						&& peso_bruto != null && peso_bruto.compareTo(BigDecimal.ZERO) > 0) {
					nombrePeso3 = "#17b55e";
					materiaPrimaLoteA.setColor3(nombrePeso3);
				} else {
					nombrePeso3 = "#FF8000";
					materiaPrimaLoteA.setColor3(nombrePeso3);
				}
				
				String rol = getAutoridad();
				if (peso_neto != null && peso_neto.compareTo(BigDecimal.ZERO) > 0) {
					
					if (rol.equals("Administrador")) {
						
						if (estado.equals("I")) {
							
							materiaPrimaLoteA.setEstadoTruePesoNeto("true");
							
						} else {
							
							materiaPrimaLoteA.setEstadoTruePesoNeto("false");
						
						}
						
					} else {
						
						materiaPrimaLoteA.setEstadoTruePesoNeto("true");	
					}
					
				} else {	
					
					if (estado.equals("I")) {
						
						materiaPrimaLoteA.setEstadoTruePesoNeto("true");
						
					} else {
						
						materiaPrimaLoteA.setEstadoTruePesoNeto("false");
					
					}
				}

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}
		session.close();
		return materiaPrimaLote;
		
	}
	
	@Override
	public List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq(Long compania, Long clienteId) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		Compania companiaId = new Compania();

		SQLQuery q = session.createSQLQuery("call pr_lista_nivel2clientesmq (:compania, :clienteId )");
		q.setLong("compania", compania);
		q.setLong("clienteId", clienteId);
		List l = q.list();
		ArrayList<ListaNivel2ClientesmqDTO> ListaNivel2ClientesmqDTO = new ArrayList<ListaNivel2ClientesmqDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaNivel2ClientesmqDTO ListaNivel2ClientesmqDTOs = new ListaNivel2ClientesmqDTO();
				BigInteger id = (BigInteger) row[0];
				String hacienda = (String) row[1];
				String cod_cliente = (String) row[2];
				String nom_cliente = (String) row[3];
				ListaNivel2ClientesmqDTOs.setId(id);
				ListaNivel2ClientesmqDTOs.setHacienda(hacienda);
				ListaNivel2ClientesmqDTOs.setCod_cliente(cod_cliente);
				ListaNivel2ClientesmqDTOs.setNom_cliente(nom_cliente);

				ListaNivel2ClientesmqDTO.add(ListaNivel2ClientesmqDTOs);

				// consultaOtDes.add(consultaOt);

			}
			}
		session.close();

		return ListaNivel2ClientesmqDTO;

	}

	@Override
	public BigDecimal consultarAdicionalManoObra(Long idCompania, Long idLabor, Long idUdadMed, Date fecha,
			Double cantidad) {
		BigDecimal tarifa = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery(
				"call pr_calculo_bonificacion_mo (:idCompania, :idLabor,  :idUdadMed, :fecha, :cantidad )");

		q.setLong("idCompania", idCompania);
		q.setLong("idLabor", idLabor);
		q.setLong("idUdadMed", idUdadMed);
		q.setDouble("cantidad", cantidad);
		q.setDate("fecha", fecha);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal tarifa2 = (BigDecimal) it.next();
				tarifa = tarifa2;
			}
		}
		return tarifa;

	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosMq(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_consulta_serv_realizados_mq (:compania, :fechaInicial,  :fechaFinal, "
						+ " :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[0];
				BigInteger consecutivo = (BigInteger) row[1];
				Date fecha_registro = (Date) row[2];
				BigDecimal anio_registro = (BigDecimal) row[3];
				String anio_mes = (String) row[4];
				BigDecimal mes = (BigDecimal) row[5];
				String cod_equipo = (String) row[6];
				String nom_equipo = (String) row[7];
				String estado = (String) row[8];
				String login = (String) row[9];
				String fecha_creacion = (String) row[10];
				String fecha_modificacion = (String) row[11];
				String origen_datos = (String) row[12];
				String puede_editar_pin = (String) row[13];
				BigInteger consecutivoRDL = (BigInteger) row[14];
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setConsecutivo(consecutivo);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setAnio(anio_registro);
				reporteA.setAnio_mes(anio_mes);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setEstado(estado);
				reporteA.setLogin(login);
				reporteA.setFecha_creacion(fecha_creacion);
				reporteA.setFecha_modificacion(fecha_modificacion);
				reporteA.setOrigen_datos(origen_datos);
				reporteA.setPuedeEditarPin(puede_editar_pin);
				reporteA.setConsecutivoRdl(consecutivoRDL);

				String estadoEstrue = "false";
				if (estado.equals("I")) {
					estadoEstrue = "true";
					reporteA.setEstadoTrue(estadoEstrue);
				}

				if (puede_editar_pin != null) {
					if (estado.equals("A") && puede_editar_pin.equals("No")) {
						estadoEstrue = "true";
						reporteA.setEstadoTrue(estadoEstrue);
					}
					if (estado.equals("A") && puede_editar_pin.equals("Si")) {
						estadoEstrue = "false";
						reporteA.setEstadoTrue(estadoEstrue);
					}
				} else {
					estadoEstrue = "true";
				}

				reporteA.setEstadoTrue(estadoEstrue);

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDet(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId, 
			Long consecutivoRdl, Long centCostId) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_serv_realizados_equipo_det (:compania, :estadoServicio, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,  :operador,  :flagOperador,  :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor,   :equipo, :flagEquipo, :pinId, :consecutivoRdl, :centCostId)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("operador", operador);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("equipo", equipo);
		q.setString("estadoServicio", estadoServicio);
		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagOperador", flagOperador);

		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("pinId", pinId);
		q.setLong("consecutivoRdl", consecutivoRdl);
		q.setLong("centCostId", centCostId);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				String cod_finca = (String) row[4];
				String nom_finca = (String) row[5];
				String nom_labor = (String) row[6];
				BigDecimal cantidad_pago = (BigDecimal) row[7];
				String cod_udad_med_pago = (String) row[8];
				String nom_udad_med_pago = (String) row[9];
				BigDecimal horas = (BigDecimal) row[10];
				String nom_lote = (String) row[11];
				Date fecha_registro = (Date) row[12];
				String hora_inicial = (String) row[13];
				String hora_final = (String) row[14];
				BigDecimal horometro_inicial = (BigDecimal) row[15];
				BigDecimal horometro_final = (BigDecimal) row[16];
				String cod_producto = (String) row[17];
				String nom_producto = (String) row[18];
				BigDecimal cantidad_galones = (BigDecimal) row[19];
				String cod_udad_med_ins = (String) row[20];
				String nom_udad_med_ins = (String) row[21];
				BigDecimal costo_combustible = (BigDecimal) row[22];
				BigDecimal gl_hora_prom = (BigDecimal) row[23];
				BigDecimal valor_unitario = (BigDecimal) row[24];
				BigDecimal ingreso_total = (BigDecimal) row[25];
				String cod_cliente = (String) row[26];
				String nom_cliente = (String) row[27];
				BigDecimal sello = (BigDecimal) row[28];
				String turno = (String) row[29];
				String cod_operario = (String) row[30];
				String nom_operario = (String) row[31];
				String cod_concepto_nomina = (String) row[32];
				String nom_concepto_nomina = (String) row[33];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[34];
				String cod_implemento = (String) row[35];
				String nom_implemento = (String) row[36];

				String docFactura = (String) row[37];
				String codLabor = (String) row[38];
				BigInteger pin = (BigInteger) row[39];
				BigInteger idRegistro = (BigInteger) row[40];
				String estatusRegistro = (String) row[41];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[42];
				BigInteger equipoId = (BigInteger) row[43];
				BigDecimal auxilioTransporte = (BigDecimal) row[44];
				BigInteger consecutivoPrefactura = (BigInteger) row[45];

				BigDecimal  valor_unitario_trabajador = (BigDecimal) row[46];
				BigDecimal valor_total_trabajador = (BigDecimal) row[47];
				BigInteger consecRdl = (BigInteger) row[48];
				BigDecimal areaHr = (BigDecimal) row[49];
				BigInteger idProgramacion = (BigInteger) row[50];
				
				String reportar_novedadparada = (String) row[51];
				String tipo_mtto_texto = (String) row[52];
				BigDecimal horometro_mtto = (BigDecimal) row[53];
				String observacion = (String) row[54];
				String nombreCentCosto = (String) row[55];
				String nombreGrupoLabor = (String) row[56];
				
				String nomZonaGeografica = (String) row[57];
				BigDecimal  horometroTanqueo = (BigDecimal) row[58];
				BigDecimal  precioProdId = (BigDecimal) row[59];
				BigDecimal  horometroTanqueoAnterior = (BigDecimal) row[60];
				BigDecimal  horasTanqueo = (BigDecimal) row[61];
				
				
				reporteA.setNomZonaGeografica(nomZonaGeografica);
				reporteA.setHorometroTanqueo(horometroTanqueo);
				reporteA.setPrecioProdId(precioProdId);
				reporteA.setHorometroTanqueoAnterior(horometroTanqueoAnterior);
				reporteA.setHorasTanqueo(horasTanqueo);
				
				reporteA.setNomGrupoGasto(nombreGrupoLabor);
				reporteA.setNombreCentCosto(nombreCentCosto);
				reporteA.setReportar_novedadparada(reportar_novedadparada);
				reporteA.setTipo_mtto_texto(tipo_mtto_texto);
				reporteA.setHorometro_mtto(horometro_mtto);
				reporteA.setObservacion(observacion);
				
				
				reporteA.setIdProgramacion(idProgramacion);
				reporteA.setAreaHr(areaHr);
				reporteA.setConsecutivoRdl(consecRdl);
				
				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCodFinca(cod_finca);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setNomUdadMed(nom_udad_med_pago);
				reporteA.setHoras(horas);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHoraInicial(hora_inicial);
				reporteA.setHoraFinal(hora_final);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setCodProducto(cod_producto);
				reporteA.setNomProducto(nom_producto);
				reporteA.setCantGalones(cantidad_galones);
				reporteA.setCodUdadMedIns(cod_udad_med_ins);
				reporteA.setNomUdadMedIns(nom_udad_med_ins);
				reporteA.setCostoCombustible(costo_combustible);
				reporteA.setGlHoraPromDia(gl_hora_prom);
				reporteA.setHorasEquipoDia(horas);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setSello(sello);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setNom_implemento(nom_implemento);

				reporteA.setDocFactura(docFactura);
				reporteA.setCodLabor(codLabor);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setAuxilio_transporte(auxilioTransporte);
				reporteA.setConsecutivoPrefactura(consecutivoPrefactura);
				
				reporteA.setValor_unitario_trabajador(valor_unitario_trabajador);
				reporteA.setValor_total_trabajador(valor_total_trabajador);
				

				String estadoEstrue = "false";
				if (estatusRegistro.equals("facturado") || estatusRegistro.equals("prefacturado")) {
					estadoEstrue = "true";
					reporteA.setEstadoTrue(estadoEstrue);
				}

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaLiqServRealizadosEquipoOperario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_liq_serv_realizados_equipo_operario (:compania, :fechaInicial,  :fechaFinal,   :operador,  :flagOperador,   :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setString("equipo", equipo);
		q.setLong("flagOperador", flagOperador);
		q.setLong("flagEquipo", flagEquipo);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				BigDecimal cantidad_pago = (BigDecimal) row[4];
				BigDecimal horas = (BigDecimal) row[5];
				Date fecha_registro = (Date) row[6];
				String turno = (String) row[7];
				String cod_operario = (String) row[8];
				String nom_operario = (String) row[9];
				String cod_concepto_nomina = (String) row[10];
				String nom_concepto_nomina = (String) row[11];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[12];
				BigDecimal valor_dia = (BigDecimal) row[13];
				String periodoLiquidacion = (String) row[14];
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setHoras(horas);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setValorDia(valor_dia);
				reporteA.setPeriodoLiquidacion(periodoLiquidacion);
				reporte.add(reporteA);

			}
		
		}
		session.close();
		
		return reporte;
	}

	@Override
	public List<ListaNivel4ClientesmqDTO> listaNivel4Clientesmq(Long compania, String hdaId) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		Compania companiaId = new Compania();

		SQLQuery q = session.createSQLQuery("call pr_lista_nivel4clientesmq (:compania, :hdaId )");
		q.setLong("compania", compania);
		q.setString("hdaId", hdaId);
		List l = q.list();
		ArrayList<ListaNivel4ClientesmqDTO> listaNivel4ClientesmqDTO = new ArrayList<ListaNivel4ClientesmqDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaNivel4ClientesmqDTO listaNivel4ClientesmqDTOs = new ListaNivel4ClientesmqDTO();
				BigInteger id = (BigInteger) row[0];
				String lote = (String) row[1];
				String cod_hda = (String) row[2];
				String nom_hda = (String) row[3];
				BigDecimal area = (BigDecimal) row[4];
				listaNivel4ClientesmqDTOs.setId(id);
				listaNivel4ClientesmqDTOs.setLote(lote);
				listaNivel4ClientesmqDTOs.setCod_hda(cod_hda);
				listaNivel4ClientesmqDTOs.setNom_hda(nom_hda);
				listaNivel4ClientesmqDTOs.setArea(area);
				listaNivel4ClientesmqDTO.add(listaNivel4ClientesmqDTOs);

				// consultaOtDes.add(consultaOt);

			}

		}
		session.close();
		
		return listaNivel4ClientesmqDTO;

	}

	@Override
	public long consultarConsecutivoConsolidadoNominamq(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_consolidado_nominamq (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public Long borrarLiqServRealizadosOperario(Long compania, Date fechaInicial, Date fechaFinal) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_borrar_liq_serv_realizados_operario (:compania, :fechaInicial, :fechaFinal)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	@Override
	public Long interfazLiqServRealizadosEquipoOperario(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String equipo, Long flagEquipo) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_interfaz_liq_serv_realizados_operario (:compania, "
				+ ":fechaInicial, :fechaFinal," + ":trabajador, :flagTrabajador," + ":equipo, :flagEquipo)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("trabajador", trabajador);
		q.setLong("flagTrabajador", flagTrabajador);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);

		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	public String preFecturarServicios(String datservrealizadosequipodetid) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_pre_facturar_servicios (:datservrealizadosequipodetid)");
		q.setString("datservrealizadosequipodetid", datservrealizadosequipodetid);
		q.executeUpdate();

		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return "";

	}

	public String facturarServicios(String datservrealizadosequipodetid) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_facturar_servicios (:datservrealizadosequipodetid)");
		q.setString("datservrealizadosequipodetid", datservrealizadosequipodetid);
		q.executeUpdate();

		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return "";

	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_reporte_serv_prefacturados(
			String datservrealizadosequipodetid) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_reporte_serv_prefacturados (:datservrealizadosequipodetid)");

		q.setString("datservrealizadosequipodetid", datservrealizadosequipodetid);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				String cod_equipo = (String) row[0];
				String nom_finca = (String) row[1];
				String nom_labor = (String) row[2];
				BigDecimal cantidad_pago = (BigDecimal) row[3];
				String cod_udad_med_pago = (String) row[4];
				String nom_lote = (String) row[5];
				Date fecha_registro = (Date) row[6];
				BigDecimal horometro_inicial = (BigDecimal) row[7];
				BigDecimal horometro_final = (BigDecimal) row[8];
				BigDecimal valor_unitario = (BigDecimal) row[9];
				BigDecimal ingreso_total = (BigDecimal) row[10];
				String nom_cliente = (String) row[11];

				String cod_operario = (String) row[12];
				String cod_implemento = (String) row[13];

				String docFactura = (String) row[14];

				BigInteger pin = (BigInteger) row[15];
				BigInteger idRegistro = (BigInteger) row[16];
				String estatusRegistro = (String) row[17];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[18];
				BigInteger equipoId = (BigInteger) row[19];
				BigInteger consecutivoPreFactura = (BigInteger) row[20];
				String direccionCliente = (String) row[21];
				String telefonoCliente = (String) row[22];
				String codCliente = (String) row[23];

				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setCod_operario(cod_operario);
				reporteA.setCod_implemento(cod_implemento);

				reporteA.setDocFactura(docFactura);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);

				reporteA.setConsecutivoPrefactura(consecutivoPreFactura);
				reporteA.setDireccionCliente(direccionCliente);
				reporteA.setTelefonoCliente(telefonoCliente);
				reporteA.setCodCliente(codCliente);

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	public Long actualizarConsecPrefacturaCompania(Long compania) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_comp_actualiza_consec_prefactura (:compania)");
		q.setLong("compania", compania);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		return 1L;

	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_prefacturas_por_cliente(Long clienteId)
			throws Exception {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consulta_prefacturas_por_cliente (:clienteId)");

		q.setLong("clienteId", clienteId);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				String cod_cliente = (String) row[0];
				String nom_cliente = (String) row[1];
				BigInteger consecutivoPreFactura = (BigInteger) row[2];

				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setConsecutivoPrefactura(consecutivoPreFactura);

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_cargar_serv_prefact_cliente(Long clienteId,
			String prefactura) throws Exception {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_cargar_serv_prefact_cliente (:clienteId, :prefactura)");

		q.setLong("clienteId", clienteId);
		q.setString("prefactura", prefactura);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				String cod_finca = (String) row[4];
				String nom_finca = (String) row[5];
				String nom_labor = (String) row[6];
				BigDecimal cantidad_pago = (BigDecimal) row[7];
				String cod_udad_med_pago = (String) row[8];
				String nom_udad_med_pago = (String) row[9];
				BigDecimal horas = (BigDecimal) row[10];
				String nom_lote = (String) row[11];
				Date fecha_registro = (Date) row[12];
				String hora_inicial = (String) row[13];
				String hora_final = (String) row[14];
				BigDecimal horometro_inicial = (BigDecimal) row[15];
				BigDecimal horometro_final = (BigDecimal) row[16];
				String cod_producto = (String) row[17];
				String nom_producto = (String) row[18];
				BigDecimal cantidad_galones = (BigDecimal) row[19];
				String cod_udad_med_ins = (String) row[20];
				String nom_udad_med_ins = (String) row[21];
				BigDecimal costo_combustible = (BigDecimal) row[22];
				BigDecimal horas_equipo_dia = (BigDecimal) row[23];
				BigDecimal valor_unitario = (BigDecimal) row[24];
				BigDecimal ingreso_total = (BigDecimal) row[25];
				String cod_cliente = (String) row[26];
				String nom_cliente = (String) row[27];
				BigDecimal sello = (BigDecimal) row[28];
				String turno = (String) row[29];
				String cod_operario = (String) row[30];
				String nom_operario = (String) row[31];
				String cod_concepto_nomina = (String) row[32];
				String nom_concepto_nomina = (String) row[33];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[34];
				String cod_implemento = (String) row[35];
				String nom_implemento = (String) row[36];

				String docFactura = (String) row[37];
				String codLabor = (String) row[38];
				BigInteger pin = (BigInteger) row[39];
				BigInteger idRegistro = (BigInteger) row[40];
				String estatusRegistro = (String) row[41];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[42];
				BigInteger equipoId = (BigInteger) row[43];
				BigInteger consecutivoPreFactura = (BigInteger) row[44];

				String direccionCliente = (String) row[45];
				String telefonoCliente = (String) row[46];

				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCodFinca(cod_finca);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setNomUdadMed(nom_udad_med_pago);
				reporteA.setHoras(horas);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHoraInicial(hora_inicial);
				reporteA.setHoraFinal(hora_final);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setCodProducto(cod_producto);
				reporteA.setNomProducto(nom_producto);
				reporteA.setCantGalones(cantidad_galones);
				reporteA.setCodUdadMedIns(cod_udad_med_ins);
				reporteA.setNomUdadMedIns(nom_udad_med_ins);
				reporteA.setCostoCombustible(costo_combustible);
				reporteA.setHorasEquipoDia(horas_equipo_dia);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setSello(sello);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setNom_implemento(nom_implemento);

				reporteA.setDocFactura(docFactura);
				reporteA.setCodLabor(codLabor);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setConsecutivoPrefactura(consecutivoPreFactura);
				reporteA.setDireccionCliente(direccionCliente);
				reporteA.setTelefonoCliente(telefonoCliente);

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public long consec_facturacion_servicios(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_facturacion_servicios (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public Long actualizarNumFacturaEnDatServRDet(String datservrealizadosequipodetid, String numfactura) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery(
				"call pr_actualizar_numfactura_datserv_rdet (:datservrealizadosequipodetid, :numfactura)");
		q.setString("datservrealizadosequipodetid", datservrealizadosequipodetid);
		q.setString("numfactura", numfactura);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		return 1L;

	}

	@Override
	public Long anularNumFacturaEnDatServRDet(String datservrealizadosequipodetid, String numfactura) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_anular_numfactura_datserv_rdet (:datservrealizadosequipodetid, :numfactura)");
		q.setString("datservrealizadosequipodetid", datservrealizadosequipodetid);
		q.setString("numfactura", numfactura);

		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		return 1L;

	}

	@Override
	public long consultarConsecutivoDatHerramientas(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_herramientas (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public long consultarConsecutivoPagoNotasClientes(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_pagos_notas_clientes (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public long consultarConsecutivoCajaMenor(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_caja_menor (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public long consultarConsecutivoDatDiferidos(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_diferidos (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public long consultarConsecutivoDatCompraProductos(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_compra_productos (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_factura_serv_consolidada_detal(String factura) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consulta_factura_serv_consolidada_detal (:factura)");

		q.setString("factura", factura);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				String cod_finca = (String) row[4];
				String nom_finca = (String) row[5];
				String nom_labor = (String) row[6];
				BigDecimal cantidad_pago = (BigDecimal) row[7];
				String cod_udad_med_pago = (String) row[8];
				String nom_udad_med_pago = (String) row[9];
				BigDecimal horas = (BigDecimal) row[10];
				String nom_lote = (String) row[11];
				Date fecha_registro = (Date) row[12];
				String hora_inicial = (String) row[13];
				String hora_final = (String) row[14];
				BigDecimal horometro_inicial = (BigDecimal) row[15];
				BigDecimal horometro_final = (BigDecimal) row[16];
				String cod_producto = (String) row[17];
				String nom_producto = (String) row[18];
				BigDecimal cantidad_galones = (BigDecimal) row[19];
				String cod_udad_med_ins = (String) row[20];
				String nom_udad_med_ins = (String) row[21];
				BigDecimal costo_combustible = (BigDecimal) row[22];
				BigDecimal horas_equipo_dia = (BigDecimal) row[23];
				BigDecimal valor_unitario = (BigDecimal) row[24];
				BigDecimal ingreso_total = (BigDecimal) row[25];
				String cod_cliente = (String) row[26];
				String nom_cliente = (String) row[27];
				BigDecimal sello = (BigDecimal) row[28];
				String turno = (String) row[29];
				String cod_operario = (String) row[30];
				String nom_operario = (String) row[31];
				String cod_concepto_nomina = (String) row[32];
				String nom_concepto_nomina = (String) row[33];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[34];
				String cod_implemento = (String) row[35];
				String nom_implemento = (String) row[36];

				String docFactura = (String) row[37];
				String codLabor = (String) row[38];
				BigInteger pin = (BigInteger) row[39];
				BigInteger idRegistro = (BigInteger) row[40];
				String estatusRegistro = (String) row[41];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[42];
				BigInteger equipoId = (BigInteger) row[43];
				BigInteger consecutivoPreFactura = (BigInteger) row[44];

				String direccionCliente = (String) row[45];
				String telefonoCliente = (String) row[46];

				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCodFinca(cod_finca);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setNomUdadMed(nom_udad_med_pago);
				reporteA.setHoras(horas);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHoraInicial(hora_inicial);
				reporteA.setHoraFinal(hora_final);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setCodProducto(cod_producto);
				reporteA.setNomProducto(nom_producto);
				reporteA.setCantGalones(cantidad_galones);
				reporteA.setCodUdadMedIns(cod_udad_med_ins);
				reporteA.setNomUdadMedIns(nom_udad_med_ins);
				reporteA.setCostoCombustible(costo_combustible);
				reporteA.setHorasEquipoDia(horas_equipo_dia);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setSello(sello);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setNom_implemento(nom_implemento);

				reporteA.setDocFactura(docFactura);
				reporteA.setCodLabor(codLabor);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setConsecutivoPrefactura(consecutivoPreFactura);
				reporteA.setDireccionCliente(direccionCliente);
				reporteA.setTelefonoCliente(telefonoCliente);

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public String pr_borrar_factura_servicio_consolidada(String numfactura) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_factura_servicio_consolidada (:numfactura)");
		// q.setString("datservrealizadosequipodetid", datservrealizadosequipodetid);
		q.setString("numfactura", numfactura);

		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		return "";

	}

	@Override
	public String pr_reversar_factura_servicio_consolidada_detal(String numfactura) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_reversar_factura_servicio_consolidada_detal (:numfactura)");
		// q.setString("datservrealizadosequipodetid", datservrealizadosequipodetid);
		q.setString("numfactura", numfactura);

		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		return "";

	}

	@Override
	public List<FacturaServiciosConsolidadosDTO> pr_facturas_consolidadas(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_facturas_consolidadas (:compania, :estadoFactura, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ " :numFactura)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("estadoFactura", estadoFactura);
		q.setLong("flagCliente", flagCliente);
		q.setString("numFactura", numFactura);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<FacturaServiciosConsolidadosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<FacturaServiciosConsolidadosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				FacturaServiciosConsolidadosDTO reporteA = new FacturaServiciosConsolidadosDTO();
				BigInteger dat_factura_servicios_id = (BigInteger) row[0];
				reporteA.setDat_factura_servicios_id(dat_factura_servicios_id);
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				String num_factura = (String) row[2];
				reporteA.setNum_factura(num_factura);
				BigInteger pers_empr_id = (BigInteger) row[3];
				reporteA.setPers_empr_id(pers_empr_id);
				String cod_cliente = (String) row[4];
				reporteA.setCod_cliente(cod_cliente);
				String nom_cliente = (String) row[5];
				reporteA.setNom_cliente(nom_cliente);
				BigInteger companiaid = (BigInteger) row[6];
				reporteA.setCompania(companiaid);
				Date fecha_registro = (Date) row[7];
				reporteA.setFecha_registro(fecha_registro);
				BigDecimal anio = (BigDecimal) row[8];
				reporteA.setAnio(anio);
				BigDecimal mes = (BigDecimal) row[9];
				reporteA.setMes(mes);
				String anio_mes = (String) row[10];
				reporteA.setAnio_mes(anio_mes);
				String fecha_vencimiento = (String) row[11];
				reporteA.setFecha_vencimiento(fecha_vencimiento);
				String forma_pago = (String) row[12];
				reporteA.setForma_pago(forma_pago);
				BigInteger plazo = (BigInteger) row[13];
				reporteA.setPlazo(plazo);
				BigDecimal valor_factura = (BigDecimal) row[14];
				reporteA.setValor_factura(valor_factura);
				BigDecimal retefuente_4porc = (BigDecimal) row[15];
				reporteA.setRetefuente_4porc(retefuente_4porc);
				BigDecimal valor_iva = (BigDecimal) row[16];
				reporteA.setValor_iva(valor_iva);
				BigDecimal retefuente_1porc = (BigDecimal) row[17];
				reporteA.setRetefuente_1porc(retefuente_1porc);
				BigDecimal valor_descuento_cenicana = (BigDecimal) row[18];
				reporteA.setValor_descuento_cenicana(valor_descuento_cenicana);
				BigDecimal valor_rete_ica = (BigDecimal) row[19];
				reporteA.setValor_rete_ica(valor_rete_ica);
				BigDecimal valor_retencion_contrato = (BigDecimal) row[20];
				reporteA.setValor_retencion_contrato(valor_retencion_contrato);
				BigDecimal valor_descuento = (BigDecimal) row[21];
				reporteA.setValor_descuento(valor_descuento);
				BigDecimal valor_base_iva = (BigDecimal) row[22];
				reporteA.setValor_base_iva(valor_base_iva);
				BigDecimal valor_descuento_timbre = (BigDecimal) row[23];
				reporteA.setValor_descuento_timbre(valor_descuento_timbre);
				String detalle_factura = (String) row[24];
				reporteA.setDetalle_factura(detalle_factura);
				String usuario_digitacion = (String) row[25];
				reporteA.setUsuario_digitacion(usuario_digitacion);
				String fecha_creacion = (String) row[26];
				reporteA.setFecha_creacion(fecha_creacion);
				String estado = (String) row[27];
				reporteA.setEstado(estado);
				String observacion_anular_reg = (String) row[28];
				reporteA.setObservacion_anular_reg(observacion_anular_reg);
				String fecha_anulacion = (String) row[29];
				reporteA.setFecha_anulacion(fecha_anulacion);
				String observacion = (String) row[30];
				reporteA.setObservacion(observacion);
				BigInteger num_prefactura = (BigInteger) row[31];
				reporteA.setNum_prefactura(num_prefactura);
				String fecha_modificacion = (String) row[32];
				reporteA.setFecha_modificacion(fecha_modificacion);

				reporte.add(reporteA);

			}
			session.close();
		}

		return reporte;
	}

	@Override
	public List<ListadoPinesMaquinariaDTO> pr_listado_pines_equipo(Long compania, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_facturas_consolidadas (:compania, :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ListadoPinesMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ListadoPinesMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListadoPinesMaquinariaDTO reporteA = new ListadoPinesMaquinariaDTO();
				BigInteger equipo_id = (BigInteger) row[0];
				reporteA.setEquipo_id(equipo_id);
				String cod_equipo = (String) row[1];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[2];
				reporteA.setNom_equipo(nom_equipo);
				BigInteger pin = (BigInteger) row[3];
				reporteA.setPin(pin);
				BigDecimal horometro_inicial = (BigDecimal) row[4];
				reporteA.setHorometro_inicial(horometro_inicial);
				BigDecimal horometro_final = (BigDecimal) row[5];
				reporteA.setHorometro_final(horometro_final);
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[6];
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public List<FacturaServiciosConsolidadosDTO> pr_factura_vs_pago_realizados(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_factura_vs_pago_realizados (:compania, :estadoFactura, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ " :numFactura)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("estadoFactura", estadoFactura);
		q.setLong("flagCliente", flagCliente);
		q.setString("numFactura", numFactura);

		List l = q.list();
		List<FacturaServiciosConsolidadosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<FacturaServiciosConsolidadosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				FacturaServiciosConsolidadosDTO reporteA = new FacturaServiciosConsolidadosDTO();
				BigInteger dat_factura_servicios_id = (BigInteger) row[0];
				reporteA.setDat_factura_servicios_id(dat_factura_servicios_id);
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				String num_factura = (String) row[2];
				reporteA.setNum_factura(num_factura);
				BigInteger pers_empr_id = (BigInteger) row[3];
				reporteA.setPers_empr_id(pers_empr_id);
				String cod_cliente = (String) row[4];
				reporteA.setCod_cliente(cod_cliente);
				String nom_cliente = (String) row[5];
				reporteA.setNom_cliente(nom_cliente);
				BigInteger companiaid = (BigInteger) row[6];
				reporteA.setCompania(companiaid);
				Date fecha_registro = (Date) row[7];
				reporteA.setFecha_registro(fecha_registro);
				BigDecimal anio = (BigDecimal) row[8];
				reporteA.setAnio(anio);
				BigDecimal mes = (BigDecimal) row[9];
				reporteA.setMes(mes);
				String anio_mes = (String) row[10];
				reporteA.setAnio_mes(anio_mes);
				String fecha_vencimiento = (String) row[11];
				reporteA.setFecha_vencimiento(fecha_vencimiento);
				String forma_pago = (String) row[12];
				reporteA.setForma_pago(forma_pago);
				BigInteger plazo = (BigInteger) row[13];
				reporteA.setPlazo(plazo);
				BigDecimal valor_factura = (BigDecimal) row[14];
				reporteA.setValor_factura(valor_factura);
				BigDecimal retefuente_4porc = (BigDecimal) row[15];
				reporteA.setRetefuente_4porc(retefuente_4porc);
				BigDecimal valor_iva = (BigDecimal) row[16];
				reporteA.setValor_iva(valor_iva);
				BigDecimal retefuente_1porc = (BigDecimal) row[17];
				reporteA.setRetefuente_1porc(retefuente_1porc);
				BigDecimal valor_descuento_cenicana = (BigDecimal) row[18];
				reporteA.setValor_descuento_cenicana(valor_descuento_cenicana);
				BigDecimal valor_rete_ica = (BigDecimal) row[19];
				reporteA.setValor_rete_ica(valor_rete_ica);
				BigDecimal valor_retencion_contrato = (BigDecimal) row[20];
				reporteA.setValor_retencion_contrato(valor_retencion_contrato);
				BigDecimal valor_descuento = (BigDecimal) row[21];
				reporteA.setValor_descuento(valor_descuento);
				BigDecimal valor_base_iva = (BigDecimal) row[22];
				reporteA.setValor_base_iva(valor_base_iva);
				BigDecimal valor_descuento_timbre = (BigDecimal) row[23];
				reporteA.setValor_descuento_timbre(valor_descuento_timbre);
				String detalle_factura = (String) row[24];
				reporteA.setDetalle_factura(detalle_factura);
				String usuario_digitacion = (String) row[25];
				reporteA.setUsuario_digitacion(usuario_digitacion);
				String fecha_creacion = (String) row[26];
				reporteA.setFecha_creacion(fecha_creacion);
				String estado = (String) row[27];
				reporteA.setEstado(estado);
				String observacion_anular_reg = (String) row[28];
				reporteA.setObservacion_anular_reg(observacion_anular_reg);
				String fecha_anulacion = (String) row[29];
				reporteA.setFecha_anulacion(fecha_anulacion);
				String observacion = (String) row[30];
				reporteA.setObservacion(observacion);
				BigInteger num_prefactura = (BigInteger) row[31];
				reporteA.setNum_prefactura(num_prefactura);
				String fecha_modificacion = (String) row[32];
				reporteA.setFecha_modificacion(fecha_modificacion);
				String detalle_nota_credito = (String) row[33];
				reporteA.setDetalle_nota_credito(detalle_nota_credito);
				BigDecimal valor_credito = (BigDecimal) row[34];
				reporteA.setValor_credito(valor_credito);
				BigDecimal valor_debito = (BigDecimal) row[35];
				reporteA.setValor_debito(valor_debito);
				String forma_pago_nota = (String) row[36];
				reporteA.setForma_pago_nota(forma_pago_nota);
				String fecha_vencimiento_nota = (String) row[37];
				reporteA.setFecha_vencimiento_nota(fecha_vencimiento_nota);

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public List<FacturaServiciosConsolidadosDTO> pr_saldo_cartera_clientes(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_saldo_cartera_clientes (:compania, :estadoFactura, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ " :numFactura)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("estadoFactura", estadoFactura);
		q.setLong("flagCliente", flagCliente);
		q.setString("numFactura", numFactura);

		List l = q.list();
		List<FacturaServiciosConsolidadosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<FacturaServiciosConsolidadosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				FacturaServiciosConsolidadosDTO reporteA = new FacturaServiciosConsolidadosDTO();
				BigInteger dat_factura_servicios_id = (BigInteger) row[0];
				reporteA.setDat_factura_servicios_id(dat_factura_servicios_id);
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				String num_factura = (String) row[2];
				reporteA.setNum_factura(num_factura);
				BigInteger pers_empr_id = (BigInteger) row[3];
				reporteA.setPers_empr_id(pers_empr_id);
				String cod_cliente = (String) row[4];
				reporteA.setCod_cliente(cod_cliente);
				String nom_cliente = (String) row[5];
				reporteA.setNom_cliente(nom_cliente);
				BigInteger companiaid = (BigInteger) row[6];
				reporteA.setCompania(companiaid);
				Date fecha_registro = (Date) row[7];
				reporteA.setFecha_registro(fecha_registro);
				BigDecimal anio = (BigDecimal) row[8];
				reporteA.setAnio(anio);
				BigDecimal mes = (BigDecimal) row[9];
				reporteA.setMes(mes);
				String anio_mes = (String) row[10];
				reporteA.setAnio_mes(anio_mes);
				String fecha_vencimiento = (String) row[11];
				reporteA.setFecha_vencimiento(fecha_vencimiento);
				String forma_pago = (String) row[12];
				reporteA.setForma_pago(forma_pago);
				BigInteger plazo = (BigInteger) row[13];
				reporteA.setPlazo(plazo);
				BigDecimal valor_factura = (BigDecimal) row[14];
				reporteA.setValor_factura(valor_factura);
				BigDecimal retefuente_4porc = (BigDecimal) row[15];
				reporteA.setRetefuente_4porc(retefuente_4porc);
				BigDecimal valor_iva = (BigDecimal) row[16];
				reporteA.setValor_iva(valor_iva);
				BigDecimal retefuente_1porc = (BigDecimal) row[17];
				reporteA.setRetefuente_1porc(retefuente_1porc);
				BigDecimal valor_descuento_cenicana = (BigDecimal) row[18];
				reporteA.setValor_descuento_cenicana(valor_descuento_cenicana);
				BigDecimal valor_rete_ica = (BigDecimal) row[19];
				reporteA.setValor_rete_ica(valor_rete_ica);
				BigDecimal valor_retencion_contrato = (BigDecimal) row[20];
				reporteA.setValor_retencion_contrato(valor_retencion_contrato);
				BigDecimal valor_descuento = (BigDecimal) row[21];
				reporteA.setValor_descuento(valor_descuento);
				BigDecimal valor_base_iva = (BigDecimal) row[22];
				reporteA.setValor_base_iva(valor_base_iva);
				BigDecimal valor_descuento_timbre = (BigDecimal) row[23];
				reporteA.setValor_descuento_timbre(valor_descuento_timbre);
				String detalle_factura = (String) row[24];
				reporteA.setDetalle_factura(detalle_factura);
				String usuario_digitacion = (String) row[25];
				reporteA.setUsuario_digitacion(usuario_digitacion);
				String fecha_creacion = (String) row[26];
				reporteA.setFecha_creacion(fecha_creacion);
				String estado = (String) row[27];
				reporteA.setEstado(estado);
				String observacion_anular_reg = (String) row[28];
				reporteA.setObservacion_anular_reg(observacion_anular_reg);
				String fecha_anulacion = (String) row[29];
				reporteA.setFecha_anulacion(fecha_anulacion);
				String observacion = (String) row[30];
				reporteA.setObservacion(observacion);
				BigInteger num_prefactura = (BigInteger) row[31];
				reporteA.setNum_prefactura(num_prefactura);
				String fecha_modificacion = (String) row[32];
				reporteA.setFecha_modificacion(fecha_modificacion);
				BigDecimal valor_credito = (BigDecimal) row[33];
				reporteA.setValor_credito(valor_credito);
				BigDecimal valor_debito = (BigDecimal) row[34];
				reporteA.setValor_debito(valor_debito);
				String fecha_vencimiento_nota = (String) row[35];
				reporteA.setFecha_vencimiento_nota(fecha_vencimiento_nota);
				String vencimiento_cartera = (String) row[36];
				reporteA.setVencimiento_cartera(vencimiento_cartera);

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	public Long pr_borrar_equipos_otros_costosmq(Long idOtrosCostosmq) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_equipos_otros_costosmq (:idOtrosCostosmq)");
		q.setLong("idOtrosCostosmq", idOtrosCostosmq);
		q.executeUpdate();

		return 1L;

	}

	@Override
	public List<ListaEquiposCategoriaDTO> pr_lista_equipo(Long categoriaid) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_lista_equipo (:categoriaid)");
		q.setLong("categoriaid", categoriaid);

		List l = q.list();
		ArrayList<ListaEquiposCategoriaDTO> reporte = new ArrayList<ListaEquiposCategoriaDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaEquiposCategoriaDTO reporteA = new ListaEquiposCategoriaDTO();
				BigInteger equipo_id = (BigInteger) row[0];
				reporteA.setEquipo_id(equipo_id);
				String cod_equipo = (String) row[1];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[2];
				reporteA.setNom_equipo(nom_equipo);
				String descripcion = (String) row[3];
				reporteA.setDescripcion(descripcion);
				BigInteger categ_equip_id = (BigInteger) row[4];
				reporteA.setCateg_equip_id(categ_equip_id);
				BigInteger tag_id = (BigInteger) row[5];
				reporteA.setTag_id(tag_id);
				String nomCategoria = (String) row[6];
				reporteA.setNomCategoria(nomCategoria);
				String codCategoria = (String) row[7];
				reporteA.setCodCategoria(codCategoria);
				
				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;

	}

	@Override
	public List<CostosIndirectosEquipoDTO> pr_otros_costos_maquinaria_saz(Long compania, Date fechaInicial,
			Date fechaFinal, String labor, Long flagLabor, Long documento, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_otros_costos_maquinaria_saz (:compania, :fechaInicial,  :fechaFinal, "
						+ " :labor, :flagLabor , :documento, :equipo, :flagEquipo )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("labor", labor);
		q.setString("equipo", equipo);
		q.setLong("documento", documento);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagEquipo", flagEquipo);

		List l = q.list();
		List<CostosIndirectosEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<CostosIndirectosEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosIndirectosEquipoDTO reporteA = new CostosIndirectosEquipoDTO();

				Date fecha = (Date) row[1];
				String tipoTransaccion = (String) row[2];
				BigInteger consecutivo = (BigInteger) row[3];
				String numFactura = (String) row[4];
				String codLabor = (String) row[5];
				String nomLabor = (String) row[6];
				String codEquipo = (String) row[7];
				String nomEquipo = (String) row[8];
				String descripcion = (String) row[9];
				BigDecimal costoTotal = (BigDecimal) row[10];
				String anioMes = (String) row[11];
				BigDecimal anio = (BigDecimal) row[12];
				BigDecimal mes = (BigDecimal) row[13];
				
				String codProveedor = (String) row[14];
				String nomProveedor = (String) row[15];
				BigDecimal horometroServicio = (BigDecimal) row[16];

				reporteA.setCodProveedor(codProveedor);
				reporteA.setNomProveedor(nomProveedor);
				reporteA.setHorometroServicio(horometroServicio);
				
				reporteA.setFecha(fecha);
				reporteA.setTipoTransaccion(tipoTransaccion);
				reporteA.setConsecutivo(consecutivo);
				reporteA.setNumFactura(numFactura);
				reporteA.setCodLabor(codLabor);
				reporteA.setNomLabor(nomLabor);
				reporteA.setCodEquipo(codEquipo);
				reporteA.setNomEquipo(nomEquipo);
				reporteA.setDescripcion(descripcion);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setAnioMes(anioMes);
				reporteA.setAnio(anio);
				reporteA.setMes(mes);

				reporte.add(reporteA);
			}
		}
		session.close();
		
		return reporte;

	}

	@Override
	public List<ConsultaCajaMenorDTO> pr_caja_menor(Long compania, Date fechaInicial, Date fechaFinal, String caja,
			Long flagCaja, String equipo, Long flagEquipo, String labor, Long flagLabor, Long consecutivo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_caja_menor (:compania, :fechaInicial,  :fechaFinal, "
				+ ":caja, :flagCaja, :equipo, :flagEquipo , :labor, :flagLabor, :consecutivo )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("caja", caja);
		q.setString("equipo", equipo);
		q.setString("labor", labor);
		q.setLong("flagCaja", flagCaja);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("flagLabor", flagLabor);
		q.setLong("consecutivo", consecutivo);

		List l = q.list();
		List<ConsultaCajaMenorDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCajaMenorDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCajaMenorDTO reporteA = new ConsultaCajaMenorDTO();
				Date fecha_registro = (Date) row[0];
				reporteA.setFecha_registro(fecha_registro);
				BigDecimal anio = (BigDecimal) row[1];
				reporteA.setAnio(anio);
				BigDecimal mes = (BigDecimal) row[2];
				reporteA.setMes(mes);
				String anio_mes = (String) row[3];
				reporteA.setAnio_mes(anio_mes);
				BigInteger consec = (BigInteger) row[4];
				reporteA.setConsecutivo(consec);
				BigDecimal valor = (BigDecimal) row[5];
				reporteA.setValor(valor);
				String detalle_nota = (String) row[6];
				reporteA.setDetalle_nota(detalle_nota);
				String cod_caja_menor = (String) row[7];
				reporteA.setCod_caja_menor(cod_caja_menor);
				String nom_caja_menor = (String) row[8];
				reporteA.setNom_caja_menor(nom_caja_menor);
				String cod_equipo = (String) row[9];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[10];
				reporteA.setNom_equipo(nom_equipo);
				String login = (String) row[11];
				reporteA.setLogin(login);
				String estado = (String) row[12];
				reporteA.setEstado(estado);
				String nomLabor = (String) row[13];
				reporteA.setNomLabor(nomLabor);

				String codProveedor = (String) row[14];
				reporteA.setCodProveedor(codProveedor);

				String nomProveedor = (String) row[15];
				reporteA.setNomProveedor(nomProveedor);

				String numFactura = (String) row[16];
				reporteA.setNumFactura(numFactura);

				String centroCosto = (String) row[17];
				reporteA.setCentroCosto(centroCosto);

				
				
				reporte.add(reporteA);
			}
		}
		session.close();
		
		return reporte;

	}

	@Override
	public List<ConsultaCompraProductosDTO> pr_compra_productos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_compra_productos (:compania, :fechaInicial,  :fechaFinal, "
				+ ":contratista, :flagContratista, :documento )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);
		q.setLong("documento", documento);

		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

				Date fecha_registro = (Date) row[1];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger consecutivo = (BigInteger) row[2];
				reporteA.setConsecutivo(consecutivo);
				BigInteger num_factura = (BigInteger) row[3];
				reporteA.setNum_factura(num_factura);
				BigDecimal anio = (BigDecimal) row[4];
				reporteA.setAnio(anio);
				BigDecimal mes = (BigDecimal) row[5];
				reporteA.setMes(mes);
				String anio_mes = (String) row[6];
				reporteA.setAnio_mes(anio_mes);
				String cod_proveedor = (String) row[7];
				reporteA.setCod_proveedor(cod_proveedor);
				String nom_proveedor = (String) row[8];
				reporteA.setNom_proveedor(nom_proveedor);
				BigDecimal valor_factura = (BigDecimal) row[9];
				reporteA.setValor_factura(valor_factura);
				BigDecimal valor_iva = (BigDecimal) row[10];
				reporteA.setValor_iva(valor_iva);
				BigDecimal valor_descuento = (BigDecimal) row[11];
				reporteA.setValor_descuento(valor_descuento);
				String detalle_nota = (String) row[12];
				reporteA.setDetalle_nota(detalle_nota);
				String tipo_moneda = (String) row[13];
				reporteA.setTipo_moneda(tipo_moneda);
				BigDecimal tasa_conversion_trm = (BigDecimal) row[14];
				reporteA.setTasa_conversion_trm(tasa_conversion_trm);
				String estado = (String) row[15];
				reporteA.setEstado(estado);
				String cod_producto = (String) row[16];
				reporteA.setCod_producto(cod_producto);
				String nom_producto = (String) row[17];
				reporteA.setNom_producto(nom_producto);
				BigDecimal valor_unitario = (BigDecimal) row[18];
				reporteA.setValor_unitario(valor_unitario);
				BigDecimal cantidad_compra = (BigDecimal) row[19];
				reporteA.setCantidad_compra(cantidad_compra);
				String cod_equipo = (String) row[20];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[21];
				reporteA.setNom_equipo(nom_equipo);
				String cod_udad_med = (String) row[22];
				reporteA.setCod_udad_med(cod_udad_med);
				String nom_udad_med = (String) row[23];
				reporteA.setNom_udad_med(nom_udad_med);
				String cod_almacen = (String) row[24];
				reporteA.setCod_almacen(cod_almacen);
				String nom_almacen = (String) row[25];
				reporteA.setNom_almacen(nom_almacen);

				String num_ot = (String) row[26];
				reporteA.setNumOt(num_ot);
				
				reporte.add(reporteA);
			}
		}
		session.close();
		
		return reporte;

	}

	@Override
	public List<ConsultaCompraProductosDTO> pr_inventario_detalle(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String producto, Long flagProducto, String almacen,
			Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex, Long factura, Long tipoProducto, String origenDatos) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_inventario_detalle (:compania, :fechaInicial,  :fechaFinal, "
				+ ":contratista, :flagContratista, :producto, :flagProducto, :almacen, :flagAlmacen, :conceptokardex, :flagConceptokardex, :conseckardex, :factura, :tipoProducto, :origenDatos )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setString("producto", producto);
		q.setString("almacen", almacen);
		q.setString("conceptokardex", conceptokardex);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setLong("flagConceptokardex", flagConceptokardex);
		q.setLong("conseckardex", conseckardex);
		q.setLong("factura", factura);
		q.setLong("tipoProducto", tipoProducto);
		q.setString("origenDatos", origenDatos);
		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

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
				String codUbicacionAlmacen = (String) row[37];
				String infoAdicional = (String) row[38];
				
				
				reporteA.setInfoAdicional(infoAdicional);
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
				reporteA.setCodUbicacionAlmacen(codUbicacionAlmacen);
				
				String implemento = (String) row[39];
				String nomTipoProducto = (String) row[40];
				reporteA.setNomTipoProducto(nomTipoProducto);
				reporteA.setImplemento(implemento);
				
				
				
				BigInteger consecutivoOt = (BigInteger) row[42];
				reporteA.setConsecutivoOt(consecutivoOt);
				
				String nombreCentroCosto = (String) row[43];
				reporteA.setNombreCentroCosto(nombreCentroCosto);
				
				String nombreGasto = (String) row[44];
				reporteA.setNomLabor(nombreGasto);
				
				reporte.add(reporteA);
			}
		}
		session.close();
		
		return reporte;

	}

	@Override
	public List<ConsultaCostosDiferidosDTO> pr_dat_diferidos(Long compania, Date fechaInicial, Date fechaFinal) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_dat_diferidos (:compania, :fechaInicial,  :fechaFinal  )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);

		List l = q.list();
		List<ConsultaCostosDiferidosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCostosDiferidosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCostosDiferidosDTO reporteA = new ConsultaCostosDiferidosDTO();

				BigInteger consecutivo = (BigInteger) row[0];
				reporteA.setConsecutivo(consecutivo);
				Date fecha_registro = (Date) row[1];
				reporteA.setFecha_registro(fecha_registro);
				BigDecimal valor_cuota = (BigDecimal) row[3];
				reporteA.setValor_cuota(valor_cuota);
				BigInteger periodos = (BigInteger) row[4];
				reporteA.setPeriodos(periodos);
				String detalle_nota = (String) row[5];
				reporteA.setDetalle_nota(detalle_nota);
				BigDecimal anio_aplicacion = (BigDecimal) row[6];
				reporteA.setAnio_aplicacion(anio_aplicacion);
				BigDecimal mes_aplicacion = (BigDecimal) row[7];
				reporteA.setMes_aplicacion(mes_aplicacion);
				String observacion = (String) row[8];
				reporteA.setObservacion(observacion);
				String cod_equipo = (String) row[9];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[10];
				reporteA.setNom_equipo(nom_equipo);
				String numeroFactura = (String) row[11];
				reporteA.setNumeroFactura(numeroFactura);
				Date fecha_diferido = (Date) row[12];
				reporteA.setFecha_diferido(fecha_diferido);
				String cod_gasto = (String) row[13];
				reporteA.setCodGasto(cod_gasto);
				String nom_gasto = (String) row[14];
				reporteA.setNomGasto(nom_gasto);
				String anio_mes_diferido = (String) row[15];
				reporteA.setAnio_mes(anio_mes_diferido);
				
				String codProveedor = (String) row[16];
				reporteA.setCodProveedor(codProveedor);
				
				String nomProveedor = (String) row[17];
				reporteA.setNomProveedor(nomProveedor);
				

				reporte.add(reporteA);
			}
		}
		session.close();
		
		return reporte;

	}

	@Override
	public String busquedaNivel2Clientes(String codNivel2C, Long idpersempr) {
		String codigo = "";
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_busqueda_nivel2_clientes (:codNivel2C, :idpersempr)");
		q.setString("codNivel2C", codNivel2C);
		q.setLong("idpersempr", idpersempr);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				codigo = (String) it.next();

			}
		}
		return codigo;

	}

	@Override
	public String busquedaNivel4Clientes(String codNivel4C, Long idnivel2C) {
		String codigo = "";
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_busqueda_nivel4_clientes (:codNivel4C, :idnivel2C)");
		q.setString("codNivel4C", codNivel4C);
		q.setLong("idnivel2C", idnivel2C);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				codigo = (String) it.next();

			}
		}
		return codigo;

	}

	@Override
	public List<FacturaServiciosConsolidadosDTO> pr_saldo_facturas_cliente(String numFactura) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_saldo_facturas_cliente (:numFactura)");

		q.setString("numFactura", numFactura);

		List l = q.list();
		List<FacturaServiciosConsolidadosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<FacturaServiciosConsolidadosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				FacturaServiciosConsolidadosDTO reporteA = new FacturaServiciosConsolidadosDTO();
				String num_factura = (String) row[0];
				reporteA.setNum_factura(num_factura);
				BigInteger pers_empr_id = (BigInteger) row[1];
				reporteA.setPers_empr_id(pers_empr_id);
				String cod_cliente = (String) row[2];
				reporteA.setCod_cliente(cod_cliente);
				String nom_cliente = (String) row[3];
				reporteA.setNom_cliente(nom_cliente);
				Date fecha_registro = (Date) row[4];
				reporteA.setFecha_registro(fecha_registro);
				BigDecimal anio = (BigDecimal) row[5];
				reporteA.setAnio(anio);
				BigDecimal mes = (BigDecimal) row[6];
				reporteA.setMes(mes);
				String anio_mes = (String) row[7];
				reporteA.setAnio_mes(anio_mes);
				BigDecimal valor_factura = (BigDecimal) row[8];
				reporteA.setValor_factura(valor_factura);
				String detalle_factura = (String) row[9];
				reporteA.setDetalle_factura(detalle_factura);

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public long consec_otros_mov_inventario(Long compania) throws Exception {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_otros_mov_inventario (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public Long pr_reversar_prefactura_servicio(Long clienteId, Long numPrefactura) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_reversar_prefactura_servicio (:clienteId, :numPrefactura)");
		q.setLong("numPrefactura", numPrefactura);
		q.setLong("clienteId", clienteId);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public List<ProntuarioLotesDTO> pr_prontuario_lotes_maquinaria(Long compania, String finca, Long flagFinca,
			String lote, Long flagLote, String proveedor, Long flagProveedor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_prontuario_lotes_maquinaria (:compania,     "
				+ ":finca, :flagFinca,   :lote, :flagLote, :proveedor,  :flagProveedor )");

		q.setLong("compania", compania);
		q.setString("finca", finca);
		q.setString("lote", lote);
		q.setString("proveedor", proveedor);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagLote", flagLote);
		q.setLong("flagProveedor", flagProveedor);

		List l = q.list();
		List<ProntuarioLotesDTO> prontuarioLotes = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			prontuarioLotes = new ArrayList<ProntuarioLotesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProntuarioLotesDTO prontuarioLotesA = new ProntuarioLotesDTO();

				String codProveedor = (String) row[1];
				String nomProveedor = (String) row[2];
				String codFinca = (String) row[3];
				String nomFinca = (String) row[4];

				String codLote = (String) row[5];
				String nomlote = (String) row[6];
				BigDecimal area = (BigDecimal) row[7];
				BigDecimal numPlantasActuales = (BigDecimal) row[8];
				BigInteger nivel4ClientesmqId = (BigInteger) row[9];
				
				prontuarioLotesA.setCodProveedor(codProveedor);
				prontuarioLotesA.setNomProveedor(nomProveedor);
				prontuarioLotesA.setCodFinca(codFinca);
				prontuarioLotesA.setNomFinca(nomFinca);
				prontuarioLotesA.setLoteA(codLote);
				prontuarioLotesA.setNomLote(nomlote);
				prontuarioLotesA.setArea(area);
				prontuarioLotesA.setNumPlantasActuales(numPlantasActuales);
				prontuarioLotesA.setNivel4ClientesMqId(nivel4ClientesmqId);
				prontuarioLotes.add(prontuarioLotesA);

			}
		}
		session.close();
		
		return prontuarioLotes;
	}

	@Override
	public Double pr_saldo_prom_producto(Long idProducto, Long idAlmacen, Long idCompania) throws Exception {
		Double precioPromProducto = 0.0;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery("call pr_saldo_prom_producto ( :idProducto, :idAlmacen,  :idCompania )");

		q.setLong("idProducto", idProducto);
		q.setLong("idAlmacen", idAlmacen);
		q.setLong("idCompania", idCompania);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0 && l.get(0) != null) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal precioPromProducto2 = (BigDecimal) it.next();
				precioPromProducto = precioPromProducto2.doubleValue();
			}
			
			
			
		}
		session.close();
		return precioPromProducto.doubleValue();
	}

	@Override
	public List<ConsultaStockMaquinariaDTO> pr_suministros_para_reposicion(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto) throws Exception {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_suministros_para_reposicion (:compania, :tipoProducto,  :flagTipoProducto, :producto, :flagProducto)");

		q.setLong("compania", compania);
		q.setString("tipoProducto", tipoProducto);
		q.setLong("flagTipoProducto", flagTipoProducto);
		q.setString("producto", producto);
		q.setLong("flagProducto", flagProducto);

		List l = q.list();
		List<ConsultaStockMaquinariaDTO> consulta = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			consulta = new ArrayList<ConsultaStockMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaStockMaquinariaDTO consultaStockDTO = new ConsultaStockMaquinariaDTO();

				String nomTipoProducto = (String) row[0];
				String codProducto = (String) row[1];
				String nomProducto = (String) row[2];
				BigDecimal cantidadDisponible = (BigDecimal) row[3];
				String nombreUdadMed = (String) row[4];
				BigDecimal cantidadIngresada = (BigDecimal) row[5];
				BigDecimal cantidadSalida = (BigDecimal) row[6];
				BigDecimal saldoMinimo = (BigDecimal) row[7];
				String referencia = (String) row[8];

				consultaStockDTO.setNomTipoProducto(nomTipoProducto);
				consultaStockDTO.setCodProducto(codProducto);
				consultaStockDTO.setNomProducto(nomProducto);
				consultaStockDTO.setCantidadDisponible(cantidadDisponible);
				consultaStockDTO.setNombreUdadMed(nombreUdadMed);
				consultaStockDTO.setCantidadIngresada(cantidadIngresada);
				consultaStockDTO.setCantidadSalida(cantidadSalida);
				consultaStockDTO.setSaldoMinimo(saldoMinimo);
				Double cantidadPedido = saldoMinimo.doubleValue() - cantidadDisponible.doubleValue();
				consultaStockDTO.setCantidadPedido(cantidadPedido);
				consultaStockDTO.setReferencia(referencia);

				consulta.add(consultaStockDTO);

			}
		}
		session.close();
		
		return consulta;

	}

	public Long pr_borrar_maq_otros_costosmq(Long idOtrosCostos) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_maq_otros_costosmq (:idOtrosCostos)");
		q.setLong("idOtrosCostos", idOtrosCostos);
		q.executeUpdate();

		return 1L;

	}

	@Override
	public long pr_max_id_unico_dat_compras(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_max_id_unico_dat_compras (:compania)");
		q.setLong("compania", compania);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue();

			}
		}
		return consecutivo;

	}

	@Override
	public long pr_max_id_unico_dat_otros_costos_mq(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_max_id_unico_dat_otros_costos_mq (:compania)");
		q.setLong("compania", compania);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue();

			}
		}
		return consecutivo;

	}

	@Override
	public long pr_max_id_unico_dat_omov_inventario(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_max_id_unico_dat_omov_inventario (:compania)");
		q.setLong("compania", compania);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue();

			}
		}
		return consecutivo;

	}

	@Override
	public Long pr_borrar_suministros_taller(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_suministros_taller (:id)");
		q.setLong("id", id);
		q.executeUpdate();

		return 1L;

	}

	@Override
	public Long pr_recalcular_otros_costosmq(Long id_ocostosmq) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_recalcular_otros_costosmq (:id_ocostosmq)");
		q.setLong("id_ocostosmq", id_ocostosmq);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public Long pr_recalcular_costo_productos(Long id_compras) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_recalcular_costo_productos (:id_compras)");
		q.setLong("id_compras", id_compras);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public Long pr_distri_suministros_taller(Long id_otros_mov_inventario) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_distri_suministros_taller (:id_otros_mov_inventario)");
		q.setLong("id_otros_mov_inventario", id_otros_mov_inventario);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public long consec_req_productos(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_req_productos (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public Long pr_busqueda_maq_ctrpin(Long idEquipo) {
		long idMaq = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_busqueda_maq_ctrpin (:idEquipo)");
		q.setLong("idEquipo", idEquipo);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigInteger idMaqA = (BigInteger) it.next();
				idMaq = idMaqA.longValue();

			}
		}
		return idMaq;

	}

	@Override
	public Long pr_actualiza_maq_ctrpin_consecutivo(Long idmaq, Long consecutivoPin) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_actualiza_maq_ctrpin_consecutivo (:idmaq, :consecutivoPin)");
		q.setLong("idmaq", idmaq);
		q.setLong("consecutivoPin", consecutivoPin);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public Long pr_actualiza_edicion_dat_serv_realizados(Long idmaq, Long consecutivoPin) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_actualiza_edicion_dat_serv_realizados (:idmaq, :consecutivoPin)");
		q.setLong("idmaq", idmaq);
		q.setLong("consecutivoPin", consecutivoPin);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public BigDecimal pr_saldo_total_producto(Long idProducto, Long idCompania) throws Exception {
		BigDecimal precioPromProducto = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery("call pr_saldo_total_producto ( :idProducto,  :idCompania )");

		q.setLong("idProducto", idProducto);
		q.setLong("idCompania", idCompania);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal precioPromProducto2 = (BigDecimal) it.next();
				precioPromProducto = precioPromProducto2;
			}
		}
		return precioPromProducto;

	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDetPendientesFact(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_serv_realizados_equipo_det_pendientesFact (:compania, :estadoServicio, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,  :operador,  :flagOperador,  :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor,   :equipo, :flagEquipo, :pinId,"
						+ ":consecutivoRdl)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("operador", operador);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("equipo", equipo);
		q.setString("estadoServicio", estadoServicio);
		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagOperador", flagOperador);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("pinId", pinId);
		q.setLong("consecutivoRdl", consecutivoRdl);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				String cod_finca = (String) row[4];
				String nom_finca = (String) row[5];
				String nom_labor = (String) row[6];
				BigDecimal cantidad_pago = (BigDecimal) row[7];
				String cod_udad_med_pago = (String) row[8];
				String nom_udad_med_pago = (String) row[9];
				BigDecimal horas = (BigDecimal) row[10];
				String nom_lote = (String) row[11];
				Date fecha_registro = (Date) row[12];
				String hora_inicial = (String) row[13];
				String hora_final = (String) row[14];
				BigDecimal horometro_inicial = (BigDecimal) row[15];
				BigDecimal horometro_final = (BigDecimal) row[16];
				String cod_producto = (String) row[17];
				String nom_producto = (String) row[18];
				BigDecimal cantidad_galones = (BigDecimal) row[19];
				String cod_udad_med_ins = (String) row[20];
				String nom_udad_med_ins = (String) row[21];
				BigDecimal costo_combustible = (BigDecimal) row[22];
				BigDecimal horas_equipo_dia = (BigDecimal) row[23];
				BigDecimal valor_unitario = (BigDecimal) row[24];
				BigDecimal ingreso_total = (BigDecimal) row[25];
				String cod_cliente = (String) row[26];
				String nom_cliente = (String) row[27];
				BigDecimal sello = (BigDecimal) row[28];
				String turno = (String) row[29];
				String cod_operario = (String) row[30];
				String nom_operario = (String) row[31];
				String cod_concepto_nomina = (String) row[32];
				String nom_concepto_nomina = (String) row[33];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[34];
				String cod_implemento = (String) row[35];
				String nom_implemento = (String) row[36];

				String docFactura = (String) row[37];
				String codLabor = (String) row[38];
				BigInteger pin = (BigInteger) row[39];
				BigInteger idRegistro = (BigInteger) row[40];
				String estatusRegistro = (String) row[41];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[42];
				BigInteger equipoId = (BigInteger) row[43];
				BigInteger consecutivo_prefactura = (BigInteger) row[44];
				BigInteger consecRdl = (BigInteger) row[45];
				
				reporteA.setConsecutivoRdl(consecRdl);
				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCodFinca(cod_finca);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setNomUdadMed(nom_udad_med_pago);
				reporteA.setHoras(horas);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHoraInicial(hora_inicial);
				reporteA.setHoraFinal(hora_final);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setCodProducto(cod_producto);
				reporteA.setNomProducto(nom_producto);
				reporteA.setCantGalones(cantidad_galones);
				reporteA.setCodUdadMedIns(cod_udad_med_ins);
				reporteA.setNomUdadMedIns(nom_udad_med_ins);
				reporteA.setCostoCombustible(costo_combustible);
				reporteA.setHorasEquipoDia(horas_equipo_dia);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setSello(sello);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setNom_implemento(nom_implemento);

				reporteA.setDocFactura(docFactura);
				reporteA.setCodLabor(codLabor);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setConsecutivoPrefactura(consecutivo_prefactura);
				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public List<FacturaServiciosConsolidadosDTO> pr_facturas_consolidadas_servdetal(Long cliente, String numFactura) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_facturas_consol_servdetal (:cliente, :numFactura)");

		q.setLong("cliente", cliente);
		q.setString("numFactura", numFactura);
		
		List l = q.list();

		List<FacturaServiciosConsolidadosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<FacturaServiciosConsolidadosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				FacturaServiciosConsolidadosDTO reporteA = new FacturaServiciosConsolidadosDTO();
				BigInteger dat_factura_servicios_id = (BigInteger) row[0];
				reporteA.setDat_factura_servicios_id(dat_factura_servicios_id);
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				String num_factura = (String) row[2];
				reporteA.setNum_factura(num_factura);
				BigInteger pers_empr_id = (BigInteger) row[3];
				reporteA.setPers_empr_id(pers_empr_id);
				String cod_cliente = (String) row[4];
				reporteA.setCod_cliente(cod_cliente);
				String nom_cliente = (String) row[5];
				reporteA.setNom_cliente(nom_cliente);
				BigInteger companiaid = (BigInteger) row[6];
				reporteA.setCompania(companiaid);
				Date fecha_registro = (Date) row[7];
				reporteA.setFecha_registro(fecha_registro);
				BigDecimal anio = (BigDecimal) row[8];
				reporteA.setAnio(anio);
				BigDecimal mes = (BigDecimal) row[9];
				reporteA.setMes(mes);
				String anio_mes = (String) row[10];
				reporteA.setAnio_mes(anio_mes);
				String fecha_vencimiento = (String) row[11];
				reporteA.setFecha_vencimiento(fecha_vencimiento);
				String forma_pago = (String) row[12];
				reporteA.setForma_pago(forma_pago);
				BigInteger plazo = (BigInteger) row[13];
				reporteA.setPlazo(plazo);
				String detalle_factura = (String) row[14];
				reporteA.setDetalle_factura(detalle_factura);

				BigDecimal valor_factura = (BigDecimal) row[15];
				reporteA.setValor_factura(valor_factura);
				BigDecimal totales = (BigDecimal) row[16];
				reporteA.setTotales(totales);

				String codLabor = (String) row[17];
				reporteA.setCodLabor(codLabor);
				String nomLabor = (String) row[18];
				reporteA.setNomLabor(nomLabor);
				String codUdadMed = (String) row[19];
				reporteA.setCodUdadMed(codUdadMed);
				String nomUdadMed = (String) row[20];
				reporteA.setNomUdadMed(nomUdadMed);
				BigDecimal cantidad = (BigDecimal) row[21];
				reporteA.setCantidad(cantidad);
				BigDecimal valorUnitario = (BigDecimal) row[22];
				reporteA.setValorUnitario(valorUnitario);

				String codEquipo = (String) row[23];
				reporteA.setCodEquipo(codEquipo);
				String pin = (String) row[24];
				reporteA.setPin(pin);
				String direccionCliente = (String) row[25];
				reporteA.setDireccionCliente(direccionCliente);
				String telefono = (String) row[26];
				reporteA.setTelefonoCliente(telefono);
				String hacienda = (String) row[27];
				reporteA.setHacienda(hacienda);
				String suerte = (String) row[28];
				reporteA.setSuerte(suerte);
				String concepto = (String) row[29];
				reporteA.setConcepto(concepto);
				BigInteger consecutivoPrefactura = (BigInteger) row[30];
				reporteA.setNum_prefactura(consecutivoPrefactura);

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public long consec_plan_serv_mq(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_plan_serv_mq (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_distribuccion_factura(Long compania, String estadoServicio,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca,
			String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long factura) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_distribuccion_factura (:compania, :estadoServicio, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,  :operador,  :flagOperador,  :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor,   :equipo, :flagEquipo, :pinId, :factura)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("operador", operador);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("equipo", equipo);
		q.setString("estadoServicio", estadoServicio);
		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagOperador", flagOperador);

		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("pinId", pinId);
		q.setLong("factura", factura);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				String cod_finca = (String) row[4];
				String nom_finca = (String) row[5];
				String nom_labor = (String) row[6];
				BigDecimal cantidad_pago = (BigDecimal) row[7];
				String cod_udad_med_pago = (String) row[8];
				String nom_udad_med_pago = (String) row[9];
				BigDecimal horas = (BigDecimal) row[10];
				String nom_lote = (String) row[11];
				Date fecha_registro = (Date) row[12];
				String hora_inicial = (String) row[13];
				String hora_final = (String) row[14];
				BigDecimal horometro_inicial = (BigDecimal) row[15];
				BigDecimal horometro_final = (BigDecimal) row[16];
				String cod_producto = (String) row[17];
				String nom_producto = (String) row[18];
				BigDecimal cantidad_galones = (BigDecimal) row[19];
				String cod_udad_med_ins = (String) row[20];
				String nom_udad_med_ins = (String) row[21];
				BigDecimal costo_combustible = (BigDecimal) row[22];
				BigDecimal horas_equipo_dia = (BigDecimal) row[23];
				BigDecimal valor_unitario = (BigDecimal) row[24];
				BigDecimal ingreso_total = (BigDecimal) row[25];
				String cod_cliente = (String) row[26];
				String nom_cliente = (String) row[27];
				BigDecimal sello = (BigDecimal) row[28];
				String turno = (String) row[29];
				String cod_operario = (String) row[30];
				String nom_operario = (String) row[31];
				String cod_concepto_nomina = (String) row[32];
				String nom_concepto_nomina = (String) row[33];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[34];
				String cod_implemento = (String) row[35];
				String nom_implemento = (String) row[36];

				String docFactura = (String) row[37];
				String codLabor = (String) row[38];
				BigInteger pin = (BigInteger) row[39];
				BigInteger idRegistro = (BigInteger) row[40];
				String estatusRegistro = (String) row[41];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[42];
				BigInteger equipoId = (BigInteger) row[43];
				Date fechaFactura = (Date) row[44];
				String notaFactura = (String) row[45];
				String estatusFactura = (String) row[46];
				BigInteger consecutivoRdl = (BigInteger) row[47];
				
				reporteA.setConsecutivoRdl(consecutivoRdl);
				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCodFinca(cod_finca);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setNomUdadMed(nom_udad_med_pago);
				reporteA.setHoras(horas);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHoraInicial(hora_inicial);
				reporteA.setHoraFinal(hora_final);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setCodProducto(cod_producto);
				reporteA.setNomProducto(nom_producto);
				reporteA.setCantGalones(cantidad_galones);
				reporteA.setCodUdadMedIns(cod_udad_med_ins);
				reporteA.setNomUdadMedIns(nom_udad_med_ins);
				reporteA.setCostoCombustible(costo_combustible);
				reporteA.setHorasEquipoDia(horas_equipo_dia);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setSello(sello);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setNom_implemento(nom_implemento);

				reporteA.setDocFactura(docFactura);
				reporteA.setCodLabor(codLabor);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setFechaFactura(fechaFactura);
				reporteA.setDetalleFactura(notaFactura);
				reporteA.setEstatusFactura(estatusFactura);
				reporte.add(reporteA);

			}
		}
		session.close();
		return reporte;
	}

	@Override
	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_salidas(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex, Long tipoProducto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_inventario_detalle_salidas (:compania, :fechaInicial,  :fechaFinal, "
						+ ":contratista, :flagContratista, :producto, :flagProducto, :almacen, :flagAlmacen, :conceptokardex, :flagConceptokardex, :conseckardex , :tipoProducto)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setString("producto", producto);
		q.setString("almacen", almacen);
		q.setString("conceptokardex", conceptokardex);

		q.setLong("flagContratista", flagContratista);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setLong("flagConceptokardex", flagConceptokardex);
		q.setLong("conseckardex", conseckardex);
		q.setLong("tipoProducto", tipoProducto);

		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

				Date fecha_registro = (Date) row[1];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger precioProdid = (BigInteger) row[0];
				reporteA.setPrecioProdid(precioProdid);
				BigDecimal anio = (BigDecimal) row[2];
				reporteA.setAnio(anio);
				BigDecimal mes = (BigDecimal) row[3];
				reporteA.setMes(mes);
				String anio_mes = (String) row[4];
				reporteA.setAnio_mes(anio_mes);
				String cod_proveedor = (String) row[6];
				reporteA.setCod_proveedor(cod_proveedor);
				String nom_proveedor = (String) row[7];
				reporteA.setNom_proveedor(nom_proveedor);
				String cod_producto = (String) row[8];
				reporteA.setCod_producto(cod_producto);
				String nom_producto = (String) row[9];
				reporteA.setNom_producto(nom_producto);
				BigDecimal valor_unitario = (BigDecimal) row[10];
				reporteA.setValor_unitario(valor_unitario);
				BigDecimal cantidad_compra = (BigDecimal) row[11];
				reporteA.setCantidad_compra(cantidad_compra);
				String cod_equipo = (String) row[12];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[13];
				reporteA.setNom_equipo(nom_equipo);
				String cod_udad_med = (String) row[14];
				reporteA.setCod_udad_med(cod_udad_med);
				String nom_udad_med = (String) row[15];
				reporteA.setNom_udad_med(nom_udad_med);
				String cod_almacen = (String) row[16];
				reporteA.setCod_almacen(cod_almacen);
				String nom_almacen = (String) row[17];
				reporteA.setNom_almacen(nom_almacen);
				String cod_concepto_kardex = (String) row[18];
				reporteA.setCod_concepto_kardex(cod_concepto_kardex);
				String nom_concepto_kardex = (String) row[19];
				reporteA.setNom_concepto_kardex(nom_concepto_kardex);
				String tipo_movimiento = (String) row[20];
				reporteA.setTipo_movimiento(tipo_movimiento);
				String cod_trabajador = (String) row[21];
				reporteA.setCod_trabajador(cod_trabajador);
				String nom_trabajador = (String) row[22];
				reporteA.setNom_trabajador(nom_trabajador);
				BigDecimal costoTotal = (BigDecimal) row[23];
				reporteA.setCostoTotal(costoTotal);
				BigInteger documentoKardex = (BigInteger) row[24];
				reporteA.setDocumentoKardex(documentoKardex);
				BigDecimal cantidadEntrada = (BigDecimal) row[25];
				reporteA.setCantidadEntrada(cantidadEntrada);
				BigDecimal cantidadSalida = (BigDecimal) row[26];
				reporteA.setCantidadSalida(cantidadSalida);
				BigDecimal costoEntrada = (BigDecimal) row[27];
				reporteA.setCostoEntrada(costoEntrada);
				BigDecimal costoSalida = (BigDecimal) row[28];
				reporteA.setCostoSalida(costoSalida);
				BigInteger num_factura = (BigInteger) row[5];
				reporteA.setNum_factura(num_factura);
				BigInteger consecutivoPin = (BigInteger) row[29];
				reporteA.setConsecutivoPin(consecutivoPin);
				BigInteger equipoid = (BigInteger) row[30];
				reporteA.setEquipoId(equipoid);
				String diferido = (String) row[31];
				reporteA.setDiferido(diferido);
				String tipoDoc = (String) row[32];
				reporteA.setTipoDoc(tipoDoc);
				String cod_sucursal = (String) row[33];
				reporteA.setCodSucursal(cod_sucursal);
				
				String implemento = (String) row[34];
				String nomTipoProducto = (String) row[35];
				reporteA.setNomTipoProducto(nomTipoProducto);
				reporteA.setImplemento(implemento);
				
				BigDecimal horAbastecimiento = (BigDecimal) row[36];
				reporteA.setHorometroAbastecimiento(horAbastecimiento);
				
				String nomLabor = (String) row[37];
				reporteA.setNomLabor(nomLabor);
				
				reporte.add(reporteA);
			}
		}
		session.close();
		return reporte;

	}

	@Override
	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_bodega(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String tipoProducto, Long flagTipoProducto

	) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_inventario_saldo_bodega (:compania, :fechaInicial,  :fechaFinal, "
				+ ":almacen, :flagAlmacen, :tipoProducto, :flagTipoProducto )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("almacen", almacen);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setLong("flagTipoProducto",flagTipoProducto);

		q.setString("tipoProducto",tipoProducto);
		List l = q.list();
		List<ConsultaStockMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaStockMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaStockMaquinariaDTO reporteA = new ConsultaStockMaquinariaDTO();

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
				BigDecimal costo_total = (BigDecimal) row[9];
				reporteA.setCosto_total(costo_total);
				BigDecimal valor_unitario = (BigDecimal) row[10];
				reporteA.setV_unitario(valor_unitario);

				String nom_udad_med = (String) row[12];
				reporteA.setNombreUdadMed(nom_udad_med);
				String cod_almacen = (String) row[13];
				reporteA.setCodAlmacen(cod_almacen);
				String nom_almacen = (String) row[14];
				reporteA.setAlmacen(nom_almacen);
				String referencia = (String) row[15];
				reporteA.setReferencia(referencia);

				BigDecimal ndias_para_consumir_producto = (BigDecimal) row[16];
				reporteA.setNdias_para_consumir_producto(ndias_para_consumir_producto);
				BigDecimal ndias_ultima_compra_producto = (BigDecimal) row[17];
				reporteA.setNdias_ultima_compra_producto(ndias_ultima_compra_producto);

				reporte.add(reporteA);
			}
		}
		session.close();
		return reporte;

	}

	@Override
	public List<ProgramacionLaboresMaqDTO> pr_consulta_prog_labormq(Long compania, Date fechaInicial, Date fechaFinal,
			String cliente, Long flagCliente, String finca, Long flagFinca, String operador, Long flagOperador,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String equipo, Long flagEquipo, String zonageografica, Long flagZonaGeografica) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_prog_labormq (:compania,  :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,  :operador,  :flagOperador,  :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor,  "
						+ " :equipo, :flagEquipo, :zonageografica, :flagZonaGeografica )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("operador", operador);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("equipo", equipo);

		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagOperador", flagOperador);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("zonageografica", zonageografica);
		q.setLong("flagZonaGeografica", flagZonaGeografica);

		List l = q.list();
		List<ProgramacionLaboresMaqDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ProgramacionLaboresMaqDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgramacionLaboresMaqDTO reporteA = new ProgramacionLaboresMaqDTO();
				BigDecimal anio_registro = (BigDecimal) row[0];
				reporteA.setAnio_registro(anio_registro);
				BigDecimal mes = (BigDecimal) row[1];
				reporteA.setMes(mes);
				String cod_equipo = (String) row[2];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[3];
				reporteA.setNom_equipo(nom_equipo);
				String cod_finca = (String) row[4];
				reporteA.setCod_finca(cod_finca);
				String nom_finca = (String) row[5];
				reporteA.setNom_finca(nom_finca);
				String nom_labor = (String) row[6];
				reporteA.setNom_labor(nom_labor);
				BigDecimal cantidad_plan = (BigDecimal) row[7];
				reporteA.setCantidad_plan(cantidad_plan);
				BigDecimal cantidad_realizada = (BigDecimal) row[8];
				reporteA.setCantidad_realizada(cantidad_realizada);
				BigDecimal cantidad_pendiente = (BigDecimal) row[9];
				reporteA.setCantidad_pendiente(cantidad_pendiente);
				String concluido = (String) row[10];
				reporteA.setConcluido(concluido);
				String facturado = (String) row[11];
				reporteA.setFacturado(facturado);
				String cod_um_plan = (String) row[12];
				reporteA.setCod_um_plan(cod_um_plan);
				String nom_um_plan = (String) row[13];
				reporteA.setNom_um_plan(nom_um_plan);
				String nom_lote = (String) row[14];
				reporteA.setNom_lote(nom_lote);
				Date periodo_inicial = (Date) row[15];
				reporteA.setPeriodo_inicial(periodo_inicial);
				BigDecimal valor_unitario = (BigDecimal) row[16];
				reporteA.setValor_unitario(valor_unitario);
				BigDecimal valor_est_total = (BigDecimal) row[17];
				reporteA.setValor_est_total(valor_est_total);
				String cod_cliente = (String) row[18];
				reporteA.setCod_cliente(cod_cliente);
				String nom_cliente = (String) row[19];
				reporteA.setNom_cliente(nom_cliente);
				String cod_supervisor = (String) row[20];
				reporteA.setCod_supervisor(cod_supervisor);
				String nom_supervisor = (String) row[21];
				reporteA.setNom_supervisor(nom_supervisor);
				String cod_labor = (String) row[22];
				reporteA.setCod_labor(cod_labor);
				BigInteger consecutivo = (BigInteger) row[23];
				reporteA.setConsecutivo(consecutivo);
				BigInteger dat_plan_servicios_mqdet_id = (BigInteger) row[24];
				reporteA.setDat_plan_servicios_mqdet_id(dat_plan_servicios_mqdet_id);
				BigInteger dat_plan_servicios_mq_id = (BigInteger) row[25];
				reporteA.setDat_plan_servicios_mq_id(dat_plan_servicios_mq_id);
				String equipo_id2 = (String) row[26];
				reporteA.setEquipo_id2(equipo_id2);
				String cod_zona = (String) row[27];
				reporteA.setCod_zona(cod_zona);
				String nom_zona = (String) row[28];
				reporteA.setNom_zona(nom_zona);
				String detalle_nota = (String) row[29];
				reporteA.setDetalleNota(detalle_nota);
				String fecha_realizado = (String) row[30];
				reporteA.setFecha_realizado(fecha_realizado);
				String nom_operario = (String) row[31];
				reporteA.setNom_operario(nom_operario);
				
				String estadoFactura = (String) row[33];
				reporteA.setEstadoFactura(estadoFactura);
				
				String consecutivoPrefactura2 = (String) row[34];
				reporteA.setConsecutivoPrefactura2(consecutivoPrefactura2);
				
				String numFactura2 = (String) row[35];
				reporteA.setNumFactura2(numFactura2);


				String nombreCentroCosto = (String) row[36];
				reporteA.setNombreCentroCosto(nombreCentroCosto);
				
				reporte.add(reporteA);

			}
		}
		session.close();
		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_servrea_det(Long compania, String estadoServicio,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca,
			String labor, Long flagLabor, String lote, Long flaglote, Long pinId,  String grpLabor, Long flagGrpLabor ) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_servrea_det (:compania, :estadoServicio, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,    :labor, :flagLabor,  :lote, :flaglote, :pinId, :grpLabor, :flagGrpLabor )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("grpLabor", grpLabor);
		q.setString("estadoServicio", estadoServicio);
		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("pinId", pinId);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flaglote", flaglote);
		q.setLong("flagGrpLabor", flagGrpLabor);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				String cod_equipo = (String) row[0];
				String nom_finca = (String) row[1];
				String nom_labor = (String) row[2];
				BigDecimal cantidad_pago = (BigDecimal) row[3];
				String cod_udad_med_pago = (String) row[4];
				String nom_lote = (String) row[5];
				Date fecha_registro = (Date) row[6];
				BigDecimal horometro_inicial = (BigDecimal) row[7];
				BigDecimal horometro_final = (BigDecimal) row[8];
				BigDecimal valor_unitario = (BigDecimal) row[9];
				BigDecimal ingreso_total = (BigDecimal) row[10];
				String nom_cliente = (String) row[11];
				String cod_operario = (String) row[12];
				String cod_implemento = (String) row[13];
				String docFactura = (String) row[14];
				BigInteger pin = (BigInteger) row[15];
				BigInteger idRegistro = (BigInteger) row[16];
				String estatusRegistro = (String) row[17];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[18];
				BigInteger equipoId = (BigInteger) row[19];

				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setCod_operario(cod_operario);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setDocFactura(docFactura);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);

				reporte.add(reporteA);

			}
		}
		session.close();
		return reporte;
	}

	@Override
	public List<ConsultaCompraProductosDTO> pr_lista_compra_productos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento, String tipoCompra, Long numfactura) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call 	pr_lista_compra_productos  (:compania, :fechaInicial,  :fechaFinal, "
						+ ":contratista, :flagContratista, :documento, :tipoCompra ,:numfactura)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);
		q.setLong("documento", documento);
		q.setLong("numfactura", numfactura);
		q.setString("tipoCompra", tipoCompra);
		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();
				BigInteger datCompraProductosId = (BigInteger) row[0];
				reporteA.setDatCompraProductosId(datCompraProductosId);
				Date fecha_registro = (Date) row[1];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger consecutivo = (BigInteger) row[2];
				reporteA.setConsecutivo(consecutivo);
				BigInteger num_factura = (BigInteger) row[3];
				reporteA.setNum_factura(num_factura);
				String cod_proveedor = (String) row[4];
				reporteA.setCod_proveedor(cod_proveedor);
				String nom_proveedor = (String) row[5];
				reporteA.setNom_proveedor(nom_proveedor);
				BigDecimal valor_factura = (BigDecimal) row[6];
				reporteA.setValor_factura(valor_factura);
				BigDecimal valor_iva = (BigDecimal) row[7];
				reporteA.setValor_iva(valor_iva);
				BigDecimal valor_descuento = (BigDecimal) row[8];
				reporteA.setValor_descuento(valor_descuento);
				String detalle_nota = (String) row[9];
				reporteA.setDetalle_nota(detalle_nota);
				String tipo_moneda = (String) row[10];
				reporteA.setTipo_moneda(tipo_moneda);
				BigDecimal tasa_conversion_trm = (BigDecimal) row[11];
				reporteA.setTasa_conversion_trm(tasa_conversion_trm);
				String estado = (String) row[12];
				reporteA.setEstado(estado);

				String num_ot = (String) row[13];
				reporteA.setNumOt(num_ot);

				
				reporte.add(reporteA);
			}
		}
		session.close();

		return reporte;

	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_labores_implemento(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, Long pinId) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_labores_implemento (:compania,  :fechaInicial,  :fechaFinal,   :equipo, :flagEquipo, :pinId)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("pinId", pinId);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				String cod_equipo = (String) row[0];
				String nom_finca = (String) row[1];
				String nom_labor = (String) row[2];
				BigDecimal cantidad_pago = (BigDecimal) row[3];
				String cod_udad_med_pago = (String) row[4];
				String nom_lote = (String) row[5];
				Date fecha_registro = (Date) row[6];
				BigDecimal horometro_inicial = (BigDecimal) row[7];
				BigDecimal horometro_final = (BigDecimal) row[8];
				BigDecimal valor_unitario = (BigDecimal) row[9];
				BigDecimal ingreso_total = (BigDecimal) row[10];
				String nom_cliente = (String) row[11];
				String cod_operario = (String) row[12];
				String cod_implemento = (String) row[13];
				String docFactura = (String) row[14];
				BigInteger pin = (BigInteger) row[15];
				BigInteger idRegistro = (BigInteger) row[16];
				String estatusRegistro = (String) row[17];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[18];
				BigInteger equipoId = (BigInteger) row[19];
				
				String zona = (String) row[20];
				BigDecimal anio = (BigDecimal) row[21];
				BigDecimal mes = (BigDecimal) row[22];
				
				Double horasTotales = horometro_final.doubleValue() - horometro_inicial.doubleValue();
				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setIngresoTotal(ingreso_total);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setCod_operario(cod_operario);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setDocFactura(docFactura);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setHorasTotales(horasTotales);
				reporteA.setCodZona(zona);
				reporteA.setAnio(anio);
				reporteA.setMes(mes);
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}

	@Override
	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto

	) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_inventario_saldo_producto (:compania, :fechaInicial,  :fechaFinal, "
						+ ":almacen, :flagAlmacen, :producto, :flagProducto )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("almacen", almacen);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setString("producto", producto);
		q.setLong("flagProducto", flagProducto);

		List l = q.list();
		List<ConsultaStockMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaStockMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaStockMaquinariaDTO reporteA = new ConsultaStockMaquinariaDTO();

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
				
				BigInteger idProducto = (BigInteger) row[18];
				BigInteger idAlmacen = (BigInteger) row[17];
				BigInteger idUdadMed = (BigInteger) row[19];
				reporteA.setIdAlmacen(idAlmacen);
				reporteA.setIdProducto(idProducto);
				reporteA.setIdUdadMed(idUdadMed);

				reporte.add(reporteA);
			}
		}

		session.close();
		return reporte;

	}

	@Override
	public List<ConsultaOtrosMovimientosInventarioDTO> pr_lista_otros_mov_productos(Long compania, Date fechaInicial,
			Date fechaFinal, Long documento, Long maquina, Long centCost) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call 	pr_lista_otros_mov_productos  (:compania, :fechaInicial,  :fechaFinal, " + " :documento, :maquina, :centCost )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("documento", documento);
		q.setLong("maquina", maquina);
		q.setLong("centCost", centCost);
		List l = q.list();
		List<ConsultaOtrosMovimientosInventarioDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaOtrosMovimientosInventarioDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaOtrosMovimientosInventarioDTO reporteA = new ConsultaOtrosMovimientosInventarioDTO();
				BigInteger dat_otros_mov_inventario_id = (BigInteger) row[0];
				reporteA.setDat_otros_mov_inventario_id(dat_otros_mov_inventario_id);
				Date fecha_registro = (Date) row[1];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger consecutivo = (BigInteger) row[2];
				reporteA.setConsecutivo(consecutivo);
				BigInteger num_factura = (BigInteger) row[3];
				reporteA.setNum_factura(num_factura);
				String cod_concepto = (String) row[4];
				reporteA.setCod_concepto_kardex(cod_concepto);
				String nom_concepto = (String) row[5];
				reporteA.setNom_concepto_kardex(nom_concepto);
				String detalle_nota = (String) row[6];
				reporteA.setDetalle_nota(detalle_nota);
				
				String nomProducto = (String) row[8];
				reporteA.setNom_producto(nomProducto);
				
				BigDecimal cantidad = (BigDecimal) row[9];
				reporteA.setCantidad_compra(cantidad);
				
				

				String estado = (String) row[7];
				reporteA.setEstado(estado);


				String cod_equipo = (String) row[10];
				reporteA.setCod_equipo(cod_equipo);
				
				reporte.add(reporteA);
			}
			
		}
		session.close();
		return reporte;

	}

	@Override
	public List<ProntuarioLotesDTO> pr_prontuario_haciendas_maquinaria(Long compania, String finca, Long flagFinca,
			String proveedor, Long flagProveedor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_prontuario_haciendas_maquinaria (:compania,     "
				+ ":finca, :flagFinca,   :proveedor,  :flagProveedor )");

		q.setLong("compania", compania);
		q.setString("finca", finca);
		q.setString("proveedor", proveedor);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagProveedor", flagProveedor);

		List l = q.list();
		List<ProntuarioLotesDTO> prontuarioLotes = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			prontuarioLotes = new ArrayList<ProntuarioLotesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProntuarioLotesDTO prontuarioLotesA = new ProntuarioLotesDTO();

				String codProveedor = (String) row[1];
				String nomProveedor = (String) row[2];
				String codFinca = (String) row[3];
				String nomFinca = (String) row[4];
				BigInteger nivel2ClientesmqId = (BigInteger) row[5];
				prontuarioLotesA.setCodProveedor(codProveedor);
				prontuarioLotesA.setNomProveedor(nomProveedor);
				prontuarioLotesA.setCodFinca(codFinca);
				prontuarioLotesA.setNomFinca(nomFinca);
				prontuarioLotesA.setNivel2ClientesMqId(nivel2ClientesmqId);
				prontuarioLotes.add(prontuarioLotesA);

			}
		}

		session.close();
		return prontuarioLotes;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_liq_auxilio_productividad(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_liq_auxilio_productividad (:compania, :fechaInicial,  :fechaFinal,   :operador,  :flagOperador)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setLong("flagOperador", flagOperador);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String periodoLiquidacion = (String) row[2];
				BigDecimal cantidad_pago = (BigDecimal) row[3];
				BigDecimal horas = (BigDecimal) row[4];
				String cod_operario = (String) row[5];
				String nom_operario = (String) row[6];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[7];
				BigDecimal valor_dia = (BigDecimal) row[8];
				BigDecimal devengo = (BigDecimal) row[9];
				BigDecimal salario = (BigDecimal) row[10];
				BigDecimal auxilio_productividad = (BigDecimal) row[11];
				String nom_concepto_nomina = (String) row[12];
				BigDecimal diasLaborados = (BigDecimal) row[13];
				String nom_profesion = (String) row[14];

				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setPeriodoLiquidacion(periodoLiquidacion);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setHoras(horas);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setValorDia(valor_dia);
				reporteA.setDevengo(devengo);
				reporteA.setSalario(salario);
				reporteA.setAuxilio_productividad(auxilio_productividad);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setNom_profesion(nom_profesion);
				reporteA.setDiasLaborados(diasLaborados);

				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}

	public Long pr_actualiza_consec_factura_compania(Long compania, Long numfactura) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_actualiza_consec_factura_compania(:compania, :numfactura)");
		q.setLong("compania", compania);
		q.setLong("numfactura", numfactura);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public List<FacturaServiciosConsolidadosDTO> pr_listar_factura_servicios(Long compania, Date fechaInicial,
			Date fechaFinal, Long numFactura) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_listar_factura_servicios (:compania, :fechaInicial,  :fechaFinal,   :numFactura)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("numFactura", numFactura);

		List l = q.list();

		List<FacturaServiciosConsolidadosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<FacturaServiciosConsolidadosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				FacturaServiciosConsolidadosDTO reporteA = new FacturaServiciosConsolidadosDTO();
				BigInteger dat_factura_servicios_id = (BigInteger) row[0];
				reporteA.setDat_factura_servicios_id(dat_factura_servicios_id);
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				String num_factura = (String) row[2];
				reporteA.setNum_factura(num_factura);
				BigInteger pers_empr_id = (BigInteger) row[3];
				reporteA.setPers_empr_id(pers_empr_id);
				String cod_cliente = (String) row[4];
				reporteA.setCod_cliente(cod_cliente);
				String nom_cliente = (String) row[5];
				reporteA.setNom_cliente(nom_cliente);
				BigInteger companiaid = (BigInteger) row[6];
				reporteA.setCompania(companiaid);
				Date fecha_registro = (Date) row[7];
				reporteA.setFecha_registro(fecha_registro);
				String detalle_factura = (String) row[8];
				reporteA.setDetalle_factura(detalle_factura);
				BigDecimal valor_factura = (BigDecimal) row[9];
				reporteA.setValor_factura(valor_factura);

				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}

	@Override
	public List<ConsultaCajaMenorDTO> pr_listar_cajamenor(Long compania, Date fechaInicial, Date fechaFinal, Long documento, Long centCost) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_listar_cajamenor (:compania, :fechaInicial,  :fechaFinal, :documento, :centCost)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		
		q.setLong("documento", documento);
		q.setLong("centCost", centCost);
		
		List l = q.list();

		List<ConsultaCajaMenorDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCajaMenorDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCajaMenorDTO reporteA = new ConsultaCajaMenorDTO();
				BigInteger cajaMenorId = (BigInteger) row[0];
				reporteA.setDatCajaMenorId(cajaMenorId);

				Date fecha_registro = (Date) row[1];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger consecutivo = (BigInteger) row[2];
				reporteA.setConsecutivo(consecutivo);
				String observacion = (String) row[3];
				reporteA.setObservacion(observacion);
				String estado = (String) row[4];
				reporteA.setEstado(estado);

				String nom_caja_menor = (String) row[5];
				reporteA.setNom_caja_menor(nom_caja_menor);

				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}

	@Override
	public List<CostosIndirectosEquipoDTO> pr_listar_otrosmq(Long compania, Date fechaInicial, Date fechaFinal,
			String tipogasto, Long documento, Long centCost, Long proveedor , String numFacturab) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_listar_otrosmq (:compania, :fechaInicial,  :fechaFinal, :tipogasto, :documento, :centCost, :proveedor, :numFacturab)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tipogasto", tipogasto);
		q.setLong("documento", documento);
		q.setLong("centCost", centCost);
		q.setLong("proveedor", proveedor);
		q.setString("numFacturab", numFacturab);
		
		List l = q.list();
		List<CostosIndirectosEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<CostosIndirectosEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosIndirectosEquipoDTO reporteA = new CostosIndirectosEquipoDTO();
				BigInteger otrosCostosMqId = (BigInteger) row[0];
				Date fecha = (Date) row[1];
				String tipoTransaccion = (String) row[2];
				BigInteger consecutivo = (BigInteger) row[3];

				String numFactura = (String) row[4];
				String observacion = (String) row[5];
				String estado = (String) row[6];
				String descProveedor = (String) row[7];
				BigDecimal valor = (BigDecimal) row[8];
				
				reporteA.setCostoTotal(valor);
				reporteA.setNomProveedor(descProveedor);
				reporteA.setFecha(fecha);
				reporteA.setTipoTransaccion(tipoTransaccion);
				reporteA.setNumFactura(numFactura);
				reporteA.setObservacion(observacion);
				reporteA.setEstado(estado);
				reporteA.setConsecutivo(consecutivo);
				reporteA.setOtrosCostosMqId(otrosCostosMqId);

				reporte.add(reporteA);
			}
		}

		session.close();
		return reporte;

	}

	@Override
	public List<PagosNotasClientesDTO> pr_listar_notas_clientes(Long compania, Date fechaInicial, Date fechaFinal) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_listar_notas_clientes (:compania,  :fechaInicial,  :fechaFinal)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);

		List l = q.list();
		List<PagosNotasClientesDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<PagosNotasClientesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				PagosNotasClientesDTO reporteA = new PagosNotasClientesDTO();
				BigInteger dat_pagos_notas_clientes_id = (BigInteger) row[0];
				reporteA.setDat_pagos_notas_clientes_id(dat_pagos_notas_clientes_id);

				Date fecha_registro = (Date) row[1];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger consecutivo = (BigInteger) row[2];
				reporteA.setConsecutivo(consecutivo);
				String detalle_nota = (String) row[3];
				reporteA.setDetalle_nota_credito(detalle_nota);
				String estado = (String) row[4];
				reporteA.setEstado(estado);

				BigInteger num_factura = (BigInteger) row[5];
				reporteA.setNum_factura(num_factura);
				String nom_cliente = (String) row[6];
				reporteA.setNom_cliente(nom_cliente);
				String forma_pago = (String) row[7];
				reporteA.setForma_pago(forma_pago);
				BigDecimal valor_credito = (BigDecimal) row[8];
				reporteA.setValor_credito(valor_credito);
				BigDecimal valor_debito = (BigDecimal) row[9];
				reporteA.setValor_debito(valor_debito);

				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}

	@Override
	public List<CatalogProductoDTO> pr_listar_productos_tipop(Long compania, Long tipoproductoid) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_listar_productos_tipop (:compania, :tipoproductoid)");
		q.setLong("compania", compania);
		q.setLong("tipoproductoid", tipoproductoid);
		List l = q.list();
		ArrayList<CatalogProductoDTO> reporte = new ArrayList<CatalogProductoDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CatalogProductoDTO reportes = new CatalogProductoDTO();
				BigInteger productoId = (BigInteger) row[0];
				String codigo = (String) row[1];
				String nombre = (String) row[2];
				reportes.setProductoId(productoId);
				reportes.setCodigo(codigo);
				reportes.setNombre(nombre);

				reporte.add(reportes);

			}
			

		}
		session.close();
		return reporte;

	}

	@Override
	public List<ProgramacionLaboresMaqDTO> pr_listar_planesmq(Long compania, Date fechaInicial, Date fechaFinal,
			String supervisor, Long flagSupervisor, String zona, Long flagZona, String tipoProy) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_listar_planesmq (:compania,  :fechaInicial,  "
				+ ":fechaFinal, :supervisor, :flagSupervisor, :zona, :flagZona, :tipoProy )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("supervisor", supervisor);
		q.setLong("flagSupervisor", flagSupervisor);
		q.setString("zona", zona);
		q.setLong("flagZona", flagZona);
		q.setString("tipoProy", tipoProy);

		List l = q.list();
		List<ProgramacionLaboresMaqDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ProgramacionLaboresMaqDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgramacionLaboresMaqDTO reporteA = new ProgramacionLaboresMaqDTO();
				BigInteger dat_plan_servicios_mq_id = (BigInteger) row[0];
				reporteA.setDat_plan_servicios_mq_id(dat_plan_servicios_mq_id);
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);

				Date periodo_inicial = (Date) row[2];
				reporteA.setPeriodo_inicial(periodo_inicial);
				String nom_zona = (String) row[3];
				reporteA.setNom_zona(nom_zona);
				String nom_supervisor = (String) row[4];
				reporteA.setNom_supervisor(nom_supervisor);
				BigDecimal cantRegistros = (BigDecimal) row[5];
				reporteA.setCantRegistros(cantRegistros);
				String nom_cliente = (String) row[6];
				reporteA.setNom_cliente(nom_cliente);
				String nom_finca = (String) row[7];
				reporteA.setNom_finca(nom_finca);
				String tipoProyecto = (String) row[8];
				reporteA.setTipoProyecto(tipoProyecto);
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}

	@Override
	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_comprobante_pago_nomina (:compania, :fechaInicial,  :fechaFinal,   :operador,  :flagOperador)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setLong("flagOperador", flagOperador);

		List l = q.list();
		List<ConsultaComprobantePagoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaComprobantePagoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaComprobantePagoDTO reporteA = new ConsultaComprobantePagoDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String periodoLiquidacion = (String) row[2];
				String cod_operario = (String) row[3];
				String nom_operario = (String) row[4];
				String nom_concepto_nomina = (String) row[6];
				String tipo_movimiento = (String) row[7];
				BigDecimal devengo = (BigDecimal) row[8];
				BigDecimal descuentos = (BigDecimal) row[9];

				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setPeriodoLiquidacion(periodoLiquidacion);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setTipoMovimiento(tipo_movimiento);
				reporteA.setDevengo(devengo);
				reporteA.setDescuentos(descuentos);

				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_servre_maq_interface_ssatelital(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_servre_maq_interface_ssatelital (:compania,  :fechaInicial,  :fechaFinal,  :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[0];
				BigInteger idRegistro = (BigInteger) row[1];

				BigDecimal anio_registro = (BigDecimal) row[3];
				BigDecimal mes = (BigDecimal) row[4];
				Date fecha_registro = (Date) row[6];
				String codLabor = (String) row[7];
				String nom_labor = (String) row[8];
				String codEquipo = (String) row[9];
				String nom_Equipo = (String) row[10];
				BigDecimal cantidad_pago = (BigDecimal) row[11];
				String cod_udad_med_pago = (String) row[12];
				BigDecimal horometro_inicial = (BigDecimal) row[13];
				BigDecimal horometro_final = (BigDecimal) row[14];
				String nom_producto = (String) row[15];
				BigDecimal cantidad_galones = (BigDecimal) row[16];
				String cod_udad_med_ins = (String) row[17];
				String nom_cliente = (String) row[18];
				String turno = (String) row[19];
				String nom_operario = (String) row[20];
				String codImplemento = (String) row[21];
				BigDecimal ingresos = (BigDecimal) row[22];
				String estado_servicio = (String) row[23];
				
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(codEquipo);
				reporteA.setNomEquipo(nom_Equipo);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setNomProducto(nom_producto);
				reporteA.setCantGalones(cantidad_galones);
				reporteA.setCodUdadMedIns(cod_udad_med_ins);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setTurno(turno);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_implemento(codImplemento);
				reporteA.setCodLabor(codLabor);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estado_servicio);
				reporteA.setIngresoTotal(ingresos);

				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}

	@Override
	public List<CatalogProductoDTO> pr_list_productos_inventario(Long compania, String producto, Long flagProducto,
			String tipoProducto, Long flagTipoProducto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_list_productos_inventario (:compania, :producto,  :flagProducto, "
				+ ":tipoProducto, :flagTipoProducto )");
		q.setLong("compania", compania);
		q.setString("producto", producto);
		q.setLong("flagTipoProducto", flagTipoProducto);
		q.setString("tipoProducto", tipoProducto);
		q.setLong("flagProducto", flagProducto);

		List l = q.list();
		List<CatalogProductoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<CatalogProductoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CatalogProductoDTO reporteA = new CatalogProductoDTO();

				BigInteger productoId = (BigInteger) row[0];
				reporteA.setProductoId(productoId);
				String cod_producto = (String) row[1];
				reporteA.setCodigo(cod_producto);
				String nom_producto = (String) row[2];
				reporteA.setNombre(nom_producto);
				String referencia = (String) row[3];
				reporteA.setReferencia(referencia);
				String posicion = (String) row[4];
				reporteA.setPosicion(posicion);
				String codTipoProducto = (String) row[5];
				reporteA.setCod_tipo_producto(codTipoProducto);
				String nomTipoProducto = (String) row[6];
				reporteA.setNom_tipo_producto(nomTipoProducto);
				String cod_udad_med = (String) row[7];
				reporteA.setCod_um_producto(cod_udad_med);
				BigDecimal cantidadDisponible = (BigDecimal) row[8];
				reporteA.setSaldo_actual_sistema(cantidadDisponible);
				String cod_almacen = (String) row[9];
				reporteA.setCod_almacen(cod_almacen);
				String nom_almacen = (String) row[10];
				reporteA.setNom_almacen(nom_almacen);

				reporte.add(reporteA);
			}
		}

		session.close();
		return reporte;

	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_servrea_estus(Long compania, Date fechaInicial,
			Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca, String labor,
			Long flagLabor, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_servrea_estus (:compania, :fechaInicial, :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,   :labor, :flagLabor, " + "  :equipo, :flagEquipo)");
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("compania", compania);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("labor", labor);
		q.setString("equipo", equipo);
		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagEquipo", flagEquipo);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				String cod_finca = (String) row[4];
				String nom_finca = (String) row[5];
				String cod_labor = (String) row[6];
				String nom_labor = (String) row[7];
				BigDecimal cantidad_pago = (BigDecimal) row[8];
				String cod_udad_med_pago = (String) row[9];
				String nom_lote = (String) row[10];
				Date fecha_registro = (Date) row[11];
				BigDecimal horometro_inicial = (BigDecimal) row[12];
				BigDecimal horometro_final = (BigDecimal) row[13];
				BigDecimal valor_unitario = (BigDecimal) row[14];
				BigDecimal ingreso_total = (BigDecimal) row[15];
				String cod_cliente = (String) row[16];
				String nom_cliente = (String) row[17];
				String turno = (String) row[18];
				String cod_operario = (String) row[19];
				String nom_operario = (String) row[20];
				String cod_implemento = (String) row[21];
				String docFactura = (String) row[22];
				BigInteger pin = (BigInteger) row[23];
				BigInteger idRegistro = (BigInteger) row[24];
				String estatusRegistro = (String) row[25];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[26];
				BigInteger equipoId = (BigInteger) row[27];
				BigInteger consecutivo_prefactura = (BigInteger) row[28];
				BigInteger consecutivoRdl = (BigInteger) row[29];

				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCodFinca(cod_finca);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setDocFactura(docFactura);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setConsecutivoPrefactura(consecutivo_prefactura);
				reporteA.setConsecutivoRdl(consecutivoRdl);
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_numero_pines_por_maquina(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_numero_pines_por_maquina (:compania, :fechaInicial,  :fechaFinal,   :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				String cod_equipo = (String) row[0];
				String nom_equipo = (String) row[1];
				BigDecimal npines_maquina = (BigDecimal) row[4];

				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setNpines_maquina(npines_maquina);
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}

	@Override
	public Long pr_borrar_liq_transporte_operario(Long compania, Date fechaInicial, Date fechaFinal) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_borrar_liq_transporte_operario (:compania, :fechaInicial, :fechaFinal)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public Long pr_interfaz_liq_transporte_operario(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String equipo, Long flagEquipo) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_interfaz_liq_transporte_operario (:compania, "
				+ ":fechaInicial, :fechaFinal," + ":trabajador, :flagTrabajador," + ":equipo, :flagEquipo)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("trabajador", trabajador);
		q.setLong("flagTrabajador", flagTrabajador);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_liq_aux_transporte_operario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_liq_aux_transporte_operario (:compania, :fechaInicial,  :fechaFinal,   :operador,  :flagOperador,   :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setString("equipo", equipo);
		q.setLong("flagOperador", flagOperador);
		q.setLong("flagEquipo", flagEquipo);
		
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				BigDecimal auxilio_transporte = (BigDecimal) row[4];
				Date fecha_registro = (Date) row[5];
				String turno = (String) row[6];
				String cod_operario = (String) row[7];
				String nom_operario = (String) row[8];
				String cod_concepto_nomina = (String) row[9];
				String nom_concepto_nomina = (String) row[10];
				String periodoLiquidacion = (String) row[11];
				
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setAuxilio_transporte(auxilio_transporte);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setPeriodoLiquidacion(periodoLiquidacion);
				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}
	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_operario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_control_productividad_operario (:compania, :fechaInicial,  :fechaFinal,   :operador,  :flagOperador, :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setLong("flagOperador", flagOperador);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				Date fecha_registro = (Date) row[2];
				String cod_operario = (String) row[3];
				String nom_operario = (String) row[4];
				String cod_concepto_nomina = (String) row[5];
				String nom_concepto_nomina = (String) row[6];
				String turno = (String) row[7];
				BigInteger pin = (BigInteger) row[8];
				BigInteger id = (BigInteger) row[9];
				String tipoTiampo = (String) row[10];
				String codEquipo = (String) row[11];
				String nomEquipo = (String) row[12];
				String tiempo = (String) row[13];
				BigDecimal dia = (BigDecimal) row[14];
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setTurno(turno);

				reporteA.setConsecutivo(pin);
				reporteA.setDat_serv_realizados_equipo_id(id);
				reporteA.setTipoTiempo(tipoTiampo);
				reporteA.setCodEquipo(codEquipo);
				reporteA.setNomEquipo(nomEquipo);
				reporteA.setTiempo(tiempo);
				reporteA.setDia(dia);
				reporte.add(reporteA);

			}
			session.close();
		}

		return reporte;
	}

	@Override
	public Long pr_borrar_compra(Long idCompra) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_compra (:idCompra)");

		q.setLong("idCompra", idCompra);

		q.executeUpdate();

		return 1L;

	}

	@Override
	public Long pr_borrar_dat_compra_detalle(Long idCompra) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_compra_detalle (:idCompra)");

		q.setLong("idCompra", idCompra);

		q.executeUpdate();

		return 1L;

	}

	@Override
	public List<CatalogoPlanRevisionDTO> pr_lista_plan_revision_equipo(Long equipoid) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_lista_plan_revision_equipo (:equipoid )");
		q.setLong("equipoid", equipoid);

		List l = q.list();
		ArrayList<CatalogoPlanRevisionDTO> reporte = new ArrayList<CatalogoPlanRevisionDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CatalogoPlanRevisionDTO reportes = new CatalogoPlanRevisionDTO();
				BigInteger idPlan = (BigInteger) row[0];
				String codigoPlan = (String) row[1];
				String nombrePlan = (String) row[2];
				reportes.setPlanRevisionId(idPlan);
				reportes.setCodigoPlan(codigoPlan);
				reportes.setNombrePlan(nombrePlan);

				reporte.add(reportes);
			}

		}
		session.close();

		return reporte;

	}

	@Override
	public List<CatalogoEquiposDTO> pr_listar_eventos_equipos(Long compania, String equipo, Long flagEquipo,
			String evento, Long flagEvento) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery(
				"call pr_listar_eventos_equipos (:compania, :equipo, :flagEquipo, :evento, :flagEvento)");
		q.setLong("compania", compania);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("flagEvento", flagEvento);

		q.setString("equipo", equipo);
		q.setString("evento", evento);

		List l = q.list();
		ArrayList<CatalogoEquiposDTO> reporte = new ArrayList<CatalogoEquiposDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CatalogoEquiposDTO reportes = new CatalogoEquiposDTO();
				BigInteger equipo_id = (BigInteger) row[0];
				String codigo_categoria = (String) row[1];
				String nombre_categoria = (String) row[2];
				String codigo_maquina = (String) row[3];
				String nombre_maquina = (String) row[4];
				String codigo_evento = (String) row[5];
				String nombre_evento = (String) row[6];
				BigDecimal dias_notificacion = (BigDecimal) row[7];
				Date f_inicial_evento = (Date) row[8];
				Date f_final_evento = (Date) row[9];
				BigDecimal dias_vencimiento = (BigDecimal) row[10];
				String estatus_vencimiento = (String) row[11];

				reportes.setEquipoId(equipo_id);
				reportes.setCodigoCategoriaEquipo(codigo_categoria);
				reportes.setNombreCategoriaEquipo(nombre_categoria);
				reportes.setCod_equipo(codigo_maquina);
				reportes.setNom_equipo(nombre_maquina);
				reportes.setCodEvento(codigo_evento);
				reportes.setNomEvento(nombre_evento);
				reportes.setDias_notificacion(dias_notificacion);
				reportes.setFecha_inicial_evento(f_inicial_evento);
				reportes.setFecha_final_evento(f_final_evento);
				reportes.setDias_vencimiento(dias_vencimiento);
				reportes.setEstatus_vencimiento(estatus_vencimiento);

				if (dias_vencimiento.longValue() > 30) {
					reportes.setColorEvento("btn btn-primary");
				}

				if (dias_vencimiento.longValue() > 8 && dias_vencimiento.longValue() <= 30) {
					reportes.setColorEvento("btn-warning");
				}

				if (dias_vencimiento.longValue() < 8) {
					reportes.setColorEvento("btn btn-danger");
				}

				reporte.add(reportes);
			}

		}
		session.close();

		return reporte;

	}

	/************* borrado de tablas *****/
	@Override
	public Long pr_borrar_dat_otros_movimientos(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_otros_movimientos (:id)");

		q.setLong("id", id);

		q.executeUpdate();

		return 1L;

	}

	@Override
	public Long pr_borrar_dat_otros_movimientos_detalle(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_otros_movimientos_detalle (:id)");

		q.setLong("id", id);

		q.executeUpdate();

		return 1L;

	}

	@Override
	public Long pr_borrar_dat_otros_costos_mq(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_otros_costos_mq (:id)");

		q.setLong("id", id);

		q.executeUpdate();

		return 1L;

	}

	@Override
	public Long pr_borrar_dat_otros_costos_mq_detalle(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_otros_costos_mq_detalle (:id)");

		q.setLong("id", id);

		q.executeUpdate();

		return 1L;

	}

	@Override
	public Long pr_borrar_dat_caja_menor(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_caja_menor (:id)");

		q.setLong("id", id);

		q.executeUpdate();

		return 1L;

	}

	@Override
	public Long pr_borrar_dat_caja_menor_detalle(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_caja_menor_detalle (:id)");

		q.setLong("id", id);

		q.executeUpdate();

		return 1L;

	}

	@Override
	public Long pr_borrar_dat_pagos_notas_clientes(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_pagos_notas_clientes (:id)");

		q.setLong("id", id);

		q.executeUpdate();

		return 1L;

	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_pyg_equipo(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro, Long modeloequipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_pyg_equipo (:compania, :fechaInicial, :fechaFinal, :equipo, :flagEquipo,  "
						+ ":categoriaEquipo, :flagCategoriaEquipo,   :estatusRegistro, :modeloequipo)");
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("compania", compania);
		q.setString("equipo", equipo);
		q.setString("categoriaEquipo", categoriaEquipo);
		q.setString("estatusRegistro", estatusRegistro);

		q.setLong("flagCategoriaEquipo", flagCategoriaEquipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("modeloequipo", modeloequipo);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				String cod_equipo = (String) row[0];
				String nom_equipo = (String) row[1];
				BigDecimal cantidad_pago = (BigDecimal) row[2];
				BigDecimal horas = (BigDecimal) row[3];
				BigDecimal ingresoTotal = (BigDecimal) row[4];
				BigDecimal costoTotal = (BigDecimal) row[5];
				BigDecimal combustible = (BigDecimal) row[6];
				BigDecimal glnHr = (BigDecimal) row[7];
				BigDecimal areaHr = (BigDecimal) row[8];
				BigDecimal glnArea = (BigDecimal) row[9];
				BigDecimal costoHr = (BigDecimal) row[10];
				BigDecimal costoArea = (BigDecimal) row[11];
				BigDecimal ingresosHr = (BigDecimal) row[12];
				BigDecimal ingresosArea = (BigDecimal) row[13];
				BigDecimal utilidad = (BigDecimal) row[14];

				BigDecimal kilometros = (BigDecimal) row[15];
				BigDecimal km_gln = (BigDecimal) row[16];
				BigDecimal costo_km = (BigDecimal) row[17];

				BigDecimal costo_combustible = (BigDecimal) row[18];
				BigDecimal costo_cmb_gln = (BigDecimal) row[19];
				BigDecimal costo_cmb_km = (BigDecimal) row[20];
				BigDecimal costo_cmb_hr = (BigDecimal) row[21];

				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);

				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setHorasTotales(horas.doubleValue());
				reporteA.setIngresoTotal(ingresoTotal);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setCombustible(combustible);
				reporteA.setGlnHr(glnHr);
				reporteA.setAreaHr(areaHr);
				reporteA.setGlnArea(glnArea);
				reporteA.setCostoHr(costoHr);
				reporteA.setCostoArea(costoArea);
				reporteA.setIngresosHr(ingresosHr);
				reporteA.setIngresosArea(ingresosArea);
				reporteA.setUtilidad(utilidad);

				reporteA.setKilometros(kilometros);
				reporteA.setKm_gln(km_gln);
				reporteA.setCosto_km(costo_km);

				reporteA.setCosto_combustible(costo_combustible);
				reporteA.setCosto_cmb_gln(costo_cmb_gln);
				reporteA.setCosto_cmb_km(costo_cmb_km);
				reporteA.setCosto_cmb_hr(costo_cmb_hr);

				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_pyg_equipo_conceptogasto(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_pyg_equipo_conceptogasto (:compania, :fechaInicial, :fechaFinal, :equipo, :flagEquipo,  "
						+ ":categoriaEquipo, :flagCategoriaEquipo,   :estatusRegistro)");
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("compania", compania);
		q.setString("equipo", equipo);
		q.setString("categoriaEquipo", categoriaEquipo);
		q.setString("estatusRegistro", estatusRegistro);
		q.setLong("flagCategoriaEquipo", flagCategoriaEquipo);
		q.setLong("flagEquipo", flagEquipo);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				String cod_equipo = (String) row[0];
				String nom_equipo = (String) row[1];
				BigDecimal cantidad_pago = (BigDecimal) row[2];
				BigDecimal horas = (BigDecimal) row[3];
				BigDecimal ingresoTotal = (BigDecimal) row[4];
				BigDecimal costoTotal = (BigDecimal) row[5];
				String conceptoGasto = (String) row[6];
				BigDecimal combustible = (BigDecimal) row[7];
				String codGrupoGasto = (String) row[8];
				String nomGrupoGasto = (String) row[9];
				BigDecimal porcentajeCosto = (BigDecimal) row[10];
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);

				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setHorasTotales(horas.doubleValue());
				reporteA.setIngresoTotal(ingresoTotal);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setConceptoGasto(conceptoGasto);
				reporteA.setCombustible(combustible);
				reporteA.setCodGrupoGasto(codGrupoGasto);
				reporteA.setNomGrupoGasto(nomGrupoGasto);
				reporteA.setPorcentajeCosto(porcentajeCosto);

				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_costo_labor_maquina(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_rendimiento_costo_labor_maquina (:compania, :fechaInicial, :fechaFinal, :equipo, :flagEquipo,  "
						+ ":categoriaEquipo, :flagCategoriaEquipo,   :estatusRegistro)");
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("compania", compania);
		q.setString("equipo", equipo);
		q.setString("categoriaEquipo", categoriaEquipo);
		q.setString("estatusRegistro", estatusRegistro);
		q.setLong("flagCategoriaEquipo", flagCategoriaEquipo);
		q.setLong("flagEquipo", flagEquipo);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				String cod_equipo = (String) row[0];
				String nom_equipo = (String) row[1];
				BigInteger equipoId = (BigInteger) row[2];
				BigDecimal cantidad_pago = (BigDecimal) row[3];
				BigDecimal horas = (BigDecimal) row[4];
				String codLabor = (String) row[5];
				String nomLabor = (String) row[6];
				String codUdadPago = (String) row[7];
				String nomUdadPago = (String) row[8];
				BigDecimal costoTotal = (BigDecimal) row[9];
				BigDecimal costoHr = (BigDecimal) row[10];
				BigDecimal subTotalCostoMaquina = (BigDecimal) row[11];
				BigDecimal costoArea = (BigDecimal) row[12];
				BigDecimal combustible = (BigDecimal) row[13];
				BigDecimal areaHr = (BigDecimal) row[14];

				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setEquipoId(equipoId);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setHorasTotales(horas.doubleValue());
				reporteA.setCodLabor(codLabor);
				reporteA.setNomLabor(nomLabor);
				reporteA.setCodUdadMed(codUdadPago);
				reporteA.setNomUdadMed(nomUdadPago);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setCostoHr(costoHr);
				reporteA.setSubTotalCostoMaquina(subTotalCostoMaquina);
				reporteA.setCombustible(combustible);
				reporteA.setAreaHr(areaHr);

				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_maquina(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_rendimiento_maquina (:compania, :fechaInicial, :fechaFinal, :equipo, :flagEquipo,  "
						+ ":categoriaEquipo, :flagCategoriaEquipo,   :estatusRegistro)");
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("compania", compania);
		q.setString("equipo", equipo);
		q.setString("categoriaEquipo", categoriaEquipo);
		q.setString("estatusRegistro", estatusRegistro);
		q.setLong("flagCategoriaEquipo", flagCategoriaEquipo);
		q.setLong("flagEquipo", flagEquipo);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				String cod_equipo = (String) row[1];
				String nom_equipo = (String) row[2];
				BigDecimal cantidad_pago = (BigDecimal) row[3];
				Double horas = (Double) row[4];
				BigDecimal ingresoTotal = (BigDecimal) row[5];
				BigDecimal costoTotal = (BigDecimal) row[6];
				BigDecimal combustible = (BigDecimal) row[7];
				BigDecimal glnHr = (BigDecimal) row[8];
				BigDecimal areaHr = (BigDecimal) row[9];
				BigDecimal glnArea = (BigDecimal) row[10];

				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setHorasTotales(horas);
				reporteA.setIngresoTotal(ingresoTotal);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setCombustible(combustible);
				reporteA.setGlnHr(glnHr);
				reporteA.setAreaHr(areaHr);
				reporteA.setGlnArea(glnArea);

				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_maquina_consolidados(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_rendimiento_maquina_consolidados (:compania, :fechaInicial, :fechaFinal, :equipo, :flagEquipo,  "
						+ ":categoriaEquipo, :flagCategoriaEquipo,   :estatusRegistro)");
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("compania", compania);
		q.setString("equipo", equipo);
		q.setString("categoriaEquipo", categoriaEquipo);
		q.setString("estatusRegistro", estatusRegistro);
		q.setLong("flagCategoriaEquipo", flagCategoriaEquipo);
		q.setLong("flagEquipo", flagEquipo);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();
				String nomCompania = (String) row[0];
				BigDecimal cantidad_pago = (BigDecimal) row[1];
				Double horas = (Double) row[2];
				BigDecimal ingresoTotal = (BigDecimal) row[3];
				BigDecimal costoTotal = (BigDecimal) row[4];
				BigDecimal combustible = (BigDecimal) row[5];
				BigDecimal glnHr = (BigDecimal) row[6];
				BigDecimal areaHr = (BigDecimal) row[7];
				BigDecimal glnArea = (BigDecimal) row[8];

				reporteA.setNomCompania(nomCompania);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setHorasTotales(horas);
				reporteA.setIngresoTotal(ingresoTotal);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setCombustible(combustible);
				reporteA.setGlnHr(glnHr);
				reporteA.setAreaHr(areaHr);
				reporteA.setGlnArea(glnArea);

				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_ingresos_vs_costos_maquina(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro, String tipoMovimiento) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_ingresos_vs_costos_maquina (:compania, :fechaInicial, :fechaFinal, :equipo, :flagEquipo,  "
						+ ":categoriaEquipo, :flagCategoriaEquipo, :estatusRegistro, :tipoMovimiento)");
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("compania", compania);
		q.setString("equipo", equipo);
		q.setString("categoriaEquipo", categoriaEquipo);
		q.setString("estatusRegistro", estatusRegistro);
		q.setLong("flagCategoriaEquipo", flagCategoriaEquipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("tipoMovimiento", tipoMovimiento);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				String cod_equipo = (String) row[0];
				String nom_equipo = (String) row[1];
				BigDecimal cantidad_pago = (BigDecimal) row[2];
				BigDecimal horas = (BigDecimal) row[3];
				BigDecimal ingresoTotal = (BigDecimal) row[4];
				BigDecimal costoTotal = (BigDecimal) row[5];
				String conceptoGasto = (String) row[6];
				BigDecimal combustible = (BigDecimal) row[7];
				String codGrupoGasto = (String) row[8];
				String nomGrupoGasto = (String) row[9];
				BigDecimal anio = (BigDecimal) row[10];
				BigDecimal mes = (BigDecimal) row[11];
				String anioMes = (String) row[12];

				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setHoras(horas);
				reporteA.setIngresoTotal(ingresoTotal);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setConceptoGasto(conceptoGasto);
				reporteA.setCombustible(combustible);
				reporteA.setCodGrupoGasto(codGrupoGasto);
				reporteA.setNomGrupoGasto(nomGrupoGasto);
				reporteA.setAnio(anio);
				reporteA.setMes(mes);
				reporteA.setAnio_mes(anioMes);

				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_operarios_maquina_periodo(Long compania, Date fechaInicial,
			Date fechaFinal, String cargo, Long flagCargo, String trabajador, Long flagTrabajador, String equipo,
			Long flagEquipo) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_operarios_maquina_periodo (:compania, " + ":fechaInicial, :fechaFinal,"
						+ ":cargo, :flagCargo," + ":trabajador, :flagTrabajador," + ":equipo, :flagEquipo)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cargo", cargo);
		q.setString("trabajador", trabajador);
		q.setLong("flagTrabajador", flagTrabajador);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("flagCargo", flagCargo);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();
				String nomCargo = (String) row[0];
				String cod_operario = (String) row[1];
				String nom_operario = (String) row[2];
				String cod_equipo = (String) row[3];
				String nom_equipo = (String) row[4];
				BigDecimal horas = (BigDecimal) row[5];
				String pines = (String) row[6];

				reporteA.setNom_profesion(nomCargo);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setHoras(horas);
				reporteA.setListaPines(pines);

				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<ConsultaCostosDiferidosDTO> pr_listar_dat_diferidos(Long compania, Date fechaInicial, Date fechaFinal, Long documento, Long centCost, Long proveedor, String numFacturab) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_listar_dat_diferidos (:compania, :fechaInicial,  :fechaFinal , :documento, :centCost , :proveedor, :numFacturab)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("documento", documento);
		q.setLong("centCost", centCost);
		q.setLong("proveedor", proveedor);
		q.setString("numFacturab", numFacturab);
		List l = q.list();
		List<ConsultaCostosDiferidosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCostosDiferidosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCostosDiferidosDTO reporteA = new ConsultaCostosDiferidosDTO();

				BigInteger consecutivo = (BigInteger) row[0];
				reporteA.setConsecutivo(consecutivo);
				Date fecha_registro = (Date) row[1];
				reporteA.setFecha_registro(fecha_registro);
				BigDecimal valor_inicial = (BigDecimal) row[2];
				reporteA.setValor_inicial(valor_inicial);
				BigInteger periodos = (BigInteger) row[3];
				reporteA.setPeriodos(periodos);
				String detalle_nota = (String) row[4];
				reporteA.setDetalle_nota(detalle_nota);
				String estado = (String) row[5];
				reporteA.setEstado(estado);
				String observacion = (String) row[6];
				reporteA.setObservacion(observacion);
				BigInteger datDiferidosId = (BigInteger) row[7];
				reporteA.setDatDiferidosId(datDiferidosId);
				String numeroFactura = (String) row[8];
				reporteA.setNumeroFactura(numeroFactura);
				String cod_gasto = (String) row[9];
				reporteA.setCodGasto(cod_gasto);
				String nom_gasto = (String) row[10];
				reporteA.setNomGasto(nom_gasto);

				
				String codProveedor = (String) row[11];
				reporteA.setCodProveedor(codProveedor);
				
				String nomProveedor = (String) row[12];
				reporteA.setNomProveedor(nomProveedor);
				
				reporte.add(reporteA);
			}
		}
		session.close();

		return reporte;

	}

	public Long pr_borrar_dat_diferidos(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_diferidos (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		return 1L;

	}

	public Long pr_borrar_dat_diferidos_det(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_diferidos_det (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		return 1L;

	}

	public Long pr_borrar_dat_diferidos_cuotas(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_diferidos_cuotas (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		return 1L;

	}

	public Long pr_borrar_equipos_otros_costosmqdistr(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_otros_costos_mq_distr (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		return 1L;

	}

	public Long pr_borrar_dat_caja_menor_det_distr(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_caja_menor_det_distr (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		return 1L;

	}

	public Long pr_borrar_precio_prom_prod_distribuccionmaq(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_precio_prom_prod_distribuccionmaq (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public List<ProgramacionLaboresMaqDTO> pr_consulta_estatus_plan_maquinas(Long id_plan_mqdet) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consulta_estatus_plan_maquinas (:id_plan_mqdet)");

		q.setLong("id_plan_mqdet", id_plan_mqdet);

		List l = q.list();
		List<ProgramacionLaboresMaqDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ProgramacionLaboresMaqDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgramacionLaboresMaqDTO reporteA = new ProgramacionLaboresMaqDTO();
				BigDecimal cantidad_plan = (BigDecimal) row[0];
				reporteA.setCantidad_plan(cantidad_plan);
				String cod_equipo = (String) row[1];
				reporteA.setCod_equipo(cod_equipo);
				Date periodo_inicial = (Date) row[2];
				reporteA.setPeriodo_inicial(periodo_inicial);
				String tipo_mov = (String) row[3];
				reporteA.setTipo_mov(tipo_mov);
				String nom_operario = (String) row[4];
				reporteA.setNom_operario(nom_operario);
				BigInteger dat_plan_servicios_mqdet_ejec = (BigInteger) row[5];
				reporteA.setDat_plan_servicios_mqdet_ejec(dat_plan_servicios_mqdet_ejec);

				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public Double pr_consulta_estatus_area_plan_maquinas(Long id_plan_mqdet) {
		BigDecimal areaAvance = null;
		Double area = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_consulta_estatus_area_plan_maquinas (:id_plan_mqdet)");
		q.setLong("id_plan_mqdet", id_plan_mqdet);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				areaAvance = (BigDecimal) it.next();
				area = areaAvance.doubleValue();

			}
		}
		return area;

	}

	public Long pr_borrar_dat_plan_servicios_mqdet_ejec(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_plan_servicios_mqdet_ejec (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		return 1L;

	}

	@Override
	public List<logServiciosMaqDTO> pr_log_dat_serv_realizados_equipo(Long compania, Long equipoid, Long documento) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_log_dat_serv_realizados_equipo (:compania,:equipoid,:documento)");

		q.setLong("compania", compania);
		q.setLong("equipoid", equipoid);
		q.setLong("documento", documento);

		List l = q.list();
		List<logServiciosMaqDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<logServiciosMaqDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				logServiciosMaqDTO reporteA = new logServiciosMaqDTO();
				BigInteger log_dat_serv_realizados_equipo_id = (BigInteger) row[0];
				BigInteger pin = (BigInteger) row[1];
				BigInteger equipo_id = (BigInteger) row[2];
				String cod_equipo = (String) row[3];
				String loginMdf = (String) row[6];
				String observacion = (String) row[7];
				Date fechaModificacion = (Date) row[8];

				reporteA.setLog_dat_serv_realizados_equipo_id(log_dat_serv_realizados_equipo_id);
				reporteA.setPin(pin);
				reporteA.setEquipo_id(equipo_id);
				reporteA.setCod_equipo(cod_equipo);
				reporteA.setLoginMdf(loginMdf);
				reporteA.setObservacion(observacion);
				reporteA.setFechaModificacion(fechaModificacion);
				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_ingresos_cero(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_serv_ingresos_cero (:compania, :estadoServicio, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,  :operador,  :flagOperador,  :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor,   :equipo, :flagEquipo, :pinId)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("operador", operador);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("equipo", equipo);
		q.setString("estadoServicio", estadoServicio);
		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagOperador", flagOperador);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("pinId", pinId);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				String cod_finca = (String) row[4];
				String nom_finca = (String) row[5];
				String nom_labor = (String) row[6];
				BigDecimal cantidad_pago = (BigDecimal) row[7];
				String cod_udad_med_pago = (String) row[8];
				String nom_udad_med_pago = (String) row[9];
				BigDecimal horas = (BigDecimal) row[10];
				String nom_lote = (String) row[11];
				Date fecha_registro = (Date) row[12];
				String hora_inicial = (String) row[13];
				String hora_final = (String) row[14];
				BigDecimal horometro_inicial = (BigDecimal) row[15];
				BigDecimal horometro_final = (BigDecimal) row[16];
				String cod_producto = (String) row[17];
				String nom_producto = (String) row[18];
				BigDecimal cantidad_galones = (BigDecimal) row[19];
				String cod_udad_med_ins = (String) row[20];
				String nom_udad_med_ins = (String) row[21];
				BigDecimal costo_combustible = (BigDecimal) row[22];
				BigDecimal horas_equipo_dia = (BigDecimal) row[23];
				BigDecimal valor_unitario = (BigDecimal) row[24];
				BigDecimal ingreso_total = (BigDecimal) row[25];
				String cod_cliente = (String) row[26];
				String nom_cliente = (String) row[27];
				BigDecimal sello = (BigDecimal) row[28];
				String turno = (String) row[29];
				String cod_operario = (String) row[30];
				String nom_operario = (String) row[31];
				String cod_concepto_nomina = (String) row[32];
				String nom_concepto_nomina = (String) row[33];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[34];
				String cod_implemento = (String) row[35];
				String nom_implemento = (String) row[36];
				String docFactura = (String) row[37];
				String codLabor = (String) row[38];
				BigInteger pin = (BigInteger) row[39];
				BigInteger idRegistro = (BigInteger) row[40];
				String estatusRegistro = (String) row[41];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[42];
				BigInteger equipoId = (BigInteger) row[43];
				BigDecimal auxilioTransporte = (BigDecimal) row[44];
				BigInteger consecutivoPrefactura = (BigInteger) row[45];

				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCodFinca(cod_finca);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setNomUdadMed(nom_udad_med_pago);
				reporteA.setHoras(horas);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHoraInicial(hora_inicial);
				reporteA.setHoraFinal(hora_final);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setCodProducto(cod_producto);
				reporteA.setNomProducto(nom_producto);
				reporteA.setCantGalones(cantidad_galones);
				reporteA.setCodUdadMedIns(cod_udad_med_ins);
				reporteA.setNomUdadMedIns(nom_udad_med_ins);
				reporteA.setCostoCombustible(costo_combustible);
				reporteA.setHorasEquipoDia(horas_equipo_dia);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setSello(sello);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setNom_implemento(nom_implemento);
				reporteA.setDocFactura(docFactura);
				reporteA.setCodLabor(codLabor);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setAuxilio_transporte(auxilioTransporte);
				reporteA.setConsecutivoPrefactura(consecutivoPrefactura);

				String estadoEstrue = "false";
				if (estatusRegistro.equals("facturado") || estatusRegistro.equals("prefacturado")) {
					estadoEstrue = "true";
					reporteA.setEstadoTrue(estadoEstrue);
				}

				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_limite_cantidad(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Double cantidamax) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_serv_limite_cantidad (:compania, :estadoServicio, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,  :operador,  :flagOperador,  :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor,   :equipo, :flagEquipo, :pinId, :cantidamax)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("operador", operador);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("equipo", equipo);
		q.setString("estadoServicio", estadoServicio);
		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagOperador", flagOperador);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("pinId", pinId);
		q.setDouble("cantidamax", cantidamax);

		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				String cod_finca = (String) row[4];
				String nom_finca = (String) row[5];
				String nom_labor = (String) row[6];
				BigDecimal cantidad_pago = (BigDecimal) row[7];
				String cod_udad_med_pago = (String) row[8];
				String nom_udad_med_pago = (String) row[9];
				BigDecimal horas = (BigDecimal) row[10];
				String nom_lote = (String) row[11];
				Date fecha_registro = (Date) row[12];
				String hora_inicial = (String) row[13];
				String hora_final = (String) row[14];
				BigDecimal horometro_inicial = (BigDecimal) row[15];
				BigDecimal horometro_final = (BigDecimal) row[16];
				String cod_producto = (String) row[17];
				String nom_producto = (String) row[18];
				BigDecimal cantidad_galones = (BigDecimal) row[19];
				String cod_udad_med_ins = (String) row[20];
				String nom_udad_med_ins = (String) row[21];
				BigDecimal costo_combustible = (BigDecimal) row[22];
				BigDecimal horas_equipo_dia = (BigDecimal) row[23];
				BigDecimal valor_unitario = (BigDecimal) row[24];
				BigDecimal ingreso_total = (BigDecimal) row[25];
				String cod_cliente = (String) row[26];
				String nom_cliente = (String) row[27];
				BigDecimal sello = (BigDecimal) row[28];
				String turno = (String) row[29];
				String cod_operario = (String) row[30];
				String nom_operario = (String) row[31];
				String cod_concepto_nomina = (String) row[32];
				String nom_concepto_nomina = (String) row[33];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[34];
				String cod_implemento = (String) row[35];
				String nom_implemento = (String) row[36];
				String docFactura = (String) row[37];
				String codLabor = (String) row[38];
				BigInteger pin = (BigInteger) row[39];
				BigInteger idRegistro = (BigInteger) row[40];
				String estatusRegistro = (String) row[41];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[42];
				BigInteger equipoId = (BigInteger) row[43];
				BigDecimal auxilioTransporte = (BigDecimal) row[44];
				BigInteger consecutivoPrefactura = (BigInteger) row[45];

				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCodFinca(cod_finca);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setNomUdadMed(nom_udad_med_pago);
				reporteA.setHoras(horas);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHoraInicial(hora_inicial);
				reporteA.setHoraFinal(hora_final);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setCodProducto(cod_producto);
				reporteA.setNomProducto(nom_producto);
				reporteA.setCantGalones(cantidad_galones);
				reporteA.setCodUdadMedIns(cod_udad_med_ins);
				reporteA.setNomUdadMedIns(nom_udad_med_ins);
				reporteA.setCostoCombustible(costo_combustible);
				reporteA.setHorasEquipoDia(horas_equipo_dia);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setSello(sello);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setNom_implemento(nom_implemento);
				reporteA.setDocFactura(docFactura);
				reporteA.setCodLabor(codLabor);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setAuxilio_transporte(auxilioTransporte);
				reporteA.setConsecutivoPrefactura(consecutivoPrefactura);

				String estadoEstrue = "false";
				if (estatusRegistro.equals("facturado") || estatusRegistro.equals("prefacturado")) {
					estadoEstrue = "true";
					reporteA.setEstadoTrue(estadoEstrue);
				}

				reporte.add(reporteA);

			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<CostosIndirectosEquipoDTO> pr_val_existencia_otros_costosmq(String idRegistro) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_val_existencia_otros_costosmq (:idRegistro)");

		q.setString("idRegistro", idRegistro);

		List l = q.list();
		ArrayList<CostosIndirectosEquipoDTO> reporte = new ArrayList<CostosIndirectosEquipoDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();
				CostosIndirectosEquipoDTO reporteA = new CostosIndirectosEquipoDTO();

				String idRegistroLlave = (String) row[0];

				reporteA.setLlaveImportacion(idRegistroLlave);
				reporte.add(reporteA);

				// consultaOtDes.add(consultaOt);

			}

		}
		return reporte;

	}
	
	@Override
	public List<ListaPlanillaNominaDTO> consultarListaPlanillaNomina(Long compania, Date fechaInicial, Date fechaFinal,Long planilla, String origen, String estadoplanilla) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_lista_planilla_nomina(:compania, :fechaInicial,  :fechaFinal, :planilla, :origen, :estadoplanilla)  ");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("planilla", planilla);
		q.setString("origen", origen);
		q.setString("estadoplanilla", estadoplanilla);
		
		// q.setParameterList("finca", fincas);

		// CALLute stored procedure and get list result
		List l = q.list();
		List<ListaPlanillaNominaDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<ListaPlanillaNominaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaPlanillaNominaDTO nominaA = new ListaPlanillaNominaDTO();
		
				 	 BigInteger planillaNominaId= (BigInteger) row[0];
				 	 Date	fechaRegistro=  (Date) row[1];
				 	 BigInteger consecutivo= (BigInteger) row[2];
					 String estado= (String) row[3];
					 String origenDatos=  (String) row[4];
					 String estadoPlanilla= (String) row[5];
					 String fechaCierrePlanilla=  (String) row[6];
					 String fechaAberturaPlanilla= (String) row[7];
					 String usuarioCierrePlanilla= (String) row[8];
					 BigInteger companiaId=  (BigInteger) row[9];
					 String fechaAnulacion= (String) row[11];
					 String fechaCreacion= (String) row[12];
					 String fechaModificacion= (String) row[13];
					 BigDecimal nRegistrosPlanilla= (BigDecimal) row[14];
					 BigDecimal unidades= (BigDecimal) row[15];
					 BigDecimal costoTotalPlanilla= (BigDecimal) row[16];
					 String usuarioDigitacion= (String) row[17];
					 String observacion= (String) row[18];
					 String tipoPlanilla= (String) row[21];
					 
					 nominaA.setPlanillaNominaId(planillaNominaId.longValue());
					 nominaA.setFechaRegistro(fechaRegistro);
					 nominaA.setConsecutivo(consecutivo.longValue());
					 nominaA.setEstado(estado);
					 nominaA.setOrigenDatos(origenDatos);
					 nominaA.setEstadoPlanilla(estadoPlanilla);
					 if(!fechaCierrePlanilla.toString().equals("")){
						 nominaA.setFechaCierrePlanilla( 
								 		fechaCierrePlanilla.toString().substring(8, 10)+"/"+
										 fechaCierrePlanilla.toString().substring(5, 7)+"/"+
										 fechaCierrePlanilla.toString().substring(0, 4));
					 }else {
						 nominaA.setFechaCierrePlanilla("");
					 }
				
					
					 if(!fechaAberturaPlanilla.toString().equals("")){
						 nominaA.setFechaAberturaPlanilla( 
								 fechaAberturaPlanilla.toString().substring(8, 10)+"/"+
										 fechaAberturaPlanilla.toString().substring(5, 7)+"/"+
										 fechaAberturaPlanilla.toString().substring(0, 4));
					 }else {
						 nominaA.setFechaAberturaPlanilla("");
					 }
					 nominaA.setUsuarioCierrePlanilla(usuarioCierrePlanilla.toString());
					 nominaA.setCompaniaId(companiaId.longValue());
					
					
					 if(!fechaAnulacion.toString().equals("")){
						 nominaA.setFechaAnulacion( 
								 fechaAnulacion.toString().substring(8, 10)+"/"+
										 fechaAnulacion.toString().substring(5, 7)+"/"+
										 fechaAnulacion.toString().substring(0, 4));
					 }else {
						 nominaA.setFechaAnulacion("");
					 }
					 
					 if(!fechaCreacion.toString().equals("")){
						 nominaA.setFechaCreacion( 
								 fechaCreacion.toString().substring(8, 10)+"/"+
										 fechaCreacion.toString().substring(5, 7)+"/"+
										 fechaCreacion.toString().substring(0, 4));
					 }else {
						 nominaA.setFechaCreacion("");
					 }
				
					 if(!fechaModificacion.toString().equals("")){
						 nominaA.setFechaModificacion( 
								 fechaModificacion.toString().substring(8, 10)+"/"+
										 fechaModificacion.toString().substring(5, 7)+"/"+
										 fechaModificacion.toString().substring(0, 4));
					 }else {
						 nominaA.setFechaModificacion("");
					 }
					 
					 
					 nominaA.setNregistrosPlanilla(nRegistrosPlanilla);
					 nominaA.setUnidades(unidades);
					 nominaA.setCostoTotalPlanilla(costoTotalPlanilla);
					 nominaA.setUsuarioDigitacion(usuarioDigitacion);
					 nominaA.setObservacion(observacion);
					 nominaA.setTipoPlanilla(tipoPlanilla);
					 
					 String estadoEstrue = "false";
					 
						if (nominaA.getEstadoPlanilla().equals("LIQUIDADA") || nominaA.getEstado().equals("ANULADA")) {
							estadoEstrue = "true";
							nominaA.setEstadoLiquidacionTrue(estadoEstrue);
						}else {
							nominaA.setEstadoLiquidacionTrue(estadoEstrue);
						}
						
					String estadoReAbrirLiquidacion ="false";
						if (nominaA.getEstadoPlanilla().equals("ABIERTA")	|| nominaA.getEstado().equals("ANULADA")) {
							estadoReAbrirLiquidacion = "true";
							nominaA.setEstadoReAbrirLiquidacion(estadoReAbrirLiquidacion);
						}else {
							nominaA.setEstadoReAbrirLiquidacion(estadoReAbrirLiquidacion);
						}
						
						
						
						
					 nomina.add(nominaA);
			}
		}
		session.close();

		return nomina;

	}

	
	@Override
	public List<ListaPlanillaNominaDetalladoDTO> reporteLaboresManualesDetalladoRD(Long compania, Date fechaInicial, Date fechaFinal,Long planilla, String origen, String estadoplanilla) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_lista_planilla_nomina_detallado(:compania, :fechaInicial,  :fechaFinal, :planilla, :origen, :estadoplanilla)  ");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("planilla", planilla);
		q.setString("origen", origen);
		q.setString("estadoplanilla", estadoplanilla);
		// q.setParameterList("finca", fincas);

		// CALLute stored procedure and get list result
		List l = q.list();
		List<ListaPlanillaNominaDetalladoDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<ListaPlanillaNominaDetalladoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaPlanillaNominaDetalladoDTO nominaA = new ListaPlanillaNominaDetalladoDTO();
					
				
				Date	fecha_registro	=	(Date) row[	0	];
				String	ficha	=	(String) row[	1	];
				String	cedula	=	(String) row[	2	];
				String	trabajador	=	(String) row[	3	];
				String	nomempresa	=	(String) row[	4	];
				String	cod_lote	=	(String) row[	5	];
				String	nom_lote	=	(String) row[	6	];
				String	cod_hacienda	=	(String) row[	7	];
				String	nom_hacienda	=	(String) row[	8	];
				String	cod_labor	=	(String) row[	9	];
				String	nom_labor	=	(String) row[	10	];
				String	cod_concepto_nomina	=	(String) row[	11	];
				String	nom_concepto_nomina	=	(String) row[	12	];
				BigDecimal	cantidad_pago	=	(BigDecimal) row[	13	];
				BigDecimal	valor_unitario	=	(BigDecimal) row[	14	];
				BigDecimal	costo_total	=	(BigDecimal) row[	15	];
				BigDecimal	n_planilla	=	(BigDecimal) row[	16	];
				String	origen_datos	=	(String) row[	17	];
				BigDecimal	numero_tiquete	=	(BigDecimal) row[	18	];
				String	nom_cliente	=	(String) row[	19	];
				String	cod_vagon	=	(String) row[	20	];
				String	tipo_corte	=	(String) row[	21	];
				String	modo_alce	=	(String) row[	22	];
				BigDecimal	nro_comprobante	=	(BigDecimal) row[	23	];
				BigDecimal	peso_molienda_kg	=	(BigDecimal) row[	24	];
				String	vagon_adicional	=	(String) row[	25	];
				String	fecha_carga	=	(String) row[	26	];
				String	fecha_descarga	=	(String) row[	27	];
				BigDecimal	planilla_nomina_id	=	(BigDecimal) row[	28	];
				String	estado	=	(String) row[	29	];
				String	estado_planilla	=	(String) row[	30	];
				String	fecha_cierre_planilla	=	(String) row[	31	];
				String	fecha_re_abertura_planilla	=	(String) row[	32	];
				String	usuario_cierre_planilla	=	(String) row[	33	];
				BigDecimal	id_compania	=	(BigDecimal) row[	34	];
				String	nom_compania	=	(String) row[	35	];
				String	fecha_anulacion	=	(String) row[	36	];
				String	fecha_creacion	=	(String) row[	37	];
				String	fecha_modificacion	=	(String) row[	38	];
				String	nom_udadMed	=	(String) row[	39	];
				nominaA.setFecha_registro(fecha_registro);
				nominaA.setFicha(ficha);
				nominaA.setCedula(cedula);
				nominaA.setTrabajador(trabajador);
				nominaA.setNomempresa(nomempresa);
				nominaA.setCod_lote(cod_lote);
				nominaA.setNom_lote(nom_lote);
				nominaA.setCod_hacienda(cod_hacienda);
				nominaA.setNom_hacienda(nom_hacienda);
				nominaA.setCod_labor(cod_labor);
				nominaA.setNom_labor(nom_labor);
				nominaA.setCod_concepto_nomina(cod_concepto_nomina);
				nominaA.setNom_concepto_nomina(nom_concepto_nomina);
				nominaA.setCantidad_pago(cantidad_pago);
				nominaA.setValor_unitario(valor_unitario);
				nominaA.setCosto_total(costo_total);
				nominaA.setN_planilla(n_planilla.longValue());
				nominaA.setOrigen_datos(origen_datos);
				nominaA.setNumero_tiquete(numero_tiquete.longValue());
				nominaA.setNom_cliente(nom_cliente);
				nominaA.setCod_vagon(cod_vagon);
				nominaA.setTipo_corte(tipo_corte);
				nominaA.setModo_alce(modo_alce);
				nominaA.setNro_comprobante(nro_comprobante.longValue());
				nominaA.setPeso_molienda_kg(peso_molienda_kg);
				nominaA.setVagon_adicional(vagon_adicional);
				nominaA.setFecha_carga(fecha_carga.toString());
				nominaA.setFecha_descarga(fecha_descarga.toString());
				nominaA.setPlanilla_nomina_id(planilla_nomina_id.longValue());
				nominaA.setEstado(estado);
				nominaA.setEstado_planilla(estado_planilla);
				nominaA.setFecha_cierre_planilla(fecha_cierre_planilla.toString());
				nominaA.setFecha_re_abertura_planilla(fecha_re_abertura_planilla.toString());
				nominaA.setUsuario_cierre_planilla(usuario_cierre_planilla);
				nominaA.setId_compania(id_compania);
				nominaA.setNom_compania(nom_compania);
				nominaA.setFecha_anulacion(fecha_anulacion.toString());
				nominaA.setFecha_creacion(fecha_creacion.toString());
				nominaA.setFecha_modificacion(fecha_modificacion.toString());
				nominaA.setNomUdadMed(nom_udadMed);
				nomina.add(nominaA);
			}
		}
		session.close();

		return nomina;

	}

	public Long pr_borrar_analisis_lab_detalle(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_analisis_lab_detalle (:id)");
		q.setLong("id", id);
		q.executeUpdate();

		return 1L;

	}
	
	public Long pr_borrar_analisis_lab(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_analisis_lab (:id)");
		q.setLong("id", id);
		q.executeUpdate();

		return 1L;

	}
	
	@Override
	public List<ConsultaCostosDiferidosDTO> pr_listar_dat_diferidos_agricola(Long compania, Date fechaInicial, Date fechaFinal) {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_listar_dat_diferidos_agricola (:compania, :fechaInicial,  :fechaFinal  )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);

		List l = q.list();
		List<ConsultaCostosDiferidosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCostosDiferidosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCostosDiferidosDTO reporteA = new ConsultaCostosDiferidosDTO();

				BigInteger consecutivo = (BigInteger) row[0];
				Date fecha_registro = (Date) row[1];
				BigDecimal valor_inicial = (BigDecimal) row[2];
				BigInteger periodos = (BigInteger) row[3];
				String detalle_nota = (String) row[4];
				String estado = (String) row[5];
				String observacion = (String) row[6];
				BigInteger datDiferidosAgricolaId = (BigInteger) row[7];
				String numeroFactura = (String) row[8];
				String cod_gasto = (String) row[9];
				String nom_gasto = (String) row[10];
				
				reporteA.setConsecutivo(consecutivo);
				reporteA.setFecha_registro(fecha_registro);
				reporteA.setValor_inicial(valor_inicial);
				reporteA.setPeriodos(periodos);
				reporteA.setDetalle_nota(detalle_nota);
				reporteA.setEstado(estado);
				reporteA.setObservacion(observacion);
				reporteA.setDatDiferidosAgricolaId(datDiferidosAgricolaId);
				reporteA.setNumeroFactura(numeroFactura);
				reporteA.setCodGasto(cod_gasto);
				reporteA.setNomGasto(nom_gasto);

				reporte.add(reporteA);
			}
		}
		session.close();

		return reporte;

	}
	
	@Override
	public long consultarConsecutivoDatDiferidosAgricola(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_diferidos_agricola (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	public Long pr_borrar_dat_diferidos_agricola(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_diferidos_agricola (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		return 1L;

	}

	public Long pr_borrar_dat_diferidos_agricola_det(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_diferidos_agricola_det (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		return 1L;

	}

	public Long pr_borrar_dat_diferidos_cuotas_agricola(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_diferidos_cuotas_agricola (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		return 1L;

	}
	
	@Override
	public List<DatNominaTrabajadorDTO> pr_lista_dat_nomina_trabajador(Long compania, Date fechaInicial, Date fechaFinal, Long planilla) {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_lista_dat_nomina_trabajador (:compania, :fechaInicial, :fechaFinal, :planilla )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("planilla", planilla);

		List l = q.list();
		List<DatNominaTrabajadorDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<DatNominaTrabajadorDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DatNominaTrabajadorDTO reporteA = new DatNominaTrabajadorDTO();

				BigInteger compania1 = (BigInteger) row[0];
				BigInteger datNominaTrabajadorId = (BigInteger) row[1];
				BigInteger consecutivo = (BigInteger) row[2];
				Date fechaInicial1 = (Date) row[3];
				Date fechaFinal1 = (Date) row[4];
				String observacion = (String) row[5];
				String estado = (String) row[6];
				String nomUsuarioDigitacion = (String) row[7];
				
				reporteA.setCompania(compania1.longValue());
				reporteA.setDatNominaTrabajadorId(datNominaTrabajadorId.longValue());
				reporteA.setConsecutivo(consecutivo.longValue());
				reporteA.setFechaInicial(fechaInicial1);
				reporteA.setFechaFinal(fechaFinal1);
				reporteA.setObservacion(observacion);
				reporteA.setEstado(estado);
				reporteA.setNomUsuarioDigitacion(nomUsuarioDigitacion);
				
				reporte.add(reporteA);
			}
		}
		session.close();

		return reporte;

	}
	
	@Override
	public List<DatOtrosCostosDTO> pr_listar_otros_costos(Long compania, Date fechaInicial, Date fechaFinal, Long planilla, String tipoDistri) {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_listar_otros_costos (:compania, :fechaInicial, :fechaFinal, :planilla, :tipoDistri )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("planilla", planilla);
		q.setString("tipoDistri", tipoDistri);

		List l = q.list();
		List<DatOtrosCostosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<DatOtrosCostosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DatOtrosCostosDTO reporteA = new DatOtrosCostosDTO();

				BigInteger datOtrosCostosId = (BigInteger) row[0];
				Date fechaRegistro = (Date) row[1];
				String tipoTransaccion = (String) row[2];
				BigInteger consecutivo = (BigInteger) row[3];
				String numFactura = (String) row[4];
				String observacion = (String) row[5];
				String estado = (String) row[6];
				String nomUsuarioDigitacion = (String) row[7];
				String codLabor = (String) row[8];
				String nomLabor = (String) row[9];
				BigDecimal valorTotal = (BigDecimal) row[10];
				String proveedor = (String) row[11];
				Date fechaInicial1 = (Date) row[12];
				
				reporteA.setDatOtrosCostosId(datOtrosCostosId.longValue());
				reporteA.setFechaRegistro(fechaRegistro);
				reporteA.setTipoTransaccion(tipoTransaccion);
				reporteA.setConsecutivo(consecutivo.longValue());
				reporteA.setNumFactura(numFactura);
				reporteA.setObservacion(observacion);
				reporteA.setEstado(estado);
				reporteA.setNomUsuarioDigitacion(nomUsuarioDigitacion);
				reporteA.setCodLabor(codLabor);
				reporteA.setNomLabor(nomLabor);
				reporteA.setValorTotal(valorTotal.doubleValue());
				reporteA.setProveedor(proveedor);
				reporteA.setFechaInicial(fechaInicial1);
				
				reporte.add(reporteA);
			}
		}
		session.close();

		return reporte;
	}
	
	@Override
	public List<DatTransProdDTO> pr_listar_produccion(Long compania, Date fechaInicial, Date fechaFinal, Long planilla) {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_listar_produccion (:compania, :fechaInicial, :fechaFinal, :planilla )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("planilla", planilla);

		List l = q.list();
		List<DatTransProdDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<DatTransProdDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DatTransProdDTO reporteA = new DatTransProdDTO();

				BigInteger datTransProdId = (BigInteger) row[0];
				Date fechaRegistro = (Date) row[1];
				String tipoTransaccion = (String) row[2];
				BigInteger consecutivo = (BigInteger) row[3];
				String observacion = (String) row[4];
				String estado = (String) row[5];
				String nomUsuarioDigitacion = (String) row[6];
				
				reporteA.setDatTransProdId(datTransProdId.longValue());
				reporteA.setFechaRegistro(fechaRegistro);
				reporteA.setTipoTransaccion(tipoTransaccion);				
				reporteA.setConsecutivo(consecutivo.longValue());
				reporteA.setObservacion(observacion);
				reporteA.setEstado(estado);
				reporteA.setNomUsuarioDigitacion(nomUsuarioDigitacion);
				
				reporte.add(reporteA);
			}
		}
		session.close();

		return reporte;

	}
	
	@Override
	public List<DatPlanLaborDTO> pr_lista_plan_labor(Long compania, Date fechaInicial, Date fechaFinal, Long planilla) throws ParseException {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_lista_plan_labor (:compania, :fechaInicial, :fechaFinal, :planilla )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("planilla", planilla);

		List l = q.list();
		List<DatPlanLaborDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<DatPlanLaborDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DatPlanLaborDTO reporteA = new DatPlanLaborDTO();

				BigInteger compania1 = (BigInteger) row[0];
				BigInteger planLaborId = (BigInteger) row[1];
				BigInteger ordenTrabajo = (BigInteger) row[2];
				BigInteger laborId_Labor = (BigInteger) row[3];
				String codLabor = (String) row[4];
				String laborNombre = (String) row[5];
				BigInteger udadMedId_UdadMed = (BigInteger) row[6];
				String codUdadMed = (String) row[7];				
				String udadMedNombre = (String) row[8];
				String nomUsuarioDigitacion = (String) row[9];				
				String estado = (String) row[10];				
				String nomTrabajador = (String) row[11];				
				String cierreOt = (String) row[12];				
				Timestamp periodoInicial = (Timestamp) row[13];
				Timestamp periodoFinal = (Timestamp) row[14];
				
				reporteA.setCompania(compania1.longValue());
				reporteA.setPlanLaborId(planLaborId.longValue());
				reporteA.setOrdenTrabajo(ordenTrabajo.longValue());
				reporteA.setLaborId_Labor(laborId_Labor.longValue());
				reporteA.setCodLabor(codLabor);
				reporteA.setLaborNombre(laborNombre);
				reporteA.setUdadMedId_UdadMed(udadMedId_UdadMed.longValue());
				reporteA.setCodUdadMed(codUdadMed);				
				reporteA.setUdadMedNombre(udadMedNombre); 
				reporteA.setNomUsuarioDigitacion(nomUsuarioDigitacion);				
				reporteA.setEstado(estado);				
				reporteA.setNomTrabajador(nomTrabajador);				
				reporteA.setCierreOt(cierreOt.toString());				
				reporteA.setPeriodoInicial(periodoInicial);
				reporteA.setPeriodoFinal(periodoFinal);
				
				String estadoEstrue = "false";
				if (reporteA.getEstado().equals("I")) {
					estadoEstrue = "true";
					reporteA.setEstadoTrue(estadoEstrue);
					reporteA.setEstadoTrue2(estadoEstrue);
				}
				
				reporteA.setEstadoTrue(estadoEstrue);

				String tituloCierreOt = "Esta seguro que desea cerrar la O.T ?";
				String icon = "ui-icon-unlocked";

				if (reporteA.getCierreOt().equals("C")) {
					tituloCierreOt = "Esta seguro que desea reabrir la O.T ?";
					icon = "ui-icon-locked";
					estadoEstrue = "true";
					reporteA.setEstadoTrue2(estadoEstrue);
					reporteA.setTituloCierreOt(tituloCierreOt);
					reporteA.setIconCierreOt(icon);
				}
				
				reporteA.setTituloCierreOt(tituloCierreOt);
				reporteA.setIconCierreOt(icon);
				reporteA.setEstadoTrue2(estadoEstrue);
				
				// Imagen O.T
				reporteA.setEstadoOrdenTrabajoVencida(estadoOrdenTrabajo(reporteA.getPeriodoFinal(),
						reporteA.getCierreOt(), reporteA.getEstado()));

				// Calcular los dias de atraso
				reporteA.setDiasAtarsoOt(diasDeAtraso(reporteA.getPeriodoFinal(),
						reporteA.getCierreOt(), reporteA.getEstado()));
				
				reporte.add(reporteA);
			}
			
		}
		session.close();

		return reporte;

	}
	
	public String estadoOrdenTrabajo(Date fechaFinOt, String cierreOt, String estado) throws ParseException {

		Date fechaHoy = new Date();
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dmyHoy = dmyFormat.format(fechaHoy);
		String dmyOt = dmyFormat.format(fechaFinOt);

		Date dateDmyHoy = dmyFormat.parse(dmyHoy);
		Date dateDmyOt = dmyFormat.parse(dmyOt);

		long fechaHoy1 = dateDmyHoy.getTime();
		long fechaOT = dateDmyOt.getTime();

		String img = "";

		if (estado.equals("A")) {

			if (cierreOt.equals("A")) {

				if (fechaOT >= fechaHoy1) {
					img = "green_alert.gif";
				} else {
					img = "alerta01.gif";

				}
			} else {

				img = "candado.png";
			}
		} else {

			img = "anulado.png";
		}

		return img;
	}

	public long diasDeAtraso(Date fechaFinOt2, String cierreOt, String estado) throws ParseException {

		java.util.Date hoy = new Date();
		GregorianCalendar calendario = new GregorianCalendar();
		GregorianCalendar calendario2 = new GregorianCalendar();

		// se extrae de la fecha fechaFinOt2 el dia - mes - año
		calendario.setTime(fechaFinOt2);
		int dia = calendario.get(java.util.Calendar.DAY_OF_MONTH);
		int mes = calendario.get(java.util.Calendar.MONTH);
		int ano = calendario.get(java.util.Calendar.YEAR);
		calendario.set(ano, mes, dia);
		java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

		calendario2.setTime(hoy);
		int diaHoy = calendario2.get(java.util.Calendar.DAY_OF_MONTH);
		int mesHoy = calendario2.get(java.util.Calendar.MONTH);
		int anoHoy = calendario2.get(java.util.Calendar.YEAR);

		calendario.set(anoHoy, mesHoy, diaHoy);
		java.sql.Date fechaHoy = new java.sql.Date(calendario2.getTimeInMillis());

		long dias = 1L;

		if ((cierreOt.equals("A")) && (estado.equals("A"))) {

			if (fechaHoy.getTime() > fecha.getTime()) {

				long diffDays = (fechaHoy.getTime() - fecha.getTime());
				dias = diffDays / (24 * 60 * 60 * 1000);

			} else {
				dias = 0;
			}

		} else {
			dias = 0;
		}

		return dias;

	}
	
	@Override
	public List<ListaNivel4DTO> listaCodigosErp( String nivel3Id) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_lista_codigo_erp ( :nivel3id)");
		
		q.setString("nivel3id", nivel3Id);

		List l = q.list();
		ArrayList<ListaNivel4DTO> reporte = new ArrayList<ListaNivel4DTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaNivel4DTO reportes = new ListaNivel4DTO();
				BigInteger nivel3_id = (BigInteger) row[0];
				String codigoErp = (String) row[1];
				BigInteger cantidadTablones = (BigInteger) row[2];
				BigDecimal areaNeta = (BigDecimal) row[3];			

				reportes.setNivel3_id(nivel3_id);
				reportes.setCodigoErp(codigoErp);
				reportes.setArea_neta(areaNeta);
				reportes.setCantidadTablones(cantidadTablones);

				reporte.add(reportes);

			}

		}
		session.close();
		
		return reporte;
	}
	
	@Override
	public List<ListaNivel4DTO> pr_lista_nivel4_filtro_nivel3( String nivel3Id) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_lista_nivel4_filtro_nivel3 (:nivel3id)");

		q.setString("nivel3id", nivel3Id);

		List l = q.list();
		ArrayList<ListaNivel4DTO> reporte = new ArrayList<ListaNivel4DTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaNivel4DTO reportes = new ListaNivel4DTO();
				BigInteger nivel3_id = (BigInteger) row[0];
				String codigoErp = (String) row[1];
				BigInteger  nivel4Id = (BigInteger) row[2];
				BigDecimal areaNeta = (BigDecimal) row[3];			
				String nombreNivel4 = (String) row[5];
			
				reportes.setNivel3_id(nivel3_id);
				reportes.setCodigoErp(codigoErp);
				reportes.setArea_neta(areaNeta);
				reportes.setNivel4_id(nivel4Id);
				reportes.setNom_nivel4(nombreNivel4);

				reporte.add(reportes);

			}

		}
		session.close();
		
		return reporte;
	}

	public Long pr_liquidar_planilla_nomina_periodo(Long compania, Date fechaInicial, Date fechaFinal, Long usuarioId) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_liquidar_planilla_nomina_periodo (:compania, :fechaInicial, :fechaFinal, :usuarioId)");
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("usuarioId", usuarioId);
		q.setLong("compania", compania);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	public Long pr_re_liquidar_planilla_nomina_periodo(Long compania, Date fechaInicial, Date fechaFinal, Long usuarioId) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_re_liquidar_planilla_nomina_periodo (:compania, :fechaInicial, :fechaFinal, :usuarioId)");
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("usuarioId", usuarioId);
		q.setLong("compania", compania);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	
	@Override
	public List<NominaDetalladaDTO> pr_desprendible_pago_agricola(Long compania, Date fechaInicial,
			Date fechaFinal, String trabajadorId, Long flagTrabajador) {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_desprendible_pago_agricola (:compania, :fecha_inicial, " 
				+ ":fecha_final, :trabajadorid, :flagtrabajador)");

		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("trabajadorid", trabajadorId);
		q.setLong("flagtrabajador", flagTrabajador);

		List l = q.list();
		ArrayList<NominaDetalladaDTO> reporte = new ArrayList<NominaDetalladaDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				NominaDetalladaDTO reportes = new NominaDetalladaDTO();
				
				Date fechaRegistro = (Date) row[0];
				String ficha = (String) row[1];
				String cedula = (String) row[2];
				String trabajador = (String) row[3];			
				String nomEmpresa = (String) row[4];
				String codConceptoNomina = (String) row[5];
				String nomConceptoNomina = (String) row[6];
				BigDecimal cantidadPago = (BigDecimal) row[7];			
				BigDecimal devengo = (BigDecimal) row[8];		
				BigDecimal deduccion = (BigDecimal) row[9];
				String tipoMovimiento = (String) row[10];		
				BigInteger companiaId = (BigInteger) row[11];
				String nomCompania = (String) row[12];	
				String nomProfesion = (String) row[13];	
			
				reportes.setFechaRegistro(fechaRegistro);
				reportes.setFicha(ficha);
				reportes.setCedula(cedula);
				reportes.setTrabajador(trabajador);
				reportes.setNomEmpresa(nomEmpresa);
				reportes.setCodConceptoNomina(codConceptoNomina);
				reportes.setNomConceptoNomina(nomConceptoNomina);
				reportes.setCantidadPago(cantidadPago);
				reportes.setDevengo(devengo);
				reportes.setDeduccion(deduccion);
				reportes.setTipoMovimiento(tipoMovimiento);
				reportes.setCompania(companiaId);
				reportes.setNomCompania(nomCompania);
				reportes.setNomProfesion(nomProfesion);

				reporte.add(reportes);
			}
		}
		session.close();
		
		return reporte;
	}
	
	@Override
	public List<ConsultaDiferidosDTO> pr_dat_diferidos_agricolas(Long compania, Date fechaInicial, Date fechaFinal, 
			String hacienda, Long flagHacienda, String lote, Long flagLote) {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_dat_diferidos_agricolas (:compania, :fecha_inicial, :fecha_final,"
				+ ":hacienda, :flaghacienda, :lote, :flaglote)");

		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("hacienda", hacienda);
		q.setString("lote", lote);
		q.setLong("flaghacienda", flagHacienda);
		q.setLong("flaglote", flagLote);

		List l = q.list();
		ArrayList<ConsultaDiferidosDTO> reporte = new ArrayList<ConsultaDiferidosDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaDiferidosDTO reportes = new ConsultaDiferidosDTO();
				
				BigInteger consecutivo = (BigInteger) row[0];
				Date fechaRegistro = (Date) row[1];
				BigDecimal valorInicial = (BigDecimal) row[2];
				BigDecimal valorCuota = (BigDecimal) row[3];			
				BigInteger periodos = (BigInteger) row[4];
				String detalleNota = (String) row[5];
				BigDecimal anio = (BigDecimal) row[6];
				BigDecimal mes = (BigDecimal) row[7];			
				String observacion = (String) row[8];		
				String nomZona = (String) row[9];
				String codHacienda = (String) row[10];		
				String nomHacienda = (String) row[11];
				String codBloque = (String) row[12];	
				String nomBloque = (String) row[13];		
				String codLote = (String) row[14];
				String nomLote = (String) row[15];	
				String numeroFactura = (String) row[16];	
				Date fecha = (Date) row[17];	
				String codGasto = (String) row[18];		
				String nomGasto = (String) row[19];
				String anioMes = (String) row[20];	

				reportes.setConsecutivo(consecutivo);
				reportes.setFechaRegistro(fechaRegistro);
				reportes.setValorInicial(valorInicial);
				reportes.setValorCuota(valorCuota);
				reportes.setPeriodos(periodos);
				reportes.setDetalleNota(detalleNota);
				reportes.setAnio(anio);
				reportes.setMes(mes);
				reportes.setObservacion(observacion);
				reportes.setNomZona(nomZona);
				reportes.setCodHacienda(codHacienda);
				reportes.setNomHacienda(nomHacienda);
				reportes.setCodBloque(codBloque);
				reportes.setNomBloque(nomBloque);				
				reportes.setCodLote(codLote);
				reportes.setNomLote(nomLote);
				reportes.setNumeroFactura(numeroFactura);
				reportes.setFecha(fecha);
				reportes.setCodGasto(codGasto);
				reportes.setNomGasto(nomGasto);
				reportes.setAnioMes(anioMes);

				reporte.add(reportes);
			}
		}
		session.close();
		
		return reporte;
	}
	
	@Override
	public List<ListaProduccionDTO> pr_listar_reg_produccion(Long compania, Date fechaInicial, Date fechaFinal, Long planilla,
			String hacienda, Long flagHacienda, String lote, Long flagLote) {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_listar_reg_produccion (:compania, :fechaInicial, :fechaFinal, :planilla,"
				+ ":hacienda, :flaghacienda, :lote, :flaglote )");
		
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("planilla", planilla);
		q.setString("hacienda", hacienda);
		q.setString("lote", lote);
		q.setLong("flaghacienda", flagHacienda);
		q.setLong("flaglote", flagLote);

		List l = q.list();
		List<ListaProduccionDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ListaProduccionDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaProduccionDTO reporteA = new ListaProduccionDTO();

				BigInteger ref = (BigInteger) row[0];
				Date fechaRegistro = (Date) row[1];
				String tipoTransaccion = (String) row[2];
				BigInteger consecutivo = (BigInteger) row[3];
				String observacion = (String) row[4];
				String estado = (String) row[5];
				String nomUsuarioDigitacion = (String) row[6];
				String codFinca = (String) row[7];
				String nomFinca = (String) row[8];
				String codLote = (String) row[9];
				String nomLote = (String) row[10];
				String fechaIni = (String) row[11];
				String fechaFin = (String) row[12];
				BigDecimal valorUnitario = (BigDecimal) row[13];
				BigDecimal ingresoBruto = (BigDecimal) row[14];
				BigInteger id = (BigInteger) row[15];
				Date finCosecha = (Date) row[16];
				String estadoRegistro = (String) row[17];
				reporteA.setRef(ref.longValue());
				reporteA.setFechaRegistro(fechaRegistro);
				reporteA.setTipoTransaccion(tipoTransaccion);				
				reporteA.setConsecutivo(consecutivo.longValue());
				reporteA.setObservacion(observacion);
				reporteA.setEstado(estado);				
				reporteA.setNomUsuarioDigitacion(nomUsuarioDigitacion);				
				reporteA.setCodFinca(codFinca);
				reporteA.setNomFinca(nomFinca);
				reporteA.setCodLote(codLote);		
				reporteA.setNomLote(nomLote);				
				reporteA.setFechaIni(fechaIni);
				reporteA.setFechaFin(fechaFin);				
				reporteA.setValorUnitario(valorUnitario.doubleValue());
				reporteA.setIngresoBruto(ingresoBruto.doubleValue());
				reporteA.setId(id.longValue());
				reporteA.setFinCosecha(finCosecha);
				reporteA.setEstadoRegistro(estadoRegistro);
				String estadoEstrue = "false";
				if (reporteA.getEstadoRegistro().equals("cerrado") || reporteA.getEstado().equals("I") ) {
					estadoEstrue = "true";
					reporteA.setEstadoEstrue(estadoEstrue);
					
				}
				reporteA.setEstadoEstrue(estadoEstrue);
				
				String estadoEstrue2 = "false";
				if (reporteA.getEstadoRegistro().equals("abierto") || reporteA.getEstado().equals("I") 	) {
					estadoEstrue2 = "true";
					reporteA.setEstadoEstrue2(estadoEstrue2);
					
				}
				reporteA.setEstadoEstrue2(estadoEstrue2);
				
				
				
				reporte.add(reporteA);
			}
		}
		session.close();

		return reporte;
	}

	@Override
	public List<CostosTotalesDTO> pr_costos_ingresos_compania_detallado(Long compania, Date fechaInicial, Date fechaFinal,			
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_ingresos_compania_detallado (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :origendatos )");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
		q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				String nombreCompania = (String) row[0];
				BigDecimal anio = (BigDecimal) row[1];
				BigDecimal mes = (BigDecimal) row[2];
				String codZona = (String) row[3];
				String nomZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String nomBloque = (String) row[8];
				String codLote = (String) row[9];
				String loteA = (String) row[10];
				String codLabor = (String) row[11];
				String nombreLabor = (String) row[12];
				String codGrupoLabor = (String) row[13];
				String nombreGrupoLabor = (String) row[14];
				BigDecimal cantidadPago = (BigDecimal) row[15];
				BigDecimal costoTotal = (BigDecimal) row[16];
				String codUdadMedPago = (String) row[17];
				BigDecimal cantidadCos = (BigDecimal) row[18];
				BigDecimal areaCos = (BigDecimal) row[19];
				BigDecimal ingresos = (BigDecimal) row[20];
				String codUdadMedCos = (String) row[21];
				String nombreElementoCosto = (String) row[22];
				String nombreProducto = (String) row[23];
				BigInteger numeroCosechas1 = (BigInteger) row[24];
				String fechaUltCorte = (String) row[25];
				String variedad = (String) row[26];
				String sistemaRiego = (String) row[27];
				String infraestructura = (String) row[28];
				BigDecimal areaRegada = (BigDecimal) row[29];
				BigDecimal horasRiego = (BigDecimal) row[30];
				BigDecimal m3Totales = (BigDecimal) row[31];
				Date fechaR = (Date) row[32];
				BigDecimal area = (BigDecimal) row[33];
				String elementoCostosMes = (String) row[34];
				String codProducto = (String) row[35];
				String origenDatos = (String) row[36];
				BigInteger id = (BigInteger) row[37];
				BigInteger idDetalle = (BigInteger) row[38];
				BigDecimal valorUnitario = (BigDecimal) row[39];

				pyGA.setFechaRegistro(fechaR);
				pyGA.setArea(area);
				pyGA.setNombreCompania(nombreCompania);
				pyGA.setAnio(anio);
				pyGA.setMes(mes);
				pyGA.setCodZona(codZona);
				pyGA.setCodFinca(codFinca);
				pyGA.setNomFinca(nomFinca);
				pyGA.setCodBloque(codBloque);
				pyGA.setLoteA(loteA);
				pyGA.setCodLabor(codLabor);
				pyGA.setNombreLabor(nombreLabor);
				pyGA.setCodGrupoLabor(codGrupoLabor);
				pyGA.setNombreGrupoLabor(nombreGrupoLabor);
				pyGA.setCantidadPago(cantidadPago);
				pyGA.setCostoTotal(costoTotal);
				pyGA.setCodUdadMedPago(codUdadMedPago);
				pyGA.setCantidadCos(cantidadCos);
				pyGA.setAreaCos(areaCos);
				pyGA.setIngresos(ingresos);
				pyGA.setCodUdadMedCos(codUdadMedCos);
				pyGA.setNombreElementoCosto(nombreElementoCosto);
				pyGA.setNombreProducto(nombreProducto);
				pyGA.setNumeroCosechas1(numeroCosechas1);
				pyGA.setFechaUltCorte(fechaUltCorte);
				pyGA.setVariedad(variedad);
				pyGA.setSistemaRiego(sistemaRiego);
				pyGA.setInfraestructura(infraestructura);
				pyGA.setAreaRegada(areaRegada);
				pyGA.setHorasRiego(horasRiego);
				pyGA.setM3Totales(m3Totales);
				pyGA.setElementoCostosMes(elementoCostosMes);
				pyGA.setCodProducto(codProducto);
				pyGA.setOrigenDatos(origenDatos);
				pyGA.setId(idDetalle);
				pyGA.setIdDetalle(idDetalle);
				pyGA.setValorUnitario(valorUnitario);

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}

	@Override
	public List<CostosTotalesDTO> pr_costos_detallado(Long compania, Date fechaInicial, Date fechaFinal,			
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_detallado (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :origendatos )");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
		q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				String nombreCompania = (String) row[0];
				BigDecimal anio = (BigDecimal) row[1];
				BigDecimal mes = (BigDecimal) row[2];
				String codZona = (String) row[3];
				String nomZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String nomBloque = (String) row[8];
				String codLote = (String) row[9];
				String loteA = (String) row[10];
				String codLabor = (String) row[11];
				String nombreLabor = (String) row[12];
				String codGrupoLabor = (String) row[13];
				String nombreGrupoLabor = (String) row[14];
				BigDecimal cantidadPago = (BigDecimal) row[15];
				BigDecimal costoTotal = (BigDecimal) row[16];
				String codUdadMedPago = (String) row[17];
				BigDecimal cantidadCos = (BigDecimal) row[18];
				BigDecimal areaCos = (BigDecimal) row[19];
				BigDecimal ingresos = (BigDecimal) row[20];
				String codUdadMedCos = (String) row[21];
				String nombreElementoCosto = (String) row[22];
				String nombreProducto = (String) row[23];
				BigInteger numeroCosechas1 = (BigInteger) row[24];
				String fechaUltCorte = (String) row[25];
				String variedad = (String) row[26];
				String sistemaRiego = (String) row[27];
				String infraestructura = (String) row[28];
				BigDecimal areaRegada = (BigDecimal) row[29];
				BigDecimal horasRiego = (BigDecimal) row[30];
				BigDecimal m3Totales = (BigDecimal) row[31];
				Date fechaR = (Date) row[32];
				BigDecimal area = (BigDecimal) row[33];
				String elementoCostosMes = (String) row[34];
				String codProducto = (String) row[35];
				String origenDatos = (String) row[36];
				BigInteger id = (BigInteger) row[37];
				BigInteger idDetalle = (BigInteger) row[38];
				BigDecimal valorUnitario = (BigDecimal) row[39];

				pyGA.setFechaRegistro(fechaR);
				pyGA.setArea(area);
				pyGA.setNombreCompania(nombreCompania);
				pyGA.setAnio(anio);
				pyGA.setMes(mes);
				pyGA.setCodZona(codZona);
				pyGA.setCodFinca(codFinca);
				pyGA.setNomFinca(nomFinca);
				pyGA.setCodBloque(codBloque);
				pyGA.setLoteA(loteA);
				pyGA.setCodLabor(codLabor);
				pyGA.setNombreLabor(nombreLabor);
				pyGA.setCodGrupoLabor(codGrupoLabor);
				pyGA.setNombreGrupoLabor(nombreGrupoLabor);
				pyGA.setCantidadPago(cantidadPago);
				pyGA.setCostoTotal(costoTotal);
				pyGA.setCodUdadMedPago(codUdadMedPago);
				pyGA.setCantidadCos(cantidadCos);
				pyGA.setAreaCos(areaCos);
				pyGA.setIngresos(ingresos);
				pyGA.setCodUdadMedCos(codUdadMedCos);
				pyGA.setNombreElementoCosto(nombreElementoCosto);
				pyGA.setNombreProducto(nombreProducto);
				pyGA.setNumeroCosechas1(numeroCosechas1);
				pyGA.setFechaUltCorte(fechaUltCorte);
				pyGA.setVariedad(variedad);
				pyGA.setSistemaRiego(sistemaRiego);
				pyGA.setInfraestructura(infraestructura);
				pyGA.setAreaRegada(areaRegada);
				pyGA.setHorasRiego(horasRiego);
				pyGA.setM3Totales(m3Totales);
				pyGA.setElementoCostosMes(elementoCostosMes);
				pyGA.setCodProducto(codProducto);
				pyGA.setOrigenDatos(origenDatos);
				pyGA.setId(idDetalle);
				pyGA.setIdDetalle(idDetalle);
				pyGA.setValorUnitario(valorUnitario);

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}

	@Override
	public List<CostosTotalesDTO> pr_costos_ingresos_lotes_cosechados_periodo_det(Long compania, Date fechaInicial, Date fechaFinal,			
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, 
			String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1, String grpLabor, Long flagGrpLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_ingresos_lotes_cosechados_periodo_det (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :origendatos, :grplabor, :flaggrplabor )");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
		q.setString("origendatos", origenDatos1);
		q.setLong("flaggrplabor", flagGrpLabor);
		q.setString("grplabor", grpLabor);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				String nombreCompania = (String) row[0];
				BigDecimal anio = (BigDecimal) row[1];
				BigDecimal mes = (BigDecimal) row[2];
				String codZona = (String) row[3];
				String nomZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String nomBloque = (String) row[8];
				String codLote = (String) row[9];
				String loteA = (String) row[10];
				String codLabor = (String) row[11];
				String nombreLabor = (String) row[12];
				String codGrupoLabor = (String) row[13];
				String nombreGrupoLabor = (String) row[14];
				BigDecimal cantidadPago = (BigDecimal) row[15];
				BigDecimal costoTotal = (BigDecimal) row[16];
				String codUdadMedPago = (String) row[17];
				BigDecimal cantidadCos = (BigDecimal) row[18];
				BigDecimal areaCos = (BigDecimal) row[19];
				BigDecimal ingresos = (BigDecimal) row[20];
				String codUdadMedCos = (String) row[21];
				String nombreElementoCosto = (String) row[22];
				String nombreProducto = (String) row[23];
				BigInteger numeroCosechas1 = (BigInteger) row[24];
				String fechaUltCorte = (String) row[25];
				String variedad = (String) row[26];
				String sistemaRiego = (String) row[27];
				String infraestructura = (String) row[28];
				BigDecimal areaRegada = (BigDecimal) row[29];
				BigDecimal horasRiego = (BigDecimal) row[30];
				BigDecimal m3Totales = (BigDecimal) row[31];
				Date fechaR = (Date) row[32];
				BigDecimal area = (BigDecimal) row[33];
				String elementoCostosMes = (String) row[34];
				String codProducto = (String) row[35];
				String origenDatos = (String) row[36];
				BigInteger id = (BigInteger) row[37];
				BigInteger idDetalle = (BigInteger) row[38];
				BigDecimal valorUnitario = (BigDecimal) row[39];

				pyGA.setFechaRegistro(fechaR);
				pyGA.setArea(area);
				pyGA.setNombreCompania(nombreCompania);
				pyGA.setAnio(anio);
				pyGA.setMes(mes);
				pyGA.setCodZona(codZona);
				pyGA.setCodFinca(codFinca);
				pyGA.setNomFinca(nomFinca);
				pyGA.setCodBloque(codBloque);
				pyGA.setLoteA(loteA);
				pyGA.setCodLabor(codLabor);
				pyGA.setNombreLabor(nombreLabor);
				pyGA.setCodGrupoLabor(codGrupoLabor);
				pyGA.setNombreGrupoLabor(nombreGrupoLabor);
				pyGA.setCantidadPago(cantidadPago);
				pyGA.setCostoTotal(costoTotal);
				pyGA.setCodUdadMedPago(codUdadMedPago);
				pyGA.setCantidadCos(cantidadCos);
				pyGA.setAreaCos(areaCos);
				pyGA.setIngresos(ingresos);
				pyGA.setCodUdadMedCos(codUdadMedCos);
				pyGA.setNombreElementoCosto(nombreElementoCosto);
				pyGA.setNombreProducto(nombreProducto);
				pyGA.setNumeroCosechas1(numeroCosechas1);
				pyGA.setFechaUltCorte(fechaUltCorte);
				pyGA.setVariedad(variedad);
				pyGA.setSistemaRiego(sistemaRiego);
				pyGA.setInfraestructura(infraestructura);
				pyGA.setAreaRegada(areaRegada);
				pyGA.setHorasRiego(horasRiego);
				pyGA.setM3Totales(m3Totales);
				pyGA.setElementoCostosMes(elementoCostosMes);
				pyGA.setCodProducto(codProducto);
				pyGA.setOrigenDatos(origenDatos);
				pyGA.setId(idDetalle);
				pyGA.setIdDetalle(idDetalle);
				pyGA.setValorUnitario(valorUnitario);

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}

	@Override
	public List<CostosTotalesDTO> pr_costos_resumen_labor_grupo(Long compania, Date fechaInicial, Date fechaFinal,			
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_resumen_labor_grupo (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :origendatos )");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
		q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				String nombreCompania = (String) row[0];
				String codZona = (String) row[1];
				String nomZona = (String) row[2];
				String codFinca = (String) row[3];
				String nomFinca = (String) row[4];
				String codBloque = (String) row[5];
				String nomBloque = (String) row[6];
				String codLote = (String) row[7];
				String loteA = (String) row[8];
				String codLabor = (String) row[9];
				String nombreLabor = (String) row[10];
				String codGrupoLabor = (String) row[11];
				String nombreGrupoLabor = (String) row[12];
				BigDecimal cantidadPago = (BigDecimal) row[13];
				BigDecimal costoTotal = (BigDecimal) row[14];
				String variedad = (String) row[15];
				BigDecimal areaRegada = (BigDecimal) row[16];
				BigDecimal costoSobreArea = (BigDecimal) row[17];

				pyGA.setNombreCompania(nombreCompania);
				pyGA.setCodZona(codZona);
				pyGA.setNomZona(nomZona);
				pyGA.setCodFinca(codFinca);
				pyGA.setNomFinca(nomFinca);
				pyGA.setCodBloque(codBloque);
				pyGA.setNomBloque(nomBloque);
				pyGA.setCodLote(codLote);				
				pyGA.setLoteA(loteA);
				pyGA.setCodLabor(codLabor);
				pyGA.setNombreLabor(nombreLabor);
				pyGA.setCodGrupoLabor(codGrupoLabor);
				pyGA.setNombreGrupoLabor(nombreGrupoLabor);
				pyGA.setCantidadPago(cantidadPago);
				pyGA.setCostoTotal(costoTotal);
				pyGA.setVariedad(variedad);
				pyGA.setAreaRegada(areaRegada);
				pyGA.setCostoSobreArea(costoSobreArea);

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}

	@Override
	public List<CostosTotalesDTO> pr_costos_resumen_labor_grupo_lotes_cosechados(Long compania, Date fechaInicial, Date fechaFinal,			
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, 
			String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1, String grpLabor, Long flagGrpLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_resumen_labor_grupo_lotes_cosechados (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :origendatos, :grplabor, :flaggrplabor)");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("grplabor", grpLabor);
		q.setLong("flaggrplabor", flagGrpLabor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
		q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				String nombreCompania = (String) row[0];
				String codZona = (String) row[1];
				String nomZona = (String) row[2];
				String codFinca = (String) row[3];
				String nomFinca = (String) row[4];
				String codBloque = (String) row[5];
				String nomBloque = (String) row[6];
				String codLote = (String) row[7];
				String loteA = (String) row[8];
				String codLabor = (String) row[9];
				String nombreLabor = (String) row[10];
				String codGrupoLabor = (String) row[11];
				String nombreGrupoLabor = (String) row[12];
				BigDecimal cantidadPago = (BigDecimal) row[13];
				BigDecimal costoTotal = (BigDecimal) row[14];
				String variedad = (String) row[15];
				BigDecimal areaRegada = (BigDecimal) row[16];
				BigDecimal costoSobreArea = (BigDecimal) row[17];
				String codUdadMedPago = (String) row[18];
				BigDecimal cantHa = (BigDecimal) row[19];
				BigDecimal rendimiento = (BigDecimal) row[20];

				pyGA.setNombreCompania(nombreCompania);
				pyGA.setCodZona(codZona);
				pyGA.setNomZona(nomZona);
				pyGA.setCodFinca(codFinca);
				pyGA.setNomFinca(nomFinca);
				pyGA.setCodBloque(codBloque);
				pyGA.setNomBloque(nomBloque);
				pyGA.setCodLote(codLote);				
				pyGA.setLoteA(loteA);
				pyGA.setCodLabor(codLabor);
				pyGA.setNombreLabor(nombreLabor);
				pyGA.setCodGrupoLabor(codGrupoLabor);
				pyGA.setNombreGrupoLabor(nombreGrupoLabor);
				pyGA.setCantidadPago(cantidadPago);
				pyGA.setCostoTotal(costoTotal);
				pyGA.setVariedad(variedad);
				pyGA.setAreaRegada(areaRegada);
				pyGA.setCostoSobreArea(costoSobreArea);
				pyGA.setCodUdadMedPago(codUdadMedPago);
				pyGA.setCantHa(cantHa);
				pyGA.setRendimiento(rendimiento);
				pyGA.setDias(0.0);

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}

	@Override
	public List<CosechasLoteDTO> pr_pyg_lotes_cosechados(Long compania, Date fechaInicial, Date fechaFinal,	String zona, 
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, 
			String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_pyg_lotes_cosechados (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona,"
				+ " :finca, :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :origendatos)");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
		q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CosechasLoteDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CosechasLoteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CosechasLoteDTO pyGA = new CosechasLoteDTO();
				String nomCompania = (String) row[0];
				BigDecimal anio = (BigDecimal) row[1];
				BigDecimal mes = (BigDecimal) row[2];				
				String codZona = (String) row[3];
				String nomZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String nomBloque = (String) row[8];
				String codLote = (String) row[9];
				String loteA = (String) row[10];
				BigDecimal costoTotal = (BigDecimal) row[11];
				BigDecimal cantCosechada = (BigDecimal) row[12];
				BigDecimal areaCosechada = (BigDecimal) row[13];
				BigDecimal ingresos = (BigDecimal) row[14];				
				BigInteger numCosechas = (BigInteger) row[15];
				String fechaUltCorte = (String) row[16];
				String variedad = (String) row[17];				
				BigDecimal areaNeta = (BigDecimal) row[18];
				BigDecimal edadUltCosecha = (BigDecimal) row[19];
				BigDecimal rendimiento = (BigDecimal) row[20];

				pyGA.setNomCompania(nomCompania);
				pyGA.setCodZona(codZona);
				pyGA.setNomZona(nomZona);
				pyGA.setCodFinca(codFinca);
				pyGA.setNomFinca(nomFinca);
				pyGA.setCodBloque(codBloque);
				pyGA.setNomBloque(nomBloque);
				pyGA.setCodLote(codLote);				
				pyGA.setLoteA(loteA);
				pyGA.setCostoTotal(costoTotal);
				pyGA.setCantCosechada(cantCosechada);
				pyGA.setAreaCosechada(areaCosechada);
				pyGA.setIngresos(ingresos);
				pyGA.setNumCosechas(numCosechas);
				pyGA.setFechaUltCorte(fechaUltCorte);
				pyGA.setVariedad(variedad);
				pyGA.setAreaNeta(areaNeta);
				pyGA.setEdadUltCosecha(edadUltCosecha);
				pyGA.setRendimiento(rendimiento);

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}
	
	@Override
	public Long pr_borrar_cierre_costos_agricolas(Long compania, Date fechaInicial, Date fechaFinal) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_borrar_cierre_costos_agricolas (:compania, :fechaInicial, :fechaFinal)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;
	}
	
	@Override
	public Long pr_interfaz_cierre_costos_agricolas(Long compania, Date fechaInicial, Date fechaFinal) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_interfaz_cierre_costos_agricolas (:compania, :fechaInicial, :fechaFinal)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;
	}

	@Override
	public List<CostosTotalesDTO> pr_costo_parcial_detallado(Long compania, Date fechaInicial, Date fechaFinal,			
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, 
			String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor, Long diaslabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costo_parcial_detallado (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :grplabor, :flaggrplabor, :diaslabor)");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("grplabor", grpLabor);
		q.setLong("flaggrplabor", flagGrpLabor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
		q.setLong("diaslabor", diaslabor);
	//	q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				BigInteger	idregistro		=	(BigInteger) row[	0	];
				BigInteger	idlote		=	(BigInteger) row[	1	];
				String	idfinca		=	(String) row[	2	];
				String	codlote		=	(String) row[	3	];
				String	idlabor		=	(String) row[	4	];
				Date	fecha		=	(Date) row[	5	];
				String	idinsumo		=	(String) row[	6	];
				BigDecimal	cantidad		=	(BigDecimal) row[	7	];
				BigDecimal	valor		=	(BigDecimal) row[	8	];
				String	undmedida		=	(String) row[	9	];
				String	tipocosto		=	(String) row[	10	];
				BigInteger	numerodoc		=	(BigInteger) row[	11	];
				String	detalle		=	(String) row[	12	];
				BigInteger	aplicado		=	(BigInteger) row[	13	];
				BigInteger	csalidas		=	(BigInteger) row[	14	];
				BigInteger	cortes		=	(BigInteger) row[	15	];
				String	codec		=	(String) row[	16	];
				String	nom_finca		=	(String) row[	17	];
				String	nom_lote		=	(String) row[	18	];
				String	nom_labor		=	(String) row[	19	];
				String	cod_grupo_labor		=	(String) row[	20	];
				String	nom_grupo_labor		=	(String) row[	21	];
				String	nom_variedad		=	(String) row[	22	];
				String	nom_corte		=	(String) row[	23	];
				BigDecimal	area_lote		=	(BigDecimal) row[	24	];
				String	nom_producto		=	(String) row[	25	];
				BigDecimal	anio		=	(BigDecimal) row[	26	];
				BigDecimal	mes		=	(BigDecimal) row[	27	];
				String	mesTexto		=	(String) row[	28	];
				
				BigDecimal	cantidad_ha		=	(BigDecimal) row[	29	];
				Date	fechaSiembra			=	(Date) row[	30	];
				Date	fechaUltCorte		=	(Date) row[	31	];
				Double	edadHoy		=	(Double) row[	32	];
				BigDecimal	diasTranscurridos		=	(BigDecimal) row[	33	]; 
				BigDecimal	areaFinca		=	(BigDecimal) row[	34	]; 
				BigDecimal	costoIndirecto		=	(BigDecimal) row[	35	]; 
				BigDecimal	costoDirecto		=	(BigDecimal) row[	36	]; 
				
				pyGA.setIdDetalle(idregistro);
				pyGA.setNivel4Id(idlote);
				pyGA.setCodFinca(idfinca);
				pyGA.setCodLote(codlote);
				pyGA.setCodLabor(idlabor);
				pyGA.setFechaRegistro(fecha);
				pyGA.setCodProducto(idinsumo);
				pyGA.setCantidadPago(cantidad);
				pyGA.setCostoTotal(valor);
				pyGA.setCodUdadMedPago(undmedida);
				pyGA.setOrigenDatos(tipocosto);
				pyGA.setConsecutivo(numerodoc);
				pyGA.setDetalle(detalle);
				pyGA.setAplicado(aplicado);
				pyGA.setCsalidas(csalidas);
				pyGA.setNumeroCosechas1(cortes);
				pyGA.setCodec(codec);
				pyGA.setNomFinca(nom_finca);
				pyGA.setLoteA(nom_lote);
				pyGA.setNombreLabor(nom_labor);
				pyGA.setCodGrupoLabor(cod_grupo_labor);
				pyGA.setNombreGrupoLabor(nom_grupo_labor);
				pyGA.setVariedad(nom_variedad);
				pyGA.setNomCorte(nom_corte);
				pyGA.setArea(area_lote);
				pyGA.setNombreProducto(nom_producto);
				pyGA.setAnio(anio);
				pyGA.setMes(mes);
				pyGA.setMesTexto(mesTexto);
				
				pyGA.setCantHa(cantidad_ha);
				pyGA.setfSiembra(fechaSiembra);
				pyGA.setfCorte(fechaUltCorte);
				pyGA.setEdadHoy(edadHoy);
				pyGA.setDiasTranscurridosLabor(diasTranscurridos);
				pyGA.setAreaFinca(areaFinca);
				pyGA.setCostoIndirecto(costoIndirecto);
				pyGA.setCostoDirecto(costoDirecto);
				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}
	
	@Override
	public List<CostosTotalesDTO> pr_costo_parcial_resumen(Long compania, Date fechaInicial, Date fechaFinal,			
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, 
			String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costo_parcial_resumen (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :grplabor, :flaggrplabor)");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("grplabor", grpLabor);
		q.setLong("flaggrplabor", flagGrpLabor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
	//	q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				BigInteger	idlote		=	(BigInteger) row[	0	];
				String	idfinca		=	(String) row[	1	];
				String	codlote		=	(String) row[	2	];
				BigDecimal	cantidad		=	(BigDecimal) row[	3	];
				BigDecimal	valor		=	(BigDecimal) row[	4	];
				BigInteger	cortes		=	(BigInteger) row[	5	];
				String	codec		=	(String) row[	6	];
				String	nom_finca		=	(String) row[	7	];
				String	nom_lote		=	(String) row[	8	];
				String	cod_grupo_labor		=	(String) row[	9	];
				String	nom_grupo_labor		=	(String) row[	10	];
				String	nom_variedad		=	(String) row[	11	];
				String	nom_corte		=	(String) row[	12	];
				BigDecimal	area_lote		=	(BigDecimal) row[	13	];
				BigDecimal	anio		=	(BigDecimal) row[	14	];
				BigDecimal	mes		=	(BigDecimal) row[	15	];
				String	mesTexto		=	(String) row[	16	];
				pyGA.setNivel4Id(idlote);
				pyGA.setCodFinca(idfinca);
				pyGA.setCodLote(codlote);
				pyGA.setCantidadPago(cantidad);
				pyGA.setCostoTotal(valor);
					pyGA.setNumeroCosechas1(cortes);
				pyGA.setCodec(codec);
				pyGA.setNomFinca(nom_finca);
				pyGA.setLoteA(nom_lote);
				pyGA.setCodGrupoLabor(cod_grupo_labor);
				pyGA.setNombreGrupoLabor(nom_grupo_labor);
				pyGA.setVariedad(nom_variedad);
				pyGA.setNomCorte(nom_corte);
				pyGA.setArea(area_lote);
					pyGA.setAnio(anio);
				pyGA.setMes(mes);
				pyGA.setMesTexto(mesTexto);

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}
	
	
	@Override
	public List<CostosTotalesDTO> pr_costo_lotes_cerrados(Long compania, Date fechaInicial, Date fechaFinal,			
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, 
			String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costo_lotes_cerrados (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :grplabor, :flaggrplabor)");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("grplabor", grpLabor);
		q.setLong("flaggrplabor", flagGrpLabor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
	//	q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				BigInteger	idregistro		=	(BigInteger) row[	0	];
				BigInteger	idlote		=	(BigInteger) row[	1	];
				String	idfinca		=	(String) row[	2	];
				String	codlote		=	(String) row[	3	];
				String	idlabor		=	(String) row[	4	];
				Date	fecha		=	(Date) row[	5	];
				String	idinsumo		=	(String) row[	6	];
				BigDecimal	cantidad		=	(BigDecimal) row[	7	];
				BigDecimal	valor		=	(BigDecimal) row[	8	];
				String	undmedida		=	(String) row[	9	];
				BigInteger	cortes		=	(BigInteger) row[	10	];
				String	nom_finca		=	(String) row[	11	];
				String	nom_lote		=	(String) row[	12	];
				String	nom_labor		=	(String) row[	13	];
				String	cod_grupo_labor		=	(String) row[	14	];
				String	nom_grupo_labor		=	(String) row[	15	];
				String	nom_variedad		=	(String) row[	16	];
				String	nom_corte		=	(String) row[	17	];
				BigDecimal	area_lote		=	(BigDecimal) row[	18	];
				String	nom_producto		=	(String) row[19	];
				BigDecimal	anio		=	(BigDecimal) row[	20	];
				BigDecimal	mes		=	(BigDecimal) row[	21	];
				String	mesTexto		=	(String) row[	22	];
				BigDecimal	areaCos		=	(BigDecimal) row[	23	];
				
				Date	FSiembra		=	(Date) row[	24	];
				Date	FCorte		=	(Date) row[	25	];
				BigDecimal	Produccion		=	(BigDecimal) row[	26	];
				String	UndMedida		=	(String) row[	27	];
				BigDecimal	RendAzucar		=	(BigDecimal) row[	28	];
				BigDecimal	ValUnitario		=	(BigDecimal) row[	29	];
				BigDecimal	Adicionales		=	(BigDecimal) row[	30	];
				BigDecimal	AjustesLiq		=	(BigDecimal) row[	31	];
				BigDecimal	IVarios = (BigDecimal) row[32];
				BigDecimal Retenciones = (BigDecimal) row[33];
				BigDecimal Descuentos = (BigDecimal) row[34];
				String Notas = (String) row[35];
				BigDecimal Edad = (BigDecimal) row[36];
				BigDecimal Precio = (BigDecimal) row[37];
				BigDecimal KATC = (BigDecimal) row[38];
				String tipoCosto = (String) row[39];
				BigDecimal costo_sobre_vlUnitTonelada = (BigDecimal) row[40];
				BigDecimal costo_ha = (BigDecimal) row[41];
				
				pyGA.setIdDetalle(idregistro);
				pyGA.setNivel4Id(idlote);
				pyGA.setCodFinca(idfinca);
				pyGA.setCodLote(codlote);
				pyGA.setCodLabor(idlabor);
				pyGA.setFechaRegistro(fecha);
				pyGA.setCodProducto(idinsumo);
				pyGA.setCantidadPago(cantidad);
				pyGA.setCostoTotal(valor);
				pyGA.setCodUdadMedPago(undmedida);
				pyGA.setNumeroCosechas1(cortes);
				pyGA.setNomFinca(nom_finca);
				pyGA.setLoteA(nom_lote);
				pyGA.setNombreLabor(nom_labor);
				pyGA.setCodGrupoLabor(cod_grupo_labor);
				pyGA.setNombreGrupoLabor(nom_grupo_labor);
				pyGA.setVariedad(nom_variedad);
				pyGA.setNomCorte(nom_corte);
				pyGA.setArea(area_lote);
				pyGA.setNombreProducto(nom_producto);
				pyGA.setAnio(anio);
				pyGA.setMes(mes);
				pyGA.setMesTexto(mesTexto);
				
				
				pyGA.setAreaCos(areaCos);
				pyGA.setNomFinca(nom_finca);
				pyGA.setLoteA(nom_lote);
				pyGA.setVariedad(nom_variedad);
				pyGA.setNomCorte(nom_corte);
				pyGA.setArea(area_lote);
				pyGA.setfSiembra(FSiembra);
				pyGA.setfCorte(FCorte);
				pyGA.setCantidadCos(Produccion);
				pyGA.setCodUdadMedCos(UndMedida);
				pyGA.setRendAzucar(RendAzucar);
				pyGA.setValUnitario(ValUnitario);
				pyGA.setAdicionales(Adicionales);
				pyGA.setAjustesLiq(AjustesLiq);
				pyGA.setiVarios(IVarios);
				pyGA.setRetenciones(Retenciones);
				pyGA.setDescuentos(Descuentos);
				pyGA.setNotas(Notas);
				pyGA.setEdadUltCorte(Edad);
				pyGA.setIngresos(Precio);
				pyGA.setKatc(KATC);
				pyGA.setTipoCosto(tipoCosto);
				pyGA.setCosto_sobre_vlUnitTonelada(costo_sobre_vlUnitTonelada);
				pyGA.setCostoSobreArea(costo_ha);
				
				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}
	

	@Override
	public List<ProduccionAcumFincaDTO> pr_produccion_lote_cerrado(Long compania, Date fecha_inicial, Date fecha_final,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, Long flagNumeroCosechas) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_produccion_lote_cerrado (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
						+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote,  :flagncosechas)");
		q.setDate("fecha_inicial", fecha_inicial);
		q.setDate("fecha_final", fecha_final);
		q.setLong("compania", compania);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);

		q.setLong("flagncosechas", flagNumeroCosechas);
		// q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<ProduccionAcumFincaDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<ProduccionAcumFincaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProduccionAcumFincaDTO pyGA = new ProduccionAcumFincaDTO();

				BigInteger idregistro = (BigInteger) row[0];
				BigInteger idlote = (BigInteger) row[1];
				String idfinca = (String) row[2];
				String codlote = (String) row[3];
				BigInteger cortes = (BigInteger) row[4];
				BigDecimal areaCosechada = (BigDecimal) row[5];
				String variedad = (String) row[6];
				Date FSiembra = (Date) row[7];
				Date FCorte = (Date) row[8];
				BigDecimal Produccion = (BigDecimal) row[9];
				String UndMedida = (String) row[10];
				BigDecimal RendAzucar = (BigDecimal) row[11];
				BigDecimal ValUnitario = (BigDecimal) row[12];
				BigDecimal Adicionales = (BigDecimal) row[13];
				BigDecimal AjustesLiq = (BigDecimal) row[14];
				BigDecimal IVarios = (BigDecimal) row[15];
				BigDecimal Retenciones = (BigDecimal) row[16];
				BigDecimal Descuentos = (BigDecimal) row[17];
				String Notas = (String) row[18];
				BigDecimal Edad = (BigDecimal) row[19];
				BigDecimal Precio = (BigDecimal) row[20];
				BigDecimal KATC = (BigDecimal) row[21];
				String nom_finca = (String) row[22];
				String nom_lote = (String) row[23];
				String nom_corte = (String) row[24];
				BigDecimal area_lote = (BigDecimal) row[25];

				BigDecimal anio = (BigDecimal) row[26];
				BigDecimal mes = (BigDecimal) row[27];
				String mesTexto = (String) row[28];

				BigDecimal tonHa = (BigDecimal) row[29];
				BigDecimal tonHaMes = (BigDecimal) row[30];
				BigDecimal ingresoHa = (BigDecimal) row[31];

				pyGA.setIdRegistro(idregistro);
				pyGA.setNivel4Id(idlote);
				pyGA.setCodFinca(idfinca);
				pyGA.setCodLote(codlote);
				pyGA.setnCosechas(cortes);

				pyGA.setNomFinca(nom_finca);
				pyGA.setNomLote(codlote);

				pyGA.setNomVariedad(variedad);
				pyGA.setNomCorte(nom_corte);
				pyGA.setArea(area_lote);
				pyGA.setfSiembra(FSiembra);
				pyGA.setfCorte(FCorte);
				pyGA.setCantidadCosechadaTon(Produccion);
				pyGA.setCodUmCos(UndMedida);
				pyGA.setRendAzucar(RendAzucar);
				pyGA.setValUnitario(ValUnitario);
				pyGA.setAdicionales(Adicionales);
				pyGA.setAjustesLiq(AjustesLiq);
				pyGA.setiVarios(IVarios);
				pyGA.setRetenciones(Retenciones);
				pyGA.setDescuentos(Descuentos);
				pyGA.setNotas(Notas);
				pyGA.setEdad(Edad);
				pyGA.setIngresoBruto(Precio);
				pyGA.setKatc(KATC);
				pyGA.setAnio(anio);
				pyGA.setMes(mes);
				pyGA.setMesTexto(mesTexto);
				pyGA.setTonHa(tonHa);
				pyGA.setTchm(tonHaMes);
				pyGA.setIngresosHa(ingresoHa);

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}

	
	
	@Override
	public List<CostosTotalesDTO> pr_costos_produccion_lote_cerrado(Long compania, 	Date fechaInicial, Date fechaFinal,		
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, 
			Long flagNumeroCosechas) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_produccion_lote_cerrado ( :compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote,  :flagncosechas)");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
			q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
	
		q.setLong("flagncosechas", flagNumeroCosechas);
	//	q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				BigInteger	idlote		=	(BigInteger) row[	0	];
				String	idfinca		=	(String) row[	1	];
				String	codlote		=	(String) row[	2	];
				
				BigDecimal	costoDirecto		=	(BigDecimal) row[	3	];
				BigInteger	cortes		=	(BigInteger) row[	4	];
				String	nom_finca		=	(String) row[	5	];
				String	nom_lote		=	(String) row[	6	];
				
				String	nom_variedad		=	(String) row[	7	];
				String	nom_corte		=	(String) row[	8	];
				BigDecimal	area_lote		=	(BigDecimal) row[	9	];
				BigDecimal	areaCos		=	(BigDecimal) row[	10	];
				
				Date	FSiembra		=	(Date) row[	11	];
				Date	FCorte		=	(Date) row[	12	];
				BigDecimal	Produccion		=	(BigDecimal) row[	13	];
				String	UndMedida		=	(String) row[	14	];
				BigDecimal	RendAzucar		=	(BigDecimal) row[	15	];
				BigDecimal	ValUnitario		=	(BigDecimal) row[	16	];
				BigDecimal	Adicionales		=	(BigDecimal) row[	17	];
				BigDecimal	AjustesLiq		=	(BigDecimal) row[	18	];
				BigDecimal	IVarios = (BigDecimal) row[19];
				BigDecimal Retenciones = (BigDecimal) row[20];
				BigDecimal Descuentos = (BigDecimal) row[21];
				String Notas = (String) row[22];
				BigDecimal Edad = (BigDecimal) row[23];
				BigDecimal Precio = (BigDecimal) row[24];
				BigDecimal KATC = (BigDecimal) row[25];

				BigDecimal costoIndirecto = (BigDecimal) row[26];
				BigDecimal valor = (BigDecimal) row[27];
				BigDecimal utilidad = (BigDecimal) row[28];
				BigDecimal ton_ha = (BigDecimal) row[29];
				BigDecimal ton_ha_edad = (BigDecimal) row[30];
				BigDecimal ingresos_ha = (BigDecimal) row[31];
				BigDecimal costo_ha = (BigDecimal) row[32];
				BigDecimal utilidad_ha = (BigDecimal) row[33];

				pyGA.setNivel4Id(idlote);
				pyGA.setCodFinca(idfinca);
				pyGA.setCodLote(codlote);

				pyGA.setCostoTotal(valor);
				pyGA.setNumeroCosechas1(cortes);
				pyGA.setAreaCos(areaCos);
				pyGA.setNomFinca(nom_finca);
				pyGA.setLoteA(nom_lote);

				pyGA.setVariedad(nom_variedad);
				pyGA.setNomCorte(nom_corte);
				pyGA.setArea(area_lote);
				pyGA.setfSiembra(FSiembra);
				pyGA.setfCorte(FCorte);
				pyGA.setCantidadCos(Produccion);
				pyGA.setCodUdadMedCos(UndMedida);
				pyGA.setRendAzucar(RendAzucar);
				pyGA.setValUnitario(ValUnitario);
				pyGA.setAdicionales(Adicionales);
				pyGA.setAjustesLiq(AjustesLiq);
				pyGA.setiVarios(IVarios);
				pyGA.setRetenciones(Retenciones);
				pyGA.setDescuentos(Descuentos);
				pyGA.setNotas(Notas);
				pyGA.setEdadUltCorte(Edad);
				pyGA.setIngresos(Precio);
				pyGA.setKatc(KATC);

				pyGA.setCostoIndirecto(costoIndirecto);
				pyGA.setCostoDirecto(costoDirecto);
				pyGA.setUtilidad(utilidad);
				pyGA.setTonHa(ton_ha);
				pyGA.setTonHaEdad(ton_ha_edad);
				pyGA.setIngresosHa(ingresos_ha);
				pyGA.setCostoSobreArea(costo_ha);
				pyGA.setUtilidadHa(utilidad_ha);

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}


	@Override
	public List<CostosTotalesDTO> pr_costos_produccion_lote_cerrado_corte(Long compania, 	Date fechaInicial, Date fechaFinal,		
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, 
			Long flagNumeroCosechas) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_produccion_lote_cerrado_corte ( :compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote,  :flagncosechas)");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
			q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
	
		q.setLong("flagncosechas", flagNumeroCosechas);
	//	q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				BigInteger	idlote		=	(BigInteger) row[	0	];
				String	idfinca		=	(String) row[	1	];
				String	codlote		=	(String) row[	2	];
				
				BigDecimal	costoDirecto		=	(BigDecimal) row[	3	];
				BigInteger	cortes		=	(BigInteger) row[	4	];
				String	nom_finca		=	(String) row[	5	];
				String	nom_lote		=	(String) row[	6	];
				
				String	nom_variedad		=	(String) row[	7	];
				String	nom_corte		=	(String) row[	8	];
				BigDecimal	area_lote		=	(BigDecimal) row[	9	];
				BigDecimal	areaCos		=	(BigDecimal) row[	10	];
				
				Date	FSiembra		=	(Date) row[	11	];
				Date	FCorte		=	(Date) row[	12	];
				BigDecimal	Produccion		=	(BigDecimal) row[	13	];
				String	UndMedida		=	(String) row[	14	];
				BigDecimal	RendAzucar		=	(BigDecimal) row[	15	];
				BigDecimal	ValUnitario		=	(BigDecimal) row[	16	];
				BigDecimal	Adicionales		=	(BigDecimal) row[	17	];
				BigDecimal	AjustesLiq		=	(BigDecimal) row[	18	];
				BigDecimal	IVarios = (BigDecimal) row[19];
				BigDecimal Retenciones = (BigDecimal) row[20];
				BigDecimal Descuentos = (BigDecimal) row[21];
				String Notas = (String) row[22];
				BigDecimal Edad = (BigDecimal) row[23];
				BigDecimal Precio = (BigDecimal) row[24];
				BigDecimal KATC = (BigDecimal) row[25];

				BigDecimal costoIndirecto = (BigDecimal) row[26];
				BigDecimal valor = (BigDecimal) row[27];
				BigDecimal utilidad = (BigDecimal) row[28];
				BigDecimal ton_ha = (BigDecimal) row[29];
				BigDecimal ton_ha_edad = (BigDecimal) row[30];
				BigDecimal ingresos_ha = (BigDecimal) row[31];
				BigDecimal costo_ha = (BigDecimal) row[32];
				BigDecimal utilidad_ha = (BigDecimal) row[33];

				pyGA.setNivel4Id(idlote);
				pyGA.setCodFinca(idfinca);
				pyGA.setCodLote(codlote);

				pyGA.setCostoTotal(valor);
				pyGA.setNumeroCosechas1(cortes);
				pyGA.setAreaCos(areaCos);
				pyGA.setNomFinca(nom_finca);
				pyGA.setLoteA(nom_lote);

				pyGA.setVariedad(nom_variedad);
				pyGA.setNomCorte(nom_corte);
				pyGA.setArea(area_lote);
				pyGA.setfSiembra(FSiembra);
				pyGA.setfCorte(FCorte);
				pyGA.setCantidadCos(Produccion);
				pyGA.setCodUdadMedCos(UndMedida);
				pyGA.setRendAzucar(RendAzucar);
				pyGA.setValUnitario(ValUnitario);
				pyGA.setAdicionales(Adicionales);
				pyGA.setAjustesLiq(AjustesLiq);
				pyGA.setiVarios(IVarios);
				pyGA.setRetenciones(Retenciones);
				pyGA.setDescuentos(Descuentos);
				pyGA.setNotas(Notas);
				pyGA.setEdadUltCorte(Edad);
				pyGA.setIngresos(Precio);
				pyGA.setKatc(KATC);

				pyGA.setCostoIndirecto(costoIndirecto);
				pyGA.setCostoDirecto(costoDirecto);
				pyGA.setUtilidad(utilidad);
				pyGA.setTonHa(ton_ha);
				pyGA.setTonHaEdad(ton_ha_edad);
				pyGA.setIngresosHa(ingresos_ha);
				pyGA.setCostoSobreArea(costo_ha);
				pyGA.setUtilidadHa(utilidad_ha);

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}

	

	@Override
	public List<CostosTotalesDTO> pr_costo_parcial_resumen_labor(Long compania, Date fechaInicial, Date fechaFinal,			
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, 
			String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costo_parcial_resumen_labor (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :grplabor, :flaggrplabor)");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("grplabor", grpLabor);
		q.setLong("flaggrplabor", flagGrpLabor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
	//	q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				BigInteger	idlote		=	(BigInteger) row[	0	];
				String	idfinca		=	(String) row[	1	];
				String	codlote		=	(String) row[	2	];
				BigDecimal	cantidad		=	(BigDecimal) row[	3	];
				BigDecimal	valor		=	(BigDecimal) row[	4	];
				BigInteger	cortes		=	(BigInteger) row[	5	];
				String	nom_finca		=	(String) row[	6	];
				String	nom_lote		=	(String) row[	7	];
				String	cod_grupo_labor		=	(String) row[	8	];
				String	nom_grupo_labor		=	(String) row[	9	];
				String	nom_variedad		=	(String) row[	10	];
				String	nom_corte		=	(String) row[	11	];
				BigDecimal	area_lote		=	(BigDecimal) row[	12	];
				BigDecimal	anio		=	(BigDecimal) row[	13	];
				BigDecimal	mes		=	(BigDecimal) row[	14	];
				String	mesTexto		=	(String) row[	15	];
				
				String	idlabor		=	(String) row[	16	];
				String	nom_labor		=	(String) row[	17	];
				String	undmedida		=	(String) row[	18	];
				BigDecimal	costo_ha		=	(BigDecimal) row[	19	];
				BigDecimal	sumatoriaCostoLote		=	(BigDecimal) row[	20	];
				BigDecimal	porcentajeCosto		=	(BigDecimal) row[	21	];
				Date	fechaSiembra			=	(Date) row[	22	];
				Date	fechaUltCorte		=	(Date) row[	23	];
				Double	edadHoy		=	(Double) row[	24	];
				
				pyGA.setNivel4Id(idlote);
				pyGA.setCodFinca(idfinca);
				pyGA.setCodLote(codlote);
				pyGA.setCantidadPago(cantidad);
				pyGA.setCostoTotal(valor);
					pyGA.setNumeroCosechas1(cortes);
				
				pyGA.setNomFinca(nom_finca);
				pyGA.setLoteA(nom_lote);
				pyGA.setCodGrupoLabor(cod_grupo_labor);
				pyGA.setNombreGrupoLabor(nom_grupo_labor);
				pyGA.setVariedad(nom_variedad);
				pyGA.setNomCorte(nom_corte);
				pyGA.setArea(area_lote);
					pyGA.setAnio(anio);
				pyGA.setMes(mes);
				pyGA.setMesTexto(mesTexto);

				pyGA.setCostoSobreArea(costo_ha);
				pyGA.setSumatoriaCostoTotalLote(sumatoriaCostoLote);
				pyGA.setPorcentajeCosto(porcentajeCosto);
				pyGA.setCodLabor(idlabor);
				pyGA.setCodUdadMedPago(undmedida);
				pyGA.setNombreLabor(nom_labor);
				pyGA.setfSiembra(fechaSiembra);
				pyGA.setfCorte(fechaUltCorte);
				pyGA.setEdadHoy(edadHoy);
				

				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}
	
	@Override
	public List<CostosTotalesDTO> pr_costo_parcial_resumen_lote(Long compania, Date fechaInicial, Date fechaFinal,			
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, 
			String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor, Long diaslabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costo_parcial_resumen_lote (:compania, :fecha_inicial, :fecha_final, :zona, :flagzona, :finca,"
				+ " :flagfinca, :bloque, :flagbloque, :lote, :flaglote, :labor, :flaglabor, :flagncosechas, :grplabor, :flaggrplabor, :diaslabor)");
		
		q.setLong("compania", compania);
		q.setDate("fecha_inicial", fechaInicial);
		q.setDate("fecha_final", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("grplabor", grpLabor);
		q.setLong("flaggrplabor", flagGrpLabor);
		q.setLong("flagzona", flagZona);
		q.setLong("flagfinca", flagFinca);
		q.setLong("flagbloque", flagBloque);
		q.setLong("flaglote", flagLote);
		q.setLong("flaglabor", flagLabor);
		q.setLong("flagncosechas", flagNumeroCosechas);
		q.setLong("diaslabor", diaslabor);
	//	q.setString("origendatos", origenDatos1);

		List l = q.list();
		List<CostosTotalesDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<CostosTotalesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosTotalesDTO pyGA = new CostosTotalesDTO();
				BigInteger	idlote		=	(BigInteger) row[	0	];
				String	idfinca		=	(String) row[	1	];
				String	codlote		=	(String) row[	2	];
				BigDecimal	valor		=	(BigDecimal) row[	3	];
				BigInteger	cortes		=	(BigInteger) row[	4	];
				String	nom_finca		=	(String) row[	5	];
				String	nom_lote		=	(String) row[	6	];
				String	nom_variedad		=	(String) row[	7	];
				String	nom_corte		=	(String) row[	8	];
				BigDecimal	area_lote		=	(BigDecimal) row[	9	];
				Double	edadHoyMeses		=	(Double) row[	10	];
				Double	edadHoyDias		=	(Double) row[	11	]; 
				BigDecimal	areaFinca		=	(BigDecimal) row[	12	]; 
				BigDecimal	toneladasUltCosecha		=	(BigDecimal) row[	13	];
				BigDecimal	tonHaUltCosecha		=	(BigDecimal) row[	14	];
				BigDecimal	valorTonelada		=	(BigDecimal) row[	15	];
				String	rangoEdadDias		=	(String) row[	16	];
				Date	fechaSiembra			=	(Date) row[	17	];
				Date	fechaUltCorte		=	(Date) row[	18	];
				
			
				pyGA.setNivel4Id(idlote);
				pyGA.setCodFinca(idfinca);
				pyGA.setCodLote(codlote);
				pyGA.setCostoTotal(valor);
				pyGA.setNumeroCosechas1(cortes);
				pyGA.setNomFinca(nom_finca);
				pyGA.setLoteA(nom_lote);
				pyGA.setVariedad(nom_variedad);
				pyGA.setNomCorte(nom_corte);
				pyGA.setArea(area_lote);
				
				pyGA.setCantidadCos(toneladasUltCosecha);
				pyGA.setTonHa(tonHaUltCosecha);
				pyGA.setValUnitario(valorTonelada);
				pyGA.setfSiembra(fechaSiembra);
				pyGA.setfCorte(fechaUltCorte);
				pyGA.setEdadHoy(edadHoyMeses);
				pyGA.setEdadHoyDias(edadHoyDias);
			
				
				pyGA.setAreaFinca(areaFinca);
				
				pyGA.setRangoEdadDias(rangoEdadDias);
		
				pyG.add(pyGA);

			}
		}
		session.close();

		return pyG;
	}
	
	
	@Override
	public List<ConsolidadoNominaDTO> pr_mo_desprendible_pago(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_mo_desprendible_pago (:compania, :fechaInicial,  :fechaFinal, "
						+ ":trabajador, :flagTrabajador )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("trabajador", trabajador);
		q.setLong("flagTrabajador", flagTrabajador);
		

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsolidadoNominaDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<ConsolidadoNominaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsolidadoNominaDTO nominaA = new ConsolidadoNominaDTO();
				BigInteger id = (BigInteger) row[0];
				Date fechaInicialC = (Date) row[1];
				Date fechaFinalC = (Date) row[2];
				
				String codTrabajador = (String) row[4];
				String nomTrabajador = (String) row[5];
				String nomProfesion = (String) row[6];
				String codConcepto = (String) row[7];
				String nomConcepto = (String) row[8];
				String tipoMovimiento = (String) row[9];
				BigDecimal devengo = (BigDecimal) row[10];
				BigDecimal deduccion = (BigDecimal) row[11];
				String observacion = (String) row[12];
				String nomCompania = (String) row[13];
				String rut = (String) row[14];
				String telefono = (String) row[15];
				String direccion = (String) row[16];
				BigDecimal anio = (BigDecimal) row[17];
				BigDecimal mes = (BigDecimal) row[18];
				
				nominaA.setId(id);
				nominaA.setFechaInicial(fechaInicialC);
				nominaA.setFechaFinal(fechaFinalC);
				nominaA.setCodTrabajador(codTrabajador);
				nominaA.setNomTrabajador(nomTrabajador);
				nominaA.setCodConcepto(codConcepto);
				nominaA.setNomConcepto(nomConcepto);
				nominaA.setNomProfesion(nomProfesion);
				nominaA.setTipoMovimiento(tipoMovimiento);
				nominaA.setDevengo(devengo);
				nominaA.setDeduccion(deduccion);
				nominaA.setObservacion(observacion);
				
				nominaA.setNombreCompania(nomCompania);
				nominaA.setRut(rut);
				nominaA.setTelefonoCompania(telefono);
				nominaA.setDireccionCompania(direccion);
				nominaA.setAnio(anio);
				nominaA.setMes(mes);

				nomina.add(nominaA);
			}
		}
		session.close();

		return nomina;

	}
	
	public List<CuadroPrecipitacionDiariaDTO> pr_comportamiento_lluvias(Long compania,
			Date fechaInicial, Date fechaFinal, String estPluvio,
			Long flagEstPluvio) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_comportamiento_lluvias (:compania,  :fechaInicial, :fechaFinal,"
				+ " :estPluvio, :flagEstPluvio )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
	
		q.setString("estPluvio", estPluvio);
		q.setLong("flagEstPluvio", flagEstPluvio);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<CuadroPrecipitacionDiariaDTO> pluviometria = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pluviometria = new ArrayList<CuadroPrecipitacionDiariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CuadroPrecipitacionDiariaDTO pluviometriaA = new CuadroPrecipitacionDiariaDTO();

				String codPluvio = (String) row[0];

				String nomPluvio = (String) row[1];
				BigDecimal precipitacion = (BigDecimal) row[2];
				Date fecha = (Date) row[3];
				BigDecimal anio = (BigDecimal) row[4];
				BigDecimal mes = (BigDecimal) row[5];
				String mesCorto = (String) row[6];
				
				
				pluviometriaA.setCodPluvio(codPluvio);
				pluviometriaA.setNomPluvio(nomPluvio);
				pluviometriaA.setPrecipitacion(precipitacion);
				pluviometriaA.setFecha(fecha);
				pluviometriaA.setAnio(anio);
				pluviometriaA.setMes(mes);
				pluviometriaA.setMesCorto(mesCorto);
				
				pluviometria.add(pluviometriaA);

			}
		}
		session.close();

		return pluviometria;

	}
	
	
	@Override
	public List<ListaNivel4DTO> pr_lista_etapas_lotes_cosechados(Long compania, Long idnivel4) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_lista_etapas_lotes_cosechados (:compania, :idnivel4)");
		q.setLong("compania", compania);
		q.setLong("idnivel4", idnivel4);

		List l = q.list();
		ArrayList<ListaNivel4DTO> reporte = new ArrayList<ListaNivel4DTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaNivel4DTO reportes = new ListaNivel4DTO();
				BigInteger nivel1_id = (BigInteger) row[0];
				BigInteger nivel2_id = (BigInteger) row[1];
				String cod_nivel2 = (String) row[2];
				String nom_nivel2 = (String) row[3];
				BigInteger nivel3_id = (BigInteger) row[4];
				BigInteger nivel4_id = (BigInteger) row[5];
				String cod_nivel4 = (String) row[6];
				String nom_nivel4 = (String) row[7];
				String lote = (String) row[8];
				BigDecimal area_neta = (BigDecimal) row[9];
				BigDecimal num_plantas_sembradas = (BigDecimal) row[10];
				
				String codEtapa = (String) row[12];
				String nomEtapa = (String) row[13];
				BigDecimal numeroCosechas = (BigDecimal) row[14];
				BigInteger etapaId = (BigInteger) row[15];
				
				reportes.setNivel1_id(nivel1_id);
				reportes.setNivel2_id(nivel2_id);
				reportes.setCod_nivel2(cod_nivel2);
				reportes.setNom_nivel2(nom_nivel2);
				reportes.setNivel3_id(nivel3_id);
				reportes.setNivel4_id(nivel4_id);
				reportes.setCod_nivel4(cod_nivel4);
				reportes.setNom_nivel4(nom_nivel4);
				reportes.setLote(lote);
				reportes.setArea_neta(area_neta);
				reportes.setNum_plantas_sembradas(num_plantas_sembradas);
				reportes.setCodEtapa(codEtapa);
				reportes.setNomEtapa(nomEtapa);
				reportes.setNumeroCosechas(numeroCosechas);
				reportes.setEtapaId(etapaId);
					
				reporte.add(reportes);

				// consultaOtDes.add(consultaOt);

			}

		}
		session.close();

		return reporte;

	}
	@Override
	public Long pr_asociar_reg_produccion_costos(Long idLote , Long idEtapa , Long reg_produccion_id ,Long idCiclo ) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_asociar_reg_produccion_costos (:idLote, :idEtapa, :reg_produccion_id, :idCiclo)");
		q.setLong("idLote", idLote);
		q.setLong("idEtapa", idEtapa);
		q.setLong("reg_produccion_id", reg_produccion_id);
		q.setLong("idCiclo", idCiclo);
		
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	
	@Override
	public Long pr_reabrir_cosecha_costos(Long idLote , Long idEtapa , Long reg_produccion_id ,Long idCiclo ) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_asociar_reg_produccion_costos (:idLote, :idEtapa, :reg_produccion_id, :idCiclo)");
		q.setLong("idLote", idLote);
		q.setLong("idEtapa", idEtapa);
		q.setLong("reg_produccion_id", reg_produccion_id);
		q.setLong("idCiclo", idCiclo);
		
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	
	@Override
	public Double pr_ultimo_valor_compra_producto(Long idProducto) throws Exception {
		Double precioPromProducto = 0.0;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery("call pr_ultimo_valor_compra_producto ( :idProducto )");

		q.setLong("idProducto", idProducto);
		

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal precioPromProducto2 = (BigDecimal) it.next();
				precioPromProducto = precioPromProducto2.doubleValue();
			}
		}
		return precioPromProducto;

	}
	
	@Override
	public Long pr_recalculo_vr_hora_maquina(Long companiaid ,Date fechaInicial, Date fechaFinal ) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_recalculo_vr_hora_maquina (:companiaid, :fechaInicial, :fechaFinal)");
		q.setLong("companiaid", companiaid);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	
	
	@Override
	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina_maq_destajo(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador, String tipoNomina) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_comprobante_pago_nomina_maq_destajo (:compania, :fechaInicial,  :fechaFinal,   :operador,  :flagOperador, :tipoNomina)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setLong("flagOperador", flagOperador);
		q.setString("tipoNomina", tipoNomina);

		List l = q.list();
		List<ConsultaComprobantePagoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaComprobantePagoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaComprobantePagoDTO reporteA = new ConsultaComprobantePagoDTO();

				BigInteger	companiaid	=	(BigInteger) row[	0	];
				BigDecimal	anio_registro	=	(BigDecimal) row[	1	];
				BigDecimal	mes	=	(BigDecimal) row[	2	];
				String	anio_mes	=	(String) row[	3	];
				Date	fecha_registro	=	(Date) row[	4	];
				String	cod_equipo	=	(String) row[	5	];
				String	nom_equipo	=	(String) row[	6	];
				BigDecimal	cantidad_pago	=	(BigDecimal) row[	7	];
				BigDecimal	horas_horometro	=	(BigDecimal) row[	8	];
				String	turno	=	(String) row[	9	];
				String	cod_operario	=	(String) row[	10	];
				String	nom_operario	=	(String) row[	11	];
				String	tipo_movimiento	=	(String) row[	12	];
				String	cod_concepto_nomina	=	(String) row[	13	];
				String	nom_concepto_nomina	=	(String) row[	14	];
				BigInteger	trab_id	=	(BigInteger) row[	15	];
				BigDecimal	valor_unitario_trabajador	=	(BigDecimal) row[	16	];
				BigDecimal	devengo	=	(BigDecimal) row[	17	];
				BigDecimal	deduccion	=	(BigDecimal) row[	18	];
				String	cod_labor	=	(String) row[	19	];
				String	nom_labor	=	(String) row[	20	];
				String	cod_hacienda	=	(String) row[	21	];
				String	nom_hacienda	=	(String) row[	22	];
				String	cod_lote	=	(String) row[	23	];
				String	nom_profesion	=	(String) row[	24	];
				String	nom_udad_med	=	(String) row[	25	];
				BigInteger	consecutivo	=	(BigInteger) row[	26	];
				BigInteger	consecutivoRdl	=	(BigInteger) row[	27	];
				String	nom_cent_costo	=	(String) row[	28	];
				reporteA.setConsecutivo(consecutivo);
				reporteA.setConsecutivoRdl(consecutivoRdl);
				
				reporteA.setCompania(companiaid);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setAnio_mes(anio_mes);
				reporteA.setFecha_registro(fecha_registro);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCantidad_pago(cantidad_pago);
				reporteA.setHoras_horometro(horas_horometro);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setTipoMovimiento(tipo_movimiento);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setTrab_id(trab_id);
				reporteA.setValor_unitario_trabajador(valor_unitario_trabajador);
				reporteA.setDevengo(devengo);
				reporteA.setDescuentos(deduccion);
				reporteA.setCod_labor(cod_labor);
				reporteA.setNom_labor(nom_labor);
				reporteA.setCod_hacienda(cod_hacienda);
				reporteA.setNom_hacienda(nom_hacienda);
				reporteA.setCod_lote(cod_lote);
				reporteA.setNom_profesion(nom_profesion);
				reporteA.setUnidadMedida(nom_udad_med);
				reporteA.setNomCentroCosto(nom_cent_costo);
				reporte.add(reporteA);

			}
		}

		session.close();

		return reporte;
	}
	
	
	public Long pr_borrar_dat_servicio_equipo(Long idServicio) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_servicio_equipo (:idServicio)");
		// q.setString("datservrealizadosequipodetid", datservrealizadosequipodetid);
		q.setLong("idServicio", idServicio);

		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		return 1L;

	}
	
	public Long pr_borrar_dat_servicio_equipo_det(Long idServicio) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_servicio_equipo_det (:idServicio)");
		// q.setString("datservrealizadosequipodetid", datservrealizadosequipodetid);
		q.setLong("idServicio", idServicio);

		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		return 1L;

	}
	
	public Long pr_borrar_serv_producto(Long idServicio) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_serv_producto (:idServicio)");
		// q.setString("datservrealizadosequipodetid", datservrealizadosequipodetid);
		q.setLong("idServicio", idServicio);

		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		return 1L;

	}
	
	
	@Override
	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl	(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, Long categoria) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consumo_combustible_rdl (:compania, :fechaInicial,  :fechaFinal, "
				+ ":equipo, :flagEquipo, :categoria )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);	
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("categoria", categoria);

		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

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
				
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[25];
				String consecutivoRdlTexto = (String) row[26];
				BigDecimal horometroAbastecimiento = (BigDecimal) row[27];
				BigDecimal horometroAbastecimientoAnterior = (BigDecimal) row[28];
				BigDecimal horas = (BigDecimal) row[29];
				BigDecimal gl_hora = (BigDecimal) row[30];
				BigDecimal gl_hora_estandar = (BigDecimal) row[31];
				
				String codLabor = (String) row[32];
				String nomLabor = (String) row[33];
				String nomHacienda= (String) row[34];
				String nomOperario = (String) row[36];
				String id_detalle_rdl = (String) row [37];
				
				String notas = (String) row [38];
				
				reporteA.setInfoAdicional(notas);
				reporteA.setNomHacienda(nomHacienda);
				reporteA.setNomOperarioMaquina(nomOperario);
				
				reporteA.setCodLabor(codLabor);
				reporteA.setNomLabor(nomLabor);
				
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setConsecutivoRdlTexto(consecutivoRdlTexto);
				reporteA.setHorometroAbastecimiento(horometroAbastecimiento);
				reporteA.setHorometroAbastecimientoAnterior(horometroAbastecimientoAnterior);
				reporteA.setHoras(horas);
				reporteA.setGlHorasEstandar(gl_hora_estandar);
				reporteA.setGlHoras(gl_hora);
				
				
				String nombrePeso1 = "#17b55e";
				reporteA.setColor(nombrePeso1);
				if (gl_hora_estandar.doubleValue() >0 &&  gl_hora.doubleValue()  > gl_hora_estandar.doubleValue()  ) {
					nombrePeso1 = "#F85B5B";
					reporteA.setColor(nombrePeso1);
				} else {
					nombrePeso1 = "#17b55e";
					reporteA.setColor(nombrePeso1);
				}
				
				
				
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
				reporteA.setId_detalle_rdl(id_detalle_rdl);
				reporte.add(reporteA);
			}
		}
		session.close();

		return reporte;

	}
	
	@Override
	public long pr_ultima_planilla_servicios_maq(Long compania, Date fecha, Long maquina, Long operarioId) {
		long maxId = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_ultima_planilla_servicios_maq (:compania,:fecha, :maquina, :operarioId)");
		q.setLong("compania", compania);
		q.setDate("fecha", fecha);
		q.setLong("maquina", maquina);
		q.setLong("operarioId", operarioId);
		
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal id = (BigDecimal) it.next();
				maxId = id.longValue() ;

			}
		}
		return maxId;
	}



	@Override
	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_importacion_movil(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String producto, Long flagProducto, String almacen,
			Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex, Long factura, Long usuario,
			String equipo, Long flagEquipo, String tipomovimiento
			) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_inventario_detalle_importacion_movil (:compania, :fechaInicial,  :fechaFinal, "
				+ ":contratista, :flagContratista, :producto, :flagProducto, :almacen, "
				+ ":flagAlmacen, :conceptokardex, :flagConceptokardex, :conseckardex, :factura , :usuario, :equipo, :flagEquipo, :tipomovimiento)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setString("producto", producto);
		q.setString("almacen", almacen);
		q.setString("conceptokardex", conceptokardex);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setLong("flagConceptokardex", flagConceptokardex);
		q.setLong("conseckardex", conseckardex);
		q.setLong("factura", factura);
		q.setLong("usuario", usuario);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("tipomovimiento", tipomovimiento);
		
		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

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
				BigInteger consecutivoOt = (BigInteger) row[45];
				
				String nombreCentroCosto = (String) row[46];
				reporteA.setNombreCentroCosto(nombreCentroCosto);
				
				reporteA.setConsecutivoOt(consecutivoOt);
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
			
		}
		session.close();
		return reporte;

	}
	
	public String pr_importar_salidas_movil_enproceso(String  precioprodid, String tipomovimiento  ) {
		
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_importar_salidas_movil_enproceso (:precioprodid, :tipomovimiento)");
		q.setString("precioprodid", precioprodid);
		q.setString("tipomovimiento", tipomovimiento);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return "";

	}
	
	@Override
	public long pr_ultima_programa_labores_maq(Long compania, Date fecha, Long cliente, Long supervisorId) {
		long maxId = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_ultima_programa_labores_maq (:compania,:fecha, :cliente, :supervisorId)");
		q.setLong("compania", compania);
		q.setDate("fecha", fecha);
		q.setLong("cliente", cliente);
		q.setLong("supervisorId", supervisorId);
		
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal id = (BigDecimal) it.next();
				maxId = id.longValue() ;

			}
		}
		return maxId;
	}

	@Override
	public List<SolicitudesMttoEquipoDTO> pr_formato_impresion_ot(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto, Long idMtto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_formato_impresion_ot (:compania, :fechaInicial,  :fechaFinal, :propietario, "
						+ ":flagPropietario," + " :equipo, :flagEquipo, :tipoMtto, :flagTipoMtto, :id_mtto)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("propietario", propietario);
		q.setString("equipo", equipo);
		q.setString("tipoMtto", tipoMtto);
		q.setLong("flagPropietario", flagPropietario);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("flagTipoMtto", flagTipoMtto);
		q.setLong("id_mtto", idMtto);

		List l = q.list();
		List<SolicitudesMttoEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<SolicitudesMttoEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				SolicitudesMttoEquipoDTO reporteA = new SolicitudesMttoEquipoDTO();

				Date fecha_entrada_taller = (Date) row[0];
				Date fecha_salida_taller = (Date) row[1];
				BigInteger consecutivo = (BigInteger) row[2];
				String cod_equipo = (String) row[3];
				String nom_equipo = (String) row[4];
				String centro_costo = (String) row[5];
				String taller = (String) row[6];
				BigDecimal horometro_entrada = (BigDecimal) row[7];
				BigDecimal odomentro_entrada = (BigDecimal) row[8];
				String tipo_mantenimiento = (String) row[9];
				String cod_plan_revision = (String) row[10];
				String plan_revision = (String) row[11];
				String motivo_entrda_taller = (String) row[12];
				String agente_causador = (String) row[13];
				String duracion_prevista_mtto_hh = (String) row[14];
				BigDecimal duracion_real_hh = (BigDecimal) row[15];
				String cod_solicitante = (String) row[16];
				String solicitante = (String) row[17];
				String cod_conductor = (String) row[18];
				String conductor = (String) row[19];
				String reporte_tecnico = (String) row[20];
				String mecanicos = (String) row[21];
				String almacen_salida = (String) row[22];
				String autoriza = (String) row[23];
				String producto = (String) row[24];
				String um_producto = (String) row[25];
				BigDecimal cantidad = (BigDecimal) row[26];
				BigDecimal valor_unitario = (BigDecimal) row[27];
				BigDecimal costo_total = (BigDecimal) row[28];
				BigInteger dat_mantenimiento_equipo_id = (BigInteger) row[29];
				String codTag = (String) row[30];
				String nombreTag = (String) row[31];
				BigDecimal anio = (BigDecimal) row[32];
				String mesCorto = (String) row[33];
				String descripcionSolicitud = (String) row[34];
				String codSistema = (String) row[35];
				String nomSistema = (String) row[36];
				String codComportamiento = (String) row[37];
				String nomComprotamiento = (String) row[38];
				String nomProfesion = (String) row[39];
				String codProfesion = (String) row[40];
				String laborPlan = (String) row[41];

				reporteA.setFecha_entrada_taller(fecha_entrada_taller);
				reporteA.setFecha_salida_taller(fecha_salida_taller);
				reporteA.setConsecutivo(consecutivo.longValue());
				reporteA.setCod_equipo(cod_equipo);
				reporteA.setNom_equipo(nom_equipo);
				reporteA.setCentro_costo(centro_costo);
				reporteA.setTaller(taller);
				reporteA.setHorometro_entrada(horometro_entrada);
				reporteA.setOdomentro_entrada(odomentro_entrada);
				reporteA.setTipo_mantenimiento(tipo_mantenimiento);
				reporteA.setPlan_revision(plan_revision);
				reporteA.setMotivo_entrda_taller(motivo_entrda_taller);
				reporteA.setAgente_causador(agente_causador);
				reporteA.setDuracion_prevista_mtto_hh(duracion_prevista_mtto_hh);
				reporteA.setDuracion_real_hh(duracion_real_hh);
				reporteA.setCod_solicitante(cod_solicitante);
				reporteA.setSolicitante(solicitante);
				reporteA.setCod_conductor(cod_conductor);
				reporteA.setConductor(conductor);
				reporteA.setReporte_tecnico(reporte_tecnico);
				reporteA.setMecanicos(mecanicos);
				reporteA.setAlmacen_salida(almacen_salida);
				reporteA.setAutoriza(autoriza);
				reporteA.setProducto(producto);
				reporteA.setUm_producto(um_producto);
				reporteA.setCantidad(cantidad);
				reporteA.setValor_unitario(valor_unitario);
				reporteA.setCosto_total(costo_total);
				reporteA.setDat_mantenimiento_equipo_id(dat_mantenimiento_equipo_id);
				reporteA.setCodTag(codTag);
				reporteA.setNombreTag(nombreTag);
				reporteA.setAnio(anio);
				reporteA.setMesCorto(mesCorto);
				reporteA.setDescripcionSolicitud(descripcionSolicitud);
				reporteA.setCodSistema(codSistema);
				reporteA.setNomSistema(nomSistema);
				reporteA.setCodComportamiento(codComportamiento);
				reporteA.setNomComprotamiento(nomComprotamiento);
				reporteA.setNomProfesion(nomProfesion);
				reporteA.setCodProfesion(codProfesion);
				reporteA.setLaborPlan(laborPlan);

				reporte.add(reporteA);

			}

		}
		session.close();
		return reporte;
	}	



	
	
	@Override
	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_maq	(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consumo_combustible_rdl_resumen_maq (:compania, :fechaInicial,  :fechaFinal, "
				+ ":equipo, :flagEquipo )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
	
		
		q.setLong("flagEquipo", flagEquipo);
		

		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

				
				BigDecimal valor_unitario = (BigDecimal) row[0];
				BigDecimal cantidad_compra = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				
				BigDecimal costoTotal = (BigDecimal) row[4];
				
				BigDecimal horas = (BigDecimal) row[5];
				BigDecimal gl_hora = (BigDecimal) row[6];
				BigDecimal gl_hora_estandar = (BigDecimal) row[7];
				
				
				
				
				reporteA.setHoras(horas);
				reporteA.setGlHorasEstandar(gl_hora_estandar);
				reporteA.setGlHoras(gl_hora);
				
				
				String nombrePeso1 = "#17b55e";
				reporteA.setColor(nombrePeso1);
				if (gl_hora_estandar.doubleValue() >0 &&  gl_hora.doubleValue()  > gl_hora_estandar.doubleValue()  ) {
					nombrePeso1 = "#F85B5B";
					reporteA.setColor(nombrePeso1);
				} else {
					nombrePeso1 = "#17b55e";
					reporteA.setColor(nombrePeso1);
				}
				
				
				
				reporteA.setValor_unitario(valor_unitario);
				reporteA.setCantidad_compra(cantidad_compra);
				reporteA.setCod_equipo(cod_equipo);
				reporteA.setNom_equipo(nom_equipo);
				reporteA.setCostoTotal(costoTotal);
				
				reporte.add(reporteA);
			}
			
		}
		session.close();
		return reporte;

	}
	
	
	/****/

	
	@Override
	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_maq_labor	(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consumo_combustible_rdl_resumen_maq_labor (:compania, :fechaInicial,  :fechaFinal, "
				+ ":equipo, :flagEquipo )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
	
		
		q.setLong("flagEquipo", flagEquipo);
		

		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

				
				BigDecimal valor_unitario = (BigDecimal) row[0];
				BigDecimal cantidad_compra = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				BigDecimal costoTotal = (BigDecimal) row[4];
				BigDecimal horas = (BigDecimal) row[5];
				BigDecimal gl_hora = (BigDecimal) row[6];
				BigDecimal gl_hora_estandar = (BigDecimal) row[7];
				
				String codLabor = (String) row[8];
				String nomLabor = (String) row[9];
				
				reporteA.setCodLabor(codLabor);
				reporteA.setNomLabor(nomLabor);
				reporteA.setHoras(horas);
				reporteA.setGlHorasEstandar(gl_hora_estandar);
				reporteA.setGlHoras(gl_hora);
				
				
				String nombrePeso1 = "#17b55e";
				reporteA.setColor(nombrePeso1);
				if (gl_hora_estandar.doubleValue() >0 &&  gl_hora.doubleValue()  > gl_hora_estandar.doubleValue()  ) {
					nombrePeso1 = "#F85B5B";
					reporteA.setColor(nombrePeso1);
				} else {
					nombrePeso1 = "#17b55e";
					reporteA.setColor(nombrePeso1);
				}
				
				
				
				reporteA.setValor_unitario(valor_unitario);
				reporteA.setCantidad_compra(cantidad_compra);
				reporteA.setCod_equipo(cod_equipo);
				reporteA.setNom_equipo(nom_equipo);
				reporteA.setCostoTotal(costoTotal);
				
				reporte.add(reporteA);
			}
			
		}
		session.close();
		return reporte;

	}

	
	@Override
	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_labor	(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consumo_combustible_rdl_resumen_labor (:compania, :fechaInicial,  :fechaFinal, "
				+ ":equipo, :flagEquipo )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
	
		
		q.setLong("flagEquipo", flagEquipo);
		

		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

				
				BigDecimal valor_unitario = (BigDecimal) row[0];
				BigDecimal cantidad_compra = (BigDecimal) row[1];
				BigDecimal costoTotal = (BigDecimal) row[2];
				BigDecimal horas = (BigDecimal) row[3];
				BigDecimal gl_hora = (BigDecimal) row[4];
				BigDecimal gl_hora_estandar = (BigDecimal) row[5];
				
				String codLabor = (String) row[6];
				String nomLabor = (String) row[7];
				
				reporteA.setCodLabor(codLabor);
				reporteA.setNomLabor(nomLabor);
				reporteA.setHoras(horas);
				reporteA.setGlHorasEstandar(gl_hora_estandar);
				reporteA.setGlHoras(gl_hora);
				
				
				String nombrePeso1 = "#17b55e";
				reporteA.setColor(nombrePeso1);
				if (gl_hora_estandar.doubleValue() >0 &&  gl_hora.doubleValue()  > gl_hora_estandar.doubleValue()  ) {
					nombrePeso1 = "#F85B5B";
					reporteA.setColor(nombrePeso1);
				} else {
					nombrePeso1 = "#17b55e";
					reporteA.setColor(nombrePeso1);
				}
				
				
				
				reporteA.setValor_unitario(valor_unitario);
				reporteA.setCantidad_compra(cantidad_compra);
				reporteA.setCostoTotal(costoTotal);
				reporte.add(reporteA);
			}
			
		}
		session.close();
		return reporte;

	}
	
	@Override
	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_hda	(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consumo_combustible_rdl_resumen_hda (:compania, :fechaInicial,  :fechaFinal, "
				+ ":equipo, :flagEquipo )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
	
		
		q.setLong("flagEquipo", flagEquipo);
		

		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

				
				BigDecimal valor_unitario = (BigDecimal) row[0];
				BigDecimal cantidad_compra = (BigDecimal) row[1];
				BigDecimal costoTotal = (BigDecimal) row[2];
				BigDecimal horas = (BigDecimal) row[3];
				BigDecimal gl_hora = (BigDecimal) row[4];
				BigDecimal gl_hora_estandar = (BigDecimal) row[5];
				
				String nomHacienda = (String) row[6];
				
				reporteA.setNomHacienda(nomHacienda);
				reporteA.setHoras(horas);
				reporteA.setGlHorasEstandar(gl_hora_estandar);
				reporteA.setGlHoras(gl_hora);
				
				
				String nombrePeso1 = "#17b55e";
				reporteA.setColor(nombrePeso1);
				if (gl_hora_estandar.doubleValue() >0 &&  gl_hora.doubleValue()  > gl_hora_estandar.doubleValue()  ) {
					nombrePeso1 = "#F85B5B";
					reporteA.setColor(nombrePeso1);
				} else {
					nombrePeso1 = "#17b55e";
					reporteA.setColor(nombrePeso1);
				}
				
				
				
				reporteA.setValor_unitario(valor_unitario);
				reporteA.setCantidad_compra(cantidad_compra);
				reporteA.setCostoTotal(costoTotal);
				reporte.add(reporteA);
			}
			
		}
		session.close();
		return reporte;

	}

	
	@Override
	public List<ConsultaCompraProductosDTO> pr_inventario_importacion_movil_formato_dia(Long compania, Date fechaInicial, Date fechaFinal, Long flagAlmacen) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_inventario_importacion_movil_formato_dia (:compania, :fechaInicial,  :fechaFinal, "
				+ ":flagAlmacen)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("flagAlmacen", flagAlmacen);
		
		
		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

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
			
				
				String nom_categoria_equipo = (String) row[45];
				String funcion_categoria = (String) row[46];
				String cod_almacen_surtidor = (String) row[47];
				String operario_equipo = (String) row[48];
				String origenDatos = (String) row[49];
				
				String labor = (String) row[50];
				
				reporteA.setNomLabor(labor);
				reporteA.setOrigenDatos(origenDatos);
				reporteA.setNomOperarioMaquina(operario_equipo);
				reporteA.setNom_categoria_equipo(nom_categoria_equipo);
				reporteA.setFuncion_categoria(funcion_categoria);
				reporteA.setCod_almacen_surtidor(cod_almacen_surtidor);
				
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
			
		}
		session.close();
		return reporte;

	}
	
	@Override
	public List<ListadoProximosMttoEquiposDTO> consultarListaProximosMttoEquiposPorVencer(Long compania, String equipo,
			Long flagEquipo, String planRevision, Long flagPlanRevision, String origenDatos, String estadoplan) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_listado_prox_mtto (:compania, " + " :equipo, :flagEquipo,"
				+ " :planRevision, :flagPlanRevision, :origenDatos, :estadoplan )");

		q.setLong("compania", compania);
		q.setString("equipo", equipo);
		q.setString("planRevision", planRevision);
		q.setString("origenDatos", origenDatos);
		q.setLong("flagPlanRevision", flagPlanRevision);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("estadoplan", estadoplan);

		List l = q.list();
		List<ListadoProximosMttoEquiposDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ListadoProximosMttoEquiposDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListadoProximosMttoEquiposDTO reporteA = new ListadoProximosMttoEquiposDTO();

				BigInteger plan_revision_equipo_id = (BigInteger) row[0];
				reporteA.setPlan_revision_equipo_id(plan_revision_equipo_id);
				String codigo_plan_revision = (String) row[1];
				reporteA.setCod_plan_revision(codigo_plan_revision);
				String nombre_plan_revision = (String) row[2];
				reporteA.setNombre_plan_revision(nombre_plan_revision);
				BigInteger equipo_id = (BigInteger) row[3];
				reporteA.setEquipo_id(equipo_id);
				String cod_equipo = (String) row[4];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[5];
				reporteA.setNom_equipo(nom_equipo);
				
				BigInteger sistemas_equipo_id = (BigInteger) row[6];
				reporteA.setSistemas_equipo_id(sistemas_equipo_id);
				
				String nombre_sistema_equipo = (String) row[7];
				reporteA.setNombre_sistema_equipo(nombre_sistema_equipo);
				
				BigInteger compartimientos_equipos_id = (BigInteger) row[8];
				reporteA.setCompartimientos_equipos_id(compartimientos_equipos_id);
				
				String nombre_compartimiento_equipo = (String) row[9];
				reporteA.setNombre_compartimiento_equipo(nombre_compartimiento_equipo);
				BigDecimal horas_prox_mtto = (BigDecimal) row[10];
				reporteA.setHoras_prox_mtto(horas_prox_mtto);
				BigDecimal km_prox_mtto = (BigDecimal) row[11];
				reporteA.setKm_prox_mtto(km_prox_mtto);
				Date fecha_prox_mtto = (Date) row[12];
				reporteA.setFecha_prox_mtto(fecha_prox_mtto);

				BigDecimal periocidad = (BigDecimal) row[13];
				reporteA.setPeriocidad(periocidad);

				BigDecimal horasUltMantenimiento = (BigDecimal) row[14];
				reporteA.setHorasUltMantenimiento(horasUltMantenimiento);

				BigDecimal horo_odo_actual = (BigDecimal) row[15];
				reporteA.setHoro_odo_actual(horo_odo_actual);
				
				String tipo_medidor = (String) row[16];
				reporteA.setTipo_medidor(tipo_medidor);	
				
				Date fecha_ultimo_servicio = (Date) row[18];
				reporteA.setFecha_ultimo_servicio(fecha_ultimo_servicio);


				BigDecimal hor_odo_para_prox_mtto = (BigDecimal) row[19];
				reporteA.setHor_odo_para_prox_mtto(hor_odo_para_prox_mtto);
				
				String alerta = (String) row[20];
				reporteA.setAlerta(alerta);	
				
				if(alerta.equals("badge-danger")) {
					reporteA.setAnim_alerta("animated infinite bounce delay-2s");
				}

				if (hor_odo_para_prox_mtto.longValue() > 50) {
					reporteA.setColorEvento("btn btn-primary");
				}

				if (hor_odo_para_prox_mtto.longValue() > 16 && hor_odo_para_prox_mtto.longValue() <= 50) {
					reporteA.setColorEvento("btn-warning");
				}

				if (hor_odo_para_prox_mtto.longValue() < 16) {
					reporteA.setColorEvento("btn btn-danger");
				}
				

				BigDecimal horo_odo_prox_mtto = (BigDecimal) row[21];
				reporteA.setHor_odo_prox_mtto(horo_odo_prox_mtto);
				
				String estadoPlan = (String) row[22];
				reporteA.setEstadoPlan(estadoPlan);	
				
				if(alerta.equals("badge-danger")) {
					reporte.add(reporteA);
				}

			}
			
		}
		session.close();
		return reporte;
	}
	
	

	@Override
	public Long pr_actualizar_plan_revision_det(Long idequipo, Date fecha_ult_serv, Double horas, Double km, String planes, String estadoPlan ) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_actualizar_plan_revision_det (:idequipo, :fecha_ult_serv, :horas, :km, :planes, :estadoPlan)");
		q.setLong("idequipo", idequipo);
		q.setDate("fecha_ult_serv", fecha_ult_serv);
		q.setDouble("horas", horas);
		q.setDouble("km", km);
		q.setString("planes", planes);
		q.setString("estadoPlan", estadoPlan);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	
	@Override
	public List<ProgMttoPreventivosMaqDTO>  pr_ordenes_trabajao_mtto_maq(Long compania, Date fechaInicial, Date fechaFinal, 
			String equipo, Long flagEquipo,
			String responsableMtto, Long flagResponsable, Long consecutivoOt , String estado_ot, Long centCost, String tipoOrden) {
	Session session = sessionFactory.openSession();

	SQLQuery q = session.createSQLQuery("call pr_ordenes_trabajao_mtto_maq (:compania ,:fechaInicial,:fechaFinal, :equipo, :flagEquipo,"
			+ ":responsableMtto, :flagResponsable,  :consecutivoOt, :estado_ot, :centCost, :tipoOrden)");

	q.setLong("compania", compania);
    q.setDate("fechaInicial", fechaInicial);
    q.setDate("fechaFinal", fechaFinal);
    q.setString("equipo", equipo);
    q.setString("responsableMtto", responsableMtto);
    q.setLong("flagEquipo", flagEquipo);
    q.setLong("flagResponsable", flagResponsable);
    q.setLong("consecutivoOt", consecutivoOt);
    q.setString("estado_ot", estado_ot);
    q.setLong("centCost", centCost);
    q.setString("tipoOrden", tipoOrden);
	List l = q.list();
	List<ProgMttoPreventivosMaqDTO> reporte = null;
	StringBuilder result = new StringBuilder();

	if (l.size() > 0) {

		reporte = new ArrayList<ProgMttoPreventivosMaqDTO>();

		for (Iterator it = l.iterator(); it.hasNext();) {

			Object[] row = (Object[]) it.next();

			ProgMttoPreventivosMaqDTO reporteA = new ProgMttoPreventivosMaqDTO();

			BigInteger	id_mtto	=	(BigInteger)	row[0	];
		
			Date	fecha_entrada_taller	=	(Date)	row[1	];
			Date	fecha_salida_taller	=	(Date)	row[2	];
			BigInteger	consecutivo	=	(BigInteger)	row[3	];
			BigInteger	id_equipo	=	(BigInteger)	row[4	];
			String	cod_equipo	=	(String)	row[5	];
			String	nom_equipo	=	(String)	row[6	];
			BigDecimal	horo_odo_entrada	=	(BigDecimal)	row[7	];
			BigInteger	id_plan_revision	=	(BigInteger)	row[8	];
			String	cod_plan_revision	=	(String)	row[9	];
			String	nom_plan_revision	=	(String)	row[10	];
			String	cod_solicitante	=	(String)	row[11	];
			String	solicitante	=	(String)	row[12	];
			BigInteger	responsable_mtto	=	(BigInteger)	row[13	];
			String	cod_responsable_tto	=	(String)	row[14	];
			String	nom_responsable_mtto	=	(String)	row[15	];
			BigInteger	id_usuario_responsable	=	(BigInteger)	row[16	];
			

			String descripcion_solicitud	 =	(String)	row[17];
			String descripcion_ot =	(String)	row[18];
			String cierre_ot =	(String)	row[19];
			String estado =	(String)	row[20];
			
			reporteA.setCierreOt(cierre_ot);
			
			if(cierre_ot.equals("A")) {
				reporteA.setCierreOt2("Abierta");
			}else {
				reporteA.setCierreOt2("Cerrada");
			}
	
			String tipoProcedimiento =	(String)	row[21];
			String foto = (String) row[22];

			String disableBtoDescarga = "true";
			if (!foto.equals("NO")) {
				disableBtoDescarga = "false";
			}
			reporteA.setFoto(foto);
			reporteA.setTipoProcedimiento(tipoProcedimiento);
			reporteA.setEstado(estado);
			reporteA.setId_mtto(id_mtto);
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
	
			reporteA.setDescripcion_solicitud(descripcion_solicitud);
			reporteA.setDescripcion_ot(descripcion_ot);

			String estadoEstrue = "false";
			if (reporteA.getEstado().equals("I")) {
				estadoEstrue = "true";
				reporteA.setEstadoTrue(estadoEstrue);
				reporteA.setEstadoTrue2(estadoEstrue);
			}
			reporteA.setEstadoTrue(estadoEstrue);

			String tituloCierreOt = "Esta seguro que desea cerrar la O.T ?";
			String icon = "ui-icon-unlocked";

			if (reporteA.getCierreOt() != null) {

				if (reporteA.getCierreOt().equals("C")) {
					tituloCierreOt = "Esta seguro que desea reabrir la O.T ?";
					icon = "ui-icon-locked";
					estadoEstrue = "true";
					reporteA.setEstadoTrue2(estadoEstrue);
					reporteA.setTituloCierreOt(tituloCierreOt);
					reporteA.setIconCierreOt(icon);
				}
				reporteA.setTituloCierreOt(tituloCierreOt);
				reporteA.setIconCierreOt(icon);
				reporteA.setEstadoTrue2(estadoEstrue);

			}else {
				
				estadoEstrue = "true";
				reporteA.setEstadoTrue(estadoEstrue);
			}

			reporte.add(reporteA);

		}
		
	}
	session.close();
		return reporte;
	}
	
	
	
	@Override
	public List<ProgLaboresMecMaqDTO>  pr_lista_prog_maquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String supervisor, Long flagSupervisor, String zona, Long flagZona,
			String cliente, Long flagCliente, String hacienda, Long flagHacienda,
			Long consecutivoOt,
			String labor, Long flagLabor, String grupoLabor, Long flagGrupoLabor, String finalizado, Double porc_avance) {
	Session session = sessionFactory.openSession();


	SQLQuery q = session.createSQLQuery("call pr_lista_prog_maquinaria (:compania ,:fechaInicial,:fechaFinal, :supervisor, :flagSupervisor,:zona,:flagZona,  :cliente, :flagCliente,"
			+ ":hacienda, :flagHacienda,  :consecutivoOt, :labor, :flagLabor, :grupoLabor, :flagGrupoLabor, :finalizado, :porc_avance)");


	q.setLong("compania", compania);
    q.setDate("fechaInicial", fechaInicial);
    q.setDate("fechaFinal", fechaFinal);
    q.setString("cliente", cliente);
    q.setString("hacienda", hacienda);
    q.setString("supervisor", supervisor);
    q.setString("zona", zona);
    
    q.setLong("flagSupervisor", flagSupervisor);
    q.setLong("flagCliente", flagCliente);
    q.setLong("flagHacienda", flagHacienda);
    q.setLong("flagZona", flagZona);
    q.setLong("consecutivoOt", consecutivoOt);
    
    q.setString("grupoLabor", grupoLabor);
    q.setString("labor", labor);
    q.setLong("flagLabor", flagLabor);
    q.setLong("flagGrupoLabor", flagGrupoLabor);
    q.setString("finalizado", finalizado);
    q.setDouble("porc_avance", porc_avance);

	List l = q.list();
	List<ProgLaboresMecMaqDTO> ordenesDeTrabajo = null;
	StringBuilder result = new StringBuilder();

	if (l.size() > 0) {

		ordenesDeTrabajo = new ArrayList<ProgLaboresMecMaqDTO>();

		for (Iterator it = l.iterator(); it.hasNext();) {

			Object[] row = (Object[]) it.next();

			ProgLaboresMecMaqDTO ordenDeTrabajo = new ProgLaboresMecMaqDTO();

			//BigInteger idPlanLabor = (BigInteger) row[0];
			
			BigInteger	companiaId	=	(BigInteger) row[	0	];
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
			BigDecimal	ingresoTotal	=	(BigDecimal) row[	43	];
			BigDecimal	vlrUnitario	=	(BigDecimal) row[	44];
			String	estadoFactura	=	(String) row[	45	];
			String	consecutivoPrefactura=	(String) row[	46	];
			String 	numFactura	=	(String ) row[	47	];
			BigDecimal	cantidadPresupuesto	=	(BigDecimal) row[	48	];
			String 	codLote	=	(String ) row[	49	];
			
			ordenDeTrabajo.setEstadoFactura(estadoFactura);
			ordenDeTrabajo.setConsecutivoPrefactura(consecutivoPrefactura);
			ordenDeTrabajo.setNumFactura(numFactura);
			ordenDeTrabajo.setCompania(companiaId);
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
			
			String color1 = "#c8ca9a";
			ordenDeTrabajo.setColor(color1);
			Double porcentajeAvance = 0.0;
			if(cantidad_plan.doubleValue() >0) {
				porcentajeAvance = (cantidadRealizada.doubleValue()/cantidad_plan.doubleValue())*100;
			}
			
			if (porcentajeAvance.doubleValue() >=0 && porcentajeAvance.doubleValue() <25  ) {
				color1 = "#bbca96";
				ordenDeTrabajo.setColor(color1);
			}
			if (porcentajeAvance.doubleValue() >=25 && porcentajeAvance.doubleValue() <50  ) {
				color1 = "#78c880";
				ordenDeTrabajo.setColor(color1);
			}
			if (porcentajeAvance.doubleValue() >=50 && porcentajeAvance.doubleValue() <75 ) {
				color1 = "#51c772";
				ordenDeTrabajo.setColor(color1);
			}
			if (porcentajeAvance.doubleValue() >=75 && porcentajeAvance.doubleValue() <99.9 ) {
				color1 = "#44c76e";
				ordenDeTrabajo.setColor(color1);
			}
				
			if (porcentajeAvance.doubleValue() >=99.9  ) {
				color1 = "#29c665";
				ordenDeTrabajo.setColor(color1);
			}
			
		
	
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
			ordenDeTrabajo.setPorcentajeAvance(porcentajeAvance);
			
			ordenDeTrabajo.setIngresoTotal(ingresoTotal);
			ordenDeTrabajo.setVlrUnitario(vlrUnitario);
			ordenDeTrabajo.setCantidadPresupuesto(cantidadPresupuesto);
			ordenDeTrabajo.setCod_lote(codLote);
			
			ordenesDeTrabajo.add(ordenDeTrabajo);
			

		}
		
	}
	session.close();
	return ordenesDeTrabajo;

	}
	
	
	
	@Override
	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto_ubicacion(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_inventario_saldo_producto_ubicacion (:compania, :fechaInicial,  :fechaFinal, "
						+ ":almacen, :flagAlmacen, :producto, :flagProducto )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("almacen", almacen);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setString("producto", producto);
		q.setLong("flagProducto", flagProducto);

		List l = q.list();
		List<ConsultaStockMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaStockMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaStockMaquinariaDTO reporteA = new ConsultaStockMaquinariaDTO();

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
				
				String nombreUbicacion = (String) row[16];
				reporteA.setNombreUbicacion(nombreUbicacion);
				
				BigInteger idUbicacion = (BigInteger) row[17];
				reporteA.setUbicacionAlmacen(idUbicacion);
				reporteA.setColor1("#FF8000");
				reporteA.setColor2("#17b55e");
				reporteA.setCantidadDigitada(0.0);
				reporte.add(reporteA);
			}
			
		}
		session.close();
		return reporte;

	}
	
	
	

	@Override
	public List<ProgMttoPreventivosMaqDTO>  pr_ordenes_trabajao_mtto_maq_detalle(Long compania, Date fechaInicial, Date fechaFinal, 
			String equipo, Long flagEquipo,
			String responsableMtto, Long flagResponsable, Long consecutivoOt, String tipoOrden ) {
	Session session = sessionFactory.openSession();

	SQLQuery q = session.createSQLQuery("call pr_ordenes_trabajao_mtto_maq_detalle (:compania ,:fechaInicial,:fechaFinal, :equipo, :flagEquipo,"
			+ ":responsableMtto, :flagResponsable,  :consecutivoOt, :tipoOrden)");

	q.setLong("compania", compania);
    q.setDate("fechaInicial", fechaInicial);
    q.setDate("fechaFinal", fechaFinal);
    q.setString("equipo", equipo);
    q.setString("responsableMtto", responsableMtto);
    q.setLong("flagEquipo", flagEquipo);
    q.setLong("flagResponsable", flagResponsable);
    q.setLong("consecutivoOt", consecutivoOt);
    q.setString("tipoOrden", tipoOrden);

	List l = q.list();
	List<ProgMttoPreventivosMaqDTO> reporte = null;
	StringBuilder result = new StringBuilder();

	if (l.size() > 0) {

		reporte = new ArrayList<ProgMttoPreventivosMaqDTO>();

		for (Iterator it = l.iterator(); it.hasNext();) {

			Object[] row = (Object[]) it.next();

			ProgMttoPreventivosMaqDTO reporteA = new ProgMttoPreventivosMaqDTO();

			BigInteger	id_mtto	=	(BigInteger)	row[0	];
		
			Date	fecha_entrada_taller	=	(Date)	row[1	];
			Date	fecha_salida_taller	=	(Date)	row[2	];
			BigInteger	consecutivo	=	(BigInteger)	row[3	];
			BigInteger	id_equipo	=	(BigInteger)	row[4	];
			String	cod_equipo	=	(String)	row[5	];
			String	nom_equipo	=	(String)	row[6	];
			BigDecimal	horo_odo_entrada	=	(BigDecimal)	row[7	];
			String	id_plan_revision2	=	(String)	row[8	];
			String	cod_plan_revision	=	(String)	row[9	];
			String	nom_plan_revision	=	(String)	row[10	];
			String	cod_solicitante	=	(String)	row[11	];
			String	solicitante	=	(String)	row[12	];
			BigInteger	responsable_mtto	=	(BigInteger)	row[13	];
			String	cod_responsable_tto	=	(String)	row[14	];
			String	nom_responsable_mtto	=	(String)	row[15	];
			BigInteger	id_usuario_responsable	=	(BigInteger)	row[16	];
			

			String descripcion_solicitud	 =	(String)	row[17];
			String descripcion_ot =	(String)	row[18];
			String	codAlmacen	=	(String)	row[19	];
			String	nomAlmacen	=	(String)	row[20	];
			
			String	codProducto	=	(String)	row[21];
			String	nomProducto	=	(String)	row[22	];
			String	nomUdadMed	=	(String)	row[23	];
			String	nomUbicacion	=	(String)	row[24];
			BigDecimal	cantidad 	=	(BigDecimal)	row[25	];
			String	datosMtto	=	(String)	row[26];
			String	estadoOt	=	(String)	row[27];
			String	estado	=	(String)	row[28];
			BigDecimal	horOdoActual 	=	(BigDecimal)	row[29];
			String	hor_km_anterior	=	(String)	row[30];
			String	hor_para_mtto	=	(String)	row[31];
			
			String	fechaUltimoServicio	=	(String)	row[32];
			Double	horOdoDifMtto	=	(Double)	row[33];
			
			reporteA.setFechaUltimoServicio(fechaUltimoServicio);
			reporteA.setHorOdoDifMtto(horOdoDifMtto);
			
			reporteA.setHorKmAnterior(hor_km_anterior);
			reporteA.setHorasParaMtto(hor_para_mtto);
			
			reporteA.setHorOdoActual(horOdoActual);
			reporteA.setCierreOt(estadoOt);
			reporteA.setDatosMatto(datosMtto);
			reporteA.setEstado(estado);
			
			
			reporteA.setCodAlmacen(codAlmacen);
			reporteA.setNomAlmacen(nomAlmacen);
			reporteA.setCod_producto(codProducto);
			reporteA.setNom_producto(nomProducto);
			reporteA.setUm_producto(nomUdadMed);
			reporteA.setNomUbicacion(nomUbicacion);
			reporteA.setCantidad(cantidad);
			
			
			
			reporteA.setId_mtto(id_mtto);
			reporteA.setFecha_entrada_taller(fecha_entrada_taller);
			reporteA.setFecha_salida_taller(fecha_salida_taller);
			reporteA.setConsecutivo(consecutivo);
			reporteA.setId_equipo(id_equipo);
			reporteA.setCod_equipo(cod_equipo);
			reporteA.setNom_equipo(nom_equipo);
			reporteA.setHoro_odo_entrada(horo_odo_entrada);
			reporteA.setId_plan_revision2(id_plan_revision2);
			reporteA.setCod_plan_revision(cod_plan_revision);
			reporteA.setNom_plan_revision(nom_plan_revision);
			reporteA.setCod_solicitante(cod_solicitante);
			reporteA.setSolicitante(solicitante);
			reporteA.setResponsable_mtto(responsable_mtto);
			reporteA.setCod_responsable_tto(cod_responsable_tto);
			reporteA.setNom_responsable_mtto(nom_responsable_mtto);
			reporteA.setId_usuario_responsable(id_usuario_responsable);
	
			reporteA.setDescripcion_solicitud(descripcion_solicitud);
			reporteA.setDescripcion_ot(descripcion_ot);


			reporte.add(reporteA);

		}
		
	}
	session.close();

		return reporte;
	}
	
	

	@Override
	public Long pr_actualizar_prog_maquinaria(Long idprogramacion) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_actualizar_prog_maquinaria (:idprogramacion)");
		q.setLong("idprogramacion", idprogramacion);
		q.executeUpdate();
			return 1L;

	}

	

	@Override
	public Long pr_borrar_dat_plan_servicios_mq(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_borrar_dat_plan_servicios_mq (:id)");
		q.setLong("id", id);
		q.executeUpdate();
			return 1L;

	}
	
	@Override
	public Long pr_borrar_dat_plan_servicios_mqdet(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_borrar_dat_plan_servicios_mqdet (:id)");
		q.setLong("id", id);
		q.executeUpdate();
			return 1L;

	}

	@Override
	public Long pr_act_prog_dat_serv_realizados_equipo_det(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_act_prog_dat_serv_realizados_equipo_det (:id)");
		q.setLong("id", id);
		q.executeUpdate();
			return 1L;

	}
	
	
	@Override
	public List<ListaLaboresDTO> pr_lista_labores(Long compania, String grupoLabor ) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		Compania companiaId = new Compania();

		SQLQuery q = session.createSQLQuery("call pr_lista_labores (:compania, :grupoLabor )");
		q.setLong("compania", compania);
		q.setString("grupoLabor", grupoLabor);
		List l = q.list();
		ArrayList<ListaLaboresDTO> ListaLaboresDTO = new ArrayList<ListaLaboresDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaLaboresDTO listaLaboresDTOs = new ListaLaboresDTO();
				BigInteger id = (BigInteger) row[0];
				String codLabor = (String) row[1];
				String nomLabor = (String) row[2];
				String codGrupo = (String) row[3];
				String  nomGrupo = (String) row[3];
				listaLaboresDTOs.setLaborId(id);
				listaLaboresDTOs.setCodLabor(codLabor);
				listaLaboresDTOs.setNomLabor(nomLabor);
				listaLaboresDTOs.setNomGrupoLabor(nomGrupo);
				listaLaboresDTOs.setCodGrupoLabor(codGrupo);

				ListaLaboresDTO.add(listaLaboresDTOs);

				// consultaOtDes.add(consultaOt);

			}
			

		}
		session.close();
		return ListaLaboresDTO;

	}
	
	@Override
	public Double pr_ult_horo_odometro_tanqueo(Long compania, Long idMaq) {
		Double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_ult_horo_odometro_tanqueo (:compania,  :idMaq)");
		q.setLong("compania", compania);
		q.setLong("idMaq", idMaq);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal valorObtenido = (BigDecimal) it.next();
				valor = valorObtenido.doubleValue();

			}
			
		}
		session.close();
		return valor;

	}
	
	
	@Override
	public List<ImportarNominaEmpAdmonDTO> pr_nomina_empleados_administrativos(Long compania, Date fechaInicial, Date fechaFinal, String tiponomina) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_nomina_empleados_administrativos (:compania, :fechaInicial, :fechaFinal, :tiponomina)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tiponomina", tiponomina);
		

		List l = q.list();
		List<ImportarNominaEmpAdmonDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ImportarNominaEmpAdmonDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ImportarNominaEmpAdmonDTO reporteA = new ImportarNominaEmpAdmonDTO();

				BigInteger idTabla = (BigInteger) row[0];
				BigInteger idTrabajador = (BigInteger) row[1];
				BigInteger idConceptoNomina = (BigInteger) row[2];
				BigInteger idCompania = (BigInteger) row[3];
				Date periodoInicial = (Date) row[4];
				Date periodoFinal = (Date) row[5];
				String tipo_movimiento = (String) row[6];
				BigDecimal devengo = (BigDecimal) row[7];
				BigDecimal descuentos = (BigDecimal) row[8];
			
				String notas = (String) row[11];
				BigInteger idCentCost = (BigInteger) row[12];
				BigInteger idEquipo = (BigInteger) row[13];
				
				reporteA.setIdEquipo(idEquipo);
				reporteA.setIdCentCost(idCentCost);
				reporteA.setNotas(notas);
				reporteA.setIdTabla(idTabla);
				reporteA.setIdTrabajador(idTrabajador);
				reporteA.setIdConceptoNomina(idConceptoNomina);
				reporteA.setIdCompania(idCompania);
				reporteA.setPeriodoInicial(periodoInicial);
				reporteA.setPeriodoFinal(periodoFinal);
				
				reporteA.setTipoMovimiento(tipo_movimiento);
				reporteA.setDevengo(devengo);
				reporteA.setDescuentos(descuentos);
				reporteA.setIdEquipo(idEquipo);
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}
	

	@Override
	public List<SolicitudesMttoEquipoDTO> pr_hoja_vida_maquina(Long compania, Date fechaInicial, Date fechaFinal,String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_hoja_vida_maquina (:compania, :fechaInicial,  :fechaFinal, :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		

		List l = q.list();
		List<SolicitudesMttoEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<SolicitudesMttoEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				SolicitudesMttoEquipoDTO reporteA = new SolicitudesMttoEquipoDTO();

				Date fecha_entrada_taller = (Date) row[0];
				Date fecha_salida_taller = (Date) row[1];
				BigInteger consecutivo = (BigInteger) row[2];
				String cod_equipo = (String) row[3];
				String nom_equipo = (String) row[4];
				String centro_costo = (String) row[5];
				String taller = (String) row[6];
				BigDecimal horometro_entrada = (BigDecimal) row[7];
				BigDecimal odomentro_entrada = (BigDecimal) row[8];
				String tipo_mantenimiento = (String) row[9];
				String plan_revision = (String) row[10];
				String motivo_entrda_taller = (String) row[11];
				String agente_causador = (String) row[12];
				String duracion_prevista_mtto_hh = (String) row[13];
				BigDecimal duracion_real_hh = (BigDecimal) row[14];
				String cod_solicitante = (String) row[15];
				String solicitante = (String) row[16];
				String cod_conductor = (String) row[17];
				String conductor = (String) row[18];
				String reporte_tecnico = (String) row[19];
				String fecha_trabajo_mec = (String) row[20];
				String mecanicos = (String) row[21];
				String concepto_nomina = (String) row[22];
				String unidad_medida = (String) row[23];
				BigDecimal cantidad_mec = (BigDecimal) row[24];
				BigDecimal tarifa_mec = (BigDecimal) row[25];
				BigDecimal costo_total_mec = (BigDecimal) row[26];
				String almacen_salida = (String) row[27];
				String autoriza = (String) row[28];
				String producto = (String) row[29];
				String um_producto = (String) row[30];
				BigDecimal cantidad = (BigDecimal) row[31];
				BigDecimal valor_unitario = (BigDecimal) row[32];
				BigDecimal costo_total = (BigDecimal) row[33];
				BigInteger dat_mantenimiento_equipo_id = (BigInteger) row[34];
				String codTag = (String) row[35];
				String nombreTag = (String) row[36];
				String tarea = (String) row[37];
				BigDecimal anio = (BigDecimal) row[38];
				String mesCorto = (String) row[39];
				String descripcionSolicitud = (String) row[40];
				String codSistema = (String) row[41];
				String nomSistema = (String) row[42];
				String codComportamiento = (String) row[43];
				String nomComprotamiento = (String) row[44];
				String tipoPersonal = (String) row[45];
				String nom_responsable_mtto = (String) row[46];
				BigDecimal horo_odo_entrada = (BigDecimal) row[47];
				BigDecimal totalGastos =  (BigDecimal) row[48];
				BigDecimal totalCostosMaquina =  (BigDecimal) row[49];
				String origenDatos =  (String) row[50];
				
				reporteA.setCostoTotalGastos(totalGastos);
				reporteA.setTotalCostosMaquina(totalCostosMaquina);
				reporteA.setOrigenDatos(origenDatos);
				
				reporteA.setResponsableMtto(nom_responsable_mtto);
				reporteA.setHoro_odo_entrada(horo_odo_entrada);
				reporteA.setFecha_entrada_taller(fecha_entrada_taller);
				reporteA.setFecha_salida_taller(fecha_salida_taller);
				reporteA.setConsecutivo(consecutivo.longValue());
				reporteA.setCod_equipo(cod_equipo);
				reporteA.setNom_equipo(nom_equipo);
				reporteA.setCentro_costo(centro_costo);
				reporteA.setTaller(taller);
				reporteA.setHorometro_entrada(horometro_entrada);
				reporteA.setOdomentro_entrada(odomentro_entrada);
				reporteA.setTipo_mantenimiento(tipo_mantenimiento);
				reporteA.setPlan_revision(plan_revision);
				reporteA.setMotivo_entrda_taller(motivo_entrda_taller);
				reporteA.setAgente_causador(agente_causador);
				reporteA.setDuracion_prevista_mtto_hh(duracion_prevista_mtto_hh);
				reporteA.setDuracion_real_hh(duracion_real_hh);
				reporteA.setCod_solicitante(cod_solicitante);
				reporteA.setSolicitante(solicitante);
				reporteA.setCod_conductor(cod_conductor);
				reporteA.setConductor(conductor);
				reporteA.setReporte_tecnico(reporte_tecnico);
				reporteA.setFecha_trabajo_mec(fecha_trabajo_mec);
				reporteA.setMecanicos(mecanicos);
				reporteA.setConcepto_nomina(concepto_nomina);
				reporteA.setUnidad_medida(unidad_medida);
				reporteA.setCantidad_mec(cantidad_mec);
				reporteA.setTarifa_mec(tarifa_mec);
				reporteA.setCosto_total_mec(costo_total_mec);
				reporteA.setAlmacen_salida(almacen_salida);
				reporteA.setAutoriza(autoriza);
				reporteA.setProducto(producto);
				reporteA.setUm_producto(um_producto);
				reporteA.setCantidad(cantidad);
				reporteA.setValor_unitario(valor_unitario);
				reporteA.setCosto_total(costo_total);
				reporteA.setDat_mantenimiento_equipo_id(dat_mantenimiento_equipo_id);
				reporteA.setCodTag(codTag);
				reporteA.setNombreTag(nombreTag);
				reporteA.setTarea(tarea);
				reporteA.setAnio(anio);
				reporteA.setMesCorto(mesCorto);
				reporteA.setDescripcionSolicitud(descripcionSolicitud);
				reporteA.setCodSistema(codSistema);
				reporteA.setNomSistema(nomSistema);
				reporteA.setCodComportamiento(codComportamiento);
				reporteA.setNomComprotamiento(nomComprotamiento);
				reporteA.setTipoPersonal(tipoPersonal);

				String nomCategoria = (String) row[51];
				reporteA.setCategoriaEquipo(nomCategoria);
			 
				
				
				String nomTipoProducto = (String) row[52];
				reporteA.setNomTipoProducto(nomTipoProducto);
			 
				
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}



	@Override
	public List<ProgramacionLaboresMaqDTO> pr_avance_proyectos_maq(Long compania, Date fechaInicial, Date fechaFinal,
			String cliente, Long flagCliente, String finca, Long flagFinca, String operador, Long flagOperador,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String equipo, Long flagEquipo, String zonageografica, Long flagZonaGeografica) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_avance_proyectos_maq (:compania,  :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,  :operador,  :flagOperador,  :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor,  "
						+ " :equipo, :flagEquipo, :zonageografica, :flagZonaGeografica )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("operador", operador);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("equipo", equipo);

		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagOperador", flagOperador);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("zonageografica", zonageografica);
		q.setLong("flagZonaGeografica", flagZonaGeografica);

		List l = q.list();
		List<ProgramacionLaboresMaqDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ProgramacionLaboresMaqDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgramacionLaboresMaqDTO reporteA = new ProgramacionLaboresMaqDTO();
				BigDecimal anio_registro = (BigDecimal) row[0];
				reporteA.setAnio_registro(anio_registro);
				BigDecimal mes = (BigDecimal) row[1];
				reporteA.setMes(mes);
				String cod_equipo = (String) row[2];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[3];
				reporteA.setNom_equipo(nom_equipo);
				String cod_finca = (String) row[4];
				reporteA.setCod_finca(cod_finca);
				String nom_finca = (String) row[5];
				reporteA.setNom_finca(nom_finca);
				String nom_labor = (String) row[6];
				reporteA.setNom_labor(nom_labor);
				BigDecimal cantidad_plan = (BigDecimal) row[7];
				reporteA.setCantidad_plan(cantidad_plan);
				BigDecimal cantidad_realizada = (BigDecimal) row[8];
				reporteA.setCantidad_realizada(cantidad_realizada);
				BigDecimal cantidad_pendiente = (BigDecimal) row[9];
				reporteA.setCantidad_pendiente(cantidad_pendiente);
				String concluido = (String) row[10];
				reporteA.setConcluido(concluido);
				String facturado = (String) row[11];
				reporteA.setFacturado(facturado);
				String cod_um_plan = (String) row[12];
				reporteA.setCod_um_plan(cod_um_plan);
				String nom_um_plan = (String) row[13];
				reporteA.setNom_um_plan(nom_um_plan);
				String nom_lote = (String) row[14];
				reporteA.setNom_lote(nom_lote);
				Date periodo_inicial = (Date) row[15];
				reporteA.setPeriodo_inicial(periodo_inicial);
				BigDecimal valor_unitario = (BigDecimal) row[16];
				reporteA.setValor_unitario(valor_unitario);
				BigDecimal valor_est_total = (BigDecimal) row[17];
				reporteA.setValor_est_total(valor_est_total);
				String cod_cliente = (String) row[18];
				reporteA.setCod_cliente(cod_cliente);
				String nom_cliente = (String) row[19];
				reporteA.setNom_cliente(nom_cliente);
				String cod_supervisor = (String) row[20];
				reporteA.setCod_supervisor(cod_supervisor);
				String nom_supervisor = (String) row[21];
				reporteA.setNom_supervisor(nom_supervisor);
				String cod_labor = (String) row[22];
				reporteA.setCod_labor(cod_labor);
				BigInteger consecutivo = (BigInteger) row[23];
				reporteA.setConsecutivo(consecutivo);
				BigInteger dat_plan_servicios_mqdet_id = (BigInteger) row[24];
				reporteA.setDat_plan_servicios_mqdet_id(dat_plan_servicios_mqdet_id);
				BigInteger dat_plan_servicios_mq_id = (BigInteger) row[25];
				reporteA.setDat_plan_servicios_mq_id(dat_plan_servicios_mq_id);
				BigInteger equipo_id = (BigInteger) row[26];
				reporteA.setEquipo_id(equipo_id);
				String cod_zona = (String) row[27];
				reporteA.setCod_zona(cod_zona);
				String nom_zona = (String) row[28];
				reporteA.setNom_zona(nom_zona);
				String detalle_nota = (String) row[29];
				reporteA.setDetalleNota(detalle_nota);
				String fecha_realizado = (String) row[30];
				reporteA.setFecha_realizado(fecha_realizado);
				String nom_operario = (String) row[31];
				reporteA.setNom_operario(nom_operario);
				
				String estadoFactura = (String) row[33];
				reporteA.setEstadoFactura(estadoFactura);
				
				BigInteger consecutivoPrefactura = (BigInteger) row[34];
				reporteA.setConsecutivoPrefactura(consecutivoPrefactura);
				
				String  numFactura = (String) row[35];
				reporteA.setNumFactura(numFactura);

				BigDecimal cantidadPresupuesto = (BigDecimal) row[36];
				reporteA.setCantidadPresupuesto(cantidadPresupuesto);
				
				BigDecimal ingresoEejecucion = (BigDecimal) row[37];
				reporteA.setIngresoTotal(ingresoEejecucion);
				
				
				BigDecimal horometroInicial = (BigDecimal) row[38];
				reporteA.setHorometroInicial(horometroInicial);
				
				BigDecimal horometroFinal = (BigDecimal) row[39];
				reporteA.setHorometroFinal(horometroFinal);
				
				BigDecimal horasTotal = (BigDecimal) row[40];
				reporteA.setHorasTotal(horasTotal);
				
				BigDecimal horasEstimadas = (BigDecimal) row[41];
				reporteA.setHorasEstiamdas(horasEstimadas);
				
				reporte.add(reporteA);

			}
		}
		session.close();
		return reporte;
	}
	
	

	@Override
	public List<DistribuccionCostosMaquinaDTO> pr_distribuccion_ingresos_equipos(Long compania, Date fechaInicial, Date fechaFinal, String tipoCosto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_distribuccion_ingresos_equipos (:compania, :fechaInicial, :fechaFinal, :tipoCosto)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tipoCosto", tipoCosto);
		
		List l = q.list();
		List<DistribuccionCostosMaquinaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<DistribuccionCostosMaquinaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DistribuccionCostosMaquinaDTO reporteA = new DistribuccionCostosMaquinaDTO();

				BigInteger companiaid = (BigInteger) row[0];
				BigDecimal anio = (BigDecimal) row[1];
				BigDecimal mes = (BigDecimal) row[2];
				String anioMes = (String) row[3];
				BigDecimal costoTotal = (BigDecimal) row[4];
				String origenDatos = (String) row[5];
				Date fecha = (Date) row[6];
				BigDecimal totalCostoDistribuido = (BigDecimal) row[9];
				BigDecimal porcentajeDistribuido = (BigDecimal) row[10];
				String origenDatos2 = (String) row [8];
				String color="";
				if (porcentajeDistribuido.doubleValue() >=0.0 && porcentajeDistribuido.doubleValue() <0.01  ) {
					color = "#f09475";
				}
				if (porcentajeDistribuido.doubleValue() >=0.01 && porcentajeDistribuido.doubleValue() <25  ) {
					color = "#bbca96";
				}
				if (porcentajeDistribuido.doubleValue() >=25 && porcentajeDistribuido.doubleValue() <50  ) {
					color = "#78c880";
				}
				if (porcentajeDistribuido.doubleValue() >=50 && porcentajeDistribuido.doubleValue() <75 ) {
					color = "#51c772";
				}
				if (porcentajeDistribuido.doubleValue() >=75 && porcentajeDistribuido.doubleValue() <99.9 ) {
					color = "#44c76e";
				}
					
				if (porcentajeDistribuido.doubleValue() >=99.9  ) {
					color = "#29c665";
				}
				
				reporteA.setCompania(companiaid);
				reporteA.setAnio(anio);
				reporteA.setMes(mes);
				reporteA.setAnioMes(anioMes);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setOrigenDatos(origenDatos);
				reporteA.setFecha(fecha);
				reporteA.setTotalCostoDistribuido(totalCostoDistribuido);
				reporteA.setPorcentajeDistribuido(porcentajeDistribuido);
				reporteA.setOrigenDatos2(origenDatos2);
				reporteA.setColor(color);
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}
	
	@Override
	public Long pr_borrar_distribuccion_costos_ind_maquina(Long compania, Date fechaInicial, Date fechaFinal, String origen) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_borrar_distribuccion_costos_ind_maquina (:compania, :fechaInicial, :fechaFinal, :origen)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("origen", origen);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		session.close();
		return 1L;

	}
	
	public Long pr_insert_distribuccion_ingresos_equipos(Long compania, Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo , String origen) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_insert_distribuccion_ingresos_equipos (:compania, :fechaInicial, :fechaFinal , :equipo, :flagEquipo, :origen)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("origen", origen);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		session.close();
		return 1L;

	}

	@Override
	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto_movil(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto

	) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_inventario_saldo_producto_movil (:compania, :fechaInicial,  :fechaFinal, "
						+ ":almacen, :flagAlmacen, :producto, :flagProducto )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("almacen", almacen);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setString("producto", producto);
		q.setLong("flagProducto", flagProducto);

		List l = q.list();
		List<ConsultaStockMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaStockMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaStockMaquinariaDTO reporteA = new ConsultaStockMaquinariaDTO();

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
				
				BigInteger idProducto = (BigInteger) row[17];
				BigInteger idAlmacen = (BigInteger) row[18];
				BigInteger idUdadMed = (BigInteger) row[19];
				reporteA.setIdAlmacen(idAlmacen);
				reporteA.setIdProducto(idProducto);
				reporteA.setIdUdadMed(idUdadMed);

				reporte.add(reporteA);
			}
		}

		session.close();
		return reporte;

	}
	
	
	@Override
	public List<DistribuccionCostosMaquinaDTO> pr_lista_equipos_distribuccion(Long compania, Date fechaInicial, Date fechaFinal,String equipo, Long flagEquipo ) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_lista_equipos_distribuccion (:compania, :fechaInicial, :fechaFinal, :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		List l = q.list();
		List<DistribuccionCostosMaquinaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<DistribuccionCostosMaquinaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DistribuccionCostosMaquinaDTO reporteA = new DistribuccionCostosMaquinaDTO();

				BigInteger companiaid = (BigInteger) row[0];
				BigDecimal anio = (BigDecimal) row[1];
				BigDecimal mes = (BigDecimal) row[2];
				String anioMes = (String) row[3];
				String codEquipo = (String) row[4];
				String nomEquipo = (String) row[5];
				
				BigDecimal horasHorometro = (BigDecimal) row[6];
				BigDecimal ingresoTotal = (BigDecimal) row[7];
				BigDecimal consolidadoIngresos = (BigDecimal) row[8];
				BigDecimal porcIngresos = (BigDecimal) row[9];
				BigInteger equipoId = (BigInteger) row[10];
				
				
				reporteA.setCompania(companiaid);
				reporteA.setAnio(anio);
				reporteA.setMes(mes);
				reporteA.setAnioMes(anioMes);
				reporteA.setCodEquipo(codEquipo);
				reporteA.setNomEquipo(nomEquipo);
				reporteA.setHorasHorometro(horasHorometro);
				reporteA.setIngresoTotal(ingresoTotal);
				reporteA.setConsolidadoIngresos(consolidadoIngresos);
				reporteA.setPorcIngresos(porcIngresos);
				reporteA.setEquipoId(equipoId);
				

				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}
	

	@Override
	public List<ConsultaRegistrosUsuariosDTO> pr_digitaciones_por_usuario(Long compania, Date fechaInicial,
			Date fechaFinal, String tipo_reg, Long idusuario) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_digitaciones_por_usuario (:compania, :fechaInicial,  :fechaFinal,   :tipo_reg, :idusuario)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tipo_reg", tipo_reg);
		q.setLong("idusuario", idusuario);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaRegistrosUsuariosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaRegistrosUsuariosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaRegistrosUsuariosDTO reporteA = new ConsultaRegistrosUsuariosDTO();

				 String nomCompania =(String) row[0];
				 BigDecimal anio =(BigDecimal) row[1];
				 String anioMes =(String) row[2];
				 BigDecimal mes =(BigDecimal) row[3];
				 
				 String	login =(String) row[4];
				 String	origen_datos =(String) row[5];
				 BigDecimal cantidadRegistros =(BigDecimal) row[6];
				
				reporteA.setNomCompania(nomCompania);
				reporteA.setAnio(anio);
				reporteA.setAnio_mes(anioMes);
				reporteA.setMes(mes);
				reporteA.setLogin(login);
				reporteA.setOrigen_datos(origen_datos);
				reporteA.setCantidadRegistros(cantidadRegistros);

				reporte.add(reporteA);

			}
			
		}
		session.close();
		return reporte;
	}
	
	@Override
	public List<DistribuccionCostosMaquinaDTO> pr_distribuccion_ingresos_equipos_detalle(Long compania, String anioMesFiltro, String idOrigen) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_distribuccion_ingresos_equipos_detalle (:compania, :anioMesFiltro, :idOrigen)");

		q.setLong("compania", compania);
		q.setString("anioMesFiltro", anioMesFiltro);
		q.setString("idOrigen", idOrigen);
		
		List l = q.list();
		List<DistribuccionCostosMaquinaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<DistribuccionCostosMaquinaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DistribuccionCostosMaquinaDTO reporteA = new DistribuccionCostosMaquinaDTO();

				BigInteger companiaid = (BigInteger) row[0];
				BigDecimal anio = (BigDecimal) row[1];
				BigDecimal mes = (BigDecimal) row[2];
				String anioMes = (String) row[3];
				BigDecimal costoTotal = (BigDecimal) row[4];
				String origenDatos = (String) row[5];
				Date fecha = (Date) row[6];
				String origenDatos2 = (String) row [8];
				String conceptoInventario = (String) row [9];
				String maquina = (String) row [10];
				Date fechaServicio = (Date) row[11];
				String observacion = (String) row [12];
				String color2 = "#bdf4be ";
				String color3 = "#dcdcdc";
				
				reporteA.setCompania(companiaid);
				reporteA.setAnio(anio);
				reporteA.setMes(mes);
				reporteA.setAnioMes(anioMes);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setOrigenDatos(origenDatos);
				reporteA.setFecha(fecha);
				reporteA.setOrigenDatos2(origenDatos2);
				reporteA.setConceptoInventario(conceptoInventario);
				reporteA.setMaquina(maquina);
				reporteA.setFechaServicio(fechaServicio);
				reporteA.setObservacion(observacion);
				reporteA.setColor2(color2);
				reporteA.setColor3(color3);
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}
	
	@Override
	public List<CostosIndirectosEquipoDTO> pr_compras_gastos(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, Long documento) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_compras_gastos (:compania, :fechaInicial,  :fechaFinal, " + 
						"	 :contratista, :flagContratista, :documento )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);
		q.setLong("documento", documento);

		List l = q.list();
		List<CostosIndirectosEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<CostosIndirectosEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosIndirectosEquipoDTO reporteA = new CostosIndirectosEquipoDTO();

				BigInteger id = (BigInteger) row[0];
				
				Date fecha = (Date) row[1];
				BigInteger consecutivo = (BigInteger) row[2];
				String numFactura = (String) row[3];
				String codProveedor = (String) row[4];
				String nomProveedor = (String) row[5];
				
				BigDecimal costoTotal = (BigDecimal) row[6];
			
				String estado= (String) row[7];
				String origenDatos = (String) row[8];
				String descripcion = (String) row[9];
				String nomCentroCosto = (String) row[10];
				
				reporteA.setNomCentroCosto(nomCentroCosto);
				reporteA.setCodProveedor(codProveedor);
				reporteA.setNomProveedor(nomProveedor);
				reporteA.setFecha(fecha);
				reporteA.setId(id);
				reporteA.setEstado(estado);
				reporteA.setOrigenDatos(origenDatos);
				reporteA.setConsecutivo(consecutivo);
				reporteA.setNumFactura(numFactura);
				reporteA.setDescripcion(descripcion);
				reporteA.setCostoTotal(costoTotal);
				
				reporte.add(reporteA);
			}
		}
		session.close();
		
		return reporte;

	}
	
	@Override
	public List<ListadoProvisionesDTO> pr_listar_proviciones(Long compania, Date fechaInicial, Date fechaFinal, String trabId, Long flagTrabajador) {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_listar_proviciones(:compania, :fechaInicial, :fechaFinal, :trabId, :flagTrabajador)");
		
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("trabId", trabId);
		q.setLong("flagTrabajador", flagTrabajador);

		List l = q.list();
		List<ListadoProvisionesDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ListadoProvisionesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListadoProvisionesDTO reporteA = new ListadoProvisionesDTO();

				BigInteger datProvisionesCierreNominaId = (BigInteger) row[0];				
				Date fechaRegistro = (Date) row[1];
				BigDecimal devengos = (BigDecimal) row[2];
				String periodoLiquidacion = (String) row[3];
				BigDecimal valorDeduccion = (BigDecimal) row[4];
				String nomTrabajador = (String) row[5];				
				String nomCeptoNomina = (String) row[6];			
				String nomLabor = (String) row[7];
				String loginUsuario = (String) row[8];
				
				reporteA.setDatProvisionesCierreNominaId(datProvisionesCierreNominaId);
				reporteA.setFechaRegistro(fechaRegistro);
				reporteA.setDevengos(devengos);
				reporteA.setPeriodoLiquidacion(periodoLiquidacion);
				reporteA.setValorDeduccion(valorDeduccion);
				reporteA.setNomTrabajador(nomTrabajador);
				reporteA.setNomCeptoNomina(nomCeptoNomina);
				reporteA.setNomLabor(nomLabor);
				reporteA.setLoginUsuario(loginUsuario);
				
				reporte.add(reporteA);
			}
		}
		
		session.close();
		
		return reporte;
	}
	
	@Override
	public List<ListadoProvisionesDTO> pr_listar_proviciones_mq(Long compania, Date fechaInicial, Date fechaFinal, String trabId, Long flagTrabajador) {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_listar_proviciones_mq(:compania, :fechaInicial, :fechaFinal, :trabId, :flagTrabajador)");
		
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("trabId", trabId);
		q.setLong("flagTrabajador", flagTrabajador);

		List l = q.list();
		List<ListadoProvisionesDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ListadoProvisionesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListadoProvisionesDTO reporteA = new ListadoProvisionesDTO();

				BigInteger datProvisionesCierreNominaId = (BigInteger) row[0];				
				Date fechaRegistro = (Date) row[1];
				BigDecimal devengos = (BigDecimal) row[2];
				String periodoLiquidacion = (String) row[3];
				BigDecimal valorDeduccion = (BigDecimal) row[4];
				String nomTrabajador = (String) row[5];				
				String nomCeptoNomina = (String) row[6];			
				String nomLabor = (String) row[7];
				String loginUsuario = (String) row[8];
				
				reporteA.setDatProvisionesCierreNominaId(datProvisionesCierreNominaId);
				reporteA.setFechaRegistro(fechaRegistro);
				reporteA.setDevengos(devengos);
				reporteA.setPeriodoLiquidacion(periodoLiquidacion);
				reporteA.setValorDeduccion(valorDeduccion);
				reporteA.setNomTrabajador(nomTrabajador);
				reporteA.setNomCeptoNomina(nomCeptoNomina);
				reporteA.setNomLabor(nomLabor);
				reporteA.setLoginUsuario(loginUsuario);
				
				reporte.add(reporteA);
			}
		}
		
		session.close();
		
		return reporte;
	}
	
	@Override
	public List<SolicitudesMttoEquipoDTO> pr_ot_plan_revision(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo,  Long idMtto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_ot_plan_revision (:compania, :fechaInicial,  :fechaFinal,"
				+ " :equipo, :flagEquipo,  :id_mtto)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("id_mtto", idMtto);

		List l = q.list();
		List<SolicitudesMttoEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<SolicitudesMttoEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				SolicitudesMttoEquipoDTO reporteA = new SolicitudesMttoEquipoDTO();

				BigInteger consecutivo = (BigInteger) row[0];
				String cod_equipo = (String) row[1];
				String nom_equipo = (String) row[2];
				String cod_plan_revision = (String) row[3];
				String plan_revision = (String) row[4];
				BigInteger dat_mantenimiento_equipo_id = (BigInteger) row[5];
				
				reporteA.setConsecutivo(consecutivo.longValue());
				reporteA.setCod_equipo(cod_equipo);
				reporteA.setNom_equipo(nom_equipo);
				reporteA.setCodPlanRevision(cod_plan_revision);
				reporteA.setPlan_revision(plan_revision);
				reporteA.setDat_mantenimiento_equipo_id(dat_mantenimiento_equipo_id);
				
				reporte.add(reporteA);

			}

		}
		session.close();
		return reporte;
	}	
	
	@Override
	public List<ConsultaCompraMateriaPrimaDTO> pr_lista_compra_materia_prima(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_lista_compra_materia_prima (:compania, :fechaInicial, :fechaFinal, "
				+ ":contratista, :flagContratista, :documento )");
		
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);
		q.setLong("documento", documento);
		
		List l = q.list();
		List<ConsultaCompraMateriaPrimaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraMateriaPrimaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraMateriaPrimaDTO reporteA = new ConsultaCompraMateriaPrimaDTO();
				BigInteger datCompraProductosId = (BigInteger) row[0];
				Date fecha_registro = (Date) row[1];
				BigInteger consecutivo = (BigInteger) row[2];
				BigInteger num_factura = (BigInteger) row[3];
				String cod_proveedor = (String) row[4];
				String nom_proveedor = (String) row[5];
				BigDecimal valor_factura = (BigDecimal) row[6];
				BigDecimal valor_iva = (BigDecimal) row[7];
				BigDecimal valor_descuento = (BigDecimal) row[8];
				String detalle_nota = (String) row[9];
				String tipo_moneda = (String) row[10];
				BigDecimal tasa_conversion_trm = (BigDecimal) row[11];
				String estado = (String) row[12];
				
				reporteA.setDatCompraProductosId(datCompraProductosId);
				reporteA.setFecha_registro(fecha_registro);
				reporteA.setConsecutivo(consecutivo);
				reporteA.setNum_factura(num_factura);
				reporteA.setCod_proveedor(cod_proveedor);
				reporteA.setNom_proveedor(nom_proveedor);
				reporteA.setValor_factura(valor_factura);
				reporteA.setValor_iva(valor_iva);
				reporteA.setValor_descuento(valor_descuento);
				reporteA.setDetalle_nota(detalle_nota);
				reporteA.setTipo_moneda(tipo_moneda);
				reporteA.setTasa_conversion_trm(tasa_conversion_trm);
				reporteA.setEstado(estado);

				reporte.add(reporteA);
			}
		}
		session.close();

		return reporte;

	}

	@Override
	public long consultarConsecutivoDatCompraMateriaPrima(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_compra_materia_prima (:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}

	@Override
	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_materia_prima(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String producto, Long flagProducto, String almacen,
			Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex, Long factura) {

		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_inventario_detalle_materia_prima (:compania, :fechaInicial,  :fechaFinal, "
				+ ":contratista, :flagContratista, :producto, :flagProducto, :almacen, :flagAlmacen, :conceptokardex, :flagConceptokardex, :conseckardex, :factura )");
		
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setString("producto", producto);
		q.setString("almacen", almacen);
		q.setString("conceptokardex", conceptokardex);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setLong("flagConceptokardex", flagConceptokardex);
		q.setLong("conseckardex", conseckardex);
		q.setLong("factura", factura);

		List l = q.list();
		List<ConsultaCompraProductosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaCompraProductosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaCompraProductosDTO reporteA = new ConsultaCompraProductosDTO();

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
				String codUbicacionAlmacen = (String) row[37];
				String infoAdicional = (String) row[38];
				
				reporteA.setInfoAdicional(infoAdicional);
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
				reporteA.setCodUbicacionAlmacen(codUbicacionAlmacen);

				reporte.add(reporteA);
			}
		}
		session.close();
		
		return reporte;

	}
	
	@Override
	public List<ConsultaProgLaboresMaqDTO> pr_consulta_lista_prog_maquinaria(Long compania, Date fechaInicial,
			Date fechaFinal) {
		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_consulta_lista_prog_maquinaria (:compania ,:fechaInicial,:fechaFinal)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);

		List l = q.list();
		List<ConsultaProgLaboresMaqDTO> ordenesDeTrabajo = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			ordenesDeTrabajo = new ArrayList<ConsultaProgLaboresMaqDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaProgLaboresMaqDTO ordenDeTrabajo = new ConsultaProgLaboresMaqDTO();

				// BigInteger idPlanLabor = (BigInteger) row[0];

				BigInteger companiaId = (BigInteger) row[0];
				Date periodo_inicial = (Date) row[1];
				BigInteger consecutivo = (BigInteger) row[2];
				BigInteger dat_plan_servicios_mq_id = (BigInteger) row[3];
				BigInteger id_programa = (BigInteger) row[4];
				BigInteger labor_id = (BigInteger) row[5];
				String cod_labor = (String) row[6];
				String nom_labor = (String) row[7];
				BigInteger id_cliente = (BigInteger) row[8];
				String nom_cliente = (String) row[9];
				BigInteger id_finca = (BigInteger) row[10];
				String nom_finca = (String) row[11];
				BigInteger id_lote = (BigInteger) row[12];
				String nom_lote = (String) row[13];
				BigDecimal cantidad_pendiente = (BigDecimal) row[14];
				BigDecimal area_programada = (BigDecimal) row[15];
				BigInteger udad_med_id = (BigInteger) row[16];

				ordenDeTrabajo.setCompania(companiaId);
				ordenDeTrabajo.setPeriodo_inicial(periodo_inicial);
				ordenDeTrabajo.setConsecutivo(consecutivo);
				ordenDeTrabajo.setDat_plan_servicios_mq_id(dat_plan_servicios_mq_id);
				ordenDeTrabajo.setId_programa(id_programa);
				ordenDeTrabajo.setLabor_id(labor_id);
				ordenDeTrabajo.setCod_labor(cod_labor);
				ordenDeTrabajo.setNom_labor(nom_labor);
				ordenDeTrabajo.setId_cliente(id_cliente);
				ordenDeTrabajo.setNom_cliente(nom_cliente);
				ordenDeTrabajo.setId_finca(id_finca);
				ordenDeTrabajo.setNom_finca(nom_finca);
				ordenDeTrabajo.setId_lote(id_lote);
				ordenDeTrabajo.setNom_lote(nom_lote);
				ordenDeTrabajo.setCantidad_pendiente(cantidad_pendiente);

				ordenDeTrabajo.setArea_programada(area_programada);
				ordenDeTrabajo.setUdad_med_id(udad_med_id);
				ordenesDeTrabajo.add(ordenDeTrabajo);

			}

		}
		session.close();
		return ordenesDeTrabajo;

	}
	
	@Override
	public List<ConsultaProvisioncesMaqDTO> pr_consulta_provisiones_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_provisiones_maq (:compania, :fechaInicial,  :fechaFinal,   :operador,  :flagOperador)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setLong("flagOperador", flagOperador);


		List l = q.list();
		List<ConsultaProvisioncesMaqDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaProvisioncesMaqDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaProvisioncesMaqDTO reporteA = new ConsultaProvisioncesMaqDTO();

				BigInteger	dat_proviciones_cierre_nomina_mq_id	=	(BigInteger) row[	0	];	reporteA.setDat_proviciones_cierre_nomina_mq_id(dat_proviciones_cierre_nomina_mq_id);
				BigInteger	companiaid	=	(BigInteger) row[	1	];	reporteA.setCompania(companiaid);
				BigDecimal	anio_registro	=	(BigDecimal) row[	2	];	reporteA.setAnio_registro(anio_registro);
				BigDecimal	mes	=	(BigDecimal) row[	3	];	reporteA.setMes(mes);
				Date	fecha_creacion	=	(Date) row[	4	];	reporteA.setFecha_creacion(fecha_creacion);
				Date	fecha_inicial	=	(Date) row[	5	];	reporteA.setFecha_inicial(fecha_inicial);
				Date	fecha_final	=	(Date) row[	6	];	reporteA.setFecha_final(fecha_final);
				String	periodo_liquidacion	=	(String) row[	7	];	reporteA.setPeriodo_liquidacion(periodo_liquidacion);
				BigInteger	trab_id	=	(BigInteger) row[	8	];	reporteA.setTrab_id(trab_id);
				BigInteger	cepto_nomina_id	=	(BigInteger) row[	9	];	reporteA.setCepto_nomina_id(cepto_nomina_id);
				String	tipo_movimiento	=	(String) row[	10	];	reporteA.setTipo_movimiento(tipo_movimiento);
				BigDecimal	devengos	=	(BigDecimal) row[	11	];	reporteA.setDevengos(devengos);
				BigDecimal	valor_deduccion	=	(BigDecimal) row[	12	];	reporteA.setValor_deduccion(valor_deduccion);
				String	gasto	=	(String) row[	13	];	reporteA.setGasto(gasto);
				String	usuario_digitacion	=	(String) row[	14	];	reporteA.setUsuario_digitacion(usuario_digitacion);
				BigDecimal	dias_laborados	=	(BigDecimal) row[	15	];	reporteA.setDias_laborados(dias_laborados);
				BigDecimal	total_devengo_empleado	=	(BigDecimal) row[	16	];	reporteA.setTotal_devengo_empleado(total_devengo_empleado);
				String	origen_datos	=	(String) row[	17	];	reporteA.setOrigen_datos(origen_datos);
				String	mes_corto	=	(String) row[	18	];	reporteA.setMes_corto(mes_corto);
				String	cod_operario	=	(String) row[	19	];	reporteA.setCod_operario(cod_operario);
				String	nom_operario	=	(String) row[	20	];	reporteA.setNom_operario(nom_operario);
				String	cod_concepto	=	(String) row[	21	];	reporteA.setCod_concepto(cod_concepto);
				String	nom_concepto	=	(String) row[	22	];	reporteA.setNom_concepto(nom_concepto);
				String	nom_compania	=	(String) row[	23	];	reporteA.setNom_compania(nom_compania);
				String	direccion	=	(String) row[	24	];	reporteA.setDireccion(direccion);
				String	telefono	=	(String) row[	25	];	reporteA.setTelefono(telefono);
				String	rut	=	(String) row[	26	];	reporteA.setRut(rut);
				String	fechaAdmision	=	(String) row[	27	];	reporteA.setFechaAdmision(fechaAdmision);
				String	fechaRetiro	=	(String) row[	28	];	reporteA.setFechaRetiro(fechaRetiro);
				
				
				

				reporte.add(reporteA);

			}
		}

		session.close();

		return reporte;
	}
	
	
	@Override
	public Long pr_calculo_provisiones_maq(Long companiaid ,Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String tipoNomina, Long usuario ) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_calculo_provisiones_maq (:companiaid, :fechaInicial, :fechaFinal, :operador, :flagOperador, :tipoNomina, :usuario)");
		q.setLong("companiaid", companiaid);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setLong("flagOperador", flagOperador);
		q.setString("tipoNomina", tipoNomina);
		q.setLong("usuario", usuario);
		
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	
	
	@Override
	public Long borrar_dat_proviciones_cierre_nomina_mq(Long companiaid ,Date fechaInicial, Date fechaFinal) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call borrar_dat_proviciones_cierre_nomina_mq (:companiaid, :fechaInicial, :fechaFinal)");
		q.setLong("companiaid", companiaid);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
	
		
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	
	@Override
	public List<ConsultaProvisioncesMaqDTO> pr_consulta_provisiones_nomina_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_provisiones_nomina_maq (:compania, :fechaInicial,  :fechaFinal,   :operador,  :flagOperador)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setLong("flagOperador", flagOperador);


		List l = q.list();
		List<ConsultaProvisioncesMaqDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaProvisioncesMaqDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaProvisioncesMaqDTO reporteA = new ConsultaProvisioncesMaqDTO();

				BigInteger	dat_proviciones_cierre_nomina_mq_id	=	(BigInteger) row[	0	];	reporteA.setDat_proviciones_cierre_nomina_mq_id(dat_proviciones_cierre_nomina_mq_id);
				BigInteger	companiaid	=	(BigInteger) row[	1	];	reporteA.setCompania(companiaid);
				BigDecimal	anio_registro	=	(BigDecimal) row[	2	];	reporteA.setAnio_registro(anio_registro);
				BigDecimal	mes	=	(BigDecimal) row[	3	];	reporteA.setMes(mes);
				Date	fecha_creacion	=	(Date) row[	4	];	reporteA.setFecha_creacion(fecha_creacion);
				Date	fecha_inicial	=	(Date) row[	5	];	reporteA.setFecha_inicial(fecha_inicial);
				Date	fecha_final	=	(Date) row[	6	];	reporteA.setFecha_final(fecha_final);
				String	periodo_liquidacion	=	(String) row[	7	];	reporteA.setPeriodo_liquidacion(periodo_liquidacion);
				BigInteger	trab_id	=	(BigInteger) row[	8	];	reporteA.setTrab_id(trab_id);
				BigInteger	cepto_nomina_id	=	(BigInteger) row[	9	];	reporteA.setCepto_nomina_id(cepto_nomina_id);
				String	tipo_movimiento	=	(String) row[	10	];	reporteA.setTipo_movimiento(tipo_movimiento);
				BigDecimal	devengos	=	(BigDecimal) row[	11	];	reporteA.setDevengos(devengos);
				BigDecimal	valor_deduccion	=	(BigDecimal) row[	12	];	reporteA.setValor_deduccion(valor_deduccion);
				String	gasto	=	(String) row[	13	];	reporteA.setGasto(gasto);
				String	usuario_digitacion	=	(String) row[	14	];	reporteA.setUsuario_digitacion(usuario_digitacion);
				BigDecimal	dias_laborados	=	(BigDecimal) row[	15	];	reporteA.setDias_laborados(dias_laborados);
				BigDecimal	total_devengo_empleado	=	(BigDecimal) row[	16	];	reporteA.setTotal_devengo_empleado(total_devengo_empleado);
				String	origen_datos	=	(String) row[	17	];	reporteA.setOrigen_datos(origen_datos);
				String	mes_corto	=	(String) row[	18	];	reporteA.setMes_corto(mes_corto);
				String	cod_operario	=	(String) row[	19	];	reporteA.setCod_operario(cod_operario);
				String	nom_operario	=	(String) row[	20	];	reporteA.setNom_operario(nom_operario);
				String	cod_concepto	=	(String) row[	21	];	reporteA.setCod_concepto(cod_concepto);
				String	nom_concepto	=	(String) row[	22	];	reporteA.setNom_concepto(nom_concepto);
				String	nom_compania	=	(String) row[	23	];	reporteA.setNom_compania(nom_compania);
				String	direccion	=	(String) row[	24	];	reporteA.setDireccion(direccion);
				String	telefono	=	(String) row[	25	];	reporteA.setTelefono(telefono);
				String	rut	=	(String) row[	26	];	reporteA.setRut(rut);
				BigDecimal	costoProvision	=	(BigDecimal) row[	27	];	reporteA.setCostoProvision(costoProvision);
				String	fechaAdmision	=	(String) row[	28	];	reporteA.setFechaAdmision(fechaAdmision);
				String	fechaRetiro	=	(String) row[	29	];	reporteA.setFechaRetiro(fechaRetiro);
				

				reporte.add(reporteA);

			}
		}

		session.close();

		return reporte;
	}
	
	
	@Override
	public List<DistribuccionCostosMaquinaDTO> pr_costos_distribuidos_equipo(  
			Long compania, Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo ,String idOrigen) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_distribuidos_equipo (:compania, :fechaInicial, :fechaFinal, :equipo, :flagEquipo ,:idOrigen)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("flagEquipo", flagEquipo	);
		q.setString("equipo", equipo);
		q.setString("idOrigen", idOrigen);
		
		List l = q.list();
		List<DistribuccionCostosMaquinaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<DistribuccionCostosMaquinaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DistribuccionCostosMaquinaDTO reporteA = new DistribuccionCostosMaquinaDTO();

				BigInteger	companiaId	=	(BigInteger ) row[	0	];
				BigDecimal	anio_registro	=	(BigDecimal ) row[	1	];
				BigDecimal	mes	=	(BigDecimal ) row[	2	];
				String	anio_mes	=	(String ) row[	3	];
				BigInteger	equipo_id	=	(BigInteger ) row[	4	];
				BigDecimal	horas_horometro	=	(BigDecimal ) row[	5	];
				BigDecimal	ingreso_total	=	(BigDecimal ) row[	6	];
				BigDecimal	proc_ingresos	=	(BigDecimal ) row[	7	];
				String	origen_datos	=	(String ) row[	8	];
				BigDecimal	costo_maquina	=	(BigDecimal ) row[	9	];
				Date	fecha	=	(Date ) row[	10	];
				Date	fecha_creacion	=	(Date ) row[	11	];
				String	cod_equipo	=	(String ) row[	12	];
				String	login	=	(String ) row[	13	];
				String	mes_corto	=	(String ) row[	14	];
				String	anio_mes_texto	=	(String ) row[	15	];

				String color2 = "#bdf4be ";
				String color3 = "#dcdcdc";
				
				reporteA.setCompania(companiaId);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setAnioMes(anio_mes);
				reporteA.setCostoTotal(costo_maquina);
				reporteA.setOrigenDatos(origen_datos);
				reporteA.setFecha(fecha);  
				reporteA.setMaquina(cod_equipo);
				reporteA.setFechaCreacion(fecha_creacion);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setAnioMes(anio_mes);
				reporteA.setAnioMesTexto(anio_mes_texto);
				reporteA.setEquipoId(equipo_id);
				reporteA.setHorasHorometro(horas_horometro);
				reporteA.setIngresoTotal(ingreso_total);
				reporteA.setPorcentajeDistribuido(proc_ingresos);
				reporteA.setColor2(color2);
				reporteA.setColor3(color3);
				reporteA.setLogin(login);
				reporteA.setMesCorto(mes_corto);
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}
	

	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_maquinaria(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo,
			String categoria, Long flagCategoriaEquipo, Long modeloEquipo
			) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_control_productividad_maquina (:compania, :fechaInicial,  :fechaFinal,   :operador,"
				+ "  :flagOperador, :equipo, :flagEquipo, :categoria, :flagCategoriaEquipo, :modeloEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setLong("flagOperador", flagOperador);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);

		q.setString("categoria", categoria);
		q.setLong("flagCategoriaEquipo", flagCategoriaEquipo);

		q.setLong("modeloEquipo", modeloEquipo);
		
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				Date fecha_registro = (Date) row[2];
				String cod_operario = (String) row[3];
				String nom_operario = (String) row[4];
				String cod_concepto_nomina = (String) row[5];
				String nom_concepto_nomina = (String) row[6];
				String turno = (String) row[7];
				BigInteger pin = (BigInteger) row[8];
				BigInteger id = (BigInteger) row[9];
				String tipoTiampo = (String) row[10];
				String codEquipo = (String) row[11];
				String nomEquipo = (String) row[12];
				String tiempo = (String) row[13];
				BigDecimal dia = (BigDecimal) row[14];
				String codLabor = (String) row[15];
				String nomLabor = (String) row[16];
				
				String categoriaEquipo = (String) row[17];
				String modelo = (String) row[18];
				

				reporteA.setCategoriaEquipo(categoriaEquipo);
				reporteA.setModeloEquipo(modelo);
				
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setTurno(turno);

				reporteA.setConsecutivo(pin);
				reporteA.setDat_serv_realizados_equipo_id(id);
				reporteA.setTipoTiempo(tipoTiampo);
				reporteA.setCodEquipo(codEquipo);
				reporteA.setNomEquipo(nomEquipo);
				reporteA.setTiempo(tiempo);
				reporteA.setDia(dia);
				reporteA.setCodLabor(codLabor);
				reporteA.setNomLabor(nomLabor);
				
				reporte.add(reporteA);

			}
			session.close();
		}

		return reporte;
	}
	
	


	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_maquina_grlabor(Long compania,
			Date fechaInicial, Date fechaFinal,  String equipo, Long flagEquipo, Long grupoLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_control_productividad_maquina_grlabor (:compania, :fechaInicial,  :fechaFinal,    :equipo, :flagEquipo, :grupoLabor)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
	
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("grupoLabor", grupoLabor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				Date fecha_registro = (Date) row[2];
				String cod_operario = (String) row[3];
				String nom_operario = (String) row[4];
				String codEquipo = (String) row[5];
				String nomEquipo = (String) row[6];
				
				String tiempo = (String) row[7];
				BigDecimal dia = (BigDecimal) row[8];
				String codGrpLabor = (String) row[9];
				String nomGrpLabor = (String) row[10];
				BigDecimal horasProductivas = (BigDecimal) row[11];
				BigDecimal horasTransporte = (BigDecimal) row[12];
				BigDecimal horasImproductivas = (BigDecimal) row[13];
				BigInteger equipoId = (BigInteger) row[14];
				Double turnoNumero = (Double) row[15];
				BigDecimal horasEstandar = (BigDecimal) row[16];
				BigDecimal numeroRegistros = (BigDecimal) row[17];
				BigDecimal diasImproductivoDomingos = (BigDecimal) row[18];
				BigDecimal diasImproductivoOtros = (BigDecimal) row[19];
				BigDecimal diasProductivos = (BigDecimal) row[20];
				BigDecimal horasOtrasLabores =(BigDecimal) row[21];
 
				reporteA.setHorasOtrasLabores(horasOtrasLabores);	
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setTurnoNumero(turnoNumero);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				
				reporteA.setCodEquipo(codEquipo);
				reporteA.setNomEquipo(nomEquipo);
				reporteA.setTiempo(tiempo);
				reporteA.setDia(dia);
				reporteA.setCodGrupoGasto(codGrpLabor);
				reporteA.setNomGrupoGasto(nomGrpLabor);
				reporteA.setHorasTransporte(horasTransporte);
				reporteA.setHorasImproductivas(horasImproductivas);
				reporteA.setHorasTotales(horasProductivas.doubleValue());
				reporteA.setEquipoId(equipoId);
				reporteA.setHorasEstandar(horasEstandar);
				
				reporteA.setNumeroRegistros(numeroRegistros);
				reporteA.setDiasImproductivoDomingos(diasImproductivoDomingos);
				reporteA.setDiasImproductivoOtros(diasImproductivoOtros);
				reporteA.setDiasProductivos(diasProductivos);
				
				
				reporte.add(reporteA);

			}
			session.close();
		}

		return reporte;
	}
	
	
	public Long pr_recalcular_mano_obra_serv_maq(Long compania, Date fechaInicial, Date fechaFinal) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_recalcular_mano_obra_serv_maq(:compania, :fechaInicial, :fechaFinal)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	public Long pr_recalcular_mano_obra_serv_maq_parte2(Long compania, Date fechaInicial, Date fechaFinal) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_recalcular_mano_obra_serv_maq_parte2(:compania, :fechaInicial, :fechaFinal)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	
	public Long pr_cierre_nomina_destajo_maquinaria(Long compania, Date fechaInicial, Date fechaFinal,String tipoNomina, Long usuario) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_cierre_nomina_destajo_maquinaria (:compania, :fechaInicial, :fechaFinal , :tipoNomina, :usuario)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tipoNomina", tipoNomina);
		q.setLong("usuario", usuario);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		session.close();
		return 1L;

	}
	
	public Long pr_borrar_trabajador_provisiones(Long compania, Date fechaInicial, Date fechaFinal,String trabajadores) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_borrar_trabajador_provisiones (:compania, :fechaInicial, :fechaFinal , :trabajadores)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("trabajadores", trabajadores);
	
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();
		session.close();
		return 1L;

	}
	
	@Override
	public List<SolicitudesMttoEquipoDTO> pr_solicitudes_mtto_equipo_productos(Long compania, Date fechaInicial,
			Date fechaFinal,  String equipo, Long flagEquipo, String producto,
			Long flagProducto, String almacen, Long flagAlmacen, Long idMtto, Long datmttoprodid, Long tipoProducto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_solicitudes_mtto_equipo_productos (:compania, :fechaInicial,  :fechaFinal, :equipo, "
						+ ":flagEquipo," + " :producto, :flagProducto, :almacen, :flagAlmacen, :id_mtto, :datmttoprodid, :tipoProducto)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
	 
		q.setString("producto", producto);
		q.setString("almacen", almacen);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setLong("id_mtto", idMtto);
		q.setLong("datmttoprodid", datmttoprodid);
		q.setLong("tipoProducto", tipoProducto);

		List l = q.list();
		List<SolicitudesMttoEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<SolicitudesMttoEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				SolicitudesMttoEquipoDTO reporteA = new SolicitudesMttoEquipoDTO();

				Date fecha_entrada_taller = (Date) row[0];
				Date fecha_salida_taller = (Date) row[1];
				BigInteger consecutivo = (BigInteger) row[2];
				String cod_equipo = (String) row[3];
				String nom_equipo = (String) row[4];
				String centro_costo = (String) row[5];
				String taller = (String) row[6];
				BigDecimal horometro_entrada = (BigDecimal) row[7];
				BigDecimal odomentro_entrada = (BigDecimal) row[8];
				String tipo_mantenimiento = (String) row[9];
				String plan_revision = (String) row[10];
				String motivo_entrda_taller = (String) row[11];
				String agente_causador = (String) row[12];
				String duracion_prevista_mtto_hh = (String) row[13];
				BigDecimal duracion_real_hh = (BigDecimal) row[14];
				String cod_solicitante = (String) row[15];
				String solicitante = (String) row[16];
				String cod_conductor = (String) row[17];
				String conductor = (String) row[18];
				String reporte_tecnico = (String) row[19];
				String fecha_trabajo_mec = (String) row[20];
				String mecanicos = (String) row[21];
				String concepto_nomina = (String) row[22];
				String unidad_medida = (String) row[23];
				BigDecimal cantidad_mec = (BigDecimal) row[24];
				BigDecimal tarifa_mec = (BigDecimal) row[25];
				BigDecimal costo_total_mec = (BigDecimal) row[26];
				String almacen_salida = (String) row[27];
				String autoriza = (String) row[28];
				String nom_producto = (String) row[29];
				String um_producto = (String) row[30];
				BigDecimal cantidad = (BigDecimal) row[31];
				BigDecimal valor_unitario = (BigDecimal) row[32];
				BigDecimal costo_total = (BigDecimal) row[33];
				BigInteger dat_mantenimiento_equipo_id = (BigInteger) row[34];
				String codTag = (String) row[35];
				String nombreTag = (String) row[36];
				String tarea = (String) row[37];
				BigDecimal anio = (BigDecimal) row[38];
				String mesCorto = (String) row[39];
				String descripcionSolicitud = (String) row[40];
				String codSistema = (String) row[41];
				String nomSistema = (String) row[42];
				String codComportamiento = (String) row[43];
				String nomComprotamiento = (String) row[44];
				String tipoPersonal = (String) row[45];
				String nom_responsable_mtto = (String) row[46];

				BigDecimal horo_odo_entrada = (BigDecimal) row[47];
				String estadoOt = (String) row[48];
				Date fechaProducto = 	(Date) row[49];
				BigInteger datMantenimientoEquipoProdId = 	(BigInteger) row[50];
				BigInteger conceptoKardexId = 	(BigInteger) row[51];
				String nombreConceptoKardex = 	(String) row[52];
				String nomTipoProducto = 	(String) row[53];
				BigInteger equipoId = 	(BigInteger) row[54];
				String ubicacionAlmacen = (String) row[55];
				
				reporteA.setUbicacionAlmacen(ubicacionAlmacen);
				
				reporteA.setEstadoOt(estadoOt);
				reporteA.setFechaRegistroProd(fechaProducto);
				reporteA.setDatMantenimientoEquipoProdId(datMantenimientoEquipoProdId);
				reporteA.setConceptoKardexId(conceptoKardexId);
				reporteA.setNombreConceptoKardex(nombreConceptoKardex);
				reporteA.setNomTipoProducto(nomTipoProducto);

				reporteA.setResponsableMtto(nom_responsable_mtto);
				reporteA.setHoro_odo_entrada(horo_odo_entrada);
				
				reporteA.setFecha_entrada_taller(fecha_entrada_taller);
				reporteA.setFecha_salida_taller(fecha_salida_taller);
				reporteA.setConsecutivo(consecutivo.longValue());
				reporteA.setCod_equipo(cod_equipo);
				reporteA.setNom_equipo(nom_equipo);
				reporteA.setCentro_costo(centro_costo);
				reporteA.setTaller(taller);
				reporteA.setHorometro_entrada(horometro_entrada);
				reporteA.setOdomentro_entrada(odomentro_entrada);
				reporteA.setTipo_mantenimiento(tipo_mantenimiento);
				reporteA.setPlan_revision(plan_revision);
				reporteA.setMotivo_entrda_taller(motivo_entrda_taller);
				reporteA.setAgente_causador(agente_causador);
				reporteA.setDuracion_prevista_mtto_hh(duracion_prevista_mtto_hh);
				reporteA.setDuracion_real_hh(duracion_real_hh);
				reporteA.setCod_solicitante(cod_solicitante);
				reporteA.setSolicitante(solicitante);
				reporteA.setCod_conductor(cod_conductor);
				reporteA.setConductor(conductor);
				reporteA.setReporte_tecnico(reporte_tecnico);
				reporteA.setFecha_trabajo_mec(fecha_trabajo_mec);
				reporteA.setMecanicos(mecanicos);
				reporteA.setConcepto_nomina(concepto_nomina);
				reporteA.setUnidad_medida(unidad_medida);
				reporteA.setCantidad_mec(cantidad_mec);
				reporteA.setTarifa_mec(tarifa_mec);
				reporteA.setCosto_total_mec(costo_total_mec);
				reporteA.setAlmacen_salida(almacen_salida);
				reporteA.setAutoriza(autoriza);
				reporteA.setProducto(nom_producto);
				reporteA.setUm_producto(um_producto);
				reporteA.setCantidad(cantidad);
				reporteA.setValor_unitario(valor_unitario);
				reporteA.setCosto_total(costo_total);
				reporteA.setDat_mantenimiento_equipo_id(dat_mantenimiento_equipo_id);
				reporteA.setCodTag(codTag);
				reporteA.setNombreTag(nombreTag);
				reporteA.setTarea(tarea);
				reporteA.setAnio(anio);
				reporteA.setMesCorto(mesCorto);
				reporteA.setDescripcionSolicitud(descripcionSolicitud);
				reporteA.setCodSistema(codSistema);
				reporteA.setNomSistema(nomSistema);
				reporteA.setCodComportamiento(codComportamiento);
				reporteA.setNomComprotamiento(nomComprotamiento);
				reporteA.setTipoPersonal(tipoPersonal);
				reporteA.setEquipoId(equipoId);

				reporte.add(reporteA);

			}
		}

		return reporte;
	}
	
	@Override
	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina_maq_destajo2(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador, String tipoNomina) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_comprobante_pago_nomina_maq_destajo2 (:compania, :fechaInicial,  :fechaFinal,   :operador,  :flagOperador, :tipoNomina)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("operador", operador);
		q.setLong("flagOperador", flagOperador);
		q.setString("tipoNomina", tipoNomina);

		List l = q.list();
		List<ConsultaComprobantePagoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaComprobantePagoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaComprobantePagoDTO reporteA = new ConsultaComprobantePagoDTO();

				BigInteger	companiaid	=	(BigInteger) row[	0	];
				BigDecimal	anio_registro	=	(BigDecimal) row[	1	];
				BigDecimal	mes	=	(BigDecimal) row[	2	];
				String	anio_mes	=	(String) row[	3	];
				Date	fecha_registro	=	(Date) row[	4	];
				String	cod_equipo	=	(String) row[	5	];
				String	nom_equipo	=	(String) row[	6	];
				BigDecimal	cantidad_pago	=	(BigDecimal) row[	7	];
				BigDecimal	horas_horometro	=	(BigDecimal) row[	8	];
				String	turno	=	(String) row[	9	];
				String	cod_operario	=	(String) row[	10	];
				String	nom_operario	=	(String) row[	11	];
				String	tipo_movimiento	=	(String) row[	12	];
				String	cod_concepto_nomina	=	(String) row[	13	];
				String	nom_concepto_nomina	=	(String) row[	14	];
				BigInteger	trab_id	=	(BigInteger) row[	15	];
				BigDecimal	valor_unitario_trabajador	=	(BigDecimal) row[	16	];
				BigDecimal	devengo	=	(BigDecimal) row[	17	];
				BigDecimal	deduccion	=	(BigDecimal) row[	18	];
				String	cod_labor	=	(String) row[	19	];
				String	nom_labor	=	(String) row[	20	];
				String	cod_hacienda	=	(String) row[	21	];
				String	nom_hacienda	=	(String) row[	22	];
				String	cod_lote	=	(String) row[	23	];
				String	nom_profesion	=	(String) row[	24	];
				String	nom_udad_med	=	(String) row[	25	];
				BigInteger	consecutivo	=	(BigInteger) row[	26	];
				BigInteger	consecutivoRdl	=	(BigInteger) row[	27	];
				
				reporteA.setConsecutivo(consecutivo);
				reporteA.setConsecutivoRdl(consecutivoRdl);
				
				reporteA.setCompania(companiaid);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setAnio_mes(anio_mes);
				reporteA.setFecha_registro(fecha_registro);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCantidad_pago(cantidad_pago);
				reporteA.setHoras_horometro(horas_horometro);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setTipoMovimiento(tipo_movimiento);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setTrab_id(trab_id);
				reporteA.setValor_unitario_trabajador(valor_unitario_trabajador);
				reporteA.setDevengo(devengo);
				reporteA.setDescuentos(deduccion);
				reporteA.setCod_labor(cod_labor);
				reporteA.setNom_labor(nom_labor);
				reporteA.setCod_hacienda(cod_hacienda);
				reporteA.setNom_hacienda(nom_hacienda);
				reporteA.setCod_lote(cod_lote);
				reporteA.setNom_profesion(nom_profesion);
				reporteA.setUnidadMedida(nom_udad_med);

				reporte.add(reporteA);

			}
		}

		session.close();

		return reporte;
	}
	
	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDetCombustible(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId, 
			Long consecutivoRdl) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_serv_realizados_equipo_det_combustible (:compania, :estadoServicio, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,  :operador,  :flagOperador,  :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor,   :equipo, :flagEquipo, :pinId, :consecutivoRdl)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("operador", operador);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("equipo", equipo);
		q.setString("estadoServicio", estadoServicio);
		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagOperador", flagOperador);

		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("pinId", pinId);
		q.setLong("consecutivoRdl", consecutivoRdl);
	
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				String cod_finca = (String) row[4];
				String nom_finca = (String) row[5];
				String nom_labor = (String) row[6];
				BigDecimal cantidad_pago = (BigDecimal) row[7];
				String cod_udad_med_pago = (String) row[8];
				String nom_udad_med_pago = (String) row[9];
				BigDecimal horas = (BigDecimal) row[10];
				String nom_lote = (String) row[11];
				Date fecha_registro = (Date) row[12];
				String hora_inicial = (String) row[13];
				String hora_final = (String) row[14];
				BigDecimal horometro_inicial = (BigDecimal) row[15];
				BigDecimal horometro_final = (BigDecimal) row[16];
				String cod_producto = (String) row[17];
				String nom_producto = (String) row[18];
				BigDecimal cantidad_galones = (BigDecimal) row[19];
				String cod_udad_med_ins = (String) row[20];
				String nom_udad_med_ins = (String) row[21];
				BigDecimal costo_combustible = (BigDecimal) row[22];
				BigDecimal gl_hora_prom = (BigDecimal) row[23];
				BigDecimal valor_unitario = (BigDecimal) row[24];
				BigDecimal ingreso_total = (BigDecimal) row[25];
				String cod_cliente = (String) row[26];
				String nom_cliente = (String) row[27];
				BigDecimal sello = (BigDecimal) row[28];
				String turno = (String) row[29];
				String cod_operario = (String) row[30];
				String nom_operario = (String) row[31];
				String cod_concepto_nomina = (String) row[32];
				String nom_concepto_nomina = (String) row[33];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[34];
				String cod_implemento = (String) row[35];
				String nom_implemento = (String) row[36];

				String docFactura = (String) row[37];
				String codLabor = (String) row[38];
				BigInteger pin = (BigInteger) row[39];
				BigInteger idRegistro = (BigInteger) row[40];
				String estatusRegistro = (String) row[41];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[42];
				BigInteger equipoId = (BigInteger) row[43];
				BigDecimal auxilioTransporte = (BigDecimal) row[44];
				BigInteger consecutivoPrefactura = (BigInteger) row[45];

				BigDecimal  valor_unitario_trabajador = (BigDecimal) row[46];
				BigDecimal valor_total_trabajador = (BigDecimal) row[47];
				BigInteger consecRdl = (BigInteger) row[48];
				BigDecimal areaHr = (BigDecimal) row[49];
				BigInteger idProgramacion = (BigInteger) row[50];
				String nombreCentCost = (String) row[51];
				
				reporteA.setIdProgramacion(idProgramacion);
				reporteA.setAreaHr(areaHr);
				reporteA.setConsecutivoRdl(consecRdl);
				
				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCodFinca(cod_finca);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setNomUdadMed(nom_udad_med_pago);
				reporteA.setHoras(horas);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHoraInicial(hora_inicial);
				reporteA.setHoraFinal(hora_final);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setCodProducto(cod_producto);
				reporteA.setNomProducto(nom_producto);
				reporteA.setCantGalones(cantidad_galones);
				reporteA.setCodUdadMedIns(cod_udad_med_ins);
				reporteA.setNomUdadMedIns(nom_udad_med_ins);
				reporteA.setCostoCombustible(costo_combustible);
				reporteA.setGlHoraPromDia(gl_hora_prom);
				reporteA.setHorasEquipoDia(horas);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setSello(sello);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setNom_implemento(nom_implemento);

				reporteA.setDocFactura(docFactura);
				reporteA.setCodLabor(codLabor);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setAuxilio_transporte(auxilioTransporte);
				reporteA.setConsecutivoPrefactura(consecutivoPrefactura);
				
				reporteA.setValor_unitario_trabajador(valor_unitario_trabajador);
				reporteA.setValor_total_trabajador(valor_total_trabajador);
				

				String estadoEstrue = "false";
				if (estatusRegistro.equals("facturado") || estatusRegistro.equals("prefacturado")) {
					estadoEstrue = "true";
					reporteA.setEstadoTrue(estadoEstrue);
				}

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}
	
	@Override
	public long consec_dat_factura_servicios_terceros(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_factura_servicios_terceros(:compania)");
		q.setLong("compania", compania);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal numConsecutivoActual = (BigDecimal) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}
	
	@Override
	public List<FacturaServiciosConsolidadosTercerosDTO> pr_listar_factura_servicios_terceros(Long compania, Date fechaInicial,
			Date fechaFinal, Long consec, Long centCost) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_listar_factura_servicios_terceros (:compania, :fechaInicial,  :fechaFinal,   :consec, :centCost)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("consec", consec);
		q.setLong("centCost", centCost);

		List l = q.list();

		List<FacturaServiciosConsolidadosTercerosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<FacturaServiciosConsolidadosTercerosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				FacturaServiciosConsolidadosTercerosDTO reporteA = new FacturaServiciosConsolidadosTercerosDTO();
				BigInteger dat_factura_servicios_id = (BigInteger) row[0];
				reporteA.setDat_factura_servicios_id(dat_factura_servicios_id);
				
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				
				String num_factura = (String) row[2];
				reporteA.setNum_factura(num_factura);
			
				BigInteger cliente_id = (BigInteger) row[3];
				reporteA.setClienteId(cliente_id);
			
				
				String cod_cliente = (String) row[4];
				reporteA.setCod_cliente(cod_cliente);
				
				String nom_cliente = (String) row[5];
				reporteA.setNom_cliente(nom_cliente);
				

				BigInteger companiaid = (BigInteger) row[6];
				reporteA.setCompania(companiaid);
				
				Date fecha_registro = (Date) row[7];
				reporteA.setFecha_registro(fecha_registro);
				
				
				String detalle_factura = (String) row[8];
				reporteA.setDetalle_factura(detalle_factura);
				

				BigDecimal valor_factura = (BigDecimal) row[9];
				reporteA.setValor_factura(valor_factura);
				
				BigInteger pers_empr_id = (BigInteger) row[10];
				reporteA.setPers_empr_id(pers_empr_id);
			
				String cod_proveedor = (String) row[11];
				reporteA.setCodProveedor(cod_proveedor);

				String nom_proveedor = (String) row[12];
				reporteA.setNomProveedor(nom_proveedor);
				
				String nom_centro_costo = (String) row[13];
				reporteA.setNomCentroCosto(nom_centro_costo);
				
				BigDecimal anio = (BigDecimal) row[14];
				reporteA.setAnio(anio);
				
				BigDecimal mes = (BigDecimal) row[15];
				reporteA.setMes(mes);
				
				String anioMes = (String) row[16];
				reporteA.setAnio_mes(anioMes);
				

				String mesTexto = (String) row[17];
				reporteA.setMesTexto(mesTexto);
		
				String tipoOperacion = (String) row[18];
				reporteA.setTipoOperacion(tipoOperacion);
				
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}
	
	@Override
	public List<FacturaServiciosConsolidadosTercerosDTO> pr_ingresos_egresos_terceros(Long compania, Date fechaInicial,
			Date fechaFinal, Long consec, Long centCost) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_ingresos_egresos_terceros (:compania, :fechaInicial,  :fechaFinal,   :consec, :centCost)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("consec", consec);
		q.setLong("centCost", centCost);

		List l = q.list();

		List<FacturaServiciosConsolidadosTercerosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<FacturaServiciosConsolidadosTercerosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				FacturaServiciosConsolidadosTercerosDTO reporteA = new FacturaServiciosConsolidadosTercerosDTO();
				BigInteger dat_factura_servicios_id = (BigInteger) row[0];
				reporteA.setDat_factura_servicios_id(dat_factura_servicios_id);
				
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				
				String num_factura = (String) row[2];
				reporteA.setNum_factura(num_factura);
			
			 
				
				String cod_cliente = (String) row[3];
				reporteA.setCod_cliente(cod_cliente);
				
				String nom_cliente = (String) row[4];
				reporteA.setNom_cliente(nom_cliente);
				
 
				Date fecha_registro = (Date) row[5];
				reporteA.setFecha_registro(fecha_registro);
				
				
				String detalle_factura = (String) row[6];
				reporteA.setDetalle_factura(detalle_factura);
				

				BigDecimal valor_factura = (BigDecimal) row[7];
				reporteA.setValor_factura(valor_factura);
				
			 
			
				String cod_proveedor = (String) row[8];
				reporteA.setCodProveedor(cod_proveedor);

				String nom_proveedor = (String) row[9];
				reporteA.setNomProveedor(nom_proveedor);
				
				String nom_centro_costo = (String) row[10];
				reporteA.setNomCentroCosto(nom_centro_costo);
				
				String conceptoGasto = (String) row[11];
				reporteA.setNomLabor(conceptoGasto);
				
				String origenDatos = (String) row[12];
				reporteA.setOrigenDatos(origenDatos);
				
				BigDecimal valorEgresos = (BigDecimal) row[13];
				reporteA.setValorEgresos(valorEgresos);
				
				String umConceptoGasto = (String) row[14];
				reporteA.setCodUdadMed(umConceptoGasto);
				
				BigDecimal cantidad = (BigDecimal) row[15];
				reporteA.setCantidad(cantidad);
				
				BigDecimal anio = (BigDecimal) row[16];
				reporteA.setAnio(anio);
				
				BigDecimal mes = (BigDecimal) row[17];
				reporteA.setMes(mes);
				
				String anioMes = (String) row[18];
				reporteA.setAnio_mes(anioMes);
				

				String mesTexto = (String) row[19];
				reporteA.setMesTexto(mesTexto);
				
				String observacion = (String) row[20];
				reporteA.setObservacion(observacion);
				
				BigDecimal cantidadLabor = (BigDecimal) row[21];
				reporteA.setCantidadLabor(cantidadLabor);
				
				BigDecimal horasTrabajadas = (BigDecimal) row[22];
				reporteA.setHorasTrabajadas(horasTrabajadas);
				
				String codigoMaquina = (String) row[23];
				reporteA.setCodigoEquipo(codigoMaquina);
				
				String categoriaEquipo = (String) row[24];
				reporteA.setCategoriaEquipo(categoriaEquipo);
				
				String modeloEquipo = (String) row[25];
				reporteA.setModeloEquipo(modeloEquipo);
				
				String tipoProducto = (String) row[26];
				reporteA.setTipoProducto(tipoProducto);

				
				reporte.add(reporteA);

			}
		}

		session.close();
		return reporte;
	}
	
	
	@Override
	public List<ConsultaStockMaquinariaDTO> pr_inventario_recalculo_precio_entrada_producto(Long compania, Date fechaInicial,
			Date fechaFinal, Long flagAlmacen, Long flagProducto

	) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_inventario_recalculo_precio_entrada_producto (:compania, :fechaInicial,  :fechaFinal, "
						+ ":flagAlmacen, :flagProducto )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setLong("flagProducto", flagProducto);

		List l = q.list();
		List<ConsultaStockMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaStockMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaStockMaquinariaDTO reporteA = new ConsultaStockMaquinariaDTO();

				BigInteger idProducto = (BigInteger) row[0];
				reporteA.setIdProducto(idProducto);
				
				String nom_producto = (String) row[1];
				reporteA.setNomProducto(nom_producto);
				
				BigInteger idAlmacen = (BigInteger) row[2];
				reporteA.setIdAlmacen(idAlmacen);
				
				
				String fechaEntrada = (String) row[3];
				reporteA.setFechaEntrada(fechaEntrada);
				
				BigDecimal valor_unitario = (BigDecimal) row[4];
				reporteA.setV_unitario(valor_unitario);
				
				
			

				reporte.add(reporteA);
			}
		}

		session.close();
		return reporte;

	}
	


	@Override
	public long pr_consec_producto_tipo(Long compania, Long tipoProd) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_consec_producto_tipo  (:compania, :tipoProd)");
		q.setLong("compania", compania);
		q.setLong("tipoProd", tipoProd);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Double numConsecutivoActual = (Double) it.next();
				consecutivo = numConsecutivoActual.longValue() + 1;

			}
		}
		return consecutivo;

	}
	
	@Override
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_realizados_equipo_det_combustible2(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId, 
			Long consecutivoRdl, Long centCostId) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_serv_realizados_equipo_det_combustible2 (:compania, :estadoServicio, :fechaInicial,  :fechaFinal, :cliente, :flagCliente,  "
						+ ":finca, :flagFinca,  :operador,  :flagOperador,  :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor,   :equipo, :flagEquipo, :pinId, :consecutivoRdl, :centCostId)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cliente", cliente);
		q.setString("finca", finca);
		q.setString("operador", operador);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("equipo", equipo);
		q.setString("estadoServicio", estadoServicio);
		q.setLong("flagCliente", flagCliente);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagOperador", flagOperador);

		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("pinId", pinId);
		q.setLong("consecutivoRdl", consecutivoRdl);
		q.setLong("centCostId", centCostId);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaServiciosRealizadosMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaServiciosRealizadosMaquinariaDTO reporteA = new ConsultaServiciosRealizadosMaquinariaDTO();

				BigDecimal anio_registro = (BigDecimal) row[0];
				BigDecimal mes = (BigDecimal) row[1];
				String cod_equipo = (String) row[2];
				String nom_equipo = (String) row[3];
				String cod_finca = (String) row[4];
				String nom_finca = (String) row[5];
				String nom_labor = (String) row[6];
				BigDecimal cantidad_pago = (BigDecimal) row[7];
				String cod_udad_med_pago = (String) row[8];
				String nom_udad_med_pago = (String) row[9];
				BigDecimal horas = (BigDecimal) row[10];
				String nom_lote = (String) row[11];
				Date fecha_registro = (Date) row[12];
				String hora_inicial = (String) row[13];
				String hora_final = (String) row[14];
				BigDecimal horometro_inicial = (BigDecimal) row[15];
				BigDecimal horometro_final = (BigDecimal) row[16];
				String cod_producto = (String) row[17];
				String nom_producto = (String) row[18];
				BigDecimal cantidad_galones = (BigDecimal) row[19];
				String cod_udad_med_ins = (String) row[20];
				String nom_udad_med_ins = (String) row[21];
				BigDecimal costo_combustible = (BigDecimal) row[22];
				BigDecimal gl_hora_prom = (BigDecimal) row[23];
				BigDecimal valor_unitario = (BigDecimal) row[24];
				BigDecimal ingreso_total = (BigDecimal) row[25];
				String cod_cliente = (String) row[26];
				String nom_cliente = (String) row[27];
				BigDecimal sello = (BigDecimal) row[28];
				String turno = (String) row[29];
				String cod_operario = (String) row[30];
				String nom_operario = (String) row[31];
				String cod_concepto_nomina = (String) row[32];
				String nom_concepto_nomina = (String) row[33];
				BigDecimal bonificacion_trabajador = (BigDecimal) row[34];
				String cod_implemento = (String) row[35];
				String nom_implemento = (String) row[36];

				String docFactura = (String) row[37];
				String codLabor = (String) row[38];
				BigInteger pin = (BigInteger) row[39];
				BigInteger idRegistro = (BigInteger) row[40];
				String estatusRegistro = (String) row[41];
				BigInteger dat_serv_realizados_equipo_id = (BigInteger) row[42];
				BigInteger equipoId = (BigInteger) row[43];
				BigDecimal auxilioTransporte = (BigDecimal) row[44];
				BigInteger consecutivoPrefactura = (BigInteger) row[45];

				BigDecimal  valor_unitario_trabajador = (BigDecimal) row[46];
				BigDecimal valor_total_trabajador = (BigDecimal) row[47];
				BigInteger consecRdl = (BigInteger) row[48];
				BigDecimal areaHr = (BigDecimal) row[49];
				BigInteger idProgramacion = (BigInteger) row[50];
				
				String reportar_novedadparada = (String) row[51];
				String tipo_mtto_texto = (String) row[52];
				BigDecimal horometro_mtto = (BigDecimal) row[53];
				String observacion = (String) row[54];
				String nombreCentCosto = (String) row[55];
				String nombreGrupoLabor = (String) row[56];
				
				String nomZonaGeografica = (String) row[57];
				BigDecimal  horometroTanqueo = (BigDecimal) row[58];
				BigDecimal  precioProdId = (BigDecimal) row[59];
				BigDecimal  horometroTanqueoAnterior = (BigDecimal) row[60];
				BigDecimal  horasTanqueo = (BigDecimal) row[61];
				
				
				reporteA.setNomZonaGeografica(nomZonaGeografica);
				reporteA.setHorometroTanqueo(horometroTanqueo);
				reporteA.setPrecioProdId(precioProdId);
				reporteA.setHorometroTanqueoAnterior(horometroTanqueoAnterior);
				reporteA.setHorasTanqueo(horasTanqueo);
				
				reporteA.setNomGrupoGasto(nombreGrupoLabor);
				reporteA.setNombreCentCosto(nombreCentCosto);
				reporteA.setReportar_novedadparada(reportar_novedadparada);
				reporteA.setTipo_mtto_texto(tipo_mtto_texto);
				reporteA.setHorometro_mtto(horometro_mtto);
				reporteA.setObservacion(observacion);
				
				
				reporteA.setIdProgramacion(idProgramacion);
				reporteA.setAreaHr(areaHr);
				reporteA.setConsecutivoRdl(consecRdl);
				
				reporteA.setEquipoId(equipoId);
				reporteA.setDat_serv_realizados_equipo_id(dat_serv_realizados_equipo_id);
				reporteA.setAnio(anio_registro);
				reporteA.setMes(mes);
				reporteA.setCodEquipo(cod_equipo);
				reporteA.setNomEquipo(nom_equipo);
				reporteA.setCodFinca(cod_finca);
				reporteA.setNomFinca(nom_finca);
				reporteA.setNomLabor(nom_labor);
				reporteA.setCantidadPago(cantidad_pago);
				reporteA.setCodUdadMed(cod_udad_med_pago);
				reporteA.setNomUdadMed(nom_udad_med_pago);
				reporteA.setHoras(horas);
				reporteA.setCodLote(nom_lote);
				reporteA.setFechaRegistro(fecha_registro);
				reporteA.setHoraInicial(hora_inicial);
				reporteA.setHoraFinal(hora_final);
				reporteA.setHorometroInicial(horometro_inicial);
				reporteA.setHorometroFinal(horometro_final);
				reporteA.setCodProducto(cod_producto);
				reporteA.setNomProducto(nom_producto);
				reporteA.setCantGalones(cantidad_galones);
				reporteA.setCodUdadMedIns(cod_udad_med_ins);
				reporteA.setNomUdadMedIns(nom_udad_med_ins);
				reporteA.setCostoCombustible(costo_combustible);
				reporteA.setGlHoraPromDia(gl_hora_prom);
				reporteA.setHorasEquipoDia(horas);
				reporteA.setValorUnitario(valor_unitario);
				reporteA.setCostoTotal(ingreso_total);
				reporteA.setCodCliente(cod_cliente);
				reporteA.setNomCliente(nom_cliente);
				reporteA.setSello(sello);
				reporteA.setTurno(turno);
				reporteA.setCod_operario(cod_operario);
				reporteA.setNom_operario(nom_operario);
				reporteA.setCod_concepto_nomina(cod_concepto_nomina);
				reporteA.setNom_concepto_nomina(nom_concepto_nomina);
				reporteA.setBonificacion_trabajador(bonificacion_trabajador);
				reporteA.setCod_implemento(cod_implemento);
				reporteA.setNom_implemento(nom_implemento);

				reporteA.setDocFactura(docFactura);
				reporteA.setCodLabor(codLabor);
				reporteA.setPin(pin);
				reporteA.setIdRegistro(idRegistro);
				reporteA.setEstatusRegistro(estatusRegistro);
				reporteA.setAuxilio_transporte(auxilioTransporte);
				reporteA.setConsecutivoPrefactura(consecutivoPrefactura);
				
				reporteA.setValor_unitario_trabajador(valor_unitario_trabajador);
				reporteA.setValor_total_trabajador(valor_total_trabajador);
				

				String estadoEstrue = "false";
				if (estatusRegistro.equals("facturado") || estatusRegistro.equals("prefacturado")) {
					estadoEstrue = "true";
					reporteA.setEstadoTrue(estadoEstrue);
				}

				reporte.add(reporteA);

			}
		}
		session.close();
		
		return reporte;
	}

	@Override
	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_bodega_ubicacion(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String tipoProducto, Long flagTipoProducto

	) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_inventario_saldo_bodega_ubicacion (:compania, :fechaInicial,  :fechaFinal, "
				+ ":almacen, :flagAlmacen, :tipoProducto, :flagTipoProducto )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("almacen", almacen);
		q.setLong("flagAlmacen", flagAlmacen);
		q.setLong("flagTipoProducto",flagTipoProducto);

		q.setString("tipoProducto",tipoProducto);
		List l = q.list();
		List<ConsultaStockMaquinariaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaStockMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaStockMaquinariaDTO reporteA = new ConsultaStockMaquinariaDTO();

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
				BigDecimal costo_total = (BigDecimal) row[9];
				reporteA.setCosto_total(costo_total);
				BigDecimal valor_unitario = (BigDecimal) row[10];
				reporteA.setV_unitario(valor_unitario);

				String nom_udad_med = (String) row[12];
				reporteA.setNombreUdadMed(nom_udad_med);
				String cod_almacen = (String) row[13];
				reporteA.setCodAlmacen(cod_almacen);
				String nom_almacen = (String) row[14];
				reporteA.setAlmacen(nom_almacen);
				String referencia = (String) row[15];
				reporteA.setReferencia(referencia);

				BigDecimal ndias_para_consumir_producto = (BigDecimal) row[16];
				reporteA.setNdias_para_consumir_producto(ndias_para_consumir_producto);
				BigDecimal ndias_ultima_compra_producto = (BigDecimal) row[17];
				reporteA.setNdias_ultima_compra_producto(ndias_ultima_compra_producto);

				String nombreUbicacion = (String) row[20];
				reporteA.setNombreUbicacion(nombreUbicacion);

				
				reporte.add(reporteA);
			}
		}
		session.close();
		return reporte;

	}
}
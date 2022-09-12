package co.com.arcosoft.dataaccess.dao;

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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.informes.dto.*;

@Service("InformesDAO")
public class InformesDAO implements IInformesDAO {

	@Resource
	private SessionFactory sessionFactory;

	public InformesDAO() {
		super();
	}

	@Override
	public List<DistribucionAreaVariedadDTO> consultarInformeDistribucionAreaVariedad(Long cultivo, String variedad) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_distri_area_variedad (:cultivo, :variedad)");
		q.setLong("cultivo", cultivo);
		q.setString("variedad", variedad);

		// q.setParameterList("variedad", variedades);

		// execute stored procedure and get list result
		List<?> l = q.list();
		List<DistribucionAreaVariedadDTO> distribucionAreaVariedads = null;

		if (l.size() > 0) {

			distribucionAreaVariedads = new ArrayList<DistribucionAreaVariedadDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DistribucionAreaVariedadDTO distribucionAreaVariedad = new DistribucionAreaVariedadDTO();

				BigDecimal area = (BigDecimal) row[0];
				String nombreCultivo = (String) row[2];
				String nombreVariedad = (String) row[1];
				BigDecimal porcArea = (BigDecimal) row[3];

				distribucionAreaVariedad.setArea(area);
				distribucionAreaVariedad.setCultivo(nombreCultivo);
				distribucionAreaVariedad.setVariedad(nombreVariedad);
				distribucionAreaVariedad.setPorcentajeArea(porcArea);
				distribucionAreaVariedads.add(distribucionAreaVariedad);

			}
		}

		return distribucionAreaVariedads;
	}

	@Override
	public List<DistribucionAreaFincaDTO> consultarInformeDistribucionAreaFinca(Long finca) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_distri_area_finca (:finca)");
		q.setLong("finca", 1L);

		// execute stored procedure and get list result
		List l = q.list();
		List<DistribucionAreaFincaDTO> distribuccionAreaFincaDTOs = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			distribuccionAreaFincaDTOs = new ArrayList<DistribucionAreaFincaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DistribucionAreaFincaDTO distribucionAreaFinca = new DistribucionAreaFincaDTO();

				BigDecimal area = (BigDecimal) row[0];
				String nombreFinca = (String) row[1];

				distribucionAreaFinca.setArea(area);
				distribucionAreaFinca.setFinca(nombreFinca);

				distribuccionAreaFincaDTOs.add(distribucionAreaFinca);

			}
		}

		return distribuccionAreaFincaDTOs;
	}

	@Override
	public List<CostosFincaDTO> consultarInformeCostosFinca(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_costos_finca (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<CostosFincaDTO> costosFinca = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			costosFinca = new ArrayList<CostosFincaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosFincaDTO costosFincas = new CostosFincaDTO();

				BigDecimal costoTotal = (BigDecimal) row[0];
				Integer anio = (Integer) row[1];
				Integer mes = (Integer) row[2];
				String anioMes = (String) row[5];
				String nombreCompania = (String) row[4];

				costosFincas.setCostoTotal(costoTotal);
				costosFincas.setAnio(anio);
				costosFincas.setMes(mes);
				costosFincas.setAnioMes(anioMes);
				costosFincas.setNombreCompania(nombreCompania);
				costosFinca.add(costosFincas);

			}
		}

		return costosFinca;
	}

	@Override
	public List<CostosGrupoLaborDTO> consultarInformeCostosGrupoLabor(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_grupo_labor (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<CostosGrupoLaborDTO> costosGrupoLabor = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			costosGrupoLabor = new ArrayList<CostosGrupoLaborDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosGrupoLaborDTO costosGrupoLabores = new CostosGrupoLaborDTO();

				String grpLabor = (String) row[2];
				BigDecimal costoTotal = (BigDecimal) row[3];
				String nombreCompania = (String) row[4];

				costosGrupoLabores.setNombreCompania(nombreCompania);
				costosGrupoLabores.setCostoTotal(costoTotal);
				costosGrupoLabores.setGrpLabor(grpLabor);

				costosGrupoLabor.add(costosGrupoLabores);

			}
		}

		return costosGrupoLabor;

	}

	@Override
	public List<CostosInsumosDTO> consultarInformeCostosInsumos(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto, Long flagProducto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_ins_agricolas_resumen (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, :producto, :flagProducto )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("producto", producto);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagProducto", flagProducto);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<CostosInsumosDTO> costosInsumos = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			costosInsumos = new ArrayList<CostosInsumosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosInsumosDTO costosInsumosA = new CostosInsumosDTO();

				Integer anio = (Integer) row[2];
				Integer mes = (Integer) row[3];
				BigDecimal costoTotal = (BigDecimal) row[5];
				String anioMes = (String) row[6];
				String nombreCompania = (String) row[1];
				costosInsumosA.setNombreCompania(nombreCompania);
				costosInsumosA.setCostoTotal(costoTotal);
				costosInsumosA.setMes(mes);
				costosInsumosA.setAnio(anio);
				costosInsumosA.setAnioMes(anioMes);
				costosInsumos.add(costosInsumosA);

			}
		}

		return costosInsumos;

	}

	@Override
	public List<CostosInsumosDetalladoDTO> consultarInformeCostosInsumosDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto,
			Long flagProducto, Long numPlanilla) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_insumos_agricolas_detalle (:compania, :fechaInicial,  :fechaFinal,"
				+ " :zona, :flagZona, :finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, :unidadMedida, "
				+ ":flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, :producto, :flagProducto, :planilla )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("producto", producto);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagProducto", flagProducto);
		q.setLong("planilla", numPlanilla);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<CostosInsumosDetalladoDTO> costosInsumos = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			costosInsumos = new ArrayList<CostosInsumosDetalladoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosInsumosDetalladoDTO costosInsumosA = new CostosInsumosDetalladoDTO();

				String nombreCompania = (String) row[1];
				Date fecha = (Date) row[2];
				String codZona = (String) row[3];
				String nomZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String nomBloque = (String) row[8];
				String loteA = (String) row[9];
				String nomLote = (String) row[10];
				String codLabor = (String) row[11];
				String nombreLabor = (String) row[12];
				String nomProducto = (String) row[13];
				String codUdadMedAplic = (String) row[14];
				BigDecimal areaAplicada = (BigDecimal) row[15];
				BigDecimal cantidadAplicada = (BigDecimal) row[16];
				BigDecimal costoTotal = (BigDecimal) row[17];
				BigDecimal valorUnit = (BigDecimal) row[18];
				BigDecimal dosis = (BigDecimal) row[19];
				BigDecimal costoHa = (BigDecimal) row[20];
				String mes = (String) row[21];
				String generico = (String) row[22];
				BigInteger idInsumos = (BigInteger) row[23];
				BigInteger consecutivo = (BigInteger) row[24];

				costosInsumosA.setNombreCompania(nombreCompania);
				costosInsumosA.setFecha(fecha);
				costosInsumosA.setCodZona(codZona);
				costosInsumosA.setNomZona(nomZona);
				costosInsumosA.setCodFinca(codFinca);
				costosInsumosA.setNomFinca(nomFinca);
				costosInsumosA.setCodBloque(codBloque);
				costosInsumosA.setNomBloque(nomBloque);
				costosInsumosA.setLoteA(loteA);
				costosInsumosA.setNomLote(nomLote);
				costosInsumosA.setCodLabor(codLabor);
				costosInsumosA.setNombreLabor(nombreLabor);
				costosInsumosA.setNomProducto(nomProducto);
				costosInsumosA.setCodUdadMedAplic(codUdadMedAplic);
				costosInsumosA.setAreaAplicada(areaAplicada);
				costosInsumosA.setCantidadAplicada(cantidadAplicada);
				costosInsumosA.setCostoTotal(costoTotal);
				costosInsumosA.setValorUnit(valorUnit);
				costosInsumosA.setDosis(dosis);
				costosInsumosA.setCostoHa(costoHa);
				costosInsumosA.setMesCorto(mes);
				costosInsumosA.setGenerico(generico);
				costosInsumosA.setIdInsumos(idInsumos);
				costosInsumosA.setConsecutivo(consecutivo);

				costosInsumos.add(costosInsumosA);

			}
		}

		return costosInsumos;

	}

	@Override
	public List<CostosServiciosContratadosDTO> consultarInformeCostosServiciosContratados(Long compania,
			Date fechaInicial, Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia,
			String contratista, Long flagContratista) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_serv_contratados_resumen (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, :contratista, :flagContratista )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("contratista", contratista);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagContratista", flagContratista);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<CostosServiciosContratadosDTO> costosServiciosContratados = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			costosServiciosContratados = new ArrayList<CostosServiciosContratadosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosServiciosContratadosDTO costosServiciosContratadosA = new CostosServiciosContratadosDTO();

				Integer anio = (Integer) row[1];
				Integer mes = (Integer) row[2];
				BigDecimal costoTotal = (BigDecimal) row[4];
				String anioMes = (String) row[5];
				String nombreCompania = (String) row[3];
				costosServiciosContratadosA.setNombreCompania(nombreCompania);
				costosServiciosContratadosA.setCostoTotal(costoTotal);
				costosServiciosContratadosA.setAnio(anio);
				costosServiciosContratadosA.setMes(mes);
				costosServiciosContratadosA.setAnioMes(anioMes);
				costosServiciosContratados.add(costosServiciosContratadosA);

			}
		}

		return costosServiciosContratados;

	}

	@Override
	public List<DatosClimaticosDTO> consultarInformeDatosClimaticos(Long compania, Long estClima, Date fechaInicial,
			Date fechaFinal) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_datos_climatologicos (:compania, :estClima, :fechaInicial, :fechaFinal )");
		q.setLong("compania", compania);
		q.setLong("estClima", estClima);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<DatosClimaticosDTO> datosClimaticos = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			datosClimaticos = new ArrayList<DatosClimaticosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DatosClimaticosDTO datosClimaticosA = new DatosClimaticosDTO();
				String cod_estacion_clima = (String) row[0];
				datosClimaticosA.setCod_estacion_clima(cod_estacion_clima);
				String nom_estacion_clima = (String) row[1];
				datosClimaticosA.setNom_estacion_clima(nom_estacion_clima);
				Date fecha_lluvia = (Date) row[2];
				datosClimaticosA.setFecha_lluvia(fecha_lluvia);
				BigInteger anio = (BigInteger) row[3];
				datosClimaticosA.setAnio(anio);
				BigInteger mes = (BigInteger) row[4];
				datosClimaticosA.setMes(mes);
				String mes_corto = (String) row[5];
				datosClimaticosA.setMes_corto(mes_corto);
				BigDecimal precipitacion = (BigDecimal) row[6];
				datosClimaticosA.setPrecipitacion(precipitacion);
				BigDecimal temperatura_maxima = (BigDecimal) row[7];
				datosClimaticosA.setTemperatura_maxima(temperatura_maxima);
				BigDecimal temperatura_media = (BigDecimal) row[8];
				datosClimaticosA.setTemperatura_media(temperatura_media);
				BigDecimal temperatura_minima = (BigDecimal) row[9];
				datosClimaticosA.setTemperatura_minima(temperatura_minima);
				BigDecimal temperatura_ambiente = (BigDecimal) row[10];
				datosClimaticosA.setTemperatura_ambiente(temperatura_ambiente);
				BigDecimal sensacion_termica = (BigDecimal) row[11];
				datosClimaticosA.setSensacion_termica(sensacion_termica);
				BigDecimal humedad_maxima = (BigDecimal) row[12];
				datosClimaticosA.setHumedad_maxima(humedad_maxima);
				BigDecimal humedad_media = (BigDecimal) row[13];
				datosClimaticosA.setHumedad_media(humedad_media);
				BigDecimal humedad_minima = (BigDecimal) row[14];
				datosClimaticosA.setHumedad_minima(humedad_minima);
				BigDecimal humedad_exterior = (BigDecimal) row[15];
				datosClimaticosA.setHumedad_exterior(humedad_exterior);
				BigDecimal humedad_interior = (BigDecimal) row[16];
				datosClimaticosA.setHumedad_interior(humedad_interior);
				BigDecimal evaporacion = (BigDecimal) row[17];
				datosClimaticosA.setEvaporacion(evaporacion);
				BigDecimal evaporacion_transpiracion = (BigDecimal) row[18];
				datosClimaticosA.setEvaporacion_transpiracion(evaporacion_transpiracion);
				BigDecimal insolacion = (BigDecimal) row[19];
				datosClimaticosA.setInsolacion(insolacion);
				BigDecimal energia_solar = (BigDecimal) row[20];
				datosClimaticosA.setEnergia_solar(energia_solar);
				BigDecimal radiacion_solar = (BigDecimal) row[21];
				datosClimaticosA.setRadiacion_solar(radiacion_solar);
				BigDecimal nubosidad = (BigDecimal) row[22];
				datosClimaticosA.setNubosidad(nubosidad);
				BigDecimal horas_sol = (BigDecimal) row[23];
				datosClimaticosA.setHoras_sol(horas_sol);
				BigDecimal punto_rocio = (BigDecimal) row[24];
				datosClimaticosA.setPunto_rocio(punto_rocio);
				BigDecimal velocidad_viento = (BigDecimal) row[25];
				datosClimaticosA.setVelocidad_viento(velocidad_viento);
				BigDecimal velocidad_maxima = (BigDecimal) row[26];
				datosClimaticosA.setVelocidad_maxima(velocidad_maxima);
				BigDecimal direccion_viento = (BigDecimal) row[27];
				datosClimaticosA.setDireccion_viento(direccion_viento);
				BigDecimal grados_dia_calor = (BigDecimal) row[28];
				datosClimaticosA.setGrados_dia_calor(grados_dia_calor);
				BigDecimal grados_dia_frio = (BigDecimal) row[29];
				datosClimaticosA.setGrados_dia_frio(grados_dia_frio);
				BigDecimal horas_luz = (BigDecimal) row[30];
				datosClimaticosA.setHoras_luz(horas_luz);
				String observacion = (String) row[31];
				datosClimaticosA.setObservacion(observacion);

				datosClimaticos.add(datosClimaticosA);

			}
		}

		return datosClimaticos;

	}

	@Override
	public List<DatosEvaporimetrosDTO> consultarInformeDatosEvaporimetros(Long estEvaporimetro, Date fechaInicial,
			Date fechaFinal) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_evaporimetro (:estEvaporimetro, :fechaInicial, :fechaFinal )");
		q.setLong("estEvaporimetro", estEvaporimetro);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<DatosEvaporimetrosDTO> datosEvaporimetros = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			datosEvaporimetros = new ArrayList<DatosEvaporimetrosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DatosEvaporimetrosDTO datosEvaporimetrosA = new DatosEvaporimetrosDTO();
				Date fecha = (Date) row[2];
				BigDecimal evaporacion = (BigDecimal) row[6];
				String fechaCorta = (String) row[9];
				String nombreEvaporimetro = (String) row[1];
				datosEvaporimetrosA.setNombreEvaporimetro(nombreEvaporimetro);

				datosEvaporimetrosA.setEvaporacion(evaporacion);
				datosEvaporimetrosA.setFecha(fecha);
				datosEvaporimetrosA.setFechaCorta(fechaCorta);
				datosEvaporimetros.add(datosEvaporimetrosA);

			}
		}

		return datosEvaporimetros;

	}

	@Override
	public List<PluviometriaDTO> consultarInformePluviometria(Long estPluvio, Date fechaInicial, Date fechaFinal) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_pluvio_lluvia (:estPluvio, :fechaInicial, :fechaFinal )");
		q.setLong("estPluvio", estPluvio);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<PluviometriaDTO> pluviometria = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pluviometria = new ArrayList<PluviometriaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				PluviometriaDTO pluviometriaA = new PluviometriaDTO();
				Date fecha = (Date) row[2];
				BigDecimal precipitacion = (BigDecimal) row[6];
				String fechaCorta = (String) row[9];
				String nombrePluvio = (String) row[1];
				BigDecimal precipitacion_acum = (BigDecimal) row[10];
				pluviometriaA.setNombrePluvio(nombrePluvio);
				pluviometriaA.setPrecipitacion(precipitacion);
				pluviometriaA.setFecha(fecha);
				pluviometriaA.setFechaCorta(fechaCorta);
				pluviometriaA.setPrecipitacion_acum(precipitacion_acum);
				pluviometria.add(pluviometriaA);

			}
		}

		return pluviometria;

	}

	@Override
	public List<IndicadoresRiegoDTO> consultarInformeIndicadoresRiego(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String infraestructura, Long flagInfraestructura,
			String sistemaRiego, Long flagSistemaRiego) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_indicadores_riego (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, :infraestructura,"
						+ "	:flagInfraestructura, :sistemaRiego, :flagSistemaRiego )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("infraestructura", infraestructura);
		q.setString("sistemaRiego", sistemaRiego);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagInfraestructura", flagInfraestructura);
		q.setLong("flagSistemaRiego", flagSistemaRiego);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<IndicadoresRiegoDTO> indicadoresRiego = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			indicadoresRiego = new ArrayList<IndicadoresRiegoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				IndicadoresRiegoDTO indicadoresRiegoA = new IndicadoresRiegoDTO();

				Integer anio = (Integer) row[1];
				Integer mes = (Integer) row[2];
				BigDecimal areaRegada = (BigDecimal) row[3];
				BigDecimal metrosCubicosTotales = (BigDecimal) row[4];
				String anioMes = (String) row[5];
				String nombreCompania = (String) row[6];
				indicadoresRiegoA.setNombreCompania(nombreCompania);
				indicadoresRiegoA.setAreaRegada(areaRegada);
				indicadoresRiegoA.setMetrosCubicosTotales(metrosCubicosTotales);
				indicadoresRiegoA.setMes(mes);
				indicadoresRiegoA.setAnio(anio);
				indicadoresRiegoA.setAnioMes(anioMes);
				indicadoresRiego.add(indicadoresRiegoA);

			}
		}

		return indicadoresRiego;

	}

	@Override
	public List<MateriaPrimaLoteDTO> consultarInformeMateriaPrimaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_materia_prima_lote (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
						+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
						+ ":modCosecha, :flagModCosecha,:noCosecha,  :flagNoCosecha, :producto,  :flagProducto )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("noCosecha", noCosecha);
		q.setString("producto", producto);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNoCosecha", flagNoCosecha);
		q.setLong("flagProducto", flagProducto);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<MateriaPrimaLoteDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<MateriaPrimaLoteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				MateriaPrimaLoteDTO materiaPrimaLoteA = new MateriaPrimaLoteDTO();

				String loteA = (String) row[10];
				BigDecimal cantidadCos = (BigDecimal) row[11];
				BigDecimal ingresos = (BigDecimal) row[12];
				BigDecimal area = (BigDecimal) row[13];
				String codZona = (String) row[3];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String nombreCompania = (String) row[14];

				materiaPrimaLoteA.setCantidadCos(cantidadCos);
				materiaPrimaLoteA.setArea(area);
				materiaPrimaLoteA.setLoteA(loteA);
				materiaPrimaLoteA.setIngresos(ingresos);
				materiaPrimaLoteA.setCodZona(codZona);
				materiaPrimaLoteA.setCodFinca(codFinca);
				materiaPrimaLoteA.setNomFinca(nomFinca);
				materiaPrimaLoteA.setCodBloque(codBloque);
				materiaPrimaLoteA.setNombreCompania(nombreCompania);
				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<ProgramacionLaboresDTO> consultarInformeProgramacionLabores(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String grupoLabor, Long flagGrupoLabor,
			String supervisor, Long flagSupervisor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_programacion_labores (:compania, :fechaInicial,  :fechaFinal,  :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ " :grupoLabor, :flagGrupoLabor, " + ":supervisor, :flagSupervisor )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("supervisor", supervisor);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("grupoLabor", grupoLabor);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagSupervisor", flagSupervisor);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProgramacionLaboresDTO> programacionLabores = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			programacionLabores = new ArrayList<ProgramacionLaboresDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgramacionLaboresDTO programacionLaboresA = new ProgramacionLaboresDTO();

				BigInteger ordenTrabajo1 = (BigInteger) row[2];

				Date periodoInicial = (Date) row[3];
				Date periodoFinal = (Date) row[4];
				Date fechaRealizado = (Date) row[5];
				String codLabor = (String) row[7];
				String nombreLabor = (String) row[8];
				String nomZona = (String) row[10];
				String codFinca = (String) row[12];
				String nomFinca = (String) row[13];
				String nomBloque = (String) row[16];
				String loteA = (String) row[18];
				String nomLote = (String) row[19];
				BigDecimal area = (BigDecimal) row[29];
				BigDecimal plantas = (BigDecimal) row[30];

				BigDecimal cantidadPlan = (BigDecimal) row[20];
				String nombreUdadMed = (String) row[23];
				String nombreSupervisor = (String) row[25];
				BigDecimal rendimientoMO = (BigDecimal) row[27];
				BigDecimal rendimientoMQ = (BigDecimal) row[28];
				BigDecimal consumoAcpm = (BigDecimal) row[31];
				String observacion = (String) row[32];
				String estadoOt = (String) row[33];

				programacionLaboresA.setCantidadPlan(cantidadPlan);
				programacionLaboresA.setCodZona(nomZona);
				programacionLaboresA.setCodFinca(codFinca);
				programacionLaboresA.setNomFinca(nomFinca);
				programacionLaboresA.setCodBloque(nomBloque);
				programacionLaboresA.setLoteA(loteA);
				programacionLaboresA.setNomLote(nomLote);
				programacionLaboresA.setCodLabor(codLabor);
				programacionLaboresA.setNombreLabor(nombreLabor);
				programacionLaboresA.setPeriodoInicial(periodoInicial);
				programacionLaboresA.setPeriodoFinal(periodoFinal);
				programacionLaboresA.setNombreUdadMed(nombreUdadMed);
				programacionLaboresA.setOrdenTrabajo(ordenTrabajo1);
				programacionLaboresA.setNombreSupervisor(nombreSupervisor);
				programacionLaboresA.setObservacion(observacion);
				programacionLaboresA.setFechaRealizado(fechaRealizado);
				programacionLaboresA.setRendimientoMO(rendimientoMO);
				programacionLaboresA.setRendimientoMQ(rendimientoMQ);
				programacionLaboresA.setArea(area);
				programacionLaboresA.setPlantas(plantas);

				programacionLaboresA.setConsumoAcpm(consumoAcpm);
				programacionLaboresA.setEstadoOt(estadoOt);

				programacionLabores.add(programacionLaboresA);

			}
		}

		return programacionLabores;
	}

	@Override
	public List<VariacionPrecioCultivoDTO> consultarInformeVariacionPrecioCultivo(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida,
			String tenencia, Long flagTenencia, String modCosecha, Long flagModCosecha, String noCosecha,
			Long flagNoCosecha, Long producto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_variacion_precio_cultivo (:compania, :fechaInicial,  :fechaFinal, :cultivo, :flagCultivo,"
						+ ":zona, :flagZona,  " + ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
						+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
						+ ":modCosecha, :flagModCosecha,:noCosecha,  :flagNoCosecha, :producto )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cultivo", cultivo);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("noCosecha", noCosecha);
		q.setLong("producto", producto);
		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNoCosecha", flagNoCosecha);

		// q.setParameterList("finca", fincas);
		// execute stored procedure and get list result
		List l = q.list();
		List<VariacionPrecioCultivoDTO> variacionPrecio = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			variacionPrecio = new ArrayList<VariacionPrecioCultivoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				VariacionPrecioCultivoDTO variacionPrecioPromedioDTOA = new VariacionPrecioCultivoDTO();

				String nomCompania = (String) row[0];
				Integer anio = (Integer) row[1];
				Integer mes = (Integer) row[2];
				Integer semana = (Integer) row[3];
				String nombreUdadMed = (String) row[4];
				BigDecimal cantidadCosechada = (BigDecimal) row[5];
				BigDecimal costoTotal = (BigDecimal) row[6];
				BigDecimal precioSemana = (BigDecimal) row[7];
				BigDecimal precioMes = (BigDecimal) row[8];
				variacionPrecioPromedioDTOA.setAnio(anio);
				variacionPrecioPromedioDTOA.setNomCompania(nomCompania);
				variacionPrecioPromedioDTOA.setMes(mes);
				variacionPrecioPromedioDTOA.setSemana(semana);
				variacionPrecioPromedioDTOA.setNombreUdadMed(nombreUdadMed);
				variacionPrecioPromedioDTOA.setCantCosechada(cantidadCosechada);
				variacionPrecioPromedioDTOA.setCostoTotal(costoTotal);
				variacionPrecioPromedioDTOA.setPrecioSemana(precioSemana);
				variacionPrecioPromedioDTOA.setPrecioMes(precioMes);

				variacionPrecio.add(variacionPrecioPromedioDTOA);

			}
		}

		return variacionPrecio;

	}

	@Override
	public List<VariacionPrecioPromedioDTO> consultarInformeVariacionPrecioPromedio(Long compania, Date fechaInicial,
			Date fechaFinal, Long producto, String almacen, Long flagAlmacen) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_varia_preprod_dia_semana (:compania, :fechaInicial,  :fechaFinal, :producto, :almacen, :flagAlmacen)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setLong("producto", producto);
		q.setString("almacen", almacen);
		q.setLong("flagAlmacen", flagAlmacen);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<VariacionPrecioPromedioDTO> variacionPrecio = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			variacionPrecio = new ArrayList<VariacionPrecioPromedioDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				VariacionPrecioPromedioDTO variacionPrecioPromedioDTOA = new VariacionPrecioPromedioDTO();

				String nomCompania = (String) row[0];
				Integer anio = (Integer) row[1];
				String fecha = (String) row[3];
				Integer mes = (Integer) row[2];
				Integer semana = (Integer) row[4];
				BigDecimal precioSemana = (BigDecimal) row[5];
				BigDecimal precioMes = (BigDecimal) row[6];
				variacionPrecioPromedioDTOA.setAnio(anio);
				variacionPrecioPromedioDTOA.setNomCompania(nomCompania);
				variacionPrecioPromedioDTOA.setFecha(fecha);
				variacionPrecioPromedioDTOA.setMes(mes);
				variacionPrecioPromedioDTOA.setSemana(semana);
				variacionPrecioPromedioDTOA.setPrecioSemana(precioSemana);
				variacionPrecioPromedioDTOA.setPrecioMes(precioMes);

				variacionPrecio.add(variacionPrecioPromedioDTOA);

			}
		}

		return variacionPrecio;

	}

	@Override
	public List<ConsultaStockDTO> consultaStock(Long compania, String tipoProducto, Long flagTipoProducto,
			String producto, Long flagProducto, String almacen, Long flagAlmacen) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_stock_almacen (:compania, :tipoProducto,  :flagTipoProducto, :producto, :flagProducto,"
						+ ":almacen, :flagAlmacen)");

		q.setLong("compania", compania);
		q.setString("tipoProducto", tipoProducto);
		q.setLong("flagTipoProducto", flagTipoProducto);

		q.setString("producto", producto);
		q.setLong("flagProducto", flagProducto);

		q.setString("almacen", almacen);
		q.setLong("flagAlmacen", flagAlmacen);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaStockDTO> consulta = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			consulta = new ArrayList<ConsultaStockDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaStockDTO consultaStockDTO = new ConsultaStockDTO();

				String nomTipoProducto = (String) row[0];
				String codProducto = (String) row[1];
				String nomProducto = (String) row[2];
				String nomAlmacen = (String) row[3];
				BigDecimal cantidadDisponible = (BigDecimal) row[4];
				String nombreUdadMed = (String) row[5];
				String fechaMovimiento = (String) row[6];
				BigDecimal cantidadIngresada = (BigDecimal) row[7];
				BigDecimal cantidadSalida = (BigDecimal) row[8];

				consultaStockDTO.setNomTipoProducto(nomTipoProducto);
				consultaStockDTO.setCodProducto(codProducto);
				consultaStockDTO.setNomProducto(nomProducto);
				consultaStockDTO.setAlmacen(nomAlmacen);
				consultaStockDTO.setCantidadDisponible(cantidadDisponible);
				consultaStockDTO.setNombreUdadMed(nombreUdadMed);
				consultaStockDTO.setFechaMovimiento(fechaMovimiento);
				consultaStockDTO.setCantidadIngresada(cantidadIngresada);
				consultaStockDTO.setCantidadSalida(cantidadSalida);

				consulta.add(consultaStockDTO);

			}
		}

		return consulta;

	}

	@Override
	public List<IndicadorVisitasProductoresDTO> consultarInformeIndicadorVisitasProductores(Long compania,
			Date fechaInicial, Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String labor,
			Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor,
			String tenencia, Long flagTenencia, String ordenTrabajo, Long flagOrdenTrabajo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_indicador_visitas (:compania, :fechaInicial,  :fechaFinal, cultivo, flagCultivo, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia,"
						+ ":ordenTrabajo, :flagOrdenTrabajo )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("cultivo", cultivo);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("ordenTrabajo", ordenTrabajo);
		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagOrdenTrabajo", flagOrdenTrabajo);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<IndicadorVisitasProductoresDTO> programacionLabores = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			programacionLabores = new ArrayList<IndicadorVisitasProductoresDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				IndicadorVisitasProductoresDTO programacionLaboresA = new IndicadorVisitasProductoresDTO();
				String nomCompania = (String) row[0];
				BigDecimal asociacionesImpactadas = (BigDecimal) row[1];
				BigDecimal productoresImpactados = (BigDecimal) row[2];
				BigDecimal valumenProducto = (BigDecimal) row[3];
				programacionLaboresA.setNomCompania(nomCompania);
				programacionLaboresA.setAsociacionesImpactadas(asociacionesImpactadas);
				programacionLaboresA.setProductoresImpactados(productoresImpactados);
				programacionLaboresA.setValumenProducto(valumenProducto);
				programacionLabores.add(programacionLaboresA);

			}
		}

		return programacionLabores;
	}

	@Override
	public List<PyGDTO> consultarInformePyG(Long compania, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String numeroCosechas,
			Long flagNumeroCosechas) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_pyg_lote (:compania,   :zona, :flagZona,  "
				+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :numeroCosechas, :flagNumeroCosechas )");

		q.setLong("compania", compania);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("numeroCosechas", numeroCosechas);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagNumeroCosechas", flagNumeroCosechas);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<PyGDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<PyGDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				PyGDTO pyGA = new PyGDTO();
				String nombreCompania = (String) row[1];
				;
				Integer anio = (Integer) row[2];
				Integer mes = (Integer) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[6];
				String nomFinca = (String) row[7];
				String codBloque = (String) row[8];
				String loteA = (String) row[10];
				String codLabor = (String) row[20];
				String nombreLabor = (String) row[21];
				String codGrupoLabor = (String) row[22];
				String nombreGrupoLabor = (String) row[23];
				BigDecimal cantidadPago = (BigDecimal) row[17];
				BigDecimal costoTotal = (BigDecimal) row[16];
				String codUdadMedPago = (String) row[18];
				BigDecimal cantidadCos = (BigDecimal) row[12];
				BigDecimal areaCos = (BigDecimal) row[15];
				BigDecimal ingresos = (BigDecimal) row[14];
				String codUdadMedCos = (String) row[13];
				String nombreElementoCosto = (String) row[24];
				String nombreProducto = (String) row[26];
				BigDecimal numeroCosechas1 = (BigDecimal) row[27];
				String fechaUltCorte = (String) row[28];
				BigDecimal edadUltCorte = (BigDecimal) row[29];
				BigDecimal area = (BigDecimal) row[30];
				BigDecimal rendimiento = (BigDecimal) row[31];
				String variedad = (String) row[32];

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
				pyGA.setEdadUltCorte(edadUltCorte);
				pyGA.setArea(area);
				pyGA.setRendimiento(rendimiento);
				pyGA.setVariedad(variedad);
				pyG.add(pyGA);

			}
		}

		return pyG;
	}
	
	@Override
	public List<ConsultaMttoDTO> consultarMttoMaquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String propietarioEquipo, Long flagPropietarioEquipo, String equipo, Long flagEquipo, String tipoMtto, Long flagTipoMtto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_mtto_maquinaria (:compania, :fechaInicial,  :fechaFinal, :propietarioEquipo, :flagPropietarioEquipo,  "
						+ ":equipo, :flagEquipo,  :tipoMtto,  :flagTipoMtto)");
		
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("propietarioEquipo", propietarioEquipo);
		q.setString("equipo", equipo);
		q.setString("tipoMtto", tipoMtto);
		q.setLong("flagPropietarioEquipo", flagPropietarioEquipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("flagTipoMtto", flagTipoMtto);

		List l = q.list();
		List<ConsultaMttoDTO> pyG = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			pyG = new ArrayList<ConsultaMttoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaMttoDTO pyGA = new ConsultaMttoDTO();
				
				String nombreCompania = (String) row[0];
				Date fechaR = (Date) row[1];	
				Date fechaS = (Date) row[2];
				BigInteger consecutivo = (BigInteger) row[3];	
				String codEquipo = (String) row[4];		
				String nomEquipo = (String) row[5];
				String cenCosto = (String) row [6];
				String tallerMec = (String) row [7];
				BigDecimal horometroE = (BigDecimal) row [8];
				BigDecimal odometroE = (BigDecimal) row [9];
				String nomTipoMtto = (String) row[10];
				String nomPlanRevision = (String) row[11];
				String nomMotivoEntradaTaller = (String) row[12];
				String nomAgenteCausadorParada = (String) row[13];
				String duracionPrevista = (String) row[14];
				BigDecimal duracionReal = (BigDecimal) row[15];
				String codSolicitante = (String) row[16];		
				String nomSolicitante = (String) row[17];
				String codConductor = (String) row[18];
				String nomConductor = (String) row[19];
				String reporteTecnico = (String) row[20];
				String fechaTrabajoMec = (String) row[21];
				String mecanico = (String) row[22];
				String nomCeptoNomina = (String) row[23];
				String nomUdadMed = (String) row[24];
				BigDecimal cantidadMec = (BigDecimal) row[25];
				BigDecimal tarifaMec = (BigDecimal) row[26];
				BigDecimal costoTotalMec = (BigDecimal) row[27];
				String almacenSalida = (String) row[28];
				String autoriza = (String) row[29];
				String producto = (String) row[30];
				String umProducto = (String) row[31];
				BigDecimal cantidad = (BigDecimal) row[32];
				BigDecimal valorUnitario = (BigDecimal) row[33];
				BigDecimal costoTotal = (BigDecimal) row[34];
				BigInteger datManEquipo = (BigInteger) row[35];	
				String codTag = (String) row[36];
				String nomTag = (String) row[37];
				String tarea = (String) row[38];
				Integer anio = (Integer) row[39];
				String mesCorto = (String) row[40];
				String codSistemaEquipo = (String) row[41];
				String nomSistemaEquipo = (String) row[42];
				String codCompartimientoEquipo = (String) row[43];
				String nomCompartimientoEquipo = (String) row[44];
				
				pyGA.setNombreCompania(nombreCompania);
				pyGA.setFechaRegistro(fechaR);
				pyGA.setFechaRegistro2(fechaS);
				pyGA.setConsecutivo(consecutivo);
				pyGA.setCodEquipo(codEquipo);
				pyGA.setNomEquipo(nomEquipo);
				pyGA.setNomTipoMtto(nomTipoMtto);
				pyGA.setCenCosto(cenCosto);
				pyGA.setTallerMecanico(tallerMec);
				pyGA.setHorometroE(horometroE);
				pyGA.setOdometroE(odometroE);
				pyGA.setNomPlanRevision(nomPlanRevision);
				pyGA.setNomMotivoEntradaTaller(nomMotivoEntradaTaller);
				pyGA.setNomAgenteCausadorParadas(nomAgenteCausadorParada);
				pyGA.setDuracionPrevista(duracionPrevista);
				pyGA.setDuracionReal(duracionReal);
				pyGA.setNomSolicitante(nomSolicitante);
				pyGA.setCodSolicitante(codSolicitante);
				pyGA.setNomConductor(nomConductor);
				pyGA.setCodConductor(codConductor);
				pyGA.setReporteTecnico(reporteTecnico);
				pyGA.setFechaTrabajoMec(fechaTrabajoMec);
				pyGA.setMecanico(mecanico);
				pyGA.setNomCeptoNomina(nomCeptoNomina);
				pyGA.setNomUdadMed(nomUdadMed);
				pyGA.setCantidadMec(cantidadMec);
				pyGA.setTarifaMec(tarifaMec);	
				pyGA.setCostoTotalMec(costoTotalMec);
				pyGA.setAlmacenSalida(almacenSalida);
				pyGA.setAutoriza(autoriza);
				pyGA.setProducto(producto);
				pyGA.setUmProducto(umProducto);
				pyGA.setCantidad(cantidad);
				pyGA.setValorUnitario(valorUnitario);
				pyGA.setCostoTotal(costoTotal);
				pyGA.setDatMantenimientoEquipo(datManEquipo);
				pyGA.setCodTag(codTag);
				pyGA.setNomTag(nomTag);
				pyGA.setTarea(tarea);
				pyGA.setAnio(anio);
				pyGA.setMesCorto(mesCorto);
				pyGA.setCodSistemaEquipo(codSistemaEquipo);
				pyGA.setNomSistemaEquipo(nomSistemaEquipo);
				pyGA.setCodCompartimientoEquipo(codCompartimientoEquipo);
				pyGA.setCodCompartimientoEquipo(nomCompartimientoEquipo);
				
				
				pyG.add(pyGA);

			}
		}

		return pyG;
	}

	@Override
	public List<CostosTotalesDTO> consultarInformeCostosTotales(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_compania_det (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia , :numeroCosechas, :flagNumeroCosechas )");
		
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("numeroCosechas", numeroCosechas);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagNumeroCosechas", flagNumeroCosechas);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
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
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
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

				pyG.add(pyGA);

			}
		}

		return pyG;
	}

	@Override
	public List<ProntuarioLotesDTO> consultarInformeProntuarioLotes(Long compania, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String tenencia,
			Long flagTenencia) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_prontuario_lotes (:compania,   :zona, :flagZona,  "
				+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :tenencia, :flagTenencia )");

		q.setLong("compania", compania);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("tenencia", tenencia);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagTenencia", flagTenencia);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProntuarioLotesDTO> prontuarioLotes = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			prontuarioLotes = new ArrayList<ProntuarioLotesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProntuarioLotesDTO prontuarioLotesA = new ProntuarioLotesDTO();
				String codZona = (String) row[1];
				String nomFinca = (String) row[2];
				String codBloque = (String) row[3];
				String loteA = (String) row[4];
				String fechaUltCorte = (String) row[5];
				BigInteger nCortes = (BigInteger) row[6];
				BigDecimal area = (BigDecimal) row[7];
				BigDecimal tchEstimado = (BigDecimal) row[8];
				BigDecimal edadUltCorte = (BigDecimal) row[9];
				String edadHoy = (String) row[10];
				BigDecimal distSiembra = (BigDecimal) row[11];
				String fechaEstCorte = (String) row[12];
				String nomTenencia = (String) row[13];
				String zonaAgroeC = (String) row[14];
				BigDecimal tchmUltCorte = (BigDecimal) row[15];
				String variedad = (String) row[16];
				BigDecimal rendimiento = (BigDecimal) row[17];
				BigDecimal tchUltCorte = (BigDecimal) row[18];
				String fechaSiembra = (String) row[19];
				String nombreLote = (String) row[20];
				BigDecimal numPlantasActuales = (BigDecimal) row[21];

				prontuarioLotesA.setCodZona(codZona);
				prontuarioLotesA.setNomFinca(nomFinca);
				prontuarioLotesA.setNomLote(nombreLote);
				prontuarioLotesA.setCodBloque(codBloque);
				prontuarioLotesA.setLoteA(loteA);
				prontuarioLotesA.setFechaUltCorte(fechaUltCorte);
				prontuarioLotesA.setnCortes(nCortes);
				prontuarioLotesA.setArea(area);
				prontuarioLotesA.setTchEstimado(tchEstimado);
				prontuarioLotesA.setEdadUltCorte(edadUltCorte);
				prontuarioLotesA.setEdadHoy(edadHoy);
				prontuarioLotesA.setDistSiembra(distSiembra);
				prontuarioLotesA.setFechaEstCorte(fechaEstCorte);
				prontuarioLotesA.setNomTenencia(nomTenencia);
				prontuarioLotesA.setZonaAgroeC(zonaAgroeC);
				prontuarioLotesA.setTchmUltCorte(tchmUltCorte);
				prontuarioLotesA.setVariedad(variedad);
				prontuarioLotesA.setRendimiento(rendimiento);
				prontuarioLotesA.setTchUltCorte(tchUltCorte);
				prontuarioLotesA.setFechaSiembra(fechaSiembra);
				prontuarioLotesA.setNumPlantasActuales(numPlantasActuales);

				prontuarioLotes.add(prontuarioLotesA);

			}
		}

		return prontuarioLotes;
	}

	@Override
	public List<ProgramaCosechaDTO> consultarInformeProgramaCosecha(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String tenencia, Long flagTenencia) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_programa_cosecha (:compania,  :fechaInicial, :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :tenencia, :flagTenencia )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("tenencia", tenencia);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagTenencia", flagTenencia);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProgramaCosechaDTO> programaCosecha = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			programaCosecha = new ArrayList<ProgramaCosechaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgramaCosechaDTO programaCosechaA = new ProgramaCosechaDTO();
				String codZona = (String) row[1];
				String nomFinca = (String) row[2];
				String codBloque = (String) row[3];
				String loteA = (String) row[4];
				String fechaUltCorte = (String) row[5];
				BigDecimal nCortes = (BigDecimal) row[6];
				BigDecimal area = (BigDecimal) row[7];
				BigDecimal tchEstimado = (BigDecimal) row[8];
				;
				BigDecimal edadUltCorte = (BigDecimal) row[9];
				;
				Double edadHoy = (Double) row[10];
				BigDecimal distSiembra = (BigDecimal) row[11];
				;
				String fechaEstCorte = (String) row[12];
				;
				String nomTenencia = (String) row[13];
				String zonaAgroeC = (String) row[14];
				String variedad = (String) row[15];
				Double tchmEstimado = (Double) row[16];
				BigDecimal tonEstimado = (BigDecimal) row[17];
				programaCosechaA.setCodZona(codZona);
				programaCosechaA.setNomFinca(nomFinca);
				programaCosechaA.setCodBloque(codBloque);
				programaCosechaA.setLoteA(loteA);
				programaCosechaA.setFechaUltCorte(fechaUltCorte);
				programaCosechaA.setnCortes(nCortes);
				programaCosechaA.setArea(area);
				programaCosechaA.setTchEstimado(tchEstimado);
				programaCosechaA.setEdadUltCorte(edadUltCorte);
				programaCosechaA.setEdadHoy(edadHoy);
				programaCosechaA.setDistSiembra(distSiembra);
				programaCosechaA.setFechaEstCorte(fechaEstCorte);
				programaCosechaA.setNomTenencia(nomTenencia);
				programaCosechaA.setZonaAgroeC(zonaAgroeC);
				programaCosechaA.setTchmEstimado(tchmEstimado);
				programaCosechaA.setTonEstimado(tonEstimado);
				programaCosechaA.setVariedad(variedad);
				programaCosecha.add(programaCosechaA);

			}
		}

		return programaCosecha;
	}

	@Override
	public List<EstadoOrdenTrabajoDTO> consultarInformeEstadoOrdenTrabajo(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String ordenTrabajo,
			Long flagOrdenTrabajo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_estado_orden_trabajo (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia,"
						+ ":ordenTrabajo, :flagOrdenTrabajo )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("ordenTrabajo", ordenTrabajo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagOrdenTrabajo", flagOrdenTrabajo);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<EstadoOrdenTrabajoDTO> estadoOrdenTrabajo = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			estadoOrdenTrabajo = new ArrayList<EstadoOrdenTrabajoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				EstadoOrdenTrabajoDTO estadoOrdenTrabajoA = new EstadoOrdenTrabajoDTO();
				String nomCompania = (String) row[0];
				Integer anio = (Integer) row[1];
				Integer mes = (Integer) row[2];
				String estadoOt = (String) row[3];
				Integer numOt = (Integer) row[4];
				estadoOrdenTrabajoA.setNombreCompania(nomCompania);
				estadoOrdenTrabajoA.setAnio(anio);
				estadoOrdenTrabajoA.setMes(mes);
				estadoOrdenTrabajoA.setEstadoOrdenTrabajo(estadoOt);
				estadoOrdenTrabajoA.setNumOrdenTrabajo(numOt);
				estadoOrdenTrabajo.add(estadoOrdenTrabajoA);

			}
		}

		return estadoOrdenTrabajo;
	}

	@Override
	public List<AnalisisEnfermedadDTO> consultarAnalisisEnfermedad(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String enfermedad, Long flagEnfermedad) {
		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_analisis_enfermedad (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :enfermedad, :flagEnfermedad )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("enfermedad", enfermedad);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagEnfermedad", flagEnfermedad);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<AnalisisEnfermedadDTO> analisisEnfermedad = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			analisisEnfermedad = new ArrayList<AnalisisEnfermedadDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				AnalisisEnfermedadDTO analisisEnfermedadA = new AnalisisEnfermedadDTO();
				String fecha = (String) row[0];
				BigInteger mes = (BigInteger) row[1];
				BigInteger anio = (BigInteger) row[2];
				String nomEnfermedad = (String) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String codLote = (String) row[8];
				BigDecimal gradoSeveridad = (BigDecimal) row[9];
				String evolucion = (String) row[10];
				BigDecimal numCenso = (BigDecimal) row[11];
				BigDecimal linea = (BigDecimal) row[12];
				BigDecimal planta = (BigDecimal) row[13];
				Double latitud = (Double) row[14];
				Double longitud = (Double) row[15];
				analisisEnfermedadA.setFecha(fecha);
				analisisEnfermedadA.setAnio(anio);
				analisisEnfermedadA.setMes(mes);
				analisisEnfermedadA.setNombreEnfermedad(nomEnfermedad);
				analisisEnfermedadA.setCodZona(codZona);
				analisisEnfermedadA.setCodFinca(codFinca);
				analisisEnfermedadA.setNomFinca(nomFinca);
				analisisEnfermedadA.setCodBloque(codBloque);
				analisisEnfermedadA.setCodLote(codLote);
				analisisEnfermedadA.setGradoSeveridad(gradoSeveridad);
				analisisEnfermedadA.setEvolucion(evolucion);
				analisisEnfermedadA.setNumCenso(numCenso);
				analisisEnfermedadA.setLinea(linea);
				analisisEnfermedadA.setPlanta(planta);
				analisisEnfermedadA.setLatitud(latitud);
				analisisEnfermedadA.setLongitud(longitud);
				analisisEnfermedad.add(analisisEnfermedadA);

			}
		}

		return analisisEnfermedad;
	}

	@Override
	public List<AnalisisPlagaDTO> consultarAnalisisPlaga(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String plaga, Long flagPlaga) {
		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_analisis_plaga (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :plaga, :flagPlaga )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("plaga", plaga);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagPlaga", flagPlaga);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<AnalisisPlagaDTO> analisisPlaga = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			analisisPlaga = new ArrayList<AnalisisPlagaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				AnalisisPlagaDTO analisisPlagaA = new AnalisisPlagaDTO();
				String fecha = (String) row[0];
				BigInteger mes = (BigInteger) row[1];
				BigInteger anio = (BigInteger) row[2];
				String nomPlaga = (String) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String codLote = (String) row[8];
				BigDecimal cantidadIndividuo = (BigDecimal) row[9];
				BigDecimal numHoja = (BigDecimal) row[10];
				BigDecimal linea = (BigDecimal) row[11];
				BigDecimal planta = (BigDecimal) row[12];
				Double latitud = (Double) row[13];
				Double longitud = (Double) row[14];
				analisisPlagaA.setFecha(fecha);
				analisisPlagaA.setAnio(anio);
				analisisPlagaA.setMes(mes);
				analisisPlagaA.setNombrePlaga(nomPlaga);
				analisisPlagaA.setCodZona(codZona);
				analisisPlagaA.setCodFinca(codFinca);
				analisisPlagaA.setNomFinca(nomFinca);
				analisisPlagaA.setCodBloque(codBloque);
				analisisPlagaA.setCodLote(codLote);
				analisisPlagaA.setCantidadIndividuo(cantidadIndividuo);
				analisisPlagaA.setNumeroHoja(numHoja);
				analisisPlagaA.setLinea(linea);
				analisisPlagaA.setPlanta(planta);
				analisisPlagaA.setLatitud(latitud);
				analisisPlagaA.setLongitud(longitud);
				analisisPlaga.add(analisisPlagaA);

			}
		}

		return analisisPlaga;
	}

	@Override
	public List<CostosElementoCostosDTO> consultarInformeCostosElementoCostos(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_elemento_costo (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<CostosElementoCostosDTO> costosElementoCostos = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			costosElementoCostos = new ArrayList<CostosElementoCostosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosElementoCostosDTO costosElementoCostosA = new CostosElementoCostosDTO();

				String nomElementoCosto = (String) row[3];
				BigDecimal costoTotal = (BigDecimal) row[2];
				String nombreCompania = (String) row[1];
				costosElementoCostosA.setNombreCompania(nombreCompania);
				costosElementoCostosA.setCostoTotal(costoTotal);
				costosElementoCostosA.setNombreElementoCosto(nomElementoCosto);

				costosElementoCostos.add(costosElementoCostosA);

			}
		}

		return costosElementoCostos;
	}

	@Override
	public List<CostosVsIngresosCompaniaDTO> consultarInformeCostosVsIngresos(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto,
			Long flagProducto, String numeroCosechas, Long flagNumeroCosechas) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_costos_vs_ingresos_compania (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, "
						+ ":producto, :flagProducto, :numeroCosechas, :flagNumeroCosechas)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("producto", producto);
		q.setString("numeroCosechas", numeroCosechas);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagNumeroCosechas", flagNumeroCosechas);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<CostosVsIngresosCompaniaDTO> costosVsIngresosCompania = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			costosVsIngresosCompania = new ArrayList<CostosVsIngresosCompaniaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosVsIngresosCompaniaDTO CostosVsIngresosCompaniaA = new CostosVsIngresosCompaniaDTO();

				Integer anio = (Integer) row[1];
				Integer mes = (Integer) row[2];
				String nombreCompania = (String) row[3];
				BigDecimal ingresos = (BigDecimal) row[4];
				BigDecimal costoTotal = (BigDecimal) row[5];
				String anioMes = (String) row[6];
				CostosVsIngresosCompaniaA.setAnio(anio);
				CostosVsIngresosCompaniaA.setMes(mes);
				CostosVsIngresosCompaniaA.setNombreCompania(nombreCompania);
				CostosVsIngresosCompaniaA.setIngresos(ingresos);
				CostosVsIngresosCompaniaA.setCostoTotal(costoTotal);
				CostosVsIngresosCompaniaA.setAnioMes(anioMes);
				costosVsIngresosCompania.add(CostosVsIngresosCompaniaA);

			}
		}

		return costosVsIngresosCompania;
	}

	@Override
	public List<DatosProduccionDTO> consultarInformeDatosProduccion(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto,
			Long flagProducto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_datos_produccion (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
						+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
						+ ":modCosecha, :flagModCosecha,:numeroCosechas,  :flagNumeroCosechas, :producto,  :flagProducto )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("numeroCosechas", numeroCosechas);
		q.setString("producto", producto);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNumeroCosechas", flagNumeroCosechas);
		q.setLong("flagProducto", flagProducto);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<DatosProduccionDTO> datosProduccion = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			datosProduccion = new ArrayList<DatosProduccionDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DatosProduccionDTO datosProduccionA = new DatosProduccionDTO();

				Integer anio = (Integer) row[1];
				String nombreCompania = (String) row[2];
				BigDecimal cantidadCos = (BigDecimal) row[3];
				BigDecimal areaCos = (BigDecimal) row[4];
				BigDecimal cantidadCosHa = (BigDecimal) row[5];
				BigDecimal rendimiento = (BigDecimal) row[6];
				BigDecimal edadNivel4 = (BigDecimal) row[7];
				BigDecimal cantidadCosHaMes = (BigDecimal) row[8];

				datosProduccionA.setAnio(anio);
				datosProduccionA.setNombreCompania(nombreCompania);
				datosProduccionA.setCantidadCosechada(cantidadCos);
				datosProduccionA.setAreaCosechada(areaCos);
				datosProduccionA.setCantidadCosechadaHa(cantidadCosHa);
				datosProduccionA.setRendimiento(rendimiento);
				datosProduccionA.setEdadCos(edadNivel4);
				datosProduccionA.setCantidadCosechadaMes(cantidadCosHaMes);
				datosProduccion.add(datosProduccionA);

			}
		}

		return datosProduccion;

	}

	@Override
	public List<DisponibilidadHidricaDTO> consultarInformeDisponibilidadHidrica(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String infraestructura,
			Long flagInfraestructura, String sistemaRiego, Long flagSistemaRiego, Long numPlanilla) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_disponibilidad_hidrica (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, :infraestructura, "
						+ ":flagInfraestructura, :sistemaRiego, :flagSistemaRiego, :planilla )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("infraestructura", infraestructura);
		q.setString("sistemaRiego", sistemaRiego);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagInfraestructura", flagInfraestructura);
		q.setLong("flagSistemaRiego", flagSistemaRiego);
		q.setLong("planilla", numPlanilla);

		// execute stored procedure and get list result
		List l = q.list();
		List<DisponibilidadHidricaDTO> disponibilidadHidrica = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			disponibilidadHidrica = new ArrayList<DisponibilidadHidricaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DisponibilidadHidricaDTO disponibilidadHidricaA = new DisponibilidadHidricaDTO();
				String nombreCompania = (String) row[0];
				Integer anio = (Integer) row[1];
				Integer mes = (Integer) row[2];
				Date fecha = (Date) row[3];
				String codZona = (String) row[5];
				String codFinca = (String) row[6];
				String nomFinca = (String) row[7];
				String codBloque = (String) row[8];
				String codLote = (String) row[10];
				String nomLote = (String) row[11];
				String nomInfraestructura = (String) row[13];
				String nomSistemaRiego = (String) row[15];
				BigDecimal totalAreaRegada = (BigDecimal) row[16];
				BigDecimal areaRegada = (BigDecimal) row[17];
				BigDecimal caudalLote = (BigDecimal) row[18];
				String horaRiegoIni = (String) row[19];
				String horaRiegoFin = (String) row[20];
				BigDecimal horasRiego = (BigDecimal) row[21];
				BigDecimal totalHorometro = (BigDecimal) row[22];
				BigDecimal kwhInicial = (BigDecimal) row[23];
				BigDecimal kwhFinal = (BigDecimal) row[24];
				BigDecimal surcosLargos = (BigDecimal) row[25];
				BigDecimal surcosCortos = (BigDecimal) row[26];
				BigDecimal m3Totales = (BigDecimal) row[27];
				BigDecimal m3h = (BigDecimal) row[28];
				BigDecimal numeroRiegos = (BigDecimal) row[29];
				BigDecimal areaNeta = (BigDecimal) row[30];
				String mesCorto = (String) row[31];
				BigInteger datRiegoId = (BigInteger) row[32];
				BigInteger consecutivo = (BigInteger) row[33];
				String nombreLabor = (String) row[34];
				String codLabor = (String) row[35];
				BigDecimal horometroInicial = (BigDecimal) row[36];
				BigDecimal horometroFinal = (BigDecimal) row[37];
				
				disponibilidadHidricaA.setNombreCompania(nombreCompania);
				disponibilidadHidricaA.setAnio(anio);
				disponibilidadHidricaA.setMes(mes);
				disponibilidadHidricaA.setFecha(fecha);
				disponibilidadHidricaA.setCodZona(codZona);
				disponibilidadHidricaA.setCodFinca(codFinca);
				disponibilidadHidricaA.setNomFinca(nomFinca);
				disponibilidadHidricaA.setCodBloque(codBloque);
				disponibilidadHidricaA.setCodLote(codLote);
				disponibilidadHidricaA.setNomInfraestructura(nomInfraestructura);
				disponibilidadHidricaA.setNomSistemaRiego(nomSistemaRiego);
				disponibilidadHidricaA.setAreaRegada(areaRegada);
				disponibilidadHidricaA.setHorasRiego(horasRiego);
				disponibilidadHidricaA.setCaudalLote(caudalLote);
				disponibilidadHidricaA.setM3h(m3h);
				disponibilidadHidricaA.setM3Totales(m3Totales);
				disponibilidadHidricaA.setNomLote(nomLote);
				disponibilidadHidricaA.setTotalAreaRegada(totalAreaRegada);
				disponibilidadHidricaA.setHoraRiegoFin(horaRiegoFin);
				disponibilidadHidricaA.setHoraRiegoIni(horaRiegoIni);
				disponibilidadHidricaA.setTotalHorometro(totalHorometro);
				disponibilidadHidricaA.setKwhInicial(kwhInicial);
				disponibilidadHidricaA.setKwhFinal(kwhFinal);
				disponibilidadHidricaA.setSurcosLargos(surcosLargos);
				disponibilidadHidricaA.setSurcosCortos(surcosCortos);
				disponibilidadHidricaA.setNumeroRiegos(numeroRiegos);
				disponibilidadHidricaA.setAreaNeta(areaNeta);
				disponibilidadHidricaA.setMesCorto(mesCorto);
				disponibilidadHidricaA.setDatRiegoId(datRiegoId);
				disponibilidadHidricaA.setConsecutivo(consecutivo);
				disponibilidadHidricaA.setNombreLabor(nombreLabor);
				disponibilidadHidricaA.setCodLabor(codLabor);
				disponibilidadHidricaA.setHorometroInicial(horometroInicial);
				disponibilidadHidricaA.setHorometroFinal(horometroFinal);

				disponibilidadHidrica.add(disponibilidadHidricaA);

			}
		}

		return disponibilidadHidrica;

	}

	@Override
	public List<IncidenciaEnfermedadDTO> consultarInformeIncidenciaEnfermedad(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String enfermedad, Long flagEnfermedad) {
		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_incidencia_enfermedad (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :enfermedad, :flagEnfermedad )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("enfermedad", enfermedad);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagEnfermedad", flagEnfermedad);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<IncidenciaEnfermedadDTO> incidenciaEnfermedad = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			incidenciaEnfermedad = new ArrayList<IncidenciaEnfermedadDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				IncidenciaEnfermedadDTO incidenciaEnfermedadA = new IncidenciaEnfermedadDTO();
				String nomCompania = (String) row[1];
				Integer mes = (Integer) row[3];
				Integer anio = (Integer) row[2];
				String nomEnfermedad = (String) row[4];
				Integer casos = (Integer) row[5];
				BigDecimal incidenciaAcumulada = (BigDecimal) row[6];
				BigDecimal incidenciaActual = (BigDecimal) row[7];
				incidenciaEnfermedadA.setNombreCompania(nomCompania);
				incidenciaEnfermedadA.setMes(mes);
				incidenciaEnfermedadA.setAnio(anio);
				incidenciaEnfermedadA.setEnfermedad(nomEnfermedad);
				incidenciaEnfermedadA.setCasos(casos);
				incidenciaEnfermedadA.setIncidenciaAcumulada(incidenciaAcumulada);
				incidenciaEnfermedadA.setIncidenciaActual(incidenciaActual);
				incidenciaEnfermedad.add(incidenciaEnfermedadA);

			}
		}

		return incidenciaEnfermedad;
	}

	@Override
	public List<LiquidacionContratistaDTO> consultarInformeLiquidacionContratistas(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_liquidacion_contratista (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, :contratista, :flagContratista )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("contratista", contratista);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagContratista", flagContratista);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<LiquidacionContratistaDTO> liquidacionContratista = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			liquidacionContratista = new ArrayList<LiquidacionContratistaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				LiquidacionContratistaDTO liquidacionContratistaA = new LiquidacionContratistaDTO();

				Integer anio = (Integer) row[0];
				Integer mes = (Integer) row[1];
				String codContratista = (String) row[2];
				String nomContratista = (String) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String codLote = (String) row[8];
				String nomLote = (String) row[14];
				String nomLabor = (String) row[9];
				BigDecimal cantidadPago = (BigDecimal) row[10];
				String codUdadMed = (String) row[11];
				BigDecimal valorUnitario = (BigDecimal) row[12];
				BigDecimal costoTotal = (BigDecimal) row[13];
				liquidacionContratistaA.setAnio(anio);
				liquidacionContratistaA.setMes(mes);
				liquidacionContratistaA.setNomLote(nomLote);
				liquidacionContratistaA.setCodContratista(codContratista);
				liquidacionContratistaA.setNomContratista(nomContratista);
				liquidacionContratistaA.setCodZona(codZona);
				liquidacionContratistaA.setCodFinca(codFinca);
				liquidacionContratistaA.setNomFinca(nomFinca);
				liquidacionContratistaA.setCodBloque(codBloque);
				liquidacionContratistaA.setCodLote(codLote);
				liquidacionContratistaA.setNomLabor(nomLabor);
				liquidacionContratistaA.setCantidadPago(cantidadPago);
				liquidacionContratistaA.setCodUdadMed(codUdadMed);
				liquidacionContratistaA.setValorUnitario(valorUnitario);
				liquidacionContratistaA.setCostoTotal(costoTotal);
				liquidacionContratista.add(liquidacionContratistaA);
			}
		}

		return liquidacionContratista;

	}

	@Override
	public List<NominaDTO> consultarInformeNomina(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_nomina (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, "
						+ ":tenencia, :flagTenencia, :contratista, :flagContratista,"
						+ ":trabajador, :flagTrabajador )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("contratista", contratista);
		q.setString("trabajador", trabajador);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagTrabajador", flagTrabajador);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<NominaDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<NominaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				NominaDTO nominaA = new NominaDTO();
				String codTrabajador = (String) row[0];
				String nomTrabajador = (String) row[1];
				Integer Lunes = (Integer) row[2];
				Long lunes = Lunes.longValue();
				Integer Martes = (Integer) row[3];
				Long martes = Martes.longValue();
				Integer Miercoles = (Integer) row[4];
				Long miercoles = Miercoles.longValue();
				Integer Jueves = (Integer) row[5];
				Long jueves = Jueves.longValue();
				Integer Viernes = (Integer) row[6];
				Long viernes = Viernes.longValue();
				Integer Sabado = (Integer) row[7];
				Long sabado = Sabado.longValue();
				Integer Domingo = (Integer) row[8];
				Long domingo = Domingo.longValue();
				Integer Total_dias = (Integer) row[9];
				Long total_dias = Total_dias.longValue();
				BigDecimal jornal = (BigDecimal) row[10];
				BigDecimal auxTransporte = (BigDecimal) row[11];
				BigDecimal horas = (BigDecimal) row[12];
				BigDecimal hed = (BigDecimal) row[13];
				BigDecimal hedf = (BigDecimal) row[14];
				BigDecimal hen = (BigDecimal) row[15];
				BigDecimal henf = (BigDecimal) row[16];
				BigDecimal festivo = (BigDecimal) row[17];
				BigDecimal recNoct = (BigDecimal) row[18];
				BigDecimal pres = (BigDecimal) row[19];
				BigDecimal incapacidad = (BigDecimal) row[20];
				BigDecimal vacaciones = (BigDecimal) row[21];
				BigDecimal primaMedia = (BigDecimal) row[22];
				BigDecimal primaCompleta = (BigDecimal) row[23];
				BigDecimal incentivos = (BigDecimal) row[24];
				BigDecimal salario = (BigDecimal) row[25];
				BigDecimal iss = (BigDecimal) row[26];
				BigDecimal otras = (BigDecimal) row[27];
				BigDecimal totalDevengos = (BigDecimal) row[28];
				BigDecimal totalDeducciones = (BigDecimal) row[29];
				BigDecimal netoPagar = (BigDecimal) row[30];
				nominaA.setCodTrabajador(codTrabajador);
				nominaA.setNomTrabajador(nomTrabajador);
				nominaA.setLunes(lunes);
				nominaA.setMartes(martes);
				nominaA.setMiercoles(miercoles);
				nominaA.setJueves(jueves);
				nominaA.setViernes(viernes);
				nominaA.setSabados(sabado);
				nominaA.setDomingos(domingo);
				nominaA.setTotal_dias(total_dias);
				nominaA.setJornal(jornal);
				nominaA.setAuxTransporte(auxTransporte);
				nominaA.setHoras(horas);
				nominaA.setHed(hed);
				nominaA.setHedf(hedf);
				nominaA.setHen(hen);
				nominaA.setHenf(henf);
				nominaA.setFestivo(festivo);
				nominaA.setRecNoct(recNoct);
				nominaA.setPres(pres);
				nominaA.setIncapacidad(incapacidad);
				nominaA.setVacaciones(vacaciones);
				nominaA.setPrimaMedia(primaMedia);
				nominaA.setPrimaCompleta(primaCompleta);
				nominaA.setIncentivos(incentivos);
				nominaA.setSalario(salario);
				nominaA.setIss(iss);
				nominaA.setOtras(otras);
				nominaA.setTotalDevengos(totalDevengos);
				nominaA.setTotalDeducciones(totalDeducciones);
				nominaA.setNetoPagar(netoPagar);
				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	@Override
	public List<ActividadesTrabajadorDTO> consultarActividadesTrabajador(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_actividades_trabajador (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, "
						+ ":tenencia, :flagTenencia, :contratista, :flagContratista,"
						+ ":trabajador, :flagTrabajador )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("contratista", contratista);
		q.setString("trabajador", trabajador);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagTrabajador", flagTrabajador);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ActividadesTrabajadorDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<ActividadesTrabajadorDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ActividadesTrabajadorDTO nominaA = new ActividadesTrabajadorDTO();
				String codTrabajador = (String) row[0];
				String nomTrabajador = (String) row[1];
				String codLabor = (String) row[2];
				String nomLabor = (String) row[3];
				String nomEmpresa = (String) row[4];
				BigDecimal costoTotalDevengado = (BigDecimal) row[5];
				BigDecimal totalDeduccion = (BigDecimal) row[6];
				BigDecimal netoPagar = (BigDecimal) row[7];
				Integer semana = (Integer) row[8];
				String fecha = (String) row[9];
				String nomCompania = (String) row[10];
				BigDecimal auxSabado = (BigDecimal) row[11];

				nominaA.setCodTrabajador(codTrabajador);
				nominaA.setNomTrabajador(nomTrabajador);
				nominaA.setCodLabor(codLabor);
				nominaA.setNomLabor(nomLabor);
				nominaA.setNomContratista(nomEmpresa);
				nominaA.setTotalDevengado(costoTotalDevengado);
				nominaA.setTotalDeducciones(totalDeduccion);
				nominaA.setNetoPagar(netoPagar);
				nominaA.setSemana(semana);
				nominaA.setFecha(fecha);
				nominaA.setNomCompania(nomCompania);
				nominaA.setAuxSabado(auxSabado);
				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	@Override
	public List<ActividadesTrabajadorResumenDTO> consultarActividadesTrabajadorResumen(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_actividades_trabajador_resumen (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, "
						+ ":tenencia, :flagTenencia, :contratista, :flagContratista,"
						+ ":trabajador, :flagTrabajador )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("contratista", contratista);
		q.setString("trabajador", trabajador);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagTrabajador", flagTrabajador);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ActividadesTrabajadorResumenDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<ActividadesTrabajadorResumenDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ActividadesTrabajadorResumenDTO nominaA = new ActividadesTrabajadorResumenDTO();
				String codTrabajador = (String) row[0];
				String nomTrabajador = (String) row[1];
				String nomEmpresa = (String) row[2];
				BigDecimal costoTotalDevengado = (BigDecimal) row[3];
				BigDecimal totalDeduccion = (BigDecimal) row[4];
				BigDecimal netoPagar = (BigDecimal) row[5];
				Integer semana = (Integer) row[6];
				String fecha = (String) row[7];
				String nomCompania = (String) row[8];
				BigDecimal auxSabado = (BigDecimal) row[9];

				nominaA.setCodTrabajador(codTrabajador);
				nominaA.setNomTrabajador(nomTrabajador);
				nominaA.setNomContratista(nomEmpresa);
				nominaA.setTotalDevengado(costoTotalDevengado);
				nominaA.setTotalDeducciones(totalDeduccion);
				nominaA.setNetoPagar(netoPagar);
				nominaA.setSemana(semana);
				nominaA.setFecha(fecha);
				nominaA.setNomCompania(nomCompania);
				nominaA.setAuxSabado(auxSabado);
				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	@Override
	public List<PrecipitacionAniosDTO> consultarInformePrecipitacionAnios(Long estPluvio) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_precipitacion_5_anios :estPluvio )");
		q.setLong("estPluvio", estPluvio);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<PrecipitacionAniosDTO> precipitacionAnios = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			precipitacionAnios = new ArrayList<PrecipitacionAniosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				PrecipitacionAniosDTO precipitacionAniosA = new PrecipitacionAniosDTO();
				Integer mes = (Integer) row[0];
				String nomCompania = (String) row[2];
				BigDecimal lluviaActual = (BigDecimal) row[3];
				BigDecimal lluviaActualMenos1 = (BigDecimal) row[4];
				BigDecimal lluviaActualMenos2 = (BigDecimal) row[5];
				BigDecimal lluviaActualMenos3 = (BigDecimal) row[6];
				BigDecimal lluviaActualMenos4 = (BigDecimal) row[7];

				precipitacionAniosA.setMes(mes);
				precipitacionAniosA.setNombreCompania(nomCompania);
				precipitacionAniosA.setLluviaActual(lluviaActual);
				precipitacionAniosA.setLluviaActualMenos1(lluviaActualMenos1);
				precipitacionAniosA.setLluviaActualMenos2(lluviaActualMenos2);
				precipitacionAniosA.setLluviaActualMenos3(lluviaActualMenos3);
				precipitacionAniosA.setLluviaActualMenos4(lluviaActualMenos4);
				precipitacionAnios.add(precipitacionAniosA);

			}
		}

		return precipitacionAnios;

	}

	@Override
	public List<ProduccionAniosDTO> consultarInformeProduccionAnios(Long compania, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia, String modCosecha,
			Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto, Long flagProducto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_produccion_5_anios (:compania, :zona, :flagZona,  "
				+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
				+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
				+ ":modCosecha, :flagModCosecha,:numeroCosechas,  :flagNumeroCosechas, :producto,  :flagProducto )");

		q.setLong("compania", compania);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("numeroCosechas", numeroCosechas);
		q.setString("producto", producto);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNumeroCosechas", flagNumeroCosechas);
		q.setLong("flagProducto", flagProducto);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProduccionAniosDTO> produccionAnios = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			produccionAnios = new ArrayList<ProduccionAniosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProduccionAniosDTO produccionAniosA = new ProduccionAniosDTO();
				Integer mes = (Integer) row[0];
				String nomCompania = (String) row[2];
				BigDecimal produccionActual = (BigDecimal) row[3];
				BigDecimal produccionActualMenos1 = (BigDecimal) row[4];
				BigDecimal produccionActualMenos2 = (BigDecimal) row[5];
				BigDecimal produccionActualMenos3 = (BigDecimal) row[6];
				BigDecimal produccionActualMenos4 = (BigDecimal) row[7];

				produccionAniosA.setMes(mes);
				produccionAniosA.setNombreCompania(nomCompania);
				produccionAniosA.setTonActual(produccionActual);
				produccionAniosA.setTonActualMenos1(produccionActualMenos1);
				produccionAniosA.setTonActualMenos2(produccionActualMenos2);
				produccionAniosA.setTonActualMenos3(produccionActualMenos3);
				produccionAniosA.setTonActualMenos4(produccionActualMenos4);

				produccionAnios.add(produccionAniosA);

			}
		}

		return produccionAnios;

	}

	@Override
	public List<ProduccionVsLluviaDTO> consultarInformeProduccionLluvia(Long compania, Date fechaInicial,
			Date fechaFinal, Date fechaInicialP, Date fechaFinalP, String zona, Long flagZona, String finca,
			Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String unidadMedida,
			Long flagUnidadMedida, String tenencia, Long flagTenencia, String modCosecha, Long flagModCosecha,
			String numeroCosechas, Long flagNumeroCosechas, String producto, Long flagProducto, Long pluvio) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_produc_vs_lluvia (:compania, :fechaInicial,  :fechaFinal, "
				+ ":fechaInicialP, :fechaFinalP, :zona, :flagZona,  "
				+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
				+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
				+ ":modCosecha, :flagModCosecha,:numeroCosechas,  :flagNumeroCosechas, :producto,  :flagProducto,"
				+ ":pluvio )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setDate("fechaInicialP", fechaInicialP);
		q.setDate("fechaFinalP", fechaFinalP);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("numeroCosechas", numeroCosechas);
		q.setString("producto", producto);
		q.setLong("pluvio", pluvio);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNumeroCosechas", flagNumeroCosechas);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagProducto", flagProducto);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProduccionVsLluviaDTO> produccionVsLluvia = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			produccionVsLluvia = new ArrayList<ProduccionVsLluviaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProduccionVsLluviaDTO produccionVsLluviaA = new ProduccionVsLluviaDTO();

				Integer anio = (Integer) row[1];
				Integer mes = (Integer) row[0];
				String nombreCompania = (String) row[3];
				BigDecimal tonMes = (BigDecimal) row[4];
				BigDecimal lluviaMes = (BigDecimal) row[5];
				produccionVsLluviaA.setAnio(anio);
				produccionVsLluviaA.setMes(mes);
				produccionVsLluviaA.setNombreCompania(nombreCompania);
				produccionVsLluviaA.setToneladas(tonMes);
				produccionVsLluviaA.setLluvia(lluviaMes);
				produccionVsLluvia.add(produccionVsLluviaA);

			}
		}

		return produccionVsLluvia;

	}

	@Override
	public List<RendimientoTrabajadoresDTO> consultarInformeRendimientoTrabajadores(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_rendto_trabajadores (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, :contratista, :flagContratista )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("contratista", contratista);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagContratista", flagContratista);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<RendimientoTrabajadoresDTO> rendimientoTrabajadores = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			rendimientoTrabajadores = new ArrayList<RendimientoTrabajadoresDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				RendimientoTrabajadoresDTO rendimientoTrabajadoresA = new RendimientoTrabajadoresDTO();

				String nombreCompania = (String) row[1];
				String codTrabajador = (String) row[2];
				String nomTrabajador = (String) row[3];
				BigDecimal cantidadRend = (BigDecimal) row[4];
				rendimientoTrabajadoresA.setNombreCompania(nombreCompania);
				rendimientoTrabajadoresA.setCodTrabajador(codTrabajador);
				rendimientoTrabajadoresA.setNombreTrabajador(nomTrabajador);
				rendimientoTrabajadoresA.setCantidadRed(cantidadRend);
				rendimientoTrabajadores.add(rendimientoTrabajadoresA);

			}
		}

		return rendimientoTrabajadores;
	}

	@Override
	public List<HorasMaquinaDTO> consultarInformeHorasMaquina(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietario, Long flagPropietario,
			String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_horas_maquina_resumen (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, :propietario, :flagPropietario,"
						+ ":modeloEquipo, :flagModeloEquipo, :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("propietario", propietario);
		q.setString("modeloEquipo", modeloEquipo);
		q.setString("equipo", equipo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagPropietario", flagPropietario);
		q.setLong("flagModeloEquipo", flagModeloEquipo);
		q.setLong("flagEquipo", flagEquipo);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<HorasMaquinaDTO> horasMaquina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			horasMaquina = new ArrayList<HorasMaquinaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				HorasMaquinaDTO horasMaquinaA = new HorasMaquinaDTO();
				String codEquipo = (String) row[0];
				String nomEquipo = (String) row[1];
				Integer horas = (Integer) row[2];
				horasMaquinaA.setCodEquipo(codEquipo);
				horasMaquinaA.setNomEquipo(nomEquipo);
				horasMaquinaA.setHoras(horas);
				horasMaquina.add(horasMaquinaA);

			}
		}

		return horasMaquina;
	}

	@Override
	public List<DespachoProductoDTO> consultarInformeDespachoProducto(Long compania, Date fechaInicial, Date fechaFinal,
			String unidadMedida, Long flagUnidadMedida, String producto, Long flagProducto, String cliente,
			Long flagCliente) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_despacho_productos (:compania, :fechaInicial,  :fechaFinal,   "
				+ ":unidadMedida,  :flagUnidadMedida,  " + ":producto,  :flagProducto, :cliente, :flagCliente  )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("unidadMedida", unidadMedida);
		q.setString("producto", producto);
		q.setString("cliente", cliente);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagCliente", flagCliente);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<DespachoProductoDTO> despachoProductoDTO = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			despachoProductoDTO = new ArrayList<DespachoProductoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DespachoProductoDTO despachoProductoDTOA = new DespachoProductoDTO();

				String nombreProducto = (String) row[1];
				BigDecimal cantidadDespachada = (BigDecimal) row[2];
				String nombreCompania = (String) row[4];

				despachoProductoDTOA.setNombreProducto(nombreProducto);
				despachoProductoDTOA.setNombreCompania(nombreCompania);
				despachoProductoDTOA.setCantidadDespachada(cantidadDespachada);
				despachoProductoDTO.add(despachoProductoDTOA);

			}
		}

		return despachoProductoDTO;

	}

	@Override
	public List<DespachoProductoClienteDTO> consultarInformeDespachoProductoCliente(Long compania, Date fechaInicial,
			Date fechaFinal, String unidadMedida, Long flagUnidadMedida, String producto, Long flagProducto,
			String cliente, Long flagCliente) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_despacho_productos_cliente (:compania, :fechaInicial,  :fechaFinal,   "
						+ ":unidadMedida,  :flagUnidadMedida,  "
						+ ":producto,  :flagProducto, :cliente, :flagCliente  )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("unidadMedida", unidadMedida);
		q.setString("producto", producto);
		q.setString("cliente", cliente);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagCliente", flagCliente);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<DespachoProductoClienteDTO> DespachoProductoClienteDTO = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			DespachoProductoClienteDTO = new ArrayList<DespachoProductoClienteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DespachoProductoClienteDTO DespachoProductoClienteDTOA = new DespachoProductoClienteDTO();

				String nombreCliente = (String) row[1];
				BigDecimal cantidadDespachada = (BigDecimal) row[2];
				String nombreCompania = (String) row[4];

				DespachoProductoClienteDTOA.setNombreCliente(nombreCliente);
				DespachoProductoClienteDTOA.setNombreCompania(nombreCompania);
				DespachoProductoClienteDTOA.setCantidadDespachada(cantidadDespachada);
				DespachoProductoClienteDTO.add(DespachoProductoClienteDTOA);

			}
		}

		return DespachoProductoClienteDTO;

	}

	@Override
	public List<DistribucionAreaCultivoDTO> consultarInformeDistribuccionAreaCultivo(Long compania, String cultivo,
			Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String variedad, Long flagVariedad) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_distri_area_cultivo (:compania,  :cultivo, :flagCultivo, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :variedad, :flagVariedad)");

		q.setLong("compania", compania);
		q.setString("zona", zona);
		q.setString("cultivo", cultivo);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("variedad", variedad);
		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagVariedad", flagVariedad);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<DistribucionAreaCultivoDTO> distribucionAreaCultivo = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			distribucionAreaCultivo = new ArrayList<DistribucionAreaCultivoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DistribucionAreaCultivoDTO distribucionAreaCultivoA = new DistribucionAreaCultivoDTO();

				BigDecimal area = (BigDecimal) row[0];

				String nombreCultivo = (String) row[1];
				String nombreCompania = (String) row[2];
				BigDecimal porcArea = (BigDecimal) row[3];

				distribucionAreaCultivoA.setArea(area);
				distribucionAreaCultivoA.setCultivo(nombreCultivo);
				distribucionAreaCultivoA.setCompania(nombreCompania);
				distribucionAreaCultivoA.setPorcentajeArea(porcArea);
				distribucionAreaCultivo.add(distribucionAreaCultivoA);

			}
		}

		return distribucionAreaCultivo;
	}

	@Override
	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLote(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_cronograma_labores  (:compania,"
				+ ":fechaInicial, :fechaFinal,  :cultivo,  :flagCultivo,  :zona,"
				+ ":flagZona,  :finca,  :flagFinca,  :bloque," + ":flagBloque,  :lote,  :flagLote,  :labor,"
				+ ":flagLabor,   :unidadMedida,  :flagUnidadMedida," + ":grupoLabor,  :flagGrupoLabor,  :tenencia,"
				+ ":flagTenencia,  :cronogramaLabor,  :flagCronogramaLabor	)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cultivo", cultivo);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("unidadMedida", unidadMedida);
		q.setString("labor", labor);

		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("cronogramaLabor", cronogramaLabor);

		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);

		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagCronogramaLabor", flagCronogramaLabor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProyeccionLaboresLoteDTO> proyeccionLaboresLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			proyeccionLaboresLote = new ArrayList<ProyeccionLaboresLoteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProyeccionLaboresLoteDTO proyeccionLaboresLoteA = new ProyeccionLaboresLoteDTO();
				String nombreCompania = (String) row[0];
				String nombreSecuencia = (String) row[1];
				String nombreLabor = (String) row[2];
				String descripcion = (String) row[3];
				Date fInicial = (Date) row[4];
				Date fFinal = (Date) row[5];
				BigDecimal duracion = (BigDecimal) row[6];
				String cod_labor = (String) row[7];
				String cod_zona = (String) row[8];
				String nom_zona = (String) row[9];
				String cod_hacienda = (String) row[10];
				String nom_hacienda = (String) row[11];
				String cod_bloque = (String) row[12];
				String nom_bloque = (String) row[13];
				String cod_lote = (String) row[14];
				String nom_lote = (String) row[15];
				String nom_variedad = (String) row[16];
				String nom_etapa = (String) row[17];
				BigDecimal area_neta = (BigDecimal) row[18];
				BigDecimal numero_plantas = (BigDecimal) row[19];
				String trabajar_con_area_plantas = (String) row[20];
				String nom_udadMed = (String) row[21];

				proyeccionLaboresLoteA.setNombreCompania(nombreCompania);
				proyeccionLaboresLoteA.setNombreSecuencia(nombreSecuencia);
				proyeccionLaboresLoteA.setNombreLabor(nombreLabor);
				proyeccionLaboresLoteA.setDescripcion(descripcion);
				proyeccionLaboresLoteA.setFechaInicial(fInicial);
				proyeccionLaboresLoteA.setFechaFinal(fFinal);
				proyeccionLaboresLoteA.setDuracion(duracion);
				proyeccionLaboresLoteA.setCod_labor(cod_labor);
				proyeccionLaboresLoteA.setCod_zona(cod_zona);
				proyeccionLaboresLoteA.setNom_zona(nom_zona);
				proyeccionLaboresLoteA.setCod_hacienda(cod_hacienda);
				proyeccionLaboresLoteA.setNom_hacienda(nom_hacienda);
				proyeccionLaboresLoteA.setCod_bloque(cod_bloque);
				proyeccionLaboresLoteA.setNom_bloque(nom_bloque);
				proyeccionLaboresLoteA.setCod_lote(cod_lote);
				proyeccionLaboresLoteA.setNom_lote(nom_lote);
				proyeccionLaboresLoteA.setNom_variedad(nom_variedad);
				proyeccionLaboresLoteA.setNom_etapa(nom_etapa);
				proyeccionLaboresLoteA.setArea_neta(area_neta);
				proyeccionLaboresLoteA.setNumero_plantas(numero_plantas);
				proyeccionLaboresLoteA.setTrabajar_con_area_plantas(trabajar_con_area_plantas);
				proyeccionLaboresLoteA.setNomUdadMed(nom_udadMed);

				proyeccionLaboresLote.add(proyeccionLaboresLoteA);

			}
		}

		return proyeccionLaboresLote;
	}

	@Override
	public List<NominaDetalladaDTO> consultarInformeNominaDetallada(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador, String tipoTransaccion, Long planilla, Long concepto, String flagConcepto,
			String origen, String tipoPersonal) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_nomina_detallada (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, "
						+ ":tenencia, :flagTenencia, :contratista, :flagContratista, :trabajador, :flagTrabajador, "
						+ ":tipoTransaccion, :planilla, :concepto, :flagconcepto, :origen, :tipoPersonal )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("contratista", contratista);
		q.setString("trabajador", trabajador);
		q.setString("tipoTransaccion", tipoTransaccion);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagTrabajador", flagTrabajador);
		q.setLong("planilla", planilla);
		q.setLong("concepto", concepto);
		q.setString("flagconcepto", flagConcepto);
		q.setString("origen", origen);
		q.setString("tipoPersonal", tipoPersonal);

		List l = q.list();
		List<NominaDetalladaDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<NominaDetalladaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				NominaDetalladaDTO nominaA = new NominaDetalladaDTO();
				Date fechaRegistro = (Date) row[0];
				String ficha = (String) row[1];
				String cedula = (String) row[2];
				String nomTrabajador = (String) row[3];
				String cod_empresa = (String) row[4];
				String nomEmpresa = (String) row[5];
				String horaInicial = (String) row[6];
				String horaFinal = (String) row[7];
				String codLote = (String) row[8];
				String nomLote = (String) row[9];
				String codHacienda = (String) row[10];
				String nomHacienda = (String) row[11];
				String codLabor = (String) row[12];
				String nomLabor = (String) row[13];
				String codConceptoNomina = (String) row[14];
				String nomConceptoNomina = (String) row[15];
				BigDecimal cantidadPago = (BigDecimal) row[16];
				BigDecimal factorPrestacional = (BigDecimal) row[17];
				BigDecimal valorUnitario = (BigDecimal) row[18];
				BigDecimal valorTotal = (BigDecimal) row[19];
				String ubicacion = (String) row[20];
				String codigoAlternativoNivel2 = (String) row[21];
				String codigoAlternativoNivel4 = (String) row[22];

				String origenDatos = (String) row[23];
				BigDecimal areaNeta = (BigDecimal) row[24];
				String unidadPago = (String) row[25];

				/*
				 * BigDecimal cantidadAuxilioTransp = (BigDecimal) row[20];
				 * BigDecimal costoAuxilioTransp = (BigDecimal) row[21];
				 * BigDecimal cantidadAuxilioAdmon = (BigDecimal) row[22];
				 * BigDecimal costoAuxilioAdmon = (BigDecimal) row[23];
				 * BigDecimal totalDevengado = (BigDecimal) row[26]; BigDecimal
				 * prestaciones4_17 = (BigDecimal) row[27]; BigDecimal
				 * prestaciones17_66 = (BigDecimal) row[28]; BigDecimal
				 * aportesPension = (BigDecimal) row[29]; BigDecimal aportesCaja
				 * = (BigDecimal) row[30]; BigDecimal aportesArl = (BigDecimal)
				 * row[31]; BigDecimal totalGeneral = (BigDecimal) row[32];
				 * BigDecimal totalGeneralIva = (BigDecimal) row[33];
				 */
				BigInteger planilla_nomina_id= (BigInteger) row[27];
				BigInteger det_planilla_nomina_id= (BigInteger) row[28];
				BigInteger consecutivo= (BigInteger) row[29];
				String observacion= (String) row[30];
				
				
				nominaA.setFechaRegistro(fechaRegistro);
				nominaA.setFicha(ficha);
				nominaA.setCedula(cedula);
				nominaA.setTrabajador(nomTrabajador);
				nominaA.setCod_empresa(cod_empresa);
				nominaA.setNomEmpresa(nomEmpresa);
				nominaA.setHoraInicial(horaInicial);
				nominaA.setHoraFinal(horaFinal);
				nominaA.setCodLote(codLote);
				nominaA.setNomLote(nomLote);
				nominaA.setCodHacienda(codHacienda);
				nominaA.setNomHacienda(nomHacienda);
				nominaA.setCodLabor(codLabor);
				nominaA.setNomLabor(nomLabor);
				nominaA.setCodConceptoNomina(codConceptoNomina);
				nominaA.setNomConceptoNomina(nomConceptoNomina);
				nominaA.setCantidadPago(cantidadPago);
				nominaA.setFactorPrestacional(factorPrestacional);
				nominaA.setValorUnitario(valorUnitario);
				nominaA.setValorTotal(valorTotal);

				nominaA.setUbicacion(ubicacion);
				nominaA.setCodigoAlternativoNivel2(codigoAlternativoNivel2);
				nominaA.setCodigoAlternativoNivel4(codigoAlternativoNivel4);

				nominaA.setOrigenDatos(origenDatos);
				nominaA.setArea(areaNeta);
				nominaA.setUnidadPago(unidadPago);
				
				nominaA.setPlanillaNominaId(planilla_nomina_id);
				nominaA.setDetPlanillaNominaId(det_planilla_nomina_id);
				nominaA.setConsecutivo(consecutivo);
				nominaA.setObservacion(observacion);
				/*
				 * nominaA.setCantidadAuxilioTransp(cantidadAuxilioTransp);
				 * nominaA.setCostoAuxilioTransp(costoAuxilioTransp);
				 * nominaA.setCantidadAuxilioAdmon(cantidadAuxilioAdmon);
				 * nominaA.setCostoAuxilioAdmon(costoAuxilioAdmon);
				 * 
				 * nominaA.setTotalDevengado(totalDevengado);
				 * nominaA.setPrestaciones4_17(prestaciones4_17);
				 * nominaA.setPrestaciones17_66(prestaciones17_66);
				 * nominaA.setAportesPension(aportesPension);
				 * nominaA.setAportesCaja(aportesCaja);
				 * nominaA.setAportesArl(aportesArl);
				 * nominaA.setTotalGeneral(totalGeneral);
				 * nominaA.setTotalGeneralIva(totalGeneralIva);
				 */
				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	@Override
	public List<CuadroPrecipitacionDiariaDTO> consultarInformeCuandroPrecipitacionDiario(Long compania,
			Date fechaInicial, Date fechaFinal, Date fechaInicialAcumulada, Date fechaFinalAcumulada, String estPluvio,
			Long flagEstPluvio) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_precipitacion_dia (:compania,  :fechaInicial, :fechaFinal,"
				+ ":fechaInicialAcumulada, :fechaFinalAcumulada, :estPluvio, :flagEstPluvio )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setDate("fechaInicialAcumulada", fechaInicialAcumulada);
		q.setDate("fechaFinalAcumulada", fechaFinalAcumulada);
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
				BigDecimal Dia1 = (BigDecimal) row[2];
				BigDecimal Dia2 = (BigDecimal) row[3];
				BigDecimal Dia3 = (BigDecimal) row[4];
				BigDecimal Dia4 = (BigDecimal) row[5];
				BigDecimal Dia5 = (BigDecimal) row[6];
				BigDecimal Dia6 = (BigDecimal) row[7];
				BigDecimal Dia7 = (BigDecimal) row[8];
				BigDecimal Dia8 = (BigDecimal) row[9];
				BigDecimal Dia9 = (BigDecimal) row[10];
				BigDecimal Dia10 = (BigDecimal) row[11];
				BigDecimal Dia11 = (BigDecimal) row[12];
				BigDecimal Dia12 = (BigDecimal) row[13];
				BigDecimal Dia13 = (BigDecimal) row[14];
				BigDecimal Dia14 = (BigDecimal) row[15];
				BigDecimal Dia15 = (BigDecimal) row[16];
				BigDecimal Dia16 = (BigDecimal) row[17];
				BigDecimal Dia17 = (BigDecimal) row[18];
				BigDecimal Dia18 = (BigDecimal) row[19];
				BigDecimal Dia19 = (BigDecimal) row[20];
				BigDecimal Dia20 = (BigDecimal) row[21];
				BigDecimal Dia21 = (BigDecimal) row[22];
				BigDecimal Dia22 = (BigDecimal) row[23];
				BigDecimal Dia23 = (BigDecimal) row[24];
				BigDecimal Dia24 = (BigDecimal) row[25];
				BigDecimal Dia25 = (BigDecimal) row[26];
				BigDecimal Dia26 = (BigDecimal) row[27];
				BigDecimal Dia27 = (BigDecimal) row[28];
				BigDecimal Dia28 = (BigDecimal) row[29];
				BigDecimal Dia29 = (BigDecimal) row[30];
				BigDecimal Dia30 = (BigDecimal) row[31];
				BigDecimal Dia31 = (BigDecimal) row[32];
				BigDecimal TotalDias = (BigDecimal) row[33];
				BigDecimal enero = (BigDecimal) row[34];
				BigDecimal febrero = (BigDecimal) row[35];
				BigDecimal marzo = (BigDecimal) row[36];
				BigDecimal abril = (BigDecimal) row[37];
				BigDecimal mayo = (BigDecimal) row[38];
				BigDecimal junio = (BigDecimal) row[39];
				BigDecimal julio = (BigDecimal) row[40];
				BigDecimal agosto = (BigDecimal) row[41];
				BigDecimal septiembre = (BigDecimal) row[42];
				BigDecimal octubre = (BigDecimal) row[43];
				BigDecimal noviembre = (BigDecimal) row[44];
				BigDecimal diciembre = (BigDecimal) row[45];
				BigDecimal totalMes = (BigDecimal) row[46];

				pluviometriaA.setCodPluvio(codPluvio);
				pluviometriaA.setNomPluvio(nomPluvio);
				pluviometriaA.setDia1(Dia1);
				pluviometriaA.setDia2(Dia2);
				pluviometriaA.setDia3(Dia3);
				pluviometriaA.setDia4(Dia4);
				pluviometriaA.setDia5(Dia5);
				pluviometriaA.setDia6(Dia6);
				pluviometriaA.setDia7(Dia7);
				pluviometriaA.setDia8(Dia8);
				pluviometriaA.setDia9(Dia9);
				pluviometriaA.setDia10(Dia10);
				pluviometriaA.setDia11(Dia11);
				pluviometriaA.setDia12(Dia12);
				pluviometriaA.setDia13(Dia13);
				pluviometriaA.setDia14(Dia14);
				pluviometriaA.setDia15(Dia15);
				pluviometriaA.setDia16(Dia16);
				pluviometriaA.setDia17(Dia17);
				pluviometriaA.setDia18(Dia18);
				pluviometriaA.setDia19(Dia19);
				pluviometriaA.setDia20(Dia20);
				pluviometriaA.setDia21(Dia21);
				pluviometriaA.setDia22(Dia22);
				pluviometriaA.setDia23(Dia23);
				pluviometriaA.setDia24(Dia24);
				pluviometriaA.setDia25(Dia25);
				pluviometriaA.setDia26(Dia26);
				pluviometriaA.setDia27(Dia27);
				pluviometriaA.setDia28(Dia28);
				pluviometriaA.setDia29(Dia29);
				pluviometriaA.setDia30(Dia30);
				pluviometriaA.setDia31(Dia31);
				pluviometriaA.setTotalDias(TotalDias);
				pluviometriaA.setEnero(enero);
				pluviometriaA.setFebrero(febrero);
				pluviometriaA.setMarzo(marzo);
				pluviometriaA.setAbril(abril);
				pluviometriaA.setMayo(mayo);
				pluviometriaA.setJunio(junio);
				pluviometriaA.setJulio(julio);
				pluviometriaA.setAgosto(agosto);
				pluviometriaA.setSeptiembre(septiembre);
				pluviometriaA.setOctubre(octubre);
				pluviometriaA.setNoviembre(noviembre);
				pluviometriaA.setDiciembre(diciembre);
				pluviometriaA.setTotalMes(totalMes);

				pluviometria.add(pluviometriaA);

			}
		}

		return pluviometria;

	}

	@Override
	public List<AnalisisDiatraeaDTO> consultarAnalisisDiatraea(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote) {
		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_analisis_diatraea (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<AnalisisDiatraeaDTO> analisisEnfermedad = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			analisisEnfermedad = new ArrayList<AnalisisDiatraeaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				AnalisisDiatraeaDTO analisisEnfermedadA = new AnalisisDiatraeaDTO();
				Date fechaEvaluacion = (Date) row[0];
				Integer mes = (Integer) row[1];
				Integer anio = (Integer) row[2];
				String codZona = (String) row[3];
				String codFinca = (String) row[4];
				String nomFinca = (String) row[5];
				String codBloque = (String) row[6];
				String codLote = (String) row[7];
				String nomLote = (String) row[8];
				BigDecimal edadMuestra = (BigDecimal) row[9];
				BigDecimal area = (BigDecimal) row[10];
				String nomVariedad = (String) row[11];
				String nomEtapa = (String) row[12];
				Date fechaUltimoCorte = (Date) row[13];
				String evaluador = (String) row[14];
				BigDecimal numeroCanaAnal = (BigDecimal) row[15];
				BigDecimal totalEntrenudos = (BigDecimal) row[16];
				BigDecimal totalEntreDiatraea = (BigDecimal) row[17];
				BigDecimal canasConDiatrea = (BigDecimal) row[18];
				BigDecimal intenInfesDiatraea = (BigDecimal) row[19];
				BigDecimal porcInfesDiatrea = (BigDecimal) row[20];
				BigDecimal canasConValentina = (BigDecimal) row[21];
				BigDecimal totalEntrenudosValentina = (BigDecimal) row[22];
				BigDecimal intenInfestValentina = (BigDecimal) row[23];
				BigDecimal porcInfestacionValentina = (BigDecimal) row[24];
				analisisEnfermedadA.setFechaEvaluacion(fechaEvaluacion);
				analisisEnfermedadA.setMes(mes);
				analisisEnfermedadA.setAnio(anio);
				analisisEnfermedadA.setCodZona(codZona);
				analisisEnfermedadA.setCodFinca(codFinca);
				analisisEnfermedadA.setNomFinca(nomFinca);
				analisisEnfermedadA.setCodBloque(codBloque);
				analisisEnfermedadA.setCodLote(codLote);
				analisisEnfermedadA.setNomLote(nomLote);
				analisisEnfermedadA.setEdadMuestra(edadMuestra);
				analisisEnfermedadA.setArea(area);
				analisisEnfermedadA.setNomVariedad(nomVariedad);
				analisisEnfermedadA.setNomEtapa(nomEtapa);
				analisisEnfermedadA.setFechaUltimoCorte(fechaUltimoCorte);
				analisisEnfermedadA.setEvaluador(evaluador);
				analisisEnfermedadA.setNumeroCanaAnal(numeroCanaAnal);
				analisisEnfermedadA.setTotalEntrenudos(totalEntrenudos);
				analisisEnfermedadA.setTotalEntreDiatraea(totalEntreDiatraea);
				analisisEnfermedadA.setCanasConDiatrea(canasConDiatrea);
				analisisEnfermedadA.setIntenInfesDiatraea(intenInfesDiatraea);
				analisisEnfermedadA.setPorcInfesDiatrea(porcInfesDiatrea);
				analisisEnfermedadA.setCanasConValentina(canasConValentina);
				analisisEnfermedadA.setTotalEntrenudosValentina(totalEntrenudosValentina);
				analisisEnfermedadA.setIntenInfestValentina(intenInfestValentina);
				analisisEnfermedadA.setPorcInfestacionValentina(porcInfestacionValentina);
				analisisEnfermedad.add(analisisEnfermedadA);

			}
		}

		return analisisEnfermedad;
	}

	@Override
	public List<ProduccionAcumFincaDTO> consultarProduccionAcumFinca(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String cliente, Long flagCliente) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_produccion_acum_finca (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
						+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
						+ ":modCosecha, :flagModCosecha,:noCosecha,  :flagNoCosecha, :producto,  :flagProducto,"
						+ ":cliente, :flagCliente )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("noCosecha", noCosecha);
		q.setString("producto", producto);
		q.setString("cliente", cliente);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNoCosecha", flagNoCosecha);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagCliente", flagCliente);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProduccionAcumFincaDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<ProduccionAcumFincaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProduccionAcumFincaDTO materiaPrimaLoteA = new ProduccionAcumFincaDTO();

				BigDecimal anio = (BigDecimal) row[1];
				BigDecimal mes = (BigDecimal) row[2];
				String mesCorto = (String) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[6];
				String nomFinca = (String) row[7];
				String codBloque = (String) row[8];
				String nomBloque = (String) row[9];
				String codLote = (String) row[10];
				String nomLote = (String) row[11];
				BigDecimal area = (BigDecimal) row[13];
				BigDecimal cantidadCos = (BigDecimal) row[12];
				String nombreCompania = (String) row[14];
				String nombreCliente = (String) row[15];
				String nombreVariedad = (String) row[16];
				String proveedor = (String) row[17];
				BigDecimal tonHa = (BigDecimal) row[18];
				BigInteger nCosechas = (BigInteger) row[19];
				Date fechaInicio = (Date) row[20];
				Date fechaFin = (Date) row[21];
				BigDecimal edad = (BigDecimal) row[22];
				BigDecimal kilosCosechados = (BigDecimal) row[23];
				BigDecimal valorUnitarioKilo = (BigDecimal) row[24];
				BigDecimal ingresoTotal = (BigDecimal) row[25];
				Date fechaProxCorte = (Date) row[26];

				materiaPrimaLoteA.setAnio(anio);
				materiaPrimaLoteA.setMes(mes);
				materiaPrimaLoteA.setMesCorto(mesCorto);
				materiaPrimaLoteA.setCodZona(codZona);
				materiaPrimaLoteA.setCodFinca(codFinca);
				materiaPrimaLoteA.setNomFinca(nomFinca);
				materiaPrimaLoteA.setCodBloque(codBloque);
				materiaPrimaLoteA.setNomBloque(codBloque);
				materiaPrimaLoteA.setCodLote(codLote);
				materiaPrimaLoteA.setNomLote(nomLote);
				materiaPrimaLoteA.setArea(area);
				materiaPrimaLoteA.setCantidadCosechadaTon(cantidadCos);
				materiaPrimaLoteA.setNomCompania(nombreCompania);
				materiaPrimaLoteA.setNomCliente(nombreCliente);
				materiaPrimaLoteA.setNomVariedad(nombreVariedad);
				materiaPrimaLoteA.setProveedor(proveedor);
				materiaPrimaLoteA.setTonHa(tonHa);
				materiaPrimaLoteA.setnCosechas(nCosechas);
				materiaPrimaLoteA.setFechaInicio(fechaInicio);
				materiaPrimaLoteA.setFechaFin(fechaFin);
				materiaPrimaLoteA.setEdad(edad);

				materiaPrimaLoteA.setKilosCosechados(kilosCosechados);
				materiaPrimaLoteA.setValorUnitarioKilo(valorUnitarioKilo);
				materiaPrimaLoteA.setIngresoTotal(ingresoTotal);
				materiaPrimaLoteA.setFechaProxCorte(fechaProxCorte);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<MovimientoVagonCosechaDTO> consultarMovimientoVagon(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String vagon, Long flagVagon) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_movimiento_vagon (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
						+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
						+ ":modCosecha, :flagModCosecha,:noCosecha,  :flagNoCosecha, :producto,  :flagProducto,"
						+ ":vagon, :flagVagon )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("noCosecha", noCosecha);
		q.setString("producto", producto);
		q.setString("vagon", vagon);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNoCosecha", flagNoCosecha);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagVagon", flagVagon);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<MovimientoVagonCosechaDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<MovimientoVagonCosechaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				MovimientoVagonCosechaDTO materiaPrimaLoteA = new MovimientoVagonCosechaDTO();

				Integer anio = (Integer) row[1];
				Integer mes = (Integer) row[2];
				String codZona = (String) row[3];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String nomBloque = (String) row[8];
				String codLote = (String) row[9];
				String nomLote = (String) row[10];
				BigDecimal cantidadCos = (BigDecimal) row[11];
				BigDecimal area = (BigDecimal) row[13];
				String nombreCompania = (String) row[14];
				String nombreVariedad = (String) row[15];
				BigDecimal numeroCosechas = (BigDecimal) row[16];
				String Vagon = (String) row[17];
				Date fechaRegistro = (Date) row[18];
				BigDecimal viajes = (BigDecimal) row[19];

				materiaPrimaLoteA.setAnio(anio);
				materiaPrimaLoteA.setMes(mes);
				materiaPrimaLoteA.setCodZona(codZona);
				materiaPrimaLoteA.setCodFinca(codFinca);
				materiaPrimaLoteA.setNomFinca(nomFinca);
				materiaPrimaLoteA.setCodBloque(codBloque);
				materiaPrimaLoteA.setNomBloque(codBloque);
				materiaPrimaLoteA.setCodLote(codLote);
				materiaPrimaLoteA.setNomLote(nomLote);
				materiaPrimaLoteA.setArea(area);
				materiaPrimaLoteA.setCantidadCosechadaTon(cantidadCos);
				materiaPrimaLoteA.setNomCompania(nombreCompania);
				materiaPrimaLoteA.setNomVariedad(nombreVariedad);
				materiaPrimaLoteA.setNumeroCosechas(numeroCosechas);
				materiaPrimaLoteA.setVagon(Vagon);
				materiaPrimaLoteA.setFechaRegistro(fechaRegistro);
				materiaPrimaLoteA.setViajes(viajes);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<DetalleInsumosLoteDTO> consultaDetalleInsumosLoteDTO(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen,
			Date fechaInicial, Date fechaFinal) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_insumos_detalle_lote (:compania, :tipoProducto,  :flagTipoProducto, :producto, :flagProducto,"
						+ ":almacen, :flagAlmacen, :fechaInicial, :fechaFinal)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tipoProducto", tipoProducto);
		q.setLong("flagTipoProducto", flagTipoProducto);

		q.setString("producto", producto);
		q.setLong("flagProducto", flagProducto);

		q.setString("almacen", almacen);
		q.setLong("flagAlmacen", flagAlmacen);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<DetalleInsumosLoteDTO> consulta = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			consulta = new ArrayList<DetalleInsumosLoteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DetalleInsumosLoteDTO consultaStockDTO = new DetalleInsumosLoteDTO();

				String nomTipoProducto = (String) row[0];
				String codProducto = (String) row[1];
				String nomProducto = (String) row[2];
				String nomAlmacen = (String) row[3];
				String nombreUdadMed = (String) row[4];
				Date fechaMovimiento = (Date) row[5];
				BigDecimal cantidadIngresada = (BigDecimal) row[6];

				BigDecimal cantidadSalida = (BigDecimal) row[7];
				// BigDecimal cantidadDisponible = (BigDecimal) row[4];

				String lote = (String) row[9];

				consultaStockDTO.setNomTipoProducto(nomTipoProducto);
				consultaStockDTO.setCodProducto(codProducto);
				consultaStockDTO.setNomProducto(nomProducto);
				consultaStockDTO.setAlmacen(nomAlmacen);
				consultaStockDTO.setFechaMovimiento(fechaMovimiento);
				// consultaStockDTO.setCantidadDisponible(cantidadDisponible);
				consultaStockDTO.setNombreUdadMed(nombreUdadMed);
				consultaStockDTO.setLote(lote);
				consultaStockDTO.setCantidadIngresada(cantidadIngresada);
				consultaStockDTO.setCantidadSalida(cantidadSalida);

				consulta.add(consultaStockDTO);

			}
		}

		return consulta;

	}

	/*************** CONSULTAS ASISTENCIA TECNICA *************/

	@Override
	public List<VisitasTecnicoResumenDTO> consultarInformeVisitasTecnicoResumen(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String trabajador,
			Long flagTrabajador, String productor, Long flagProductor, String cultivo, Long flagCultivo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_visitas_tecnico  (:compania,"
				+ ":fechaInicial, :fechaFinal,   :zona," + ":flagZona,  :finca,  :flagFinca,  :bloque,"
				+ ":flagBloque,  :lote,  :flagLote,  :labor," + ":flagLabor,   :unidadMedida,  :flagUnidadMedida,"
				+ ":grupoLabor,  :flagGrupoLabor,  :tenencia," + ":flagTenencia, :trabajador, :flagTrabajador,"
				+ ":productor, :flagProductor, :cultivo,  :flagCultivo	)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cultivo", cultivo);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("unidadMedida", unidadMedida);
		q.setString("labor", labor);

		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("trabajador", trabajador);
		q.setString("productor", productor);

		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);

		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagTrabajador", flagTrabajador);
		q.setLong("flagProductor", flagProductor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<VisitasTecnicoResumenDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<VisitasTecnicoResumenDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				VisitasTecnicoResumenDTO reporteA = new VisitasTecnicoResumenDTO();
				String nombreCompania = (String) row[0];
				String nombreDepartamento = (String) row[1];
				String codTrabajador = (String) row[2];
				String nomTrabajador = (String) row[3];
				Integer numVisitas = (Integer) row[4];
				Integer numAsociaciones = (Integer) row[5];
				Integer numParcelasDemostrativas = (Integer) row[6];
				String productores = (String) row[7];
				String cultivos = (String) row[8];

				reporteA.setNomCompania(nombreCompania);
				reporteA.setDepartamento(nombreDepartamento);
				reporteA.setCodTrabajador(codTrabajador);
				reporteA.setNomTrabajador(nomTrabajador);
				reporteA.setNumVisitasTotales(numVisitas);
				reporteA.setNumAsociacionesVisitadas(numAsociaciones);
				reporteA.setNumParcelasDemostrativas(numParcelasDemostrativas);
				reporteA.setProductores(productores);
				reporteA.setCultivos(cultivos);

				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<VisitasTecnicoDetalladoDTO> consultarInformeVisitasTecnicoDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String trabajador,
			Long flagTrabajador, String productor, Long flagProductor, String cultivo, Long flagCultivo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_detalle_visitas_tecnico  (:compania,"
				+ ":fechaInicial, :fechaFinal,   :zona," + ":flagZona,  :finca,  :flagFinca,  :bloque,"
				+ ":flagBloque,  :lote,  :flagLote,  :labor," + ":flagLabor,   :unidadMedida,  :flagUnidadMedida,"
				+ ":grupoLabor,  :flagGrupoLabor,  :tenencia," + ":flagTenencia, :trabajador, :flagTrabajador,"
				+ ":productor, :flagProductor, :cultivo,  :flagCultivo	)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cultivo", cultivo);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("unidadMedida", unidadMedida);
		q.setString("labor", labor);

		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("trabajador", trabajador);
		q.setString("productor", productor);

		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);

		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagTrabajador", flagTrabajador);
		q.setLong("flagProductor", flagProductor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<VisitasTecnicoDetalladoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<VisitasTecnicoDetalladoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				VisitasTecnicoDetalladoDTO reporteA = new VisitasTecnicoDetalladoDTO();
				String nombreCompania = (String) row[0];
				Date fecha = (Date) row[1];
				String nombreDepartamento = (String) row[2];
				String codTrabajador = (String) row[3];
				String nomTrabajador = (String) row[4];
				String nomProductor = (String) row[5];
				String variedad = (String) row[6];
				String nomCiudad = (String) row[7];

				reporteA.setNomCompania(nombreCompania);
				reporteA.setFecha(fecha);
				reporteA.setDepartamento(nombreDepartamento);
				reporteA.setCodTrabajador(codTrabajador);
				reporteA.setNomTrabajador(nomTrabajador);
				reporteA.setProductores(nomProductor);
				reporteA.setVariedad(variedad);
				reporteA.setNomCiudad(nomCiudad);
				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<PorcentajeProduccionProductorDTO> consultarInformeDatosPorcentajeProdProductor(Long compania,
			Date fechaInicial, Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia,
			Long flagTenencia, String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas,
			String producto, Long flagProducto, String productor, Long flagProductor, String cultivo,
			Long flagCultivo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_porcen_produccion_productor (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
						+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
						+ ":modCosecha, :flagModCosecha,:numeroCosechas,  :flagNumeroCosechas, :producto,  :flagProducto, "
						+ ":productor, :flagProductor, :cultivo, :flagCultivo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("numeroCosechas", numeroCosechas);
		q.setString("producto", producto);
		q.setString("productor", productor);
		q.setString("cultivo", cultivo);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNumeroCosechas", flagNumeroCosechas);
		q.setLong("flagProducto", flagProducto);
		q.setString("productor", productor);
		q.setString("cultivo", cultivo);
		q.setLong("flagProductor", flagProductor);
		q.setLong("flagCultivo", flagCultivo);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<PorcentajeProduccionProductorDTO> datosProduccion = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			datosProduccion = new ArrayList<PorcentajeProduccionProductorDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				PorcentajeProduccionProductorDTO datosProduccionA = new PorcentajeProduccionProductorDTO();
				String nombreCompania = (String) row[2];
				Integer anio = (Integer) row[1];
				BigDecimal cantidadCosechada = (BigDecimal) row[3];
				BigDecimal areaCosechada = (BigDecimal) row[4];
				BigDecimal cantidadEstimada = (BigDecimal) row[5];
				BigDecimal porcentajeEstimado = (BigDecimal) row[6];
				BigDecimal porcentajeOtrosDestinos = (BigDecimal) row[7];
				Integer mes = (Integer) row[8];

				datosProduccionA.setAnio(anio);
				datosProduccionA.setNombreCompania(nombreCompania);
				datosProduccionA.setCantidadCosechada(cantidadCosechada);
				datosProduccionA.setAreaCosechada(areaCosechada);
				datosProduccionA.setCantidadEstimada(cantidadEstimada);
				datosProduccionA.setPorcentajeEstimado(porcentajeEstimado);
				datosProduccionA.setPorcentajeOtrosDestinos(porcentajeOtrosDestinos);
				datosProduccionA.setMes(mes);
				datosProduccion.add(datosProduccionA);
			}
		}

		return datosProduccion;

	}

	@Override
	public List<PorcentajeProveedoresAsociadosDTO> consultarInformePorcentajeTipoProdocutor(Long compania, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String cultivo, Long flagCultivo, String variedad, Long flagVariedad, String productor,
			Long flagProductor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_porcentaje_proveedores_asoc  (:compania," + ":zona,"
				+ ":flagZona,  :finca,  :flagFinca,  :bloque," + ":flagBloque,  :lote,  :flagLote, "
				+ ":cultivo, :flagCultivo, :variedad, :flagVariedad," + ":productor, :flagProductor)");
		q.setLong("compania", compania);
		q.setString("cultivo", cultivo);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("variedad", variedad);
		q.setString("productor", productor);
		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagProductor", flagProductor);
		q.setLong("flagVariedad", flagVariedad);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<PorcentajeProveedoresAsociadosDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<PorcentajeProveedoresAsociadosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				PorcentajeProveedoresAsociadosDTO reporteA = new PorcentajeProveedoresAsociadosDTO();
				String nombreCompania = (String) row[2];
				String tipoProductor = (String) row[1];
				BigDecimal area = (BigDecimal) row[0];
				BigDecimal porcArea = (BigDecimal) row[3];
				Double porcProductores = (Double) row[4];

				reporteA.setNomCompania(nombreCompania);
				reporteA.setTipoProductor(tipoProductor);
				reporteA.setArea(porcArea);
				reporteA.setPorcArea(porcArea);
				reporteA.setPorcProductores(porcProductores);
				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<HojaVidaLoteDTO> consultarInformeHojaVidaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String productor, Long flagProductor, String cultivo, Long flagCultivo, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String numeroCosechas, Long flagNumeroCosechas) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_hoja_vida_lote (:compania, :fechaInicial, :fechaFinal,"
				+ ":productor, :flagProductor, :cultivo, :flagCultivo, :zona, :flagZona,  "
				+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,"
				+ " :numeroCosechas, :flagNumeroCosechas )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("numeroCosechas", numeroCosechas);
		q.setString("cultivo", cultivo);
		q.setString("productor", productor);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagNumeroCosechas", flagNumeroCosechas);
		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagProductor", flagProductor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<HojaVidaLoteDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<HojaVidaLoteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				HojaVidaLoteDTO reporteA = new HojaVidaLoteDTO();
				String nombreCompania = (String) row[1];
				Integer anio = (Integer) row[2];
				Integer mes = (Integer) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[6];
				String nomFinca = (String) row[7];
				String codBloque = (String) row[8];
				String loteA = (String) row[10];
				String codLabor = (String) row[20];
				String nombreLabor = (String) row[21];
				String codGrupoLabor = (String) row[22];
				String nombreGrupoLabor = (String) row[23];
				BigDecimal cantidadPago = (BigDecimal) row[17];
				BigDecimal costoTotal = (BigDecimal) row[16];
				String codUdadMedPago = (String) row[18];
				BigDecimal cantidadCos = (BigDecimal) row[12];
				BigDecimal areaCos = (BigDecimal) row[15];
				BigDecimal ingresos = (BigDecimal) row[14];
				String codUdadMedCos = (String) row[13];
				String nombreElementoCosto = (String) row[24];
				String nombreProducto = (String) row[26];
				BigDecimal numeroCosechas1 = (BigDecimal) row[27];
				String fechaUltCorte = (String) row[28];
				BigDecimal edadUltCorte = (BigDecimal) row[29];
				BigDecimal area = (BigDecimal) row[30];
				BigDecimal rendimiento = (BigDecimal) row[31];
				String variedad = (String) row[32];
				String nombreProductor = (String) row[33];

				reporteA.setNombreCompania(nombreCompania);
				reporteA.setAnio(anio);
				reporteA.setMes(mes);
				reporteA.setCodZona(codZona);
				reporteA.setCodFinca(codFinca);
				reporteA.setNomFinca(nomFinca);
				reporteA.setCodBloque(codBloque);
				reporteA.setLoteA(loteA);
				reporteA.setCodLabor(codLabor);
				reporteA.setNombreLabor(nombreLabor);
				reporteA.setCodGrupoLabor(codGrupoLabor);
				reporteA.setNombreGrupoLabor(nombreGrupoLabor);
				reporteA.setCantidadPago(cantidadPago);
				reporteA.setCostoTotal(costoTotal);
				reporteA.setCodUdadMedPago(codUdadMedPago);
				reporteA.setCantidadCos(cantidadCos);
				reporteA.setAreaCos(areaCos);
				reporteA.setIngresos(ingresos);
				reporteA.setCodUdadMedCos(codUdadMedCos);
				reporteA.setNombreElementoCosto(nombreElementoCosto);
				reporteA.setNombreProducto(nombreProducto);
				reporteA.setNumeroCosechas1(numeroCosechas1);
				reporteA.setFechaUltCorte(fechaUltCorte);
				reporteA.setEdadUltCorte(edadUltCorte);
				reporteA.setArea(area);
				reporteA.setRendimiento(rendimiento);
				reporteA.setVariedad(variedad);
				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<ProduccionPalmaPesoPromedioDTO> consultarInformeProduccionPalmaPesoPromedio(Long compania,
			Date fechaInicial, Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia,
			Long flagTenencia, String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha,
			String producto, Long flagProducto, String consecutivo, Long flagConsecutivo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_produccion_peso_promedio (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
						+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
						+ ":modCosecha, :flagModCosecha,:noCosecha,  :flagNoCosecha, :producto,  :flagProducto,"
						+ ":consecutivo, :flagConsecutivo )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("noCosecha", noCosecha);
		q.setString("producto", producto);
		q.setString("consecutivo", consecutivo);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNoCosecha", flagNoCosecha);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagConsecutivo", flagConsecutivo);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProduccionPalmaPesoPromedioDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ProduccionPalmaPesoPromedioDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProduccionPalmaPesoPromedioDTO reporteA = new ProduccionPalmaPesoPromedioDTO();

				String codZona = (String) row[1];
				String codFinca = (String) row[2];
				String nomFinca = (String) row[3];
				String codBloque = (String) row[4];
				String nomBloque = (String) row[5];
				String codLote = (String) row[6];
				String nomLote = (String) row[7];
				BigDecimal area = (BigDecimal) row[8];
				BigDecimal cantRacimos = (BigDecimal) row[9];
				BigDecimal pesoPromedio = (BigDecimal) row[10];
				BigDecimal produccionLoteTon = (BigDecimal) row[11];
				BigDecimal cantidadCosechadaTon = (BigDecimal) row[12];
				BigDecimal tonHa = (BigDecimal) row[13];
				BigDecimal tonHaAnio = (BigDecimal) row[14];

				reporteA.setCodZona(codZona);
				reporteA.setCodFinca(codFinca);
				reporteA.setNomFinca(nomFinca);
				reporteA.setCodBloque(codBloque);
				reporteA.setNomBloque(nomBloque);
				reporteA.setCodLote(codLote);
				reporteA.setNomLote(nomLote);
				reporteA.setArea(area);
				reporteA.setCantRacimos(cantRacimos);
				reporteA.setPesoPromedio(pesoPromedio);
				reporteA.setProduccionLoteTon(produccionLoteTon);
				reporteA.setCantidadCosechadaTon(cantidadCosechadaTon);
				reporteA.setTonHa(tonHaAnio);
				reporteA.setTonHaAnio(tonHaAnio);
				reporte.add(reporteA);

			}
		}

		return reporte;

	}

	/************ CALCULO DE EDAD DEL LOTE ****************/

	@Override
	public Double calcularEdadLote(Date fechaActual, Long nivel4) {
		// BigDecimal edad = "0";
		Double edadFin = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_calculo_edad (:fechaActual, :nivel4)");
		q.setDate("fechaActual", fechaActual);
		q.setLong("nivel4", nivel4);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Double edad = (Double) it.next();
				edadFin = Math.round(edad * 100.0) / 100.0;

			}
		}
		return edadFin;

	}

	/************************
	 * CONSULTA DE CONSECUTIVOS DE TABLAS TRANSACCIONALES
	 *******************/

	@Override
	public long consultarConsecutivoDatEstimCosecha(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_estim_cosecha (:compania)");
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
	public long consultarConsecutivoUnicoDatPlanillaNomina(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_unido_planilla_nomina (:compania)");
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
	public long consultarConsecutivoDatPlanillaNomina(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_planilla_nomina (:compania)");
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
	public long consultarConsecutivoDatRiego(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_riego (:compania)");
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
	public long consultarConsecutivoDatServicio(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_servicio (:compania)");
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
	public long consultarConsecutivoDatAplicProducto(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_aplic_producto (:compania)");
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
	public long consultarConsecutivoDatTransProd(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_trans_prod (:compania)");
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
	public long consultarConsecutivoDatSanVeg(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_san_veg (:compania)");
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
	public long consultarConsecutivoDatPlanLabor(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_plan_labor (:compania )");
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
	public long consultarConsecutivoDatBascula() {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session
				.createSQLQuery("SELECT MAX(cosecutivo) CONSECUTIVO FROM dat_estim_cosecha GROUP BY compania)");

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
	public long consultarConsecutivoAbastecimientoCombustible(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call consec_abast_combustible (:compania)");
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

	// consultarConsecutivoDatSolicitudesMtto

	@Override
	public long consultarConsecutivoDatSolicitudesMtto(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call consec_dat_solicitud_mtto(:compania)");
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
	public long consultarConsecutivoMantenimientoMaquinaria(Long compania, String tipo_orden) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call consec_mantenimiento_equipo (:compania, :tipo_orden)");
		q.setLong("compania", compania);
		
		q.setString("tipo_orden", tipo_orden);
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

	/********************************************/

	@Override
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDes(Long compania) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		Compania companiaId = new Compania();

		SQLQuery q = session.createSQLQuery("call pr_lista_ot (:compania )");
		q.setLong("compania", compania);

		List l = q.list();
		ArrayList<ConsultaOrdenTrabajoDesDTO> consultaOrdenTrabajoDesDTOS = new ArrayList<ConsultaOrdenTrabajoDesDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaOrdenTrabajoDesDTO consultaOrdenTrabajoDesDTO = new ConsultaOrdenTrabajoDesDTO();
				BigInteger idOt = (BigInteger) row[4];
				String descripcion = (String) row[3];
				consultaOrdenTrabajoDesDTO.setPlanLaborId(idOt);
				consultaOrdenTrabajoDesDTO.setDescripcion(descripcion);

				consultaOrdenTrabajoDesDTOS.add(consultaOrdenTrabajoDesDTO);

				// consultaOtDes.add(consultaOt);

			}

		}
		return consultaOrdenTrabajoDesDTOS;

	}

	/********** Consulta de valores posibles variables sanidad vegetal ******/

	@Override
	public List<ValoresPosiblesVariablesSanidadVegetalDTO> consultarValoresPosiblesVariablesSV(Long idVariable,
			BigDecimal valorPosible, Long idAnalisis) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_valor_var_ana_suelo (:idVariable, :valorPosible,  :idAnalisis )");

		q.setLong("idVariable", idVariable);
		q.setBigDecimal("valorPosible", valorPosible);
		q.setLong("idAnalisis", idAnalisis);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ValoresPosiblesVariablesSanidadVegetalDTO> valoresPosiblesSanidadVegetal = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			valoresPosiblesSanidadVegetal = new ArrayList<ValoresPosiblesVariablesSanidadVegetalDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ValoresPosiblesVariablesSanidadVegetalDTO valoresPosiblesSanidadVegetalA = new ValoresPosiblesVariablesSanidadVegetalDTO();

				String clasificacion = (String) row[5];
				valoresPosiblesSanidadVegetalA.setClasificacion(clasificacion);
				valoresPosiblesSanidadVegetal.add(valoresPosiblesSanidadVegetalA);

			}
		}

		return valoresPosiblesSanidadVegetal;
	}

	@Override
	public String consultarFaseFenologica(Long faseFenologica, Date idFechaDescanso) {
		String fase = "";
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery("call pr_fase_fenologica (:faseFenologica,   :idFechaDescanso )");

		q.setDate("idFechaDescanso", idFechaDescanso);
		q.setLong("faseFenologica", faseFenologica);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				String faseId = (String) it.next();
				fase = faseId;
			}
		}
		return fase;

	}

	@Override
	public Long consultarFaseFenologicaId(Date idFechaDescanso) {
		Long fase = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery("call pr_fase_fenologica_id ( :idFechaDescanso )");

		q.setDate("idFechaDescanso", idFechaDescanso);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal faseId = (BigDecimal) it.next();
				fase = faseId.longValue();
			}
		}
		return fase;

	}

	/*************** consultar tarifas ******/

	@Override
	public Double consultarPrecioPromProducto(Long idProducto, Long idAlmacen, Long idCompania, Date idFecha) {
		Double precioPromProducto = 0.0;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session
				.createSQLQuery("call pr_precio_prom_producto ( :idProducto, :idAlmacen,  :idCompania, :idFecha )");

		q.setLong("idProducto", idProducto);
		q.setLong("idAlmacen", idAlmacen);
		q.setLong("idCompania", idCompania);
		q.setDate("idFecha", idFecha);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal precioPromProducto2 = (BigDecimal) it.next();
				precioPromProducto = precioPromProducto2.doubleValue();
			}
		}
		
		session.getTransaction().commit();
		session.close();
		
		return precioPromProducto;

	}

	@Override
	public BigDecimal consultarTarifaProfesion(Long idCompania, Long idContratista, Long idProfesion,
			Long idCeptoNomina, Long idUdadMed, Date idFecha) {
		BigDecimal tarifa = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session
				.createSQLQuery("call pr_tarifa_profesion (:idCompania, :idContratista,  :idProfesion, :idCeptoNomina"
						+ ", :idUdadMed, :idFecha)");

		q.setLong("idCompania", idCompania);
		q.setLong("idContratista", idContratista);
		q.setLong("idProfesion", idProfesion);
		q.setLong("idCeptoNomina", idCeptoNomina);
		q.setLong("idUdadMed", idUdadMed);
		q.setDate("idFecha", idFecha);

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
	public BigDecimal consultarTarifaLaborRendimiento(Long idCompania, Long idContratista, Long idLabor, Long idNivel2,
			Long idUdadMed, Date idFecha) {
		BigDecimal tarifa = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session
				.createSQLQuery("call pr_tarifa_labor_rendimiento (:idCompania, :idContratista,  :idLabor, :idNivel2"
						+ ", :idUdadMed, :idFecha)");

		q.setLong("idCompania", idCompania);
		q.setLong("idContratista", idContratista);
		q.setLong("idLabor", idLabor);
		q.setLong("idNivel2", idNivel2);
		q.setLong("idUdadMed", idUdadMed);
		q.setDate("idFecha", idFecha);

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
	public BigDecimal consultarTarifaLaborBonificacion(Long idCompania, Long idContratista, Long idLabor, Long idNivel2,
			Long idUdadMed, Date idFecha) {
		BigDecimal tarifa = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery(
				"call pr_bonificacion_labor_rendimiento (:idCompania, :idContratista,  :idLabor, :idNivel2"
						+ ", :idUdadMed, :idFecha)");

		q.setLong("idCompania", idCompania);
		q.setLong("idContratista", idContratista);
		q.setLong("idLabor", idLabor);
		q.setLong("idNivel2", idNivel2);
		q.setLong("idUdadMed", idUdadMed);
		q.setDate("idFecha", idFecha);

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
	public BigDecimal consultarTarifaLaborRendimientoBase(Long idCompania, Long idContratista, Long idLabor,
			Long idNivel2, Long idUdadMed, Date idFecha) {
		BigDecimal tarifa = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery(
				"call pr_rendimiento_labor_rendimiento (:idCompania, :idContratista,  :idLabor, :idNivel2"
						+ ", :idUdadMed, :idFecha)");

		q.setLong("idCompania", idCompania);
		q.setLong("idContratista", idContratista);
		q.setLong("idLabor", idLabor);
		q.setLong("idNivel2", idNivel2);
		q.setLong("idUdadMed", idUdadMed);
		q.setDate("idFecha", idFecha);

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
	public BigDecimal consultarAuxSabado(Long idCompania, Long idTrabajador, Date idFecha) {
		BigDecimal auxSabado = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery("call pr_trabajador_aux_sabado (:idCompania, :idTrabajador,   :idFecha )");

		q.setLong("idCompania", idCompania);
		q.setLong("idTrabajador", idTrabajador);
		q.setDate("idFecha", idFecha);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal auxSabado2 = (BigDecimal) it.next();
				auxSabado = auxSabado2;
			}
		}
		return auxSabado;

	}

	@Override
	public Long consultarDiaSabado(Date idFecha) {
		Long diaSabado = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery("call pr_dias_sabado (  :idFecha )");

		q.setDate("idFecha", idFecha);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Integer diaSabado2 = (Integer) it.next();
				diaSabado = diaSabado2.longValue();
			}
		}
		return diaSabado;

	}

	@Override
	public BigDecimal consultarTarifaEquipProp(Long idCompania, Long idEquipo, Long idUdadMed, Date idFecha) {
		BigDecimal tarifa = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session
				.createSQLQuery("call pr_tarifa_equip_prop (:idCompania, :idEquipo" + ", :idUdadMed, :idFecha)");

		q.setLong("idCompania", idCompania);
		q.setLong("idEquipo", idEquipo);
		q.setLong("idUdadMed", idUdadMed);
		q.setDate("idFecha", idFecha);

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
	public BigDecimal consultarTarifaContratista(Long idCompania, Long idContratista, Long idLabor, Long idServicio,
			Long idUdadMed, Date idFecha, Double edadLote, String estadoInc, Long nivel2Id, Long nivel4Id,
			String alturaMata) {
		BigDecimal tarifa = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session
				.createSQLQuery("call PR_TARIFA_CONTRATISTA ( :idCompania, :idContratista,  :idLabor, :idServicio"
						+ ", :idUdadMed, :idFecha, :edadLote, :estadoInc, :nivel2Id, :nivel4Id, :alturaMata)");

		q.setLong("idCompania", idCompania);
		q.setLong("idContratista", idContratista);
		q.setLong("idLabor", idLabor);
		q.setLong("idServicio", idServicio);
		q.setLong("idUdadMed", idUdadMed);
		q.setDate("idFecha", idFecha);
		q.setDouble("edadLote", edadLote);
		q.setString("estadoInc", estadoInc);
		q.setLong("nivel2Id", nivel2Id);
		q.setLong("nivel4Id", nivel4Id);
		q.setString("alturaMata", alturaMata);

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

	/************ Consultas DTO **************/

	@Override
	public List<ConsultaDatPlanLaborDTO> consultaDatPlanLabor() {
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_dat_plan_labor ()");
		List l = q.list();
		List<ConsultaDatPlanLaborDTO> datPlanLabor = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			datPlanLabor = new ArrayList<ConsultaDatPlanLaborDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaDatPlanLaborDTO consultaDatPlanLaborDTO = new ConsultaDatPlanLaborDTO();

				Long NPases = (Long) row[6];
				Long anio = (Long) row[2];
				BigDecimal CantidadPlan = (BigDecimal) row[14];
				Double cantidadPlan = CantidadPlan.doubleValue();
				String cierreOt = (String) row[19];
				Long compania = (Long) row[1];
				BigDecimal CostoTotalEstimado = (BigDecimal) row[15];
				Double costoTotalEstimado = CostoTotalEstimado.doubleValue();
				BigDecimal EdadPlanificacion = (BigDecimal) row[12];
				Double edadPlanificacion = EdadPlanificacion.doubleValue();
				String estado = (String) row[28];
				Date fechaCreacion = (Date) row[26];
				Date fechaModificacion = (Date) row[27];
				String idMobile = (String) row[20];
				String infoAdicional = (String) row[24];
				String infoAdicional2 = (String) row[25];
				Float latitud = (Float) row[21];
				Float longitud = (Float) row[22];
				Long nivel1Id = (Long) row[8];
				Long nivel2Id = (Long) row[9];
				Long nivel3Id = (Long) row[10];
				String observacion = (String) row[18];
				String observacionAnularReg = (String) row[30];
				Long ordenTrabajo = (Long) row[31];
				Date periodoFinal = (Date) row[4];
				Date periodoInicial = (Date) row[3];
				Long planLaborId = (Long) row[0];
				Float precision = (Float) row[23];
				Long usuarioDigitacion = (Long) row[29];
				Long contratistaId_Contratista = (Long) row[17];
				Long laborId_Labor = (Long) row[5];
				Long nivel4Id_Nivel4 = (Long) row[11];
				Long servicioId_Servicio = (Long) row[7];
				Long trabId_Trabajador = (Long) row[16];
				Long udadMedId_UdadMed = (Long) row[13];

				datPlanLabor.add(consultaDatPlanLaborDTO);

			}
		}

		return datPlanLabor;
	}

	/***********************/

	@Override
	public List<ProduccionCortesDTO> consultarInformeProduccionCortes(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto,
			Long flagProducto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_produccion_ncortes (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
						+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
						+ ":modCosecha, :flagModCosecha,:numeroCosechas,  :flagNumeroCosechas, :producto,  :flagProducto )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("numeroCosechas", numeroCosechas);
		q.setString("producto", producto);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNumeroCosechas", flagNumeroCosechas);
		q.setLong("flagProducto", flagProducto);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProduccionCortesDTO> datosProduccion = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			datosProduccion = new ArrayList<ProduccionCortesDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProduccionCortesDTO datosProduccionA = new ProduccionCortesDTO();

				String nCortes = (String) row[1];
				String nombreCompania = (String) row[2];
				BigDecimal cantidadCos = (BigDecimal) row[3];
				BigDecimal areaCos = (BigDecimal) row[4];
				BigDecimal cantidadCosHa = (BigDecimal) row[5];
				BigDecimal rendimiento = (BigDecimal) row[6];
				BigDecimal edadNivel4 = (BigDecimal) row[7];
				BigDecimal cantidadCosHaMes = (BigDecimal) row[8];

				datosProduccionA.setnCortes(nCortes);
				datosProduccionA.setNombreCompania(nombreCompania);
				datosProduccionA.setCantidadCosechada(cantidadCos);
				datosProduccionA.setAreaCosechada(areaCos);
				datosProduccionA.setCantidadCosechadaHa(cantidadCosHa);
				datosProduccionA.setRendimiento(rendimiento);
				datosProduccionA.setEdadCos(edadNivel4);
				datosProduccionA.setCantidadCosechadaMes(cantidadCosHaMes);
				datosProduccion.add(datosProduccionA);

			}
		}

		return datosProduccion;

	}

	/***************** interface ***/

	@Override
	public List<InterfaceNomina85DTO> consultarInterfaceNomina85(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_nomina_interface_8_5 (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, "
						+ ":tenencia, :flagTenencia, :contratista, :flagContratista,"
						+ ":trabajador, :flagTrabajador )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("contratista", contratista);
		q.setString("trabajador", trabajador);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagTrabajador", flagTrabajador);

		// q.setParameterList("finca", fincas);

		// CALLute stored procedure and get list result
		List l = q.list();
		List<InterfaceNomina85DTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<InterfaceNomina85DTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				InterfaceNomina85DTO nominaA = new InterfaceNomina85DTO();
				String interfaceNomina = (String) row[0];
				nominaA.setPlanoNomina(interfaceNomina);
				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	/********************* ACTUALIZACIÓN 29-01-2017 ***/

	@Override
	public List<ProgramacionSiembraCosechaDTO> consultarInformeProgramacionSiembraCosecha(Long compania,
			Long anioInicial, Long anioFinal, String productores, Long flagProductor, String variedades,
			Long flagVariedad, String supervisor, Long flagSupervisor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_programa_siembra_cosecha (:compania, :anioInicial,  :anioFinal, :productores, :flagProductor,"
						+ " :variedades, :flagVariedad, :supervisor, :flagSupervisor)");

		q.setLong("compania", compania);
		q.setLong("anioInicial", anioInicial);
		q.setLong("anioFinal", anioFinal);
		q.setString("productores", productores);
		q.setString("supervisor", supervisor);
		q.setString("variedades", variedades);
		q.setLong("flagVariedad", flagVariedad);
		q.setLong("flagSupervisor", flagSupervisor);
		q.setLong("flagProductor", flagProductor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProgramacionSiembraCosechaDTO> programacionLabores = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			programacionLabores = new ArrayList<ProgramacionSiembraCosechaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgramacionSiembraCosechaDTO programacionLaboresA = new ProgramacionSiembraCosechaDTO();

				String tecnico = (String) row[0];
				String productor = (String) row[1];
				String cedula = (String) row[2];
				String departamento = (String) row[3];
				String variedad = (String) row[4];
				String vinculado_asociacion = (String) row[5];
				BigDecimal num_plantas = (BigDecimal) row[6];
				BigDecimal area_neta = (BigDecimal) row[7];
				String fecha_siembra = (String) row[8];
				String fecha_cosecha = (String) row[9];
				String origen = (String) row[10];
				BigDecimal total_siembra = (BigDecimal) row[11];
				BigDecimal total_cosecha = (BigDecimal) row[12];
				BigDecimal sem1 = (BigDecimal) row[13];
				BigDecimal sem2 = (BigDecimal) row[14];
				BigDecimal sem3 = (BigDecimal) row[15];
				BigDecimal sem4 = (BigDecimal) row[16];
				BigDecimal sem5 = (BigDecimal) row[17];
				BigDecimal sem6 = (BigDecimal) row[18];
				BigDecimal sem7 = (BigDecimal) row[19];
				BigDecimal sem8 = (BigDecimal) row[20];
				BigDecimal sem9 = (BigDecimal) row[21];
				BigDecimal sem10 = (BigDecimal) row[22];
				BigDecimal sem11 = (BigDecimal) row[23];
				BigDecimal sem12 = (BigDecimal) row[24];
				BigDecimal sem13 = (BigDecimal) row[25];
				BigDecimal sem14 = (BigDecimal) row[26];
				BigDecimal sem15 = (BigDecimal) row[27];
				BigDecimal sem16 = (BigDecimal) row[28];
				BigDecimal sem17 = (BigDecimal) row[29];
				BigDecimal sem18 = (BigDecimal) row[30];
				BigDecimal sem19 = (BigDecimal) row[31];
				BigDecimal sem20 = (BigDecimal) row[32];
				BigDecimal sem21 = (BigDecimal) row[33];
				BigDecimal sem22 = (BigDecimal) row[34];
				BigDecimal sem23 = (BigDecimal) row[35];
				BigDecimal sem24 = (BigDecimal) row[36];
				BigDecimal sem25 = (BigDecimal) row[37];
				BigDecimal sem26 = (BigDecimal) row[38];
				BigDecimal sem27 = (BigDecimal) row[39];
				BigDecimal sem28 = (BigDecimal) row[40];
				BigDecimal sem29 = (BigDecimal) row[41];
				BigDecimal sem30 = (BigDecimal) row[42];
				BigDecimal sem31 = (BigDecimal) row[43];
				BigDecimal sem32 = (BigDecimal) row[44];
				BigDecimal sem33 = (BigDecimal) row[45];
				BigDecimal sem34 = (BigDecimal) row[46];
				BigDecimal sem35 = (BigDecimal) row[47];
				BigDecimal sem36 = (BigDecimal) row[48];
				BigDecimal sem37 = (BigDecimal) row[49];
				BigDecimal sem38 = (BigDecimal) row[50];
				BigDecimal sem39 = (BigDecimal) row[51];
				BigDecimal sem40 = (BigDecimal) row[52];
				BigDecimal sem41 = (BigDecimal) row[53];
				BigDecimal sem42 = (BigDecimal) row[54];
				BigDecimal sem43 = (BigDecimal) row[55];
				BigDecimal sem44 = (BigDecimal) row[56];
				BigDecimal sem45 = (BigDecimal) row[57];
				BigDecimal sem46 = (BigDecimal) row[58];
				BigDecimal sem47 = (BigDecimal) row[59];
				BigDecimal sem48 = (BigDecimal) row[60];
				BigDecimal sem49 = (BigDecimal) row[61];
				BigDecimal sem50 = (BigDecimal) row[62];
				BigDecimal sem51 = (BigDecimal) row[63];
				BigDecimal sem52 = (BigDecimal) row[64];

				programacionLaboresA.setTecnico(tecnico);
				programacionLaboresA.setProductor(productor);
				programacionLaboresA.setCedula(cedula);
				programacionLaboresA.setDepartamento(departamento);
				programacionLaboresA.setVariedad(variedad);
				programacionLaboresA.setVinculado_asociacion(vinculado_asociacion);
				programacionLaboresA.setNum_plantas(num_plantas);
				programacionLaboresA.setArea_neta(area_neta);
				programacionLaboresA.setFecha_siembra(fecha_siembra);
				programacionLaboresA.setFecha_cosecha(fecha_cosecha);
				programacionLaboresA.setOrigen(origen);
				programacionLaboresA.setTotal_siembra(total_siembra);
				programacionLaboresA.setTotal_cosecha(total_cosecha);
				programacionLaboresA.setSem1(sem1);
				programacionLaboresA.setSem2(sem2);
				programacionLaboresA.setSem3(sem3);
				programacionLaboresA.setSem4(sem4);
				programacionLaboresA.setSem5(sem5);
				programacionLaboresA.setSem6(sem6);
				programacionLaboresA.setSem7(sem7);
				programacionLaboresA.setSem8(sem8);
				programacionLaboresA.setSem9(sem9);
				programacionLaboresA.setSem10(sem10);
				programacionLaboresA.setSem11(sem11);
				programacionLaboresA.setSem12(sem12);
				programacionLaboresA.setSem13(sem13);
				programacionLaboresA.setSem14(sem14);
				programacionLaboresA.setSem15(sem15);
				programacionLaboresA.setSem16(sem16);
				programacionLaboresA.setSem17(sem17);
				programacionLaboresA.setSem18(sem18);
				programacionLaboresA.setSem19(sem19);
				programacionLaboresA.setSem20(sem20);
				programacionLaboresA.setSem21(sem21);
				programacionLaboresA.setSem22(sem22);
				programacionLaboresA.setSem23(sem23);
				programacionLaboresA.setSem24(sem24);
				programacionLaboresA.setSem25(sem25);
				programacionLaboresA.setSem26(sem26);
				programacionLaboresA.setSem27(sem27);
				programacionLaboresA.setSem28(sem28);
				programacionLaboresA.setSem29(sem29);
				programacionLaboresA.setSem30(sem30);
				programacionLaboresA.setSem31(sem31);
				programacionLaboresA.setSem32(sem32);
				programacionLaboresA.setSem33(sem33);
				programacionLaboresA.setSem34(sem34);
				programacionLaboresA.setSem35(sem35);
				programacionLaboresA.setSem36(sem36);
				programacionLaboresA.setSem37(sem37);
				programacionLaboresA.setSem38(sem38);
				programacionLaboresA.setSem39(sem39);
				programacionLaboresA.setSem40(sem40);
				programacionLaboresA.setSem41(sem41);
				programacionLaboresA.setSem42(sem42);
				programacionLaboresA.setSem43(sem43);
				programacionLaboresA.setSem44(sem44);
				programacionLaboresA.setSem45(sem45);
				programacionLaboresA.setSem46(sem46);
				programacionLaboresA.setSem47(sem47);
				programacionLaboresA.setSem48(sem48);
				programacionLaboresA.setSem49(sem49);
				programacionLaboresA.setSem50(sem50);
				programacionLaboresA.setSem51(sem51);
				programacionLaboresA.setSem52(sem52);

				programacionLabores.add(programacionLaboresA);

			}
		}

		return programacionLabores;
	}

	@Override
	public List<ProgramacionSiembraCosechaVariedadDTO> consultarInformeProgramacionSiembraCosechaVariedad(Long compania,
			Long anioInicial, Long anioFinal, String productor, Long flagProductor, String variedad, Long flagVariedad,
			String supervisor, Long flagSupervisor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_programa_siembra_cosecha_variedad (:compania, :anioInicial,  :anioFinal, :productor, :flagProductor,"
						+ " :variedad, :flagVariedad, :supervisor, :flagSupervisor)");

		q.setLong("compania", compania);
		q.setLong("anioInicial", anioInicial);
		q.setLong("anioFinal", anioFinal);
		q.setString("productor", productor);
		q.setString("supervisor", supervisor);
		q.setString("variedad", variedad);
		q.setLong("flagVariedad", flagVariedad);
		q.setLong("flagSupervisor", flagSupervisor);
		q.setLong("flagProductor", flagProductor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProgramacionSiembraCosechaVariedadDTO> programacionLabores = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			programacionLabores = new ArrayList<ProgramacionSiembraCosechaVariedadDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgramacionSiembraCosechaVariedadDTO programacionLaboresA = new ProgramacionSiembraCosechaVariedadDTO();
				String variedadNombre = (String) row[0];
				BigDecimal totalSiembra = (BigDecimal) row[1];
				BigDecimal totalCosecha = (BigDecimal) row[2];
				BigDecimal enero = (BigDecimal) row[3];
				BigDecimal febrero = (BigDecimal) row[4];
				BigDecimal marzo = (BigDecimal) row[5];
				BigDecimal abril = (BigDecimal) row[6];
				BigDecimal mayo = (BigDecimal) row[7];
				BigDecimal junio = (BigDecimal) row[8];
				BigDecimal julio = (BigDecimal) row[9];
				BigDecimal agosto = (BigDecimal) row[10];
				BigDecimal septiembre = (BigDecimal) row[11];
				BigDecimal octubre = (BigDecimal) row[12];
				BigDecimal noviembre = (BigDecimal) row[13];
				BigDecimal diciembre = (BigDecimal) row[14];
				String origen = (String) row[15];
				programacionLaboresA.setVariedad(variedadNombre);
				programacionLaboresA.setTotal_siembra(totalSiembra);
				programacionLaboresA.setTotal_cosecha(totalCosecha);
				programacionLaboresA.setEnero(enero);
				programacionLaboresA.setFebrero(febrero);
				programacionLaboresA.setMarzo(marzo);
				programacionLaboresA.setAbril(abril);
				programacionLaboresA.setMayo(mayo);
				programacionLaboresA.setJunio(junio);
				programacionLaboresA.setJulio(julio);
				programacionLaboresA.setAgosto(agosto);
				programacionLaboresA.setJulio(julio);
				programacionLaboresA.setAgosto(agosto);
				programacionLaboresA.setSeptiembre(septiembre);
				programacionLaboresA.setOctubre(octubre);
				programacionLaboresA.setNoviembre(noviembre);
				programacionLaboresA.setDiciembre(diciembre);
				programacionLaboresA.setOrigen(origen);

				programacionLabores.add(programacionLaboresA);

			}
		}

		return programacionLabores;
	}

	@Override
	public List<HorasMaquinaDetalladoDTO> consultarInformeHorasMaquinaDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietario,
			Long flagPropietario, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo, Long numPlanilla) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_horas_maquina (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, :propietario, :flagPropietario,"
						+ ":modeloEquipo, :flagModeloEquipo, :equipo, :flagEquipo, :planilla)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("propietario", propietario);
		q.setString("modeloEquipo", modeloEquipo);
		q.setString("equipo", equipo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagPropietario", flagPropietario);
		q.setLong("flagModeloEquipo", flagModeloEquipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("planilla", numPlanilla);

		List l = q.list();
		List<HorasMaquinaDetalladoDTO> horasMaquinaDetallado = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			horasMaquinaDetallado = new ArrayList<HorasMaquinaDetalladoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				HorasMaquinaDetalladoDTO horasMaquinaDetalladoA = new HorasMaquinaDetalladoDTO();

				Integer anio = (Integer) row[0];
				Integer mes = (Integer) row[1];
				String codEquipo = (String) row[2];
				String nomEquipo = (String) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String codLote = (String) row[8];
				String nomLote = (String) row[13];
				String nomLabor = (String) row[9];
				BigDecimal cantidadPago = (BigDecimal) row[10];
				String codUdadMed = (String) row[11];
				BigDecimal horas = (BigDecimal) row[12];
				Date fechaRegistro = (Date) row[14];
				String horaInicial = (String) row[15];
				String horaFinal = (String) row[16];
				BigDecimal horometroInicial = (BigDecimal) row[17];
				BigDecimal horometroFinal = (BigDecimal) row[18];
				String codProducto = (String) row[19];
				String nomProducto = (String) row[20];
				BigDecimal cantGalones = (BigDecimal) row[21];
				String codUdadMedIns = (String) row[22];
				String nomUdadMedIns = (String) row[23];
				BigDecimal costoCombustible = (BigDecimal) row[24];
				BigDecimal area = (BigDecimal) row[26];
				BigInteger datServicioDetId = (BigInteger) row[27];
				BigInteger consecutivo = (BigInteger) row[28];
				BigDecimal valorUnitario = (BigDecimal) row[29];
				BigDecimal costoTotal = (BigDecimal) row[30];
				String origenDatos = (String) row[31];

				horasMaquinaDetalladoA.setAnio(anio);
				horasMaquinaDetalladoA.setMes(mes);
				horasMaquinaDetalladoA.setCodEquipo(codEquipo);
				horasMaquinaDetalladoA.setNomEquipo(nomEquipo);
				horasMaquinaDetalladoA.setCodZona(codZona);
				horasMaquinaDetalladoA.setCodFinca(codFinca);
				horasMaquinaDetalladoA.setNomFinca(nomFinca);
				horasMaquinaDetalladoA.setCodBloque(codBloque);
				horasMaquinaDetalladoA.setCodLote(codLote);
				horasMaquinaDetalladoA.setNomLote(nomLote);
				horasMaquinaDetalladoA.setNomLabor(nomLabor);
				horasMaquinaDetalladoA.setCantidadPago(cantidadPago);
				horasMaquinaDetalladoA.setCodUdadMed(codUdadMed);
				horasMaquinaDetalladoA.setHoras(horas);
				horasMaquinaDetalladoA.setFechaRegistro(fechaRegistro);
				horasMaquinaDetalladoA.setHoraInicial(horaInicial);
				horasMaquinaDetalladoA.setHoraFinal(horaFinal);
				horasMaquinaDetalladoA.setHorometroInicial(horometroInicial);
				horasMaquinaDetalladoA.setHorometroFinal(horometroFinal);
				horasMaquinaDetalladoA.setCodProducto(codProducto);
				horasMaquinaDetalladoA.setNomProducto(nomProducto);
				horasMaquinaDetalladoA.setCantGalones(cantGalones);
				horasMaquinaDetalladoA.setCodUdadMedIns(codUdadMedIns);
				horasMaquinaDetalladoA.setNomUdadMedIns(nomUdadMedIns);
				horasMaquinaDetalladoA.setCostoCombustible(costoCombustible);
				horasMaquinaDetalladoA.setArea(area);
				horasMaquinaDetalladoA.setDatServicioDetId(datServicioDetId);
				horasMaquinaDetalladoA.setConsecutivo(consecutivo);
				horasMaquinaDetalladoA.setValorUnitario(valorUnitario);
				horasMaquinaDetalladoA.setCostoTotal(costoTotal);
				horasMaquinaDetalladoA.setOrigenDatos(origenDatos);
				horasMaquinaDetallado.add(horasMaquinaDetalladoA);

			}
		}

		return horasMaquinaDetallado;
	}

	@Override
	public List<DetalleInsumosMaquinariaDTO> consultaDetalleInsumosMaquinaria(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen,
			Date fechaInicial, Date fechaFinal) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_kardex_maquinaria (:compania, :tipoProducto,  :flagTipoProducto, :producto, :flagProducto,"
						+ ":almacen, :flagAlmacen, :fechaInicial, :fechaFinal)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tipoProducto", tipoProducto);
		q.setLong("flagTipoProducto", flagTipoProducto);

		q.setString("producto", producto);
		q.setLong("flagProducto", flagProducto);

		q.setString("almacen", almacen);
		q.setLong("flagAlmacen", flagAlmacen);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<DetalleInsumosMaquinariaDTO> consulta = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			consulta = new ArrayList<DetalleInsumosMaquinariaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				DetalleInsumosMaquinariaDTO consultaStockDTO = new DetalleInsumosMaquinariaDTO();

				String nomTipoProducto = (String) row[0];
				String codProducto = (String) row[1];
				String nomProducto = (String) row[2];
				String nomAlmacen = (String) row[3];
				BigDecimal cantidadDisponible = (BigDecimal) row[4];
				String nombreUdadMed = (String) row[5];
				BigDecimal cantidadIngresada = (BigDecimal) row[6];
				BigDecimal cantidadSalida = (BigDecimal) row[7];
				String lote = (String) row[8];

				consultaStockDTO.setNomTipoProducto(nomTipoProducto);
				consultaStockDTO.setCodProducto(codProducto);
				consultaStockDTO.setNomProducto(nomProducto);
				consultaStockDTO.setAlmacen(nomAlmacen);
				consultaStockDTO.setCantidadDisponible(cantidadDisponible);
				consultaStockDTO.setNombreUdadMed(nombreUdadMed);
				consultaStockDTO.setLote(lote);
				consultaStockDTO.setCantidadIngresada(cantidadIngresada);
				consultaStockDTO.setCantidadSalida(cantidadSalida);

				consulta.add(consultaStockDTO);

			}
		}

		return consulta;

	}

	@Override
	public List<ConsultaStockMaquinariaDTO> consultaStockMaquinaria(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_stock_almacen_maquinaria (:compania, :tipoProducto,  :flagTipoProducto, :producto, :flagProducto,"
						+ ":almacen, :flagAlmacen)");

		q.setLong("compania", compania);
		q.setString("tipoProducto", tipoProducto);
		q.setLong("flagTipoProducto", flagTipoProducto);

		q.setString("producto", producto);
		q.setLong("flagProducto", flagProducto);

		q.setString("almacen", almacen);
		q.setLong("flagAlmacen", flagAlmacen);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
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
				String nomAlmacen = (String) row[3];
				BigDecimal cantidadDisponible = (BigDecimal) row[4];
				String nombreUdadMed = (String) row[5];
				String fechaMovimiento = (String) row[6];
				BigDecimal cantidadIngresada = (BigDecimal) row[7];
				BigDecimal cantidadSalida = (BigDecimal) row[8];

				consultaStockDTO.setNomTipoProducto(nomTipoProducto);
				consultaStockDTO.setCodProducto(codProducto);
				consultaStockDTO.setNomProducto(nomProducto);
				consultaStockDTO.setAlmacen(nomAlmacen);
				consultaStockDTO.setCantidadDisponible(cantidadDisponible);
				consultaStockDTO.setNombreUdadMed(nombreUdadMed);
				consultaStockDTO.setFechaMovimiento(fechaMovimiento);
				consultaStockDTO.setCantidadIngresada(cantidadIngresada);
				consultaStockDTO.setCantidadSalida(cantidadSalida);

				consulta.add(consultaStockDTO);

			}
		}

		return consulta;

	}

	@Override
	public List<SolicitudesMttoEquipoDTO> consultarInformeSolciitudesMttoDet(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto, Long idMtto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("exec pr_solicitudes_mtto_equipo_detal  :compania, :fechaInicial,  :fechaFinal, :propietario, "
						+ ":flagPropietario," + " :equipo, :flagEquipo, :tipoMtto, :flagTipoMtto, :id_mtto ");

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
				BigDecimal consecutivo = (BigDecimal) row[2];
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
				String estadoOt = (String) row[48];
				
				BigDecimal  hor_dif_mtto = (BigDecimal) row[49];
				
				BigDecimal num_documento_compra = 	(BigDecimal) row[50];
				String nom_proveedor_compra = 	(String) row[51];
				BigDecimal num_factura_compra = 	(BigDecimal) row[52];
				String fecha_compra = 	(String) row[53];
				
				reporteA.setHor_dif_mtto(hor_dif_mtto);
				reporteA.setEstadoOt(estadoOt);
				reporteA.setNumDocumentoCompra(num_documento_compra);
				reporteA.setNomProveedorCompra(nom_proveedor_compra);
				reporteA.setNumFacturaCompra(num_factura_compra);
				reporteA.setFechaCompra(fecha_compra);

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

				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<ProductoresPorTecnicoDTO> consultarProductoresPorTecnico(Long compania, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_productores_por_tecnico (:compania,  :contratista, :flagContratista,"
						+ ":trabajador, :flagTrabajador )");

		q.setLong("compania", compania);
		q.setString("contratista", contratista);
		q.setString("trabajador", trabajador);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagTrabajador", flagTrabajador);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProductoresPorTecnicoDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<ProductoresPorTecnicoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProductoresPorTecnicoDTO nominaA = new ProductoresPorTecnicoDTO();
				String codProductor = (String) row[0];
				String nomProductor = (String) row[1];
				String tipoProductor = (String) row[2];
				String tipoEmpresa = (String) row[3];
				String tecnico = (String) row[4];
				String ciudad = (String) row[5];
				BigDecimal nroProductores = (BigDecimal) row[6];
				nominaA.setCodProductor(codProductor);
				nominaA.setNomProductor(nomProductor);
				nominaA.setTipoProductor(tipoProductor);
				nominaA.setTipoEmpresa(tipoEmpresa);
				nominaA.setTecnico(tecnico);
				nominaA.setCiudad(ciudad);
				nominaA.setNroProductores(nroProductores);
				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	@Override
	public List<LineaBaseProductorDTO> consultarLineaBaseProductor(Long companias, String contratista,
			Long flagContratista) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_bd_linea_productores_impacto (:companias,  :contratista, :flagContratista)");

		q.setLong("companias", companias);
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<LineaBaseProductorDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<LineaBaseProductorDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				LineaBaseProductorDTO linea = new LineaBaseProductorDTO();
				String nombreCompania = (String) row[0];
				linea.setNombreCompania(nombreCompania);
				String departamento = (String) row[1];
				linea.setDepartamento(departamento);
				String ciudad = (String) row[2];
				linea.setCiudad(ciudad);
				String productor = (String) row[3];
				linea.setProductor(productor);
				String celular = (String) row[4];
				linea.setCelular(celular);
				String asociacion = (String) row[5];
				linea.setAsociacion(asociacion);
				String tecnico = (String) row[6];
				linea.setTecnico(tecnico);
				String responsable_social = (String) row[7];
				linea.setResponsable_social(responsable_social);
				BigDecimal linea_base_id = (BigDecimal) row[8];
				linea.setLinea_base_id(linea_base_id);
				BigDecimal pers_empr_id = (BigDecimal) row[9];
				linea.setPers_empr_id(pers_empr_id);
				String prod_grupo_etnico = (String) row[10];
				linea.setProd_grupo_etnico(prod_grupo_etnico);
				String prod_otro_grupo_etnico = (String) row[11];
				linea.setProd_otro_grupo_etnico(prod_otro_grupo_etnico);
				String prod_situacion_actual = (String) row[12];
				linea.setProd_situacion_actual(prod_situacion_actual);
				String prod_nivel_educacion = (String) row[13];
				linea.setProd_nivel_educacion(prod_nivel_educacion);
				String prod_servicios_vivienda = (String) row[14];
				linea.setProd_servicios_vivienda(prod_servicios_vivienda);
				String prod_construccion_vivienda = (String) row[15];
				linea.setProd_construccion_vivienda(prod_construccion_vivienda);
				String prod_otro_construccion_vivienda = (String) row[16];
				linea.setProd_otro_construccion_vivienda(prod_otro_construccion_vivienda);
				String prod_propiedad_vivienda = (String) row[17];
				linea.setProd_propiedad_vivienda(prod_propiedad_vivienda);
				String prod_familia_no_personas_casa = (String) row[18];
				linea.setProd_familia_no_personas_casa(prod_familia_no_personas_casa);
				String prod_familia_menores_edad = (String) row[19];
				linea.setProd_familia_menores_edad(prod_familia_menores_edad);
				String prod_familia_no_hijos = (String) row[20];
				linea.setProd_familia_no_hijos(prod_familia_no_hijos);
				String prod_familia_hijos_menores_edad = (String) row[21];
				linea.setProd_familia_hijos_menores_edad(prod_familia_hijos_menores_edad);
				String prod_familia_sistema_medico = (String) row[22];
				linea.setProd_familia_sistema_medico(prod_familia_sistema_medico);
				String prod_familia_otro_sistema_medico = (String) row[23];
				linea.setProd_familia_otro_sistema_medico(prod_familia_otro_sistema_medico);
				String prod_familia_distancia_centro_salud = (String) row[24];
				linea.setProd_familia_distancia_centro_salud(prod_familia_distancia_centro_salud);
				String prod_eduacion_hijos = (String) row[25];
				linea.setProd_eduacion_hijos(prod_eduacion_hijos);
				String prod_dinero_recaudado_actividad = (String) row[26];
				linea.setProd_dinero_recaudado_actividad(prod_dinero_recaudado_actividad);
				String prod_no_meses_produccion_anual = (String) row[27];
				linea.setProd_no_meses_produccion_anual(prod_no_meses_produccion_anual);
				String prod_gasto_ingresos = (String) row[28];
				linea.setProd_gasto_ingresos(prod_gasto_ingresos);
				String prod_area_cultivada_propia = (String) row[29];
				linea.setProd_area_cultivada_propia(prod_area_cultivada_propia);
				String prod_area_cultivada_propia_m2 = (String) row[30];
				linea.setProd_area_cultivada_propia_m2(prod_area_cultivada_propia_m2);
				String prod_area_cultivada_arrendada = (String) row[31];
				linea.setProd_area_cultivada_arrendada(prod_area_cultivada_arrendada);
				String prod_area_cultivada_arrendada_m2 = (String) row[32];
				linea.setProd_area_cultivada_arrendada_m2(prod_area_cultivada_arrendada_m2);
				String prod_area_cultivada_compartida = (String) row[33];
				linea.setProd_area_cultivada_compartida(prod_area_cultivada_compartida);
				String prod_area_cultivada_compartida_m2 = (String) row[34];
				linea.setProd_area_cultivada_compartida_m2(prod_area_cultivada_compartida_m2);
				String prod_area_sin_cultivar_propia = (String) row[35];
				linea.setProd_area_sin_cultivar_propia(prod_area_sin_cultivar_propia);
				String prod_area_sin_cultivar_propia_m2 = (String) row[36];
				linea.setProd_area_sin_cultivar_propia_m2(prod_area_sin_cultivar_propia_m2);
				String prod_area_sin_cultivar_arrendada = (String) row[37];
				linea.setProd_area_sin_cultivar_arrendada(prod_area_sin_cultivar_arrendada);
				String prod_area_sin_cultivar_arrendada_m2 = (String) row[38];
				linea.setProd_area_sin_cultivar_arrendada_m2(prod_area_sin_cultivar_arrendada_m2);
				String prod_area_sin_cultivar_compartida = (String) row[39];
				linea.setProd_area_sin_cultivar_compartida(prod_area_sin_cultivar_compartida);
				String prod_area_sin_cultivar_compartida_m2 = (String) row[40];
				linea.setProd_area_sin_cultivar_compartida_m2(prod_area_sin_cultivar_compartida_m2);
				String prod_estructura_protegida = (String) row[41];
				linea.setProd_estructura_protegida(prod_estructura_protegida);
				String prod_otro_estructura_protegida = (String) row[42];
				linea.setProd_otro_estructura_protegida(prod_otro_estructura_protegida);
				String prod_empleados_actuales = (String) row[43];
				linea.setProd_empleados_actuales(prod_empleados_actuales);
				String prod_credito_financiacion_cultivo = (String) row[44];
				linea.setProd_credito_financiacion_cultivo(prod_credito_financiacion_cultivo);
				String prod_otro_credito_financiacion_cultivo = (String) row[45];
				linea.setProd_otro_credito_financiacion_cultivo(prod_otro_credito_financiacion_cultivo);
				String prod_contrato_comerciale_cliente = (String) row[46];
				linea.setProd_contrato_comerciale_cliente(prod_contrato_comerciale_cliente);
				String prod_otro_contrato_comercial_cliente = (String) row[47];
				linea.setProd_otro_contrato_comercial_cliente(prod_otro_contrato_comercial_cliente);
				String prod_asistencia_tecnica_actualmente = (String) row[48];
				linea.setProd_asistencia_tecnica_actualmente(prod_asistencia_tecnica_actualmente);
				String prod_otro_asistencia_tecnica_actualmente = (String) row[49];
				linea.setProd_otro_asistencia_tecnica_actualmente(prod_otro_asistencia_tecnica_actualmente);
				String prod_conoce_costos_produccion = (String) row[50];
				linea.setProd_conoce_costos_produccion(prod_conoce_costos_produccion);
				String prod_fondo_rotatorio = (String) row[51];
				linea.setProd_fondo_rotatorio(prod_fondo_rotatorio);
				String prod_otro_fondo_rotatorio = (String) row[52];
				linea.setProd_otro_fondo_rotatorio(prod_otro_fondo_rotatorio);
				String prod_produccion_sostenible = (String) row[53];
				linea.setProd_produccion_sostenible(prod_produccion_sostenible);
				String prod_otro_produccion_sostenible = (String) row[54];
				linea.setProd_otro_produccion_sostenible(prod_otro_produccion_sostenible);
				String prod_pertenece_proyecto_fortalecimiento = (String) row[55];
				linea.setProd_pertenece_proyecto_fortalecimiento(prod_pertenece_proyecto_fortalecimiento);
				String prod_otro_proyecto_fortalecimiento = (String) row[56];
				linea.setProd_otro_proyecto_fortalecimiento(prod_otro_proyecto_fortalecimiento);
				String prod_tiempo_venta_producto = (String) row[57];
				linea.setProd_tiempo_venta_producto(prod_tiempo_venta_producto);
				String prod_transporte_propio_producto = (String) row[58];
				linea.setProd_transporte_propio_producto(prod_transporte_propio_producto);
				String prod_otro_transporte_propio_producto = (String) row[59];
				linea.setProd_otro_transporte_propio_producto(prod_otro_transporte_propio_producto);
				String prod_productos_venta_actual = (String) row[60];
				linea.setProd_productos_venta_actual(prod_productos_venta_actual);
				String prod_donde_vende_productos = (String) row[61];
				linea.setProd_donde_vende_productos(prod_donde_vende_productos);
				String prod_condicion_vivienda_no_habitaciones = (String) row[62];
				linea.setProd_condicion_vivienda_no_habitaciones(prod_condicion_vivienda_no_habitaciones);
				String prod_condicion_vivienda_no_personas_habitacion = (String) row[63];
				linea.setProd_condicion_vivienda_no_personas_habitacion(prod_condicion_vivienda_no_personas_habitacion);
				String prod_condicion_vivienda_adultos_ninos = (String) row[64];
				linea.setProd_condicion_vivienda_adultos_ninos(prod_condicion_vivienda_adultos_ninos);
				String prod_condicion_vivienda_bano_inodoro = (String) row[65];
				linea.setProd_condicion_vivienda_bano_inodoro(prod_condicion_vivienda_bano_inodoro);
				String prod_condicion_vivienda_bano_lavamanos = (String) row[66];
				linea.setProd_condicion_vivienda_bano_lavamanos(prod_condicion_vivienda_bano_lavamanos);
				String prod_eduacion_ninos_asistencia_escuela = (String) row[67];
				linea.setProd_eduacion_ninos_asistencia_escuela(prod_eduacion_ninos_asistencia_escuela);
				String prod_eduacion_ninos_duracion_jornada_escolar = (String) row[68];
				linea.setProd_eduacion_ninos_duracion_jornada_escolar(prod_eduacion_ninos_duracion_jornada_escolar);
				String prod_eduacion_ninos_transporte_escolar = (String) row[69];
				linea.setProd_eduacion_ninos_transporte_escolar(prod_eduacion_ninos_transporte_escolar);
				String prod_eduacion_ninos_tiempo_transporte = (String) row[70];
				linea.setProd_eduacion_ninos_tiempo_transporte(prod_eduacion_ninos_tiempo_transporte);
				String prod_educacion_ninos_ninas_asistencia_escolar = (String) row[71];
				linea.setProd_educacion_ninos_ninas_asistencia_escolar(prod_educacion_ninos_ninas_asistencia_escolar);
				String prod_educacion_ninos_anios_sistema_escolar = (String) row[72];
				linea.setProd_educacion_ninos_anios_sistema_escolar(prod_educacion_ninos_anios_sistema_escolar);
				String prod_ninas_adolescentes_embarazadas = (String) row[73];
				linea.setProd_ninas_adolescentes_embarazadas(prod_ninas_adolescentes_embarazadas);
				String prod_desnutricion_infantil = (String) row[74];
				linea.setProd_desnutricion_infantil(prod_desnutricion_infantil);
				String prod_familia_acceso_salud = (String) row[75];
				linea.setProd_familia_acceso_salud(prod_familia_acceso_salud);
				BigDecimal prod_encuestador = (BigDecimal) row[76];
				linea.setProd_encuestador(prod_encuestador);
				BigDecimal consecutivo = (BigDecimal) row[77];
				linea.setConsecutivo(consecutivo);
				BigDecimal compania = (BigDecimal) row[78];
				linea.setCompania(compania);
				String estado = (String) row[79];
				linea.setEstado(estado);
				Date fecha_creacion = (Date) row[80];
				linea.setFecha_creacion(fecha_creacion);
				Date fecha_modificacion = (Date) row[81];
				linea.setFecha_modificacion(fecha_modificacion);
				BigDecimal usuario_digitacion = (BigDecimal) row[82];
				linea.setUsuario_digitacion(usuario_digitacion);
				String cultivo_variedad_prod_1 = (String) row[83];
				linea.setCultivo_variedad_prod_1(cultivo_variedad_prod_1);
				String cultivo_variedad_prod_2 = (String) row[84];
				linea.setCultivo_variedad_prod_2(cultivo_variedad_prod_2);
				String cultivo_variedad_prod_3 = (String) row[85];
				linea.setCultivo_variedad_prod_3(cultivo_variedad_prod_3);
				String cultivo_variedad_prod_4 = (String) row[86];
				linea.setCultivo_variedad_prod_4(cultivo_variedad_prod_4);
				String cultivo_variedad_prod_5 = (String) row[87];
				linea.setCultivo_variedad_prod_5(cultivo_variedad_prod_5);
				String cultivo_variedad_prod_6 = (String) row[88];
				linea.setCultivo_variedad_prod_6(cultivo_variedad_prod_6);
				String cultivo_variedad_prod_7 = (String) row[89];
				linea.setCultivo_variedad_prod_7(cultivo_variedad_prod_7);
				String cultivo_variedad_prod_8 = (String) row[90];
				linea.setCultivo_variedad_prod_8(cultivo_variedad_prod_8);
				String cultivo_variedad_prod_9 = (String) row[91];
				linea.setCultivo_variedad_prod_9(cultivo_variedad_prod_9);
				String cultivo_variedad_prod_10 = (String) row[92];
				linea.setCultivo_variedad_prod_10(cultivo_variedad_prod_10);
				String rend_cosecha_1 = (String) row[93];
				linea.setRend_cosecha_1(rend_cosecha_1);
				String rend_cosecha_2 = (String) row[94];
				linea.setRend_cosecha_2(rend_cosecha_2);
				String rend_cosecha_3 = (String) row[95];
				linea.setRend_cosecha_3(rend_cosecha_3);
				String rend_cosecha_4 = (String) row[96];
				linea.setRend_cosecha_4(rend_cosecha_4);
				String rend_cosecha_5 = (String) row[97];
				linea.setRend_cosecha_5(rend_cosecha_5);
				String rend_cosecha_6 = (String) row[98];
				linea.setRend_cosecha_6(rend_cosecha_6);
				String rend_cosecha_7 = (String) row[99];
				linea.setRend_cosecha_7(rend_cosecha_7);
				String rend_cosecha_8 = (String) row[100];
				linea.setRend_cosecha_8(rend_cosecha_8);
				String rend_cosecha_9 = (String) row[101];
				linea.setRend_cosecha_9(rend_cosecha_9);
				String rend_cosecha_10 = (String) row[102];
				linea.setRend_cosecha_10(rend_cosecha_10);
				String cultivo_variedad_venta_1 = (String) row[103];
				linea.setCultivo_variedad_venta_1(cultivo_variedad_venta_1);
				String cultivo_variedad_venta_2 = (String) row[104];
				linea.setCultivo_variedad_venta_2(cultivo_variedad_venta_2);
				String cultivo_variedad_venta_3 = (String) row[105];
				linea.setCultivo_variedad_venta_3(cultivo_variedad_venta_3);
				String cultivo_variedad_venta_4 = (String) row[106];
				linea.setCultivo_variedad_venta_4(cultivo_variedad_venta_4);
				String cultivo_variedad_venta_5 = (String) row[107];
				linea.setCultivo_variedad_venta_5(cultivo_variedad_venta_5);
				String cultivo_variedad_venta_6 = (String) row[108];
				linea.setCultivo_variedad_venta_6(cultivo_variedad_venta_6);
				String cultivo_variedad_venta_7 = (String) row[109];
				linea.setCultivo_variedad_venta_7(cultivo_variedad_venta_7);
				String cultivo_variedad_venta_8 = (String) row[110];
				linea.setCultivo_variedad_venta_8(cultivo_variedad_venta_8);
				String cultivo_variedad_venta_9 = (String) row[111];
				linea.setCultivo_variedad_venta_9(cultivo_variedad_venta_9);
				String cultivo_variedad_venta_10 = (String) row[112];
				linea.setCultivo_variedad_venta_10(cultivo_variedad_venta_10);
				String vol_venta_mensual_1 = (String) row[113];
				linea.setVol_venta_mensual_1(vol_venta_mensual_1);
				String vol_venta_mensual_2 = (String) row[114];
				linea.setVol_venta_mensual_2(vol_venta_mensual_2);
				String vol_venta_mensual_3 = (String) row[115];
				linea.setVol_venta_mensual_3(vol_venta_mensual_3);
				String vol_venta_mensual_4 = (String) row[116];
				linea.setVol_venta_mensual_4(vol_venta_mensual_4);
				String vol_venta_mensual_5 = (String) row[117];
				linea.setVol_venta_mensual_5(vol_venta_mensual_5);
				String vol_venta_mensual_6 = (String) row[118];
				linea.setVol_venta_mensual_6(vol_venta_mensual_6);
				String vol_venta_mensual_7 = (String) row[119];
				linea.setVol_venta_mensual_7(vol_venta_mensual_7);
				String vol_venta_mensual_8 = (String) row[120];
				linea.setVol_venta_mensual_8(vol_venta_mensual_8);
				String vol_venta_mensual_9 = (String) row[121];
				linea.setVol_venta_mensual_9(vol_venta_mensual_9);
				String vol_venta_mensual_10 = (String) row[122];
				linea.setVol_venta_mensual_10(vol_venta_mensual_10);
				String empaca_producto_1 = (String) row[123];
				linea.setEmpaca_producto_1(empaca_producto_1);
				String empaca_producto_2 = (String) row[124];
				linea.setEmpaca_producto_2(empaca_producto_2);
				String empaca_producto_3 = (String) row[125];
				linea.setEmpaca_producto_3(empaca_producto_3);
				String empaca_producto_4 = (String) row[126];
				linea.setEmpaca_producto_4(empaca_producto_4);
				String empaca_producto_5 = (String) row[127];
				linea.setEmpaca_producto_5(empaca_producto_5);
				String empaca_producto_6 = (String) row[128];
				linea.setEmpaca_producto_6(empaca_producto_6);
				String empaca_producto_7 = (String) row[129];
				linea.setEmpaca_producto_7(empaca_producto_7);
				String empaca_producto_8 = (String) row[130];
				linea.setEmpaca_producto_8(empaca_producto_8);
				String empaca_producto_9 = (String) row[131];
				linea.setEmpaca_producto_9(empaca_producto_9);
				String empaca_producto_10 = (String) row[132];
				linea.setEmpaca_producto_10(empaca_producto_10);
				String prod_servicios_energia = (String) row[133];
				linea.setProd_servicios_energia(prod_servicios_energia);
				String prod_servicios_gas = (String) row[134];
				linea.setProd_servicios_gas(prod_servicios_gas);
				String prod_servicios_telefonia = (String) row[135];
				linea.setProd_servicios_telefonia(prod_servicios_telefonia);
				String prod_servicios_internet = (String) row[136];
				linea.setProd_servicios_internet(prod_servicios_internet);
				String prod_servicios_tv = (String) row[137];
				linea.setProd_servicios_tv(prod_servicios_tv);
				String prod_eduacion_hijos_tipo = (String) row[138];
				linea.setProd_eduacion_hijos_tipo(prod_eduacion_hijos_tipo);
				String cedula = (String) row[139];
				linea.setCedula(cedula);
				String observaciones = (String) row[140];
				linea.setObservaciones(observaciones);
				String prod_gasto_ingresos_servicios = (String) row[141];
				linea.setProd_gasto_ingresos_servicios(prod_gasto_ingresos_servicios);
				String prod_gasto_ingresos_educacion = (String) row[142];
				linea.setProd_gasto_ingresos_educacion(prod_gasto_ingresos_educacion);
				String prod_gasto_ingresos_intereses = (String) row[143];
				linea.setProd_gasto_ingresos_intereses(prod_gasto_ingresos_intereses);
				String prod_gasto_ingresos_vivienda = (String) row[144];
				linea.setProd_gasto_ingresos_vivienda(prod_gasto_ingresos_vivienda);
				String prod_construccion_vivienda_piso = (String) row[145];
				linea.setProd_construccion_vivienda_piso(prod_construccion_vivienda_piso);
				String observacion = (String) row[146];
				linea.setObservacion(observacion);
				String prod_gasto_ingresos_recreacion = (String) row[147];
				linea.setProd_gasto_ingresos_recreacion(prod_gasto_ingresos_recreacion);

				String genero = (String) row[148];
				linea.setGenero(genero);

				nomina.add(linea);
			}
		}

		return nomina;

	}

	@Override
	public List<LineaBaseAsociacionDTO> consultarLineaBaseAsociacion(Long companias, String contratista,
			Long flagContratista) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_bd_linea_asociacion_impacto (:companias,  :contratista, :flagContratista)");

		q.setLong("companias", companias);
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<LineaBaseAsociacionDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<LineaBaseAsociacionDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				LineaBaseAsociacionDTO linea = new LineaBaseAsociacionDTO();
				String nombrecompania = (String) row[0];
				linea.setNombrecompania(nombrecompania);
				String departamento = (String) row[1];
				linea.setDepartamento(departamento);
				String ciudad = (String) row[2];
				linea.setCiudad(ciudad);
				String productor = (String) row[3];
				linea.setProductor(productor);
				String celular = (String) row[4];
				linea.setCelular(celular);
				String tecnico = (String) row[5];
				linea.setTecnico(tecnico);
				String responsable = (String) row[6];
				linea.setResponsable(responsable);
				BigDecimal lnea_base_asociacion_id = (BigDecimal) row[7];
				linea.setLnea_base_asociacion_id(lnea_base_asociacion_id);
				BigDecimal compania = (BigDecimal) row[8];
				linea.setCompania(compania);
				BigDecimal consecutivo = (BigDecimal) row[9];
				linea.setConsecutivo(consecutivo);
				BigDecimal pers_empr_id = (BigDecimal) row[10];
				linea.setPers_empr_id(pers_empr_id);
				String asoc_db_formalizada_asociacion = (String) row[11];
				linea.setAsoc_db_formalizada_asociacion(asoc_db_formalizada_asociacion);
				String asoc_db_otra_formalizada_asociacion = (String) row[12];
				linea.setAsoc_db_otra_formalizada_asociacion(asoc_db_otra_formalizada_asociacion);
				String asoc_db_tipo_certificacion = (String) row[13];
				linea.setAsoc_db_tipo_certificacion(asoc_db_tipo_certificacion);
				String asoc_db_otra_certificacion = (String) row[14];
				linea.setAsoc_db_otra_certificacion(asoc_db_otra_certificacion);
				String asoc_db_no_socios = (String) row[15];
				linea.setAsoc_db_no_socios(asoc_db_no_socios);
				String asoc_db_no_socios_mujeres = (String) row[16];
				linea.setAsoc_db_no_socios_mujeres(asoc_db_no_socios_mujeres);
				String asoc_db_no_mujeres_junta_directiva = (String) row[17];
				linea.setAsoc_db_no_mujeres_junta_directiva(asoc_db_no_mujeres_junta_directiva);
				String asoc_db_estado_organizacional = (String) row[18];
				linea.setAsoc_db_estado_organizacional(asoc_db_estado_organizacional);
				String asoc_db_cooperacion_socios = (String) row[19];
				linea.setAsoc_db_cooperacion_socios(asoc_db_cooperacion_socios);
				String asoc_db_estado_cuenta_socios = (String) row[20];
				linea.setAsoc_db_estado_cuenta_socios(asoc_db_estado_cuenta_socios);
				String asoc_db_area_sembrada = (String) row[21];
				linea.setAsoc_db_area_sembrada(asoc_db_area_sembrada);
				String asoc_db_toneladas_venta_mensual = (String) row[22];
				linea.setAsoc_db_toneladas_venta_mensual(asoc_db_toneladas_venta_mensual);
				String asoc_db_ingresos_venta_mensual = (String) row[23];
				linea.setAsoc_db_ingresos_venta_mensual(asoc_db_ingresos_venta_mensual);
				String asoc_db_creditos_financiar_cultivo = (String) row[24];
				linea.setAsoc_db_creditos_financiar_cultivo(asoc_db_creditos_financiar_cultivo);
				String asoc_db_otra_creditos_financiar_cultivo = (String) row[25];
				linea.setAsoc_db_otra_creditos_financiar_cultivo(asoc_db_otra_creditos_financiar_cultivo);
				String asoc_db_contratos_firmados_cliente = (String) row[26];
				linea.setAsoc_db_contratos_firmados_cliente(asoc_db_contratos_firmados_cliente);
				String asoc_db_otra_contratos_firmados_cliente = (String) row[27];
				linea.setAsoc_db_otra_contratos_firmados_cliente(asoc_db_otra_contratos_firmados_cliente);
				String asoc_db_recibe_asistencia_tecnica = (String) row[28];
				linea.setAsoc_db_recibe_asistencia_tecnica(asoc_db_recibe_asistencia_tecnica);
				String asoc_db_otra_recibe_asistencia_tecnica = (String) row[29];
				linea.setAsoc_db_otra_recibe_asistencia_tecnica(asoc_db_otra_recibe_asistencia_tecnica);
				String asoc_db_conoce_costos_produccion = (String) row[30];
				linea.setAsoc_db_conoce_costos_produccion(asoc_db_conoce_costos_produccion);
				String asoc_db_fondo_rotatorio = (String) row[31];
				linea.setAsoc_db_fondo_rotatorio(asoc_db_fondo_rotatorio);
				String asoc_db_otro_fondo_rotatorio = (String) row[32];
				linea.setAsoc_db_otro_fondo_rotatorio(asoc_db_otro_fondo_rotatorio);
				String asoc_db_estrategias_administrativas = (String) row[33];
				linea.setAsoc_db_estrategias_administrativas(asoc_db_estrategias_administrativas);
				String asoc_db_estructura_organizacional = (String) row[34];
				linea.setAsoc_db_estructura_organizacional(asoc_db_estructura_organizacional);
				String asoc_db_manejo_contabilidad_finanzas = (String) row[35];
				linea.setAsoc_db_manejo_contabilidad_finanzas(asoc_db_manejo_contabilidad_finanzas);
				String asoc_db_otra_manejo_contabilidad_finanzas = (String) row[36];
				linea.setAsoc_db_otra_manejo_contabilidad_finanzas(asoc_db_otra_manejo_contabilidad_finanzas);
				String asoc_db_tiene_cuenta_bancaria = (String) row[37];
				linea.setAsoc_db_tiene_cuenta_bancaria(asoc_db_tiene_cuenta_bancaria);
				String asoc_db_tiempo_cuenta_bancaria = (String) row[38];
				linea.setAsoc_db_tiempo_cuenta_bancaria(asoc_db_tiempo_cuenta_bancaria);
				String asoc_db_practicas_sostenibles = (String) row[39];
				linea.setAsoc_db_practicas_sostenibles(asoc_db_practicas_sostenibles);
				String asoc_db_otra_practicas_sostenibles = (String) row[40];
				linea.setAsoc_db_otra_practicas_sostenibles(asoc_db_otra_practicas_sostenibles);
				String asoc_db_pertenece_proyecto_fortalecimiento = (String) row[41];
				linea.setAsoc_db_pertenece_proyecto_fortalecimiento(asoc_db_pertenece_proyecto_fortalecimiento);
				String asoc_db_otro_proyecto_fortalecimiento = (String) row[42];
				linea.setAsoc_db_otro_proyecto_fortalecimiento(asoc_db_otro_proyecto_fortalecimiento);
				String cultivo_variedad_prod_1 = (String) row[43];
				linea.setCultivo_variedad_prod_1(cultivo_variedad_prod_1);
				String cultivo_variedad_prod_2 = (String) row[44];
				linea.setCultivo_variedad_prod_2(cultivo_variedad_prod_2);
				String cultivo_variedad_prod_3 = (String) row[45];
				linea.setCultivo_variedad_prod_3(cultivo_variedad_prod_3);
				String cultivo_variedad_prod_4 = (String) row[46];
				linea.setCultivo_variedad_prod_4(cultivo_variedad_prod_4);
				String cultivo_variedad_prod_5 = (String) row[47];
				linea.setCultivo_variedad_prod_5(cultivo_variedad_prod_5);
				String cultivo_variedad_prod_6 = (String) row[48];
				linea.setCultivo_variedad_prod_6(cultivo_variedad_prod_6);
				String cultivo_variedad_prod_7 = (String) row[49];
				linea.setCultivo_variedad_prod_7(cultivo_variedad_prod_7);
				String cultivo_variedad_prod_8 = (String) row[50];
				linea.setCultivo_variedad_prod_8(cultivo_variedad_prod_8);
				String cultivo_variedad_prod_9 = (String) row[51];
				linea.setCultivo_variedad_prod_9(cultivo_variedad_prod_9);
				String cultivo_variedad_prod_10 = (String) row[52];
				linea.setCultivo_variedad_prod_10(cultivo_variedad_prod_10);
				String rend_cosecha_1 = (String) row[53];
				linea.setRend_cosecha_1(rend_cosecha_1);
				String rend_cosecha_2 = (String) row[54];
				linea.setRend_cosecha_2(rend_cosecha_2);
				String rend_cosecha_3 = (String) row[55];
				linea.setRend_cosecha_3(rend_cosecha_3);
				String rend_cosecha_4 = (String) row[56];
				linea.setRend_cosecha_4(rend_cosecha_4);
				String rend_cosecha_5 = (String) row[57];
				linea.setRend_cosecha_5(rend_cosecha_5);
				String rend_cosecha_6 = (String) row[58];
				linea.setRend_cosecha_6(rend_cosecha_6);
				String rend_cosecha_7 = (String) row[59];
				linea.setRend_cosecha_7(rend_cosecha_7);
				String rend_cosecha_8 = (String) row[60];
				linea.setRend_cosecha_8(rend_cosecha_8);
				String rend_cosecha_9 = (String) row[61];
				linea.setRend_cosecha_9(rend_cosecha_9);
				String rend_cosecha_10 = (String) row[62];
				linea.setRend_cosecha_10(rend_cosecha_10);
				String cultivo_variedad_venta_1 = (String) row[63];
				linea.setCultivo_variedad_venta_1(cultivo_variedad_venta_1);
				String cultivo_variedad_venta_2 = (String) row[64];
				linea.setCultivo_variedad_venta_2(cultivo_variedad_venta_2);
				String cultivo_variedad_venta_3 = (String) row[65];
				linea.setCultivo_variedad_venta_3(cultivo_variedad_venta_3);
				String cultivo_variedad_venta_4 = (String) row[66];
				linea.setCultivo_variedad_venta_4(cultivo_variedad_venta_4);
				String cultivo_variedad_venta_5 = (String) row[67];
				linea.setCultivo_variedad_venta_5(cultivo_variedad_venta_5);
				String cultivo_variedad_venta_6 = (String) row[68];
				linea.setCultivo_variedad_venta_6(cultivo_variedad_venta_6);
				String cultivo_variedad_venta_7 = (String) row[69];
				linea.setCultivo_variedad_venta_7(cultivo_variedad_venta_7);
				String cultivo_variedad_venta_8 = (String) row[70];
				linea.setCultivo_variedad_venta_8(cultivo_variedad_venta_8);
				String cultivo_variedad_venta_9 = (String) row[71];
				linea.setCultivo_variedad_venta_9(cultivo_variedad_venta_9);
				String cultivo_variedad_venta_10 = (String) row[72];
				linea.setCultivo_variedad_venta_10(cultivo_variedad_venta_10);
				String vol_venta_mensual_1 = (String) row[73];
				linea.setVol_venta_mensual_1(vol_venta_mensual_1);
				String vol_venta_mensual_2 = (String) row[74];
				linea.setVol_venta_mensual_2(vol_venta_mensual_2);
				String vol_venta_mensual_3 = (String) row[75];
				linea.setVol_venta_mensual_3(vol_venta_mensual_3);
				String vol_venta_mensual_4 = (String) row[76];
				linea.setVol_venta_mensual_4(vol_venta_mensual_4);
				String vol_venta_mensual_5 = (String) row[77];
				linea.setVol_venta_mensual_5(vol_venta_mensual_5);
				String vol_venta_mensual_6 = (String) row[78];
				linea.setVol_venta_mensual_6(vol_venta_mensual_6);
				String vol_venta_mensual_7 = (String) row[79];
				linea.setVol_venta_mensual_7(vol_venta_mensual_7);
				String vol_venta_mensual_8 = (String) row[80];
				linea.setVol_venta_mensual_8(vol_venta_mensual_8);
				String vol_venta_mensual_9 = (String) row[81];
				linea.setVol_venta_mensual_9(vol_venta_mensual_9);
				String vol_venta_mensual_10 = (String) row[82];
				linea.setVol_venta_mensual_10(vol_venta_mensual_10);
				String empaca_producto_1 = (String) row[83];
				linea.setEmpaca_producto_1(empaca_producto_1);
				String empaca_producto_2 = (String) row[84];
				linea.setEmpaca_producto_2(empaca_producto_2);
				String empaca_producto_3 = (String) row[85];
				linea.setEmpaca_producto_3(empaca_producto_3);
				String empaca_producto_4 = (String) row[86];
				linea.setEmpaca_producto_4(empaca_producto_4);
				String empaca_producto_5 = (String) row[87];
				linea.setEmpaca_producto_5(empaca_producto_5);
				String empaca_producto_6 = (String) row[88];
				linea.setEmpaca_producto_6(empaca_producto_6);
				String empaca_producto_7 = (String) row[89];
				linea.setEmpaca_producto_7(empaca_producto_7);
				String empaca_producto_8 = (String) row[90];
				linea.setEmpaca_producto_8(empaca_producto_8);
				String empaca_producto_9 = (String) row[91];
				linea.setEmpaca_producto_9(empaca_producto_9);
				String empaca_producto_10 = (String) row[92];
				linea.setEmpaca_producto_10(empaca_producto_10);
				String asoc_db_tiempo_venta_producto = (String) row[93];
				linea.setAsoc_db_tiempo_venta_producto(asoc_db_tiempo_venta_producto);
				String asoc_db_transporte_propio_producto = (String) row[94];
				linea.setAsoc_db_transporte_propio_producto(asoc_db_transporte_propio_producto);
				String asoc_db_otra_transporte_propio_producto = (String) row[95];
				linea.setAsoc_db_otra_transporte_propio_producto(asoc_db_otra_transporte_propio_producto);
				String asoc_db_productos_venta_actual = (String) row[96];
				linea.setAsoc_db_productos_venta_actual(asoc_db_productos_venta_actual);
				String asoc_db_donde_vende_productos = (String) row[97];
				linea.setAsoc_db_donde_vende_productos(asoc_db_donde_vende_productos);
				String asoc_db_observaciones_consultor_cultivo = (String) row[98];
				linea.setAsoc_db_observaciones_consultor_cultivo(asoc_db_observaciones_consultor_cultivo);
				String asoc_db_observaciones_socio_empresarial = (String) row[99];
				linea.setAsoc_db_observaciones_socio_empresarial(asoc_db_observaciones_socio_empresarial);
				BigDecimal asoc_db_encuestador_id = (BigDecimal) row[100];
				linea.setAsoc_db_encuestador_id(asoc_db_encuestador_id);
				Date fecha_creacion = (Date) row[101];
				linea.setFecha_creacion(fecha_creacion);
				Date fecha_modificacion = (Date) row[102];
				linea.setFecha_modificacion(fecha_modificacion);
				String estado = (String) row[103];
				linea.setEstado(estado);
				BigDecimal usuario_digitacion = (BigDecimal) row[104];
				linea.setUsuario_digitacion(usuario_digitacion);
				String cedula = (String) row[105];
				linea.setCedula(cedula);
				String asoc_db_otra_cuentas_bancaria = (String) row[106];
				linea.setAsoc_db_otra_cuentas_bancaria(asoc_db_otra_cuentas_bancaria);
				String asoc_db_principales_compradores = (String) row[107];
				linea.setAsoc_db_principales_compradores(asoc_db_principales_compradores);
				String asoc_db_otra_calidad_suelo_agua = (String) row[108];
				linea.setAsoc_db_otra_calidad_suelo_agua(asoc_db_otra_calidad_suelo_agua);
				String asoc_db_otra_diversificacion_compra = (String) row[109];
				linea.setAsoc_db_otra_diversificacion_compra(asoc_db_otra_diversificacion_compra);
				String asoc_db_otra_observacion = (String) row[110];
				linea.setAsoc_db_otra_observacion(asoc_db_otra_observacion);

				nomina.add(linea);
			}
		}

		return nomina;

	}

	@Override
	public List<ProgramaRiegosDTO> consultarInformeProgramaRiegos(Long compania, Long anio, Long mes, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String infraestructura, Long flagInfraestructura) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_programa_riego (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :infraestructura,"
						+ "	:flagInfraestructura )");

		q.setLong("compania", compania);
		q.setLong("anio", anio);
		q.setLong("mes", mes);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("infraestructura", infraestructura);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagInfraestructura", flagInfraestructura);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProgramaRiegosDTO> disponibilidadHidrica = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			disponibilidadHidrica = new ArrayList<ProgramaRiegosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProgramaRiegosDTO disponibilidadHidricaA = new ProgramaRiegosDTO();

				disponibilidadHidrica.add(disponibilidadHidricaA);

			}
		}

		return disponibilidadHidrica;

	}

	/*** ACTUALIZACION 01-02-2017 ***/

	@Override
	public long consultarConsecutivoProgramaSiembraCosecha(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_programa_siembra_cosecha (:compania)");
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
	public List<ProduccionAcumFincaDTO> consultarProduccionLoteDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String cliente, Long flagCliente) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_produccion_lote_detallado (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote,  "
						+ ":unidadMedida,  :flagUnidadMedida,  :tenencia, :flagTenencia,"
						+ ":modCosecha, :flagModCosecha,:noCosecha,  :flagNoCosecha, :producto,  :flagProducto,"
						+ ":cliente, :flagCliente )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		// q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		// q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("modCosecha", modCosecha);
		q.setString("noCosecha", noCosecha);
		q.setString("producto", producto);
		q.setString("cliente", cliente);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		// q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagModCosecha", flagModCosecha);
		q.setLong("flagNoCosecha", flagNoCosecha);
		q.setLong("flagProducto", flagProducto);
		q.setLong("flagCliente", flagCliente);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProduccionAcumFincaDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<ProduccionAcumFincaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProduccionAcumFincaDTO materiaPrimaLoteA = new ProduccionAcumFincaDTO();

				BigDecimal anio = (BigDecimal) row[1];
				BigDecimal mes = (BigDecimal) row[2];
				String mesCorto = (String) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[6];
				String nomFinca = (String) row[7];
				String codBloque = (String) row[8];
				String nomBloque = (String) row[9];
				String codLote = (String) row[10];
				String nomLote = (String) row[11];
				BigDecimal cantidadCos = (BigDecimal) row[12];
				BigDecimal area = (BigDecimal) row[13];
				String nombreCompania = (String) row[14];
				String nombreCliente = (String) row[15];
				String nombreVariedad = (String) row[16];
				String proveedor = (String) row[17];
				BigDecimal tonHa = (BigDecimal) row[18];
				BigInteger nCosechas = (BigInteger) row[19];
				Date fechaInicio = (Date) row[20];
				Date fechaFin = (Date) row[21];
				BigDecimal edad = (BigDecimal) row[22];
				BigDecimal kilosCosechados = (BigDecimal) row[23];
				BigDecimal valorUnitarioKilo = (BigDecimal) row[24];
				BigDecimal ingresoTotal = (BigDecimal) row[25];
				Date fechaProxCorte = (Date) row[26];
				BigDecimal tchm = (BigDecimal) row[28];
				BigDecimal rendHa = (BigDecimal) row[29];
				BigDecimal ingresosHa = (BigDecimal) row[30];

				BigDecimal porcKilosTonelada = (BigDecimal) row[31];
				BigDecimal porcMateriaExtrana = (BigDecimal) row[32];
				BigDecimal porcRendimiento = (BigDecimal) row[33];
				BigDecimal porcSacarosa = (BigDecimal) row[34];
				BigDecimal ingresoBruto = (BigDecimal) row[35];
				BigDecimal valorDeduccion = (BigDecimal) row[36];

				materiaPrimaLoteA.setAnio(anio);
				materiaPrimaLoteA.setMes(mes);
				materiaPrimaLoteA.setMesCorto(mesCorto);
				materiaPrimaLoteA.setCodZona(codZona);
				materiaPrimaLoteA.setCodFinca(codFinca);
				materiaPrimaLoteA.setNomFinca(nomFinca);
				materiaPrimaLoteA.setCodBloque(codBloque);
				materiaPrimaLoteA.setNomBloque(codBloque);
				materiaPrimaLoteA.setCodLote(codLote);
				materiaPrimaLoteA.setNomLote(nomLote);
				materiaPrimaLoteA.setArea(area);
				materiaPrimaLoteA.setCantidadCosechadaTon(cantidadCos);
				materiaPrimaLoteA.setNomCompania(nombreCompania);
				materiaPrimaLoteA.setNomCliente(nombreCliente);
				materiaPrimaLoteA.setNomVariedad(nombreVariedad);
				materiaPrimaLoteA.setProveedor(proveedor);
				materiaPrimaLoteA.setTonHa(tonHa);
				materiaPrimaLoteA.setnCosechas(nCosechas);
				materiaPrimaLoteA.setFechaInicio(fechaInicio);
				materiaPrimaLoteA.setFechaFin(fechaFin);
				materiaPrimaLoteA.setEdad(edad);

				materiaPrimaLoteA.setKilosCosechados(kilosCosechados);
				materiaPrimaLoteA.setValorUnitarioKilo(valorUnitarioKilo);
				materiaPrimaLoteA.setIngresoTotal(ingresoTotal);
				materiaPrimaLoteA.setFechaProxCorte(fechaProxCorte);

				materiaPrimaLoteA.setTchm(tchm);
				materiaPrimaLoteA.setRendHa(rendHa);
				materiaPrimaLoteA.setIngresosHa(ingresosHa);

				materiaPrimaLoteA.setPorcKilosTonelada(porcKilosTonelada);
				materiaPrimaLoteA.setPorcMateriaExtrana(porcMateriaExtrana);
				materiaPrimaLoteA.setPorcRendimiento(porcRendimiento);
				materiaPrimaLoteA.setPorcSacarosa(porcSacarosa);
				materiaPrimaLoteA.setIngresoBruto(ingresoBruto);
				materiaPrimaLoteA.setValorDeduccion(valorDeduccion);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	/*************************** 09-02-2017 ****/

	@Override
	public long consultarConsecutivoProgramRiego(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_programa_riego (:compania)");
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

	/*** 10-02-2017**bascula **/

	@Override
	public List<BasculaVehiculosPesarDTO> consultarBasculaPesar(Long compania) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call vehiculos_a_pesar (:compania)");

		q.setLong("compania", compania);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<BasculaVehiculosPesarDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<BasculaVehiculosPesarDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				BasculaVehiculosPesarDTO materiaPrimaLoteA = new BasculaVehiculosPesarDTO();

				BigInteger id = (BigInteger) row[0];
				BigInteger consecutivo = (BigInteger) row[1];
				String equipo = (String) row[2];
				String tipoTransaccion = (String) row[3];
				Date fecha = (Date) row[4];

				materiaPrimaLoteA.setId(id);
				materiaPrimaLoteA.setConsecutivo(consecutivo);
				materiaPrimaLoteA.setEquipo(equipo);
				materiaPrimaLoteA.setTipoTransaccion(tipoTransaccion);
				materiaPrimaLoteA.setFechaRegistro(fecha);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<BasculaVehiculosTararDTO> consultarBasculaTarar(Long compania) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call vehiculos_a_tarar (:compania)");

		q.setLong("compania", compania);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<BasculaVehiculosTararDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<BasculaVehiculosTararDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				BasculaVehiculosTararDTO materiaPrimaLoteA = new BasculaVehiculosTararDTO();

				BigInteger id = (BigInteger) row[0];
				BigInteger consecutivo = (BigInteger) row[1];
				String equipo = (String) row[2];
				String tipoTransaccion = (String) row[3];
				Date fecha = (Date) row[4];

				materiaPrimaLoteA.setId(id);
				materiaPrimaLoteA.setConsecutivo(consecutivo);
				materiaPrimaLoteA.setEquipo(equipo);
				materiaPrimaLoteA.setTipoTransaccion(tipoTransaccion);
				materiaPrimaLoteA.setFechaRegistro(fecha);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<TiquetesBasculaDTO> consultarTiqueteBascula(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoTransaccion, Long flagTipoTransaccion, String equipo1, Long flagEquipo, String tiquete,
			Long flagTiquete, String estado1, Long flagEstado) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_tiquetes_bascula (:compania1, :fechaInicial, :fechaFinal, :tipoTransaccion, :flagTipoTransaccion, :equipo1, "
						+ ":flagEquipo, :tiquete, :flagTiquete, :estado1, :flagEstado)");

		q.setLong("compania1", compania1);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tipoTransaccion", tipoTransaccion);
		q.setLong("flagTipoTransaccion", flagTipoTransaccion);
		q.setString("equipo1", equipo1);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("tiquete", tiquete);
		q.setLong("flagTiquete", flagTiquete);
		q.setString("estado1", estado1);
		q.setLong("flagEstado", flagEstado);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
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
				String equipo = (String) row[4];
				materiaPrimaLoteA.setEquipo(equipo);
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

				String estadoEstrue = "false";
				if (estado.equals("I")) {
					estadoEstrue = "true";
					materiaPrimaLoteA.setEstadoTrue(estadoEstrue);
				}

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<TiquetesBasculaImprimirProdDTO> consultarTiqueteBasculaImprimirProd(Long compania1, Long tiquete) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_tiquetes_bascula_imprimir_prod (:compania1, :tiquete)");

		q.setLong("compania1", compania1);
		q.setLong("tiquete", tiquete);
		List l = q.list();
		List<TiquetesBasculaImprimirProdDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<TiquetesBasculaImprimirProdDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				TiquetesBasculaImprimirProdDTO materiaPrimaLoteA = new TiquetesBasculaImprimirProdDTO();

				BigInteger dat_trans_prod_id = (BigInteger) row[0];
				materiaPrimaLoteA.setDat_trans_prod_id(dat_trans_prod_id);
				BigInteger consecutivo = (BigInteger) row[1];
				materiaPrimaLoteA.setConsecutivo(consecutivo);
				Date fecha_registro = (Date) row[2];
				materiaPrimaLoteA.setFecha_registro(fecha_registro);
				String tipo_transaccion = (String) row[3];
				materiaPrimaLoteA.setTipo_transaccion(tipo_transaccion);
				String equipo = (String) row[4];
				materiaPrimaLoteA.setEquipo(equipo);
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
				String conductor = (String) row[13];
				materiaPrimaLoteA.setConductor(conductor);
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
				String acidez = (String) row[28];
				materiaPrimaLoteA.setAcidez(acidez);
				String humedad = (String) row[29];
				materiaPrimaLoteA.setHumedad(humedad);
				String impurezas = (String) row[30];
				materiaPrimaLoteA.setImpurezas(impurezas);
				String temperatura = (String) row[31];
				materiaPrimaLoteA.setTemperatura(temperatura);
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
				String lote = (String) row[40];
				materiaPrimaLoteA.setLote(lote);
				String producto = (String) row[41];
				materiaPrimaLoteA.setProducto(producto);
				String nombreCompania = (String) row[42];
				materiaPrimaLoteA.setNombreCompania(nombreCompania);
				String nitCompania = (String) row[43];
				materiaPrimaLoteA.setNitCompania(nitCompania);
				String telefonoCompania = (String) row[44];
				materiaPrimaLoteA.setTelefonoCompania(telefonoCompania);
				String direccionCompania = (String) row[45];
				materiaPrimaLoteA.setDireccionCompania(direccionCompania);
				String ciudadCompania = (String) row[46];
				materiaPrimaLoteA.setCiudadCompania(ciudadCompania);
				String nom_cliente = (String) row[47];
				materiaPrimaLoteA.setNom_cliente(nom_cliente);
				String cod_cliente = (String) row[48];
				materiaPrimaLoteA.setCod_cliente(cod_cliente);
				String cod_producto = (String) row[49];
				materiaPrimaLoteA.setCod_producto(cod_producto);
				String placa_equipo = (String) row[50];
				materiaPrimaLoteA.setPlaca_equipo(placa_equipo);				
				String origen = (String) row[51];
				materiaPrimaLoteA.setOrigen(origen);
				String no_documento = (String) row[52];
				materiaPrimaLoteA.setNo_documento(no_documento);
				String destino = (String) row[53];
				materiaPrimaLoteA.setDestino(destino);
				String observaciones = (String) row[54];
				materiaPrimaLoteA.setObservaciones(observaciones);
				String usuario_digitacion = (String) row[55];
				materiaPrimaLoteA.setUsuario_digitacion(usuario_digitacion);				
				String campoCiudadCliente = (String) row[56];
				materiaPrimaLoteA.setCampo_ciudad_cliente(campoCiudadCliente);				
				String ciudadCliente = (String) row[57];
				materiaPrimaLoteA.setCiudad_cliente(ciudadCliente);				
				String campoOrigen = (String) row[58];
				materiaPrimaLoteA.setCampo_origen(campoOrigen);				
				String campoDestino = (String) row[59];
				materiaPrimaLoteA.setCampo_destino(campoDestino);				
				String campoAcidez = (String) row[60];
				materiaPrimaLoteA.setCampo_acidez(campoAcidez);				
				String campoHumedad = (String) row[61];
				materiaPrimaLoteA.setCampo_humedad(campoHumedad);				
				String campoImpurezas = (String) row[62];
				materiaPrimaLoteA.setCampo_impurezas(campoImpurezas);				
				String campoTemperatura = (String) row[63];
				materiaPrimaLoteA.setCampo_temperatura(campoTemperatura);				
				String campoSellos = (String) row[64];
				materiaPrimaLoteA.setCampo_sellos(campoSellos);				
				String campoProveedorCliente = (String) row[65];
				materiaPrimaLoteA.setCampo_proveedor_cliente(campoProveedorCliente);
				BigInteger consecutivoNeto = (BigInteger) row[66];
				materiaPrimaLoteA.setConsecutivo_peso_neto(consecutivoNeto.longValue());

				Date fechaImpresion = new Date();
				materiaPrimaLoteA.setFechaImpresion(fechaImpresion);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<TiquetesBasculaImprimirDespachosDTO> consultarTiqueteBasculaImprimirDespachos(Long compania1,
			Long tiquete) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_tiquetes_bascula_imprimir_despa (:compania1, :tiquete)");

		q.setLong("compania1", compania1);
		q.setLong("tiquete", tiquete);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<TiquetesBasculaImprimirDespachosDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<TiquetesBasculaImprimirDespachosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				TiquetesBasculaImprimirDespachosDTO materiaPrimaLoteA = new TiquetesBasculaImprimirDespachosDTO();

				BigDecimal dat_trans_prod_id = (BigDecimal) row[0];
				materiaPrimaLoteA.setDat_trans_prod_id(dat_trans_prod_id);
				BigDecimal consecutivo = (BigDecimal) row[1];
				materiaPrimaLoteA.setConsecutivo(consecutivo);
				Date fecha_registro = (Date) row[2];
				materiaPrimaLoteA.setFecha_registro(fecha_registro);
				String tipo_transaccion = (String) row[3];
				materiaPrimaLoteA.setTipo_transaccion(tipo_transaccion);
				String equipo = (String) row[4];
				materiaPrimaLoteA.setEquipo(equipo);
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
				BigDecimal compania = (BigDecimal) row[11];
				materiaPrimaLoteA.setCompania(compania);
				String transportadora = (String) row[12];
				materiaPrimaLoteA.setTransportadora(transportadora);
				String conductor = (String) row[13];
				materiaPrimaLoteA.setConductor(conductor);
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
				BigDecimal impurezas = (BigDecimal) row[30];
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

				String cliente = (String) row[40];
				materiaPrimaLoteA.setCliente(cliente);

				String nombreCompania = (String) row[41];
				materiaPrimaLoteA.setNombreCompania(nombreCompania);
				String nitCompania = (String) row[42];
				materiaPrimaLoteA.setNitCompania(nitCompania);
				String telefonoCompania = (String) row[43];
				materiaPrimaLoteA.setTelefonoCompania(telefonoCompania);
				String direccionCompania = (String) row[44];
				materiaPrimaLoteA.setDireccionCompania(direccionCompania);
				String ciudadCompania = (String) row[45];
				materiaPrimaLoteA.setCiudadCompania(ciudadCompania);

				Date fechaImpresion = new Date();
				materiaPrimaLoteA.setFechaImpresion(fechaImpresion);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<TiquetesBasculaDespachosInformeDTO> consultarTiqueteBasculaDespachosInforme(Long compania1,
			Date fechaInicial, Date fechaFinal, String equipo1, Long flagEquipo, String tiquete, Long flagTiquete,
			String contratista, Long flagContratista) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_tiquetes_bascula_despachos (:compania1, :fechaInicial, :fechaFinal, :equipo1, :flagEquipo, :tiquete, :flagTiquete, :contratista, :flagContratista)");

		q.setLong("compania1", compania1);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo1", equipo1);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("tiquete", tiquete);
		q.setLong("flagTiquete", flagTiquete);
		
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);
		
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<TiquetesBasculaDespachosInformeDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<TiquetesBasculaDespachosInformeDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				TiquetesBasculaDespachosInformeDTO materiaPrimaLoteA = new TiquetesBasculaDespachosInformeDTO();

				BigInteger dat_trans_prod_id = (BigInteger) row[0];
				materiaPrimaLoteA.setDat_trans_prod_id(dat_trans_prod_id);
				BigInteger consecutivo = (BigInteger) row[1];
				materiaPrimaLoteA.setConsecutivo(consecutivo);
				Date fecha_registro = (Date) row[2];
				materiaPrimaLoteA.setFecha_registro(fecha_registro);
				String tipo_transaccion = (String) row[3];
				materiaPrimaLoteA.setTipo_transaccion(tipo_transaccion);
				String equipo = (String) row[4];
				materiaPrimaLoteA.setEquipo(equipo);
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
				String conductor = (String) row[13];
				materiaPrimaLoteA.setConductor(conductor);
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
				BigDecimal impurezas = (BigDecimal) row[30];
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

				String cliente = (String) row[40];
				materiaPrimaLoteA.setCliente(cliente);

				String nombreCompania = (String) row[41];
				materiaPrimaLoteA.setNombreCompania(nombreCompania);
				String nitCompania = (String) row[42];
				materiaPrimaLoteA.setNitCompania(nitCompania);
				String telefonoCompania = (String) row[43];
				materiaPrimaLoteA.setTelefonoCompania(telefonoCompania);
				String direccionCompania = (String) row[44];
				materiaPrimaLoteA.setDireccionCompania(direccionCompania);
				String ciudadCompania = (String) row[45];
				materiaPrimaLoteA.setCiudadCompania(ciudadCompania);

				String fechaImpresion = new String();
				materiaPrimaLoteA.setFechaImpresion(fechaImpresion);

				String producto = (String) row[46];
				materiaPrimaLoteA.setProducto(producto);
				String unidadMedida = (String) row[47];
				materiaPrimaLoteA.setUnidadMedidaProducto(unidadMedida);
				String ciudad = (String) row[48];
				materiaPrimaLoteA.setCiudadCliente(ciudad);
				BigDecimal CantidadRequerida = (BigDecimal) row[49];
				materiaPrimaLoteA.setCantidadRequerida(CantidadRequerida);

				BigDecimal mes = (BigDecimal) row[50];
				materiaPrimaLoteA.setMes(mes);

				String mesCorto = (String) row[51];
				materiaPrimaLoteA.setMesCorto(mesCorto);

				BigDecimal anio = (BigDecimal) row[52];
				materiaPrimaLoteA.setAnio(anio);

				String factura = (String) row[53];
				materiaPrimaLoteA.setNoFactura(factura);

				String pedido = (String) row[54];
				materiaPrimaLoteA.setNoPedido(pedido);

				String despacho = (String) row[55];
				materiaPrimaLoteA.setNoRegistroDespacho(despacho);
				
				BigInteger consecutivo_peso_neto = (BigInteger) row[56];
				materiaPrimaLoteA.setConsecutivo_peso_neto(consecutivo_peso_neto);
				
				Date fecha_vehiculo_porteria = (Date) row[57];
				materiaPrimaLoteA.setFecha_vehiculo_porteria(fecha_vehiculo_porteria);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<TiquetesBasculaProduccionInformeDTO> consultarTiqueteBasculaProduccionInforme(Long compania1,
			Date fechaInicial, Date fechaFinal, String equipo1, Long flagEquipo, String tiquete, Long flagTiquete,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String contratista, Long flagContratista, String tipoFecha) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_tiquetes_bascula_produccion  (:compania1, :fechaInicial, :fechaFinal, :equipo1, :flagEquipo, :tiquete, :flagTiquete, "
						+ ":zona, :flagZona,  :finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :contratista, :flagContratista, :tipoFecha)");

		q.setLong("compania1", compania1);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo1", equipo1);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("tiquete", tiquete);
		q.setLong("flagTiquete", flagTiquete);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);

		q.setLong("flagContratista", flagContratista);
		q.setString("contratista", contratista);
		q.setString("tipoFecha", tipoFecha);
		
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<TiquetesBasculaProduccionInformeDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<TiquetesBasculaProduccionInformeDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				TiquetesBasculaProduccionInformeDTO materiaPrimaLoteA = new TiquetesBasculaProduccionInformeDTO();

				BigInteger dat_trans_prod_id = (BigInteger) row[0];
				materiaPrimaLoteA.setDat_trans_prod_id(dat_trans_prod_id);
				BigInteger consecutivo = (BigInteger) row[1];
				materiaPrimaLoteA.setConsecutivo(consecutivo);
				Date fecha_registro = (Date) row[2];
				materiaPrimaLoteA.setFecha_registro(fecha_registro);
				String tipo_transaccion = (String) row[3];
				materiaPrimaLoteA.setTipo_transaccion(tipo_transaccion);
				String equipo = (String) row[4];
				materiaPrimaLoteA.setEquipo(equipo);
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
				String conductor = (String) row[13];
				materiaPrimaLoteA.setConductor(conductor);
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
				BigDecimal impurezas = (BigDecimal) row[30];
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

				String loteN = (String) row[40];
				materiaPrimaLoteA.setLote(loteN);

				String producto = (String) row[41];
				materiaPrimaLoteA.setProducto(producto);

				String nombreCompania = (String) row[42];
				materiaPrimaLoteA.setNombreCompania(nombreCompania);
				String nitCompania = (String) row[43];
				materiaPrimaLoteA.setNitCompania(nitCompania);
				String telefonoCompania = (String) row[44];
				materiaPrimaLoteA.setTelefonoCompania(telefonoCompania);
				String direccionCompania = (String) row[45];
				materiaPrimaLoteA.setDireccionCompania(direccionCompania);
				String ciudadCompania = (String) row[46];
				materiaPrimaLoteA.setCiudadCompania(ciudadCompania);

				String fechaImpresion = new String();
				materiaPrimaLoteA.setFechaImpresion(fechaImpresion);

				String zonaN = (String) row[47];
				materiaPrimaLoteA.setZona(zonaN);
				String fincaN = (String) row[48];
				materiaPrimaLoteA.setFinca(fincaN);

				String bloqueN = (String) row[49];
				materiaPrimaLoteA.setBloque(bloqueN);

				String variedad = (String) row[50];
				materiaPrimaLoteA.setVariedad(variedad);

				BigDecimal pesoPromedio = (BigDecimal) row[51];
				materiaPrimaLoteA.setPesoPromedio(pesoPromedio);

				BigDecimal produccionLote = (BigDecimal) row[52];
				materiaPrimaLoteA.setProduccionLote(produccionLote);

				BigDecimal areaCos = (BigDecimal) row[53];
				materiaPrimaLoteA.setAreaCosechada(areaCos);

				BigDecimal mes = (BigDecimal) row[54];
				materiaPrimaLoteA.setMes(mes);

				String mesCorto = (String) row[55];
				materiaPrimaLoteA.setMesCorto(mesCorto);

				BigDecimal anio = (BigDecimal) row[56];
				materiaPrimaLoteA.setAnio(anio);

				String proveedor = (String) row[57];
				materiaPrimaLoteA.setProveedor(proveedor);

				BigDecimal costoTotal = (BigDecimal) row[58];
				materiaPrimaLoteA.setCostoTotal(costoTotal);

				String tenencia = (String) row[59];
				materiaPrimaLoteA.setTenencia(tenencia);
				String categ_equipo = (String) row[60];
				materiaPrimaLoteA.setCateg_equipo(categ_equipo);
				String reg_despacho = (String) row[61];
				materiaPrimaLoteA.setReg_despacho(reg_despacho);
				String estado_almacenado = (String) row[62];
				materiaPrimaLoteA.setEstado_almacenado(estado_almacenado);
				BigDecimal tiempo_espera_hr = (BigDecimal) row[63];
				materiaPrimaLoteA.setTiempo_espera_hr(tiempo_espera_hr);
				BigDecimal tiempo_descargue_hr = (BigDecimal) row[64];
				materiaPrimaLoteA.setTiempo_descargue_hr(tiempo_descargue_hr);
				BigDecimal tiempo_total_hr = (BigDecimal) row[65];
				materiaPrimaLoteA.setTiempo_total_hr(tiempo_total_hr);
				BigInteger num_consecutivo_analisis = (BigInteger) row[66];
				materiaPrimaLoteA.setNum_consecutivo_analisis(num_consecutivo_analisis);
				BigDecimal descuento_impurezas = (BigDecimal) row[67];
				materiaPrimaLoteA.setDescuento_impurezas(descuento_impurezas);
				BigDecimal descuento_rac_podrido = (BigDecimal) row[68];
				materiaPrimaLoteA.setDescuento_rac_podrido(descuento_rac_podrido);
				BigDecimal racimos_maduros = (BigDecimal) row[69];
				materiaPrimaLoteA.setRacimos_maduros(racimos_maduros);
				BigDecimal racimos_verdes = (BigDecimal) row[70];
				materiaPrimaLoteA.setRacimos_verdes(racimos_verdes);
				BigDecimal racimos_sobremaduros = (BigDecimal) row[71];
				materiaPrimaLoteA.setRacimos_sobremaduros(racimos_sobremaduros);
				BigDecimal racimos_podridos = (BigDecimal) row[72];
				materiaPrimaLoteA.setRacimos_podridos(racimos_podridos);
				BigDecimal racimos_pend_largo = (BigDecimal) row[73];
				materiaPrimaLoteA.setRacimos_pend_largo(racimos_pend_largo);
				BigDecimal racimos_mal_formados = (BigDecimal) row[74];
				materiaPrimaLoteA.setRacimos_mal_formados(racimos_mal_formados);
				BigDecimal rango_impurezas = (BigDecimal) row[75];
				materiaPrimaLoteA.setRango_impurezas(rango_impurezas);
				BigDecimal ra_demotispa = (BigDecimal) row[76];
				materiaPrimaLoteA.setRa_demotispa(ra_demotispa);
				String usuario_analisis = (String) row[77];
				materiaPrimaLoteA.setUsuarioAnalisis(usuario_analisis);				
				
				BigInteger consecutivo_peso_neto = (BigInteger) row[78];
				materiaPrimaLoteA.setConsecutivo_peso_neto(consecutivo_peso_neto);
				Date fecha_vehiculo_porteria = (Date) row[79];
				materiaPrimaLoteA.setFecha_vehiculo_porteria(fecha_vehiculo_porteria);
				
				BigDecimal porc_racimos = (BigDecimal) row[80];
				materiaPrimaLoteA.setPorc_racimos(porc_racimos);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	/******************** ACTUALIZACION 09-03-2017 ****/

	@Override
	public List<ConsolidadoNominaDTO> consultarConsolidadoNomina(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String contratista, Long flagContratista) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_costos_nomina_consolidada (:compania, :fechaInicial,  :fechaFinal, "
						+ ":trabajador, :flagTrabajador, :contratista, :flagContratista )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("trabajador", trabajador);
		q.setLong("flagTrabajador", flagTrabajador);
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsolidadoNominaDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<ConsolidadoNominaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsolidadoNominaDTO nominaA = new ConsolidadoNominaDTO();

				Date fechaInicialC = (Date) row[1];
				Date fechaFinalC = (Date) row[2];
				String codTrabajador = (String) row[4];
				String nomTrabajador = (String) row[5];
				String codConcepto = (String) row[6];
				String nomConcepto = (String) row[7];
				BigDecimal valorTotalLote = (BigDecimal) row[9];

				String nomCompania = (String) row[10];
				String codZona = (String) row[11];
				String codFinca = (String) row[12];
				String nomFinca = (String) row[13];
				String codBloque = (String) row[14];
				String loteA = (String) row[15];
				String nomLote = (String) row[16];
				String origenDatos = (String) row[17];

				nominaA.setFechaInicial(fechaInicialC);
				nominaA.setFechaFinal(fechaFinalC);
				nominaA.setCodTrabajador(codTrabajador);
				nominaA.setNomTrabajador(nomTrabajador);
				nominaA.setCodConcepto(codConcepto);
				nominaA.setNomConcepto(nomConcepto);
				nominaA.setValorTotalLote(valorTotalLote);
				nominaA.setNombreCompania(nomCompania);
				nominaA.setCodZona(codZona);
				nominaA.setCodFinca(codFinca);
				nominaA.setNomFinca(nomFinca);
				nominaA.setCodBloque(codBloque);
				nominaA.setCodLote(loteA);
				nominaA.setNomLote(nomLote);
				nominaA.setOrigenDatos(origenDatos);

				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	@Override
	public List<CostosIndirectosDTO> consultarCostosIndirectos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String labor, Long flagLabor, String hacienda, Long flagHacienda,
			String lote, Long flagLote, String ccontable, Long flagCcontable) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_otros_costos (:compania, :fechaInicial,  :fechaFinal, "
				+ ":contratista, :flagContratista, :labor, :flagLabor, :hacienda, :flaghacienda, :lote, :flaglote,"
				+ ":ccontable, :flagccontable )");
		
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("labor", labor);
		q.setString("contratista", contratista);
		q.setString("hacienda", hacienda);
		q.setString("lote", lote);
		q.setString("ccontable", ccontable);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flaghacienda", flagHacienda);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flaglote", flagLote);
		q.setLong("flagccontable", flagCcontable);

		List l = q.list();
		List<CostosIndirectosDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<CostosIndirectosDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosIndirectosDTO nominaA = new CostosIndirectosDTO();

				BigInteger id = (BigInteger) row[0];
				Date fecha = (Date) row[1];
				String tipoTransaccion = (String) row[2];
				String codProveedor = (String) row[3];
				String nomProveedor = (String) row[4];
				String numFactura = (String) row[5];
				String observacion = (String) row[6];
				BigDecimal valorBruto = (BigDecimal) row[7];
				BigDecimal areaNetaLote = (BigDecimal) row[8];
				BigDecimal valorTotalLote = (BigDecimal) row[9];
				String nomCompania = (String) row[10];
				String codZona = (String) row[11];
				String codFinca = (String) row[12];
				String nomFinca = (String) row[13];
				String codBloque = (String) row[14];
				String nomBloque = (String) row[15];
				String loteA = (String) row[16];
				String nomLote = (String) row[17];
				String origenDatos = (String) row[18];							
				String codCuenta = (String) row[19];
				String nomCuenta = (String) row[20];
				String codElementoCosto = (String) row[21];
				String nomElementoCosto = (String) row[22];
				
				nominaA.setId(id);
				nominaA.setFecha(fecha);
				nominaA.setTipoTransaccion(tipoTransaccion);
				nominaA.setCodProveedor(codProveedor);
				nominaA.setNomProveedor(nomProveedor);
				nominaA.setNumFactura(numFactura);
				nominaA.setObservacion(observacion);
				nominaA.setValorBruto(valorBruto);
				nominaA.setAreaNetaLote(areaNetaLote);
				nominaA.setValorTotalLote(valorTotalLote);
				nominaA.setNombreCompania(nomCompania);
				nominaA.setCodZona(codZona);
				nominaA.setCodFinca(codFinca);
				nominaA.setNomFinca(nomFinca);
				nominaA.setCodBloque(codBloque);
				nominaA.setNomBloque(nomBloque);
				nominaA.setCodLote(loteA);
				nominaA.setNomLote(nomLote);
				nominaA.setOrigenDatos(origenDatos);
				nominaA.setNomCuenta(nomCuenta);
				nominaA.setCodCuenta(codCuenta);
				nominaA.setNomElementoCosto(nomElementoCosto);
				nominaA.setCodElementoCosto(codElementoCosto);

				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	@Override
	public long consultarConsecutivoConsolidadoNomina(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_consolidado_nomina (:compania)");
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
	public long consultarConsecutivoOtrosCostos(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_otros_costos (:compania)");
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

	/**** 18-03-2017*** */

	@Override
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoEjecucionLabores(Long compania, Long ordenTrabajoDet) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_lista_ot_det  (:compania, :ordenTrabajoDet )");
		q.setLong("compania", compania);
		q.setLong("ordenTrabajoDet", ordenTrabajoDet);

		List l = q.list();
		ArrayList<ConsultaOrdenTrabajoDesDTO> consultaOrdenTrabajoDesDTOS = new ArrayList<ConsultaOrdenTrabajoDesDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaOrdenTrabajoDesDTO consultaOrdenTrabajoDesDTO = new ConsultaOrdenTrabajoDesDTO();
				BigInteger idOt = (BigInteger) row[1];
				String descripcion = (String) row[3];
				BigInteger planLaborDetId = (BigInteger) row[4];
				BigInteger nivel1Id = (BigInteger) row[5];
				BigInteger nivel2Id = (BigInteger) row[8];
				BigInteger nivel3Id = (BigInteger) row[11];
				BigInteger nivel4Id = (BigInteger) row[14];
				BigInteger laborId = (BigInteger) row[17];
				BigInteger umId = (BigInteger) row[20];
				BigDecimal cantidadPlanId = (BigDecimal) row[23];
				BigDecimal pesoPromedio = (BigDecimal) row[24];
				String nombreNivel2 = (String) row[10];
				String nombreNivel4 = (String) row[16];
				String nombreLabor = (String) row[19];
				String nombreUdadmed = (String) row[22];

				consultaOrdenTrabajoDesDTO.setPlanLaborId(idOt);
				consultaOrdenTrabajoDesDTO.setDescripcion(descripcion);

				consultaOrdenTrabajoDesDTO.setPlanLaborDetId(planLaborDetId);
				consultaOrdenTrabajoDesDTO.setNivel1Id(nivel1Id);
				consultaOrdenTrabajoDesDTO.setNivel2Id(nivel2Id);
				consultaOrdenTrabajoDesDTO.setNivel3Id(nivel3Id);
				consultaOrdenTrabajoDesDTO.setNivel4Id(nivel4Id);
				consultaOrdenTrabajoDesDTO.setLaborId(laborId);
				consultaOrdenTrabajoDesDTO.setUmId(umId);
				consultaOrdenTrabajoDesDTO.setCantidadPlanId(cantidadPlanId);
				consultaOrdenTrabajoDesDTO.setPesoPromedio(pesoPromedio);
				consultaOrdenTrabajoDesDTO.setNombreLabor(nombreLabor);
				consultaOrdenTrabajoDesDTO.setNombreNivel2(nombreNivel2);
				consultaOrdenTrabajoDesDTO.setNombreNivel4(nombreNivel4);
				consultaOrdenTrabajoDesDTO.setNombreUdadMed(nombreUdadmed);

				consultaOrdenTrabajoDesDTOS.add(consultaOrdenTrabajoDesDTO);

				// consultaOtDes.add(consultaOt);

			}

		}
		return consultaOrdenTrabajoDesDTOS;

	}

	/**** 02-06-2017 ***/

	@Override
	public List<ListadoRecursosDTO> consultaListadoRecursos(Long tipoRecursoId) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_tp_recurso (:tipoRecursoId )");
		q.setLong("tipoRecursoId", tipoRecursoId);

		List l = q.list();
		ArrayList<ListadoRecursosDTO> consultaListadoRecursosDTO = new ArrayList<ListadoRecursosDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListadoRecursosDTO consultaListadoRecursosADTO = new ListadoRecursosDTO();
				BigInteger idTipoRecurso = (BigInteger) row[0];
				BigInteger idRecurso = (BigInteger) row[1];
				String codigoRecurso = (String) row[2];
				String nombreRecurso = (String) row[3];

				consultaListadoRecursosADTO.setTpRecursoId(idTipoRecurso);
				consultaListadoRecursosADTO.setRecursoId(idRecurso);

				consultaListadoRecursosADTO.setCodigoRecurso(codigoRecurso);
				consultaListadoRecursosADTO.setNombreRecurso(nombreRecurso);

				consultaListadoRecursosDTO.add(consultaListadoRecursosADTO);

				// consultaOtDes.add(consultaOt);

			}

		}
		return consultaListadoRecursosDTO;

	}

	@Override
	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLoteDet(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_cronograma_labores_detallado  (:compania,"
				+ ":fechaInicial, :fechaFinal,  :cultivo,  :flagCultivo,  :zona,"
				+ ":flagZona,  :finca,  :flagFinca,  :bloque," + ":flagBloque,  :lote,  :flagLote,  :labor,"
				+ ":flagLabor,   :unidadMedida,  :flagUnidadMedida," + ":grupoLabor,  :flagGrupoLabor,  :tenencia,"
				+ ":flagTenencia,  :cronogramaLabor,  :flagCronogramaLabor	)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cultivo", cultivo);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("unidadMedida", unidadMedida);
		q.setString("labor", labor);

		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("cronogramaLabor", cronogramaLabor);

		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);

		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagCronogramaLabor", flagCronogramaLabor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProyeccionLaboresLoteDTO> proyeccionLaboresLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			proyeccionLaboresLote = new ArrayList<ProyeccionLaboresLoteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProyeccionLaboresLoteDTO proyeccionLaboresLoteA = new ProyeccionLaboresLoteDTO();
				String nombreCompania = (String) row[0];
				String nombreSecuencia = (String) row[1];
				String nombreLabor = (String) row[2];
				String descripcion = (String) row[3];
				Date fInicial = (Date) row[4];
				Date fFinal = (Date) row[5];
				BigDecimal duracion = (BigDecimal) row[6];
				String cod_labor = (String) row[7];
				String cod_zona = (String) row[8];
				String nom_zona = (String) row[9];
				String cod_hacienda = (String) row[10];
				String nom_hacienda = (String) row[11];
				String cod_bloque = (String) row[12];
				String nom_bloque = (String) row[13];
				String cod_lote = (String) row[14];
				String nom_lote = (String) row[15];
				String nom_variedad = (String) row[16];
				String nom_etapa = (String) row[17];
				BigDecimal area_neta = (BigDecimal) row[18];
				BigDecimal numero_plantas = (BigDecimal) row[19];
				String trabajar_con_area_plantas = (String) row[20];
				String cod_tp_recurso = (String) row[21];
				String nom_tp_recurso = (String) row[22];
				String cod_recurso = (String) row[23];
				String nom_recursos = (String) row[24];
				String um_recurso = (String) row[25];
				String nom_elem_costo = (String) row[26];
				Date fi_tarifa = (Date) row[27];
				Date ff_tarifa = (Date) row[28];
				BigDecimal disponibilidad_dia = (BigDecimal) row[29];
				BigDecimal disponibilidad_total = (BigDecimal) row[30];
				BigDecimal valor_unit_recurso = (BigDecimal) row[31];
				BigDecimal rendimiento_recurso = (BigDecimal) row[32];
				BigDecimal cantidad_presupuestada = (BigDecimal) row[33];
				BigDecimal valor_presupuestado = (BigDecimal) row[34];
				String anio_mes = (String) row[35];
				proyeccionLaboresLoteA.setNombreCompania(nombreCompania);
				proyeccionLaboresLoteA.setNombreSecuencia(nombreSecuencia);
				proyeccionLaboresLoteA.setNombreLabor(nombreLabor);
				proyeccionLaboresLoteA.setDescripcion(descripcion);
				proyeccionLaboresLoteA.setFechaInicial(fInicial);
				proyeccionLaboresLoteA.setFechaFinal(fFinal);
				proyeccionLaboresLoteA.setDuracion(duracion);
				proyeccionLaboresLoteA.setCod_labor(cod_labor);
				proyeccionLaboresLoteA.setCod_zona(cod_zona);
				proyeccionLaboresLoteA.setNom_zona(nom_zona);
				proyeccionLaboresLoteA.setCod_hacienda(cod_hacienda);
				proyeccionLaboresLoteA.setNom_hacienda(nom_hacienda);
				proyeccionLaboresLoteA.setCod_bloque(cod_bloque);
				proyeccionLaboresLoteA.setNom_bloque(nom_bloque);
				proyeccionLaboresLoteA.setCod_lote(cod_lote);
				proyeccionLaboresLoteA.setNom_lote(nom_lote);
				proyeccionLaboresLoteA.setNom_variedad(nom_variedad);
				proyeccionLaboresLoteA.setNom_etapa(nom_etapa);
				proyeccionLaboresLoteA.setArea_neta(area_neta);
				proyeccionLaboresLoteA.setNumero_plantas(numero_plantas);
				proyeccionLaboresLoteA.setTrabajar_con_area_plantas(trabajar_con_area_plantas);
				proyeccionLaboresLoteA.setCod_tp_recurso(cod_tp_recurso);
				proyeccionLaboresLoteA.setNom_tp_recurso(nom_tp_recurso);
				proyeccionLaboresLoteA.setCod_recurso(cod_recurso);
				proyeccionLaboresLoteA.setNom_recursos(nom_recursos);
				proyeccionLaboresLoteA.setUm_recurso(um_recurso);
				proyeccionLaboresLoteA.setNom_elem_costo(nom_elem_costo);
				proyeccionLaboresLoteA.setFi_tarifa(fi_tarifa);
				proyeccionLaboresLoteA.setFf_tarifa(ff_tarifa);
				proyeccionLaboresLoteA.setDisponibilidad_dia(disponibilidad_dia);
				proyeccionLaboresLoteA.setDisponibilidad_total(disponibilidad_total);
				proyeccionLaboresLoteA.setValor_unit_recurso(valor_unit_recurso);
				proyeccionLaboresLoteA.setRendimiento_recurso(rendimiento_recurso);
				proyeccionLaboresLoteA.setCantidad_presupuestada(cantidad_presupuestada);
				proyeccionLaboresLoteA.setValor_presupuestado(valor_presupuestado);
				proyeccionLaboresLoteA.setAnio_mes(anio_mes);

				proyeccionLaboresLote.add(proyeccionLaboresLoteA);

			}
		}

		return proyeccionLaboresLote;
	}

	@Override
	public List<AnalisisEnfermedadVer2DTO> consultarAnalisisEnfermedadVer2(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String enfermedad, Long flagEnfermedad) {
		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_analisis_enfermedad_ver2 (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :enfermedad, :flagEnfermedad )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("enfermedad", enfermedad);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagEnfermedad", flagEnfermedad);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<AnalisisEnfermedadVer2DTO> analisisEnfermedad = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			analisisEnfermedad = new ArrayList<AnalisisEnfermedadVer2DTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				AnalisisEnfermedadVer2DTO analisisEnfermedadA = new AnalisisEnfermedadVer2DTO();
				String fecha = (String) row[0];
				BigInteger mes = (BigInteger) row[1];
				BigInteger anio = (BigInteger) row[2];
				String nomEnfermedad = (String) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				BigDecimal gradoSeveridad = (BigDecimal) row[9];
				String codLote = (String) row[8];
				String evolucion = (String) row[10];
				BigDecimal numCenso = (BigDecimal) row[11];
				BigDecimal linea = (BigDecimal) row[12];
				BigDecimal planta = (BigDecimal) row[13];
				Double latitud = (Double) row[14];
				Double longitud = (Double) row[15];

				String procedimiento = (String) row[16];
				String ubicacion = (String) row[17];

				analisisEnfermedadA.setFecha(fecha);
				analisisEnfermedadA.setAnio(anio);
				analisisEnfermedadA.setMes(mes);
				analisisEnfermedadA.setNombreEnfermedad(nomEnfermedad);
				analisisEnfermedadA.setCodZona(codZona);
				analisisEnfermedadA.setCodFinca(codFinca);
				analisisEnfermedadA.setNomFinca(nomFinca);
				analisisEnfermedadA.setCodBloque(codBloque);
				analisisEnfermedadA.setCodLote(codLote);
				analisisEnfermedadA.setGradoSeveridad(gradoSeveridad);
				analisisEnfermedadA.setEvolucion(evolucion);
				analisisEnfermedadA.setNumCenso(numCenso);
				analisisEnfermedadA.setLinea(linea);
				analisisEnfermedadA.setPlanta(planta);
				analisisEnfermedadA.setLatitud(latitud);
				analisisEnfermedadA.setLongitud(longitud);
				analisisEnfermedadA.setProcedimiento(procedimiento);
				analisisEnfermedadA.setUbicacion(ubicacion);

				analisisEnfermedad.add(analisisEnfermedadA);

			}
		}

		return analisisEnfermedad;
	}

	@Override
	public List<AnalisisPlagaVer2DTO> consultarAnalisisPlagaVer2(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String plaga, Long flagPlaga) {
		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_analisis_plaga_ver2 ( :compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :plaga, :flagPlaga )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("plaga", plaga);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagPlaga", flagPlaga);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<AnalisisPlagaVer2DTO> analisisPlaga = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			analisisPlaga = new ArrayList<AnalisisPlagaVer2DTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				AnalisisPlagaVer2DTO analisisPlagaA = new AnalisisPlagaVer2DTO();
				String fecha = (String) row[0];
				BigInteger mes = (BigInteger) row[1];
				BigInteger anio = (BigInteger) row[2];
				String nomPlaga = (String) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String codLote = (String) row[8];
				BigDecimal cantidadIndividuo = (BigDecimal) row[9];
				BigDecimal numHoja = (BigDecimal) row[10];
				BigDecimal linea = (BigDecimal) row[11];
				BigDecimal planta = (BigDecimal) row[12];
				Double latitud = (Double) row[13];
				Double longitud = (Double) row[14];

				BigDecimal numCenso = (BigDecimal) row[15];
				BigDecimal defoliacionProm = (BigDecimal) row[16];
				BigDecimal promIndividuosHoja = (BigDecimal) row[17];

				analisisPlagaA.setFecha(fecha);
				analisisPlagaA.setAnio(anio);
				analisisPlagaA.setMes(mes);
				analisisPlagaA.setNombrePlaga(nomPlaga);
				analisisPlagaA.setCodZona(codZona);
				analisisPlagaA.setCodFinca(codFinca);
				analisisPlagaA.setNomFinca(nomFinca);
				analisisPlagaA.setCodBloque(codBloque);
				analisisPlagaA.setCodLote(codLote);
				analisisPlagaA.setCantidadIndividuo(cantidadIndividuo);
				analisisPlagaA.setNumeroHoja(numHoja);
				analisisPlagaA.setLinea(linea);
				analisisPlagaA.setPlanta(planta);
				analisisPlagaA.setLatitud(latitud);
				analisisPlagaA.setLongitud(longitud);
				analisisPlagaA.setNumCenso(numCenso);
				analisisPlagaA.setDefoliacionProm(defoliacionProm);
				analisisPlagaA.setPromIndividuosHoja(promIndividuosHoja);

				analisisPlaga.add(analisisPlagaA);

			}
		}

		return analisisPlaga;
	}

	@Override
	public List<ConsultaEventosPorPagarDTO> consultarEventosPorPagar(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String propietario, Long flagPropietario, String evento, Long flagEvento) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_eventos_por_pagar (:compania, :fechaInicial,  :fechaFinal,  :equipo, :flagEquipo,"
						+ " :propietario, :flagPropietario, :evento, :flagEvento	)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("propietario", propietario);
		q.setString("equipo", equipo);
		q.setString("evento", evento);
		q.setLong("flagEvento", flagEvento);
		q.setLong("flagPropietario", flagPropietario);
		q.setLong("flagEquipo", flagEquipo);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaEventosPorPagarDTO> informe = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			informe = new ArrayList<ConsultaEventosPorPagarDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaEventosPorPagarDTO informeA = new ConsultaEventosPorPagarDTO();
				BigInteger companiaId = (BigInteger) row[0];
				BigInteger equipoId = (BigInteger) row[1];
				String codigoEquipo = (String) row[2];
				String nombreEquipo = (String) row[3];
				BigInteger idPropietario = (BigInteger) row[4];
				String nombrePropietario = (String) row[5];
				BigInteger idEvento = (BigInteger) row[6];
				String nombreEvento = (String) row[7];
				String elementoCosto = (String) row[8];
				BigInteger idEquipoEvento = (BigInteger) row[9];
				Date fechaIni = (Date) row[10];
				Date fechaFin = (Date) row[11];
				Date fechaPago = (Date) row[12];
				BigInteger idProveedor = (BigInteger) row[13];
				String nombreProveedor = (String) row[14];
				String registraPago = (String) row[15];
				String observacion = (String) row[16];
				BigDecimal valorEvento = (BigDecimal) row[17];

				informeA.setCompania(companiaId);
				informeA.setEquipoId(equipoId);
				informeA.setCodigoEquipo(codigoEquipo);
				informeA.setNombreEquipo(nombreEquipo);
				informeA.setIdPropietario(idPropietario);
				informeA.setPropietario(nombrePropietario);
				informeA.setIdEvento(idEvento);
				informeA.setNombreEvento(nombreEvento);
				informeA.setElementoCosto(elementoCosto);
				informeA.setIdEquipoEvento(idEquipoEvento);
				informeA.setFechaInicial(fechaIni);
				informeA.setFechaFinal(fechaFin);

				informeA.setFechaPago(fechaPago);
				informeA.setIdProveedor(idProveedor);
				informeA.setNombreProveedor(nombreProveedor);
				informeA.setRegistraPago(registraPago);
				informeA.setObservacion(observacion);

				informe.add(informeA);

			}
		}

		return informe;
	}

	@Override
	public long consultarConsecutivoOtrosCostosMq(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_otros_costos_mq (:compania)");
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
	public long consultarConsecutivoServRealizados(Long compania, Long equipoId) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_serv_realizados_equipo (:compania, :equipoId)");
		q.setLong("compania", compania);
		q.setLong("equipoId", equipoId);
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
	public long consultarConsecutivoRegistroHorasEquipo(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_registro_horas_equipo (:compania)");
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
	public long consultarConsecutivoPlanAnualFabrica(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_plan_anual_fabrica (:compania)");
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
	public long consultarConsecutivoCheckListEquipo(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_check_list_equipo (:compania)");
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
	public long consultarConsecutivoReporteFallasEquipo(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_reporte_fallas (:compania)");
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
	public List<CostosIndirectosEquipoDTO> consultarCostosIndirectosMq(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String labor, Long flagLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_otros_costos_maquinaria (:compania, :fechaInicial,  :fechaFinal, "
				+ ":contratista, :flagContratista, :labor, :flagLabor )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("labor", labor);
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagLabor", flagLabor);
		// q.setParameterList("finca", fincas);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<CostosIndirectosEquipoDTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<CostosIndirectosEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CostosIndirectosEquipoDTO nominaA = new CostosIndirectosEquipoDTO();

				Date fecha = (Date) row[1];
				String tipoTransaccion = (String) row[2];
				String codProveedor = (String) row[3];
				String nomProveedor = (String) row[4];
				String numFactura = (String) row[5];
				String nomLabor = (String) row[6];
				String nomElementoCosto = (String) row[7];
				String codEquipo = (String) row[8];
				String nomEquipo = (String) row[9];
				String descripcion = (String) row[10];
				String nomUdadMed = (String) row[11];

				BigDecimal cantidad = (BigDecimal) row[12];
				BigDecimal valorUnit = (BigDecimal) row[13];
				BigDecimal costoTotal = (BigDecimal) row[14];

				String observacion = (String) row[15];
				String nomCompania = (String) row[16];
				String origenDatos = (String) row[17];

				nominaA.setFecha(fecha);
				nominaA.setTipoTransaccion(tipoTransaccion);
				nominaA.setCodProveedor(codProveedor);
				nominaA.setNomProveedor(nomProveedor);
				nominaA.setNumFactura(numFactura);
				nominaA.setObservacion(observacion);
				nominaA.setNombreCompania(nomCompania);
				nominaA.setNomLabor(nomLabor);
				nominaA.setNomElementoCosto(nomElementoCosto);
				nominaA.setDescripcion(descripcion);
				nominaA.setNomUdadMed(nomUdadMed);
				nominaA.setCodEquipo(codEquipo);
				nominaA.setNomEquipo(nomEquipo);
				nominaA.setCantidad(cantidad);
				nominaA.setValorUnit(valorUnit);
				nominaA.setCostoTotal(costoTotal);
				nominaA.setNombreCompania(nomCompania);
				nominaA.setOrigenDatos(origenDatos);

				nominaA.setOrigenDatos(origenDatos);

				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	@Override
	public List<ProduccionLoteArcansasDTO> consultarProduccionLoteArcansas(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote) {
		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_produccion_palma_arcansas( :compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProduccionLoteArcansasDTO> analisis = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			analisis = new ArrayList<ProduccionLoteArcansasDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProduccionLoteArcansasDTO analisisA = new ProduccionLoteArcansasDTO();
				Date max_fecha_apuntamiento = (Date) row[0];
				String max_fecha_pesaje = (String) row[1];
				String cod_zona = (String) row[2];
				String nom_zona = (String) row[3];
				String cod_hacienda = (String) row[4];
				String nom_hacienda = (String) row[5];
				String cod_bloque = (String) row[6];
				String nom_bloque = (String) row[7];
				String cod_lote = (String) row[8];
				String nom_lote = (String) row[9];
				String cod_labor = (String) row[10];
				String nom_labor = (String) row[11];
				String nombre_udadmed = (String) row[12];
				BigDecimal no_racimos = (BigDecimal) row[13];
				BigDecimal peso_promedio = (BigDecimal) row[14];
				BigDecimal total_racimos = (BigDecimal) row[15];
				BigDecimal peso_promedio_total_racimos = (BigDecimal) row[16];
				BigDecimal peso_total_esperado = (BigDecimal) row[17];
				BigDecimal peso_camion = (BigDecimal) row[18];
				BigDecimal diferencia_pesos = (BigDecimal) row[19];
				BigDecimal diferencia_por_racimos = (BigDecimal) row[20];
				BigDecimal peso_real_racimo_total = (BigDecimal) row[21];
				BigDecimal peso_promedio_racimo_real_lote = (BigDecimal) row[22];
				BigDecimal produccion_lote_kg = (BigDecimal) row[23];
				BigDecimal numero_remision = (BigDecimal) row[24];
				BigInteger consecutivo_produccion = (BigInteger) row[25];

				analisisA.setMax_fecha_apuntamiento(max_fecha_apuntamiento);
				analisisA.setMax_fecha_pesaje(max_fecha_pesaje);
				analisisA.setCod_zona(cod_zona);
				analisisA.setNom_zona(nom_zona);
				analisisA.setCod_hacienda(cod_hacienda);
				analisisA.setNom_hacienda(nom_hacienda);
				analisisA.setCod_bloque(cod_bloque);
				analisisA.setNom_bloque(nom_bloque);
				analisisA.setCod_lote(cod_lote);
				analisisA.setNom_lote(nom_lote);
				analisisA.setCod_labor(cod_labor);
				analisisA.setNom_labor(nom_labor);
				analisisA.setNombre_udadmed(nombre_udadmed);
				analisisA.setNo_racimos(no_racimos);
				analisisA.setPeso_promedio(peso_promedio);
				analisisA.setTotal_racimos(total_racimos);
				analisisA.setPeso_promedio_total_racimos(peso_promedio_total_racimos);
				analisisA.setPeso_total_esperado(peso_total_esperado);
				analisisA.setPeso_camion(peso_camion);
				analisisA.setDiferencia_pesos(diferencia_pesos);
				analisisA.setDiferencia_por_racimos(diferencia_por_racimos);
				analisisA.setPeso_real_racimo_total(peso_real_racimo_total);
				analisisA.setPeso_promedio_racimo_real_lote(peso_promedio_racimo_real_lote);
				analisisA.setProduccion_lote_kg(produccion_lote_kg);
				analisisA.setNumero_remision(numero_remision);
				analisisA.setConsecutivo_produccion(consecutivo_produccion);

				analisis.add(analisisA);

			}
		}

		return analisis;
	}

	@Override
	public List<MttoReporteFallasEquipoDTO> consultarInformeReporteFallasEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_reporte_fallas (:compania, :fechaInicial,  :fechaFinal,"
				+ " :propietario, :flagPropietario, :equipo, :flagEquipo )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("propietario", propietario);
		q.setString("equipo", equipo);
		// q.setString("tipoMtto", tipoMtto);

		q.setLong("flagPropietario", flagPropietario);
		q.setLong("flagEquipo", flagEquipo);
		// q.setLong("flagTipoMtto", flagTipoMtto);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<MttoReporteFallasEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<MttoReporteFallasEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				MttoReporteFallasEquipoDTO reporteA = new MttoReporteFallasEquipoDTO();

				Date fecha_registro = (Date) row[0];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				String cod_equipo = (String) row[2];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[3];
				reporteA.setNom_equipo(nom_equipo);
				String nom_medidor = (String) row[4];
				reporteA.setNom_medidor(nom_medidor);
				BigDecimal horometro_entrada = (BigDecimal) row[5];
				reporteA.setHorometro_entrada(horometro_entrada);
				BigDecimal odomentro_entrada = (BigDecimal) row[6];
				reporteA.setOdomentro_entrada(odomentro_entrada);
				String motivo_entrda_taller = (String) row[7];
				reporteA.setMotivo_entrda_taller(motivo_entrda_taller);
				String agente_causador = (String) row[8];
				reporteA.setAgente_causador(agente_causador);
				String cod_operario_maquina = (String) row[9];
				reporteA.setCod_operario_maquina(cod_operario_maquina);
				String nom_operario_maquina = (String) row[10];
				reporteA.setNom_operario_maquina(nom_operario_maquina);
				String cod_supervisor_mtto = (String) row[11];
				reporteA.setCod_supervisor_mtto(cod_supervisor_mtto);
				String nom_supervisor_mtto = (String) row[12];
				reporteA.setNom_supervisor_mtto(nom_supervisor_mtto);
				String descripcion_falla = (String) row[13];
				reporteA.setDescripcion_falla(descripcion_falla);
				String hora_inicial_parada = (String) row[14];
				reporteA.setHora_inicial_parada(hora_inicial_parada);
				String hora_final_parada = (String) row[15];
				reporteA.setHora_final_parada(hora_final_parada);
				BigDecimal duracion_real_hh = (BigDecimal) row[16];
				reporteA.setDuracion_real_hh(duracion_real_hh);
				BigInteger dat_reporte_fallas_id = (BigInteger) row[17];
				reporteA.setDat_reporte_fallas_id(dat_reporte_fallas_id);
				String codtag = (String) row[18];
				reporteA.setCodtag(codtag);
				String nombretag = (String) row[19];
				reporteA.setNombretag(nombretag);
				Integer anio = (Integer) row[20];
				reporteA.setAnio(anio);
				String mes_corto = (String) row[21];
				reporteA.setMes_corto(mes_corto);

				// reporteA.setFecha_entrada_taller(fecha_entrada_taller);

				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<CalculoProxMttoDTO> consultarProximoMtto(Date fechaentrada, Long equipoid, Long planrevisionid,
			Double horasmtto, Double kmmtto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_calculo_prox_mtto (:fechaentrada, :equipoid," + ":planrevisionid, :horasmtto, :kmmtto)");

		q.setDate("fechaentrada", fechaentrada);
		q.setLong("equipoid", equipoid);
		q.setLong("planrevisionid", planrevisionid);
		q.setDouble("horasmtto", horasmtto);
		q.setDouble("kmmtto", kmmtto);

		// execute stored procedure and get list result
		List l = q.list();
		List<CalculoProxMttoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<CalculoProxMttoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CalculoProxMttoDTO reporteA = new CalculoProxMttoDTO();

				BigInteger equipo_id = (BigInteger) row[0];
				reporteA.setEquipo_id(equipo_id);
				String cod_equipo = (String) row[1];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[2];
				reporteA.setNom_equipo(nom_equipo);
				BigInteger planRev_id = (BigInteger) row[3];
				reporteA.setPlan_revision_equipo_id(planRev_id);
				String cod_planRev = (String) row[4];
				reporteA.setCod_plan_revision(cod_planRev);
				String nom_plan = (String) row[5];
				reporteA.setNombre_plan_revision(nom_plan);
				Date fechaProxMtto = (Date) row[6];
				reporteA.setFecha_prox_mtto(fechaProxMtto);
				BigDecimal kmProxMtto = (BigDecimal) row[7];
				reporteA.setKm_prox_mtto(kmProxMtto);
				BigDecimal horasProxMtto = (BigDecimal) row[8];
				reporteA.setHoras_prox_mtto(horasProxMtto);
				BigInteger plandetid = (BigInteger) row[9];
				reporteA.setPlan_revision_equipo_det_id(plandetid);

				
				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<MttoHorasTrabajadasEquipoDTO> consultarInformeHorasTrabajoEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_horas_trabajadas_equipo (:compania, :fechaInicial,  :fechaFinal,"
				+ " :propietario, :flagPropietario, :equipo, :flagEquipo )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("propietario", propietario);
		q.setString("equipo", equipo);

		q.setLong("flagPropietario", flagPropietario);
		q.setLong("flagEquipo", flagEquipo);

		// execute stored procedure and get list result
		List l = q.list();
		List<MttoHorasTrabajadasEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<MttoHorasTrabajadasEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				MttoHorasTrabajadasEquipoDTO reporteA = new MttoHorasTrabajadasEquipoDTO();

				Date fecha_registro = (Date) row[0];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				String cod_equipo = (String) row[2];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[3];
				reporteA.setNom_equipo(nom_equipo);
				String nom_medidor = (String) row[4];
				reporteA.setNom_medidor(nom_medidor);
				BigDecimal horometro_registrado = (BigDecimal) row[5];
				reporteA.setHorometro_registrado(horometro_registrado);
				BigDecimal odomentro_registrado = (BigDecimal) row[6];
				reporteA.setOdomentro_registrado(odomentro_registrado);
				BigInteger dat_horas_trabajo_equipo_id = (BigInteger) row[7];
				reporteA.setDat_horas_trabajo_equipo_id(dat_horas_trabajo_equipo_id);
				Integer anio = (Integer) row[8];
				reporteA.setAnio(anio);
				String mes_corto = (String) row[9];
				reporteA.setMes_corto(mes_corto);

				// reporteA.setFecha_entrada_taller(fecha_entrada_taller);

				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<MttoSalidaCombustibleEquipoDTO> consultarInformeSalidasCombustibleEquipo(Long compania,
			Date fechaInicial, Date fechaFinal, String propietario, Long flagPropietario, String equipo,
			Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_salida_combustible_equipo (:compania, :fechaInicial,  :fechaFinal,"
				+ " :propietario, :flagPropietario, :equipo, :flagEquipo )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("propietario", propietario);
		q.setString("equipo", equipo);
		// q.setString("tipoMtto", tipoMtto);

		q.setLong("flagPropietario", flagPropietario);
		q.setLong("flagEquipo", flagEquipo);
		// q.setLong("flagTipoMtto", flagTipoMtto);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<MttoSalidaCombustibleEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<MttoSalidaCombustibleEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				MttoSalidaCombustibleEquipoDTO reporteA = new MttoSalidaCombustibleEquipoDTO();
				Date fecha_registro = (Date) row[0];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				BigInteger numero_planilla_fisica = (BigInteger) row[2];
				reporteA.setNumero_planilla_fisica(numero_planilla_fisica);
				String cod_equipo = (String) row[3];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[4];
				reporteA.setNom_equipo(nom_equipo);
				String nom_medidor = (String) row[5];
				reporteA.setNom_medidor(nom_medidor);
				BigDecimal horometro_entrada = (BigDecimal) row[6];
				reporteA.setHorometro_entrada(horometro_entrada);
				BigDecimal odomentro_entrada = (BigDecimal) row[7];
				reporteA.setOdomentro_entrada(odomentro_entrada);
				String nom_tipo_abastecimiento = (String) row[8];
				reporteA.setNom_tipo_abastecimiento(nom_tipo_abastecimiento);
				String nom_bomba_abastecimiento = (String) row[9];
				reporteA.setNom_bomba_abastecimiento(nom_bomba_abastecimiento);
				String cod_almacen = (String) row[10];
				reporteA.setCod_almacen(cod_almacen);
				String nom_almacen = (String) row[11];
				reporteA.setNom_almacen(nom_almacen);
				String cod_despachador = (String) row[12];
				reporteA.setCod_despachador(cod_despachador);
				String nom_despachador = (String) row[13];
				reporteA.setNom_despachador(nom_despachador);
				String cod_conductor = (String) row[14];
				reporteA.setCod_conductor(cod_conductor);
				String nom_conductor = (String) row[15];
				reporteA.setNom_conductor(nom_conductor);
				String cod_producto = (String) row[16];
				reporteA.setCod_producto(cod_producto);
				String nom_producto = (String) row[17];
				reporteA.setNom_producto(nom_producto);
				String cod_um_producto = (String) row[18];
				reporteA.setCod_um_producto(cod_um_producto);
				String nom_um_producto = (String) row[19];
				reporteA.setNom_um_producto(nom_um_producto);
				BigDecimal cantidad = (BigDecimal) row[20];
				reporteA.setCantidad(cantidad);
				BigDecimal valor_unitario = (BigDecimal) row[21];
				reporteA.setValor_unitario(valor_unitario);
				BigDecimal costo_total = (BigDecimal) row[22];
				reporteA.setCosto_total(costo_total);
				String observacion = (String) row[23];
				reporteA.setObservacion(observacion);
				BigInteger dat_abast_combustible_id = (BigInteger) row[24];
				reporteA.setDat_abast_combustible_id(dat_abast_combustible_id);
				Integer anio = (Integer) row[25];
				reporteA.setAnio(anio);
				String mes_corto = (String) row[26];
				reporteA.setMes_corto(mes_corto);

				// reporteA.setFecha_entrada_taller(fecha_entrada_taller);

				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<MttoPlanFabricaDTO> consultarInformePlanFabrica(Long compania, Long anioInicial, Long anioFinal) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_plan_fabrica (:compania, :anioInicial, :anioFinal )");

		q.setLong("compania", compania);
		q.setLong("anioInicial", anioInicial);
		q.setLong("anioFinal", anioFinal);

		List l = q.list();
		List<MttoPlanFabricaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<MttoPlanFabricaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				MttoPlanFabricaDTO reporteA = new MttoPlanFabricaDTO();

				BigInteger dat_plan_anual_fabrica_id = (BigInteger) row[0];
				BigInteger consecutivo = (BigInteger) row[1];
				BigInteger anio = (BigInteger) row[2];
				BigDecimal horas_arranque = (BigDecimal) row[3];
				BigDecimal produccion_est_enero = (BigDecimal) row[4];
				BigDecimal produccion_est_febrero = (BigDecimal) row[5];
				BigDecimal produccion_est_marzo = (BigDecimal) row[6];
				BigDecimal produccion_est_abril = (BigDecimal) row[7];
				BigDecimal produccion_est_mayo = (BigDecimal) row[8];
				BigDecimal produccion_est_junio = (BigDecimal) row[9];
				BigDecimal produccion_est_julio = (BigDecimal) row[10];
				BigDecimal produccion_est_agosto = (BigDecimal) row[11];
				BigDecimal produccion_est_septiembre = (BigDecimal) row[12];
				BigDecimal produccion_est_octubre = (BigDecimal) row[13];
				BigDecimal produccion_est_noviembre = (BigDecimal) row[14];
				BigDecimal produccion_est_diciembre = (BigDecimal) row[15];
				BigDecimal produccion_est_total = (BigDecimal) row[16];
				BigDecimal produccion_enero = (BigDecimal) row[17];
				BigDecimal produccion_febrero = (BigDecimal) row[18];
				BigDecimal produccion_marzo = (BigDecimal) row[19];
				BigDecimal produccion_abril = (BigDecimal) row[20];
				BigDecimal produccion_mayo = (BigDecimal) row[21];
				BigDecimal produccion_junio = (BigDecimal) row[22];
				BigDecimal produccion_julio = (BigDecimal) row[23];
				BigDecimal produccion_agosto = (BigDecimal) row[24];
				BigDecimal produccion_septiembre = (BigDecimal) row[25];
				BigDecimal produccion_octubre = (BigDecimal) row[26];
				BigDecimal produccion_noviembre = (BigDecimal) row[27];
				BigDecimal produccion_diciembre = (BigDecimal) row[28];
				BigDecimal produccion_total = (BigDecimal) row[29];
				BigDecimal velocidad_estandar = (BigDecimal) row[30];
				BigDecimal horas_proceso_est = (BigDecimal) row[31];
				BigDecimal horas_proceso_ejec = (BigDecimal) row[32];
				BigDecimal horas_mtto_prog_est = (BigDecimal) row[33];
				BigDecimal horas_mtto_prog_ejec = (BigDecimal) row[34];
				BigDecimal horas_mtto_no_prog_est = (BigDecimal) row[35];
				BigDecimal horas_mtto_no_prog_ejec = (BigDecimal) row[36];
				BigDecimal horas_planta_est = (BigDecimal) row[37];
				BigDecimal horas_planta_ejec = (BigDecimal) row[38];
				BigDecimal valor_promedio_hr_dia = (BigDecimal) row[39];
				String nom_compania = (String) row[40];
				String observacion = (String) row[41];

				reporteA.setDat_plan_anual_fabrica_id(dat_plan_anual_fabrica_id);
				reporteA.setConsecutivo(consecutivo);
				reporteA.setAnio(anio);
				reporteA.setHoras_arranque(horas_arranque);
				reporteA.setProduccion_est_enero(produccion_est_enero);
				reporteA.setProduccion_est_febrero(produccion_est_febrero);
				reporteA.setProduccion_est_marzo(produccion_est_marzo);
				reporteA.setProduccion_est_abril(produccion_est_abril);
				reporteA.setProduccion_est_mayo(produccion_est_mayo);
				reporteA.setProduccion_est_junio(produccion_est_junio);
				reporteA.setProduccion_est_julio(produccion_est_julio);
				reporteA.setProduccion_est_agosto(produccion_est_agosto);
				reporteA.setProduccion_est_septiembre(produccion_est_septiembre);
				reporteA.setProduccion_est_octubre(produccion_est_octubre);
				reporteA.setProduccion_est_noviembre(produccion_est_noviembre);
				reporteA.setProduccion_est_diciembre(produccion_est_diciembre);
				reporteA.setProduccion_est_total(produccion_est_total);
				reporteA.setProduccion_enero(produccion_enero);
				reporteA.setProduccion_febrero(produccion_febrero);
				reporteA.setProduccion_marzo(produccion_marzo);
				reporteA.setProduccion_abril(produccion_abril);
				reporteA.setProduccion_mayo(produccion_mayo);
				reporteA.setProduccion_junio(produccion_junio);
				reporteA.setProduccion_julio(produccion_julio);
				reporteA.setProduccion_agosto(produccion_agosto);
				reporteA.setProduccion_septiembre(produccion_septiembre);
				reporteA.setProduccion_octubre(produccion_octubre);
				reporteA.setProduccion_noviembre(produccion_noviembre);
				reporteA.setProduccion_diciembre(produccion_diciembre);
				reporteA.setProduccion_total(produccion_total);
				reporteA.setVelocidad_estandar(velocidad_estandar);
				reporteA.setHoras_proceso_est(horas_proceso_est);
				reporteA.setHoras_proceso_ejec(horas_proceso_ejec);
				reporteA.setHoras_mtto_prog_est(horas_mtto_prog_est);
				reporteA.setHoras_mtto_prog_ejec(horas_mtto_prog_ejec);
				reporteA.setHoras_mtto_no_prog_est(horas_mtto_no_prog_est);
				reporteA.setHoras_mtto_no_prog_ejec(horas_mtto_no_prog_ejec);
				reporteA.setHoras_planta_est(horas_planta_est);
				reporteA.setHoras_planta_ejec(horas_planta_ejec);
				reporteA.setValor_promedio_hr_dia(valor_promedio_hr_dia);
				reporteA.setNom_compania(nom_compania);
				reporteA.setObservacion(observacion);

				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<MttoCheckListEquipoDTO> consultarInformeCheckListEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_check_list_equipo (:compania, :fechaInicial,  :fechaFinal,"
				+ " :propietario, :flagPropietario, :equipo, :flagEquipo )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("propietario", propietario);
		q.setString("equipo", equipo);
		// q.setString("tipoMtto", tipoMtto);

		q.setLong("flagPropietario", flagPropietario);
		q.setLong("flagEquipo", flagEquipo);
		// q.setLong("flagTipoMtto", flagTipoMtto);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<MttoCheckListEquipoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<MttoCheckListEquipoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				MttoCheckListEquipoDTO reporteA = new MttoCheckListEquipoDTO();

				Date fecha_registro = (Date) row[0];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger consecutivo = (BigInteger) row[1];
				reporteA.setConsecutivo(consecutivo);
				String cod_equipo = (String) row[2];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[3];
				reporteA.setNom_equipo(nom_equipo);
				String nom_medidor = (String) row[4];
				reporteA.setNom_medidor(nom_medidor);
				BigDecimal horometro_entrada = (BigDecimal) row[5];
				reporteA.setHorometro_entrada(horometro_entrada);
				BigDecimal odomentro_entrada = (BigDecimal) row[6];
				reporteA.setOdomentro_entrada(odomentro_entrada);
				String cod_supervisor_mtto = (String) row[7];
				reporteA.setCod_supervisor_mtto(cod_supervisor_mtto);
				String nom_supervisor_mtto = (String) row[8];
				reporteA.setNom_supervisor_mtto(nom_supervisor_mtto);
				String observacion = (String) row[9];
				reporteA.setObservacion(observacion);
				BigInteger dat_check_list_equipo_id = (BigInteger) row[10];
				reporteA.setDat_check_list_equipo_id(dat_check_list_equipo_id);
				String codtag = (String) row[11];
				reporteA.setCodtag(codtag);
				String nombretag = (String) row[12];
				reporteA.setNombretag(nombretag);
				Integer anio = (Integer) row[13];
				reporteA.setAnio(anio);
				String mes_corto = (String) row[14];
				reporteA.setMes_corto(mes_corto);
				String cod_sistemas_equipo = (String) row[15];
				reporteA.setCod_sistemas_equipo(cod_sistemas_equipo);
				String nom_sistemas_equipo = (String) row[16];
				reporteA.setNom_sistemas_equipo(nom_sistemas_equipo);
				String cod_compartimiento_equipo = (String) row[17];
				reporteA.setCod_compartimiento_equipo(cod_compartimiento_equipo);
				String nom_compartimiento_equipo = (String) row[18];
				reporteA.setNom_compartimiento_equipo(nom_compartimiento_equipo);
				String condicion_limpieza = (String) row[19];
				reporteA.setCondicion_limpieza(condicion_limpieza);
				String condicion_ruido = (String) row[20];
				reporteA.setCondicion_ruido(condicion_ruido);
				String condicion_soldadura = (String) row[21];
				reporteA.setCondicion_soldadura(condicion_soldadura);
				String condicion_conexiones = (String) row[22];
				reporteA.setCondicion_conexiones(condicion_conexiones);
				String condicion_vibracion = (String) row[23];
				reporteA.setCondicion_vibracion(condicion_vibracion);
				String condicion_estado_general = (String) row[24];
				reporteA.setCondicion_estado_general(condicion_estado_general);
				String condicion_pintura = (String) row[25];
				reporteA.setCondicion_pintura(condicion_pintura);
				String condicion_lubricantes = (String) row[26];
				reporteA.setCondicion_lubricantes(condicion_lubricantes);

				// reporteA.setFecha_entrada_taller(fecha_entrada_taller);

				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<MttoProyeccionMttoDTO> consultarInformeProyeccionMtto(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String planRevision, Long flagPlanRevision) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_proyeccion_mtto (:compania, :fechaInicial,  :fechaFinal,"
				+ " :equipo, :flagEquipo, :planRevision, :flagPlanRevision )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setString("planRevision", planRevision);

		q.setLong("flagEquipo", flagEquipo);
		q.setLong("flagPlanRevision", flagPlanRevision);

		List l = q.list();
		List<MttoProyeccionMttoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<MttoProyeccionMttoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				MttoProyeccionMttoDTO reporteA = new MttoProyeccionMttoDTO();

				BigInteger id_programa = (BigInteger) row[0];
				reporteA.setId_programa(id_programa);
				BigInteger plan_revision_equipo_id = (BigInteger) row[1];
				reporteA.setPlan_revision_equipo_id(plan_revision_equipo_id);
				String nombre_plan_revision = (String) row[2];
				reporteA.setNombre_plan_revision(nombre_plan_revision);
				BigInteger medidor_id = (BigInteger) row[3];
				reporteA.setMedidor_id(medidor_id);
				String nombre_medidor = (String) row[4];
				reporteA.setNombre_medidor(nombre_medidor);
				String tipo_medidor = (String) row[5];
				reporteA.setTipo_medidor(tipo_medidor);
				BigInteger equipo_id = (BigInteger) row[6];
				reporteA.setEquipo_id(equipo_id);
				String cod_equipo = (String) row[7];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[8];
				reporteA.setNom_equipo(nom_equipo);
				BigInteger cent_cost_id = (BigInteger) row[9];
				reporteA.setCent_cost_id(cent_cost_id);
				String centro_costo = (String) row[10];
				reporteA.setCentro_costo(centro_costo);
				BigInteger tag_id = (BigInteger) row[11];
				reporteA.setTag_id(tag_id);
				String nombretag = (String) row[12];
				reporteA.setNombretag(nombretag);
				BigInteger sistemas_equipo_id = (BigInteger) row[13];
				reporteA.setSistemas_equipo_id(sistemas_equipo_id);
				String nombre_sistema_equipo = (String) row[14];
				reporteA.setNombre_sistema_equipo(nombre_sistema_equipo);
				BigInteger compartimientos_equipo_id = (BigInteger) row[15];
				reporteA.setCompartimientos_equipo_id(compartimientos_equipo_id);
				String nombre_compartimiento_equipo = (String) row[16];
				reporteA.setNombre_compartimiento_equipo(nombre_compartimiento_equipo);
				BigDecimal periocidad_hora = (BigDecimal) row[17];
				reporteA.setPeriocidad_hora(periocidad_hora);
				BigDecimal horas_dia_estandar = (BigDecimal) row[18];
				reporteA.setHoras_dia_estandar(horas_dia_estandar);
				BigDecimal horometro_inicial = (BigDecimal) row[19];
				reporteA.setHorometro_inicial(horometro_inicial);
				BigDecimal horas_prox_mtto = (BigDecimal) row[20];
				reporteA.setHoras_prox_mtto(horas_prox_mtto);
				Date fecha_prox_mtto = (Date) row[21];
				reporteA.setFecha_prox_mtto(fecha_prox_mtto);
				String cod_tp_recurso = (String) row[22];
				reporteA.setCod_tp_recurso(cod_tp_recurso);
				String nom_tp_recurso = (String) row[23];
				reporteA.setNom_tp_recurso(nom_tp_recurso);
				String cod_recurso = (String) row[24];
				reporteA.setCod_recurso(cod_recurso);
				String nom_recursos = (String) row[25];
				reporteA.setNom_recursos(nom_recursos);
				String um_recurso = (String) row[26];
				reporteA.setUm_recurso(um_recurso);
				String nom_elem_costo_recurso = (String) row[27];
				reporteA.setNom_elem_costo_recurso(nom_elem_costo_recurso);
				String fecha_costo_inicial_rec = (String) row[28];
				reporteA.setFecha_costo_inicial_rec(fecha_costo_inicial_rec);
				String fecha_costo_final_rec = (String) row[29];
				reporteA.setFecha_costo_final_rec(fecha_costo_final_rec);
				BigDecimal disponibilidad_dia_rec = (BigDecimal) row[30];
				reporteA.setDisponibilidad_dia_rec(disponibilidad_dia_rec);
				BigDecimal disponibilidad_total_rec = (BigDecimal) row[31];
				reporteA.setDisponibilidad_total_rec(disponibilidad_total_rec);
				BigDecimal valor_recurso = (BigDecimal) row[32];
				reporteA.setValor_recurso(valor_recurso);

				Integer anio = (Integer) row[33];
				reporteA.setAnio(anio);

				String mes = (String) row[34];
				reporteA.setMes(mes);

				// reporteA.setFecha_entrada_taller(fecha_entrada_taller);

				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public BigDecimal consultarHorometroActual(Date idFecha, Long idEquipo, Long idMedidor, Long idCompania) {
		BigDecimal reporte = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_horometro_actual_equipo (:idFecha, :idEquipo,  :idMedidor, :idCompania)");

		q.setDate("idFecha", idFecha);
		q.setLong("idEquipo", idEquipo);
		q.setLong("idMedidor", idMedidor);
		q.setLong("idCompania", idCompania);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l != null && l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal reporteA = (BigDecimal) it.next();
				reporte = reporteA;
			}
		}
		return reporte;

	}

	@Override
	public BigDecimal consultarOdometroActual(Date idFecha, Long idEquipo, Long idMedidor, Long idCompania) {
		BigDecimal reporte = null;
		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		SQLQuery q = session.createSQLQuery(
				"call pr_consulta_odometro_actual_equipo ( :idFecha, :idEquipo,  :idMedidor, :idCompania )");

		q.setDate("idFecha", idFecha);
		q.setLong("idEquipo", idEquipo);
		q.setLong("idMedidor", idMedidor);
		q.setLong("idCompania", idCompania);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal reporteA = (BigDecimal) it.next();
				reporte = reporteA;
			}
		}
		return reporte;

	}

	@Override
	public List<ConsultaSolicitudesParaMttoDTO> consultaSolicitudesParaMtto(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String tipoMtto, Long flagTipoMtto, String solicitante,
			Long flagSolicitante, String nivelPrioridad, Long flagNivelPrioridad, String origenDatos) throws Exception {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_solicitudes_para_os_mtto (:compania, :fechaInicial,  :fechaFinal,"
				+ "  :equipo, :flagEquipo,  :tipoMtto,  :flagTipoMtto,  :solicitante, :flagSolicitante,"
				+ "   :nivelPrioridad, :flagNivelPrioridad , :origenDatos)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setString("tipoMtto", tipoMtto);
		q.setString("solicitante", solicitante);
		q.setString("nivelPrioridad", nivelPrioridad);
		q.setString("origenDatos", origenDatos);

		q.setLong("flagTipoMtto", flagTipoMtto);
		q.setLong("flagSolicitante", flagSolicitante);
		q.setLong("flagEquipo", flagEquipo);
		q.setLong("flagTipoMtto", flagTipoMtto);
		q.setLong("flagNivelPrioridad", flagNivelPrioridad);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaSolicitudesParaMttoDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<ConsultaSolicitudesParaMttoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaSolicitudesParaMttoDTO reporteA = new ConsultaSolicitudesParaMttoDTO();

				BigInteger ncompania = (BigInteger) row[0];
				reporteA.setCompania(ncompania);
				BigInteger dat_solicitudes_mtto_id = (BigInteger) row[1];
				reporteA.setDat_solicitudes_mtto_id(dat_solicitudes_mtto_id);
				Date fecha_registro = (Date) row[2];
				reporteA.setFecha_registro(fecha_registro);
				BigInteger consecutivo = (BigInteger) row[3];
				reporteA.setConsecutivo(consecutivo);
				BigInteger trab_solicitante_id = (BigInteger) row[4];
				reporteA.setTrab_solicitante_id(trab_solicitante_id);
				String nom_trabajador = (String) row[5];
				reporteA.setNom_trabajador(nom_trabajador);
				BigInteger zonas_fabrica_id = (BigInteger) row[6];
				reporteA.setZonas_fabrica_id(zonas_fabrica_id);
				String nom_zona = (String) row[7];
				reporteA.setNom_zona(nom_zona);
				BigInteger tipo_mantenimiento_id = (BigInteger) row[8];
				reporteA.setTipo_mantenimiento_id(tipo_mantenimiento_id);
				String nom_tipo_mtto = (String) row[9];
				reporteA.setNom_tipo_mtto(nom_tipo_mtto);
				BigInteger area_trabajo_id = (BigInteger) row[10];
				reporteA.setArea_trabajo_id(area_trabajo_id);
				String nom_area_trabajo = (String) row[11];
				reporteA.setNom_area_trabajo(nom_area_trabajo);
				BigInteger tag_id = (BigInteger) row[12];
				reporteA.setTag_id(tag_id);
				String nom_tag = (String) row[13];
				reporteA.setNom_tag(nom_tag);
				BigInteger taller_id = (BigInteger) row[14];
				reporteA.setTaller_id(taller_id);
				String nom_taller_mecanico = (String) row[15];
				reporteA.setNom_taller_mecanico(nom_taller_mecanico);
				BigInteger equipo_id = (BigInteger) row[16];
				reporteA.setEquipo_id(equipo_id);
				String nom_equipo = (String) row[17];
				reporteA.setNom_equipo(nom_equipo);
				BigInteger nivel_prioridad_id = (BigInteger) row[18];
				reporteA.setNivel_prioridad_id(nivel_prioridad_id);
				String nom_nivel_prioridad = (String) row[19];
				reporteA.setNom_nivel_prioridad(nom_nivel_prioridad);
				String descripcion_solicitud = (String) row[20];
				reporteA.setDescripcion_solicitud(descripcion_solicitud);
				String observaciones = (String) row[21];
				reporteA.setObservaciones(observaciones);
				String estado = (String) row[22];
				reporteA.setEstado(estado);
				String cierreSolicitud = (String) row[23];
				reporteA.setCierreSolicitud(cierreSolicitud);
				Date fecha_cierre = (Date) row[24];
				reporteA.setFechaCierre(fecha_cierre);

				reporteA.setEstadoSolicitudVencida(estadoOrdenTrabajo(fecha_registro, cierreSolicitud, estado));

				reporteA.setDiasAtarso(diasDeAtraso(fecha_registro, cierreSolicitud, estado));

				String estadoEstrue = "false";
				if (estado != null) {
					if (estado.equals("I")) {
						estadoEstrue = "true";
						reporteA.setEstadoTrue(estadoEstrue);
						reporteA.setEstadoTrue2(estadoEstrue);
					}
					reporteA.setEstadoTrue(estadoEstrue);
				}

				reporteA.setEstadoTrue(estadoEstrue);

				String tituloCierreOt = "Esta seguro que desea cerrar la Solicitud ?";
				String icon = "ui-icon-unlocked";

				if (cierreSolicitud.equals("C")) {
					tituloCierreOt = "Esta seguro que desea reabrir la Solicitud?";
					icon = "ui-icon-locked";
					estadoEstrue = "true";
					reporteA.setEstadoTrue2(estadoEstrue);
					reporteA.setTituloCierre(tituloCierreOt);
					reporteA.setIconCierre(icon);
				}

				reporteA.setEstadoTrue2(estadoEstrue);
				reporteA.setTituloCierre(tituloCierreOt);
				reporteA.setIconCierre(icon);

				// estadoOrdenTrabajo(Date fechaFinOt, String cierreOt, String
				// estado)

				reporte.add(reporteA);

			}
		}

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
	
	public  List<ExportarPlanRevisionDTO>  exportarPlanRevisionExcel(Long compania,String modulo, Long flagPlanRevision,
			String planSeleccionados) {
		
		Session session = sessionFactory.openSession();
	
		List<ExportarPlanRevisionDTO> reporte = null;
		StringBuilder result = new StringBuilder();
		
		if (flagPlanRevision == 0L) {
			
			SQLQuery q = session.createSQLQuery("call pr_listado_planes_revision (:compania, :origendatos, :planrevisionid ) ");

			q.setLong("compania", compania);
			q.setString("origendatos", modulo);
			q.setLong("planrevisionid", 0L);
			//q.setLong("planrevisionid", Long.parseLong(planSeleccionados));
			
			List l = q.list();

			if (l.size() > 0) {
				
				reporte = new ArrayList<ExportarPlanRevisionDTO>();
	
				for (Iterator it = l.iterator(); it.hasNext();) {
	
					Object[] row = (Object[]) it.next();
	
					ExportarPlanRevisionDTO dto = new ExportarPlanRevisionDTO();
					
					//BigInteger plan_revision_equipo_id = (BigInteger) row[0];
					dto.setPlan_revision_equipo_id((BigInteger) row[0]);
					dto.setCod_plan_revision((String) row[1]);
					dto.setNombre_plan_revision((String) row[2]);
					dto.setEquipo_id((BigInteger) row[3]);
					dto.setCod_equipo((String) row[4]);
					dto.setNom_equipo((String) row[5]);
					dto.setSistemas_equipo_id((BigInteger) row[6]);
					dto.setNombre_sistema_equipo((String) row[7]);
					dto.setCompartimientos_equipo_id((BigInteger) row[8]);
					dto.setNombre_compartimiento_equipo((String) row[9]);
					dto.setCodigo_tag((String) row[10]);
					dto.setNombre_tag((String) row[11]);
					dto.setPeriocidad((BigDecimal) row[12]);
					dto.setHoras_km_ultimo_servicio((BigDecimal) row[13]);
					dto.setTipo_medidor((String) row[14]);
					dto.setAlerta_min((BigDecimal) row[15]);
					dto.setActividades((String) row[16]);
					dto.setSecuencia((BigDecimal) row[17]);
					dto.setDuracion((String) row[18]);
					
					reporte.add(dto);
					
				}
			
			}// if 
		
		}else {
			
			Long id = 1L;
			String[] parts = planSeleccionados.split(",");
			reporte = new ArrayList<ExportarPlanRevisionDTO>();
			
			for (int i = 0; i < parts.length; i++) {
				
				id = Long.parseLong(parts[i].toString()) ;
			
			
				SQLQuery q = session.createSQLQuery("call pr_listado_planes_revision (:compania, :origendatos, :planrevisionid ) ");
				q.setLong("compania", compania);
				q.setString("origendatos", modulo);
				q.setLong("planrevisionid", Long.parseLong(planSeleccionados));
				
				List l = q.list();
	
				if (l.size() > 0) {

					for (Iterator it = l.iterator(); it.hasNext();) {
		
						Object[] row = (Object[]) it.next();
		
						ExportarPlanRevisionDTO dto = new ExportarPlanRevisionDTO();
						
						//BigInteger plan_revision_equipo_id = (BigInteger) row[0];
						dto.setPlan_revision_equipo_id((BigInteger) row[0]);
						dto.setCod_plan_revision((String) row[1]);
						dto.setNombre_plan_revision((String) row[2]);
						dto.setEquipo_id((BigInteger) row[3]);
						dto.setCod_equipo((String) row[4]);
						dto.setNom_equipo((String) row[5]);
						dto.setSistemas_equipo_id((BigInteger) row[6]);
						dto.setNombre_sistema_equipo((String) row[7]);
						dto.setCompartimientos_equipo_id((BigInteger) row[8]);
						dto.setNombre_compartimiento_equipo((String) row[9]);
						dto.setCodigo_tag((String) row[10]);
						dto.setNombre_tag((String) row[11]);
						dto.setPeriocidad((BigDecimal) row[12]);
						dto.setHoras_km_ultimo_servicio((BigDecimal) row[13]);
						dto.setTipo_medidor((String) row[14]);
						dto.setAlerta_min((BigDecimal) row[15]);
						dto.setActividades((String) row[16]);
						dto.setSecuencia((BigDecimal) row[17]);
						dto.setDuracion((String) row[18]);
						
						reporte.add(dto);
						
					}
				
				}// if 
			}
			
		}
		
		
		return reporte;
		
	}

	public List<ListadoProximosMttoEquiposDTO> consultarListaProximosMttoEquipos(Long compania, String equipo,
			Long flagEquipo, String planRevision, Long flagPlanRevision, String origenDatos) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_listado_prox_mtto (:compania, " + " :equipo, :flagEquipo,"
				+ " :planRevision, :flagPlanRevision, :origenDatos,:estadoplan )");
		String estadoplan ="0";
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
				

				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<HorasMaquinaDetalladoDTO> consultarServRealizadosEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietario,
			Long flagPropietario, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_serv_realizados_equipo (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia, :propietario, :flagPropietario,"
						+ ":modeloEquipo, :flagModeloEquipo, :equipo, :flagEquipo)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("propietario", propietario);
		q.setString("modeloEquipo", modeloEquipo);
		q.setString("equipo", equipo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagPropietario", flagPropietario);
		q.setLong("flagModeloEquipo", flagModeloEquipo);
		q.setLong("flagEquipo", flagEquipo);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<HorasMaquinaDetalladoDTO> horasMaquinaDetallado = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			horasMaquinaDetallado = new ArrayList<HorasMaquinaDetalladoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				HorasMaquinaDetalladoDTO horasMaquinaDetalladoA = new HorasMaquinaDetalladoDTO();

				Integer anio = (Integer) row[0];
				Integer mes = (Integer) row[1];
				String codEquipo = (String) row[2];
				String nomEquipo = (String) row[3];
				String codZona = (String) row[4];
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
				String codLote = (String) row[8];
				String nomLote = (String) row[13];
				String nomLabor = (String) row[9];
				BigDecimal cantidadPago = (BigDecimal) row[10];
				String codUdadMed = (String) row[11];
				BigDecimal horas = (BigDecimal) row[12];
				Date fechaRegistro = (Date) row[14];
				String horaInicial = (String) row[15];
				String horaFinal = (String) row[16];
				BigDecimal horometroInicial = (BigDecimal) row[17];
				BigDecimal horometroFinal = (BigDecimal) row[18];
				String codProducto = (String) row[19];
				String nomProducto = (String) row[20];
				BigDecimal cantGalones = (BigDecimal) row[21];
				String codUdadMedIns = (String) row[22];
				String nomUdadMedIns = (String) row[23];
				BigDecimal costoCombustible = (BigDecimal) row[24];
				BigDecimal area = (BigDecimal) row[26];
				BigDecimal valorUnitario = (BigDecimal) row[27];
				BigDecimal costoTotal = (BigDecimal) row[28];
				String codCliente = (String) row[29];
				String nomCliente = (String) row[30];

				horasMaquinaDetalladoA.setAnio(anio);
				horasMaquinaDetalladoA.setMes(mes);
				horasMaquinaDetalladoA.setCodEquipo(codEquipo);
				horasMaquinaDetalladoA.setNomEquipo(nomEquipo);
				horasMaquinaDetalladoA.setCodZona(codZona);
				horasMaquinaDetalladoA.setCodFinca(codFinca);
				horasMaquinaDetalladoA.setNomFinca(nomFinca);
				horasMaquinaDetalladoA.setCodBloque(codBloque);
				horasMaquinaDetalladoA.setCodLote(codLote);
				horasMaquinaDetalladoA.setNomLote(nomLote);
				horasMaquinaDetalladoA.setNomLabor(nomLabor);
				horasMaquinaDetalladoA.setCantidadPago(cantidadPago);
				horasMaquinaDetalladoA.setCodUdadMed(codUdadMed);
				horasMaquinaDetalladoA.setHoras(horas);
				horasMaquinaDetalladoA.setFechaRegistro(fechaRegistro);
				horasMaquinaDetalladoA.setHoraInicial(horaInicial);
				horasMaquinaDetalladoA.setHoraFinal(horaFinal);
				horasMaquinaDetalladoA.setHorometroInicial(horometroInicial);
				horasMaquinaDetalladoA.setHorometroFinal(horometroFinal);
				horasMaquinaDetalladoA.setCodProducto(codProducto);
				horasMaquinaDetalladoA.setNomProducto(nomProducto);
				horasMaquinaDetalladoA.setCantGalones(cantGalones);
				horasMaquinaDetalladoA.setCodUdadMedIns(codUdadMedIns);
				horasMaquinaDetalladoA.setNomUdadMedIns(nomUdadMedIns);
				horasMaquinaDetalladoA.setCostoCombustible(costoCombustible);
				horasMaquinaDetalladoA.setArea(area);
				horasMaquinaDetalladoA.setValorUnitario(valorUnitario);
				horasMaquinaDetalladoA.setCostoTotal(costoTotal);
				horasMaquinaDetalladoA.setCodCliente(codCliente);
				horasMaquinaDetalladoA.setNomCliente(nomCliente);

				horasMaquinaDetallado.add(horasMaquinaDetalladoA);

			}
		}

		return horasMaquinaDetallado;
	}

	@Override
	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLoteExpress(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_cronograma_labores_express  (:compania,"
				+ ":fechaInicial, :fechaFinal,  :cultivo,  :flagCultivo,  :zona,"
				+ ":flagZona,  :finca,  :flagFinca,  :bloque," + ":flagBloque,  :lote,  :flagLote,  :labor,"
				+ ":flagLabor,   :unidadMedida,  :flagUnidadMedida," + ":grupoLabor,  :flagGrupoLabor,  :tenencia,"
				+ ":flagTenencia,  :cronogramaLabor,  :flagCronogramaLabor	)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cultivo", cultivo);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("unidadMedida", unidadMedida);
		q.setString("labor", labor);

		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("cronogramaLabor", cronogramaLabor);

		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);

		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagCronogramaLabor", flagCronogramaLabor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProyeccionLaboresLoteDTO> proyeccionLaboresLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			proyeccionLaboresLote = new ArrayList<ProyeccionLaboresLoteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProyeccionLaboresLoteDTO proyeccionLaboresLoteA = new ProyeccionLaboresLoteDTO();
				String nombreCompania = (String) row[0];
				String nombreSecuencia = (String) row[1];
				String nombreLabor = (String) row[2];
				String descripcion = (String) row[3];
				Date fInicial = (Date) row[4];
				Date fFinal = (Date) row[5];
				BigDecimal duracion = (BigDecimal) row[6];
				String cod_labor = (String) row[7];
				String cod_zona = (String) row[8];
				String nom_zona = (String) row[9];
				String cod_hacienda = (String) row[10];
				String nom_hacienda = (String) row[11];
				String cod_bloque = (String) row[12];
				String nom_bloque = (String) row[13];
				String cod_lote = (String) row[14];
				String nom_lote = (String) row[15];
				String nom_variedad = (String) row[16];
				String nom_etapa = (String) row[17];
				BigDecimal area_neta = (BigDecimal) row[18];
				BigDecimal numero_plantas = (BigDecimal) row[19];
				String trabajar_con_area_plantas = (String) row[20];
				BigDecimal valor_unitario = (BigDecimal) row[21];
				BigDecimal valor_presupuestado = (BigDecimal) row[22];
				String anio_mes = (String) row[23];
				proyeccionLaboresLoteA.setNombreCompania(nombreCompania);
				proyeccionLaboresLoteA.setNombreSecuencia(nombreSecuencia);
				proyeccionLaboresLoteA.setNombreLabor(nombreLabor);
				proyeccionLaboresLoteA.setDescripcion(descripcion);
				proyeccionLaboresLoteA.setFechaInicial(fInicial);
				proyeccionLaboresLoteA.setFechaFinal(fFinal);
				proyeccionLaboresLoteA.setDuracion(duracion);
				proyeccionLaboresLoteA.setCod_labor(cod_labor);
				proyeccionLaboresLoteA.setCod_zona(cod_zona);
				proyeccionLaboresLoteA.setNom_zona(nom_zona);
				proyeccionLaboresLoteA.setCod_hacienda(cod_hacienda);
				proyeccionLaboresLoteA.setNom_hacienda(nom_hacienda);
				proyeccionLaboresLoteA.setCod_bloque(cod_bloque);
				proyeccionLaboresLoteA.setNom_bloque(nom_bloque);
				proyeccionLaboresLoteA.setCod_lote(cod_lote);
				proyeccionLaboresLoteA.setNom_lote(nom_lote);
				proyeccionLaboresLoteA.setNom_variedad(nom_variedad);
				proyeccionLaboresLoteA.setNom_etapa(nom_etapa);
				proyeccionLaboresLoteA.setArea_neta(area_neta);
				proyeccionLaboresLoteA.setNumero_plantas(numero_plantas);
				proyeccionLaboresLoteA.setTrabajar_con_area_plantas(trabajar_con_area_plantas);
				proyeccionLaboresLoteA.setValor_unit_recurso(valor_unitario);
				proyeccionLaboresLoteA.setValor_presupuestado(valor_presupuestado);
				proyeccionLaboresLoteA.setAnio_mes(anio_mes);

				proyeccionLaboresLote.add(proyeccionLaboresLoteA);

			}
		}

		return proyeccionLaboresLote;
	}

	@Override
	public long consultarConsecutivoParadasFabrica(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_parada_fabrica (:compania)");
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
	public List<MttoParadasFabricaDTO> consultarInformeParosFabrica(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String tag, Long flagTag) throws Exception {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_paros_fabrica (:compania, :fechaInicial,  :fechaFinal,"
				+ "  :equipo, :flagEquipo,  :tag, :flagTag )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tag", tag);
		q.setString("equipo", equipo);
		// q.setString("tipoMtto", tipoMtto);

		q.setLong("flagTag", flagTag);
		q.setLong("flagEquipo", flagEquipo);
		// q.setLong("flagTipoMtto", flagTipoMtto);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<MttoParadasFabricaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<MttoParadasFabricaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				MttoParadasFabricaDTO reporteA = new MttoParadasFabricaDTO();
				BigInteger dat_paradas_fabrica_id = (BigInteger) row[0];
				reporteA.setDat_paradas_fabrica_id(dat_paradas_fabrica_id);
				Date fechap_inicial = (Date) row[1];
				reporteA.setFechap_inicial(fechap_inicial);
				Date fechap_final = (Date) row[2];
				reporteA.setFechap_final(fechap_final);
				BigDecimal duracion = (BigDecimal) row[3];
				reporteA.setDuracion(duracion);
				BigInteger consecutivo = (BigInteger) row[4];
				reporteA.setConsecutivo(consecutivo);
				String nom_area_trabajo = (String) row[5];
				reporteA.setNom_area_trabajo(nom_area_trabajo);
				String codigo_tag = (String) row[6];
				reporteA.setCodigo_tag(codigo_tag);
				String nom_tag = (String) row[7];
				reporteA.setNom_tag(nom_tag);
				String cod_equipo = (String) row[8];
				reporteA.setCod_equipo(cod_equipo);
				String nom_equipo = (String) row[9];
				reporteA.setNom_equipo(nom_equipo);
				String descripcion_parada = (String) row[10];
				reporteA.setDescripcion_parada(descripcion_parada);
				String observaciones = (String) row[11];
				reporteA.setObservaciones(observaciones);
				String nom_agente_causador_parada = (String) row[12];
				reporteA.setNom_agente_causador_parada(nom_agente_causador_parada);
				String nom_motivos_parada = (String) row[13];
				reporteA.setNom_motivos_parada(nom_motivos_parada);
				String parada_critica = (String) row[14];
				reporteA.setParada_critica(parada_critica);
				String usuario_digitacion = (String) row[15];
				reporteA.setUsuario_digitacion(usuario_digitacion);

				reporte.add(reporteA);

			}
		}

		return reporte;
	}

	@Override
	public List<ListaVariablesSanidadDTO> consultarListaVariablesSanidad(Long compania, Long tipoAnalisis) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_listado_variables (:compania, :tipoAnalisis )");
		q.setLong("compania", compania);
		q.setLong("tipoAnalisis", tipoAnalisis);

		List l = q.list();
		ArrayList<ListaVariablesSanidadDTO> reporte = new ArrayList<ListaVariablesSanidadDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaVariablesSanidadDTO reportes = new ListaVariablesSanidadDTO();
				BigInteger idAnalisis = (BigInteger) row[0];
				String nombreAnalisis = (String) row[1];
				BigInteger idVariable = (BigInteger) row[2];
				String codVariable = (String) row[3];
				String nomVariable = (String) row[4];
				Short orden = (Short) row[5];
				String tipoVariable = (String) row[6];
				String formula = (String) row[7];
				BigInteger companiaId = (BigInteger) row[8];
				BigDecimal valorVariable = (BigDecimal) row[9];

				reportes.setIdAnalisis(idAnalisis);
				reportes.setNombreAnalisis(nombreAnalisis);
				reportes.setIdVariable(idVariable);
				reportes.setCodVariable(codVariable);
				reportes.setNomVariable(nomVariable);
				reportes.setOrden(orden);
				reportes.setTipoVariable(tipoVariable);
				reportes.setFormula(formula);
				reportes.setCompaniaId(companiaId);
				reportes.setValorVariable(valorVariable);

				reporte.add(reportes);

				// consultaOtDes.add(consultaOt);

			}

		}
		return reporte;

	}

	@Override
	public List<CatalogoEquiposDTO> consultarCatalogoEquipos(Long compania, String origenDatos) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call catalog_equipos (:compania, :origenDatos )");
		q.setLong("compania", compania);
		q.setString("origenDatos", origenDatos);

		List l = q.list();
		ArrayList<CatalogoEquiposDTO> reporte = new ArrayList<CatalogoEquiposDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				CatalogoEquiposDTO reportes = new CatalogoEquiposDTO();
				BigInteger idEquipo = (BigInteger) row[0];
				String descripcion = (String) row[1];
				String origendatos = (String) row[2];
				reportes.setEquipoId(idEquipo);
				reportes.setNom_equipo(descripcion);
				reportes.setOrigen_datos(origendatos);

				reporte.add(reportes);

				// consultaOtDes.add(consultaOt);

			}

		}
		return reporte;

	}

	@Override
	public long consultarIdUnicoDatSanVeg(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_max_id_unico_dat_san_veg (:compania)");
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
	public long consultarConsecutivoDatAnalisisLaboratorio(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_analisis_laboratorio (:compania)");
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
	public long consultarIdUnicoDatAnalisisLaboratorio(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_max_id_unico_dat_analisis_laboratorio (:compania)");
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
	public List<ListaVariablesAnaLaboratorioDTO> consultarListaVariablesAnaLaboratorio(Long compania,
			Long tipoAnalisis) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_listado_variables_laboratorio (:compania, :tipoAnalisis )");
		q.setLong("compania", compania);
		q.setLong("tipoAnalisis", tipoAnalisis);

		List l = q.list();
		ArrayList<ListaVariablesAnaLaboratorioDTO> reporte = new ArrayList<ListaVariablesAnaLaboratorioDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaVariablesAnaLaboratorioDTO reportes = new ListaVariablesAnaLaboratorioDTO();
				BigInteger idAnalisis = (BigInteger) row[0];
				String nombreAnalisis = (String) row[1];
				BigInteger idVariable = (BigInteger) row[2];
				String codVariable = (String) row[3];
				String nomVariable = (String) row[4];
				BigInteger orden = (BigInteger) row[5];
				String tipoVariable = (String) row[6];
				String formula = (String) row[7];
				BigInteger companiaId = (BigInteger) row[8];
				BigDecimal valorDia = (BigDecimal) row[9];

				BigDecimal valorHora6 = (BigDecimal) row[10];
				BigDecimal valorHora7 = (BigDecimal) row[11];
				BigDecimal valorHora8 = (BigDecimal) row[12];
				BigDecimal valorHora9 = (BigDecimal) row[13];
				BigDecimal valorHora10 = (BigDecimal) row[14];
				BigDecimal valorHora11 = (BigDecimal) row[15];
				BigDecimal valorHora12 = (BigDecimal) row[16];
				BigDecimal valorHora13 = (BigDecimal) row[17];
				BigDecimal valorHora14 = (BigDecimal) row[19];
				BigDecimal valorHora15 = (BigDecimal) row[19];
				BigDecimal valorHora16 = (BigDecimal) row[20];
				BigDecimal valorHora17 = (BigDecimal) row[21];
				BigDecimal valorHora18 = (BigDecimal) row[22];
				BigDecimal valorHora19 = (BigDecimal) row[23];
				BigDecimal valorHora20 = (BigDecimal) row[24];
				BigDecimal valorHora21 = (BigDecimal) row[25];
				BigDecimal valorHora22 = (BigDecimal) row[26];
				BigDecimal valorHora23 = (BigDecimal) row[27];
				BigDecimal valorHora0 = (BigDecimal) row[28];
				BigDecimal valorHora1 = (BigDecimal) row[29];
				BigDecimal valorHora2 = (BigDecimal) row[30];
				BigDecimal valorHora3 = (BigDecimal) row[31];
				BigDecimal valorHora4 = (BigDecimal) row[32];
				BigDecimal valorHora5 = (BigDecimal) row[33];

				String horaDigitacion = (String) row[34];
				String frecuenciaDigitacion = (String) row[35];

				reportes.setIdAnalisis(idAnalisis);
				reportes.setNombreAnalisis(nombreAnalisis);
				reportes.setIdVariable(idVariable);
				reportes.setCodVariable(codVariable);
				reportes.setNomVariable(nomVariable);
				reportes.setOrden(orden);
				reportes.setTipoVariable(tipoVariable);
				reportes.setFormula(formula);
				reportes.setCompaniaId(companiaId);
				reportes.setValorVariableDia(valorDia);

				reportes.setValorVariableHora6(valorHora6);
				reportes.setValorVariableHora7(valorHora7);
				reportes.setValorVariableHora8(valorHora8);
				reportes.setValorVariableHora9(valorHora9);
				reportes.setValorVariableHora10(valorHora10);
				reportes.setValorVariableHora11(valorHora11);
				reportes.setValorVariableHora12(valorHora12);
				reportes.setValorVariableHora13(valorHora13);
				reportes.setValorVariableHora14(valorHora14);
				reportes.setValorVariableHora15(valorHora15);
				reportes.setValorVariableHora16(valorHora16);
				reportes.setValorVariableHora17(valorHora17);
				reportes.setValorVariableHora18(valorHora18);
				reportes.setValorVariableHora19(valorHora19);
				reportes.setValorVariableHora20(valorHora20);
				reportes.setValorVariableHora21(valorHora21);
				reportes.setValorVariableHora22(valorHora22);
				reportes.setValorVariableHora23(valorHora23);
				reportes.setValorVariableHora0(valorHora0);
				reportes.setValorVariableHora1(valorHora1);
				reportes.setValorVariableHora2(valorHora2);
				reportes.setValorVariableHora3(valorHora3);
				reportes.setValorVariableHora4(valorHora4);
				reportes.setValorVariableHora5(valorHora5);

				reportes.setHoraDigitacion(horaDigitacion);
				reportes.setFrecuenciaDigitacion(frecuenciaDigitacion);

				reporte.add(reportes);

				// consultaOtDes.add(consultaOt);

			}

		}
		return reporte;

	}

	@Override
	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDTO> consultarTiqueteSinAnalisisCalidadFruto(Long compania) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_ticket_anacal_fruto (:compania)");

		q.setLong("compania", compania);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaTiqueteSinAnalisisCalidadFrutoDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<ConsultaTiqueteSinAnalisisCalidadFrutoDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaTiqueteSinAnalisisCalidadFrutoDTO materiaPrimaLoteA = new ConsultaTiqueteSinAnalisisCalidadFrutoDTO();

				BigInteger id = (BigInteger) row[0];
				BigInteger consecutivo = (BigInteger) row[1];
				String equipo = (String) row[2];
				String tipoTransaccion = (String) row[3];
				Date fecha = (Date) row[4];

				materiaPrimaLoteA.setId(id);
				materiaPrimaLoteA.setConsecutivo(consecutivo);
				materiaPrimaLoteA.setEquipo(equipo);
				materiaPrimaLoteA.setTipoTransaccion(tipoTransaccion);
				materiaPrimaLoteA.setFechaRegistro(fecha);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO> consultarTiqueteSinAnalisisCalidadDetalle(
			Long compania, Long tiquete) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_ticket_anacal_fruto_detal (:compania, :tiquete)");

		q.setLong("compania", compania);
		q.setLong("tiquete", tiquete);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO> materiaPrimaLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			materiaPrimaLote = new ArrayList<ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO materiaPrimaLoteA = new ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO();

				BigInteger id = (BigInteger) row[0];
				BigInteger consecutivo = (BigInteger) row[1];
				String equipo = (String) row[2];
				String tipoTransaccion = (String) row[3];
				Date fecha = (Date) row[4];
				BigInteger nivel4Id = (BigInteger) row[8];
				String lote = (String) row[10];

				materiaPrimaLoteA.setId(id);
				materiaPrimaLoteA.setConsecutivo(consecutivo);
				materiaPrimaLoteA.setEquipo(equipo);
				materiaPrimaLoteA.setTipoTransaccion(tipoTransaccion);
				materiaPrimaLoteA.setFechaRegistro(fecha);
				materiaPrimaLoteA.setNivel4Id(nivel4Id);
				materiaPrimaLoteA.setLote(lote);

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

	}

	@Override
	public List<AnalisisProcesoIndustrialDTO> consultarAnalisisProcesoIndustrial(Long compania, Date fechaInicial,
			Date fechaFinal, String tipoAnalisis, Long flagTipoAnalisis) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_analisis_industrial (:compania, :fechaInicial, :fechaFinal,"
				+ ":tipoAnalisis, :flagTipoAnalisis)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("tipoAnalisis", tipoAnalisis);
		q.setLong("flagTipoAnalisis", flagTipoAnalisis);

		// execute stored procedure and get list result
		List l = q.list();
		List<AnalisisProcesoIndustrialDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<AnalisisProcesoIndustrialDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				AnalisisProcesoIndustrialDTO reporteA = new AnalisisProcesoIndustrialDTO();

				BigInteger dat_ana_lab_id = (BigInteger) row[0];
				BigInteger consecutivo = (BigInteger) row[1];
				String cod_analisis = (String) row[2];
				String nom_grupo_analisis = (String) row[3];
				String cod_variable = (String) row[4];
				String nom_variable = (String) row[5];
				BigInteger orden_digitacion = (BigInteger) row[6];
				String tipo_variable = (String) row[7];
				Date fecha_analisis = (Date) row[8];
				String horas = (String) row[20];
				BigDecimal valor_variable = (BigDecimal) row[10];
				String zona = (String) row[11];
				String cod_finca = (String) row[12];
				String finca = (String) row[13];
				String bloque = (String) row[14];
				String lote = (String) row[15];
				BigDecimal anio = (BigDecimal) row[16];
				BigDecimal mes = (BigDecimal) row[17];
				String anio_mes = (String) row[18];
				BigDecimal nro_ticket = (BigDecimal) row[19];
				String tipoValor = (String) row[21];
				String tipoAcumulado = (String) row[22];
				
				reporteA.setDat_ana_lab_id(dat_ana_lab_id);
				reporteA.setConsecutivo(consecutivo);
				reporteA.setCod_analisis(cod_analisis);
				reporteA.setNom_grupo_analisis(nom_grupo_analisis);
				reporteA.setCod_variable(cod_variable);
				reporteA.setNom_variable(nom_variable);
				reporteA.setOrden_digitacion(orden_digitacion);
				reporteA.setTipo_variable(tipo_variable);
				reporteA.setFecha_analisis(fecha_analisis);
				reporteA.setHoras(horas);
				reporteA.setValor_variable(valor_variable);
				reporteA.setZona(zona);
				reporteA.setCod_finca(cod_finca);
				reporteA.setFinca(finca);
				reporteA.setBloque(bloque);
				reporteA.setLote(lote);
				reporteA.setAnio(anio);
				reporteA.setMes(mes);
				reporteA.setAnio_mes(anio_mes);
				reporteA.setNro_ticket(nro_ticket);
				reporteA.setTipoValor(tipoValor);
				reporteA.setTipoAcumulado(tipoAcumulado);
				

				reporte.add(reporteA);

			}
		}

		return reporte;

	}

	public long consultarConsec_dat_pluvio(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_pluvio (:compania)");
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
	public List<CatalogProductoDTO> consultarCatalogoProductosAgricolas(Long compania) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_lista_productos_agricola (:compania)");
		q.setLong("compania", compania);

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

				// consultaOtDes.add(consultaOt);

			}

		}
		return reporte;

	}

	@Override
	public List<CatalogProductoDTO> consultarCatalogoProductosMtto(Long compania) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_lista_productos_mtto (:compania)");
		q.setLong("compania", compania);

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

				// consultaOtDes.add(consultaOt);

			}

		}
		return reporte;

	}

	public double calcularHoras(Date fechaFinal, Date fechaInicial) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_calculo_horas (:fechaFinal, :fechaInicial)");
		q.setDate("fechaFinal", fechaFinal);
		q.setDate("fechaInicial", fechaInicial);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigDecimal resultado = (BigDecimal) it.next();
				valor = resultado.doubleValue();

			}
		}
		return valor;

	}

	@Override
	public List<ListaNivel4DTO> consultarListaNivel4(Long compania, String nivel2) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_lista_nivel4 (:compania, :nivel2)");
		q.setLong("compania", compania);
		q.setString("nivel2", nivel2);

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

				reporte.add(reportes);

				// consultaOtDes.add(consultaOt);

			}

		}
		return reporte;

	}

	public Long borrarNivel4OtrosCostos(Long idOtrosCostos) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_lotes_otros_costos (:idOtrosCostos)");
		q.setLong("idOtrosCostos", idOtrosCostos);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	/***************** interface ***/

	@Override
	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarMo(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String trabajador, Long flagTrabajador,
			String conceptonomina, Long flagconceptonomina) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call exp_registros_mo_manager (:compania, :fechaInicial,  :fechaFinal, "
				+ ":contratista, :flagContratista,"
				+ ":trabajador, :flagTrabajador, :conceptonomina, :flagconceptonomina )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setString("trabajador", trabajador);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagTrabajador", flagTrabajador);
		q.setString("conceptonomina", conceptonomina);
		q.setLong("flagconceptonomina", flagconceptonomina);

		// q.setParameterList("finca", fincas);

		// CALLute stored procedure and get list result
		List l = q.list();
		List<interfaceManagerExpRegistrosMODTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<interfaceManagerExpRegistrosMODTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				interfaceManagerExpRegistrosMODTO nominaA = new interfaceManagerExpRegistrosMODTO();

				String idEmpresa = (String) row[0];
				String idTipoDoc = (String) row[1];
				String cedulaEmpleado = (String) row[2];
				String nomEmpleado = (String) row[3];
				Date fechaRegistro = (Date) row[4];
				String codConceptoNomina = (String) row[5];
				String nomConceptoNomina = (String) row[6];
				BigDecimal cantidadPago = (BigDecimal) row[7];
				BigDecimal costoTotal = (BigDecimal) row[8];
				String fecha_texto = (String) row[9];
				String numDias = (String) row[10];
				String cuentaContable = (String) row[11];
				String interfaceNomina = (String) row[12];

				nominaA.setIdEmpresa(idEmpresa);
				nominaA.setIdTipoDoc(idTipoDoc);
				nominaA.setCedulaEmpleado(cedulaEmpleado);
				nominaA.setNomEmpleado(nomEmpleado);
				nominaA.setFechaRegistro(fechaRegistro);
				nominaA.setCodConceptoNomina(codConceptoNomina);
				nominaA.setNomConceptoNomina(nomConceptoNomina);
				nominaA.setCantidadPago(cantidadPago);
				nominaA.setCostoTotal(costoTotal);
				nominaA.setFecha_texto(fecha_texto);
				nominaA.setNumDias(numDias);
				nominaA.setCuentaContable(cuentaContable);

				nominaA.setPlanoNomina(interfaceNomina);

				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	@Override
	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarAusentismosMo(Long compania,
			Date fechaInicial, Date fechaFinal, String contratista, Long flagContratista, String trabajador,
			Long flagTrabajador, String conceptonomina, Long flagconceptonomina) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call exp_reg_ausentismos_mo_manager (:compania, :fechaInicial,  :fechaFinal, "
						+ " :contratista, :flagContratista,"
						+ ":trabajador, :flagTrabajador, :conceptonomina, :flagconceptonomina )");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setString("trabajador", trabajador);
		q.setLong("flagContratista", flagContratista);
		q.setLong("flagTrabajador", flagTrabajador);
		q.setString("conceptonomina", conceptonomina);
		q.setLong("flagconceptonomina", flagconceptonomina);

		// q.setParameterList("finca", fincas);

		// CALLute stored procedure and get list result
		List l = q.list();
		List<interfaceManagerExpRegistrosMODTO> nomina = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			nomina = new ArrayList<interfaceManagerExpRegistrosMODTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				interfaceManagerExpRegistrosMODTO nominaA = new interfaceManagerExpRegistrosMODTO();

				String idEmpresa = (String) row[0];
				String idTipoDoc = (String) row[1];
				String cedulaEmpleado = (String) row[2];
				String nomEmpleado = (String) row[3];
				Date fechaRegistro = (Date) row[4];
				String codConceptoNomina = (String) row[5];
				String nomConceptoNomina = (String) row[6];
				BigDecimal cantidadPago = (BigDecimal) row[7];
				BigDecimal costoTotal = (BigDecimal) row[8];
				String fecha_texto = (String) row[9];
				String numDias = (String) row[10];
				String cuentaContable = (String) row[11];
				String interfaceNomina = (String) row[12];

				nominaA.setIdEmpresa(idEmpresa);
				nominaA.setIdTipoDoc(idTipoDoc);
				nominaA.setCedulaEmpleado(cedulaEmpleado);
				nominaA.setNomEmpleado(nomEmpleado);
				nominaA.setFechaRegistro(fechaRegistro);
				nominaA.setCodConceptoNomina(codConceptoNomina);
				nominaA.setNomConceptoNomina(nomConceptoNomina);
				nominaA.setCantidadPago(cantidadPago);
				nominaA.setCostoTotal(costoTotal);
				nominaA.setFecha_texto(fecha_texto);
				nominaA.setNumDias(numDias);
				nominaA.setCuentaContable(cuentaContable);

				nominaA.setPlanoNomina(interfaceNomina);

				nomina.add(nominaA);
			}
		}

		return nomina;

	}

	public String aprobarOrdenesServicioNivel1(String idPlanLaborDet) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_aprobacion_ordenes1 (:idPlanLaborDet)");
		q.setString("idPlanLaborDet", idPlanLaborDet);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		return "";

	}

	public String aprobarOrdenesServicioNivel2(String idPlanLaborDet) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_aprobacion_ordenes2 (:idPlanLaborDet)");
		q.setString("idPlanLaborDet", idPlanLaborDet);

		List l = q.list();
		StringBuilder result = new StringBuilder();

		return "";

	}

	@Override
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDesAprobacion(Long compania) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/

		Compania companiaId = new Compania();

		SQLQuery q = session.createSQLQuery("call pr_lista_ot_aprobacion (:compania )");
		q.setLong("compania", compania);

		List l = q.list();
		ArrayList<ConsultaOrdenTrabajoDesDTO> consultaOrdenTrabajoDesDTOS = new ArrayList<ConsultaOrdenTrabajoDesDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ConsultaOrdenTrabajoDesDTO consultaOrdenTrabajoDesDTO = new ConsultaOrdenTrabajoDesDTO();
				BigInteger idOt = (BigInteger) row[4];
				String descripcion = (String) row[3];
				consultaOrdenTrabajoDesDTO.setPlanLaborId(idOt);
				consultaOrdenTrabajoDesDTO.setDescripcion(descripcion);

				consultaOrdenTrabajoDesDTOS.add(consultaOrdenTrabajoDesDTO);

				// consultaOtDes.add(consultaOt);

			}

		}
		return consultaOrdenTrabajoDesDTOS;

	}

	@Override
	public long consultarExistenciaOtParaSolicitudMq(Long solicitudId) {
		long consecutivo = 0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_consulta_solicitudes_con_ot (:solicitudId)");
		q.setLong("solicitudId", solicitudId);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigInteger idSol = (BigInteger) it.next();
				consecutivo = idSol.longValue();

			}
		}
		return consecutivo;

	}

	@Override
	public List<CostosTotalesDTO> consultarInformeHojaVidaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session
				.createSQLQuery("call pr_hoja_vida_lote (:compania, :fechaInicial,  :fechaFinal, :zona, :flagZona,  "
						+ ":finca, :flagFinca,  :bloque,  :flagBloque, :lote, :flagLote, :labor, :flagLabor, "
						+ ":unidadMedida,  :flagUnidadMedida, :grupoLabor, :flagGrupoLabor, :tenencia, :flagTenencia , :numeroCosechas, :flagNumeroCosechas )");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("labor", labor);
		q.setString("unidadMedida", unidadMedida);
		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("numeroCosechas", numeroCosechas);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);
		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagNumeroCosechas", flagNumeroCosechas);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
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
				String codFinca = (String) row[5];
				String nomFinca = (String) row[6];
				String codBloque = (String) row[7];
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
				// BigDecimal edadUltCorte = (BigDecimal) row[26];
				// BigDecimal area = (BigDecimal) row[24];
				// BigDecimal rendimiento = (BigDecimal) row[25];
				String variedad = (String) row[26];
				String sistemaRiego = (String) row[27];
				String infraestructura = (String) row[28];
				BigDecimal areaRegada = (BigDecimal) row[29];
				BigDecimal horasRiego = (BigDecimal) row[30];
				BigDecimal m3Totales = (BigDecimal) row[31];
				Date fechaR = (Date) row[32];
				BigDecimal area = (BigDecimal) row[33];
				String elementoCostosMes = (String) row[34];

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
				// pyGA.setEdadUltCorte(edadUltCorte);
				// pyGA.setArea(area);
				// pyGA.setRendimiento(rendimiento);
				pyGA.setVariedad(variedad);
				pyGA.setSistemaRiego(sistemaRiego);
				pyGA.setInfraestructura(infraestructura);
				pyGA.setAreaRegada(areaRegada);
				pyGA.setHorasRiego(horasRiego);
				pyGA.setM3Totales(m3Totales);
				pyGA.setElementoCostosMes(elementoCostosMes);

				pyG.add(pyGA);

			}
		}

		return pyG;
	}

	@Override
	public Long borrarCierreCostosNomina(Long compania, Long anio, Long mes) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_cierre_nomina (:compania, :anio, :mes)");
		q.setLong("anio", anio);
		q.setLong("mes", mes);
		q.setLong("compania", compania);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	@Override
	public Long borrarCierreCostosDistriMqAgricola(Long compania, Long anio, Long mes) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_distribucion_mqagricola (:compania, :anio, :mes)");
		q.setLong("anio", anio);
		q.setLong("mes", mes);
		q.setLong("compania", compania);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	@Override
	public Long cierreCostosNomina(Long compania, Long anio, Long mes, String contratista, Long flagContratista) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_cierre_costos_nomina (:compania, :anio,  :mes, " + ":contratista, :flagContratista )");

		q.setLong("compania", compania);
		q.setLong("anio", anio);
		q.setLong("mes", mes);

		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	@Override
	public Long cierreCostosDistriMqAgricola(Long compania, Long anio, Long mes, String equipo, Long flagEquipo,
			String contratista, Long flagContratista) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_cierre_costos_mtto_equipo_det (:compania, :anio,  :mes, "
				+ ":equipo, :flagEquipo, :contratista, :flagContratista )");

		q.setLong("compania", compania);
		q.setLong("anio", anio);
		q.setLong("mes", mes);

		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	@Override
	public List<ProyeccionLaboresLoteDTO> consultarInformePresupuestoPorHacienda(Long compania, String zona,
			Long flagZona, String finca, Long flagFinca, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String cronogramaLabor,
			Long flagCronogramaLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_presupuesto_hacienda  (:compania," + ":zona,"
				+ ":flagZona,  :finca,  :flagFinca,  :labor," + ":flagLabor,   :unidadMedida,  :flagUnidadMedida,"
				+ ":grupoLabor,  :flagGrupoLabor,  " + ":cronogramaLabor,  :flagCronogramaLabor	)");

		q.setLong("compania", compania);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("unidadMedida", unidadMedida);
		q.setString("labor", labor);

		q.setString("grupoLabor", grupoLabor);
		q.setString("cronogramaLabor", cronogramaLabor);

		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagLabor", flagLabor);

		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagCronogramaLabor", flagCronogramaLabor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProyeccionLaboresLoteDTO> proyeccionLaboresLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			proyeccionLaboresLote = new ArrayList<ProyeccionLaboresLoteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProyeccionLaboresLoteDTO proyeccionLaboresLoteA = new ProyeccionLaboresLoteDTO();
				String nombreCompania = (String) row[0];
				String nombreSecuencia = (String) row[1];
				String cod_zona = (String) row[2];
				String nom_zona = (String) row[3];
				String cod_hacienda = (String) row[4];
				String nom_hacienda = (String) row[5];
				Date fInicial = (Date) row[6];
				Date fFinal = (Date) row[7];
				String cod_labor = (String) row[8];
				String nombreLabor = (String) row[9];

				String cod_udadMed = (String) row[10];
				String nombreUdadMed = (String) row[11];
				BigDecimal valor_presupuestado = (BigDecimal) row[12];
				BigDecimal cantidad_presupuestada = (BigDecimal) row[13];

				String anio_mes = (String) row[14];
				String nomGrupoLabor = (String) row[22];

				proyeccionLaboresLoteA.setNombreCompania(nombreCompania);
				proyeccionLaboresLoteA.setNombreSecuencia(nombreSecuencia);
				proyeccionLaboresLoteA.setNombreLabor(nombreLabor);
				proyeccionLaboresLoteA.setFechaInicial(fInicial);
				proyeccionLaboresLoteA.setFechaFinal(fFinal);
				proyeccionLaboresLoteA.setCod_labor(cod_labor);
				proyeccionLaboresLoteA.setCod_zona(cod_zona);
				proyeccionLaboresLoteA.setNom_zona(nom_zona);
				proyeccionLaboresLoteA.setCod_hacienda(cod_hacienda);
				proyeccionLaboresLoteA.setNom_hacienda(nom_hacienda);

				proyeccionLaboresLoteA.setValor_presupuestado(valor_presupuestado);
				proyeccionLaboresLoteA.setCantidad_presupuestada(cantidad_presupuestada);

				proyeccionLaboresLoteA.setCodUdadMed(cod_udadMed);
				proyeccionLaboresLoteA.setNomUdadMed(nombreUdadMed);

				proyeccionLaboresLoteA.setAnio_mes(anio_mes);
				proyeccionLaboresLoteA.setNombreGrupoLabor(nomGrupoLabor);
				proyeccionLaboresLote.add(proyeccionLaboresLoteA);

			}
		}

		return proyeccionLaboresLote;
	}

	public Long borrarLiqServRealizadosOperario(Long compania, Date fechaInicial, Date fechaFinal) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery(
				"call pr_borrar_liq_serv_realizados_operario" + " (:compania, :fechaInicial, :fechaFinal)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	public Long liqServRealizadosEquipoOperario(Long compania, Date fechaInicial, Date fechaFinal, String trabajador,
			Long flagTrabajador, String equipo, Long flagEquipo) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_liq_serv_realizados_equipo_operario (:compania, "
				+ ":fechaInicial, :fechaFinal," + ":trabajador, :flagTrabajador," + ":equipo, :flagEquipo)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("equipo", equipo);
		q.setLong("flagEquipo", flagEquipo);
		q.setString("trabajador", trabajador);
		q.setLong("flagTrabajador", flagTrabajador);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	@Override
	public List<CatalogProductoDTO> consultarCatalogoProductosSegunTipo(Long compania, Long tipoProducto) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_lista_tipoprod_productos (:compania, :tipoProducto)");
		q.setLong("compania", compania);
		q.setLong("tipoProducto", tipoProducto);

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

				// consultaOtDes.add(consultaOt);

			}

		}
		return reporte;

	}

	public Long borrarCalculoDominicalesFestivosNomina(Long compania, Date fechaInicial, Date fechaFinal) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("call pr_borrar_dominical_fest_nomina (:compania, :fechaInicial, :fechaFinal)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}

	public Long calculoDominicalesFestivosNomina(Long compania, Date fechaInicial, Date fechaFinal, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_calculo_dominical_fest_nomina (:compania, "
				+ ":fechaInicial, :fechaFinal," + ":contratista, :flagContratista," + ":trabajador, :flagTrabajador)");
		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("contratista", contratista);
		q.setLong("flagContratista", flagContratista);
		q.setString("trabajador", trabajador);
		q.setLong("flagTrabajador", flagTrabajador);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}


	public long consultarUltimaPlanillaNomina(Long compania, Date fecha) {
		long id = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_ultima_planilla_dia (:compania, :fecha)");
		q.setLong("compania", compania);
		q.setDate("fecha", fecha);
		List l = q.list();
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				BigInteger idMax = (BigInteger) it.next();
				id = idMax.longValue();

			}
		}
		return id;

	}
	
	public Long pr_borrar_dat_ana_laboratorio(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_ana_laboratorio (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	
	public Long pr_borrar_dat_ana_laboratorio_det(Long id) {
		double valor = 0.0;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call pr_borrar_dat_ana_laboratorio_det (:id)");
		q.setLong("id", id);
		q.executeUpdate();
		// List l = q.list();
		// StringBuilder result = new StringBuilder();

		return 1L;

	}
	
	@Override
	public List<ListaVariablesAnaLaboratorioDTO> pr_validar_existencia_analisis_lab
							(Long compania, Date fecha, String horaDigitacion, Long idAnalisis ) {

		Session session = sessionFactory.openSession();
		/*** PANTALLA POR CONSTRUIR ***/
		SQLQuery q = session.createSQLQuery("call pr_validar_existencia_analisis_lab (:compania, :fecha, :horaDigitacion, :idAnalisis)");
		q.setLong("compania", compania);
		q.setLong("idAnalisis", idAnalisis);
		q.setDate("fecha", fecha);
		q.setString("horaDigitacion", horaDigitacion);

		List l = q.list();
		ArrayList<ListaVariablesAnaLaboratorioDTO> reporte = new ArrayList<ListaVariablesAnaLaboratorioDTO>();
		if (l.size() > 0) {

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ListaVariablesAnaLaboratorioDTO reportes = new ListaVariablesAnaLaboratorioDTO();
				Date fechaAnalisis = (Date)  row[0];
				String hora_digitacion   = (String ) row[1];
				String estado = (String) row[2];
				BigInteger ana_lab_id = (BigInteger) row[3];
				BigInteger dat_ana_lab_id = (BigInteger) row[4];
				reportes.setFechaAnalisis(fechaAnalisis);
				reportes.setHoraDigitacion(hora_digitacion);
				reportes.setEstado(estado);
				reportes.setIdAnalisis(ana_lab_id);
				reportes.setDat_ana_lab_id(dat_ana_lab_id);

				reporte.add(reportes);

				// consultaOtDes.add(consultaOt);

			}

		}
		return reporte;

	}
	

	@Override
	public List<ProyeccionLaboresLoteDTO> pr_presupuesto_vs_ejecutado(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_presupuesto_vs_ejecutado  (:compania,"
				+ ":fechaInicial, :fechaFinal,  :cultivo,  :flagCultivo,  :zona,"
				+ ":flagZona,  :finca,  :flagFinca,  :bloque," + ":flagBloque,  :lote,  :flagLote,  :labor,"
				+ ":flagLabor,   :unidadMedida,  :flagUnidadMedida," + ":grupoLabor,  :flagGrupoLabor,  :tenencia,"
				+ ":flagTenencia,  :cronogramaLabor,  :flagCronogramaLabor	)");

		q.setLong("compania", compania);
		q.setDate("fechaInicial", fechaInicial);
		q.setDate("fechaFinal", fechaFinal);
		q.setString("cultivo", cultivo);
		q.setString("zona", zona);
		q.setString("finca", finca);
		q.setString("bloque", bloque);
		q.setString("lote", lote);
		q.setString("unidadMedida", unidadMedida);
		q.setString("labor", labor);

		q.setString("grupoLabor", grupoLabor);
		q.setString("tenencia", tenencia);
		q.setString("cronogramaLabor", cronogramaLabor);

		q.setLong("flagCultivo", flagCultivo);
		q.setLong("flagZona", flagZona);
		q.setLong("flagFinca", flagFinca);
		q.setLong("flagBloque", flagBloque);
		q.setLong("flagLote", flagLote);
		q.setLong("flagLabor", flagLabor);

		q.setLong("flagUnidadMedida", flagUnidadMedida);
		q.setLong("flagGrupoLabor", flagGrupoLabor);
		q.setLong("flagTenencia", flagTenencia);
		q.setLong("flagCronogramaLabor", flagCronogramaLabor);

		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<ProyeccionLaboresLoteDTO> proyeccionLaboresLote = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			proyeccionLaboresLote = new ArrayList<ProyeccionLaboresLoteDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				ProyeccionLaboresLoteDTO proyeccionLaboresLoteA = new ProyeccionLaboresLoteDTO();
				String nombreCompania = (String) row[0];
				String nombreSecuencia = (String) row[1];
				String nombreLabor = (String) row[2];
				String descripcion = (String) row[3];
				Date fInicial = (Date) row[4];
				Date fFinal = (Date) row[5];
				BigDecimal duracion = (BigDecimal) row[6];
				String cod_labor = (String) row[7];
				String cod_zona = (String) row[8];
				String nom_zona = (String) row[9];
				String cod_hacienda = (String) row[10];
				String nom_hacienda = (String) row[11];
				String cod_bloque = (String) row[12];
				String nom_bloque = (String) row[13];
				String cod_lote = (String) row[14];
				String nom_lote = (String) row[15];
				String nom_variedad = (String) row[16];
				String nom_etapa = (String) row[17];
				BigDecimal area_neta = (BigDecimal) row[18];
				BigDecimal numero_plantas = (BigDecimal) row[19];
				String trabajar_con_area_plantas = (String) row[20];
				BigDecimal valor_unitario = (BigDecimal) row[21];
				BigDecimal valor_presupuestado = (BigDecimal) row[22];
				String anio_mes = (String) row[23];
				String origen = (String) row[24];
				BigDecimal ejecutado = (BigDecimal) row[25];
				String nomGrupoLabor = (String) row[26];
				proyeccionLaboresLoteA.setNombreCompania(nombreCompania);
				proyeccionLaboresLoteA.setNombreSecuencia(nombreSecuencia);
				proyeccionLaboresLoteA.setNombreLabor(nombreLabor);
				proyeccionLaboresLoteA.setDescripcion(descripcion);
				proyeccionLaboresLoteA.setFechaInicial(fInicial);
				proyeccionLaboresLoteA.setFechaFinal(fFinal);
				proyeccionLaboresLoteA.setDuracion(duracion);
				proyeccionLaboresLoteA.setCod_labor(cod_labor);
				proyeccionLaboresLoteA.setCod_zona(cod_zona);
				proyeccionLaboresLoteA.setNom_zona(nom_zona);
				proyeccionLaboresLoteA.setCod_hacienda(cod_hacienda);
				proyeccionLaboresLoteA.setNom_hacienda(nom_hacienda);
				proyeccionLaboresLoteA.setCod_bloque(cod_bloque);
				proyeccionLaboresLoteA.setNom_bloque(nom_bloque);
				proyeccionLaboresLoteA.setCod_lote(cod_lote);
				proyeccionLaboresLoteA.setNom_lote(nom_lote);
				proyeccionLaboresLoteA.setNom_variedad(nom_variedad);
				proyeccionLaboresLoteA.setNom_etapa(nom_etapa);
				proyeccionLaboresLoteA.setArea_neta(area_neta);
				proyeccionLaboresLoteA.setNumero_plantas(numero_plantas);
				proyeccionLaboresLoteA.setTrabajar_con_area_plantas(trabajar_con_area_plantas);
				proyeccionLaboresLoteA.setValor_unit_recurso(valor_unitario);
				proyeccionLaboresLoteA.setValor_presupuestado(valor_presupuestado);
				proyeccionLaboresLoteA.setAnio_mes(anio_mes);
				proyeccionLaboresLoteA.setOrigen(origen);
				proyeccionLaboresLoteA.setValor_ejecutado(ejecutado);
				proyeccionLaboresLoteA.setNombreGrupoLabor(nomGrupoLabor);
				
				proyeccionLaboresLote.add(proyeccionLaboresLoteA);

			}
		}

		return proyeccionLaboresLote;
	}
	

	
	@Override
	public List<TiquetesBasculaDTO> consultarEstadoVehiculo(Long compania1, Date fechaInicial, Date fechaFinal, String tipoMovimiento,
			String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoEquipos, String estadoEquipos, String selectedTiquet, Long flagTiquet, String tiquete_peso_neto) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery(
				"call pr_tiquetes_bascula (:compania1, :fechaInicial, :fechaFinal, :tipoTransaccion1, :flagTipoTransaccion, :equipo1, "
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

				String estadoEstrue = "false";
				if (estado.equals("I")) {
					estadoEstrue = "true";
					materiaPrimaLoteA.setEstadoTrue(estadoEstrue);
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

				materiaPrimaLote.add(materiaPrimaLoteA);

			}
		}

		return materiaPrimaLote;

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

		return materiaPrimaLote;
		
	}
	
	@Override
	public List<TiquetesBasculaDTO> pr_consulta_vehiculo_en_patio(Long compania, Long equipo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("call pr_consulta_vehiculo_en_patio  (:compania," + ":equipo)");

		q.setLong("compania", compania);
		
		q.setLong("equipo", equipo);
		// q.setParameterList("finca", fincas);

		// execute stored procedure and get list result
		List l = q.list();
		List<TiquetesBasculaDTO> reporte = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			reporte = new ArrayList<TiquetesBasculaDTO>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				Object[] row = (Object[]) it.next();

				TiquetesBasculaDTO reporteA = new TiquetesBasculaDTO();
				BigInteger datTransProdId = (BigInteger) row[0];
				BigInteger equipoId = (BigInteger) row[1];
				String codigoEquipo = (String) row[2];
				BigDecimal pesoNeto = (BigDecimal) row[3];
				
			

				reporteA.setDat_trans_prod_id(datTransProdId);
				reporteA.setEquipoId(equipoId);
				reporteA.setEquipo(codigoEquipo);
				reporteA.setPeso_neto(pesoNeto);
				
				
				reporte.add(reporteA);

			}
		}

		return reporte;
	}
	
	@Override
	public long consultarConsecutivoDatTransProdPesoNeto(Long compania) {
		long consecutivo = 1;
		Session session = sessionFactory.openSession();
		SQLQuery q = session.createSQLQuery("call consec_dat_trans_prod_peso_neto (:compania)");
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
	
	
}
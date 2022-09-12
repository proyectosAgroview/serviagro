package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IDatAplicProdDetDAO;
import co.com.arcosoft.dataaccess.dao.IDatAplicProductoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatAplicProdDet;
import co.com.arcosoft.modelo.DatAplicProducto;
import co.com.arcosoft.modelo.dto.DatAplicProdDetDTO;
import co.com.arcosoft.modelo.dto.DatAplicProductoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatAplicProductoLogic")
public class DatAplicProductoLogic implements IDatAplicProductoLogic {
	private static final Logger log = LoggerFactory.getLogger(DatAplicProductoLogic.class);

	/**
	 * DAO injected by Spring that manages DatAplicProducto entities
	 *
	 */
	@Autowired
	private IDatAplicProductoDAO datAplicProductoDAO;

	/**
	 * DAO injected by Spring that manages DatAplicProdDet entities
	 *
	 */
	@Autowired
	private IDatAplicProdDetDAO datAplicProdDetDAO;

	/**
	 * Logic injected by Spring that manages Almacen entities
	 *
	 */
	@Autowired
	IAlmacenLogic logicAlmacen1;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor2;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel43;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador4;

	@Override
	@Transactional(readOnly = true)
	public List<DatAplicProducto> getDatAplicProducto() throws Exception {
		log.debug("finding all DatAplicProducto instances");

		List<DatAplicProducto> list = new ArrayList<DatAplicProducto>();

		try {
			list = datAplicProductoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatAplicProducto failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatAplicProducto");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatAplicProducto(DatAplicProducto entity, List<DatAplicProdDetDTO> dataDetProductos)
			throws Exception {
		log.debug("saving DatAplicProducto instance");

		try { /*
				 * if (entity.getTrabajador() == null) { throw new
				 * ZMessManager().new ForeignException("trabajador"); }
				 */
			if ((entity.getNPases() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNPases(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("NPases");
			}

			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getCierreCostos() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCierreCostos(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("cierreCostos");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getDocumetoErp() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDocumetoErp(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("documetoErp");
			}

			if ((entity.getEdadEjecucion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadEjecucion(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadEjecucion");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEtapaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaId");
			}

			if ((entity.getIdMobile() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getIdMobile(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("idMobile");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getVariedId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedId");
			}

			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 */

			if ((entity.getAreaAplicada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaAplicada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaAplicada");
			}

			/*
			 * if (entity.getDatAplicProdId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "datAplicProdId"); }
			 * 
			 * if ((entity.getDatAplicProdId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getDatAplicProdId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "datAplicProdId"); }
			 * 
			 * if (getDatAplicProducto(entity.getDatAplicProdId()) != null) {
			 * throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			datAplicProductoDAO.save(entity);

			if (dataDetProductos != null) {

				for (DatAplicProdDetDTO valorDto : dataDetProductos) {

					if (valorDto.getDatProdDetId() == null) {

						DatAplicProdDet valor = new DatAplicProdDet();

						valor.setCantidadAplicada(valorDto.getCantidadAplicada());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setDosis(valorDto.getDosis());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setValorUnit(valorDto.getValorUnit());

						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4());
						valor.setDatAplicProducto(entity);

						datAplicProdDetDAO.save(valor);
					}

				}
			}
			log.debug("save DatAplicProducto successful");
		} catch (Exception e) {
			log.error("save DatAplicProducto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatAplicProducto(DatAplicProducto entity) throws Exception {
		log.debug("deleting DatAplicProducto instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatAplicProducto");
		}

		if (entity.getDatAplicProdId() == null) {
			throw new ZMessManager().new EmptyFieldException("datAplicProdId");
		}

		List<DatAplicProdDet> datAplicProdDets = null;
		List<DatAplicProdDet> datAplicProdDets_1 = null;

		try {
			datAplicProdDets = datAplicProdDetDAO.findByProperty("datAplicProducto.datAplicProdId",
					entity.getDatAplicProdId());

			if (Utilities.validationsList(datAplicProdDets) == true) {
				throw new ZMessManager().new DeletingException("datAplicProdDets");
			}

			datAplicProdDets_1 = datAplicProdDetDAO.findByProperty("datAplicProducto.datAplicProdId",
					entity.getDatAplicProdId());

			if (Utilities.validationsList(datAplicProdDets_1) == true) {
				throw new ZMessManager().new DeletingException("datAplicProdDets_1");
			}

			datAplicProductoDAO.delete(entity);

			log.debug("delete DatAplicProducto successful");
		} catch (Exception e) {
			log.error("delete DatAplicProducto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatAplicProducto(DatAplicProducto entity, List<DatAplicProdDetDTO> dataDetProductos)
			throws Exception {
		log.debug("updating DatAplicProducto instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatAplicProducto");
			}
			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new ForeignException("trabajador"); }
			 */
			if ((entity.getNPases() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNPases(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("NPases");
			}

			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getCierreCostos() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCierreCostos(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("cierreCostos");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getDocumetoErp() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDocumetoErp(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("documetoErp");
			}

			if ((entity.getEdadEjecucion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadEjecucion(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadEjecucion");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEtapaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaId");
			}

			if ((entity.getIdMobile() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getIdMobile(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("idMobile");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getVariedId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedId");
			}

			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 */

			if ((entity.getAreaAplicada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaAplicada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaAplicada");
			}

			if (entity.getDatAplicProdId() != null) {
				datAplicProductoDAO.update(entity);

				for (DatAplicProdDetDTO valorDto : dataDetProductos) {

					if (valorDto.getDatProdDetId() == null) { // crear el valor
																// nuevo

						DatAplicProdDet valor = new DatAplicProdDet();

						valor.setCantidadAplicada(valorDto.getCantidadAplicada());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setDosis(valorDto.getDosis());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setValorUnit(valorDto.getValorUnit());

						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4());
						valor.setDatAplicProducto(entity);

						datAplicProdDetDAO.save(valor);

					} else {
						DatAplicProdDet valor = datAplicProdDetDAO.findById(valorDto.getDatProdDetId());

						valor.setCantidadAplicada(valorDto.getCantidadAplicada());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setDosis(valorDto.getDosis());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setValorUnit(valorDto.getValorUnit());

						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4());
						datAplicProdDetDAO.update(valor);
					}

				}

			} else {
				saveDatAplicProducto(entity, dataDetProductos);

			}

			log.debug("update DatAplicProducto successful");
		} catch (Exception e) {
			log.error("update DatAplicProducto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatAplicProductoDTO> getDataDatAplicProducto() throws Exception {
		try {
			List<DatAplicProducto> datAplicProducto = datAplicProductoDAO.findAll();

			List<DatAplicProductoDTO> datAplicProductoDTO = new ArrayList<DatAplicProductoDTO>();

			for (DatAplicProducto datAplicProductoTmp : datAplicProducto) {
				DatAplicProductoDTO datAplicProductoDTO2 = new DatAplicProductoDTO();

				datAplicProductoDTO2.setDatAplicProdId(datAplicProductoTmp.getDatAplicProdId());
				datAplicProductoDTO2
						.setNPases((datAplicProductoTmp.getNPases() != null) ? datAplicProductoTmp.getNPases() : null);
				datAplicProductoDTO2
						.setAnio((datAplicProductoTmp.getAnio() != null) ? datAplicProductoTmp.getAnio() : null);
				datAplicProductoDTO2.setCierreCostos(
						(datAplicProductoTmp.getCierreCostos() != null) ? datAplicProductoTmp.getCierreCostos() : null);
				datAplicProductoDTO2.setCompania(
						(datAplicProductoTmp.getCompania() != null) ? datAplicProductoTmp.getCompania() : null);
				datAplicProductoDTO2.setConsecutivo(
						(datAplicProductoTmp.getConsecutivo() != null) ? datAplicProductoTmp.getConsecutivo() : null);
				datAplicProductoDTO2.setDocumetoErp(
						(datAplicProductoTmp.getDocumetoErp() != null) ? datAplicProductoTmp.getDocumetoErp() : null);
				datAplicProductoDTO2.setEdadEjecucion((datAplicProductoTmp.getEdadEjecucion() != null)
						? datAplicProductoTmp.getEdadEjecucion() : null);
				datAplicProductoDTO2
						.setEstado((datAplicProductoTmp.getEstado() != null) ? datAplicProductoTmp.getEstado() : null);
				datAplicProductoDTO2.setEtapaId(
						(datAplicProductoTmp.getEtapaId() != null) ? datAplicProductoTmp.getEtapaId() : null);
				datAplicProductoDTO2.setFechaCreacion(datAplicProductoTmp.getFechaCreacion());
				datAplicProductoDTO2.setFechaModificacion(datAplicProductoTmp.getFechaModificacion());
				datAplicProductoDTO2.setFechaRegistro(datAplicProductoTmp.getFechaRegistro());
				datAplicProductoDTO2.setIdMobile(
						(datAplicProductoTmp.getIdMobile() != null) ? datAplicProductoTmp.getIdMobile() : null);
				datAplicProductoDTO2.setInfoAdicional((datAplicProductoTmp.getInfoAdicional() != null)
						? datAplicProductoTmp.getInfoAdicional() : null);
				datAplicProductoDTO2.setInfoAdicional2((datAplicProductoTmp.getInfoAdicional2() != null)
						? datAplicProductoTmp.getInfoAdicional2() : null);
				datAplicProductoDTO2.setLatitud(
						(datAplicProductoTmp.getLatitud() != null) ? datAplicProductoTmp.getLatitud() : null);
				datAplicProductoDTO2.setLongitud(
						(datAplicProductoTmp.getLongitud() != null) ? datAplicProductoTmp.getLongitud() : null);
				datAplicProductoDTO2.setNivel1Id(
						(datAplicProductoTmp.getNivel1Id() != null) ? datAplicProductoTmp.getNivel1Id() : null);
				datAplicProductoDTO2.setNivel3Id(
						(datAplicProductoTmp.getNivel3Id() != null) ? datAplicProductoTmp.getNivel3Id() : null);
				datAplicProductoDTO2.setObservacion(
						(datAplicProductoTmp.getObservacion() != null) ? datAplicProductoTmp.getObservacion() : null);
				datAplicProductoDTO2.setObservacionAnularReg((datAplicProductoTmp.getObservacionAnularReg() != null)
						? datAplicProductoTmp.getObservacionAnularReg() : null);
				datAplicProductoDTO2.setPrecision(
						(datAplicProductoTmp.getPrecision() != null) ? datAplicProductoTmp.getPrecision() : null);
				datAplicProductoDTO2.setUsuarioDigitacion((datAplicProductoTmp.getUsuarioDigitacion() != null)
						? datAplicProductoTmp.getUsuarioDigitacion() : null);
				datAplicProductoDTO2.setVariedId(
						(datAplicProductoTmp.getVariedId() != null) ? datAplicProductoTmp.getVariedId() : null);

				if (datAplicProductoTmp.getAlmacen() != null) {
					datAplicProductoDTO2.setAlmacenId_Almacen(datAplicProductoTmp.getAlmacen());
				} else {
					datAplicProductoDTO2.setAlmacenId_Almacen(null);
				}
				if (datAplicProductoTmp.getNivel2Id() != null) {
					datAplicProductoDTO2.setNivel2Id(datAplicProductoTmp.getNivel2Id().getNivel2Id());
				} else {
					datAplicProductoDTO2.setNivel2Id(null);
				}

				if (datAplicProductoTmp.getOrdenTrabajo() != null) {
					datAplicProductoDTO2.setOrdenTrabajo(datAplicProductoTmp.getOrdenTrabajo().getPlanLaborDetId());
				} else {
					datAplicProductoDTO2.setOrdenTrabajo(null);
				}

				if (datAplicProductoTmp.getLabor() != null) {
					datAplicProductoDTO2.setLaborId_Labor(datAplicProductoTmp.getLabor().getLaborId());
				} else {
					datAplicProductoDTO2.setLaborId_Labor(null);
				}

				if (datAplicProductoTmp.getNivel4() != null) {
					datAplicProductoDTO2.setNivel4Id_Nivel4(datAplicProductoTmp.getNivel4().getNivel4Id());
				} else {
					datAplicProductoDTO2.setNivel4Id_Nivel4(null);
				}

				if (datAplicProductoTmp.getTrabajador() != null) {
					datAplicProductoDTO2.setTrabId_Trabajador(datAplicProductoTmp.getTrabajador());
				} else {
					datAplicProductoDTO2.setTrabId_Trabajador(null);
				}

				String nombreLabor = datAplicProductoTmp.getLabor().getNombre();
				datAplicProductoDTO2.setLaborNombre(nombreLabor);
				String nombreNivel2 = datAplicProductoTmp.getNivel2Id().getNombre();
				datAplicProductoDTO2.setNivel2Nombre(nombreNivel2);

				String nombreNivel4 = datAplicProductoTmp.getNivel4().getNombre();
				datAplicProductoDTO2.setNivel4Nombre(nombreNivel4);

				datAplicProductoDTO.add(datAplicProductoDTO2);
			}

			return datAplicProductoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatAplicProducto getDatAplicProducto(Long datAplicProdId) throws Exception {
		log.debug("getting DatAplicProducto instance");

		DatAplicProducto entity = null;

		try {
			entity = datAplicProductoDAO.findById(datAplicProdId);
		} catch (Exception e) {
			log.error("get DatAplicProducto failed", e);
			throw new ZMessManager().new FindingException("DatAplicProducto");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatAplicProducto> findPageDatAplicProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatAplicProducto> entity = null;

		try {
			entity = datAplicProductoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatAplicProducto Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatAplicProducto() throws Exception {
		Long entity = null;

		try {
			entity = datAplicProductoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatAplicProducto Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 *            [0] = String variable = (String) varibles[i]; representa como
	 *            se llama la variable en el pojo
	 *
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1];
	 *            representa si el valor necesita o no ''(comillas simples)usado
	 *            para campos de tipo string
	 *
	 *            [2] = Object value = varibles[i + 2]; representa el valor que
	 *            se va a buscar en la BD
	 *
	 *            [3] = String comparator = (String) varibles[i + 3]; representa
	 *            que tipo de busqueda voy a hacer.., ejemplo: where
	 *            nombre=william o where nombre<>william, en este campo iria el
	 *            tipo de comparador que quiero si es = o <>
	 *
	 *            Se itera de 4 en 4..., entonces 4 registros del arreglo
	 *            representan 1 busqueda en un campo, si se ponen mas pues el
	 *            continuara buscando en lo que se le ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *            la diferencia son estas dos posiciones
	 *
	 *            [0] = String variable = (String) varibles[j]; la variable ne
	 *            la BD que va a ser buscada en un rango
	 *
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en
	 *            un rango
	 *
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en
	 *            un rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria
	 *            value2
	 *
	 *            [3] = String comparator1 = (String) varibles[j + 3];
	 *            comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *            [4] = String comparator2 = (String) varibles[j + 4];
	 *            comparador 2 ejemplo: a comparador1>1 and a comparador2<5 (el
	 *            original: a > 1 and a < 5) *
	 * @param variablesBetweenDates
	 *            (en este caso solo para mysql) [0] = String variable =
	 *            (String) varibles[k]; el nombre de la variable que hace
	 *            referencia a una fecha
	 *
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *            comparar(deben ser dates)
	 *
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *            comparar(deben ser dates)
	 *
	 *            esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatAplicProducto> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatAplicProducto> list = new ArrayList<DatAplicProducto>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) && (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) && (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null) && (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable + " and " + variable + " " + comparator2
									+ " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1 + " " + variable + " and " + variable
									+ " " + comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) && (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0)
							? ("(model." + variable + " between \'" + value + "\' and \'" + value2 + "\')")
							: (tempWhere + " AND (model." + variable + " between \'" + value + "\' and \'" + value2
									+ "\')");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = null;
		} else {
			where = "(" + tempWhere + ")";
		}

		try {
			list = datAplicProductoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	public List<DatAplicProductoDTO> getDataDetProductosByDatAplicProdId(Long datAplicProdId) throws Exception {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatAplicProductoDTO> findByCriteriaPageAplicProducto(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		try {
			List<DatAplicProducto> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("laborNombre")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(labor.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel2Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2Id.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel4Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel4.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("ordenTrabajo")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ")
							+ "upper(ordenTrabajo.ordenTrabajo)" + " LIKE '%" + e.getValue().toString().toUpperCase()
							+ "%' ";

				} else if (e.getKey().equals("trabajadorCodigo")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(trabajador.codigo)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("almacenNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(almacen.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}

			entity = datAplicProductoDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<DatAplicProductoDTO> datAplicProductoDTO = new ArrayList<DatAplicProductoDTO>();

			for (DatAplicProducto datAplicProductoTmp : entity) {
				DatAplicProductoDTO datAplicProductoDTO2 = new DatAplicProductoDTO();

				datAplicProductoDTO2.setDatAplicProdId(datAplicProductoTmp.getDatAplicProdId());
				datAplicProductoDTO2
						.setNPases((datAplicProductoTmp.getNPases() != null) ? datAplicProductoTmp.getNPases() : null);
				datAplicProductoDTO2.setAreaAplicada(
						(datAplicProductoTmp.getAreaAplicada() != null) ? datAplicProductoTmp.getAreaAplicada() : null);
				datAplicProductoDTO2
						.setAnio((datAplicProductoTmp.getAnio() != null) ? datAplicProductoTmp.getAnio() : null);
				datAplicProductoDTO2.setCierreCostos(
						(datAplicProductoTmp.getCierreCostos() != null) ? datAplicProductoTmp.getCierreCostos() : null);
				datAplicProductoDTO2.setCompania(
						(datAplicProductoTmp.getCompania() != null) ? datAplicProductoTmp.getCompania() : null);
				datAplicProductoDTO2.setConsecutivo(
						(datAplicProductoTmp.getConsecutivo() != null) ? datAplicProductoTmp.getConsecutivo() : null);
				datAplicProductoDTO2.setDocumetoErp(
						(datAplicProductoTmp.getDocumetoErp() != null) ? datAplicProductoTmp.getDocumetoErp() : null);
				datAplicProductoDTO2.setEdadEjecucion((datAplicProductoTmp.getEdadEjecucion() != null)
						? datAplicProductoTmp.getEdadEjecucion() : null);
				datAplicProductoDTO2
						.setEstado((datAplicProductoTmp.getEstado() != null) ? datAplicProductoTmp.getEstado() : null);
				datAplicProductoDTO2.setEtapaId(
						(datAplicProductoTmp.getEtapaId() != null) ? datAplicProductoTmp.getEtapaId() : null);
				datAplicProductoDTO2.setFechaCreacion(datAplicProductoTmp.getFechaCreacion());
				datAplicProductoDTO2.setFechaModificacion(datAplicProductoTmp.getFechaModificacion());
				datAplicProductoDTO2.setFechaRegistro(datAplicProductoTmp.getFechaRegistro());
				datAplicProductoDTO2.setIdMobile(
						(datAplicProductoTmp.getIdMobile() != null) ? datAplicProductoTmp.getIdMobile() : null);
				datAplicProductoDTO2.setInfoAdicional((datAplicProductoTmp.getInfoAdicional() != null)
						? datAplicProductoTmp.getInfoAdicional() : null);
				datAplicProductoDTO2.setInfoAdicional2((datAplicProductoTmp.getInfoAdicional2() != null)
						? datAplicProductoTmp.getInfoAdicional2() : null);
				datAplicProductoDTO2.setLatitud(
						(datAplicProductoTmp.getLatitud() != null) ? datAplicProductoTmp.getLatitud() : null);
				datAplicProductoDTO2.setLongitud(
						(datAplicProductoTmp.getLongitud() != null) ? datAplicProductoTmp.getLongitud() : null);
				datAplicProductoDTO2.setNivel1Id(
						(datAplicProductoTmp.getNivel1Id() != null) ? datAplicProductoTmp.getNivel1Id() : null);
				datAplicProductoDTO2.setNivel3Id(
						(datAplicProductoTmp.getNivel3Id() != null) ? datAplicProductoTmp.getNivel3Id() : null);
				datAplicProductoDTO2.setObservacion(
						(datAplicProductoTmp.getObservacion() != null) ? datAplicProductoTmp.getObservacion() : null);
				datAplicProductoDTO2.setObservacionAnularReg((datAplicProductoTmp.getObservacionAnularReg() != null)
						? datAplicProductoTmp.getObservacionAnularReg() : null);
				datAplicProductoDTO2.setPrecision(
						(datAplicProductoTmp.getPrecision() != null) ? datAplicProductoTmp.getPrecision() : null);
				datAplicProductoDTO2.setUsuarioDigitacion((datAplicProductoTmp.getUsuarioDigitacion() != null)
						? datAplicProductoTmp.getUsuarioDigitacion() : null);
				datAplicProductoDTO2.setVariedId(
						(datAplicProductoTmp.getVariedId() != null) ? datAplicProductoTmp.getVariedId() : null);

				if (datAplicProductoTmp.getAlmacen() != null) {
					datAplicProductoDTO2.setAlmacenId_Almacen(datAplicProductoTmp.getAlmacen());
				} else {
					datAplicProductoDTO2.setAlmacenId_Almacen(null);
				}
				if (datAplicProductoTmp.getNivel2Id() != null) {
					datAplicProductoDTO2.setNivel2Id(datAplicProductoTmp.getNivel2Id().getNivel2Id());
				} else {
					datAplicProductoDTO2.setNivel2Id(null);
				}

				if (datAplicProductoTmp.getOrdenTrabajo() != null) {
					datAplicProductoDTO2.setOrdenTrabajo(datAplicProductoTmp.getOrdenTrabajo().getPlanLaborDetId());
				} else {
					datAplicProductoDTO2.setOrdenTrabajo(null);
				}

				if (datAplicProductoTmp.getLabor() != null) {
					datAplicProductoDTO2.setLaborId_Labor(datAplicProductoTmp.getLabor().getLaborId());
				} else {
					datAplicProductoDTO2.setLaborId_Labor(null);
				}

				if (datAplicProductoTmp.getNivel4() != null) {
					datAplicProductoDTO2.setNivel4Id_Nivel4(datAplicProductoTmp.getNivel4().getNivel4Id());
				} else {
					datAplicProductoDTO2.setNivel4Id_Nivel4(null);
				}

				if (datAplicProductoTmp.getTrabajador() != null) {
					datAplicProductoDTO2.setTrabId_Trabajador(datAplicProductoTmp.getTrabajador());
				} else {
					datAplicProductoDTO2.setTrabId_Trabajador(null);
				}

				String estadoEstrue = "false";
				if (datAplicProductoTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datAplicProductoDTO2.setEstadoTrue(estadoEstrue);
				}
				datAplicProductoDTO2.setEstadoTrue(estadoEstrue);

				String nombreLabor = datAplicProductoTmp.getLabor().getNombre();
				datAplicProductoDTO2.setLaborNombre(nombreLabor);
				String nombreNivel2 = datAplicProductoTmp.getNivel2Id().getNombre();
				datAplicProductoDTO2.setNivel2Nombre(nombreNivel2);

				String nombreNivel4 = datAplicProductoTmp.getNivel4().getNombre();
				datAplicProductoDTO2.setNivel4Nombre(nombreNivel4);

				datAplicProductoDTO.add(datAplicProductoDTO2);
			}

			return datAplicProductoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberAplicProducto(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("laborNombre")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(labor.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel2Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2Id.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel4Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel4.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("ordenTrabajo")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ")
							+ "upper(ordenTrabajo.ordenTrabajo)" + " LIKE '%" + e.getValue().toString().toUpperCase()
							+ "%' ";

				} else if (e.getKey().equals("trabajadorCodigo")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(trabajador.codigo)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("almacenNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(almacen.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}
			entity = datAplicProductoDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("AplicProducto Count");
		} finally {
		}
		return entity;
	}

}

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

import co.com.arcosoft.dataaccess.dao.IDatEstimCosechaDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatEstimCosecha;
import co.com.arcosoft.modelo.dto.DatEstimCosechaDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatEstimCosechaLogic")
public class DatEstimCosechaLogic implements IDatEstimCosechaLogic {
	private static final Logger log = LoggerFactory.getLogger(DatEstimCosechaLogic.class);

	/**
	 * DAO injected by Spring that manages DatEstimCosecha entities
	 *
	 */
	@Autowired
	private IDatEstimCosechaDAO datEstimCosechaDAO;

	/**
	 * Logic injected by Spring that manages MotEstim entities
	 *
	 */
	@Autowired
	IMotEstimLogic logicMotEstim1;

	@Override
	@Transactional(readOnly = true)
	public List<DatEstimCosecha> getDatEstimCosecha() throws Exception {
		log.debug("finding all DatEstimCosecha instances");

		List<DatEstimCosecha> list = new ArrayList<DatEstimCosecha>();

		try {
			list = datEstimCosechaDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatEstimCosecha failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatEstimCosecha");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatEstimCosecha(DatEstimCosecha entity) throws Exception {
		log.debug("saving DatEstimCosecha instance");

		try {
			if (entity.getMotEstim() == null) {
				throw new ZMessManager().new ForeignException("motEstim");
			}

			if ((entity.getAnioFiscalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnioFiscalNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anioFiscalNivel4");
			}

			if ((entity.getAreaNeta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaNeta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaNeta");
			}

			if ((entity.getCantidadTotalEst() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadTotalEst(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadTotalEst");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getTrabajador().getTrabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador().getTrabId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabajador");
			}

			if ((entity.getEdadNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadNivel4");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEtapaNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaNivel4");
			}

			if ((entity.getFaseFenoNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFaseFenoNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("faseFenoNivel4");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getMobileId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getMobileId(), 23) == false)) {
				throw new ZMessManager().new NotValidFormatException("mobileId");
			}

			if ((entity.getNivel1Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel1Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel1Id");
			}

			if ((entity.getNivel2Id().getNivel2Id() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2Id().getNivel2Id(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id");
			}

			if ((entity.getNivel3Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel3Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel3Id");
			}

			if ((entity.getNivel4Id().getNivel4Id() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4Id().getNivel4Id(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getThEstimado() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getThEstimado(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("thEstimado");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getVariedNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedNivel4");
			}

			if (entity.getMotEstim().getMotEstimId() == null) {
				throw new ZMessManager().new EmptyFieldException("motEstimId_MotEstim");
			}

			if ((entity.getMotEstim().getMotEstimId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMotEstim().getMotEstimId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("motEstimId_MotEstim");
			}

			/*
			 * if (entity.getDatEstimCosechaId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "datEstimCosechaId"); }
			 * 
			 * if ((entity.getDatEstimCosechaId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getDatEstimCosechaId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "datEstimCosechaId");
			 * } if (getDatEstimCosecha(entity.getDatEstimCosechaId()) != null)
			 * { throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			datEstimCosechaDAO.save(entity);

			log.debug("save DatEstimCosecha successful");
		} catch (Exception e) {
			log.error("save DatEstimCosecha failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatEstimCosecha(DatEstimCosecha entity) throws Exception {
		log.debug("deleting DatEstimCosecha instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatEstimCosecha");
		}

		if (entity.getDatEstimCosechaId() == null) {
			throw new ZMessManager().new EmptyFieldException("datEstimCosechaId");
		}

		try {
			datEstimCosechaDAO.delete(entity);

			log.debug("delete DatEstimCosecha successful");
		} catch (Exception e) {
			log.error("delete DatEstimCosecha failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatEstimCosecha(DatEstimCosecha entity) throws Exception {
		log.debug("updating DatEstimCosecha instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatEstimCosecha");
			}

			if (entity.getMotEstim() == null) {
				throw new ZMessManager().new ForeignException("motEstim");
			}

			if ((entity.getAnioFiscalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnioFiscalNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anioFiscalNivel4");
			}

			if ((entity.getAreaNeta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaNeta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaNeta");
			}

			if ((entity.getCantidadTotalEst() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadTotalEst(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadTotalEst");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getDatEstimCosechaId() == null) {
				throw new ZMessManager().new EmptyFieldException("datEstimCosechaId");
			}

			if ((entity.getDatEstimCosechaId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatEstimCosechaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datEstimCosechaId");
			}

			if ((entity.getEdadNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadNivel4");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEtapaNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaNivel4");
			}

			if ((entity.getFaseFenoNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFaseFenoNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("faseFenoNivel4");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getTrabajador().getTrabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador().getTrabId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabajador");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getMobileId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getMobileId(), 23) == false)) {
				throw new ZMessManager().new NotValidFormatException("mobileId");
			}

			if ((entity.getNivel1Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel1Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel1Id");
			}

			if ((entity.getNivel2Id().getNivel2Id() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2Id().getNivel2Id(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id");
			}

			if ((entity.getNivel3Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel3Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel3Id");
			}

			if ((entity.getNivel4Id().getNivel4Id() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4Id().getNivel4Id(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getThEstimado() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getThEstimado(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("thEstimado");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getVariedNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedNivel4");
			}

			if (entity.getMotEstim().getMotEstimId() == null) {
				throw new ZMessManager().new EmptyFieldException("motEstimId_MotEstim");
			}

			if ((entity.getMotEstim().getMotEstimId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMotEstim().getMotEstimId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("motEstimId_MotEstim");
			}

			datEstimCosechaDAO.update(entity);

			log.debug("update DatEstimCosecha successful");
		} catch (Exception e) {
			log.error("update DatEstimCosecha failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatEstimCosechaDTO> getDataDatEstimCosecha() throws Exception {
		try {
			List<DatEstimCosecha> datEstimCosecha = datEstimCosechaDAO.findAll();

			List<DatEstimCosechaDTO> datEstimCosechaDTO = new ArrayList<DatEstimCosechaDTO>();

			for (DatEstimCosecha datEstimCosechaTmp : datEstimCosecha) {
				DatEstimCosechaDTO datEstimCosechaDTO2 = new DatEstimCosechaDTO();

				datEstimCosechaDTO2.setDatEstimCosechaId(datEstimCosechaTmp.getDatEstimCosechaId());
				datEstimCosechaDTO2.setConsecutivo(
						(datEstimCosechaTmp.getConsecutivo() != null) ? datEstimCosechaTmp.getConsecutivo() : null);
				datEstimCosechaDTO2.setAnioFiscalNivel4((datEstimCosechaTmp.getAnioFiscalNivel4() != null)
						? datEstimCosechaTmp.getAnioFiscalNivel4() : null);
				datEstimCosechaDTO2.setAreaNeta(
						(datEstimCosechaTmp.getAreaNeta() != null) ? datEstimCosechaTmp.getAreaNeta() : null);
				datEstimCosechaDTO2.setCantidadTotalEst((datEstimCosechaTmp.getCantidadTotalEst() != null)
						? datEstimCosechaTmp.getCantidadTotalEst() : null);
				datEstimCosechaDTO2.setCompania(
						(datEstimCosechaTmp.getCompania() != null) ? datEstimCosechaTmp.getCompania() : null);
				datEstimCosechaDTO2.setEdadNivel4(
						(datEstimCosechaTmp.getEdadNivel4() != null) ? datEstimCosechaTmp.getEdadNivel4() : null);
				datEstimCosechaDTO2
						.setEstado((datEstimCosechaTmp.getEstado() != null) ? datEstimCosechaTmp.getEstado() : null);
				datEstimCosechaDTO2.setEtapaNivel4(
						(datEstimCosechaTmp.getEtapaNivel4() != null) ? datEstimCosechaTmp.getEtapaNivel4() : null);
				datEstimCosechaDTO2.setFaseFenoNivel4((datEstimCosechaTmp.getFaseFenoNivel4() != null)
						? datEstimCosechaTmp.getFaseFenoNivel4() : null);
				datEstimCosechaDTO2.setFechaCreacion(datEstimCosechaTmp.getFechaCreacion());
				datEstimCosechaDTO2.setFechaModificacion(datEstimCosechaTmp.getFechaModificacion());
				datEstimCosechaDTO2.setFechaMuestra(datEstimCosechaTmp.getFechaMuestra());
				datEstimCosechaDTO2.setInfoAdicional(
						(datEstimCosechaTmp.getInfoAdicional() != null) ? datEstimCosechaTmp.getInfoAdicional() : null);
				datEstimCosechaDTO2.setInfoAdicional2((datEstimCosechaTmp.getInfoAdicional2() != null)
						? datEstimCosechaTmp.getInfoAdicional2() : null);
				datEstimCosechaDTO2.setMobileId(
						(datEstimCosechaTmp.getMobileId() != null) ? datEstimCosechaTmp.getMobileId() : null);
				datEstimCosechaDTO2.setNivel1Id(
						(datEstimCosechaTmp.getNivel1Id() != null) ? datEstimCosechaTmp.getNivel1Id() : null);

				datEstimCosechaDTO2.setNivel3Id(
						(datEstimCosechaTmp.getNivel3Id() != null) ? datEstimCosechaTmp.getNivel3Id() : null);

				datEstimCosechaDTO2.setObservacion(
						(datEstimCosechaTmp.getObservacion() != null) ? datEstimCosechaTmp.getObservacion() : null);
				datEstimCosechaDTO2.setObservacionAnularReg((datEstimCosechaTmp.getObservacionAnularReg() != null)
						? datEstimCosechaTmp.getObservacionAnularReg() : null);
				datEstimCosechaDTO2.setThEstimado(
						(datEstimCosechaTmp.getThEstimado() != null) ? datEstimCosechaTmp.getThEstimado() : null);
				datEstimCosechaDTO2.setUsuarioDigitacion((datEstimCosechaTmp.getUsuarioDigitacion() != null)
						? datEstimCosechaTmp.getUsuarioDigitacion() : null);
				datEstimCosechaDTO2.setVariedNivel4(
						(datEstimCosechaTmp.getVariedNivel4() != null) ? datEstimCosechaTmp.getVariedNivel4() : null);
				datEstimCosechaDTO2.setMotEstimId_MotEstim((datEstimCosechaTmp.getMotEstim().getMotEstimId() != null)
						? datEstimCosechaTmp.getMotEstim().getMotEstimId() : null);
				datEstimCosechaDTO2.setNivel2Id((datEstimCosechaTmp.getNivel2Id().getNivel2Id() != null)
						? datEstimCosechaTmp.getNivel2Id().getNivel2Id() : null);
				datEstimCosechaDTO2.setNivel4Id((datEstimCosechaTmp.getNivel4Id().getNivel4Id() != null)
						? datEstimCosechaTmp.getNivel4Id().getNivel4Id() : null);
				datEstimCosechaDTO2.setTrabajador((datEstimCosechaTmp.getTrabajador().getTrabId() != null)
						? datEstimCosechaTmp.getTrabajador().getTrabId() : null);

				datEstimCosechaDTO2
						.setLatitud((datEstimCosechaTmp.getLatitud() != null) ? datEstimCosechaTmp.getLatitud() : null);
				datEstimCosechaDTO2.setLongitud(
						(datEstimCosechaTmp.getLongitud() != null) ? datEstimCosechaTmp.getLongitud() : null);
				datEstimCosechaDTO2.setPrecision(
						(datEstimCosechaTmp.getPrecision() != null) ? datEstimCosechaTmp.getPrecision() : null);
				String nombreNivel2 = datEstimCosechaTmp.getNivel2Id().getNombre();
				datEstimCosechaDTO2.setNivel2Nombre(nombreNivel2);
				String nombreNivel4 = datEstimCosechaTmp.getNivel4Id().getNombre();
				datEstimCosechaDTO2.setNivel4Nombre(nombreNivel4);
				String nombreTrabajador = datEstimCosechaTmp.getTrabajador().getNombre();
				datEstimCosechaDTO2.setTrabajadorNombre(nombreTrabajador);
				String codigoTrabajador = datEstimCosechaTmp.getTrabajador().getCodigo();
				datEstimCosechaDTO2.setTrabajadorCodigo(codigoTrabajador);

				datEstimCosechaDTO.add(datEstimCosechaDTO2);
			}

			return datEstimCosechaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatEstimCosecha getDatEstimCosecha(Long datEstimCosechaId) throws Exception {
		log.debug("getting DatEstimCosecha instance");

		DatEstimCosecha entity = null;

		try {
			entity = datEstimCosechaDAO.findById(datEstimCosechaId);
		} catch (Exception e) {
			log.error("get DatEstimCosecha failed", e);
			throw new ZMessManager().new FindingException("DatEstimCosecha");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatEstimCosecha> findPageDatEstimCosecha(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatEstimCosecha> entity = null;

		try {
			entity = datEstimCosechaDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatEstimCosecha Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatEstimCosecha() throws Exception {
		Long entity = null;

		try {
			entity = datEstimCosechaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatEstimCosecha Count");
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
	public List<DatEstimCosecha> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatEstimCosecha> list = new ArrayList<DatEstimCosecha>();
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
			list = datEstimCosechaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatEstimCosechaDTO> findByCriteriaPageDatEstimCosecha(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		try {
			List<DatEstimCosecha> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("nivel2Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2Id.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel4Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel4Id.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("trabajadorCodigo")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(trabajador.codigo)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}

			entity = datEstimCosechaDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<DatEstimCosechaDTO> datEstimCosechaDTO = new ArrayList<DatEstimCosechaDTO>();

			for (DatEstimCosecha datEstimCosechaTmp : entity) {
				DatEstimCosechaDTO datEstimCosechaDTO2 = new DatEstimCosechaDTO();

				datEstimCosechaDTO2.setDatEstimCosechaId(datEstimCosechaTmp.getDatEstimCosechaId());
				datEstimCosechaDTO2.setConsecutivo(
						(datEstimCosechaTmp.getConsecutivo() != null) ? datEstimCosechaTmp.getConsecutivo() : null);
				datEstimCosechaDTO2.setAnioFiscalNivel4((datEstimCosechaTmp.getAnioFiscalNivel4() != null)
						? datEstimCosechaTmp.getAnioFiscalNivel4() : null);
				datEstimCosechaDTO2.setAreaNeta(
						(datEstimCosechaTmp.getAreaNeta() != null) ? datEstimCosechaTmp.getAreaNeta() : null);
				datEstimCosechaDTO2.setCantidadTotalEst((datEstimCosechaTmp.getCantidadTotalEst() != null)
						? datEstimCosechaTmp.getCantidadTotalEst() : null);
				datEstimCosechaDTO2.setCompania(
						(datEstimCosechaTmp.getCompania() != null) ? datEstimCosechaTmp.getCompania() : null);
				datEstimCosechaDTO2.setEdadNivel4(
						(datEstimCosechaTmp.getEdadNivel4() != null) ? datEstimCosechaTmp.getEdadNivel4() : null);
				datEstimCosechaDTO2
						.setEstado((datEstimCosechaTmp.getEstado() != null) ? datEstimCosechaTmp.getEstado() : null);
				datEstimCosechaDTO2.setEtapaNivel4(
						(datEstimCosechaTmp.getEtapaNivel4() != null) ? datEstimCosechaTmp.getEtapaNivel4() : null);
				datEstimCosechaDTO2.setFaseFenoNivel4((datEstimCosechaTmp.getFaseFenoNivel4() != null)
						? datEstimCosechaTmp.getFaseFenoNivel4() : null);
				datEstimCosechaDTO2.setFechaCreacion(datEstimCosechaTmp.getFechaCreacion());
				datEstimCosechaDTO2.setFechaModificacion(datEstimCosechaTmp.getFechaModificacion());
				datEstimCosechaDTO2.setFechaMuestra(datEstimCosechaTmp.getFechaMuestra());
				datEstimCosechaDTO2.setInfoAdicional(
						(datEstimCosechaTmp.getInfoAdicional() != null) ? datEstimCosechaTmp.getInfoAdicional() : null);
				datEstimCosechaDTO2.setInfoAdicional2((datEstimCosechaTmp.getInfoAdicional2() != null)
						? datEstimCosechaTmp.getInfoAdicional2() : null);
				datEstimCosechaDTO2.setMobileId(
						(datEstimCosechaTmp.getMobileId() != null) ? datEstimCosechaTmp.getMobileId() : null);
				datEstimCosechaDTO2.setNivel1Id(
						(datEstimCosechaTmp.getNivel1Id() != null) ? datEstimCosechaTmp.getNivel1Id() : null);

				datEstimCosechaDTO2.setNivel3Id(
						(datEstimCosechaTmp.getNivel3Id() != null) ? datEstimCosechaTmp.getNivel3Id() : null);

				datEstimCosechaDTO2.setObservacion(
						(datEstimCosechaTmp.getObservacion() != null) ? datEstimCosechaTmp.getObservacion() : null);
				datEstimCosechaDTO2.setObservacionAnularReg((datEstimCosechaTmp.getObservacionAnularReg() != null)
						? datEstimCosechaTmp.getObservacionAnularReg() : null);
				datEstimCosechaDTO2.setThEstimado(
						(datEstimCosechaTmp.getThEstimado() != null) ? datEstimCosechaTmp.getThEstimado() : null);
				datEstimCosechaDTO2.setUsuarioDigitacion((datEstimCosechaTmp.getUsuarioDigitacion() != null)
						? datEstimCosechaTmp.getUsuarioDigitacion() : null);
				datEstimCosechaDTO2.setVariedNivel4(
						(datEstimCosechaTmp.getVariedNivel4() != null) ? datEstimCosechaTmp.getVariedNivel4() : null);
				datEstimCosechaDTO2.setMotEstimId_MotEstim((datEstimCosechaTmp.getMotEstim().getMotEstimId() != null)
						? datEstimCosechaTmp.getMotEstim().getMotEstimId() : null);
				datEstimCosechaDTO2.setNivel2Id((datEstimCosechaTmp.getNivel2Id().getNivel2Id() != null)
						? datEstimCosechaTmp.getNivel2Id().getNivel2Id() : null);
				datEstimCosechaDTO2.setNivel4Id((datEstimCosechaTmp.getNivel4Id().getNivel4Id() != null)
						? datEstimCosechaTmp.getNivel4Id().getNivel4Id() : null);
				datEstimCosechaDTO2.setTrabajador((datEstimCosechaTmp.getTrabajador().getTrabId() != null)
						? datEstimCosechaTmp.getTrabajador().getTrabId() : null);

				String nombreNivel2 = datEstimCosechaTmp.getNivel2Id().getNombre();
				datEstimCosechaDTO2.setNivel2Nombre(nombreNivel2);
				String nombreNivel4 = datEstimCosechaTmp.getNivel4Id().getNombre();
				datEstimCosechaDTO2.setNivel4Nombre(nombreNivel4);
				String nombreTrabajador = datEstimCosechaTmp.getTrabajador().getNombre();
				datEstimCosechaDTO2.setTrabajadorNombre(nombreTrabajador);
				String codigoTrabajador = datEstimCosechaTmp.getTrabajador().getCodigo();
				datEstimCosechaDTO2.setTrabajadorCodigo(codigoTrabajador);

				String estadoEstrue = "false";
				if (datEstimCosechaTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datEstimCosechaDTO2.setEstadoTrue(estadoEstrue);
				}
				datEstimCosechaDTO2.setEstadoTrue(estadoEstrue);

				datEstimCosechaDTO.add(datEstimCosechaDTO2);
			}

			return datEstimCosechaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatEstimCosecha(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("nivel2Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2Id.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel4Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel4Id.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("trabajadorCodigo")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(trabajador.codigo)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}

			entity = datEstimCosechaDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatEstimCosecha Count");
		} finally {
		}
		return entity;
	}

}

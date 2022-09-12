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

import co.com.arcosoft.dataaccess.dao.IDatRiegoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatRiego;
import co.com.arcosoft.modelo.dto.DatRiegoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatRiegoLogic")
public class DatRiegoLogic implements IDatRiegoLogic {
	private static final Logger log = LoggerFactory.getLogger(DatRiegoLogic.class);

	/**
	 * DAO injected by Spring that manages DatRiego entities
	 *
	 */
	@Autowired
	private IDatRiegoDAO datRiegoDAO;

	/**
	 * Logic injected by Spring that manages Infraestructura entities
	 *
	 */
	@Autowired
	IInfraestructuraLogic logicInfraestructura1;

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
	 * Logic injected by Spring that manages SistemaRiego entities
	 *
	 */
	@Autowired
	ISistemaRiegoLogic logicSistemaRiego4;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador5;

	@Override
	@Transactional(readOnly = true)
	public List<DatRiego> getDatRiego() throws Exception {
		log.debug("finding all DatRiego instances");

		List<DatRiego> list = new ArrayList<DatRiego>();

		try {
			list = datRiegoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatRiego failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatRiego");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatRiego(DatRiego entity) throws Exception {
		log.debug("saving DatRiego instance");

		try {

			if ((entity.getNPases() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNPases(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("NPases");
			}

			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getAreaRegada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaRegada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaRegada");
			}

			if ((entity.getCaudalInfraestructura() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCaudalInfraestructura(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("caudalInfraestructura");
			}

			if ((entity.getCaudalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCaudalNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("caudalNivel4");
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

			if ((entity.getCostoTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCostoTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotal");
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

			if ((entity.getHoraTotalInfra() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHoraTotalInfra(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("horaTotalInfra");
			}

			if ((entity.getHoraTotalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHoraTotalNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("horaTotalNivel4");
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

			if ((entity.getValorUnit() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorUnit(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnit");
			}

			if ((entity.getVariedId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedId");
			}

			if ((entity.getVolM3Infra() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVolM3Infra(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("volM3Infra");
			}

			if ((entity.getVolM3Nivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVolM3Nivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("volM3Nivel4");
			}

			if ((entity.getVolTotalInfra() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVolTotalInfra(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("volTotalInfra");
			}

			if ((entity.getVolTotalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVolTotalNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("volTotalNivel4");
			}

			/*
			 * if (entity.getDatRiegoId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("datRiegoId"); }
			 * 
			 * if ((entity.getDatRiegoId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getDatRiegoId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "datRiegoId"); } if
			 * (getDatRiego(entity.getDatRiegoId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */
			datRiegoDAO.save(entity);

			log.debug("save DatRiego successful");
		} catch (Exception e) {
			log.error("save DatRiego failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatRiego(DatRiego entity) throws Exception {
		log.debug("deleting DatRiego instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatRiego");
		}

		if (entity.getDatRiegoId() == null) {
			throw new ZMessManager().new EmptyFieldException("datRiegoId");
		}

		try {
			datRiegoDAO.delete(entity);

			log.debug("delete DatRiego successful");
		} catch (Exception e) {
			log.error("delete DatRiego failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatRiego(DatRiego entity) throws Exception {
		log.debug("updating DatRiego instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatRiego");
			}

			if ((entity.getNPases() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNPases(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("NPases");
			}

			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getAreaRegada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaRegada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaRegada");
			}

			if ((entity.getCaudalInfraestructura() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCaudalInfraestructura(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("caudalInfraestructura");
			}

			if ((entity.getCaudalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCaudalNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("caudalNivel4");
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

			if ((entity.getCostoTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCostoTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotal");
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

			if ((entity.getHoraTotalInfra() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHoraTotalInfra(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("horaTotalInfra");
			}

			if ((entity.getHoraTotalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHoraTotalNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("horaTotalNivel4");
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

			if ((entity.getValorUnit() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorUnit(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnit");
			}

			if ((entity.getVariedId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedId");
			}

			if ((entity.getVolM3Infra() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVolM3Infra(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("volM3Infra");
			}

			if ((entity.getVolM3Nivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVolM3Nivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("volM3Nivel4");
			}

			if ((entity.getVolTotalInfra() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVolTotalInfra(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("volTotalInfra");
			}

			if ((entity.getVolTotalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVolTotalNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("volTotalNivel4");
			}

			if (entity.getDatRiegoId() != null) {

				datRiegoDAO.update(entity);
			} else {
				saveDatRiego(entity);
			}

			log.debug("update DatRiego successful");
		} catch (Exception e) {
			log.error("update DatRiego failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatRiegoDTO> getDataDatRiego() throws Exception {
		try {
			List<DatRiego> datRiego = datRiegoDAO.findAll();

			List<DatRiegoDTO> datRiegoDTO = new ArrayList<DatRiegoDTO>();

			for (DatRiego datRiegoTmp : datRiego) {
				DatRiegoDTO datRiegoDTO2 = new DatRiegoDTO();

				datRiegoDTO2.setDatRiegoId(datRiegoTmp.getDatRiegoId());
				datRiegoDTO2.setNPases((datRiegoTmp.getNPases() != null) ? datRiegoTmp.getNPases() : null);
				datRiegoDTO2.setAnio((datRiegoTmp.getAnio() != null) ? datRiegoTmp.getAnio() : null);
				datRiegoDTO2.setAreaRegada((datRiegoTmp.getAreaRegada() != null) ? datRiegoTmp.getAreaRegada() : null);
				datRiegoDTO2.setCaudalInfraestructura((datRiegoTmp.getCaudalInfraestructura() != null)
						? datRiegoTmp.getCaudalInfraestructura() : null);
				datRiegoDTO2.setCaudalNivel4(
						(datRiegoTmp.getCaudalNivel4() != null) ? datRiegoTmp.getCaudalNivel4() : null);
				datRiegoDTO2.setCierreCostos(
						(datRiegoTmp.getCierreCostos() != null) ? datRiegoTmp.getCierreCostos() : null);
				datRiegoDTO2.setCompania((datRiegoTmp.getCompania() != null) ? datRiegoTmp.getCompania() : null);
				datRiegoDTO2
						.setConsecutivo((datRiegoTmp.getConsecutivo() != null) ? datRiegoTmp.getConsecutivo() : null);
				datRiegoDTO2.setCostoTotal((datRiegoTmp.getCostoTotal() != null) ? datRiegoTmp.getCostoTotal() : null);
				datRiegoDTO2.setEdadEjecucion(
						(datRiegoTmp.getEdadEjecucion() != null) ? datRiegoTmp.getEdadEjecucion() : null);
				datRiegoDTO2.setEstado((datRiegoTmp.getEstado() != null) ? datRiegoTmp.getEstado() : null);
				datRiegoDTO2.setEtapaId((datRiegoTmp.getEtapaId() != null) ? datRiegoTmp.getEtapaId() : null);
				datRiegoDTO2.setFechaCreacion(datRiegoTmp.getFechaCreacion());
				datRiegoDTO2.setFechaModificacion(datRiegoTmp.getFechaModificacion());
				datRiegoDTO2.setFechaRegistro(datRiegoTmp.getFechaRegistro());
				datRiegoDTO2.setHoraFinInfra(
						(datRiegoTmp.getHoraFinInfra() != null) ? datRiegoTmp.getHoraFinInfra() : null);
				datRiegoDTO2.setHoraFinNivel4(
						(datRiegoTmp.getHoraFinNivel4() != null) ? datRiegoTmp.getHoraFinNivel4() : null);
				datRiegoDTO2.setHoraIniInfra(
						(datRiegoTmp.getHoraIniInfra() != null) ? datRiegoTmp.getHoraIniInfra() : null);
				datRiegoDTO2.setHoraIniNivel4(
						(datRiegoTmp.getHoraIniNivel4() != null) ? datRiegoTmp.getHoraIniNivel4() : null);
				datRiegoDTO2.setHoraTotalInfra(
						(datRiegoTmp.getHoraTotalInfra() != null) ? datRiegoTmp.getHoraTotalInfra() : null);
				datRiegoDTO2.setHoraTotalNivel4(
						(datRiegoTmp.getHoraTotalNivel4() != null) ? datRiegoTmp.getHoraTotalNivel4() : null);
				datRiegoDTO2.setIdMobile((datRiegoTmp.getIdMobile() != null) ? datRiegoTmp.getIdMobile() : null);
				datRiegoDTO2.setInfoAdicional(
						(datRiegoTmp.getInfoAdicional() != null) ? datRiegoTmp.getInfoAdicional() : null);
				datRiegoDTO2.setInfoAdicional2(
						(datRiegoTmp.getInfoAdicional2() != null) ? datRiegoTmp.getInfoAdicional2() : null);
				datRiegoDTO2.setLatitud((datRiegoTmp.getLatitud() != null) ? datRiegoTmp.getLatitud() : null);
				datRiegoDTO2.setLongitud((datRiegoTmp.getLongitud() != null) ? datRiegoTmp.getLongitud() : null);
				datRiegoDTO2.setNivel1Id((datRiegoTmp.getNivel1Id() != null) ? datRiegoTmp.getNivel1Id() : null);
				
				if (datRiegoTmp.getNivel2Id() != null) {
					datRiegoDTO2.setNivel2Id(datRiegoTmp.getNivel2Id());
				} else {
					datRiegoDTO2.setNivel2Id(null);
				}
				
				datRiegoDTO2.setNivel3Id((datRiegoTmp.getNivel3Id() != null) ? datRiegoTmp.getNivel3Id() : null);
				datRiegoDTO2
						.setObservacion((datRiegoTmp.getObservacion() != null) ? datRiegoTmp.getObservacion() : null);
				datRiegoDTO2.setObservacionAnularReg(
						(datRiegoTmp.getObservacionAnularReg() != null) ? datRiegoTmp.getObservacionAnularReg() : null);

				datRiegoDTO2.setPrecision((datRiegoTmp.getPrecision() != null) ? datRiegoTmp.getPrecision() : null);
				datRiegoDTO2.setUsuarioDigitacion(
						(datRiegoTmp.getUsuarioDigitacion() != null) ? datRiegoTmp.getUsuarioDigitacion() : null);
				datRiegoDTO2.setValorUnit((datRiegoTmp.getValorUnit() != null) ? datRiegoTmp.getValorUnit() : null);
				datRiegoDTO2.setVariedId((datRiegoTmp.getVariedId() != null) ? datRiegoTmp.getVariedId() : null);
				datRiegoDTO2.setVolM3Infra((datRiegoTmp.getVolM3Infra() != null) ? datRiegoTmp.getVolM3Infra() : null);
				datRiegoDTO2
						.setVolM3Nivel4((datRiegoTmp.getVolM3Nivel4() != null) ? datRiegoTmp.getVolM3Nivel4() : null);
				datRiegoDTO2.setVolTotalInfra(
						(datRiegoTmp.getVolTotalInfra() != null) ? datRiegoTmp.getVolTotalInfra() : null);
				datRiegoDTO2.setVolTotalNivel4(
						(datRiegoTmp.getVolTotalNivel4() != null) ? datRiegoTmp.getVolTotalNivel4() : null);

				if (datRiegoTmp.getInfraestructura() != null) {
					datRiegoDTO2.setInfraId_Infraestructura(datRiegoTmp.getInfraestructura());
				} else {
					datRiegoDTO2.setInfraId_Infraestructura(null);
				}

				if (datRiegoTmp.getInfraestructura() != null) {
					datRiegoDTO2.setNombreInfraestructura(datRiegoTmp.getInfraestructura().getNombre());
				} else {
					datRiegoDTO2.setNombreInfraestructura(null);
				}

				
				if (datRiegoTmp.getOrdenTrabajo() != null) {
					datRiegoDTO2.setOrdenTrabajo(datRiegoTmp.getOrdenTrabajo());
				} else {
					datRiegoDTO2.setOrdenTrabajo(null);
				}

				if (datRiegoTmp.getLabor() != null) {
					datRiegoDTO2.setLaborId_Labor(datRiegoTmp.getLabor());
				} else {
					datRiegoDTO2.setLaborId_Labor(null);
				}

				if (datRiegoTmp.getNivel4() != null) {
					datRiegoDTO2.setNivel4Id_Nivel4(datRiegoTmp.getNivel4());
				} else {
					datRiegoDTO2.setNivel4Id_Nivel4(null);
				}

				if (datRiegoTmp.getTrabajador() != null) {
					datRiegoDTO2.setTrabId_Trabajador(datRiegoTmp.getTrabajador());
				} else {
					datRiegoDTO2.setTrabId_Trabajador(null);
				}

				
				if (datRiegoTmp.getTrabajador() != null) {
					datRiegoDTO2.setTrabajadorNombre(datRiegoTmp.getTrabajador().getNombre());
				} else {
					datRiegoDTO2.setTrabajadorNombre(null);
				}



				if (datRiegoTmp.getNivel2Id() != null) {
					datRiegoDTO2.setNivel2Id(datRiegoTmp.getNivel2Id());
				} else {
					datRiegoDTO2.setNivel2Id(null);
				}

				if (datRiegoTmp.getNivel4() != null) {
					datRiegoDTO2.setNivel4Id_Nivel4(datRiegoTmp.getNivel4());
				} else {
					datRiegoDTO2.setNivel4Id_Nivel4(null);
				}

				if (datRiegoTmp.getNivel2Id() != null) {
					datRiegoDTO2.setNivel2Nombre(datRiegoTmp.getNivel2Id().getNombre());
				} else {
					datRiegoDTO2.setNivel2Nombre(null);
				}

				if (datRiegoTmp.getNivel4() != null) {
					datRiegoDTO2.setNivel4Nombre(datRiegoTmp.getNivel4().getNombre());
				} else {
					datRiegoDTO2.setNivel4Nombre(null);
				}
				
				if (datRiegoTmp.getLabor() != null) {
					datRiegoDTO2.setLaborNombre(datRiegoTmp.getLabor().getNombre());
				} else {
					datRiegoDTO2.setLaborNombre(null);
				}


				if (datRiegoTmp.getSistemaRiego() != null) {
					datRiegoDTO2.setSistemaRiegoId_SistemaRiego(datRiegoTmp.getSistemaRiego());
				} else {
					datRiegoDTO2.setSistemaRiegoId_SistemaRiego(null);
				}

				if (datRiegoTmp.getSistemaRiego() != null) {
					datRiegoDTO2.setSistemaRieNombre(datRiegoTmp.getSistemaRiego().getNombre());
				} else {
					datRiegoDTO2.setSistemaRieNombre(null);
				}


				if (datRiegoTmp.getSistemaRiego() != null) {
					datRiegoDTO2.setSistemaRieNombre(datRiegoTmp.getSistemaRiego().getNombre());
				} else {
					datRiegoDTO2.setSistemaRieNombre(null);
				}


				datRiegoDTO.add(datRiegoDTO2);
			}

			return datRiegoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatRiego getDatRiego(Long datRiegoId) throws Exception {
		log.debug("getting DatRiego instance");

		DatRiego entity = null;

		try {
			entity = datRiegoDAO.findById(datRiegoId);
		} catch (Exception e) {
			log.error("get DatRiego failed", e);
			throw new ZMessManager().new FindingException("DatRiego");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatRiego> findPageDatRiego(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<DatRiego> entity = null;

		try {
			entity = datRiegoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatRiego Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatRiego() throws Exception {
		Long entity = null;

		try {
			entity = datRiegoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatRiego Count");
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
	public List<DatRiego> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<DatRiego> list = new ArrayList<DatRiego>();
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
			list = datRiegoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatRiegoDTO> findByCriteriaPageRiego(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		try {
			List<DatRiego> entity = null;

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

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}

			entity = datRiegoDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<DatRiegoDTO> datRiegoDTO = new ArrayList<DatRiegoDTO>();

			for (DatRiego datRiegoTmp : entity) {
				DatRiegoDTO datRiegoDTO2 = new DatRiegoDTO();

					datRiegoDTO2.setDatRiegoId(datRiegoTmp.getDatRiegoId());
					datRiegoDTO2.setNPases((datRiegoTmp.getNPases() != null) ? datRiegoTmp.getNPases() : null);
					datRiegoDTO2.setAnio((datRiegoTmp.getAnio() != null) ? datRiegoTmp.getAnio() : null);
					datRiegoDTO2.setAreaRegada((datRiegoTmp.getAreaRegada() != null) ? datRiegoTmp.getAreaRegada() : null);
					datRiegoDTO2.setCaudalInfraestructura((datRiegoTmp.getCaudalInfraestructura() != null)
							? datRiegoTmp.getCaudalInfraestructura() : null);
					datRiegoDTO2.setCaudalNivel4(
							(datRiegoTmp.getCaudalNivel4() != null) ? datRiegoTmp.getCaudalNivel4() : null);
					datRiegoDTO2.setCierreCostos(
							(datRiegoTmp.getCierreCostos() != null) ? datRiegoTmp.getCierreCostos() : null);
					datRiegoDTO2.setCompania((datRiegoTmp.getCompania() != null) ? datRiegoTmp.getCompania() : null);
					datRiegoDTO2
							.setConsecutivo((datRiegoTmp.getConsecutivo() != null) ? datRiegoTmp.getConsecutivo() : null);
					datRiegoDTO2.setCostoTotal((datRiegoTmp.getCostoTotal() != null) ? datRiegoTmp.getCostoTotal() : null);
					datRiegoDTO2.setEdadEjecucion(
							(datRiegoTmp.getEdadEjecucion() != null) ? datRiegoTmp.getEdadEjecucion() : null);
					datRiegoDTO2.setEstado((datRiegoTmp.getEstado() != null) ? datRiegoTmp.getEstado() : null);
					datRiegoDTO2.setEtapaId((datRiegoTmp.getEtapaId() != null) ? datRiegoTmp.getEtapaId() : null);
					datRiegoDTO2.setFechaCreacion(datRiegoTmp.getFechaCreacion());
					datRiegoDTO2.setFechaModificacion(datRiegoTmp.getFechaModificacion());
					datRiegoDTO2.setFechaRegistro(datRiegoTmp.getFechaRegistro());
					datRiegoDTO2.setHoraFinInfra(
							(datRiegoTmp.getHoraFinInfra() != null) ? datRiegoTmp.getHoraFinInfra() : null);
					datRiegoDTO2.setHoraFinNivel4(
							(datRiegoTmp.getHoraFinNivel4() != null) ? datRiegoTmp.getHoraFinNivel4() : null);
					datRiegoDTO2.setHoraIniInfra(
							(datRiegoTmp.getHoraIniInfra() != null) ? datRiegoTmp.getHoraIniInfra() : null);
					datRiegoDTO2.setHoraIniNivel4(
							(datRiegoTmp.getHoraIniNivel4() != null) ? datRiegoTmp.getHoraIniNivel4() : null);
					datRiegoDTO2.setHoraTotalInfra(
							(datRiegoTmp.getHoraTotalInfra() != null) ? datRiegoTmp.getHoraTotalInfra() : null);
					datRiegoDTO2.setHoraTotalNivel4(
							(datRiegoTmp.getHoraTotalNivel4() != null) ? datRiegoTmp.getHoraTotalNivel4() : null);
					datRiegoDTO2.setIdMobile((datRiegoTmp.getIdMobile() != null) ? datRiegoTmp.getIdMobile() : null);
					datRiegoDTO2.setInfoAdicional(
							(datRiegoTmp.getInfoAdicional() != null) ? datRiegoTmp.getInfoAdicional() : null);
					datRiegoDTO2.setInfoAdicional2(
							(datRiegoTmp.getInfoAdicional2() != null) ? datRiegoTmp.getInfoAdicional2() : null);
					datRiegoDTO2.setLatitud((datRiegoTmp.getLatitud() != null) ? datRiegoTmp.getLatitud() : null);
					datRiegoDTO2.setLongitud((datRiegoTmp.getLongitud() != null) ? datRiegoTmp.getLongitud() : null);
					datRiegoDTO2.setNivel1Id((datRiegoTmp.getNivel1Id() != null) ? datRiegoTmp.getNivel1Id() : null);
					
					if (datRiegoTmp.getNivel2Id() != null) {
						datRiegoDTO2.setNivel2Id(datRiegoTmp.getNivel2Id());
					} else {
						datRiegoDTO2.setNivel2Id(null);
					}
					
					datRiegoDTO2.setNivel3Id((datRiegoTmp.getNivel3Id() != null) ? datRiegoTmp.getNivel3Id() : null);
					datRiegoDTO2
							.setObservacion((datRiegoTmp.getObservacion() != null) ? datRiegoTmp.getObservacion() : null);
					datRiegoDTO2.setObservacionAnularReg(
							(datRiegoTmp.getObservacionAnularReg() != null) ? datRiegoTmp.getObservacionAnularReg() : null);

					datRiegoDTO2.setPrecision((datRiegoTmp.getPrecision() != null) ? datRiegoTmp.getPrecision() : null);
					datRiegoDTO2.setUsuarioDigitacion(
							(datRiegoTmp.getUsuarioDigitacion() != null) ? datRiegoTmp.getUsuarioDigitacion() : null);
					datRiegoDTO2.setValorUnit((datRiegoTmp.getValorUnit() != null) ? datRiegoTmp.getValorUnit() : null);
					datRiegoDTO2.setVariedId((datRiegoTmp.getVariedId() != null) ? datRiegoTmp.getVariedId() : null);
					datRiegoDTO2.setVolM3Infra((datRiegoTmp.getVolM3Infra() != null) ? datRiegoTmp.getVolM3Infra() : null);
					datRiegoDTO2
							.setVolM3Nivel4((datRiegoTmp.getVolM3Nivel4() != null) ? datRiegoTmp.getVolM3Nivel4() : null);
					datRiegoDTO2.setVolTotalInfra(
							(datRiegoTmp.getVolTotalInfra() != null) ? datRiegoTmp.getVolTotalInfra() : null);
					datRiegoDTO2.setVolTotalNivel4(
							(datRiegoTmp.getVolTotalNivel4() != null) ? datRiegoTmp.getVolTotalNivel4() : null);

					if (datRiegoTmp.getInfraestructura() != null) {
						datRiegoDTO2.setInfraId_Infraestructura(datRiegoTmp.getInfraestructura());
					} else {
						datRiegoDTO2.setInfraId_Infraestructura(null);
					}

					if (datRiegoTmp.getInfraestructura() != null) {
						datRiegoDTO2.setNombreInfraestructura(datRiegoTmp.getInfraestructura().getNombre());
					} else {
						datRiegoDTO2.setNombreInfraestructura(null);
					}

					
					if (datRiegoTmp.getOrdenTrabajo() != null) {
						datRiegoDTO2.setOrdenTrabajo(datRiegoTmp.getOrdenTrabajo());
					} else {
						datRiegoDTO2.setOrdenTrabajo(null);
					}

					if (datRiegoTmp.getLabor() != null) {
						datRiegoDTO2.setLaborId_Labor(datRiegoTmp.getLabor());
					} else {
						datRiegoDTO2.setLaborId_Labor(null);
					}

					if (datRiegoTmp.getNivel4() != null) {
						datRiegoDTO2.setNivel4Id_Nivel4(datRiegoTmp.getNivel4());
					} else {
						datRiegoDTO2.setNivel4Id_Nivel4(null);
					}

					if (datRiegoTmp.getTrabajador() != null) {
						datRiegoDTO2.setTrabId_Trabajador(datRiegoTmp.getTrabajador());
					} else {
						datRiegoDTO2.setTrabId_Trabajador(null);
					}

					
					if (datRiegoTmp.getTrabajador() != null) {
						datRiegoDTO2.setTrabajadorNombre(datRiegoTmp.getTrabajador().getNombre());
					} else {
						datRiegoDTO2.setTrabajadorNombre(null);
					}



					if (datRiegoTmp.getNivel2Id() != null) {
						datRiegoDTO2.setNivel2Id(datRiegoTmp.getNivel2Id());
					} else {
						datRiegoDTO2.setNivel2Id(null);
					}

					if (datRiegoTmp.getNivel4() != null) {
						datRiegoDTO2.setNivel4Id_Nivel4(datRiegoTmp.getNivel4());
					} else {
						datRiegoDTO2.setNivel4Id_Nivel4(null);
					}

					if (datRiegoTmp.getNivel2Id() != null) {
						datRiegoDTO2.setNivel2Nombre(datRiegoTmp.getNivel2Id().getNombre());
					} else {
						datRiegoDTO2.setNivel2Nombre(null);
					}

					if (datRiegoTmp.getNivel4() != null) {
						datRiegoDTO2.setNivel4Nombre(datRiegoTmp.getNivel4().getNombre());
					} else {
						datRiegoDTO2.setNivel4Nombre(null);
					}
					
					if (datRiegoTmp.getLabor() != null) {
						datRiegoDTO2.setLaborNombre(datRiegoTmp.getLabor().getNombre());
					} else {
						datRiegoDTO2.setLaborNombre(null);
					}


					if (datRiegoTmp.getSistemaRiego() != null) {
						datRiegoDTO2.setSistemaRiegoId_SistemaRiego(datRiegoTmp.getSistemaRiego());
					} else {
						datRiegoDTO2.setSistemaRiegoId_SistemaRiego(null);
					}

					if (datRiegoTmp.getSistemaRiego() != null) {
						datRiegoDTO2.setSistemaRieNombre(datRiegoTmp.getSistemaRiego().getNombre());
					} else {
						datRiegoDTO2.setSistemaRieNombre(null);
					}


					if (datRiegoTmp.getSistemaRiego() != null) {
						datRiegoDTO2.setSistemaRieNombre(datRiegoTmp.getSistemaRiego().getNombre());
					} else {
						datRiegoDTO2.setSistemaRieNombre(null);
					}


				datRiegoDTO.add(datRiegoDTO2);
			}

			return datRiegoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberRiego(Map<String, Object> filters) throws Exception {
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

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}
			entity = datRiegoDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatRiego Count");
		} finally {
		}
		return entity;
	}





	@Override
	@Transactional(readOnly = true)
	public List<DatRiegoDTO> getDataDatRiegoByPlanillaNomina(Long planillaNominaId) throws Exception {
		try {
			
			List<DatRiego> datRiego = datRiegoDAO
					.findByCriteria("datPlanillaNominaId.planillaNominaId= " + planillaNominaId);


			List<DatRiegoDTO> datRiegoDTO = new ArrayList<DatRiegoDTO>();

			for (DatRiego datRiegoTmp : datRiego) {
				DatRiegoDTO datRiegoDTO2 = new DatRiegoDTO();

				datRiegoDTO2.setDatRiegoId(datRiegoTmp.getDatRiegoId());
				datRiegoDTO2.setNPases((datRiegoTmp.getNPases() != null) ? datRiegoTmp.getNPases() : null);
				datRiegoDTO2.setAnio((datRiegoTmp.getAnio() != null) ? datRiegoTmp.getAnio() : null);
				datRiegoDTO2.setAreaRegada((datRiegoTmp.getAreaRegada() != null) ? datRiegoTmp.getAreaRegada() : null);
				datRiegoDTO2.setCaudalInfraestructura((datRiegoTmp.getCaudalInfraestructura() != null)
						? datRiegoTmp.getCaudalInfraestructura() : null);
				datRiegoDTO2.setCaudalNivel4(
						(datRiegoTmp.getCaudalNivel4() != null) ? datRiegoTmp.getCaudalNivel4() : null);
				datRiegoDTO2.setCierreCostos(
						(datRiegoTmp.getCierreCostos() != null) ? datRiegoTmp.getCierreCostos() : null);
				datRiegoDTO2.setCompania((datRiegoTmp.getCompania() != null) ? datRiegoTmp.getCompania() : null);
				datRiegoDTO2
						.setConsecutivo((datRiegoTmp.getConsecutivo() != null) ? datRiegoTmp.getConsecutivo() : null);
				datRiegoDTO2.setCostoTotal((datRiegoTmp.getCostoTotal() != null) ? datRiegoTmp.getCostoTotal() : null);
				datRiegoDTO2.setEdadEjecucion(
						(datRiegoTmp.getEdadEjecucion() != null) ? datRiegoTmp.getEdadEjecucion() : null);
				datRiegoDTO2.setEstado((datRiegoTmp.getEstado() != null) ? datRiegoTmp.getEstado() : null);
				datRiegoDTO2.setEtapaId((datRiegoTmp.getEtapaId() != null) ? datRiegoTmp.getEtapaId() : null);
				datRiegoDTO2.setFechaCreacion(datRiegoTmp.getFechaCreacion());
				datRiegoDTO2.setFechaModificacion(datRiegoTmp.getFechaModificacion());
				datRiegoDTO2.setFechaRegistro(datRiegoTmp.getFechaRegistro());
				datRiegoDTO2.setHoraFinInfra(
						(datRiegoTmp.getHoraFinInfra() != null) ? datRiegoTmp.getHoraFinInfra() : null);
				datRiegoDTO2.setHoraFinNivel4(
						(datRiegoTmp.getHoraFinNivel4() != null) ? datRiegoTmp.getHoraFinNivel4() : null);
				datRiegoDTO2.setHoraIniInfra(
						(datRiegoTmp.getHoraIniInfra() != null) ? datRiegoTmp.getHoraIniInfra() : null);
				datRiegoDTO2.setHoraIniNivel4(
						(datRiegoTmp.getHoraIniNivel4() != null) ? datRiegoTmp.getHoraIniNivel4() : null);
				datRiegoDTO2.setHoraTotalInfra(
						(datRiegoTmp.getHoraTotalInfra() != null) ? datRiegoTmp.getHoraTotalInfra() : null);
				datRiegoDTO2.setHoraTotalNivel4(
						(datRiegoTmp.getHoraTotalNivel4() != null) ? datRiegoTmp.getHoraTotalNivel4() : null);
				datRiegoDTO2.setIdMobile((datRiegoTmp.getIdMobile() != null) ? datRiegoTmp.getIdMobile() : null);
				datRiegoDTO2.setInfoAdicional(
						(datRiegoTmp.getInfoAdicional() != null) ? datRiegoTmp.getInfoAdicional() : null);
				datRiegoDTO2.setInfoAdicional2(
						(datRiegoTmp.getInfoAdicional2() != null) ? datRiegoTmp.getInfoAdicional2() : null);
				datRiegoDTO2.setLatitud((datRiegoTmp.getLatitud() != null) ? datRiegoTmp.getLatitud() : null);
				datRiegoDTO2.setLongitud((datRiegoTmp.getLongitud() != null) ? datRiegoTmp.getLongitud() : null);
				datRiegoDTO2.setNivel1Id((datRiegoTmp.getNivel1Id() != null) ? datRiegoTmp.getNivel1Id() : null);
				
				if (datRiegoTmp.getNivel2Id() != null) {
					datRiegoDTO2.setNivel2Id(datRiegoTmp.getNivel2Id());
				} else {
					datRiegoDTO2.setNivel2Id(null);
				}
				
				datRiegoDTO2.setNivel3Id((datRiegoTmp.getNivel3Id() != null) ? datRiegoTmp.getNivel3Id() : null);
				datRiegoDTO2
						.setObservacion((datRiegoTmp.getObservacion() != null) ? datRiegoTmp.getObservacion() : null);
				datRiegoDTO2.setObservacionAnularReg(
						(datRiegoTmp.getObservacionAnularReg() != null) ? datRiegoTmp.getObservacionAnularReg() : null);

				datRiegoDTO2.setPrecision((datRiegoTmp.getPrecision() != null) ? datRiegoTmp.getPrecision() : null);
				datRiegoDTO2.setUsuarioDigitacion(
						(datRiegoTmp.getUsuarioDigitacion() != null) ? datRiegoTmp.getUsuarioDigitacion() : null);
				datRiegoDTO2.setValorUnit((datRiegoTmp.getValorUnit() != null) ? datRiegoTmp.getValorUnit() : null);
				datRiegoDTO2.setVariedId((datRiegoTmp.getVariedId() != null) ? datRiegoTmp.getVariedId() : null);
				datRiegoDTO2.setVolM3Infra((datRiegoTmp.getVolM3Infra() != null) ? datRiegoTmp.getVolM3Infra() : null);
				datRiegoDTO2
						.setVolM3Nivel4((datRiegoTmp.getVolM3Nivel4() != null) ? datRiegoTmp.getVolM3Nivel4() : null);
				datRiegoDTO2.setVolTotalInfra(
						(datRiegoTmp.getVolTotalInfra() != null) ? datRiegoTmp.getVolTotalInfra() : null);
				datRiegoDTO2.setVolTotalNivel4(
						(datRiegoTmp.getVolTotalNivel4() != null) ? datRiegoTmp.getVolTotalNivel4() : null);
				datRiegoDTO2.setTotalHorometro(
						(datRiegoTmp.getTotalHorometro() != null) ? datRiegoTmp.getTotalHorometro() : null);

				if (datRiegoTmp.getInfraestructura() != null) {
					datRiegoDTO2.setInfraId_Infraestructura(datRiegoTmp.getInfraestructura());
				} else {
					datRiegoDTO2.setInfraId_Infraestructura(null);
				}

				if (datRiegoTmp.getInfraestructura() != null) {
					datRiegoDTO2.setNombreInfraestructura(datRiegoTmp.getInfraestructura().getNombre());
				} else {
					datRiegoDTO2.setNombreInfraestructura(null);
				}

				
				if (datRiegoTmp.getOrdenTrabajo() != null) {
					datRiegoDTO2.setOrdenTrabajo(datRiegoTmp.getOrdenTrabajo());
				} else {
					datRiegoDTO2.setOrdenTrabajo(null);
				}

				if (datRiegoTmp.getLabor() != null) {
					datRiegoDTO2.setLaborId_Labor(datRiegoTmp.getLabor());
				} else {
					datRiegoDTO2.setLaborId_Labor(null);
				}

				if (datRiegoTmp.getNivel4() != null) {
					datRiegoDTO2.setNivel4Id_Nivel4(datRiegoTmp.getNivel4());
				} else {
					datRiegoDTO2.setNivel4Id_Nivel4(null);
				}

				if (datRiegoTmp.getTrabajador() != null) {
					datRiegoDTO2.setTrabId_Trabajador(datRiegoTmp.getTrabajador());
				} else {
					datRiegoDTO2.setTrabId_Trabajador(null);
				}

				
				if (datRiegoTmp.getTrabajador() != null) {
					datRiegoDTO2.setTrabajadorNombre(datRiegoTmp.getTrabajador().getNombre());
				} else {
					datRiegoDTO2.setTrabajadorNombre(null);
				}



				if (datRiegoTmp.getNivel2Id() != null) {
					datRiegoDTO2.setNivel2Id(datRiegoTmp.getNivel2Id());
				} else {
					datRiegoDTO2.setNivel2Id(null);
				}

				if (datRiegoTmp.getNivel4() != null) {
					datRiegoDTO2.setNivel4Id_Nivel4(datRiegoTmp.getNivel4());
				} else {
					datRiegoDTO2.setNivel4Id_Nivel4(null);
				}

				if (datRiegoTmp.getNivel2Id() != null) {
					datRiegoDTO2.setNivel2Nombre(datRiegoTmp.getNivel2Id().getNombre());
				} else {
					datRiegoDTO2.setNivel2Nombre(null);
				}

				if (datRiegoTmp.getNivel4() != null) {
					datRiegoDTO2.setNivel4Nombre(datRiegoTmp.getNivel4().getNombre());
				} else {
					datRiegoDTO2.setNivel4Nombre(null);
				}
				
				if (datRiegoTmp.getLabor() != null) {
					datRiegoDTO2.setLaborNombre(datRiegoTmp.getLabor().getNombre());
				} else {
					datRiegoDTO2.setLaborNombre(null);
				}


				if (datRiegoTmp.getSistemaRiego() != null) {
					datRiegoDTO2.setSistemaRiegoId_SistemaRiego(datRiegoTmp.getSistemaRiego());
				} else {
					datRiegoDTO2.setSistemaRiegoId_SistemaRiego(null);
				}

				if (datRiegoTmp.getSistemaRiego() != null) {
					datRiegoDTO2.setSistemaRieNombre(datRiegoTmp.getSistemaRiego().getNombre());
				} else {
					datRiegoDTO2.setSistemaRieNombre(null);
				}


				if (datRiegoTmp.getSistemaRiego() != null) {
					datRiegoDTO2.setSistemaRieNombre(datRiegoTmp.getSistemaRiego().getNombre());
				} else {
					datRiegoDTO2.setSistemaRieNombre(null);
				}


				datRiegoDTO.add(datRiegoDTO2);
			}

			return datRiegoDTO;
		} catch (Exception e) {
			throw e;
		}
	}



}

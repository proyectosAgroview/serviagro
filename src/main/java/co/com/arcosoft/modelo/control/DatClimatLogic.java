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

import co.com.arcosoft.dataaccess.dao.IDatClimatDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatClimat;
import co.com.arcosoft.modelo.dto.DatClimatDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatClimatLogic")
public class DatClimatLogic implements IDatClimatLogic {
	private static final Logger log = LoggerFactory.getLogger(DatClimatLogic.class);

	/**
	 * DAO injected by Spring that manages DatClimat entities
	 *
	 */
	@Autowired
	private IDatClimatDAO datClimatDAO;

	/**
	 * Logic injected by Spring that manages EstClimat entities
	 *
	 */
	@Autowired
	IEstClimatLogic logicEstClimat1;

	@Override
	@Transactional(readOnly = true)
	public List<DatClimat> getDatClimat() throws Exception {
		log.debug("finding all DatClimat instances");

		List<DatClimat> list = new ArrayList<DatClimat>();

		try {
			list = datClimatDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatClimat failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatClimat");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatClimat(DatClimat entity) throws Exception {
		log.debug("saving DatClimat instance");

		try {
			if (entity.getEstClimat() == null) {
				throw new ZMessManager().new ForeignException("estClimat");
			}

			/*
			 * if ((entity.getCodigo() != null) &&
			 * (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) ==
			 * false)) { throw new ZMessManager().new
			 * NotValidFormatException("codigo"); }
			 */

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			/*
			 * if (entity.getDatsClimatoId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "datsClimatoId"); }
			 * 
			 * if ((entity.getDatsClimatoId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getDatsClimatoId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "datsClimatoId"); }
			 */

			if ((entity.getDireccionViento() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDireccionViento(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccionViento");
			}

			if ((entity.getEnergiaSolar() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEnergiaSolar(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("energiaSolar");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEvaporacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEvaporacion(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("evaporacion");
			}

			if ((entity.getEvaporacionTranspiracion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEvaporacionTranspiracion(),
							12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("evaporacionTranspiracion");
			}

			if ((entity.getGradosDiaCalor() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getGradosDiaCalor(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("gradosDiaCalor");
			}

			if ((entity.getGradosDiaFrio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getGradosDiaFrio(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("gradosDiaFrio");
			}

			if ((entity.getHumedadMaxima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHumedadMaxima(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("hemedadMaxima");
			}

			if ((entity.getHorasLuz() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHorasLuz(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("horasLuz");
			}

			if ((entity.getHorasSol() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHorasSol(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("horasSol");
			}

			if ((entity.getHumedadExterior() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHumedadExterior(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("humedadExterior");
			}

			if ((entity.getHumedadInterior() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHumedadInterior(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("humedadInterior");
			}

			if ((entity.getHumedadMedia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHumedadMedia(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("humedadMedia");
			}

			if ((entity.getHumedadMinima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHumedadMinima(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("humedadMinima");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getInsolacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getInsolacion(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("insolacion");
			}

			if ((entity.getNubosidad() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNubosidad(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("nubosidad");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getPrecipitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPrecipitacion(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("precipitacion");
			}

			if ((entity.getPuntoRocio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPuntoRocio(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("puntoRocio");
			}

			if ((entity.getRadiacionSolar() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRadiacionSolar(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("radiacionSolar");
			}

			if ((entity.getSensacionTermica() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSensacionTermica(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("sensacionTermica");
			}

			if ((entity.getTemperaturaAmbiente() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaAmbiente(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaAmbiente");
			}

			if ((entity.getTemperaturaMaxima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMaxima(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMaxima");
			}

			if ((entity.getTemperaturaMedia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMedia(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMedia");
			}

			if ((entity.getTemperaturaMinima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMinima(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMinima");
			}

			if ((entity.getVelocidadMaxima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVelocidadMaxima(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("velocidadMaxima");
			}

			if ((entity.getVelocidadViento() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVelocidadViento(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("velocidadViento");
			}

			if (entity.getEstClimat().getEstClimatId() == null) {
				throw new ZMessManager().new EmptyFieldException("estClimatId_EstClimat");
			}

			if ((entity.getEstClimat().getEstClimatId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEstClimat().getEstClimatId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("estClimatId_EstClimat");
			}

			/*
			 * if (getDatClimat(entity.getDatsClimatoId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			datClimatDAO.save(entity);

			log.debug("save DatClimat successful");
		} catch (Exception e) {
			log.error("save DatClimat failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatClimat(DatClimat entity) throws Exception {
		log.debug("deleting DatClimat instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatClimat");
		}

		if (entity.getDatsClimatoId() == null) {
			throw new ZMessManager().new EmptyFieldException("datsClimatoId");
		}

		try {
			datClimatDAO.delete(entity);

			log.debug("delete DatClimat successful");
		} catch (Exception e) {
			log.error("delete DatClimat failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatClimat(DatClimat entity) throws Exception {
		log.debug("updating DatClimat instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatClimat");
			}

			if (entity.getEstClimat() == null) {
				throw new ZMessManager().new ForeignException("estClimat");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getDatsClimatoId() == null) {
				throw new ZMessManager().new EmptyFieldException("datsClimatoId");
			}

			if ((entity.getDatsClimatoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatsClimatoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datsClimatoId");
			}

			if ((entity.getDireccionViento() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDireccionViento(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccionViento");
			}

			if ((entity.getEnergiaSolar() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEnergiaSolar(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("energiaSolar");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEvaporacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEvaporacion(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("evaporacion");
			}

			if ((entity.getEvaporacionTranspiracion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEvaporacionTranspiracion(),
							12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("evaporacionTranspiracion");
			}

			if ((entity.getGradosDiaCalor() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getGradosDiaCalor(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("gradosDiaCalor");
			}

			if ((entity.getGradosDiaFrio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getGradosDiaFrio(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("gradosDiaFrio");
			}

			if ((entity.getHumedadMaxima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHumedadMaxima(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("hemedadMaxima");
			}

			if ((entity.getHorasLuz() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHorasLuz(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("horasLuz");
			}

			if ((entity.getHorasSol() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHorasSol(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("horasSol");
			}

			if ((entity.getHumedadExterior() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHumedadExterior(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("humedadExterior");
			}

			if ((entity.getHumedadInterior() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHumedadInterior(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("humedadInterior");
			}

			if ((entity.getHumedadMedia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHumedadMedia(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("humedadMedia");
			}

			if ((entity.getHumedadMinima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getHumedadMinima(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("humedadMinima");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getInsolacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getInsolacion(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("insolacion");
			}

			if ((entity.getNubosidad() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNubosidad(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("nubosidad");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getPrecipitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPrecipitacion(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("precipitacion");
			}

			if ((entity.getPuntoRocio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPuntoRocio(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("puntoRocio");
			}

			if ((entity.getRadiacionSolar() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRadiacionSolar(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("radiacionSolar");
			}

			if ((entity.getSensacionTermica() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSensacionTermica(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("sensacionTermica");
			}

			if ((entity.getTemperaturaAmbiente() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaAmbiente(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaAmbiente");
			}

			if ((entity.getTemperaturaMaxima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMaxima(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMaxima");
			}

			if ((entity.getTemperaturaMedia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMedia(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMedia");
			}

			if ((entity.getTemperaturaMinima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTemperaturaMinima(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("temperaturaMinima");
			}

			if ((entity.getVelocidadMaxima() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVelocidadMaxima(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("velocidadMaxima");
			}

			if ((entity.getVelocidadViento() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVelocidadViento(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("velocidadViento");
			}

			if (entity.getEstClimat().getEstClimatId() == null) {
				throw new ZMessManager().new EmptyFieldException("estClimatId_EstClimat");
			}

			if ((entity.getEstClimat().getEstClimatId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEstClimat().getEstClimatId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("estClimatId_EstClimat");
			}

			datClimatDAO.update(entity);

			log.debug("update DatClimat successful");
		} catch (Exception e) {
			log.error("update DatClimat failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatClimatDTO> getDataDatClimat() throws Exception {
		try {
			List<DatClimat> datClimat = datClimatDAO.findAll();

			List<DatClimatDTO> datClimatDTO = new ArrayList<DatClimatDTO>();

			for (DatClimat datClimatTmp : datClimat) {
				DatClimatDTO datClimatDTO2 = new DatClimatDTO();

				datClimatDTO2.setDatsClimatoId(datClimatTmp.getDatsClimatoId());
				datClimatDTO2.setCompania((datClimatTmp.getCompania() != null) ? datClimatTmp.getCompania() : null);
				datClimatDTO2.setDireccionViento(
						(datClimatTmp.getDireccionViento() != null) ? datClimatTmp.getDireccionViento() : null);
				datClimatDTO2.setEnergiaSolar(
						(datClimatTmp.getEnergiaSolar() != null) ? datClimatTmp.getEnergiaSolar() : null);
				datClimatDTO2.setEstado((datClimatTmp.getEstado() != null) ? datClimatTmp.getEstado() : null);
				datClimatDTO2
						.setEvaporacion((datClimatTmp.getEvaporacion() != null) ? datClimatTmp.getEvaporacion() : null);
				datClimatDTO2.setEvaporacionTranspiracion((datClimatTmp.getEvaporacionTranspiracion() != null)
						? datClimatTmp.getEvaporacionTranspiracion() : null);
				datClimatDTO2.setFechaAnulacion(datClimatTmp.getFechaAnulacion());
				datClimatDTO2.setFechaCreacion(datClimatTmp.getFechaCreacion());
				datClimatDTO2.setFechaLluvia(datClimatTmp.getFechaLluvia());
				datClimatDTO2.setFechaModificacion(datClimatTmp.getFechaModificacion());
				datClimatDTO2.setGradosDiaCalor(
						(datClimatTmp.getGradosDiaCalor() != null) ? datClimatTmp.getGradosDiaCalor() : null);
				datClimatDTO2.setGradosDiaFrio(
						(datClimatTmp.getGradosDiaFrio() != null) ? datClimatTmp.getGradosDiaFrio() : null);
				datClimatDTO2.setHemedadMaxima(
						(datClimatTmp.getHumedadMaxima() != null) ? datClimatTmp.getHumedadMaxima() : null);
				datClimatDTO2.setHorasLuz((datClimatTmp.getHorasLuz() != null) ? datClimatTmp.getHorasLuz() : null);
				datClimatDTO2.setHorasSol((datClimatTmp.getHorasSol() != null) ? datClimatTmp.getHorasSol() : null);
				datClimatDTO2.setHumedadExterior(
						(datClimatTmp.getHumedadExterior() != null) ? datClimatTmp.getHumedadExterior() : null);
				datClimatDTO2.setHumedadInterior(
						(datClimatTmp.getHumedadInterior() != null) ? datClimatTmp.getHumedadInterior() : null);
				datClimatDTO2.setHumedadMedia(
						(datClimatTmp.getHumedadMedia() != null) ? datClimatTmp.getHumedadMedia() : null);
				datClimatDTO2.setHumedadMinima(
						(datClimatTmp.getHumedadMinima() != null) ? datClimatTmp.getHumedadMinima() : null);
				datClimatDTO2.setInfoAdicional(
						(datClimatTmp.getInfoAdicional() != null) ? datClimatTmp.getInfoAdicional() : null);
				datClimatDTO2.setInfoAdicional2(
						(datClimatTmp.getInfoAdicional2() != null) ? datClimatTmp.getInfoAdicional2() : null);
				datClimatDTO2
						.setInsolacion((datClimatTmp.getInsolacion() != null) ? datClimatTmp.getInsolacion() : null);
				datClimatDTO2.setNubosidad((datClimatTmp.getNubosidad() != null) ? datClimatTmp.getNubosidad() : null);
				datClimatDTO2
						.setObservacion((datClimatTmp.getObservacion() != null) ? datClimatTmp.getObservacion() : null);
				datClimatDTO2.setObservacionAnularReg((datClimatTmp.getObservacionAnularReg() != null)
						? datClimatTmp.getObservacionAnularReg() : null);
				datClimatDTO2.setPrecipitacion(
						(datClimatTmp.getPrecipitacion() != null) ? datClimatTmp.getPrecipitacion() : null);
				datClimatDTO2
						.setPuntoRocio((datClimatTmp.getPuntoRocio() != null) ? datClimatTmp.getPuntoRocio() : null);
				datClimatDTO2.setRadiacionSolar(
						(datClimatTmp.getRadiacionSolar() != null) ? datClimatTmp.getRadiacionSolar() : null);
				datClimatDTO2.setSensacionTermica(
						(datClimatTmp.getSensacionTermica() != null) ? datClimatTmp.getSensacionTermica() : null);
				datClimatDTO2.setTemperaturaAmbiente(
						(datClimatTmp.getTemperaturaAmbiente() != null) ? datClimatTmp.getTemperaturaAmbiente() : null);
				datClimatDTO2.setTemperaturaMaxima(
						(datClimatTmp.getTemperaturaMaxima() != null) ? datClimatTmp.getTemperaturaMaxima() : null);
				datClimatDTO2.setTemperaturaMedia(
						(datClimatTmp.getTemperaturaMedia() != null) ? datClimatTmp.getTemperaturaMedia() : null);
				datClimatDTO2.setTemperaturaMinima(
						(datClimatTmp.getTemperaturaMinima() != null) ? datClimatTmp.getTemperaturaMinima() : null);
				datClimatDTO2.setVelocidadMaxima(
						(datClimatTmp.getVelocidadMaxima() != null) ? datClimatTmp.getVelocidadMaxima() : null);
				datClimatDTO2.setVelocidadViento(
						(datClimatTmp.getVelocidadViento() != null) ? datClimatTmp.getVelocidadViento() : null);
				datClimatDTO2.setEstClimatId_EstClimat((datClimatTmp.getEstClimat().getEstClimatId() != null)
						? datClimatTmp.getEstClimat().getEstClimatId() : null);

				String nombreEstclimat = datClimatTmp.getEstClimat().getNombre();
				datClimatDTO2.setNombreEstclimat(nombreEstclimat);

				String estadoEstrue = "false";
				if (datClimatTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datClimatDTO2.setEstadoTrue(estadoEstrue);
				}
				datClimatDTO2.setEstadoTrue(estadoEstrue);

				datClimatDTO.add(datClimatDTO2);

			}

			return datClimatDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatClimat getDatClimat(Long datsClimatoId) throws Exception {
		log.debug("getting DatClimat instance");

		DatClimat entity = null;

		try {
			entity = datClimatDAO.findById(datsClimatoId);
		} catch (Exception e) {
			log.error("get DatClimat failed", e);
			throw new ZMessManager().new FindingException("DatClimat");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatClimat> findPageDatClimat(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<DatClimat> entity = null;

		try {
			entity = datClimatDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatClimat Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatClimat() throws Exception {
		Long entity = null;

		try {
			entity = datClimatDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatClimat Count");
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
	public List<DatClimat> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<DatClimat> list = new ArrayList<DatClimat>();
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
			list = datClimatDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatClimatDTO> findByCriteriaPageClima(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		try {
			List<DatClimat> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("nombreEstclimat")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(estClimat.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
				}

			}

			entity = datClimatDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<DatClimatDTO> datClimatDTO = new ArrayList<DatClimatDTO>();

			for (DatClimat datClimatTmp : entity) {
				DatClimatDTO datClimatDTO2 = new DatClimatDTO();

				datClimatDTO2.setDatsClimatoId(datClimatTmp.getDatsClimatoId());
				datClimatDTO2.setCompania((datClimatTmp.getCompania() != null) ? datClimatTmp.getCompania() : null);
				datClimatDTO2.setDireccionViento(
						(datClimatTmp.getDireccionViento() != null) ? datClimatTmp.getDireccionViento() : null);
				datClimatDTO2.setEnergiaSolar(
						(datClimatTmp.getEnergiaSolar() != null) ? datClimatTmp.getEnergiaSolar() : null);
				datClimatDTO2.setEstado((datClimatTmp.getEstado() != null) ? datClimatTmp.getEstado() : null);
				datClimatDTO2
						.setEvaporacion((datClimatTmp.getEvaporacion() != null) ? datClimatTmp.getEvaporacion() : null);
				datClimatDTO2.setEvaporacionTranspiracion((datClimatTmp.getEvaporacionTranspiracion() != null)
						? datClimatTmp.getEvaporacionTranspiracion() : null);
				datClimatDTO2.setFechaAnulacion(datClimatTmp.getFechaAnulacion());
				datClimatDTO2.setFechaCreacion(datClimatTmp.getFechaCreacion());
				datClimatDTO2.setFechaLluvia(datClimatTmp.getFechaLluvia());
				datClimatDTO2.setFechaModificacion(datClimatTmp.getFechaModificacion());
				datClimatDTO2.setGradosDiaCalor(
						(datClimatTmp.getGradosDiaCalor() != null) ? datClimatTmp.getGradosDiaCalor() : null);
				datClimatDTO2.setGradosDiaFrio(
						(datClimatTmp.getGradosDiaFrio() != null) ? datClimatTmp.getGradosDiaFrio() : null);
				datClimatDTO2.setHemedadMaxima(
						(datClimatTmp.getHumedadMaxima() != null) ? datClimatTmp.getHumedadMaxima() : null);
				datClimatDTO2.setHorasLuz((datClimatTmp.getHorasLuz() != null) ? datClimatTmp.getHorasLuz() : null);
				datClimatDTO2.setHorasSol((datClimatTmp.getHorasSol() != null) ? datClimatTmp.getHorasSol() : null);
				datClimatDTO2.setHumedadExterior(
						(datClimatTmp.getHumedadExterior() != null) ? datClimatTmp.getHumedadExterior() : null);
				datClimatDTO2.setHumedadInterior(
						(datClimatTmp.getHumedadInterior() != null) ? datClimatTmp.getHumedadInterior() : null);
				datClimatDTO2.setHumedadMedia(
						(datClimatTmp.getHumedadMedia() != null) ? datClimatTmp.getHumedadMedia() : null);
				datClimatDTO2.setHumedadMinima(
						(datClimatTmp.getHumedadMinima() != null) ? datClimatTmp.getHumedadMinima() : null);
				datClimatDTO2.setInfoAdicional(
						(datClimatTmp.getInfoAdicional() != null) ? datClimatTmp.getInfoAdicional() : null);
				datClimatDTO2.setInfoAdicional2(
						(datClimatTmp.getInfoAdicional2() != null) ? datClimatTmp.getInfoAdicional2() : null);
				datClimatDTO2
						.setInsolacion((datClimatTmp.getInsolacion() != null) ? datClimatTmp.getInsolacion() : null);
				datClimatDTO2.setNubosidad((datClimatTmp.getNubosidad() != null) ? datClimatTmp.getNubosidad() : null);
				datClimatDTO2
						.setObservacion((datClimatTmp.getObservacion() != null) ? datClimatTmp.getObservacion() : null);
				datClimatDTO2.setObservacionAnularReg((datClimatTmp.getObservacionAnularReg() != null)
						? datClimatTmp.getObservacionAnularReg() : null);
				datClimatDTO2.setPrecipitacion(
						(datClimatTmp.getPrecipitacion() != null) ? datClimatTmp.getPrecipitacion() : null);
				datClimatDTO2
						.setPuntoRocio((datClimatTmp.getPuntoRocio() != null) ? datClimatTmp.getPuntoRocio() : null);
				datClimatDTO2.setRadiacionSolar(
						(datClimatTmp.getRadiacionSolar() != null) ? datClimatTmp.getRadiacionSolar() : null);
				datClimatDTO2.setSensacionTermica(
						(datClimatTmp.getSensacionTermica() != null) ? datClimatTmp.getSensacionTermica() : null);
				datClimatDTO2.setTemperaturaAmbiente(
						(datClimatTmp.getTemperaturaAmbiente() != null) ? datClimatTmp.getTemperaturaAmbiente() : null);
				datClimatDTO2.setTemperaturaMaxima(
						(datClimatTmp.getTemperaturaMaxima() != null) ? datClimatTmp.getTemperaturaMaxima() : null);
				datClimatDTO2.setTemperaturaMedia(
						(datClimatTmp.getTemperaturaMedia() != null) ? datClimatTmp.getTemperaturaMedia() : null);
				datClimatDTO2.setTemperaturaMinima(
						(datClimatTmp.getTemperaturaMinima() != null) ? datClimatTmp.getTemperaturaMinima() : null);
				datClimatDTO2.setVelocidadMaxima(
						(datClimatTmp.getVelocidadMaxima() != null) ? datClimatTmp.getVelocidadMaxima() : null);
				datClimatDTO2.setVelocidadViento(
						(datClimatTmp.getVelocidadViento() != null) ? datClimatTmp.getVelocidadViento() : null);
				datClimatDTO2.setEstClimatId_EstClimat((datClimatTmp.getEstClimat().getEstClimatId() != null)
						? datClimatTmp.getEstClimat().getEstClimatId() : null);

				String nombreEstclimat = datClimatTmp.getEstClimat().getNombre();
				datClimatDTO2.setNombreEstclimat(nombreEstclimat);

				String estadoEstrue = "false";
				if (datClimatTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datClimatDTO2.setEstadoTrue(estadoEstrue);
				}
				datClimatDTO2.setEstadoTrue(estadoEstrue);

				datClimatDTO.add(datClimatDTO2);

			}

			return datClimatDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberClima(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("nombreEstclimat")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(estClimat.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
				}
			}
			entity = datClimatDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatClimat Count");
		} finally {
		}
		return entity;
	}

}

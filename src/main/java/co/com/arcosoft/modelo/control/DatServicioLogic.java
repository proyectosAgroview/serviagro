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

import co.com.arcosoft.dataaccess.dao.IDatServImplementoDAO;
import co.com.arcosoft.dataaccess.dao.IDatServicioDAO;
import co.com.arcosoft.dataaccess.dao.IDatServicioDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatServImplemento;
import co.com.arcosoft.modelo.DatServicio;
import co.com.arcosoft.modelo.DatServicioDet;
import co.com.arcosoft.modelo.dto.DatServicioDTO;
import co.com.arcosoft.modelo.dto.DatServicioDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatServicioLogic")
public class DatServicioLogic implements IDatServicioLogic {
	private static final Logger log = LoggerFactory.getLogger(DatServicioLogic.class);

	/**
	 * DAO injected by Spring that manages DatServicio entities
	 *
	 */
	@Autowired
	private IDatServicioDAO datServicioDAO;

	@Autowired
	private IDatServicioDetDAO datServicioDetDAO;

	/**
	 * DAO injected by Spring that manages DatServImplemento entities
	 *
	 */
	@Autowired
	private IDatServImplementoDAO datServImplementoDAO;

	/**
	 * Logic injected by Spring that manages Contratista entities
	 *
	 */

	/**
	 * Logic injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	IEquipoLogic logicEquipo2;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor3;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel44;

	/**
	 * Logic injected by Spring that manages Servicio entities
	 *
	 */
	@Autowired
	IServicioLogic logicServicio5;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador6;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed7;

	@Override
	@Transactional(readOnly = true)
	public List<DatServicio> getDatServicio() throws Exception {
		log.debug("finding all DatServicio instances");

		List<DatServicio> list = new ArrayList<DatServicio>();

		try {
			list = datServicioDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatServicio failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatServicio");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatServicio(DatServicio entity, List<DatServicioDetDTO> dataDetServicio) throws Exception {
		log.debug("saving DatServicio instance");

		try {

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

			if ((entity.getTrabajador() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			/*
			 * if (entity.getDatServicioId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "datServicioId"); }
			 * 
			 * if ((entity.getDatServicioId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getDatServicioId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "datServicioId"); }
			 * 
			 * if (getDatServicio(entity.getDatServicioId()) != null) { throw
			 * new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */
			datServicioDAO.save(entity);

			if (dataDetServicio != null) {

				for (DatServicioDetDTO valorDto : dataDetServicio) {

					if (valorDto.getDatServicioDetId() == null) {

						DatServicioDet valor = new DatServicioDet();

						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setUdadMedByUdadMedPago(valorDto.getUdadMedPago());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnit(valorDto.getValorUnit());
						valor.setHoraFinal(valorDto.getHoraFinal());
						valor.setHoraInicial(valorDto.getHoraInicial());
						valor.setHorometroInicial(valorDto.getHorometroInicial());
						valor.setHorometroFinal(valorDto.getHorometroFinal());
						valor.setTotalHoras(valorDto.getTotalHoras());
						valor.setCantidadPago(valorDto.getTotalHoras());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());

						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4());
						valor.setDatServicioId(entity);

						datServicioDetDAO.save(valor);
					}

				}
			}

			log.debug("save DatServicio successful");
		} catch (Exception e) {
			log.error("save DatServicio failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatServicio(DatServicio entity) throws Exception {
		log.debug("deleting DatServicio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatServicio");
		}

		if (entity.getDatServicioId() == null) {
			throw new ZMessManager().new EmptyFieldException("datServicioId");
		}

		List<DatServImplemento> datServImplementos = null;
		List<DatServicioDet> datServicioDets = null;

		try {
			datServImplementos = datServImplementoDAO.findByProperty("datServicio.datServicioId",
					entity.getDatServicioId());

			if (Utilities.validationsList(datServImplementos) == true) {
				throw new ZMessManager().new DeletingException("datServImplementos");
			}

			datServicioDets = datServicioDetDAO.findByProperty("datServicio.datServicioId", entity.getDatServicioId());

			if (Utilities.validationsList(datServicioDets) == true) {
				throw new ZMessManager().new DeletingException("datServicioDets");

			}

			datServicioDAO.delete(entity);

			log.debug("delete DatServicio successful");
		} catch (Exception e) {
			log.error("delete DatServicio failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatServicio(DatServicio entity, List<DatServicioDetDTO> dataDetServicio) throws Exception {
		log.debug("updating DatServicio instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatServicio");
			}

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
			 * DatServicioDet valor = datServicioDetDAO
			 * .findById(valorDto.getDatServicioDetId());
			 * 
			 * if (valorDto.getDatServicioDetId() == null) {
			 * 
			 */

			if (entity.getDatServicioId() != null) {

				datServicioDAO.update(entity);

				for (DatServicioDetDTO valorDto : dataDetServicio) {

					if (valorDto.getDatServicioDetId() == null) { // crear el
																	// valor
																	// nuevo

						DatServicioDet valor = new DatServicioDet();

						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setUdadMedByUdadMedPago(valorDto.getUdadMedPago());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnit(valorDto.getValorUnit());
						valor.setHoraFinal(valorDto.getHoraFinal());
						valor.setCantidadPago(valorDto.getTotalHoras());
						valor.setHoraInicial(valorDto.getHoraInicial());
						valor.setTotalHoras(valorDto.getTotalHoras());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setHorometroInicial(valorDto.getHorometroInicial());
						valor.setHorometroFinal(valorDto.getHorometroFinal());

						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4());
						valor.setDatServicioId(entity);
						datServicioDetDAO.save(valor);

					} else {
						DatServicioDet valor = datServicioDetDAO.findById(valorDto.getDatServicioDetId());

						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setUdadMedByUdadMedPago(valorDto.getUdadMedPago());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnit(valorDto.getValorUnit());
						valor.setHoraFinal(valorDto.getHoraFinal());
						valor.setCantidadPago(valorDto.getTotalHoras());
						valor.setHoraInicial(valorDto.getHoraInicial());
						valor.setTotalHoras(valorDto.getTotalHoras());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setHorometroInicial(valorDto.getHorometroInicial());
						valor.setHorometroFinal(valorDto.getHorometroFinal());

						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4());

						datServicioDetDAO.update(valor);
					}

				}

			} else {

				saveDatServicio(entity, dataDetServicio);
			}

			log.debug("update DatServicio successful");
		} catch (Exception e) {
			log.error("update DatServicio failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatServicioDTO> getDataDatServicio() throws Exception {
		try {
			List<DatServicio> datServicio = datServicioDAO.findAll();

			List<DatServicioDTO> datServicioDTO = new ArrayList<DatServicioDTO>();

			for (DatServicio datServicioTmp : datServicio) {
				DatServicioDTO datServicioDTO2 = new DatServicioDTO();

				datServicioDTO2.setDatServicioId(datServicioTmp.getDatServicioId());
				datServicioDTO2.setNPases((datServicioTmp.getNPases() != null) ? datServicioTmp.getNPases() : null);
				datServicioDTO2.setAnio((datServicioTmp.getAnio() != null) ? datServicioTmp.getAnio() : null);
				datServicioDTO2.setCantidadPago(
						(datServicioTmp.getCantidadPago() != null) ? datServicioTmp.getCantidadPago() : null);
				datServicioDTO2.setCierreCostos(
						(datServicioTmp.getCierreCostos() != null) ? datServicioTmp.getCierreCostos() : null);
				datServicioDTO2
						.setCompania((datServicioTmp.getCompania() != null) ? datServicioTmp.getCompania() : null);
				datServicioDTO2.setConsecutivo(
						(datServicioTmp.getConsecutivo() != null) ? datServicioTmp.getConsecutivo() : null);
				datServicioDTO2.setCostoTotal(
						(datServicioTmp.getCostoTotal() != null) ? datServicioTmp.getCostoTotal() : null);
				datServicioDTO2.setDocumetoErp(
						(datServicioTmp.getDocumetoErp() != null) ? datServicioTmp.getDocumetoErp() : null);
				datServicioDTO2.setEdadEjecucion(
						(datServicioTmp.getEdadEjecucion() != null) ? datServicioTmp.getEdadEjecucion() : null);
				datServicioDTO2.setEstado((datServicioTmp.getEstado() != null) ? datServicioTmp.getEstado() : null);
				datServicioDTO2.setEtapaId((datServicioTmp.getEtapaId() != null) ? datServicioTmp.getEtapaId() : null);
				datServicioDTO2.setFechaCreacion(datServicioTmp.getFechaCreacion());
				datServicioDTO2.setFechaModificacion(datServicioTmp.getFechaModificacion());
				datServicioDTO2.setFechaRegistro(datServicioTmp.getFechaRegistro());

				datServicioDTO2
						.setHoraFinal((datServicioTmp.getHoraFinal() != null) ? datServicioTmp.getHoraFinal() : null);
				datServicioDTO2.setHoraInicial(
						(datServicioTmp.getHoraInicial() != null) ? datServicioTmp.getHoraInicial() : null);
				datServicioDTO2
						.setIdMobile((datServicioTmp.getIdMobile() != null) ? datServicioTmp.getIdMobile() : null);
				datServicioDTO2.setInfoAdicional(
						(datServicioTmp.getInfoAdicional() != null) ? datServicioTmp.getInfoAdicional() : null);
				datServicioDTO2.setInfoAdicional2(
						(datServicioTmp.getInfoAdicional2() != null) ? datServicioTmp.getInfoAdicional2() : null);
				datServicioDTO2.setLatitud((datServicioTmp.getLatitud() != null) ? datServicioTmp.getLatitud() : null);
				datServicioDTO2
						.setLongitud((datServicioTmp.getLongitud() != null) ? datServicioTmp.getLongitud() : null);
				datServicioDTO2
						.setNivel1Id((datServicioTmp.getNivel1Id() != null) ? datServicioTmp.getNivel1Id() : null);
				if (datServicioTmp.getNivel2Id() != null) {
					datServicioDTO2.setNivel2Id(datServicioTmp.getNivel2Id().getNivel2Id());
				} else {
					datServicioDTO2.setNivel2Id(null);
				}
				datServicioDTO2
						.setNivel3Id((datServicioTmp.getNivel3Id() != null) ? datServicioTmp.getNivel3Id() : null);
				datServicioDTO2.setObservacion(
						(datServicioTmp.getObservacion() != null) ? datServicioTmp.getObservacion() : null);
				datServicioDTO2.setObservacionAnularReg((datServicioTmp.getObservacionAnularReg() != null)
						? datServicioTmp.getObservacionAnularReg() : null);
				datServicioDTO2
						.setPrecision((datServicioTmp.getPrecision() != null) ? datServicioTmp.getPrecision() : null);
				datServicioDTO2.setTiempoInactivo(
						(datServicioTmp.getTiempoInactivo() != null) ? datServicioTmp.getTiempoInactivo() : null);
				datServicioDTO2.setTotalHoras(
						(datServicioTmp.getTotalHoras() != null) ? datServicioTmp.getTotalHoras() : null);
				datServicioDTO2.setUsuarioDigitacion(
						(datServicioTmp.getUsuarioDigitacion() != null) ? datServicioTmp.getUsuarioDigitacion() : null);
				datServicioDTO2
						.setValorUnit((datServicioTmp.getValorUnit() != null) ? datServicioTmp.getValorUnit() : null);
				datServicioDTO2
						.setVariedId((datServicioTmp.getVariedId() != null) ? datServicioTmp.getVariedId() : null);

				if (datServicioTmp.getContratista() != null) {
					datServicioDTO2.setContratistaId_Contratista(datServicioTmp.getContratista().getPersEmprId());
				} else {
					datServicioDTO2.setContratistaId_Contratista(null);
				}

				if (datServicioTmp.getEquipo() != null) {
					datServicioDTO2.setEquipoId_Equipo(datServicioTmp.getEquipo());
				} else {
					datServicioDTO2.setEquipoId_Equipo(null);
				}
				if (datServicioTmp.getOrdenTrabajo() != null) {
					datServicioDTO2.setOrdenTrabajo(datServicioTmp.getOrdenTrabajo().getPlanLaborDetId());
				} else {
					datServicioDTO2.setOrdenTrabajo(null);
				}

				if (datServicioTmp.getLabor() != null) {
					datServicioDTO2.setLaborId_Labor(datServicioTmp.getLabor().getLaborId());
				} else {
					datServicioDTO2.setLaborId_Labor(null);
				}

				if (datServicioTmp.getNivel4() != null) {
					datServicioDTO2.setNivel4Id_Nivel4(datServicioTmp.getNivel4().getNivel4Id());
				} else {
					datServicioDTO2.setNivel4Id_Nivel4(null);
				}

				if (datServicioTmp.getTrabajador() != null) {
					datServicioDTO2.setTrabId_Trabajador(datServicioTmp.getTrabajador());
				} else {
					datServicioDTO2.setTrabId_Trabajador(null);
				}

				datServicioDTO2.setUdadMedId_UdadMed(
						(datServicioTmp.getUdadMed() != null) ? datServicioTmp.getUdadMed() : null);

				String nombreLabor = datServicioTmp.getLabor().getNombre();
				datServicioDTO2.setLaborNombre(nombreLabor);
				String nombreNivel2 = datServicioTmp.getNivel2Id().getNombre();
				datServicioDTO2.setNivel2Nombre(nombreNivel2);
				String nombreNivel4 = datServicioTmp.getNivel4().getNombre();
				datServicioDTO2.setNivel4Nombre(nombreNivel4);
				String nombreServicio = datServicioTmp.getServicio().getNombre();
				datServicioDTO2.setServicioNombre(nombreServicio);
				String nombreContratista = datServicioTmp.getContratista().getNombre();
				datServicioDTO2.setContratistaNombre(nombreContratista);
				String codigoContratista = datServicioTmp.getContratista().getCodigo();
				datServicioDTO2.setContratistaCodigo(codigoContratista);

				datServicioDTO.add(datServicioDTO2);
			}

			return datServicioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatServicio getDatServicio(Long datServicioId) throws Exception {
		log.debug("getting DatServicio instance");

		DatServicio entity = null;

		try {
			entity = datServicioDAO.findById(datServicioId);
		} catch (Exception e) {
			log.error("get DatServicio failed", e);
			throw new ZMessManager().new FindingException("DatServicio");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatServicio> findPageDatServicio(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatServicio> entity = null;

		try {
			entity = datServicioDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatServicio Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatServicio() throws Exception {
		Long entity = null;

		try {
			entity = datServicioDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatServicio Count");
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
	public List<DatServicio> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatServicio> list = new ArrayList<DatServicio>();
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
			list = datServicioDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatServicioDTO> findByCriteriaPageServicio(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		try {

			List<DatServicio> entity = null;
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("laborNombre")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(labor.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("ordenTrabajo")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ")
							+ "upper(ordenTrabajo.ordenTrabajo)" + " LIKE '%" + e.getValue().toString().toUpperCase()
							+ "%' ";

				} else if (e.getKey().equals("nivel2Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2Id.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel4Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel4.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("contratistaNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(contratista.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("udadMedNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(udadMed.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("servicioNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(servicio.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}

			entity = datServicioDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<DatServicioDTO> datServicioDTO = new ArrayList<DatServicioDTO>();

			for (DatServicio datServicioTmp : entity) {
				DatServicioDTO datServicioDTO2 = new DatServicioDTO();

				datServicioDTO2.setDatServicioId(datServicioTmp.getDatServicioId());
				datServicioDTO2.setNPases((datServicioTmp.getNPases() != null) ? datServicioTmp.getNPases() : null);
				datServicioDTO2.setAnio((datServicioTmp.getAnio() != null) ? datServicioTmp.getAnio() : null);
				datServicioDTO2.setCantidadPago(
						(datServicioTmp.getCantidadPago() != null) ? datServicioTmp.getCantidadPago() : null);
				datServicioDTO2.setCierreCostos(
						(datServicioTmp.getCierreCostos() != null) ? datServicioTmp.getCierreCostos() : null);
				datServicioDTO2
						.setCompania((datServicioTmp.getCompania() != null) ? datServicioTmp.getCompania() : null);
				datServicioDTO2.setConsecutivo(
						(datServicioTmp.getConsecutivo() != null) ? datServicioTmp.getConsecutivo() : null);
				datServicioDTO2.setCostoTotal(
						(datServicioTmp.getCostoTotal() != null) ? datServicioTmp.getCostoTotal() : null);
				datServicioDTO2.setDocumetoErp(
						(datServicioTmp.getDocumetoErp() != null) ? datServicioTmp.getDocumetoErp() : null);
				datServicioDTO2.setEdadEjecucion(
						(datServicioTmp.getEdadEjecucion() != null) ? datServicioTmp.getEdadEjecucion() : null);
				datServicioDTO2.setEstado((datServicioTmp.getEstado() != null) ? datServicioTmp.getEstado() : null);
				datServicioDTO2.setEtapaId((datServicioTmp.getEtapaId() != null) ? datServicioTmp.getEtapaId() : null);

				datServicioDTO2.setFechaCreacion(datServicioTmp.getFechaCreacion());
				datServicioDTO2.setFechaModificacion(datServicioTmp.getFechaModificacion());
				datServicioDTO2.setFechaRegistro(datServicioTmp.getFechaRegistro());

				datServicioDTO2
						.setHoraFinal((datServicioTmp.getHoraFinal() != null) ? datServicioTmp.getHoraFinal() : null);
				datServicioDTO2.setHoraInicial(
						(datServicioTmp.getHoraInicial() != null) ? datServicioTmp.getHoraInicial() : null);
				datServicioDTO2
						.setIdMobile((datServicioTmp.getIdMobile() != null) ? datServicioTmp.getIdMobile() : null);
				datServicioDTO2.setInfoAdicional(
						(datServicioTmp.getInfoAdicional() != null) ? datServicioTmp.getInfoAdicional() : null);
				datServicioDTO2.setInfoAdicional2(
						(datServicioTmp.getInfoAdicional2() != null) ? datServicioTmp.getInfoAdicional2() : null);
				datServicioDTO2.setLatitud((datServicioTmp.getLatitud() != null) ? datServicioTmp.getLatitud() : null);
				datServicioDTO2
						.setLongitud((datServicioTmp.getLongitud() != null) ? datServicioTmp.getLongitud() : null);
				datServicioDTO2
						.setNivel1Id((datServicioTmp.getNivel1Id() != null) ? datServicioTmp.getNivel1Id() : null);
				if (datServicioTmp.getNivel2Id() != null) {
					datServicioDTO2.setNivel2Id(datServicioTmp.getNivel2Id().getNivel2Id());
				} else {
					datServicioDTO2.setNivel2Id(null);
				}
				datServicioDTO2
						.setNivel3Id((datServicioTmp.getNivel3Id() != null) ? datServicioTmp.getNivel3Id() : null);
				datServicioDTO2.setObservacion(
						(datServicioTmp.getObservacion() != null) ? datServicioTmp.getObservacion() : null);
				datServicioDTO2.setObservacionAnularReg((datServicioTmp.getObservacionAnularReg() != null)
						? datServicioTmp.getObservacionAnularReg() : null);
				datServicioDTO2
						.setPrecision((datServicioTmp.getPrecision() != null) ? datServicioTmp.getPrecision() : null);
				datServicioDTO2.setTiempoInactivo(
						(datServicioTmp.getTiempoInactivo() != null) ? datServicioTmp.getTiempoInactivo() : null);
				datServicioDTO2.setTotalHoras(
						(datServicioTmp.getTotalHoras() != null) ? datServicioTmp.getTotalHoras() : null);
				datServicioDTO2.setUsuarioDigitacion(
						(datServicioTmp.getUsuarioDigitacion() != null) ? datServicioTmp.getUsuarioDigitacion() : null);
				datServicioDTO2
						.setValorUnit((datServicioTmp.getValorUnit() != null) ? datServicioTmp.getValorUnit() : null);
				datServicioDTO2
						.setVariedId((datServicioTmp.getVariedId() != null) ? datServicioTmp.getVariedId() : null);

				if (datServicioTmp.getContratista() != null) {
					datServicioDTO2.setContratistaId_Contratista(datServicioTmp.getContratista().getPersEmprId());
				} else {
					datServicioDTO2.setContratistaId_Contratista(null);
				}

				if (datServicioTmp.getEquipo() != null) {
					datServicioDTO2.setEquipoId_Equipo(datServicioTmp.getEquipo());
				} else {
					datServicioDTO2.setEquipoId_Equipo(null);
				}
				if (datServicioTmp.getOrdenTrabajo() != null) {
					datServicioDTO2.setOrdenTrabajo(datServicioTmp.getOrdenTrabajo().getPlanLaborDetId());
				} else {
					datServicioDTO2.setOrdenTrabajo(null);
				}

				if (datServicioTmp.getLabor() != null) {
					datServicioDTO2.setLaborId_Labor(datServicioTmp.getLabor().getLaborId());
				} else {
					datServicioDTO2.setLaborId_Labor(null);
				}

				if (datServicioTmp.getNivel4() != null) {
					datServicioDTO2.setNivel4Id_Nivel4(datServicioTmp.getNivel4().getNivel4Id());
				} else {
					datServicioDTO2.setNivel4Id_Nivel4(null);
				}

				if (datServicioTmp.getServicio() != null) {
					datServicioDTO2.setServicioId_Servicio(datServicioTmp.getServicio().getServicioId());
				} else {
					datServicioDTO2.setServicioId_Servicio(null);
				}

				if (datServicioTmp.getTrabajador() != null) {
					datServicioDTO2.setTrabId_Trabajador(datServicioTmp.getTrabajador());
				} else {
					datServicioDTO2.setTrabId_Trabajador(null);
				}

				datServicioDTO2.setUdadMedId_UdadMed(
						(datServicioTmp.getUdadMed() != null) ? datServicioTmp.getUdadMed() : null);

				String nombreLabor = datServicioTmp.getLabor().getNombre();
				datServicioDTO2.setLaborNombre(nombreLabor);
				String nombreNivel2 = datServicioTmp.getNivel2Id().getNombre();
				datServicioDTO2.setNivel2Nombre(nombreNivel2);
				String nombreNivel4 = datServicioTmp.getNivel4().getNombre();
				datServicioDTO2.setNivel4Nombre(nombreNivel4);
				String nombreServicio = datServicioTmp.getServicio().getNombre();

				datServicioDTO2.setServicioNombre(nombreServicio);
				String nombreContratista = datServicioTmp.getContratista().getNombre();

				datServicioDTO2.setContratistaNombre(nombreContratista);
				String codigoContratista = datServicioTmp.getContratista().getCodigo();
				datServicioDTO2.setContratistaCodigo(codigoContratista);

				String estadoEstrue = "false";
				if (datServicioTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datServicioDTO2.setEstadoTrue(estadoEstrue);
				}
				datServicioDTO2.setEstadoTrue(estadoEstrue);

				datServicioDTO.add(datServicioDTO2);
			}

			return datServicioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberServicio(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("laborNombre")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(labor.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("ordenTrabajo")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ")
							+ "upper(ordenTrabajo.ordenTrabajo)" + " LIKE '%" + e.getValue().toString().toUpperCase()
							+ "%' ";

				} else if (e.getKey().equals("nivel2Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2Id.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel4Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel4.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("contratistaNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(contratista.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("udadMedNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(udadMed.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("servicioNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(servicio.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}
			entity = datServicioDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatServicio Count");
		} finally {
		}
		return entity;
	}

}

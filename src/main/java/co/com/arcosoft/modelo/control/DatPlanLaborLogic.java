package co.com.arcosoft.modelo.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

import co.com.arcosoft.dataaccess.dao.IDatPlanLaborDAO;
import co.com.arcosoft.dataaccess.dao.IDatPlanLaborDetDAO;
import co.com.arcosoft.dataaccess.dao.IPlanAsignarRecursoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanLabor;
import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.PlanAsignarRecurso;
import co.com.arcosoft.modelo.dto.DatPlanLaborDTO;
import co.com.arcosoft.modelo.dto.DatPlanLaborDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatPlanLaborLogic")
public class DatPlanLaborLogic implements IDatPlanLaborLogic {
	private static final Logger log = LoggerFactory.getLogger(DatPlanLaborLogic.class);

	/**
	 * DAO injected by Spring that manages DatPlanLabor entities
	 *
	 */
	@Autowired
	private IDatPlanLaborDAO datPlanLaborDAO;

	@Autowired
	private IDatPlanLaborDetDAO datPlanLaborDetDAO;

	/**
	 * DAO injected by Spring that manages PlanAsignarRecurso entities
	 *
	 */
	@Autowired
	private IPlanAsignarRecursoDAO planAsignarRecursoDAO;

	/**
	 * Logic injected by Spring that manages Contratista entities
	 *
	 */

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
	 * Logic injected by Spring that manages Servicio entities
	 *
	 */
	@Autowired
	IServicioLogic logicServicio4;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador5;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed6;

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanLabor> getDatPlanLabor() throws Exception {
		log.debug("finding all DatPlanLabor instances");

		List<DatPlanLabor> list = new ArrayList<DatPlanLabor>();

		try {
			list = datPlanLaborDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatPlanLabor failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatPlanLabor");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatPlanLabor(DatPlanLabor entity, List<DatPlanLaborDetDTO> dataPlanLaborDet) throws Exception {
		log.debug("saving DatPlanLabor instance");

		try {
			/*
			 * if (entity.getContratista() == null) { throw new
			 * ZMessManager().new ForeignException("contratista"); }
			 */
			if (entity.getLabor() == null) {
				throw new ZMessManager().new ForeignException("labor");
			}

			/*
			 * if (entity.getServicio() == null) { throw new ZMessManager().new
			 * ForeignException("servicio"); }
			 * 
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

			if ((entity.getCierreOt() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCierreOt(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("cierreOt");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}
			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
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

			if ((entity.getOrdenTrabajo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getOrdenTrabajo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ordenTrabajo");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}
			/*
			 * if (entity.getContratista() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "contratistaId_Contratista"); }
			 */
			if ((entity.getContratista() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getContratista(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("contratistaId_Contratista");
			}

			if (entity.getLabor().getLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("laborId_Labor");
			}

			if ((entity.getLabor().getLaborId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getLabor().getLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("laborId_Labor");
			}

			/*
			 * if (entity.getServicio() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "servicioId_Servicio"); }
			 */

			if ((entity.getTrabajador() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			if (dataPlanLaborDet != null) {

				for (DatPlanLaborDetDTO valorDto : dataPlanLaborDet) {

					if (valorDto.getPlanLaborDetId() == null) {

						DatPlanLaborDet valor = new DatPlanLaborDet();

						valor.setEdadPlanificacion(valorDto.getEdadPlanificacion());
						valor.setCantidadPlan(valorDto.getCantidadPlan());

						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setDatPlanLabor(entity);

						datPlanLaborDetDAO.save(valor);
					}

				}
			}

			datPlanLaborDAO.save(entity);

			log.debug("save DatPlanLabor successful");
		} catch (Exception e) {
			log.error("save DatPlanLabor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatPlanLabor(DatPlanLabor entity) throws Exception {
		log.debug("deleting DatPlanLabor instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatPlanLabor");
		}

		if (entity.getPlanLaborId() == null) {
			throw new ZMessManager().new EmptyFieldException("planLaborId");
		}

		List<PlanAsignarRecurso> planAsignarRecursos = null;
		List<DatPlanLaborDet> datPlanLaborDet = null;
		try {
			planAsignarRecursos = planAsignarRecursoDAO.findByProperty("datPlanLabor.planLaborId",
					entity.getPlanLaborId());

			if (Utilities.validationsList(planAsignarRecursos) == true) {
				throw new ZMessManager().new DeletingException("planAsignarRecursos");
			}
			datPlanLaborDet = datPlanLaborDetDAO.findByProperty("datPlanLabor.planLaborId", entity.getPlanLaborId());

			if (Utilities.validationsList(datPlanLaborDet) == true) {
				throw new ZMessManager().new DeletingException("datPlanLaborDet");

			}

			datPlanLaborDAO.delete(entity);

			log.debug("delete DatPlanLabor successful");
		} catch (Exception e) {
			log.error("delete DatPlanLabor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatPlanLabor(DatPlanLabor entity, List<DatPlanLaborDetDTO> dataPlanLaborDet) throws Exception {
		log.debug("updating DatPlanLabor instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatPlanLabor");
			}

			/*
			 * if (entity.getContratista() == null) { throw new
			 * ZMessManager().new ForeignException("contratista"); }
			 */

			if (entity.getLabor() == null) {
				throw new ZMessManager().new ForeignException("labor");
			}
			if ((entity.getNPases() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNPases(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("NPases");
			}

			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getCierreOt() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCierreOt(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("cierreOt");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
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

			if ((entity.getOrdenTrabajo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getOrdenTrabajo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ordenTrabajo");
			}

			if (entity.getPlanLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("planLaborId");
			}

			if ((entity.getPlanLaborId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPlanLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("planLaborId");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}
			/*
			 * if (entity.getContratista() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "contratistaId_Contratista"); }
			 */
			if ((entity.getContratista() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getContratista(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("contratistaId_Contratista");
			}

			if (entity.getLabor().getLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("laborId_Labor");
			}

			if ((entity.getLabor().getLaborId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getLabor().getLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("laborId_Labor");
			}

			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 */

			if ((entity.getTrabajador() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			datPlanLaborDAO.update(entity);
			for (DatPlanLaborDetDTO valorDto : dataPlanLaborDet) {

				if (valorDto.getPlanLaborDetId() == null) { // crear el valor
															// nuevo

					DatPlanLaborDet valor = new DatPlanLaborDet();

					valor.setEdadPlanificacion(valorDto.getEdadPlanificacion());
					valor.setCantidadPlan(valorDto.getCantidadPlan());

					valor.setNivel2(valorDto.getNivel2Id_Nivel2());
					valor.setNivel4(valorDto.getNivel4Id_Nivel4());
					valor.setDatPlanLabor(entity);

					datPlanLaborDetDAO.save(valor);

				} else {
					DatPlanLaborDet valor = datPlanLaborDetDAO.findById(valorDto.getPlanLaborDetId());

					valor.setEdadPlanificacion(valorDto.getEdadPlanificacion());
					valor.setCantidadPlan(valorDto.getCantidadPlan());

					valor.setNivel2(valorDto.getNivel2Id_Nivel2());
					valor.setNivel4(valorDto.getNivel4Id_Nivel4());
					valor.setDatPlanLabor(entity);

					datPlanLaborDetDAO.update(valor);
				}

			}

			log.debug("update DatPlanLabor successful");
		} catch (Exception e) {
			log.error("update DatPlanLabor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanLaborDTO> getDataDatPlanLabor() throws Exception {
		try {

			List<DatPlanLabor> datPlanLabor = datPlanLaborDAO.findAll();

			List<DatPlanLaborDTO> datPlanLaborDTO = new ArrayList<DatPlanLaborDTO>();

			for (DatPlanLabor datPlanLaborTmp : datPlanLabor) {
				DatPlanLaborDTO datPlanLaborDTO2 = new DatPlanLaborDTO();

				datPlanLaborDTO2.setPlanLaborId(datPlanLaborTmp.getPlanLaborId());
				datPlanLaborDTO2.setNPases((datPlanLaborTmp.getNPases() != null) ? datPlanLaborTmp.getNPases() : null);
				datPlanLaborDTO2.setAnio((datPlanLaborTmp.getAnio() != null) ? datPlanLaborTmp.getAnio() : null);
				datPlanLaborDTO2.setCantidadPlan(
						(datPlanLaborTmp.getCantidadPlan() != null) ? datPlanLaborTmp.getCantidadPlan() : null);
				datPlanLaborDTO2
						.setCierreOt((datPlanLaborTmp.getCierreOt() != null) ? datPlanLaborTmp.getCierreOt() : null);
				datPlanLaborDTO2
						.setCompania((datPlanLaborTmp.getCompania() != null) ? datPlanLaborTmp.getCompania() : null);
				datPlanLaborDTO2.setCostoTotalEstimado((datPlanLaborTmp.getCostoTotalEstimado() != null)
						? datPlanLaborTmp.getCostoTotalEstimado() : null);
				datPlanLaborDTO2.setEdadPlanificacion((datPlanLaborTmp.getEdadPlanificacion() != null)
						? datPlanLaborTmp.getEdadPlanificacion() : null);
				datPlanLaborDTO2.setEstado((datPlanLaborTmp.getEstado() != null) ? datPlanLaborTmp.getEstado() : null);
				datPlanLaborDTO2.setFechaCreacion(datPlanLaborTmp.getFechaCreacion());
				datPlanLaborDTO2.setFechaModificacion(datPlanLaborTmp.getFechaModificacion());
				datPlanLaborDTO2
						.setIdMobile((datPlanLaborTmp.getIdMobile() != null) ? datPlanLaborTmp.getIdMobile() : null);
				datPlanLaborDTO2.setInfoAdicional(
						(datPlanLaborTmp.getInfoAdicional() != null) ? datPlanLaborTmp.getInfoAdicional() : null);
				datPlanLaborDTO2.setInfoAdicional2(
						(datPlanLaborTmp.getInfoAdicional2() != null) ? datPlanLaborTmp.getInfoAdicional2() : null);
				datPlanLaborDTO2
						.setLatitud((datPlanLaborTmp.getLatitud() != null) ? datPlanLaborTmp.getLatitud() : null);
				datPlanLaborDTO2
						.setLongitud((datPlanLaborTmp.getLongitud() != null) ? datPlanLaborTmp.getLongitud() : null);
				datPlanLaborDTO2
						.setNivel1Id((datPlanLaborTmp.getNivel1Id() != null) ? datPlanLaborTmp.getNivel1Id() : null);
				if (datPlanLaborTmp.getNivel2Id() != null) {
					datPlanLaborDTO2.setNivel2Id(datPlanLaborTmp.getNivel2Id().getNivel2Id());
				} else {
					datPlanLaborDTO2.setNivel2Id(null);
				}
				datPlanLaborDTO2
						.setNivel3Id((datPlanLaborTmp.getNivel3Id() != null) ? datPlanLaborTmp.getNivel3Id() : null);
				datPlanLaborDTO2.setObservacion(
						(datPlanLaborTmp.getObservacion() != null) ? datPlanLaborTmp.getObservacion() : null);
				datPlanLaborDTO2.setObservacionAnularReg((datPlanLaborTmp.getObservacionAnularReg() != null)
						? datPlanLaborTmp.getObservacionAnularReg() : null);
				datPlanLaborDTO2.setOrdenTrabajo(
						(datPlanLaborTmp.getOrdenTrabajo() != null) ? datPlanLaborTmp.getOrdenTrabajo() : null);
				datPlanLaborDTO2.setPeriodoFinal(datPlanLaborTmp.getPeriodoFinal());
				datPlanLaborDTO2.setPeriodoInicial(datPlanLaborTmp.getPeriodoInicial());
				datPlanLaborDTO2
						.setPrecision((datPlanLaborTmp.getPrecision() != null) ? datPlanLaborTmp.getPrecision() : null);
				datPlanLaborDTO2.setUsuarioDigitacion((datPlanLaborTmp.getUsuarioDigitacion() != null)
						? datPlanLaborTmp.getUsuarioDigitacion() : null);

				if (datPlanLaborTmp.getContratista() != null) {
					datPlanLaborDTO2.setContratistaId_Contratista(datPlanLaborTmp.getContratista());
				} else {
					datPlanLaborDTO2.setContratistaId_Contratista(null);
				}

				if (datPlanLaborTmp.getLabor() != null) {
					datPlanLaborDTO2.setLaborId_Labor(datPlanLaborTmp.getLabor().getLaborId());
				} else {
					datPlanLaborDTO2.setLaborId_Labor(null);
				}

				if (datPlanLaborTmp.getNivel4() != null) {
					datPlanLaborDTO2.setNivel4Id_Nivel4(datPlanLaborTmp.getNivel4().getNivel4Id());
				} else {
					datPlanLaborDTO2.setNivel4Id_Nivel4(null);
				}

				if (datPlanLaborTmp.getServicio() != null) {
					datPlanLaborDTO2.setServicioId_Servicio(datPlanLaborTmp.getServicio());
				} else {
					datPlanLaborDTO2.setServicioId_Servicio(null);
				}

				if (datPlanLaborTmp.getTrabajador() != null) {
					datPlanLaborDTO2.setTrabId_Trabajador(datPlanLaborTmp.getTrabajador());
				} else {
					datPlanLaborDTO2.setTrabId_Trabajador(null);
				}

				datPlanLaborDTO2.setUdadMedId_UdadMed((datPlanLaborTmp.getUdadMed().getUdadMedId() != null)
						? datPlanLaborTmp.getUdadMed().getUdadMedId() : null);

				String nombreLabor = datPlanLaborTmp.getLabor().getNombre();
				datPlanLaborDTO2.setLaborNombre(nombreLabor);
				/*String nombreNivel2 = datPlanLaborTmp.getNivel2Id().getNombre();
				datPlanLaborDTO2.setNivel2Nombre(nombreNivel2);
				String nombreNivel4 = datPlanLaborTmp.getNivel4().getNombre();
				datPlanLaborDTO2.setNivel4Nombre(nombreNivel4);*/
				
				//String nombreUdadMed = datPlanLaborTmp.getUdadMed().getNombre();
				String nombreUdadMed = logicUdadMed6.getUdadMed(datPlanLaborTmp.getUdadMed().getUdadMedId()).getNombre();
				datPlanLaborDTO2.setUdadMedNombre(nombreUdadMed);
				datPlanLaborDTO.add(datPlanLaborDTO2);
			}

			return datPlanLaborDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatPlanLabor getDatPlanLabor(Long planLaborId) throws Exception {
		log.debug("getting DatPlanLabor instance");

		DatPlanLabor entity = null;

		try {
			entity = datPlanLaborDAO.findById(planLaborId);
		} catch (Exception e) {
			log.error("get DatPlanLabor failed", e);
			throw new ZMessManager().new FindingException("DatPlanLabor");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanLabor> findPageDatPlanLabor(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatPlanLabor> entity = null;

		try {
			entity = datPlanLaborDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatPlanLabor Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatPlanLabor() throws Exception {
		Long entity = null;

		try {
			entity = datPlanLaborDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatPlanLabor Count");
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
	public List<DatPlanLabor> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatPlanLabor> list = new ArrayList<DatPlanLabor>();
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
			list = datPlanLaborDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanLaborDTO> findByCriteriaPagePlanLabor(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		try {
			List<DatPlanLabor> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("laborNombre")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(labor.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel2Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel4Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel4.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("udadMedNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(udadmed.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}
			}

			entity = datPlanLaborDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<DatPlanLaborDTO> datPlanLaborDTO = new ArrayList<DatPlanLaborDTO>();

			for (DatPlanLabor datPlanLaborTmp : entity) {
				DatPlanLaborDTO datPlanLaborDTO2 = new DatPlanLaborDTO();

				datPlanLaborDTO2.setPlanLaborId(datPlanLaborTmp.getPlanLaborId());
				datPlanLaborDTO2.setNPases((datPlanLaborTmp.getNPases() != null) ? datPlanLaborTmp.getNPases() : null);
				datPlanLaborDTO2.setAnio((datPlanLaborTmp.getAnio() != null) ? datPlanLaborTmp.getAnio() : null);
				datPlanLaborDTO2.setCantidadPlan(
						(datPlanLaborTmp.getCantidadPlan() != null) ? datPlanLaborTmp.getCantidadPlan() : null);
				datPlanLaborDTO2
						.setCierreOt((datPlanLaborTmp.getCierreOt() != null) ? datPlanLaborTmp.getCierreOt() : null);
				datPlanLaborDTO2
						.setCompania((datPlanLaborTmp.getCompania() != null) ? datPlanLaborTmp.getCompania() : null);
				datPlanLaborDTO2.setCostoTotalEstimado((datPlanLaborTmp.getCostoTotalEstimado() != null)
						? datPlanLaborTmp.getCostoTotalEstimado() : null);
				datPlanLaborDTO2.setEdadPlanificacion((datPlanLaborTmp.getEdadPlanificacion() != null)
						? datPlanLaborTmp.getEdadPlanificacion() : null);
				datPlanLaborDTO2.setEstado((datPlanLaborTmp.getEstado() != null) ? datPlanLaborTmp.getEstado() : null);
				datPlanLaborDTO2.setFechaCreacion(datPlanLaborTmp.getFechaCreacion());
				datPlanLaborDTO2.setFechaModificacion(datPlanLaborTmp.getFechaModificacion());
				datPlanLaborDTO2
						.setIdMobile((datPlanLaborTmp.getIdMobile() != null) ? datPlanLaborTmp.getIdMobile() : null);
				datPlanLaborDTO2.setInfoAdicional(
						(datPlanLaborTmp.getInfoAdicional() != null) ? datPlanLaborTmp.getInfoAdicional() : null);
				datPlanLaborDTO2.setInfoAdicional2(
						(datPlanLaborTmp.getInfoAdicional2() != null) ? datPlanLaborTmp.getInfoAdicional2() : null);
				datPlanLaborDTO2
						.setLatitud((datPlanLaborTmp.getLatitud() != null) ? datPlanLaborTmp.getLatitud() : null);
				datPlanLaborDTO2
						.setLongitud((datPlanLaborTmp.getLongitud() != null) ? datPlanLaborTmp.getLongitud() : null);
				datPlanLaborDTO2
						.setNivel1Id((datPlanLaborTmp.getNivel1Id() != null) ? datPlanLaborTmp.getNivel1Id() : null);
				if (datPlanLaborTmp.getNivel2Id() != null) {
					datPlanLaborDTO2.setNivel2Id(datPlanLaborTmp.getNivel2Id().getNivel2Id());
				} else {
					datPlanLaborDTO2.setNivel2Id(null);
				}
				datPlanLaborDTO2
						.setNivel3Id((datPlanLaborTmp.getNivel3Id() != null) ? datPlanLaborTmp.getNivel3Id() : null);
				datPlanLaborDTO2.setObservacion(
						(datPlanLaborTmp.getObservacion() != null) ? datPlanLaborTmp.getObservacion() : null);
				datPlanLaborDTO2.setObservacionAnularReg((datPlanLaborTmp.getObservacionAnularReg() != null)
						? datPlanLaborTmp.getObservacionAnularReg() : null);
				datPlanLaborDTO2.setOrdenTrabajo(
						(datPlanLaborTmp.getOrdenTrabajo() != null) ? datPlanLaborTmp.getOrdenTrabajo() : null);
				datPlanLaborDTO2.setPeriodoFinal(datPlanLaborTmp.getPeriodoFinal());
				// Imagen O.T
				datPlanLaborDTO2.setEstadoOrdenTrabajoVencida(estadoOrdenTrabajo(datPlanLaborTmp.getPeriodoFinal(),
						datPlanLaborTmp.getCierreOt(), datPlanLaborTmp.getEstado()));

				// Calcular los dias de atraso
				datPlanLaborDTO2.setDiasAtarsoOt(diasDeAtraso(datPlanLaborTmp.getPeriodoFinal(),
						datPlanLaborTmp.getCierreOt(), datPlanLaborTmp.getEstado()));

				datPlanLaborDTO2.setPeriodoInicial(datPlanLaborTmp.getPeriodoInicial());
				datPlanLaborDTO2
						.setPrecision((datPlanLaborTmp.getPrecision() != null) ? datPlanLaborTmp.getPrecision() : null);
				datPlanLaborDTO2.setUsuarioDigitacion((datPlanLaborTmp.getUsuarioDigitacion() != null)
						? datPlanLaborTmp.getUsuarioDigitacion() : null);

				if (datPlanLaborTmp.getContratista() != null) {
					datPlanLaborDTO2.setContratistaId_Contratista(datPlanLaborTmp.getContratista());
				} else {
					datPlanLaborDTO2.setContratistaId_Contratista(null);
				}

				if (datPlanLaborTmp.getLabor() != null) {
					datPlanLaborDTO2.setLaborId_Labor(datPlanLaborTmp.getLabor().getLaborId());
				} else {
					datPlanLaborDTO2.setLaborId_Labor(null);
				}

				if (datPlanLaborTmp.getNivel4() != null) {
					datPlanLaborDTO2.setNivel4Id_Nivel4(datPlanLaborTmp.getNivel4().getNivel4Id());
				} else {
					datPlanLaborDTO2.setNivel4Id_Nivel4(null);
				}

				if (datPlanLaborTmp.getServicio() != null) {
					datPlanLaborDTO2.setServicioId_Servicio(datPlanLaborTmp.getServicio());
				} else {
					datPlanLaborDTO2.setServicioId_Servicio(null);
				}

				if (datPlanLaborTmp.getTrabajador() != null) {
					datPlanLaborDTO2.setTrabId_Trabajador(datPlanLaborTmp.getTrabajador());
				} else {
					datPlanLaborDTO2.setTrabId_Trabajador(null);
				}

				datPlanLaborDTO2.setUdadMedId_UdadMed((datPlanLaborTmp.getUdadMed().getUdadMedId() != null)
						? datPlanLaborTmp.getUdadMed().getUdadMedId() : null);

				String estadoEstrue = "false";
				if (datPlanLaborTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datPlanLaborDTO2.setEstadoTrue(estadoEstrue);
					datPlanLaborDTO2.setEstadoTrue2(estadoEstrue);
				}
				datPlanLaborDTO2.setEstadoTrue(estadoEstrue);

				String tituloCierreOt = "Esta seguro que desea cerrar la O.T ?";
				String icon = "ui-icon-unlocked";

				if (datPlanLaborTmp.getCierreOt().equals("C")) {
					tituloCierreOt = "Esta seguro que desea reabrir la O.T ?";
					icon = "ui-icon-locked";
					estadoEstrue = "true";
					datPlanLaborDTO2.setEstadoTrue2(estadoEstrue);
					datPlanLaborDTO2.setTituloCierreOt(tituloCierreOt);
					datPlanLaborDTO2.setIconCierreOt(icon);
				}
				datPlanLaborDTO2.setTituloCierreOt(tituloCierreOt);
				datPlanLaborDTO2.setIconCierreOt(icon);
				datPlanLaborDTO2.setEstadoTrue2(estadoEstrue);

				String nombreLabor = datPlanLaborTmp.getLabor().getNombre();
				datPlanLaborDTO2.setLaborNombre(nombreLabor);
				// String nombreNivel2 =
				// datPlanLaborTmp.getNivel2Id().getNombre();
				// datPlanLaborDTO2.setNivel2Nombre(nombreNivel2);
				// String nombreNivel4 =
				// datPlanLaborTmp.getNivel4().getNombre();
				// datPlanLaborDTO2.setNivel4Nombre(nombreNivel4);
				String nombreUdadMed = datPlanLaborTmp.getUdadMed().getNombre();
				datPlanLaborDTO2.setUdadMedNombre(nombreUdadMed);
				datPlanLaborDTO.add(datPlanLaborDTO2);
			}

			return datPlanLaborDTO;
		} catch (Exception e) {
			throw e;
		}
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
	@Transactional(readOnly = true)
	public Long findTotalNumberPlanLabor(Map<String, Object> filters) throws Exception {
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

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel4Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel4.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("udadMedNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(udadmed.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}
			}
			entity = datPlanLaborDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PlanLabor Count");
		} finally {
		}
		return entity;
	}

}

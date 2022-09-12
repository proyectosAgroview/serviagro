package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IDatSolicitudesMttoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatSolicitudesMtto;
import co.com.arcosoft.modelo.dto.DatSolicitudesMttoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatSolicitudesMttoLogic")
public class DatSolicitudesMttoLogic implements IDatSolicitudesMttoLogic {
	private static final Logger log = LoggerFactory.getLogger(DatSolicitudesMttoLogic.class);

	/**
	 * DAO injected by Spring that manages DatSolicitudesMtto entities
	 *
	 */
	@Autowired
	private IDatSolicitudesMttoDAO datSolicitudesMttoDAO;

	/**
	 * Logic injected by Spring that manages AreaTrabajo entities
	 *
	 */
	@Autowired
	IAreaTrabajoLogic logicAreaTrabajo1;

	/**
	 * Logic injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	IEquipoLogic logicEquipo2;

	/**
	 * Logic injected by Spring that manages NivelPrioridad entities
	 *
	 */
	@Autowired
	INivelPrioridadLogic logicNivelPrioridad3;

	/**
	 * Logic injected by Spring that manages Tag entities
	 *
	 */
	@Autowired
	ITagLogic logicTag4;

	/**
	 * Logic injected by Spring that manages TipoMantenimiento entities
	 *
	 */
	@Autowired
	ITipoMantenimientoLogic logicTipoMantenimiento5;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador6;

	/**
	 * Logic injected by Spring that manages ZonasFabrica entities
	 *
	 */
	@Autowired
	IZonasFabricaLogic logicZonasFabrica7;

	@Transactional(readOnly = true)
	public List<DatSolicitudesMtto> getDatSolicitudesMtto() throws Exception {
		log.debug("finding all DatSolicitudesMtto instances");

		List<DatSolicitudesMtto> list = new ArrayList<DatSolicitudesMtto>();

		try {
			list = datSolicitudesMttoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatSolicitudesMtto failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatSolicitudesMtto");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatSolicitudesMtto(DatSolicitudesMtto entity) throws Exception {
		log.debug("saving DatSolicitudesMtto instance");

		try {
			/*if (entity.getAreaTrabajo() == null) {
				throw new ZMessManager().new ForeignException("areaTrabajo");
			}

			if (entity.getEquipo() == null) {
				throw new ZMessManager().new ForeignException("equipo");
			}

			if (entity.getNivelPrioridad() == null) {
				throw new ZMessManager().new ForeignException("nivelPrioridad");
			}

			if (entity.getTag() == null) {
				throw new ZMessManager().new ForeignException("tag");
			}

			if (entity.getTipoMantenimiento() == null) {
				throw new ZMessManager().new ForeignException("tipoMantenimiento");
			}

			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if (entity.getZonasFabrica() == null) {
				throw new ZMessManager().new ForeignException("zonasFabrica");
			}

			if ((entity.getDescripcionSolicitud() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDescripcionSolicitud(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("descripcionSolicitud");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getObservaciones() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservaciones(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("observaciones");
			}

			if ((entity.getRequiereParadaFabrica() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getRequiereParadaFabrica(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("requiereParadaFabrica");
			}

			if (entity.getAreaTrabajo().getAreaTrabajoId() == null) {
				throw new ZMessManager().new EmptyFieldException("areaTrabajoId_AreaTrabajo");
			}

			if (entity.getEquipo().getEquipoId() == null) {
				throw new ZMessManager().new EmptyFieldException("equipoId_Equipo");
			}

			if (entity.getNivelPrioridad().getNivelPrioridadId() == null) {
				throw new ZMessManager().new EmptyFieldException("nivelPrioridadId_NivelPrioridad");
			}

			if (entity.getTag().getTagId() == null) {
				throw new ZMessManager().new EmptyFieldException("tagId_Tag");
			}

			if (entity.getTipoMantenimiento().getTipoMantenimientoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipoMantenimientoId_TipoMantenimiento");
			}

			if (entity.getTrabajador().getTrabId() == null) {
				throw new ZMessManager().new EmptyFieldException("trabId_Trabajador");
			}

			if (entity.getZonasFabrica().getZonasFabricaId() == null) {
				throw new ZMessManager().new EmptyFieldException("zonasFabricaId_ZonasFabrica");
			}

			/*
			 * if (getDatSolicitudesMtto(entity.getDatSolicitudesMttoId()) != null) { throw
			 * new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			datSolicitudesMttoDAO.save(entity);

			log.debug("save DatSolicitudesMtto successful");
		} catch (Exception e) {
			log.error("save DatSolicitudesMtto failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatSolicitudesMtto(DatSolicitudesMtto entity) throws Exception {
		log.debug("deleting DatSolicitudesMtto instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatSolicitudesMtto");
		}

		if (entity.getDatSolicitudesMttoId() == null) {
			throw new ZMessManager().new EmptyFieldException("datSolicitudesMttoId");
		}

		try {
			datSolicitudesMttoDAO.delete(entity);

			log.debug("delete DatSolicitudesMtto successful");
		} catch (Exception e) {
			log.error("delete DatSolicitudesMtto failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatSolicitudesMtto(DatSolicitudesMtto entity) throws Exception {
		log.debug("updating DatSolicitudesMtto instance");

		try {
			/*if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatSolicitudesMtto");
			}

			if (entity.getAreaTrabajo() == null) {
				throw new ZMessManager().new ForeignException("areaTrabajo");
			}

			if (entity.getEquipo() == null) {
				throw new ZMessManager().new ForeignException("equipo");
			}

			if (entity.getNivelPrioridad() == null) {
				throw new ZMessManager().new ForeignException("nivelPrioridad");
			}

			if (entity.getTag() == null) {
				throw new ZMessManager().new ForeignException("tag");
			}

			if (entity.getTipoMantenimiento() == null) {
				throw new ZMessManager().new ForeignException("tipoMantenimiento");
			}

			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if (entity.getZonasFabrica() == null) {
				throw new ZMessManager().new ForeignException("zonasFabrica");
			}

			if ((entity.getDescripcionSolicitud() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDescripcionSolicitud(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("descripcionSolicitud");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getObservaciones() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservaciones(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("observaciones");
			}

			if ((entity.getRequiereParadaFabrica() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getRequiereParadaFabrica(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("requiereParadaFabrica");
			}

			if (entity.getAreaTrabajo().getAreaTrabajoId() == null) {
				throw new ZMessManager().new EmptyFieldException("areaTrabajoId_AreaTrabajo");
			}

			if (entity.getEquipo().getEquipoId() == null) {
				throw new ZMessManager().new EmptyFieldException("equipoId_Equipo");
			}

			if (entity.getNivelPrioridad().getNivelPrioridadId() == null) {
				throw new ZMessManager().new EmptyFieldException("nivelPrioridadId_NivelPrioridad");
			}

			if (entity.getTag().getTagId() == null) {
				throw new ZMessManager().new EmptyFieldException("tagId_Tag");
			}

			if (entity.getTipoMantenimiento().getTipoMantenimientoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipoMantenimientoId_TipoMantenimiento");
			}

			if (entity.getTrabajador().getTrabId() == null) {
				throw new ZMessManager().new EmptyFieldException("trabId_Trabajador");
			}

			if (entity.getZonasFabrica().getZonasFabricaId() == null) {
				throw new ZMessManager().new EmptyFieldException("zonasFabricaId_ZonasFabrica");
			}*/

			datSolicitudesMttoDAO.update(entity);

			log.debug("update DatSolicitudesMtto successful");
		} catch (Exception e) {
			log.error("update DatSolicitudesMtto failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DatSolicitudesMttoDTO> getDataDatSolicitudesMtto() throws Exception {
		try {
			List<DatSolicitudesMtto> datSolicitudesMtto = datSolicitudesMttoDAO.findAll();

			List<DatSolicitudesMttoDTO> datSolicitudesMttoDTO = new ArrayList<DatSolicitudesMttoDTO>();

			for (DatSolicitudesMtto datSolicitudesMttoTmp : datSolicitudesMtto) {
				DatSolicitudesMttoDTO datSolicitudesMttoDTO2 = new DatSolicitudesMttoDTO();

				datSolicitudesMttoDTO2.setDatSolicitudesMttoId(datSolicitudesMttoTmp.getDatSolicitudesMttoId());
				datSolicitudesMttoDTO2.setCompania(
						(datSolicitudesMttoTmp.getCompania() != null) ? datSolicitudesMttoTmp.getCompania() : null);
				datSolicitudesMttoDTO2.setConsecutivo(
						(datSolicitudesMttoTmp.getConsecutivo() != null) ? datSolicitudesMttoTmp.getConsecutivo()
								: null);
				datSolicitudesMttoDTO2.setDescripcionSolicitud((datSolicitudesMttoTmp.getDescripcionSolicitud() != null)
						? datSolicitudesMttoTmp.getDescripcionSolicitud()
						: null);
				datSolicitudesMttoDTO2.setEstado(
						(datSolicitudesMttoTmp.getEstado() != null) ? datSolicitudesMttoTmp.getEstado() : null);
				datSolicitudesMttoDTO2.setFechaAnulacion(datSolicitudesMttoTmp.getFechaAnulacion());
				datSolicitudesMttoDTO2.setFechaCreacion(datSolicitudesMttoTmp.getFechaCreacion());
				datSolicitudesMttoDTO2.setFechaModificacion(datSolicitudesMttoTmp.getFechaModificacion());
				datSolicitudesMttoDTO2.setFechaRegistro(datSolicitudesMttoTmp.getFechaRegistro());
				datSolicitudesMttoDTO2.setObservacionAnularReg((datSolicitudesMttoTmp.getObservacionAnularReg() != null)
						? datSolicitudesMttoTmp.getObservacionAnularReg()
						: null);
				datSolicitudesMttoDTO2.setObservaciones(
						(datSolicitudesMttoTmp.getObservaciones() != null) ? datSolicitudesMttoTmp.getObservaciones()
								: null);
				datSolicitudesMttoDTO2
						.setRequiereParadaFabrica((datSolicitudesMttoTmp.getRequiereParadaFabrica() != null)
								? datSolicitudesMttoTmp.getRequiereParadaFabrica()
								: null);
				datSolicitudesMttoDTO2.setAreaTrabajoId_AreaTrabajo(
						(datSolicitudesMttoTmp.getAreaTrabajo() != null)
								? datSolicitudesMttoTmp.getAreaTrabajo().getAreaTrabajoId()
								: null);

				if (datSolicitudesMttoTmp.getEquipo() != null) {
					datSolicitudesMttoDTO2.setEquipoId_Equipo(datSolicitudesMttoTmp.getEquipo().getEquipoId());
				} else {
					datSolicitudesMttoDTO2.setEquipoId_Equipo(null);
				}

				datSolicitudesMttoDTO2.setNivelPrioridadId_NivelPrioridad(
						(datSolicitudesMttoTmp.getNivelPrioridad() != null)
								? datSolicitudesMttoTmp.getNivelPrioridad().getNivelPrioridadId()
								: null);

				if (datSolicitudesMttoTmp.getTag() != null) {
					datSolicitudesMttoDTO2.setTagId_Tag(datSolicitudesMttoTmp.getTag().getTagId());
				} else {
					datSolicitudesMttoDTO2.setTagId_Tag(null);
				}

				datSolicitudesMttoDTO2.setTipoMantenimientoId_TipoMantenimiento(
						(datSolicitudesMttoTmp.getTipoMantenimiento() != null)
								? datSolicitudesMttoTmp.getTipoMantenimiento().getTipoMantenimientoId()
								: null);

				if (datSolicitudesMttoTmp.getTrabajador() != null) {
					datSolicitudesMttoDTO2.setTrabId_Trabajador(datSolicitudesMttoTmp.getTrabajador().getTrabId());
				} else {
					datSolicitudesMttoDTO2.setTrabId_Trabajador(null);
				}

				datSolicitudesMttoDTO2.setZonasFabricaId_ZonasFabrica(
						(datSolicitudesMttoTmp.getZonasFabrica()!= null)
								? datSolicitudesMttoTmp.getZonasFabrica().getZonasFabricaId()
								: null);

				String estadoEstrue = "false";
				if (datSolicitudesMttoTmp.getEstado() != null) {
					if (datSolicitudesMttoTmp.getEstado().equals("I")) {
						estadoEstrue = "true";
						datSolicitudesMttoDTO2.setEstadoTrue(estadoEstrue);
					}
					datSolicitudesMttoDTO2.setEstadoTrue(estadoEstrue);
				}
				datSolicitudesMttoDTO.add(datSolicitudesMttoDTO2);
			}

			return datSolicitudesMttoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DatSolicitudesMtto getDatSolicitudesMtto(Long datSolicitudesMttoId) throws Exception {
		log.debug("getting DatSolicitudesMtto instance");

		DatSolicitudesMtto entity = null;

		try {
			entity = datSolicitudesMttoDAO.findById(datSolicitudesMttoId);
		} catch (Exception e) {
			log.error("get DatSolicitudesMtto failed", e);
			throw new ZMessManager().new FindingException("DatSolicitudesMtto");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<DatSolicitudesMtto> findPageDatSolicitudesMtto(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<DatSolicitudesMtto> entity = null;

		try {
			entity = datSolicitudesMttoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatSolicitudesMtto Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDatSolicitudesMtto() throws Exception {
		Long entity = null;

		try {
			entity = datSolicitudesMttoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatSolicitudesMtto Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 *            [0] = String variable = (String) varibles[i]; representa como se
	 *            llama la variable en el pojo
	 *
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa
	 *            si el valor necesita o no ''(comillas simples)usado para campos de
	 *            tipo string
	 *
	 *            [2] = Object value = varibles[i + 2]; representa el valor que se
	 *            va a buscar en la BD
	 *
	 *            [3] = String comparator = (String) varibles[i + 3]; representa que
	 *            tipo de busqueda voy a hacer.., ejemplo: where nombre=william o
	 *            where nombre<>william, en este campo iria el tipo de comparador
	 *            que quiero si es = o <>
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
	 *            [0] = String variable = (String) varibles[j]; la variable ne la BD
	 *            que va a ser buscada en un rango
	 *
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en un
	 *            rango
	 *
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un
	 *            rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
	 *
	 *            [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
	 *            ejemplo: a comparator1 1 and a < 5
	 *
	 *            [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
	 *            ejemplo: a comparador1>1 and a comparador2<5 (el original: a > 1
	 *            and a < 5) *
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a una
	 *            fecha
	 *
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben
	 *            ser dates)
	 *
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben
	 *            ser dates)
	 *
	 *            esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<DatSolicitudesMtto> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatSolicitudesMtto> list = new ArrayList<DatSolicitudesMtto>();
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
			list = datSolicitudesMttoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}

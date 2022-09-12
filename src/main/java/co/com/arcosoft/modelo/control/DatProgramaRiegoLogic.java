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

import co.com.arcosoft.dataaccess.dao.IDatProgramaRiegoDAO;
import co.com.arcosoft.dataaccess.dao.IDatProgramaRiegoDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatProgramaRiego;
import co.com.arcosoft.modelo.DatProgramaRiegoDet;
import co.com.arcosoft.modelo.dto.DatProgramaRiegoDTO;
import co.com.arcosoft.modelo.dto.DatProgramaRiegoDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatProgramaRiegoLogic")
public class DatProgramaRiegoLogic implements IDatProgramaRiegoLogic {
	private static final Logger log = LoggerFactory.getLogger(DatProgramaRiegoLogic.class);

	/**
	 * DAO injected by Spring that manages DatProgramaRiego entities
	 *
	 */
	@Autowired
	private IDatProgramaRiegoDAO datProgramaRiegoDAO;

	/**
	 * DAO injected by Spring that manages DatProgramaRiegoDet entities
	 *
	 */
	@Autowired
	private IDatProgramaRiegoDetDAO datProgramaRiegoDetDAO;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador1;

	@Override
	@Transactional(readOnly = true)
	public List<DatProgramaRiego> getDatProgramaRiego() throws Exception {
		log.debug("finding all DatProgramaRiego instances");

		List<DatProgramaRiego> list = new ArrayList<DatProgramaRiego>();

		try {
			list = datProgramaRiegoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatProgramaRiego failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatProgramaRiego");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatProgramaRiego(DatProgramaRiego entity, List<DatProgramaRiegoDetDTO> dataProgramaRiegoDet)
			throws Exception {
		log.debug("saving DatProgramaRiego instance");

		try {
			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getMes() != null) && (Utilities.checkWordAndCheckWithlength(entity.getMes(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("mes");
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

			datProgramaRiegoDAO.save(entity);

			if (dataProgramaRiegoDet != null) {

				for (DatProgramaRiegoDetDTO valorDto : dataProgramaRiegoDet) {

					if (valorDto.getDatProgramaRiegoDetId() == null) {

						DatProgramaRiegoDet valor = new DatProgramaRiegoDet();

						valor.setAreaRegada(valorDto.getAreaRegada());
						valor.setCaudalNivel4(valorDto.getCaudalNivel4());
						valor.setEdadPrograma(valorDto.getEdadPrograma());
						valor.setFechaEstimadaRiego(valorDto.getFechaEstimadaRiego());
						valor.setHorasEstimadas(valorDto.getHorasEstimadas());
						valor.setInfraestructura(valorDto.getInfraId_Infraestructura());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());

						valor.setDatProgramaRiego(entity);

						datProgramaRiegoDetDAO.save(valor);
					}

				}
			}

			log.debug("save DatProgramaRiego successful");
		} catch (Exception e) {
			log.error("save DatProgramaRiego failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatProgramaRiego(DatProgramaRiego entity) throws Exception {
		log.debug("deleting DatProgramaRiego instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatProgramaRiego");
		}

		if (entity.getDatProgramaRiegoId() == null) {
			throw new ZMessManager().new EmptyFieldException("datProgramaRiegoId");
		}

		List<DatProgramaRiegoDet> datProgramaRiegoDets = null;

		try {
			datProgramaRiegoDets = datProgramaRiegoDetDAO.findByProperty("datProgramaRiego.datProgramaRiegoId",
					entity.getDatProgramaRiegoId());

			if (Utilities.validationsList(datProgramaRiegoDets) == true) {
				throw new ZMessManager().new DeletingException("datProgramaRiegoDets");
			}

			datProgramaRiegoDAO.delete(entity);

			log.debug("delete DatProgramaRiego successful");
		} catch (Exception e) {
			log.error("delete DatProgramaRiego failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatProgramaRiego(DatProgramaRiego entity, List<DatProgramaRiegoDetDTO> dataProgramaRiegoDet)
			throws Exception {
		log.debug("updating DatProgramaRiego instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatProgramaRiego");
			}

			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if (entity.getDatProgramaRiegoId() == null) {
				throw new ZMessManager().new EmptyFieldException("datProgramaRiegoId");
			}

			if ((entity.getDatProgramaRiegoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatProgramaRiegoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datProgramaRiegoId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getMes() != null) && (Utilities.checkWordAndCheckWithlength(entity.getMes(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("mes");
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

			datProgramaRiegoDAO.update(entity);
			if (dataProgramaRiegoDet != null) {
				for (DatProgramaRiegoDetDTO valorDto : dataProgramaRiegoDet) {

					if (valorDto.getDatProgramaRiegoDetId() == null) { // crear
																		// el
																		// valor
						// nuevo

						DatProgramaRiegoDet valor = new DatProgramaRiegoDet();
						valor.setAreaRegada(valorDto.getAreaRegada());
						valor.setCaudalNivel4(valorDto.getCaudalNivel4());
						valor.setEdadPrograma(valorDto.getEdadPrograma());
						valor.setFechaEstimadaRiego(valorDto.getFechaEstimadaRiego());
						valor.setHorasEstimadas(valorDto.getHorasEstimadas());
						valor.setInfraestructura(valorDto.getInfraId_Infraestructura());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setDatProgramaRiego(entity);
						datProgramaRiegoDetDAO.save(valor);

					} else {
						DatProgramaRiegoDet valor = datProgramaRiegoDetDAO
								.findById(valorDto.getDatProgramaRiegoDetId());
						valor.setAreaRegada(valorDto.getAreaRegada());
						valor.setCaudalNivel4(valorDto.getCaudalNivel4());
						valor.setEdadPrograma(valorDto.getEdadPrograma());
						valor.setFechaEstimadaRiego(valorDto.getFechaEstimadaRiego());
						valor.setHorasEstimadas(valorDto.getHorasEstimadas());
						valor.setInfraestructura(valorDto.getInfraId_Infraestructura());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setDatProgramaRiego(entity);
						datProgramaRiegoDetDAO.update(valor);
					}

				}

			}
			log.debug("update DatProgramaRiego successful");
		} catch (Exception e) {
			log.error("update DatProgramaRiego failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatProgramaRiegoDTO> getDataDatProgramaRiego() throws Exception {
		try {
			List<DatProgramaRiego> datProgramaRiego = datProgramaRiegoDAO.findAll();

			List<DatProgramaRiegoDTO> datProgramaRiegoDTO = new ArrayList<DatProgramaRiegoDTO>();

			for (DatProgramaRiego datProgramaRiegoTmp : datProgramaRiego) {
				DatProgramaRiegoDTO datProgramaRiegoDTO2 = new DatProgramaRiegoDTO();

				datProgramaRiegoDTO2.setDatProgramaRiegoId(datProgramaRiegoTmp.getDatProgramaRiegoId());
				datProgramaRiegoDTO2
						.setAnio((datProgramaRiegoTmp.getAnio() != null) ? datProgramaRiegoTmp.getAnio() : null);
				datProgramaRiegoDTO2.setCompania(
						(datProgramaRiegoTmp.getCompania() != null) ? datProgramaRiegoTmp.getCompania() : null);
				datProgramaRiegoDTO2.setConsecutivo(
						(datProgramaRiegoTmp.getConsecutivo() != null) ? datProgramaRiegoTmp.getConsecutivo() : null);
				datProgramaRiegoDTO2
						.setEstado((datProgramaRiegoTmp.getEstado() != null) ? datProgramaRiegoTmp.getEstado() : null);
				datProgramaRiegoDTO2.setFechaAnulacion(datProgramaRiegoTmp.getFechaAnulacion());
				datProgramaRiegoDTO2.setFechaCreacion(datProgramaRiegoTmp.getFechaCreacion());
				datProgramaRiegoDTO2.setFechaModificacion(datProgramaRiegoTmp.getFechaModificacion());
				datProgramaRiegoDTO2.setInfoAdicional((datProgramaRiegoTmp.getInfoAdicional() != null)
						? datProgramaRiegoTmp.getInfoAdicional() : null);
				datProgramaRiegoDTO2.setInfoAdicional2((datProgramaRiegoTmp.getInfoAdicional2() != null)
						? datProgramaRiegoTmp.getInfoAdicional2() : null);
				datProgramaRiegoDTO2
						.setMes((datProgramaRiegoTmp.getMes() != null) ? datProgramaRiegoTmp.getMes() : null);
				datProgramaRiegoDTO2.setObservacion(
						(datProgramaRiegoTmp.getObservacion() != null) ? datProgramaRiegoTmp.getObservacion() : null);
				datProgramaRiegoDTO2.setObservacionAnularReg((datProgramaRiegoTmp.getObservacionAnularReg() != null)
						? datProgramaRiegoTmp.getObservacionAnularReg() : null);
				datProgramaRiegoDTO2.setUsuarioDigitacion((datProgramaRiegoTmp.getUsuarioDigitacion() != null)
						? datProgramaRiegoTmp.getUsuarioDigitacion() : null);

				if (datProgramaRiegoTmp.getTrabajador() != null) {
					datProgramaRiegoDTO2.setTrabId_Trabajador(datProgramaRiegoTmp.getTrabajador().getTrabId());
				} else {
					datProgramaRiegoDTO2.setTrabId_Trabajador(null);
				}

				datProgramaRiegoDTO.add(datProgramaRiegoDTO2);
			}

			return datProgramaRiegoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatProgramaRiego getDatProgramaRiego(Long datProgramaRiegoId) throws Exception {
		log.debug("getting DatProgramaRiego instance");

		DatProgramaRiego entity = null;

		try {
			entity = datProgramaRiegoDAO.findById(datProgramaRiegoId);
		} catch (Exception e) {
			log.error("get DatProgramaRiego failed", e);
			throw new ZMessManager().new FindingException("DatProgramaRiego");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatProgramaRiego> findPageDatProgramaRiego(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatProgramaRiego> entity = null;

		try {
			entity = datProgramaRiegoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatProgramaRiego Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatProgramaRiego() throws Exception {
		Long entity = null;

		try {
			entity = datProgramaRiegoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatProgramaRiego Count");
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
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
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
	public List<DatProgramaRiego> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatProgramaRiego> list = new ArrayList<DatProgramaRiego>();
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
			list = datProgramaRiegoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}

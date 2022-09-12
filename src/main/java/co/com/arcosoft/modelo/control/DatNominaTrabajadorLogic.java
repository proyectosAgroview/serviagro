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

import co.com.arcosoft.dataaccess.dao.IDatNominaTrabajadorDAO;
import co.com.arcosoft.dataaccess.dao.IDatNominaTrabajadorDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatNominaTrabajador;
import co.com.arcosoft.modelo.DatNominaTrabajadorDet;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDTO;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatNominaTrabajadorLogic")
public class DatNominaTrabajadorLogic implements IDatNominaTrabajadorLogic {
	private static final Logger log = LoggerFactory.getLogger(DatNominaTrabajadorLogic.class);

	/**
	 * DAO injected by Spring that manages DatNominaTrabajador entities
	 *
	 */
	@Autowired
	private IDatNominaTrabajadorDAO datNominaTrabajadorDAO;

	/**
	 * DAO injected by Spring that manages DatNominaTrabajadorDet entities
	 *
	 */
	@Autowired
	private IDatNominaTrabajadorDetDAO datNominaTrabajadorDetDAO;

	@Override
	@Transactional(readOnly = true)
	public List<DatNominaTrabajador> getDatNominaTrabajador() throws Exception {
		log.debug("finding all DatNominaTrabajador instances");

		List<DatNominaTrabajador> list = new ArrayList<DatNominaTrabajador>();

		try {
			list = datNominaTrabajadorDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatNominaTrabajador failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatNominaTrabajador");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatNominaTrabajador(DatNominaTrabajador entity,
			List<DatNominaTrabajadorDetDTO> dataNominaTrabajador) throws Exception {
		log.debug("saving DatNominaTrabajador instance");

		try {
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

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3900) == false)) {
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

			datNominaTrabajadorDAO.save(entity);

			if (dataNominaTrabajador != null) {

				for (DatNominaTrabajadorDetDTO valorDto : dataNominaTrabajador) {

					if (valorDto.getDatNominaTrabajadorDetId() == null) {

						DatNominaTrabajadorDet valor = new DatNominaTrabajadorDet();

						valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setValorTotal(valorDto.getValorTotal());
						valor.setCantidad(valorDto.getCantidad());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setDatNominaTrabajador(entity);

						datNominaTrabajadorDetDAO.save(valor);
					}

				}
			}

			log.debug("save DatNominaTrabajador successful");
		} catch (Exception e) {
			log.error("save DatNominaTrabajador failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatNominaTrabajador(DatNominaTrabajador entity) throws Exception {
		log.debug("deleting DatNominaTrabajador instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatNominaTrabajador");
		}

		if (entity.getDatNominaTrabajadorId() == null) {
			throw new ZMessManager().new EmptyFieldException("datNominaTrabajadorId");
		}

		List<DatNominaTrabajadorDet> datNominaTrabajadorDets = null;

		try {
			datNominaTrabajadorDets = datNominaTrabajadorDetDAO
					.findByProperty("datNominaTrabajador.datNominaTrabajadorId", entity.getDatNominaTrabajadorId());

			if (Utilities.validationsList(datNominaTrabajadorDets) == true) {
				throw new ZMessManager().new DeletingException("datNominaTrabajadorDets");
			}

			datNominaTrabajadorDAO.delete(entity);

			log.debug("delete DatNominaTrabajador successful");
		} catch (Exception e) {
			log.error("delete DatNominaTrabajador failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatNominaTrabajador(DatNominaTrabajador entity,
			List<DatNominaTrabajadorDetDTO> dataNominaTrabajador) throws Exception {
		log.debug("updating DatNominaTrabajador instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatNominaTrabajador");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if (entity.getDatNominaTrabajadorId() == null) {
				throw new ZMessManager().new EmptyFieldException("datNominaTrabajadorId");
			}

			if ((entity.getDatNominaTrabajadorId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatNominaTrabajadorId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datNominaTrabajadorId");
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

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3900) == false)) {
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

			datNominaTrabajadorDAO.update(entity);

			if (dataNominaTrabajador != null) {
				for (DatNominaTrabajadorDetDTO valorDto : dataNominaTrabajador) {

					if (valorDto.getDatNominaTrabajadorDetId() == null) {

						DatNominaTrabajadorDet valor = new DatNominaTrabajadorDet();

						valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setValorTotal(valorDto.getValorTotal());
						valor.setDatNominaTrabajador(entity);
						valor.setCantidad(valorDto.getCantidad());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						datNominaTrabajadorDetDAO.save(valor);

					} else {
						DatNominaTrabajadorDet valor = datNominaTrabajadorDetDAO
								.findById(valorDto.getDatNominaTrabajadorDetId());

						valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setValorTotal(valorDto.getValorTotal());
						valor.setDatNominaTrabajador(entity);
						valor.setCantidad(valorDto.getCantidad());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						datNominaTrabajadorDetDAO.update(valor);
					}

				}
			}

			log.debug("update DatNominaTrabajador successful");
		} catch (Exception e) {
			log.error("update DatNominaTrabajador failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatNominaTrabajadorDTO> getDataDatNominaTrabajador() throws Exception {
		try {
			List<DatNominaTrabajador> datNominaTrabajador = datNominaTrabajadorDAO.findAll();

			List<DatNominaTrabajadorDTO> datNominaTrabajadorDTO = new ArrayList<DatNominaTrabajadorDTO>();

			for (DatNominaTrabajador datNominaTrabajadorTmp : datNominaTrabajador) {
				DatNominaTrabajadorDTO datNominaTrabajadorDTO2 = new DatNominaTrabajadorDTO();

				datNominaTrabajadorDTO2.setDatNominaTrabajadorId(datNominaTrabajadorTmp.getDatNominaTrabajadorId());
				datNominaTrabajadorDTO2.setCompania(
						(datNominaTrabajadorTmp.getCompania() != null) ? datNominaTrabajadorTmp.getCompania() : null);
				datNominaTrabajadorDTO2.setConsecutivo((datNominaTrabajadorTmp.getConsecutivo() != null)
						? datNominaTrabajadorTmp.getConsecutivo() : null);
				datNominaTrabajadorDTO2.setEstado(
						(datNominaTrabajadorTmp.getEstado() != null) ? datNominaTrabajadorTmp.getEstado() : null);
				datNominaTrabajadorDTO2.setFechaAnulacion(datNominaTrabajadorTmp.getFechaAnulacion());
				datNominaTrabajadorDTO2.setFechaCreacion(datNominaTrabajadorTmp.getFechaCreacion());
				datNominaTrabajadorDTO2.setFechaFinal(datNominaTrabajadorTmp.getFechaFinal());
				datNominaTrabajadorDTO2.setFechaInicial(datNominaTrabajadorTmp.getFechaInicial());
				datNominaTrabajadorDTO2.setFechaModificacion(datNominaTrabajadorTmp.getFechaModificacion());
				datNominaTrabajadorDTO2.setInfoAdicional((datNominaTrabajadorTmp.getInfoAdicional() != null)
						? datNominaTrabajadorTmp.getInfoAdicional() : null);
				datNominaTrabajadorDTO2.setInfoAdicional2((datNominaTrabajadorTmp.getInfoAdicional2() != null)
						? datNominaTrabajadorTmp.getInfoAdicional2() : null);
				datNominaTrabajadorDTO2.setObservacion((datNominaTrabajadorTmp.getObservacion() != null)
						? datNominaTrabajadorTmp.getObservacion() : null);
				datNominaTrabajadorDTO2
						.setObservacionAnularReg((datNominaTrabajadorTmp.getObservacionAnularReg() != null)
								? datNominaTrabajadorTmp.getObservacionAnularReg() : null);
				datNominaTrabajadorDTO2.setUsuarioDigitacion((datNominaTrabajadorTmp.getUsuarioDigitacion() != null)
						? datNominaTrabajadorTmp.getUsuarioDigitacion() : null);
				datNominaTrabajadorDTO.add(datNominaTrabajadorDTO2);
			}

			return datNominaTrabajadorDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatNominaTrabajador getDatNominaTrabajador(Long datNominaTrabajadorId) throws Exception {
		log.debug("getting DatNominaTrabajador instance");

		DatNominaTrabajador entity = null;

		try {
			entity = datNominaTrabajadorDAO.findById(datNominaTrabajadorId);
		} catch (Exception e) {
			log.error("get DatNominaTrabajador failed", e);
			throw new ZMessManager().new FindingException("DatNominaTrabajador");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatNominaTrabajador> findPageDatNominaTrabajador(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<DatNominaTrabajador> entity = null;

		try {
			entity = datNominaTrabajadorDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatNominaTrabajador Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatNominaTrabajador() throws Exception {
		Long entity = null;

		try {
			entity = datNominaTrabajadorDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatNominaTrabajador Count");
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
	public List<DatNominaTrabajador> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatNominaTrabajador> list = new ArrayList<DatNominaTrabajador>();
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
			list = datNominaTrabajadorDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}

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

import co.com.arcosoft.dataaccess.dao.IDatAnaTransProdDAO;
import co.com.arcosoft.dataaccess.dao.IValorVarAnaTransDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatAnaTransProd;
import co.com.arcosoft.modelo.ValorVarAnaTrans;
import co.com.arcosoft.modelo.dto.DatAnaTransProdDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatAnaTransProdLogic")
public class DatAnaTransProdLogic implements IDatAnaTransProdLogic {
	private static final Logger log = LoggerFactory.getLogger(DatAnaTransProdLogic.class);

	/**
	 * DAO injected by Spring that manages DatAnaTransProd entities
	 *
	 */
	@Autowired
	private IDatAnaTransProdDAO datAnaTransProdDAO;

	/**
	 * DAO injected by Spring that manages ValorVarAnaTrans entities
	 *
	 */
	@Autowired
	private IValorVarAnaTransDAO valorVarAnaTransDAO;

	/**
	 * Logic injected by Spring that manages AnaLaboratorio entities
	 *
	 */
	@Autowired
	IAnaLaboratorioLogic logicAnaLaboratorio1;

	/**
	 * Logic injected by Spring that manages DatTransProd entities
	 *
	 */
	@Autowired
	IDatTransProdLogic logicDatTransProd2;

	@Override
	@Transactional(readOnly = true)
	public List<DatAnaTransProd> getDatAnaTransProd() throws Exception {
		log.debug("finding all DatAnaTransProd instances");

		List<DatAnaTransProd> list = new ArrayList<DatAnaTransProd>();

		try {
			list = datAnaTransProdDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatAnaTransProd failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatAnaTransProd");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatAnaTransProd(DatAnaTransProd entity) throws Exception {
		log.debug("saving DatAnaTransProd instance");

		try {
			if (entity.getAnaLaboratorio() == null) {
				throw new ZMessManager().new ForeignException("anaLaboratorio");
			}

			if (entity.getDatTransProd() == null) {
				throw new ZMessManager().new ForeignException("datTransProd");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if (entity.getDatAnaTransProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("datAnaTransProdId");
			}

			if ((entity.getDatAnaTransProdId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatAnaTransProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datAnaTransProdId");
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

			if ((entity.getMobileId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getMobileId(), 23) == false)) {
				throw new ZMessManager().new NotValidFormatException("mobileId");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getResponsable() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getResponsable(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("responsable");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if (entity.getAnaLaboratorio().getAnaLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaLabId_AnaLaboratorio");
			}

			if ((entity.getAnaLaboratorio().getAnaLabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getAnaLaboratorio().getAnaLabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaLabId_AnaLaboratorio");
			}

			if (entity.getDatTransProd().getDatTransProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdId_DatTransProd");
			}

			if ((entity.getDatTransProd().getDatTransProdId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatTransProd().getDatTransProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdId_DatTransProd");
			}

			if (getDatAnaTransProd(entity.getDatAnaTransProdId()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			datAnaTransProdDAO.save(entity);

			log.debug("save DatAnaTransProd successful");
		} catch (Exception e) {
			log.error("save DatAnaTransProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatAnaTransProd(DatAnaTransProd entity) throws Exception {
		log.debug("deleting DatAnaTransProd instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatAnaTransProd");
		}

		if (entity.getDatAnaTransProdId() == null) {
			throw new ZMessManager().new EmptyFieldException("datAnaTransProdId");
		}

		List<ValorVarAnaTrans> valorVarAnaTranses = null;

		try {
			valorVarAnaTranses = valorVarAnaTransDAO.findByProperty("datAnaTransProd.datAnaTransProdId",
					entity.getDatAnaTransProdId());

			if (Utilities.validationsList(valorVarAnaTranses) == true) {
				throw new ZMessManager().new DeletingException("valorVarAnaTranses");
			}

			datAnaTransProdDAO.delete(entity);

			log.debug("delete DatAnaTransProd successful");
		} catch (Exception e) {
			log.error("delete DatAnaTransProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatAnaTransProd(DatAnaTransProd entity) throws Exception {
		log.debug("updating DatAnaTransProd instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatAnaTransProd");
			}

			if (entity.getAnaLaboratorio() == null) {
				throw new ZMessManager().new ForeignException("anaLaboratorio");
			}

			if (entity.getDatTransProd() == null) {
				throw new ZMessManager().new ForeignException("datTransProd");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if (entity.getDatAnaTransProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("datAnaTransProdId");
			}

			if ((entity.getDatAnaTransProdId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatAnaTransProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datAnaTransProdId");
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

			if ((entity.getMobileId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getMobileId(), 23) == false)) {
				throw new ZMessManager().new NotValidFormatException("mobileId");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getResponsable() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getResponsable(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("responsable");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if (entity.getAnaLaboratorio().getAnaLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaLabId_AnaLaboratorio");
			}

			if ((entity.getAnaLaboratorio().getAnaLabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getAnaLaboratorio().getAnaLabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaLabId_AnaLaboratorio");
			}

			if (entity.getDatTransProd().getDatTransProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdId_DatTransProd");
			}

			if ((entity.getDatTransProd().getDatTransProdId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatTransProd().getDatTransProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdId_DatTransProd");
			}

			datAnaTransProdDAO.update(entity);

			log.debug("update DatAnaTransProd successful");
		} catch (Exception e) {
			log.error("update DatAnaTransProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatAnaTransProdDTO> getDataDatAnaTransProd() throws Exception {
		try {
			List<DatAnaTransProd> datAnaTransProd = datAnaTransProdDAO.findAll();

			List<DatAnaTransProdDTO> datAnaTransProdDTO = new ArrayList<DatAnaTransProdDTO>();

			for (DatAnaTransProd datAnaTransProdTmp : datAnaTransProd) {
				DatAnaTransProdDTO datAnaTransProdDTO2 = new DatAnaTransProdDTO();

				datAnaTransProdDTO2.setDatAnaTransProdId(datAnaTransProdTmp.getDatAnaTransProdId());
				datAnaTransProdDTO2.setCompania(
						(datAnaTransProdTmp.getCompania() != null) ? datAnaTransProdTmp.getCompania() : null);
				datAnaTransProdDTO2.setConsecutivo(
						(datAnaTransProdTmp.getConsecutivo() != null) ? datAnaTransProdTmp.getConsecutivo() : null);
				datAnaTransProdDTO2
						.setEstado((datAnaTransProdTmp.getEstado() != null) ? datAnaTransProdTmp.getEstado() : null);
				datAnaTransProdDTO2.setFechaAnalisis(datAnaTransProdTmp.getFechaAnalisis());
				datAnaTransProdDTO2.setFechaCreacion(datAnaTransProdTmp.getFechaCreacion());
				datAnaTransProdDTO2.setFechaModificacion(datAnaTransProdTmp.getFechaModificacion());
				datAnaTransProdDTO2.setInfoAdicional(
						(datAnaTransProdTmp.getInfoAdicional() != null) ? datAnaTransProdTmp.getInfoAdicional() : null);
				datAnaTransProdDTO2.setInfoAdicional2((datAnaTransProdTmp.getInfoAdicional2() != null)
						? datAnaTransProdTmp.getInfoAdicional2() : null);
				datAnaTransProdDTO2.setMobileId(
						(datAnaTransProdTmp.getMobileId() != null) ? datAnaTransProdTmp.getMobileId() : null);
				datAnaTransProdDTO2.setObservacion(
						(datAnaTransProdTmp.getObservacion() != null) ? datAnaTransProdTmp.getObservacion() : null);
				datAnaTransProdDTO2.setObservacionAnularReg((datAnaTransProdTmp.getObservacionAnularReg() != null)
						? datAnaTransProdTmp.getObservacionAnularReg() : null);
				datAnaTransProdDTO2.setResponsable(
						(datAnaTransProdTmp.getResponsable() != null) ? datAnaTransProdTmp.getResponsable() : null);
				datAnaTransProdDTO2.setUsuarioDigitacion((datAnaTransProdTmp.getUsuarioDigitacion() != null)
						? datAnaTransProdTmp.getUsuarioDigitacion() : null);
				datAnaTransProdDTO2
						.setAnaLabId_AnaLaboratorio((datAnaTransProdTmp.getAnaLaboratorio().getAnaLabId() != null)
								? datAnaTransProdTmp.getAnaLaboratorio().getAnaLabId() : null);
				datAnaTransProdDTO2.setDatTransProdId_DatTransProd(
						(datAnaTransProdTmp.getDatTransProd().getDatTransProdId() != null)
								? datAnaTransProdTmp.getDatTransProd().getDatTransProdId() : null);
				datAnaTransProdDTO.add(datAnaTransProdDTO2);
			}

			return datAnaTransProdDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatAnaTransProd getDatAnaTransProd(Long datAnaTransProdId) throws Exception {
		log.debug("getting DatAnaTransProd instance");

		DatAnaTransProd entity = null;

		try {
			entity = datAnaTransProdDAO.findById(datAnaTransProdId);
		} catch (Exception e) {
			log.error("get DatAnaTransProd failed", e);
			throw new ZMessManager().new FindingException("DatAnaTransProd");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatAnaTransProd> findPageDatAnaTransProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatAnaTransProd> entity = null;

		try {
			entity = datAnaTransProdDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatAnaTransProd Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatAnaTransProd() throws Exception {
		Long entity = null;

		try {
			entity = datAnaTransProdDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatAnaTransProd Count");
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
	public List<DatAnaTransProd> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatAnaTransProd> list = new ArrayList<DatAnaTransProd>();
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
			list = datAnaTransProdDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}

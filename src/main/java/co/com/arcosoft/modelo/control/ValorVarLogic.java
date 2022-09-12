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

import co.com.arcosoft.dataaccess.dao.IValorVarDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ValorVar;
import co.com.arcosoft.modelo.dto.ValorVarDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ValorVarLogic")
public class ValorVarLogic implements IValorVarLogic {
	private static final Logger log = LoggerFactory.getLogger(ValorVarLogic.class);

	/**
	 * DAO injected by Spring that manages ValorVar entities
	 *
	 */
	@Autowired
	private IValorVarDAO valorVarDAO;

	/**
	 * Logic injected by Spring that manages DatSanVeg entities
	 *
	 */
	@Autowired
	IDatSanVegLogic logicDatSanVeg1;

	/**
	 * Logic injected by Spring that manages Variable entities
	 *
	 */
	@Autowired
	IVariableLogic logicVariable2;

	@Transactional(readOnly = true)
	public List<ValorVar> getValorVar() throws Exception {
		log.debug("finding all ValorVar instances");

		List<ValorVar> list = new ArrayList<ValorVar>();

		try {
			list = valorVarDAO.findAll();
		} catch (Exception e) {
			log.error("finding all ValorVar failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "ValorVar");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveValorVar(ValorVar entity) throws Exception {
		log.debug("saving ValorVar instance");

		try {
			if (entity.getDatSanVeg() == null) {
				throw new ZMessManager().new ForeignException("datSanVeg");
			}

			if (entity.getVariable() == null) {
				throw new ZMessManager().new ForeignException("variable");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getValor(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getDatSanVeg().getDatSanVegId() == null) {
				throw new ZMessManager().new EmptyFieldException("datSanVegId_DatSanVeg");
			}

			if ((entity.getDatSanVeg().getDatSanVegId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatSanVeg().getDatSanVegId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datSanVegId_DatSanVeg");
			}

			if (entity.getVariable().getVariableId() == null) {
				throw new ZMessManager().new EmptyFieldException("variableId_Variable");
			}

			if ((entity.getVariable().getVariableId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable().getVariableId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableId_Variable");
			}

			valorVarDAO.save(entity);

			log.debug("save ValorVar successful");
		} catch (Exception e) {
			log.error("save ValorVar failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteValorVar(ValorVar entity) throws Exception {
		log.debug("deleting ValorVar instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ValorVar");
		}
		try {
			valorVarDAO.delete(entity);

			log.debug("delete ValorVar successful");
		} catch (Exception e) {
			log.error("delete ValorVar failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateValorVar(ValorVar entity) throws Exception {
		log.debug("updating ValorVar instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("ValorVar");
			}

			if (entity.getDatSanVeg() == null) {
				throw new ZMessManager().new ForeignException("datSanVeg");
			}


			if ((entity.getValor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getValor(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getDatSanVeg().getDatSanVegId() == null) {
				throw new ZMessManager().new EmptyFieldException("datSanVegId_DatSanVeg");
			}

			if ((entity.getDatSanVeg().getDatSanVegId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatSanVeg().getDatSanVegId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datSanVegId_DatSanVeg");
			}


			

			valorVarDAO.update(entity);

			log.debug("update ValorVar successful");
		} catch (Exception e) {
			log.error("update ValorVar failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ValorVarDTO> getDataValorVar() throws Exception {
		try {
			List<ValorVar> valorVar = valorVarDAO.findAll();

			List<ValorVarDTO> valorVarDTO = new ArrayList<ValorVarDTO>();

			for (ValorVar valorVarTmp : valorVar) {
				ValorVarDTO valorVarDTO2 = new ValorVarDTO();

				valorVarDTO2.setValorVarId(valorVarTmp.getValorVarId());
				valorVarDTO2.setFechaCreacion(valorVarTmp.getFechaCreacion());
				valorVarDTO2.setFechaModificacion(valorVarTmp.getFechaModificacion());
				valorVarDTO2.setValor((valorVarTmp.getValor() != null) ? valorVarTmp.getValor() : null);
				valorVarDTO2.setDatSanVegId_DatSanVeg((valorVarTmp.getDatSanVeg().getDatSanVegId() != null)
						? valorVarTmp.getDatSanVeg().getDatSanVegId() : null);

				if (valorVarTmp.getVariable() != null) {
					valorVarDTO2.setVariableId_Variable(valorVarTmp.getVariable().getVariableId());
				} else {
					valorVarDTO2.setVariableId_Variable(null);
				}

				valorVarDTO.add(valorVarDTO2);
			}

			return valorVarDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ValorVar getValorVar(Long valorVarId) throws Exception {
		log.debug("getting ValorVar instance");

		ValorVar entity = null;

		try {
			entity = valorVarDAO.findById(valorVarId);
		} catch (Exception e) {
			log.error("get ValorVar failed", e);
			throw new ZMessManager().new FindingException("ValorVar");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<ValorVar> findPageValorVar(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<ValorVar> entity = null;

		try {
			entity = valorVarDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ValorVar Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberValorVar() throws Exception {
		Long entity = null;

		try {
			entity = valorVarDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ValorVar Count");
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
	@Transactional(readOnly = true)
	public List<ValorVar> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<ValorVar> list = new ArrayList<ValorVar>();
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
			list = valorVarDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = true)
	public List<ValorVarDTO> getDataValorVarByValor(Long datSanVegId) throws Exception {
		try {
			List<ValorVar> valorVar = valorVarDAO.findByCriteria("datSanVeg.datSanVegId= " + datSanVegId);

			List<ValorVarDTO> valorVarDTO = new ArrayList<ValorVarDTO>();

			for (ValorVar valorVarTmp : valorVar) {
				ValorVarDTO valorVarDTO2 = new ValorVarDTO();

				valorVarDTO2.setValorVarId(valorVarTmp.getValorVarId());
				valorVarDTO2.setFechaCreacion(valorVarTmp.getFechaCreacion());
				valorVarDTO2.setFechaModificacion(valorVarTmp.getFechaModificacion());
				valorVarDTO2.setValor((valorVarTmp.getValor() != null) ? valorVarTmp.getValor() : null);
				valorVarDTO2.setDatSanVegId_DatSanVeg((valorVarTmp.getDatSanVeg().getDatSanVegId() != null)
						? valorVarTmp.getDatSanVeg().getDatSanVegId() : null);

				if (valorVarTmp.getVariable() != null) {
					valorVarDTO2.setVariableId_Variable(valorVarTmp.getVariable().getVariableId());
				} else {
					valorVarDTO2.setVariableId_Variable(null);
				}

				valorVarDTO2.setVariable1(valorVarTmp.getVariable1());
				valorVarDTO2.setVariable2(valorVarTmp.getVariable2());
				valorVarDTO2.setVariable3(valorVarTmp.getVariable3());
				valorVarDTO2.setVariable4(valorVarTmp.getVariable4());
				valorVarDTO2.setVariable5(valorVarTmp.getVariable5());
				valorVarDTO2.setVariable6(valorVarTmp.getVariable6());
				valorVarDTO2.setVariable7(valorVarTmp.getVariable7());
				valorVarDTO2.setVariable8(valorVarTmp.getVariable8());
				valorVarDTO2.setVariable9(valorVarTmp.getVariable9());
				valorVarDTO2.setVariable10(valorVarTmp.getVariable10());

				valorVarDTO2.setVariableText1(valorVarTmp.getVariableText1());
				valorVarDTO2.setVariableText2(valorVarTmp.getVariableText2());
				valorVarDTO2.setVariableText3(valorVarTmp.getVariableText3());
				valorVarDTO2.setVariableText4(valorVarTmp.getVariableText4());
				valorVarDTO2.setVariableText5(valorVarTmp.getVariableText5());
				valorVarDTO2.setVariableText6(valorVarTmp.getVariableText6());
				valorVarDTO2.setVariableText7(valorVarTmp.getVariableText7());
				valorVarDTO2.setVariableText8(valorVarTmp.getVariableText8());
				valorVarDTO2.setVariableText9(valorVarTmp.getVariableText9());
				valorVarDTO2.setVariableText10(valorVarTmp.getVariableText10());

				if (valorVarTmp.getFitosanidad() != null) {
					valorVarDTO2.setFitosanidad(valorVarTmp.getFitosanidad());
				} else {
					valorVarDTO2.setFitosanidad(null);
				}

				if (valorVarTmp.getFitosanidad() != null) {
					valorVarDTO2.setNombreFitosanidad(valorVarTmp.getFitosanidad().getNombre());
				} else {
					valorVarDTO2.setNombreFitosanidad(null);
				}

				valorVarDTO2.setVariableDate1(valorVarTmp.getVariableDate1());

				valorVarDTO.add(valorVarDTO2);
			}

			return valorVarDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}

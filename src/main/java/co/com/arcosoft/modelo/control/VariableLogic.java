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

import co.com.arcosoft.dataaccess.dao.IListValorDAO;
import co.com.arcosoft.dataaccess.dao.IRangoValorDAO;
import co.com.arcosoft.dataaccess.dao.IVariableDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ListValor;
import co.com.arcosoft.modelo.RangoValor;
import co.com.arcosoft.modelo.Variable;
import co.com.arcosoft.modelo.dto.ListValorDTO;
import co.com.arcosoft.modelo.dto.RangoValorDTO;
import co.com.arcosoft.modelo.dto.VariableDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("VariableLogic")
public class VariableLogic implements IVariableLogic {
	private static final Logger log = LoggerFactory.getLogger(VariableLogic.class);

	/**
	 * DAO injected by Spring that manages Variable entities
	 *
	 */
	@Autowired
	private IVariableDAO variableDAO;

	@Autowired
	private IListValorDAO listValorDAO;

	@Autowired
	private IRangoValorDAO rangoValorDAO;

	/**
	 * Logic injected by Spring that manages AnaSanVeg entities
	 *
	 */
	@Autowired
	IAnaSanVegLogic logicAnaSanVeg1;

	@Override
	@Transactional(readOnly = true)
	public List<Variable> getVariable() throws Exception {
		log.debug("finding all Variable instances");

		List<Variable> list = new ArrayList<Variable>();

		try {
			list = variableDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Variable failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Variable");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveVariable(Variable entity, List<ListValorDTO> dataValores, List<RangoValorDTO> dataRango)
			throws Exception {
		log.debug("saving Variable instance");

		try {
			if (entity.getAnaSanVeg() == null) {
				throw new ZMessManager().new ForeignException("anaSanVeg");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
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

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getNumeroDecimales() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroDecimales(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroDecimales");
			}

			if ((entity.getOrden() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getOrden(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("orden");
			}

			if ((entity.getTiempoDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTiempoDigitacion(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tiempoDigitacion");
			}

			if ((entity.getTipoDato() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoDato(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoDato");
			}

			if ((entity.getValorMaximo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorMaximo(), 6, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorMaximo");
			}

			if ((entity.getValorMinimo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorMinimo(), 6, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorMinimo");
			}

			/*
			 * if (entity.getVariableId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("variableId"); }
			 * 
			 * if ((entity.getVariableId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getVariableId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "variableId"); }
			 */

			if (entity.getAnaSanVeg().getAnaSanVegId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaSanVegId_AnaSanVeg");
			}

			if ((entity.getAnaSanVeg().getAnaSanVegId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaSanVeg().getAnaSanVegId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaSanVegId_AnaSanVeg");
			}

			/*
			 * if (getVariable(entity.getVariableId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			variableDAO.save(entity);

			if (dataValores != null) {

				for (ListValorDTO valorDto : dataValores) {

					if (valorDto.getListValorId() == null) {

						ListValor valor = new ListValor();

						valor.setClasificacion(valorDto.getClasificacion());
						valor.setCodigo(valorDto.getCodigo());
						valor.setCompania(entity.getCompania());
						valor.setFechaCreacion(new Date());
						valor.setFechaModificacion(new Date());
						valor.setInfoAdicional(null);
						valor.setInfoAdicional2(null);
						valor.setValorAlfaNumerico(valorDto.getValorAlfaNumerico());
						valor.setValorNumerico(valorDto.getValorNumerico());
						valor.setVariable(entity);

						listValorDAO.save(valor);
					}

				}
			}

			if (dataRango != null) {

				for (RangoValorDTO valorRangoDTO : dataRango) {

					RangoValor valorRango = new RangoValor();

					valorRango.setCodigo(valorRangoDTO.getCodigo());
					valorRango.setClasificacion(valorRangoDTO.getClasificacion());
					valorRango.setCompania(valorRangoDTO.getCompania());
					valorRango.setEstado(valorRangoDTO.getEstado());
					valorRango.setFechaCreacion(new Date());
					valorRango.setFechaModificacion(valorRangoDTO.getFechaCreacion());
					valorRango.setInfoAdicional(null);
					valorRango.setInfoAdicional2(null);
					valorRango.setValorFinal(valorRangoDTO.getValorFinal());
					valorRango.setValorInicial(valorRangoDTO.getValorInicial());
					valorRango.setVariable(entity);

					rangoValorDAO.save(valorRango);
				}
			}

			log.debug("save Variable successful");
		} catch (Exception e) {
			log.error("save Variable failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteVariable(Variable entity) throws Exception {
		log.debug("deleting Variable instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Variable");
		}

		if (entity.getVariableId() == null) {
			throw new ZMessManager().new EmptyFieldException("variableId");
		}

		try {
			variableDAO.delete(entity);

			log.debug("delete Variable successful");
		} catch (Exception e) {
			log.error("delete Variable failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateVariable(Variable entity, List<ListValorDTO> dataValores, List<RangoValorDTO> dataRango)
			throws Exception {
		log.debug("updating Variable instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Variable");
			}

			if (entity.getAnaSanVeg() == null) {
				throw new ZMessManager().new ForeignException("anaSanVeg");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
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

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getNumeroDecimales() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroDecimales(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroDecimales");
			}

			if ((entity.getOrden() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getOrden(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("orden");
			}

			if ((entity.getTiempoDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTiempoDigitacion(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tiempoDigitacion");
			}

			if ((entity.getTipoDato() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoDato(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoDato");
			}

			if ((entity.getValorMaximo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorMaximo(), 6, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorMaximo");
			}

			if ((entity.getValorMinimo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorMinimo(), 6, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorMinimo");
			}

			if (entity.getVariableId() == null) {
				throw new ZMessManager().new EmptyFieldException("variableId");
			}

			if ((entity.getVariableId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariableId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableId");
			}

			if (entity.getAnaSanVeg().getAnaSanVegId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaSanVegId_AnaSanVeg");
			}

			if ((entity.getAnaSanVeg().getAnaSanVegId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaSanVeg().getAnaSanVegId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaSanVegId_AnaSanVeg");
			}

			variableDAO.update(entity);

			for (ListValorDTO valorDto : dataValores) {

				if (valorDto.getListValorId() == null) { // crear el valor nuevo

					ListValor valor = new ListValor();

					valor.setClasificacion(valorDto.getClasificacion());
					valor.setCodigo(valorDto.getCodigo());
					valor.setCompania(entity.getCompania());
					valor.setFechaCreacion(new Date());
					valor.setFechaModificacion(new Date());
					valor.setInfoAdicional(null);
					valor.setInfoAdicional2(null);
					valor.setValorAlfaNumerico(valorDto.getValorAlfaNumerico());
					valor.setValorNumerico(valorDto.getValorNumerico());
					valor.setVariable(entity);

					listValorDAO.save(valor);

				} else {
					ListValor valor = listValorDAO.findById(valorDto.getListValorId());

					valor.setClasificacion(valorDto.getClasificacion());
					valor.setCodigo(valorDto.getCodigo());
					valor.setCompania(entity.getCompania());
					valor.setFechaModificacion(new Date());
					valor.setInfoAdicional(null);
					valor.setInfoAdicional2(null);
					valor.setValorAlfaNumerico(valorDto.getValorAlfaNumerico());
					valor.setValorNumerico(valorDto.getValorNumerico());
					valor.setVariable(entity);

					listValorDAO.update(valor);
				}

			}

			for (RangoValorDTO valorRangoDTO : dataRango) {

				if (valorRangoDTO.getRangoValorId() == null) {

					RangoValor valorRango = new RangoValor();

					valorRango.setClasificacion(valorRangoDTO.getClasificacion());
					valorRango.setCodigo(valorRangoDTO.getCodigo());
					valorRango.setCompania(valorRangoDTO.getCompania());
					valorRango.setEstado(valorRangoDTO.getEstado());
					valorRango.setFechaCreacion(new Date());
					valorRango.setFechaModificacion(new Date());
					valorRango.setInfoAdicional(null);
					valorRango.setInfoAdicional2(null);
					valorRango.setValorFinal(valorRangoDTO.getValorFinal());
					valorRango.setValorInicial(valorRangoDTO.getValorInicial());
					valorRango.setVariable(entity);

					rangoValorDAO.save(valorRango);

				} else {

					RangoValor valorRango = rangoValorDAO.findById(valorRangoDTO.getRangoValorId());

					valorRango.setClasificacion(valorRango.getClasificacion());
					valorRango.setCodigo(valorRangoDTO.getCodigo());
					valorRango.setCompania(valorRangoDTO.getCompania());
					valorRango.setEstado(valorRangoDTO.getEstado());
					valorRango.setFechaCreacion(new Date());
					valorRango.setFechaModificacion(new Date());
					valorRango.setInfoAdicional(null);
					valorRango.setInfoAdicional2(null);
					valorRango.setValorFinal(valorRangoDTO.getValorFinal());
					valorRango.setValorInicial(valorRangoDTO.getValorInicial());
					valorRango.setVariable(entity);

					rangoValorDAO.update(valorRango);

				}
			}

			log.debug("update Variable successful");
		} catch (Exception e) {
			log.error("update Variable failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<VariableDTO> getDataVariable() throws Exception {
		try {
			List<Variable> variable = variableDAO.findAll();

			List<VariableDTO> variableDTO = new ArrayList<VariableDTO>();

			for (Variable variableTmp : variable) {
				VariableDTO variableDTO2 = new VariableDTO();

				variableDTO2.setVariableId(variableTmp.getVariableId());
				variableDTO2.setCodigo((variableTmp.getCodigo() != null) ? variableTmp.getCodigo() : null);
				variableDTO2.setCompania((variableTmp.getCompania() != null) ? variableTmp.getCompania() : null);
				variableDTO2.setEstado((variableTmp.getEstado() != null) ? variableTmp.getEstado() : null);
				variableDTO2.setFechaCreacion(variableTmp.getFechaCreacion());
				variableDTO2.setFechaModificacion(variableTmp.getFechaModificacion());
				variableDTO2.setInfoAdicional(
						(variableTmp.getInfoAdicional() != null) ? variableTmp.getInfoAdicional() : null);
				variableDTO2.setInfoAdicional2(
						(variableTmp.getInfoAdicional2() != null) ? variableTmp.getInfoAdicional2() : null);
				variableDTO2.setNombre((variableTmp.getNombre() != null) ? variableTmp.getNombre() : null);
				variableDTO2.setNumeroDecimales(
						(variableTmp.getNumeroDecimales() != null) ? variableTmp.getNumeroDecimales() : null);
				variableDTO2.setOrden((variableTmp.getOrden() != null) ? variableTmp.getOrden() : null);
				variableDTO2.setTiempoDigitacion(
						(variableTmp.getTiempoDigitacion() != null) ? variableTmp.getTiempoDigitacion() : null);
				variableDTO2.setTipoDato((variableTmp.getTipoDato() != null) ? variableTmp.getTipoDato() : null);
				variableDTO2
						.setValorMaximo((variableTmp.getValorMaximo() != null) ? variableTmp.getValorMaximo() : null);
				variableDTO2
						.setValorMinimo((variableTmp.getValorMinimo() != null) ? variableTmp.getValorMinimo() : null);
				variableDTO2.setAnaSanVegId_AnaSanVeg((variableTmp.getAnaSanVeg().getAnaSanVegId() != null)
						? variableTmp.getAnaSanVeg().getAnaSanVegId() : null);

				String nombreAnalisis = variableTmp.getAnaSanVeg().getNombre();
				variableDTO2.setAnalisis(nombreAnalisis);

				variableDTO.add(variableDTO2);
			}

			return variableDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Variable getVariable(Long variableId) throws Exception {
		log.debug("getting Variable instance");

		Variable entity = null;

		try {
			entity = variableDAO.findById(variableId);
		} catch (Exception e) {
			log.error("get Variable failed", e);
			throw new ZMessManager().new FindingException("Variable");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Variable> findPageVariable(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Variable> entity = null;

		try {
			entity = variableDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Variable Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberVariable() throws Exception {
		Long entity = null;

		try {
			entity = variableDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Variable Count");
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
	public List<Variable> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Variable> list = new ArrayList<Variable>();
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
			list = variableDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

}

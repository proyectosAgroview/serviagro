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

import co.com.arcosoft.dataaccess.dao.IDatTransProdDAO;
import co.com.arcosoft.dataaccess.dao.ITransportadoraDAO;
import co.com.arcosoft.dataaccess.dao.IVehiculosTranspDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatTransProd;
import co.com.arcosoft.modelo.Transportadora;
import co.com.arcosoft.modelo.VehiculosTransp;
import co.com.arcosoft.modelo.dto.TransportadoraDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TransportadoraLogic")
public class TransportadoraLogic implements ITransportadoraLogic {
	private static final Logger log = LoggerFactory.getLogger(TransportadoraLogic.class);

	/**
	 * DAO injected by Spring that manages Transportadora entities
	 *
	 */
	@Autowired
	private ITransportadoraDAO transportadoraDAO;

	/**
	 * DAO injected by Spring that manages DatTransProd entities
	 *
	 */
	@Autowired
	private IDatTransProdDAO datTransProdDAO;

	/**
	 * DAO injected by Spring that manages VehiculosTransp entities
	 *
	 */
	@Autowired
	private IVehiculosTranspDAO vehiculosTranspDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Transportadora> getTransportadora() throws Exception {
		log.debug("finding all Transportadora instances");

		List<Transportadora> list = new ArrayList<Transportadora>();

		try {
			list = transportadoraDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Transportadora failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Transportadora");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTransportadora(Transportadora entity) throws Exception {
		log.debug("saving Transportadora instance");

		try {
			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDireccion(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccion");
			}

			if ((entity.getEmail() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEmail(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("email");
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

			if ((entity.getNit() != null) && (Utilities.checkWordAndCheckWithlength(entity.getNit(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("nit");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			/*
			 * if (entity.getTranspId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("transpId"); }
			 * 
			 * if ((entity.getTranspId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTranspId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("transpId"); }
			 * 
			 * if (getTransportadora(entity.getTranspId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			transportadoraDAO.save(entity);

			log.debug("save Transportadora successful");
		} catch (Exception e) {
			log.error("save Transportadora failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTransportadora(Transportadora entity) throws Exception {
		log.debug("deleting Transportadora instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Transportadora");
		}

		if (entity.getTranspId() == null) {
			throw new ZMessManager().new EmptyFieldException("transpId");
		}

		List<DatTransProd> datTransProds = null;
		List<VehiculosTransp> vehiculosTransps = null;

		try {
			datTransProds = datTransProdDAO.findByProperty("transportadora.transpId", entity.getTranspId());

			if (Utilities.validationsList(datTransProds) == true) {
				throw new ZMessManager().new DeletingException("datTransProds");
			}

			vehiculosTransps = vehiculosTranspDAO.findByProperty("transportadora.transpId", entity.getTranspId());

			if (Utilities.validationsList(vehiculosTransps) == true) {
				throw new ZMessManager().new DeletingException("vehiculosTransps");
			}

			transportadoraDAO.delete(entity);

			log.debug("delete Transportadora successful");
		} catch (Exception e) {
			log.error("delete Transportadora failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTransportadora(Transportadora entity) throws Exception {
		log.debug("updating Transportadora instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Transportadora");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDireccion(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccion");
			}

			if ((entity.getEmail() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEmail(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("email");
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

			if ((entity.getNit() != null) && (Utilities.checkWordAndCheckWithlength(entity.getNit(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("nit");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if (entity.getTranspId() == null) {
				throw new ZMessManager().new EmptyFieldException("transpId");
			}

			if ((entity.getTranspId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTranspId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("transpId");
			}

			transportadoraDAO.update(entity);

			log.debug("update Transportadora successful");
		} catch (Exception e) {
			log.error("update Transportadora failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TransportadoraDTO> getDataTransportadora() throws Exception {
		try {
			List<Transportadora> transportadora = transportadoraDAO.findAll();

			List<TransportadoraDTO> transportadoraDTO = new ArrayList<TransportadoraDTO>();

			for (Transportadora transportadoraTmp : transportadora) {
				TransportadoraDTO transportadoraDTO2 = new TransportadoraDTO();

				transportadoraDTO2.setTranspId(transportadoraTmp.getTranspId());
				transportadoraDTO2
						.setCodigo((transportadoraTmp.getCodigo() != null) ? transportadoraTmp.getCodigo() : null);
				transportadoraDTO2.setCompania(
						(transportadoraTmp.getCompania() != null) ? transportadoraTmp.getCompania() : null);
				transportadoraDTO2.setDireccion(
						(transportadoraTmp.getDireccion() != null) ? transportadoraTmp.getDireccion() : null);
				transportadoraDTO2
						.setEmail((transportadoraTmp.getEmail() != null) ? transportadoraTmp.getEmail() : null);
				transportadoraDTO2
						.setEstado((transportadoraTmp.getEstado() != null) ? transportadoraTmp.getEstado() : null);
				transportadoraDTO2.setFechaCreacion(
						(transportadoraTmp.getFechaCreacion() != null) ? transportadoraTmp.getFechaCreacion() : null);
				transportadoraDTO2.setFechaModificacion((transportadoraTmp.getFechaModificacion() != null)
						? transportadoraTmp.getFechaModificacion() : null);
				transportadoraDTO2.setInfoAdicional(
						(transportadoraTmp.getInfoAdicional() != null) ? transportadoraTmp.getInfoAdicional() : null);
				transportadoraDTO2.setInfoAdicional2(
						(transportadoraTmp.getInfoAdicional2() != null) ? transportadoraTmp.getInfoAdicional2() : null);
				transportadoraDTO2.setNit((transportadoraTmp.getNit() != null) ? transportadoraTmp.getNit() : null);
				transportadoraDTO2
						.setNombre((transportadoraTmp.getNombre() != null) ? transportadoraTmp.getNombre() : null);
				transportadoraDTO2.setTelefono(
						(transportadoraTmp.getTelefono() != null) ? transportadoraTmp.getTelefono() : null);
				transportadoraDTO.add(transportadoraDTO2);
			}

			return transportadoraDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Transportadora getTransportadora(Long transpId) throws Exception {
		log.debug("getting Transportadora instance");

		Transportadora entity = null;

		try {
			entity = transportadoraDAO.findById(transpId);
		} catch (Exception e) {
			log.error("get Transportadora failed", e);
			throw new ZMessManager().new FindingException("Transportadora");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Transportadora> findPageTransportadora(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<Transportadora> entity = null;

		try {
			entity = transportadoraDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Transportadora Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTransportadora() throws Exception {
		Long entity = null;

		try {
			entity = transportadoraDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Transportadora Count");
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
	public List<Transportadora> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<Transportadora> list = new ArrayList<Transportadora>();
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
			list = transportadoraDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}

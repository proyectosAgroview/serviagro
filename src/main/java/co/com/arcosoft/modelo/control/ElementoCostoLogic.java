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

import co.com.arcosoft.dataaccess.dao.IConceptoNominaDAO;
import co.com.arcosoft.dataaccess.dao.ICostoRecursoDAO;
import co.com.arcosoft.dataaccess.dao.IElementoCostoDAO;
import co.com.arcosoft.dataaccess.dao.IEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IProductoDAO;
import co.com.arcosoft.dataaccess.dao.IProfesionDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.CostoRecurso;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.dto.ElementoCostoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ElementoCostoLogic")
public class ElementoCostoLogic implements IElementoCostoLogic {
	private static final Logger log = LoggerFactory.getLogger(ElementoCostoLogic.class);

	/**
	 * DAO injected by Spring that manages ElementoCosto entities
	 *
	 */
	@Autowired
	private IElementoCostoDAO elementoCostoDAO;

	/**
	 * DAO injected by Spring that manages ConceptoNomina entities
	 *
	 */
	@Autowired
	private IConceptoNominaDAO conceptoNominaDAO;

	/**
	 * DAO injected by Spring that manages CostoRecurso entities
	 *
	 */
	@Autowired
	private ICostoRecursoDAO costoRecursoDAO;

	/**
	 * DAO injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	private IEquipoDAO equipoDAO;

	/**
	 * DAO injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	private IProductoDAO productoDAO;

	/**
	 * DAO injected by Spring that manages Profesion entities
	 *
	 */
	@Autowired
	private IProfesionDAO profesionDAO;

	@Override
	@Transactional(readOnly = true)
	public List<ElementoCosto> getElementoCosto() throws Exception {
		log.debug("finding all ElementoCosto instances");

		List<ElementoCosto> list = new ArrayList<ElementoCosto>();

		try {
			list = elementoCostoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all ElementoCosto failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "ElementoCosto");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveElementoCosto(ElementoCosto entity) throws Exception {
		log.debug("saving ElementoCosto instance");

		try {
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
			/*
			 * if (entity.getElemCostoId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("elemCostoId"); }
			 * 
			 * if ((entity.getElemCostoId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getElemCostoId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "elemCostoId"); }
			 * 
			 * if (getElementoCosto(entity.getElemCostoId()) != null) { throw
			 * new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */
			elementoCostoDAO.save(entity);

			log.debug("save ElementoCosto successful");
		} catch (Exception e) {
			log.error("save ElementoCosto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteElementoCosto(ElementoCosto entity) throws Exception {
		log.debug("deleting ElementoCosto instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ElementoCosto");
		}

		if (entity.getElemCostoId() == null) {
			throw new ZMessManager().new EmptyFieldException("elemCostoId");
		}

		List<ConceptoNomina> conceptoNominas = null;
		List<CostoRecurso> costoRecursos = null;
		List<Equipo> equipos = null;
		List<Producto> productos = null;
		List<Profesion> profesions = null;

		try {
			conceptoNominas = conceptoNominaDAO.findByProperty("elementoCosto.elemCostoId", entity.getElemCostoId());

			if (Utilities.validationsList(conceptoNominas) == true) {
				throw new ZMessManager().new DeletingException("conceptoNominas");
			}

			costoRecursos = costoRecursoDAO.findByProperty("elementoCosto.elemCostoId", entity.getElemCostoId());

			if (Utilities.validationsList(costoRecursos) == true) {
				throw new ZMessManager().new DeletingException("costoRecursos");
			}

			equipos = equipoDAO.findByProperty("elementoCosto.elemCostoId", entity.getElemCostoId());

			if (Utilities.validationsList(equipos) == true) {
				throw new ZMessManager().new DeletingException("equipos");
			}

			productos = productoDAO.findByProperty("elementoCosto.elemCostoId", entity.getElemCostoId());

			if (Utilities.validationsList(productos) == true) {
				throw new ZMessManager().new DeletingException("productos");
			}

			profesions = profesionDAO.findByProperty("elementoCosto.elemCostoId", entity.getElemCostoId());

			if (Utilities.validationsList(profesions) == true) {
				throw new ZMessManager().new DeletingException("profesions");
			}

			elementoCostoDAO.delete(entity);

			log.debug("delete ElementoCosto successful");
		} catch (Exception e) {
			log.error("delete ElementoCosto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateElementoCosto(ElementoCosto entity) throws Exception {
		log.debug("updating ElementoCosto instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("ElementoCosto");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getElemCostoId() == null) {
				throw new ZMessManager().new EmptyFieldException("elemCostoId");
			}

			if ((entity.getElemCostoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getElemCostoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId");
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

			elementoCostoDAO.update(entity);

			log.debug("update ElementoCosto successful");
		} catch (Exception e) {
			log.error("update ElementoCosto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ElementoCostoDTO> getDataElementoCosto() throws Exception {
		try {
			List<ElementoCosto> elementoCosto = elementoCostoDAO.findAll();

			List<ElementoCostoDTO> elementoCostoDTO = new ArrayList<ElementoCostoDTO>();

			for (ElementoCosto elementoCostoTmp : elementoCosto) {
				ElementoCostoDTO elementoCostoDTO2 = new ElementoCostoDTO();

				elementoCostoDTO2.setElemCostoId(elementoCostoTmp.getElemCostoId());
				elementoCostoDTO2
						.setCodigo((elementoCostoTmp.getCodigo() != null) ? elementoCostoTmp.getCodigo() : null);
				elementoCostoDTO2
						.setCompania((elementoCostoTmp.getCompania() != null) ? elementoCostoTmp.getCompania() : null);
				elementoCostoDTO2
						.setEstado((elementoCostoTmp.getEstado() != null) ? elementoCostoTmp.getEstado() : null);
				elementoCostoDTO2.setFechaCreacion(elementoCostoTmp.getFechaCreacion());
				elementoCostoDTO2.setFechaModificacion(elementoCostoTmp.getFechaModificacion());
				elementoCostoDTO2.setInfoAdicional(
						(elementoCostoTmp.getInfoAdicional() != null) ? elementoCostoTmp.getInfoAdicional() : null);
				elementoCostoDTO2.setInfoAdicional2(
						(elementoCostoTmp.getInfoAdicional2() != null) ? elementoCostoTmp.getInfoAdicional2() : null);
				elementoCostoDTO2
						.setNombre((elementoCostoTmp.getNombre() != null) ? elementoCostoTmp.getNombre() : null);
				elementoCostoDTO.add(elementoCostoDTO2);
			}

			return elementoCostoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ElementoCosto getElementoCosto(Long elemCostoId) throws Exception {
		log.debug("getting ElementoCosto instance");

		ElementoCosto entity = null;

		try {
			entity = elementoCostoDAO.findById(elemCostoId);
		} catch (Exception e) {
			log.error("get ElementoCosto failed", e);
			throw new ZMessManager().new FindingException("ElementoCosto");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ElementoCosto> findPageElementoCosto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ElementoCosto> entity = null;

		try {
			entity = elementoCostoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ElementoCosto Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberElementoCosto() throws Exception {
		Long entity = null;

		try {
			entity = elementoCostoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ElementoCosto Count");
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
	public List<ElementoCosto> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<ElementoCosto> list = new ArrayList<ElementoCosto>();
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
			list = elementoCostoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}

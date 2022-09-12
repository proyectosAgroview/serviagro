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

import co.com.arcosoft.dataaccess.dao.IVariedadNivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.VariedadNivel4;
import co.com.arcosoft.modelo.dto.VariedadNivel4DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("VariedadNivel4Logic")
public class VariedadNivel4Logic implements IVariedadNivel4Logic {
	private static final Logger log = LoggerFactory.getLogger(VariedadNivel4Logic.class);

	/**
	 * DAO injected by Spring that manages VariedadNivel4 entities
	 *
	 */
	@Autowired
	private IVariedadNivel4DAO variedadNivel4DAO;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel41;

	/**
	 * Logic injected by Spring that manages Variedad entities
	 *
	 */
	@Autowired
	IVariedadLogic logicVariedad2;

	@Override
	@Transactional(readOnly = true)
	public List<VariedadNivel4> getVariedadNivel4() throws Exception {
		log.debug("finding all VariedadNivel4 instances");

		List<VariedadNivel4> list = new ArrayList<VariedadNivel4>();

		try {
			list = variedadNivel4DAO.findAll();
		} catch (Exception e) {
			log.error("finding all VariedadNivel4 failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "VariedadNivel4");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveVariedadNivel4(VariedadNivel4 entity) throws Exception {
		log.debug("saving VariedadNivel4 instance");

		try {
			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getVariedad() == null) {
				throw new ZMessManager().new ForeignException("variedad");
			}

			if ((entity.getPorcentajeArea() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPorcentajeArea(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("porcentajeArea");
			}

			if (entity.getVariedadNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("variedadNivel4Id");
			}

			if ((entity.getVariedadNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedadNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedadNivel4Id");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			if (entity.getVariedad().getVariedId() == null) {
				throw new ZMessManager().new EmptyFieldException("variedId_Variedad");
			}

			if ((entity.getVariedad().getVariedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedad().getVariedId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedId_Variedad");
			}

			if (getVariedadNivel4(entity.getVariedadNivel4Id()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			variedadNivel4DAO.save(entity);

			log.debug("save VariedadNivel4 successful");
		} catch (Exception e) {
			log.error("save VariedadNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteVariedadNivel4(VariedadNivel4 entity) throws Exception {
		log.debug("deleting VariedadNivel4 instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("VariedadNivel4");
		}

		if (entity.getVariedadNivel4Id() == null) {
			throw new ZMessManager().new EmptyFieldException("variedadNivel4Id");
		}

		try {
			variedadNivel4DAO.delete(entity);

			log.debug("delete VariedadNivel4 successful");
		} catch (Exception e) {
			log.error("delete VariedadNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateVariedadNivel4(VariedadNivel4 entity) throws Exception {
		log.debug("updating VariedadNivel4 instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("VariedadNivel4");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getVariedad() == null) {
				throw new ZMessManager().new ForeignException("variedad");
			}

			if ((entity.getPorcentajeArea() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPorcentajeArea(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("porcentajeArea");
			}

			if (entity.getVariedadNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("variedadNivel4Id");
			}

			if ((entity.getVariedadNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedadNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedadNivel4Id");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			if (entity.getVariedad().getVariedId() == null) {
				throw new ZMessManager().new EmptyFieldException("variedId_Variedad");
			}

			if ((entity.getVariedad().getVariedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedad().getVariedId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedId_Variedad");
			}

			variedadNivel4DAO.update(entity);

			log.debug("update VariedadNivel4 successful");
		} catch (Exception e) {
			log.error("update VariedadNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<VariedadNivel4DTO> getDataVariedadNivel4() throws Exception {
		try {
			List<VariedadNivel4> variedadNivel4 = variedadNivel4DAO.findAll();

			List<VariedadNivel4DTO> variedadNivel4DTO = new ArrayList<VariedadNivel4DTO>();

			for (VariedadNivel4 variedadNivel4Tmp : variedadNivel4) {
				VariedadNivel4DTO variedadNivel4DTO2 = new VariedadNivel4DTO();

				variedadNivel4DTO2.setVariedadNivel4Id(variedadNivel4Tmp.getVariedadNivel4Id());

				variedadNivel4DTO2.setPorcentajeArea(
						(variedadNivel4Tmp.getPorcentajeArea() != null) ? variedadNivel4Tmp.getPorcentajeArea() : null);

				variedadNivel4DTO2.setNivel4Id_Nivel4((variedadNivel4Tmp.getNivel4().getNivel4Id() != null)
						? variedadNivel4Tmp.getNivel4().getNivel4Id() : null);

				variedadNivel4DTO2.setVariedId_Variedad(
						(variedadNivel4Tmp.getVariedad() != null) ? variedadNivel4Tmp.getVariedad() : null);

				variedadNivel4DTO2.setNombreVariedad((variedadNivel4Tmp.getVariedad().getNombre() != null)
						? variedadNivel4Tmp.getVariedad().getNombre() : null);

				variedadNivel4DTO.add(variedadNivel4DTO2);
			}

			return variedadNivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public VariedadNivel4 getVariedadNivel4(Long variedadNivel4Id) throws Exception {
		log.debug("getting VariedadNivel4 instance");

		VariedadNivel4 entity = null;

		try {
			entity = variedadNivel4DAO.findById(variedadNivel4Id);
		} catch (Exception e) {
			log.error("get VariedadNivel4 failed", e);
			throw new ZMessManager().new FindingException("VariedadNivel4");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<VariedadNivel4> findPageVariedadNivel4(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<VariedadNivel4> entity = null;

		try {
			entity = variedadNivel4DAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("VariedadNivel4 Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberVariedadNivel4() throws Exception {
		Long entity = null;

		try {
			entity = variedadNivel4DAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("VariedadNivel4 Count");
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
	public List<VariedadNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<VariedadNivel4> list = new ArrayList<VariedadNivel4>();
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
			list = variedadNivel4DAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<VariedadNivel4DTO> getDataVariedadNivel4ByNivel4Id(Long nivel4Id) throws Exception {
		try {

			List<VariedadNivel4> variedadNivel4 = variedadNivel4DAO.findByCriteria("nivel4.nivel4Id= " + nivel4Id);
			variedadNivel4DAO.findAll();

			List<VariedadNivel4DTO> variedadNivel4DTO = new ArrayList<VariedadNivel4DTO>();

			for (VariedadNivel4 variedadNivel4Tmp : variedadNivel4) {
				VariedadNivel4DTO variedadNivel4DTO2 = new VariedadNivel4DTO();

				variedadNivel4DTO2.setVariedadNivel4Id(variedadNivel4Tmp.getVariedadNivel4Id());
				variedadNivel4DTO2.setPorcentajeArea(
						(variedadNivel4Tmp.getPorcentajeArea() != null) ? variedadNivel4Tmp.getPorcentajeArea() : null);
				variedadNivel4DTO2.setNivel4Id_Nivel4((variedadNivel4Tmp.getNivel4().getNivel4Id() != null)
						? variedadNivel4Tmp.getNivel4().getNivel4Id() : null);

				variedadNivel4DTO2.setVariedId_Variedad(
						(variedadNivel4Tmp.getVariedad() != null) ? variedadNivel4Tmp.getVariedad() : null);

				variedadNivel4DTO2.setNombreVariedad((variedadNivel4Tmp.getVariedad().getNombre() != null)
						? variedadNivel4Tmp.getVariedad().getNombre() : null);

				variedadNivel4DTO.add(variedadNivel4DTO2);
			}

			return variedadNivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

}

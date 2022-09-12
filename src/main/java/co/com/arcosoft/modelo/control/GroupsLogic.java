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

import co.com.arcosoft.dataaccess.dao.IGroupAuthoritiesDAO;
import co.com.arcosoft.dataaccess.dao.IGroupMembersDAO;
import co.com.arcosoft.dataaccess.dao.IGroupsDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.GroupAuthorities;
import co.com.arcosoft.modelo.GroupMembers;
import co.com.arcosoft.modelo.Groups;
import co.com.arcosoft.modelo.dto.GroupsDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("GroupsLogic")
public class GroupsLogic implements IGroupsLogic {
	private static final Logger log = LoggerFactory.getLogger(GroupsLogic.class);

	/**
	 * DAO injected by Spring that manages Groups entities
	 *
	 */
	@Autowired
	private IGroupsDAO groupsDAO;

	/**
	 * DAO injected by Spring that manages GroupAuthorities entities
	 *
	 */
	@Autowired
	private IGroupAuthoritiesDAO groupAuthoritiesDAO;

	/**
	 * DAO injected by Spring that manages GroupMembers entities
	 *
	 */
	@Autowired
	private IGroupMembersDAO groupMembersDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Groups> getGroups() throws Exception {
		log.debug("finding all Groups instances");

		List<Groups> list = new ArrayList<Groups>();

		try {
			list = groupsDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Groups failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Groups");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveGroups(Groups entity, GroupAuthorities entity2) throws Exception {
		log.debug("saving Groups instance");

		try {
			if (entity.getGroupName() == null) {
				throw new ZMessManager().new EmptyFieldException("groupName");
			}

			if ((entity.getGroupName() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getGroupName(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("groupName");
			}

			/*
			 * if (entity.getId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("id"); }
			 * 
			 * if (getGroups(entity.getId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			groupsDAO.save(entity);

			if (entity2 != null) {

				GroupAuthorities ga = new GroupAuthorities();
				ga.setGroups(entity);
				ga.setAuthority(entity2.getAuthority());
				groupAuthoritiesDAO.save(ga);

			}

			log.debug("save Groups successful");
		} catch (Exception e) {
			log.error("save Groups failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteGroups(Groups entity) throws Exception {
		log.debug("deleting Groups instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Groups");
		}

		if (entity.getId() == null) {
			throw new ZMessManager().new EmptyFieldException("id");
		}

		List<GroupAuthorities> groupAuthoritieses = null;
		List<GroupMembers> groupMemberses = null;

		try {
			groupAuthoritieses = groupAuthoritiesDAO.findByProperty("groups.id", entity.getId());

			if (Utilities.validationsList(groupAuthoritieses) == true) {
				throw new ZMessManager().new DeletingException("groupAuthoritieses");
			}

			groupMemberses = groupMembersDAO.findByProperty("groups.id", entity.getId());

			if (Utilities.validationsList(groupMemberses) == true) {
				throw new ZMessManager().new DeletingException("groupMemberses");
			}

			groupsDAO.delete(entity);

			log.debug("delete Groups successful");
		} catch (Exception e) {
			log.error("delete Groups failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateGroups(Groups entity, GroupAuthorities entity2) throws Exception {
		log.debug("updating Groups instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Groups");
			}

			if (entity.getGroupName() == null) {
				throw new ZMessManager().new EmptyFieldException("groupName");
			}

			if ((entity.getGroupName() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getGroupName(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("groupName");
			}

			if (entity.getId() == null) {
				throw new ZMessManager().new EmptyFieldException("id");
			}

			groupsDAO.update(entity);

			if (entity2 != null) {
				GroupAuthorities result = groupAuthoritiesDAO.findById(entity2.getId().longValue());
				if (result != null) {
					result.setGroups(entity);
					result.setAuthority(entity2.getAuthority().toString());
					groupAuthoritiesDAO.update(result);
				}
			}

			log.debug("update Groups successful");
		} catch (Exception e) {
			log.error("update Groups failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<GroupsDTO> getDataGroups() throws Exception {
		try {
			List<Groups> groups = groupsDAO.findAll();
			List<GroupsDTO> groupsDTO = new ArrayList<GroupsDTO>();

			List<GroupAuthorities> groupAuthorities = groupAuthoritiesDAO.findAll();

			for (Groups groupsTmp : groups) {

				for (GroupAuthorities groupAuthoritiesTmp : groupAuthorities) {

					GroupsDTO groupsDTO2 = new GroupsDTO();

					if (groupsTmp.getId().longValue() == groupAuthoritiesTmp.getGroups().getId()) {

						groupsDTO2.setId(groupsTmp.getId());
						groupsDTO2.setGroupName((groupsTmp.getGroupName() != null) ? groupsTmp.getGroupName() : null);
						groupsDTO2.setId_GroupsAutoridad(groupAuthoritiesTmp.getId());
						groupsDTO2.setNombreAutoridad(groupAuthoritiesTmp.getAuthority());
						groupsDTO.add(groupsDTO2);

					}

				}

			}

			return groupsDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Groups getGroups(Long id) throws Exception {
		log.debug("getting Groups instance");

		Groups entity = null;

		try {
			entity = groupsDAO.findById(id);
		} catch (Exception e) {
			log.error("get Groups failed", e);
			throw new ZMessManager().new FindingException("Groups");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Groups> findPageGroups(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Groups> entity = null;

		try {
			entity = groupsDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Groups Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberGroups() throws Exception {
		Long entity = null;

		try {
			entity = groupsDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Groups Count");
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
	public List<Groups> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Groups> list = new ArrayList<Groups>();
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
			list = groupsDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}

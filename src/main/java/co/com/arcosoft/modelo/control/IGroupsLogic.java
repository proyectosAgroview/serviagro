package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.GroupAuthorities;
import co.com.arcosoft.modelo.Groups;
import co.com.arcosoft.modelo.dto.GroupsDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IGroupsLogic {
	public List<Groups> getGroups() throws Exception;

	/**
	 * Save an new Groups entity
	 */
	public void saveGroups(Groups entity, GroupAuthorities entity2) throws Exception;

	/**
	 * Delete an existing Groups entity
	 *
	 */
	public void deleteGroups(Groups entity) throws Exception;

	/**
	 * Update an existing Groups entity
	 *
	 */
	public void updateGroups(Groups entity, GroupAuthorities entity2) throws Exception;

	/**
	 * Load an existing Groups entity
	 *
	 */
	public Groups getGroups(Long id) throws Exception;

	public List<Groups> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Groups> findPageGroups(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGroups() throws Exception;

	public List<GroupsDTO> getDataGroups() throws Exception;
}

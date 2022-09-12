package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.GroupAuthorities;
import co.com.arcosoft.modelo.dto.GroupAuthoritiesDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IGroupAuthoritiesLogic {
	public List<GroupAuthorities> getGroupAuthorities() throws Exception;

	/**
	 * Save an new GroupAuthorities entity
	 */
	public void saveGroupAuthorities(GroupAuthorities entity) throws Exception;

	/**
	 * Delete an existing GroupAuthorities entity
	 *
	 */
	public void deleteGroupAuthorities(GroupAuthorities entity) throws Exception;

	/**
	 * Update an existing GroupAuthorities entity
	 *
	 */
	public void updateGroupAuthorities(GroupAuthorities entity) throws Exception;

	/**
	 * Load an existing GroupAuthorities entity
	 *
	 */
	public GroupAuthorities getGroupAuthorities(Long id) throws Exception;

	public List<GroupAuthorities> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<GroupAuthorities> findPageGroupAuthorities(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberGroupAuthorities() throws Exception;

	public List<GroupAuthoritiesDTO> getDataGroupAuthorities() throws Exception;
}

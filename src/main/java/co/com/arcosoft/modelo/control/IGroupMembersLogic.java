package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.GroupMembers;
import co.com.arcosoft.modelo.dto.GroupMembersDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IGroupMembersLogic {
	public List<GroupMembers> getGroupMembers() throws Exception;

	/**
	 * Save an new GroupMembers entity
	 */
	public void saveGroupMembers(GroupMembers entity) throws Exception;

	/**
	 * Delete an existing GroupMembers entity
	 *
	 */
	public void deleteGroupMembers(GroupMembers entity) throws Exception;

	/**
	 * Update an existing GroupMembers entity
	 *
	 */
	public void updateGroupMembers(GroupMembers entity) throws Exception;

	/**
	 * Load an existing GroupMembers entity
	 *
	 */
	public GroupMembers getGroupMembers(Long id) throws Exception;

	public List<GroupMembers> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<GroupMembers> findPageGroupMembers(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberGroupMembers() throws Exception;

	public List<GroupMembersDTO> getDataGroupMembers() throws Exception;
}

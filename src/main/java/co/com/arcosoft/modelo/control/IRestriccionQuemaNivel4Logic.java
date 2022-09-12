package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.RestriccionQuemaNivel4;
import co.com.arcosoft.modelo.RestriccionQuemaNivel4Id;
import co.com.arcosoft.modelo.dto.RestriccionQuemaNivel4DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IRestriccionQuemaNivel4Logic {
	public List<RestriccionQuemaNivel4> getRestriccionQuemaNivel4() throws Exception;

	/**
	 * Save an new RestriccionQuemaNivel4 entity
	 */
	public void saveRestriccionQuemaNivel4(RestriccionQuemaNivel4 entity) throws Exception;

	/**
	 * Delete an existing RestriccionQuemaNivel4 entity
	 *
	 */
	public void deleteRestriccionQuemaNivel4(RestriccionQuemaNivel4 entity) throws Exception;

	/**
	 * Update an existing RestriccionQuemaNivel4 entity
	 *
	 */
	public void updateRestriccionQuemaNivel4(RestriccionQuemaNivel4 entity) throws Exception;

	/**
	 * Load an existing RestriccionQuemaNivel4 entity
	 *
	 */
	public RestriccionQuemaNivel4 getRestriccionQuemaNivel4(RestriccionQuemaNivel4Id id) throws Exception;

	public List<RestriccionQuemaNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RestriccionQuemaNivel4> findPageRestriccionQuemaNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberRestriccionQuemaNivel4() throws Exception;

	public List<RestriccionQuemaNivel4DTO> getDataRestriccionQuemaNivel4() throws Exception;
}

package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DistSiembra;
import co.com.arcosoft.modelo.dto.DistSiembraDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDistSiembraLogic {
	public List<DistSiembra> getDistSiembra() throws Exception;

	/**
	 * Save an new DistSiembra entity
	 */
	public void saveDistSiembra(DistSiembra entity) throws Exception;

	/**
	 * Delete an existing DistSiembra entity
	 *
	 */
	public void deleteDistSiembra(DistSiembra entity) throws Exception;

	/**
	 * Update an existing DistSiembra entity
	 *
	 */
	public void updateDistSiembra(DistSiembra entity) throws Exception;

	/**
	 * Load an existing DistSiembra entity
	 *
	 */
	public DistSiembra getDistSiembra(Long distSiembraId) throws Exception;

	public List<DistSiembra> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DistSiembra> findPageDistSiembra(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDistSiembra() throws Exception;

	public List<DistSiembraDTO> getDataDistSiembra() throws Exception;
}

package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.dto.CentCostDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICentCostLogic {
	public List<CentCost> getCentCost() throws Exception;

	/**
	 * Save an new CentCost entity
	 */
	public void saveCentCost(CentCost entity) throws Exception;

	/**
	 * Delete an existing CentCost entity
	 *
	 */
	public void deleteCentCost(CentCost entity) throws Exception;

	/**
	 * Update an existing CentCost entity
	 *
	 */
	public void updateCentCost(CentCost entity) throws Exception;

	/**
	 * Load an existing CentCost entity
	 *
	 */
	public CentCost getCentCost(Long centCostId) throws Exception;

	public List<CentCost> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<CentCost> findPageCentCost(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCentCost() throws Exception;

	public List<CentCostDTO> getDataCentCost() throws Exception;
}
